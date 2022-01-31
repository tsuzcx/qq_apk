import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;

public class aznc
{
  public aznd a;
  public boolean a;
  public aznd b;
  public boolean b;
  
  public static aznc a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    aznc localaznc = new aznc();
    localaznc.jdField_a_of_type_Aznd = aznd.a(paramString4, paramString3);
    localaznc.b = aznd.a(paramString2, paramString1);
    localaznc.jdField_a_of_type_Boolean = false;
    return localaznc;
  }
  
  public static aznc a(cmd0x934.Item paramItem)
  {
    aznc localaznc = new aznc();
    localaznc.jdField_a_of_type_Aznd = aznd.a(paramItem.off_info);
    localaznc.b = aznd.a(paramItem.on_info);
    localaznc.jdField_a_of_type_Boolean = paramItem.hot.get();
    return localaznc;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aznc
 * JD-Core Version:    0.7.0.1
 */