import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.vip.pb.vac_adv_get.DropList;

public class bkfl
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static bkfl a(vac_adv_get.DropList paramDropList)
  {
    if (paramDropList == null) {
      return null;
    }
    bkfl localbkfl = new bkfl();
    localbkfl.jdField_a_of_type_Int = paramDropList.action_type.get();
    localbkfl.b = paramDropList.optext.get();
    localbkfl.jdField_a_of_type_JavaLangString = paramDropList.iconurl.get();
    localbkfl.c = paramDropList.jumpurl.get();
    return localbkfl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfl
 * JD-Core Version:    0.7.0.1
 */