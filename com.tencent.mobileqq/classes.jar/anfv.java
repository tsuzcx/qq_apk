import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkViewModelBase.TimeRecord;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.Container;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo.TimeRecord;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.10;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.11;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.12;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.13;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.14;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.15;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.16;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.17;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.18;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.20;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.21;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.4;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.5;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.7;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.8;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.9;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anfv
  extends anft
{
  private static long jdField_c_of_type_Long;
  private static long jdField_d_of_type_Long;
  protected afem a;
  private WeakReference<bdfq> jdField_a_of_type_JavaLangRefWeakReference;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver;
  private HashMap<String, String> b = new HashMap();
  private HashMap<String, String> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, String> jdField_d_of_type_JavaUtilHashMap = new HashMap();
  
  public anfv(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    this.jdField_a_of_type_Afem = new afem(this.jdField_a_of_type_JavaLangString, 30000L);
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).getInt("key_ark_authority_info" + "_" + paramString1 + "_" + paramString2 + "_" + paramString3, 0);
  }
  
  public static ArrayList<String> a(String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).getString("key_ark_authority_app_list_" + paramString, "");
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(";");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        while (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (!TextUtils.isEmpty(localCharSequence)) {
            localArrayList.add(localCharSequence);
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(long paramLong, String paramString, int paramInt)
  {
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null)
    {
      QLog.e("ArkApp", 1, "GetUserInformation.arkGetUserInformation call back is null");
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    QQAppInterface localQQAppInterface = anfp.a();
    Object localObject;
    String str2;
    String str1;
    if ((localQQAppInterface != null) && (1 == paramInt))
    {
      localObject = ((aloz)localQQAppInterface.getManager(51)).b(paramString);
      if (localObject != null)
      {
        str2 = ((Card)localObject).strNick;
        if (((Card)localObject).shGender == 0) {
          str1 = BaseActivity.sTopActivity.getString(2131694190);
        }
      }
    }
    for (;;)
    {
      String str3 = ((Card)localObject).strCity;
      String str4 = ((Card)localObject).strProvince;
      String str5 = ((Card)localObject).strCountry;
      localObject = "";
      paramString = localQQAppInterface.c(paramString);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.url))) {
        paramString = MsfSdkUtils.insertMtype("QQHeadIcon", ((FriendListHandler)localQQAppInterface.a(1)).a().a(paramString.url, paramString.bFaceFlags, paramString.bUsrType, 0));
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp", 2, "GetUserInformation nickname=" + str2 + ", avatarUrl=" + paramString + ", gender=" + str1 + ", city=" + str3 + ", province=" + str4 + ", country=" + str5);
        }
        localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, "{\"nickname\":\"%s\",\"avatar\":\"%s\",\"gender\":\"%s\",\"city\":\"%s\",\"province\":\"%s\",\"country\":\"%s\"}", new Object[] { str2, paramString, str1, str3, str4, str5 }));
        paramInt = 0;
        if (paramInt != 0) {
          localVariantWrapper2.SetNull();
        }
        paramString = localVariantWrapper1.Create();
        localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, paramString);
        paramString.Reset();
        localVariantWrapper2.Reset();
        localVariantWrapper1.Reset();
        return;
        if (((Card)localObject).shGender != 1) {
          break label445;
        }
        str1 = BaseActivity.sTopActivity.getString(2131692470);
        break;
        paramString = (String)localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("ArkApp", 2, "GetUserInformation QQHeadSetting is empty");
          paramString = (String)localObject;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp", 2, "GetUserInformation FriendCard is null");
      }
      for (;;)
      {
        paramInt = 1;
        break;
        QLog.i("ArkApp", 1, "GetUserInformation get value null for appInterface null, authState = " + paramInt);
      }
      label445:
      str1 = "";
    }
  }
  
  private void a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt)
  {
    Object localObject2 = anfp.a();
    if ((localObject2 != null) && (1 == paramInt))
    {
      localObject1 = this.jdField_a_of_type_JavaLangString + "_" + paramLong3 + "_" + paramString;
      if ((this.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject1)) && (!TextUtils.isEmpty((CharSequence)this.jdField_c_of_type_JavaUtilHashMap.get(localObject1))) && (this.jdField_d_of_type_JavaUtilHashMap.containsKey(localObject1)) && (!TextUtils.isEmpty((CharSequence)this.jdField_d_of_type_JavaUtilHashMap.get(localObject1))))
      {
        paramString = String.valueOf(paramLong3);
        if ((!this.b.containsKey(this.jdField_a_of_type_JavaLangString)) || (!this.b.containsValue(paramString))) {
          this.b.put(this.jdField_a_of_type_JavaLangString, paramString);
        }
        paramString = a(paramLong1);
        if (paramString != null) {}
      }
    }
    do
    {
      return;
      localObject2 = paramString.Create();
      ((ark.VariantWrapper)localObject2).SetTableAsJsonString(String.format(Locale.CHINA, "{\"openid\":\"%s\",\"token\":\"%s\"}", new Object[] { this.jdField_c_of_type_JavaUtilHashMap.get(localObject1), this.jdField_d_of_type_JavaUtilHashMap.get(localObject1) }));
      localObject1 = paramString.Create();
      paramString.InvokeDefault(new ark.VariantWrapper[] { localObject2 }, (ark.VariantWrapper)localObject1);
      ((ark.VariantWrapper)localObject1).Reset();
      ((ark.VariantWrapper)localObject2).Reset();
      paramString.Reset();
      return;
      if (this.jdField_a_of_type_MqqObserverWtloginObserver == null) {
        this.jdField_a_of_type_MqqObserverWtloginObserver = new angb(this, paramLong1);
      }
      ((WtloginManager)((QQAppInterface)localObject2).getManager(1)).GetOpenKeyWithoutPasswd(paramString, paramLong2, paramLong3, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
      paramString = a(paramLong1);
    } while (paramString == null);
    Object localObject1 = paramString.Create();
    ((ark.VariantWrapper)localObject1).SetNull();
    localObject2 = paramString.Create();
    paramString.InvokeDefault(new ark.VariantWrapper[] { localObject1 }, (ark.VariantWrapper)localObject2);
    ((ark.VariantWrapper)localObject2).Reset();
    ((ark.VariantWrapper)localObject1).Reset();
    paramString.Reset();
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString)
  {
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null)
    {
      QLog.e("ArkApp", 1, "Callback is null");
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp", 2, "doCallbackForGetPskeyAsync : SetString");
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
        QLog.d("ArkApp", 2, "doCallbackForGetPskeyAsync : SetNull");
      }
      localVariantWrapper2.SetNull();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ArrayList localArrayList = a(paramString2);
    StringBuilder localStringBuilder = new StringBuilder("");
    int j = 0;
    int n = 0;
    int m;
    for (int i = 0; j < localArrayList.size(); i = m)
    {
      String str = (String)localArrayList.get(j);
      int k = n;
      m = i;
      if (!TextUtils.isEmpty(str))
      {
        if (n > 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(str);
        n += 1;
        k = n;
        m = i;
        if (str.equals(paramString1))
        {
          m = 1;
          k = n;
        }
      }
      j += 1;
      n = k;
    }
    if (i == 0)
    {
      if (n > 0) {
        localStringBuilder.append(";");
      }
      localStringBuilder.append(paramString1);
    }
    BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).edit().putString("key_ark_authority_app_list_" + paramString2, localStringBuilder.toString()).commit();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).edit().putInt("key_ark_authority_info" + "_" + paramString1 + "_" + paramString2 + "_" + paramString3, paramInt).commit();
  }
  
  public void Destruct()
  {
    if (this.jdField_a_of_type_Afem != null) {
      this.jdField_a_of_type_Afem.a();
    }
    if (this.jdField_a_of_type_MqqObserverWtloginObserver != null) {
      this.jdField_a_of_type_MqqObserverWtloginObserver = null;
    }
    super.Destruct();
  }
  
  public String GetTypeName()
  {
    return "QQ";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (paramString.equals("OpenUrl")) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while ((paramString.equals("NavigateTo")) || (paramString.equals("OpenVideo")) || (paramString.equals("GetVersion")) || (paramString.equals("GetPerformance")) || (paramString.equals("Login")) || (paramString.equals("GetUserInformation")) || (paramString.equals("OpenView")) || (paramString.equals("CloseView")) || (paramString.equals("ShareView")) || (paramString.equals("ShowStatusBar")) || (paramString.equals("HideStatusBar")) || (paramString.equals("SetNavigationBarTitle")) || (paramString.equals("ShowShareMenu")) || (paramString.equals("HideShareMenu")) || (paramString.equals("PreviewImage")) || (paramString.equals("SetTalkBackText")) || (paramString.equals("ChooseImage")) || (paramString.equals("GetAppInfo")));
        if (this.jdField_a_of_type_Long != 0L) {
          break;
        }
      } while ((paramString.equals("GetSkey")) || (paramString.equals("GetPskey")) || (paramString.equals("GetPskeyAsync")) || (paramString.equals("GetUIN")) || (paramString.equals("GetNickName")) || (paramString.equals("Report")) || (paramString.equals("ReportEx")) || (paramString.equals("Log")) || (paramString.equals("GetContainerInfo")) || (paramString.equals("DataRequest")) || (paramString.equals("GetCurrentPosition")) || (paramString.equals("WatchPosition")) || (paramString.equals("ClearWatch")) || (paramString.equals("GetCurrentAddress")) || (paramString.equals("SendMessage")));
      if (paramString.equals("TestGetJson")) {
        return false;
      }
    } while ((paramString.equals("Notify")) || (paramString.equals("GetAppID")) || (paramString.equals("GetAudioOutputMode")) || (paramString.equals("IsMute")) || (paramString.equals("GetNickNameByView")) || (paramString.equals("SubscribePublicAccount")));
    return false;
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!a(paramString)) {
      return false;
    }
    if (paramString.equals("GetSkey"))
    {
      paramString = "";
      paramArrayOfVariantWrapper = anfp.a();
      if (paramArrayOfVariantWrapper != null) {
        paramString = ((TicketManager)paramArrayOfVariantWrapper.getManager(2)).getSkey(paramArrayOfVariantWrapper.getCurrentAccountUin());
      }
      paramVariantWrapper.SetString(paramString);
      if ((paramString != null) && (QLog.isColorLevel())) {
        QLog.d("ark.GetSkey ", 2, paramString);
      }
      return true;
    }
    Object localObject1;
    if (paramString.equals("GetPskey"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 1))
      {
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
        paramString = "";
        localObject1 = anfp.a();
        if (localObject1 != null) {
          paramString = ((TicketManager)((QQAppInterface)localObject1).getManager(2)).getPskey(((QQAppInterface)localObject1).getCurrentAccountUin(), paramArrayOfVariantWrapper);
        }
        paramVariantWrapper.SetString(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("ark.GetSkey ", 2, paramArrayOfVariantWrapper);
        }
      }
      return true;
    }
    if (paramString.equals("NavigateTo"))
    {
      paramString = BaseActivity.sTopActivity;
      if ((paramString != null) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1)) {
        anfp.a(paramString, paramArrayOfVariantWrapper[0].GetString(), true, 0L, null, null, 3, this.jdField_a_of_type_JavaLangString, null);
      }
      return true;
    }
    BaseActivity localBaseActivity;
    long l1;
    Object localObject2;
    if (paramString.equals("OpenUrl"))
    {
      paramVariantWrapper.SetBool(false);
      localBaseActivity = BaseActivity.sTopActivity;
      if (((localBaseActivity instanceof FragmentActivity)) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        if (!TextUtils.isEmpty(paramString))
        {
          if (paramArrayOfVariantWrapper.length <= 1) {
            break label8231;
          }
          if (!paramArrayOfVariantWrapper[1].IsView()) {
            break label661;
          }
          l1 = paramArrayOfVariantWrapper[1].GetView();
          localObject1 = null;
          localObject2 = null;
        }
      }
    }
    for (;;)
    {
      label661:
      int i;
      try
      {
        if (paramArrayOfVariantWrapper.length <= 2) {
          break label8226;
        }
        paramArrayOfVariantWrapper = new JSONObject(paramArrayOfVariantWrapper[2].GetTableAsJsonString());
        if (paramArrayOfVariantWrapper != null)
        {
          localObject2 = paramArrayOfVariantWrapper.optString("businessId", "biz_src_jc_ark");
          localObject3 = (FragmentActivity)localBaseActivity;
          if (((FragmentActivity)localObject3).getChatFragment() == null) {
            break label8220;
          }
          localObject4 = ((FragmentActivity)localObject3).getChatFragment().a();
          if ((!(localObject4 instanceof agot)) || (!"biz_src_ads".equals(localObject2))) {
            break label8220;
          }
          localObject3 = syb.b(((BaseChatPie)localObject4).a.jdField_a_of_type_JavaLangString);
          QLog.d("ArkApp", 1, "ArkSafe.OpenUrl set hsSourceID for " + ((BaseChatPie)localObject4).a.jdField_a_of_type_JavaLangString + ", input " + (String)localObject2 + ", output " + (String)localObject3);
          if (l1 == 0L) {
            break label8214;
          }
          localObject4 = ark.arkGetContainer(l1);
          if (localObject4 == null) {
            break label8214;
          }
          localObject4 = (afdt)afdt.a((ark.Container)localObject4).get();
          if ((localObject4 == null) || (!(localObject4 instanceof afds))) {
            break label8214;
          }
          localObject4 = (MessageForArkApp)((afds)localObject4).jdField_a_of_type_JavaLangRefWeakReference.get();
          if (!angr.a(paramString, (String)localObject1, paramArrayOfVariantWrapper, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          anjv.a(null, this.jdField_a_of_type_JavaLangString, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
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
            if (localObject4 != null)
            {
              l1 = npd.a(((MessageForArkApp)localObject4).ark_app_message.getAppIdFromMeta(), 0L);
              if (l1 != 0L) {
                continue;
              }
              paramArrayOfVariantWrapper = "";
              azmj.b(null, "dc00898", "", "", "0X800A86C", "0X800A86C", 0, 0, paramArrayOfVariantWrapper, "", "", "");
              paramArrayOfVariantWrapper = paramString;
            }
          }
          Log.d("ark.OpenUrl ", paramArrayOfVariantWrapper);
          anjv.a(null, this.jdField_a_of_type_JavaLangString, "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
          return true;
          localObject1 = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
          l1 = 0L;
          break;
        }
        localObject2 = "biz_src_jc_ark";
        continue;
        paramArrayOfVariantWrapper = String.valueOf(l1);
        continue;
        int k;
        int j;
        boolean bool2;
        boolean bool3;
        if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
        {
          if (!anfp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.BROWSER"))
          {
            QLog.d("ArkApp", 1, "ArkSafe.OpenUrl ModuleCheckPermission invalid!");
            return false;
          }
          paramArrayOfVariantWrapper = ArkAppConfigMgr.getInstance().getUrlChecker(this.jdField_a_of_type_JavaLangString);
          i = 1;
          if (paramArrayOfVariantWrapper != null)
          {
            k = paramArrayOfVariantWrapper.checkUrlIsValidByAppNavigationList(paramString);
            j = 0;
            if (k == 0)
            {
              i = 1;
              bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(this.jdField_a_of_type_JavaLangString);
              bool3 = anjs.a();
              if ((!bool2) || (bool3)) {
                continue;
              }
              bool1 = true;
              if (QLog.isColorLevel()) {
                QLog.e("ArkApp", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.appname=", this.jdField_a_of_type_JavaLangString, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
              }
              if (i != 0) {
                break label8211;
              }
              j = 1;
              if (bool1) {
                break label8211;
              }
              QLog.e("ArkApp", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.http appName=", this.jdField_a_of_type_JavaLangString, ",url=", ndq.b(paramString, new String[0]), ", isValid set=true" });
              i = 1;
              j = 2;
              annd.b(this.jdField_a_of_type_JavaLangString, paramString, k, j, afdt.jdField_c_of_type_JavaLangString);
            }
          }
          else
          {
            if (i != 0) {
              continue;
            }
            QLog.d("ArkApp", 1, new Object[] { "ArkSafe.OpenUrl check url invalid!, url=", ndq.b(paramString, new String[0]), ", app=", this.jdField_a_of_type_JavaLangString });
            return false;
          }
          i = 0;
          continue;
          bool1 = false;
          continue;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label8208;
          }
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject1);
            Iterator localIterator = localJSONObject.keys();
            paramArrayOfVariantWrapper = new String();
            i = 0;
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              paramVariantWrapper = null;
              if ((localJSONObject.get(str) instanceof String))
              {
                paramVariantWrapper = localJSONObject.getString(str);
                if (TextUtils.isEmpty(paramVariantWrapper)) {
                  break label8205;
                }
                localObject1 = paramArrayOfVariantWrapper;
                if (i != 0) {
                  localObject1 = paramArrayOfVariantWrapper + "&";
                }
                paramArrayOfVariantWrapper = (String)localObject1 + str + "=" + paramVariantWrapper;
                i = 1;
                break label8240;
              }
              if (!(localJSONObject.get(str) instanceof Number)) {
                continue;
              }
              paramVariantWrapper = ((Number)localJSONObject.get(str)).toString();
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
            continue;
            anjv.a(null, this.jdField_a_of_type_JavaLangString, "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
            continue;
            paramArrayOfVariantWrapper = String.valueOf(l1);
            continue;
            anfp.a(localBaseActivity, paramString, true, 0L, null, (String)localObject2, 0, this.jdField_a_of_type_JavaLangString, (String)localObject3);
            continue;
          }
          paramArrayOfVariantWrapper = (FragmentActivity)localBaseActivity;
          if (paramArrayOfVariantWrapper.getChatFragment() != null)
          {
            paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.getChatFragment().a();
            if ((paramArrayOfVariantWrapper instanceof agot)) {
              ((agot)paramArrayOfVariantWrapper).a.b();
            }
          }
          else
          {
            if ((localObject4 == null) || (((MessageForArkApp)localObject4).ark_app_message == null)) {
              continue;
            }
            l1 = npd.a(((MessageForArkApp)localObject4).ark_app_message.getAppIdFromMeta(), 0L);
            anfp.a(localBaseActivity, paramString, true, l1, (MessageForArkApp)localObject4, (String)localObject2, 0, this.jdField_a_of_type_JavaLangString, (String)localObject3);
            ((MessageForArkApp)localObject4).reportClick();
            if (((MessageForArkApp)localObject4).buildTypeAndTitle().isSdkShare)
            {
              if (l1 != 0L) {
                continue;
              }
              paramArrayOfVariantWrapper = "";
              azmj.b(null, "dc00898", "", "", "0X800A869", "0X800A869", 0, 0, paramArrayOfVariantWrapper, "", "", "");
            }
            paramArrayOfVariantWrapper = paramString;
            continue;
            paramVariantWrapper = paramString + "&" + paramArrayOfVariantWrapper;
            continue;
          }
        }
        paramArrayOfVariantWrapper = paramString;
        if (this.jdField_a_of_type_Long != 0L) {
          continue;
        }
        paramVariantWrapper = bdds.a(anfp.a(), localBaseActivity, paramString);
        paramArrayOfVariantWrapper = paramString;
        if (paramVariantWrapper == null) {
          continue;
        }
        paramArrayOfVariantWrapper = ArkAppConfigMgr.getInstance().getUrlChecker(this.jdField_a_of_type_JavaLangString);
        i = 1;
        if (paramArrayOfVariantWrapper != null)
        {
          k = paramArrayOfVariantWrapper.checkUrlIsValidByAppNavigationList(paramString);
          j = 0;
          if (k == 0)
          {
            i = 1;
            bool2 = ArkAppConfigMgr.getInstance().isUrlCheckEnable(this.jdField_a_of_type_JavaLangString);
            bool3 = anjs.a();
            if ((!bool2) || (bool3)) {
              continue;
            }
            bool1 = true;
            if (QLog.isColorLevel()) {
              QLog.e("ArkApp", 2, new Object[] { "ArkSafe.UrlCheck.OpenUrl.http.JumpAction=", this.jdField_a_of_type_JavaLangString, ", enableCheck=", Boolean.valueOf(bool1), ", appEnableCheck=", Boolean.valueOf(bool2), ", isPublicAccount=", Boolean.valueOf(bool3) });
            }
            if (i != 0) {
              continue;
            }
            j = 1;
            if (bool1) {
              continue;
            }
            QLog.e("ArkApp", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.OpenUrl.jump appName=", this.jdField_a_of_type_JavaLangString, ",url=", ndq.b(paramString, new String[0]), ", isValid set=true" });
            i = 1;
            j = 2;
            annd.b(this.jdField_a_of_type_JavaLangString, paramString, k, j, afdt.jdField_c_of_type_JavaLangString);
          }
        }
        else
        {
          if (i == 0) {
            continue;
          }
          paramVariantWrapper.c();
          paramArrayOfVariantWrapper = paramString;
          continue;
        }
        i = 0;
        continue;
        bool1 = false;
        continue;
        QLog.e("ArkApp", 1, new Object[] { "ArkSafe.OpenUrl check url invalid, url=", ndq.b(paramString, new String[0]), ", app=", this.jdField_a_of_type_JavaLangString });
        paramArrayOfVariantWrapper = paramString;
        continue;
        if (paramString.equals("OpenVideo"))
        {
          l1 = System.currentTimeMillis();
          if ((l1 - jdField_c_of_type_Long < 1000L) && (l1 > jdField_c_of_type_Long))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ArkApp", 2, "click too offen,please try again later ");
            }
            return true;
          }
          jdField_c_of_type_Long = l1;
          paramVariantWrapper.SetBool(false);
          paramString = BaseActivity.sTopActivity;
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
              localObject1 = anfp.a();
              if ((this.jdField_a_of_type_ComTencentArkArk$Application != null) && (!this.jdField_a_of_type_ComTencentArkArk$Application.CheckUrlLegality(paramArrayOfVariantWrapper))) {
                return false;
              }
              paramVariantWrapper.SetBool(true);
              anfp.a(paramString, paramArrayOfVariantWrapper);
              anjv.a((QQAppInterface)localObject1, this.jdField_a_of_type_JavaLangString, "AIOArkOpenVideo", 1, 0, 0L, 0L, 0L, paramArrayOfVariantWrapper, "");
            }
            return true;
          }
          catch (MalformedURLException paramString)
          {
            ArkAppCenter.c("ArkApp", "url parse error and msg= " + paramString.getMessage());
            return false;
          }
        }
        if (paramString.equals("GetUIN"))
        {
          paramString = "";
          paramArrayOfVariantWrapper = anfp.a();
          if (paramArrayOfVariantWrapper != null) {
            paramString = paramArrayOfVariantWrapper.getCurrentAccountUin();
          }
          paramVariantWrapper.SetString(paramString);
          if (paramString != null) {
            Log.d("ark.GetUIN ", paramString);
          }
          return true;
        }
        if (paramString.equals("Report"))
        {
          paramString = anfp.a();
          if (paramString == null) {
            return false;
          }
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 3))
          {
            paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
            i = (int)Math.round(paramArrayOfVariantWrapper[1].GetDouble());
            paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[2].GetString();
            if (!TextUtils.isEmpty(paramArrayOfVariantWrapper))
            {
              localObject1 = paramString.getCurrentAccountUin();
              l1 = NetConnInfoCenter.getServerTime();
              if (TextUtils.isEmpty(paramVariantWrapper)) {
                continue;
              }
            }
          }
          try
          {
            Long.parseLong(paramVariantWrapper);
            azmj.b(paramString, "CliOper", "", (String)localObject1, "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), paramVariantWrapper, paramArrayOfVariantWrapper, "");
            anjv.a(paramString, this.jdField_a_of_type_JavaLangString, paramArrayOfVariantWrapper, i);
            return true;
          }
          catch (Exception paramVariantWrapper)
          {
            azmj.b(paramString, "CliOper", "", (String)localObject1, "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), "0", paramArrayOfVariantWrapper, "");
            continue;
          }
          azmj.b(paramString, "CliOper", "", (String)localObject1, "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), "0", paramArrayOfVariantWrapper, "");
          continue;
        }
        if (paramString.equals("ReportEx"))
        {
          if (paramArrayOfVariantWrapper.length > 0)
          {
            paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
            if (paramArrayOfVariantWrapper.length > 1)
            {
              paramString = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
              if ((!TextUtils.isEmpty(paramVariantWrapper)) && (!TextUtils.isEmpty(paramString))) {
                continue;
              }
              ArkAppCenter.c("ArkApp", "QQ.ReportEx, invalid arguments");
              return false;
            }
          }
          else
          {
            paramVariantWrapper = null;
            continue;
          }
          paramString = null;
          continue;
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
              azmj.b(null, "dc00898", "", (String)localObject1, paramArrayOfVariantWrapper, paramVariantWrapper, i, j, k, Integer.toString(m), Integer.toString(n), (String)localObject2, (String)localObject3);
              return true;
            }
            catch (JSONException paramArrayOfVariantWrapper)
            {
              ArkAppCenter.c("ArkApp", "QQ.ReportEx, invalid report data, data=" + paramString);
              return false;
            }
          }
          return false;
        }
        if (paramString.equals("GetVersion"))
        {
          paramArrayOfVariantWrapper = bdcb.c();
          paramString = paramArrayOfVariantWrapper;
          if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
            paramString = "8.3.3";
          }
          paramVariantWrapper.SetString(paramString);
          return true;
        }
        if (paramString.equals("Log"))
        {
          if (paramArrayOfVariantWrapper != null)
          {
            l1 = paramArrayOfVariantWrapper.length;
            if (l1 <= 0L) {
              return true;
            }
          }
          else
          {
            l1 = 0L;
            continue;
          }
          paramString = paramArrayOfVariantWrapper[0];
          i = paramString.GetType();
          j = anfp.a(paramArrayOfVariantWrapper, l1);
          if (i == 0)
          {
            QLog.i("ArkApp.QQLog", j, "none");
            return true;
          }
          if (i == 1)
          {
            QLog.i("ArkApp.QQLog", j, "null");
            continue;
          }
          if (i == 2)
          {
            if (paramString.GetBool())
            {
              paramString = "true";
              QLog.i("ArkApp.QQLog", j, paramString);
              continue;
            }
            paramString = "false";
            continue;
          }
          if (i == 3)
          {
            QLog.i("ArkApp.QQLog", j, Integer.toString(paramString.GetInt()));
            continue;
          }
          if (i == 4)
          {
            QLog.i("ArkApp.QQLog", j, Double.toString(paramString.GetDouble()));
            continue;
          }
          if (i == 5)
          {
            QLog.i("ArkApp.QQLog", j, paramString.GetString());
            continue;
          }
          if (paramString.IsFunction())
          {
            QLog.i("ArkApp.QQLog", j, "Function Object");
            continue;
          }
          if (paramString.IsUserObject())
          {
            QLog.i("ArkApp.QQLog", j, "User Object");
            continue;
          }
          if ((paramString.IsArray()) || (paramString.IsTable()))
          {
            QLog.i("ArkApp.QQLog", j, paramString.GetTableAsJsonString());
            continue;
          }
          QLog.i("ArkApp.QQLog", j, "Unknown Object");
          continue;
        }
        if (paramString.equals("GetNickName"))
        {
          paramString = null;
          localObject2 = anfp.a();
          if (localObject2 == null) {
            return false;
          }
          if (paramArrayOfVariantWrapper != null)
          {
            l1 = paramArrayOfVariantWrapper.length;
            if (l1 == 1L)
            {
              paramString = paramArrayOfVariantWrapper[0].GetString();
              if (!TextUtils.isEmpty(paramString))
              {
                localObject1 = null;
                if (!TextUtils.isEmpty(afdt.jdField_a_of_type_JavaLangString)) {
                  localObject1 = bdbt.h((QQAppInterface)localObject2, afdt.jdField_a_of_type_JavaLangString, paramString);
                }
                if (localObject1 != null)
                {
                  paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
                  if (!TextUtils.equals((CharSequence)localObject1, paramString)) {
                    continue;
                  }
                }
                localObject1 = bdbt.q((QQAppInterface)localObject2, paramString);
                paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  continue;
                }
                paramString = bdbt.a((QQAppInterface)localObject2, paramString, 0);
                paramVariantWrapper.SetString(paramString);
                if (paramString != null) {
                  Log.d("ark.GetNickName ", paramString);
                }
              }
              return true;
            }
          }
          else
          {
            l1 = 0L;
            continue;
          }
          if (l1 != 0L) {
            continue;
          }
          paramString = ((QQAppInterface)localObject2).getCurrentAccountUin();
          continue;
        }
        else if (paramString.equals("GetContainerInfo"))
        {
          localObject1 = new HashMap();
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            if (l1 == 0L) {
              continue;
            }
            paramString = ark.arkGetContainer(l1);
            if (paramString == null) {
              continue;
            }
            paramString = (afdt)afdt.a(paramString).get();
            if ((paramString == null) || (!(paramString instanceof afds))) {
              continue;
            }
            paramArrayOfVariantWrapper = ((afds)paramString).a();
            paramString = paramArrayOfVariantWrapper;
            if (paramArrayOfVariantWrapper == null) {
              paramString = anfp.a();
            }
            if (QLog.isColorLevel()) {
              QLog.d("ArkApp", 2, new Object[] { "multiAio.ArkAppModuleReg GetContainerInfo Extra ViewID viewHandle=", Long.valueOf(l1), anfp.a(paramString) });
            }
            if (paramString != null)
            {
              ((HashMap)localObject1).put("ChatUIN", paramString.jdField_a_of_type_JavaLangString);
              paramArrayOfVariantWrapper = String.format("%d", new Object[] { Integer.valueOf(-1) });
            }
          }
          switch (paramString.jdField_a_of_type_Int)
          {
          default: 
            paramString = paramArrayOfVariantWrapper;
            ((HashMap)localObject1).put("ChatType", paramString);
            paramVariantWrapper.SetMap((Map)localObject1);
            return true;
            paramString = anfp.a();
            if (QLog.isColorLevel()) {
              QLog.d("ArkApp", 2, new Object[] { "multiAio.ArkAppModuleReg GetContainerInfo old activity=", BaseActivity.sTopActivity, anfp.a(paramString) });
            }
            break;
          case 1008: 
            paramString = String.format("%d", new Object[] { Integer.valueOf(1) });
            break;
          case 0: 
            paramString = String.format("%d", new Object[] { Integer.valueOf(2) });
            break;
          case 1: 
            paramString = String.format("%d", new Object[] { Integer.valueOf(3) });
            break;
          case 3000: 
            paramString = String.format("%d", new Object[] { Integer.valueOf(4) });
            break;
          case 2: 
            paramString = String.format("%d", new Object[] { Integer.valueOf(5) });
            break;
          case 1004: 
            paramString = String.format("%d", new Object[] { Integer.valueOf(6) });
            break;
          }
        }
        else
        {
          if (paramString.equals("DataRequest"))
          {
            paramString = anfp.a();
            if (paramString == null)
            {
              paramVariantWrapper.SetNull();
              return true;
            }
            paramVariantWrapper.CreateObject("DataRequest", new afff(paramString, this.jdField_a_of_type_JavaLangString));
            return true;
          }
          if (paramString.equals("GetPerformance"))
          {
            if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1))
            {
              paramVariantWrapper.SetNull();
              return true;
            }
            paramString = paramArrayOfVariantWrapper[0].GetString();
            if (TextUtils.isEmpty(paramString)) {
              continue;
            }
            paramArrayOfVariantWrapper = afds.a(paramString);
            if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.arkContainer == null))
            {
              ArkAppCenter.c("ArkApp", String.format("QQ.GetPerformance, arkAppMsg is null, viewID=%s", new Object[] { paramString }));
              continue;
            }
            paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.arkContainer.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord;
            if (paramArrayOfVariantWrapper == null)
            {
              ArkAppCenter.c("ArkApp", String.format("QQ.GetPerformance, timeRecord is null, viewID=%s", new Object[] { paramString }));
              continue;
            }
            paramString = null;
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
              ArkAppCenter.c("ArkApp", String.format("QQ.GetPerformance, json exception, msg=%s", new Object[] { paramArrayOfVariantWrapper.getMessage() }));
              continue;
            }
            if (TextUtils.isEmpty(paramString)) {
              continue;
            }
            paramVariantWrapper.SetTableAsJsonString(paramString);
            return true;
            i = 0;
            continue;
          }
          if (paramString.equals("GetCurrentPosition"))
          {
            if ((this.jdField_a_of_type_Afem == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
              return false;
            }
            if (QLog.isColorLevel()) {
              QLog.i("ArkApp", 2, String.format("GetCurrentPosition.app.%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
            }
            l1 = a(paramArrayOfVariantWrapper[0].Copy());
            this.jdField_a_of_type_Afem.b(new anfw(this, l1));
            return true;
          }
          if (paramString.equals("WatchPosition"))
          {
            if ((this.jdField_a_of_type_Afem == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
              return false;
            }
            if (QLog.isColorLevel()) {
              QLog.i("ArkApp", 2, String.format("WatchPosition.app.%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
            }
            l1 = a(paramArrayOfVariantWrapper[0].Copy());
            this.jdField_a_of_type_Afem.a(new anfy(this, l1));
            return true;
          }
          if (paramString.equals("ClearWatch"))
          {
            if (this.jdField_a_of_type_Afem == null) {
              return false;
            }
            this.jdField_a_of_type_Afem.b();
            return true;
          }
          if (paramString.equals("GetCurrentAddress"))
          {
            if ((this.jdField_a_of_type_Afem == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
              return false;
            }
            l1 = a(paramArrayOfVariantWrapper[0].Copy());
            this.jdField_a_of_type_Afem.a(new angc(this, l1), true);
            return true;
          }
          if (paramString.equals("SendMessage"))
          {
            if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || ((!paramArrayOfVariantWrapper[0].IsArray()) && (!paramArrayOfVariantWrapper[0].IsTable()))) {
              return false;
            }
            localObject1 = paramArrayOfVariantWrapper[0].GetTableAsJsonString();
            try
            {
              paramVariantWrapper = new JSONObject((String)localObject1);
              if ((paramArrayOfVariantWrapper.length <= 1) || (paramArrayOfVariantWrapper[1].GetType() != 2)) {
                continue;
              }
              bool1 = paramArrayOfVariantWrapper[1].GetBool();
              if ((paramArrayOfVariantWrapper.length >= 3) && (paramArrayOfVariantWrapper[2].IsView()))
              {
                l1 = paramArrayOfVariantWrapper[2].GetView();
                if (l1 == 0L) {
                  continue;
                }
                paramString = ark.arkGetContainer(l1);
                if (paramString == null) {
                  continue;
                }
                paramString = (afdt)afdt.a(paramString).get();
                if ((paramString == null) || (!(paramString instanceof afds))) {
                  continue;
                }
                paramArrayOfVariantWrapper = ((afds)paramString).a();
                paramString = paramArrayOfVariantWrapper;
                if (paramArrayOfVariantWrapper == null) {
                  paramString = anfp.a();
                }
                if (!QLog.isColorLevel()) {
                  break label8243;
                }
                QLog.d("ArkApp", 2, new Object[] { "multiAio.ArkAppModuleReg SendMessage Extra viewid viewHandle=", Long.valueOf(l1), anfp.a(paramString) });
                break label8243;
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
                paramString = anfp.a();
                if (!QLog.isColorLevel()) {
                  break label8246;
                }
                QLog.d("ArkApp", 2, new Object[] { "multiAio.ArkAppModuleReg SendMessage old,sessionInfo=", anfp.a(paramString) });
                break label8246;
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
                ((ArkAppMessage)localObject2).promptText = String.format(alpo.a(2131701013), new Object[] { ((ArkAppMessage)localObject2).appDesc });
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
                  acex.b(anfp.a(), paramString, (ArkAppMessage)localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage light currentChat success");
                  }
                }
              }
              else {
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.4(this, (ArkAppMessage)localObject2));
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
            if (!paramVariantWrapper.has("text")) {
              continue;
            }
            paramVariantWrapper = paramVariantWrapper.getString("text");
            if (bool1)
            {
              paramArrayOfVariantWrapper = anfp.a();
              if ((paramString == null) || (paramArrayOfVariantWrapper == null)) {
                break label8251;
              }
              paramString = ayvw.a(anfp.a(), anfp.a().c(), paramString.jdField_a_of_type_JavaLangString, paramString.b, paramString.jdField_a_of_type_Int, (byte)1, (byte)0, (short)0, paramVariantWrapper);
              paramArrayOfVariantWrapper.a().a(paramString, null);
              if (!QLog.isColorLevel()) {
                break label8251;
              }
              QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage text currentChat success");
              break label8251;
            }
            ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.5(this, paramVariantWrapper));
            break label8251;
          }
          else
          {
            if (paramString.equals("GetPskeyAsync"))
            {
              if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[1].IsFunction()))
              {
                QLog.e("ArkApp", 1, "GetPskeyAsync.param error");
                return false;
              }
              paramString = paramArrayOfVariantWrapper[0].GetString();
              paramVariantWrapper = anfp.a();
              if (paramVariantWrapper != null)
              {
                l1 = a(paramArrayOfVariantWrapper[1].Copy());
                paramArrayOfVariantWrapper = (TicketManager)paramVariantWrapper.getManager(2);
                localObject1 = paramArrayOfVariantWrapper.getPskey(paramVariantWrapper.getCurrentAccountUin(), paramString);
                if (TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localObject1 = paramVariantWrapper.getCurrentAccountUin();
                  paramVariantWrapper = new angd(this, paramArrayOfVariantWrapper, paramVariantWrapper, paramString, l1);
                  paramArrayOfVariantWrapper.GetPskey((String)localObject1, 16L, new String[] { paramString }, paramVariantWrapper);
                  if (QLog.isColorLevel()) {
                    QLog.d("ark.GetSkeyAsync ", 2, paramString);
                  }
                  return true;
                }
                a(l1, true, (String)localObject1);
                continue;
              }
              QLog.e("ArkApp", 1, "GetPskeyAsync error, QQAppInterface is null");
              return false;
            }
            if (paramString.equals("Login"))
            {
              if (!anfp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.LOGIN"))
              {
                QLog.e("ArkApp", 1, "Login.permission not allow");
                return false;
              }
              if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[1].IsFunction()))
              {
                QLog.e("ArkApp", 1, "Login.param error");
                return false;
              }
              try
              {
                l1 = Long.parseLong(paramArrayOfVariantWrapper[0].GetString());
                paramString = null;
                paramVariantWrapper = anfp.a();
                if (paramVariantWrapper != null) {
                  paramString = paramVariantWrapper.getCurrentAccountUin();
                }
                if ((paramVariantWrapper == null) || (TextUtils.isEmpty(paramString))) {
                  return false;
                }
              }
              catch (NumberFormatException paramString)
              {
                QLog.e("ArkApp", 1, "Login.Exception:" + paramString.getMessage());
                return false;
              }
              l2 = a(paramArrayOfVariantWrapper[1].Copy());
              paramArrayOfVariantWrapper = this.jdField_c_of_type_JavaLangString;
              paramVariantWrapper = ArkAppCacheMgr.getApplicationDesc(this.jdField_a_of_type_JavaLangString);
              paramArrayOfVariantWrapper = paramVariantWrapper;
              if (TextUtils.isEmpty(paramVariantWrapper)) {
                paramArrayOfVariantWrapper = String.valueOf(l1);
              }
              paramVariantWrapper = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
              localObject1 = "key_ark_authority_show_dialog" + "_" + paramArrayOfVariantWrapper + "_" + "ark_authority_api_login" + "_" + paramString;
              if ((!paramVariantWrapper.getBoolean((String)localObject1, false)) && (jdField_a_of_type_Boolean))
              {
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.7(this, paramArrayOfVariantWrapper, l2, paramString, l1));
                paramVariantWrapper.edit().putBoolean((String)localObject1, true).commit();
                a(paramArrayOfVariantWrapper, paramString);
                return true;
              }
              a(l2, paramString, 16L, l1, a(paramArrayOfVariantWrapper, "ark_authority_api_login", paramString));
              continue;
            }
            if (paramString.equals("GetUserInformation"))
            {
              if (!anfp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.USER_INFORMATION"))
              {
                QLog.e("ArkApp", 1, "GetUserInformation.permission not allow");
                return false;
              }
              if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsFunction()))
              {
                QLog.e("ArkApp", 1, "GetUserInformation.param error");
                return false;
              }
              paramString = null;
              paramVariantWrapper = anfp.a();
              if (paramVariantWrapper != null) {
                paramString = paramVariantWrapper.getCurrentAccountUin();
              }
              if ((paramVariantWrapper == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
              {
                QLog.e("ArkApp", 1, "GetUserInformation.error app is null for cureUin:" + paramString + ", app=" + this.jdField_a_of_type_JavaLangString);
                return false;
              }
              l1 = a(paramArrayOfVariantWrapper[0].Copy());
              paramVariantWrapper = (String)this.b.get(this.jdField_a_of_type_JavaLangString);
              localObject1 = ArkAppCacheMgr.getApplicationDesc(this.jdField_a_of_type_JavaLangString);
              paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                paramArrayOfVariantWrapper = paramVariantWrapper;
              }
              paramVariantWrapper = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
              localObject1 = "key_ark_authority_show_dialog" + "_" + paramArrayOfVariantWrapper + "_" + "ark_authority_api_user_info" + "_" + paramString;
              if ((!paramVariantWrapper.getBoolean((String)localObject1, false)) && (jdField_a_of_type_Boolean))
              {
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.8(this, paramArrayOfVariantWrapper, l1, paramString));
                paramVariantWrapper.edit().putBoolean((String)localObject1, true).commit();
                a(paramArrayOfVariantWrapper, paramString);
                return true;
              }
              a(l1, paramString, a(paramArrayOfVariantWrapper, "ark_authority_api_user_info", paramString));
              continue;
            }
            if (paramString.equals("TestGetJson")) {
              return paramVariantWrapper.SetTableAsJsonString("{ \"ret\":0, \"msg\":\"ok\", \"data\":{ \"param_array\": [ 3.1400000000000001, true, \"hello\", { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, { }, 1 ], \"param_bool_false\": false, \"param_bool_true\": true, \"param_double\": 3.1400000000000001, \"param_int\": 0, \"param_int2\": -1, \"param_int3\": 1001, \"param_str_empty\": \"\", \"param_str_hello\": \"hello\", \"param_table\": { \"param1\": 0, \"param2\": 3.1400000000000001, \"param3\": true, \"param4\": \"hello\", \"param5\": { }, \"param6\": { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, \"param7\": \"\" } }}");
            }
            if (paramString.equals("OpenView"))
            {
              if (!anfp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.OPENVIEW")) {
                return false;
              }
              if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 4) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()) && (paramArrayOfVariantWrapper[2].IsString()) && ((paramArrayOfVariantWrapper[3].IsArray()) || (paramArrayOfVariantWrapper[3].IsTable())))
              {
                l1 = paramArrayOfVariantWrapper[0].GetView();
                paramString = paramArrayOfVariantWrapper[1].GetString();
                paramVariantWrapper = paramArrayOfVariantWrapper[2].GetString();
                paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[3].GetTableAsJsonString();
                QLog.d("ArkOpenView", 1, "OpenView holder=" + l1 + ", type=" + paramString + ", view=" + paramVariantWrapper + ", meta=" + paramArrayOfVariantWrapper);
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.9(this, paramString, paramVariantWrapper, paramArrayOfVariantWrapper, l1));
              }
              return true;
            }
            if (paramString.equals("CloseView"))
            {
              if (!anfp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.OPENVIEW")) {
                return false;
              }
              if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
              {
                l1 = paramArrayOfVariantWrapper[0].GetView();
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.10(this, l1));
              }
              return true;
            }
            if (paramString.equals("ShareView"))
            {
              if (!anfp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.SHARE")) {
                return false;
              }
              if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && ((paramArrayOfVariantWrapper[1].IsArray()) || (paramArrayOfVariantWrapper[1].IsTable())))
              {
                paramString = paramArrayOfVariantWrapper[0].GetString();
                paramVariantWrapper = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
                paramArrayOfVariantWrapper = anfp.a(paramArrayOfVariantWrapper);
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.11(this, paramString, paramVariantWrapper, paramArrayOfVariantWrapper));
              }
              return true;
            }
            if (paramString.equals("ShowStatusBar"))
            {
              if (!anfp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.STATUSBAR")) {
                return false;
              }
              if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()))
              {
                l1 = paramArrayOfVariantWrapper[0].GetView();
                paramString = paramArrayOfVariantWrapper[1].GetString();
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.12(this, l1, paramString));
              }
              return true;
            }
            if (paramString.equals("HideStatusBar"))
            {
              if (!anfp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.STATUSBAR")) {
                return false;
              }
              if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
              {
                l1 = paramArrayOfVariantWrapper[0].GetView();
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.13(this, l1));
              }
              return true;
            }
            if (paramString.equals("SetNavigationBarTitle"))
            {
              if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()))
              {
                l1 = paramArrayOfVariantWrapper[0].GetView();
                paramString = paramArrayOfVariantWrapper[1].GetString();
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.14(this, l1, paramString));
              }
              return true;
            }
            if (paramString.equals("ShowShareMenu"))
            {
              if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
              {
                l1 = paramArrayOfVariantWrapper[0].GetView();
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.15(this, l1));
              }
              return true;
            }
            if (paramString.equals("HideShareMenu"))
            {
              if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
              {
                l1 = paramArrayOfVariantWrapper[0].GetView();
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.16(this, l1));
              }
              return true;
            }
            if (paramString.equals("PreviewImage"))
            {
              if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && ((paramArrayOfVariantWrapper[0].IsArray()) || (paramArrayOfVariantWrapper[0].IsTable())) && (paramArrayOfVariantWrapper[1].GetType() == 4))
              {
                paramString = paramArrayOfVariantWrapper[0].GetTableAsJsonString();
                localObject1 = new ArrayList();
                try
                {
                  localObject2 = new JSONArray(paramString);
                  i = 0;
                  if (i < ((JSONArray)localObject2).length())
                  {
                    paramVariantWrapper = ((JSONArray)localObject2).optString(i);
                    if (TextUtils.isEmpty(paramVariantWrapper)) {
                      break label8253;
                    }
                    paramString = paramVariantWrapper;
                    if (!paramVariantWrapper.startsWith("http://"))
                    {
                      paramString = paramVariantWrapper;
                      if (!paramVariantWrapper.startsWith("https://"))
                      {
                        paramString = this.jdField_a_of_type_ComTencentArkArk$Application.GetSystemPathFromLocal(paramVariantWrapper);
                        if (TextUtils.isEmpty(paramString)) {
                          break label8253;
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
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.17(this, i, (ArrayList)localObject1));
              }
              return true;
            }
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
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.18(this, l1, paramString));
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
                anmg.a().a(new anfx(this, l1));
                ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.20(this, j, bool1, paramString));
                return true;
              }
              catch (JSONException paramString)
              {
                QLog.e("ArkApp", 1, "Error:", paramString);
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
              if (lik.a(BaseApplicationImpl.getContext()))
              {
                i = 1;
                QLog.i("ArkApp", 1, "current audio status:" + i);
                paramVariantWrapper.SetInt(i);
                return true;
              }
              if (AudioHelper.a(BaseApplicationImpl.getContext()))
              {
                i = 2;
                continue;
              }
              paramString = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
              if (paramString != null)
              {
                if (paramString.t())
                {
                  i = 4;
                  continue;
                }
                i = 3;
                continue;
              }
            }
            else if (paramString.equals("IsMute"))
            {
              if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 1))
              {
                bool1 = paramArrayOfVariantWrapper[0].GetBool();
                if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() != null)
                {
                  paramString = (AudioManager)BaseApplicationImpl.sApplication.getSystemService("audio");
                  if (paramString != null)
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
                          if ((Math.abs(l1 - jdField_d_of_type_Long) >= 120000L) || (l1 <= jdField_d_of_type_Long)) {
                            continue;
                          }
                          if (QLog.isColorLevel()) {
                            QLog.e("ArkApp", 2, "IsMute() do not show toast so frequently in 2 min");
                          }
                        }
                        paramVariantWrapper.SetBool(bool2);
                        return true;
                      }
                    }
                    catch (Exception paramString)
                    {
                      QLog.e("ArkApp", 1, "IsMute() error:", paramString);
                      return false;
                    }
                    bool2 = false;
                    continue;
                    if (QLog.isColorLevel()) {
                      QLog.e("ArkApp", 2, "IsMute() show toast");
                    }
                    jdField_d_of_type_Long = l1;
                    localObject1 = aoho.b(380).a();
                    paramArrayOfVariantWrapper = "";
                    paramString = paramArrayOfVariantWrapper;
                    if (localObject1 != null)
                    {
                      paramString = paramArrayOfVariantWrapper;
                      if (((aohn)localObject1).a() != null) {
                        paramString = ((aohn)localObject1).a().b;
                      }
                    }
                    paramArrayOfVariantWrapper = paramString;
                    if (TextUtils.isEmpty(paramString))
                    {
                      paramArrayOfVariantWrapper = paramString;
                      if (BaseActivity.sTopActivity != null) {
                        paramArrayOfVariantWrapper = BaseActivity.sTopActivity.getString(2131690292);
                      }
                    }
                    ArkDispatchTask.getInstance().postToMainThread(new ArkAppModuleReg.ModuleQQ.21(this, paramArrayOfVariantWrapper));
                    continue;
                  }
                }
                return false;
              }
            }
            else if (paramString.equals("GetNickNameByView"))
            {
              if (paramArrayOfVariantWrapper != null)
              {
                l1 = paramArrayOfVariantWrapper.length;
                if (l1 <= 0L)
                {
                  QLog.d("ArkApp", 1, "ark.GetNickNameByView invalid param args == 0 ");
                  return false;
                }
              }
              else
              {
                l1 = 0L;
                continue;
              }
              localObject2 = anfp.a();
              if (localObject2 == null)
              {
                QLog.d("ArkApp", 1, "ark.GetNickNameByView invalid param appInterface == null ");
                return false;
              }
              localObject1 = null;
              if ((l1 < 1L) || (!paramArrayOfVariantWrapper[0].IsView())) {
                continue;
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
              if (!TextUtils.isEmpty(paramString)) {
                continue;
              }
              localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
              if (l2 != 0L)
              {
                paramString = ark.arkGetContainer(l2);
                if (paramString == null) {
                  continue;
                }
                paramString = (afdt)afdt.a(paramString).get();
                if (!(paramString instanceof afds)) {
                  continue;
                }
                paramArrayOfVariantWrapper = ((afds)paramString).a();
                paramString = paramArrayOfVariantWrapper;
                if (paramArrayOfVariantWrapper == null) {
                  paramString = anfp.a();
                }
                paramArrayOfVariantWrapper = paramString;
                if (QLog.isColorLevel())
                {
                  QLog.d("ArkApp", 2, new Object[] { "ark.GetNickNameByView Extra ViewID viewHandle=", Long.valueOf(l2), anfp.a(paramString) });
                  paramArrayOfVariantWrapper = paramString;
                }
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  if (paramArrayOfVariantWrapper == null) {
                    continue;
                  }
                  paramArrayOfVariantWrapper = bdbt.a((QQAppInterface)localObject2, paramArrayOfVariantWrapper, ((String)localObject1).equals(((QQAppInterface)localObject2).c()), (String)localObject1);
                  if (paramArrayOfVariantWrapper != null)
                  {
                    paramString = paramArrayOfVariantWrapper;
                    if (!TextUtils.equals(paramArrayOfVariantWrapper, (CharSequence)localObject1)) {}
                  }
                  else
                  {
                    paramArrayOfVariantWrapper = bdbt.q((QQAppInterface)localObject2, (String)localObject1);
                    paramString = paramArrayOfVariantWrapper;
                    if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
                      paramString = bdbt.a((QQAppInterface)localObject2, (String)localObject1, 0);
                    }
                  }
                  paramVariantWrapper.SetString(paramString);
                  if ((paramString != null) && (QLog.isColorLevel())) {
                    QLog.d("ArkApp", 2, new Object[] { "ark.GetNickNameByView ", paramString });
                  }
                  return true;
                }
              }
              else
              {
                paramString = anfp.a();
                paramArrayOfVariantWrapper = paramString;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("ArkApp", 2, new Object[] { "ark.GetNickNameByView old activity=", BaseActivity.sTopActivity, anfp.a(paramString) });
                paramArrayOfVariantWrapper = paramString;
                continue;
              }
              return false;
            }
            else
            {
              if (paramString.equals("GetAppInfo"))
              {
                localObject1 = new JSONObject();
                try
                {
                  ((JSONObject)localObject1).put("package", BaseApplicationImpl.getApplication().getPackageName());
                  ((JSONObject)localObject1).put("name", BaseApplicationImpl.getApplication().getString(2131690192));
                  paramArrayOfVariantWrapper = bdcb.c();
                  paramString = paramArrayOfVariantWrapper;
                  if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
                    paramString = "8.3.3";
                  }
                  ((JSONObject)localObject1).put("version", paramString);
                }
                catch (Exception paramString)
                {
                  QLog.e("ArkApp", 1, "ark.GetAppInfo: ", paramString);
                  continue;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ArkApp", 2, new Object[] { "ark.GetAppInfo: ", ((JSONObject)localObject1).toString() });
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
                    yht.a(BaseApplicationImpl.getContext(), paramString, new anfz(this, l1));
                  } else {
                    yht.c(BaseApplicationImpl.getContext(), paramString, new anga(this, l1));
                  }
                }
                catch (Exception paramString)
                {
                  paramString.printStackTrace();
                }
              }
              return false;
            }
          }
        }
      }
      catch (JSONException paramArrayOfVariantWrapper)
      {
        paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject2;
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
        i = -1;
        continue;
        paramString = null;
        continue;
        bool1 = true;
        continue;
        paramArrayOfVariantWrapper = null;
        continue;
        paramString = null;
        continue;
        paramString = paramArrayOfVariantWrapper;
        continue;
        continue;
      }
      label8205:
      break label8240;
      label8208:
      continue;
      label8211:
      continue;
      label8214:
      Object localObject4 = null;
      continue;
      label8220:
      Object localObject3 = null;
      continue;
      label8226:
      paramArrayOfVariantWrapper = null;
      continue;
      label8231:
      l1 = 0L;
      localObject1 = null;
      break;
      label8240:
      continue;
      label8243:
      continue;
      label8246:
      continue;
      return true;
      label8251:
      return true;
      label8253:
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
        paramSosoLbsInfo.a.e = ((String)localObject);
      }
      localObject = ArkAppCenter.a();
      if ((localObject != null) && (localObject.length == 2))
      {
        paramSosoLbsInfo.a.c = localObject[0];
        paramSosoLbsInfo.a.jdField_d_of_type_Double = localObject[1];
      }
      localObject = "{}";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("prov", paramSosoLbsInfo.a.jdField_d_of_type_JavaLangString);
      localJSONObject.put("city", paramSosoLbsInfo.a.e);
      localJSONObject.put("dist", paramSosoLbsInfo.a.g);
      localJSONObject.put("road", paramSosoLbsInfo.a.j);
      localJSONObject.put("town", paramSosoLbsInfo.a.h);
      localJSONObject.put("lat", paramSosoLbsInfo.a.c);
      localJSONObject.put("lng", paramSosoLbsInfo.a.jdField_d_of_type_Double);
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
        ArkAppCenter.c("ArkApp", paramSosoLbsInfo.getMessage());
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
  
  public void a(List<anhq> paramList)
  {
    super.a(paramList);
    a("OpenUrl", 1L, 500L);
    a("SendMessage", 1L, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfv
 * JD-Core Version:    0.7.0.1
 */