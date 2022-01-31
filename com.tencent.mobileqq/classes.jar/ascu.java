import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ascu
  implements BusinessObserver
{
  ascu(ascq paramascq) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.b("KEY_GET_APP_INFO", paramBoolean);
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "AppinfoObserver onReceive isSuccess = ", Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    synchronized (ascq.jdField_a_of_type_JavaLangObject)
    {
      this.a.l = false;
      Object localObject1 = localObject2;
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          localObject1 = paramBundle.getByteArray("data");
          if (localObject1 != null) {
            paramBundle = new GetAppInfoProto.GetAppinfoResponse();
          }
        }
        catch (Exception localException1)
        {
          paramBundle = null;
        }
        try
        {
          paramBundle.mergeFrom((byte[])localObject1);
          this.a.jdField_a_of_type_Aryj = aryj.a(paramBundle);
          if ((this.a instanceof asdb)) {
            ((asdm)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a().a(this.a.b, this.a.jdField_a_of_type_Aryj);
          }
          QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "get appinfo time=", Long.valueOf(System.currentTimeMillis() - this.a.c), ", ret=", Integer.valueOf(paramBundle.ret.get()) });
          this.a.e();
          localObject1 = paramBundle;
          this.a.x();
          if ((localObject1 == null) || (((GetAppInfoProto.GetAppinfoResponse)localObject1).ret.get() == 0) || (!(this.a instanceof asdb))) {
            break;
          }
          if (aopb.e()) {
            this.a.a(((GetAppInfoProto.GetAppinfoResponse)localObject1).msg.get(), true);
          }
          ascq.jdField_a_of_type_JavaLangObject.notify();
          return;
        }
        catch (Exception localException2)
        {
          Bundle localBundle;
          break label288;
        }
        QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive data=null");
        localObject1 = localObject2;
        continue;
        label288:
        QLog.e("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "AppinfoObserver.onReceive ", localException1.getMessage() });
        localBundle = paramBundle;
      }
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive success, go share");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascu
 * JD-Core Version:    0.7.0.1
 */