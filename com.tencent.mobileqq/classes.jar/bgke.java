import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils.1;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lbfif;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;
import tencent.im.msg.obj_msg.MsgContentInfo;
import tencent.im.msg.obj_msg.MsgContentInfo.MsgFile;
import tencent.im.msg.obj_msg.ObjMsg;

public class bgke
{
  public static int a;
  private static String[] a;
  
  static
  {
    jdField_a_of_type_Int = 48;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "\\", "/", ":", "*", "?", "\"", "<", ">", "|" };
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong2 == 0L) {
      return 0;
    }
    long l1 = paramLong1;
    long l2 = paramLong2;
    if (paramLong1 > paramLong2)
    {
      l1 = paramLong2;
      l2 = paramLong2;
    }
    while (l2 > 2147483647L)
    {
      l2 >>= 1;
      l1 >>= 1;
    }
    return (int)(l1 / l2 * 100.0D);
  }
  
  public static int a(Context paramContext)
  {
    int i = 2;
    int j = NetworkUtil.getSystemNetwork(paramContext);
    if (j == 0) {
      i = 0;
    }
    while ((2 != j) && (3 != j) && (4 != j)) {
      return i;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong)
  {
    int i = a(paramContext);
    if (i == 0) {
      bgjc.a(paramQQAppInterface, paramLong, 106);
    }
    return i;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt, String paramString4, long paramLong2)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramLong1, paramString3, paramInt, paramString4, paramLong2, 0, 0);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt1, String paramString4, long paramLong2, int paramInt2, int paramInt3)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramLong1, paramString3, paramInt1, paramString4, paramLong2, paramInt2, paramInt3, 0);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt1, String paramString4, long paramLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramLong1, paramString3, paramInt1, paramString4, paramLong2, paramInt2, paramInt3, paramInt4, 0L, 0);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt1, String paramString4, long paramLong2, int paramInt2, int paramInt3, int paramInt4, long paramLong3, int paramInt5)
  {
    MessageRecord localMessageRecord = bcsa.a(-2017);
    agfe.a().a(localMessageRecord.uniseq, paramLong3, paramInt5);
    localMessageRecord.selfuin = paramQQAppInterface.getCurrentAccountUin();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramQQAppInterface.getCurrentAccountUin();
    localMessageRecord.msgUid = bcsc.a(paramInt1);
    localMessageRecord.msg = bhfj.a(null);
    localMessageRecord.msgtype = -2017;
    localMessageRecord.isread = true;
    localMessageRecord.issend = 1;
    localMessageRecord.istroop = 1;
    paramString1 = paramQQAppInterface.getMessageFacade().getAIOList(localMessageRecord.senderuin, 1);
    if ((paramString1 != null) && (!paramString1.isEmpty())) {}
    for (localMessageRecord.shmsgseq = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;; localMessageRecord.shmsgseq = Math.abs(new Random().nextInt()))
    {
      localMessageRecord.time = bcrg.a();
      paramString1 = (MessageForTroopFile)localMessageRecord;
      paramString1.fileName = paramString2;
      paramString1.uuid = paramString3;
      paramString1.fileSize = paramLong1;
      paramString1.FromUin = paramString4;
      paramString1.entitySessionId = paramLong2;
      paramString1.width = paramInt2;
      paramString1.height = paramInt3;
      paramString1.duration = paramInt4;
      if (localMessageRecord.isSend()) {
        ((aocy)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageRecord);
      }
      paramString1.serial();
      ThreadManager.post(new TroopFileUtils.1(paramQQAppInterface, localMessageRecord), 8, null, false);
      QLog.i("TroopFile", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(localMessageRecord.uniseq) + "], selfuin[" + auea.e(localMessageRecord.selfuin) + "], frienduin[" + auea.e(localMessageRecord.frienduin) + "], senderuin[" + auea.e(localMessageRecord.senderuin) + "], issend[" + String.valueOf(localMessageRecord.issend) + "], istroop[" + String.valueOf(localMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(localMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(localMessageRecord.msgUid) + "], time[" + String.valueOf(localMessageRecord.time) + "], vipBubbleID[" + String.valueOf(-1) + "]");
      return localMessageRecord.uniseq;
    }
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt1, String paramString4, long paramLong2, int paramInt2, int paramInt3, long paramLong3, int paramInt4)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramLong1, paramString3, paramInt1, paramString4, paramLong2, paramInt2, paramInt3, 0, paramLong3, paramInt4);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, String paramString3, int paramInt1, String paramString4, long paramLong2, long paramLong3, int paramInt2)
  {
    return a(paramQQAppInterface, paramString1, paramString2, paramLong1, paramString3, paramInt1, paramString4, paramLong2, 0, 0, paramLong3, paramInt2);
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 < paramInt1) {
      i = paramInt2;
    }
    for (;;)
    {
      Object localObject = bheg.a(paramString, i);
      try
      {
        paramString = bheg.a(paramString, (BitmapFactory.Options)localObject);
        if (paramString == null)
        {
          localObject = null;
          return localObject;
          i = paramInt1;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        int j;
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TroopFile", 2, "", paramString);
            }
            paramString = null;
          }
          i = paramString.getWidth();
          j = paramString.getHeight();
          if ((i <= 0) || (j <= 0)) {
            return null;
          }
          if (i > paramInt1) {
            break;
          }
          localObject = paramString;
        } while (j <= paramInt2);
        float f = Math.max(paramInt1 / i, paramInt2 / j);
        localObject = new Matrix();
        ((Matrix)localObject).setScale(f, f);
        try
        {
          localObject = Bitmap.createBitmap(paramString, 0, 0, i, j, (Matrix)localObject, true);
          ((Bitmap)localObject).setDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi);
          if (paramString != localObject) {
            paramString.recycle();
          }
          j = ((Bitmap)localObject).getWidth();
          int k = ((Bitmap)localObject).getHeight();
          paramString = new Rect();
          i = j;
          if (j >= paramInt1)
          {
            paramString.left = ((j - paramInt1) / 2);
            i = paramInt1;
          }
          j = k;
          if (k >= paramInt2)
          {
            paramString.top = 0;
            j = paramInt2;
          }
          paramString.bottom = (j + paramString.top);
          paramString.right = (paramString.left + i);
          Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          localBitmap.setDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi);
          if (localBitmap != null) {
            new Canvas(localBitmap).drawBitmap((Bitmap)localObject, paramString, new Rect(0, 0, paramInt1, paramInt2), null);
          }
          ((Bitmap)localObject).recycle();
          return localBitmap;
        }
        catch (Throwable paramString) {}
      }
    }
    return null;
  }
  
  public static bfjs a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt)
  {
    Object localObject = null;
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong1);
    paramQQAppInterface = localObject;
    if (localTroopFileTransferManager != null)
    {
      paramQQAppInterface = localObject;
      if (!TextUtils.isEmpty(paramString1)) {
        paramQQAppInterface = localTroopFileTransferManager.a(UUID.fromString(paramString1));
      }
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      paramString1 = paramQQAppInterface;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = localTroopFileTransferManager.a(paramString2);
      }
    }
    paramQQAppInterface = new bfjs(paramString1);
    if (TextUtils.isEmpty(paramQQAppInterface.g)) {
      paramQQAppInterface.g = paramString3;
    }
    if (paramQQAppInterface.c == 0L) {
      paramQQAppInterface.c = paramLong2;
    }
    if (paramInt != 0) {
      paramQQAppInterface.h = paramInt;
    }
    if (TextUtils.isEmpty(paramQQAppInterface.e)) {
      paramQQAppInterface.e = paramString2;
    }
    return paramQQAppInterface;
  }
  
  public static bfjs a(QQAppInterface paramQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    Object localObject = null;
    if (paramMessageForTroopFile == null) {
      return null;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramMessageForTroopFile.frienduin));
    paramQQAppInterface = (QQAppInterface)localObject;
    if (localTroopFileTransferManager != null)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!TextUtils.isEmpty(paramMessageForTroopFile.uuid)) {
        paramQQAppInterface = localTroopFileTransferManager.a(UUID.fromString(paramMessageForTroopFile.uuid));
      }
    }
    localObject = paramQQAppInterface;
    if (localTroopFileTransferManager != null)
    {
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null)
      {
        localObject = paramQQAppInterface;
        if (!TextUtils.isEmpty(paramMessageForTroopFile.url)) {
          localObject = localTroopFileTransferManager.a(paramMessageForTroopFile.url);
        }
      }
    }
    paramQQAppInterface = new bfjs((bfjs)localObject);
    if (TextUtils.isEmpty(paramQQAppInterface.g)) {
      paramQQAppInterface.g = paramMessageForTroopFile.fileName;
    }
    if (paramQQAppInterface.c == 0L) {
      paramQQAppInterface.c = paramMessageForTroopFile.fileSize;
    }
    if (paramMessageForTroopFile.bisID != 0) {
      paramQQAppInterface.h = paramMessageForTroopFile.bisID;
    }
    if (!TextUtils.isEmpty(paramMessageForTroopFile.url)) {
      paramQQAppInterface.e = paramMessageForTroopFile.url;
    }
    if (!TextUtils.isEmpty(paramMessageForTroopFile.frienduin)) {
      paramQQAppInterface.b = Long.valueOf(paramMessageForTroopFile.frienduin).longValue();
    }
    if (!TextUtils.isEmpty(paramMessageForTroopFile.sha1)) {
      paramQQAppInterface.f = paramMessageForTroopFile.sha1;
    }
    if (paramMessageForTroopFile.uniseq > 0L) {
      paramQQAppInterface.a = paramMessageForTroopFile.uniseq;
    }
    paramQQAppInterface.k = paramMessageForTroopFile.yybApkPackageName;
    paramQQAppInterface.l = paramMessageForTroopFile.yybApkName;
    paramQQAppInterface.m = paramMessageForTroopFile.yybApkIconUrl;
    return paramQQAppInterface;
  }
  
  public static bfjs a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    return a(paramQQAppInterface, paramFileManagerEntity.TroopUin, paramFileManagerEntity.strTroopFileID, paramFileManagerEntity.strTroopFilePath, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.busId);
  }
  
  public static TroopFileData a(obj_msg.ObjMsg paramObjMsg)
  {
    if (paramObjMsg == null) {
      return null;
    }
    if (paramObjMsg.uint32_msg_type.get() != 6L) {
      return null;
    }
    if (!paramObjMsg.msg_content_info.has()) {
      return null;
    }
    TroopFileData localTroopFileData = new TroopFileData();
    if (((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_file_path.has()) {
      localTroopFileData.fileUrl = new String(((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_file_path.get().toByteArray());
    }
    while (TextUtils.isEmpty(localTroopFileData.fileUrl))
    {
      return null;
      QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. bytes_file_path is null");
    }
    if (((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.uint32_bus_id.has()) {
      localTroopFileData.bisID = ((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.uint32_bus_id.get();
    }
    for (;;)
    {
      label219:
      Object localObject;
      if (((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.str_file_name.has())
      {
        localTroopFileData.fileName = ((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.str_file_name.get();
        if (!((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.uint64_file_size.has()) {
          break label586;
        }
        localTroopFileData.lfileSize = ((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.uint64_file_size.get();
        label266:
        if (!((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.int64_dead_time.has()) {
          break label599;
        }
        localTroopFileData.lastTime = ((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.int64_dead_time.get();
        label313:
        if (!((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_file_sha1.has()) {
          break label612;
        }
        localTroopFileData.sha1 = new String(((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_file_sha1.get().toByteArray());
        localTroopFileData.uuid = UUID.nameUUIDFromBytes(localTroopFileData.fileUrl.getBytes()).toString();
        if (((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_ext.has()) {
          localObject = ((obj_msg.MsgContentInfo)paramObjMsg.msg_content_info.get(0)).msg_file.bytes_ext.get().toStringUtf8();
        }
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        localTroopFileData.width = ((JSONObject)localObject).optInt("width");
        localTroopFileData.height = ((JSONObject)localObject).optInt("height");
        localTroopFileData.duration = ((JSONObject)localObject).optInt("duration");
        localTroopFileData.dspFileName = new String(paramObjMsg.bytes_title.get().toByteArray());
        localTroopFileData.dspFileName = auea.a(localTroopFileData.dspFileName);
        if ((paramObjMsg.rpt_bytes_abstact.has()) && (!paramObjMsg.rpt_bytes_abstact.get().isEmpty())) {
          localTroopFileData.dspFileSize = new String(((ByteStringMicro)paramObjMsg.rpt_bytes_abstact.get(0)).toByteArray());
        }
        return localTroopFileData;
        QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. uint32_bus_id is null");
        continue;
        QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. str_file_name is null");
        break label219;
        label586:
        QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. uint64_file_size is null");
        break label266;
        label599:
        QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. int64_dead_time is null");
        break label313;
        label612:
        QLog.w("TroopFileUtils<QFile>", 1, "decodeTroopFileData. bytes_file_sha1 is null");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    DecimalFormat localDecimalFormat = new DecimalFormat("##0.0");
    double d1 = 1024.0D * 1024.0D;
    double d2 = 1024.0D * d1;
    if (paramLong < d1) {
      return localDecimalFormat.format(paramLong / 1024.0D) + "K";
    }
    if (paramLong < d2) {
      return localDecimalFormat.format(paramLong / d1) + "M";
    }
    return localDecimalFormat.format(paramLong / d2) + "G";
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    paramLong = 1000L * paramLong;
    long l = System.currentTimeMillis();
    if (paramLong <= l) {
      return paramContext.getString(2131697064);
    }
    paramLong = (paramLong - l) / 86400000L;
    return paramLong + 1L + paramContext.getString(2131697037);
  }
  
  public static String a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = "";
    }
    int i;
    do
    {
      do
      {
        return localObject;
        i = paramString.lastIndexOf(".");
        if (i == -1) {
          break;
        }
        localObject = paramString;
      } while (i <= 9);
      if (i != -1) {
        break;
      }
      localObject = paramString;
    } while (paramString.length() <= 13);
    String str;
    if (i == -1)
    {
      str = "";
      localObject = paramString;
      paramString = str;
    }
    for (;;)
    {
      localObject = ((String)localObject).substring(0, 3) + "..." + ((String)localObject).substring(((String)localObject).length() - 3);
      return (String)localObject + paramString;
      localObject = paramString.substring(i);
      str = paramString.substring(0, i);
      paramString = (String)localObject;
      localObject = str;
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {}
    for (;;)
    {
      return;
      Object localObject = new HashMap();
      Iterator localIterator = paramList.iterator();
      long l;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label137;
        }
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        l = Long.parseLong(localChatMessage.frienduin);
        paramList = (List)((Map)localObject).get(Long.valueOf(l));
        paramActivity = paramList;
        if (paramList == null)
        {
          paramActivity = new ArrayList();
          ((Map)localObject).put(Long.valueOf(l), paramActivity);
        }
        paramList = a(paramQQAppInterface, (MessageForTroopFile)localChatMessage);
        if ((paramList == null) || (paramList.e == null)) {
          break;
        }
        paramActivity.add(paramList);
      }
      label137:
      paramActivity = ((Map)localObject).entrySet().iterator();
      while (paramActivity.hasNext())
      {
        paramList = (Map.Entry)paramActivity.next();
        l = ((Long)paramList.getKey()).longValue();
        paramList = (List)paramList.getValue();
        localObject = TroopFileTransferManager.a(paramQQAppInterface, l);
        if (localObject != null) {
          ((TroopFileTransferManager)localObject).a(paramList);
        }
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForTroopFile))) {}
    while (TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramChatMessage.frienduin)) == null) {
      return;
    }
    paramChatMessage = (MessageForTroopFile)paramChatMessage;
    aufd.a(paramQQAppInterface, paramContext, Long.parseLong(paramChatMessage.frienduin), paramChatMessage.uuid, paramChatMessage.url, paramChatMessage.fileName, paramChatMessage.fileSize, paramChatMessage.bisID);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    bgjc.a(paramQQAppInterface, paramLong, 106);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, List<bfif> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      Object localObject2 = new HashMap();
      Iterator localIterator = paramList.iterator();
      Object localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label132;
        }
        bfif localbfif = (bfif)localIterator.next();
        localObject1 = (List)((Map)localObject2).get(Long.valueOf(paramLong));
        paramList = (List<bfif>)localObject1;
        if (localObject1 == null)
        {
          paramList = new ArrayList();
          ((Map)localObject2).put(Long.valueOf(paramLong), paramList);
        }
        localObject1 = aufd.a(paramQQAppInterface, paramLong, localbfif);
        if ((localObject1 == null) || (((bfjs)localObject1).e == null)) {
          break;
        }
        paramList.add(localObject1);
      }
      label132:
      paramList = ((Map)localObject2).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject1 = (Map.Entry)paramList.next();
        paramLong = ((Long)((Map.Entry)localObject1).getKey()).longValue();
        localObject1 = (List)((Map.Entry)localObject1).getValue();
        localObject2 = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
        if (localObject2 != null) {
          ((TroopFileTransferManager)localObject2).a((List)localObject1);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean, long paramLong1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, long paramLong2, long paramLong3, String paramString6, String paramString7, int paramInt2)
  {
    long l1 = paramLong1;
    if (paramLong1 == 0L) {
      l1 = System.currentTimeMillis();
    }
    long l2;
    label34:
    int i;
    if (l1 < 1L)
    {
      paramLong1 = 0L;
      if (paramLong1 > 0L) {
        break label482;
      }
      paramLong1 = 0L;
      l2 = 0L;
      i = HttpUtil.getNetWorkType();
      if ((i >= AppConstants.NET_TYPE_NAME.length) || (i < 0)) {
        break label503;
      }
    }
    label482:
    label503:
    for (String str = AppConstants.NET_TYPE_NAME[i];; str = "NONE")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("netType", str);
      localHashMap.put("serverip", String.valueOf(paramString2));
      localHashMap.put("troopUin", String.valueOf(paramString3));
      localHashMap.put("filePath", paramString5);
      localHashMap.put("errorCode", String.valueOf(paramInt1));
      localHashMap.put("transferedSize", String.valueOf(paramLong2));
      localHashMap.put("fileSize", String.valueOf(paramLong3));
      localHashMap.put("url", String.valueOf(paramString6));
      localHashMap.put("rspHeader", String.valueOf(paramString7));
      localHashMap.put("retry", String.valueOf(paramInt2));
      if (paramBoolean == true) {}
      for (i = 0;; i = 1)
      {
        bdla.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "troop_troopfile", paramString1, 0, i, paramString3, paramString4, paramLong1 + "KB/s", localHashMap.toString());
        if (QLog.isColorLevel()) {
          QLog.d("BizTechReport", 2, "ReportTransferFailedInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(paramBoolean) + "], errorCode[" + String.valueOf(paramInt1) + "], startTime[" + String.valueOf(l1) + "], duration[" + String.valueOf(l2) + "],  transferSize[" + String.valueOf(paramLong2) + "], fileSize[" + String.valueOf(paramLong3) + "], fileType[" + paramString4 + "], netType[" + str + "], fileTransferSpeed[" + String.valueOf(paramLong1) + " KB/s], serverip[" + paramString2 + "], url[" + String.valueOf(paramString6) + "], rspHeader[" + String.valueOf(paramString7) + "], retryTimes[" + String.valueOf(paramInt2) + "]");
        }
        return;
        paramLong1 = System.currentTimeMillis() - l1;
        break;
        long l3 = paramLong2 / paramLong1;
        l2 = paramLong1;
        paramLong1 = l3;
        break label34;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_troop_up", false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramLong + "");
    return (localTroopInfo != null) && (((localTroopInfo.troopowneruin != null) && (paramQQAppInterface.getCurrentAccountUin().equals(localTroopInfo.troopowneruin))) || ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(paramQQAppInterface.getCurrentAccountUin()))));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.contains(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: iload_2
    //   5: iload_3
    //   6: invokestatic 957	bgke:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   9: astore 6
    //   11: aload 6
    //   13: ifnonnull +10 -> 23
    //   16: iload 5
    //   18: istore 4
    //   20: iload 4
    //   22: ireturn
    //   23: new 959	java/io/File
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 960	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 963	java/io/File:exists	()Z
    //   36: ifeq +8 -> 44
    //   39: aload_0
    //   40: invokevirtual 966	java/io/File:delete	()Z
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 969	java/io/File:createNewFile	()Z
    //   48: pop
    //   49: new 971	java/io/BufferedOutputStream
    //   52: dup
    //   53: new 973	java/io/FileOutputStream
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 976	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 979	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: astore_1
    //   65: aload_1
    //   66: astore_0
    //   67: aload 6
    //   69: getstatic 985	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   72: bipush 100
    //   74: aload_1
    //   75: invokevirtual 989	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   78: pop
    //   79: aload_1
    //   80: astore_0
    //   81: aload 6
    //   83: invokevirtual 364	android/graphics/Bitmap:recycle	()V
    //   86: iconst_1
    //   87: istore 5
    //   89: iload 5
    //   91: istore 4
    //   93: aload_1
    //   94: ifnull -74 -> 20
    //   97: aload_1
    //   98: invokevirtual 992	java/io/BufferedOutputStream:flush	()V
    //   101: aload_1
    //   102: invokevirtual 995	java/io/BufferedOutputStream:close	()V
    //   105: iconst_1
    //   106: ireturn
    //   107: astore_0
    //   108: iload 5
    //   110: istore 4
    //   112: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq -95 -> 20
    //   118: ldc_w 997
    //   121: iconst_2
    //   122: new 227	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 999
    //   132: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_0
    //   136: invokevirtual 1000	java/io/IOException:toString	()Ljava/lang/String;
    //   139: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 1002	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: iconst_1
    //   149: ireturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 1003	java/io/IOException:printStackTrace	()V
    //   155: goto -106 -> 49
    //   158: astore_0
    //   159: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq -61 -> 101
    //   165: ldc_w 997
    //   168: iconst_2
    //   169: new 227	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 999
    //   179: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: invokevirtual 1000	java/io/IOException:toString	()Ljava/lang/String;
    //   186: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 1002	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: goto -94 -> 101
    //   198: astore 6
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_1
    //   203: astore_0
    //   204: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +36 -> 243
    //   210: aload_1
    //   211: astore_0
    //   212: ldc_w 997
    //   215: iconst_2
    //   216: new 227	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 999
    //   226: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 6
    //   231: invokevirtual 1004	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   234: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 1002	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: iload 5
    //   245: istore 4
    //   247: aload_1
    //   248: ifnull -228 -> 20
    //   251: aload_1
    //   252: invokevirtual 992	java/io/BufferedOutputStream:flush	()V
    //   255: aload_1
    //   256: invokevirtual 995	java/io/BufferedOutputStream:close	()V
    //   259: iconst_0
    //   260: ireturn
    //   261: astore_0
    //   262: iload 5
    //   264: istore 4
    //   266: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -249 -> 20
    //   272: ldc_w 997
    //   275: iconst_2
    //   276: new 227	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 999
    //   286: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_0
    //   290: invokevirtual 1000	java/io/IOException:toString	()Ljava/lang/String;
    //   293: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 1002	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: iconst_0
    //   303: ireturn
    //   304: astore_0
    //   305: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq -53 -> 255
    //   311: ldc_w 997
    //   314: iconst_2
    //   315: new 227	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 999
    //   325: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_0
    //   329: invokevirtual 1000	java/io/IOException:toString	()Ljava/lang/String;
    //   332: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 1002	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: goto -86 -> 255
    //   344: astore_1
    //   345: aconst_null
    //   346: astore_0
    //   347: aload_0
    //   348: ifnull +11 -> 359
    //   351: aload_0
    //   352: invokevirtual 992	java/io/BufferedOutputStream:flush	()V
    //   355: aload_0
    //   356: invokevirtual 995	java/io/BufferedOutputStream:close	()V
    //   359: aload_1
    //   360: athrow
    //   361: astore 6
    //   363: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq -11 -> 355
    //   369: ldc_w 997
    //   372: iconst_2
    //   373: new 227	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 999
    //   383: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 6
    //   388: invokevirtual 1000	java/io/IOException:toString	()Ljava/lang/String;
    //   391: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 1002	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: goto -45 -> 355
    //   403: astore_0
    //   404: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq -48 -> 359
    //   410: ldc_w 997
    //   413: iconst_2
    //   414: new 227	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 999
    //   424: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_0
    //   428: invokevirtual 1000	java/io/IOException:toString	()Ljava/lang/String;
    //   431: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 1002	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: goto -81 -> 359
    //   443: astore_1
    //   444: goto -97 -> 347
    //   447: astore 6
    //   449: goto -247 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	paramString1	String
    //   0	452	1	paramString2	String
    //   0	452	2	paramInt1	int
    //   0	452	3	paramInt2	int
    //   18	247	4	bool1	boolean
    //   1	262	5	bool2	boolean
    //   9	73	6	localBitmap	Bitmap
    //   198	32	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   361	26	6	localIOException	java.io.IOException
    //   447	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   101	105	107	java/io/IOException
    //   44	49	150	java/io/IOException
    //   97	101	158	java/io/IOException
    //   49	65	198	java/io/FileNotFoundException
    //   255	259	261	java/io/IOException
    //   251	255	304	java/io/IOException
    //   49	65	344	finally
    //   351	355	361	java/io/IOException
    //   355	359	403	java/io/IOException
    //   67	79	443	finally
    //   81	86	443	finally
    //   204	210	443	finally
    //   212	243	443	finally
    //   67	79	447	java/io/FileNotFoundException
    //   81	86	447	java/io/FileNotFoundException
  }
  
  public static String b(String paramString)
  {
    int k = paramString.length();
    char[] arrayOfChar = paramString.toCharArray();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < k)
    {
      int m = paramString.codePointAt(i);
      int j;
      if (EmotcationConstants.EMOJI_MAP.get(m, -1) < 0)
      {
        localStringBuilder.append(arrayOfChar[i]);
        j = i;
      }
      for (;;)
      {
        i = j + 1;
        break;
        j = i;
        if (m > 65535)
        {
          j = i;
          if (k >= i + 2) {
            j = i + 1;
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForTroopFile))) {}
    TroopFileTransferManager localTroopFileTransferManager;
    do
    {
      do
      {
        return;
        localTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
      } while (localTroopFileTransferManager == null);
      paramQQAppInterface = a(paramQQAppInterface, (MessageForTroopFile)paramChatMessage);
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.e == null));
    audr.d(paramContext.getString(2131692595));
    localTroopFileTransferManager.a(paramQQAppInterface.e, paramQQAppInterface.g, paramQQAppInterface.c, paramQQAppInterface.h);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_troop_down", false);
  }
  
  public static boolean b(String paramString)
  {
    return paramString.trim().length() == 0;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_troopzip_down", false);
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("file_config_" + paramQQAppInterface.getCurrentUin(), 0).getBoolean("https_troop_thumb", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgke
 * JD-Core Version:    0.7.0.1
 */