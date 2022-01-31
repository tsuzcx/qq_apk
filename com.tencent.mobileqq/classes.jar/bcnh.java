import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;

public class bcnh
{
  public bcni a;
  public boolean a;
  public bcni b;
  public boolean b;
  
  public static bcnh a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bcnh localbcnh = new bcnh();
    localbcnh.jdField_a_of_type_Bcni = bcni.a(paramString4, paramString3);
    localbcnh.b = bcni.a(paramString2, paramString1);
    localbcnh.jdField_a_of_type_Boolean = false;
    return localbcnh;
  }
  
  public static bcnh a(cmd0x934.Item paramItem)
  {
    bcnh localbcnh = new bcnh();
    localbcnh.jdField_a_of_type_Bcni = bcni.a(paramItem.off_info);
    localbcnh.b = bcni.a(paramItem.on_info);
    localbcnh.jdField_a_of_type_Boolean = paramItem.hot.get();
    return localbcnh;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnh
 * JD-Core Version:    0.7.0.1
 */