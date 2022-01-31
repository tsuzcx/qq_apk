import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class anli
  implements BusinessObserver
{
  anli(anlh paramanlh, Activity paramActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131690285);
    localObject1 = str;
    if (paramBoolean) {
      localObject2 = str;
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        localObject1 = str;
        if (paramBundle != null)
        {
          localObject2 = str;
          GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
          localObject2 = str;
          localGetAppinfoResponse.mergeFrom(paramBundle);
          localObject1 = str;
          localObject2 = str;
          if (localGetAppinfoResponse.has())
          {
            localObject1 = str;
            localObject2 = str;
            if (localGetAppinfoResponse.ret.get() == 0)
            {
              localObject1 = str;
              localObject2 = str;
              if (localGetAppinfoResponse.androidInfo != null)
              {
                localObject2 = str;
                paramBundle = localGetAppinfoResponse.androidInfo;
                localObject2 = str;
                if (paramBundle.messagetail != null) {
                  continue;
                }
                localObject1 = "";
                localObject2 = localObject1;
                ((String)localObject1).trim();
              }
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArkWebModule", 2, paramBundle.getMessage());
        localObject1 = localObject2;
        continue;
      }
      paramBundle = (Bundle)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramBundle = this.jdField_a_of_type_AndroidAppActivity.getString(2131690285);
      }
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131690286);
      this.jdField_a_of_type_Anlh.a(String.format((String)localObject1, new Object[] { paramBundle }));
      anlh.a(this.jdField_a_of_type_Anlh).show();
      return;
      localObject2 = str;
      localObject1 = paramBundle.messagetail.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anli
 * JD-Core Version:    0.7.0.1
 */