import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aoky
{
  public static aokw a(aokz paramaokz, int paramInt)
  {
    if (paramaokz == null) {
      throw new RuntimeException("params can not be null!");
    }
    Object localObject;
    switch (paramaokz.jdField_a_of_type_Int)
    {
    default: 
      localObject = new aolb(paramInt);
    }
    for (;;)
    {
      QLog.i("KeyingManager", 1, "getKeying keying: " + localObject + "  params: " + paramaokz.toString());
      return localObject;
      localObject = new aokq(paramInt);
      continue;
      localObject = new aold(paramInt);
      continue;
      localObject = new aoku(paramInt);
      continue;
      localObject = new aokv(paramInt);
      continue;
      if (TextUtils.isEmpty(paramaokz.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = new aokr(paramInt, paramaokz.jdField_a_of_type_JavaLangString);
    }
    throw new RuntimeException("fragmentShader can not be empty!");
  }
  
  public static aokz a(int paramInt)
  {
    return new aokz(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoky
 * JD-Core Version:    0.7.0.1
 */