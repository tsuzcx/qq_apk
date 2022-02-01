import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.vip.pb.vac_adv_get.DropList;

public class bmtz
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static bmtz a(vac_adv_get.DropList paramDropList)
  {
    if (paramDropList == null) {
      return null;
    }
    bmtz localbmtz = new bmtz();
    localbmtz.jdField_a_of_type_Int = paramDropList.action_type.get();
    localbmtz.b = paramDropList.optext.get();
    localbmtz.jdField_a_of_type_JavaLangString = paramDropList.iconurl.get();
    localbmtz.c = paramDropList.jumpurl.get();
    return localbmtz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtz
 * JD-Core Version:    0.7.0.1
 */