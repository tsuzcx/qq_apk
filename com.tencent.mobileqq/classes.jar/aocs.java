import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;

public class aocs
  implements anuh
{
  private List<String> a = new ArrayList();
  
  public List<String> a(AppInterface paramAppInterface)
  {
    if (this.a.isEmpty()) {
      this.a.add("100077");
    }
    if (((paramAppInterface instanceof QQAppInterface)) && (QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameEnable", 1) == 1)) {
      return this.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocs
 * JD-Core Version:    0.7.0.1
 */