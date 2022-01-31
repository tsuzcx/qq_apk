import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class bata
  implements BusinessObserver
{
  bata(basz parambasz) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|isSuccess=" + paramBoolean + ",time=" + (System.currentTimeMillis() - basx.b(this.a.b)));
    }
    int j = -1;
    paramInt = j;
    int i;
    if (paramBoolean) {
      i = j;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      paramInt = j;
      if (paramBundle != null)
      {
        i = j;
        GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
        i = j;
        localGetAppinfoResponse.mergeFrom(paramBundle);
        i = j;
        j = localGetAppinfoResponse.ret.get();
        i = j;
        if (QLog.isColorLevel())
        {
          i = j;
          QLog.i("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|ret=" + j);
        }
        paramInt = j;
        if (j == 0)
        {
          i = j;
          basx.a(this.a.b).d = zfy.a(localGetAppinfoResponse.iconsURL, 16);
          i = j;
          basx.a(this.a.b).e = zfy.a(localGetAppinfoResponse.iconsURL, 100);
          i = j;
          if (localGetAppinfoResponse.androidInfo != null)
          {
            i = j;
            paramBundle = localGetAppinfoResponse.androidInfo;
            i = j;
            if (paramBundle.packName.has())
            {
              i = j;
              basx.a(this.a.b).jdField_a_of_type_JavaLangString = paramBundle.packName.get();
            }
            i = j;
            if (paramBundle.messagetail.has())
            {
              i = j;
              basx.a(this.a.b).b = paramBundle.messagetail.get();
            }
            i = j;
            if (paramBundle.sourceUrl.has())
            {
              i = j;
              if (basx.a(this.a.b) != Long.parseLong("1103584836"))
              {
                i = j;
                basx.a(this.a.b).c = paramBundle.sourceUrl.get();
              }
            }
          }
          i = j;
          basx.a(this.a.b).jdField_a_of_type_Int = 1;
          i = j;
          basz.a(this.a);
          paramInt = j;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramInt = i;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.share.ForwardSdkShareProcessor", 2, paramBundle, new Object[0]);
          paramInt = i;
        }
      }
      basz.a(this.a).set(true);
      this.a.b();
    }
    if ((basx.a(this.a.b).jdField_a_of_type_Int != 1) && (basz.a(this.a) < 2) && (paramInt != 110507) && (paramInt != 110401))
    {
      basz.b(this.a);
      this.a.d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bata
 * JD-Core Version:    0.7.0.1
 */