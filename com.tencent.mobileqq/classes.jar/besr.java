import android.text.TextUtils;
import org.json.JSONObject;

public class besr
  implements Cloneable
{
  public static String c = "auto";
  public static String d = "portrait";
  public static String e = "landscape";
  public int a;
  public berz a;
  public Boolean a;
  public String a;
  public int b;
  public Boolean b;
  public String b;
  
  public static besr a()
  {
    besr localbesr = new besr();
    localbesr.jdField_a_of_type_Berz = berz.a();
    localbesr.jdField_a_of_type_Int = bfgh.a("#ffffff");
    localbesr.jdField_a_of_type_JavaLangString = "dark";
    localbesr.jdField_a_of_type_JavaLangBoolean = null;
    localbesr.jdField_b_of_type_Int = 50;
    localbesr.jdField_b_of_type_JavaLangBoolean = null;
    localbesr.jdField_b_of_type_JavaLangString = null;
    return localbesr;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    int i;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Berz.a(paramJSONObject);
      localObject1 = paramJSONObject.optString("backgroundColor");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label143;
      }
      i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("backgroundTextStyle", this.jdField_a_of_type_JavaLangString);
      if (!paramJSONObject.has("enablePullDownRefresh")) {
        break label151;
      }
      localObject1 = Boolean.valueOf(paramJSONObject.optBoolean("enablePullDownRefresh"));
      label72:
      this.jdField_a_of_type_JavaLangBoolean = ((Boolean)localObject1);
      this.jdField_b_of_type_Int = paramJSONObject.optInt("onReachBottomDistance", this.jdField_b_of_type_Int);
      if (!paramJSONObject.has("disableScroll")) {
        break label156;
      }
    }
    label143:
    label151:
    label156:
    for (Object localObject1 = Boolean.valueOf(paramJSONObject.optBoolean("disableScroll"));; localObject1 = null)
    {
      this.jdField_b_of_type_JavaLangBoolean = ((Boolean)localObject1);
      localObject1 = localObject2;
      if (paramJSONObject.has("pageOrientation")) {
        localObject1 = paramJSONObject.optString("pageOrientation", d);
      }
      this.jdField_b_of_type_JavaLangString = ((String)localObject1);
      return;
      i = bfgh.a((String)localObject1);
      break;
      localObject1 = null;
      break label72;
    }
  }
  
  public besr b()
  {
    try
    {
      localbesr = (besr)super.clone();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localbesr.jdField_a_of_type_Berz = this.jdField_a_of_type_Berz.b();
        return localbesr;
      }
      catch (Throwable localThrowable2)
      {
        besr localbesr;
        break label24;
      }
      localThrowable1 = localThrowable1;
      localbesr = null;
    }
    label24:
    return localbesr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     besr
 * JD-Core Version:    0.7.0.1
 */