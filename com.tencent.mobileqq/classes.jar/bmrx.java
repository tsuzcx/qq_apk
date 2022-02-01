import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bmrx
{
  public static final List<String> a = new ArrayList(Arrays.asList(new String[] { "4", "5", "7" }));
  public static final List<String> b = new ArrayList(Arrays.asList(new String[] { "1", "4", "5", "7" }));
  public static final List<String> c = new ArrayList(Arrays.asList(new String[] { "2", "3", "6", "", null }));
  public static final List<String> d = new ArrayList(Arrays.asList(new String[] { "2", "3", "", null }));
  public static final List<String> e = new ArrayList(Arrays.asList(new String[] { "2", "3" }));
  public static final List<String> f = new ArrayList(Arrays.asList(new String[] { "6" }));
  
  public static void a(Bundle paramBundle, bmry parambmry)
  {
    ArrayList localArrayList = new ArrayList();
    for (Object localObject = parambmry.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      localArrayList.addAll(Arrays.asList(((Class)localObject).getDeclaredFields()));
    }
    int i = 0;
    if (i < localArrayList.size())
    {
      localObject = (Field)localArrayList.get(i);
      String str1 = ((Field)localObject).getName();
      String str2 = ((Field)localObject).getType().getSimpleName();
      QLog.i("HbInfo", 2, "key = " + str1 + " tname = " + str2);
      String str3 = paramBundle.getString(str1);
      if (str3 == null) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          QLog.i("HbInfo", 2, "set " + str1 + " = " + str3);
          if (str2.equals("String")) {
            ((Field)localObject).set(parambmry, str3);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrx
 * JD-Core Version:    0.7.0.1
 */