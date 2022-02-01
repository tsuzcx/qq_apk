import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExifInfoSwitch;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.qphone.base.util.QLog;

public class aqab
  extends aptq<aqaa>
{
  @NonNull
  public aqaa a(int paramInt)
  {
    return new aqaa();
  }
  
  @Nullable
  public aqaa a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onParsed " + paramArrayOfaptx.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaptx != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaptx.length > 0) {
        localObject1 = aqaa.a(paramArrayOfaptx);
      }
    }
    return localObject1;
  }
  
  public void a(aqaa paramaqaa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onUpdate " + paramaqaa.toString());
    }
    SafeBitmapFactory.setNeedRegionDecode(paramaqaa.jdField_a_of_type_Boolean);
    SafeBitmapFactory.setPxThreshoidToSp(paramaqaa.jdField_a_of_type_Long);
    SafeBitmapFactory.setRamThreshoidToSp(paramaqaa.jdField_a_of_type_Int);
    SafeBitmapFactory.setThreadCountToSp(paramaqaa.jdField_b_of_type_Int);
    PicUploadFileSizeLimit.setLimitC2C(paramaqaa.jdField_b_of_type_Long);
    PicUploadFileSizeLimit.setLimitGroup(paramaqaa.jdField_c_of_type_Long);
    PicUploadExifInfoSwitch.setSwitch(paramaqaa.jdField_c_of_type_Int);
  }
  
  public Class<aqaa> clazz()
  {
    return aqaa.class;
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
 * Qualified Name:     aqab
 * JD-Core Version:    0.7.0.1
 */