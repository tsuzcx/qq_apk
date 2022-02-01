import android.text.TextUtils;
import java.util.ArrayList;

public class bira
{
  public static final ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        Object localObject = (arkd)aran.a().a(361);
        if ((localObject != null) && (!TextUtils.isEmpty(((arkd)localObject).d)))
        {
          localObject = ((arkd)localObject).d;
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
    arkd localarkd = (arkd)aran.a().a(361);
    if (localarkd != null) {}
    switch (paramInt)
    {
    default: 
      return paramBoolean;
    case 1: 
      return localarkd.jdField_a_of_type_Boolean;
    case 2: 
      return localarkd.jdField_b_of_type_Boolean;
    }
    return localarkd.jdField_c_of_type_Boolean;
  }
  
  public static final boolean b(int paramInt, boolean paramBoolean)
  {
    arkd localarkd = (arkd)aran.a().a(361);
    if (localarkd != null) {
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
        } while (Math.random() >= Float.valueOf(localarkd.jdField_a_of_type_JavaLangString).floatValue());
        return true;
      } while (Math.random() >= Float.valueOf(localarkd.jdField_b_of_type_JavaLangString).floatValue());
      return true;
    } while (Math.random() >= Float.valueOf(localarkd.jdField_c_of_type_JavaLangString).floatValue());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bira
 * JD-Core Version:    0.7.0.1
 */