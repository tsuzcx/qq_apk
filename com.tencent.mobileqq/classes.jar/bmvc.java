import BOSSStrategyCenter.tAdvDesc;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import org.json.JSONObject;

public class bmvc
  extends alaw
{
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public bmvc(tAdvDesc paramtAdvDesc)
  {
    super(paramtAdvDesc);
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
      this.c = ((JSONObject)localObject).optString("topText");
      this.d = ((JSONObject)localObject).optString("bottomText");
      this.e = ((JSONObject)localObject).optString("textColor");
      this.f = ((JSONObject)localObject).optString("cartoon");
      this.g = ((JSONObject)localObject).optString("cartoon_md5");
      this.h = ((JSONObject)localObject).optString("cartoonNum");
      localObject = new bmve(this, null);
      ((alax)localObject).a = this.f;
      ((alax)localObject).b = this.g;
      if (!TextUtils.isEmpty(this.f)) {
        ((alax)localObject).c = (QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.f.hashCode())) + ".zip");
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(2, localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "qboss banner parseJson error msg = " + localException.getMessage());
      bmev.a().a(2741, this.jdField_a_of_type_BOSSStrategyCenterTAdvDesc.task_id, 102, "CountDownBanner json parseError exception = " + localException.getMessage() + " json string = " + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvc
 * JD-Core Version:    0.7.0.1
 */