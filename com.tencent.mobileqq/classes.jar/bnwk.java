import BOSSStrategyCenter.tAdvDesc;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bnwk
  extends almm
{
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public bnwk(tAdvDesc paramtAdvDesc)
  {
    super(paramtAdvDesc);
  }
  
  public bnwk(TianShuAccess.AdItem paramAdItem)
  {
    super(paramAdItem);
  }
  
  protected void a()
  {
    super.a();
    if ((this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc == null) || (TextUtils.isEmpty(this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_data)))
    {
      QLog.e("QbossADBannerConfigInfo", 1, "parseJsonFromAdvDesc error with data = null");
      return;
    }
    String str = this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.res_data;
    try
    {
      Object localObject = new JSONObject(str);
      this.e = ((JSONObject)localObject).optString("topText");
      this.f = ((JSONObject)localObject).optString("bottomText");
      this.g = ((JSONObject)localObject).optString("textColor");
      this.h = ((JSONObject)localObject).optString("cartoon");
      this.i = ((JSONObject)localObject).optString("cartoon_md5");
      this.j = ((JSONObject)localObject).optString("cartoonNum");
      localObject = new bnwm(this, null);
      ((almn)localObject).a = this.h;
      ((almn)localObject).b = this.i;
      if (!TextUtils.isEmpty(this.h)) {
        ((almn)localObject).c = (QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.h.hashCode())) + ".zip");
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(2, localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "qboss banner parseJson error msg = " + localException.getMessage());
      bnfx.a().a(2741, this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.task_id, 102, "CountDownBanner json parseError exception = " + localException.getMessage() + " json string = " + str);
    }
  }
  
  public void a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    super.a(paramSharedPreferences, paramString);
    try
    {
      this.e = paramSharedPreferences.getString("splash_union_banner_top_text" + paramString, "");
      this.f = paramSharedPreferences.getString("splash_union_banner_bottom_text" + paramString, "");
      this.g = paramSharedPreferences.getString("splash_union_banner_text_color" + paramString, "");
      this.h = paramSharedPreferences.getString("splash_union_banner_cartoon_url" + paramString, "");
      this.i = paramSharedPreferences.getString("splash_union_banner_md5" + paramString, "");
      this.j = paramSharedPreferences.getString("splash_union_banner_cartoon_num" + paramString, "");
      paramSharedPreferences = new bnwm(this, null);
      paramSharedPreferences.a = this.h;
      paramSharedPreferences.b = this.i;
      if (!TextUtils.isEmpty(this.h)) {
        paramSharedPreferences.c = (QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.h.hashCode())) + ".zip");
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(2, paramSharedPreferences);
      return;
    }
    catch (Exception paramSharedPreferences)
    {
      paramSharedPreferences.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "buildUnionBannerFromSP error msg = " + paramSharedPreferences.getMessage());
    }
  }
  
  public void a(String paramString, SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    super.a(paramString, paramSharedPreferences);
    paramString = paramSharedPreferences.edit();
    paramString.putString("splash_union_banner_top_text" + this.c, this.e);
    paramString.putString("splash_union_banner_bottom_text" + this.c, this.f);
    paramString.putString("splash_union_banner_text_color" + this.c, this.g);
    paramString.putString("splash_union_banner_cartoon_url" + this.c, this.h);
    paramString.putString("splash_union_banner_md5" + this.c, this.i);
    paramString.putString("splash_union_banner_cartoon_num" + this.c, this.j);
    paramString.apply();
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem == null)
    {
      QLog.e("QbossADBannerConfigInfo", 1, "parseJsonFromAdvDesc error with data = null");
      return;
    }
    Object localObject = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.argList.get().iterator();
    while (localIterator.hasNext())
    {
      TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)localIterator.next();
      ((HashMap)localObject).put(localMapEntry.key.get(), localMapEntry.value.get());
    }
    try
    {
      this.e = ((String)((HashMap)localObject).get("topText"));
      this.f = ((String)((HashMap)localObject).get("bottomText"));
      this.g = ((String)((HashMap)localObject).get("textColor"));
      this.h = ((String)((HashMap)localObject).get("cartoon"));
      this.i = ((String)((HashMap)localObject).get("cartoon_md5"));
      this.j = ((String)((HashMap)localObject).get("cartoonNum"));
      localObject = new bnwm(this, null);
      ((almn)localObject).a = this.h;
      ((almn)localObject).b = this.i;
      if (!TextUtils.isEmpty(this.h)) {
        ((almn)localObject).c = (QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.h.hashCode())) + ".zip");
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(2, localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "qboss banner fillDataFromUnionSplashItem error msg = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwk
 * JD-Core Version:    0.7.0.1
 */