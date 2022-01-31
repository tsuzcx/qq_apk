import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

public class amtz
  extends ampa<amty>
{
  public int a()
  {
    return 251;
  }
  
  @NonNull
  public amty a(int paramInt)
  {
    return new amty();
  }
  
  @Nullable
  public amty a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onParsed " + paramArrayOfamph.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfamph != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfamph.length > 0) {
        localObject1 = amty.a(paramArrayOfamph);
      }
    }
    return localObject1;
  }
  
  public Class<amty> a()
  {
    return amty.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amty paramamty)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onUpdate " + paramamty.toString());
    }
    SafeBitmapFactory.setNeedRegionDecode(paramamty.jdField_a_of_type_Boolean);
    SafeBitmapFactory.setPxThreshoidToSp(paramamty.jdField_a_of_type_Long);
    SafeBitmapFactory.setRamThreshoidToSp(paramamty.jdField_a_of_type_Int);
    SafeBitmapFactory.setThreadCountToSp(paramamty.jdField_b_of_type_Int);
    ayxe.a(paramamty.jdField_b_of_type_Long);
    ayxe.b(paramamty.jdField_c_of_type_Long);
    ayxc.a(paramamty.jdField_c_of_type_Int);
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
 * Qualified Name:     amtz
 * JD-Core Version:    0.7.0.1
 */