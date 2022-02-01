import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class anxy
  implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
{
  private List<String> a = new ArrayList();
  
  public void a()
  {
    if (this.a.isEmpty()) {
      this.a.add("100066");
    }
  }
  
  public void b()
  {
    if (!this.a.isEmpty()) {
      this.a.remove("100066");
    }
  }
  
  public List<String> getRedPointPaths(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (!this.a.isEmpty())) {
      return this.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxy
 * JD-Core Version:    0.7.0.1
 */