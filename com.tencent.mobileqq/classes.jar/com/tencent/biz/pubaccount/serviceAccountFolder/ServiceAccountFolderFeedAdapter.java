package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ServiceAccountFolderFeedAdapter
  extends BaseAdapter
  implements View.OnClickListener, DecodeTaskCompletionListener
{
  private final String a = "ServiceAccountFolderFeedAdapter";
  private QQAppInterface b;
  private ServiceAccountFolderActivity c;
  private SwipListView d;
  private DragFrameLayout e;
  private RecentFaceDecoder f;
  private final Object g = new Object();
  private List<ServiceAccountFolderFeed> h;
  private HashMap<String, Bitmap> i = new HashMap();
  private float j = 0.0F;
  private float k = 0.0F;
  private float l = 0.0F;
  private Set<Integer> m = new HashSet();
  
  public ServiceAccountFolderFeedAdapter(QQAppInterface paramQQAppInterface, ServiceAccountFolderActivity paramServiceAccountFolderActivity, SwipListView paramSwipListView)
  {
    this.b = paramQQAppInterface;
    this.c = paramServiceAccountFolderActivity;
    this.d = paramSwipListView;
    this.h = new ArrayList();
    this.f = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.j = paramServiceAccountFolderActivity.getResources().getDimension(2131298741);
    this.k = paramServiceAccountFolderActivity.getResources().getDimension(2131298739);
    this.l = (this.j + this.k);
  }
  
  private void a(ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unfollow->uin:");
      ((StringBuilder)localObject1).append(paramServiceAccountFolderFeed.b);
      QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    this.c.b(true);
    Object localObject1 = null;
    Object localObject2 = (IPublicAccountDataManager)this.b.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject2 != null) {
      localObject1 = ((IPublicAccountDataManager)localObject2).findAccountDetailInfo(paramServiceAccountFolderFeed.b);
    }
    if ((localObject1 != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((IPublicAccountDetail)localObject1).getAccountFlag()) == -4))
    {
      localObject1 = new NewIntent(this.c, ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
      ((NewIntent)localObject1).putExtra("cmd", "unfollow");
      localObject2 = new mobileqq_mp.UnFollowRequest();
      ((mobileqq_mp.UnFollowRequest)localObject2).uin.set((int)Long.parseLong(paramServiceAccountFolderFeed.b));
      ((NewIntent)localObject1).putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject2).toByteArray());
      ((NewIntent)localObject1).putExtra("source", 25);
      ((NewIntent)localObject1).setObserver(new ServiceAccountFolderFeedAdapter.5(this, paramServiceAccountFolderFeed));
      this.b.startServlet((NewIntent)localObject1);
    }
    else
    {
      localObject1 = new NewPublicAccountObserver(new ServiceAccountFolderFeedAdapter.6(this, paramServiceAccountFolderFeed), this.b);
      this.b.removeObserver((BusinessObserver)localObject1);
      this.b.addObserver((BusinessObserver)localObject1);
      PublicAccountStateReporter.a(this.b, false, paramServiceAccountFolderFeed.b, 0);
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).removeLbsUin(this.b, paramServiceAccountFolderFeed.b);
  }
  
  private void a(ServiceAccountFolderFeed paramServiceAccountFolderFeed, int paramInt)
  {
    Object localObject = (ActionSheet)ActionSheetHelper.b(this.c, null);
    ((ActionSheet)localObject).setMainTitle(String.format(this.c.getResources().getString(2131894284), new Object[] { paramServiceAccountFolderFeed.h }));
    ((ActionSheet)localObject).addButton(2131894218, 3);
    ((ActionSheet)localObject).addCancelButton(2131887648);
    ((ActionSheet)localObject).setOnButtonClickListener(new ServiceAccountFolderFeedAdapter.4(this, paramServiceAccountFolderFeed, paramInt, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showActionSheet->uin:");
      ((StringBuilder)localObject).append(paramServiceAccountFolderFeed.b);
      ((StringBuilder)localObject).append(", name:");
      ((StringBuilder)localObject).append(paramServiceAccountFolderFeed.h);
      QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder paramServiceAccountFolderFeedHolder, int paramInt, View paramView)
  {
    ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)getItem(paramInt);
    if (localServiceAccountFolderFeed == null) {
      return;
    }
    boolean bool = a(localServiceAccountFolderFeed.b);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateItemContent->uin:");
      ((StringBuilder)localObject1).append(localServiceAccountFolderFeed.b);
      ((StringBuilder)localObject1).append(", isFollow:");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool)
    {
      paramServiceAccountFolderFeedHolder.g.setVisibility(0);
      paramView.setTag(-3, Integer.valueOf((int)this.l));
    }
    else
    {
      paramServiceAccountFolderFeedHolder.g.setVisibility(8);
      paramView.setTag(-3, Integer.valueOf((int)this.k));
    }
    paramServiceAccountFolderFeedHolder.a = localServiceAccountFolderFeed.b;
    if (this.f != null) {
      a(paramServiceAccountFolderFeedHolder, localServiceAccountFolderFeed.b);
    }
    paramServiceAccountFolderFeedHolder.d.setCompoundDrawablesWithIntrinsicBounds(0, localServiceAccountFolderFeed.e);
    paramServiceAccountFolderFeedHolder.d.setText(localServiceAccountFolderFeed.h);
    paramServiceAccountFolderFeedHolder.d.setExtendText(localServiceAccountFolderFeed.g, 0);
    if (localServiceAccountFolderFeed.p == 4) {
      n = 2130839732;
    } else {
      n = 0;
    }
    paramServiceAccountFolderFeedHolder.e.setCompoundDrawablesWithIntrinsicBounds(n, 0);
    int n = localServiceAccountFolderFeed.k;
    Object localObject2 = localServiceAccountFolderFeed.l;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = localObject1;
    if (((String)localObject1).length() > 0)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith(" "))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (n != 0)) {
      paramServiceAccountFolderFeedHolder.e.setExtendTextColor(ColorStateList.valueOf(n), 1);
    }
    paramServiceAccountFolderFeedHolder.e.setExtendText((String)localObject2, 1);
    try
    {
      paramServiceAccountFolderFeedHolder.e.setText(new QQText(localServiceAccountFolderFeed.i, 3, 16));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      SingleLineTextView localSingleLineTextView = paramServiceAccountFolderFeedHolder.e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localServiceAccountFolderFeed.i);
      ((StringBuilder)localObject2).append(" ");
      localSingleLineTextView.setText(((StringBuilder)localObject2).toString());
    }
    n = localServiceAccountFolderFeed.d;
    int i1 = localServiceAccountFolderFeed.c;
    if (n > 0) {
      if (i1 == 0)
      {
        paramServiceAccountFolderFeedHolder.f.setDragViewType(-1, paramView);
        paramServiceAccountFolderFeedHolder.f.setOnModeChangeListener(null);
      }
      else
      {
        if (i1 == 2)
        {
          paramServiceAccountFolderFeedHolder.f.setDragViewType(-1, paramView);
          paramServiceAccountFolderFeedHolder.f.setOnModeChangeListener(null);
          n = 1;
          break label577;
        }
        paramServiceAccountFolderFeedHolder.f.setDragViewType(0, paramView);
        paramServiceAccountFolderFeedHolder.f.setOnModeChangeListener(this.e);
        if (b(localServiceAccountFolderFeed.b)) {
          VSReporter.a(localServiceAccountFolderFeed.b, "auth_page", "new_exp", 0, 0, new String[0]);
        }
        i1 = 3;
        i2 = 2130852592;
        break label591;
      }
    }
    n = 0;
    label577:
    int i3 = 0;
    int i2 = 0;
    i1 = n;
    n = i3;
    label591:
    if (b(localServiceAccountFolderFeed.b))
    {
      paramView = this.m;
      if ((paramView != null) && (!paramView.contains(Integer.valueOf(paramInt))))
      {
        this.m.add(Integer.valueOf(paramInt));
        VSReporter.b(localServiceAccountFolderFeed.b, "auth_page", "new_msg_exp", 0, 0, new String[0]);
      }
    }
    CustomWidgetUtil.a(paramServiceAccountFolderFeedHolder.f, i1, n, i2, 99, null);
    if (AppSetting.e)
    {
      paramView = new StringBuilder();
      paramView.append(paramServiceAccountFolderFeedHolder.d.getText());
      paramView.append(",");
      if (n != 0) {
        if (n == 1)
        {
          paramView.append("有一条未读,");
        }
        else if (n == 2)
        {
          paramView.append("有两条未读,");
        }
        else if (n > 0)
        {
          paramView.append("有");
          paramView.append(n);
          paramView.append("条未读,");
        }
      }
      paramView.append(paramServiceAccountFolderFeedHolder.e.getText());
      paramView.append(",");
      paramView.append(localServiceAccountFolderFeed.g);
      paramServiceAccountFolderFeedHolder.b.setContentDescription(paramView);
    }
  }
  
  private void a(ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder paramServiceAccountFolderFeedHolder, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setHolderIcon->uin:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (Bitmap)this.i.get(paramString);
    if (localObject == null)
    {
      paramServiceAccountFolderFeedHolder.c.setImageDrawable(this.f.a(1008, paramString));
      return;
    }
    paramServiceAccountFolderFeedHolder.c.setImageBitmap((Bitmap)localObject);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.b.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localIPublicAccountDataManager != null)
    {
      IPublicAccountDetail localIPublicAccountDetail = localIPublicAccountDataManager.findAccountDetailInfoCache(paramString);
      if ((localIPublicAccountDetail != null) && (!localIPublicAccountDetail.isShowFollowButton())) {
        return false;
      }
      if ((localIPublicAccountDetail == null) && ("1770946116".equals(paramString))) {
        return false;
      }
      if ((PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfoCache(paramString) != null) {
        return true;
      }
      if (localIPublicAccountDetail != null) {
        return localIPublicAccountDetail.getFollowType() == 1;
      }
    }
    return false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showNetworkErrorToast");
    }
    Toast.makeText(this.b.getApplication(), 2131892951, 0).show();
  }
  
  private void b(ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    String str = paramServiceAccountFolderFeed.b;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("updateUnfollowInfo->uin:");
      ((StringBuilder)???).append(str);
      QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.g)
    {
      this.h.remove(paramServiceAccountFolderFeed);
      notifyDataSetChanged();
      ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.7(this, paramServiceAccountFolderFeed));
      if (getCount() == 0)
      {
        ??? = this.c;
        if ((??? != null) && (((ServiceAccountFolderActivity)???).isResume())) {
          this.c.a(true);
        }
      }
      ThreadManager.getSubThreadHandler().postDelayed(new ServiceAccountFolderFeedAdapter.8(this, str, paramServiceAccountFolderFeed), 10L);
      return;
    }
  }
  
  private boolean b(String paramString)
  {
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.b.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localIPublicAccountDataManager != null)
    {
      paramString = (PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfo(paramString);
      if ((paramString != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    this.f.b();
    this.i.clear();
    this.m.clear();
    synchronized (this.g)
    {
      this.h.clear();
      return;
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.e = paramDragFrameLayout;
  }
  
  public void a(List<ServiceAccountFolderFeed> paramList)
  {
    if (paramList != null) {
      synchronized (this.g)
      {
        this.h.clear();
        this.h.addAll(paramList);
        notifyDataSetChanged();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("setDataList->DataSetChanged size:");
          ((StringBuilder)???).append(paramList.size());
          QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)???).toString());
          return;
        }
      }
    }
  }
  
  public int getCount()
  {
    synchronized (this.g)
    {
      int n = this.h.size();
      return n;
    }
  }
  
  public Object getItem(int paramInt)
  {
    synchronized (this.g)
    {
      if (paramInt >= getCount()) {
        return null;
      }
      Object localObject2 = this.h.get(paramInt);
      return localObject2;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramView != null) && ((paramView.getTag() instanceof ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder))) {
      localObject1 = (ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)paramView.getTag();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder(this);
      paramView = LayoutInflater.from(this.c).inflate(2131625659, null);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).b = ((RelativeLayout)paramView.findViewById(2131432850));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).c = ((ImageView)paramView.findViewById(2131435219));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).d = ((SingleLineTextView)paramView.findViewById(2131447463));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).e = ((SingleLineTextView)paramView.findViewById(2131431757));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).f = ((DragTextView)paramView.findViewById(2131449128));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).g = ((Button)paramView.findViewById(2131438143));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).h = ((Button)paramView.findViewById(2131438112));
      Object localObject3 = this.c.getResources();
      float f1 = DeviceInfoUtil.A();
      localObject1 = ((Resources)localObject3).getColorStateList(2131168122);
      localObject3 = ((Resources)localObject3).getColorStateList(2131168001);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).d.setTextColor((ColorStateList)localObject3);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).d.setTextSize(17.0F);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).d.setExtendTextColor((ColorStateList)localObject1, 0);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).d.setExtendTextSize(12.0F, 0);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).d.setCompoundDrawablePadding((int)(3.0F * f1));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).d.setExtendTextPadding((int)(5.0F * f1), 2);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).d.setExtendTextColor((ColorStateList)localObject1, 2);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).d.setExtendTextSize(17.0F, 2);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).e.setTextSize(14.0F);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).e.setExtendTextPadding((int)(f1 * 2.0F), 1);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).e.setExtendTextSize(14.0F, 1);
      ((ThemeImageView)((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).c).setSupportMaskView(true);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).b.setOnClickListener(this);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).g.setOnClickListener(this);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).h.setOnClickListener(this);
      paramView.setTag(localObject2);
    }
    ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).b.setTag(Integer.valueOf(paramInt));
    ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).g.setTag(Integer.valueOf(paramInt));
    ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).h.setTag(Integer.valueOf(paramInt));
    ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).f.setTag(Integer.valueOf(paramInt));
    a((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2, paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    int i2 = ((Integer)paramView.getTag()).intValue();
    ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)getItem(i2);
    if (localServiceAccountFolderFeed != null)
    {
      int n = localServiceAccountFolderFeed.d;
      int i3 = localServiceAccountFolderFeed.c;
      int i1 = 0;
      if (i3 != 1) {
        n = 0;
      }
      long l1 = ServiceAccountFolderManager.a().a(localServiceAccountFolderFeed);
      Object localObject4 = localServiceAccountFolderFeed.j;
      Object localObject2;
      Object localObject3;
      if (localObject4 != null)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append(localServiceAccountFolderFeed.d);
        ((StringBuilder)???).append("");
        ??? = ((StringBuilder)???).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((MessageRecord)localObject4).msgseq);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((MessageRecord)localObject4).msgBackupMsgRandom);
        ((StringBuilder)localObject3).append("");
        localObject2 = PublicAccountEventReport.a((String)???, (String)localObject2, ((StringBuilder)localObject3).toString());
      }
      else
      {
        localObject2 = "";
      }
      if ((localServiceAccountFolderFeed.j != null) && (localServiceAccountFolderFeed.j.mExJsonObject != null)) {
        localObject3 = localServiceAccountFolderFeed.j.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
      } else {
        localObject3 = "";
      }
      int i4 = paramView.getId();
      Object localObject5;
      Object localObject6;
      if (i4 != 2131432850)
      {
        if (i4 != 2131438112)
        {
          if (i4 == 2131438143)
          {
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("onClickMenuUnfollow->uin:");
              ((StringBuilder)???).append(localServiceAccountFolderFeed.b);
              ((StringBuilder)???).append(", name:");
              ((StringBuilder)???).append(localServiceAccountFolderFeed.h);
              QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)???).toString());
            }
            a(localServiceAccountFolderFeed, i2);
            ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.1(this, localServiceAccountFolderFeed));
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("onClickMenuDelete->uin:");
            ((StringBuilder)???).append(localServiceAccountFolderFeed.b);
            ((StringBuilder)???).append(", name:");
            ((StringBuilder)???).append(localServiceAccountFolderFeed.h);
            QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)???).toString());
          }
          synchronized (this.g)
          {
            this.h.remove(localServiceAccountFolderFeed);
            notifyDataSetChanged();
            ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.2(this, localServiceAccountFolderFeed));
            if (getCount() == 0)
            {
              ??? = this.c;
              if ((??? != null) && (((ServiceAccountFolderActivity)???).isResume())) {
                this.c.a(true);
              }
            }
            if (i3 == 2) {
              i1 = 1;
            }
            ??? = this.b;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(localServiceAccountFolderFeed.b);
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(i1);
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(n);
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append(i2 + 1);
            localObject5 = ((StringBuilder)localObject5).toString();
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("");
            ((StringBuilder)localObject6).append(l1);
            ReportController.b((AppRuntime)???, "dc01160", "Pb_account_lifeservice", (String)localObject2, "0X80067F3", "0X80067F3", 0, 0, (String)localObject3, (String)localObject4, (String)localObject5, ((StringBuilder)localObject6).toString());
            RecentPubAccHelper.a(this.b, localServiceAccountFolderFeed.b, localServiceAccountFolderFeed.c, localServiceAccountFolderFeed.d, 2, localServiceAccountFolderFeed.h, false);
            ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.3(this, localServiceAccountFolderFeed));
          }
        }
      }
      else
      {
        ??? = new Intent(this.c, ChatActivity.class);
        ((Intent)???).putExtra("uintype", 1008);
        ((Intent)???).putExtra("uin", localServiceAccountFolderFeed.b);
        ((Intent)???).putExtra("uinname", localServiceAccountFolderFeed.h);
        ((Intent)???).putExtra("start_time", System.currentTimeMillis());
        ((Intent)???).putExtra("red_hot_count", localServiceAccountFolderFeed.d);
        ((Intent)???).putExtra("INTENT_KEY_FROM", 2);
        this.c.startActivity((Intent)???);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onClickFeedItem->uin:");
          ((StringBuilder)???).append(localServiceAccountFolderFeed.b);
          ((StringBuilder)???).append(", name:");
          ((StringBuilder)???).append(localServiceAccountFolderFeed.h);
          QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)???).toString());
        }
        if (i3 == 1) {
          ??? = "0X80067EF";
        } else if (i3 == 2) {
          ??? = "0X80067F0";
        } else {
          ??? = "0X80067F1";
        }
        localObject5 = this.b;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("");
        ((StringBuilder)localObject6).append(localServiceAccountFolderFeed.b);
        localObject6 = ((StringBuilder)localObject6).toString();
        Object localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append("");
        ((StringBuilder)localObject7).append(i3);
        localObject7 = ((StringBuilder)localObject7).toString();
        Object localObject8 = new StringBuilder();
        ((StringBuilder)localObject8).append("");
        ((StringBuilder)localObject8).append(l1);
        localObject8 = ((StringBuilder)localObject8).toString();
        Object localObject9 = new StringBuilder();
        ((StringBuilder)localObject9).append("");
        ((StringBuilder)localObject9).append(i2 + 1);
        localObject9 = ((StringBuilder)localObject9).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(n);
        ReportController.b((AppRuntime)localObject5, "dc01160", "Pb_account_lifeservice", (String)localObject6, (String)???, (String)???, 0, 0, (String)localObject7, (String)localObject8, (String)localObject9, localStringBuilder.toString());
        RecentPubAccHelper.a(this.b, localServiceAccountFolderFeed.b, localServiceAccountFolderFeed.c, localServiceAccountFolderFeed.d, 2, localServiceAccountFolderFeed.h);
        localObject5 = this.b;
        localObject6 = localServiceAccountFolderFeed.b;
        n = localServiceAccountFolderFeed.c;
        i1 = localServiceAccountFolderFeed.d;
        if (localServiceAccountFolderFeed.j == null) {
          ??? = "";
        } else {
          ??? = localServiceAccountFolderFeed.j.msg;
        }
        localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append(i2);
        ((StringBuilder)localObject7).append("");
        PublicAccountEventReport.b((QQAppInterface)localObject5, (MessageRecord)localObject4, (String)localObject6, n, i1, (String)???, (String)localObject3, (String)localObject2, ((StringBuilder)localObject7).toString());
        if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(localServiceAccountFolderFeed.b)) {
          ReportController.b(this.b, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.8.17", "");
        }
        if (b(localServiceAccountFolderFeed.b))
        {
          VSReporter.a(localServiceAccountFolderFeed.b, "auth_page", "clk_content", 0, 0, new String[] { "", "1", localServiceAccountFolderFeed.h, localServiceAccountFolderFeed.l });
          VSReporter.b(localServiceAccountFolderFeed.b, "auth_page", "new_msg_clk", 0, 0, new String[0]);
        }
        PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramString != null))
    {
      if (paramString.length() == 0) {
        return;
      }
      this.i.put(paramString, paramBitmap);
      paramInt2 = this.d.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.d.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)))
        {
          paramBitmap = (ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)paramBitmap;
          if (paramString.equals(paramBitmap.a)) {
            a(paramBitmap, paramString);
          }
        }
        paramInt1 += 1;
      }
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("onDecodeTaskCompleted->uin:");
        paramBitmap.append(paramString);
        QLog.d("ServiceAccountFolderFeedAdapter", 2, paramBitmap.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter
 * JD-Core Version:    0.7.0.1
 */