import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class bcni
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public bcni()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_c_of_type_Int = -7829368;
  }
  
  public static bcni a(String paramString1, String paramString2)
  {
    bcni localbcni = new bcni();
    localbcni.jdField_a_of_type_JavaLangString = paramString1;
    localbcni.jdField_b_of_type_JavaLangString = "";
    localbcni.jdField_c_of_type_JavaLangString = paramString2;
    try
    {
      localbcni.jdField_a_of_type_Int = 0;
      localbcni.jdField_b_of_type_Int = 0;
      localbcni.jdField_c_of_type_Int = 0;
      return localbcni;
    }
    catch (Exception paramString1) {}
    return localbcni;
  }
  
  public static bcni a(cmd0x934.ItemInfo paramItemInfo)
  {
    bcni localbcni = new bcni();
    localbcni.jdField_a_of_type_JavaLangString = paramItemInfo.title.get();
    localbcni.jdField_b_of_type_JavaLangString = paramItemInfo.icon.get();
    localbcni.jdField_c_of_type_JavaLangString = paramItemInfo.url.get();
    try
    {
      localbcni.jdField_a_of_type_Int = Color.parseColor(paramItemInfo.color.get());
      localbcni.jdField_b_of_type_Int = Color.parseColor(paramItemInfo.font_color.get());
      localbcni.jdField_c_of_type_Int = Color.parseColor(paramItemInfo.border_color.get());
      return localbcni;
    }
    catch (Exception paramItemInfo) {}
    return localbcni;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcni
 * JD-Core Version:    0.7.0.1
 */