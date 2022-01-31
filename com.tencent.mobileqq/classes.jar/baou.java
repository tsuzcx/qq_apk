import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;

public class baou
{
  public baov a;
  public boolean a;
  public baov b;
  public boolean b;
  
  public static baou a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    baou localbaou = new baou();
    localbaou.jdField_a_of_type_Baov = baov.a(paramString4, paramString3);
    localbaou.b = baov.a(paramString2, paramString1);
    localbaou.jdField_a_of_type_Boolean = false;
    return localbaou;
  }
  
  public static baou a(cmd0x934.Item paramItem)
  {
    baou localbaou = new baou();
    localbaou.jdField_a_of_type_Baov = baov.a(paramItem.off_info);
    localbaou.b = baov.a(paramItem.on_info);
    localbaou.jdField_a_of_type_Boolean = paramItem.hot.get();
    return localbaou;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baou
 * JD-Core Version:    0.7.0.1
 */