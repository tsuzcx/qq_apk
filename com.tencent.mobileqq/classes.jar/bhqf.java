import android.text.TextUtils;
import java.util.ArrayList;

public class bhqf
{
  public static final ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        Object localObject = (aqur)aqlk.a().a(361);
        if ((localObject != null) && (!TextUtils.isEmpty(((aqur)localObject).d)))
        {
          localObject = ((aqur)localObject).d;
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
    aqur localaqur = (aqur)aqlk.a().a(361);
    if (localaqur != null) {}
    switch (paramInt)
    {
    default: 
      return paramBoolean;
    case 1: 
      return localaqur.jdField_a_of_type_Boolean;
    case 2: 
      return localaqur.jdField_b_of_type_Boolean;
    }
    return localaqur.jdField_c_of_type_Boolean;
  }
  
  public static final boolean b(int paramInt, boolean paramBoolean)
  {
    aqur localaqur = (aqur)aqlk.a().a(361);
    if (localaqur != null) {
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
        } while (Math.random() >= Float.valueOf(localaqur.jdField_a_of_type_JavaLangString).floatValue());
        return true;
      } while (Math.random() >= Float.valueOf(localaqur.jdField_b_of_type_JavaLangString).floatValue());
      return true;
    } while (Math.random() >= Float.valueOf(localaqur.jdField_c_of_type_JavaLangString).floatValue());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqf
 * JD-Core Version:    0.7.0.1
 */