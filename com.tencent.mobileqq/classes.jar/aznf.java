import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.List;

public class aznf
{
  public String a;
  public ArrayList<aznc> a;
  
  public static aznf a(cmd0x934.List paramList)
  {
    aznf localaznf = new aznf();
    localaznf.jdField_a_of_type_JavaLangString = paramList.name.get();
    localaznf.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList.items.size());
    int i = 0;
    while (i < paramList.items.size())
    {
      localaznf.jdField_a_of_type_JavaUtilArrayList.add(aznc.a((cmd0x934.Item)paramList.items.get(i)));
      i += 1;
    }
    return localaznf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aznf
 * JD-Core Version:    0.7.0.1
 */