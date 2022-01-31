import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownload;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownloadThumbnail;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

public class bcng
  extends yui
{
  public bcng(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    Object localObject2;
    Object localObject1;
    try
    {
      localObject2 = (TroopFileTransferManager)TroopFileTransferManager.a().get(Long.valueOf(l));
      if (localObject2 == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "bad troopUin" + l);
        }
        return;
      }
      String str = paramBundle.getString("itemKey");
      if (str == null) {
        return;
      }
      localObject1 = UUID.fromString(str);
      try
      {
        localObject1 = (TroopFileTransferManager.Item)((TroopFileTransferManager)localObject2).jdField_a_of_type_JavaUtilMap.get(localObject1);
        if (localObject1 == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileTransferManager", 4, "bad item key" + str);
          }
          return;
        }
      }
      finally {}
    }
    finally {}
    int i = arrr.a(arso.a(((TroopFileTransferManager.Item)localObject1).FileName));
    paramInt = paramBundle.getInt("thumbNail");
    boolean bool2 = paramBundle.getBoolean("isPreview", false);
    paramBundle = new bcnp();
    paramBundle.jdField_a_of_type_Int = -1;
    try
    {
      paramBundle.e = ((TroopFileTransferManager.Item)localObject1).Id.toString();
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder().append("isSuccess=").append(paramBoolean).append(", resp=");
        if (paramDownloadFileRspBody != null)
        {
          bool1 = true;
          QLog.i("TroopFileTransferManager", 4, bool1);
        }
      }
      else
      {
        if ((paramDownloadFileRspBody != null) && (paramBoolean)) {
          break label504;
        }
        if ((i == 2) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder().append("mReqDownloadFileObserver failed return, fn=").append(((TroopFileTransferManager.Item)localObject1).FileName).append(", isSucc").append(paramBoolean).append(", resp=");
          if (paramDownloadFileRspBody == null) {
            break label390;
          }
          paramBoolean = true;
          QLog.e(".troop.troop_file_video.thumb", 2, paramBoolean);
        }
        if (paramInt != 128) {
          break label395;
        }
        ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Small = false;
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        paramBundle.e = null;
        continue;
        boolean bool1 = false;
        continue;
        label390:
        paramBoolean = false;
      }
      label395:
      if (paramInt == 640)
      {
        ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Large = false;
        return;
      }
      if (paramInt == 383)
      {
        ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Middle = false;
        ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Middle_Fail = true;
        this.a.d((TroopFileTransferManager.Item)localObject1);
        return;
      }
      if (bool2)
      {
        bcmp.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.e, 700);
        paramBundle.jdField_a_of_type_Boolean = false;
        ((aloz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).c(paramBundle);
        return;
      }
      this.a.a((TroopFileTransferManager.Item)localObject1, 10, 103);
      return;
    }
    label504:
    i = paramDownloadFileRspBody.int32_ret_code.get();
    paramBundle.jdField_a_of_type_Int = i;
    if (bool2)
    {
      paramBundle.jdField_a_of_type_Boolean = false;
      paramBundle.jdField_a_of_type_JavaLangString = paramDownloadFileRspBody.str_download_ip.get();
      if ((TextUtils.isEmpty(paramBundle.jdField_a_of_type_JavaLangString)) || (paramBundle.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        paramBundle.jdField_a_of_type_JavaLangString = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      paramBundle.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      paramBundle.c = paramDownloadFileRspBody.str_ret_msg.get();
      paramBundle.d = bdhe.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_file_video.thumb", 2, "mReqDownloadFileObserver, fn=" + ((TroopFileTransferManager.Item)localObject1).FileName + ", retCode=" + i + ", bPreview=" + bool2);
    }
    ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Middle_Fail = false;
    if (i < 0)
    {
      if (paramInt == 128)
      {
        ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Small = false;
        return;
      }
      if (paramInt == 640)
      {
        ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Large = false;
        return;
      }
      if (paramInt == 383)
      {
        ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Middle = false;
        ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Middle_Fail = true;
        if ((i == -103) || (i == -302) || (i == -301))
        {
          TroopFileTransferManager.a(this.a, (TroopFileTransferManager.Item)localObject1);
          return;
        }
        this.a.d((TroopFileTransferManager.Item)localObject1);
        return;
      }
      if (bool2)
      {
        bcmp.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.e, 700);
        if (TextUtils.isEmpty(paramBundle.c)) {
          paramBundle.c = alud.a(2131715752);
        }
        paramBundle.jdField_a_of_type_Boolean = false;
        ((aloz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).c(paramBundle);
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
      QLog.i("TroopFileTransferManager", 1, "download_failed,troopUin=" + this.a.e + ",fileName=" + ((TroopFileTransferManager.Item)localObject1).FileName + ",filePath=" + ((TroopFileTransferManager.Item)localObject1).FilePath + ",retCode=" + i);
    }
    switch (i)
    {
    case -134: 
    default: 
      if (bool2)
      {
        paramBundle.jdField_a_of_type_Boolean = true;
        ((aloz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).c(paramBundle);
        return;
      }
      break;
    case -107: 
    case -102: 
      this.a.a((TroopFileTransferManager.Item)localObject1, 10, 101);
      if (paramInt != 0) {
        return;
      }
      bcpr.b(bcps.c, i);
      return;
    case -302: 
    case -301: 
    case -103: 
      TroopFileTransferManager.a(this.a, (TroopFileTransferManager.Item)localObject1, 301);
      if (((TroopFileTransferManager.Item)localObject1).TmpFile != null) {
        new File(((TroopFileTransferManager.Item)localObject1).TmpFile).delete();
      }
      ((TroopFileTransferManager.Item)localObject1).deleteThumbnailFile(this.a.e, 128);
      ((TroopFileTransferManager.Item)localObject1).deleteThumbnailFile(this.a.e, 640);
      TroopFileTransferManager.a(this.a, (TroopFileTransferManager.Item)localObject1);
      if (paramInt != 0) {
        return;
      }
      bcpr.b(bcps.c, i);
      return;
    }
    ((TroopFileTransferManager.Item)localObject1).cookieValue = bdhe.a(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
    if (((TroopFileTransferManager.Item)localObject1).cookieValue != null) {
      ((TroopFileTransferManager.Item)localObject1).cookieValue = ((TroopFileTransferManager.Item)localObject1).cookieValue.toLowerCase();
    }
    ((TroopFileTransferManager.Item)localObject1).DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
    ((TroopFileTransferManager.Item)localObject1).DownloadUrl = bdhe.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
    ((TroopFileTransferManager.Item)localObject1).Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
    ((TroopFileTransferManager.Item)localObject1).NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
    if (TextUtils.isEmpty(((TroopFileTransferManager.Item)localObject1).DownloadIp)) {
      bcpr.a("gfile", "ipnull", "", "", "", "");
    }
    if ((i == -133) || (i == -132)) {
      this.a.a((TroopFileTransferManager.Item)localObject1, ((TroopFileTransferManager.Item)localObject1).Status, 309);
    }
    while ((paramInt == 128) || (paramInt == 383) || (paramInt == 640))
    {
      paramDownloadFileRspBody = new TroopFileTransferManager.TaskHttpDownloadThumbnail(this.a, (TroopFileTransferManager.Item)localObject1, paramInt, String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get()));
      this.a.jdField_a_of_type_ArrayOfBcnq[4].a(paramDownloadFileRspBody);
      return;
      if (i == -134)
      {
        this.a.a((TroopFileTransferManager.Item)localObject1, 10, 302);
        if (paramInt != 0) {
          return;
        }
        bcpr.b(bcps.c, i);
        return;
      }
    }
    if (!this.a.c((TroopFileTransferManager.Item)localObject1)) {
      this.a.jdField_a_of_type_ArrayOfBcnq[3].a(new TroopFileTransferManager.TaskHttpDownload(this.a, (TroopFileTransferManager.Item)localObject1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcng
 * JD-Core Version:    0.7.0.1
 */