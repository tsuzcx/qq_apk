import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;

public class bcrq
{
  public bcrr a;
  public boolean a;
  public bcrr b;
  public boolean b;
  
  public static bcrq a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bcrq localbcrq = new bcrq();
    localbcrq.jdField_a_of_type_Bcrr = bcrr.a(paramString4, paramString3);
    localbcrq.b = bcrr.a(paramString2, paramString1);
    localbcrq.jdField_a_of_type_Boolean = false;
    return localbcrq;
  }
  
  public static bcrq a(cmd0x934.Item paramItem)
  {
    bcrq localbcrq = new bcrq();
    localbcrq.jdField_a_of_type_Bcrr = bcrr.a(paramItem.off_info);
    localbcrq.b = bcrr.a(paramItem.on_info);
    localbcrq.jdField_a_of_type_Boolean = paramItem.hot.get();
    return localbcrq;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcrq
 * JD-Core Version:    0.7.0.1
 */