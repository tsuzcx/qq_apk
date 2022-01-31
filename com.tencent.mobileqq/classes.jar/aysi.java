import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.ArkViewModelBase.ErrorInfo;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppInfo.TimeRecord;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.rich.ArkNodeContainer.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class aysi
  extends ArkViewModel
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  private aysh a;
  public ArkAppInfo.TimeRecord a;
  
  public aysi(aysd paramaysd) {}
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public void a()
  {
    destroy();
    this.jdField_a_of_type_Aysh = null;
  }
  
  public void a(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ArkNodeContainer", 2, String.format("CheckMetaLegality,appMeta is parse error and msg=%s", new Object[] { paramString.getMessage() }));
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("ArkNodeContainer", 2, String.format("loadArkApp, apppath:" + paramString1 + " retcode:" + paramInt + " msg:" + paramString2, new Object[0]));
    }
    boolean bool1;
    label72:
    String str1;
    String str2;
    String str3;
    if (paramInt != 0)
    {
      bool1 = true;
      if (paramInt != -2) {
        break label152;
      }
      str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
      str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
      str3 = ArkEnvironmentManager.getInstance().getAppResPath(this.mAppInfo.name);
      b(str1);
      b(str2);
      b(str3);
      if (paramString2 != null) {
        break label158;
      }
      paramString2 = "";
    }
    label152:
    label158:
    for (;;)
    {
      doLoadArkApp(paramString1, str1, str2, str3, bool1, bool2, paramInt, paramString2);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label72;
    }
  }
  
  public boolean a(aysh paramaysh, String paramString, float paramFloat)
  {
    this.jdField_a_of_type_Aysh = paramaysh;
    if (this.jdField_a_of_type_Aysh == null) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString)) {
      a(paramString);
    }
    return super.init(this.jdField_a_of_type_Aysh.b(), this.jdField_a_of_type_Aysh.d(), this.jdField_a_of_type_Aysh.c(), paramString, anob.a(), paramFloat);
  }
  
  public void initLibrary()
  {
    ark.MediaSetStub(anov.a);
  }
  
  public void onFirstDrawEnd()
  {
    super.onFirstDrawEnd();
  }
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if (paramAppPathInfo != null) {}
    for (paramAppPathInfo = paramAppPathInfo.path;; paramAppPathInfo = null)
    {
      this.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord.getAppFromLocal = false;
      this.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord.endOfGetApp = System.currentTimeMillis();
      a(paramAppPathInfo, paramInt, paramString);
      return;
    }
  }
  
  public boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null)
    {
      this.mInit = false;
      this.mLoadFailed = true;
      paramAppInfo = this.mViewImpl;
      if (paramAppInfo != null) {
        paramAppInfo.onLoadFailed(null, this.mErrorInfo.retCode, true);
      }
      return true;
    }
    this.jdField_a_of_type_ComTencentArkOpenArkAppInfo$TimeRecord.beginOfGetApp = System.currentTimeMillis();
    Object localObject2 = this.jdField_a_of_type_Aysh.a();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.mAppInfo.name, this.mAppInfo.view, this.mAppInfo.appMinVersion, true);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkNodeContainer", 2, String.format("onLoadApp,mAppInfo.name=%s,appPath=%s", new Object[] { this.mAppInfo.name, localObject1 }));
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ArkDispatchTask.getInstance().post(this.mAppInfo.name, new ArkNodeContainer.1(this, (String)localObject1));
      return true;
    }
    localObject2 = this.mViewImpl;
    if (localObject2 != null) {
      ((ArkViewImplement)localObject2).onLoading();
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArkNodeContainer", 2, String.format("onLoadApp,mAppInfo.name=%s,appPath=%s,viewImplement=%h", new Object[] { this.mAppInfo.name, localObject1, localObject2 }));
    }
    ArkAppMgr.getInstance().getAppPathByName(paramAppInfo.name, paramAppInfo.view, paramAppInfo.appMinVersion, null, new aysj(this));
    return false;
  }
  
  public void onLoadReport(int paramInt)
  {
    if (this.mAppInfo != null) {
      anoe.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), this.mAppInfo.name, "ArkAppLoadState", paramInt, 0, 0L, 0L, 0L, this.mAppInfo.view, "");
    }
  }
  
  public void onRunAppFailed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ArkNodeContainer", 2, String.format("onRunAppFailed", new Object[0]));
    }
    Object localObject = this.mViewImpl;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Aysh == null) {
        break label90;
      }
      localObject = ((ArkViewImplement)localObject).getView().getContext().getString(2131719595);
    }
    label90:
    for (this.mErrorInfo.msg = String.format((String)localObject, new Object[] { this.jdField_a_of_type_Aysh.b() });; this.mErrorInfo.msg = "")
    {
      this.mErrorInfo.canRetry = false;
      super.onRunAppFailed();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysi
 * JD-Core Version:    0.7.0.1
 */