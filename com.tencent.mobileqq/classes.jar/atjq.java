import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.MD5;
import org.json.JSONObject;

public class atjq
  implements ayvn
{
  public atjq(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"code\":-4}" });
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = bdhb.a(paramString);
        if (arrayOfByte == null) {
          break;
        }
        localJSONObject.put("code", 0);
        StringBuilder localStringBuilder = new StringBuilder("data:");
        if (awkr.a(paramString))
        {
          str = "image/gif;";
          localStringBuilder.append(str);
          localStringBuilder.append("base64,");
          localStringBuilder.append(bdfr.encodeToString(arrayOfByte, 0));
          localJSONObject.put("imgData", localStringBuilder);
          localJSONObject.put("md5", MD5.toMD5(arrayOfByte));
          localJSONObject.put("imagePath", paramString);
          this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
          return;
        }
      }
      catch (Exception paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"code\":-3}" });
        return;
      }
      String str = "image/jpg;";
    }
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"code\":-3}" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjq
 * JD-Core Version:    0.7.0.1
 */