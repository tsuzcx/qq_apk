import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.vip.pb.vac_adv_get.DropList;

public class bnvh
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static bnvh a(vac_adv_get.DropList paramDropList)
  {
    if (paramDropList == null) {
      return null;
    }
    bnvh localbnvh = new bnvh();
    localbnvh.jdField_a_of_type_Int = paramDropList.action_type.get();
    localbnvh.b = paramDropList.optext.get();
    localbnvh.jdField_a_of_type_JavaLangString = paramDropList.iconurl.get();
    localbnvh.c = paramDropList.jumpurl.get();
    return localbnvh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvh
 * JD-Core Version:    0.7.0.1
 */