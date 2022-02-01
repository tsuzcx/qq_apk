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
  public static CopyOnWriteArrayList<RecentPubAccHelper.PublicAccEnterDetail> a = new CopyOnWriteArrayList();
  private static int f = -1;
  private Activity b;
  private MqqHandler c;
  private QQProgressDialog d;
  private Runnable e = new RecentPubAccHelper.1(this);
  private boolean g = false;
  
  public RecentPubAccHelper(MqqHandler paramMqqHandler, Activity paramActivity)
  {
    this.c = paramMqqHandler;
    this.b = paramActivity;
    c();
  }
  
  private void a(int paramInt)
  {
    Toast.makeText(this.b, paramInt, 0).show();
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
      localObject1 = new NewIntent(this.b, ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
      ((NewIntent)localObject1).putExtra("cmd", "unfollow");
      localObject2 = new mobileqq_mp.UnFollowRequest();
      ((mobileqq_mp.UnFollowRequest)localObject2).uin.set((int)Long.parseLong(paramRecentBaseData.getRecentUserUin()));
      ((mobileqq_mp.UnFollowRequest)localObject2).account_type.set(e());
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, boolean paramBoolean)
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportUserDelPublicAcc --pUin: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", pName: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", unReadNum: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", unReadFlag: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", from: ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("RecentPubAccHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean) {
      localObject = "0X8009A33";
    } else {
      localObject = "0X800BDDA";
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, (String)localObject, (String)localObject, 0, 0, String.valueOf(i), String.valueOf(paramInt3), paramString2, "");
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
  
  public static boolean a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "showNetworkErrorToast");
    }
    Toast.makeText(this.b, paramInt, 0).show();
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
      ((StringBuilder)localObject).append(a.size());
      QLog.d("RecentPubAccHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (a.size() > 0)
    {
      localObject = a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecentPubAccHelper.PublicAccEnterDetail localPublicAccEnterDetail = (RecentPubAccHelper.PublicAccEnterDetail)((Iterator)localObject).next();
        long l = System.currentTimeMillis() - localPublicAccEnterDetail.a;
        if (l <= 3600000L) {
          a(paramQQAppInterface, localPublicAccEnterDetail.b, l, localPublicAccEnterDetail.c);
        }
      }
    }
    a.clear();
  }
  
  private void c() {}
  
  private void c(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    RecentUser localRecentUser;
    int i;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
      localRecentUser = localRecentUserBaseData.e();
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
  
  private int d()
  {
    return this.b.getResources().getDimensionPixelSize(2131299920);
  }
  
  private int e()
  {
    return 1;
  }
  
  private void f()
  {
    QQProgressDialog localQQProgressDialog = this.d;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.d.dismiss();
    }
  }
  
  public void a(Activity paramActivity, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramActivity);
    localActionSheet.setMainTitle(String.format(paramActivity.getResources().getString(2131892991), new Object[] { paramRecentBaseData.mTitleName }));
    int i;
    if (a()) {
      i = 2131892990;
    } else {
      i = 2131892989;
    }
    localActionSheet.addButton(i, 3);
    localActionSheet.addCancelButton(2131892988);
    localActionSheet.setOnDismissListener(new RecentPubAccHelper.5(this));
    localActionSheet.setOnButtonClickListener(new RecentPubAccHelper.6(this, paramQQAppInterface, paramRecentBaseData, localActionSheet));
    if (!localActionSheet.isShowing())
    {
      this.g = false;
      localActionSheet.show();
      if (a()) {
        ReportController.b(paramQQAppInterface, "dc00898", "", paramRecentBaseData.getRecentUserUin(), "0X800BDD7", "0X800BDD7", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    a.clear();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == null)
    {
      this.d = new QQProgressDialog(this.b, d());
      this.d.c(2131893007);
      this.d.setCanceledOnTouchOutside(true);
    }
    Object localObject = this.d;
    if (localObject != null) {
      if ((paramBoolean) && (!((QQProgressDialog)localObject).isShowing()))
      {
        this.d.show();
        this.c.postDelayed(this.e, 1000L);
      }
      else if ((!paramBoolean) && (this.d.isShowing()))
      {
        this.d.dismiss();
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
  
  public void b()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((QQProgressDialog)localObject).dismiss();
    }
    this.d = null;
    localObject = this.c;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacks(this.e);
    }
    a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper
 * JD-Core Version:    0.7.0.1
 */