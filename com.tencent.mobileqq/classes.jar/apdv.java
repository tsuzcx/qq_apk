import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class apdv
{
  public static apdt a(apdw paramapdw, int paramInt)
  {
    if (paramapdw == null) {
      throw new RuntimeException("params can not be null!");
    }
    Object localObject;
    switch (paramapdw.jdField_a_of_type_Int)
    {
    default: 
      localObject = new apdy(paramInt);
    }
    for (;;)
    {
      QLog.i("KeyingManager", 1, "getKeying keying: " + localObject + "  params: " + paramapdw.toString());
      return localObject;
      localObject = new apdn(paramInt);
      continue;
      localObject = new apea(paramInt);
      continue;
      localObject = new apdr(paramInt);
      continue;
      localObject = new apds(paramInt);
      continue;
      if (TextUtils.isEmpty(paramapdw.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = new apdo(paramInt, paramapdw.jdField_a_of_type_JavaLangString);
    }
    throw new RuntimeException("fragmentShader can not be empty!");
  }
  
  public static apdw a(int paramInt)
  {
    return new apdw(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdv
 * JD-Core Version:    0.7.0.1
 */