import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class atpe
  extends BroadcastReceiver
{
  atpe(atow paramatow) {}
  
  private void a(Intent paramIntent, FileManagerEntity paramFileManagerEntity)
  {
    if (paramIntent.getLongExtra("token_task_id", 0L) != paramFileManagerEntity.uniseq) {}
    for (;;)
    {
      return;
      long l1 = paramIntent.getLongExtra("token_current_size", 0L);
      long l2 = paramIntent.getLongExtra("token_total_size", 0L);
      paramFileManagerEntity.status = 2;
      if (l2 != 0L) {}
      for (paramFileManagerEntity.fProgress = ((float)l1 / (float)l2); this.a.jdField_a_of_type_Atou != null; paramFileManagerEntity.fProgress = 1.0F)
      {
        this.a.jdField_a_of_type_Atou.a(paramFileManagerEntity.fProgress);
        return;
      }
    }
  }
  
  private void b(Intent paramIntent, FileManagerEntity paramFileManagerEntity)
  {
    long l1 = paramIntent.getLongExtra("token_task_id", 0L);
    if (l1 != paramFileManagerEntity.uniseq) {
      return;
    }
    atow.b(this.a, NetConnInfoCenter.getServerTimeMillis());
    long l2 = paramIntent.getLongExtra("token_current_size", 0L);
    boolean bool = paramIntent.getBooleanExtra("token_is_success", false);
    int j = paramIntent.getIntExtra("token_http_code", 0);
    QLog.d("MPcFileModel<FileAssistant>", 2, "BROADCAST_MPFILE_DOWNLOAD_COMPLETED , currentSize:" + l2 + ",isSucceed:" + bool + ",http_code:" + j);
    paramIntent = new ReportItem();
    paramIntent.uSessionID = l1;
    paramIntent.uChannelType = 6;
    paramIntent.bSend = false;
    paramIntent.uNotifyTime = atow.a(this.a);
    paramIntent.uFileSize = l2;
    paramIntent.bFileExist = false;
    paramIntent.uStartPos = 0L;
    paramIntent.uTaskStart = atow.a(this.a);
    paramIntent.uTaskEnd = atow.b(this.a);
    paramIntent.uDuration = (atow.b(this.a) - atow.a(this.a));
    paramIntent.bUserRetry = false;
    paramIntent.sSuffix = "";
    int i;
    if (bool)
    {
      i = 2;
      paramIntent.emResult = i;
      paramIntent.nFailCode = 0;
      paramIntent.nUserCode = j;
      Object localObject = ((anjx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a();
      if (localObject == null) {
        break label489;
      }
      paramIntent.dwServerIP = dp.a(((bliz)localObject).jdField_a_of_type_JavaLangString);
      paramIntent.wServerPort = ((short)((bliz)localObject).jdField_a_of_type_Int);
      label281:
      paramIntent.dwClientIP = dp.a(dp.a());
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramFileManagerEntity.peerDin != 0L) {
        break label502;
      }
      i = ez.b;
      label313:
      ez.a((QQAppInterface)localObject, paramIntent, i);
      if (bool) {
        break label591;
      }
      paramFileManagerEntity.status = 3;
      if ((j != 2) && (j != 3) && (j != 4) && (j != 5) && (j != 8)) {
        break label509;
      }
      atvf.a(2131693773);
      label366:
      if (this.a.jdField_a_of_type_Atou != null) {
        this.a.jdField_a_of_type_Atou.g();
      }
    }
    label693:
    for (;;)
    {
      ((anjx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a(paramFileManagerEntity.strDataLineMPFileID);
      if (atow.a(this.a)) {
        break label695;
      }
      paramFileManagerEntity.mContext = "needMPFileC2C";
      QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + atow.a(this.a) + ",create mEntity.mContext");
      return;
      if (atow.b(this.a))
      {
        i = 32;
        break;
      }
      i = 41;
      break;
      label489:
      paramIntent.dwServerIP = 0;
      paramIntent.wServerPort = 0;
      break label281;
      label502:
      i = ez.d;
      break label313;
      label509:
      if (j == 1)
      {
        atvf.a(2131693771);
        break label366;
      }
      if (j == 1004)
      {
        atvf.a(2131693772);
        break label366;
      }
      if (j == 11)
      {
        QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file download!");
        break label366;
      }
      if (j == 12)
      {
        QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file predownload!");
        break label366;
      }
      atow.a(this.a, j + 2100);
      break label366;
      label591:
      paramFileManagerEntity.status = 1;
      paramIntent = ((anjx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().b();
      if (paramIntent == null) {
        if (QLog.isColorLevel()) {
          QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
        }
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Atou == null) {
          break label693;
        }
        this.a.jdField_a_of_type_Atou.f();
        break;
        paramFileManagerEntity.setFilePath(String.format("%s/%s", new Object[] { paramIntent, paramFileManagerEntity.fileName }));
        paramFileManagerEntity.setCloudType(3);
      }
    }
    label695:
    QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + atow.a(this.a) + "mEntity.mContext = null");
    paramFileManagerEntity.mContext = null;
  }
  
  private void c(Intent paramIntent, FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramIntent.getExtras();
    long l = paramIntent.getLongExtra(blix.f, 0L);
    int i = paramFileManagerEntity.getInt(blix.e);
    int j = paramFileManagerEntity.getInt("result");
    if ((i == 0) && (j == 0)) {
      atow.a(this.a, true);
    }
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "mainReceiver MPFILE_ACTION_HOST_INFO_UPDATE,ret:" + i);
    if (atow.c(this.a) != l) {}
    do
    {
      boolean bool;
      do
      {
        return;
        if (i != 0) {
          break;
        }
        i = paramFileManagerEntity.getInt("result");
        paramIntent = paramFileManagerEntity.getByteArray("bytes_json");
        j = paramFileManagerEntity.getInt("power");
        atow.b(this.a, j);
        bool = paramFileManagerEntity.getBoolean("inputPwdError", false);
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
          atow.a(this.a, i + 2000);
        }
      } while (this.a.jdField_a_of_type_Atmk == null);
      this.a.jdField_a_of_type_Atmk.a(false);
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
        atvf.a(2131693758);
        return;
      }
      if (i == 1014)
      {
        atvf.a(2131693800);
        return;
      }
      atow.a(this.a, i);
    } while (this.a.jdField_a_of_type_Atmk == null);
    this.a.jdField_a_of_type_Atmk.a(false);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.jdField_a_of_type_Atmn.a();
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramIntent.getAction();
      } while (str == null);
      if (str.equals("com.dataline.mpfile.download_progress"))
      {
        a(paramIntent, paramContext);
        return;
      }
      if (str.equals("com.dataline.mpfile.download_completed"))
      {
        b(paramIntent, paramContext);
        return;
      }
      if (blix.d.equalsIgnoreCase(str))
      {
        c(paramIntent, paramContext);
        return;
      }
    } while (!blix.g.equalsIgnoreCase(str));
    atow.a(this.a, false);
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "channelReceiver MPFILE_ACTION_CHANNEL_DISCONNECT!");
    atvf.a(2131693772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpe
 * JD-Core Version:    0.7.0.1
 */