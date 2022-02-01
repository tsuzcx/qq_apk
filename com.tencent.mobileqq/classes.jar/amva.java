import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class amva
  implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
{
  public List<String> getRedPointPaths(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      boolean bool = ((QQAppInterface)paramAppInterface).getLebaHelper().a();
      paramAppInterface = aqhj.c();
      if ((bool) && (paramAppInterface.a()))
      {
        paramAppInterface = new ArrayList();
        paramAppInterface.add("150000");
        paramAppInterface.add("150000.150100");
        return paramAppInterface;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amva
 * JD-Core Version:    0.7.0.1
 */