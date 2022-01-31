import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Locale;

class bdqq
  implements bdpx
{
  private float jdField_a_of_type_Float;
  
  bdqq(bdqp parambdqp, long paramLong) {}
  
  public void a(int paramInt, bdpy parambdpy, String paramString)
  {
    bdnw.b("GameRuntimeLoader", "[Gpkg] getGpkgInfoByConfig end, resCode=" + paramInt + ", msg=" + paramString + " ,timecost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if ((paramInt == 0) && (parambdpy != null))
    {
      bdeu.a().a(parambdpy);
      bdnw.b("GameRuntimeLoader", "[Gpkg] getGpkgInfoByConfig appid=" + parambdpy.d + ", appName=" + parambdpy.c + " success");
      bdqp.a(this.jdField_a_of_type_Bdqp, parambdpy);
      bdqp.a(this.jdField_a_of_type_Bdqp, null);
      this.jdField_a_of_type_Bdqp.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[Gpkg] getGpkgInfoByConfig appid=");
    if (parambdpy != null) {}
    for (parambdpy = parambdpy.d;; parambdpy = "unknown appid")
    {
      bdnw.d("GameRuntimeLoader", parambdpy + ", fail " + paramString);
      bdqp.a(this.jdField_a_of_type_Bdqp, null);
      bdqp.a(this.jdField_a_of_type_Bdqp, null);
      this.jdField_a_of_type_Bdqp.a(paramInt, paramString);
      return;
    }
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    String str = "";
    if (paramFloat - this.jdField_a_of_type_Float > 0.1F)
    {
      this.jdField_a_of_type_Float = paramFloat;
      str = String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(100.0F * paramFloat) }) + "%";
      bdnw.b("GameRuntimeLoader", "[Gpkg]" + paramMiniAppInfo.appId + "(" + paramMiniAppInfo.name + "), progress " + str + ", size=" + paramLong);
    }
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Bdqp.a().notifyRuntimeEvent(2001, new Object[] { Float.valueOf(paramFloat) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdqq
 * JD-Core Version:    0.7.0.1
 */