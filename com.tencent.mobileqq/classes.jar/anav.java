import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class anav
{
  public static anat a(anaw paramanaw, int paramInt)
  {
    if (paramanaw == null) {
      throw new RuntimeException("params can not be null!");
    }
    Object localObject;
    switch (paramanaw.jdField_a_of_type_Int)
    {
    default: 
      localObject = new anay(paramInt);
    }
    for (;;)
    {
      QLog.i("KeyingManager", 1, "getKeying keying: " + localObject + "  params: " + paramanaw.toString());
      return localObject;
      localObject = new anan(paramInt);
      continue;
      localObject = new anba(paramInt);
      continue;
      localObject = new anar(paramInt);
      continue;
      localObject = new anas(paramInt);
      continue;
      if (TextUtils.isEmpty(paramanaw.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject = new anao(paramInt, paramanaw.jdField_a_of_type_JavaLangString);
    }
    throw new RuntimeException("fragmentShader can not be empty!");
  }
  
  public static anaw a(int paramInt)
  {
    return new anaw(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anav
 * JD-Core Version:    0.7.0.1
 */