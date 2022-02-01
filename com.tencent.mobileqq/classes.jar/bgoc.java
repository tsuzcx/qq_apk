import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;

public class bgoc
{
  public bgod a;
  public boolean a;
  public bgod b;
  public boolean b;
  
  public static bgoc a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bgoc localbgoc = new bgoc();
    localbgoc.jdField_a_of_type_Bgod = bgod.a(paramString4, paramString3);
    localbgoc.b = bgod.a(paramString2, paramString1);
    localbgoc.jdField_a_of_type_Boolean = false;
    return localbgoc;
  }
  
  public static bgoc a(cmd0x934.Item paramItem)
  {
    bgoc localbgoc = new bgoc();
    localbgoc.jdField_a_of_type_Bgod = bgod.a(paramItem.off_info);
    localbgoc.b = bgod.a(paramItem.on_info);
    localbgoc.jdField_a_of_type_Boolean = paramItem.hot.get();
    return localbgoc;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgoc
 * JD-Core Version:    0.7.0.1
 */