import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.10;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.5;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.8;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.9;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class aphi
  extends apih
{
  private aphu jdField_a_of_type_Aphu;
  private aphv jdField_a_of_type_Aphv;
  private aphw jdField_a_of_type_Aphw;
  private bmxe jdField_a_of_type_Bmxe;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private boolean b;
  private boolean c;
  
  aphi(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    bmxh.a().c();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Bmxe = new aphr(this);
    bmxh.a().a(this.jdField_a_of_type_Bmxe);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new aphs(this);
    paramApplication = BaseActivity.sTopActivity;
    if (paramApplication != null) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramApplication, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
  }
  
  private int a(Context paramContext, double paramDouble, WadlParams paramWadlParams)
  {
    SharedPreferences localSharedPreferences;
    String str1;
    if (paramContext != null)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
      str1 = "key_download_show_not_wifi_dialog" + paramWadlParams.jdField_a_of_type_JavaLangString;
      if (localSharedPreferences == null) {
        break label178;
      }
    }
    label178:
    for (boolean bool = localSharedPreferences.getBoolean(str1, true);; bool = true)
    {
      if (paramDouble > bmxi.a())
      {
        ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.9(this, paramContext, paramWadlParams));
        return 2;
      }
      if ((bool) && (bgnt.g(paramContext)) && (bgnt.b(paramContext) != 1))
      {
        String str2 = String.format(paramContext.getString(2131690116), new Object[] { bgmf.a(paramDouble) });
        String str3 = paramContext.getString(2131690115);
        ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.10(this, paramContext, str2, paramWadlParams, localSharedPreferences, str1, str3));
        return 2;
      }
      bmxh.a().a(paramWadlParams);
      this.c = true;
      return 1;
    }
  }
  
  private String a(int paramInt)
  {
    String str = "";
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {}
    switch (paramInt)
    {
    case 2: 
    default: 
      str = localBaseActivity.getString(2131690113);
      return str;
    case 1: 
      return localBaseActivity.getString(2131690111);
    }
    return localBaseActivity.getString(2131690112);
  }
  
  private JSONArray a(ArrayList<WadlResult> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (WadlResult)paramArrayList.next();
      if (localObject != null)
      {
        localObject = a((WadlResult)localObject, paramString);
        if (localObject != null) {
          localJSONArray.put(localObject);
        }
      }
    }
    return localJSONArray;
  }
  
  private JSONObject a(WadlParams paramWadlParams, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramWadlParams != null)
      {
        localJSONObject.put("actionCode", paramWadlParams.jdField_b_of_type_Int);
        localJSONObject.put("appId", paramWadlParams.jdField_a_of_type_JavaLangString);
        localJSONObject.put("apkUrl", paramWadlParams.jdField_e_of_type_JavaLangString);
        localJSONObject.put("apkSign", paramWadlParams.jdField_b_of_type_JavaLangString);
        localJSONObject.put("versionCode", paramWadlParams.jdField_e_of_type_Int);
        localJSONObject.put("packageName", paramWadlParams.f);
        localJSONObject.put("appName", paramWadlParams.j);
        if (!paramWadlParams.jdField_b_of_type_Boolean) {
          break label250;
        }
      }
      label250:
      for (int i = 1;; i = 0)
      {
        localJSONObject.put("delayDownload", i);
        localJSONObject.put("fromWebUrl", paramWadlParams.m);
        localJSONObject.put("apkChannel", paramWadlParams.jdField_c_of_type_JavaLangString);
        localJSONObject.put("via", paramWadlParams.l);
        localJSONObject.put("yyStartTime", paramWadlParams.jdField_a_of_type_Long);
        localJSONObject.put("yyEndTime", paramWadlParams.jdField_b_of_type_Long);
        localJSONObject.put("adtag", paramWadlParams.n);
        localJSONObject.put("from", paramWadlParams.d);
        localJSONObject.put("flags", paramWadlParams.jdField_c_of_type_Int);
        localJSONObject.put("extraData", paramWadlParams.o);
        localJSONObject.put("sourceId", paramWadlParams.p);
        return localJSONObject;
      }
      return null;
    }
    catch (Exception paramWadlParams)
    {
      QLog.i("ark.download.module", 1, paramString + " parseWadlParams error::", paramWadlParams);
    }
  }
  
  private JSONObject a(WadlResult paramWadlResult, String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      if (paramWadlResult == null)
      {
        localJSONObject1.put("taskStatus", -1);
        localJSONObject1.put("progress", 0);
        return localJSONObject1;
      }
      if (paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams != null)
      {
        JSONObject localJSONObject2 = a(paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams, paramString);
        if (localJSONObject2 != null) {
          localJSONObject1.put("wadlParams", localJSONObject2.toString());
        }
      }
      localJSONObject1.put("event", paramWadlResult.jdField_a_of_type_Int);
      localJSONObject1.put("taskId", paramWadlResult.jdField_a_of_type_JavaLangString);
      localJSONObject1.put("taskStatus", paramWadlResult.jdField_b_of_type_Int);
      localJSONObject1.put("fileSize", paramWadlResult.jdField_a_of_type_Long);
      localJSONObject1.put("downloadFileSize", paramWadlResult.jdField_b_of_type_Long);
      localJSONObject1.put("downloadFilePath", paramWadlResult.jdField_b_of_type_JavaLangString);
      localJSONObject1.put("createTime", paramWadlResult.jdField_c_of_type_Long);
      localJSONObject1.put("errCode", bizo.b(paramWadlResult.jdField_c_of_type_Int));
      localJSONObject1.put("progress", paramWadlResult.d);
      return localJSONObject1;
    }
    catch (Exception paramWadlResult)
    {
      QLog.i("ark.download.module", 1, paramString + " parseWadlResult error::", paramWadlResult);
    }
    return null;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.8(this, paramString));
      return true;
    }
    catch (Exception paramString)
    {
      QLog.i("ark.download.module", 1, " showToast error::", paramString);
    }
    return false;
  }
  
  public void Destruct()
  {
    super.Destruct();
    bmxh.a().b(this.jdField_a_of_type_Bmxe);
    this.jdField_a_of_type_Bmxe = null;
    this.jdField_a_of_type_Aphv = null;
    this.jdField_a_of_type_Aphw = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a(((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue());
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public String GetTypeName()
  {
    return "QQDownload";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (paramString.equals("QueryPackageState")) {}
    while ((paramString.equals("QueryPackageStateVia")) || (paramString.equals("StartDownload")) || (paramString.equals("PauseDownload")) || (paramString.equals("ContinueDownload")) || (paramString.equals("InstallPackage")) || (paramString.equals("DownloadInit"))) {
      return true;
    }
    return paramString.equals("DeletePackage");
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!apgt.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentArkArk$Application, "permission.DOWNLOAD"))
    {
      QLog.i("ark.download.module", 1, "ark.dctrl.ArkAppDownloadModule.invokeFunc permission denied");
      paramString = BaseActivity.sTopActivity;
      if (paramString != null) {
        b(paramString.getString(2131690117));
      }
      return false;
    }
    QLog.i("ark.download.module", 1, String.format("ark.dctrl.ArkAppDownloadModule.invokeFunc.%s", new Object[] { paramString }));
    long l;
    if (paramString.equals("QueryPackageState"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        l = a(paramArrayOfVariantWrapper[1].Copy());
        paramArrayOfVariantWrapper = new ArrayList();
        paramArrayOfVariantWrapper.add(paramString);
        QLog.i("ark.download.module", 1, String.format("ark.dctrl.QueryPackageState.appid:%s", new Object[] { Long.valueOf(l) }));
        this.jdField_a_of_type_Aphv = new aphj(this, l);
        if (paramArrayOfVariantWrapper.size() > 0) {
          bmxh.a().a(paramArrayOfVariantWrapper);
        }
        return true;
      }
      return false;
    }
    if (paramString.equals("QueryPackageStateVia"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        QLog.i("ark.download.module", 1, String.format("ark.dctrl.QueryPackageStateVia.via:%s", new Object[] { paramString }));
        this.jdField_a_of_type_Aphw = new aphm(this, a(paramArrayOfVariantWrapper[1].Copy()));
        if (!TextUtils.isEmpty(paramString)) {
          bmxh.a().a(paramString);
        }
        return true;
      }
      return false;
    }
    if (paramString.equals("DownloadInit"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        l = a(paramArrayOfVariantWrapper[0].Copy());
        QLog.i("ark.download.module", 1, "ark.dctrl.DownloadInit callbackid=" + l);
        this.jdField_a_of_type_Aphu = new aphn(this);
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    Object localObject;
    boolean bool1;
    int i;
    if (paramString.equals("StartDownload"))
    {
      if (this.jdField_a_of_type_Aphu == null)
      {
        QLog.e("ark.download.module", 1, "should DownloadInit first ");
        paramVariantWrapper.SetInt(-1);
        return true;
      }
      paramString = BaseActivity.sTopActivity;
      double d;
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        localObject = paramArrayOfVariantWrapper[0].GetString();
        d = paramArrayOfVariantWrapper[1].GetDouble();
        paramArrayOfVariantWrapper = new WadlParams((String)localObject);
        if (paramArrayOfVariantWrapper.jdField_b_of_type_Int == 12)
        {
          bcst.a(null, "dc00898", "", "", "0X8009E12", "0X8009E12", 0, 0, "", "", paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString, "");
          boolean bool2 = true;
          localObject = aqmv.b(380).a();
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (((aqmu)localObject).a() != null)
            {
              localObject = ((aqmu)localObject).a();
              bool1 = bool2;
              if (((aqno)localObject).c != null)
              {
                bool1 = bool2;
                if (((aqno)localObject).c.contains(this.jdField_a_of_type_JavaLangString)) {
                  bool1 = false;
                }
              }
            }
          }
          QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl [StartDownload] mAppName:", this.jdField_a_of_type_JavaLangString, ",showDownloadCtrlDialog=", Boolean.valueOf(bool1), ",appid=", paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString, ",name=", paramArrayOfVariantWrapper.j, ",iconUrl:", paramArrayOfVariantWrapper.k });
          if (!bool1) {
            break label762;
          }
          apqq.a().a(this.jdField_a_of_type_JavaLangString, paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString, paramArrayOfVariantWrapper.j, paramArrayOfVariantWrapper.k, new apho(this, paramArrayOfVariantWrapper, paramString, d));
          i = 2;
        }
      }
      for (;;)
      {
        paramVariantWrapper.SetInt(i);
        return true;
        if (paramArrayOfVariantWrapper.jdField_b_of_type_Int != 2) {
          break;
        }
        bcst.a(null, "dc00898", "", "", "0X8009E11", "0X8009E11", 0, 0, "", "", paramArrayOfVariantWrapper.jdField_a_of_type_JavaLangString, "");
        break;
        label762:
        i = a(paramString, d, paramArrayOfVariantWrapper);
        continue;
        i = -2;
      }
    }
    if (paramString.equals("PauseDownload"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
      {
        i = paramArrayOfVariantWrapper[0].GetInt();
        paramString = paramArrayOfVariantWrapper[1].GetString();
        QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.pause download appid:", paramString, ",from:", Integer.valueOf(i) });
        bmxh.a().a(i, paramString);
        paramVariantWrapper.SetBool(true);
        bcst.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "1", "", paramString, "");
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    if (paramString.equals("ContinueDownload"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
      {
        i = paramArrayOfVariantWrapper[0].GetInt();
        paramString = paramArrayOfVariantWrapper[1].GetString();
        QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.continue download appid:", paramString, ",from:", Integer.valueOf(i) });
        paramArrayOfVariantWrapper = BaseActivity.sTopActivity;
        bool1 = true;
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_authority", 0);
        String str1 = "key_download_show_not_wifi_dialog" + paramString;
        if (localObject != null) {
          bool1 = ((SharedPreferences)localObject).getBoolean(str1, true);
        }
        if ((bool1) && (paramArrayOfVariantWrapper != null) && (bgnt.g(paramArrayOfVariantWrapper)) && (bgnt.b(paramArrayOfVariantWrapper) != 1))
        {
          String str2 = paramArrayOfVariantWrapper.getString(2131690108);
          String str3 = paramArrayOfVariantWrapper.getString(2131690115);
          ArkAppCenter.a().postToMainThread(new ArkAppDownloadModule.5(this, paramArrayOfVariantWrapper, str2, i, paramString, (SharedPreferences)localObject, str1, str3));
          paramVariantWrapper.SetBool(true);
          return true;
        }
        bmxh.a().b(i, paramString);
        this.c = true;
        bcst.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "2", "", paramString, "");
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    if (paramString.equals("InstallPackage"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        paramString = paramArrayOfVariantWrapper[0].GetString();
        QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.install package:", paramString });
        paramString = new WadlParams(paramString);
        bmxh.a().b(paramString);
        bcst.a(null, "dc00898", "", "", "0X8009E16", "0X8009E16", 0, 0, "", "", paramString.jdField_a_of_type_JavaLangString, "");
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    if (paramString.equals("DeletePackage"))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[1].IsString()))
      {
        i = paramArrayOfVariantWrapper[0].GetInt();
        paramString = paramArrayOfVariantWrapper[1].GetString();
        QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl.delete package appId:", paramString, ",from:", Integer.valueOf(i) });
        bmxh.a().c(i, paramString);
        paramVariantWrapper.SetBool(true);
        return true;
      }
      paramVariantWrapper.SetBool(false);
      return true;
    }
    return false;
  }
  
  protected apin[] a()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphi
 * JD-Core Version:    0.7.0.1
 */