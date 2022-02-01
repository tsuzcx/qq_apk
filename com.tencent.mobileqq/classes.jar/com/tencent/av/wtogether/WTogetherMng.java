package com.tencent.av.wtogether;

import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.BusinessHandlerFactory;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.core.JniSimpleInfoMng;
import com.tencent.av.opengl.effects.TipsInfo;
import com.tencent.av.smallscreen.SmallScreenDialogActivity;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.data.ReqComResult;
import com.tencent.av.wtogether.data.ReqVideoAction;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTInfoFromPush;
import com.tencent.av.wtogether.data.WTReqUrlResult;
import com.tencent.av.wtogether.data.WTSyncPlayInfo;
import com.tencent.av.wtogether.data.WTVideoInfo;
import com.tencent.av.wtogether.data.WTogetherPlayInfo;
import com.tencent.av.wtogether.data.WTogetherRoom;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import trpc.qq_av_together.common.WTogetherCommon.PushMsg;
import trpc.qq_av_together.common.WTogetherCommon.RoomInfo;

public class WTogetherMng
  extends BusinessManager
  implements Handler.Callback
{
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, WatchTogetherInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
  
  public WTogetherMng(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private SessionInfo a(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    Object localObject = null;
    if (paramInt == 2) {
      paramInt = 3;
    }
    for (paramString = String.valueOf(paramLong2);; paramString = null)
    {
      String str = SessionMgr.a(paramInt, paramString, new int[0]);
      paramString = SessionMgr.a().a();
      if (!TextUtils.equals(paramString.jdField_c_of_type_JavaLangString, str)) {
        paramString = localObject;
      }
      for (;;)
      {
        if ((paramString != null) && (paramString.b() != paramLong1) && (QLog.isColorLevel())) {
          QLog.i("WTogether.Mng", 2, "getSessionInfo, [" + paramString.b() + "," + paramLong1 + "]");
        }
        return paramString;
      }
      paramInt = 0;
    }
  }
  
  private WatchTogetherInfo a(int paramInt, long paramLong)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        WatchTogetherInfo localWatchTogetherInfo = (WatchTogetherInfo)((Map.Entry)localIterator.next()).getValue();
        if ((localWatchTogetherInfo != null) && (localWatchTogetherInfo.b() == paramInt))
        {
          long l = localWatchTogetherInfo.a();
          if (l == paramLong) {
            return localWatchTogetherInfo;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      return null;
    }
    return null;
  }
  
  private WatchTogetherInfo a(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    if (TextUtils.equals(String.valueOf(paramLong2), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, paramString + ", self receive start push. [roomType: " + paramInt + ", roomId: " + paramLong1 + "]");
      }
      localObject = null;
      return localObject;
    }
    Object localObject = a(paramInt, paramLong1, paramLong2, paramString);
    if ((localObject == null) || (((SessionInfo)localObject).f()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, paramString + ", session is illegal. [roomType: " + paramInt + ", roomId: " + paramLong1 + "]");
      }
      return null;
    }
    WTInfoFromPush localWTInfoFromPush = new WTInfoFromPush(paramInt, paramLong1, paramLong2, paramString);
    paramString = b((SessionInfo)localObject);
    if (paramString == null) {
      paramString = a((SessionInfo)localObject);
    }
    for (;;)
    {
      localObject = paramString;
      if (paramString == null) {
        break;
      }
      paramString.a(1, "getWatchTogetherInfoForPush");
      paramString.a(paramInt, paramLong1);
      return paramString;
      if (a(localWTInfoFromPush))
      {
        localObject = paramString.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
        if ((localObject != null) && (((WTogetherRoom)localObject).a() == 1) && (((WTogetherRoom)localObject).b() == 1)) {
          paramString.jdField_a_of_type_ComTencentAvWtogetherDataWTInfoFromPush = localWTInfoFromPush;
        }
        for (;;)
        {
          paramString = null;
          break;
          if (localObject != null) {
            a(localWTInfoFromPush);
          }
        }
      }
    }
  }
  
  private WatchTogetherInfo a(int paramInt, String paramString, boolean paramBoolean)
  {
    String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    String str1 = SessionMgr.a(paramInt, paramString, new int[0]);
    Object localObject = (WatchTogetherInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
    if ((localObject == null) && (paramBoolean)) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        WatchTogetherInfo localWatchTogetherInfo = (WatchTogetherInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
        localObject = localWatchTogetherInfo;
        if (localWatchTogetherInfo == null)
        {
          localObject = new WatchTogetherInfo(str2, str1, paramInt, paramString);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localObject);
        }
        return localObject;
      }
    }
    return localObject;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = a(paramInt, paramLong1, paramLong2, "onReceiveStartPush");
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label81;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onReceiveStartPush, illegal. [roomType: " + paramInt + ", roomId: " + paramLong1 + "]");
      }
    }
    label81:
    do
    {
      return;
      localObject = ((WatchTogetherInfo)localObject).a();
      break;
      if (((WTogetherRoom)localObject).a() == 0)
      {
        ((WTogetherRoom)localObject).a(String.valueOf(paramLong2));
        b(a(paramInt, paramLong1));
        return;
      }
    } while (!TextUtils.equals(((WTogetherRoom)localObject).jdField_b_of_type_JavaLangString, String.valueOf(paramLong2)));
    a((WTogetherRoom)localObject, 6);
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    WatchTogetherInfo localWatchTogetherInfo = a(paramInt1, paramLong1);
    if ((localWatchTogetherInfo != null) && (!TextUtils.equals(String.valueOf(paramLong2), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))) {
      a(localWatchTogetherInfo.a(), paramInt2);
    }
    if ((paramInt2 == 2) || (paramInt2 == 3)) {
      if (localWatchTogetherInfo == null) {
        b((WTogetherRoom)localObject1, 2131695972);
      }
    }
    do
    {
      return;
      localObject1 = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
      break;
      if (paramInt2 == 4)
      {
        if (localWatchTogetherInfo == null) {}
        for (localObject1 = localObject2;; localObject1 = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
        {
          b((WTogetherRoom)localObject1, 2131695970);
          return;
        }
      }
    } while (paramInt2 != 1);
    if (localWatchTogetherInfo == null) {}
    for (localObject1 = localObject3;; localObject1 = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
    {
      b((WTogetherRoom)localObject1, 2131695989);
      return;
    }
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onReceiveUserEnterOrLeave, [roomType: " + paramInt + ", roomId: " + paramLong1 + ", operator: " + paramLong2 + ", seq: " + paramLong3 + ", enter: " + paramBoolean + "]");
    }
    ReqComResult localReqComResult = new ReqComResult(paramInt, paramLong1);
    localReqComResult.jdField_a_of_type_Boolean = paramBoolean;
    localReqComResult.jdField_a_of_type_JavaLangString = String.valueOf(paramLong2);
    WTogetherHandler localWTogetherHandler = (WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e);
    if (localWTogetherHandler != null) {
      localWTogetherHandler.notifyUI(10, localReqComResult.jdField_a_of_type_Boolean, localReqComResult);
    }
  }
  
  private void a(long paramLong, String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(5))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 5;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(localMessage, paramLong);
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "tryEnterRoomLater, from[" + paramString + "]");
    }
  }
  
  private void a(ReqComResult paramReqComResult, WatchTogetherInfo paramWatchTogetherInfo, WTogetherRoom paramWTogetherRoom, String paramString)
  {
    if ((paramReqComResult == null) || (paramWatchTogetherInfo == null) || (paramWTogetherRoom == null)) {}
    for (;;)
    {
      return;
      if ((!paramReqComResult.jdField_a_of_type_Boolean) && (paramReqComResult.jdField_b_of_type_Int == 1009)) {
        a(paramWatchTogetherInfo, 7, "checkError");
      }
      while ((!paramReqComResult.jdField_a_of_type_Boolean) && (QLog.isColorLevel()))
      {
        QLog.i("WTogether.Mng", 2, "checkError, errCode[" + paramReqComResult.jdField_b_of_type_Int + "], from[" + paramString + "]");
        return;
        if ((!paramReqComResult.jdField_a_of_type_Boolean) && (paramReqComResult.jdField_b_of_type_Int == 1007)) {
          a(paramWatchTogetherInfo, 5, "checkError");
        }
      }
    }
  }
  
  private void a(WTInfoFromPush paramWTInfoFromPush)
  {
    if (paramWTInfoFromPush == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramWTInfoFromPush = a(paramWTInfoFromPush.jdField_a_of_type_Int, paramWTInfoFromPush.jdField_a_of_type_Long, paramWTInfoFromPush.jdField_b_of_type_Long, "dealForRoomIdConflict");
        } while (paramWTInfoFromPush == null);
        paramWTInfoFromPush = b(paramWTInfoFromPush);
      } while ((paramWTInfoFromPush == null) || (paramWTInfoFromPush.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom == null));
      a(paramWTInfoFromPush, 6, "dealForRoomIdConflict");
      a(BaseApplicationImpl.getContext().getString(2131695998), 100L);
    } while (!QLog.isColorLevel());
    QLog.i("WTogether.Mng", 2, "dealForRoomIdConflict");
  }
  
  private void a(WTogetherPlayInfo paramWTogetherPlayInfo, String paramString)
  {
    if ((paramWTogetherPlayInfo != null) && (paramWTogetherPlayInfo.jdField_a_of_type_ArrayOfBoolean[2] == 0))
    {
      paramWTogetherPlayInfo.jdField_a_of_type_ArrayOfBoolean[2] = true;
      b(BaseApplicationImpl.getContext().getString(2131695986), true);
      AVUtil.a("0X800B8B6", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "showResourceExpire, from[" + paramString + "]");
      }
    }
  }
  
  private void a(WTogetherPlayInfo paramWTogetherPlayInfo, boolean paramBoolean, String paramString)
  {
    boolean[] arrayOfBoolean;
    int i;
    BaseApplication localBaseApplication;
    String str;
    int j;
    if ((paramWTogetherPlayInfo != null) && (paramWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo != null) && (paramWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo.jdField_b_of_type_Int == 1) && (paramWTogetherPlayInfo.jdField_b_of_type_Int <= 3600))
    {
      arrayOfBoolean = paramWTogetherPlayInfo.jdField_a_of_type_ArrayOfBoolean;
      i = paramWTogetherPlayInfo.jdField_b_of_type_Int;
      localBaseApplication = BaseApplicationImpl.getContext();
      str = "";
      paramWTogetherPlayInfo = str;
      if (i <= 0) {
        break label366;
      }
      if (i > 900) {
        break label303;
      }
      paramWTogetherPlayInfo = str;
      if (arrayOfBoolean[0] != 0) {
        break label366;
      }
      if (!paramBoolean) {
        break label281;
      }
      j = i / 60;
      if (j == 0) {
        break label253;
      }
      paramWTogetherPlayInfo = j + "分钟";
    }
    label281:
    for (paramWTogetherPlayInfo = localBaseApplication.getString(2131695987, new Object[] { paramWTogetherPlayInfo });; paramWTogetherPlayInfo = localBaseApplication.getString(2131695987, new Object[] { "15分钟" }))
    {
      arrayOfBoolean[0] = true;
      if (!TextUtils.isEmpty(paramWTogetherPlayInfo))
      {
        b(paramWTogetherPlayInfo, false);
        AVUtil.a("0X800B8B5", 0, 0, i / 60 + "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.i("WTogether.Mng", 2, "showPayedResourceLeftTimeIfNeed, from[" + paramString + "], leftTime[" + i + "], tip[" + paramWTogetherPlayInfo + "]");
        }
      }
      return;
      label253:
      paramWTogetherPlayInfo = i % 60 + "秒";
      break;
    }
    label303:
    paramWTogetherPlayInfo = str;
    if (arrayOfBoolean[1] == 0)
    {
      if (!paramBoolean) {
        break label369;
      }
      j = i / 60;
    }
    label366:
    label369:
    for (paramWTogetherPlayInfo = localBaseApplication.getString(2131695987, new Object[] { j + "分钟" });; paramWTogetherPlayInfo = localBaseApplication.getString(2131695987, new Object[] { "1小时" }))
    {
      arrayOfBoolean[1] = true;
      break;
    }
  }
  
  private void a(WTogetherRoom paramWTogetherRoom)
  {
    if (paramWTogetherRoom == null) {}
    for (WTogetherPlayInfo localWTogetherPlayInfo = null; (localWTogetherPlayInfo == null) || (!localWTogetherPlayInfo.b()) || (paramWTogetherRoom.a() != 3); localWTogetherPlayInfo = paramWTogetherRoom.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onMsgOnChangeFile, illegal param, room[" + paramWTogetherRoom + "]");
      }
      return;
    }
    paramWTogetherRoom = new WTReqUrlResult(paramWTogetherRoom.jdField_a_of_type_Int, paramWTogetherRoom.jdField_b_of_type_Long, 0, localWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo, 1, true);
    paramWTogetherRoom.jdField_a_of_type_JavaLangString = localWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo.jdField_b_of_type_JavaLangString;
    paramWTogetherRoom.jdField_b_of_type_JavaLangString = localWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo.jdField_c_of_type_JavaLangString;
    paramWTogetherRoom.jdField_c_of_type_Boolean = true;
    paramWTogetherRoom.d = 0;
    paramWTogetherRoom.jdField_c_of_type_JavaLangString = null;
    a(paramWTogetherRoom);
    ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).notifyUI(1, true, paramWTogetherRoom);
  }
  
  private void a(WTogetherRoom paramWTogetherRoom, WTogetherCommon.RoomInfo paramRoomInfo, String paramString)
  {
    long l = 200L;
    if ((paramRoomInfo == null) || (paramWTogetherRoom == null)) {}
    for (;;)
    {
      return;
      boolean bool = paramWTogetherRoom.a(paramRoomInfo, paramString);
      paramRoomInfo = paramWTogetherRoom.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo;
      if (paramRoomInfo != null)
      {
        a(paramRoomInfo, bool, paramString);
        if (!paramRoomInfo.a()) {
          break label143;
        }
        if (!bool) {
          break label117;
        }
        paramWTogetherRoom.a(3, 3, paramString);
        a(paramRoomInfo, paramString);
      }
      label143:
      while ((bool) && (QLog.isColorLevel()))
      {
        QLog.i("WTogether.Mng", 2, "updateRoomInfo, from[" + paramString + "], room[" + paramWTogetherRoom + "]");
        return;
        label117:
        if ("onSyncPlayInfo".equalsIgnoreCase(paramString))
        {
          paramWTogetherRoom.a(4, 3, paramString);
          a(paramRoomInfo, paramString);
          continue;
          if (paramRoomInfo.b())
          {
            if (bool)
            {
              paramWTogetherRoom.a(3, 2, paramString);
              paramRoomInfo = Message.obtain();
              paramRoomInfo.what = 3;
              paramRoomInfo.obj = paramWTogetherRoom;
              WeakReferenceHandler localWeakReferenceHandler = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
              if (paramWTogetherRoom.e()) {
                l = 50L;
              }
              localWeakReferenceHandler.sendMessageDelayed(paramRoomInfo, l);
            }
            else if ((paramWTogetherRoom.a() == 3) && (paramWTogetherRoom.b() != 2))
            {
              paramWTogetherRoom.a(3, 2, paramString);
            }
          }
          else if (paramRoomInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_a_of_type_Int == 0)
          {
            paramWTogetherRoom.a(3, 1, paramString);
            paramWTogetherRoom.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_c_of_type_Int = ((int)AudioHelper.b());
            ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).a(paramWTogetherRoom.jdField_a_of_type_Int, paramWTogetherRoom.jdField_b_of_type_Long, paramWTogetherRoom.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_c_of_type_Int, paramWTogetherRoom.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo, true, 0);
          }
          else if (bool)
          {
            paramWTogetherRoom.a(3, 3, paramString);
            a(BaseApplicationImpl.getApplication().getString(2131695969), 200L);
          }
        }
      }
    }
  }
  
  private void a(WatchTogetherInfo paramWatchTogetherInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "quitWatchTogether, reason[" + paramInt + "], from[" + paramString + "]");
    }
    if (paramWatchTogetherInfo == null) {}
    for (paramString = null; paramString == null; paramString = paramWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
    {
      d(paramWatchTogetherInfo);
      return;
    }
    paramWatchTogetherInfo.jdField_b_of_type_Int = paramInt;
    if (paramString.e())
    {
      a(paramWatchTogetherInfo);
      return;
    }
    c(paramWatchTogetherInfo);
  }
  
  private void a(WatchTogetherInfo paramWatchTogetherInfo, String paramString)
  {
    Object localObject2 = null;
    if (paramWatchTogetherInfo == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (!((WTogetherRoom)localObject1).e()); localObject1 = paramWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom) {
      return;
    }
    if (paramWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo != null) {
      if (paramWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_b_of_type_Int == 0)
      {
        paramWatchTogetherInfo.jdField_c_of_type_Int = 4;
        label51:
        if (((WTogetherRoom)localObject1).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo != null) {
          break label166;
        }
      }
    }
    label166:
    for (localObject1 = localObject2;; localObject1 = ((WTogetherRoom)localObject1).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo)
    {
      if ((localObject1 != null) && (((WTFileInfo)localObject1).jdField_a_of_type_Int == 0)) {
        ((WTFileInfo)localObject1).d = paramWatchTogetherInfo.jdField_c_of_type_Int;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("WTogether.Mng", 2, "updateWTFileInfoVideoSrcTypeExtra, from[" + paramString + "], videoSrcTypeExtra[" + paramWatchTogetherInfo.jdField_c_of_type_Int + "]");
      return;
      if (paramWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_b_of_type_Int == 1)
      {
        paramWatchTogetherInfo.jdField_c_of_type_Int = 3;
        break label51;
      }
      paramWatchTogetherInfo.jdField_c_of_type_Int = 0;
      break label51;
      paramWatchTogetherInfo.jdField_c_of_type_Int = 0;
      break label51;
    }
  }
  
  private void a(String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(1))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 10000L);
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "startSync, from[" + paramString + "]");
      }
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    paramString = new WTogetherMng.2(this, paramString);
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(paramString, paramLong);
  }
  
  private void a(WTogetherCommon.PushMsg paramPushMsg)
  {
    if (paramPushMsg == null) {
      return;
    }
    int i = paramPushMsg.room_type.get();
    long l1 = paramPushMsg.room_id.get();
    long l2 = paramPushMsg.operate_uin.get();
    long l3 = paramPushMsg.seq.get();
    int j = paramPushMsg.action_type.get();
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onQavPushMsg, [roomType: " + i + ", roomId: " + l1 + ", operator: " + l2 + ", action: " + j + ", seq: " + l3 + "]");
    }
    switch (j)
    {
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      a(i, l1, l2, l3, j);
      return;
    case 6: 
      a(i, l1, l2);
      return;
    case 7: 
      b(i, l1, l2);
      return;
    case 8: 
      c(i, l1, l2);
      return;
    case 9: 
    case 10: 
      if (j == 9) {}
      for (boolean bool = true;; bool = false)
      {
        a(i, l1, l2, l3, bool);
        return;
      }
    }
    d(i, l1, l2);
  }
  
  private boolean a(SessionInfo paramSessionInfo, ChooseFileInfo paramChooseFileInfo, long[] paramArrayOfLong)
  {
    if ((paramChooseFileInfo == null) || (paramSessionInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "startWatchTogether, illegal param.");
      }
      return false;
    }
    WatchTogetherInfo localWatchTogetherInfo = a(paramSessionInfo);
    if (localWatchTogetherInfo != null) {
      localWatchTogetherInfo.a(paramSessionInfo, true);
    }
    for (paramSessionInfo = localWatchTogetherInfo.a();; paramSessionInfo = null)
    {
      if (paramSessionInfo == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("WTogether.Mng", 2, "startWatchTogether, not valid to create room.");
        return false;
      }
      int i = paramSessionInfo.a();
      if (i != 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("WTogether.Mng", 2, "startWatchTogether, illegal state, roomState[" + i + "]");
        return false;
      }
      localWatchTogetherInfo.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(5);
      e(localWatchTogetherInfo);
      localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = paramChooseFileInfo;
      localWatchTogetherInfo.a(1, "startWatchTogether");
      paramSessionInfo.a(paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramSessionInfo.a(1, 1, "startWatchTogether");
      a(true);
      ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).a(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_b_of_type_Long, paramChooseFileInfo, paramArrayOfLong, 0);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(7);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(7, 30000L);
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "startWatchTogether, room[" + paramSessionInfo + "]");
      }
      return true;
    }
  }
  
  private boolean a(WTInfoFromPush paramWTInfoFromPush)
  {
    if (paramWTInfoFromPush == null) {}
    SessionInfo localSessionInfo;
    WatchTogetherInfo localWatchTogetherInfo;
    WTogetherRoom localWTogetherRoom;
    do
    {
      do
      {
        do
        {
          return false;
          localSessionInfo = a(paramWTInfoFromPush.jdField_a_of_type_Int, paramWTInfoFromPush.jdField_a_of_type_Long, paramWTInfoFromPush.jdField_b_of_type_Long, paramWTInfoFromPush.jdField_a_of_type_JavaLangString);
        } while (localSessionInfo == null);
        localWatchTogetherInfo = b(localSessionInfo);
      } while (localWatchTogetherInfo == null);
      localWTogetherRoom = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
    } while ((localWTogetherRoom == null) || (localWTogetherRoom.a() == 0));
    long l1 = localWatchTogetherInfo.a();
    int i = localWatchTogetherInfo.b();
    long l2 = localSessionInfo.b();
    if ((localWTogetherRoom.e()) && (l1 == l2) && (l1 != 0L) && ((l1 != paramWTInfoFromPush.jdField_a_of_type_Long) || (i != paramWTInfoFromPush.jdField_a_of_type_Int))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((QLog.isColorLevel()) && (bool)) {
        QLog.i("WTogether.Mng", 2, "checkRoomIdConflict, error. come[" + paramWTInfoFromPush.jdField_a_of_type_Int + "," + paramWTInfoFromPush.jdField_a_of_type_Long + "," + paramWTInfoFromPush.jdField_b_of_type_Long + "], cur[" + i + "," + l1 + "," + localWTogetherRoom.jdField_b_of_type_JavaLangString + "]");
      }
      return bool;
    }
  }
  
  private void b()
  {
    Object localObject = SessionMgr.a().a();
    if ((localObject == null) || (((SessionInfo)localObject).f())) {}
    for (;;)
    {
      return;
      localObject = b((SessionInfo)localObject);
      if (localObject == null) {}
      for (localObject = null; (localObject != null) && (((WTogetherRoom)localObject).a() == 4); localObject = ((WatchTogetherInfo)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
      {
        ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).a(((WTogetherRoom)localObject).jdField_a_of_type_Int, ((WTogetherRoom)localObject).jdField_b_of_type_Long, ((WTogetherRoom)localObject).jdField_a_of_type_Long, ((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 10000L);
        return;
      }
    }
  }
  
  private void b(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = a(paramInt, paramLong1);
    if (localObject == null) {}
    for (WTogetherRoom localWTogetherRoom = null; localWTogetherRoom == null; localWTogetherRoom = ((WatchTogetherInfo)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom) {
      return;
    }
    ((WatchTogetherInfo)localObject).jdField_b_of_type_Int = 2;
    if (localWTogetherRoom.e())
    {
      a((WatchTogetherInfo)localObject);
      return;
    }
    localWTogetherRoom.a(5, 1, "onReceiveClosePush");
    localObject = new ReqComResult(localWTogetherRoom.jdField_a_of_type_Int, localWTogetherRoom.jdField_b_of_type_Long);
    b((ReqComResult)localObject);
    ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).notifyUI(8, ((ReqComResult)localObject).jdField_a_of_type_Boolean, localObject);
    b(localWTogetherRoom, 2131695973);
  }
  
  private void b(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString, false);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onMsgClearInfo, info[" + paramString + "]");
    }
    if (paramString == null) {
      return;
    }
    d(paramString);
  }
  
  private void b(WTogetherRoom paramWTogetherRoom, int paramInt)
  {
    if (paramWTogetherRoom == null) {
      return;
    }
    a(BaseApplicationImpl.getContext().getString(paramInt, new Object[] { paramWTogetherRoom.jdField_c_of_type_JavaLangString }), 300L);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(1))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "stopSync, from[" + paramString + "]");
      }
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).notifyUI(11, paramBoolean, paramString);
  }
  
  private void c(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = a(paramInt, paramLong1, paramLong2, "onReceiveChangeFilePush");
    if ((localObject == null) || (!((WatchTogetherInfo)localObject).a())) {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onReceiveChangeFilePush, illegal. [roomType: " + paramInt + ", roomId: " + paramLong1 + "]");
      }
    }
    do
    {
      return;
      localObject = ((WatchTogetherInfo)localObject).a();
      if ((localObject != null) && (((WTogetherRoom)localObject).a() == 0))
      {
        ((WTogetherRoom)localObject).a(String.valueOf(paramLong2));
        b(a(paramInt, paramLong1));
        return;
      }
    } while ((localObject == null) || (!TextUtils.equals(((WTogetherRoom)localObject).jdField_b_of_type_JavaLangString, String.valueOf(paramLong2))));
    a((WTogetherRoom)localObject, 8);
    b((WTogetherRoom)localObject, 2131695968);
  }
  
  private void c(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "updateAVSDKWTogetherFlag, flag[" + paramInt + "], from[" + paramString + "]");
    }
    paramString = VideoController.a().a();
    if (paramString != null) {
      paramString.a(SessionMgr.a().a().d, paramInt, true);
    }
  }
  
  private void d(int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onReceiveSecurityInfo");
    }
    WatchTogetherInfo localWatchTogetherInfo = a(paramInt, paramLong1);
    if (localWatchTogetherInfo == null) {}
    for (Object localObject = null; localObject == null; localObject = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom) {
      return;
    }
    localWatchTogetherInfo.jdField_b_of_type_Int = 8;
    if (((WTogetherRoom)localObject).e()) {
      a(localWatchTogetherInfo);
    }
    for (;;)
    {
      VideoController.a().jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10007) });
      return;
      ((WTogetherRoom)localObject).a(5, 1, "onReceiveClosePush");
      localObject = new ReqComResult(((WTogetherRoom)localObject).jdField_a_of_type_Int, ((WTogetherRoom)localObject).jdField_b_of_type_Long);
      b((ReqComResult)localObject);
      ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).notifyUI(8, ((ReqComResult)localObject).jdField_a_of_type_Boolean, localObject);
    }
  }
  
  private void d(WatchTogetherInfo paramWatchTogetherInfo)
  {
    int i = 1;
    if (paramWatchTogetherInfo == null) {
      return;
    }
    String str = paramWatchTogetherInfo.jdField_b_of_type_JavaLangString;
    ??? = SessionMgr.a().c(str);
    if ((??? == null) || (((SessionInfo)???).f())) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        i = 0;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("WTogether.Mng", 2, "clearInfo, ret[" + i + "], info[" + paramWatchTogetherInfo + "]");
        return;
      }
      if ((paramWatchTogetherInfo.a() == 0L) || (((SessionInfo)???).b() == paramWatchTogetherInfo.a())) {
        synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
      }
      paramWatchTogetherInfo.a((SessionInfo)???, true);
      i = 2;
    }
  }
  
  private void e(WatchTogetherInfo paramWatchTogetherInfo)
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(6)) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(6);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramWatchTogetherInfo != null) {
        if (paramWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTInfoFromPush != null)
        {
          bool1 = bool2;
          paramWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTInfoFromPush = null;
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Mng", 2, "clearConflictInfo, hasConflict[" + bool1 + "]");
        }
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public WTogetherPlayInfo a(SessionInfo paramSessionInfo)
  {
    Object localObject = null;
    WatchTogetherInfo localWatchTogetherInfo = b(paramSessionInfo);
    paramSessionInfo = localObject;
    if (localWatchTogetherInfo != null)
    {
      paramSessionInfo = localObject;
      if (localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom != null) {
        paramSessionInfo = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo;
      }
    }
    return paramSessionInfo;
  }
  
  public WatchTogetherInfo a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return null;
    }
    return a(paramSessionInfo.f(), paramSessionInfo.b(), true);
  }
  
  public void a() {}
  
  public void a(int paramInt, String paramString)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramInt, paramString, false);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "clearForClose, [relationType: " + paramInt + ", relationId: " + paramString + ", info: " + localWatchTogetherInfo + "]");
    }
    e(localWatchTogetherInfo);
    a(localWatchTogetherInfo, 3, "clearForClose");
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = true;
    if (paramInt2 == 1) {}
    for (;;)
    {
      WatchTogetherInfo localWatchTogetherInfo = a(paramInt1, paramString, bool);
      if (localWatchTogetherInfo != null) {
        localWatchTogetherInfo.a(paramInt2, "updateFlg");
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "updateFlag, [relationType: " + paramInt1 + ", relationId: " + paramString + ", flag: " + paramInt2 + "]");
      }
      return;
      bool = false;
    }
  }
  
  public void a(int paramInt, String paramString, ChooseFileInfo paramChooseFileInfo, long[] paramArrayOfLong)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramInt, paramString, true);
    if (localWatchTogetherInfo != null)
    {
      if (paramInt != 3) {
        break label151;
      }
      localWatchTogetherInfo.jdField_a_of_type_JavaUtilArrayList.clear();
      localWatchTogetherInfo.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(AVUtil.a(paramString)));
    }
    for (;;)
    {
      localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = paramChooseFileInfo;
      if (paramChooseFileInfo != null) {
        localWatchTogetherInfo.a(1, "updateChooseFile");
      }
      if (paramChooseFileInfo != null) {
        AVUtil.a("0X800B62A", paramChooseFileInfo.a(), 0, paramChooseFileInfo.d(), paramChooseFileInfo.c(), paramChooseFileInfo.a(), paramChooseFileInfo.b());
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "updateChooseFile, [relationType: " + paramInt + ", relationId: " + paramString + ", file: " + paramChooseFileInfo + "]");
      }
      return;
      label151:
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
      {
        localWatchTogetherInfo.jdField_a_of_type_JavaUtilArrayList.clear();
        int j = paramArrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          long l = paramArrayOfLong[i];
          localWatchTogetherInfo.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
          i += 1;
        }
      }
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt != 4) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onReceivePushMsg, param illegal.");
      }
    }
    do
    {
      return;
      int j = 0;
      WTogetherCommon.PushMsg localPushMsg = new WTogetherCommon.PushMsg();
      try
      {
        localPushMsg.mergeFrom(paramArrayOfByte);
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("WTogether.Mng", 2, "onReceivePushMsg", paramArrayOfByte);
            i = j;
          }
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          int i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("WTogether.Mng", 2, "onReceivePushMsg", paramArrayOfByte);
            i = j;
          }
        }
      }
    } while (i == 0);
    paramArrayOfByte = Message.obtain();
    paramArrayOfByte.what = 4;
    paramArrayOfByte.arg1 = paramInt;
    paramArrayOfByte.obj = localPushMsg;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramArrayOfByte);
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onConnected, session is null.");
      }
    }
    for (;;)
    {
      return;
      WatchTogetherInfo localWatchTogetherInfo = b(paramSessionInfo);
      if ((localWatchTogetherInfo == null) || (localWatchTogetherInfo.a() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("WTogether.Mng", 2, "onConnected, no info or flag is 0.");
        }
      }
      else
      {
        localWatchTogetherInfo.a(paramSessionInfo, true);
        Object localObject = localWatchTogetherInfo.a();
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("WTogether.Mng", 2, "onConnected, not valid to create room.");
          }
        }
        else
        {
          int i = ((WTogetherRoom)localObject).a();
          if ((i == 0) && (localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo != null)) {
            if (!WTogetherUtil.a(paramSessionInfo.d))
            {
              a(BaseApplicationImpl.getContext().getString(2131695990), 0L);
              d(localWatchTogetherInfo);
            }
          }
          while (QLog.isDevelopLevel())
          {
            QLog.i("WTogether.Mng", 4, "onConnected, roomState[" + i + "], room[" + localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom + "]");
            return;
            if ((localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.d == 1) && (!WTogetherUtil.b(paramSessionInfo.d)))
            {
              b(BaseApplicationImpl.getContext().getString(2131695991), true);
              AVUtil.a("0X800B8B7", 0, 0, "", "", "", "");
              d(localWatchTogetherInfo);
            }
            else
            {
              localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
              ((WTogetherRealNameVideoProcessHelper)localObject).b(new WTogetherMng.1(this, paramSessionInfo, localWatchTogetherInfo, (WTogetherRealNameVideoProcessHelper)localObject));
              continue;
              if (i == 0) {
                b(localWatchTogetherInfo);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(SessionInfo paramSessionInfo, int paramInt, Intent paramIntent)
  {
    Object localObject = null;
    int i = -1;
    if ((paramInt == 4660) && (paramIntent != null))
    {
      paramIntent.setExtrasClassLoader(ChooseFileInfo.class.getClassLoader());
      localObject = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
      paramInt = paramIntent.getIntExtra("watch_together_uinType", -1);
      String str = paramIntent.getStringExtra("watch_together_uin");
      paramIntent = (Intent)localObject;
      localObject = str;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "onActivityResult, uinType[" + paramInt + "], uin[" + (String)localObject + "], choose[" + paramIntent + "]");
      }
      if ((paramIntent != null) && (paramSessionInfo != null) && (paramSessionInfo.j == paramInt) && (TextUtils.equals((CharSequence)localObject, paramSessionInfo.d)))
      {
        if ((paramIntent.d == 1) && (!WTogetherUtil.b(paramSessionInfo.d)))
        {
          b(BaseApplicationImpl.getContext().getString(2131695991), true);
          AVUtil.a("0X800B8B7", 0, 0, "", "", "", "");
        }
      }
      else {
        return;
      }
      localObject = b(paramSessionInfo);
      if ((localObject != null) && (((WatchTogetherInfo)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom != null) && (((WatchTogetherInfo)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom.d()))
      {
        a(paramSessionInfo, paramIntent);
        return;
      }
      a(paramSessionInfo, paramIntent, new long[] { AVUtil.a(paramSessionInfo.d) });
      return;
      paramIntent = null;
      paramInt = i;
    }
  }
  
  public void a(SessionInfo paramSessionInfo, WTSyncPlayInfo paramWTSyncPlayInfo)
  {
    paramSessionInfo = b(paramSessionInfo);
    if (paramSessionInfo == null) {}
    for (paramSessionInfo = null; (paramSessionInfo == null) || (paramSessionInfo.c()) || (!paramSessionInfo.d()); paramSessionInfo = paramSessionInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom) {
      return;
    }
    paramSessionInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a(paramWTSyncPlayInfo);
    a("syncPlayInfo");
  }
  
  public void a(SessionInfo paramSessionInfo, WTVideoInfo paramWTVideoInfo, boolean paramBoolean)
  {
    WTogetherPlayInfo localWTogetherPlayInfo = null;
    Object localObject = b(paramSessionInfo);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        localWTogetherPlayInfo = ((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo;
      }
      if ((localWTogetherPlayInfo != null) && (localWTogetherPlayInfo.a(paramWTVideoInfo))) {
        if (!paramBoolean) {
          break label148;
        }
      }
    }
    label148:
    for (int i = 2;; i = 3)
    {
      ((WTogetherRoom)localObject).a(4, i, "onStartPlayResult");
      a("updatePlayResult");
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "updatePlayResult, videoInfo[" + paramWTVideoInfo + "], room[" + localObject + "], session[" + paramSessionInfo + "], success[" + paramBoolean + "]");
      }
      return;
      localObject = ((WatchTogetherInfo)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
      break;
    }
  }
  
  public void a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onSwitchTerminalSuccess, isSelfSwitchTerminal[" + paramBoolean + "], session[" + paramSessionInfo + "]");
    }
  }
  
  void a(ReqComResult paramReqComResult)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(8);
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.jdField_a_of_type_Int, paramReqComResult.jdField_a_of_type_Long);
    WTogetherRoom localWTogetherRoom;
    if (localWatchTogetherInfo == null)
    {
      localWTogetherRoom = null;
      if ((localWTogetherRoom != null) && (localWTogetherRoom.a() == 5)) {
        break label52;
      }
    }
    label52:
    int i;
    do
    {
      return;
      localWTogetherRoom = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
      break;
      i = localWatchTogetherInfo.jdField_b_of_type_Int;
      localWTogetherRoom.b("onCloseWTogether");
      d(localWatchTogetherInfo);
      c(0, "onCloseWTogether");
      a(localWatchTogetherInfo, true);
      if (i == 5) {
        a(200L, "onCloseWTogether");
      }
      WTDataReportUtil.b();
    } while (!QLog.isDevelopLevel());
    QLog.i("WTogether.Mng", 4, "onCloseWTogether, result[" + paramReqComResult + "], quitReason[" + i + "]");
  }
  
  void a(ReqComResult paramReqComResult, long paramLong, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.jdField_a_of_type_Int, paramReqComResult.jdField_a_of_type_Long);
    Object localObject;
    if (localWatchTogetherInfo == null)
    {
      localObject = null;
      if ((localObject != null) && (!((WTogetherRoom)localObject).c()) && (((WTogetherRoom)localObject).d())) {
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onSyncPlayInfo, room[" + localObject + "]");
      }
    }
    label92:
    do
    {
      return;
      localObject = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
      break;
      if ((paramReqComResult.jdField_a_of_type_Boolean) && (paramRoomInfo != null)) {
        a((WTogetherRoom)localObject, paramRoomInfo, "onSyncPlayInfo");
      }
    } while (paramReqComResult.jdField_a_of_type_Boolean);
    a(paramReqComResult, localWatchTogetherInfo, (WTogetherRoom)localObject, "onSyncPlayInfo");
  }
  
  void a(ReqComResult paramReqComResult, ChooseFileInfo paramChooseFileInfo, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(7);
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.jdField_a_of_type_Int, paramReqComResult.jdField_a_of_type_Long);
    if ((localWatchTogetherInfo == null) || (paramChooseFileInfo == null) || (!paramChooseFileInfo.equals(localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo))) {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onStartWTogether, info[" + localWatchTogetherInfo + "]");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
      if ((localObject != null) && (((WTogetherRoom)localObject).e()) && (((WTogetherRoom)localObject).a() == 1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WTogether.Mng", 2, "onStartWTogether, room[" + localObject + "]");
    return;
    if ((paramReqComResult.jdField_a_of_type_Boolean) && (paramRoomInfo != null))
    {
      ((WTogetherRoom)localObject).a(1, 2, "onStartWTogether");
      a((WTogetherRoom)localObject, paramRoomInfo, "onStartWTogether");
      if (a(localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTInfoFromPush)) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(6, 200L);
      }
      if (((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_a_of_type_Int == 0)
      {
        AVUtil.a("0X800B62D", paramChooseFileInfo.a(), 0, "", paramChooseFileInfo.c(), paramChooseFileInfo.a(), paramChooseFileInfo.b());
        label247:
        WTDataReportUtil.a();
        a(localWatchTogetherInfo, "onStartWTogether");
      }
    }
    for (;;)
    {
      if (paramReqComResult.jdField_a_of_type_Boolean) {
        c(1, "onStartWTogether");
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("WTogether.Mng", 4, "onStartWTogether, result[" + paramReqComResult + "]");
      return;
      if (((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo == null) {
        break label247;
      }
      WTVideoInfo localWTVideoInfo = ((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo;
      int i = paramChooseFileInfo.a();
      paramRoomInfo = paramChooseFileInfo.c();
      localObject = localWTVideoInfo.jdField_a_of_type_JavaLangString;
      if (localWTVideoInfo.b()) {}
      for (paramChooseFileInfo = localWTVideoInfo.d;; paramChooseFileInfo = localWTVideoInfo.jdField_b_of_type_JavaLangString)
      {
        AVUtil.a("0X800B62D", i, 0, "", paramRoomInfo, (String)localObject, paramChooseFileInfo);
        break;
      }
      localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = null;
      localWatchTogetherInfo.a(0, "onStartWTogether");
      ((WTogetherRoom)localObject).b("onStartWTogether");
      a(localWatchTogetherInfo, true);
      if (paramReqComResult.jdField_b_of_type_Int == 1019) {
        a(200L, "onStartWTogether");
      }
    }
  }
  
  void a(ReqComResult paramReqComResult, ReqVideoAction paramReqVideoAction, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.jdField_a_of_type_Int, paramReqComResult.jdField_a_of_type_Long);
    if (localWatchTogetherInfo == null)
    {
      paramReqVideoAction = null;
      if ((paramReqVideoAction != null) && (paramReqVideoAction.e()) && (!paramReqVideoAction.c()) && (paramReqVideoAction.d())) {
        break label93;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onChangeVideoStatus, room[" + paramReqVideoAction + "]");
      }
    }
    label93:
    do
    {
      return;
      paramReqVideoAction = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
      break;
      if ((paramReqComResult.jdField_a_of_type_Boolean) && (paramRoomInfo != null)) {
        a(paramReqVideoAction, paramRoomInfo, "onChangeVideoStatus");
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "onChangeVideoStatus, result[" + paramReqComResult + "]");
      }
    } while (paramReqComResult.jdField_a_of_type_Boolean);
    a(paramReqComResult, localWatchTogetherInfo, paramReqVideoAction, "onChangeVideoStatus");
  }
  
  void a(ReqComResult paramReqComResult, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.jdField_a_of_type_Int, paramReqComResult.jdField_a_of_type_Long);
    WTogetherRoom localWTogetherRoom;
    if (localWatchTogetherInfo == null)
    {
      localWTogetherRoom = null;
      if (localWTogetherRoom != null) {
        break label35;
      }
    }
    label35:
    do
    {
      return;
      localWTogetherRoom = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
      break;
      if ((paramReqComResult.jdField_a_of_type_Boolean) && (paramRoomInfo != null)) {
        a(localWTogetherRoom, paramRoomInfo, "onGetRoomInfo");
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "onGetRoomInfo, room[" + localWTogetherRoom + "], result[" + paramReqComResult + "]");
      }
    } while (paramReqComResult.jdField_a_of_type_Boolean);
    a(paramReqComResult, localWatchTogetherInfo, localWTogetherRoom, "onGetRoomInfo");
  }
  
  void a(WTReqUrlResult paramWTReqUrlResult)
  {
    Object localObject = a(paramWTReqUrlResult.jdField_a_of_type_Int, paramWTReqUrlResult.jdField_a_of_type_Long);
    if (localObject == null) {}
    for (localObject = null; (localObject == null) || (((WTogetherRoom)localObject).a() != 3) || (((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo == null) || (((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo == null) || (!((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.equals(paramWTReqUrlResult.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo)); localObject = ((WatchTogetherInfo)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onRequestUrl, room[" + localObject + "]");
      }
      return;
    }
    if ((paramWTReqUrlResult.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(paramWTReqUrlResult.jdField_a_of_type_JavaLangString)))
    {
      if (((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo == null) {
        ((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo = new WTVideoInfo(((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_a_of_type_Int, ((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_a_of_type_JavaLangString, paramWTReqUrlResult.jdField_a_of_type_JavaLangString, paramWTReqUrlResult.jdField_b_of_type_JavaLangString, null, null, null, 0, null, 0L);
      }
      ((WTogetherRoom)localObject).a(4, 0, "onRequestUrl");
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("content:");
      localStringBuilder.append("roomid=").append(paramWTReqUrlResult.jdField_a_of_type_Long).append("|");
      if ((((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo != null) && (((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo != null))
      {
        localStringBuilder.append("file_id=").append(((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_c_of_type_JavaLangString).append("|");
        localStringBuilder.append("file_uuid=").append(((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_b_of_type_JavaLangString);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("WTogether.Mng", 4, "onRequestUrl, result[" + paramWTReqUrlResult + "] \n" + localStringBuilder.toString());
      return;
      ((WTogetherRoom)localObject).a(3, 3, "onRequestUrl");
    }
  }
  
  public void a(WTogetherRoom paramWTogetherRoom, int paramInt)
  {
    if (paramWTogetherRoom == null) {}
    do
    {
      return;
      ReqVideoAction localReqVideoAction = new ReqVideoAction(paramWTogetherRoom.jdField_a_of_type_Long, paramInt, paramWTogetherRoom.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo);
      ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).a(paramWTogetherRoom.jdField_a_of_type_Int, paramWTogetherRoom.jdField_b_of_type_Long, localReqVideoAction);
    } while (!QLog.isDevelopLevel());
    QLog.i("WTogether.Mng", 4, "queryRoomInfo, room[" + paramWTogetherRoom + "], action[" + paramInt + "]");
  }
  
  public void a(WatchTogetherInfo paramWatchTogetherInfo)
  {
    b("closeWTogetherMode");
    if (paramWatchTogetherInfo == null) {}
    for (Object localObject = null; (localObject == null) || (!((WTogetherRoom)localObject).e()) || (!((WTogetherRoom)localObject).d()); localObject = paramWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "closeWTogetherMode, room[" + localObject + "]");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "closeWTogetherMode, room[" + localObject + "]");
    }
    WTDataReportUtil.a(((WTogetherRoom)localObject).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo, "closeWTogetherMode");
    paramWatchTogetherInfo.a(false, "closeWTogetherMode");
    ((WTogetherRoom)localObject).a(5, 1, "closeWTogetherMode");
    ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).a(((WTogetherRoom)localObject).jdField_a_of_type_Int, ((WTogetherRoom)localObject).jdField_b_of_type_Long, 0);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(8);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(8, 30000L);
  }
  
  protected void a(WatchTogetherInfo paramWatchTogetherInfo, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "onExitWTMode, isAdmin[" + paramBoolean + "]");
    }
    e(paramWatchTogetherInfo);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9008), Long.valueOf(l), Boolean.valueOf(false) });
    TipsInfo.a().a(true);
  }
  
  protected void a(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "onEnterWTMode, isAdmin[" + paramBoolean + "], seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9008), Long.valueOf(l), Boolean.valueOf(true) });
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new WTogetherMng.3(this, l));
    TipsInfo.a().a(false);
  }
  
  public boolean a(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString, false);
    if (paramString != null) {
      return paramString.a() == 1;
    }
    return false;
  }
  
  public boolean a(SessionInfo paramSessionInfo)
  {
    boolean bool2 = false;
    paramSessionInfo = b(paramSessionInfo);
    if (paramSessionInfo == null) {}
    for (paramSessionInfo = null;; paramSessionInfo = paramSessionInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
    {
      boolean bool1 = bool2;
      if (paramSessionInfo != null)
      {
        bool1 = bool2;
        if (paramSessionInfo.a() != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public boolean a(SessionInfo paramSessionInfo, ChooseFileInfo paramChooseFileInfo)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramSessionInfo);
    if (localWatchTogetherInfo != null) {
      localWatchTogetherInfo.a(paramSessionInfo, false);
    }
    for (paramSessionInfo = localWatchTogetherInfo.a();; paramSessionInfo = null)
    {
      if ((paramSessionInfo == null) || (!paramSessionInfo.e()) || (!paramSessionInfo.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("WTogether.Mng", 2, "changeFile, not valid to change file. room[" + paramSessionInfo + "]");
        }
        return false;
      }
      WTDataReportUtil.a(paramSessionInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo, "changeFile");
      localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = paramChooseFileInfo;
      localWatchTogetherInfo.a(true, "changeFile");
      paramSessionInfo.a(paramSessionInfo.jdField_a_of_type_JavaLangString);
      ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).a(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_b_of_type_Long, paramSessionInfo.jdField_a_of_type_Long, paramChooseFileInfo);
      return true;
    }
  }
  
  public boolean a(SessionInfo paramSessionInfo, ReqVideoAction paramReqVideoAction)
  {
    WatchTogetherInfo localWatchTogetherInfo = b(paramSessionInfo);
    if (localWatchTogetherInfo == null) {}
    for (paramSessionInfo = null; (paramSessionInfo == null) || ((paramSessionInfo.a() != 4) && ((paramSessionInfo.a() != 3) || (paramSessionInfo.b() != 3))) || (paramReqVideoAction == null) || (!paramSessionInfo.e()) || (localWatchTogetherInfo.b()); paramSessionInfo = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "changeVideoStatus, illegal param or no room. info[" + localWatchTogetherInfo + "]");
      }
      return false;
    }
    if (paramReqVideoAction.jdField_a_of_type_Int == 4) {
      a(BaseApplicationImpl.getContext().getString(2131695971, new Object[] { String.valueOf(paramReqVideoAction.jdField_a_of_type_Float) }), 0L);
    }
    paramReqVideoAction.jdField_a_of_type_Long = paramSessionInfo.a();
    ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).a(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_b_of_type_Long, paramReqVideoAction, 0);
    return true;
  }
  
  boolean a(ReqComResult paramReqComResult, long paramLong, int paramInt)
  {
    boolean bool1 = true;
    boolean bool3 = false;
    boolean bool2 = false;
    if ((paramReqComResult == null) || (paramReqComResult.jdField_b_of_type_Int == 1009))
    {
      bool2 = false;
      return bool2;
    }
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.jdField_a_of_type_Int, paramReqComResult.jdField_a_of_type_Long);
    WTogetherRoom localWTogetherRoom;
    if (localWatchTogetherInfo == null)
    {
      localWTogetherRoom = null;
      switch (paramInt)
      {
      default: 
        label51:
        if ((localWTogetherRoom == null) || (localWTogetherRoom.a() != 4) || (paramLong != localWTogetherRoom.b())) {
          break;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("WTogether.Mng", 4, "checkForRetry, {result: " + paramReqComResult + ", seq: " + paramLong + ", action: " + paramInt + "}");
      return bool1;
      localWTogetherRoom = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
      break label51;
      if ((localWTogetherRoom == null) || (localWTogetherRoom.a() != 1))
      {
        bool1 = false;
        continue;
        if (localWTogetherRoom != null)
        {
          bool1 = bool2;
          if (localWTogetherRoom.a() != 5) {}
        }
        else
        {
          bool1 = true;
        }
        continue;
        if ((localWTogetherRoom == null) || (localWTogetherRoom.a() != 2))
        {
          bool1 = false;
          continue;
          if (localWTogetherRoom != null)
          {
            bool1 = bool3;
            if (localWTogetherRoom.a() != 6) {}
          }
          else
          {
            bool1 = true;
          }
          continue;
          if ((localWTogetherRoom == null) || (!localWTogetherRoom.d()) || (!localWatchTogetherInfo.b()))
          {
            bool1 = false;
            continue;
            bool1 = false;
          }
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public WatchTogetherInfo b(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return null;
    }
    return a(paramSessionInfo.f(), paramSessionInfo.b(), false);
  }
  
  public void b(SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "checkAndQuit");
    }
    a(b(paramSessionInfo), 6, "checkAndQuit");
    a(BaseApplicationImpl.getContext().getString(2131695998), 100L);
  }
  
  void b(ReqComResult paramReqComResult)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.jdField_a_of_type_Int, paramReqComResult.jdField_a_of_type_Long);
    WTogetherRoom localWTogetherRoom;
    if (localWatchTogetherInfo == null)
    {
      localWTogetherRoom = null;
      if (localWTogetherRoom != null) {
        break label44;
      }
    }
    label44:
    int i;
    do
    {
      return;
      localWTogetherRoom = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
      break;
      i = localWatchTogetherInfo.jdField_b_of_type_Int;
      localWTogetherRoom.b("onQuitRoom");
      d(localWatchTogetherInfo);
      c(0, "onQuitRoom");
      a(localWatchTogetherInfo, false);
      if (i == 5) {
        a(200L, "onQuitRoom");
      }
      WTDataReportUtil.b();
    } while (!QLog.isDevelopLevel());
    QLog.i("WTogether.Mng", 4, "onQuitRoom, result[" + paramReqComResult + "], quitReason[" + i + "]");
  }
  
  void b(ReqComResult paramReqComResult, ChooseFileInfo paramChooseFileInfo, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.jdField_a_of_type_Int, paramReqComResult.jdField_a_of_type_Long);
    if ((localWatchTogetherInfo == null) || (paramChooseFileInfo == null) || (!paramChooseFileInfo.equals(localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo))) {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onChangeVideoFile, info[" + localWatchTogetherInfo + "]");
      }
    }
    do
    {
      return;
      paramChooseFileInfo = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
      if ((paramChooseFileInfo != null) && (paramChooseFileInfo.e()) && (!paramChooseFileInfo.c()) && (paramChooseFileInfo.d())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WTogether.Mng", 2, "onChangeVideoFile, room[" + paramChooseFileInfo + "]");
    return;
    localWatchTogetherInfo.a(false, "onChangeVideoFile");
    if ((paramReqComResult.jdField_a_of_type_Boolean) && (paramRoomInfo != null))
    {
      a(paramChooseFileInfo, paramRoomInfo, "onChangeVideoFile");
      a(localWatchTogetherInfo, "onChangeVideoFile");
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "onChangeVideoFile, result[" + paramReqComResult + "]");
      }
      if (paramReqComResult.jdField_a_of_type_Boolean) {
        break;
      }
      a(paramReqComResult, localWatchTogetherInfo, paramChooseFileInfo, "onChangeVideoFile");
      return;
      localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = null;
    }
  }
  
  void b(ReqComResult paramReqComResult, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(9);
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.jdField_a_of_type_Int, paramReqComResult.jdField_a_of_type_Long);
    if (localWatchTogetherInfo == null) {}
    for (Object localObject = null; (localObject == null) || (((WTogetherRoom)localObject).a() != 2); localObject = localWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onEnterRoom, room[" + localObject + "]");
      }
      return;
    }
    if ((paramReqComResult.jdField_a_of_type_Boolean) && (paramRoomInfo != null))
    {
      ((WTogetherRoom)localObject).a(2, 2, "onEnterRoom");
      a((WTogetherRoom)localObject, paramRoomInfo, "onEnterRoom");
      WTDataReportUtil.a();
    }
    for (;;)
    {
      if (paramReqComResult.jdField_a_of_type_Boolean) {
        c(1, "onEnterRoom");
      }
      if (!paramReqComResult.jdField_a_of_type_Boolean) {
        a(localWatchTogetherInfo, false);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("WTogether.Mng", 4, "onEnterRoom, result[" + paramReqComResult + "]");
      return;
      ((WTogetherRoom)localObject).b("onEnterRoom");
    }
  }
  
  public void b(WatchTogetherInfo paramWatchTogetherInfo)
  {
    if (paramWatchTogetherInfo == null) {}
    for (Object localObject = null; (localObject == null) || (((WTogetherRoom)localObject).a() != 0) || (((WTogetherRoom)localObject).e()); localObject = paramWatchTogetherInfo.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "enterRoom, room[" + localObject + "]");
      }
      return;
    }
    if (!WTogetherUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "enterRoom, not support.");
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(11);
      return;
    }
    paramWatchTogetherInfo.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(5);
    e(paramWatchTogetherInfo);
    ((WTogetherRoom)localObject).a(2, 1, "enterRoom");
    a(false);
    ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).c(((WTogetherRoom)localObject).jdField_a_of_type_Int, ((WTogetherRoom)localObject).jdField_b_of_type_Long, 0);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(9);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(9, 30000L);
  }
  
  public void c(SessionInfo paramSessionInfo)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onPeerSwitchTerminal, session[" + paramSessionInfo + "]");
    }
    a(b(paramSessionInfo), 4, "onPeerSwitchTerminal");
  }
  
  public void c(WatchTogetherInfo paramWatchTogetherInfo)
  {
    b("quitRoom");
    if ((paramWatchTogetherInfo == null) || (!paramWatchTogetherInfo.a())) {}
    do
    {
      return;
      paramWatchTogetherInfo = paramWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom;
    } while ((paramWatchTogetherInfo == null) || (paramWatchTogetherInfo.e()) || (!paramWatchTogetherInfo.d()));
    WTDataReportUtil.a(paramWatchTogetherInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherPlayInfo, "quitRoom");
    paramWatchTogetherInfo.a(6, 1, "quitRoom");
    ((WTogetherHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.e)).b(paramWatchTogetherInfo.jdField_a_of_type_Int, paramWatchTogetherInfo.jdField_b_of_type_Long, 0);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(10, 30000L);
  }
  
  public void d(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = b(paramSessionInfo);
    if (paramSessionInfo == null) {
      return;
    }
    a(paramSessionInfo, 1, "closeWTogetherMode");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return true;
                } while (!(paramMessage.obj instanceof String));
                b(paramMessage.arg1, (String)paramMessage.obj);
                return true;
                b();
                return true;
              } while (!(paramMessage.obj instanceof WTogetherRoom));
              a((WTogetherRoom)paramMessage.obj);
              return true;
            } while (!(paramMessage.obj instanceof WTogetherCommon.PushMsg));
            a((WTogetherCommon.PushMsg)paramMessage.obj);
            return true;
            if (QLog.isColorLevel()) {
              QLog.i("WTogether.Mng", 2, "MSG_TRY_ENTER_ROOM");
            }
            paramMessage = SessionMgr.a().a();
          } while ((paramMessage.f()) || (!paramMessage.l()));
          localObject2 = a(paramMessage);
          if (localObject2 != null) {
            ((WatchTogetherInfo)localObject2).a(paramMessage, true);
          }
          if (localObject2 == null) {}
          for (paramMessage = (Message)localObject1; (paramMessage == null) || (paramMessage.a() != 0); paramMessage = ((WatchTogetherInfo)localObject2).a())
          {
            QLog.i("WTogether.Mng", 2, "MSG_TRY_ENTER_ROOM, error, room[" + paramMessage + "]");
            return true;
          }
          b((WatchTogetherInfo)localObject2);
          return true;
          paramMessage = SessionMgr.a().a();
        } while ((paramMessage.f()) || (!paramMessage.l()));
        paramMessage = b(paramMessage);
      } while (paramMessage == null);
      if (a(paramMessage.jdField_a_of_type_ComTencentAvWtogetherDataWTInfoFromPush)) {
        a(paramMessage.jdField_a_of_type_ComTencentAvWtogetherDataWTInfoFromPush);
      }
      paramMessage.jdField_a_of_type_ComTencentAvWtogetherDataWTInfoFromPush = null;
      return true;
    case 7: 
      localObject1 = b(SessionMgr.a().a());
      if (localObject1 == null) {}
      for (paramMessage = null; (paramMessage != null) && (paramMessage.a() == 1) && (paramMessage.b() == 1); paramMessage = ((WatchTogetherInfo)localObject1).jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
      {
        paramMessage = new ReqComResult(paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Long);
        paramMessage.jdField_a_of_type_Boolean = false;
        paramMessage.jdField_b_of_type_Int = -1000;
        a(paramMessage, ((WatchTogetherInfo)localObject1).jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo, null);
        return true;
      }
    case 8: 
      paramMessage = b(SessionMgr.a().a());
      if (paramMessage == null) {}
      for (paramMessage = (Message)localObject2; (paramMessage != null) && (paramMessage.a() == 5) && (paramMessage.b() == 1); paramMessage = paramMessage.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
      {
        paramMessage = new ReqComResult(paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Long);
        paramMessage.jdField_a_of_type_Boolean = false;
        paramMessage.jdField_b_of_type_Int = -1000;
        a(paramMessage);
        return true;
      }
    case 9: 
      paramMessage = b(SessionMgr.a().a());
      if (paramMessage == null) {}
      for (paramMessage = null; (paramMessage != null) && (paramMessage.a() == 2) && (paramMessage.b() == 1); paramMessage = paramMessage.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
      {
        paramMessage = new ReqComResult(paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Long);
        paramMessage.jdField_a_of_type_Boolean = false;
        paramMessage.jdField_b_of_type_Int = -1000;
        b(paramMessage, null);
        return true;
      }
    case 10: 
      paramMessage = b(SessionMgr.a().a());
      if (paramMessage == null) {}
      for (paramMessage = localObject3; (paramMessage != null) && (paramMessage.a() == 6) && (paramMessage.b() == 1); paramMessage = paramMessage.jdField_a_of_type_ComTencentAvWtogetherDataWTogetherRoom)
      {
        paramMessage = new ReqComResult(paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Long);
        paramMessage.jdField_a_of_type_Boolean = false;
        paramMessage.jdField_b_of_type_Int = -1000;
        b(paramMessage);
        return true;
      }
    }
    try
    {
      paramMessage = BaseApplicationImpl.getContext();
      localObject1 = paramMessage.getString(2131696001);
      localObject2 = new Intent(paramMessage, SmallScreenDialogActivity.class);
      ((Intent)localObject2).putExtra("tag_model", 1);
      ((Intent)localObject2).putExtra("tag_style", 1);
      ((Intent)localObject2).putExtra("tag_msg", (String)localObject1);
      paramMessage.startActivity((Intent)localObject2);
      return true;
    }
    catch (Throwable paramMessage)
    {
      QLog.i("WTogether.Mng", 2, "MSG_SHOW_NOT_SUPPORT", paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherMng
 * JD-Core Version:    0.7.0.1
 */