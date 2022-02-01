import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class bfwj
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public bfwj()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_c_of_type_Int = -7829368;
  }
  
  public static bfwj a(String paramString1, String paramString2)
  {
    bfwj localbfwj = new bfwj();
    localbfwj.jdField_a_of_type_JavaLangString = paramString1;
    localbfwj.jdField_b_of_type_JavaLangString = "";
    localbfwj.jdField_c_of_type_JavaLangString = paramString2;
    try
    {
      localbfwj.jdField_a_of_type_Int = 0;
      localbfwj.jdField_b_of_type_Int = 0;
      localbfwj.jdField_c_of_type_Int = 0;
      return localbfwj;
    }
    catch (Exception paramString1) {}
    return localbfwj;
  }
  
  public static bfwj a(cmd0x934.ItemInfo paramItemInfo)
  {
    bfwj localbfwj = new bfwj();
    localbfwj.jdField_a_of_type_JavaLangString = paramItemInfo.title.get();
    localbfwj.jdField_b_of_type_JavaLangString = paramItemInfo.icon.get();
    localbfwj.jdField_c_of_type_JavaLangString = paramItemInfo.url.get();
    try
    {
      localbfwj.jdField_a_of_type_Int = Color.parseColor(paramItemInfo.color.get());
      localbfwj.jdField_b_of_type_Int = Color.parseColor(paramItemInfo.font_color.get());
      localbfwj.jdField_c_of_type_Int = Color.parseColor(paramItemInfo.border_color.get());
      return localbfwj;
    }
    catch (Exception paramItemInfo) {}
    return localbfwj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwj
 * JD-Core Version:    0.7.0.1
 */