import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;

public class bffv
{
  public bffw a;
  public boolean a;
  public bffw b;
  public boolean b;
  
  public static bffv a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bffv localbffv = new bffv();
    localbffv.jdField_a_of_type_Bffw = bffw.a(paramString4, paramString3);
    localbffv.b = bffw.a(paramString2, paramString1);
    localbffv.jdField_a_of_type_Boolean = false;
    return localbffv;
  }
  
  public static bffv a(cmd0x934.Item paramItem)
  {
    bffv localbffv = new bffv();
    localbffv.jdField_a_of_type_Bffw = bffw.a(paramItem.off_info);
    localbffv.b = bffw.a(paramItem.on_info);
    localbffv.jdField_a_of_type_Boolean = paramItem.hot.get();
    return localbffv;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffv
 * JD-Core Version:    0.7.0.1
 */