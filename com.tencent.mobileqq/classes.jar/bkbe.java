import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.vip.pb.vac_adv_get.DropList;

public class bkbe
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static bkbe a(vac_adv_get.DropList paramDropList)
  {
    if (paramDropList == null) {
      return null;
    }
    bkbe localbkbe = new bkbe();
    localbkbe.jdField_a_of_type_Int = paramDropList.action_type.get();
    localbkbe.b = paramDropList.optext.get();
    localbkbe.jdField_a_of_type_JavaLangString = paramDropList.iconurl.get();
    localbkbe.c = paramDropList.jumpurl.get();
    return localbkbe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkbe
 * JD-Core Version:    0.7.0.1
 */