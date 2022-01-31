import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bdni
  implements Cloneable
{
  public int a;
  public String a;
  public List<bdnj> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  
  public bdni()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public static Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (paramString != null)
        {
          paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
          return paramString;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static bdni a(JSONObject paramJSONObject)
  {
    bdni localbdni = null;
    if (paramJSONObject != null)
    {
      localbdni = new bdni();
      localbdni.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("custom", false);
      if (localbdni.jdField_a_of_type_Boolean) {
        localbdni.jdField_b_of_type_Boolean = false;
      }
      localbdni.jdField_a_of_type_Int = bdyk.a(paramJSONObject.optString("color"));
      localbdni.jdField_b_of_type_Int = bdyk.a(paramJSONObject.optString("selectedColor"));
      localbdni.c = bdyk.a(paramJSONObject.optString("backgroundColor"));
      localbdni.jdField_a_of_type_JavaLangString = paramJSONObject.optString("borderStyle", "black");
      localbdni.jdField_a_of_type_JavaUtilList = a(paramJSONObject.optJSONArray("list"));
      localbdni.jdField_b_of_type_JavaLangString = paramJSONObject.optString("position", "bottom");
    }
    return localbdni;
  }
  
  public static List<bdnj> a(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {
          localLinkedList.add(bdnj.a(localJSONObject));
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public bdni a()
  {
    try
    {
      localbdni1 = (bdni)super.clone();
      try
      {
        localbdni1.jdField_a_of_type_JavaUtilList = new LinkedList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          Object localObject = localbdni1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (bdnj)localIterator.next();
          localbdni1.jdField_a_of_type_JavaUtilList.add(((bdnj)localObject).a());
        }
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        bdni localbdni2;
        bdni localbdni1 = null;
      }
    }
    localbdni2 = localbdni1;
    return localbdni2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdni
 * JD-Core Version:    0.7.0.1
 */