import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;

public class baog
{
  public baoh a;
  public boolean a;
  public baoh b;
  public boolean b;
  
  public static baog a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    baog localbaog = new baog();
    localbaog.jdField_a_of_type_Baoh = baoh.a(paramString4, paramString3);
    localbaog.b = baoh.a(paramString2, paramString1);
    localbaog.jdField_a_of_type_Boolean = false;
    return localbaog;
  }
  
  public static baog a(cmd0x934.Item paramItem)
  {
    baog localbaog = new baog();
    localbaog.jdField_a_of_type_Baoh = baoh.a(paramItem.off_info);
    localbaog.b = baoh.a(paramItem.on_info);
    localbaog.jdField_a_of_type_Boolean = paramItem.hot.get();
    return localbaog;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baog
 * JD-Core Version:    0.7.0.1
 */