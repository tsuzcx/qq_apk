import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Locale;

class bewu
  implements bevs
{
  private float jdField_a_of_type_Float;
  
  bewu(bewt parambewt, long paramLong) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    String str = "";
    if (paramFloat - this.jdField_a_of_type_Float > 0.1F)
    {
      this.jdField_a_of_type_Float = paramFloat;
      str = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(100.0F * paramFloat) }) + "%";
      betc.b("GpkgLoadAsyncTask", "[Gpkg]" + paramMiniAppInfo.appId + "(" + paramMiniAppInfo.name + "), progress " + str + ", size=" + paramLong);
    }
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Bewt.a().notifyRuntimeEvent(2001, new Object[] { Float.valueOf(paramFloat) });
    }
  }
  
  public void onInitGpkgInfo(int paramInt, bevt parambevt, String paramString)
  {
    betc.b("GpkgLoadAsyncTask", "[Gpkg] getGpkgInfoByConfig end, resCode=" + paramInt + ", msg=" + paramString + " ,timecost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if ((paramInt == 0) && (parambevt != null))
    {
      bejl.a().a(parambevt, true);
      betc.b("GpkgLoadAsyncTask", "[Gpkg] getGpkgInfoByConfig appid=" + parambevt.d + ", appName=" + parambevt.c + " success");
      bewt.a(this.jdField_a_of_type_Bewt, parambevt);
      bewt.a(this.jdField_a_of_type_Bewt, null);
      this.jdField_a_of_type_Bewt.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[Gpkg] getGpkgInfoByConfig appid=");
    if (parambevt != null) {}
    for (parambevt = parambevt.d;; parambevt = "unknown appid")
    {
      betc.d("GpkgLoadAsyncTask", parambevt + ", fail " + paramString);
      bewt.a(this.jdField_a_of_type_Bewt, null);
      bewt.a(this.jdField_a_of_type_Bewt, null);
      this.jdField_a_of_type_Bewt.a(paramInt, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bewu
 * JD-Core Version:    0.7.0.1
 */