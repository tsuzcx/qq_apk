import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class apnz
{
  public static apnx a(apoa paramapoa, int paramInt)
  {
    if (paramapoa == null) {
      throw new RuntimeException("params can not be null!");
    }
    Object localObject;
    switch (paramapoa.jdField_a_of_type_Int)
    {
    default: 
      localObject = new apoc(paramInt);
    }
    for (;;)
    {
      QLog.i("KeyingManager", 1, "getKeying keying: " + localObject + "  params: " + paramapoa.toString());
      return localObject;
      localObject = new apnr(paramInt);
      continue;
      localObject = new apoe(paramInt);
      continue;
      localObject = new apnv(paramInt);
      continue;
      localObject = new apnw(paramInt);
      continue;
      if (TextUtils.isEmpty(paramapoa.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = new apns(paramInt, paramapoa.jdField_a_of_type_JavaLangString);
    }
    throw new RuntimeException("fragmentShader can not be empty!");
  }
  
  public static apoa a(int paramInt)
  {
    return new apoa(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnz
 * JD-Core Version:    0.7.0.1
 */