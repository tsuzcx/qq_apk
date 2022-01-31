import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class arni
  implements BusinessObserver
{
  arni(arne paramarne, Intent paramIntent) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_Arne.a.dismiss();
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        Object localObject = paramBundle.getByteArray("data");
        if (localObject != null)
        {
          paramBundle = new GetAppInfoProto.GetAppinfoResponse();
          paramBundle.mergeFrom((byte[])localObject);
          if ((paramBundle.has()) && (paramBundle.ret.get() == 0) && (paramBundle.androidInfo != null))
          {
            localAndroidInfo = paramBundle.androidInfo;
            localObject = xmq.a(paramBundle.iconsURL, 16);
            Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
            if (localAndroidInfo.sourceUrl != null) {
              continue;
            }
            paramBundle = "";
            localIntent.putExtra("struct_share_key_source_url", paramBundle);
            localIntent = this.jdField_a_of_type_AndroidContentIntent;
            paramBundle = (Bundle)localObject;
            if (localObject == null) {
              paramBundle = "";
            }
            localIntent.putExtra("struct_share_key_source_icon", paramBundle);
            localObject = this.jdField_a_of_type_AndroidContentIntent;
            if (localAndroidInfo.messagetail != null) {
              continue;
            }
            paramBundle = "";
            ((Intent)localObject).putExtra("struct_share_key_source_name", paramBundle);
            localObject = this.jdField_a_of_type_AndroidContentIntent;
            if (localAndroidInfo.packName != null) {
              continue;
            }
            paramBundle = "";
            ((Intent)localObject).putExtra("struct_share_key_source_a_action_data", paramBundle);
          }
        }
      }
      catch (Exception paramBundle)
      {
        GetAppInfoProto.AndroidInfo localAndroidInfo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QQApi", 2, paramBundle.getMessage());
        continue;
        this.jdField_a_of_type_AndroidContentIntent.putExtra("stuctmsg_bytes", paramBundle.getBytes());
        this.jdField_a_of_type_Arne.startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, (byte)1);
      }
      paramBundle = axva.a(this.jdField_a_of_type_AndroidContentIntent.getExtras());
      if (paramBundle != null) {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQApi", 2, "build struct msg fail");
      }
      return;
      paramBundle = localAndroidInfo.sourceUrl.get();
      continue;
      paramBundle = localAndroidInfo.messagetail.get();
      continue;
      paramBundle = localAndroidInfo.packName.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arni
 * JD-Core Version:    0.7.0.1
 */