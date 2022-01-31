import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x934.cmd0x934.Item;
import tencent.im.oidb.cmd0x934.cmd0x934.List;

public class baox
{
  public String a;
  public ArrayList<baou> a;
  
  public static baox a(cmd0x934.List paramList)
  {
    baox localbaox = new baox();
    localbaox.jdField_a_of_type_JavaLangString = paramList.name.get();
    localbaox.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList.items.size());
    int i = 0;
    while (i < paramList.items.size())
    {
      localbaox.jdField_a_of_type_JavaUtilArrayList.add(baou.a((cmd0x934.Item)paramList.items.get(i)));
      i += 1;
    }
    return localbaox;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baox
 * JD-Core Version:    0.7.0.1
 */