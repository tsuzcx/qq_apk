import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel.17.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class anyj
  extends anwf
{
  public anyj(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "onPackageEnd resultCode = " + paramInt + ",ep = " + paramEmoticonPackage);
      }
    } while (this.a.n);
    ThreadManager.getUIHandler().post(new EmoticonMainPanel.17.1(this, paramEmoticonPackage, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyj
 * JD-Core Version:    0.7.0.1
 */