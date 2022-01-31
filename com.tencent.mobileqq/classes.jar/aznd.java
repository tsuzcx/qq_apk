import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class aznd
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public aznd()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_c_of_type_Int = -7829368;
  }
  
  public static aznd a(String paramString1, String paramString2)
  {
    aznd localaznd = new aznd();
    localaznd.jdField_a_of_type_JavaLangString = paramString1;
    localaznd.jdField_b_of_type_JavaLangString = "";
    localaznd.jdField_c_of_type_JavaLangString = paramString2;
    try
    {
      localaznd.jdField_a_of_type_Int = 0;
      localaznd.jdField_b_of_type_Int = 0;
      localaznd.jdField_c_of_type_Int = 0;
      return localaznd;
    }
    catch (Exception paramString1) {}
    return localaznd;
  }
  
  public static aznd a(cmd0x934.ItemInfo paramItemInfo)
  {
    aznd localaznd = new aznd();
    localaznd.jdField_a_of_type_JavaLangString = paramItemInfo.title.get();
    localaznd.jdField_b_of_type_JavaLangString = paramItemInfo.icon.get();
    localaznd.jdField_c_of_type_JavaLangString = paramItemInfo.url.get();
    try
    {
      localaznd.jdField_a_of_type_Int = Color.parseColor(paramItemInfo.color.get());
      localaznd.jdField_b_of_type_Int = Color.parseColor(paramItemInfo.font_color.get());
      localaznd.jdField_c_of_type_Int = Color.parseColor(paramItemInfo.border_color.get());
      return localaznd;
    }
    catch (Exception paramItemInfo) {}
    return localaznd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aznd
 * JD-Core Version:    0.7.0.1
 */