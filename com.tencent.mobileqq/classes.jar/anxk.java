import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class anxk
  implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
{
  public List<String> getRedPointPaths(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (((QQAppInterface)paramAppInterface).getLebaHelper().a()))
    {
      paramAppInterface = new ArrayList();
      paramAppInterface.add("100000");
      return paramAppInterface;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxk
 * JD-Core Version:    0.7.0.1
 */