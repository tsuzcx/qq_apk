import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class besn
  implements Cloneable
{
  public int a;
  public String a;
  public List<beso> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  
  public besn()
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
  
  public static besn a(JSONObject paramJSONObject)
  {
    besn localbesn = null;
    if (paramJSONObject != null)
    {
      localbesn = new besn();
      localbesn.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("custom", false);
      if (localbesn.jdField_a_of_type_Boolean) {
        localbesn.jdField_b_of_type_Boolean = false;
      }
      localbesn.jdField_a_of_type_Int = bfgh.a(paramJSONObject.optString("color"));
      localbesn.jdField_b_of_type_Int = bfgh.a(paramJSONObject.optString("selectedColor"));
      localbesn.c = bfgh.a(paramJSONObject.optString("backgroundColor"));
      localbesn.jdField_a_of_type_JavaLangString = paramJSONObject.optString("borderStyle", "black");
      localbesn.jdField_a_of_type_JavaUtilList = a(paramJSONObject.optJSONArray("list"));
      localbesn.jdField_b_of_type_JavaLangString = paramJSONObject.optString("position", "bottom");
    }
    return localbesn;
  }
  
  public static List<beso> a(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {
          localLinkedList.add(beso.a(localJSONObject));
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public besn a()
  {
    try
    {
      localbesn1 = (besn)super.clone();
      try
      {
        localbesn1.jdField_a_of_type_JavaUtilList = new LinkedList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          Object localObject = localbesn1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (beso)localIterator.next();
          localbesn1.jdField_a_of_type_JavaUtilList.add(((beso)localObject).a());
        }
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        besn localbesn2;
        besn localbesn1 = null;
      }
    }
    localbesn2 = localbesn1;
    return localbesn2;
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
 * Qualified Name:     besn
 * JD-Core Version:    0.7.0.1
 */