import android.graphics.Color;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x934.cmd0x934.ItemInfo;

public class bcrr
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public bcrr()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_c_of_type_Int = -7829368;
  }
  
  public static bcrr a(String paramString1, String paramString2)
  {
    bcrr localbcrr = new bcrr();
    localbcrr.jdField_a_of_type_JavaLangString = paramString1;
    localbcrr.jdField_b_of_type_JavaLangString = "";
    localbcrr.jdField_c_of_type_JavaLangString = paramString2;
    try
    {
      localbcrr.jdField_a_of_type_Int = 0;
      localbcrr.jdField_b_of_type_Int = 0;
      localbcrr.jdField_c_of_type_Int = 0;
      return localbcrr;
    }
    catch (Exception paramString1) {}
    return localbcrr;
  }
  
  public static bcrr a(cmd0x934.ItemInfo paramItemInfo)
  {
    bcrr localbcrr = new bcrr();
    localbcrr.jdField_a_of_type_JavaLangString = paramItemInfo.title.get();
    localbcrr.jdField_b_of_type_JavaLangString = paramItemInfo.icon.get();
    localbcrr.jdField_c_of_type_JavaLangString = paramItemInfo.url.get();
    try
    {
      localbcrr.jdField_a_of_type_Int = Color.parseColor(paramItemInfo.color.get());
      localbcrr.jdField_b_of_type_Int = Color.parseColor(paramItemInfo.font_color.get());
      localbcrr.jdField_c_of_type_Int = Color.parseColor(paramItemInfo.border_color.get());
      return localbcrr;
    }
    catch (Exception paramItemInfo) {}
    return localbcrr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcrr
 * JD-Core Version:    0.7.0.1
 */