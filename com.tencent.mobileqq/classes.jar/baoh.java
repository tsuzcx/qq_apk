import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class baoh
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public baoh()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_c_of_type_Int = -7829368;
  }
  
  public static baoh a(String paramString1, String paramString2)
  {
    baoh localbaoh = new baoh();
    localbaoh.jdField_a_of_type_JavaLangString = paramString1;
    localbaoh.jdField_b_of_type_JavaLangString = "";
    localbaoh.jdField_c_of_type_JavaLangString = paramString2;
    try
    {
      localbaoh.jdField_a_of_type_Int = 0;
      localbaoh.jdField_b_of_type_Int = 0;
      localbaoh.jdField_c_of_type_Int = 0;
      return localbaoh;
    }
    catch (Exception paramString1) {}
    return localbaoh;
  }
  
  public static baoh a(cmd0x934.ItemInfo paramItemInfo)
  {
    baoh localbaoh = new baoh();
    localbaoh.jdField_a_of_type_JavaLangString = paramItemInfo.title.get();
    localbaoh.jdField_b_of_type_JavaLangString = paramItemInfo.icon.get();
    localbaoh.jdField_c_of_type_JavaLangString = paramItemInfo.url.get();
    try
    {
      localbaoh.jdField_a_of_type_Int = Color.parseColor(paramItemInfo.color.get());
      localbaoh.jdField_b_of_type_Int = Color.parseColor(paramItemInfo.font_color.get());
      localbaoh.jdField_c_of_type_Int = Color.parseColor(paramItemInfo.border_color.get());
      return localbaoh;
    }
    catch (Exception paramItemInfo) {}
    return localbaoh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baoh
 * JD-Core Version:    0.7.0.1
 */