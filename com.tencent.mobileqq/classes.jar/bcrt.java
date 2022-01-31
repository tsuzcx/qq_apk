import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.List;

public class bcrt
{
  public String a;
  public ArrayList<bcrq> a;
  
  public static bcrt a(cmd0x934.List paramList)
  {
    bcrt localbcrt = new bcrt();
    localbcrt.jdField_a_of_type_JavaLangString = paramList.name.get();
    localbcrt.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList.items.size());
    int i = 0;
    while (i < paramList.items.size())
    {
      localbcrt.jdField_a_of_type_JavaUtilArrayList.add(bcrq.a((cmd0x934.Item)paramList.items.get(i)));
      i += 1;
    }
    return localbcrt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcrt
 * JD-Core Version:    0.7.0.1
 */