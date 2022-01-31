import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

public class amdu
  extends alzl<amdt>
{
  public int a()
  {
    return 251;
  }
  
  @NonNull
  public amdt a(int paramInt)
  {
    return new amdt();
  }
  
  @Nullable
  public amdt a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onParsed " + paramArrayOfalzs.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfalzs != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfalzs.length > 0) {
        localObject1 = amdt.a(paramArrayOfalzs);
      }
    }
    return localObject1;
  }
  
  public Class<amdt> a()
  {
    return amdt.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amdt paramamdt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onUpdate " + paramamdt.toString());
    }
    SafeBitmapFactory.setNeedRegionDecode(paramamdt.jdField_a_of_type_Boolean);
    SafeBitmapFactory.setPxThreshoidToSp(paramamdt.jdField_a_of_type_Long);
    SafeBitmapFactory.setRamThreshoidToSp(paramamdt.jdField_a_of_type_Int);
    SafeBitmapFactory.setThreadCountToSp(paramamdt.jdField_b_of_type_Int);
    axwv.a(paramamdt.jdField_b_of_type_Long);
    axwv.b(paramamdt.jdField_c_of_type_Long);
    axwt.a(paramamdt.jdField_c_of_type_Int);
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
 * Qualified Name:     amdu
 * JD-Core Version:    0.7.0.1
 */