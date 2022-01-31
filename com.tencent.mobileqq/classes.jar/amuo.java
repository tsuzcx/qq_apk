import android.text.TextUtils;
import org.json.JSONObject;

public class amuo
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static amuo a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      amuo localamuo = new amuo();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("enable", 0) == 1) {}
      for (;;)
      {
        localamuo.jdField_a_of_type_Boolean = bool;
        localamuo.jdField_a_of_type_Int = paramString.optInt("showCount", 0);
        localamuo.jdField_a_of_type_JavaLangString = paramString.optString("c2cTipsContent", "");
        localamuo.b = paramString.optString("c2cHighlightContent", "");
        localamuo.c = paramString.optString("groupTipsContent", "");
        localamuo.d = paramString.optString("groupHighlightContent", "");
        return localamuo;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return "想及时收到对方的回复，快去打开消息推送设置吧。";
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.b)) {
      return "打开消息推送";
    }
    return this.b;
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "想及时收到对方的回复，快去打开消息推送设置吧。";
    }
    return this.c;
  }
  
  public String d()
  {
    if (TextUtils.isEmpty(this.d)) {
      return "打开消息推送";
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amuo
 * JD-Core Version:    0.7.0.1
 */