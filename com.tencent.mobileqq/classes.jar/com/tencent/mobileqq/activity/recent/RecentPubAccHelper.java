package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class RecentPubAccHelper
{
  public static CopyOnWriteArrayList<RecentPubAccHelper.PublicAccEnterDetail> a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RecentPubAccHelper.1(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public RecentPubAccHelper(MqqHandler paramMqqHandler, Activity paramActivity)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168);
  }
  
  private void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, paramInt, 0).show();
  }
  
  private void a(IPublicAccountDetail paramIPublicAccountDetail, QQAppInterface paramQQAppInterface)
  {
    if (paramIPublicAccountDetail == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "deleteAccount");
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.remove(paramIPublicAccountDetail.getEntity());
    paramQQAppInterface.close();
  }
  
  private void a(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = paramRecentBaseData.getRecentUserUin();
    Object localObject1 = null;
    PAStartupTracker.a(null, " pubAcc_follow_cancel", (String)localObject2);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("unfollow->UIN: ");
      ((StringBuilder)localObject2).append(paramRecentBaseData.getRecentUserUin());
      QLog.d("RecentPubAccHelper", 2, ((StringBuilder)localObject2).toString());
    }
    a(true);
    localObject2 = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject2 != null) {
      localObject1 = ((IPublicAccountDataManager)localObject2).findAccountDetailInfo(paramRecentBaseData.getRecentUserUin());
    }
    if ((localObject1 != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((IPublicAccountDetail)localObject1).getAccountFlag()) == -4))
    {
      localObject1 = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
      ((NewIntent)localObject1).putExtra("cmd", "unfollow");
      localObject2 = new mobileqq_mp.UnFollowRequest();
      ((mobileqq_mp.UnFollowRequest)localObject2).uin.set((int)Long.parseLong(paramRecentBaseData.getRecentUserUin()));
      ((mobileqq_mp.UnFollowRequest)localObject2).account_type.set(b());
      ((NewIntent)localObject1).putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(new RecentPubAccHelper.2(this, paramRecentBaseData, paramQQAppInterface));
      paramQQAppInterface.startServlet((NewIntent)localObject1);
    }
    else
    {
      localObject1 = new NewPublicAccountObserver(new RecentPubAccHelper.3(this, paramRecentBaseData, paramQQAppInterface), paramQQAppInterface);
      paramQQAppInterface.removeObserver((BusinessObserver)localObject1);
      paramQQAppInterface.addObserver((BusinessObserver)localObject1);
      PublicAccountStateReporter.a(paramQQAppInterface, false, paramRecentBaseData.getRecentUserUin(), 0);
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).removeLbsUin(paramQQAppInterface, paramRecentBaseData.getRecentUserUin());
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "unfollow exit");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    int j = 4;
    int i = j;
    if (paramInt2 > 0)
    {
      i = j;
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1) {
          if (paramInt1 != 2)
          {
            if ((paramInt1 != 3) && (paramInt1 != 4))
            {
              i = 3;
              break label54;
            }
          }
          else
          {
            i = 2;
            break label54;
          }
        }
        i = 1;
      }
    }
    label54:
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportUserClickPubAccEnterAIO --pUin: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", pName: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", unReadNum: ");
      ((StringBuilder)localObject).append(paramInt2);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(", unReadFlag: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", from: ");
      localStringBuilder.append(paramInt3);
      QLog.d("RecentPubAccHelper", 2, new Object[] { localObject, localStringBuilder.toString() });
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A31", "0X8009A31", 0, 0, String.valueOf(i), String.valueOf(paramInt3), paramString2, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportUserStayPublicAccAIOTime --pUin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", pName: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", time: ");
      localStringBuilder.append(paramLong);
      QLog.d("RecentPubAccHelper", 2, localStringBuilder.toString());
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A32", "0X8009A32", 0, 0, String.valueOf(paramLong), "", paramString2, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportUserUnfollowPublicAcc --pUin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", pName: ");
      localStringBuilder.append(paramString2);
      QLog.d("RecentPubAccHelper", 2, localStringBuilder.toString());
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A34", "0X8009A34", 0, 0, "", "", paramString2, "");
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return false;
    }
    localObject = (IPublicAccountDataManager)((QQAppInterface)localObject).getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      IPublicAccountDetail localIPublicAccountDetail = ((IPublicAccountDataManager)localObject).findAccountDetailInfoCache(paramString);
      if ((localIPublicAccountDetail != null) && (!localIPublicAccountDetail.isShowFollowButton())) {
        return false;
      }
      if ((localIPublicAccountDetail == null) && ("1770946116".equals(paramString))) {
        return false;
      }
      if ((localIPublicAccountDetail != null) && ("2173223560".equals(paramString))) {
        return false;
      }
      if ((PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(paramString) != null) {
        return true;
      }
      if (localIPublicAccountDetail != null) {
        return localIPublicAccountDetail.getFollowType() == 1;
      }
    }
    return false;
  }
  
  private int b()
  {
    return 1;
  }
  
  private void b() {}
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "showNetworkErrorToast");
    }
    Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, paramInt, 0).show();
  }
  
  private void b(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new RecentPubAccHelper.4(this, paramQQAppInterface, paramRecentBaseData), 10L);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportUserStayPublicAccAIOTime --mPubAccEnterList.size: ");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
      QLog.d("RecentPubAccHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      localObject = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecentPubAccHelper.PublicAccEnterDetail localPublicAccEnterDetail = (RecentPubAccHelper.PublicAccEnterDetail)((Iterator)localObject).next();
        long l = System.currentTimeMillis() - localPublicAccEnterDetail.jdField_a_of_type_Long;
        if (l <= 3600000L) {
          a(paramQQAppInterface, localPublicAccEnterDetail.jdField_a_of_type_JavaLangString, l, localPublicAccEnterDetail.b);
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    int j = 4;
    int i = j;
    if (paramInt2 > 0)
    {
      i = j;
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1) {
          if (paramInt1 != 2)
          {
            if ((paramInt1 != 3) && (paramInt1 != 4))
            {
              i = 3;
              break label54;
            }
          }
          else
          {
            i = 2;
            break label54;
          }
        }
        i = 1;
      }
    }
    label54:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportUserDelPublicAcc --pUin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", pName: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", unReadNum: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", unReadFlag: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", from: ");
      localStringBuilder.append(paramInt3);
      QLog.d("RecentPubAccHelper", 2, localStringBuilder.toString());
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A33", "0X8009A33", 0, 0, String.valueOf(i), String.valueOf(paramInt3), paramString2, "");
  }
  
  private void c()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void c(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    RecentUser localRecentUser;
    int i;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
      localRecentUser = localRecentUserBaseData.a();
      i = localRecentUserBaseData.mPosition;
    }
    else
    {
      localRecentUser = null;
      i = -1;
    }
    if (localRecentUser != null)
    {
      RecentReportHelper.a(paramQQAppInterface, paramRecentBaseData, localRecentUser);
      RecentUtil.a(paramQQAppInterface, localRecentUser, i);
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localObject != null) {
      ((QQProgressDialog)localObject).dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void a(Activity paramActivity, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramActivity);
    localActionSheet.setMainTitle(String.format(paramActivity.getResources().getString(2131695256), new Object[] { paramRecentBaseData.mTitleName }));
    localActionSheet.addButton(2131695255, 3);
    localActionSheet.addCancelButton(2131695254);
    localActionSheet.setOnDismissListener(new RecentPubAccHelper.5(this));
    localActionSheet.setOnButtonClickListener(new RecentPubAccHelper.6(this, paramQQAppInterface, paramRecentBaseData, localActionSheet));
    if (!localActionSheet.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      localActionSheet.show();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, a());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131695272);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localObject != null) {
      if ((paramBoolean) && (!((QQProgressDialog)localObject).isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
      else if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showProgressBar->show:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("RecentPubAccHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper
 * JD-Core Version:    0.7.0.1
 */