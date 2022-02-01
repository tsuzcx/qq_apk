import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink.1;
import cooperation.qlink.QlAndQQInterface;
import cooperation.qlink.QlAndQQInterface.DailogClickInfo;
import cooperation.qlink.QlAndQQInterface.InsertFMFileInfo;
import cooperation.qlink.QlAndQQInterface.ReportInfo;
import cooperation.qlink.QlAndQQInterface.ReportPerformanceInfo;
import cooperation.qlink.QlAndQQInterface.SendFileInfo;
import cooperation.qlink.QlAndQQInterface.SendFileInfos;
import cooperation.qlink.QlAndQQInterface.UserInfo;
import cooperation.qlink.QlAndQQInterface.WorkState;
import cooperation.qlink.QlinkBridgeActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class blyb
{
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private QlAndQQInterface.WorkState jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
  private Timer jdField_a_of_type_JavaUtilTimer;
  private int jdField_b_of_type_Int = -1;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  
  public blyb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, zms paramzms)
  {
    if (paramActivity == null) {
      return;
    }
    String str = anvx.a(2131710158);
    if (1 == paramInt) {
      paramString = str + anvx.a(2131710161) + paramString + anvx.a(2131710156);
    }
    for (;;)
    {
      bhdj.a(paramActivity, 230, paramActivity.getString(2131698057), paramString, 2131698051, 2131698051, new blyk(this, paramzms), null).show();
      return;
      if (2 == paramInt) {
        paramString = str + anvx.a(2131710160) + paramString + anvx.a(2131710155);
      } else {
        paramString = anvx.a(2131710157);
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - startQlink failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), anvx.a(2131710159), 0).show();
      return;
    }
    Intent localIntent = new Intent(paramContext, QlinkBridgeActivity.class);
    localIntent.putExtra("_from_", paramInt);
    if (paramBundle != null) {
      localIntent.putExtra("_param_", paramBundle);
    }
    if ((paramContext instanceof aapf)) {
      localIntent.setFlags(276824064);
    }
    if ((9 == paramInt) || (10 == paramInt)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 161	blyb:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 92
    //   16: iconst_1
    //   17: ldc 163
    //   19: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: new 167	java/util/Timer
    //   26: dup
    //   27: invokespecial 168	java/util/Timer:<init>	()V
    //   30: putfield 161	blyb:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   33: aload_0
    //   34: getfield 161	blyb:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   37: new 170	cooperation/qlink/QQProxyForQlink$9
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 172	cooperation/qlink/QQProxyForQlink$9:<init>	(Lblyb;)V
    //   45: lconst_0
    //   46: ldc2_w 173
    //   49: invokevirtual 178	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   52: goto -41 -> 11
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	blyb
    //   6	2	1	localTimer	Timer
    //   55	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	55	finally
    //   14	52	55	finally
  }
  
  private void i()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ cancelQlinkHeartTimer");
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void j()
  {
    IntentFilter localIntentFilter;
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new blyc(this);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label95;
      }
    }
    label95:
    for (BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();; localBaseApplication = null)
    {
      if (localBaseApplication != null)
      {
        localBaseApplication.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        return;
      }
      QLog.e("QQProxyForQlink", 1, "registerAccountReceiver error. fail");
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null)) {
        QLog.e("QQProxyForQlink", 1, "unregisterAccountReceiver error.");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 223	blyb:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   8: ifnonnull +58 -> 66
    //   11: aload_0
    //   12: new 225	blyd
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 226	blyd:<init>	(Lblyb;)V
    //   20: putfield 223	blyb:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   23: new 190	android/content/IntentFilter
    //   26: dup
    //   27: invokespecial 191	android/content/IntentFilter:<init>	()V
    //   30: astore_2
    //   31: aload_2
    //   32: ldc 228
    //   34: invokevirtual 197	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 28	blyb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   41: ifnull +11 -> 52
    //   44: aload_0
    //   45: getfield 28	blyb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   48: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   51: astore_1
    //   52: aload_1
    //   53: ifnull +16 -> 69
    //   56: aload_1
    //   57: aload_0
    //   58: getfield 223	blyb:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   61: aload_2
    //   62: invokevirtual 212	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   65: pop
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: ldc 92
    //   71: iconst_1
    //   72: ldc 230
    //   74: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 223	blyb:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   82: goto -16 -> 66
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	blyb
    //   1	56	1	localBaseApplication	BaseApplication
    //   85	4	1	localObject	Object
    //   30	32	2	localIntentFilter	IntentFilter
    // Exception table:
    //   from	to	target	type
    //   4	37	85	finally
    //   37	52	85	finally
    //   56	66	85	finally
    //   69	82	85	finally
  }
  
  /* Error */
  private void m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 223	blyb:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   6: ifnull +28 -> 34
    //   9: aload_0
    //   10: getfield 28	blyb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 28	blyb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: ifnonnull +14 -> 37
    //   26: ldc 92
    //   28: iconst_1
    //   29: ldc 233
    //   31: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 28	blyb:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   41: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: aload_0
    //   45: getfield 223	blyb:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   48: invokevirtual 221	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 223	blyb:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   56: goto -22 -> 34
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	blyb
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	34	59	finally
    //   37	56	59	finally
  }
  
  public int a()
  {
    return this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount;
  }
  
  public QlAndQQInterface.WorkState a()
  {
    return this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState;
  }
  
  public void a()
  {
    QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppInit");
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null)) {
      ThreadManager.executeOnSubThread(new QQProxyForQlink.1(this));
    }
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount = paramInt;
    if (i != this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QQProxyForQlink", 4, "[QLINK]-QQ UI_LOG:notifyGoingonTransChanged.count:" + paramInt);
      }
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(1134025, null).sendToTarget();
      }
    }
  }
  
  public void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {}
    label403:
    for (;;)
    {
      return;
      String str2 = ContactUtils.getFriendDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin);
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin.equalsIgnoreCase(str2)) {}
      }
      else
      {
        if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick == null) {
          break label224;
        }
        str1 = this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick;
      }
      if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode == 1)
      {
        a("0X8004854", 1);
        paramOnClickListener3 = paramActivity.getResources().getString(2131698097) + str1 + paramActivity.getResources().getString(2131698098);
        if ((paramString != null) && (!paramString.equalsIgnoreCase(this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin)))
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(paramActivity, 230, paramActivity.getResources().getString(2131698058), paramOnClickListener3, paramActivity.getResources().getString(2131698099), paramActivity.getResources().getString(2131698099), paramOnClickListener2, null);
          label194:
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
          break label403;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new blyh(this));
        return;
        label224:
        str1 = this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin;
        break;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(paramActivity, 230, paramActivity.getResources().getString(2131698058), paramOnClickListener3, paramActivity.getResources().getString(2131698099), paramActivity.getResources().getString(2131698100), paramOnClickListener1, paramOnClickListener2);
        break label194;
        if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode == 2)
        {
          a("0X8004856", 1);
          paramOnClickListener1 = str1 + paramActivity.getResources().getString(2131698096);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(paramActivity, 230, paramActivity.getResources().getString(2131698058), paramOnClickListener1, paramActivity.getResources().getString(2131698095), paramActivity.getResources().getString(2131698095), paramOnClickListener3, null);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - working but op err");
        }
      }
    }
  }
  
  public void a(Activity paramActivity, ArrayList<String> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramActivity == null) {}
    label166:
    do
    {
      return;
      switch (paramInt2)
      {
      }
      for (;;)
      {
        if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mWorking) {
          break label166;
        }
        Object localObject = null;
        paramString = localObject;
        if (paramArrayList != null)
        {
          paramString = localObject;
          if (paramArrayList.size() > 0)
          {
            paramString = new Bundle();
            paramString.putStringArrayList("string_filepaths", paramArrayList);
          }
        }
        a(paramActivity, paramInt1, paramString);
        if (!paramBoolean) {
          break;
        }
        paramActivity.finish();
        return;
        a("0X800484F", 1);
        continue;
        a("0X800485B", 1);
        continue;
        a("0X800485E", 1);
        continue;
        a("0X8004858", 1);
        continue;
        a("0X800566F", 1);
      }
      if ((15 != paramInt1) || ((paramArrayList != null) && (paramArrayList.size() != 0))) {
        break;
      }
      a(paramActivity, paramInt1, new Bundle());
    } while (!paramBoolean);
    paramActivity.finish();
    return;
    a(paramActivity, new blye(this, paramArrayList, paramActivity, paramInt1, paramBoolean), new blyf(this), new blyg(this), paramString);
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = (QlAndQQInterface.WorkState)paramBundle.getSerializable("wstate");
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mForIphone = paramBundle.mForIphone;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode = paramBundle.mMode;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick = paramBundle.mPeerNick;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin = paramBundle.mPeerUin;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mState = paramBundle.mState;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount = paramBundle.mTransferingCount;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mWorking = paramBundle.mWorking;
  }
  
  public void a(QlAndQQInterface.DailogClickInfo paramDailogClickInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.a, paramDailogClickInfo);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().a("cmd.senddailogclickinfo", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ sendDailogClick:" + i);
    }
  }
  
  public void a(QlAndQQInterface.InsertFMFileInfo paramInsertFMFileInfo)
  {
    if (paramInsertFMFileInfo == null) {
      return;
    }
    String str = auea.a(paramInsertFMFileInfo.filePath);
    long l1 = auea.a(paramInsertFMFileInfo.filePath);
    long l2 = bcsa.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(l2, paramInsertFMFileInfo.uin, 0);
    localFileManagerEntity.setCloudType(5);
    localFileManagerEntity.nSessionId = paramInsertFMFileInfo.sessionId;
    localFileManagerEntity.setFilePath(paramInsertFMFileInfo.filePath);
    localFileManagerEntity.nFileType = auea.a(paramInsertFMFileInfo.filePath);
    localFileManagerEntity.strThumbPath = paramInsertFMFileInfo.thumbPath;
    localFileManagerEntity.fileName = str;
    localFileManagerEntity.fileSize = l1;
    localFileManagerEntity.srvTime = (bcrg.a() * 1000L);
    localFileManagerEntity.msgSeq = auea.a();
    localFileManagerEntity.msgUid = auea.b();
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = paramInsertFMFileInfo.uin;
    localFileManagerEntity.nOlSenderProgress = paramInsertFMFileInfo.transSeq;
    anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localanvk.e(String.valueOf(localFileManagerEntity.peerUin)) != null)
    {
      localFileManagerEntity.peerType = 0;
      localFileManagerEntity.peerNick = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInsertFMFileInfo.uin, null, 0);
      localFileManagerEntity.status = 1;
      if ((!localanvk.b(paramInsertFMFileInfo.uin)) && (!paramInsertFMFileInfo.bSend)) {
        break label357;
      }
      localFileManagerEntity.nOpType = 0;
      localFileManagerEntity.bSend = true;
      TransfileUtile.makeTransFileProtocolData(paramInsertFMFileInfo.filePath, 0L, 0, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      QLog.d("QQProxyForQlink", 4, "insertFM sessionid:" + paramInsertFMFileInfo.sessionId + " transeq:" + localFileManagerEntity.nOlSenderProgress + " filePath:" + paramInsertFMFileInfo.filePath);
      return;
      localFileManagerEntity.peerType = 1003;
      break;
      label357:
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.bSend = false;
      TransfileUtile.makeTransFileProtocolData(paramInsertFMFileInfo.filePath, l1, 0, false, null);
      BuddyTransfileProcessor.getTransferFilePath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
    }
  }
  
  public void a(QlAndQQInterface.UserInfo paramUserInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.a, paramUserInfo);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().a("cmd.senduserinfo", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ sendUserInfo:" + i);
    }
  }
  
  public void a(String paramString)
  {
    String str = ContactUtils.getFriendNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    QlAndQQInterface.UserInfo localUserInfo = new QlAndQQInterface.UserInfo();
    localUserInfo.uin = paramString;
    if (str != null) {}
    for (localUserInfo.nick = str;; localUserInfo.nick = paramString)
    {
      paramString = localanvk.e(paramString);
      localUserInfo.isFriend = false;
      if (paramString != null) {
        localUserInfo.isFriend = paramString.isFriend();
      }
      a(localUserInfo);
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "QLINK_CLICK_EVENT: act=" + paramString + " count:" + paramInt);
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, 0, paramInt, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    if (QLog.isDevelopLevel())
    {
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (paramHashMap != null)
      {
        localObject1 = localObject2;
        if (paramHashMap.size() > 0)
        {
          localObject2 = paramHashMap.entrySet().iterator();
          Map.Entry localEntry;
          for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + " " + (String)localEntry.getKey() + ":" + (String)localEntry.getValue()) {
            localEntry = (Map.Entry)((Iterator)localObject2).next();
          }
        }
      }
      QLog.d("QQProxyForQlink", 4, "QLINK_PERFORMANCE: tagName=" + paramString2 + " uin:" + paramString1 + " success:" + paramBoolean + (String)localObject1);
    }
    blyp.a(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap);
  }
  
  public void a(AppActivity paramAppActivity, String paramString, zms paramzms)
  {
    if ((paramAppActivity == null) || (paramString == null)) {
      return;
    }
    blyo localblyo = blyn.a(paramString);
    if (localblyo == null)
    {
      bhdj.a(paramAppActivity, 230, paramAppActivity.getString(2131698057), paramAppActivity.getString(2131698077), 2131698051, 2131698051, new blyi(this, paramzms), null).show();
      return;
    }
    if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mWorking)
    {
      a(paramAppActivity, this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode, this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick, paramzms);
      return;
    }
    boolean bool = "qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from"));
    if (bool) {
      c(1);
    }
    paramzms = new Bundle();
    paramzms.putString("url", paramString);
    paramzms.putString("key", localblyo.a);
    paramzms.putString("peerUin", localblyo.b);
    paramzms.putString("peerNick", localblyo.c);
    paramzms.putString("peerOS", localblyo.d);
    paramzms.putString("apSSID", localblyo.e);
    paramzms.putString("preSharedKey", localblyo.f);
    paramzms.putBoolean("fromqlink", bool);
    paramString = paramAppActivity.getIntent().getStringExtra("subfrom");
    if (paramString != null) {
      paramzms.putString("subfrom", paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink();
    a(paramAppActivity, 11, paramzms);
    paramAppActivity.finish();
  }
  
  public void a(AppActivity paramAppActivity, zms paramzms)
  {
    if (paramAppActivity == null) {
      return;
    }
    bhdj.a(paramAppActivity, 230, paramAppActivity.getString(2131698075), paramAppActivity.getString(2131698076), 2131698051, 2131698051, new blyj(this, paramzms), null).show();
  }
  
  public boolean a(QlAndQQInterface.SendFileInfos paramSendFileInfos)
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink().a("0X8004763", 1);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.a, paramSendFileInfos);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().a("cmd.sendfilemsgs", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ QQ2QlSendFileMsgs:" + i);
    }
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(String paramString, List<String> paramList)
  {
    if ((paramList == null) || (paramString == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. param error");
      }
    }
    do
    {
      return false;
      if (paramList.size() > 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. no any file");
    return false;
    QlAndQQInterface.SendFileInfos localSendFileInfos = new QlAndQQInterface.SendFileInfos();
    localSendFileInfos.strUin = paramString;
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      QlAndQQInterface.SendFileInfo localSendFileInfo = new QlAndQQInterface.SendFileInfo();
      localSendFileInfo.sessionid = auea.a().longValue();
      localSendFileInfo.filePath = paramList;
      localSendFileInfo.fileSize = auea.a(paramList);
      localSendFileInfos.infos.add(localSendFileInfo);
    }
    return a(localSendFileInfos);
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (1 == paramInt) {
      auea.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("qlinkexit", false))
      {
        QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ qlink is exit:");
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
        i();
        return;
      }
      paramBundle = (QlAndQQInterface.WorkState)paramBundle.getSerializable("wstate");
      if (paramBundle != null)
      {
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mForIphone = paramBundle.mForIphone;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode = paramBundle.mMode;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick = paramBundle.mPeerNick;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin = paramBundle.mPeerUin;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mState = paramBundle.mState;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount = paramBundle.mTransferingCount;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mWorking = paramBundle.mWorking;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 0;
      return;
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ respHeart. no wstate error");
      continue;
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ respHeart. info = null");
    }
  }
  
  public void c()
  {
    QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppDestroy");
    k();
    m();
    i();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("cmd", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().a("cmd.sendsimplecmd", localBundle);
  }
  
  public void c(Bundle paramBundle)
  {
    int i = paramBundle.getInt("Event", 0);
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - unimplement event[" + i + "]");
      }
    case 18: 
    case 19: 
      do
      {
        return;
        a(paramBundle.getString("action_name"), paramBundle.getInt(QlAndQQInterface.a));
        return;
        paramBundle = (QlAndQQInterface.ReportInfo)paramBundle.getSerializable(QlAndQQInterface.a);
      } while (!(paramBundle.data instanceof QlAndQQInterface.ReportPerformanceInfo));
      paramBundle = (QlAndQQInterface.ReportPerformanceInfo)paramBundle.data;
      a(paramBundle.mUin, paramBundle.mTagName, paramBundle.mSuccess, paramBundle.mDuration, paramBundle.mSize, paramBundle.mParams);
      return;
    case 20: 
      blyp.a();
      return;
    case 21: 
      blyp.b();
      return;
    case 15: 
      a((QlAndQQInterface.InsertFMFileInfo)paramBundle.getSerializable(QlAndQQInterface.a));
      return;
    case 16: 
      a(paramBundle.getInt(QlAndQQInterface.a));
      return;
    case 17: 
      a(paramBundle.getString(QlAndQQInterface.a));
      return;
    case 22: 
      d();
      return;
    case 23: 
      a(paramBundle.getBundle(QlAndQQInterface.a));
      return;
    case 24: 
      b(paramBundle.getBundle(QlAndQQInterface.a));
      return;
    }
    b(paramBundle.getInt(QlAndQQInterface.a));
  }
  
  public void d()
  {
    QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ nofityQlinkStart");
    h();
  }
  
  public void e()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("param", 1);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().a("cmd.sendheart", localBundle);
    }
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     blyb
 * JD-Core Version:    0.7.0.1
 */