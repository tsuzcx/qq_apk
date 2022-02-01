import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONObject;

public abstract class bpnb
{
  public double a;
  private float a;
  @Deprecated
  public int a;
  public Drawable a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  private int c = 5;
  public String c;
  public String d;
  public String e;
  private String f;
  
  public bpnb(@NonNull String paramString)
  {
    this.jdField_a_of_type_Float = 0.05F;
    this.jdField_a_of_type_Double = 1.0D;
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalStateException("FacePackage'id can not be null.");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public abstract String a();
  
  public abstract String a(int paramInt);
  
  public void a(String paramString)
  {
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      yqp.e("FacePackage", "config json is empty.");
      i = 0;
      if (i == 0)
      {
        yqp.e("FacePackage", "config json is illegal, use default value, type : %s", new Object[] { a() });
        if (!"NormalFacePackage".equals(a())) {
          break label240;
        }
        if (!"1".equals(this.jdField_a_of_type_JavaLangString)) {
          break label226;
        }
        this.c = 5;
        this.jdField_a_of_type_Float = 0.05F;
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.f = null;
        return;
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          this.c = localJSONObject.getInt("amount");
          this.jdField_a_of_type_Float = Float.valueOf(localJSONObject.getString("spacing")).floatValue();
          this.jdField_a_of_type_Double = localJSONObject.optDouble("scale", 1.0D);
          if ((this.c < 1) || (this.jdField_a_of_type_Float < 0.0F) || (this.jdField_a_of_type_Float >= 0.5D))
          {
            yqp.e("FacePackage", "config json is illegal : %s", new Object[] { paramString });
            i = 0;
            break;
          }
          this.f = paramString;
          i = 1;
        }
        catch (Exception localException)
        {
          yqp.e("FacePackage", "parse config json error : " + paramString + ", exception : " + localException.toString());
          i = 0;
        }
      }
      break;
      label226:
      this.c = 5;
      this.jdField_a_of_type_Float = 0.05F;
      continue;
      label240:
      if (!"LocationFacePackage".equals(a())) {
        break label266;
      }
      this.c = 4;
      this.jdField_a_of_type_Float = 0.1F;
    }
    label266:
    throw new IllegalStateException("unknown face package, type:" + a());
  }
  
  public abstract int b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpnb
 * JD-Core Version:    0.7.0.1
 */