import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.List;

public class bfwl
{
  public String a;
  public ArrayList<bfwi> a;
  
  public static bfwl a(cmd0x934.List paramList)
  {
    bfwl localbfwl = new bfwl();
    localbfwl.jdField_a_of_type_JavaLangString = paramList.name.get();
    localbfwl.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList.items.size());
    int i = 0;
    while (i < paramList.items.size())
    {
      localbfwl.jdField_a_of_type_JavaUtilArrayList.add(bfwi.a((cmd0x934.Item)paramList.items.get(i)));
      i += 1;
    }
    return localbfwl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwl
 * JD-Core Version:    0.7.0.1
 */