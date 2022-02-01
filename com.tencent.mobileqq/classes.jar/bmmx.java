import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.vip.pb.vac_adv_get.DropList;

public class bmmx
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static bmmx a(vac_adv_get.DropList paramDropList)
  {
    if (paramDropList == null) {
      return null;
    }
    bmmx localbmmx = new bmmx();
    localbmmx.jdField_a_of_type_Int = paramDropList.action_type.get();
    localbmmx.b = paramDropList.optext.get();
    localbmmx.jdField_a_of_type_JavaLangString = paramDropList.iconurl.get();
    localbmmx.c = paramDropList.jumpurl.get();
    return localbmmx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmx
 * JD-Core Version:    0.7.0.1
 */