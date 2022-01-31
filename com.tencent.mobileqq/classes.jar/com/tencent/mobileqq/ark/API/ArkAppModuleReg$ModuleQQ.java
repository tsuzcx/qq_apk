package com.tencent.mobileqq.ark.API;

import aawb;
import aawc;
import aawd;
import aawe;
import aawf;
import aawg;
import aawh;
import aawi;
import aawj;
import aawl;
import aawm;
import aawn;
import aawo;
import aawp;
import aawv;
import aaxb;
import aaxc;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkViewModelBase.TimeRecord;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.Container;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager;
import com.tencent.mobileqq.activity.aio.item.ArkDataRequestObj;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkAppInfo.TimeRecord;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
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

public class ArkAppModuleReg$ModuleQQ
  extends ArkAppModuleReg.ModuleBase
{
  protected ArkAppLocationManager a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver;
  private HashMap b = new HashMap();
  private HashMap c = new HashMap();
  private HashMap d = new HashMap();
  
  public ArkAppModuleReg$ModuleQQ()
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager = new ArkAppLocationManager(30000L);
    }
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0).getInt("key_ark_authority_info" + "_" + paramString1 + "_" + paramString2 + "_" + paramString3, 0);
  }
  
  public static ArrayList a(String paramString)
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
  
  private void a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt)
  {
    Object localObject2 = ArkAppModuleReg.a();
    if ((localObject2 != null) && (1 == paramInt))
    {
      localObject1 = this.jdField_a_of_type_JavaLangString + "_" + paramLong3 + "_" + paramString;
      if ((this.c.containsKey(localObject1)) && (!TextUtils.isEmpty((CharSequence)this.c.get(localObject1))) && (this.d.containsKey(localObject1)) && (!TextUtils.isEmpty((CharSequence)this.d.get(localObject1))))
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
      ((ark.VariantWrapper)localObject2).SetTableAsJsonString(String.format(Locale.CHINA, "{\"openid\":\"%s\",\"token\":\"%s\"}", new Object[] { this.c.get(localObject1), this.d.get(localObject1) }));
      localObject1 = paramString.Create();
      paramString.InvokeDefault(new ark.VariantWrapper[] { localObject2 }, (ark.VariantWrapper)localObject1);
      ((ark.VariantWrapper)localObject1).Reset();
      ((ark.VariantWrapper)localObject2).Reset();
      paramString.Reset();
      return;
      if (this.jdField_a_of_type_MqqObserverWtloginObserver == null) {
        this.jdField_a_of_type_MqqObserverWtloginObserver = new aawj(this, paramLong1);
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
  
  private void a(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    QQAppInterface localQQAppInterface = ArkAppModuleReg.a();
    Object localObject;
    String str2;
    String str1;
    if ((localQQAppInterface != null) && (paramBoolean) && (1 == paramInt))
    {
      localObject = ((FriendsManager)localQQAppInterface.getManager(50)).a(paramString);
      if (localObject != null)
      {
        str2 = ((Card)localObject).strNick;
        if (((Card)localObject).shGender == 0) {
          str1 = BaseActivity.sTopActivity.getString(2131433957);
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
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.url)))
      {
        paramString = MsfSdkUtils.insertMtype("QQHeadIcon", ((FriendListHandler)localQQAppInterface.a(1)).a().a(paramString.url, paramString.bFaceFlags, paramString.bUsrType, 0));
        label167:
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp", 2, "GetUserInformation nickname=" + str2 + ", avatarUrl=" + paramString + ", gender=" + str1 + ", city=" + str3 + ", province=" + str4 + ", country=" + str5);
        }
        localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, "{\"nickname\":\"%s\",\"avatar\":\"%s\",\"gender\":\"%s\",\"city\":\"%s\",\"province\":\"%s\",\"country\":\"%s\"}", new Object[] { str2, paramString, str1, str3, str4, str5 }));
      }
      for (paramInt = 0;; paramInt = 1)
      {
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
          break label422;
        }
        str1 = BaseActivity.sTopActivity.getString(2131433958);
        break;
        paramString = (String)localObject;
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.d("ArkApp", 2, "GetUserInformation QQHeadSetting is empty");
        paramString = (String)localObject;
        break label167;
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp", 2, "GetUserInformation FriendCard is null");
        }
      }
      label422:
      str1 = "";
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager.a();
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
        return true;
      } while ((paramString.equals("GetVersion")) || (paramString.equals("GetPerformance")) || (paramString.equals("Login")) || (paramString.equals("GetUserInformation")) || (paramString.equals("OpenView")) || (paramString.equals("CloseView")) || (paramString.equals("ShareView")) || (paramString.equals("ShowStatusBar")) || (paramString.equals("HideStatusBar")) || (paramString.equals("SetNavigationBarTitle")) || (paramString.equals("ShowShareMenu")) || (paramString.equals("HideShareMenu")) || (paramString.equals("PreviewImage")));
      if (this.jdField_a_of_type_Long != 0L) {
        break;
      }
    } while ((paramString.equals("GetSkey")) || (paramString.equals("GetPskey")) || (paramString.equals("GetUIN")) || (paramString.equals("GetNickName")) || (paramString.equals("Report")) || (paramString.equals("Log")) || (paramString.equals("GetContainerInfo")) || (paramString.equals("DataRequest")) || (paramString.equals("GetCurrentPosition")) || (paramString.equals("WatchPosition")) || (paramString.equals("ClearWatch")) || (paramString.equals("GetCurrentAddress")) || (paramString.equals("SendMessage")));
    return !paramString.equals("TestGetJson");
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!a(paramString)) {
      return false;
    }
    if (paramString.equals("GetSkey"))
    {
      paramString = "";
      paramArrayOfVariantWrapper = ArkAppModuleReg.a();
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
        localObject1 = ArkAppModuleReg.a();
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
    Object localObject3;
    long l1;
    label286:
    label299:
    boolean bool;
    int i;
    label432:
    Object localObject2;
    if (paramString.equals("OpenUrl"))
    {
      paramVariantWrapper.SetBool(false);
      localObject3 = BaseActivity.sTopActivity;
      if (((localObject3 instanceof FragmentActivity)) && (paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        if (!TextUtils.isEmpty(paramString))
        {
          if (paramArrayOfVariantWrapper.length <= 1) {
            break label5020;
          }
          if (!paramArrayOfVariantWrapper[1].IsView()) {
            break label286;
          }
          l1 = paramArrayOfVariantWrapper[1].GetView();
          paramArrayOfVariantWrapper = null;
          if (!ArkAppSchemeCenter.a(paramString, paramArrayOfVariantWrapper, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString)) {
            break label299;
          }
          ArkAppDataReport.k(null, this.jdField_a_of_type_JavaLangString);
          paramVariantWrapper.SetBool(true);
          paramArrayOfVariantWrapper = paramString;
        }
      }
      for (;;)
      {
        Log.d("ark.OpenUrl ", paramArrayOfVariantWrapper);
        ArkAppDataReport.j(null, this.jdField_a_of_type_JavaLangString);
        return true;
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
        l1 = 0L;
        break;
        if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
        {
          if (!ArkAppModuleReg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, "permission.BROWSER")) {
            return false;
          }
          localObject1 = ark.Application.Create(((ArkAppCenter)ArkAppModuleReg.a().getManager(120)).a().a(this.jdField_a_of_type_JavaLangString, null));
          if ((localObject1 != null) && (!TextUtils.isEmpty(paramString)))
          {
            bool = ((ark.Application)localObject1).CheckUrlLegality(paramString);
            ((ark.Application)localObject1).Release();
            if (!bool) {
              return false;
            }
          }
          if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
            break label5017;
          }
          for (;;)
          {
            try
            {
              JSONObject localJSONObject = new JSONObject(paramArrayOfVariantWrapper);
              Iterator localIterator = localJSONObject.keys();
              paramArrayOfVariantWrapper = new String();
              i = 0;
              if (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                localObject1 = null;
                if ((localJSONObject.get(str) instanceof String))
                {
                  localObject1 = localJSONObject.getString(str);
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break label5014;
                  }
                  localObject2 = paramArrayOfVariantWrapper;
                  if (i != 0) {
                    localObject2 = paramArrayOfVariantWrapper + "&";
                  }
                  paramArrayOfVariantWrapper = (String)localObject2 + str + "=" + (String)localObject1;
                  i = 1;
                  break label5028;
                }
                if (!(localJSONObject.get(str) instanceof Number)) {
                  continue;
                }
                localObject1 = ((Number)localJSONObject.get(str)).toString();
                continue;
              }
              if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
                break label5011;
              }
              if (paramString.indexOf("?", 0) != -1) {
                continue;
              }
              paramArrayOfVariantWrapper = paramString + paramArrayOfVariantWrapper;
              paramString = paramArrayOfVariantWrapper;
            }
            catch (JSONException paramArrayOfVariantWrapper)
            {
              label626:
              continue;
              ArkAppDataReport.k(null, this.jdField_a_of_type_JavaLangString);
              continue;
              ArkAppModuleReg.a((Context)localObject3, paramString, true, 0L, null);
              continue;
            }
            paramArrayOfVariantWrapper = (FragmentActivity)localObject3;
            if (paramArrayOfVariantWrapper.getChatFragment() != null)
            {
              paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.getChatFragment().a();
              if (!(paramArrayOfVariantWrapper instanceof PublicAccountChatPie)) {
                continue;
              }
              ((PublicAccountChatPie)paramArrayOfVariantWrapper).a.b();
            }
            localObject1 = null;
            paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
            if (l1 != 0L)
            {
              localObject2 = ark.arkGetContainer(l1);
              paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
              if (localObject2 != null)
              {
                localObject2 = (ArkAppContainer)ArkAppContainer.a((ark.Container)localObject2).get();
                paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
                if (localObject2 != null)
                {
                  paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
                  if ((localObject2 instanceof ArkAioContainerWrapper)) {
                    paramArrayOfVariantWrapper = (MessageForArkApp)((ArkAioContainerWrapper)localObject2).jdField_a_of_type_JavaLangRefWeakReference.get();
                  }
                }
              }
            }
            if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.ark_app_message == null)) {
              continue;
            }
            ArkAppModuleReg.a((Context)localObject3, paramString, true, 0L, paramArrayOfVariantWrapper);
            paramVariantWrapper.SetBool(true);
            paramArrayOfVariantWrapper = paramString;
            break;
            paramArrayOfVariantWrapper = paramString + "&" + paramArrayOfVariantWrapper;
            paramString = paramArrayOfVariantWrapper;
          }
        }
        paramArrayOfVariantWrapper = paramString;
        if (this.jdField_a_of_type_Long == 0L)
        {
          paramVariantWrapper = JumpParser.a(ArkAppModuleReg.a(), (Context)localObject3, paramString);
          paramArrayOfVariantWrapper = paramString;
          if (paramVariantWrapper != null)
          {
            paramVariantWrapper.b();
            paramArrayOfVariantWrapper = paramString;
          }
        }
      }
    }
    else
    {
      if (paramString.equals("GetUIN"))
      {
        paramString = "";
        paramArrayOfVariantWrapper = ArkAppModuleReg.a();
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
        paramString = ArkAppModuleReg.a();
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
              break label1075;
            }
          }
        }
        for (;;)
        {
          try
          {
            Long.parseLong(paramVariantWrapper);
            ReportController.b(paramString, "CliOper", "", (String)localObject1, "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), paramVariantWrapper, paramArrayOfVariantWrapper, "");
            ArkAppDataReport.k(paramString, this.jdField_a_of_type_JavaLangString, paramArrayOfVariantWrapper, i);
            return true;
          }
          catch (Exception paramVariantWrapper)
          {
            ReportController.b(paramString, "CliOper", "", (String)localObject1, "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), "0", paramArrayOfVariantWrapper, "");
            continue;
          }
          label1075:
          ReportController.b(paramString, "CliOper", "", (String)localObject1, "0X8005FFE", "0X8005FFE", i, 0, Long.toString(l1), "0", paramArrayOfVariantWrapper, "");
        }
      }
      if (paramString.equals("GetVersion"))
      {
        paramArrayOfVariantWrapper = DeviceInfoUtil.d();
        paramString = paramArrayOfVariantWrapper;
        if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {
          paramString = "7.6.8";
        }
        paramVariantWrapper.SetString(paramString);
        return true;
      }
      int j;
      if (paramString.equals("Log"))
      {
        if (paramArrayOfVariantWrapper != null) {}
        for (l1 = paramArrayOfVariantWrapper.length; l1 <= 0L; l1 = 0L) {
          return true;
        }
        paramString = paramArrayOfVariantWrapper[0];
        i = paramString.GetType();
        j = ArkAppModuleReg.a(paramArrayOfVariantWrapper, l1);
        if (i == 1) {
          QLog.i("ArkApp.QQLog", j, "nil");
        }
        for (;;)
        {
          return true;
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
          } else if (paramString.IsArray()) {
            QLog.i("ArkApp.QQLog", j, paramString.GetTableAsJsonString());
          } else if (paramString.IsFunction()) {
            QLog.i("ArkApp.QQLog", j, "Function Object");
          } else if (paramString.IsUserObject()) {
            QLog.i("ArkApp.QQLog", j, "User Object");
          } else {
            QLog.i("ArkApp.QQLog", j, "Unknown Object");
          }
        }
      }
      if (paramString.equals("GetNickName"))
      {
        paramString = null;
        localObject2 = ArkAppModuleReg.a();
        if (localObject2 == null) {
          return false;
        }
        if (paramArrayOfVariantWrapper != null)
        {
          l1 = paramArrayOfVariantWrapper.length;
          if (l1 != 1L) {
            break label1545;
          }
          paramString = paramArrayOfVariantWrapper[0].GetString();
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(paramString))
          {
            localObject1 = null;
            if (!TextUtils.isEmpty(ArkAppContainer.jdField_a_of_type_JavaLangString)) {
              localObject1 = ContactUtils.g((QQAppInterface)localObject2, ArkAppContainer.jdField_a_of_type_JavaLangString, paramString);
            }
            if (localObject1 != null)
            {
              paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
              if (!TextUtils.equals((CharSequence)localObject1, paramString)) {
                break label5006;
              }
            }
            localObject1 = ContactUtils.q((QQAppInterface)localObject2, paramString);
            paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break label5006;
            }
            paramString = ContactUtils.a((QQAppInterface)localObject2, paramString, 0);
            label1519:
            paramVariantWrapper.SetString(paramString);
            if (paramString != null) {
              Log.d("ark.GetNickName ", paramString);
            }
          }
          return true;
          l1 = 0L;
          break;
          label1545:
          if (l1 == 0L) {
            paramString = ((QQAppInterface)localObject2).getCurrentAccountUin();
          }
        }
      }
      if (paramString.equals("GetContainerInfo"))
      {
        paramArrayOfVariantWrapper = new HashMap();
        if ((BaseActivity.sTopActivity instanceof FragmentActivity))
        {
          paramString = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
          if (paramString != null)
          {
            paramString = paramString.a();
            if (paramString != null)
            {
              localObject1 = paramString.a();
              if (localObject1 != null)
              {
                paramArrayOfVariantWrapper.put("ChatUIN", ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString);
                paramString = String.format("%d", new Object[] { Integer.valueOf(-1) });
                switch (((SessionInfo)localObject1).jdField_a_of_type_Int)
                {
                }
              }
            }
          }
        }
        for (;;)
        {
          paramArrayOfVariantWrapper.put("ChatType", paramString);
          paramVariantWrapper.SetMap(paramArrayOfVariantWrapper);
          return true;
          paramString = String.format("%d", new Object[] { Integer.valueOf(1) });
          continue;
          paramString = String.format("%d", new Object[] { Integer.valueOf(2) });
          continue;
          paramString = String.format("%d", new Object[] { Integer.valueOf(3) });
          continue;
          paramString = String.format("%d", new Object[] { Integer.valueOf(4) });
          continue;
          paramString = String.format("%d", new Object[] { Integer.valueOf(5) });
          continue;
          paramString = String.format("%d", new Object[] { Integer.valueOf(6) });
        }
      }
      if (paramString.equals("DataRequest"))
      {
        paramString = ArkAppModuleReg.a();
        if (paramString == null)
        {
          paramVariantWrapper.SetNull();
          return true;
        }
        paramVariantWrapper.CreateObject("DataRequest", new ArkDataRequestObj(paramString));
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
            paramArrayOfVariantWrapper = ArkAioContainerWrapper.a(paramString);
            if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.arkContainer == null))
            {
              ArkAppCenter.b("ArkApp", String.format("QQ.GetPerformance, arkAppMsg is null, viewID=%s", new Object[] { paramString }));
            }
            else
            {
              paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.arkContainer.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$TimeRecord;
              if (paramArrayOfVariantWrapper != null) {
                break;
              }
              ArkAppCenter.b("ArkApp", String.format("QQ.GetPerformance, timeRecord is null, viewID=%s", new Object[] { paramString }));
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
            ((JSONObject)localObject2).put("GetApplicationStart", 0.01D + paramArrayOfVariantWrapper.jdField_a_of_type_Long);
            ((JSONObject)localObject2).put("GetApplicationEnd", 0.01D + paramArrayOfVariantWrapper.b);
            ((JSONObject)localObject2).put("FetchApplicationStart", 0.01D + paramArrayOfVariantWrapper.jdField_a_of_type_Long);
            ((JSONObject)localObject2).put("FetchApplicationEnd", 0.01D + paramArrayOfVariantWrapper.b);
            ((JSONObject)localObject2).put("CreateViewStart", 0.01D + paramArrayOfVariantWrapper.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.beginOfCreateView);
            ((JSONObject)localObject2).put("CreateViewEnd", 0.01D + paramArrayOfVariantWrapper.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.endOfCreateView);
            ((JSONObject)localObject2).put("DisplayViewStart", 0.01D + paramArrayOfVariantWrapper.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.beginOfDisplyView);
            ((JSONObject)localObject2).put("DisplayViewEnd", 0.01D + paramArrayOfVariantWrapper.jdField_a_of_type_ComTencentArkArkViewModelBase$TimeRecord.endOfDisplyView);
            localObject2 = new JSONObject();
            ((JSONObject)localObject1).put("Navigation", localObject2);
            if (!paramArrayOfVariantWrapper.jdField_a_of_type_Boolean) {
              continue;
            }
            i = 1;
            ((JSONObject)localObject2).put("FetchApplicationFromCache", i);
            paramArrayOfVariantWrapper = ((JSONObject)localObject1).toString();
            paramString = paramArrayOfVariantWrapper;
          }
          catch (Exception paramArrayOfVariantWrapper)
          {
            ArkAppCenter.b("ArkApp", String.format("QQ.GetPerformance, json exception, msg=%s", new Object[] { paramArrayOfVariantWrapper.getMessage() }));
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
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp", 2, String.format("GetCurrentPosition.app.%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
        }
        l1 = a(paramArrayOfVariantWrapper[0].Copy());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager.b(new aawb(this, l1));
        return true;
      }
      if (paramString.equals("WatchPosition"))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp", 2, String.format("WatchPosition.app.%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
        }
        l1 = a(paramArrayOfVariantWrapper[0].Copy());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager.a(new aawl(this, l1));
        return true;
      }
      if (paramString.equals("ClearWatch"))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager == null) {
          return false;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager.b();
        return true;
      }
      if (paramString.equals("GetCurrentAddress"))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager == null) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (paramArrayOfVariantWrapper[0] == null) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
          return false;
        }
        l1 = a(paramArrayOfVariantWrapper[0].Copy());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager.a(new aawm(this, l1));
        return true;
      }
      if (paramString.equals("SendMessage"))
      {
        if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsArray())) {
          return false;
        }
        paramVariantWrapper = paramArrayOfVariantWrapper[0].GetTableAsJsonString();
        label2702:
        do
        {
          try
          {
            paramString = new JSONObject(paramVariantWrapper);
            if ((paramArrayOfVariantWrapper.length <= 1) || (paramArrayOfVariantWrapper[1].GetType() != 2)) {
              break;
            }
            bool = paramArrayOfVariantWrapper[1].GetBool();
            if (paramString.has("light"))
            {
              localObject1 = new ArkAppMessage();
              ((ArkAppMessage)localObject1).appMinVersion = "0.0.0.1";
              paramString = paramString.getJSONObject("light");
              ((ArkAppMessage)localObject1).appName = paramString.getString("Application");
              if (TextUtils.isEmpty(((ArkAppMessage)localObject1).appName)) {
                return false;
              }
              ((ArkAppMessage)localObject1).appView = paramString.getString("View");
              if (TextUtils.isEmpty(((ArkAppMessage)localObject1).appView)) {
                return false;
              }
              paramArrayOfVariantWrapper = ArkAppCenter.a(((ArkAppMessage)localObject1).appName, ((ArkAppMessage)localObject1).appMinVersion);
              if (paramArrayOfVariantWrapper != null)
              {
                ((ArkAppMessage)localObject1).appDesc = ((String)paramArrayOfVariantWrapper.get("desc"));
                ((ArkAppMessage)localObject1).appMinVersion = ((String)paramArrayOfVariantWrapper.get("version"));
              }
              if (TextUtils.isEmpty(((ArkAppMessage)localObject1).appDesc)) {
                ((ArkAppMessage)localObject1).appDesc = ((ArkAppMessage)localObject1).appName;
              }
              ((ArkAppMessage)localObject1).promptText = paramString.optString("Prompt");
              if (TextUtils.isEmpty(((ArkAppMessage)localObject1).promptText)) {
                ((ArkAppMessage)localObject1).promptText = String.format("[应用]%s", new Object[] { ((ArkAppMessage)localObject1).appDesc });
              }
              ((ArkAppMessage)localObject1).metaList = paramString.getJSONObject("MetaData").toString();
              paramArrayOfVariantWrapper = paramString.optJSONObject("Config");
              paramString = paramArrayOfVariantWrapper;
              if (paramArrayOfVariantWrapper == null) {
                paramString = new JSONObject();
              }
              paramString.put("forward", 1);
              ((ArkAppMessage)localObject1).config = paramString.toString();
              if (bool)
              {
                if ((BaseActivity.sTopActivity instanceof FragmentActivity))
                {
                  paramString = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
                  if (paramString != null)
                  {
                    paramString = paramString.a();
                    if (paramString != null)
                    {
                      paramString = paramString.a();
                      if (paramString != null)
                      {
                        ChatActivityFacade.b(ArkAppModuleReg.a(), paramString, (ArkAppMessage)localObject1);
                        if (QLog.isColorLevel()) {
                          QLog.i("ArkApp", 1, "QQ.SendMessage light currentChat success");
                        }
                      }
                    }
                  }
                }
              }
              else {
                ArkAppCenter.a().postToMainThread(new aawn(this, (ArkAppMessage)localObject1));
              }
            }
          }
          catch (JSONException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ArkApp", 1, "QQ.SendMessage parameter error: " + paramString.getMessage());
            }
            if (QLog.isColorLevel()) {
              QLog.i("ArkApp", 1, String.format("QQ.SendMessage fail, packet:%s", new Object[] { paramVariantWrapper }));
            }
            return false;
          }
        } while (!paramString.has("text"));
        paramString = paramString.getString("text");
        if (bool)
        {
          if (!(BaseActivity.sTopActivity instanceof FragmentActivity)) {
            break label5033;
          }
          paramArrayOfVariantWrapper = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
          if (paramArrayOfVariantWrapper == null) {
            break label5033;
          }
          paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.a();
          if (paramArrayOfVariantWrapper == null) {
            break label5033;
          }
          localObject1 = paramArrayOfVariantWrapper.a();
          paramArrayOfVariantWrapper = ArkAppModuleReg.a();
          if ((localObject1 == null) || (paramArrayOfVariantWrapper == null)) {
            break label5033;
          }
          paramString = MessageRecordFactory.a(ArkAppModuleReg.a(), ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject1).b, ((SessionInfo)localObject1).b, ((SessionInfo)localObject1).jdField_a_of_type_Int, (byte)1, (byte)0, (short)0, paramString);
          paramArrayOfVariantWrapper.a().a(paramString, null);
          if (!QLog.isColorLevel()) {
            break label5033;
          }
          QLog.i("ArkApp", 1, "QQ.SendMessage text currentChat success");
          break label5033;
        }
        ArkAppCenter.a().postToMainThread(new aawo(this, paramString));
        break label5033;
      }
      else
      {
        if (paramString.equals("Login"))
        {
          if (!ArkAppModuleReg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, "permission.LOGIN")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[1].IsFunction())) {
            return false;
          }
          try
          {
            l1 = Long.parseLong(paramArrayOfVariantWrapper[0].GetString());
            paramString = null;
            paramVariantWrapper = ArkAppModuleReg.a();
            if (paramVariantWrapper != null) {
              paramString = paramVariantWrapper.getCurrentAccountUin();
            }
            if ((paramVariantWrapper == null) || (TextUtils.isEmpty(paramString))) {
              return false;
            }
          }
          catch (NumberFormatException paramString)
          {
            return false;
          }
          long l2 = a(paramArrayOfVariantWrapper[1].Copy());
          localObject1 = ((ArkAppCenter)paramVariantWrapper.getManager(120)).a().a(this.jdField_a_of_type_JavaLangString, null);
          paramVariantWrapper = ArkAppCenter.b((String)localObject1);
          paramArrayOfVariantWrapper = paramVariantWrapper;
          if (TextUtils.isEmpty(paramVariantWrapper)) {
            paramArrayOfVariantWrapper = String.valueOf(l1);
          }
          paramVariantWrapper = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
          localObject2 = "key_ark_authority_show_dialog" + "_" + paramArrayOfVariantWrapper + "_" + "ark_authority_api_login" + "_" + paramString;
          if (!paramVariantWrapper.getBoolean((String)localObject2, false))
          {
            ArkAppCenter.a().postToMainThread(new aawp(this, paramArrayOfVariantWrapper, (String)localObject1, l2, paramString, l1));
            paramVariantWrapper.edit().putBoolean((String)localObject2, true).commit();
            a(paramArrayOfVariantWrapper, paramString);
          }
          for (;;)
          {
            return true;
            a(l2, paramString, 16L, l1, a(paramArrayOfVariantWrapper, "ark_authority_api_login", paramString));
          }
        }
        if (paramString.equals("GetUserInformation"))
        {
          if (!ArkAppModuleReg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, "permission.USER_INFORMATION")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
            return false;
          }
          paramString = null;
          localObject1 = ArkAppModuleReg.a();
          if (localObject1 != null) {
            paramString = ((QQAppInterface)localObject1).getCurrentAccountUin();
          }
          if ((localObject1 == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
            return false;
          }
          l1 = a(paramArrayOfVariantWrapper[0].Copy());
          j = 0;
          paramVariantWrapper = (String)this.b.get(this.jdField_a_of_type_JavaLangString);
          i = j;
          if (!TextUtils.isEmpty(paramVariantWrapper))
          {
            paramArrayOfVariantWrapper = this.jdField_a_of_type_JavaLangString + "_" + paramVariantWrapper + "_" + paramString;
            i = j;
            if (this.c.containsKey(paramArrayOfVariantWrapper))
            {
              i = j;
              if (!TextUtils.isEmpty((CharSequence)this.c.get(paramArrayOfVariantWrapper)))
              {
                i = j;
                if (this.d.containsKey(paramArrayOfVariantWrapper))
                {
                  i = j;
                  if (!TextUtils.isEmpty((CharSequence)this.d.get(paramArrayOfVariantWrapper))) {
                    i = 1;
                  }
                }
              }
            }
          }
          localObject2 = ((ArkAppCenter)((QQAppInterface)localObject1).getManager(120)).a().a(this.jdField_a_of_type_JavaLangString, null);
          localObject1 = ArkAppCenter.b((String)localObject2);
          paramArrayOfVariantWrapper = (ark.VariantWrapper[])localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramArrayOfVariantWrapper = paramVariantWrapper;
          }
          if (i == 0)
          {
            a(l1, paramString, false, a(paramArrayOfVariantWrapper, "ark_authority_api_user_info", paramString));
            return true;
          }
          paramVariantWrapper = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
          localObject1 = "key_ark_authority_show_dialog" + "_" + paramArrayOfVariantWrapper + "_" + "ark_authority_api_user_info" + "_" + paramString;
          if (!paramVariantWrapper.getBoolean((String)localObject1, false))
          {
            ArkAppCenter.a().postToMainThread(new aawv(this, paramArrayOfVariantWrapper, (String)localObject2, l1, paramString));
            paramVariantWrapper.edit().putBoolean((String)localObject1, true).commit();
            a(paramArrayOfVariantWrapper, paramString);
          }
          for (;;)
          {
            return true;
            a(l1, paramString, true, a(paramArrayOfVariantWrapper, "ark_authority_api_user_info", paramString));
          }
        }
        if (paramString.equals("TestGetJson")) {
          return paramVariantWrapper.SetTableAsJsonString("{ \"ret\":0, \"msg\":\"ok\", \"data\":{ \"param_array\": [ 3.1400000000000001, true, \"hello\", { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, { }, 1 ], \"param_bool_false\": false, \"param_bool_true\": true, \"param_double\": 3.1400000000000001, \"param_int\": 0, \"param_int2\": -1, \"param_int3\": 1001, \"param_str_empty\": \"\", \"param_str_hello\": \"hello\", \"param_table\": { \"param1\": 0, \"param2\": 3.1400000000000001, \"param3\": true, \"param4\": \"hello\", \"param5\": { }, \"param6\": { \"param10\": 10, \"param11\": 10.1, \"param12\": true, \"param13\": \"hello 10\" }, \"param7\": \"\" } }}");
        }
        if (paramString.equals("OpenView"))
        {
          if (!ArkAppModuleReg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, "permission.OPENVIEW")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 4) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()) && (paramArrayOfVariantWrapper[2].IsString()) && (paramArrayOfVariantWrapper[3].IsArray()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            paramString = paramArrayOfVariantWrapper[1].GetString();
            paramVariantWrapper = paramArrayOfVariantWrapper[2].GetString();
            paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[3].GetTableAsJsonString();
            QLog.d("ArkOpenView", 1, "OpenView holder=" + l1 + ", type=" + paramString + ", view=" + paramVariantWrapper + ", meta=" + paramArrayOfVariantWrapper);
            ArkAppCenter.a().postToMainThread(new aaxb(this, paramString, paramVariantWrapper, paramArrayOfVariantWrapper, l1));
          }
          return true;
        }
        if (paramString.equals("CloseView"))
        {
          if (!ArkAppModuleReg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, "permission.OPENVIEW")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            ArkAppCenter.a().postToMainThread(new aaxc(this, l1));
          }
          return true;
        }
        if (paramString.equals("ShareView"))
        {
          if (!ArkAppModuleReg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, "permission.SHARE")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && (paramArrayOfVariantWrapper[1].IsArray()))
          {
            paramString = paramArrayOfVariantWrapper[0].GetString();
            paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1].GetTableAsJsonString();
            ArkAppCenter.a().postToMainThread(new aawc(this, paramString, paramArrayOfVariantWrapper));
          }
          return true;
        }
        if (paramString.equals("ShowStatusBar"))
        {
          if (!ArkAppModuleReg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, "permission.STATUSBAR")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            paramString = paramArrayOfVariantWrapper[1].GetString();
            ArkAppCenter.a().postToMainThread(new aawd(this, l1, paramString));
          }
          return true;
        }
        if (paramString.equals("HideStatusBar"))
        {
          if (!ArkAppModuleReg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, "permission.STATUSBAR")) {
            return false;
          }
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            ArkAppCenter.a().postToMainThread(new aawe(this, l1));
          }
          return true;
        }
        if (paramString.equals("SetNavigationBarTitle"))
        {
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsView()) && (paramArrayOfVariantWrapper[1].IsString()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            paramString = paramArrayOfVariantWrapper[1].GetString();
            ArkAppCenter.a().postToMainThread(new aawf(this, l1, paramString));
          }
          return true;
        }
        if (paramString.equals("ShowShareMenu"))
        {
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            ArkAppCenter.a().postToMainThread(new aawg(this, l1));
          }
          return true;
        }
        if (paramString.equals("HideShareMenu"))
        {
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsView()))
          {
            l1 = paramArrayOfVariantWrapper[0].GetView();
            ArkAppCenter.a().postToMainThread(new aawh(this, l1));
          }
          return true;
        }
        if (paramString.equals("PreviewImage")) {
          if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsArray()) && (paramArrayOfVariantWrapper[1].GetType() == 4))
          {
            paramString = paramArrayOfVariantWrapper[0].GetTableAsJsonString();
            localObject2 = new ArrayList();
            localObject1 = ark.Application.Create(((ArkAppCenter)ArkAppModuleReg.a().getManager(120)).a().a(this.jdField_a_of_type_JavaLangString, null));
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = new JSONArray(paramString);
        i = 0;
        if (i < ((JSONArray)localObject3).length())
        {
          paramVariantWrapper = ((JSONArray)localObject3).optString(i);
          if (TextUtils.isEmpty(paramVariantWrapper)) {
            break label5035;
          }
          paramString = paramVariantWrapper;
          if (!paramVariantWrapper.startsWith("http://"))
          {
            paramString = paramVariantWrapper;
            if (!paramVariantWrapper.startsWith("https://"))
            {
              paramString = ((ark.Application)localObject1).GetSystemPathFromLocal(paramVariantWrapper);
              if (TextUtils.isEmpty(paramString)) {
                break label5035;
              }
            }
          }
          ((ArrayList)localObject2).add(paramString);
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ArkApp", 1, "QQ.PreviewImage parameter error: " + paramString.getMessage());
        }
        ((ark.Application)localObject1).Release();
        return true;
      }
      ((ark.Application)localObject1).Release();
      i = (int)Math.round(paramArrayOfVariantWrapper[1].GetDouble());
      ArkAppCenter.a().postToMainThread(new aawi(this, i, (ArrayList)localObject2));
      return true;
      return false;
      bool = true;
      break label2702;
      label5006:
      paramString = paramArrayOfVariantWrapper;
      break label1519;
      label5011:
      break label626;
      label5014:
      break label5028;
      label5017:
      break label626;
      label5020:
      l1 = 0L;
      paramArrayOfVariantWrapper = null;
      break;
      label5028:
      break label432;
      return true;
      label5033:
      return true;
      label5035:
      i += 1;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    ark.VariantWrapper localVariantWrapper1 = b(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    localVariantWrapper2.SetDouble(paramDouble1 / 1000000.0D);
    ark.VariantWrapper localVariantWrapper3 = localVariantWrapper1.Create();
    localVariantWrapper3.SetDouble(paramDouble2 / 1000000.0D);
    ark.VariantWrapper localVariantWrapper4 = localVariantWrapper1.Create();
    localVariantWrapper4.SetBool(paramBoolean);
    ark.VariantWrapper localVariantWrapper5 = localVariantWrapper1.Create();
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2, localVariantWrapper3, localVariantWrapper4 }, localVariantWrapper5);
    localVariantWrapper5.Reset();
    localVariantWrapper4.Reset();
    localVariantWrapper2.Reset();
    localVariantWrapper3.Reset();
  }
  
  public void a(long paramLong, boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    ark.VariantWrapper localVariantWrapper1 = a(paramLong);
    if (localVariantWrapper1 == null) {
      return;
    }
    ark.VariantWrapper localVariantWrapper2 = localVariantWrapper1.Create();
    if (paramSosoLbsInfo != null)
    {
      localObject = ArkAppCenter.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramSosoLbsInfo.a.e = ((String)localObject);
      }
      localObject = ArkAppCenter.a();
      if ((localObject != null) && (localObject.length == 2))
      {
        paramSosoLbsInfo.a.a = localObject[0];
        paramSosoLbsInfo.a.b = localObject[1];
      }
      localVariantWrapper2.SetTableAsJsonString(String.format(Locale.CHINA, "{\"prov\":\"%s\",\"city\":\"%s\",\"dist\":\"%s\",\"road\":\"%s\",\"town\":\"%s\",\"lat\":%.6f,\"lng\":%.6f}", new Object[] { paramSosoLbsInfo.a.d, paramSosoLbsInfo.a.e, paramSosoLbsInfo.a.g, paramSosoLbsInfo.a.j, paramSosoLbsInfo.a.h, Double.valueOf(paramSosoLbsInfo.a.a), Double.valueOf(paramSosoLbsInfo.a.b) }));
    }
    paramSosoLbsInfo = localVariantWrapper1.Create();
    paramSosoLbsInfo.SetBool(paramBoolean);
    Object localObject = localVariantWrapper1.Create();
    localVariantWrapper1.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2, paramSosoLbsInfo }, (ark.VariantWrapper)localObject);
    ((ark.VariantWrapper)localObject).Reset();
    paramSosoLbsInfo.Reset();
    localVariantWrapper2.Reset();
    localVariantWrapper1.Reset();
  }
  
  public void a(List paramList)
  {
    super.a(paramList);
    a("OpenUrl", 1L, 500L);
    a("SendMessage", 1L, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ
 * JD-Core Version:    0.7.0.1
 */