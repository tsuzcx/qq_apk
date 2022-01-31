import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Locale;

class bewd
  implements bevb
{
  private float jdField_a_of_type_Float;
  
  bewd(bewc parambewc, long paramLong) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    String str = "";
    if (paramFloat - this.jdField_a_of_type_Float > 0.1F)
    {
      this.jdField_a_of_type_Float = paramFloat;
      str = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(100.0F * paramFloat) }) + "%";
      besl.b("GpkgLoadAsyncTask", "[Gpkg]" + paramMiniAppInfo.appId + "(" + paramMiniAppInfo.name + "), progress " + str + ", size=" + paramLong);
    }
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Bewc.a().notifyRuntimeEvent(2001, new Object[] { Float.valueOf(paramFloat) });
    }
  }
  
  public void onInitGpkgInfo(int paramInt, bevc parambevc, String paramString)
  {
    besl.b("GpkgLoadAsyncTask", "[Gpkg] getGpkgInfoByConfig end, resCode=" + paramInt + ", msg=" + paramString + " ,timecost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if ((paramInt == 0) && (parambevc != null))
    {
      beiu.a().a(parambevc, true);
      besl.b("GpkgLoadAsyncTask", "[Gpkg] getGpkgInfoByConfig appid=" + parambevc.d + ", appName=" + parambevc.c + " success");
      bewc.a(this.jdField_a_of_type_Bewc, parambevc);
      bewc.a(this.jdField_a_of_type_Bewc, null);
      this.jdField_a_of_type_Bewc.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[Gpkg] getGpkgInfoByConfig appid=");
    if (parambevc != null) {}
    for (parambevc = parambevc.d;; parambevc = "unknown appid")
    {
      besl.d("GpkgLoadAsyncTask", parambevc + ", fail " + paramString);
      bewc.a(this.jdField_a_of_type_Bewc, null);
      bewc.a(this.jdField_a_of_type_Bewc, null);
      this.jdField_a_of_type_Bewc.a(paramInt, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewd
 * JD-Core Version:    0.7.0.1
 */