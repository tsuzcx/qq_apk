import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

public class aold
  extends aofy<aolc>
{
  public int a()
  {
    return 251;
  }
  
  @NonNull
  public aolc a(int paramInt)
  {
    return new aolc();
  }
  
  @Nullable
  public aolc a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onParsed " + paramArrayOfaogf.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaogf != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaogf.length > 0) {
        localObject1 = aolc.a(paramArrayOfaogf);
      }
    }
    return localObject1;
  }
  
  public Class<aolc> a()
  {
    return aolc.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aolc paramaolc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onUpdate " + paramaolc.toString());
    }
    SafeBitmapFactory.setNeedRegionDecode(paramaolc.jdField_a_of_type_Boolean);
    SafeBitmapFactory.setPxThreshoidToSp(paramaolc.jdField_a_of_type_Long);
    SafeBitmapFactory.setRamThreshoidToSp(paramaolc.jdField_a_of_type_Int);
    SafeBitmapFactory.setThreadCountToSp(paramaolc.jdField_b_of_type_Int);
    bavd.a(paramaolc.jdField_b_of_type_Long);
    bavd.b(paramaolc.jdField_c_of_type_Long);
    bavb.a(paramaolc.jdField_c_of_type_Int);
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
 * Qualified Name:     aold
 * JD-Core Version:    0.7.0.1
 */