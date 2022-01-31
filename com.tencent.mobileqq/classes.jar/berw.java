import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class berw
  implements Cloneable
{
  public int a;
  public String a;
  public List<berx> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  
  public berw()
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
  
  public static berw a(JSONObject paramJSONObject)
  {
    berw localberw = null;
    if (paramJSONObject != null)
    {
      localberw = new berw();
      localberw.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("custom", false);
      if (localberw.jdField_a_of_type_Boolean) {
        localberw.jdField_b_of_type_Boolean = false;
      }
      localberw.jdField_a_of_type_Int = bffq.a(paramJSONObject.optString("color"));
      localberw.jdField_b_of_type_Int = bffq.a(paramJSONObject.optString("selectedColor"));
      localberw.c = bffq.a(paramJSONObject.optString("backgroundColor"));
      localberw.jdField_a_of_type_JavaLangString = paramJSONObject.optString("borderStyle", "black");
      localberw.jdField_a_of_type_JavaUtilList = a(paramJSONObject.optJSONArray("list"));
      localberw.jdField_b_of_type_JavaLangString = paramJSONObject.optString("position", "bottom");
    }
    return localberw;
  }
  
  public static List<berx> a(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {
          localLinkedList.add(berx.a(localJSONObject));
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public berw a()
  {
    try
    {
      localberw1 = (berw)super.clone();
      try
      {
        localberw1.jdField_a_of_type_JavaUtilList = new LinkedList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          Object localObject = localberw1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (berx)localIterator.next();
          localberw1.jdField_a_of_type_JavaUtilList.add(((berx)localObject).a());
        }
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        berw localberw2;
        berw localberw1 = null;
      }
    }
    localberw2 = localberw1;
    return localberw2;
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
 * Qualified Name:     berw
 * JD-Core Version:    0.7.0.1
 */