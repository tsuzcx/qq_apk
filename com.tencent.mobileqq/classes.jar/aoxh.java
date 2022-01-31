import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public class aoxh
  implements Runnable
{
  public aoxh(QIMPtvTemplateManager paramQIMPtvTemplateManager) {}
  
  public void run()
  {
    int i = 1;
    boolean bool1 = PtvFilterSoLoad.b();
    boolean bool2 = NetworkUtil.d(BaseApplication.getContext());
    if (BaseApplicationImpl.sProcessId == 1) {
      i = 0;
    }
    if ((bool1) && (bool2) && (i != 0)) {
      this.a.a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoxh
 * JD-Core Version:    0.7.0.1
 */