import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

class bdcl
  extends bdcn
{
  bdcl(bdck parambdck) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, List<oidb_0xe61.BeancurdCubeInfoResult> paramList)
  {
    String str;
    if (QLog.isColorLevel())
    {
      str = MobileQQ.getShortUinStr(paramString2);
      if (paramList != null) {
        break label111;
      }
    }
    label111:
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("Tofu_TofuManager", 2, String.format("onPullTofuMsgData suc=%b selfUin=%s frdUin=%s size=%d", new Object[] { Boolean.valueOf(paramBoolean), paramString1, str, Integer.valueOf(i) }));
      if (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { Boolean.valueOf(paramBoolean), paramString2, paramList }).sendToTarget();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcl
 * JD-Core Version:    0.7.0.1
 */