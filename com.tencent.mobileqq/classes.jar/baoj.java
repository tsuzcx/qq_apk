import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.List;

public class baoj
{
  public String a;
  public ArrayList<baog> a;
  
  public static baoj a(cmd0x934.List paramList)
  {
    baoj localbaoj = new baoj();
    localbaoj.jdField_a_of_type_JavaLangString = paramList.name.get();
    localbaoj.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList.items.size());
    int i = 0;
    while (i < paramList.items.size())
    {
      localbaoj.jdField_a_of_type_JavaUtilArrayList.add(baog.a((cmd0x934.Item)paramList.items.get(i)));
      i += 1;
    }
    return localbaoj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baoj
 * JD-Core Version:    0.7.0.1
 */