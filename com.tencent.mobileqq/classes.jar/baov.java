import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class baov
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public baov()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_c_of_type_Int = -7829368;
  }
  
  public static baov a(String paramString1, String paramString2)
  {
    baov localbaov = new baov();
    localbaov.jdField_a_of_type_JavaLangString = paramString1;
    localbaov.jdField_b_of_type_JavaLangString = "";
    localbaov.jdField_c_of_type_JavaLangString = paramString2;
    try
    {
      localbaov.jdField_a_of_type_Int = 0;
      localbaov.jdField_b_of_type_Int = 0;
      localbaov.jdField_c_of_type_Int = 0;
      return localbaov;
    }
    catch (Exception paramString1) {}
    return localbaov;
  }
  
  public static baov a(cmd0x934.ItemInfo paramItemInfo)
  {
    baov localbaov = new baov();
    localbaov.jdField_a_of_type_JavaLangString = paramItemInfo.title.get();
    localbaov.jdField_b_of_type_JavaLangString = paramItemInfo.icon.get();
    localbaov.jdField_c_of_type_JavaLangString = paramItemInfo.url.get();
    try
    {
      localbaov.jdField_a_of_type_Int = Color.parseColor(paramItemInfo.color.get());
      localbaov.jdField_b_of_type_Int = Color.parseColor(paramItemInfo.font_color.get());
      localbaov.jdField_c_of_type_Int = Color.parseColor(paramItemInfo.border_color.get());
      return localbaov;
    }
    catch (Exception paramItemInfo) {}
    return localbaov;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baov
 * JD-Core Version:    0.7.0.1
 */