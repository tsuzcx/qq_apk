import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExifInfoSwitch;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.qphone.base.util.QLog;

public class arde
  extends aqwt<ardd>
{
  @NonNull
  public ardd a(int paramInt)
  {
    return new ardd();
  }
  
  @Nullable
  public ardd a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqxa != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqxa.length > 0) {
        localObject1 = ardd.a(paramArrayOfaqxa);
      }
    }
    return localObject1;
  }
  
  public void a(ardd paramardd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onUpdate " + paramardd.toString());
    }
    SafeBitmapFactory.setNeedRegionDecode(paramardd.jdField_a_of_type_Boolean);
    SafeBitmapFactory.setPxThreshoidToSp(paramardd.jdField_a_of_type_Long);
    SafeBitmapFactory.setRamThreshoidToSp(paramardd.jdField_a_of_type_Int);
    SafeBitmapFactory.setThreadCountToSp(paramardd.jdField_b_of_type_Int);
    PicUploadFileSizeLimit.setLimitC2C(paramardd.jdField_b_of_type_Long);
    PicUploadFileSizeLimit.setLimitGroup(paramardd.jdField_c_of_type_Long);
    PicUploadExifInfoSwitch.setSwitch(paramardd.jdField_c_of_type_Int);
  }
  
  public Class<ardd> clazz()
  {
    return ardd.class;
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
 * Qualified Name:     arde
 * JD-Core Version:    0.7.0.1
 */