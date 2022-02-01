import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aprl
{
  public static aprj a(aprm paramaprm, int paramInt)
  {
    if (paramaprm == null) {
      throw new RuntimeException("params can not be null!");
    }
    Object localObject;
    switch (paramaprm.jdField_a_of_type_Int)
    {
    default: 
      localObject = new apro(paramInt);
    }
    for (;;)
    {
      QLog.i("KeyingManager", 1, "getKeying keying: " + localObject + "  params: " + paramaprm.toString());
      return localObject;
      localObject = new aprd(paramInt);
      continue;
      localObject = new aprq(paramInt);
      continue;
      localObject = new aprh(paramInt);
      continue;
      localObject = new apri(paramInt);
      continue;
      if (TextUtils.isEmpty(paramaprm.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = new apre(paramInt, paramaprm.jdField_a_of_type_JavaLangString);
    }
    throw new RuntimeException("fragmentShader can not be empty!");
  }
  
  public static aprm a(int paramInt)
  {
    return new aprm(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprl
 * JD-Core Version:    0.7.0.1
 */