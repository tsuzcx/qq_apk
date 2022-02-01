import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class bgwk
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public bgwk()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_c_of_type_Int = -7829368;
  }
  
  public static bgwk a(String paramString1, String paramString2)
  {
    bgwk localbgwk = new bgwk();
    localbgwk.jdField_a_of_type_JavaLangString = paramString1;
    localbgwk.jdField_b_of_type_JavaLangString = "";
    localbgwk.jdField_c_of_type_JavaLangString = paramString2;
    try
    {
      localbgwk.jdField_a_of_type_Int = 0;
      localbgwk.jdField_b_of_type_Int = 0;
      localbgwk.jdField_c_of_type_Int = 0;
      return localbgwk;
    }
    catch (Exception paramString1) {}
    return localbgwk;
  }
  
  public static bgwk a(cmd0x934.ItemInfo paramItemInfo)
  {
    bgwk localbgwk = new bgwk();
    localbgwk.jdField_a_of_type_JavaLangString = paramItemInfo.title.get();
    localbgwk.jdField_b_of_type_JavaLangString = paramItemInfo.icon.get();
    localbgwk.jdField_c_of_type_JavaLangString = paramItemInfo.url.get();
    try
    {
      localbgwk.jdField_a_of_type_Int = Color.parseColor(paramItemInfo.color.get());
      localbgwk.jdField_b_of_type_Int = Color.parseColor(paramItemInfo.font_color.get());
      localbgwk.jdField_c_of_type_Int = Color.parseColor(paramItemInfo.border_color.get());
      return localbgwk;
    }
    catch (Exception paramItemInfo) {}
    return localbgwk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwk
 * JD-Core Version:    0.7.0.1
 */