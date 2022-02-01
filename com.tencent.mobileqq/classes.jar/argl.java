import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

public class argl
  extends arac<argk>
{
  @NonNull
  public argk a(int paramInt)
  {
    return new argk();
  }
  
  @Nullable
  public argk a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaraj != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaraj.length > 0) {
        localObject1 = argk.a(paramArrayOfaraj);
      }
    }
    return localObject1;
  }
  
  public void a(argk paramargk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onUpdate " + paramargk.toString());
    }
    SafeBitmapFactory.setNeedRegionDecode(paramargk.jdField_a_of_type_Boolean);
    SafeBitmapFactory.setPxThreshoidToSp(paramargk.jdField_a_of_type_Long);
    SafeBitmapFactory.setRamThreshoidToSp(paramargk.jdField_a_of_type_Int);
    SafeBitmapFactory.setThreadCountToSp(paramargk.jdField_b_of_type_Int);
    bezh.a(paramargk.jdField_b_of_type_Long);
    bezh.b(paramargk.jdField_c_of_type_Long);
    bezf.a(paramargk.jdField_c_of_type_Int);
  }
  
  public Class<argk> clazz()
  {
    return argk.class;
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
 * Qualified Name:     argl
 * JD-Core Version:    0.7.0.1
 */