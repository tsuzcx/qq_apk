import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.vip.pb.vac_adv_get.DropList;

public class bhyr
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static bhyr a(vac_adv_get.DropList paramDropList)
  {
    if (paramDropList == null) {
      return null;
    }
    bhyr localbhyr = new bhyr();
    localbhyr.jdField_a_of_type_Int = paramDropList.action_type.get();
    localbhyr.b = paramDropList.optext.get();
    localbhyr.jdField_a_of_type_JavaLangString = paramDropList.iconurl.get();
    localbhyr.c = paramDropList.jumpurl.get();
    return localbhyr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhyr
 * JD-Core Version:    0.7.0.1
 */