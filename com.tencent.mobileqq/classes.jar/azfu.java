import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.List;

public class azfu
{
  public static int[] a = { 2131719570, 2131719569 };
  
  public static String a(int paramInt)
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    String str = localResources.getString(2131719596);
    switch (paramInt)
    {
    default: 
      return str;
    case 1: 
      return localResources.getString(2131719596);
    case 2: 
      return localResources.getString(2131719581);
    }
    return localResources.getString(2131719579);
  }
  
  public static List<azfv> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    azfv localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 7;
    localazfv.b = 40;
    localArrayList.add(localazfv);
    localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 0;
    localazfv.jdField_a_of_type_JavaLangString = paramString;
    localArrayList.add(localazfv);
    paramString = new azfv();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 20;
    localArrayList.add(paramString);
    paramString = new azfv();
    paramString.jdField_a_of_type_Int = 1;
    localArrayList.add(paramString);
    paramString = new azfv();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 10;
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public static List<azfv> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    azfv localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 7;
    localazfv.b = 40;
    localArrayList.add(localazfv);
    localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 3;
    localazfv.jdField_a_of_type_JavaLangString = paramString1;
    localArrayList.add(localazfv);
    paramString1 = new azfv();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 12;
    localArrayList.add(paramString1);
    paramString1 = new azfv();
    paramString1.jdField_a_of_type_Int = 4;
    paramString1.jdField_a_of_type_JavaLangString = paramString2;
    localArrayList.add(paramString1);
    paramString1 = new azfv();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 12;
    localArrayList.add(paramString1);
    paramString1 = new azfv();
    paramString1.jdField_a_of_type_Int = 6;
    localArrayList.add(paramString1);
    paramString1 = new azfv();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 10;
    localArrayList.add(paramString1);
    return localArrayList;
  }
  
  public static List<azfv> a(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    azfv localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 7;
    localazfv.b = 40;
    localArrayList.add(localazfv);
    localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 3;
    localazfv.jdField_a_of_type_JavaLangString = paramString1;
    localArrayList.add(localazfv);
    paramString1 = new azfv();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 12;
    localArrayList.add(paramString1);
    paramString1 = new azfv();
    paramString1.jdField_a_of_type_Int = 4;
    paramString1.jdField_a_of_type_JavaLangString = paramString2;
    localArrayList.add(paramString1);
    paramString1 = new azfv();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 12;
    localArrayList.add(paramString1);
    paramString1 = new azfv();
    paramString1.jdField_a_of_type_Int = 5;
    paramString1.jdField_a_of_type_JavaLangString = paramString3;
    localArrayList.add(paramString1);
    paramString1 = new azfv();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 10;
    localArrayList.add(paramString1);
    return localArrayList;
  }
  
  public static List<azfv> a(String paramString, List<azfm> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new azfv();
    ((azfv)localObject).jdField_a_of_type_Int = 7;
    ((azfv)localObject).b = 40;
    localArrayList.add(localObject);
    localObject = new azfv();
    ((azfv)localObject).jdField_a_of_type_Int = 8;
    ((azfv)localObject).jdField_a_of_type_JavaLangString = paramString;
    localArrayList.add(localObject);
    paramString = new azfv();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 12;
    localArrayList.add(paramString);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        paramString = new azfv();
        paramString.jdField_a_of_type_Int = 9;
        localObject = (azfm)paramList.get(i);
        ((azfm)localObject).b = (i + 1);
        ((azfm)localObject).c = azfm.a(((azfm)localObject).b);
        paramString.jdField_a_of_type_Azfm = ((azfm)localObject);
        localArrayList.add(paramString);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<azfv> b(String paramString)
  {
    int i = 0;
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    ArrayList localArrayList = new ArrayList();
    azfv localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 7;
    localazfv.b = 40;
    localArrayList.add(localazfv);
    localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 0;
    localazfv.jdField_a_of_type_JavaLangString = paramString;
    localArrayList.add(localazfv);
    paramString = new azfv();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 20;
    localArrayList.add(paramString);
    while (i < a.length)
    {
      paramString = new azfv();
      paramString.jdField_a_of_type_Int = 2;
      paramString.jdField_a_of_type_JavaLangString = localResources.getString(a[i]);
      localArrayList.add(paramString);
      paramString = new azfv();
      paramString.jdField_a_of_type_Int = 7;
      paramString.b = 4;
      localArrayList.add(paramString);
      i += 1;
    }
    paramString = new azfv();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 6;
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public static List<azfv> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    azfv localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 7;
    localazfv.b = 40;
    localArrayList.add(localazfv);
    localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 0;
    localazfv.jdField_a_of_type_JavaLangString = paramString;
    localArrayList.add(localazfv);
    paramString = new azfv();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 30;
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public static List<azfv> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    azfv localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 7;
    localazfv.b = 40;
    localArrayList.add(localazfv);
    localazfv = new azfv();
    localazfv.jdField_a_of_type_Int = 0;
    localazfv.jdField_a_of_type_JavaLangString = paramString;
    localArrayList.add(localazfv);
    paramString = new azfv();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 12;
    localArrayList.add(paramString);
    paramString = new azfv();
    paramString.jdField_a_of_type_Int = 6;
    localArrayList.add(paramString);
    paramString = new azfv();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 10;
    localArrayList.add(paramString);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfu
 * JD-Core Version:    0.7.0.1
 */