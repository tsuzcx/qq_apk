import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.ResultInfo;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessServlet.RspOpenStart;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

public class aqqh
  implements BusinessObserver
{
  private int jdField_a_of_type_Int;
  private WeakReference<QIPCModule> jdField_a_of_type_MqqUtilWeakReference;
  
  public aqqh(QIPCModule paramQIPCModule, int paramInt)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQIPCModule);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(Bundle paramBundle, TogetherBusinessServlet.RspOpenStart paramRspOpenStart)
  {
    int i;
    long l;
    String str;
    QQAppInterface localQQAppInterface;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherObserver", 2, "handleStartPackage TogetherControlManager");
      }
      i = paramBundle.getInt("session_type", -1);
      l = paramBundle.getLong("uin", -1L);
      int j = paramBundle.getInt("business_type", 0);
      str = paramBundle.getString("appid", "");
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (j == 2) {
        if (i != 2) {
          break label154;
        }
      }
    }
    label154:
    for (paramBundle = "c2c_AIO";; paramBundle = "Grp_AIO")
    {
      awqx.b(localQQAppInterface, "dc00899", paramBundle, "", "video_tab", "clk_share_suc", 0, 0, l + "", str, "", "");
      axng.a(localQQAppInterface, paramRspOpenStart.jumpType, paramRspOpenStart.jumpUrl, null, new Bundle(), i);
      return;
    }
  }
  
  private boolean a(TogetherBusinessServlet.RspOpenStart paramRspOpenStart)
  {
    if ((paramRspOpenStart.resultInfo != null) && (paramRspOpenStart.resultInfo.showErrorMsg) && (!TextUtils.isEmpty(paramRspOpenStart.resultInfo.errorMsg))) {}
    while (((paramRspOpenStart.jumpType != 1) && (paramRspOpenStart.jumpType != 2)) || (TextUtils.isEmpty(paramRspOpenStart.jumpUrl))) {
      return false;
    }
    return true;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherObserver", 2, "type:" + paramInt + " isSuccess:" + paramBoolean);
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherObserver", 2, " mRef is empty");
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QIPCModule)this.jdField_a_of_type_MqqUtilWeakReference.get();
          if ((12 == paramInt) && (paramBoolean))
          {
            ((QIPCModule)localObject).callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(0, paramBundle));
            return;
          }
        } while ((13 != paramInt) || (!paramBoolean));
        ((QIPCModule)localObject).callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(0, paramBundle));
        localObject = (TogetherBusinessServlet.RspOpenStart)paramBundle.getSerializable("QQAIOMediaSvc.open_start");
        paramBundle = paramBundle.getBundle("bundle");
        if ((paramBundle != null) && (localObject != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TogetherObserver", 2, "bundleExtra is null or rspOpenStart is null");
      return;
    } while (!a((TogetherBusinessServlet.RspOpenStart)localObject));
    if (QLog.isColorLevel()) {
      QLog.d("TogetherObserver", 2, "handleStartPackage jumpToTogetherBusiness");
    }
    a(paramBundle, (TogetherBusinessServlet.RspOpenStart)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqqh
 * JD-Core Version:    0.7.0.1
 */