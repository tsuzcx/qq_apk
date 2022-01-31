import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class baax
  extends babc
{
  public int a;
  public long a;
  public String a;
  public URL a;
  public ConcurrentHashMap<String, bhws> a;
  public int b;
  protected String b;
  public String c;
  public int d;
  public String d;
  public int e;
  
  public baax() {}
  
  public baax(String paramString)
  {
    b(paramString);
    a();
    this.jdField_d_of_type_JavaLangString = String.valueOf(hashCode());
  }
  
  public baax(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
    this.jdField_d_of_type_JavaLangString = String.valueOf(hashCode());
  }
  
  public static String b()
  {
    VFSFile localVFSFile = new VFSFile(TroopHWJsPlugin.jdField_a_of_type_JavaLangString);
    if (!localVFSFile.exists())
    {
      localVFSFile.mkdirs();
      bbdj.c(TroopHWJsPlugin.jdField_a_of_type_JavaLangString + ".nomedia");
    }
    return TroopHWJsPlugin.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return 0;
  }
  
  public bhws a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString2 = new bhws(tsu.a(), paramString1, paramString2);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
      return paramString2;
    }
    return (bhws)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
  }
  
  public Stream<baax> a(XMediaEditor paramXMediaEditor)
  {
    this.g = 1;
    Object localObject2 = Stream.of(this).map(new ThreadOffFunction("ImageInfo", 2));
    Object localObject1 = localObject2;
    if (!apvb.b(this.jdField_c_of_type_JavaLangString)) {
      localObject1 = ((Stream)localObject2).map(new baay(this.jdField_d_of_type_Int));
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localObject1 = ((Stream)localObject1).map(new baaz(0, paramXMediaEditor, paramXMediaEditor.a("troopuin")));
    }
    for (;;)
    {
      localObject2 = paramXMediaEditor.findViewHolderForLayoutPosition(this.jdField_c_of_type_Int);
      if ((localObject2 instanceof baby))
      {
        localObject2 = (baby)localObject2;
        if (this.jdField_d_of_type_JavaLangString.equals(((baby)localObject2).a.getTag())) {
          ((babu)((baao)paramXMediaEditor.getAdapter()).a.a(1)).a((baby)localObject2, this, 0);
        }
      }
      return ((Stream)localObject1).map(new UIThreadOffFunction(null));
    }
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "img");
      localJSONObject.put("url", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("width", this.jdField_a_of_type_Int);
      localJSONObject.put("height", this.jdField_b_of_type_Int);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ImageInfo", 2, "ImageInfo getContent exception.");
    }
    return localJSONObject;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (apvb.b(this.jdField_a_of_type_JavaLangString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString, localOptions);
      this.jdField_a_of_type_Int = localOptions.outWidth;
      this.jdField_b_of_type_Int = localOptions.outHeight;
      int i = JpegExifReader.readOrientation(this.jdField_a_of_type_JavaLangString);
      if ((i == 6) || (i == 5) || (i == 8) || (i == 7))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageInfo", 2, new Object[] { "calculateLocalImageSize need orientation. before width=", Integer.valueOf(this.jdField_a_of_type_Int), ", height=", Integer.valueOf(this.jdField_b_of_type_Int), ", path=", this.jdField_a_of_type_JavaLangString });
        }
        i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = i;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageInfo", 2, new Object[] { "calculateLocalImageSize result. width=", Integer.valueOf(this.jdField_a_of_type_Int), ", height=", Integer.valueOf(this.jdField_b_of_type_Int), ", path=", this.jdField_a_of_type_JavaLangString, ", cost=", Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageInfo", 2, new Object[] { "ImageInfo createFrom json: ", paramJSONObject });
    }
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    c(paramJSONObject.optString("url"));
    this.jdField_a_of_type_Int = paramJSONObject.optInt("width");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("height");
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
  }
  
  public int b()
  {
    return 1;
  }
  
  public void b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaNetURL = new File(paramString).toURI().toURL();
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ImageInfo", 1, "setURLFromPath exception.");
    }
  }
  
  public boolean b()
  {
    return TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
  }
  
  public void c(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaNetURL = new URL(paramString);
      this.jdField_b_of_type_JavaLangString = paramString;
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ImageInfo", 1, "Image setURLFromContentUrl exception.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baax
 * JD-Core Version:    0.7.0.1
 */