import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.List;

public class bffy
{
  public String a;
  public ArrayList<bffv> a;
  
  public static bffy a(cmd0x934.List paramList)
  {
    bffy localbffy = new bffy();
    localbffy.jdField_a_of_type_JavaLangString = paramList.name.get();
    localbffy.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList.items.size());
    int i = 0;
    while (i < paramList.items.size())
    {
      localbffy.jdField_a_of_type_JavaUtilArrayList.add(bffv.a((cmd0x934.Item)paramList.items.get(i)));
      i += 1;
    }
    return localbffy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffy
 * JD-Core Version:    0.7.0.1
 */