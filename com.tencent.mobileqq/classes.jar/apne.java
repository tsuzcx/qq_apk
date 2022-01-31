import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class apne
  extends BroadcastReceiver
{
  apne(apnd paramapnd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.jdField_a_of_type_Apkp.a();
    if (paramIntent == null) {}
    Object localObject;
    label420:
    label452:
    label505:
    do
    {
      do
      {
        boolean bool;
        int i;
        do
        {
          long l1;
          do
          {
            do
            {
              for (;;)
              {
                return;
                localObject = paramIntent.getAction();
                if (localObject != null)
                {
                  if (!((String)localObject).equals("com.dataline.mpfile.download_progress")) {
                    break;
                  }
                  if (paramIntent.getLongExtra("token_task_id", 0L) == paramContext.uniseq)
                  {
                    l1 = paramIntent.getLongExtra("token_current_size", 0L);
                    l2 = paramIntent.getLongExtra("token_total_size", 0L);
                    paramContext.status = 2;
                    if (l2 != 0L) {}
                    for (paramContext.fProgress = ((float)l1 / (float)l2); this.a.jdField_a_of_type_Apnb != null; paramContext.fProgress = 1.0F)
                    {
                      this.a.jdField_a_of_type_Apnb.a(paramContext.fProgress);
                      return;
                    }
                  }
                }
              }
              if (!((String)localObject).equals("com.dataline.mpfile.download_completed")) {
                break;
              }
              l1 = paramIntent.getLongExtra("token_task_id", 0L);
            } while (l1 != paramContext.uniseq);
            apnd.a(this.a, NetConnInfoCenter.getServerTimeMillis());
            long l2 = paramIntent.getLongExtra("token_current_size", 0L);
            bool = paramIntent.getBooleanExtra("token_is_success", false);
            j = paramIntent.getIntExtra("token_http_code", 0);
            QLog.d("MPcFileModel<FileAssistant>", 2, "BROADCAST_MPFILE_DOWNLOAD_COMPLETED , currentSize:" + l2 + ",isSucceed:" + bool + ",http_code:" + j);
            paramIntent = new ReportItem();
            paramIntent.uSessionID = l1;
            paramIntent.uChannelType = 6;
            paramIntent.bSend = false;
            paramIntent.uNotifyTime = apnd.a(this.a);
            paramIntent.uFileSize = l2;
            paramIntent.bFileExist = false;
            paramIntent.uStartPos = 0L;
            paramIntent.uTaskStart = apnd.a(this.a);
            paramIntent.uTaskEnd = apnd.b(this.a);
            paramIntent.uDuration = (apnd.b(this.a) - apnd.a(this.a));
            paramIntent.bUserRetry = false;
            paramIntent.sSuffix = "";
            if (bool)
            {
              i = 2;
              paramIntent.emResult = i;
              paramIntent.nFailCode = 0;
              paramIntent.nUserCode = j;
              localObject = ((ajuo)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a();
              if (localObject == null) {
                break label631;
              }
              paramIntent.dwServerIP = fb.a(((bgor)localObject).jdField_a_of_type_JavaLangString);
              paramIntent.wServerPort = ((short)((bgor)localObject).jdField_a_of_type_Int);
              paramIntent.dwClientIP = fb.a(fb.a());
              localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramContext.peerDin != 0L) {
                break label644;
              }
              i = gl.b;
              gl.a((QQAppInterface)localObject, paramIntent, i);
              if (bool) {
                break label737;
              }
              paramContext.status = 3;
              if ((j != 2) && (j != 3) && (j != 4) && (j != 5) && (j != 8)) {
                break label651;
              }
              aptv.a(2131694347);
              if (this.a.jdField_a_of_type_Apnb != null) {
                this.a.jdField_a_of_type_Apnb.g();
              }
            }
            for (;;)
            {
              ((ajuo)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a(paramContext.strDataLineMPFileID);
              if (apnd.b(this.a)) {
                break label841;
              }
              paramContext.mContext = "needMPFileC2C";
              QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + apnd.b(this.a) + ",create mEntity.mContext");
              return;
              if (apnd.a(this.a))
              {
                i = 32;
                break;
              }
              i = 41;
              break;
              paramIntent.dwServerIP = 0;
              paramIntent.wServerPort = 0;
              break label420;
              i = gl.d;
              break label452;
              if (j == 1)
              {
                aptv.a(2131694345);
                break label505;
              }
              if (j == 1004)
              {
                aptv.a(2131694346);
                break label505;
              }
              if (j == 11)
              {
                QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file download!");
                break label505;
              }
              if (j == 12)
              {
                QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file predownload!");
                break label505;
              }
              apnd.a(this.a, j + 2100);
              break label505;
              paramContext.status = 1;
              paramIntent = ((ajuo)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().b();
              if (paramIntent == null) {
                if (QLog.isColorLevel()) {
                  QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
                }
              }
              for (;;)
              {
                if (this.a.jdField_a_of_type_Apnb == null) {
                  break label839;
                }
                this.a.jdField_a_of_type_Apnb.f();
                break;
                paramContext.setFilePath(String.format("%s/%s", new Object[] { paramIntent, paramContext.fileName }));
                paramContext.setCloudType(3);
              }
            }
            QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + apnd.b(this.a) + "mEntity.mContext = null");
            paramContext.mContext = null;
            return;
            if (!bgop.d.equalsIgnoreCase((String)localObject)) {
              break;
            }
            paramContext = paramIntent.getExtras();
            l1 = paramIntent.getLongExtra(bgop.f, 0L);
            i = paramContext.getInt(bgop.e);
            j = paramContext.getInt("result");
            if ((i == 0) && (j == 0)) {
              apnd.a(this.a, true);
            }
            QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "mainReceiver MPFILE_ACTION_HOST_INFO_UPDATE,ret:" + i);
          } while (apnd.c(this.a) != l1);
          if (i != 0) {
            break;
          }
          i = paramContext.getInt("result");
          paramIntent = paramContext.getByteArray("bytes_json");
          int j = paramContext.getInt("power");
          apnd.b(this.a, j);
          bool = paramContext.getBoolean("inputPwdError", false);
          switch (i)
          {
          default: 
            QLog.d("MPcFileModel<FileAssistant>", 1, "andorid 6.3.0 accept valid C2C response:" + i);
            return;
          case 0: 
            this.a.p();
            return;
          case 1: 
          case 2: 
          case 3: 
          case 4: 
            apnd.a(this.a, i + 2000);
          }
        } while (this.a.jdField_a_of_type_Apkm == null);
        this.a.jdField_a_of_type_Apkm.a(false);
        return;
        this.a.a(paramIntent, bool);
        return;
        this.a.a(paramIntent);
        return;
        this.a.q();
        return;
        this.a.r();
        return;
        if (i == 1013)
        {
          aptv.a(2131694332);
          return;
        }
        if (i == 1014)
        {
          aptv.a(2131694374);
          return;
        }
        apnd.a(this.a, i);
      } while (this.a.jdField_a_of_type_Apkm == null);
      this.a.jdField_a_of_type_Apkm.a(false);
      return;
    } while (!bgop.g.equalsIgnoreCase((String)localObject));
    label631:
    apnd.a(this.a, false);
    label644:
    label651:
    label737:
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "channelReceiver MPFILE_ACTION_CHANNEL_DISCONNECT!");
    label839:
    label841:
    aptv.a(2131694346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apne
 * JD-Core Version:    0.7.0.1
 */