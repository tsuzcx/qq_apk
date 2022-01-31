import android.text.TextUtils;
import org.json.JSONObject;

public class besa
  implements Cloneable
{
  public static String c = "auto";
  public static String d = "portrait";
  public static String e = "landscape";
  public int a;
  public beri a;
  public Boolean a;
  public String a;
  public int b;
  public Boolean b;
  public String b;
  
  public static besa a()
  {
    besa localbesa = new besa();
    localbesa.jdField_a_of_type_Beri = beri.a();
    localbesa.jdField_a_of_type_Int = bffq.a("#ffffff");
    localbesa.jdField_a_of_type_JavaLangString = "dark";
    localbesa.jdField_a_of_type_JavaLangBoolean = null;
    localbesa.jdField_b_of_type_Int = 50;
    localbesa.jdField_b_of_type_JavaLangBoolean = null;
    localbesa.jdField_b_of_type_JavaLangString = null;
    return localbesa;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    int i;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Beri.a(paramJSONObject);
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
      i = bffq.a((String)localObject1);
      break;
      localObject1 = null;
      break label72;
    }
  }
  
  public besa b()
  {
    try
    {
      localbesa = (besa)super.clone();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localbesa.jdField_a_of_type_Beri = this.jdField_a_of_type_Beri.b();
        return localbesa;
      }
      catch (Throwable localThrowable2)
      {
        besa localbesa;
        break label24;
      }
      localThrowable1 = localThrowable1;
      localbesa = null;
    }
    label24:
    return localbesa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     besa
 * JD-Core Version:    0.7.0.1
 */