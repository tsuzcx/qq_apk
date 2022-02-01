import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.vip.pb.vac_adv_get.DropList;

public class blam
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static blam a(vac_adv_get.DropList paramDropList)
  {
    if (paramDropList == null) {
      return null;
    }
    blam localblam = new blam();
    localblam.jdField_a_of_type_Int = paramDropList.action_type.get();
    localblam.b = paramDropList.optext.get();
    localblam.jdField_a_of_type_JavaLangString = paramDropList.iconurl.get();
    localblam.c = paramDropList.jumpurl.get();
    return localblam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blam
 * JD-Core Version:    0.7.0.1
 */