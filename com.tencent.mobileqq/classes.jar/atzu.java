import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Utils;
import cooperation.weiyun.channel.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileDocDownloadAbsMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskSimpleFileItem;
import cooperation.weiyun.channel.pb.WeiyunPB.ExtensionReq;
import cooperation.weiyun.channel.pb.WeiyunPB.LibInfoListGetMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.PicVideo2QcloudItem;
import cooperation.weiyun.channel.pb.WeiyunPB.PwdVerifyMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.ShareFileItem;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgReq;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunShareAuthInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class atzu
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LinkedHashMap<String, WeiYunFileInfo> jdField_a_of_type_JavaUtilLinkedHashMap;
  private volatile boolean b;
  private volatile boolean c;
  
  public atzu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (jdField_a_of_type_Boolean) {
      bmyh.b();
    }
    bmyh.a();
    jdField_a_of_type_Boolean = true;
  }
  
  private int a(int paramInt)
  {
    int i = 1;
    if (acwh.d(paramInt)) {
      i = 0;
    }
    while (paramInt == 1) {
      return i;
    }
    if (paramInt == 3000) {
      return 2;
    }
    return 3;
  }
  
  private int a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (acwh.d(paramInt)) {
        return 3;
      }
      return 4;
    }
    if (acwh.d(paramInt)) {
      return 1;
    }
    return 2;
  }
  
  private WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq a(FileManagerEntity paramFileManagerEntity, long paramLong)
  {
    WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq localCrossBidProxyCopyFileToOtherBidMsgReq = new WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq();
    if (paramFileManagerEntity.fileName != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_name.set(paramFileManagerEntity.fileName);
    }
    localCrossBidProxyCopyFileToOtherBidMsgReq.file_size.set(paramFileManagerEntity.fileSize);
    if (paramFileManagerEntity.strFileSHA != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_sha.set(bnau.a(paramFileManagerEntity.strFileSHA));
    }
    if (paramFileManagerEntity.strFileMd5 != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_md5.set(bnau.a(paramFileManagerEntity.strFileMd5));
    }
    if (paramFileManagerEntity.WeiYunFileId != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.src_file_id.set(paramFileManagerEntity.WeiYunFileId);
    }
    if (paramFileManagerEntity.WeiYunDirKey != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.src_pdir_key.set(bnau.a(paramFileManagerEntity.WeiYunDirKey));
    }
    localCrossBidProxyCopyFileToOtherBidMsgReq.src_bid.set(25);
    localCrossBidProxyCopyFileToOtherBidMsgReq.src_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    localCrossBidProxyCopyFileToOtherBidMsgReq.src_group.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    localCrossBidProxyCopyFileToOtherBidMsgReq.dst_bid.set(102);
    localCrossBidProxyCopyFileToOtherBidMsgReq.dst_uin.set(paramLong);
    localCrossBidProxyCopyFileToOtherBidMsgReq.user_type.set(0);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      WeiyunPB.ExtensionReq localExtensionReq = new WeiyunPB.ExtensionReq();
      localExtensionReq.uint64_id.set(3L);
      localExtensionReq.uint64_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionType == 102L) && (paramFileManagerEntity.peerUin != null)) {
        localExtensionReq.str_dst_phonenum.set(paramFileManagerEntity.peerUin);
      }
      paramFileManagerEntity.tmpSessionSig = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.peerUin, (int)paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        localExtensionReq.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      localCrossBidProxyCopyFileToOtherBidMsgReq.extension_req.set(localExtensionReq);
    }
    return localCrossBidProxyCopyFileToOtherBidMsgReq;
  }
  
  private WeiyunPB.PicVideo2QcloudItem a(MessageForPic paramMessageForPic)
  {
    WeiyunPB.PicVideo2QcloudItem localPicVideo2QcloudItem = new WeiyunPB.PicVideo2QcloudItem();
    localPicVideo2QcloudItem.bool_auto_create_user.set(true);
    if (!TextUtils.isEmpty(paramMessageForPic.uuid)) {
      localPicVideo2QcloudItem.str_file_id.set(paramMessageForPic.uuid);
    }
    localPicVideo2QcloudItem.uint64_file_id.set(paramMessageForPic.groupFileID);
    if (!TextUtils.isEmpty(paramMessageForPic.uuid)) {
      localPicVideo2QcloudItem.str_file_name.set(paramMessageForPic.uuid);
    }
    if (!TextUtils.isEmpty(paramMessageForPic.md5)) {
      localPicVideo2QcloudItem.str_file_md5.set(paramMessageForPic.md5);
    }
    localPicVideo2QcloudItem.uint32_bid.set(a(false, paramMessageForPic.istroop));
    localPicVideo2QcloudItem.uint32_chat_type.set(a(paramMessageForPic.istroop));
    localPicVideo2QcloudItem.uint32_user_type.set(paramMessageForPic.issend);
    if (!TextUtils.isEmpty(paramMessageForPic.frienduin)) {
      localPicVideo2QcloudItem.str_dst_id.set(paramMessageForPic.frienduin);
    }
    if (!TextUtils.isEmpty(paramMessageForPic.senderuin)) {
      localPicVideo2QcloudItem.str_src_id.set(paramMessageForPic.senderuin);
    }
    localPicVideo2QcloudItem.image_type.set(paramMessageForPic.imageType);
    localPicVideo2QcloudItem.uint64_file_size.set(paramMessageForPic.size);
    if (paramMessageForPic.rawMsgUrl != null) {
      localPicVideo2QcloudItem.raw_url.set(paramMessageForPic.rawMsgUrl);
    }
    return localPicVideo2QcloudItem;
  }
  
  private WeiyunPB.PicVideo2QcloudItem a(MessageForShortVideo paramMessageForShortVideo)
  {
    WeiyunPB.PicVideo2QcloudItem localPicVideo2QcloudItem = new WeiyunPB.PicVideo2QcloudItem();
    localPicVideo2QcloudItem.bool_auto_create_user.set(true);
    if (!TextUtils.isEmpty(paramMessageForShortVideo.uuid)) {
      localPicVideo2QcloudItem.str_file_id.set(paramMessageForShortVideo.uuid);
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.md5)) {
      localPicVideo2QcloudItem.str_file_md5.set(paramMessageForShortVideo.md5);
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName)) {
      localPicVideo2QcloudItem.str_file_name.set(paramMessageForShortVideo.videoFileName);
    }
    localPicVideo2QcloudItem.uint32_bid.set(a(true, paramMessageForShortVideo.istroop));
    localPicVideo2QcloudItem.uint32_chat_type.set(a(paramMessageForShortVideo.istroop));
    localPicVideo2QcloudItem.uint32_user_type.set(paramMessageForShortVideo.issend);
    if (!TextUtils.isEmpty(paramMessageForShortVideo.frienduin)) {
      localPicVideo2QcloudItem.str_dst_id.set(paramMessageForShortVideo.frienduin);
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.senderuin)) {
      localPicVideo2QcloudItem.str_src_id.set(paramMessageForShortVideo.senderuin);
    }
    localPicVideo2QcloudItem.uint64_file_size.set(paramMessageForShortVideo.videoFileSize);
    return localPicVideo2QcloudItem;
  }
  
  @Nullable
  private String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : strFileId[" + paramString1 + "], thumbUrl[" + paramString2 + "], WeiYunThumbnailType[" + paramInt + "]");
    }
    String str;
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 39, new Object[] { paramString1, paramObject });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : fileID or thumbUrl error");
      }
      str = null;
    }
    Pair localPair;
    File localFile;
    do
    {
      do
      {
        return str;
        str = paramString2;
      } while (!paramString2.startsWith("http"));
      localPair = bmyh.a(paramString2, paramInt, paramBoolean);
      localFile = new File(bmyh.b(), Long.toString(((Long)localPair.second).longValue()));
      paramString2 = localFile.getAbsolutePath();
      str = paramString2;
    } while (localFile.exists());
    if (!bgnt.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 39, new Object[] { paramString1, paramObject });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : network error");
      }
      return null;
    }
    paramString1 = new auae(this, paramString1, paramInt, paramObject);
    bmzf.a().a((String)((Pair)localPair.first).first, paramString2, (String)((Pair)localPair.first).second, paramString1);
    return null;
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, bety parambety, String paramString, int paramInt1, int paramInt2)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.valueOf(paramString).longValue());
    if (localTroopFileTransferManager == null) {}
    for (;;)
    {
      return;
      long l1 = 0L;
      int i = atvo.a(parambety.jdField_a_of_type_JavaLangString);
      Object localObject;
      long l2;
      if ((atwl.a(parambety.jdField_a_of_type_JavaLangString)) && ((i == 0) || (i == 2))) {
        if (i == 0)
        {
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(parambety.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          l2 = bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, parambety.g, parambety.c, parambety.jdField_a_of_type_JavaUtilUUID.toString(), paramInt2, Long.toString(parambety.b), paramFileManagerEntity.nSessionId, ((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight);
          paramFileManagerEntity = localTroopFileTransferManager.a(parambety.jdField_a_of_type_JavaUtilUUID);
          l1 = l2;
          if (paramFileManagerEntity != null)
          {
            paramFileManagerEntity.width = ((BitmapFactory.Options)localObject).outWidth;
            paramFileManagerEntity.height = ((BitmapFactory.Options)localObject).outHeight;
            l1 = l2;
          }
        }
      }
      while ((paramInt1 != 0) && (l1 != 0L))
      {
        agjf.a().a(l1, 0L, paramInt1);
        return;
        if (i == 2)
        {
          localObject = ShortVideoUtils.a(parambety.jdField_a_of_type_JavaLangString);
          l2 = bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, parambety.g, parambety.c, parambety.jdField_a_of_type_JavaUtilUUID.toString(), paramInt2, Long.toString(parambety.b), paramFileManagerEntity.nSessionId, localObject[0], localObject[1], localObject[2]);
          paramFileManagerEntity = localTroopFileTransferManager.a(parambety.jdField_a_of_type_JavaUtilUUID);
          l1 = l2;
          if (paramFileManagerEntity != null)
          {
            paramFileManagerEntity.width = localObject[0];
            paramFileManagerEntity.height = localObject[1];
            l1 = l2;
            continue;
            l1 = bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, parambety.jdField_a_of_type_JavaUtilUUID.toString(), paramInt2, Long.toString(8888L), paramFileManagerEntity.nSessionId);
          }
        }
      }
    }
  }
  
  private void a(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq paramAioPicAndVideoCopyToWeiyunMsgReq, auah paramauah)
  {
    bmxr.a();
    bmyx.a(paramAioPicAndVideoCopyToWeiyunMsgReq, new auad(this, paramauah));
  }
  
  private boolean a(WeiyunPB.WeiyunShareAddFromMobileQQMsgReq paramWeiyunShareAddFromMobileQQMsgReq, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramLong > 0L)
    {
      paramWeiyunShareAddFromMobileQQMsgReq.weiyun_share_auth_info.expired_time.set((int)(paramLong / 1000L));
      paramWeiyunShareAddFromMobileQQMsgReq.weiyun_share_auth_info.setHasFlag(true);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramWeiyunShareAddFromMobileQQMsgReq.pass_word.set(paramString);
      paramWeiyunShareAddFromMobileQQMsgReq.weiyun_share_auth_info.pass_word.set(paramString);
      paramWeiyunShareAddFromMobileQQMsgReq.weiyun_share_auth_info.setHasFlag(true);
    }
    paramWeiyunShareAddFromMobileQQMsgReq.enable_qq_add_friend.set(paramBoolean1);
    paramWeiyunShareAddFromMobileQQMsgReq = paramWeiyunShareAddFromMobileQQMsgReq.qr_flag;
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      paramWeiyunShareAddFromMobileQQMsgReq.set(i);
      return true;
    }
  }
  
  private boolean a(WeiyunPB.WeiyunShareAddFromMobileQQMsgReq paramWeiyunShareAddFromMobileQQMsgReq, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = false;
    int i = atvo.a(paramFileManagerEntity);
    if (i == 2)
    {
      paramWeiyunShareAddFromMobileQQMsgReq.source.set(1);
      paramWeiyunShareAddFromMobileQQMsgReq.file.setHasFlag(true);
      paramWeiyunShareAddFromMobileQQMsgReq.file.file_id.set(paramFileManagerEntity.WeiYunFileId);
      if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey)) {
        paramWeiyunShareAddFromMobileQQMsgReq.file.pdir_key.set(bnau.a(paramFileManagerEntity.WeiYunDirKey));
      }
      bool = true;
    }
    label111:
    label241:
    do
    {
      for (;;)
      {
        return bool;
        if (i == 1)
        {
          paramWeiyunShareAddFromMobileQQMsgReq.source.set(2);
          PBUInt64Field localPBUInt64Field = paramWeiyunShareAddFromMobileQQMsgReq.src_uin;
          Object localObject;
          if (paramFileManagerEntity.peerType == 3000)
          {
            localObject = paramFileManagerEntity.peerUin;
            localPBUInt64Field.set(Long.parseLong((String)localObject));
            localObject = paramWeiyunShareAddFromMobileQQMsgReq.src_appid;
            if (paramFileManagerEntity.peerType != 3000) {
              break label241;
            }
          }
          for (i = 106;; i = 3)
          {
            ((PBUInt32Field)localObject).set(i);
            if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid)) {
              paramWeiyunShareAddFromMobileQQMsgReq.src_full_path.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
            }
            paramWeiyunShareAddFromMobileQQMsgReq.file_size.set(paramFileManagerEntity.fileSize);
            if (!TextUtils.isEmpty(paramFileManagerEntity.fileName)) {
              paramWeiyunShareAddFromMobileQQMsgReq.file_name.set(paramFileManagerEntity.fileName);
            }
            if (TextUtils.isEmpty(paramFileManagerEntity.strFileSHA)) {
              break;
            }
            paramWeiyunShareAddFromMobileQQMsgReq.file_sha.set(paramFileManagerEntity.strFileSHA);
            break;
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            break label111;
          }
        }
        if (i != 4) {
          break label412;
        }
        paramWeiyunShareAddFromMobileQQMsgReq.source.set(3);
        try
        {
          paramFileManagerEntity = bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
          if ((paramFileManagerEntity == null) || (TextUtils.isEmpty(paramFileManagerEntity.e)))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink : troop file info is invalid");
            return false;
          }
        }
        catch (Throwable paramFileManagerEntity)
        {
          for (;;)
          {
            QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink : get troop file info error", paramFileManagerEntity);
            paramFileManagerEntity = null;
          }
          paramWeiyunShareAddFromMobileQQMsgReq.src_uin.set(paramFileManagerEntity.b);
          paramWeiyunShareAddFromMobileQQMsgReq.src_appid.set(paramFileManagerEntity.h);
          paramWeiyunShareAddFromMobileQQMsgReq.src_full_path.set(ByteStringMicro.copyFrom(paramFileManagerEntity.e.getBytes()));
          paramWeiyunShareAddFromMobileQQMsgReq.file_size.set(paramFileManagerEntity.c);
          if (!TextUtils.isEmpty(paramFileManagerEntity.g)) {
            paramWeiyunShareAddFromMobileQQMsgReq.file_name.set(paramFileManagerEntity.g);
          }
        }
      }
      if (TextUtils.isEmpty(paramFileManagerEntity.f)) {
        break;
      }
      paramWeiyunShareAddFromMobileQQMsgReq.file_sha.set(paramFileManagerEntity.f);
      break;
    } while (!QLog.isColorLevel());
    label412:
    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink : unsupported cloudType:" + i);
    return false;
  }
  
  private void b()
  {
    if (!bnaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
    {
      if (NetworkUtils.isWifiAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
      {
        this.c = true;
        bnaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new auaf(this));
      }
      return;
    }
    this.b = true;
    bmxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), true);
    WeiyunTransmissionGlobal.getInstance().getUploadManager().loadLibFromPath(bnaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).getAbsolutePath());
  }
  
  public auam a(FileManagerEntity paramFileManagerEntity, Object paramObject, bmzs parambmzs)
  {
    if (paramFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile entity is null");
      }
    }
    Pair localPair;
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile, fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + paramFileManagerEntity.fileSize + "],modifyTime[" + paramFileManagerEntity.lastTime + "]");
      }
      if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey)) {
        break label169;
      }
      localPair = aszj.a(paramFileManagerEntity.WeiYunFileId);
      if (localPair != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile dirKey is null");
    return null;
    paramFileManagerEntity.WeiYunDirKey = ((String)localPair.first);
    paramFileManagerEntity.WeiYunFileId = ((String)localPair.second);
    label169:
    if (paramFileManagerEntity.nWeiYunSrcType == 2) {
      paramFileManagerEntity = bmzf.a().a(paramFileManagerEntity.strLargeThumPath, paramFileManagerEntity.strThumbPath, paramFileManagerEntity.WeiYunDirKey, paramFileManagerEntity.WeiYunFileId, parambmzs);
    }
    label290:
    for (;;)
    {
      return new auam(paramFileManagerEntity, paramObject, false, null, parambmzs);
      paramFileManagerEntity = bmxt.a(paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.strFileSHA, paramFileManagerEntity.fileSize, 0, paramFileManagerEntity.WeiYunDirKey, paramFileManagerEntity.strLargeThumPath);
      if (paramFileManagerEntity == null) {}
      for (paramFileManagerEntity = null;; paramFileManagerEntity = bmzf.a().a(paramFileManagerEntity, bmyh.a(), true, parambmzs))
      {
        if (!TextUtils.isEmpty(paramFileManagerEntity)) {
          break label290;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "create download task failed!");
        return null;
      }
    }
  }
  
  public auam a(String paramString, Object paramObject, UploadManager.IUploadStatusListener paramIUploadStatusListener)
  {
    if ((!this.b) && (!this.c)) {
      b();
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile strPath is null");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile, strPath[" + paramString + "]");
    }
    paramString = bmxt.b(paramString, UploadFile.createUploadBatch(1, null), 1);
    if (paramString == null) {}
    for (paramString = null;; paramString = WeiyunTransmissionGlobal.getInstance().getUploadManager().upload(paramString, false, true, paramIUploadStatusListener))
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label138;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile create upload task failed!");
      return null;
    }
    label138:
    return new auam(paramString, paramObject, true, paramIUploadStatusListener, null);
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertOfflineFile2WeiYunEntity : entity is null!");
      }
      atvo.a();
      return null;
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertOfflineFile2WeiYunEntity : fromUin is null!");
      }
      atvo.a();
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = atvo.a().longValue();
    localFileManagerEntity.uniseq = -1L;
    localFileManagerEntity.nOpType = 4;
    localFileManagerEntity.peerNick = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, null, paramFileManagerEntity.peerType);
    localFileManagerEntity.peerType = paramFileManagerEntity.peerType;
    localFileManagerEntity.peerUin = paramString;
    if (paramFileManagerEntity.peerType == 3000) {}
    for (localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;; localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())
    {
      localFileManagerEntity.srvTime = (bbyp.a() * 1000L);
      localFileManagerEntity.status = 2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "insertWeiYun2OfflineEntity FileManagerEntity:" + atvo.a(localFileManagerEntity));
      }
      return localFileManagerEntity;
    }
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertWeiYun2OfflineEntity : entity is null, peerUin[" + atvo.e(paramString2) + "], peerType[" + paramInt1 + "]");
      }
      paramFileManagerEntity = null;
      return paramFileManagerEntity;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = atvo.a().longValue();
    String str = bdzv.a("", 0L, 0, true);
    long l = bbzh.a(-1000).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nOpType = 3;
    localFileManagerEntity.peerNick = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, null, paramInt1);
    localFileManagerEntity.peerType = paramInt1;
    localFileManagerEntity.selfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localFileManagerEntity.srvTime = (bbyp.a() * 1000L);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = atvo.a();
    localFileManagerEntity.msgUid = atvo.b();
    if (paramInt2 != 0) {
      agjf.a().a(l, 0L, paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    paramFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if ((paramInt1 == 1004) || (paramInt1 == 1000)) {
      paramFileManagerEntity = paramString1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, paramFileManagerEntity, true, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, true, paramInt1, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, null, 2, l, localFileManagerEntity.msgUid, -1L, bbyp.a());
      paramFileManagerEntity = localFileManagerEntity;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "insertWeiYun2OfflineEntity peerType[" + paramInt1 + "],FileManagerEntity:" + atvo.a(localFileManagerEntity));
      return localFileManagerEntity;
      if (paramInt1 == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString1;
        localFileManagerEntity.tmpSessionToPhone = paramString2;
        paramFileManagerEntity = paramString1;
      }
    }
  }
  
  public String a(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramInt, true, paramObject);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd");
    }
    bmyx.a(new atzy(this));
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList, categoryId[" + paramString1 + "], offset[" + paramInt2 + "], count[" + paramInt3 + "], version[" + paramString2 + "]");
    }
    if (!bgnt.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 31, new Object[] { Integer.valueOf(0), "network error", paramString1 });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList : network error");
      }
      return;
    }
    if (paramInt2 == 0)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      this.jdField_a_of_type_Int = 0;
      label168:
      this.jdField_a_of_type_Int += 1;
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "categoryId : " + paramString1);
      if (!"document".equals(paramString1)) {
        break label330;
      }
      paramInt2 = 1;
    }
    for (;;)
    {
      WeiyunPB.LibInfoListGetMsgReq localLibInfoListGetMsgReq = new WeiyunPB.LibInfoListGetMsgReq();
      localLibInfoListGetMsgReq.lib_id.set(paramInt2);
      localLibInfoListGetMsgReq.load_type.set(1);
      PBStringField localPBStringField = localLibInfoListGetMsgReq.local_version;
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      localPBStringField.set(str);
      localLibInfoListGetMsgReq.count.set(paramInt3);
      localLibInfoListGetMsgReq.scene_id.set(paramInt1);
      bmyx.a(localLibInfoListGetMsgReq, new atzv(this, paramString1));
      return;
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null) {
        break label168;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList : start not from zero?!");
      return;
      label330:
      paramInt2 = i;
      if (!"picture".equals(paramString1)) {
        if ("video".equals(paramString1)) {
          paramInt2 = 4;
        } else if ("music".equals(paramString1)) {
          paramInt2 = 3;
        } else {
          paramInt2 = 5;
        }
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, auah paramauah)
  {
    WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq localAioPicAndVideoCopyToWeiyunMsgReq = new WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq();
    ArrayList localArrayList = new ArrayList(1);
    if ((paramChatMessage instanceof MessageForPic)) {
      localArrayList.add(a((MessageForPic)paramChatMessage));
    }
    for (;;)
    {
      localAioPicAndVideoCopyToWeiyunMsgReq.pic_video_2qcloud_list.set(localArrayList);
      a(localAioPicAndVideoCopyToWeiyunMsgReq, paramauah);
      return;
      if ((paramChatMessage instanceof MessageForShortVideo)) {
        localArrayList.add(a((MessageForShortVideo)paramChatMessage));
      }
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "=_= ^! [CS Send]sendWeiYun2OfflineFile : entity is null");
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L, "actFileWy2Of", 0L, "", "", "", "", 9006L, "entity is null", 0L, 0L, 0L, "", "", 0, "", null);
      atvo.a();
      return;
    }
    paramFileManagerEntity.status = 2;
    if (!bgnt.d(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 3, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 33, new Object[] { Integer.valueOf(2), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "=_= ^! [CS Send] Id[" + paramFileManagerEntity.nSessionId + "]sendWeiYun2OfflineFile : network error");
      atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", paramFileManagerEntity.peerUin, "", "", 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "", null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
      return;
    }
    QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "=_= ^ [CS Send]sendWyFile2QqOffline, peerUin[" + atvo.e(paramFileManagerEntity.peerUin) + "peerType[" + paramInt + "]], WeiYunFileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + paramFileManagerEntity.fileSize + "], nWeiYunSrcType[" + paramFileManagerEntity.nWeiYunSrcType + "]");
    paramFileManagerEntity.fProgress = 0.0F;
    long l;
    try
    {
      l = Long.parseLong(paramFileManagerEntity.peerUin.replace("+", ""));
      awhl localawhl = (awhl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
      if ((localawhl != null) && (localawhl.a(paramFileManagerEntity.peerUin)))
      {
        atvo.a(anni.a(2131715594));
        paramFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 3, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 33, new Object[] { Integer.valueOf(10), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
        if (QLog.isColorLevel()) {
          QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2OfflineFile : shield");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("WeiYunLogicCenter<FileAssistant>", 2, "number format failed!");
        }
        l = 0L;
      }
      if ((TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) || (TextUtils.isEmpty(paramFileManagerEntity.fileName)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWyFile2QqOffline onFailed: weiyunID is null[" + TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId) + "], fileName is Null[" + TextUtils.isEmpty(paramFileManagerEntity.fileName) + "]");
        }
        paramFileManagerEntity.status = 0;
        paramFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.nSessionId, 1005);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 33, new Object[] { Integer.valueOf(1), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
        return;
      }
      i = 3;
      if (paramInt != 3000) {
        break label1154;
      }
    }
    int i = 106;
    QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] sendWeiYun2Disc[" + paramFileManagerEntity.fileName + "]");
    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "=_= ^ Id[" + paramFileManagerEntity.nSessionId + "]sendWyFile2Offline bizId:" + i);
    WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq localCrossBidProxyCopyFileToOtherBidMsgReq = new WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq();
    if (paramFileManagerEntity.fileName != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_name.set(paramFileManagerEntity.fileName);
    }
    localCrossBidProxyCopyFileToOtherBidMsgReq.file_size.set(paramFileManagerEntity.fileSize);
    if (paramFileManagerEntity.strFileSHA != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_sha.set(bnau.a(paramFileManagerEntity.strFileSHA));
    }
    if (paramFileManagerEntity.strFileMd5 != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_md5.set(bnau.a(paramFileManagerEntity.strFileMd5));
    }
    for (;;)
    {
      if (paramFileManagerEntity.WeiYunFileId != null) {
        localCrossBidProxyCopyFileToOtherBidMsgReq.src_file_id.set(paramFileManagerEntity.WeiYunFileId);
      }
      if (paramFileManagerEntity.WeiYunDirKey != null) {
        localCrossBidProxyCopyFileToOtherBidMsgReq.src_pdir_key.set(bnau.a(paramFileManagerEntity.WeiYunDirKey));
      }
      localCrossBidProxyCopyFileToOtherBidMsgReq.src_bid.set(25);
      localCrossBidProxyCopyFileToOtherBidMsgReq.src_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      localCrossBidProxyCopyFileToOtherBidMsgReq.src_group.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      localCrossBidProxyCopyFileToOtherBidMsgReq.dst_bid.set(i);
      localCrossBidProxyCopyFileToOtherBidMsgReq.dst_uin.set(l);
      localCrossBidProxyCopyFileToOtherBidMsgReq.user_type.set(0);
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        WeiyunPB.ExtensionReq localExtensionReq = new WeiyunPB.ExtensionReq();
        localExtensionReq.uint64_id.set(3L);
        localExtensionReq.uint64_type.set(paramFileManagerEntity.tmpSessionType);
        if ((paramFileManagerEntity.tmpSessionType == 102L) && (paramFileManagerEntity.peerUin != null)) {
          localExtensionReq.str_dst_phonenum.set(paramFileManagerEntity.peerUin);
        }
        paramFileManagerEntity.tmpSessionSig = atvo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.peerUin, (int)paramFileManagerEntity.tmpSessionType);
        if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
          localExtensionReq.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
        }
        localCrossBidProxyCopyFileToOtherBidMsgReq.extension_req.set(localExtensionReq);
      }
      bmyx.a(localCrossBidProxyCopyFileToOtherBidMsgReq, new auaa(this, paramFileManagerEntity, paramInt));
      atvo.b(paramFileManagerEntity.nSessionId);
      return;
      label1154:
      QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "=_=k Id[" + paramFileManagerEntity.nSessionId + "] sendWeiYun2Offline[" + paramFileManagerEntity.fileName + "]");
      break;
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_md5.set(bnau.a(""));
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, auah paramauah)
  {
    if (!bgnt.d(BaseApplication.getContext()))
    {
      if (paramauah != null) {
        paramauah.a(2, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink : network error");
      }
    }
    WeiyunPB.WeiyunShareAddFromMobileQQMsgReq localWeiyunShareAddFromMobileQQMsgReq;
    do
    {
      return;
      localWeiyunShareAddFromMobileQQMsgReq = new WeiyunPB.WeiyunShareAddFromMobileQQMsgReq();
      if ((a(localWeiyunShareAddFromMobileQQMsgReq, paramLong, paramString, paramBoolean1, paramBoolean2)) && (a(localWeiyunShareAddFromMobileQQMsgReq, paramFileManagerEntity))) {
        break;
      }
    } while (paramauah == null);
    paramauah.a(13, "");
    return;
    bmyx.a(localWeiyunShareAddFromMobileQQMsgReq, new atzx(this, paramauah));
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (paramFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop : entity is null");
      }
    }
    TroopFileTransferManager localTroopFileTransferManager;
    bety localbety;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.valueOf(paramString).longValue());
        } while (localTroopFileTransferManager == null);
        i = Math.abs(new Random().nextInt());
        localbety = localTroopFileTransferManager.a(paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileSize, 25, i, 8888L);
      } while (localbety == null);
      a(paramFileManagerEntity, localbety, paramString, paramInt, i);
      paramFileManagerEntity.status = 2;
      if (bgnt.d(BaseApplication.getContext())) {
        break;
      }
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      localTroopFileTransferManager.a(localbety.jdField_a_of_type_JavaUtilUUID, -1, null, anni.a(2131715592));
    } while (!QLog.isColorLevel());
    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop : network error");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop, peerUin[" + atvo.e(paramFileManagerEntity.peerUin) + "], WeiYunFileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + paramFileManagerEntity.fileSize + "], nWeiYunSrcType[" + paramFileManagerEntity.nWeiYunSrcType + "]");
    }
    paramFileManagerEntity.fProgress = 0.0F;
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
      bmyx.a(a(paramFileManagerEntity, l1), new auab(this, localTroopFileTransferManager, localbety, paramFileManagerEntity));
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.w("WeiYunLogicCenter<FileAssistant>", 2, "number format failed!");
          l1 = l2;
        }
      }
    }
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "deleteWeiYunFile, strFileId[" + paramWeiYunFileInfo.jdField_a_of_type_JavaLangString + "],strFileName[" + paramWeiYunFileInfo.c + "]");
    }
    athc.a(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString, paramWeiYunFileInfo);
    Object localObject = new WeiyunPB.DiskSimpleFileItem();
    ((WeiyunPB.DiskSimpleFileItem)localObject).file_id.set(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    if (paramWeiYunFileInfo.b != null) {
      ((WeiyunPB.DiskSimpleFileItem)localObject).pdir_key.set(bnau.a(paramWeiYunFileInfo.b));
    }
    ((WeiyunPB.DiskSimpleFileItem)localObject).filename.set(paramWeiYunFileInfo.c);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(localObject);
    localObject = new WeiyunPB.DiskDirFileBatchDeleteExMsgReq();
    ((WeiyunPB.DiskDirFileBatchDeleteExMsgReq)localObject).file_list.set(localArrayList);
    bmyx.a((WeiyunPB.DiskDirFileBatchDeleteExMsgReq)localObject, new auag(this, paramWeiYunFileInfo));
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo, auah paramauah)
  {
    if (paramWeiYunFileInfo == null) {
      QLog.e("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^! [CS Send]sendWeiYun2Dataline : entity is null");
    }
    do
    {
      do
      {
        return;
        if (bgnt.d(BaseApplication.getContext())) {
          break;
        }
      } while (paramauah == null);
      paramauah.a(-1, "no_network");
      return;
      QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^ [CS Send]sendWeiYun2Dataline, WeiYunFileId[" + paramWeiYunFileInfo.jdField_a_of_type_JavaLangString + "], fileName[" + paramWeiYunFileInfo.c + "], fileSize[" + paramWeiYunFileInfo.jdField_a_of_type_Long + "], nWeiYunSrcType[" + paramWeiYunFileInfo.jdField_a_of_type_Int);
      if ((!TextUtils.isEmpty(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramWeiYunFileInfo.c))) {
        break;
      }
      QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "sendWeiYun2Dataline onFailed: weiyunID is null[" + TextUtils.isEmpty(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString) + "], fileName is Null[" + TextUtils.isEmpty(paramWeiYunFileInfo.c) + "]");
    } while (paramauah == null);
    paramauah.a(-2, "no_weiyunid_or_filename");
    return;
    WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq localCrossBidProxyCopyFileToOtherBidMsgReq = new WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq();
    if (paramWeiYunFileInfo.c != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_name.set(paramWeiYunFileInfo.c);
    }
    localCrossBidProxyCopyFileToOtherBidMsgReq.file_size.set(paramWeiYunFileInfo.jdField_a_of_type_Long);
    if (paramWeiYunFileInfo.j != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_sha.set(bnau.a(paramWeiYunFileInfo.j));
    }
    if (paramWeiYunFileInfo.i != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_md5.set(bnau.a(paramWeiYunFileInfo.i));
    }
    for (;;)
    {
      if (paramWeiYunFileInfo.jdField_a_of_type_JavaLangString != null) {
        localCrossBidProxyCopyFileToOtherBidMsgReq.src_file_id.set(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      }
      if (paramWeiYunFileInfo.b != null) {
        localCrossBidProxyCopyFileToOtherBidMsgReq.src_pdir_key.set(bnau.a(paramWeiYunFileInfo.b));
      }
      localCrossBidProxyCopyFileToOtherBidMsgReq.src_bid.set(25);
      localCrossBidProxyCopyFileToOtherBidMsgReq.src_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      localCrossBidProxyCopyFileToOtherBidMsgReq.src_group.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      localCrossBidProxyCopyFileToOtherBidMsgReq.dst_bid.set(38);
      localCrossBidProxyCopyFileToOtherBidMsgReq.dst_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      localCrossBidProxyCopyFileToOtherBidMsgReq.user_type.set(0);
      bmyx.a(localCrossBidProxyCopyFileToOtherBidMsgReq, new auac(this, paramauah));
      return;
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_md5.set(bnau.a(""));
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd");
    }
    if (!bgnt.d(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd : network error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 45, new Object[] { Integer.valueOf(0), BaseApplication.getContext().getString(2131693946) });
      return;
    }
    WeiyunPB.PwdVerifyMsgReq localPwdVerifyMsgReq = new WeiyunPB.PwdVerifyMsgReq();
    paramString = Utils.bytes2HexStr(Utils.str2Md5(paramString));
    localPwdVerifyMsgReq.pwd_md5.set(bnau.a(paramString));
    bmyx.a(localPwdVerifyMsgReq, new atzz(this));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "get weiyun file PreviewAddress onFailed, fileId[" + paramString1 + "],dirKey[" + paramString2 + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 278, new Object[] { Integer.valueOf(1810001), anni.a(2131715595), "", "", "", "", Integer.valueOf(0) });
      return;
    }
    WeiyunPB.DiskFileDocDownloadAbsMsgReq localDiskFileDocDownloadAbsMsgReq = new WeiyunPB.DiskFileDocDownloadAbsMsgReq();
    localDiskFileDocDownloadAbsMsgReq.file_id.set(paramString1);
    localDiskFileDocDownloadAbsMsgReq.pdir_key.set(bnau.a(paramString2));
    bmyx.a(localDiskFileDocDownloadAbsMsgReq, new atzw(this));
  }
  
  public void a(List<MessageForPic> paramList, List<MessageForShortVideo> paramList1, auah paramauah)
  {
    WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq localAioPicAndVideoCopyToWeiyunMsgReq = new WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq();
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((MessageForPic)paramList.next()));
      }
    }
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList = paramList1.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((MessageForShortVideo)paramList.next()));
      }
    }
    localAioPicAndVideoCopyToWeiyunMsgReq.pic_video_2qcloud_list.set(localArrayList);
    a(localAioPicAndVideoCopyToWeiyunMsgReq, paramauah);
  }
  
  public boolean a()
  {
    return bmyx.a();
  }
  
  public String b(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramInt, false, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzu
 * JD-Core Version:    0.7.0.1
 */