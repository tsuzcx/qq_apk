import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Locale;

class bgzl
  implements bgyt
{
  private float jdField_a_of_type_Float;
  
  bgzl(bgzk parambgzk, long paramLong) {}
  
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
      paramMiniAppInfo = new bgzy().a(paramFloat).a();
      this.jdField_a_of_type_Bgzk.a().notifyRuntimeEvent(2001, new Object[] { paramMiniAppInfo });
    }
  }
  
  public void onInitGpkgInfo(int paramInt, bgyu parambgyu, String paramString)
  {
    QMLog.i("GpkgLoadAsyncTask", "[Gpkg] getGpkgInfoByConfig end, resCode=" + paramInt + ", msg=" + paramString + " ,timecost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if ((paramInt == 0) && (parambgyu != null))
    {
      bgnt.a().a(parambgyu, true);
      QMLog.i("GpkgLoadAsyncTask", "[Gpkg] getGpkgInfoByConfig appid=" + parambgyu.appId + ", appName=" + parambgyu.apkgName + " success");
      bgzk.a(this.jdField_a_of_type_Bgzk, parambgyu);
      bgzk.a(this.jdField_a_of_type_Bgzk, null);
      this.jdField_a_of_type_Bgzk.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[Gpkg] getGpkgInfoByConfig appid=");
    if (parambgyu != null) {}
    for (parambgyu = parambgyu.appId;; parambgyu = "unknown appid")
    {
      QMLog.e("GpkgLoadAsyncTask", parambgyu + ", fail " + paramString);
      bgzk.a(this.jdField_a_of_type_Bgzk, null);
      bgzk.a(this.jdField_a_of_type_Bgzk, null);
      this.jdField_a_of_type_Bgzk.a(paramInt, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzl
 * JD-Core Version:    0.7.0.1
 */