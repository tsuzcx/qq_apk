import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class bgod
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public bgod()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_c_of_type_Int = -7829368;
  }
  
  public static bgod a(String paramString1, String paramString2)
  {
    bgod localbgod = new bgod();
    localbgod.jdField_a_of_type_JavaLangString = paramString1;
    localbgod.jdField_b_of_type_JavaLangString = "";
    localbgod.jdField_c_of_type_JavaLangString = paramString2;
    try
    {
      localbgod.jdField_a_of_type_Int = 0;
      localbgod.jdField_b_of_type_Int = 0;
      localbgod.jdField_c_of_type_Int = 0;
      return localbgod;
    }
    catch (Exception paramString1) {}
    return localbgod;
  }
  
  public static bgod a(cmd0x934.ItemInfo paramItemInfo)
  {
    bgod localbgod = new bgod();
    localbgod.jdField_a_of_type_JavaLangString = paramItemInfo.title.get();
    localbgod.jdField_b_of_type_JavaLangString = paramItemInfo.icon.get();
    localbgod.jdField_c_of_type_JavaLangString = paramItemInfo.url.get();
    try
    {
      localbgod.jdField_a_of_type_Int = Color.parseColor(paramItemInfo.color.get());
      localbgod.jdField_b_of_type_Int = Color.parseColor(paramItemInfo.font_color.get());
      localbgod.jdField_c_of_type_Int = Color.parseColor(paramItemInfo.border_color.get());
      return localbgod;
    }
    catch (Exception paramItemInfo) {}
    return localbgod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgod
 * JD-Core Version:    0.7.0.1
 */