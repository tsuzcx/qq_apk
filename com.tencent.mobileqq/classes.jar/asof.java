import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.4.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class asof
  extends askq
{
  asof(asoc paramasoc) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelMallHelper", 2, "onPackageEnd resultCode = " + paramInt + ",ep = " + paramEmoticonPackage);
      }
    } while (this.a.a.g);
    ThreadManager.getUIHandler().post(new EmoticonPanelMallHelper.4.1(this, paramEmoticonPackage, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asof
 * JD-Core Version:    0.7.0.1
 */