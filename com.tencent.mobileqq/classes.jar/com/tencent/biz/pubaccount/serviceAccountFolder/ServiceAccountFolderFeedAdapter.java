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
  private float jdField_a_of_type_Float = 0.0F;
  private ServiceAccountFolderActivity jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = "ServiceAccountFolderFeedAdapter";
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<ServiceAccountFolderFeed> jdField_a_of_type_JavaUtilList;
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private float b = 0.0F;
  private float c = 0.0F;
  
  public ServiceAccountFolderFeedAdapter(QQAppInterface paramQQAppInterface, ServiceAccountFolderActivity paramServiceAccountFolderActivity, SwipListView paramSwipListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity = paramServiceAccountFolderActivity;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Float = paramServiceAccountFolderActivity.getResources().getDimension(2131298065);
    this.b = paramServiceAccountFolderActivity.getResources().getDimension(2131298063);
    this.c = (this.jdField_a_of_type_Float + this.b);
  }
  
  private void a(ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unfollow->uin:");
      ((StringBuilder)localObject1).append(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
      QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.b(true);
    Object localObject1 = null;
    Object localObject2 = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject2 != null) {
      localObject1 = ((IPublicAccountDataManager)localObject2).findAccountDetailInfo(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
    }
    if ((localObject1 != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((IPublicAccountDetail)localObject1).getAccountFlag()) == -4))
    {
      localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
      ((NewIntent)localObject1).putExtra("cmd", "unfollow");
      localObject2 = new mobileqq_mp.UnFollowRequest();
      ((mobileqq_mp.UnFollowRequest)localObject2).uin.set((int)Long.parseLong(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString));
      ((NewIntent)localObject1).putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject2).toByteArray());
      ((NewIntent)localObject1).putExtra("source", 25);
      ((NewIntent)localObject1).setObserver(new ServiceAccountFolderFeedAdapter.5(this, paramServiceAccountFolderFeed));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
    }
    else
    {
      localObject1 = new NewPublicAccountObserver(new ServiceAccountFolderFeedAdapter.6(this, paramServiceAccountFolderFeed), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)localObject1);
      PublicAccountStateReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 0);
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).removeLbsUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
  }
  
  private void a(ServiceAccountFolderFeed paramServiceAccountFolderFeed, int paramInt)
  {
    Object localObject = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, null);
    ((ActionSheet)localObject).setMainTitle(String.format(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources().getString(2131696510), new Object[] { paramServiceAccountFolderFeed.jdField_c_of_type_JavaLangString }));
    ((ActionSheet)localObject).addButton(2131696446, 3);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    ((ActionSheet)localObject).setOnButtonClickListener(new ServiceAccountFolderFeedAdapter.4(this, paramServiceAccountFolderFeed, paramInt, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showActionSheet->uin:");
      ((StringBuilder)localObject).append(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", name:");
      ((StringBuilder)localObject).append(paramServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
      QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder paramServiceAccountFolderFeedHolder, int paramInt, View paramView)
  {
    ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)getItem(paramInt);
    if (localServiceAccountFolderFeed == null) {
      return;
    }
    boolean bool = a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateItemContent->uin:");
      ((StringBuilder)localObject1).append(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(", isFollow:");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    if (bool)
    {
      paramServiceAccountFolderFeedHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramView.setTag(-3, Integer.valueOf((int)this.c));
    }
    else
    {
      paramServiceAccountFolderFeedHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramView.setTag(-3, Integer.valueOf((int)this.b));
    }
    paramServiceAccountFolderFeedHolder.jdField_a_of_type_JavaLangString = localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder != null) {
      a(paramServiceAccountFolderFeedHolder, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
    }
    paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, localServiceAccountFolderFeed.jdField_c_of_type_Int);
    paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
    paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString, 0);
    if (localServiceAccountFolderFeed.e == 4) {
      i = 2130839534;
    } else {
      i = 0;
    }
    paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
    int i = localServiceAccountFolderFeed.jdField_d_of_type_Int;
    Object localObject2 = localServiceAccountFolderFeed.jdField_d_of_type_JavaLangString;
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
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (i != 0)) {
      paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
    }
    paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject2, 1);
    try
    {
      paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(new QQText(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence, 3, 16));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      SingleLineTextView localSingleLineTextView = paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence);
      ((StringBuilder)localObject2).append(" ");
      localSingleLineTextView.setText(((StringBuilder)localObject2).toString());
    }
    i = localServiceAccountFolderFeed.jdField_b_of_type_Int;
    int j = localServiceAccountFolderFeed.jdField_a_of_type_Int;
    if (i > 0) {
      if (j == 0)
      {
        paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
        paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
      }
      else
      {
        if (j == 2)
        {
          paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
          paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
          i = 1;
          break label577;
        }
        paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
        paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        if (b(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString)) {
          VSReporter.a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_page", "new_exp", 0, 0, new String[0]);
        }
        j = 3;
        k = 2130850770;
        break label591;
      }
    }
    i = 0;
    label577:
    int m = 0;
    int k = 0;
    j = i;
    i = m;
    label591:
    if (b(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString))
    {
      paramView = this.jdField_a_of_type_JavaUtilSet;
      if ((paramView != null) && (!paramView.contains(Integer.valueOf(paramInt))))
      {
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
        VSReporter.b(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_exp", 0, 0, new String[0]);
      }
    }
    CustomWidgetUtil.a(paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, j, i, k, 99, null);
    if (AppSetting.d)
    {
      paramView = new StringBuilder();
      paramView.append(paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText());
      paramView.append(",");
      if (i != 0) {
        if (i == 1)
        {
          paramView.append("有一条未读,");
        }
        else if (i == 2)
        {
          paramView.append("有两条未读,");
        }
        else if (i > 0)
        {
          paramView.append("有");
          paramView.append(i);
          paramView.append("条未读,");
        }
      }
      paramView.append(paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.getText());
      paramView.append(",");
      paramView.append(localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString);
      paramServiceAccountFolderFeedHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramView);
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
    Object localObject = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject == null)
    {
      paramServiceAccountFolderFeedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, paramString));
      return;
    }
    paramServiceAccountFolderFeedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
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
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131695217, 0).show();
  }
  
  private void b(ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    String str = paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("updateUnfollowInfo->uin:");
      ((StringBuilder)???).append(str);
      QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramServiceAccountFolderFeed);
      notifyDataSetChanged();
      ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.7(this, paramServiceAccountFolderFeed));
      if (getCount() == 0)
      {
        ??? = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity;
        if ((??? != null) && (((ServiceAccountFolderActivity)???).isResume())) {
          this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
        }
      }
      ThreadManager.getSubThreadHandler().postDelayed(new ServiceAccountFolderFeedAdapter.8(this, str, paramServiceAccountFolderFeed), 10L);
      return;
    }
  }
  
  private boolean b(String paramString)
  {
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
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
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(List<ServiceAccountFolderFeed> paramList)
  {
    if (paramList != null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
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
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
  }
  
  public Object getItem(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramInt >= getCount()) {
        return null;
      }
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity).inflate(2131559630, null);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366531));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378784));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131365536));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380210));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370820));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370802));
      Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources();
      float f = DeviceInfoUtil.a();
      localObject1 = ((Resources)localObject3).getColorStateList(2131167142);
      localObject3 = ((Resources)localObject3).getColorStateList(2131167063);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject3);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 0);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject1, 2);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
      ((ThemeImageView)((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.setTag(localObject2);
    }
    ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
    ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
    ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_b_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
    ((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    a((ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)localObject2, paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    int k = ((Integer)paramView.getTag()).intValue();
    ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)getItem(k);
    if (localServiceAccountFolderFeed != null)
    {
      int i = localServiceAccountFolderFeed.jdField_b_of_type_Int;
      int m = localServiceAccountFolderFeed.jdField_a_of_type_Int;
      int j = 0;
      if (m != 1) {
        i = 0;
      }
      long l = ServiceAccountFolderManager.a().a(localServiceAccountFolderFeed);
      ??? = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (??? != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localServiceAccountFolderFeed.jdField_b_of_type_Int);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((MessageRecord)???).msgseq);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((MessageRecord)???).msgBackupMsgRandom);
        ((StringBuilder)localObject4).append("");
        localObject2 = PublicAccountEventReport.a((String)localObject2, (String)localObject3, ((StringBuilder)localObject4).toString());
      }
      else
      {
        localObject2 = "";
      }
      if ((localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null)) {
        localObject3 = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
      } else {
        localObject3 = "";
      }
      int n = paramView.getId();
      Object localObject5;
      Object localObject6;
      if (n != 2131366531)
      {
        if (n != 2131370802)
        {
          if (n == 2131370820)
          {
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("onClickMenuUnfollow->uin:");
              ((StringBuilder)???).append(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
              ((StringBuilder)???).append(", name:");
              ((StringBuilder)???).append(localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
              QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)???).toString());
            }
            a(localServiceAccountFolderFeed, k);
            ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.1(this, localServiceAccountFolderFeed));
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("onClickMenuDelete->uin:");
            ((StringBuilder)???).append(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
            ((StringBuilder)???).append(", name:");
            ((StringBuilder)???).append(localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
            QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)???).toString());
          }
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_JavaUtilList.remove(localServiceAccountFolderFeed);
            notifyDataSetChanged();
            ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.2(this, localServiceAccountFolderFeed));
            if (getCount() == 0)
            {
              ??? = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity;
              if ((??? != null) && (((ServiceAccountFolderActivity)???).isResume())) {
                this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
              }
            }
            if (m == 2) {
              j = 1;
            }
            ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(j);
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(i);
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append(k + 1);
            localObject5 = ((StringBuilder)localObject5).toString();
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("");
            ((StringBuilder)localObject6).append(l);
            ReportController.b((AppRuntime)???, "dc01160", "Pb_account_lifeservice", (String)localObject2, "0X80067F3", "0X80067F3", 0, 0, (String)localObject3, (String)localObject4, (String)localObject5, ((StringBuilder)localObject6).toString());
            RecentPubAccHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, localServiceAccountFolderFeed.jdField_a_of_type_Int, localServiceAccountFolderFeed.jdField_b_of_type_Int, 2, localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
            ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.3(this, localServiceAccountFolderFeed));
          }
        }
      }
      else
      {
        ??? = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, ChatActivity.class);
        ((Intent)???).putExtra("uintype", 1008);
        ((Intent)???).putExtra("uin", localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
        ((Intent)???).putExtra("uinname", localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
        ((Intent)???).putExtra("start_time", System.currentTimeMillis());
        ((Intent)???).putExtra("red_hot_count", localServiceAccountFolderFeed.jdField_b_of_type_Int);
        ((Intent)???).putExtra("INTENT_KEY_FROM", 2);
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.startActivity((Intent)???);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onClickFeedItem->uin:");
          ((StringBuilder)???).append(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
          ((StringBuilder)???).append(", name:");
          ((StringBuilder)???).append(localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
          QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)???).toString());
        }
        if (m == 1) {
          ??? = "0X80067EF";
        } else if (m == 2) {
          ??? = "0X80067F0";
        } else {
          ??? = "0X80067F1";
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("");
        ((StringBuilder)localObject5).append(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
        localObject5 = ((StringBuilder)localObject5).toString();
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("");
        ((StringBuilder)localObject6).append(m);
        localObject6 = ((StringBuilder)localObject6).toString();
        Object localObject7 = new StringBuilder();
        ((StringBuilder)localObject7).append("");
        ((StringBuilder)localObject7).append(l);
        localObject7 = ((StringBuilder)localObject7).toString();
        Object localObject8 = new StringBuilder();
        ((StringBuilder)localObject8).append("");
        ((StringBuilder)localObject8).append(k + 1);
        localObject8 = ((StringBuilder)localObject8).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        ReportController.b((AppRuntime)localObject4, "dc01160", "Pb_account_lifeservice", (String)localObject5, (String)???, (String)???, 0, 0, (String)localObject6, (String)localObject7, (String)localObject8, localStringBuilder.toString());
        RecentPubAccHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, localServiceAccountFolderFeed.jdField_a_of_type_Int, localServiceAccountFolderFeed.jdField_b_of_type_Int, 2, localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject5 = localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
        i = localServiceAccountFolderFeed.jdField_a_of_type_Int;
        j = localServiceAccountFolderFeed.jdField_b_of_type_Int;
        if (localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
          ??? = "";
        } else {
          ??? = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg;
        }
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(k);
        ((StringBuilder)localObject6).append("");
        PublicAccountEventReport.b((QQAppInterface)localObject4, (String)localObject5, i, j, (String)???, (String)localObject3, (String)localObject2, ((StringBuilder)localObject6).toString());
        if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.7.0", "");
        }
        if (b(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString))
        {
          VSReporter.a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_page", "clk_content", 0, 0, new String[] { "", "1", localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString, localServiceAccountFolderFeed.jdField_d_of_type_JavaLangString });
          VSReporter.b(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_clk", 0, 0, new String[0]);
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
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt1).getTag();
        if ((paramBitmap != null) && ((paramBitmap instanceof ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)))
        {
          paramBitmap = (ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)paramBitmap;
          if (paramString.equals(paramBitmap.jdField_a_of_type_JavaLangString)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter
 * JD-Core Version:    0.7.0.1
 */