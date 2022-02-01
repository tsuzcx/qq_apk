import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

public class aqrb
  extends aqkz<aqra>
{
  @NonNull
  public aqra a(int paramInt)
  {
    return new aqra();
  }
  
  @Nullable
  public aqra a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onParsed " + paramArrayOfaqlg.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqlg != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqlg.length > 0) {
        localObject1 = aqra.a(paramArrayOfaqlg);
      }
    }
    return localObject1;
  }
  
  public void a(aqra paramaqra)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onUpdate " + paramaqra.toString());
    }
    SafeBitmapFactory.setNeedRegionDecode(paramaqra.jdField_a_of_type_Boolean);
    SafeBitmapFactory.setPxThreshoidToSp(paramaqra.jdField_a_of_type_Long);
    SafeBitmapFactory.setRamThreshoidToSp(paramaqra.jdField_a_of_type_Int);
    SafeBitmapFactory.setThreadCountToSp(paramaqra.jdField_b_of_type_Int);
    beao.a(paramaqra.jdField_b_of_type_Long);
    beao.b(paramaqra.jdField_c_of_type_Long);
    beam.a(paramaqra.jdField_c_of_type_Int);
  }
  
  public Class<aqra> clazz()
  {
    return aqra.class;
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
      QLog.d("PicCommonConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 251;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqrb
 * JD-Core Version:    0.7.0.1
 */