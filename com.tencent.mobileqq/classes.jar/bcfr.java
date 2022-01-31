import android.text.TextUtils;
import java.util.ArrayList;

public class bcfr
{
  public static final ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        Object localObject = (amww)ampl.a().a(361);
        if ((localObject != null) && (!TextUtils.isEmpty(((amww)localObject).d)))
        {
          localObject = ((amww)localObject).d;
          localObject = ((String)localObject).split(";");
          int j = localObject.length;
          int i = 0;
          if (i < j)
          {
            localArrayList.add(localObject[i]);
            i += 1;
            continue;
          }
          return localArrayList;
        }
      }
      catch (Throwable localThrowable) {}
      String str = "QQ";
    }
  }
  
  public static final boolean a(int paramInt, boolean paramBoolean)
  {
    amww localamww = (amww)ampl.a().a(361);
    if (localamww != null) {}
    switch (paramInt)
    {
    default: 
      return paramBoolean;
    case 1: 
      return localamww.jdField_a_of_type_Boolean;
    case 2: 
      return localamww.jdField_b_of_type_Boolean;
    }
    return localamww.jdField_c_of_type_Boolean;
  }
  
  public static final boolean b(int paramInt, boolean paramBoolean)
  {
    amww localamww = (amww)ampl.a().a(361);
    if (localamww != null) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return paramBoolean;
        } while (Math.random() >= Float.valueOf(localamww.jdField_a_of_type_JavaLangString).floatValue());
        return true;
      } while (Math.random() >= Float.valueOf(localamww.jdField_b_of_type_JavaLangString).floatValue());
      return true;
    } while (Math.random() >= Float.valueOf(localamww.jdField_c_of_type_JavaLangString).floatValue());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcfr
 * JD-Core Version:    0.7.0.1
 */