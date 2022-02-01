import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class astj
  extends BroadcastReceiver
{
  astj(astb paramastb) {}
  
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
      for (paramFileManagerEntity.fProgress = ((float)l1 / (float)l2); this.a.jdField_a_of_type_Assz != null; paramFileManagerEntity.fProgress = 1.0F)
      {
        this.a.jdField_a_of_type_Assz.a(paramFileManagerEntity.fProgress);
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
    astb.b(this.a, NetConnInfoCenter.getServerTimeMillis());
    long l2 = paramIntent.getLongExtra("token_current_size", 0L);
    boolean bool = paramIntent.getBooleanExtra("token_is_success", false);
    int j = paramIntent.getIntExtra("token_http_code", 0);
    QLog.d("MPcFileModel<FileAssistant>", 2, "BROADCAST_MPFILE_DOWNLOAD_COMPLETED , currentSize:" + l2 + ",isSucceed:" + bool + ",http_code:" + j);
    paramIntent = new ReportItem();
    paramIntent.uSessionID = l1;
    paramIntent.uChannelType = 6;
    paramIntent.bSend = false;
    paramIntent.uNotifyTime = astb.a(this.a);
    paramIntent.uFileSize = l2;
    paramIntent.bFileExist = false;
    paramIntent.uStartPos = 0L;
    paramIntent.uTaskStart = astb.a(this.a);
    paramIntent.uTaskEnd = astb.b(this.a);
    paramIntent.uDuration = (astb.b(this.a) - astb.a(this.a));
    paramIntent.bUserRetry = false;
    paramIntent.sSuffix = "";
    int i;
    if (bool)
    {
      i = 2;
      paramIntent.emResult = i;
      paramIntent.nFailCode = 0;
      paramIntent.nUserCode = j;
      Object localObject = ((amqd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(8)).a().a();
      if (localObject == null) {
        break label489;
      }
      paramIntent.dwServerIP = dp.a(((bkoj)localObject).jdField_a_of_type_JavaLangString);
      paramIntent.wServerPort = ((short)((bkoj)localObject).jdField_a_of_type_Int);
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
      aszk.a(2131693889);
      label366:
      if (this.a.jdField_a_of_type_Assz != null) {
        this.a.jdField_a_of_type_Assz.g();
      }
    }
    label693:
    for (;;)
    {
      ((amqd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(8)).a().a(paramFileManagerEntity.strDataLineMPFileID);
      if (astb.a(this.a)) {
        break label695;
      }
      paramFileManagerEntity.mContext = "needMPFileC2C";
      QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + astb.a(this.a) + ",create mEntity.mContext");
      return;
      if (astb.b(this.a))
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
        aszk.a(2131693887);
        break label366;
      }
      if (j == 1004)
      {
        aszk.a(2131693888);
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
      astb.a(this.a, j + 2100);
      break label366;
      label591:
      paramFileManagerEntity.status = 1;
      paramIntent = ((amqd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(8)).a().b();
      if (paramIntent == null) {
        if (QLog.isColorLevel()) {
          QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
        }
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Assz == null) {
          break label693;
        }
        this.a.jdField_a_of_type_Assz.f();
        break;
        paramFileManagerEntity.setFilePath(String.format("%s/%s", new Object[] { paramIntent, paramFileManagerEntity.fileName }));
        paramFileManagerEntity.setCloudType(3);
      }
    }
    label695:
    QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + astb.a(this.a) + "mEntity.mContext = null");
    paramFileManagerEntity.mContext = null;
  }
  
  private void c(Intent paramIntent, FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramIntent.getExtras();
    long l = paramIntent.getLongExtra(bkoh.f, 0L);
    int i = paramFileManagerEntity.getInt(bkoh.e);
    int j = paramFileManagerEntity.getInt("result");
    if ((i == 0) && (j == 0)) {
      astb.a(this.a, true);
    }
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "mainReceiver MPFILE_ACTION_HOST_INFO_UPDATE,ret:" + i);
    if (astb.c(this.a) != l) {}
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
        astb.b(this.a, j);
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
          astb.a(this.a, i + 2000);
        }
      } while (this.a.jdField_a_of_type_Asqp == null);
      this.a.jdField_a_of_type_Asqp.a(false);
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
        aszk.a(2131693874);
        return;
      }
      if (i == 1014)
      {
        aszk.a(2131693916);
        return;
      }
      astb.a(this.a, i);
    } while (this.a.jdField_a_of_type_Asqp == null);
    this.a.jdField_a_of_type_Asqp.a(false);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.jdField_a_of_type_Asqs.a();
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
      if (bkoh.d.equalsIgnoreCase(str))
      {
        c(paramIntent, paramContext);
        return;
      }
    } while (!bkoh.g.equalsIgnoreCase(str));
    astb.a(this.a, false);
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "channelReceiver MPFILE_ACTION_CHANNEL_DISCONNECT!");
    aszk.a(2131693888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astj
 * JD-Core Version:    0.7.0.1
 */