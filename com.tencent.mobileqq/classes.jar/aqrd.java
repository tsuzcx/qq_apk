import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class aqrd
  extends aqkz<aqrc>
{
  @NonNull
  public aqrc a(int paramInt)
  {
    return new aqrc();
  }
  
  @Nullable
  public aqrc a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onParsed " + paramArrayOfaqlg.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqlg != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqlg.length > 0) {
        localObject1 = aqrc.a(paramArrayOfaqlg);
      }
    }
    return localObject1;
  }
  
  public void a(aqrc paramaqrc)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onUpdate " + paramaqrc.toString());
    }
    if (Pattern.matches("(\\d+?\\|){7}\\d+", paramaqrc.jdField_a_of_type_JavaLangString)) {
      ayxu.a("flowCombination", paramaqrc.jdField_a_of_type_JavaLangString, true);
    }
    if (Pattern.matches("(\\d+?\\|){3}\\d+", paramaqrc.jdField_b_of_type_JavaLangString)) {
      ayxu.a("troopCombination", paramaqrc.jdField_b_of_type_JavaLangString, true);
    }
    if (paramaqrc.g > 0L) {
      ayxu.a("maxRequest", paramaqrc.g, true);
    }
    if ((paramaqrc.jdField_a_of_type_Long == 0L) || (paramaqrc.jdField_a_of_type_Long == 1L)) {
      if (paramaqrc.jdField_a_of_type_Long != 1L) {
        break label447;
      }
    }
    label447:
    for (boolean bool1 = true;; bool1 = false)
    {
      ayxu.a("PicPreDownSwitch", bool1, true);
      if ((paramaqrc.jdField_b_of_type_Long == 0L) || (paramaqrc.jdField_b_of_type_Long == 1L) || (paramaqrc.jdField_b_of_type_Long == 2L) || (paramaqrc.jdField_b_of_type_Long == 3L)) {
        ayxu.a("PicAuDownTimePoint", paramaqrc.jdField_b_of_type_Long, true);
      }
      if (paramaqrc.jdField_c_of_type_Long > 0L) {
        ayxu.a("MaxWifiFlow", paramaqrc.jdField_c_of_type_Long, true);
      }
      if (paramaqrc.jdField_d_of_type_Long > 0L) {
        ayxu.a("Max4GFlow", paramaqrc.jdField_d_of_type_Long, true);
      }
      if (paramaqrc.e > 0L) {
        ayxu.a("Max3GFlow", paramaqrc.e, true);
      }
      if (paramaqrc.f > 0L) {
        ayxu.a("Max2GFlow", paramaqrc.f, true);
      }
      if (Pattern.matches("^[0-9A-Fa-f]+$", paramaqrc.jdField_c_of_type_JavaLangString)) {
        ayxu.a("xGPreDownPolicy", Long.valueOf(paramaqrc.jdField_c_of_type_JavaLangString, 16).longValue(), true);
      }
      if (paramaqrc.h > 0L) {
        ayxu.a("AFBFlowHitXG", paramaqrc.h, true);
      }
      if (paramaqrc.i > 0L) {
        ayxu.a("AFBFlowMissXG", paramaqrc.i, true);
      }
      if (paramaqrc.j > 0L) {
        ayxu.a("APicAvgSize", paramaqrc.j, true);
      }
      if (paramaqrc.k > 0L) {
        ayxu.a("APicMaxSize", paramaqrc.k, true);
      }
      if ((paramaqrc.l == 0L) || (paramaqrc.l == 1L))
      {
        bool1 = bool2;
        if (paramaqrc.l == 1L) {
          bool1 = true;
        }
        ayxu.a("enablePeakFlow", bool1, true);
      }
      if (Pattern.matches("^((([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]);)*+([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]))$", paramaqrc.jdField_d_of_type_JavaLangString)) {
        ayxu.a("PeakFlowTimePeriod", paramaqrc.jdField_d_of_type_JavaLangString, true);
      }
      if (paramaqrc.m > 0L) {
        ayxu.a("PeakFlowMaxPicSize", paramaqrc.m, true);
      }
      return;
    }
  }
  
  public Class<aqrc> clazz()
  {
    return aqrc.class;
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
 * Qualified Name:     aqrd
 * JD-Core Version:    0.7.0.1
 */