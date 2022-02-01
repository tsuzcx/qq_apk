package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.data.AccountDetail;
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
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166);
  }
  
  private void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, paramInt, 0).show();
  }
  
  private void a(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = null;
    PAStartupTracker.a(null, " pubAcc_follow_cancel", paramRecentBaseData.getRecentUserUin());
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "unfollow->UIN: " + paramRecentBaseData.getRecentUserUin());
    }
    a(true);
    Object localObject2 = (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject2 != null) {
      localObject1 = ((PublicAccountDataManager)localObject2).a(paramRecentBaseData.getRecentUserUin());
    }
    if ((localObject1 != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(((AccountDetail)localObject1).accountFlag) == -4))
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
    for (;;)
    {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).removeLbsUin(paramQQAppInterface, paramRecentBaseData.getRecentUserUin());
      if (QLog.isColorLevel()) {
        QLog.d("RecentPubAccHelper", 2, "unfollow exit");
      }
      return;
      localObject1 = new NewPublicAccountObserver(new RecentPubAccHelper.3(this, paramRecentBaseData, paramQQAppInterface), paramQQAppInterface);
      paramQQAppInterface.removeObserver((BusinessObserver)localObject1);
      paramQQAppInterface.addObserver((BusinessObserver)localObject1);
      PublicAccountStateReporter.a(paramQQAppInterface, false, paramRecentBaseData.getRecentUserUin(), 0);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    int i = 4;
    if (paramInt2 > 0) {
      switch (paramInt1)
      {
      default: 
        i = 3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentPubAccHelper", 2, new Object[] { "reportUserClickPubAccEnterAIO --pUin: " + paramString1 + ", pName: " + paramString2 + ", unReadNum: " + paramInt2, ", unReadFlag: " + i + ", from: " + paramInt3 });
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A31", "0X8009A31", 0, 0, String.valueOf(i), String.valueOf(paramInt3), paramString2, "");
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "reportUserStayPublicAccAIOTime --pUin: " + paramString1 + ", pName: " + paramString2 + ", time: " + paramLong);
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A32", "0X8009A32", 0, 0, String.valueOf(paramLong), "", paramString2, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "reportUserUnfollowPublicAcc --pUin: " + paramString1 + ", pName: " + paramString2);
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A34", "0X8009A34", 0, 0, "", "", paramString2, "");
  }
  
  private void a(AccountDetail paramAccountDetail, QQAppInterface paramQQAppInterface)
  {
    if (paramAccountDetail == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "deleteAccount");
    }
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface.remove(paramAccountDetail);
    paramQQAppInterface.close();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AccountDetail localAccountDetail;
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return false;
            localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          } while (localObject == null);
          localObject = (PublicAccountDataManager)((QQAppInterface)localObject).getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        } while (localObject == null);
        localAccountDetail = ((PublicAccountDataManager)localObject).b(paramString);
      } while (((localAccountDetail != null) && (!localAccountDetail.isShowFollowButton)) || ((localAccountDetail == null) && ("1770946116".equals(paramString))) || ((localAccountDetail != null) && ("2173223560".equals(paramString))));
      if (((PublicAccountDataManager)localObject).c(paramString) != null) {
        return true;
      }
    } while (localAccountDetail == null);
    if (localAccountDetail.followType == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "reportUserStayPublicAccAIOTime --mPubAccEnterList.size: " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        RecentPubAccHelper.PublicAccEnterDetail localPublicAccEnterDetail = (RecentPubAccHelper.PublicAccEnterDetail)localIterator.next();
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
    int i = 4;
    if (paramInt2 > 0) {
      switch (paramInt1)
      {
      default: 
        i = 3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentPubAccHelper", 2, "reportUserDelPublicAcc --pUin: " + paramString1 + ", pName: " + paramString2 + ", unReadNum: " + paramInt2 + ", unReadFlag: " + i + ", from: " + paramInt3);
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A33", "0X8009A33", 0, 0, String.valueOf(i), String.valueOf(paramInt3), paramString2, "");
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void c(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    RecentUser localRecentUser = null;
    int i = -1;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
      localRecentUser = localRecentUserBaseData.a();
      i = localRecentUserBaseData.mPosition;
    }
    if (localRecentUser != null)
    {
      RecentReportHelper.a(paramQQAppInterface, paramRecentBaseData, localRecentUser);
      RecentUtil.a(paramQQAppInterface, localRecentUser, i);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void a(Activity paramActivity, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramActivity);
    localActionSheet.setMainTitle(String.format(paramActivity.getResources().getString(2131695260), new Object[] { paramRecentBaseData.mTitleName }));
    localActionSheet.addButton(2131695259, 3);
    localActionSheet.addCancelButton(2131695258);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131695269);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        break label120;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentPubAccHelper", 2, "showProgressBar->show:" + paramBoolean);
      }
      return;
      label120:
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper
 * JD-Core Version:    0.7.0.1
 */