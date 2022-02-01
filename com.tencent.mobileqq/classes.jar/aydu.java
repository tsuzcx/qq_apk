import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class aydu
  extends QIPCModule
{
  private static volatile aydu a;
  
  public aydu(String paramString)
  {
    super(paramString);
  }
  
  public static aydu a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aydu("PicSTWXQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicSTWXQIPCModule", 2, "onCall, action = " + paramString);
    }
    paramString = paramBundle.getString("param_pic_path", "");
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("PicSTWXQIPCModule", 2, "path is empty");
      }
    }
    int i;
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("PicSTWXQIPCModule", 2, "onCall, path = " + paramString);
      }
      i = paramBundle.getInt("param_from_type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("PicSTWXQIPCModule", 2, "onCall, fromType = " + i);
      }
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle instanceof QQAppInterface)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PicSTWXQIPCModule", 2, "cannot get QQAppInterface.");
    return null;
    paramBundle = (QQAppInterface)paramBundle;
    PicShareToWX.a().a(this, paramInt, paramBundle, paramString, i);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydu
 * JD-Core Version:    0.7.0.1
 */