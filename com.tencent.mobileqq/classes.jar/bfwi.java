import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;

public class bfwi
{
  public bfwj a;
  public boolean a;
  public bfwj b;
  public boolean b;
  
  public static bfwi a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bfwi localbfwi = new bfwi();
    localbfwi.jdField_a_of_type_Bfwj = bfwj.a(paramString4, paramString3);
    localbfwi.b = bfwj.a(paramString2, paramString1);
    localbfwi.jdField_a_of_type_Boolean = false;
    return localbfwi;
  }
  
  public static bfwi a(cmd0x934.Item paramItem)
  {
    bfwi localbfwi = new bfwi();
    localbfwi.jdField_a_of_type_Bfwj = bfwj.a(paramItem.off_info);
    localbfwi.b = bfwj.a(paramItem.on_info);
    localbfwi.jdField_a_of_type_Boolean = paramItem.hot.get();
    return localbfwi;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwi
 * JD-Core Version:    0.7.0.1
 */