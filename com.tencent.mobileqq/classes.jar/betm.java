import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class betm
  implements BusinessObserver
{
  betm(betl parambetl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetAppInfoStep|isSuccess=" + paramBoolean + ",time=" + (System.currentTimeMillis() - betj.b(this.a.b)));
    int i = -1;
    paramInt = i;
    if (paramBoolean) {
      paramInt = i;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      paramInt = i;
      if (paramBundle != null)
      {
        paramInt = i;
        GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
        paramInt = i;
        localGetAppinfoResponse.mergeFrom(paramBundle);
        paramInt = i;
        i = localGetAppinfoResponse.ret.get();
        paramInt = i;
        if (QLog.isColorLevel())
        {
          paramInt = i;
          QLog.i("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|ret=" + i);
        }
        paramInt = i;
        if (i == 0)
        {
          paramInt = i;
          this.a.b.a.d = abgu.a(localGetAppinfoResponse.iconsURL, 16);
          paramInt = i;
          this.a.b.a.e = abgu.a(localGetAppinfoResponse.iconsURL, 100);
          paramInt = i;
          if (localGetAppinfoResponse.androidInfo != null)
          {
            paramInt = i;
            paramBundle = localGetAppinfoResponse.androidInfo;
            paramInt = i;
            if (paramBundle.packName.has())
            {
              paramInt = i;
              this.a.b.a.jdField_a_of_type_JavaLangString = paramBundle.packName.get();
            }
            paramInt = i;
            if (paramBundle.messagetail.has())
            {
              paramInt = i;
              this.a.b.a.b = paramBundle.messagetail.get();
            }
            paramInt = i;
            if (paramBundle.sourceUrl.has())
            {
              paramInt = i;
              if (betj.a(this.a.b) != Long.parseLong("1103584836"))
              {
                paramInt = i;
                this.a.b.a.c = paramBundle.sourceUrl.get();
              }
            }
          }
          paramInt = i;
          this.a.b.a.jdField_a_of_type_Int = 1;
          paramInt = i;
          this.a.g();
          paramInt = i;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("Q.share.ForwardSdkShareProcessor", 1, paramBundle, new Object[0]);
      }
      betl.a(this.a).set(true);
      this.a.b();
    }
    if ((this.a.b.a.jdField_a_of_type_Int != 1) && (betl.a(this.a) < 2) && (paramInt != 110507) && (paramInt != 110401))
    {
      betl.b(this.a);
      this.a.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betm
 * JD-Core Version:    0.7.0.1
 */