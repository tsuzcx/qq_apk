import android.text.TextUtils;
import org.json.JSONObject;

public class aoqb
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String b = "";
  private String c = "";
  private String d = "";
  
  public static aoqb a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      aoqb localaoqb = new aoqb();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("enable", 0) == 1) {}
      for (;;)
      {
        localaoqb.jdField_a_of_type_Boolean = bool;
        localaoqb.jdField_a_of_type_Int = paramString.optInt("showCount", 0);
        localaoqb.jdField_a_of_type_JavaLangString = paramString.optString("c2cTipsContent", "");
        localaoqb.b = paramString.optString("c2cHighlightContent", "");
        localaoqb.c = paramString.optString("groupTipsContent", "");
        localaoqb.d = paramString.optString("groupHighlightContent", "");
        return localaoqb;
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
 * Qualified Name:     aoqb
 * JD-Core Version:    0.7.0.1
 */