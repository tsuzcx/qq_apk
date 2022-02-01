import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBoxAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBoxADLisener;
import java.lang.ref.WeakReference;

public class bjbx
  extends AdProxy.AbsBoxAdView
{
  int jdField_a_of_type_Int = 53;
  abld jdField_a_of_type_Abld;
  AdProxy.IBoxADLisener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  String e;
  String f;
  String g;
  String h;
  
  public bjbx(AdProxyImpl paramAdProxyImpl, Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, AdProxy.IBoxADLisener paramIBoxADLisener)
  {
    super(paramAdProxyImpl);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener = paramIBoxADLisener;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Abld != null) {
      this.jdField_a_of_type_Abld.b();
    }
    this.jdField_a_of_type_Abld = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener = null;
  }
  
  public void loadAD()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        break label91;
      }
      localObject = new StringBuilder().append("loadAD, act is null, ");
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener == null) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("AdProxyImpl", 1, bool);
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener != null) {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBoxADLisener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      }
      return;
      localObject = null;
      break;
    }
    label91:
    this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl.requestAdInfo((Context)localObject, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.d, this.e, this.f, this.g, this.h, 1, new bjby(this, (Activity)localObject));
  }
  
  public void show()
  {
    if (this.jdField_a_of_type_Abld != null) {
      this.jdField_a_of_type_Abld.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbx
 * JD-Core Version:    0.7.0.1
 */