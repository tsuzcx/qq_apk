import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.business.base.appreport.AppReportReceiver;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi.1;
import com.tencent.open.downloadnew.MyAppApi.13;
import com.tencent.open.downloadnew.MyAppApi.14;
import com.tencent.open.downloadnew.MyAppApi.17;
import com.tencent.open.downloadnew.MyAppApi.18;
import com.tencent.open.downloadnew.MyAppApi.19;
import com.tencent.open.downloadnew.MyAppApi.3;
import com.tencent.open.downloadnew.MyAppApi.4;
import com.tencent.open.downloadnew.MyAppApi.5;
import com.tencent.open.downloadnew.MyAppApi.7;
import com.tencent.open.downloadnew.MyAppApi.8;
import com.tencent.open.downloadnew.MyAppApi.9;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bjxd
{
  protected static bjxd a;
  private final int a;
  protected long a;
  protected DialogInterface.OnClickListener a;
  public bjxo a;
  protected bjxq a;
  public bjxr a;
  protected ITMAssistantCallBackListener a;
  public TMAssistantCallYYBParamStruct a;
  protected TMAssistantBaseCallYYB a;
  public String a;
  protected boolean a;
  protected long b;
  TMAssistantCallYYBParamStruct b;
  protected boolean b;
  protected final long c = 180000L;
  protected boolean c;
  public long d;
  boolean d;
  public boolean e;
  private boolean f;
  private boolean g;
  
  protected bjxd()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener = new bjxp(this);
    this.jdField_b_of_type_Long = -1L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 7090000;
    try
    {
      a();
      d();
      i();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bjtx.c("MyAppApi", "MyAppApi init>>>", localThrowable);
      }
    }
  }
  
  private static Uri a(OuterCallReportModel paramOuterCallReportModel)
  {
    return Uri.parse("tmast://sdk_wake?jump_code=" + bjvf.a(bjjo.a().a(), null).a("Common_jump_code") + "&outerCallTime=" + paramOuterCallReportModel.mOuterCallTime + "&outerCallType=" + paramOuterCallReportModel.mOuterCallType + "&outerCallMode=" + paramOuterCallReportModel.mOuterCallMode + "&hostpname=com.tencent.mobileqq&hostversion=" + GlobalUtil.getAppVersionCode(bjjo.a().a()));
  }
  
  public static bjxd a()
  {
    try
    {
      if (jdField_a_of_type_Bjxd == null) {
        jdField_a_of_type_Bjxd = new bjxd();
      }
      c();
      bjxd localbjxd = jdField_a_of_type_Bjxd;
      return localbjxd;
    }
    finally {}
  }
  
  public static int b()
  {
    return TMAssistantCallYYB_V2.getQQDownloadApiLevel(BaseApplicationImpl.getApplication());
  }
  
  @NonNull
  private static OuterCallReportModel b()
  {
    OuterCallReportModel localOuterCallReportModel = OuterCallReportModel.getDefaultModel();
    localOuterCallReportModel.mOuterCallMode = 0;
    localOuterCallReportModel.mOuterCallType = 1;
    localOuterCallReportModel.mOuterCallTime = System.currentTimeMillis();
    localOuterCallReportModel.mComponentName = "SplashActivity";
    return localOuterCallReportModel;
  }
  
  public static void c()
  {
    ThreadManager.executeOnSubThread(new MyAppApi.1());
  }
  
  private static void c(OuterCallReportModel paramOuterCallReportModel)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setPackage("com.tencent.android.qqdownloader");
    localIntent.setData(a(paramOuterCallReportModel));
    localIntent.addFlags(32768);
    if (!(bjjo.a().a() instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    try
    {
      bjjo.a().a().startActivity(localIntent);
      return;
    }
    catch (SecurityException paramOuterCallReportModel)
    {
      paramOuterCallReportModel.printStackTrace();
      return;
    }
    catch (ActivityNotFoundException paramOuterCallReportModel)
    {
      bjtx.e("TAMST_WAKE", "activity not found error:" + paramOuterCallReportModel.getMessage());
    }
  }
  
  private static void d(OuterCallReportModel paramOuterCallReportModel)
  {
    GlobalUtil.getInstance().setContext(bjjo.a().a());
    SDKReportManager2.getInstance().postReport(15, paramOuterCallReportModel.toString());
  }
  
  /* Error */
  public static boolean d()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 142	bjxd:jdField_a_of_type_Bjxd	Lbjxd;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localbjxd	bjxd
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  private void i()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    bjjo.a().a().registerReceiver(new AppReportReceiver(), localIntentFilter);
  }
  
  private static boolean i()
  {
    return (bjwj.i()) && (TMAssistantCallYYB_V1.getQQDownloadApiLevel(bjjo.a().a()) >= 7);
  }
  
  public int a()
  {
    int i = TMAssistantCallYYB_V1.getQQDownloadApiLevel(bjjo.a().a());
    if (!arta.a("com.tencent.android.qqdownloader", BaseActivity.sTopActivity)) {
      i = 3;
    }
    return i;
  }
  
  public int a(Bundle paramBundle)
  {
    int j = 1;
    int i = j;
    if (paramBundle != null)
    {
      i = j;
      if (paramBundle.getInt(bjwo.k) == 3) {
        i = 2;
      }
    }
    return i;
  }
  
  public long a(Bundle paramBundle)
  {
    try
    {
      bjtx.c("MyAppApi", "--addDownloadTaskFromTmast--params = " + paramBundle);
      if (paramBundle == null) {
        return -1L;
      }
      paramBundle.getString("url");
      long l = a().addDownloadTaskFromTmast(paramBundle);
      return l;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return -1L;
  }
  
  protected long a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    bjtx.c("MyAppApi", "--addDownloadTaskFromTaskList--params = " + paramBundle + "autoDownload = " + paramBoolean1);
    if (paramBundle == null) {
      return -1L;
    }
    paramBundle = a(paramBundle);
    this.jdField_b_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = paramBundle;
    return a().addDownloadTaskFromTaskList(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public DownloadInfo a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, Bundle paramBundle)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_Int = 1;
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramTMAssistantCallYYBParamStruct.SNGAppId;
    localDownloadInfo.j = paramTMAssistantCallYYBParamStruct.taskAppId;
    localDownloadInfo.e = paramTMAssistantCallYYBParamStruct.taskPackageName;
    localDownloadInfo.k = paramTMAssistantCallYYBParamStruct.taskApkId;
    localDownloadInfo.jdField_b_of_type_Int = paramTMAssistantCallYYBParamStruct.taskVersion;
    localDownloadInfo.q = paramTMAssistantCallYYBParamStruct.recommendId;
    localDownloadInfo.s = paramTMAssistantCallYYBParamStruct.channelId;
    if (paramBundle != null)
    {
      localDownloadInfo.jdField_h_of_type_JavaLangString = paramBundle.getString(bjwo.i);
      localDownloadInfo.f = paramBundle.getString(bjwo.l);
      localDownloadInfo.jdField_d_of_type_JavaLangString = paramBundle.getString(bjwo.j);
      localDownloadInfo.jdField_d_of_type_Int = paramBundle.getInt(bjwo.E);
    }
    return localDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!b())) {
      return null;
    }
    paramBundle = a(paramBundle);
    if (a() <= 2)
    {
      paramBundle = ((TMAssistantCallYYB_V1)a()).getDownloadTaskState(paramBundle);
      if (paramBundle != null) {
        return new TMAssistantDownloadTaskInfo(paramBundle.mUrl, paramBundle.mSavePath, paramBundle.mState, paramBundle.mReceiveDataLen, paramBundle.mTotalDataLen, paramBundle.mContentType);
      }
      return null;
    }
    paramBundle = ((TMAssistantCallYYB_V2)a()).getDownloadTaskState(paramBundle);
    if (paramBundle != null) {
      return new TMAssistantDownloadTaskInfo(paramBundle.mUrl, paramBundle.mSavePath, paramBundle.mState, paramBundle.mReceiveDataLen, paramBundle.mTotalDataLen, paramBundle.mContentType);
    }
    return null;
  }
  
  protected TMAssistantCallYYBParamStruct a(Bundle paramBundle)
  {
    String str3 = paramBundle.getString(bjwo.b);
    String str4 = paramBundle.getString(bjwo.jdField_c_of_type_JavaLangString);
    String str5 = paramBundle.getString(bjwo.jdField_d_of_type_JavaLangString);
    String str6 = paramBundle.getString(bjwo.f);
    Object localObject = paramBundle.getString(bjwo.i);
    int j = paramBundle.getInt(bjwo.e);
    int i = j;
    if (j == 0) {}
    try
    {
      i = Integer.valueOf(paramBundle.getString(bjwo.e)).intValue();
      String str2;
      String str1;
      if (this.jdField_a_of_type_Boolean)
      {
        str2 = bjvg.a((String)localObject, "NEWYYB");
        paramBundle.getString(bjwo.z);
        localObject = paramBundle.getString(bjwo.B);
        j = paramBundle.getInt(bjwo.A);
        if (j != 1) {
          break label418;
        }
        localObject = "ANDROIDQQ-gray";
        str1 = "1";
      }
      for (;;)
      {
        bjtx.b("State_Log", " channelId:" + (String)localObject);
        localObject = new TMAssistantCallYYBParamStruct(str3, str4, str5, i, str2, str6, "", "", (String)localObject, str1);
        if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(bjjo.a().a()) >= 6)
        {
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_JS_DoDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_JS_DoDownloadAction", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_DownloadApi_DoDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_DownloadApi_DoDownloadAction", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_DownloadApi_DoDownloadActionByMyApp", Long.valueOf(paramBundle.getLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_MyAppApi_HandleDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_HandleDownloadAction", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_MyAppApi_StartToAppDetail", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_StartToAppDetail", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_MyAppApi_StartToDownloadList", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_StartToDownloadList", 0L)));
        }
        ((TMAssistantCallYYBParamStruct)localObject).source = paramBundle.getString("big_brother_source_key");
        ((TMAssistantCallYYBParamStruct)localObject).recommendId = paramBundle.getString("recommendId");
        bjtx.b("MyAppApi", "recommendId:" + ((TMAssistantCallYYBParamStruct)localObject).recommendId);
        return localObject;
        str2 = bjvg.a((String)localObject, "YYB");
        break;
        label418:
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = "ANDROIDQQ";
          str1 = j + "";
        }
        else
        {
          str1 = j + "";
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public TMAssistantBaseCallYYB a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB == null) {
        a();
      }
      TMAssistantBaseCallYYB localTMAssistantBaseCallYYB = this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB;
      return localTMAssistantBaseCallYYB;
    }
    finally {}
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_Bjxo != null) && (this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle != null)) {
      return this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle.getString(bjwo.b);
    }
    return "";
  }
  
  public void a()
  {
    if (a() <= 2) {}
    for (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V1.getInstance();; this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V2.getInstance())
    {
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.initTMAssistantCallYYBApi(bjjo.a().a());
      g();
      return;
    }
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new MyAppApi.3(this, paramActivity));
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString(bjwo.p);
    int i = paramBundle.getInt("dialogType");
    int j = paramBundle.getInt("auto_start_yyb_download");
    bjtx.c("TIME-STATISTIC", "MyAppApi--showTipDialog");
    bjtx.c("MyAppApi", "-showTipDialog-");
    if (paramActivity == null) {
      return;
    }
    Resources localResources = paramActivity.getResources();
    Object localObject;
    if (paramInt2 == 1) {
      if (paramInt1 == 2)
      {
        paramInt1 = 1;
        if (!TextUtils.isEmpty(str)) {
          break label463;
        }
        localObject = bjwj.a(paramInt1, paramString2);
        label86:
        paramString2 = (String)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        switch (paramInt1)
        {
        default: 
          paramString2 = localResources.getString(2131691447);
          label138:
          if (((paramInt1 != 2) && (paramInt1 != 4)) || (!TextUtils.isEmpty(str))) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = String.format(paramString2, new Object[] { paramString1 });
        localObject = localResources.getString(2131691467);
        if ((paramInt2 == 1) && (i == 1))
        {
          paramString1 = localResources.getString(2131691468);
          paramString2 = localResources.getString(2131691451);
          localObject = new bjxr(paramActivity);
          ((bjxr)localObject).b(2131691462, paramOnClickListener2, true);
          if (!paramBoolean)
          {
            bool = true;
            ((bjxr)localObject).a(2131691465, paramOnClickListener1, bool);
            ((bjxr)localObject).a(paramString1);
            ((bjxr)localObject).b(paramString2);
            if (i == 1)
            {
              ((bjxr)localObject).b(2131691462, Color.parseColor("#D2D1D1"), paramOnClickListener2, true);
              paramInt1 = Color.parseColor("#3AC8FF");
              if (paramBoolean) {
                continue;
              }
              paramBoolean = true;
              ((bjxr)localObject).a(2131691465, paramInt1, paramOnClickListener1, paramBoolean);
              ((bjxr)localObject).a(paramActivity.getResources().getDrawable(2130841841));
              ((bjxr)localObject).a(Color.parseColor("#848484"));
            }
            ((bjxr)localObject).setCancelable(true);
            ((bjxr)localObject).setOnCancelListener(paramOnCancelListener);
            ((bjxr)localObject).setOnDismissListener(new bjxg(this));
            if ((!(paramActivity instanceof AppActivity)) || (((AppActivity)paramActivity).isResume())) {
              continue;
            }
            bjtx.c("TIME-STATISTIC", "MyAppApi--showTipDialog---cancel !isResume");
            return;
            if ((paramInt1 == 12) && (!TextUtils.isEmpty(paramString1)))
            {
              paramInt1 = 2;
              break;
            }
            paramInt1 = 1;
            break;
            if (paramInt1 == 2)
            {
              paramInt1 = 3;
              break;
            }
            if ((paramInt1 == 12) && (!TextUtils.isEmpty(paramString1)))
            {
              paramInt1 = 4;
              break;
            }
            paramInt1 = 3;
            break;
            label463:
            localObject = str;
            break label86;
            paramString2 = localResources.getString(2131691447);
            break label138;
            paramString2 = localResources.getString(2131691448, new Object[] { paramString1 });
            break label138;
            paramString2 = localResources.getString(2131691449);
            break label138;
            paramString2 = localResources.getString(2131691450, new Object[] { paramString1 });
          }
        }
      }
      catch (Exception paramString2)
      {
        if (paramInt1 == 2)
        {
          paramString1 = localResources.getString(2131691447);
          bjtx.c("MyAppApi", " errorMsg = " + paramString2.getMessage());
          continue;
        }
        paramString1 = localResources.getString(2131691449);
        continue;
        boolean bool = false;
        continue;
        paramBoolean = false;
        continue;
        try
        {
          if (!paramActivity.isFinishing())
          {
            ((bjxr)localObject).show();
            bdll.b(null, "dc00898", "", "", "0X8008F7A", "0X8008F7A", 0, 0, "", "", "", "");
            if (i == 1)
            {
              bjto.a("6006", "0", "0", paramBundle.getString(bjwo.i), paramBundle.getString("pageId") + "_" + paramBundle.getString("moduleId") + "_" + paramBundle.getString(bjwo.f) + "_" + paramBundle.getString(bjwo.jdField_c_of_type_JavaLangString) + "_" + paramBundle.getString(bjwo.jdField_d_of_type_JavaLangString));
              if (j == 1) {
                ThreadManager.getUIHandler().post(new MyAppApi.13(this, paramOnClickListener1, (bjxr)localObject));
              }
            }
          }
        }
        catch (Exception paramActivity)
        {
          paramActivity.printStackTrace();
          continue;
        }
        bjtx.c("TIME-STATISTIC", "MyAppApi--showTipDialog---complete");
        this.jdField_a_of_type_Bjxr = ((bjxr)localObject);
        return;
        paramString2 = paramString1;
        paramString1 = (String)localObject;
        continue;
      }
      paramString1 = paramString2;
    }
  }
  
  protected void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    boolean bool = bjwj.d();
    long l = bjjo.a().a();
    int i;
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long))
    {
      i = 1;
      if (i != 0) {
        break label115;
      }
      if (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct == null) {
        break label106;
      }
      if (a() > 2) {
        break label85;
      }
      ((TMAssistantCallYYB_V1)a()).startToAuthorized(paramActivity, this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
      label74:
      this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
    }
    label85:
    label106:
    label115:
    bjue localbjue;
    do
    {
      return;
      i = 0;
      break;
      ((TMAssistantCallYYB_V2)a()).startToAuthorized(paramActivity, this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
      break label74;
      bjtx.e("MyAppApi", "startToAuthorizedDirect mLastAuthorizeParam = null, needCarryQQIdentity = false");
      return;
      localbjue = new bjue();
      localbjue.a(new bjxh(this, localbjue, l, paramActivity, paramOnClickListener));
    } while (!(paramActivity instanceof BaseActivity));
    localbjue.a(((BaseActivity)paramActivity).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    bjtx.c("TIME-STATISTIC", "MyAppApi--handleDownloadAction");
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_HandleDownloadAction", System.currentTimeMillis());
    }
    int i = -1;
    try
    {
      j = a().checkQQDownloaderInstalled();
      i = j;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        boolean bool5;
        DownloadInfo localDownloadInfo;
        localException1.printStackTrace();
        continue;
        bool1 = false;
      }
      if (i == 2) {
        break label307;
      }
    }
    boolean bool2 = paramBundle.getBoolean(bjwo.g, false);
    boolean bool3 = paramBundle.getBoolean(bjwo.jdField_h_of_type_JavaLangString, true);
    int k = paramBundle.getInt(bjwo.n);
    int j = paramBundle.getInt(bjwo.k);
    String str3 = paramBundle.getString(bjwo.i);
    String str2 = paramBundle.getString(bjwo.b);
    int m = paramBundle.getInt("dialogType");
    int n = paramBundle.getInt(bjwo.t, 0);
    int i1 = paramBundle.getInt(bjwo.u, 0);
    boolean bool4 = bjwj.e();
    bool5 = bjwj.g();
    bjtx.c("OpenConfig-MyAppApi", " useMyAppFlag = " + bool4);
    localDownloadInfo = bjwq.a().a(str2);
    boolean bool1;
    if ((localDownloadInfo != null) && (localDownloadInfo.jdField_c_of_type_Int == 1))
    {
      bool1 = true;
      if (((bool4) && (bool5)) || (bool1)) {
        break label295;
      }
      if (paramOnClickListener != null)
      {
        bjtx.a("MyAppApi", "allowMyApp=" + bool4 + " allowMyAppDownload=" + bool5 + " taskExist=" + bool1);
        paramOnClickListener.onClick(null, 0);
      }
      bjvg.a("200", str3, str2);
    }
    for (;;)
    {
      return;
      label295:
      if (i == 1) {
        label307:
        if ((this.jdField_a_of_type_Bjxr != null) && (this.jdField_a_of_type_Bjxr.isShowing())) {
          if (this.jdField_a_of_type_Bjxr.a() == paramActivity)
          {
            bjtx.a("MyAppApi", "mTipDialog is showing return");
            return;
          }
        }
      }
      try
      {
        this.jdField_a_of_type_Bjxr.dismiss();
        label351:
        for (this.jdField_a_of_type_Bjxr = null; (!bjwj.f()) || ((j != 2) && (j != 12)); this.jdField_a_of_type_Bjxr = null)
        {
          bjtx.a("MyAppApi", "not allowShowDialog return actionCode = " + j);
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(null, 0);
          }
          bjvg.a("200", str3, str2);
          return;
        }
        ThreadManager.getSubThreadHandler().post(new MyAppApi.5(this, str3, str2));
        bool4 = bjwj.a();
        bjxk localbjxk = new bjxk(this, bool2, paramOnClickListener, paramBundle, k, bool4, paramActivity, str3, bool1, bool3, str2, m);
        bjxm localbjxm = new bjxm(this, paramOnClickListener, str3, str2);
        bjxl localbjxl = new bjxl(this, str3, str2);
        String str1 = null;
        Object localObject = str1;
        if (i1 > 0)
        {
          localObject = str1;
          if (n > 0)
          {
            k = i1 - n;
            localObject = str1;
            if (k > 0) {
              localObject = bjya.a(k);
            }
          }
        }
        str1 = paramBundle.getString("source");
        ThreadManager.getUIHandler().post(new MyAppApi.7(this, paramActivity, j, i, (String)localObject, localbjxk, localbjxm, localbjxl, str1, bool4, paramBundle));
        ThreadManager.getSubThreadHandler().post(new MyAppApi.8(this, str3, str2));
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
        return;
        if (i != 0) {
          continue;
        }
        if ((bjwj.h()) || (bool1))
        {
          paramOnClickListener = bjvg.a(str3, "YYB");
          if (k == 0) {
            a(paramActivity, paramBundle, bool2, bool3);
          }
          while ((localObject == null) && ((j == 2) || (j == 12)))
          {
            bjvg.a("202", paramOnClickListener, str2);
            return;
            a(paramActivity, paramBundle, bool2, bool3);
          }
          bjvg.a("200", paramOnClickListener, str2);
          return;
        }
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(null, 0);
        }
        bjvg.a("200", str3, str2);
        return;
      }
      catch (Exception localException2)
      {
        break label351;
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    bjtx.c("NewUpgradeDialog", "preDownload called,get updateDetail info");
    ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.18(this, paramActivity), 0L);
  }
  
  public void a(Activity paramActivity, String paramString, int paramInt)
  {
    bjtx.c("MyAppApi", "downloadYyb");
    if (paramInt == 1) {
      bjwk.a("_1101070898");
    }
    if (this.jdField_a_of_type_Bjxq == null)
    {
      this.jdField_a_of_type_Bjxq = new bjxq(this);
      bjwq.a().a(this.jdField_a_of_type_Bjxq);
    }
    Object localObject = bjwq.a().a("1101070898");
    bjtx.c("MyAppApi", "---startDownloadYYB---");
    if (localObject != null)
    {
      if (paramInt == 1)
      {
        ((DownloadInfo)localObject).jdField_a_of_type_Boolean = false;
        ((DownloadInfo)localObject).jdField_b_of_type_Boolean = true;
      }
      for (((DownloadInfo)localObject).jdField_h_of_type_Int = 1;; ((DownloadInfo)localObject).jdField_h_of_type_Int = 0)
      {
        ((DownloadInfo)localObject).jdField_h_of_type_JavaLangString = paramString;
        bjwq.a().e((DownloadInfo)localObject);
        bjwq.a().a((DownloadInfo)localObject);
        return;
        ((DownloadInfo)localObject).jdField_a_of_type_Boolean = true;
        ((DownloadInfo)localObject).jdField_b_of_type_Boolean = false;
      }
    }
    String str = bjwj.a();
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "https://a.app.qq.com/o/myapp-down?g_f=991310";
    }
    a(paramActivity, (String)localObject, paramString, paramInt, false);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!"biz_src_yyb".equals(paramString2))
    {
      long l2 = bjwj.a();
      l1 = l2;
      if (l2 > 0L) {}
    }
    for (long l1 = 2000L;; l1 = 0L)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.17(this, paramActivity, paramString1), l1);
      return;
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    bjtx.c("MyAppApi", "startDownloadYyb");
    Bundle localBundle = new Bundle();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "https://a.app.qq.com/o/myapp-down?g_f=991310";
    }
    localBundle.putString(bjwo.b, "1101070898");
    localBundle.putString(bjwo.j, str);
    localBundle.putString(bjwo.f, "com.tencent.android.qqdownloader");
    localBundle.putInt(bjwo.k, 2);
    localBundle.putString(bjwo.i, paramString2);
    localBundle.putString(bjwo.l, bjya.jdField_d_of_type_JavaLangString);
    if (paramInt == 1) {
      localBundle.putBoolean(bjwo.x, true);
    }
    for (;;)
    {
      localBundle.putInt(bjwo.C, paramInt);
      localBundle.putString(bjwo.m, "yyb");
      localBundle.putString(bjwo.jdField_c_of_type_JavaLangString, "5848");
      localBundle.putBoolean(bjwo.g, true);
      localBundle.putBoolean(bjwo.jdField_h_of_type_JavaLangString, paramBoolean);
      localBundle.putInt(bjwo.n, 1);
      bjwk.a(paramActivity, localBundle, "biz_src_yyb", null, 0);
      return;
      localBundle.putBoolean(bjwo.x, false);
    }
  }
  
  public void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.19(this, paramBoolean, paramActivity, paramString), 0L);
  }
  
  protected void a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    bjtx.c("TIME-STATISTIC", "MyAppApi--startToDownloadTaskList");
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramContext) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_StartToDownloadList", System.currentTimeMillis());
    }
    if ((paramBundle == null) || (paramContext == null)) {
      return;
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramBundle);
    boolean bool = bjwj.d();
    long l = bjjo.a().a();
    int i;
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long)) {
      i = 1;
    }
    Object localObject;
    label296:
    int j;
    while ((i == 0) || (paramContext == null) || (!(paramContext instanceof BaseActivity)))
    {
      localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
      bjwq.a().e((DownloadInfo)localObject);
      try
      {
        bjtx.a("State_Log", "OpenSDK startToDownloadTaskList param SNGAppId=" + localTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + localTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + localTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + localTMAssistantCallYYBParamStruct.taskPackageName + " version=" + localTMAssistantCallYYBParamStruct.taskVersion + " uin=" + localTMAssistantCallYYBParamStruct.uin + " via=" + localTMAssistantCallYYBParamStruct.via);
        bjtx.c("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
        if (a() > 2) {
          break label296;
        }
        ((TMAssistantCallYYB_V1)a()).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2);
        return;
      }
      catch (Exception paramContext)
      {
        bjtx.e("MyAppApi", "--startToDownloadTaskList--Exception = " + paramContext);
        return;
      }
      i = 0;
      continue;
      i = paramBundle.getInt(bjwo.k);
      j = a(paramBundle);
      if (i != 3) {
        break label400;
      }
      paramBoolean1 = false;
      paramBoolean2 = false;
    }
    label400:
    for (;;)
    {
      ((TMAssistantCallYYB_V2)a()).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, j);
      return;
      localObject = new bjue();
      ((bjue)localObject).a(new bjxf(this, (bjue)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
      if (!(paramContext instanceof BaseActivity)) {
        break;
      }
      ((bjue)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
      return;
    }
  }
  
  public void a(Context paramContext, JSONArray paramJSONArray, int paramInt, String paramString1, String paramString2)
  {
    int j = 2;
    if (paramJSONArray == null) {}
    int k;
    do
    {
      return;
      k = paramJSONArray.length();
    } while (k == 0);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < k)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = new TMAssistantCallYYBParamStruct();
        localTMAssistantCallYYBParamStruct.recommendId = localJSONObject.optString("recommendId");
        localTMAssistantCallYYBParamStruct.channelId = localJSONObject.optString(bjwo.K);
        localTMAssistantCallYYBParamStruct.taskPackageName = localJSONObject.optString(bjwo.f);
        localTMAssistantCallYYBParamStruct.taskVersion = localJSONObject.optInt(bjwo.e);
        localTMAssistantCallYYBParamStruct.via = localJSONObject.optString(bjwo.i);
        localTMAssistantCallYYBParamStruct.taskApkId = localJSONObject.optString(bjwo.jdField_d_of_type_JavaLangString);
        localTMAssistantCallYYBParamStruct.taskAppId = localJSONObject.optString(bjwo.jdField_c_of_type_JavaLangString);
        localTMAssistantCallYYBParamStruct.SNGAppId = localJSONObject.optString(bjwo.jdField_c_of_type_JavaLangString);
        if (TextUtils.isEmpty(localTMAssistantCallYYBParamStruct.SNGAppId)) {
          localTMAssistantCallYYBParamStruct.SNGAppId = localJSONObject.optString(bjwo.b);
        }
        if (TextUtils.isEmpty(localTMAssistantCallYYBParamStruct.via)) {
          localTMAssistantCallYYBParamStruct.via = paramString1;
        }
        localTMAssistantCallYYBParamStruct.source = paramString2;
        localArrayList.add(localTMAssistantCallYYBParamStruct);
      }
    }
    i = j;
    if (paramInt == 2) {
      i = 3;
    }
    ThreadManager.excute(new MyAppApi.9(this, paramContext, localArrayList, i, paramString1), 16, null, true);
  }
  
  protected void a(String paramString)
  {
    bjwq localbjwq = bjwq.a();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramString;
    localDownloadInfo.a(10);
    if (localDownloadInfo != null) {
      localbjwq.a(10, localDownloadInfo);
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new MyAppApi.14(this, paramString, paramOnClickListener, paramActivity));
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_JavaLangString = paramString;
    } while (!this.jdField_d_of_type_Boolean);
    SharedPreferences.Editor localEditor = bjjo.a().a().getSharedPreferences("showTost_pf", 0).edit();
    localEditor.putBoolean("showToast", this.jdField_d_of_type_Boolean);
    localEditor.putString("toast_msg", paramString);
    localEditor.commit();
  }
  
  protected boolean a()
  {
    return !TMAssistantCallYYB_V1.isExistActoin(this.jdField_a_of_type_Long);
  }
  
  public boolean a(Context paramContext, Bundle paramBundle)
  {
    bjtx.c("TIME-STATISTIC", "MyAppApi--startToWebView");
    if (paramBundle == null) {
      return false;
    }
    paramBundle = paramBundle.getString("url");
    bjtx.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
    a().startToWebView(paramContext, paramBundle);
    return true;
  }
  
  public boolean a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    bjtx.c("TIME-STATISTIC", "MyAppApi--startToAppDetail ");
    if (paramBundle == null) {
      return false;
    }
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramContext) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_StartToAppDetail", System.currentTimeMillis());
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramBundle);
    if (!bjwk.b(localTMAssistantCallYYBParamStruct.SNGAppId)) {
      return false;
    }
    boolean bool = bjwj.d();
    long l = bjjo.a().a();
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long)) {}
    for (int i = 1;; i = 0)
    {
      Object localObject;
      if ((i == 0) || (paramContext == null) || (!(paramContext instanceof BaseActivity)))
      {
        localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
        bjwq.a().e((DownloadInfo)localObject);
      }
      for (;;)
      {
        try
        {
          bjtx.a("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + localTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + localTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + localTMAssistantCallYYBParamStruct.taskAppId + " source=" + localTMAssistantCallYYBParamStruct.source + " packageName=" + localTMAssistantCallYYBParamStruct.taskPackageName + " version=" + localTMAssistantCallYYBParamStruct.taskVersion + " uin=" + localTMAssistantCallYYBParamStruct.uin + " via=" + localTMAssistantCallYYBParamStruct.via + " autoDownload=" + paramBoolean1 + " autoInstall=" + paramBoolean2);
          bjtx.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
          if (a() <= 2)
          {
            ((TMAssistantCallYYB_V1)a()).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2);
          }
          else
          {
            i = paramBundle.getInt(bjwo.k);
            int j = a(paramBundle);
            if (i == 3)
            {
              paramBoolean1 = false;
              paramBoolean2 = false;
              ((TMAssistantCallYYB_V2)a()).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, j);
            }
          }
        }
        catch (Exception paramContext)
        {
          bjtx.b("MyAppApi", "startToAppDetail err", paramContext);
          return false;
        }
        localObject = new bjue();
        ((bjue)localObject).a(new bjxe(this, (bjue)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
        if ((paramContext instanceof BaseActivity)) {
          ((bjue)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
        }
        return true;
      }
      return true;
    }
  }
  
  public long b(Bundle paramBundle)
  {
    try
    {
      bjtx.c("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + paramBundle);
      if (paramBundle == null) {
        return -1L;
      }
      String str = paramBundle.getString("url");
      if (!TextUtils.isEmpty(str))
      {
        if ((str.startsWith("tmast")) || (str.startsWith("tpmast"))) {
          return a().addDownloadTaskFromTmast(paramBundle);
        }
        long l = a().addDownloadTaskFromWebview(paramBundle);
        return l;
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return -1L;
  }
  
  protected long b(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    bjtx.c("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + paramBundle + "autoDownload = " + paramBoolean1);
    if (paramBundle == null) {
      return -1L;
    }
    paramBundle = a(paramBundle);
    this.jdField_b_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = paramBundle;
    return a().addDownloadTaskFromAppDetail(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V2.getInstance();
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.initTMAssistantCallYYBApi(bjjo.a().a());
    g();
  }
  
  public void b(Activity paramActivity)
  {
    long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    bjtx.c("MyAppApi", "judgeInstallFlag -- mInstalledFlag = " + this.jdField_a_of_type_Boolean + "mInstallTime = " + this.jdField_b_of_type_Long + " countTime =" + l);
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Long != -1L) && (l <= 180000L)) {
        break label337;
      }
      i = 1;
      if (!b()) {
        break label404;
      }
      if (a()) {
        break label342;
      }
      this.jdField_b_of_type_Boolean = false;
      label107:
      if ((!this.jdField_b_of_type_Boolean) && (i == 0))
      {
        if (this.jdField_a_of_type_Long != -1L) {
          a().removeDownloadTask(this.jdField_a_of_type_Long);
        }
        if (!bjwj.h()) {
          break label379;
        }
        if (this.jdField_a_of_type_Bjxo != null)
        {
          if (this.jdField_a_of_type_Bjxo.jdField_a_of_type_Int != 0) {
            break label350;
          }
          a(paramActivity, this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bjxo.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bjxo.jdField_b_of_type_Boolean);
        }
      }
    }
    for (;;)
    {
      e();
      if ((!this.jdField_d_of_type_Boolean) && (!b()))
      {
        paramActivity = bjjo.a().a().getSharedPreferences("showTost_pf", 0);
        this.jdField_d_of_type_Boolean = paramActivity.getBoolean("showToast", false);
        this.jdField_a_of_type_JavaLangString = paramActivity.getString("toast_msg", "");
      }
      if (this.jdField_d_of_type_Boolean)
      {
        if (!b()) {
          new Handler(Looper.getMainLooper()).postDelayed(new MyAppApi.4(this), 2000L);
        }
        this.jdField_d_of_type_Boolean = false;
        paramActivity = bjjo.a().a().getSharedPreferences("showTost_pf", 0).edit();
        paramActivity.putBoolean("showToast", this.jdField_d_of_type_Boolean);
        paramActivity.commit();
      }
      return;
      label337:
      i = 0;
      break;
      label342:
      this.jdField_b_of_type_Boolean = true;
      break label107;
      label350:
      a(paramActivity, this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bjxo.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bjxo.jdField_b_of_type_Boolean);
      continue;
      label379:
      if ((i != 0) || (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
        continue;
      }
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      continue;
      try
      {
        label404:
        if (new File(bjjo.a().a().getFilesDir() + File.separator + "yyb_via_info.txt").exists()) {
          bjjo.a().a().deleteFile("yyb_via_info.txt");
        }
        label464:
        if ((this.jdField_b_of_type_Boolean) || (i != 0)) {
          continue;
        }
        if (this.jdField_a_of_type_Long != -1L) {
          a().removeDownloadTask(this.jdField_a_of_type_Long);
        }
        if ((i != 0) || (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
          continue;
        }
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      catch (Exception paramActivity)
      {
        break label464;
      }
    }
  }
  
  public void b(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_HandleDownloadAction", System.currentTimeMillis());
    }
    int i = -1;
    try
    {
      j = a().checkQQDownloaderInstalled();
      i = j;
    }
    catch (Exception localException)
    {
      int j;
      boolean bool1;
      boolean bool2;
      int k;
      int m;
      String str2;
      DownloadInfo localDownloadInfo;
      for (;;)
      {
        boolean bool3;
        boolean bool4;
        String str1;
        localException.printStackTrace();
        continue;
        j = 0;
      }
      if ((i != 2) && (i != 1)) {
        break label244;
      }
      if (paramOnClickListener == null) {
        break label233;
      }
      paramOnClickListener.onClick(null, 0);
      bjvg.a("202", str2, localException);
      return;
      if ((!bjwj.h()) && (j == 0)) {
        break label331;
      }
      if (k != 0) {
        break label308;
      }
      a(paramActivity, paramBundle, bool1, bool2);
      for (;;)
      {
        paramActivity = bjvg.a(str2, "YYB");
        if ((localDownloadInfo != null) || ((m != 2) && (m != 12))) {
          break;
        }
        bjvg.a("202", paramActivity, localException);
        return;
        a(paramActivity, paramBundle, bool1, bool2);
      }
      bjvg.a("200", paramActivity, localException);
      return;
      if (paramOnClickListener == null) {
        break label343;
      }
      paramOnClickListener.onClick(null, 0);
      bjvg.a("200", str2, localException);
    }
    bool1 = paramBundle.getBoolean(bjwo.g, false);
    bool2 = paramBundle.getBoolean(bjwo.jdField_h_of_type_JavaLangString, true);
    k = paramBundle.getInt(bjwo.n);
    m = paramBundle.getInt(bjwo.k);
    bool3 = bjwj.e();
    bool4 = bjwj.g();
    str1 = paramBundle.getString(bjwo.b);
    str2 = paramBundle.getString(bjwo.i);
    localDownloadInfo = bjwq.a().a(str1);
    if ((localDownloadInfo != null) && (localDownloadInfo.jdField_c_of_type_Int == 1))
    {
      j = 1;
      bjtx.c("OpenConfig-MyAppApi", " useMyAppFlag = " + bool3);
      if (((bool3) && (bool4)) || (j != 0)) {
        break label209;
      }
      if (paramOnClickListener != null) {
        paramOnClickListener.onClick(null, 0);
      }
      bjvg.a("200", str2, str1);
    }
    label209:
    label233:
    label244:
    return;
  }
  
  public void b(String paramString, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity)
  {
    for (;;)
    {
      String str3;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        String str1 = localJSONObject.optString("appid", "");
        localJSONObject.optString("myAppid", "");
        localJSONObject.optString("apkId", "");
        Object localObject2 = localJSONObject.optString("versionCode", "");
        String str2 = localJSONObject.optString("via", "");
        localJSONObject.optString("appPackageName", "");
        str3 = localJSONObject.optString("appName", anzj.a(2131705939));
        localJSONObject.optString("channelId", "");
        Object localObject1 = localJSONObject.optString("appAuthorizedStr", "");
        Bundle localBundle = new Bundle();
        paramString = (String)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString = "1";
        }
        int i = Integer.parseInt(paramString);
        localBundle.putString(bjwo.b, localJSONObject.optString("appid", ""));
        localBundle.putString(bjwo.jdField_c_of_type_JavaLangString, localJSONObject.optString("myAppid", ""));
        localBundle.putString(bjwo.jdField_d_of_type_JavaLangString, localJSONObject.optString("apkId"));
        localBundle.putInt(bjwo.e, i);
        localBundle.putString(bjwo.f, localJSONObject.optString("appPackageName"));
        localBundle.putString(bjwo.i, localJSONObject.optString("via"));
        localBundle.putString(bjwo.l, localJSONObject.optString("appName"));
        localBundle.putString(bjwo.z, localJSONObject.optString("channelId"));
        localBundle.putString(bjwo.B, localJSONObject.optString("channel"));
        localBundle.putString(bjwo.v, localJSONObject.optString("uin"));
        this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = a(localBundle);
        this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct.actionFlag = "2";
        if (b())
        {
          a(paramActivity, paramOnClickListener);
          return;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramString = (String)localObject1;
          boolean bool = bjwj.a();
          localObject1 = new bjxi(this, localBundle, bool, paramActivity, str2, paramOnClickListener, str1);
          paramOnClickListener = new bjxm(this, paramOnClickListener, str2, str1);
          localObject2 = new bjxl(this, str2, str1);
          localBundle.putString(bjwo.p, paramString);
          a(paramActivity, 1, 1, "0", (DialogInterface.OnClickListener)localObject1, paramOnClickListener, (DialogInterface.OnCancelListener)localObject2, "biz_src_yyb", bool, localBundle);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = str3 + anzj.a(2131705936);
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    try
    {
      int i = a().checkQQDownloaderInstalled();
      if ((i == 2) || (i == 1)) {
        bool = false;
      }
      return bool;
    }
    catch (Exception localException)
    {
      bjtx.c("MyAppApi", "hasValidQQDownloader>>>", localException);
    }
    return false;
  }
  
  public boolean b(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return false;
    }
    bjtx.c("TIME-STATISTIC", "mDownloadSdk.startToDownloadListWithParams");
    a().startToDownloadTaskListWithParams(paramContext, paramBundle);
    return true;
  }
  
  public void c(Activity paramActivity)
  {
    new bjyb(paramActivity, null).execute(new Void[0]);
  }
  
  public boolean c()
  {
    return (b()) && (bjwj.e()) && (bjwj.h());
  }
  
  protected void d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    bjxj localbjxj = new bjxj(this);
    bjjo.a().a().registerReceiver(localbjxj, localIntentFilter);
  }
  
  public void d(Activity paramActivity)
  {
    if ((this.e) && (this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null))
    {
      if ((!a()) && (a().b()))
      {
        if (this.jdField_a_of_type_Long != -1L) {
          a().removeDownloadTask(this.jdField_a_of_type_Long);
        }
        a(paramActivity, null);
      }
      this.e = false;
      e();
      return;
    }
    this.e = false;
    this.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
    e();
  }
  
  protected void e()
  {
    bjtx.c("MyAppApi", "clearInstallParam");
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
    this.jdField_a_of_type_Bjxo = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct = null;
  }
  
  public boolean e()
  {
    return a() > 2;
  }
  
  public void f()
  {
    this.jdField_d_of_type_Long = 0L;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  protected void g()
  {
    a().registerListener(this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener);
  }
  
  public boolean g()
  {
    boolean bool2 = false;
    Object localObject = BaseActivity.sTopActivity.getPackageManager();
    boolean bool1 = bool2;
    if (localObject != null) {}
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0);
      bool1 = bool2;
      if (localObject != null)
      {
        int i = ((PackageInfo)localObject).versionCode;
        bool1 = bool2;
        if (i >= 7090000) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return false;
  }
  
  public void h()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.unregisterListener(this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener);
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.destroyQQDownloaderOpenSDK();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          jdField_a_of_type_Bjxd = null;
          return;
        }
        finally {}
        localException = localException;
        bjtx.a("MyAppApi", "onDestroy>>>", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxd
 * JD-Core Version:    0.7.0.1
 */