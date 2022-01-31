import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

public class amua
  extends ampb<amtz>
{
  public int a()
  {
    return 251;
  }
  
  @NonNull
  public amtz a(int paramInt)
  {
    return new amtz();
  }
  
  @Nullable
  public amtz a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onParsed " + paramArrayOfampi.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfampi != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfampi.length > 0) {
        localObject1 = amtz.a(paramArrayOfampi);
      }
    }
    return localObject1;
  }
  
  public Class<amtz> a()
  {
    return amtz.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amtz paramamtz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onUpdate " + paramamtz.toString());
    }
    SafeBitmapFactory.setNeedRegionDecode(paramamtz.jdField_a_of_type_Boolean);
    SafeBitmapFactory.setPxThreshoidToSp(paramamtz.jdField_a_of_type_Long);
    SafeBitmapFactory.setRamThreshoidToSp(paramamtz.jdField_a_of_type_Int);
    SafeBitmapFactory.setThreadCountToSp(paramamtz.jdField_b_of_type_Int);
    ayxc.a(paramamtz.jdField_b_of_type_Long);
    ayxc.b(paramamtz.jdField_c_of_type_Long);
    ayxa.a(paramamtz.jdField_c_of_type_Int);
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amua
 * JD-Core Version:    0.7.0.1
 */