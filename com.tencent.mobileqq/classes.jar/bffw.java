import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class bffw
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public bffw()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_c_of_type_Int = -7829368;
  }
  
  public static bffw a(String paramString1, String paramString2)
  {
    bffw localbffw = new bffw();
    localbffw.jdField_a_of_type_JavaLangString = paramString1;
    localbffw.jdField_b_of_type_JavaLangString = "";
    localbffw.jdField_c_of_type_JavaLangString = paramString2;
    try
    {
      localbffw.jdField_a_of_type_Int = 0;
      localbffw.jdField_b_of_type_Int = 0;
      localbffw.jdField_c_of_type_Int = 0;
      return localbffw;
    }
    catch (Exception paramString1) {}
    return localbffw;
  }
  
  public static bffw a(cmd0x934.ItemInfo paramItemInfo)
  {
    bffw localbffw = new bffw();
    localbffw.jdField_a_of_type_JavaLangString = paramItemInfo.title.get();
    localbffw.jdField_b_of_type_JavaLangString = paramItemInfo.icon.get();
    localbffw.jdField_c_of_type_JavaLangString = paramItemInfo.url.get();
    try
    {
      localbffw.jdField_a_of_type_Int = Color.parseColor(paramItemInfo.color.get());
      localbffw.jdField_b_of_type_Int = Color.parseColor(paramItemInfo.font_color.get());
      localbffw.jdField_c_of_type_Int = Color.parseColor(paramItemInfo.border_color.get());
      return localbffw;
    }
    catch (Exception paramItemInfo) {}
    return localbffw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffw
 * JD-Core Version:    0.7.0.1
 */