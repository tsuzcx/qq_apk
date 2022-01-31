package com.tencent.biz.troop.file;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.weiyun.ResponseHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import oyn;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyCopyToReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ReqBody;
import tencent.im.cs.group_file_common.group_file_common.FeedsInfo;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DeleteFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.MoveFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.CreateFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.DeleteFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RenameFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.ReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileCountReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileInfoReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFilePreviewReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.ReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.ReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.TransFileReqBody;

public class TroopFileProtocol
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, int paramInt6, long paramLong2, int paramInt7, ByteStringMicro paramByteStringMicro, TroopFileProtocol.GetFileListObserver paramGetFileListObserver)
  {
    boolean bool;
    oidb_0x6d8.GetFileListReqBody localGetFileListReqBody;
    if (paramInt7 == 0)
    {
      bool = true;
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileProtocol", 4, "getFileList" + paramLong1 + ",reqFor:" + paramInt2 + ",reqFrom:" + paramInt4 + ",count:" + paramInt3 + ",firstPage:" + bool);
      }
      localGetFileListReqBody = new oidb_0x6d8.GetFileListReqBody();
      localGetFileListReqBody.uint32_all_file_count.set(paramInt1);
      localGetFileListReqBody.uint32_file_count.set(paramInt3);
      localGetFileListReqBody.uint32_req_from.set(paramInt4);
      localGetFileListReqBody.uint64_group_code.set(paramLong1);
      localGetFileListReqBody.uint32_app_id.set(3);
      localGetFileListReqBody.str_folder_id.set(paramString);
      localGetFileListReqBody.uint32_sort_by.set(paramInt5);
      localGetFileListReqBody.uint32_filter_code.set(paramInt6);
      localGetFileListReqBody.uint64_uin.set(paramLong2);
      localGetFileListReqBody.uint32_start_index.set(paramInt7);
      if (paramByteStringMicro != null) {
        break label310;
      }
      localGetFileListReqBody.bytes_context.set(ByteStringMicro.copyFromUtf8(""));
    }
    for (;;)
    {
      paramByteStringMicro = new Bundle();
      paramByteStringMicro.putLong("troopUin", paramLong1);
      paramByteStringMicro.putInt("reqFor", paramInt2);
      paramByteStringMicro.putInt("reqFrom", paramInt4);
      paramByteStringMicro.putBoolean("isFirstPage", bool);
      paramByteStringMicro.putString("parentFileId", paramString);
      paramByteStringMicro.putLong("uin_filter", paramLong2);
      paramString = new oidb_0x6d8.ReqBody();
      paramString.file_list_info_req.set(localGetFileListReqBody);
      ProtoUtils.b(paramQQAppInterface, paramGetFileListObserver, paramString.toByteArray(), "OidbSvc.0x6d8_1", 1752, 1, paramByteStringMicro);
      return;
      bool = false;
      break;
      label310:
      localGetFileListReqBody.bytes_context.set(paramByteStringMicro);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt, String paramString, TroopFileProtocol.GetOneFileInfoObserver paramGetOneFileInfoObserver)
  {
    if ((paramQQAppInterface == null) || (paramLong == 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    oidb_0x6d8.GetFileInfoReqBody localGetFileInfoReqBody = new oidb_0x6d8.GetFileInfoReqBody();
    localGetFileInfoReqBody.uint64_group_code.set(paramLong);
    localGetFileInfoReqBody.uint32_app_id.set(3);
    localGetFileInfoReqBody.uint32_bus_id.set(paramInt);
    localGetFileInfoReqBody.str_file_id.set(paramString);
    paramString = new oidb_0x6d8.ReqBody();
    paramString.file_info_req.set(localGetFileInfoReqBody);
    ProtoUtils.b(paramQQAppInterface, paramGetOneFileInfoObserver, paramString.toByteArray(), "OidbSvc.0x6d8_0", 1752, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, TroopFileProtocol.DeleteFileObserver paramDeleteFileObserver)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1))) {
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
    ProtoUtils.b(paramQQAppInterface, paramDeleteFileObserver, paramString2.toByteArray(), "OidbSvc.0x6d6_3", 1750, 3, (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, TroopFileProtocol.MoveFileObserver paramMoveFileObserver)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    while (paramString2.equals(paramString3)) {
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
    ProtoUtils.b(paramQQAppInterface, paramMoveFileObserver, paramString1.toByteArray(), "OidbSvc.0x6d6_5", 1750, 5);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileProtocol.GetFileCountObserver paramGetFileCountObserver)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileProtocol", 4, "getFileList" + paramLong);
    }
    oidb_0x6d8.GetFileCountReqBody localGetFileCountReqBody = new oidb_0x6d8.GetFileCountReqBody();
    localGetFileCountReqBody.uint64_group_code.set(paramLong);
    localGetFileCountReqBody.uint32_app_id.set(3);
    localGetFileCountReqBody.uint32_bus_id.set(0);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    oidb_0x6d8.ReqBody localReqBody = new oidb_0x6d8.ReqBody();
    localReqBody.group_file_cnt_req.set(localGetFileCountReqBody);
    ProtoUtils.b(paramQQAppInterface, paramGetFileCountObserver, localReqBody.toByteArray(), "OidbSvc.0x6d8_1", 1752, 2, localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileInfo paramTroopFileInfo, TroopFileProtocol.ReqTransFileObserver paramReqTransFileObserver)
  {
    if ((paramLong == 0L) || (paramTroopFileInfo == null)) {
      return;
    }
    oidb_0x6d9.TransFileReqBody localTransFileReqBody = new oidb_0x6d9.TransFileReqBody();
    localTransFileReqBody.uint32_app_id.set(3);
    localTransFileReqBody.uint64_group_code.set(paramLong);
    localTransFileReqBody.uint32_bus_id.set(paramTroopFileInfo.a);
    localTransFileReqBody.str_file_id.set(paramTroopFileInfo.b);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    localBundle.putString("fileId", paramTroopFileInfo.b);
    paramTroopFileInfo = new oidb_0x6d9.ReqBody();
    paramTroopFileInfo.trans_file_req.set(localTransFileReqBody);
    ProtoUtils.b(paramQQAppInterface, paramReqTransFileObserver, paramTroopFileInfo.toByteArray(), "OidbSvc.0x6d9_0", 1753, 0, localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean, TroopFileProtocol.ReqDownloadFileObserver paramReqDownloadFileObserver)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return;
    }
    int i = FileManagerUtil.a(FileUtil.a(paramItem.FileName));
    oidb_0x6d6.DownloadFileReqBody localDownloadFileReqBody = new oidb_0x6d6.DownloadFileReqBody();
    localDownloadFileReqBody.uint32_bus_id.set(paramItem.BusId);
    localDownloadFileReqBody.uint32_app_id.set(3);
    localDownloadFileReqBody.uint64_group_code.set(paramLong);
    localDownloadFileReqBody.str_file_id.set(paramItem.FilePath);
    Object localObject = localDownloadFileReqBody.bool_thumbnail_req;
    boolean bool;
    if (paramInt != 0)
    {
      bool = true;
      label89:
      ((PBBoolField)localObject).set(bool);
      localDownloadFileReqBody.bool_preview_req.set(paramBoolean);
      if (i == 2)
      {
        if (paramInt == 0) {
          break label329;
        }
        localDownloadFileReqBody.bool_thumbnail_req.set(false);
        localDownloadFileReqBody.bool_preview_req.set(true);
      }
    }
    for (;;)
    {
      localDownloadFileReqBody.uint32_url_type.set(0);
      localObject = new Bundle();
      ((Bundle)localObject).putString("itemKey", paramItem.Id.toString());
      ((Bundle)localObject).putLong("troopUin", paramLong);
      ((Bundle)localObject).putInt("thumbNail", paramInt);
      ((Bundle)localObject).putBoolean("isPreview", paramBoolean);
      paramItem = new oidb_0x6d6.ReqBody();
      paramItem.download_file_req.set(localDownloadFileReqBody);
      ProtoUtils.b(paramQQAppInterface, paramReqDownloadFileObserver, paramItem.toByteArray(), "OidbSvc.0x6d6_2", 1750, 2, (Bundle)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(".troop.troop_file_video", 2, "reqDownloadFile:thumbSize=" + paramInt + ", isPreview=" + paramBoolean + ", fileType=" + i + ", bool_thumbnail_req=" + localDownloadFileReqBody.bool_thumbnail_req.get() + ", bool_preview_req=" + localDownloadFileReqBody.bool_preview_req.get());
      return;
      bool = false;
      break label89;
      label329:
      localDownloadFileReqBody.bool_thumbnail_req.set(false);
      localDownloadFileReqBody.bool_preview_req.set(false);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, TroopFileProtocol.ReqFeedsObserver paramReqFeedsObserver)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return;
    }
    Object localObject1 = new group_file_common.FeedsInfo();
    ((group_file_common.FeedsInfo)localObject1).str_file_id.set(paramItem.FilePath);
    ((group_file_common.FeedsInfo)localObject1).uint32_bus_id.set(paramItem.BusId);
    ((group_file_common.FeedsInfo)localObject1).uint32_msg_random.set(paramItem.RandomNum);
    Object localObject2;
    if ((paramItem.width != 0) && (paramItem.height != 0)) {
      localObject2 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject2).put("width", paramItem.width);
      ((JSONObject)localObject2).put("height", paramItem.height);
      ((JSONObject)localObject2).put("duration", paramItem.duration);
      ((group_file_common.FeedsInfo)localObject1).bytes_ext.set(ByteStringMicro.copyFromUtf8(((JSONObject)localObject2).toString()));
      localObject2 = new oidb_0x6d9.FeedsReqBody();
      ((oidb_0x6d9.FeedsReqBody)localObject2).uint32_app_id.set(3);
      ((oidb_0x6d9.FeedsReqBody)localObject2).uint64_group_code.set(paramLong);
      ((oidb_0x6d9.FeedsReqBody)localObject2).rpt_feeds_info_list.add((MessageMicro)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("itemKey", paramItem.Id.toString());
      ((Bundle)localObject1).putLong("troopUin", paramLong);
      ((Bundle)localObject1).putString("fileId", paramItem.FilePath);
      paramItem = new oidb_0x6d9.ReqBody();
      paramItem.feeds_info_req.set((MessageMicro)localObject2);
      ProtoUtils.b(paramQQAppInterface, paramReqFeedsObserver, paramItem.toByteArray(), "OidbSvc.0x6d9_4", 1753, 4, (Bundle)localObject1);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, TroopFileProtocol.ReqResendFileObserver paramReqResendFileObserver)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return;
    }
    Object localObject = new oidb_0x6d6.ResendReqBody();
    ((oidb_0x6d6.ResendReqBody)localObject).uint32_bus_id.set(paramItem.BusId);
    ((oidb_0x6d6.ResendReqBody)localObject).uint32_app_id.set(3);
    ((oidb_0x6d6.ResendReqBody)localObject).uint64_group_code.set(paramLong);
    ((oidb_0x6d6.ResendReqBody)localObject).str_file_id.set(paramItem.FilePath);
    ((oidb_0x6d6.ResendReqBody)localObject).bytes_sha.set(ByteStringMicro.copyFrom(paramItem.Sha));
    oidb_0x6d6.ReqBody localReqBody = new oidb_0x6d6.ReqBody();
    localReqBody.resend_file_req.set((MessageMicro)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putString("itemKey", paramItem.Id.toString());
    ((Bundle)localObject).putLong("troopUin", paramLong);
    ProtoUtils.b(paramQQAppInterface, paramReqResendFileObserver, localReqBody.toByteArray(), "OidbSvc.0x6d6_1", 1750, 1, (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, TroopFileProtocol.ReqUploadFileObserver paramReqUploadFileObserver)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return;
    }
    Object localObject1 = new oidb_0x6d6.UploadFileReqBody();
    ((oidb_0x6d6.UploadFileReqBody)localObject1).uint32_bus_id.set(paramItem.BusId);
    ((oidb_0x6d6.UploadFileReqBody)localObject1).uint32_app_id.set(3);
    ((oidb_0x6d6.UploadFileReqBody)localObject1).uint64_group_code.set(paramLong);
    ((oidb_0x6d6.UploadFileReqBody)localObject1).bytes_md5.set(ByteStringMicro.copyFrom(paramItem.Md5));
    ((oidb_0x6d6.UploadFileReqBody)localObject1).bytes_sha.set(ByteStringMicro.copyFrom(paramItem.Sha));
    Object localObject2;
    if (TextUtils.isEmpty(paramItem.mParentId))
    {
      ((oidb_0x6d6.UploadFileReqBody)localObject1).str_parent_folder_id.set("/");
      ((oidb_0x6d6.UploadFileReqBody)localObject1).str_file_name.set(paramItem.FileName);
      ((oidb_0x6d6.UploadFileReqBody)localObject1).str_local_path.set(paramItem.LocalFile);
      localObject2 = ((oidb_0x6d6.UploadFileReqBody)localObject1).uint32_entrance;
      if (!paramItem.isFromAIO) {
        break label248;
      }
    }
    label248:
    for (int i = 5;; i = 4)
    {
      ((PBUInt32Field)localObject2).set(i);
      ((oidb_0x6d6.UploadFileReqBody)localObject1).uint64_file_size.set(paramItem.ProgressTotal);
      localObject2 = new oidb_0x6d6.ReqBody();
      ((oidb_0x6d6.ReqBody)localObject2).upload_file_req.set((MessageMicro)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("itemKey", paramItem.Id.toString());
      ((Bundle)localObject1).putLong("troopUin", paramLong);
      ProtoUtils.b(paramQQAppInterface, paramReqUploadFileObserver, ((oidb_0x6d6.ReqBody)localObject2).toByteArray(), "OidbSvc.0x6d6_0", 1750, 0, (Bundle)localObject1);
      return;
      ((oidb_0x6d6.UploadFileReqBody)localObject1).str_parent_folder_id.set(paramItem.mParentId);
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt, TroopFileProtocol.GetFilePreviewObserver paramGetFilePreviewObserver)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileProtocol", 4, "getFilePreviewList" + paramLong + ",filePath:" + paramString + ",busId:" + paramInt);
    }
    oidb_0x6d8.GetFilePreviewReqBody localGetFilePreviewReqBody = new oidb_0x6d8.GetFilePreviewReqBody();
    localGetFilePreviewReqBody.uint64_group_code.set(paramLong);
    localGetFilePreviewReqBody.uint32_app_id.set(3);
    localGetFilePreviewReqBody.uint32_bus_id.set(paramInt);
    localGetFilePreviewReqBody.str_file_id.set(paramString);
    paramString = new oidb_0x6d8.ReqBody();
    paramString.file_preview_req.set(localGetFilePreviewReqBody);
    ProtoUtils.b(paramQQAppInterface, paramGetFilePreviewObserver, paramString.toByteArray(), "OidbSvc.0x6d8_4", 1752, 4);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, TroopFileProtocol.DeleteFolderObserver paramDeleteFolderObserver)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    oidb_0x6d7.DeleteFolderReqBody localDeleteFolderReqBody = new oidb_0x6d7.DeleteFolderReqBody();
    localDeleteFolderReqBody.str_folder_id.set(paramString);
    localDeleteFolderReqBody.uint32_app_id.set(3);
    localDeleteFolderReqBody.uint64_group_code.set(paramLong);
    paramString = new oidb_0x6d7.ReqBody();
    paramString.delete_folder_req.set(localDeleteFolderReqBody);
    ProtoUtils.b(paramQQAppInterface, paramDeleteFolderObserver, paramString.toByteArray(), "OidbSvc.0x6d7_1", 1751, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, TroopFileProtocol.CreateFolderObserver paramCreateFolderObserver)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    oidb_0x6d7.CreateFolderReqBody localCreateFolderReqBody = new oidb_0x6d7.CreateFolderReqBody();
    localCreateFolderReqBody.str_parent_folder_id.set(paramString1);
    localCreateFolderReqBody.str_folder_name.set(paramString2);
    localCreateFolderReqBody.uint32_app_id.set(3);
    localCreateFolderReqBody.uint64_group_code.set(paramLong);
    paramString1 = new oidb_0x6d7.ReqBody();
    paramString1.create_folder_req.set(localCreateFolderReqBody);
    ProtoUtils.b(paramQQAppInterface, paramCreateFolderObserver, paramString1.toByteArray(), "OidbSvc.0x6d7_0", 1751, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, TroopFileProtocol.RenameFolderObserver paramRenameFolderObserver)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
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
    ProtoUtils.b(paramQQAppInterface, paramRenameFolderObserver, localReqBody.toByteArray(), "OidbSvc.0x6d7_2", 1751, 2, (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList)
  {
    paramString1 = new HttpWebCgiAsyncTask2("http://" + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + URLUtil.a(paramString4) + "&", "GET", new oyn(new ArrayList(), paramString4, paramFileManagerEntity, paramQQAppInterface, paramInt, paramOnGetZipFileList), 1000, null);
    paramString2 = new Bundle();
    paramString2.putString("version", DeviceInfoUtil.d());
    paramString2.putString("Cookie", paramString5);
    paramString3 = new HashMap();
    paramString3.put("BUNDLE", paramString2);
    paramString3.put("CONTEXT", paramQQAppInterface.getApp().getApplicationContext());
    paramString1.a(paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, long paramLong1, TroopFileTransferManager.Item paramItem, long paramLong2, long paramLong3, TroopFileProtocol.ReqCopyToObserver paramReqCopyToObserver)
  {
    if ((paramLong1 == 0L) || (paramItem == null)) {
      return;
    }
    cmd0x383.ReqBody localReqBody = new cmd0x383.ReqBody();
    localReqBody.uint64_groupcode.set(paramLong1);
    localReqBody.uint32_app_id.set(3);
    cmd0x383.ApplyCopyToReqBody localApplyCopyToReqBody = new cmd0x383.ApplyCopyToReqBody();
    if (paramBoolean) {
      localReqBody.uint64_groupcode.set(paramLong1);
    }
    for (;;)
    {
      localApplyCopyToReqBody.uint64_dst_uin.set(paramLong2);
      localApplyCopyToReqBody.uint32_src_bus_id.set(paramItem.ForwardBusId);
      if (!TextUtils.isEmpty(paramItem.ForwardPath)) {
        localApplyCopyToReqBody.str_src_file_path.set(paramItem.ForwardPath);
      }
      localApplyCopyToReqBody.uint32_dst_bus_id.set(paramItem.BusId);
      Bundle localBundle = new Bundle();
      localBundle.putLong("troopUin", paramLong1);
      localBundle.putString("itemKey", paramItem.Id.toString());
      localBundle.putLong("sessionId", paramLong3);
      localReqBody.msg_copy_to_req_body.set(localApplyCopyToReqBody);
      if (paramItem.BusId == 25) {
        ResponseHandler.a();
      }
      ProtoUtils.a(paramQQAppInterface, paramReqCopyToObserver, localReqBody.toByteArray(), "GroupFileAppSvr.CopyTo", localBundle);
      return;
      localReqBody.uint64_groupcode.set(paramItem.ForwardTroopuin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.TroopFileProtocol
 * JD-Core Version:    0.7.0.1
 */