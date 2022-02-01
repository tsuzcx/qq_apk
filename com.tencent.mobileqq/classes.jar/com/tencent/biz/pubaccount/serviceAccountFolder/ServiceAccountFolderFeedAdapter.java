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
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
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
    this.jdField_a_of_type_Float = paramServiceAccountFolderActivity.getResources().getDimension(2131298071);
    this.b = paramServiceAccountFolderActivity.getResources().getDimension(2131298069);
    this.c = (this.jdField_a_of_type_Float + this.b);
  }
  
  private void a(ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow->uin:" + paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.b(true);
    Object localObject1 = null;
    Object localObject2 = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject2 != null) {
      localObject1 = ((PublicAccountDataManager)localObject2).a(paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
    }
    if ((localObject1 != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((AccountDetail)localObject1).accountFlag) == -4))
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
    for (;;)
    {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).removeLbsUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
      return;
      localObject1 = new NewPublicAccountObserver(new ServiceAccountFolderFeedAdapter.6(this, paramServiceAccountFolderFeed), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)localObject1);
      PublicAccountStateReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 0);
    }
  }
  
  private void a(ServiceAccountFolderFeed paramServiceAccountFolderFeed, int paramInt)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, null);
    localActionSheet.setMainTitle(String.format(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources().getString(2131696491), new Object[] { paramServiceAccountFolderFeed.jdField_c_of_type_JavaLangString }));
    localActionSheet.addButton(2131696427, 3);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new ServiceAccountFolderFeedAdapter.4(this, paramServiceAccountFolderFeed, paramInt, localActionSheet));
    localActionSheet.show();
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showActionSheet->uin:" + paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", name:" + paramServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
    }
  }
  
  private void a(ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder paramServiceAccountFolderFeedHolder, int paramInt, View paramView)
  {
    ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)getItem(paramInt);
    if (localServiceAccountFolderFeed == null) {}
    for (;;)
    {
      return;
      boolean bool = a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateItemContent->uin:" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", isFollow:" + bool);
      }
      int i;
      if (bool)
      {
        paramServiceAccountFolderFeedHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramView.setTag(-3, Integer.valueOf((int)this.c));
        paramServiceAccountFolderFeedHolder.jdField_a_of_type_JavaLangString = localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder != null) {
          a(paramServiceAccountFolderFeedHolder, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
        }
        paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, localServiceAccountFolderFeed.jdField_c_of_type_Int);
        paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
        paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString, 0);
        i = 0;
        if (localServiceAccountFolderFeed.e == 4) {
          i = 2130839676;
        }
        paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0);
        i = localServiceAccountFolderFeed.jdField_d_of_type_Int;
        Object localObject2 = localServiceAccountFolderFeed.jdField_d_of_type_JavaLangString;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0)
        {
          localObject2 = localObject1;
          if (!((String)localObject1).endsWith(" ")) {
            localObject2 = (String)localObject1 + " ";
          }
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (i != 0)) {
          paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject2, 1);
      }
      try
      {
        paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(new QQText(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence, 3, 16));
        m = localServiceAccountFolderFeed.jdField_b_of_type_Int;
        i = localServiceAccountFolderFeed.jdField_a_of_type_Int;
        if (m > 0) {
          if (i == 0)
          {
            paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 0;
            if ((b(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))))
            {
              this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
              VSReporter.b(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_exp", 0, 0, new String[0]);
            }
            CustomWidgetUtil.a(paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, k, i, j, 99, null);
            if (!AppSetting.d) {
              continue;
            }
            paramView = new StringBuilder();
            paramView.append(paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText()).append(",");
            if (i != 0) {
              break label724;
            }
            paramView.append(paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.getText()).append(",").append(localServiceAccountFolderFeed.jdField_b_of_type_JavaLangString);
            paramServiceAccountFolderFeedHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramView);
            return;
            paramServiceAccountFolderFeedHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramView.setTag(-3, Integer.valueOf((int)this.b));
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int m;
          int j;
          int k;
          localException.printStackTrace();
          paramServiceAccountFolderFeedHolder.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence + " ");
          continue;
          if (i == 2)
          {
            paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
            paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
            i = 0;
            j = 0;
            k = 1;
          }
          else
          {
            int n = 3;
            int i1 = 2130850834;
            paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
            paramServiceAccountFolderFeedHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
            i = m;
            j = i1;
            k = n;
            if (b(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString))
            {
              VSReporter.a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_page", "new_exp", 0, 0, new String[0]);
              i = m;
              j = i1;
              k = n;
              continue;
              label724:
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
                paramView.append("有").append(i).append("条未读,");
                continue;
                i = 0;
                j = 0;
                k = 0;
              }
            }
          }
        }
      }
    }
  }
  
  private void a(ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder paramServiceAccountFolderFeedHolder, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "setHolderIcon->uin:" + paramString);
    }
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null)
    {
      paramServiceAccountFolderFeedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(1008, paramString));
      return;
    }
    paramServiceAccountFolderFeedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AccountDetail localAccountDetail;
    do
    {
      PublicAccountDataManager localPublicAccountDataManager;
      do
      {
        do
        {
          return false;
          localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        } while (localPublicAccountDataManager == null);
        localAccountDetail = localPublicAccountDataManager.b(paramString);
      } while (((localAccountDetail != null) && (!localAccountDetail.isShowFollowButton)) || ((localAccountDetail == null) && ("1770946116".equals(paramString))));
      if (localPublicAccountDataManager.c(paramString) != null) {
        return true;
      }
    } while (localAccountDetail == null);
    if (localAccountDetail.followType == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "showNetworkErrorToast");
    }
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131695222, 0).show();
  }
  
  private void b(ServiceAccountFolderFeed paramServiceAccountFolderFeed)
  {
    String str = paramServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "updateUnfollowInfo->uin:" + str);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramServiceAccountFolderFeed);
      notifyDataSetChanged();
      ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.7(this, paramServiceAccountFolderFeed));
      if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
        this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new ServiceAccountFolderFeedAdapter.8(this, str, paramServiceAccountFolderFeed), 10L);
      return;
    }
  }
  
  private boolean b(String paramString)
  {
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localPublicAccountDataManager != null)
    {
      paramString = localPublicAccountDataManager.b(paramString);
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
    if (paramList != null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderFeedAdapter", 2, "setDataList->DataSetChanged size:" + paramList.size());
      }
      return;
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView != null)
    {
      localObject1 = localObject2;
      if ((paramView.getTag() instanceof ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)) {
        localObject1 = (ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder)paramView.getTag();
      }
    }
    if (localObject1 == null)
    {
      paramView = new ServiceAccountFolderFeedAdapter.ServiceAccountFolderFeedHolder(this);
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity).inflate(2131559754, null);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131366661));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368603));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject1).findViewById(2131379432));
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject1).findViewById(2131365699));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131380944));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject1).findViewById(2131371195));
      paramView.jdField_b_of_type_AndroidWidgetButton = ((Button)((View)localObject1).findViewById(2131371178));
      Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.getResources();
      float f = DeviceInfoUtil.a();
      localObject2 = ((Resources)localObject3).getColorStateList(2131167117);
      localObject3 = ((Resources)localObject3).getColorStateList(2131167040);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject3);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(17.0F);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 0);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor((ColorStateList)localObject2, 2);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextSize(14.0F);
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(f * 2.0F), 1);
      paramView.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
      ((ThemeImageView)paramView.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramView.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((View)localObject1).setTag(paramView);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
      paramView.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
      paramView.jdField_b_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      a(paramView, paramInt, (View)localObject1);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = paramView;
      paramView = (View)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public void onClick(View paramView)
  {
    int k = ((Integer)paramView.getTag()).intValue();
    ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)getItem(k);
    if (localServiceAccountFolderFeed == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = localServiceAccountFolderFeed.jdField_b_of_type_Int;
    int j = localServiceAccountFolderFeed.jdField_a_of_type_Int;
    if (j != 1) {
      i = 0;
    }
    for (;;)
    {
      long l = ServiceAccountFolderManager.a().a(localServiceAccountFolderFeed);
      ??? = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      String str1;
      if (??? != null)
      {
        str1 = PublicAccountEventReport.a(localServiceAccountFolderFeed.jdField_b_of_type_Int + "", ((MessageRecord)???).msgseq + "", ((MessageRecord)???).msgBackupMsgRandom + "");
        label154:
        if ((localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject == null)) {
          break label1189;
        }
      }
      label401:
      label788:
      label1189:
      for (String str2 = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");; str2 = "") {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131366661: 
          ??? = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity, ChatActivity.class);
          ((Intent)???).putExtra("uintype", 1008);
          ((Intent)???).putExtra("uin", localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
          ((Intent)???).putExtra("uinname", localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
          ((Intent)???).putExtra("start_time", System.currentTimeMillis());
          ((Intent)???).putExtra("red_hot_count", localServiceAccountFolderFeed.jdField_b_of_type_Int);
          ((Intent)???).putExtra("INTENT_KEY_FROM", 2);
          this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.startActivity((Intent)???);
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickFeedItem->uin:" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", name:" + localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
          }
          ??? = "0X80067F1";
          QQAppInterface localQQAppInterface;
          String str3;
          if (j == 1)
          {
            ??? = "0X80067EF";
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, (String)???, (String)???, 0, 0, "" + j, "" + l, "" + (k + 1), "" + i);
            RecentPubAccHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, localServiceAccountFolderFeed.jdField_a_of_type_Int, localServiceAccountFolderFeed.jdField_b_of_type_Int, 2, localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
            localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            str3 = localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
            i = localServiceAccountFolderFeed.jdField_a_of_type_Int;
            j = localServiceAccountFolderFeed.jdField_b_of_type_Int;
            if (localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              break label788;
            }
          }
          for (??? = "";; ??? = localServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg)
          {
            PublicAccountEventReport.b(localQQAppInterface, str3, i, j, (String)???, str2, str1, k + "");
            if (PAWeatherItemBuilder.a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.5.5", "");
            }
            if (b(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString))
            {
              VSReporter.a(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_page", "clk_content", 0, 0, new String[] { "", "1", localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString, localServiceAccountFolderFeed.jdField_d_of_type_JavaLangString });
              VSReporter.b(localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_page", "new_msg_clk", 0, 0, new String[0]);
            }
            PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
            break;
            str1 = "";
            break label154;
            if (j != 2) {
              break label401;
            }
            ??? = "0X80067F0";
            break label401;
          }
        case 2131371195: 
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuUnfollow->uin:" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", name:" + localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
          }
          a(localServiceAccountFolderFeed, k);
          ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.1(this, localServiceAccountFolderFeed));
          break;
        case 2131371178: 
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderFeedAdapter", 2, "onClickMenuDelete->uin:" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", name:" + localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
          }
          for (;;)
          {
            synchronized (this.jdField_a_of_type_JavaLangObject)
            {
              this.jdField_a_of_type_JavaUtilList.remove(localServiceAccountFolderFeed);
              notifyDataSetChanged();
              ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.2(this, localServiceAccountFolderFeed));
              if ((getCount() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity != null) && (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.isResume())) {
                this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderActivity.a(true);
              }
              if (j == 2)
              {
                j = 1;
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "0X80067F3", "0X80067F3", 0, 0, "" + j, "" + i, "" + (k + 1), "" + l);
                RecentPubAccHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, localServiceAccountFolderFeed.jdField_a_of_type_Int, localServiceAccountFolderFeed.jdField_b_of_type_Int, 2, localServiceAccountFolderFeed.jdField_c_of_type_JavaLangString);
                ThreadManager.executeOnSubThread(new ServiceAccountFolderFeedAdapter.3(this, localServiceAccountFolderFeed));
              }
            }
            j = 0;
          }
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
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
    } while (!QLog.isColorLevel());
    QLog.d("ServiceAccountFolderFeedAdapter", 2, "onDecodeTaskCompleted->uin:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter
 * JD-Core Version:    0.7.0.1
 */