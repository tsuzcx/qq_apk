package com.tencent.biz.troop.file;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.troop.file.protocol.TroopFileCreateFolderObserver;
import com.tencent.biz.troop.file.protocol.TroopFileDeleteFileObserver;
import com.tencent.biz.troop.file.protocol.TroopFileDeleteFolderObserver;
import com.tencent.biz.troop.file.protocol.TroopFileGetFileCountObserver;
import com.tencent.biz.troop.file.protocol.TroopFileGetFileListObserver;
import com.tencent.biz.troop.file.protocol.TroopFileGetFilePreviewObserver;
import com.tencent.biz.troop.file.protocol.TroopFileGetFileSpaceObserver;
import com.tencent.biz.troop.file.protocol.TroopFileGetOneFileInfoObserver;
import com.tencent.biz.troop.file.protocol.TroopFileMoveFileObserver;
import com.tencent.biz.troop.file.protocol.TroopFileRenameFolderObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqFeedsObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqTransFileObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqUploadFileObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReq;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.haoliyou.JumpShareUtils;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.group_file_common.group_file_common.FeedsInfo;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DeleteFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.MoveFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.CreateFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.DeleteFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RenameFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.ReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileCountReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileInfoReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFilePreviewReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetSpaceReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.ReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.ReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.TransFileReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopFileProtocol
{
  public static ITroopFileProtoReq a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean1, boolean paramBoolean2, TroopFileReqDownloadFileObserver paramTroopFileReqDownloadFileObserver)
  {
    if ((paramLong != 0L) && (paramItem != null))
    {
      int i = FileManagerUtil.c(FileUtil.a(paramItem.FileName));
      oidb_0x6d6.DownloadFileReqBody localDownloadFileReqBody = new oidb_0x6d6.DownloadFileReqBody();
      localDownloadFileReqBody.uint32_bus_id.set(paramItem.BusId);
      localDownloadFileReqBody.uint32_app_id.set(3);
      localDownloadFileReqBody.uint64_group_code.set(paramLong);
      localDownloadFileReqBody.str_file_id.set(paramItem.FilePath);
      Object localObject = localDownloadFileReqBody.bool_thumbnail_req;
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((PBBoolField)localObject).set(bool);
      localDownloadFileReqBody.bool_preview_req.set(paramBoolean1);
      if (i == 2)
      {
        if (paramBoolean2) {
          localDownloadFileReqBody.uint32_src.set(1);
        } else {
          localDownloadFileReqBody.uint32_src.set(0);
        }
        if (paramInt != 0)
        {
          localDownloadFileReqBody.bool_thumbnail_req.set(false);
          localDownloadFileReqBody.bool_preview_req.set(true);
        }
        else
        {
          localDownloadFileReqBody.bool_thumbnail_req.set(false);
          localDownloadFileReqBody.bool_preview_req.set(false);
        }
      }
      localDownloadFileReqBody.uint32_url_type.set(0);
      localObject = new Bundle();
      ((Bundle)localObject).putString("itemKey", paramItem.Id.toString());
      ((Bundle)localObject).putLong("troopUin", paramLong);
      ((Bundle)localObject).putInt("thumbNail", paramInt);
      ((Bundle)localObject).putBoolean("isPreview", paramBoolean1);
      paramItem = new oidb_0x6d6.ReqBody();
      paramItem.download_file_req.set(localDownloadFileReqBody);
      return a(paramQQAppInterface, paramTroopFileReqDownloadFileObserver, paramItem.toByteArray(), "OidbSvc.0x6d6_2", 1750, 2, (Bundle)localObject);
    }
    return null;
  }
  
  public static ITroopFileProtoReq a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, TroopFileReqUploadFileObserver paramTroopFileReqUploadFileObserver)
  {
    if ((paramLong != 0L) && (paramItem != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("itemKey", paramItem.Id.toString());
      localBundle.putLong("troopUin", paramLong);
      localBundle.putBoolean("bExtfTransfer", paramItem.bExtfTransfer);
      return a(paramQQAppInterface, paramLong, paramItem.FileName, paramItem.LocalFile, paramItem.ProgressTotal, paramItem.isFromAIO, paramItem.Md5, paramItem.Sha, paramItem.Sha3, paramItem.BusId, paramItem.mParentId, localBundle, paramTroopFileReqUploadFileObserver);
    }
    return null;
  }
  
  public static ITroopFileProtoReq a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt, TroopFileGetFilePreviewObserver paramTroopFileGetFilePreviewObserver)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFilePreviewList");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",filePath:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",busId:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TroopFileProtocol", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x6d8.GetFilePreviewReqBody();
    ((oidb_0x6d8.GetFilePreviewReqBody)localObject).uint64_group_code.set(paramLong);
    ((oidb_0x6d8.GetFilePreviewReqBody)localObject).uint32_app_id.set(3);
    ((oidb_0x6d8.GetFilePreviewReqBody)localObject).uint32_bus_id.set(paramInt);
    ((oidb_0x6d8.GetFilePreviewReqBody)localObject).str_file_id.set(paramString);
    paramString = new oidb_0x6d8.ReqBody();
    paramString.file_preview_req.set((MessageMicro)localObject);
    return a(paramQQAppInterface, paramTroopFileGetFilePreviewObserver, paramString.toByteArray(), "OidbSvc.0x6d8_4", 1752, 4, null);
  }
  
  public static ITroopFileProtoReq a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString3, int paramInt, String paramString4, Bundle paramBundle, TroopFileReqUploadFileObserver paramTroopFileReqUploadFileObserver)
  {
    oidb_0x6d6.UploadFileReqBody localUploadFileReqBody = new oidb_0x6d6.UploadFileReqBody();
    localUploadFileReqBody.uint32_bus_id.set(paramInt);
    localUploadFileReqBody.uint32_app_id.set(3);
    localUploadFileReqBody.uint64_group_code.set(paramLong1);
    localUploadFileReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    localUploadFileReqBody.bytes_sha.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
    if (paramString3 != null)
    {
      paramArrayOfByte1 = HexUtil.hexStr2Bytes(paramString3);
      localUploadFileReqBody.bytes_sha3.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    }
    if (TextUtils.isEmpty(paramString4)) {
      localUploadFileReqBody.str_parent_folder_id.set("/");
    } else {
      localUploadFileReqBody.str_parent_folder_id.set(paramString4);
    }
    localUploadFileReqBody.str_file_name.set(paramString1);
    localUploadFileReqBody.str_local_path.set(paramString2);
    paramString1 = localUploadFileReqBody.uint32_entrance;
    if (paramBoolean) {
      paramInt = 5;
    } else {
      paramInt = 4;
    }
    paramString1.set(paramInt);
    localUploadFileReqBody.uint64_file_size.set(paramLong2);
    paramBoolean = false;
    if (paramBundle != null) {
      paramBoolean = paramBundle.getBoolean("bExtfTransfer", false);
    }
    if (paramBoolean) {
      localUploadFileReqBody.bool_support_multi_upload.set(true);
    }
    paramString1 = new oidb_0x6d6.ReqBody();
    paramString1.upload_file_req.set(localUploadFileReqBody);
    return a(paramQQAppInterface, paramTroopFileReqUploadFileObserver, paramString1.toByteArray(), "OidbSvc.0x6d6_0", 1750, 0, paramBundle);
  }
  
  private static ITroopFileProtoReq a(QQAppInterface paramQQAppInterface, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.h());
    paramArrayOfByte = ((ITroopFileProtoReqMgr)paramQQAppInterface.getRuntimeService(ITroopFileProtoReqMgr.class, "")).createProtoReq();
    paramArrayOfByte.a(paramString);
    paramArrayOfByte.a(localOIDBSSOPkg.toByteArray());
    paramArrayOfByte.a(paramBundle);
    paramArrayOfByte.a(paramTroopProtocolObserver);
    ((ITroopFileProtoReqMgr)paramQQAppInterface.getRuntimeService(ITroopFileProtoReqMgr.class, "")).sendProtoRequest(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  private static String a(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      if (!ZhuoXusManager.a().l())
      {
        if (QLog.isColorLevel())
        {
          QLog.i("IMG_FILE", 1, "choushane false!");
          return "";
        }
      }
      else
      {
        if (paramItem.strQRUrl != null) {
          return paramItem.strQRUrl;
        }
        String str;
        if (FileUtils.d(paramItem.middleThumbnailFile))
        {
          localObject = new File(paramItem.middleThumbnailFile);
          str = "mid";
        }
        else
        {
          if (!FileUtils.d(paramItem.largeThumbnailFile)) {
            break label185;
          }
          localObject = new File(paramItem.largeThumbnailFile);
          str = "larg";
        }
        Object localObject = JumpShareUtils.a(BaseApplicationImpl.getContext(), (File)localObject);
        if (localObject != null)
        {
          paramItem.strQRUrl = ((StringBuilder)((Pair)localObject).first).toString();
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("reqFeeds getImageUrl success:");
            ((StringBuilder)localObject).append(paramItem.strQRUrl);
            ((StringBuilder)localObject).append(" use:");
            ((StringBuilder)localObject).append(str);
            QLog.i("IMG_FILE_QR", 1, ((StringBuilder)localObject).toString());
          }
          paramItem = paramItem.strQRUrl;
          return paramItem;
          label185:
          return null;
        }
        return "";
      }
    }
    catch (Throwable paramItem)
    {
      return "";
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, int paramInt6, long paramLong2, int paramInt7, ByteStringMicro paramByteStringMicro, TroopFileGetFileListObserver paramTroopFileGetFileListObserver)
  {
    boolean bool;
    if (paramInt7 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFileList");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",reqFor:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",reqFrom:");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(",count:");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(",firstPage:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("TroopFileProtocol", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x6d8.GetFileListReqBody();
    ((oidb_0x6d8.GetFileListReqBody)localObject).uint32_all_file_count.set(paramInt1);
    ((oidb_0x6d8.GetFileListReqBody)localObject).uint32_file_count.set(paramInt3);
    ((oidb_0x6d8.GetFileListReqBody)localObject).uint32_req_from.set(paramInt4);
    ((oidb_0x6d8.GetFileListReqBody)localObject).uint64_group_code.set(paramLong1);
    ((oidb_0x6d8.GetFileListReqBody)localObject).uint32_app_id.set(3);
    ((oidb_0x6d8.GetFileListReqBody)localObject).str_folder_id.set(paramString);
    ((oidb_0x6d8.GetFileListReqBody)localObject).uint32_sort_by.set(paramInt5);
    ((oidb_0x6d8.GetFileListReqBody)localObject).uint32_filter_code.set(paramInt6);
    ((oidb_0x6d8.GetFileListReqBody)localObject).uint64_uin.set(paramLong2);
    ((oidb_0x6d8.GetFileListReqBody)localObject).uint32_start_index.set(paramInt7);
    if (paramByteStringMicro == null) {
      ((oidb_0x6d8.GetFileListReqBody)localObject).bytes_context.set(ByteStringMicro.copyFromUtf8(""));
    } else {
      ((oidb_0x6d8.GetFileListReqBody)localObject).bytes_context.set(paramByteStringMicro);
    }
    if ((paramInt6 != 2) && (paramInt6 != 3)) {
      ((oidb_0x6d8.GetFileListReqBody)localObject).uint32_show_onlinedoc_folder.set(1);
    } else {
      ((oidb_0x6d8.GetFileListReqBody)localObject).uint32_show_onlinedoc_folder.set(0);
    }
    paramByteStringMicro = new Bundle();
    paramByteStringMicro.putLong("troopUin", paramLong1);
    paramByteStringMicro.putInt("reqFor", paramInt2);
    paramByteStringMicro.putInt("reqFrom", paramInt4);
    paramByteStringMicro.putBoolean("isFirstPage", bool);
    paramByteStringMicro.putString("parentFileId", paramString);
    paramByteStringMicro.putLong("uin_filter", paramLong2);
    paramString = new oidb_0x6d8.ReqBody();
    paramString.file_list_info_req.set((MessageMicro)localObject);
    ProtoUtils.b(paramQQAppInterface, paramTroopFileGetFileListObserver, paramString.toByteArray(), "OidbSvc.0x6d8_1", 1752, 1, paramByteStringMicro);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, Bundle paramBundle, TroopFileReqFeedsObserver paramTroopFileReqFeedsObserver)
  {
    a(paramQQAppInterface, paramLong, paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, paramBundle, null, paramTroopFileReqFeedsObserver);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, Bundle paramBundle, msg_ctrl.MsgCtrl paramMsgCtrl, TroopFileReqFeedsObserver paramTroopFileReqFeedsObserver)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("TroopFileProtocol", 1, "reqFeeds error.filePath is null ");
      return;
    }
    group_file_common.FeedsInfo localFeedsInfo = new group_file_common.FeedsInfo();
    localFeedsInfo.str_file_id.set(paramString);
    localFeedsInfo.uint32_bus_id.set(paramInt1);
    localFeedsInfo.uint32_msg_random.set(paramInt2);
    if (paramBoolean) {
      localFeedsInfo.uint32_feed_flag.set(1);
    } else {
      localFeedsInfo.uint32_feed_flag.set(3);
    }
    if (paramMsgCtrl != null) {
      localFeedsInfo.msg_ctrl.set(paramMsgCtrl);
    }
    try
    {
      paramString = new JSONObject();
      if (paramBundle.containsKey("yyb_apk_package_name_key")) {
        paramString.put("yyb_apk_package_name_key", paramBundle.getString("yyb_apk_package_name_key"));
      }
      if (paramBundle.containsKey("yyb_apk_name_key")) {
        paramString.put("yyb_apk_name_key", paramBundle.getString("yyb_apk_name_key"));
      }
      if (paramBundle.containsKey("yyb_apk_icon_url_key")) {
        paramString.put("yyb_apk_icon_url_key", paramBundle.getString("yyb_apk_icon_url_key"));
      }
      if ((paramInt3 != 0) && (paramInt4 != 0))
      {
        paramString.put("width", paramInt3);
        paramString.put("height", paramInt4);
        paramString.put("duration", paramInt5);
      }
      if (paramString.length() > 0) {
        localFeedsInfo.bytes_ext.set(ByteStringMicro.copyFromUtf8(paramString.toString()));
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    paramString = new oidb_0x6d9.FeedsReqBody();
    paramString.uint32_app_id.set(3);
    paramString.uint64_group_code.set(paramLong);
    paramString.rpt_feeds_info_list.add(localFeedsInfo);
    paramMsgCtrl = new oidb_0x6d9.ReqBody();
    paramMsgCtrl.feeds_info_req.set(paramString);
    ProtoUtils.b(paramQQAppInterface, paramTroopFileReqFeedsObserver, paramMsgCtrl.toByteArray(), "OidbSvc.0x6d9_4", 1753, 4, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, String paramString, long paramLong2, int paramInt2, Bundle paramBundle, TroopFileReqCopyToObserver paramTroopFileReqCopyToObserver)
  {
    oidb_0x6d9.CopyToReqBody localCopyToReqBody = new oidb_0x6d9.CopyToReqBody();
    localCopyToReqBody.uint32_app_id.set(3);
    localCopyToReqBody.uint64_group_code.set(paramLong1);
    localCopyToReqBody.uint64_dst_uin.set(paramLong2);
    localCopyToReqBody.uint32_src_bus_id.set(paramInt1);
    localCopyToReqBody.str_src_file_id.set(paramString);
    localCopyToReqBody.uint32_dst_bus_id.set(paramInt2);
    paramString = new oidb_0x6d9.ReqBody();
    paramString.copy_to_req.set(localCopyToReqBody);
    ProtoUtils.b(paramQQAppInterface, paramTroopFileReqCopyToObserver, paramString.toByteArray(), "OidbSvc.0x6d9_2", 1753, 2, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt, String paramString, TroopFileGetOneFileInfoObserver paramTroopFileGetOneFileInfoObserver)
  {
    if ((paramQQAppInterface != null) && (paramLong != 0L))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      oidb_0x6d8.GetFileInfoReqBody localGetFileInfoReqBody = new oidb_0x6d8.GetFileInfoReqBody();
      localGetFileInfoReqBody.uint64_group_code.set(paramLong);
      localGetFileInfoReqBody.uint32_app_id.set(3);
      localGetFileInfoReqBody.uint32_bus_id.set(paramInt);
      localGetFileInfoReqBody.str_file_id.set(paramString);
      paramString = new oidb_0x6d8.ReqBody();
      paramString.file_info_req.set(localGetFileInfoReqBody);
      ProtoUtils.b(paramQQAppInterface, paramTroopFileGetOneFileInfoObserver, paramString.toByteArray(), "OidbSvc.0x6d8_0", 1752, 0);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, TroopFileDeleteFileObserver paramTroopFileDeleteFileObserver)
  {
    if (paramLong != 0L)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      Object localObject = new oidb_0x6d6.DeleteFileReqBody();
      ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_bus_id.set(paramInt1);
      ((oidb_0x6d6.DeleteFileReqBody)localObject).str_file_id.set(paramString1);
      ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_app_id.set(3);
      ((oidb_0x6d6.DeleteFileReqBody)localObject).uint64_group_code.set(paramLong);
      ((oidb_0x6d6.DeleteFileReqBody)localObject).str_parent_folder_id.set(paramString2);
      if (paramInt2 != 0) {
        ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_msgdb_seq.set(paramInt2);
      }
      if (paramInt3 != 0) {
        ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_msg_rand.set(paramInt3);
      }
      paramString2 = new oidb_0x6d6.ReqBody();
      paramString2.delete_file_req.set((MessageMicro)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putString("fileId", paramString1);
      ProtoUtils.b(paramQQAppInterface, paramTroopFileDeleteFileObserver, paramString2.toByteArray(), "OidbSvc.0x6d6_3", 1750, 3, (Bundle)localObject);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, TroopFileMoveFileObserver paramTroopFileMoveFileObserver)
  {
    if ((paramLong != 0L) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if (paramString2.equals(paramString3)) {
        return;
      }
      oidb_0x6d6.MoveFileReqBody localMoveFileReqBody = new oidb_0x6d6.MoveFileReqBody();
      localMoveFileReqBody.uint32_bus_id.set(paramInt);
      localMoveFileReqBody.str_file_id.set(paramString1);
      localMoveFileReqBody.uint32_app_id.set(3);
      localMoveFileReqBody.uint64_group_code.set(paramLong);
      localMoveFileReqBody.str_parent_folder_id.set(paramString2);
      localMoveFileReqBody.str_dest_folder_id.set(paramString3);
      paramString1 = new oidb_0x6d6.ReqBody();
      paramString1.move_file_req.set(localMoveFileReqBody);
      ProtoUtils.b(paramQQAppInterface, paramTroopFileMoveFileObserver, paramString1.toByteArray(), "OidbSvc.0x6d6_5", 1750, 5);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileGetFileCountObserver paramTroopFileGetFileCountObserver)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFileList");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("TroopFileProtocol", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x6d8.GetFileCountReqBody();
    ((oidb_0x6d8.GetFileCountReqBody)localObject).uint64_group_code.set(paramLong);
    ((oidb_0x6d8.GetFileCountReqBody)localObject).uint32_app_id.set(3);
    ((oidb_0x6d8.GetFileCountReqBody)localObject).uint32_bus_id.set(0);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    oidb_0x6d8.ReqBody localReqBody = new oidb_0x6d8.ReqBody();
    localReqBody.group_file_cnt_req.set((MessageMicro)localObject);
    ProtoUtils.b(paramQQAppInterface, paramTroopFileGetFileCountObserver, localReqBody.toByteArray(), "OidbSvc.0x6d8_1", 1752, 2, localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileGetFileSpaceObserver paramTroopFileGetFileSpaceObserver)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFileList");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("TroopFileProtocol", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x6d8.GetSpaceReqBody();
    ((oidb_0x6d8.GetSpaceReqBody)localObject).uint64_group_code.set(paramLong);
    ((oidb_0x6d8.GetSpaceReqBody)localObject).uint32_app_id.set(3);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    oidb_0x6d8.ReqBody localReqBody = new oidb_0x6d8.ReqBody();
    localReqBody.group_space_req.set((MessageMicro)localObject);
    ProtoUtils.a(paramQQAppInterface, paramTroopFileGetFileSpaceObserver, localReqBody.toByteArray(), "OidbSvc.0x6d8_3", 1752, 3, localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileInfo paramTroopFileInfo, TroopFileReqTransFileObserver paramTroopFileReqTransFileObserver)
  {
    if (paramLong != 0L)
    {
      if (paramTroopFileInfo == null) {
        return;
      }
      oidb_0x6d9.TransFileReqBody localTransFileReqBody = new oidb_0x6d9.TransFileReqBody();
      localTransFileReqBody.uint32_app_id.set(3);
      localTransFileReqBody.uint64_group_code.set(paramLong);
      localTransFileReqBody.uint32_bus_id.set(paramTroopFileInfo.f);
      localTransFileReqBody.str_file_id.set(paramTroopFileInfo.c);
      Bundle localBundle = new Bundle();
      localBundle.putLong("troopUin", paramLong);
      localBundle.putString("fileId", paramTroopFileInfo.c);
      paramTroopFileInfo = new oidb_0x6d9.ReqBody();
      paramTroopFileInfo.trans_file_req.set(localTransFileReqBody);
      ProtoUtils.b(paramQQAppInterface, paramTroopFileReqTransFileObserver, paramTroopFileInfo.toByteArray(), "OidbSvc.0x6d9_0", 1753, 0, localBundle);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, TroopFileReqFeedsObserver paramTroopFileReqFeedsObserver)
  {
    if (paramLong != 0L)
    {
      if (paramItem == null) {
        return;
      }
      QLog.i("TroopFileProtocol", 1, "reqFeeds, waterTest.");
      Bundle localBundle = new Bundle();
      localBundle.putString("itemKey", paramItem.Id.toString());
      localBundle.putLong("troopUin", paramLong);
      localBundle.putString("fileId", paramItem.FilePath);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqFeeds, waterTest.pkgName[");
      ((StringBuilder)localObject).append(paramItem.yybApkPackageName);
      ((StringBuilder)localObject).append("]");
      QLog.i("TroopFileProtocol", 1, ((StringBuilder)localObject).toString());
      if (!TextUtils.isEmpty(paramItem.yybApkPackageName)) {
        localBundle.putString("yyb_apk_package_name_key", paramItem.yybApkPackageName);
      }
      if (!TextUtils.isEmpty(paramItem.yybApkName)) {
        localBundle.putString("yyb_apk_name_key", paramItem.yybApkName);
      }
      if (!TextUtils.isEmpty(paramItem.yybApkIconUrl)) {
        localBundle.putString("yyb_apk_icon_url_key", paramItem.yybApkIconUrl);
      }
      localObject = a(paramItem);
      localObject = JumpShareUtils.a(paramItem.LocalFile, paramItem.width, paramItem.height, (String)localObject);
      a(paramQQAppInterface, paramLong, paramItem.BusId, paramItem.FilePath, paramItem.RandomNum, paramItem.width, paramItem.height, paramItem.duration, true, localBundle, (msg_ctrl.MsgCtrl)localObject, paramTroopFileReqFeedsObserver);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, TroopFileDeleteFolderObserver paramTroopFileDeleteFolderObserver)
  {
    if (paramLong != 0L)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      oidb_0x6d7.DeleteFolderReqBody localDeleteFolderReqBody = new oidb_0x6d7.DeleteFolderReqBody();
      localDeleteFolderReqBody.str_folder_id.set(paramString);
      localDeleteFolderReqBody.uint32_app_id.set(3);
      localDeleteFolderReqBody.uint64_group_code.set(paramLong);
      paramString = new oidb_0x6d7.ReqBody();
      paramString.delete_folder_req.set(localDeleteFolderReqBody);
      ProtoUtils.b(paramQQAppInterface, paramTroopFileDeleteFolderObserver, paramString.toByteArray(), "OidbSvc.0x6d7_1", 1751, 1);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, TroopFileCreateFolderObserver paramTroopFileCreateFolderObserver)
  {
    if ((paramLong != 0L) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      oidb_0x6d7.CreateFolderReqBody localCreateFolderReqBody = new oidb_0x6d7.CreateFolderReqBody();
      localCreateFolderReqBody.str_parent_folder_id.set(paramString1);
      localCreateFolderReqBody.str_folder_name.set(paramString2);
      localCreateFolderReqBody.uint32_app_id.set(3);
      localCreateFolderReqBody.uint64_group_code.set(paramLong);
      paramString1 = new oidb_0x6d7.ReqBody();
      paramString1.create_folder_req.set(localCreateFolderReqBody);
      ProtoUtils.b(paramQQAppInterface, paramTroopFileCreateFolderObserver, paramString1.toByteArray(), "OidbSvc.0x6d7_0", 1751, 0);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, TroopFileRenameFolderObserver paramTroopFileRenameFolderObserver)
  {
    if ((paramLong != 0L) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Object localObject = new oidb_0x6d7.RenameFolderReqBody();
      ((oidb_0x6d7.RenameFolderReqBody)localObject).str_folder_id.set(paramString1);
      ((oidb_0x6d7.RenameFolderReqBody)localObject).str_new_folder_name.set(paramString2);
      ((oidb_0x6d7.RenameFolderReqBody)localObject).uint32_app_id.set(3);
      ((oidb_0x6d7.RenameFolderReqBody)localObject).uint64_group_code.set(paramLong);
      oidb_0x6d7.ReqBody localReqBody = new oidb_0x6d7.ReqBody();
      localReqBody.rename_folder_req.set((MessageMicro)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putString("folderId", paramString1);
      ((Bundle)localObject).putString("folderName", paramString2);
      ProtoUtils.b(paramQQAppInterface, paramTroopFileRenameFolderObserver, localReqBody.toByteArray(), "OidbSvc.0x6d7_2", 1751, 2, (Bundle)localObject);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ITroopFileProtoReq paramITroopFileProtoReq)
  {
    if (paramQQAppInterface != null)
    {
      if (paramITroopFileProtoReq == null) {
        return;
      }
      ((ITroopFileProtoReqMgr)paramQQAppInterface.getRuntimeService(ITroopFileProtoReqMgr.class, "")).cancelRequest(paramITroopFileProtoReq);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("/ftn_compress_list/rkey=");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("&filetype=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&path=");
    localStringBuilder.append(URLUtil.c(paramString4));
    localStringBuilder.append("&");
    paramString1 = new HttpWebCgiAsyncTask2(localStringBuilder.toString(), "GET", new TroopFileProtocol.1(new ArrayList(), paramString4, paramFileManagerEntity, paramQQAppInterface, paramInt, paramOnGetZipFileList), 1000, null);
    paramString2 = new Bundle();
    paramString2.putString("version", DeviceInfoUtil.e());
    paramString2.putString("Cookie", paramString5);
    paramString3 = new HashMap();
    paramString3.put("BUNDLE", paramString2);
    paramString3.put("CONTEXT", paramQQAppInterface.getApp().getApplicationContext());
    paramString1.a(paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, long paramLong1, TroopFileTransferManager.Item paramItem, long paramLong2, long paramLong3, TroopFileReqCopyToObserver paramTroopFileReqCopyToObserver)
  {
    if (paramLong1 != 0L)
    {
      if (paramItem == null) {
        return;
      }
      Object localObject = new oidb_0x6d9.CopyToReqBody();
      ((oidb_0x6d9.CopyToReqBody)localObject).uint32_app_id.set(3);
      if (paramBoolean) {
        ((oidb_0x6d9.CopyToReqBody)localObject).uint64_group_code.set(paramLong1);
      } else {
        ((oidb_0x6d9.CopyToReqBody)localObject).uint64_group_code.set(paramItem.ForwardTroopuin);
      }
      ((oidb_0x6d9.CopyToReqBody)localObject).uint64_dst_uin.set(paramLong2);
      ((oidb_0x6d9.CopyToReqBody)localObject).uint32_src_bus_id.set(paramItem.ForwardBusId);
      if (!TextUtils.isEmpty(paramItem.ForwardPath)) {
        ((oidb_0x6d9.CopyToReqBody)localObject).str_src_file_id.set(paramItem.ForwardPath);
      }
      ((oidb_0x6d9.CopyToReqBody)localObject).uint32_dst_bus_id.set(paramItem.BusId);
      oidb_0x6d9.ReqBody localReqBody = new oidb_0x6d9.ReqBody();
      localReqBody.copy_to_req.set((MessageMicro)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putLong("troopUin", paramLong1);
      ((Bundle)localObject).putString("itemKey", paramItem.Id.toString());
      ((Bundle)localObject).putLong("sessionId", paramLong3);
      if (paramItem.BusId == 25) {
        ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).startSave2Weiyun();
      }
      ProtoUtils.b(paramQQAppInterface, paramTroopFileReqCopyToObserver, localReqBody.toByteArray(), "OidbSvc.0x6d9_2", 1753, 2, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.TroopFileProtocol
 * JD-Core Version:    0.7.0.1
 */