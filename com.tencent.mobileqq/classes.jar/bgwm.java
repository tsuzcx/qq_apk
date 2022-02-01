import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.List;

public class bgwm
{
  public String a;
  public ArrayList<bgwj> a;
  
  public static bgwm a(cmd0x934.List paramList)
  {
    bgwm localbgwm = new bgwm();
    localbgwm.jdField_a_of_type_JavaLangString = paramList.name.get();
    localbgwm.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList.items.size());
    int i = 0;
    while (i < paramList.items.size())
    {
      localbgwm.jdField_a_of_type_JavaUtilArrayList.add(bgwj.a((cmd0x934.Item)paramList.items.get(i)));
      i += 1;
    }
    return localbgwm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwm
 * JD-Core Version:    0.7.0.1
 */