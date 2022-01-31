import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.vip.pb.vac_adv_get.DropList;

public class bgpu
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static bgpu a(vac_adv_get.DropList paramDropList)
  {
    if (paramDropList == null) {
      return null;
    }
    bgpu localbgpu = new bgpu();
    localbgpu.jdField_a_of_type_Int = paramDropList.action_type.get();
    localbgpu.b = paramDropList.optext.get();
    localbgpu.jdField_a_of_type_JavaLangString = paramDropList.iconurl.get();
    localbgpu.c = paramDropList.jumpurl.get();
    return localbgpu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgpu
 * JD-Core Version:    0.7.0.1
 */