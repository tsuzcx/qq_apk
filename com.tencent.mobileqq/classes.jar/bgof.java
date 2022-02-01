import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.List;

public class bgof
{
  public String a;
  public ArrayList<bgoc> a;
  
  public static bgof a(cmd0x934.List paramList)
  {
    bgof localbgof = new bgof();
    localbgof.jdField_a_of_type_JavaLangString = paramList.name.get();
    localbgof.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList.items.size());
    int i = 0;
    while (i < paramList.items.size())
    {
      localbgof.jdField_a_of_type_JavaUtilArrayList.add(bgoc.a((cmd0x934.Item)paramList.items.get(i)));
      i += 1;
    }
    return localbgof;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgof
 * JD-Core Version:    0.7.0.1
 */