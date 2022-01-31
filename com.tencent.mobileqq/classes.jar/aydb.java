import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.activity.JoinTroopUtil.4;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;

public class aydb
  extends bbms
{
  private ajtg jdField_a_of_type_Ajtg;
  private ajuc jdField_a_of_type_Ajuc;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aydf jdField_a_of_type_Aydf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  private volatile boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  private aydb(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2, int paramInt, String paramString3, String paramString4, aydf paramaydf)
  {
    super(paramContext);
    a(paramContext, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, paramString1, paramString2, paramInt, paramString3, paramString4, paramaydf);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "registerObserver");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION"));
    setOnDismissListener(new ayde(this));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JoinTroopUtil.4(this), 15000L);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new bbne(this.jdField_a_of_type_AndroidContentContext).a(paramInt1, a(), 0, paramInt2);
  }
  
  private void a(@NonNull Context paramContext, @NonNull TroopInfoData paramTroopInfoData, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, aydf paramaydf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "init");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Aydf = paramaydf;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    this.jdField_a_of_type_Ajtg = ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
    paramTroopInfoData.troopUin = (paramString1 + "");
    paramTroopInfoData.pa = paramInt;
    paramTroopInfoData.troopName = (paramString2 + "");
    if (TextUtils.isEmpty(paramTroopInfoData.newTroopName)) {
      paramTroopInfoData.newTroopName = paramTroopInfoData.troopName;
    }
    this.b = (paramString3 + "");
    this.c = (paramString4 + "");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Ajuc = new aydc(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aydd(this);
    a();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, boolean paramBoolean, aydf paramaydf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinTroop by uin");
    }
    paramContext = new aydb(paramContext, paramString1, paramString2, paramInt, paramString3, paramString4, paramaydf);
    paramContext.d(paramBoolean);
    b(paramContext);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "onJoinTroopDone: troopUin = " + paramString + ", ret = " + paramInt + ", trace = " + Log.getStackTraceString(new RuntimeException()));
    }
    if (this.jdField_a_of_type_Aydf != null) {
      this.jdField_a_of_type_Aydf.a(paramString, paramInt);
    }
    dismiss();
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, String.format("onJoinTroopRsp isSuccess = %s, reqtype = %s, result = %s, troopUin = %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
    if (paramBoolean) {
      if (1 == paramInt1) {
        switch (paramInt2)
        {
        case -1: 
        default: 
          if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "onJoinTroopRsp failed");
          }
          a(2131628045, 1);
          a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
        }
      }
    }
    for (;;)
    {
      dismiss();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "onJoinTroopRsp gotoWebInfo");
      }
      this.jdField_a_of_type_Ajtg.b(Long.parseLong(paramString), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "onJoinTroopRsp gotoAIO = " + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Boolean) {
        f();
      }
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString);
      localTroopInfo.troopuin = paramString;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)) {}
      for (localTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;; localTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(localTroopInfo);
        this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.e(localTroopInfo);
        a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "onJoinTroopRsp join forbidden");
      }
      a(2131654599, 1);
      a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      continue;
      if (1 == paramInt1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "onJoinTroopRsp rsp failed");
        }
        azlj.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramInt2);
        a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, TroopInfo paramTroopInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, String.format("handle0x88d isSuccess = %s, troopUin = %s, troopInfo = %s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramTroopInfo }));
    }
    String str = String.valueOf(paramLong);
    if (!str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "handle0x88d return due to different uin");
      }
      a(str, 2);
      return;
    }
    if (paramTroopInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopUtil", 2, "handle0x88d return due to empty troopInfo");
      }
      a(str, 2);
      return;
    }
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramTroopInfo.troopname)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramTroopInfo.troopname;
      }
      if (!TextUtils.isEmpty(paramTroopInfo.newTroopName)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = paramTroopInfo.newTroopName;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag = ((int)paramTroopInfo.troopPrivilegeFlag);
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "handle0x88d return due to OnlyTroopMemberInvite");
        }
        a(2131654590, 0);
        a(str, 2);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddTroopUtil", 2, "handle0x88d return due to HomeworkGroup");
        }
        c();
        a(str, 4);
        return;
      }
      paramBoolean = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128);
      boolean bool = TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512);
      if ((paramBoolean) && (bool))
      {
        d();
        a(str, 4);
        return;
      }
      a(null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "handle0x88d return due rsp failed");
    }
    a(2131653422, 1);
    a(str, 2);
  }
  
  private boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "realJoinGroup");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)
    {
      e();
      return false;
    }
    b(paramString);
    return true;
  }
  
  private int b()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "doJoinTroop");
    }
    if (!badq.d(this.jdField_a_of_type_AndroidContentContext))
    {
      a(2131628946, 1);
      i = 2;
    }
    do
    {
      return i;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 34) && (anoe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        anue.a(this.jdField_a_of_type_AndroidContentContext).show();
        return 1;
      }
      if (QSecFramework.a().a(1001).booleanValue()) {
        QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(6), "joingroup", null }, null);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.b)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop())
        {
          c();
          return 1;
        }
        e();
        return 0;
      }
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.jdField_a_of_type_Ajtg.a(l, 8390785);
        return 0;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("AddTroopUtil", 2, localException.toString());
    return 0;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "unRegisterObserver");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AddTroopUtil", 2, "unRegisterObserver error", localException);
    }
  }
  
  private static void b(@NonNull aydb paramaydb)
  {
    paramaydb.setCancelable(false);
    paramaydb.setCanceledOnTouchOutside(false);
    paramaydb.c(2131629253);
    if (paramaydb.b() == 0)
    {
      paramaydb.show();
      return;
    }
    paramaydb.b();
    paramaydb.a(paramaydb.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "jumpJoinTroopVerify");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      paramString = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, "", this.b, this.c, paramString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
      return;
    }
    a(2131654599, 0);
    a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinHomeworkGroup");
    }
    azgh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "gotoWebInfo, url = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131652917, 1).b(a());
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 3);
      return;
      paramString = paramString + "?_wv=1031&troopUin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&isVerify=" + 0;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("show_right_close_button", true);
      localIntent.putExtra("finish_animation_up_down", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130771997, 2130771990);
      }
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinPayGroup");
    }
    afce.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "joinGroup");
    }
    this.jdField_a_of_type_Ajtg.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.b, this.c, null, null);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddTroopUtil", 2, "go2AIO");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 30) {}
    for (Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);; localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class))
    {
      localIntent = aciy.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aydb
 * JD-Core Version:    0.7.0.1
 */