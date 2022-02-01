import com.tencent.mobileqq.DrawerPushItem;
import java.util.Comparator;

class amtb
  implements Comparator<DrawerPushItem>
{
  amtb(amsx paramamsx) {}
  
  public int a(DrawerPushItem paramDrawerPushItem1, DrawerPushItem paramDrawerPushItem2)
  {
    if (paramDrawerPushItem2.priority == paramDrawerPushItem1.priority) {
      return paramDrawerPushItem1.sub_priority - paramDrawerPushItem2.sub_priority;
    }
    return paramDrawerPushItem1.priority - paramDrawerPushItem2.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtb
 * JD-Core Version:    0.7.0.1
 */