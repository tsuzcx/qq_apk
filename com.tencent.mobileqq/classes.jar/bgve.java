import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Locale;

class bgve
  implements bgum
{
  private float jdField_a_of_type_Float;
  
  bgve(bgvd parambgvd, long paramLong) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    String str = "";
    if (paramFloat - this.jdField_a_of_type_Float > 0.1F)
    {
      this.jdField_a_of_type_Float = paramFloat;
      str = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(100.0F * paramFloat) }) + "%";
      QMLog.i("GpkgLoadAsyncTask", "[Gpkg]" + paramMiniAppInfo.appId + "(" + paramMiniAppInfo.name + "), progress " + str + ", size=" + paramLong);
    }
    if (!TextUtils.isEmpty(str))
    {
      paramMiniAppInfo = new bgvr().a(paramFloat).a();
      this.jdField_a_of_type_Bgvd.a().notifyRuntimeEvent(2001, new Object[] { paramMiniAppInfo });
    }
  }
  
  public void onInitGpkgInfo(int paramInt, bgun parambgun, String paramString)
  {
    QMLog.i("GpkgLoadAsyncTask", "[Gpkg] getGpkgInfoByConfig end, resCode=" + paramInt + ", msg=" + paramString + " ,timecost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if ((paramInt == 0) && (parambgun != null))
    {
      bgjm.a().a(parambgun, true);
      QMLog.i("GpkgLoadAsyncTask", "[Gpkg] getGpkgInfoByConfig appid=" + parambgun.appId + ", appName=" + parambgun.apkgName + " success");
      bgvd.a(this.jdField_a_of_type_Bgvd, parambgun);
      bgvd.a(this.jdField_a_of_type_Bgvd, null);
      this.jdField_a_of_type_Bgvd.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[Gpkg] getGpkgInfoByConfig appid=");
    if (parambgun != null) {}
    for (parambgun = parambgun.appId;; parambgun = "unknown appid")
    {
      QMLog.e("GpkgLoadAsyncTask", parambgun + ", fail " + paramString);
      bgvd.a(this.jdField_a_of_type_Bgvd, null);
      bgvd.a(this.jdField_a_of_type_Bgvd, null);
      this.jdField_a_of_type_Bgvd.a(paramInt, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgve
 * JD-Core Version:    0.7.0.1
 */