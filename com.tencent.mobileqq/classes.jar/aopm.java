import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

public class aopm
  extends aokh<aopl>
{
  public int a()
  {
    return 251;
  }
  
  @NonNull
  public aopl a(int paramInt)
  {
    return new aopl();
  }
  
  @Nullable
  public aopl a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onParsed " + paramArrayOfaoko.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaoko != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaoko.length > 0) {
        localObject1 = aopl.a(paramArrayOfaoko);
      }
    }
    return localObject1;
  }
  
  public Class<aopl> a()
  {
    return aopl.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aopl paramaopl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onUpdate " + paramaopl.toString());
    }
    SafeBitmapFactory.setNeedRegionDecode(paramaopl.jdField_a_of_type_Boolean);
    SafeBitmapFactory.setPxThreshoidToSp(paramaopl.jdField_a_of_type_Long);
    SafeBitmapFactory.setRamThreshoidToSp(paramaopl.jdField_a_of_type_Int);
    SafeBitmapFactory.setThreadCountToSp(paramaopl.jdField_b_of_type_Int);
    bazm.a(paramaopl.jdField_b_of_type_Long);
    bazm.b(paramaopl.jdField_c_of_type_Long);
    bazk.a(paramaopl.jdField_c_of_type_Int);
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
 * Qualified Name:     aopm
 * JD-Core Version:    0.7.0.1
 */