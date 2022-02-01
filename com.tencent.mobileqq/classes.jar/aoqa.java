import android.app.Activity;
import android.media.AudioManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkViewModelBase.TimeRecord;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo.TimeRecord;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.10;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.11;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.12;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.13;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.14;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.15;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.16;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.17;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.18;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.20;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.21;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.24;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.26;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.4;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.5;
import com.tencent.mobileqq.ark.API.ArkAppQQModule.9;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqa
  extends aopk
{
  private static long jdField_b_of_type_Long;
  private static long jdField_c_of_type_Long;
  protected afwc a;
  private WeakReference<QQCustomDialog> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, String> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public aoqa(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    this.jdField_a_of_type_Afwc = new afwc(this.jdField_a_of_type_JavaLangString, 30000L);
  }
  
  private static int a(ark.VariantWrapper[] paramArrayOfVariantWrapper, long paramLong)
  {
    int i = 2;
    int k = 0;
    if (paramLong >= 2L)
    {
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1];
      String[] arrayOfString;
      int j;
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.GetType() == 5) && (paramArrayOfVariantWrapper.GetString() != null))
      {
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.GetString().toLowerCase();
        arrayOfString = new String[8];
        arrayOfString[0] = "d";
        arrayOfString[1] = "debug";
        arrayOfString[2] = "i";
        arrayOfString[3] = "info";
        arrayOfString[4] = "e";
        arrayOfString[5] = "error";
        arrayOfString[6] = "w";
        arrayOfString[7] = "warning";
        if (!arrayOfString[0].equals(paramArrayOfVariantWrapper))
        {
          j = i;
          if (!arrayOfString[1].equals(paramArrayOfVariantWrapper)) {}
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label204;
          }
          j = 0;
          k = 1;
        }
      }
      for (;;)
      {
        int m = i;
        if (k == 0)
        {
          m = i;
          if (j == 0) {
            m = 1;
          }
        }
        return m;
        do
        {
          j += 1;
          if (j >= arrayOfString.length) {
            break;
          }
        } while (!arrayOfString[j].equals(paramArrayOfVariantWrapper));
        j = 1;
        i = 1;
        continue;
        return 1;
        i = 4;
        j = 0;
        continue;
        label204:
        i = 4;
        j = 0;
        k = 1;
      }
    }
    return 4;
  }
  
  private static String a(ark.VariantWrapper[] paramArrayOfVariantWrapper)
  {
    if (paramArrayOfVariantWrapper.length >= 3)
    {
      if ((paramArrayOfVariantWrapper[2].IsArray()) || (paramArrayOfVariantWrapper[2].IsTable())) {
        return paramArrayOfVariantWrapper[2].GetTableAsJsonString();
      }
      return "";
    }
    return "";
  }
  
  private void a()
  {
    if (!ArkAppCenter.e()) {
      return;
    }
    ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.24(this));
  }
  
  private void a(long paramLong, String paramString)
  {
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null)
    {
      QLog.e("ArkApp.ArkAppQQModule", 1, "Callback is null");
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppQQModule", 2, "doCallbackForGetPskeyAsync : SetString");
      }
      localVariantWrapper2.SetString(paramString);
    }
    for (;;)
    {
      paramString = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString);
      paramString.Reset();
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppQQModule", 2, "doCallbackForGetPskeyAsync : SetNull");
      }
      localVariantWrapper2.SetNull();
    }
  }
  
  private void a(long paramLong, String paramString, int paramInt)
  {
    paramString = a(paramLong);
    if (paramString == null)
    {
      QLog.e("ArkApp.ArkAppQQModule", 1, "GetUserInformation.arkGetUserInformation call back is null");
      return;
    }
    ark.VariantWrapper localVariantWrapper = paramString.Create();
    localVariantWrapper.SetNull();
    if (1 == paramInt)
    {
      localObject = aori.c(null);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localVariantWrapper.SetTableAsJsonString((String)localObject);
      }
    }
    Object localObject = paramString.Create();
    paramString.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper }, (ark.VariantWrapper)localObject);
    ((ark.VariantWrapper)localObject).Reset();
    localVariantWrapper.Reset();
    paramString.Reset();
  }
  
  private void a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt)
  {
    if (1 != paramInt)
    {
      QLog.i("ArkApp.ArkAppQQModule", 1, "arkLoginGetOpenKey, no auth");
      a(null, null, paramLong1);
      return;
    }
    paramString = this.jdField_a_of_type_JavaLangString + "_" + paramLong3 + "_" + paramString;
    if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString)) && (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilHashMap.get(paramString))) && (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramString)) && (!TextUtils.isEmpty((CharSequence)this.jdField_c_of_type_JavaUtilHashMap.get(paramString))))
    {
      String str = String.valueOf(paramLong3);
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsValue(str))) {
        this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaLangString, str);
      }
      a((String)this.jdField_b_of_type_JavaUtilHashMap.get(paramString), (String)this.jdField_c_of_type_JavaUtilHashMap.get(paramString), paramLong1);
      return;
    }
    aori.a(paramLong2, paramLong3, new aoqg(this, paramLong1));
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    ArkDispatchTask.getInstance().post(this.jdField_a_of_type_JavaLangString, new ArkAppQQModule.26(this, paramLong, paramString1, paramString2));
  }
  
  public void Destruct()
  {
    if (this.jdField_a_of_type_Afwc != null) {
      this.jdField_a_of_type_Afwc.a();
    }
    super.Destruct();
  }
  
  public String GetTypeName()
  {
    return "QQ";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (super.HasMenthod(paramString)) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while ((paramString.equals("OpenUrl")) || (paramString.equals("NavigateTo")) || (paramString.equals("OpenVideo")) || (paramString.equals("GetVersion")) || (paramString.equals("GetPerformance")) || (paramString.equals("Login")) || (paramString.equals("GetUserInformation")) || (paramString.equals("OpenView")) || (paramString.equals("CloseView")) || (paramString.equals("ShareView")) || (paramString.equals("ShowStatusBar")) || (paramString.equals("HideStatusBar")) || (paramString.equals("SetNavigationBarTitle")) || (paramString.equals("ShowShareMenu")) || (paramString.equals("HideShareMenu")) || (paramString.equals("PreviewImage")) || (paramString.equals("SetTalkBackText")) || (paramString.equals("ChooseImage")) || (paramString.equals("GetAppInfo")));
        if (this.jdField_a_of_type_Long != 0L) {
          break;
        }
      } while ((paramString.equals("GetPskeyAsync")) || (paramString.equals("GetNickName")) || (paramString.equals("Report")) || (paramString.equals("ReportEx")) || (paramString.equals("Log")) || (paramString.equals("GetContainerInfo")) || (paramString.equals("DataRequest")) || (paramString.equals("GetCurrentPosition")) || (paramString.equals("WatchPosition")) || (paramString.equals("ClearWatch")) || (paramString.equals("GetCurrentAddress")) || (paramString.equals("SendMessage")));
      if (paramString.equals("TestGetJson")) {
        return false;
      }
    } while ((paramString.equals("Notify")) || (paramString.equals("GetAppID")) || (paramString.equals("GetAudioOutputMode")) || (paramString.equals("IsMute")) || (paramString.equals("GetNickNameByView")) || (paramString.equals("SubscribePublicAccount")));
    return false;
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (super.Invoke(paramString, paramArrayOfVariantWrapper, paramVariantWrapper)) {
      return true;
    }
    if (!a(paramString)) {
      return false;
    }
    bgjk.a(a(), paramString);
    if (paramString.equals("NavigateTo"))
    {
      paramString = a();
      if ((paramString != null) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1)) {
        aorg.a(paramString, paramArrayOfVariantWrapper[0].GetString(), true, 0L, null, null, 3, this.jdField_a_of_type_JavaLangString, null);
      }
      return true;
    }
    Activity localActivity;
    long l1;
    Object localObject1;
    Object localObject5;
    if (paramString.equals("OpenUrl"))
    {
      paramVariantWrapper.SetBool(false);
      localActivity = a();
      if (localActivity == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppQQModule", "open url, no activity found");
        return true;
      }
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        if (!TextUtils.isEmpty(paramString))
        {
          if (paramArrayOfVariantWrapper.length <= 1) {
            break label7674;
          }
          if (!paramArrayOfVariantWrapper[1].IsView()) {
            break label561;
          }
          l1 = paramArrayOfVariantWrapper[1].GetView();
          localObject1 = null;
          localObject5 = null;
        }
      }
    }
    label189:
    Object localObject4;
    MessageForArkApp localMessageForArkApp;
    try
    {
      if (paramArrayOfVariantWrapper.length <= 2) {
        break label7669;
      }
      paramArrayOfVariantWrapper = new JSONObject(paramArrayOfVariantWrapper[2].GetTableAsJsonString());
      localObject5 = paramArrayOfVariantWrapper;
    }
    catch (JSONException paramArrayOfVariantWrapper)
    {
      for (;;)
      {
        Object localObject2;
        int k;
        boolean bool2;
        continue;
        paramArrayOfVariantWrapper = null;
        continue;
        paramArrayOfVariantWrapper = null;
        continue;
        localObject1 = paramString;
        continue;
        long l2 = 0L;
        continue;
        boolean bool1 = false;
        continue;
        paramString = null;
        continue;
        bool1 = true;
        continue;
        paramArrayOfVariantWrapper = null;
        continue;
        paramString = null;
        continue;
        paramString = null;
      }
    }
    Object localObject3 = null;
    if (localObject5 != null)
    {
      localObject2 = ((JSONObject)localObject5).optString("businessId", "biz_src_jc_ark");
      label213:
      paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject3;
      if (!(localActivity instanceof FragmentActivity)) {
        break label7660;
      }
      localObject4 = (FragmentActivity)localActivity;
      paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject3;
      if (((FragmentActivity)localObject4).getChatFragment() == null) {
        break label7660;
      }
      localObject3 = ((FragmentActivity)localObject4).getChatFragment().a();
      paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject3;
      if (!(localObject3 instanceof ahiu)) {
        break label7660;
      }
      paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject3;
      if (!"biz_src_ads".equals(localObject2)) {
        break label7660;
      }
      localObject4 = ugf.b(((BaseChatPie)localObject3).sessionInfo.curFriendUin);
      QLog.d("ArkApp.ArkAppQQModule", 1, "ArkSafe.OpenUrl set hsSourceID for " + ((BaseChatPie)localObject3).sessionInfo.curFriendUin + ", input " + (String)localObject2 + ", output " + (String)localObject4);
      label345:
      if (l1 == 0L) {
        break label7654;
      }
      paramArrayOfVariantWrapper = ark.arkGetContainer(l1);
      if (paramArrayOfVariantWrapper == null) {
        break label7654;
      }
      paramArrayOfVariantWrapper = (afvi)afvi.a(paramArrayOfVariantWrapper).get();
      if ((paramArrayOfVariantWrapper == null) || (!(paramArrayOfVariantWrapper instanceof afvh))) {
        break label7654;
      }
      localMessageForArkApp = (MessageForArkApp)((afvh)paramArrayOfVariantWrapper).jdField_a_of_type_JavaLangRefWeakReference.get();
      label399:
      if (!aoqp.a(paramString, (String)localObject1, (JSONObject)localObject5, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString)) {
        break label592;
      }
      aovl.a(null, this.jdField_a_of_type_JavaLangString, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
      paramVariantWrapper.SetBool(true);
      if (!MiniAppLauncher.isMiniAppUrl(paramString))
      {
        paramArrayOfVariantWrapper = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          paramArrayOfVariantWrapper = paramString;
          if (!paramString.startsWith("miniapp")) {}
        }
      }
      else
      {
        paramArrayOfVariantWrapper = paramString;
        if (localMessageForArkApp != null)
        {
          l1 = obg.a(localMessageForArkApp.ark_app_message.getAppIdFromMeta(), 0L);
          if (l1 != 0L) {
            break label583;
          }
          paramArrayOfVariantWrapper = "";
          label503:
          bcef.b(null, "dc00898", "", "", "0X800A86C", "0X800A86C", 0, 0, paramArrayOfVariantWrapper, "", "", "");
          paramArrayOfVariantWrapper = paramString;
        }
      }
    }
    label561:
    label583:
    label592:
    int j;
    int i;
    for (;;)
    {
      Log.d("ark.OpenUrl ", paramArrayOfVariantWrapper);
      aovl.a(null, this.jdField_a_of_type_JavaLangString, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
      return true;
      localObject1 = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
      l1 = 0L;
      break;
      localObject2 = "biz_src_jc_ark";
      break label213;
      paramArrayOfVariantWrapper = String.valueOf(l1);
      break label503;
      boolean bool3;
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        if (!aonw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.BROWSER"))
        {
          QLog.d("ArkApp.ArkAppQQModule", 1, "ArkSafe.OpenUrl ModuleCheckPermission invalid!");
          return false;
        }
        paramArrayOfVariantWrapper = ArkAppConfigMgr.getInstance().getUrlChecker(this.jdField_a_of_type_JavaLangString);
        j = 1;
        if (paramArrayOfVariantWrapper != null)
        {
          k = paramArrayOfVariantWrapper.checkUrlIsValidByAppNavigationList(paramString);
          if (k != 0) {
            break label921;
          }
          i = 1;
          bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(this.jdField_a_of_type_JavaLangString);
          bool3 = ArkAppCenterUtil.isPublicAccount();
          if ((!bool2) || (bool3)) {
            break label927;
          }
        }
        label921:
        label927:
        for (bool1 = true;; bool1 = false)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkAppQQModule", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.appname=", this.jdField_a_of_type_JavaLangString, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
          }
          if (i != 0) {
            break label7644;
          }
          if (bool1) {
            break label7634;
          }
          QLog.e("ArkApp.ArkAppQQModule", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.http appName=", this.jdField_a_of_type_JavaLangString, ",url=", npn.b(paramString, new String[0]), ", isValid set=true" });
          j = 1;
          i = 2;
          label843:
          a();
          label847:
          aoys.b(this.jdField_a_of_type_JavaLangString, paramString, k, i, afvi.c);
          aovl.b(a(), this.jdField_a_of_type_JavaLangString, paramString, 2);
          if (j != 0) {
            break label933;
          }
          QLog.d("ArkApp.ArkAppQQModule", 1, new Object[] { "ArkSafe.OpenUrl check url invalid!, url=", npn.b(paramString, new String[0]), ", app=", this.jdField_a_of_type_JavaLangString });
          return false;
          i = 0;
          break;
        }
        label933:
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label7631;
        }
        for (;;)
        {
          try
          {
            localObject5 = new JSONObject((String)localObject1);
            Iterator localIterator = ((JSONObject)localObject5).keys();
            paramArrayOfVariantWrapper = new String();
            i = 0;
            label970:
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              paramVariantWrapper = null;
              if ((((JSONObject)localObject5).get(str) instanceof String))
              {
                paramVariantWrapper = ((JSONObject)localObject5).getString(str);
                if (TextUtils.isEmpty(paramVariantWrapper)) {
                  break label7628;
                }
                localObject1 = paramArrayOfVariantWrapper;
                if (i != 0) {
                  localObject1 = paramArrayOfVariantWrapper + "&";
                }
                paramArrayOfVariantWrapper = (String)localObject1 + str + "=" + paramVariantWrapper;
                i = 1;
                break label7683;
              }
              if (!(((JSONObject)localObject5).get(str) instanceof Number)) {
                continue;
              }
              paramVariantWrapper = ((Number)((JSONObject)localObject5).get(str)).toString();
              continue;
            }
            paramVariantWrapper = paramString;
            if (!TextUtils.isEmpty(paramArrayOfVariantWrapper))
            {
              if (paramString.indexOf("?", 0) != -1) {
                continue;
              }
              paramVariantWrapper = paramString + paramArrayOfVariantWrapper;
            }
            paramString = paramVariantWrapper;
          }
          catch (JSONException paramArrayOfVariantWrapper)
          {
            label1161:
            continue;
            aovl.a(null, this.jdField_a_of_type_JavaLangString, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
            continue;
            paramArrayOfVariantWrapper = String.valueOf(l1);
            continue;
            aorg.a(localActivity, paramString, true, 0L, null, (String)localObject2, 0, this.jdField_a_of_type_JavaLangString, (String)localObject4);
            continue;
          }
          if (!(localObject3 instanceof ahiu)) {
            continue;
          }
          ((ahiu)localObject3).a.b();
          if ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null)) {
            continue;
          }
          l1 = obg.a(localMessageForArkApp.ark_app_message.getAppIdFromMeta(), 0L);
          aorg.a(localActivity, paramString, true, l1, localMessageForArkApp, (String)localObject2, 0, this.jdField_a_of_type_JavaLangString, (String)localObject4);
          localMessageForArkApp.reportClick();
          if (localMessageForArkApp.buildTypeAndTitle().isSdkShare)
          {
            if (l1 != 0L) {
              continue;
            }
            paramArrayOfVariantWrapper = "";
            bcef.b(null, "dc00898", "", "", "0X800A869", "0X800A869", 0, 0, paramArrayOfVariantWrapper, "", "", "");
          }
          paramArrayOfVariantWrapper = paramString;
          break;
          paramVariantWrapper = paramString + "&" + paramArrayOfVariantWrapper;
        }
      }
      paramArrayOfVariantWrapper = paramString;
      if (this.jdField_a_of_type_Long == 0L)
      {
        paramVariantWrapper = bfwg.a(a(), localActivity, paramString);
        paramArrayOfVariantWrapper = paramString;
        if (paramVariantWrapper != null)
        {
          paramArrayOfVariantWrapper = ArkAppConfigMgr.getInstance().getUrlChecker(this.jdField_a_of_type_JavaLangString);
          i = 1;
          if (paramArrayOfVariantWrapper != null)
          {
            k = paramArrayOfVariantWrapper.checkUrlIsValidByAppNavigationList(paramString);
            j = 0;
            if (k != 0) {
              break label1633;
            }
            i = 1;
            label1434:
            bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(this.jdField_a_of_type_JavaLangString);
            bool3 = ArkAppCenterUtil.isPublicAccount();
            if ((!bool2) || (bool3)) {
              break label1639;
            }
          }
          label1633:
          label1639:
          for (bool1 = true;; bool1 = false)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ArkApp.ArkAppQQModule", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.JumpAction=", this.jdField_a_of_type_JavaLangString, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
            }
            if (i != 0) {
              break label7625;
            }
            j = 1;
            if (bool1) {
              break label7625;
            }
            QLog.e("ArkApp.ArkAppQQModule", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.jump appName=", this.jdField_a_of_type_JavaLangString, ",url=", npn.b(paramString, new String[0]), ", isValid set=true" });
            i = 1;
            j = 2;
            aoys.b(this.jdField_a_of_type_JavaLangString, paramString, k, j, afvi.c);
            if (i == 0) {
              break label1645;
            }
            paramVariantWrapper.a();
            paramArrayOfVariantWrapper = paramString;
            break;
            i = 0;
            break label1434;
          }
          label1645:
          QLog.e("ArkApp.ArkAppQQModule", 1, new Object[] { "ArkSafe.OpenUrl check url invalid, url=", npn.b(paramString, new String[0]), ", app=", this.jdField_a_of_type_JavaLangString });
          paramArrayOfVariantWrapper = paramString;
        }
      }
    }
    if (paramString.equals("OpenVideo"))
    {
      l1 = System.currentTimeMillis();
      if ((l1 - jdField_b_of_type_Long < 1000L) && (l1 > jdField_b_of_type_Long))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAppQQModule", 2, "click too offen,please try again later ");
        }
        return true;
      }
      jdField_b_of_type_Long = l1;
      paramVariantWrapper.SetBool(false);
      paramString = a();
      if (((paramString instanceof FragmentActivity)) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
        if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {}
      }
      try
      {
        localObject1 = new URL(paramArrayOfVariantWrapper).getProtocol();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).equalsIgnoreCase("http")) || (((String)localObject1).equalsIgnoreCase("https"))))
        {
          if ((this.jdField_a_of_type_ComTencentArkArk$Application != null) && (!this.jdField_a_of_type_ComTencentArkArk$Application.CheckUrlLegality(paramArrayOfVariantWrapper))) {
            return false;
          }
          paramVariantWrapper.SetBool(true);
          aorg.a(paramString, paramArrayOfVariantWrapper);
          aovl.a(a(), this.jdField_a_of_type_JavaLangString, "AIOArkOpenVideo", 1, 0, 0L, 0L, 0L, paramArrayOfVariantWrapper, "");
        }
        return true;
      }
      catch (MalformedURLException paramString)
      {
        ArkAppCenter.c("ArkApp.ArkAppQQModule", "url parse error and msg= " + paramString.getMessage());
        return false;
      }
    }
    if (paramString.equals("Report"))
    {
      paramString = a();
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 3))
      {
        paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
        i = (int)Math.round(paramArrayOfVariantWrapper[1].GetDouble());
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[2].GetString();
        if (!TextUtils.isEmpty(paramArrayOfVariantWrapper))
        {
          l1 = NetConnInfoCenter.getServerTime();
          if (TextUtils.isEmpty(paramVariantWrapper)) {
            break label2069;
          }
        }
      }
      for (;;)
      {
        try
        {
          Long.parseLong(paramVariantWrapper);
          bcef.b(paramString, "CliOper", "", "", "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), paramVariantWrapper, paramArrayOfVariantWrapper, "");
          aovl.a(paramString, this.jdField_a_of_type_JavaLangString, paramArrayOfVariantWrapper, i);
          return true;
        }
        catch (Exception paramVariantWrapper)
        {
          bcef.b(paramString, "CliOper", "", "", "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), "0", paramArrayOfVariantWrapper, "");
          continue;
        }
        label2069:
        bcef.b(paramString, "CliOper", "", "", "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), "0", paramArrayOfVariantWrapper, "");
      }
    }
    if (paramString.equals("ReportEx"))
    {
      if (paramArrayOfVariantWrapper.length > 0)
      {
        paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
        if (paramArrayOfVariantWrapper.length <= 1) {
          break label2167;
        }
      }
      label2167:
      for (paramString = paramArrayOfVariantWrapper[1].GetTableAsJsonString();; paramString = null)
      {
        if ((!TextUtils.isEmpty(paramVariantWrapper)) && (!TextUtils.isEmpty(paramString))) {
          break label2172;
        }
        ArkAppCenter.c("ArkApp.ArkAppQQModule", "QQ.ReportEx, invalid arguments");
        return false;
        paramVariantWrapper = null;
        break;
      }
      label2172:
      if (paramVariantWrapper.equals("898")) {
        try
        {
          localObject3 = new JSONObject(paramString);
          paramArrayOfVariantWrapper = ((JSONObject)localObject3).getString("type");
          paramVariantWrapper = ((JSONObject)localObject3).getString("name");
          localObject1 = ((JSONObject)localObject3).optString("targetUin", "");
          i = ((JSONObject)localObject3).optInt("entry", 0);
          j = ((JSONObject)localObject3).optInt("count", 1);
          k = ((JSONObject)localObject3).optInt("result", 0);
          int m = ((JSONObject)localObject3).optInt("r1", 0);
          int n = ((JSONObject)localObject3).optInt("r2", 0);
          localObject2 = ((JSONObject)localObject3).optString("r3", "");
          localObject3 = ((JSONObject)localObject3).optString("r4", "");
          bcef.b(null, "dc00898", "", (String)localObject1, paramArrayOfVariantWrapper, paramVariantWrapper, i, j, k, Integer.toString(m), Integer.toString(n), (String)localObject2, (String)localObject3);
          return true;
        }
        catch (JSONException paramArrayOfVariantWrapper)
        {
          ArkAppCenter.c("ArkApp.ArkAppQQModule", "QQ.ReportEx, invalid report data, data=" + paramString);
          return false;
        }
      }
      return false;
    }
    if (paramString.equals("GetVersion"))
    {
      paramArrayOfVariantWrapper = DeviceInfoUtil.getQQVersion();
      paramString = paramArrayOfVariantWrapper;
      if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
        paramString = "8.4.8";
      }
      paramVariantWrapper.SetString(paramString);
      return true;
    }
    if (paramString.equals("Log"))
    {
      if (paramArrayOfVariantWrapper != null) {}
      for (l1 = paramArrayOfVariantWrapper.length; l1 <= 0L; l1 = 0L) {
        return true;
      }
      paramString = paramArrayOfVariantWrapper[0];
      i = paramString.GetType();
      j = a(paramArrayOfVariantWrapper, l1);
      if (i == 0) {
        QLog.i("ArkApp.QQLog", j, "none");
      }
      for (;;)
      {
        return true;
        if (i == 1)
        {
          QLog.i("ArkApp.QQLog", j, "null");
        }
        else
        {
          if (i == 2)
          {
            if (paramString.GetBool()) {}
            for (paramString = "true";; paramString = "false")
            {
              QLog.i("ArkApp.QQLog", j, paramString);
              break;
            }
          }
          if (i == 3) {
            QLog.i("ArkApp.QQLog", j, Integer.toString(paramString.GetInt()));
          } else if (i == 4) {
            QLog.i("ArkApp.QQLog", j, Double.toString(paramString.GetDouble()));
          } else if (i == 5) {
            QLog.i("ArkApp.QQLog", j, paramString.GetString());
          } else if (paramString.IsFunction()) {
            QLog.i("ArkApp.QQLog", j, "Function Object");
          } else if (paramString.IsUserObject()) {
            QLog.i("ArkApp.QQLog", j, "User Object");
          } else if ((paramString.IsArray()) || (paramString.IsTable())) {
            QLog.i("ArkApp.QQLog", j, paramString.GetTableAsJsonString());
          } else {
            QLog.i("ArkApp.QQLog", j, "Unknown Object");
          }
        }
      }
    }
    if (paramString.equals("GetNickName"))
    {
      localObject2 = a();
      if (paramArrayOfVariantWrapper != null)
      {
        l1 = paramArrayOfVariantWrapper.length;
        if (l1 != 1L) {
          break label2824;
        }
      }
      for (paramString = paramArrayOfVariantWrapper[0].GetString();; paramString = ((QQAppInterface)localObject2).getCurrentAccountUin())
      {
        if (localObject2 == null) {
          break label2845;
        }
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = null;
          if (!TextUtils.isEmpty(afvi.jdField_a_of_type_JavaLangString)) {
            localObject1 = ContactUtils.getTroopMemberName((QQAppInterface)localObject2, afvi.jdField_a_of_type_JavaLangString, paramString);
          }
          if (localObject1 != null)
          {
            paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
            if (!TextUtils.equals((CharSequence)localObject1, paramString)) {}
          }
          else
          {
            localObject1 = ContactUtils.getDateNickName((QQAppInterface)localObject2, paramString);
            paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramArrayOfVariantWrapper = ContactUtils.getNick((QQAppInterface)localObject2, paramString, 0);
            }
          }
          paramVariantWrapper.SetString(paramArrayOfVariantWrapper);
          if (paramArrayOfVariantWrapper != null) {
            Log.d("ark.GetNickName ", paramArrayOfVariantWrapper);
          }
        }
        return true;
        l1 = 0L;
        break;
        label2824:
        if ((l1 != 0L) || (localObject2 == null)) {
          break label7620;
        }
      }
      label2845:
      paramString = aori.a(paramString);
      QLog.i("ArkApp.ArkAppQQModule", 1, "QQ.GetNickname, ipc call, nickname=" + paramString);
      paramVariantWrapper.SetString(paramString);
      return true;
    }
    if (paramString.equals("GetContainerInfo"))
    {
      localObject1 = new HashMap();
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
      {
        l1 = paramArrayOfVariantWrapper[0].GetView();
        if (l1 == 0L) {
          break label7615;
        }
        paramString = ark.arkGetContainer(l1);
        if (paramString == null) {
          break label7615;
        }
        paramString = (afvi)afvi.a(paramString).get();
        if ((paramString == null) || (!(paramString instanceof afvh))) {
          break label7610;
        }
        paramArrayOfVariantWrapper = ((afvh)paramString).a();
        paramString = paramArrayOfVariantWrapper;
        if (paramArrayOfVariantWrapper == null) {
          paramString = a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "multiAio.ArkAppModuleReg GetContainerInfo Extra ViewID viewHandle=", Long.valueOf(l1), a(paramString) });
        }
        if (paramString != null)
        {
          ((HashMap)localObject1).put("ChatUIN", paramString.curFriendUin);
          paramArrayOfVariantWrapper = String.format("%d", new Object[] { Integer.valueOf(-1) });
          switch (paramString.curType)
          {
          default: 
            paramString = paramArrayOfVariantWrapper;
          }
        }
      }
      for (;;)
      {
        ((HashMap)localObject1).put("ChatType", paramString);
        paramVariantWrapper.SetMap((Map)localObject1);
        return true;
        paramString = a();
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "multiAio.ArkAppModuleReg GetContainerInfo, ", a(paramString) });
        }
        break;
        paramString = String.format("%d", new Object[] { Integer.valueOf(1) });
        continue;
        paramString = String.format("%d", new Object[] { Integer.valueOf(2) });
        continue;
        if (!TextUtils.isEmpty(paramString.curFriendUin)) {
          if (!nmy.a().a(paramString.curFriendUin)) {
            break label3277;
          }
        }
        label3277:
        for (paramString = "1";; paramString = "0")
        {
          ((HashMap)localObject1).put("AnonymousStatus", paramString);
          paramString = String.format("%d", new Object[] { Integer.valueOf(3) });
          break;
        }
        paramString = String.format("%d", new Object[] { Integer.valueOf(4) });
        continue;
        paramString = String.format("%d", new Object[] { Integer.valueOf(5) });
        continue;
        paramString = String.format("%d", new Object[] { Integer.valueOf(6) });
      }
    }
    else
    {
      if (paramString.equals("DataRequest"))
      {
        paramVariantWrapper.CreateObject("DataRequest", new afww(a(), this.jdField_a_of_type_JavaLangString));
        return true;
      }
      if (paramString.equals("GetPerformance"))
      {
        if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1)) {}
        for (;;)
        {
          paramVariantWrapper.SetNull();
          return true;
          paramString = paramArrayOfVariantWrapper[0].GetString();
          if (!TextUtils.isEmpty(paramString))
          {
            paramArrayOfVariantWrapper = afvh.a(paramString);
            if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.arkContainer == null))
            {
              ArkAppCenter.c("ArkApp.ArkAppQQModule", String.format("QQ.GetPerformance, arkAppMsg is null, viewID=%s", new Object[] { paramString }));
            }
            else
            {
              paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.arkContainer.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord;
              if (paramArrayOfVariantWrapper != null) {
                break;
              }
              ArkAppCenter.c("ArkApp.ArkAppQQModule", String.format("QQ.GetPerformance, timeRecord is null, viewID=%s", new Object[] { paramString }));
            }
          }
        }
        paramString = null;
        for (;;)
        {
          try
          {
            localObject1 = new JSONObject();
            localObject2 = new JSONObject();
            ((JSONObject)localObject1).put("Timing", localObject2);
            ((JSONObject)localObject2).put("GetApplicationStart", 0.01D + paramArrayOfVariantWrapper.beginOfGetApp);
            ((JSONObject)localObject2).put("GetApplicationEnd", 0.01D + paramArrayOfVariantWrapper.endOfGetApp);
            ((JSONObject)localObject2).put("FetchApplicationStart", 0.01D + paramArrayOfVariantWrapper.beginOfGetApp);
            ((JSONObject)localObject2).put("FetchApplicationEnd", 0.01D + paramArrayOfVariantWrapper.endOfGetApp);
            ((JSONObject)localObject2).put("CreateViewStart", 0.01D + paramArrayOfVariantWrapper.mRecord.beginOfCreateView);
            ((JSONObject)localObject2).put("CreateViewEnd", 0.01D + paramArrayOfVariantWrapper.mRecord.endOfCreateView);
            ((JSONObject)localObject2).put("DisplayViewStart", 0.01D + paramArrayOfVariantWrapper.mRecord.beginOfDisplyView);
            ((JSONObject)localObject2).put("DisplayViewEnd", 0.01D + paramArrayOfVariantWrapper.mRecord.endOfDisplyView);
            localObject2 = new JSONObject();
            ((JSONObject)localObject1).put("Navigation", localObject2);
            if (!paramArrayOfVariantWrapper.getAppFromLocal) {
              continue;
            }
            i = 1;
            ((JSONObject)localObject2).put("FetchApplicationFromCache", i);
            paramArrayOfVariantWrapper = ((JSONObject)localObject1).toString();
            paramString = paramArrayOfVariantWrapper;
          }
          catch (Exception paramArrayOfVariantWrapper)
          {
            ArkAppCenter.c("ArkApp.ArkAppQQModule", String.format("QQ.GetPerformance, json exception, msg=%s", new Object[] { paramArrayOfVariantWrapper.getMessage() }));
            continue;
          }
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          paramVariantWrapper.SetTableAsJsonString(paramString);
          return true;
          i = 0;
        }
      }
      if (paramString.equals("GetCurrentPosition"))
      {
        if ((this.jdField_a_of_type_Afwc == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp.ArkAppQQModule", 2, String.format("GetCurrentPosition.app.%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
        }
        l1 = a(paramArrayOfVariantWrapper[0].Copy());
        this.jdField_a_of_type_Afwc.b(new aoqb(this, l1));
        return true;
      }
      if (paramString.equals("WatchPosition"))
      {
        if ((this.jdField_a_of_type_Afwc == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp.ArkAppQQModule", 2, String.format("WatchPosition.app.%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
        }
        l1 = a(paramArrayOfVariantWrapper[0].Copy());
        this.jdField_a_of_type_Afwc.a(new aoqd(this, l1));
        return true;
      }
      if (paramString.equals("ClearWatch"))
      {
        if (this.jdField_a_of_type_Afwc == null) {
          return false;
        }
        this.jdField_a_of_type_Afwc.b();
        return true;
      }
      if (paramString.equals("GetCurrentAddress"))
      {
        if ((this.jdField_a_of_type_Afwc == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
          return false;
        }
        l1 = a(paramArrayOfVariantWrapper[0].Copy());
        this.jdField_a_of_type_Afwc.a(new aoqh(this, l1), true);
        return true;
      }
      if (paramString.equals("SendMessage"))
      {
        if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || ((!paramArrayOfVariantWrapper[0].IsArray()) && (!paramArrayOfVariantWrapper[0].IsTable()))) {
          return false;
        }
        localObject1 = paramArrayOfVariantWrapper[0].GetTableAsJsonString();
        label4292:
        do
        {
          try
          {
            paramVariantWrapper = new JSONObject((String)localObject1);
            if ((paramArrayOfVariantWrapper.length <= 1) || (paramArrayOfVariantWrapper[1].GetType() != 2)) {
              break label7604;
            }
            bool1 = paramArrayOfVariantWrapper[1].GetBool();
            if ((paramArrayOfVariantWrapper.length >= 3) && (paramArrayOfVariantWrapper[2].IsView()))
            {
              l1 = paramArrayOfVariantWrapper[2].GetView();
              if (l1 == 0L) {
                break;
              }
              paramString = ark.arkGetContainer(l1);
              if (paramString == null) {
                break;
              }
              paramString = (afvi)afvi.a(paramString).get();
              if ((paramString == null) || (!(paramString instanceof afvh))) {
                break;
              }
              paramArrayOfVariantWrapper = ((afvh)paramString).a();
              paramString = paramArrayOfVariantWrapper;
              if (paramArrayOfVariantWrapper == null) {
                paramString = a();
              }
              if (!QLog.isColorLevel()) {
                break label7686;
              }
              QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "multiAio.ArkAppModuleReg SendMessage Extra viewid viewHandle=", Long.valueOf(l1), a(paramString) });
              break label7686;
              if (!paramVariantWrapper.has("light")) {
                continue;
              }
              localObject2 = new ArkAppMessage();
              ((ArkAppMessage)localObject2).appMinVersion = "0.0.0.1";
              paramArrayOfVariantWrapper = paramVariantWrapper.getJSONObject("light");
              ((ArkAppMessage)localObject2).appName = paramArrayOfVariantWrapper.getString("Application");
              if (TextUtils.isEmpty(((ArkAppMessage)localObject2).appName)) {
                return false;
              }
            }
            else
            {
              paramString = a();
              if (!QLog.isColorLevel()) {
                break label7689;
              }
              QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "multiAio.ArkAppModuleReg SendMessage old,sessionInfo=", a(paramString) });
              break label7689;
            }
            ((ArkAppMessage)localObject2).appView = paramArrayOfVariantWrapper.getString("View");
            if (TextUtils.isEmpty(((ArkAppMessage)localObject2).appView)) {
              return false;
            }
            paramVariantWrapper = ArkAppCacheMgr.getApplicationFromManifest(((ArkAppMessage)localObject2).appName, ((ArkAppMessage)localObject2).appMinVersion);
            if (paramVariantWrapper != null)
            {
              ((ArkAppMessage)localObject2).appDesc = ((String)paramVariantWrapper.get("desc"));
              ((ArkAppMessage)localObject2).appMinVersion = ((String)paramVariantWrapper.get("version"));
            }
            if (TextUtils.isEmpty(((ArkAppMessage)localObject2).appDesc)) {
              ((ArkAppMessage)localObject2).appDesc = ((ArkAppMessage)localObject2).appName;
            }
            ((ArkAppMessage)localObject2).promptText = paramArrayOfVariantWrapper.optString("Prompt");
            if (TextUtils.isEmpty(((ArkAppMessage)localObject2).promptText)) {
              ((ArkAppMessage)localObject2).promptText = String.format(amtj.a(2131699792), new Object[] { ((ArkAppMessage)localObject2).appDesc });
            }
            ((ArkAppMessage)localObject2).metaList = paramArrayOfVariantWrapper.getJSONObject("MetaData").toString();
            paramVariantWrapper = paramArrayOfVariantWrapper.optJSONObject("Config");
            paramArrayOfVariantWrapper = paramVariantWrapper;
            if (paramVariantWrapper == null) {
              paramArrayOfVariantWrapper = new JSONObject();
            }
            paramArrayOfVariantWrapper.put("forward", 1);
            ((ArkAppMessage)localObject2).config = paramArrayOfVariantWrapper.toString();
            if (bool1)
            {
              if (paramString != null)
              {
                acvv.b(a(), paramString, (ArkAppMessage)localObject2);
                if (QLog.isColorLevel()) {
                  QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage light currentChat success");
                }
              }
            }
            else {
              ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.4(this, (ArkAppMessage)localObject2));
            }
          }
          catch (JSONException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage parameter error: " + paramString.getMessage());
            }
            if (QLog.isColorLevel()) {
              QLog.i("ArkApp", 1, String.format("multiAio.QQ.SendMessage fail, packet:%s", new Object[] { localObject1 }));
            }
            return false;
          }
        } while (!paramVariantWrapper.has("text"));
        paramVariantWrapper = paramVariantWrapper.getString("text");
        if (bool1)
        {
          paramArrayOfVariantWrapper = a();
          if ((paramString == null) || (paramArrayOfVariantWrapper == null)) {
            break label7694;
          }
          paramString = bbli.a(a(), a().getCurrentUin(), paramString.curFriendUin, paramString.troopUin, paramString.curType, (byte)1, (byte)0, (short)0, paramVariantWrapper);
          paramArrayOfVariantWrapper.getMessageFacade().addAndSendMessage(paramString, null);
          if (!QLog.isColorLevel()) {
            break label7694;
          }
          QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage text currentChat success");
          break label7694;
        }
        ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.5(this, paramVariantWrapper));
        break label7694;
      }
      else
      {
        if (paramString.equals("GetPskeyAsync"))
        {
          if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[1].IsFunction()))
          {
            QLog.e("ArkApp.ArkAppQQModule", 1, "GetPskeyAsync.param error");
            return false;
          }
          aori.a(paramArrayOfVariantWrapper[0].GetString(), new aoqi(this, a(paramArrayOfVariantWrapper[1].Copy())));
          return true;
        }
        if (paramString.equals("Login"))
        {
          if (!aonw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.LOGIN"))
          {
            QLog.e("ArkApp.ArkAppQQModule", 1, "Login.permission not allow");
            return false;
          }
          if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[1].IsFunction()))
          {
            QLog.e("ArkApp.ArkAppQQModule", 1, "Login.param error");
            return false;
          }
          for (;;)
          {
            try
            {
              l1 = Long.parseLong(paramArrayOfVariantWrapper[0].GetString());
              paramString = a();
              if (paramString == null)
              {
                paramString = null;
                l2 = a(paramArrayOfVariantWrapper[1].Copy());
                aopl.a(paramString, this.jdField_a_of_type_JavaLangString, "ark_authority_api_login", BaseApplicationImpl.getContext().getString(2131690116), new aoqj(this, l2, paramString, l1));
                return true;
              }
            }
            catch (NumberFormatException paramString)
            {
              QLog.e("ArkApp.ArkAppQQModule", 1, "Login.Exception:" + paramString.getMessage());
              return false;
            }
            paramString = paramString.getCurrentAccountUin();
          }
        }
        if (paramString.equals("GetUserInformation"))
        {
          if (!aonw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.USER_INFORMATION"))
          {
            QLog.e("ArkApp.ArkAppQQModule", 1, "GetUserInformation.permission not allow");
            return false;
          }
          if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsFunction()))
          {
            QLog.e("ArkApp.ArkAppQQModule", 1, "GetUserInformation.param error");
            return false;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            QLog.e("ArkApp.ArkAppQQModule", 1, "GetUserInformation.error app is null, app=" + this.jdField_a_of_type_JavaLangString);
            return false;
          }
          l1 = a(paramArrayOfVariantWrapper[0].Copy());
          paramString = a();
          if (paramString != null) {}
          for (paramString = paramString.getCurrentUin();; paramString = null)
          {
            aopl.a(paramString, this.jdField_a_of_type_JavaLangString, "ark_authority_api_user_info", BaseApplicationImpl.getContext().getString(2131690117), new aoqk(this, l1, paramString));
            return true;
          }
        }
        if (paramString.equals("TestGetJson")) {
          return paramVariantWrapper.SetTableAsJsonString("{ \"ret\":0, \"msg\":\"ok\", \"data\":{ \"param_array\": [ 3.1400000000000001, true, \"hello\", { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, { }, 1 ], \"param_bool_false\": false, \"param_bool_true\": true, \"param_double\": 3.1400000000000001, \"param_int\": 0, \"param_int2\": -1, \"param_int3\": 1001, \"param_str_empty\": \"\", \"param_str_hello\": \"hello\", \"param_table\": { \"param1\": 0, \"param2\": 3.1400000000000001, \"param3\": true, \"param4\": \"hello\", \"param5\": { }, \"param6\": { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, \"param7\": \"\" } }}");
        }
        if (paramString.equals("OpenView"))
        {
          if (!aonw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.OPENVIEW")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 4) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()) && (paramArrayOfVariantWrapper[2].IsString()) && ((paramArrayOfVariantWrapper[3].IsArray()) || (paramArrayOfVariantWrapper[3].IsTable())))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            paramString = paramArrayOfVariantWrapper[1].GetString();
            paramVariantWrapper = paramArrayOfVariantWrapper[2].GetString();
            paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[3].GetTableAsJsonString();
            QLog.d("ArkOpenView", 1, "OpenView holder=" + l1 + ", type=" + paramString + ", view=" + paramVariantWrapper + ", meta=" + paramArrayOfVariantWrapper);
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.9(this, paramString, paramVariantWrapper, paramArrayOfVariantWrapper, l1));
          }
          return true;
        }
        if (paramString.equals("CloseView"))
        {
          if (!aonw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.OPENVIEW")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.10(this, l1));
          }
          return true;
        }
        if (paramString.equals("ShareView"))
        {
          if (!aonw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.SHARE")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && ((paramArrayOfVariantWrapper[1].IsArray()) || (paramArrayOfVariantWrapper[1].IsTable())))
          {
            paramString = paramArrayOfVariantWrapper[0].GetString();
            paramVariantWrapper = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
            paramArrayOfVariantWrapper = a(paramArrayOfVariantWrapper);
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.11(this, paramString, paramVariantWrapper, paramArrayOfVariantWrapper));
          }
          return true;
        }
        if (paramString.equals("ShowStatusBar"))
        {
          if (!aonw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.STATUSBAR")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            paramString = paramArrayOfVariantWrapper[1].GetString();
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.12(this, l1, paramString));
          }
          return true;
        }
        if (paramString.equals("HideStatusBar"))
        {
          if (!aonw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.STATUSBAR")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.13(this, l1));
          }
          return true;
        }
        if (paramString.equals("SetNavigationBarTitle"))
        {
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            paramString = paramArrayOfVariantWrapper[1].GetString();
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.14(this, l1, paramString));
          }
          return true;
        }
        if (paramString.equals("ShowShareMenu"))
        {
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.15(this, l1));
          }
          return true;
        }
        if (paramString.equals("HideShareMenu"))
        {
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.16(this, l1));
          }
          return true;
        }
        if (paramString.equals("PreviewImage")) {
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && ((paramArrayOfVariantWrapper[0].IsArray()) || (paramArrayOfVariantWrapper[0].IsTable())) && (paramArrayOfVariantWrapper[1].GetType() == 4))
          {
            paramString = paramArrayOfVariantWrapper[0].GetTableAsJsonString();
            localObject1 = new ArrayList();
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONArray(paramString);
        i = 0;
        if (i < ((JSONArray)localObject2).length())
        {
          paramVariantWrapper = ((JSONArray)localObject2).optString(i);
          if (TextUtils.isEmpty(paramVariantWrapper)) {
            break label7696;
          }
          paramString = paramVariantWrapper;
          if (!paramVariantWrapper.startsWith("http://"))
          {
            paramString = paramVariantWrapper;
            if (!paramVariantWrapper.startsWith("https://"))
            {
              paramString = this.jdField_a_of_type_ComTencentArkArk$Application.GetSystemPathFromLocal(paramVariantWrapper);
              if (TextUtils.isEmpty(paramString)) {
                break label7696;
              }
            }
          }
          ((ArrayList)localObject1).add(paramString);
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp", 1, "QQ.PreviewImage parameter error: " + paramString.getMessage());
        }
        return true;
      }
      i = (int)Math.round(paramArrayOfVariantWrapper[1].GetDouble());
      ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.17(this, i, (ArrayList)localObject1));
      return true;
      if (paramString.equals("Notify"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 3)) {
          paramVariantWrapper.SetBool(ArkAppNotifyCenter.notify(paramArrayOfVariantWrapper[0].GetString(), paramArrayOfVariantWrapper[1].GetString(), paramArrayOfVariantWrapper[2].GetTableAsJsonString()));
        }
        return true;
      }
      if (paramString.equals("SetTalkBackText"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && (paramArrayOfVariantWrapper[1].IsView()))
        {
          paramString = paramArrayOfVariantWrapper[0].GetString();
          l1 = paramArrayOfVariantWrapper[1].GetView();
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.18(this, l1, paramString));
        }
        return true;
      }
      if (paramString.equals("ChooseImage"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 3))
        {
          l1 = a(paramArrayOfVariantWrapper[2].Copy());
          paramVariantWrapper = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
          QLog.i("ArkApp", 1, "QQ.ChooseImage :num=" + paramArrayOfVariantWrapper[0].GetDouble() + " extraInfo=" + paramVariantWrapper);
          paramString = "";
          if (this.jdField_a_of_type_ComTencentArkArk$Application != null) {
            paramString = this.jdField_a_of_type_ComTencentArkArk$Application.GetEngineResPath();
          }
          j = (int)paramArrayOfVariantWrapper[0].GetDouble();
          i = j;
          if (j <= 1) {
            i = 1;
          }
          j = i;
          if (i > 9) {
            j = 9;
          }
          bool1 = false;
        }
        try
        {
          if (!TextUtils.isEmpty(paramVariantWrapper)) {
            bool1 = new JSONObject(paramVariantWrapper).optBoolean("compress");
          }
          aoxw.a().a(new aoqc(this, l1));
          ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.20(this, j, bool1, paramString));
          return true;
        }
        catch (JSONException paramString)
        {
          QLog.e("ArkApp.ArkAppQQModule", 1, "Error:", paramString);
          return false;
        }
      }
      if (paramString.equals("GetAppID"))
      {
        paramVariantWrapper.SetString(String.valueOf(AppSetting.a()));
        return true;
      }
      if (paramString.equals("GetAudioOutputMode"))
      {
        i = aori.a();
        QLog.i("ArkApp.ArkAppQQModule", 1, "current audio status:" + i);
        paramVariantWrapper.SetInt(i);
        return true;
      }
      if (paramString.equals("IsMute"))
      {
        if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 1))
        {
          bool1 = paramArrayOfVariantWrapper[0].GetBool();
          paramString = (AudioManager)BaseApplicationImpl.sApplication.getSystemService("audio");
          if (paramString != null) {
            for (;;)
            {
              try
              {
                i = paramString.getStreamVolume(3);
                if (i <= 0)
                {
                  bool2 = true;
                  if ((bool2) && (bool1))
                  {
                    l1 = System.currentTimeMillis();
                    if ((Math.abs(l1 - jdField_c_of_type_Long) >= 120000L) || (l1 <= jdField_c_of_type_Long)) {
                      break label6797;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.e("ArkApp.ArkAppQQModule", 2, "IsMute() do not show toast so frequently in 2 min");
                    }
                  }
                  paramVariantWrapper.SetBool(bool2);
                  return true;
                }
              }
              catch (Exception paramString)
              {
                QLog.e("ArkApp.ArkAppQQModule", 1, "IsMute() error:", paramString);
                return false;
              }
              bool2 = false;
              continue;
              label6797:
              if (QLog.isColorLevel()) {
                QLog.e("ArkApp.ArkAppQQModule", 2, "IsMute() show toast");
              }
              jdField_c_of_type_Long = l1;
              localObject1 = apvq.b(380).a();
              paramArrayOfVariantWrapper = "";
              paramString = paramArrayOfVariantWrapper;
              if (localObject1 != null)
              {
                paramString = paramArrayOfVariantWrapper;
                if (((apvp)localObject1).a() != null) {
                  paramString = ((apvp)localObject1).a().b;
                }
              }
              localObject1 = a();
              paramArrayOfVariantWrapper = paramString;
              if (TextUtils.isEmpty(paramString))
              {
                paramArrayOfVariantWrapper = paramString;
                if (localObject1 != null) {
                  paramArrayOfVariantWrapper = ((Activity)localObject1).getString(2131690155);
                }
              }
              ArkDispatchTask.getInstance().postToMainThread(new ArkAppQQModule.21(this, (Activity)localObject1, paramArrayOfVariantWrapper));
            }
          }
          return false;
        }
      }
      else if (paramString.equals("GetNickNameByView"))
      {
        if (paramArrayOfVariantWrapper != null) {}
        for (l1 = paramArrayOfVariantWrapper.length; l1 <= 0L; l1 = 0L)
        {
          QLog.d("ArkApp.ArkAppQQModule", 1, "ark.GetNickNameByView invalid param args == 0 ");
          return false;
        }
        localObject1 = null;
        if ((l1 < 1L) || (!paramArrayOfVariantWrapper[0].IsView())) {
          break label7587;
        }
        l2 = paramArrayOfVariantWrapper[0].GetView();
        paramString = (String)localObject1;
        if (l1 >= 2L)
        {
          paramString = (String)localObject1;
          if (paramArrayOfVariantWrapper[1].IsString()) {
            paramString = paramArrayOfVariantWrapper[1].GetString();
          }
        }
        localObject2 = a();
        if (localObject2 != null)
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label7581;
          }
          localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
          if (l2 != 0L)
          {
            paramString = ark.arkGetContainer(l2);
            if (paramString == null) {
              break label7576;
            }
            paramString = (afvi)afvi.a(paramString).get();
            if (!(paramString instanceof afvh)) {
              break label7576;
            }
            paramArrayOfVariantWrapper = ((afvh)paramString).a();
            paramString = paramArrayOfVariantWrapper;
            if (paramArrayOfVariantWrapper == null) {
              paramString = a();
            }
            paramArrayOfVariantWrapper = paramString;
            if (QLog.isColorLevel())
            {
              QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "ark.GetNickNameByView Extra ViewID viewHandle=", Long.valueOf(l2), a(paramString) });
              paramArrayOfVariantWrapper = paramString;
            }
          }
          while (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (paramArrayOfVariantWrapper == null) {
              break label7571;
            }
            paramArrayOfVariantWrapper = ContactUtils.getNicknameInSession((QQAppInterface)localObject2, paramArrayOfVariantWrapper, ((String)localObject1).equals(((QQAppInterface)localObject2).getCurrentUin()), (String)localObject1);
            if (paramArrayOfVariantWrapper != null)
            {
              paramString = paramArrayOfVariantWrapper;
              if (!TextUtils.equals(paramArrayOfVariantWrapper, (CharSequence)localObject1)) {}
            }
            else
            {
              paramArrayOfVariantWrapper = ContactUtils.getDateNickName((QQAppInterface)localObject2, (String)localObject1);
              paramString = paramArrayOfVariantWrapper;
              if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
                paramString = ContactUtils.getNick((QQAppInterface)localObject2, (String)localObject1, 0);
              }
            }
            paramVariantWrapper.SetString(paramString);
            if ((paramString != null) && (QLog.isColorLevel())) {
              QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "ark.GetNickNameByView ", paramString });
            }
            return true;
            paramString = a();
            paramArrayOfVariantWrapper = paramString;
            if (QLog.isColorLevel())
            {
              QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "ark.GetNickNameByView old, ", a(paramString) });
              paramArrayOfVariantWrapper = paramString;
            }
          }
          return false;
        }
        else
        {
          QLog.d("ArkApp.ArkAppQQModule", 1, "ark.GetNickNameByView invalid param appInterface == null ");
          paramVariantWrapper.SetString(aori.a(paramString, l2));
          return true;
        }
      }
      else
      {
        if (paramString.equals("GetAppInfo"))
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("package", BaseApplicationImpl.getApplication().getPackageName());
            ((JSONObject)localObject1).put("name", BaseApplicationImpl.getApplication().getString(2131690081));
            paramArrayOfVariantWrapper = DeviceInfoUtil.getQQVersion();
            paramString = paramArrayOfVariantWrapper;
            if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
              paramString = "8.4.8";
            }
            ((JSONObject)localObject1).put("version", paramString);
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              QLog.e("ArkApp.ArkAppQQModule", 1, "ark.GetAppInfo: ", paramString);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkAppQQModule", 2, new Object[] { "ark.GetAppInfo: ", ((JSONObject)localObject1).toString() });
          }
          paramVariantWrapper.SetTableAsJsonString(((JSONObject)localObject1).toString());
          return true;
        }
        if (paramString.equals("SubscribePublicAccount"))
        {
          if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 3) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[2].IsFunction())) {
            return false;
          }
          l1 = a(paramArrayOfVariantWrapper[2].Copy());
          paramString = null;
          try
          {
            if (paramArrayOfVariantWrapper[0].IsString()) {
              paramString = paramArrayOfVariantWrapper[0].GetString();
            }
            if ((int)paramArrayOfVariantWrapper[1].GetDouble() == 0) {
              zkf.a(BaseApplicationImpl.getContext(), paramString, new aoqe(this, l1));
            } else {
              zkf.c(BaseApplicationImpl.getContext(), paramString, new aoqf(this, l1));
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
          }
        }
        return false;
      }
      label7571:
      label7576:
      label7581:
      label7587:
      label7604:
      label7610:
      label7615:
      label7620:
      label7625:
      label7628:
      break label7683;
      label7631:
      break label1161;
      label7634:
      j = i;
      i = 1;
      break label843;
      label7644:
      j = i;
      i = 0;
      break label847;
      label7654:
      localMessageForArkApp = null;
      break label399;
      label7660:
      localObject4 = null;
      localObject3 = paramArrayOfVariantWrapper;
      break label345;
      label7669:
      paramArrayOfVariantWrapper = null;
      break label189;
      label7674:
      l1 = 0L;
      localObject1 = null;
      break;
      label7683:
      break label970;
      label7686:
      break label4292;
      label7689:
      break label4292;
      return true;
      label7694:
      return true;
      label7696:
      i += 1;
    }
    return true;
  }
  
  protected void a(long paramLong, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    ark.VariantWrapper localVariantWrapper1 = b(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    localVariantWrapper2.SetDouble(paramDouble1);
    ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
    localVariantWrapper3.SetDouble(paramDouble2);
    ark.VariantWrapper localVariantWrapper4 = localVariantWrapper1.Create();
    localVariantWrapper4.SetBool(paramBoolean);
    ark.VariantWrapper localVariantWrapper5 = localVariantWrapper1.Create();
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2, localVariantWrapper3, localVariantWrapper4 }, localVariantWrapper5);
    localVariantWrapper5.Reset();
    localVariantWrapper4.Reset();
    localVariantWrapper2.Reset();
    localVariantWrapper3.Reset();
  }
  
  protected void a(long paramLong, boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    Object localObject;
    if (paramSosoLbsInfo != null)
    {
      localObject = ArkAppCenter.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramSosoLbsInfo.mLocation.city = ((String)localObject);
      }
      localObject = ArkAppCenter.a();
      if ((localObject != null) && (localObject.length == 2))
      {
        paramSosoLbsInfo.mLocation.mLat84 = localObject[0];
        paramSosoLbsInfo.mLocation.mLon84 = localObject[1];
      }
      localObject = "{}";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("prov", paramSosoLbsInfo.mLocation.province);
      localJSONObject.put("city", paramSosoLbsInfo.mLocation.city);
      localJSONObject.put("dist", paramSosoLbsInfo.mLocation.district);
      localJSONObject.put("road", paramSosoLbsInfo.mLocation.street);
      localJSONObject.put("town", paramSosoLbsInfo.mLocation.town);
      localJSONObject.put("lat", paramSosoLbsInfo.mLocation.mLat84);
      localJSONObject.put("lng", paramSosoLbsInfo.mLocation.mLon84);
      paramSosoLbsInfo = localJSONObject.toString();
      localVariantWrapper2.SetTableAsJsonString(paramSosoLbsInfo);
      paramSosoLbsInfo = localVariantWrapper1.Create();
      paramSosoLbsInfo.SetBool(paramBoolean);
      localObject = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2, paramSosoLbsInfo }, (ark.VariantWrapper)localObject);
      ((ark.VariantWrapper)localObject).Reset();
      paramSosoLbsInfo.Reset();
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      return;
    }
    catch (JSONException paramSosoLbsInfo)
    {
      for (;;)
      {
        ArkAppCenter.c("ArkApp.ArkAppQQModule", paramSosoLbsInfo.getMessage());
        paramSosoLbsInfo = (SosoInterface.SosoLbsInfo)localObject;
      }
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, String paramString, int paramInt)
  {
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("uin", paramString);
      ((JSONObject)localObject).put("followState", paramInt);
      localVariantWrapper2.SetTableAsJsonString(((JSONObject)localObject).toString());
      paramString = localVariantWrapper1.Create();
      paramString.SetBool(paramBoolean);
      localObject = localVariantWrapper1.Create();
      localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2, paramString }, (ark.VariantWrapper)localObject);
      ((ark.VariantWrapper)localObject).Reset();
      paramString.Reset();
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(List<aoti> paramList)
  {
    super.a(paramList);
    a("OpenUrl", 1L, 500L);
    a("SendMessage", 1L, 500L);
  }
  
  protected aopq[] a()
  {
    return new aopq[] { new aoqn(null), new aoqm(null), new aoql(null) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqa
 * JD-Core Version:    0.7.0.1
 */