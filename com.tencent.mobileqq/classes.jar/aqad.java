import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class aqad
  extends aptq<aqac>
{
  @NonNull
  public aqac a(int paramInt)
  {
    return new aqac();
  }
  
  @Nullable
  public aqac a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onParsed " + paramArrayOfaptx.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaptx != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaptx.length > 0) {
        localObject1 = aqac.a(paramArrayOfaptx);
      }
    }
    return localObject1;
  }
  
  public void a(aqac paramaqac)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onUpdate " + paramaqac.toString());
    }
    if (Pattern.matches("(\\d+?\\|){7}\\d+", paramaqac.jdField_a_of_type_JavaLangString)) {
      aydq.a("flowCombination", paramaqac.jdField_a_of_type_JavaLangString, true);
    }
    if (Pattern.matches("(\\d+?\\|){3}\\d+", paramaqac.jdField_b_of_type_JavaLangString)) {
      aydq.a("troopCombination", paramaqac.jdField_b_of_type_JavaLangString, true);
    }
    if (paramaqac.g > 0L) {
      aydq.a("maxRequest", paramaqac.g, true);
    }
    if ((paramaqac.jdField_a_of_type_Long == 0L) || (paramaqac.jdField_a_of_type_Long == 1L)) {
      if (paramaqac.jdField_a_of_type_Long != 1L) {
        break label483;
      }
    }
    label483:
    for (boolean bool1 = true;; bool1 = false)
    {
      aydq.a("PicPreDownSwitchNew", bool1, true);
      if ((paramaqac.jdField_b_of_type_Long == 0L) || (paramaqac.jdField_b_of_type_Long == 1L) || (paramaqac.jdField_b_of_type_Long == 2L) || (paramaqac.jdField_b_of_type_Long == 3L)) {
        aydq.a("PicAuDownTimePoint", paramaqac.jdField_b_of_type_Long, true);
      }
      if (paramaqac.jdField_c_of_type_Long > 0L) {
        aydq.a("MaxWifiFlow", paramaqac.jdField_c_of_type_Long, true);
      }
      if (paramaqac.jdField_d_of_type_Long > 0L) {
        aydq.a("Max4GFlow", paramaqac.jdField_d_of_type_Long, true);
      }
      if (paramaqac.e > 0L) {
        aydq.a("Max3GFlow", paramaqac.e, true);
      }
      if (paramaqac.f > 0L) {
        aydq.a("Max2GFlow", paramaqac.f, true);
      }
      if (Pattern.matches("^[0-9A-Fa-f]+$", paramaqac.jdField_c_of_type_JavaLangString)) {
        aydq.a("xGPreDownPolicy", Long.valueOf(paramaqac.jdField_c_of_type_JavaLangString, 16).longValue(), true);
      }
      if (paramaqac.h > 0L) {
        aydq.a("AFBFlowHitXG", paramaqac.h, true);
      }
      if (paramaqac.i > 0L) {
        aydq.a("AFBFlowMissXG", paramaqac.i, true);
      }
      if (paramaqac.j > 0L) {
        aydq.a("APicAvgSize", paramaqac.j, true);
      }
      if (paramaqac.k > 0L) {
        aydq.a("APicMaxSize", paramaqac.k, true);
      }
      if ((paramaqac.l == 0L) || (paramaqac.l == 1L))
      {
        bool1 = bool2;
        if (paramaqac.l == 1L) {
          bool1 = true;
        }
        aydq.a("enablePeakFlow", bool1, true);
      }
      if (Pattern.matches("^((([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]);)*+([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]))$", paramaqac.jdField_d_of_type_JavaLangString)) {
        aydq.a("PeakFlowTimePeriod", paramaqac.jdField_d_of_type_JavaLangString, true);
      }
      if (paramaqac.m > 0L) {
        aydq.a("PeakFlowMaxPicSize", paramaqac.m, true);
      }
      if ((paramaqac.jdField_a_of_type_Int > 0) && (paramaqac.jdField_b_of_type_Int > 0))
      {
        aydq.a("gifWifiPreDownloadLimit", paramaqac.jdField_a_of_type_Int, true);
        aydq.a("gifXgPreDownloadLimit", paramaqac.jdField_b_of_type_Int, true);
      }
      return;
    }
  }
  
  public Class<aqac> clazz()
  {
    return aqac.class;
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
 * Qualified Name:     aqad
 * JD-Core Version:    0.7.0.1
 */