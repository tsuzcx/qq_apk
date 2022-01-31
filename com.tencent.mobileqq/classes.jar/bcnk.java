import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.List;

public class bcnk
{
  public String a;
  public ArrayList<bcnh> a;
  
  public static bcnk a(cmd0x934.List paramList)
  {
    bcnk localbcnk = new bcnk();
    localbcnk.jdField_a_of_type_JavaLangString = paramList.name.get();
    localbcnk.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList.items.size());
    int i = 0;
    while (i < paramList.items.size())
    {
      localbcnk.jdField_a_of_type_JavaUtilArrayList.add(bcnh.a((cmd0x934.Item)paramList.items.get(i)));
      i += 1;
    }
    return localbcnk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnk
 * JD-Core Version:    0.7.0.1
 */