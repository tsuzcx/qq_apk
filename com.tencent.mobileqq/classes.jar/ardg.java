import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class ardg
  extends aqwt<ardf>
{
  @NonNull
  public ardf a(int paramInt)
  {
    return new ardf();
  }
  
  @Nullable
  public ardf a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqxa != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqxa.length > 0) {
        localObject1 = ardf.a(paramArrayOfaqxa);
      }
    }
    return localObject1;
  }
  
  public void a(ardf paramardf)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onUpdate " + paramardf.toString());
    }
    if (Pattern.matches("(\\d+?\\|){7}\\d+", paramardf.jdField_a_of_type_JavaLangString)) {
      azkc.a("flowCombination", paramardf.jdField_a_of_type_JavaLangString, true);
    }
    if (Pattern.matches("(\\d+?\\|){3}\\d+", paramardf.jdField_b_of_type_JavaLangString)) {
      azkc.a("troopCombination", paramardf.jdField_b_of_type_JavaLangString, true);
    }
    if (paramardf.g > 0L) {
      azkc.a("maxRequest", paramardf.g, true);
    }
    if ((paramardf.jdField_a_of_type_Long == 0L) || (paramardf.jdField_a_of_type_Long == 1L)) {
      if (paramardf.jdField_a_of_type_Long != 1L) {
        break label483;
      }
    }
    label483:
    for (boolean bool1 = true;; bool1 = false)
    {
      azkc.a("PicPreDownSwitchNew", bool1, true);
      if ((paramardf.jdField_b_of_type_Long == 0L) || (paramardf.jdField_b_of_type_Long == 1L) || (paramardf.jdField_b_of_type_Long == 2L) || (paramardf.jdField_b_of_type_Long == 3L)) {
        azkc.a("PicAuDownTimePoint", paramardf.jdField_b_of_type_Long, true);
      }
      if (paramardf.jdField_c_of_type_Long > 0L) {
        azkc.a("MaxWifiFlow", paramardf.jdField_c_of_type_Long, true);
      }
      if (paramardf.jdField_d_of_type_Long > 0L) {
        azkc.a("Max4GFlow", paramardf.jdField_d_of_type_Long, true);
      }
      if (paramardf.e > 0L) {
        azkc.a("Max3GFlow", paramardf.e, true);
      }
      if (paramardf.f > 0L) {
        azkc.a("Max2GFlow", paramardf.f, true);
      }
      if (Pattern.matches("^[0-9A-Fa-f]+$", paramardf.jdField_c_of_type_JavaLangString)) {
        azkc.a("xGPreDownPolicy", Long.valueOf(paramardf.jdField_c_of_type_JavaLangString, 16).longValue(), true);
      }
      if (paramardf.h > 0L) {
        azkc.a("AFBFlowHitXG", paramardf.h, true);
      }
      if (paramardf.i > 0L) {
        azkc.a("AFBFlowMissXG", paramardf.i, true);
      }
      if (paramardf.j > 0L) {
        azkc.a("APicAvgSize", paramardf.j, true);
      }
      if (paramardf.k > 0L) {
        azkc.a("APicMaxSize", paramardf.k, true);
      }
      if ((paramardf.l == 0L) || (paramardf.l == 1L))
      {
        bool1 = bool2;
        if (paramardf.l == 1L) {
          bool1 = true;
        }
        azkc.a("enablePeakFlow", bool1, true);
      }
      if (Pattern.matches("^((([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]);)*+([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]))$", paramardf.jdField_d_of_type_JavaLangString)) {
        azkc.a("PeakFlowTimePeriod", paramardf.jdField_d_of_type_JavaLangString, true);
      }
      if (paramardf.m > 0L) {
        azkc.a("PeakFlowMaxPicSize", paramardf.m, true);
      }
      if ((paramardf.jdField_a_of_type_Int > 0) && (paramardf.jdField_b_of_type_Int > 0))
      {
        azkc.a("gifWifiPreDownloadLimit", paramardf.jdField_a_of_type_Int, true);
        azkc.a("gifXgPreDownloadLimit", paramardf.jdField_b_of_type_Int, true);
      }
      return;
    }
  }
  
  public Class<ardf> clazz()
  {
    return ardf.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 616;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardg
 * JD-Core Version:    0.7.0.1
 */