import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class argn
  extends arac<argm>
{
  @NonNull
  public argm a(int paramInt)
  {
    return new argm();
  }
  
  @Nullable
  public argm a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaraj != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaraj.length > 0) {
        localObject1 = argm.a(paramArrayOfaraj);
      }
    }
    return localObject1;
  }
  
  public void a(argm paramargm)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onUpdate " + paramargm.toString());
    }
    if (Pattern.matches("(\\d+?\\|){7}\\d+", paramargm.jdField_a_of_type_JavaLangString)) {
      azqi.a("flowCombination", paramargm.jdField_a_of_type_JavaLangString, true);
    }
    if (Pattern.matches("(\\d+?\\|){3}\\d+", paramargm.jdField_b_of_type_JavaLangString)) {
      azqi.a("troopCombination", paramargm.jdField_b_of_type_JavaLangString, true);
    }
    if (paramargm.g > 0L) {
      azqi.a("maxRequest", paramargm.g, true);
    }
    if ((paramargm.jdField_a_of_type_Long == 0L) || (paramargm.jdField_a_of_type_Long == 1L)) {
      if (paramargm.jdField_a_of_type_Long != 1L) {
        break label483;
      }
    }
    label483:
    for (boolean bool1 = true;; bool1 = false)
    {
      azqi.a("PicPreDownSwitchNew", bool1, true);
      if ((paramargm.jdField_b_of_type_Long == 0L) || (paramargm.jdField_b_of_type_Long == 1L) || (paramargm.jdField_b_of_type_Long == 2L) || (paramargm.jdField_b_of_type_Long == 3L)) {
        azqi.a("PicAuDownTimePoint", paramargm.jdField_b_of_type_Long, true);
      }
      if (paramargm.jdField_c_of_type_Long > 0L) {
        azqi.a("MaxWifiFlow", paramargm.jdField_c_of_type_Long, true);
      }
      if (paramargm.jdField_d_of_type_Long > 0L) {
        azqi.a("Max4GFlow", paramargm.jdField_d_of_type_Long, true);
      }
      if (paramargm.e > 0L) {
        azqi.a("Max3GFlow", paramargm.e, true);
      }
      if (paramargm.f > 0L) {
        azqi.a("Max2GFlow", paramargm.f, true);
      }
      if (Pattern.matches("^[0-9A-Fa-f]+$", paramargm.jdField_c_of_type_JavaLangString)) {
        azqi.a("xGPreDownPolicy", Long.valueOf(paramargm.jdField_c_of_type_JavaLangString, 16).longValue(), true);
      }
      if (paramargm.h > 0L) {
        azqi.a("AFBFlowHitXG", paramargm.h, true);
      }
      if (paramargm.i > 0L) {
        azqi.a("AFBFlowMissXG", paramargm.i, true);
      }
      if (paramargm.j > 0L) {
        azqi.a("APicAvgSize", paramargm.j, true);
      }
      if (paramargm.k > 0L) {
        azqi.a("APicMaxSize", paramargm.k, true);
      }
      if ((paramargm.l == 0L) || (paramargm.l == 1L))
      {
        bool1 = bool2;
        if (paramargm.l == 1L) {
          bool1 = true;
        }
        azqi.a("enablePeakFlow", bool1, true);
      }
      if (Pattern.matches("^((([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]);)*+([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]))$", paramargm.jdField_d_of_type_JavaLangString)) {
        azqi.a("PeakFlowTimePeriod", paramargm.jdField_d_of_type_JavaLangString, true);
      }
      if (paramargm.m > 0L) {
        azqi.a("PeakFlowMaxPicSize", paramargm.m, true);
      }
      if ((paramargm.jdField_a_of_type_Int > 0) && (paramargm.jdField_b_of_type_Int > 0))
      {
        azqi.a("gifWifiPreDownloadLimit", paramargm.jdField_a_of_type_Int, true);
        azqi.a("gifXgPreDownloadLimit", paramargm.jdField_b_of_type_Int, true);
      }
      return;
    }
  }
  
  public Class<argm> clazz()
  {
    return argm.class;
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
 * Qualified Name:     argn
 * JD-Core Version:    0.7.0.1
 */