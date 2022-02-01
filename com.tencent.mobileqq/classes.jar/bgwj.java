import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;

public class bgwj
{
  public bgwk a;
  public boolean a;
  public bgwk b;
  public boolean b;
  
  public static bgwj a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bgwj localbgwj = new bgwj();
    localbgwj.jdField_a_of_type_Bgwk = bgwk.a(paramString4, paramString3);
    localbgwj.b = bgwk.a(paramString2, paramString1);
    localbgwj.jdField_a_of_type_Boolean = false;
    return localbgwj;
  }
  
  public static bgwj a(cmd0x934.Item paramItem)
  {
    bgwj localbgwj = new bgwj();
    localbgwj.jdField_a_of_type_Bgwk = bgwk.a(paramItem.off_info);
    localbgwj.b = bgwk.a(paramItem.on_info);
    localbgwj.jdField_a_of_type_Boolean = paramItem.hot.get();
    return localbgwj;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwj
 * JD-Core Version:    0.7.0.1
 */