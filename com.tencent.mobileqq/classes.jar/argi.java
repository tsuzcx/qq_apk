import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class argi
  extends BroadcastReceiver
{
  argi(argh paramargh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.jdField_a_of_type_Ardq.a();
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
                    for (paramContext.fProgress = ((float)l1 / (float)l2); this.a.jdField_a_of_type_Argf != null; paramContext.fProgress = 1.0F)
                    {
                      this.a.jdField_a_of_type_Argf.a(paramContext.fProgress);
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
            argh.a(this.a, NetConnInfoCenter.getServerTimeMillis());
            long l2 = paramIntent.getLongExtra("token_current_size", 0L);
            bool = paramIntent.getBooleanExtra("token_is_success", false);
            j = paramIntent.getIntExtra("token_http_code", 0);
            QLog.d("MPcFileModel<FileAssistant>", 2, "BROADCAST_MPFILE_DOWNLOAD_COMPLETED , currentSize:" + l2 + ",isSucceed:" + bool + ",http_code:" + j);
            paramIntent = new ReportItem();
            paramIntent.uSessionID = l1;
            paramIntent.uChannelType = 6;
            paramIntent.bSend = false;
            paramIntent.uNotifyTime = argh.a(this.a);
            paramIntent.uFileSize = l2;
            paramIntent.bFileExist = false;
            paramIntent.uStartPos = 0L;
            paramIntent.uTaskStart = argh.a(this.a);
            paramIntent.uTaskEnd = argh.b(this.a);
            paramIntent.uDuration = (argh.b(this.a) - argh.a(this.a));
            paramIntent.bUserRetry = false;
            paramIntent.sSuffix = "";
            if (bool)
            {
              i = 2;
              paramIntent.emResult = i;
              paramIntent.nFailCode = 0;
              paramIntent.nUserCode = j;
              localObject = ((allz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a();
              if (localObject == null) {
                break label631;
              }
              paramIntent.dwServerIP = dk.a(((biqh)localObject).jdField_a_of_type_JavaLangString);
              paramIntent.wServerPort = ((short)((biqh)localObject).jdField_a_of_type_Int);
              paramIntent.dwClientIP = dk.a(dk.a());
              localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramContext.peerDin != 0L) {
                break label644;
              }
              i = eu.b;
              eu.a((QQAppInterface)localObject, paramIntent, i);
              if (bool) {
                break label737;
              }
              paramContext.status = 3;
              if ((j != 2) && (j != 3) && (j != 4) && (j != 5) && (j != 8)) {
                break label651;
              }
              armz.a(2131694505);
              if (this.a.jdField_a_of_type_Argf != null) {
                this.a.jdField_a_of_type_Argf.g();
              }
            }
            for (;;)
            {
              ((allz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a(paramContext.strDataLineMPFileID);
              if (argh.b(this.a)) {
                break label841;
              }
              paramContext.mContext = "needMPFileC2C";
              QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + argh.b(this.a) + ",create mEntity.mContext");
              return;
              if (argh.a(this.a))
              {
                i = 32;
                break;
              }
              i = 41;
              break;
              paramIntent.dwServerIP = 0;
              paramIntent.wServerPort = 0;
              break label420;
              i = eu.d;
              break label452;
              if (j == 1)
              {
                armz.a(2131694503);
                break label505;
              }
              if (j == 1004)
              {
                armz.a(2131694504);
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
              argh.a(this.a, j + 2100);
              break label505;
              paramContext.status = 1;
              paramIntent = ((allz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().b();
              if (paramIntent == null) {
                if (QLog.isColorLevel()) {
                  QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
                }
              }
              for (;;)
              {
                if (this.a.jdField_a_of_type_Argf == null) {
                  break label839;
                }
                this.a.jdField_a_of_type_Argf.f();
                break;
                paramContext.setFilePath(String.format("%s/%s", new Object[] { paramIntent, paramContext.fileName }));
                paramContext.setCloudType(3);
              }
            }
            QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + argh.b(this.a) + "mEntity.mContext = null");
            paramContext.mContext = null;
            return;
            if (!biqf.d.equalsIgnoreCase((String)localObject)) {
              break;
            }
            paramContext = paramIntent.getExtras();
            l1 = paramIntent.getLongExtra(biqf.f, 0L);
            i = paramContext.getInt(biqf.e);
            j = paramContext.getInt("result");
            if ((i == 0) && (j == 0)) {
              argh.a(this.a, true);
            }
            QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "mainReceiver MPFILE_ACTION_HOST_INFO_UPDATE,ret:" + i);
          } while (argh.c(this.a) != l1);
          if (i != 0) {
            break;
          }
          i = paramContext.getInt("result");
          paramIntent = paramContext.getByteArray("bytes_json");
          int j = paramContext.getInt("power");
          argh.b(this.a, j);
          bool = paramContext.getBoolean("inputPwdError", false);
          switch (i)
          {
          default: 
            QLog.d("MPcFileModel<FileAssistant>", 1, "andorid 6.3.0 accept valid C2C response:" + i);
            return;
          case 0: 
            this.a.r();
            return;
          case 1: 
          case 2: 
          case 3: 
          case 4: 
            argh.a(this.a, i + 2000);
          }
        } while (this.a.jdField_a_of_type_Ardn == null);
        this.a.jdField_a_of_type_Ardn.a(false);
        return;
        this.a.a(paramIntent, bool);
        return;
        this.a.a(paramIntent);
        return;
        this.a.s();
        return;
        this.a.t();
        return;
        if (i == 1013)
        {
          armz.a(2131694490);
          return;
        }
        if (i == 1014)
        {
          armz.a(2131694532);
          return;
        }
        argh.a(this.a, i);
      } while (this.a.jdField_a_of_type_Ardn == null);
      this.a.jdField_a_of_type_Ardn.a(false);
      return;
    } while (!biqf.g.equalsIgnoreCase((String)localObject));
    label631:
    argh.a(this.a, false);
    label644:
    label651:
    label737:
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "channelReceiver MPFILE_ACTION_CHANNEL_DISCONNECT!");
    label839:
    label841:
    armz.a(2131694504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argi
 * JD-Core Version:    0.7.0.1
 */