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
import com.tencent.av.utils.AudioHelper;
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
  private final ConcurrentHashMap<String, WatchTogetherInfo> d = new ConcurrentHashMap(2);
  private final WeakReferenceHandler e = new WeakReferenceHandler(Looper.getMainLooper(), this);
  
  public WTogetherMng(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private SessionInfo a(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    if (paramInt == 2)
    {
      paramInt = 3;
      paramString = String.valueOf(paramLong2);
    }
    else
    {
      paramString = null;
      paramInt = 0;
    }
    String str = SessionMgr.a(paramInt, paramString, new int[0]);
    Object localObject = SessionMgr.a().b();
    paramString = (String)localObject;
    if (!TextUtils.equals(((SessionInfo)localObject).f, str)) {
      paramString = null;
    }
    if ((paramString != null) && (paramString.D() != paramLong1) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSessionInfo, [");
      ((StringBuilder)localObject).append(paramString.D());
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Mng", 2, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  private WatchTogetherInfo a(int paramInt, long paramLong)
  {
    Object localObject2 = null;
    try
    {
      Iterator localIterator = this.d.entrySet().iterator();
      Object localObject1;
      long l;
      do
      {
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (WatchTogetherInfo)((Map.Entry)localIterator.next()).getValue();
        } while ((localObject1 == null) || (((WatchTogetherInfo)localObject1).c() != paramInt));
        l = ((WatchTogetherInfo)localObject1).d();
      } while (l != paramLong);
      return localObject1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private WatchTogetherInfo a(int paramInt, String paramString, boolean paramBoolean)
  {
    String str2 = this.c.getCurrentAccountUin();
    String str1 = SessionMgr.a(paramInt, paramString, new int[0]);
    Object localObject = (WatchTogetherInfo)this.d.get(str1);
    if ((localObject == null) && (paramBoolean)) {
      synchronized (this.d)
      {
        WatchTogetherInfo localWatchTogetherInfo = (WatchTogetherInfo)this.d.get(str1);
        localObject = localWatchTogetherInfo;
        if (localWatchTogetherInfo == null)
        {
          localObject = new WatchTogetherInfo(str2, str1, paramInt, paramString);
          this.d.put(str1, localObject);
        }
        return localObject;
      }
    }
    return localObject;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = b(paramInt, paramLong1, paramLong2, "onReceiveStartPush");
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((WatchTogetherInfo)localObject).f();
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceiveStartPush, illegal. [roomType: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", roomId: ");
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append("]");
        QLog.i("WTogether.Mng", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (((WTogetherRoom)localObject).e() == 0)
    {
      ((WTogetherRoom)localObject).a(String.valueOf(paramLong2));
      b(a(paramInt, paramLong1));
      return;
    }
    if (TextUtils.equals(((WTogetherRoom)localObject).e, String.valueOf(paramLong2))) {
      a((WTogetherRoom)localObject, 6);
    }
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramInt1, paramLong1);
    if ((localWatchTogetherInfo != null) && (!TextUtils.equals(String.valueOf(paramLong2), this.c.getCurrentAccountUin()))) {
      a(localWatchTogetherInfo.f(), paramInt2);
    }
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    if ((paramInt2 != 2) && (paramInt2 != 3))
    {
      if (paramInt2 == 4)
      {
        if (localWatchTogetherInfo != null) {
          localObject1 = localWatchTogetherInfo.g;
        }
        b((WTogetherRoom)localObject1, 2131893747);
        return;
      }
      if (paramInt2 == 1)
      {
        if (localWatchTogetherInfo == null) {
          localObject1 = localObject2;
        } else {
          localObject1 = localWatchTogetherInfo.g;
        }
        b((WTogetherRoom)localObject1, 2131893766);
      }
    }
    else
    {
      if (localWatchTogetherInfo == null) {
        localObject1 = localObject3;
      } else {
        localObject1 = localWatchTogetherInfo.g;
      }
      b((WTogetherRoom)localObject1, 2131893749);
    }
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceiveUserEnterOrLeave, [roomType: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", roomId: ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", operator: ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(", seq: ");
      ((StringBuilder)localObject).append(paramLong3);
      ((StringBuilder)localObject).append(", enter: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Mng", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ReqComResult(paramInt, paramLong1);
    ((ReqComResult)localObject).c = paramBoolean;
    ((ReqComResult)localObject).e = String.valueOf(paramLong2);
    WTogetherHandler localWTogetherHandler = (WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c);
    if (localWTogetherHandler != null) {
      localWTogetherHandler.notifyUI(10, ((ReqComResult)localObject).c, localObject);
    }
  }
  
  private void a(long paramLong, String paramString)
  {
    Object localObject;
    if (!this.e.hasMessages(5))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 5;
      this.e.sendMessageDelayed((Message)localObject, paramLong);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryEnterRoomLater, from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Mng", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(ReqComResult paramReqComResult, WatchTogetherInfo paramWatchTogetherInfo, WTogetherRoom paramWTogetherRoom, String paramString)
  {
    if ((paramReqComResult != null) && (paramWatchTogetherInfo != null))
    {
      if (paramWTogetherRoom == null) {
        return;
      }
      if ((!paramReqComResult.c) && (paramReqComResult.d == 1009)) {
        a(paramWatchTogetherInfo, 7, "checkError");
      } else if ((!paramReqComResult.c) && (paramReqComResult.d == 1007)) {
        a(paramWatchTogetherInfo, 5, "checkError");
      }
      if ((!paramReqComResult.c) && (QLog.isColorLevel()))
      {
        paramWatchTogetherInfo = new StringBuilder();
        paramWatchTogetherInfo.append("checkError, errCode[");
        paramWatchTogetherInfo.append(paramReqComResult.d);
        paramWatchTogetherInfo.append("], from[");
        paramWatchTogetherInfo.append(paramString);
        paramWatchTogetherInfo.append("]");
        QLog.i("WTogether.Mng", 2, paramWatchTogetherInfo.toString());
      }
    }
  }
  
  private void a(WTogetherPlayInfo paramWTogetherPlayInfo, String paramString)
  {
    if ((paramWTogetherPlayInfo != null) && (paramWTogetherPlayInfo.g[2] == 0))
    {
      paramWTogetherPlayInfo.g[2] = true;
      b(BaseApplicationImpl.getContext().getString(2131893763), true);
      AVUtil.a("0X800B8B6", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        paramWTogetherPlayInfo = new StringBuilder();
        paramWTogetherPlayInfo.append("showResourceExpire, from[");
        paramWTogetherPlayInfo.append(paramString);
        paramWTogetherPlayInfo.append("]");
        QLog.i("WTogether.Mng", 2, paramWTogetherPlayInfo.toString());
      }
    }
  }
  
  private void a(WTogetherPlayInfo paramWTogetherPlayInfo, boolean paramBoolean, String paramString)
  {
    if ((paramWTogetherPlayInfo != null) && (paramWTogetherPlayInfo.b != null) && (paramWTogetherPlayInfo.b.h == 1) && (paramWTogetherPlayInfo.f <= 3600))
    {
      Object localObject = paramWTogetherPlayInfo.g;
      int i = paramWTogetherPlayInfo.f;
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if (i > 0)
      {
        int j;
        if (i <= 900)
        {
          if (localObject[0] == 0)
          {
            if (paramBoolean)
            {
              j = i / 60;
              if (j != 0)
              {
                paramWTogetherPlayInfo = new StringBuilder();
                paramWTogetherPlayInfo.append(j);
                paramWTogetherPlayInfo.append("分钟");
                paramWTogetherPlayInfo = paramWTogetherPlayInfo.toString();
              }
              else
              {
                paramWTogetherPlayInfo = new StringBuilder();
                paramWTogetherPlayInfo.append(i % 60);
                paramWTogetherPlayInfo.append("秒");
                paramWTogetherPlayInfo = paramWTogetherPlayInfo.toString();
              }
              paramWTogetherPlayInfo = localBaseApplication.getString(2131893764, new Object[] { paramWTogetherPlayInfo });
            }
            else
            {
              paramWTogetherPlayInfo = localBaseApplication.getString(2131893764, new Object[] { "15分钟" });
            }
            localObject[0] = 1;
            break label289;
          }
        }
        else if (localObject[1] == 0)
        {
          if (paramBoolean)
          {
            j = i / 60;
            paramWTogetherPlayInfo = new StringBuilder();
            paramWTogetherPlayInfo.append(j);
            paramWTogetherPlayInfo.append("分钟");
            paramWTogetherPlayInfo = localBaseApplication.getString(2131893764, new Object[] { paramWTogetherPlayInfo.toString() });
          }
          else
          {
            paramWTogetherPlayInfo = localBaseApplication.getString(2131893764, new Object[] { "1小时" });
          }
          localObject[1] = 1;
          break label289;
        }
      }
      paramWTogetherPlayInfo = "";
      label289:
      if (!TextUtils.isEmpty(paramWTogetherPlayInfo))
      {
        b(paramWTogetherPlayInfo, false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i / 60);
        ((StringBuilder)localObject).append("");
        AVUtil.a("0X800B8B5", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("showPayedResourceLeftTimeIfNeed, from[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("], leftTime[");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("], tip[");
          ((StringBuilder)localObject).append(paramWTogetherPlayInfo);
          ((StringBuilder)localObject).append("]");
          QLog.i("WTogether.Mng", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void a(WTogetherRoom paramWTogetherRoom)
  {
    Object localObject;
    if (paramWTogetherRoom == null) {
      localObject = null;
    } else {
      localObject = paramWTogetherRoom.h;
    }
    if ((localObject != null) && (((WTogetherPlayInfo)localObject).b()) && (paramWTogetherRoom.e() == 3))
    {
      paramWTogetherRoom = new WTReqUrlResult(paramWTogetherRoom.b, paramWTogetherRoom.c, 0, ((WTogetherPlayInfo)localObject).a, 1, true);
      paramWTogetherRoom.h = ((WTogetherPlayInfo)localObject).b.c;
      paramWTogetherRoom.i = ((WTogetherPlayInfo)localObject).b.d;
      paramWTogetherRoom.l = true;
      paramWTogetherRoom.j = 0;
      paramWTogetherRoom.k = null;
      a(paramWTogetherRoom);
      ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).notifyUI(1, true, paramWTogetherRoom);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMsgOnChangeFile, illegal param, room[");
      ((StringBuilder)localObject).append(paramWTogetherRoom);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Mng", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(WTogetherRoom paramWTogetherRoom, WTogetherCommon.RoomInfo paramRoomInfo, String paramString)
  {
    if (paramRoomInfo != null)
    {
      if (paramWTogetherRoom == null) {
        return;
      }
      boolean bool1 = paramWTogetherRoom.a(paramRoomInfo, paramString);
      paramRoomInfo = paramWTogetherRoom.h;
      if (paramRoomInfo != null)
      {
        a(paramRoomInfo, bool1, paramString);
        if (paramRoomInfo.a())
        {
          if (bool1)
          {
            paramWTogetherRoom.a(3, 3, paramString);
            a(paramRoomInfo, paramString);
          }
          else if ("onSyncPlayInfo".equalsIgnoreCase(paramString))
          {
            paramWTogetherRoom.a(4, 3, paramString);
            a(paramRoomInfo, paramString);
          }
        }
        else
        {
          boolean bool2 = paramRoomInfo.b();
          long l = 200L;
          if (bool2)
          {
            if (bool1)
            {
              paramWTogetherRoom.a(3, 2, paramString);
              paramRoomInfo = Message.obtain();
              paramRoomInfo.what = 3;
              paramRoomInfo.obj = paramWTogetherRoom;
              WeakReferenceHandler localWeakReferenceHandler = this.e;
              if (paramWTogetherRoom.i()) {
                l = 50L;
              }
              localWeakReferenceHandler.sendMessageDelayed(paramRoomInfo, l);
            }
            else if ((paramWTogetherRoom.e() == 3) && (paramWTogetherRoom.f() != 2))
            {
              paramWTogetherRoom.a(3, 2, paramString);
            }
          }
          else if (paramRoomInfo.a.a == 0)
          {
            paramWTogetherRoom.a(3, 1, paramString);
            paramWTogetherRoom.h.a.n = ((int)AudioHelper.c());
            ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).a(paramWTogetherRoom.b, paramWTogetherRoom.c, paramWTogetherRoom.h.a.n, paramWTogetherRoom.h.a, true, 0);
          }
          else if (bool1)
          {
            paramWTogetherRoom.a(3, 3, paramString);
            a(BaseApplicationImpl.getApplication().getString(2131893746), 200L);
          }
        }
      }
      if ((bool1) && (QLog.isColorLevel()))
      {
        paramRoomInfo = new StringBuilder();
        paramRoomInfo.append("updateRoomInfo, from[");
        paramRoomInfo.append(paramString);
        paramRoomInfo.append("], room[");
        paramRoomInfo.append(paramWTogetherRoom);
        paramRoomInfo.append("]");
        QLog.i("WTogether.Mng", 2, paramRoomInfo.toString());
      }
    }
  }
  
  private void a(WatchTogetherInfo paramWatchTogetherInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("quitWatchTogether, reason[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("WTogether.Mng", 2, localStringBuilder.toString());
    }
    if (paramWatchTogetherInfo == null) {
      paramString = null;
    } else {
      paramString = paramWatchTogetherInfo.g;
    }
    if (paramString == null)
    {
      d(paramWatchTogetherInfo);
      return;
    }
    paramWatchTogetherInfo.i = paramInt;
    if (paramString.i())
    {
      a(paramWatchTogetherInfo);
      return;
    }
    c(paramWatchTogetherInfo);
  }
  
  private void a(WatchTogetherInfo paramWatchTogetherInfo, String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramWatchTogetherInfo == null) {
      localObject1 = null;
    } else {
      localObject1 = paramWatchTogetherInfo.g;
    }
    if (localObject1 != null)
    {
      if (!((WTogetherRoom)localObject1).i()) {
        return;
      }
      if (paramWatchTogetherInfo.f != null)
      {
        if (paramWatchTogetherInfo.f.b == 0) {
          paramWatchTogetherInfo.j = 4;
        } else if (paramWatchTogetherInfo.f.b == 1) {
          paramWatchTogetherInfo.j = 3;
        } else {
          paramWatchTogetherInfo.j = 0;
        }
      }
      else {
        paramWatchTogetherInfo.j = 0;
      }
      if (((WTogetherRoom)localObject1).h == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = ((WTogetherRoom)localObject1).h.a;
      }
      if ((localObject1 != null) && (((WTFileInfo)localObject1).a == 0)) {
        ((WTFileInfo)localObject1).o = paramWatchTogetherInfo.j;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateWTFileInfoVideoSrcTypeExtra, from[");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("], videoSrcTypeExtra[");
        ((StringBuilder)localObject1).append(paramWatchTogetherInfo.j);
        ((StringBuilder)localObject1).append("]");
        QLog.i("WTogether.Mng", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    paramString = new WTogetherMng.2(this, paramString);
    if (paramLong == 0L)
    {
      this.e.post(paramString);
      return;
    }
    this.e.postDelayed(paramString, paramLong);
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
    if (QLog.isDevelopLevel())
    {
      paramPushMsg = new StringBuilder();
      paramPushMsg.append("onQavPushMsg, [roomType: ");
      paramPushMsg.append(i);
      paramPushMsg.append(", roomId: ");
      paramPushMsg.append(l1);
      paramPushMsg.append(", operator: ");
      paramPushMsg.append(l2);
      paramPushMsg.append(", action: ");
      paramPushMsg.append(j);
      paramPushMsg.append(", seq: ");
      paramPushMsg.append(l3);
      paramPushMsg.append("]");
      QLog.i("WTogether.Mng", 4, paramPushMsg.toString());
    }
    if (j != 100)
    {
      switch (j)
      {
      default: 
        return;
      case 9: 
      case 10: 
        boolean bool;
        if (j == 9) {
          bool = true;
        } else {
          bool = false;
        }
        a(i, l1, l2, l3, bool);
        return;
      case 8: 
        c(i, l1, l2);
        return;
      case 7: 
        b(i, l1, l2);
        return;
      case 6: 
        a(i, l1, l2);
        return;
      }
      a(i, l1, l2, l3, j);
      return;
    }
    d(i, l1, l2);
  }
  
  private boolean a(SessionInfo paramSessionInfo, ChooseFileInfo paramChooseFileInfo, long[] paramArrayOfLong)
  {
    if ((paramChooseFileInfo != null) && (paramSessionInfo != null))
    {
      WatchTogetherInfo localWatchTogetherInfo = a(paramSessionInfo);
      WTogetherRoom localWTogetherRoom = null;
      if (localWatchTogetherInfo != null)
      {
        localWatchTogetherInfo.a(paramSessionInfo, true);
        localWTogetherRoom = localWatchTogetherInfo.f();
      }
      if (localWTogetherRoom == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WTogether.Mng", 2, "startWatchTogether, not valid to create room.");
        }
        return false;
      }
      int i = localWTogetherRoom.e();
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          paramSessionInfo = new StringBuilder();
          paramSessionInfo.append("startWatchTogether, illegal state, roomState[");
          paramSessionInfo.append(i);
          paramSessionInfo.append("]");
          QLog.i("WTogether.Mng", 2, paramSessionInfo.toString());
        }
        return false;
      }
      localWatchTogetherInfo.i = 0;
      this.e.removeMessages(5);
      e(localWatchTogetherInfo);
      localWatchTogetherInfo.f = paramChooseFileInfo;
      localWatchTogetherInfo.a(1, "startWatchTogether");
      localWTogetherRoom.a(localWTogetherRoom.d);
      localWTogetherRoom.a(1, 1, "startWatchTogether");
      a(true);
      ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).a(localWTogetherRoom.b, localWTogetherRoom.c, paramChooseFileInfo, paramArrayOfLong, 0);
      this.e.removeMessages(7);
      this.e.sendEmptyMessageDelayed(7, 30000L);
      if (QLog.isDevelopLevel())
      {
        paramSessionInfo = new StringBuilder();
        paramSessionInfo.append("startWatchTogether, room[");
        paramSessionInfo.append(localWTogetherRoom);
        paramSessionInfo.append("]");
        QLog.i("WTogether.Mng", 4, paramSessionInfo.toString());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "startWatchTogether, illegal param.");
    }
    return false;
  }
  
  private boolean a(WTInfoFromPush paramWTInfoFromPush)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramWTInfoFromPush == null) {
      return false;
    }
    Object localObject = a(paramWTInfoFromPush.a, paramWTInfoFromPush.b, paramWTInfoFromPush.c, paramWTInfoFromPush.d);
    if (localObject == null) {
      return false;
    }
    WatchTogetherInfo localWatchTogetherInfo = b((SessionInfo)localObject);
    if (localWatchTogetherInfo == null) {
      return false;
    }
    WTogetherRoom localWTogetherRoom = localWatchTogetherInfo.g;
    if (localWTogetherRoom != null)
    {
      if (localWTogetherRoom.e() == 0) {
        return false;
      }
      long l1 = localWatchTogetherInfo.d();
      int i = localWatchTogetherInfo.c();
      long l2 = ((SessionInfo)localObject).D();
      boolean bool1 = bool3;
      if (localWTogetherRoom.i())
      {
        bool1 = bool3;
        if (l1 == l2)
        {
          bool1 = bool3;
          if (l1 != 0L) {
            if (l1 == paramWTInfoFromPush.b)
            {
              bool1 = bool3;
              if (i == paramWTInfoFromPush.a) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        bool2 = bool1;
        if (bool1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkRoomIdConflict, error. come[");
          ((StringBuilder)localObject).append(paramWTInfoFromPush.a);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(paramWTInfoFromPush.b);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(paramWTInfoFromPush.c);
          ((StringBuilder)localObject).append("], cur[");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(localWTogetherRoom.e);
          ((StringBuilder)localObject).append("]");
          QLog.i("WTogether.Mng", 2, ((StringBuilder)localObject).toString());
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  private WatchTogetherInfo b(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    boolean bool = TextUtils.equals(String.valueOf(paramLong2), this.c.getCurrentAccountUin());
    StringBuilder localStringBuilder = null;
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(", self receive start push. [roomType: ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", roomId: ");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append("]");
        QLog.i("WTogether.Mng", 2, localStringBuilder.toString());
      }
      return null;
    }
    Object localObject = a(paramInt, paramLong1, paramLong2, paramString);
    if ((localObject != null) && (!((SessionInfo)localObject).e()))
    {
      WTInfoFromPush localWTInfoFromPush = new WTInfoFromPush(paramInt, paramLong1, paramLong2, paramString);
      paramString = b((SessionInfo)localObject);
      if (paramString == null)
      {
        paramString = a((SessionInfo)localObject);
      }
      else if (a(localWTInfoFromPush))
      {
        localObject = paramString.g;
        if ((localObject != null) && (((WTogetherRoom)localObject).e() == 1) && (((WTogetherRoom)localObject).f() == 1))
        {
          paramString.h = localWTInfoFromPush;
          paramString = localStringBuilder;
        }
        else
        {
          paramString = localStringBuilder;
          if (localObject != null)
          {
            b(localWTInfoFromPush);
            paramString = localStringBuilder;
          }
        }
      }
      if (paramString != null)
      {
        paramString.a(1, "getWatchTogetherInfoForPush");
        paramString.a(paramInt, paramLong1);
      }
      return paramString;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(", session is illegal. [roomType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", roomId: ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.i("WTogether.Mng", 2, localStringBuilder.toString());
    }
    return null;
  }
  
  private void b()
  {
    Object localObject = SessionMgr.a().b();
    if (localObject != null)
    {
      if (((SessionInfo)localObject).e()) {
        return;
      }
      localObject = b((SessionInfo)localObject);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((WatchTogetherInfo)localObject).g;
      }
      if (localObject != null)
      {
        if (((WTogetherRoom)localObject).e() != 4) {
          return;
        }
        ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).a(((WTogetherRoom)localObject).b, ((WTogetherRoom)localObject).c, ((WTogetherRoom)localObject).a, ((WTogetherRoom)localObject).j);
        this.e.sendEmptyMessageDelayed(1, 10000L);
      }
    }
  }
  
  private void b(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = a(paramInt, paramLong1);
    WTogetherRoom localWTogetherRoom;
    if (localObject == null) {
      localWTogetherRoom = null;
    } else {
      localWTogetherRoom = ((WatchTogetherInfo)localObject).g;
    }
    if (localWTogetherRoom == null) {
      return;
    }
    ((WatchTogetherInfo)localObject).i = 2;
    if (localWTogetherRoom.i())
    {
      a((WatchTogetherInfo)localObject);
      return;
    }
    localWTogetherRoom.a(5, 1, "onReceiveClosePush");
    localObject = new ReqComResult(localWTogetherRoom.b, localWTogetherRoom.c);
    b((ReqComResult)localObject);
    ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).notifyUI(8, ((ReqComResult)localObject).c, localObject);
    b(localWTogetherRoom, 2131893750);
  }
  
  private void b(WTInfoFromPush paramWTInfoFromPush)
  {
    if (paramWTInfoFromPush == null) {
      return;
    }
    paramWTInfoFromPush = a(paramWTInfoFromPush.a, paramWTInfoFromPush.b, paramWTInfoFromPush.c, "dealForRoomIdConflict");
    if (paramWTInfoFromPush == null) {
      return;
    }
    paramWTInfoFromPush = b(paramWTInfoFromPush);
    if (paramWTInfoFromPush == null) {
      return;
    }
    if (paramWTInfoFromPush.g == null) {
      return;
    }
    a(paramWTInfoFromPush, 6, "dealForRoomIdConflict");
    a(BaseApplicationImpl.getContext().getString(2131893775), 100L);
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "dealForRoomIdConflict");
    }
  }
  
  private void b(WTogetherRoom paramWTogetherRoom, int paramInt)
  {
    if (paramWTogetherRoom == null) {
      return;
    }
    a(BaseApplicationImpl.getContext().getString(paramInt, new Object[] { paramWTogetherRoom.f }), 300L);
  }
  
  private void b(String paramString)
  {
    if (!this.e.hasMessages(1))
    {
      this.e.sendEmptyMessageDelayed(1, 10000L);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startSync, from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("WTogether.Mng", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).notifyUI(11, paramBoolean, paramString);
  }
  
  private void c(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = b(paramInt, paramLong1, paramLong2, "onReceiveChangeFilePush");
    if ((localObject != null) && (((WatchTogetherInfo)localObject).b()))
    {
      localObject = ((WatchTogetherInfo)localObject).f();
      if ((localObject != null) && (((WTogetherRoom)localObject).e() == 0))
      {
        ((WTogetherRoom)localObject).a(String.valueOf(paramLong2));
        b(a(paramInt, paramLong1));
        return;
      }
      if ((localObject != null) && (TextUtils.equals(((WTogetherRoom)localObject).e, String.valueOf(paramLong2))))
      {
        a((WTogetherRoom)localObject, 8);
        b((WTogetherRoom)localObject, 2131893745);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceiveChangeFilePush, illegal. [roomType: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", roomId: ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Mng", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void c(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString, false);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMsgClearInfo, info[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("WTogether.Mng", 4, localStringBuilder.toString());
    }
    if (paramString == null) {
      return;
    }
    d(paramString);
  }
  
  private void c(String paramString)
  {
    if (this.e.hasMessages(1))
    {
      this.e.removeMessages(1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopSync, from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("WTogether.Mng", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void d(int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onReceiveSecurityInfo");
    }
    WatchTogetherInfo localWatchTogetherInfo = a(paramInt, paramLong1);
    Object localObject;
    if (localWatchTogetherInfo == null) {
      localObject = null;
    } else {
      localObject = localWatchTogetherInfo.g;
    }
    if (localObject == null) {
      return;
    }
    localWatchTogetherInfo.i = 8;
    if (((WTogetherRoom)localObject).i())
    {
      a(localWatchTogetherInfo);
    }
    else
    {
      ((WTogetherRoom)localObject).a(5, 1, "onReceiveClosePush");
      localObject = new ReqComResult(((WTogetherRoom)localObject).b, ((WTogetherRoom)localObject).c);
      b((ReqComResult)localObject);
      ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).notifyUI(8, ((ReqComResult)localObject).c, localObject);
    }
    VideoController.f().e.a(new Object[] { Integer.valueOf(10007) });
  }
  
  private void d(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAVSDKWTogetherFlag, flag[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("WTogether.Mng", 2, localStringBuilder.toString());
    }
    paramString = VideoController.f().aG();
    if (paramString != null) {
      paramString.a(SessionMgr.a().b().s, paramInt, true);
    }
  }
  
  private void d(WatchTogetherInfo paramWatchTogetherInfo)
  {
    if (paramWatchTogetherInfo == null) {
      return;
    }
    Object localObject1 = paramWatchTogetherInfo.b;
    ??? = SessionMgr.a().d((String)localObject1);
    int i;
    if ((??? != null) && (!((SessionInfo)???).e()))
    {
      if ((paramWatchTogetherInfo.d() != 0L) && (((SessionInfo)???).D() != paramWatchTogetherInfo.d()))
      {
        paramWatchTogetherInfo.a((SessionInfo)???, true);
        i = 2;
        break label127;
      }
      synchronized (this.d)
      {
        this.d.remove(localObject1);
        i = 1;
      }
    }
    synchronized (this.d)
    {
      this.d.remove(localObject1);
      i = 0;
      label127:
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("clearInfo, ret[");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("], info[");
        ((StringBuilder)localObject1).append(paramWatchTogetherInfo);
        ((StringBuilder)localObject1).append("]");
        QLog.i("WTogether.Mng", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
  }
  
  private void e(WatchTogetherInfo paramWatchTogetherInfo)
  {
    boolean bool;
    if (this.e.hasMessages(6))
    {
      this.e.removeMessages(6);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (paramWatchTogetherInfo != null)
    {
      if (paramWatchTogetherInfo.h != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramWatchTogetherInfo.h = null;
    }
    if (QLog.isDevelopLevel())
    {
      paramWatchTogetherInfo = new StringBuilder();
      paramWatchTogetherInfo.append("clearConflictInfo, hasConflict[");
      paramWatchTogetherInfo.append(bool);
      paramWatchTogetherInfo.append("]");
      QLog.i("WTogether.Mng", 2, paramWatchTogetherInfo.toString());
    }
  }
  
  public WatchTogetherInfo a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return null;
    }
    return a(paramSessionInfo.z(), paramSessionInfo.A(), true);
  }
  
  protected void a() {}
  
  public void a(int paramInt, String paramString)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramInt, paramString, false);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearForClose, [relationType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", relationId: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", info: ");
      localStringBuilder.append(localWatchTogetherInfo);
      localStringBuilder.append("]");
      QLog.i("WTogether.Mng", 4, localStringBuilder.toString());
    }
    e(localWatchTogetherInfo);
    a(localWatchTogetherInfo, 3, "clearForClose");
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = true;
    if (paramInt2 != 1) {
      bool = false;
    }
    Object localObject = a(paramInt1, paramString, bool);
    if (localObject != null) {
      ((WatchTogetherInfo)localObject).a(paramInt2, "updateFlg");
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateFlag, [relationType: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", relationId: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", flag: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Mng", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, String paramString, ChooseFileInfo paramChooseFileInfo, long[] paramArrayOfLong)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramInt, paramString, true);
    if (localWatchTogetherInfo != null)
    {
      if (paramInt == 3)
      {
        localWatchTogetherInfo.k.clear();
        localWatchTogetherInfo.k.add(Long.valueOf(AVUtil.c(paramString)));
      }
      else if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
      {
        localWatchTogetherInfo.k.clear();
        int j = paramArrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          long l = paramArrayOfLong[i];
          localWatchTogetherInfo.k.add(Long.valueOf(l));
          i += 1;
        }
      }
      localWatchTogetherInfo.f = paramChooseFileInfo;
      if (paramChooseFileInfo != null) {
        localWatchTogetherInfo.a(1, "updateChooseFile");
      }
      if (paramChooseFileInfo != null) {
        AVUtil.a("0X800B62A", paramChooseFileInfo.b(), 0, paramChooseFileInfo.f(), paramChooseFileInfo.e(), paramChooseFileInfo.c(), paramChooseFileInfo.d());
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("updateChooseFile, [relationType: ");
      paramArrayOfLong.append(paramInt);
      paramArrayOfLong.append(", relationId: ");
      paramArrayOfLong.append(paramString);
      paramArrayOfLong.append(", file: ");
      paramArrayOfLong.append(paramChooseFileInfo);
      paramArrayOfLong.append("]");
      QLog.i("WTogether.Mng", 4, paramArrayOfLong.toString());
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt == 4) && (paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      int j = 0;
      WTogetherCommon.PushMsg localPushMsg = new WTogetherCommon.PushMsg();
      int i;
      try
      {
        localPushMsg.mergeFrom(paramArrayOfByte);
        i = 1;
      }
      catch (Throwable paramArrayOfByte)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("WTogether.Mng", 2, "onReceivePushMsg", paramArrayOfByte);
          i = j;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("WTogether.Mng", 2, "onReceivePushMsg", paramArrayOfByte);
          i = j;
        }
      }
      if (i != 0)
      {
        paramArrayOfByte = Message.obtain();
        paramArrayOfByte.what = 4;
        paramArrayOfByte.arg1 = paramInt;
        paramArrayOfByte.obj = localPushMsg;
        this.e.sendMessage(paramArrayOfByte);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "onReceivePushMsg, param illegal.");
    }
  }
  
  public void a(SessionInfo paramSessionInfo, int paramInt, Intent paramIntent)
  {
    int i = -1;
    Object localObject2 = null;
    Object localObject1;
    if ((paramInt == 4660) && (paramIntent != null))
    {
      paramIntent.setExtrasClassLoader(ChooseFileInfo.class.getClassLoader());
      localObject1 = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
      paramInt = paramIntent.getIntExtra("watch_together_uinType", -1);
      localObject2 = paramIntent.getStringExtra("watch_together_uin");
      paramIntent = (Intent)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = null;
      paramIntent = (Intent)localObject2;
      paramInt = i;
    }
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onActivityResult, uinType[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], uin[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("], choose[");
      ((StringBuilder)localObject2).append(paramIntent);
      ((StringBuilder)localObject2).append("]");
      QLog.i("WTogether.Mng", 4, ((StringBuilder)localObject2).toString());
    }
    if ((paramIntent != null) && (paramSessionInfo != null) && (paramSessionInfo.p == paramInt) && (TextUtils.equals((CharSequence)localObject1, paramSessionInfo.s)))
    {
      if ((paramIntent.o == 1) && (!WTogetherUtil.c(paramSessionInfo.s)))
      {
        b(BaseApplicationImpl.getContext().getString(2131893768), true);
        AVUtil.a("0X800B8B7", 0, 0, "", "", "", "");
        return;
      }
      localObject1 = b(paramSessionInfo);
      if ((localObject1 != null) && (((WatchTogetherInfo)localObject1).g != null) && (((WatchTogetherInfo)localObject1).g.h()))
      {
        a(paramSessionInfo, paramIntent);
        return;
      }
      a(paramSessionInfo, paramIntent, new long[] { AVUtil.c(paramSessionInfo.s) });
    }
  }
  
  public void a(SessionInfo paramSessionInfo, WTSyncPlayInfo paramWTSyncPlayInfo)
  {
    paramSessionInfo = b(paramSessionInfo);
    if (paramSessionInfo == null) {
      paramSessionInfo = null;
    } else {
      paramSessionInfo = paramSessionInfo.g;
    }
    if ((paramSessionInfo != null) && (!paramSessionInfo.g()))
    {
      if (!paramSessionInfo.h()) {
        return;
      }
      paramSessionInfo.j.a(paramWTSyncPlayInfo);
      b("syncPlayInfo");
    }
  }
  
  public void a(SessionInfo paramSessionInfo, WTVideoInfo paramWTVideoInfo, boolean paramBoolean)
  {
    Object localObject1 = b(paramSessionInfo);
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((WatchTogetherInfo)localObject1).g;
    }
    if (localObject1 != null) {
      localObject2 = ((WTogetherRoom)localObject1).h;
    }
    if ((localObject2 != null) && (((WTogetherPlayInfo)localObject2).a(paramWTVideoInfo)))
    {
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 3;
      }
      ((WTogetherRoom)localObject1).a(4, i, "onStartPlayResult");
    }
    b("updatePlayResult");
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updatePlayResult, videoInfo[");
      ((StringBuilder)localObject2).append(paramWTVideoInfo);
      ((StringBuilder)localObject2).append("], room[");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("], session[");
      ((StringBuilder)localObject2).append(paramSessionInfo);
      ((StringBuilder)localObject2).append("], success[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("]");
      QLog.i("WTogether.Mng", 4, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchTerminalSuccess, isSelfSwitchTerminal[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], session[");
      localStringBuilder.append(paramSessionInfo);
      localStringBuilder.append("]");
      QLog.i("WTogether.Mng", 4, localStringBuilder.toString());
    }
  }
  
  void a(ReqComResult paramReqComResult)
  {
    this.e.removeMessages(8);
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.a, paramReqComResult.b);
    Object localObject;
    if (localWatchTogetherInfo == null) {
      localObject = null;
    } else {
      localObject = localWatchTogetherInfo.g;
    }
    if (localObject != null)
    {
      if (((WTogetherRoom)localObject).e() != 5) {
        return;
      }
      int i = localWatchTogetherInfo.i;
      ((WTogetherRoom)localObject).b("onCloseWTogether");
      d(localWatchTogetherInfo);
      d(0, "onCloseWTogether");
      a(localWatchTogetherInfo, true);
      if (i == 5) {
        a(200L, "onCloseWTogether");
      }
      WTDataReportUtil.b();
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCloseWTogether, result[");
        ((StringBuilder)localObject).append(paramReqComResult);
        ((StringBuilder)localObject).append("], quitReason[");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("]");
        QLog.i("WTogether.Mng", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  void a(ReqComResult paramReqComResult, long paramLong, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.a, paramReqComResult.b);
    WTogetherRoom localWTogetherRoom;
    if (localWatchTogetherInfo == null) {
      localWTogetherRoom = null;
    } else {
      localWTogetherRoom = localWatchTogetherInfo.g;
    }
    if ((localWTogetherRoom != null) && (!localWTogetherRoom.g()) && (localWTogetherRoom.h()))
    {
      if ((paramReqComResult.c) && (paramRoomInfo != null)) {
        a(localWTogetherRoom, paramRoomInfo, "onSyncPlayInfo");
      }
      if (!paramReqComResult.c) {
        a(paramReqComResult, localWatchTogetherInfo, localWTogetherRoom, "onSyncPlayInfo");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramReqComResult = new StringBuilder();
      paramReqComResult.append("onSyncPlayInfo, room[");
      paramReqComResult.append(localWTogetherRoom);
      paramReqComResult.append("]");
      QLog.i("WTogether.Mng", 2, paramReqComResult.toString());
    }
  }
  
  void a(ReqComResult paramReqComResult, ChooseFileInfo paramChooseFileInfo, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    this.e.removeMessages(7);
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.a, paramReqComResult.b);
    if ((localWatchTogetherInfo != null) && (paramChooseFileInfo != null) && (paramChooseFileInfo.equals(localWatchTogetherInfo.f)))
    {
      Object localObject = localWatchTogetherInfo.g;
      if ((localObject != null) && (((WTogetherRoom)localObject).i()) && (((WTogetherRoom)localObject).e() == 1))
      {
        if ((paramReqComResult.c) && (paramRoomInfo != null))
        {
          ((WTogetherRoom)localObject).a(1, 2, "onStartWTogether");
          a((WTogetherRoom)localObject, paramRoomInfo, "onStartWTogether");
          if (a(localWatchTogetherInfo.h)) {
            this.e.sendEmptyMessageDelayed(6, 200L);
          }
          if (((WTogetherRoom)localObject).h.a.a == 0)
          {
            AVUtil.a("0X800B62D", paramChooseFileInfo.b(), 0, "", paramChooseFileInfo.e(), paramChooseFileInfo.c(), paramChooseFileInfo.d());
          }
          else if (((WTogetherRoom)localObject).h.b != null)
          {
            WTVideoInfo localWTVideoInfo = ((WTogetherRoom)localObject).h.b;
            int i = paramChooseFileInfo.b();
            paramRoomInfo = paramChooseFileInfo.e();
            localObject = localWTVideoInfo.b;
            if (localWTVideoInfo.b()) {
              paramChooseFileInfo = localWTVideoInfo.e;
            } else {
              paramChooseFileInfo = localWTVideoInfo.c;
            }
            AVUtil.a("0X800B62D", i, 0, "", paramRoomInfo, (String)localObject, paramChooseFileInfo);
          }
          WTDataReportUtil.a();
          a(localWatchTogetherInfo, "onStartWTogether");
        }
        else
        {
          localWatchTogetherInfo.f = null;
          localWatchTogetherInfo.a(0, "onStartWTogether");
          ((WTogetherRoom)localObject).b("onStartWTogether");
          a(localWatchTogetherInfo, true);
          if (paramReqComResult.d == 1019) {
            a(200L, "onStartWTogether");
          }
        }
        if (paramReqComResult.c) {
          d(1, "onStartWTogether");
        }
        if (QLog.isDevelopLevel())
        {
          paramChooseFileInfo = new StringBuilder();
          paramChooseFileInfo.append("onStartWTogether, result[");
          paramChooseFileInfo.append(paramReqComResult);
          paramChooseFileInfo.append("]");
          QLog.i("WTogether.Mng", 4, paramChooseFileInfo.toString());
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        paramReqComResult = new StringBuilder();
        paramReqComResult.append("onStartWTogether, room[");
        paramReqComResult.append(localObject);
        paramReqComResult.append("]");
        QLog.i("WTogether.Mng", 2, paramReqComResult.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramReqComResult = new StringBuilder();
      paramReqComResult.append("onStartWTogether, info[");
      paramReqComResult.append(localWatchTogetherInfo);
      paramReqComResult.append("]");
      QLog.i("WTogether.Mng", 2, paramReqComResult.toString());
    }
  }
  
  void a(ReqComResult paramReqComResult, ReqVideoAction paramReqVideoAction, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.a, paramReqComResult.b);
    if (localWatchTogetherInfo == null) {
      paramReqVideoAction = null;
    } else {
      paramReqVideoAction = localWatchTogetherInfo.g;
    }
    if ((paramReqVideoAction != null) && (paramReqVideoAction.i()) && (!paramReqVideoAction.g()) && (paramReqVideoAction.h()))
    {
      if ((paramReqComResult.c) && (paramRoomInfo != null)) {
        a(paramReqVideoAction, paramRoomInfo, "onChangeVideoStatus");
      }
      if (QLog.isDevelopLevel())
      {
        paramRoomInfo = new StringBuilder();
        paramRoomInfo.append("onChangeVideoStatus, result[");
        paramRoomInfo.append(paramReqComResult);
        paramRoomInfo.append("]");
        QLog.i("WTogether.Mng", 4, paramRoomInfo.toString());
      }
      if (!paramReqComResult.c) {
        a(paramReqComResult, localWatchTogetherInfo, paramReqVideoAction, "onChangeVideoStatus");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramReqComResult = new StringBuilder();
      paramReqComResult.append("onChangeVideoStatus, room[");
      paramReqComResult.append(paramReqVideoAction);
      paramReqComResult.append("]");
      QLog.i("WTogether.Mng", 2, paramReqComResult.toString());
    }
  }
  
  void a(ReqComResult paramReqComResult, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.a, paramReqComResult.b);
    WTogetherRoom localWTogetherRoom;
    if (localWatchTogetherInfo == null) {
      localWTogetherRoom = null;
    } else {
      localWTogetherRoom = localWatchTogetherInfo.g;
    }
    if (localWTogetherRoom == null) {
      return;
    }
    if ((paramReqComResult.c) && (paramRoomInfo != null)) {
      a(localWTogetherRoom, paramRoomInfo, "onGetRoomInfo");
    }
    if (QLog.isDevelopLevel())
    {
      paramRoomInfo = new StringBuilder();
      paramRoomInfo.append("onGetRoomInfo, room[");
      paramRoomInfo.append(localWTogetherRoom);
      paramRoomInfo.append("], result[");
      paramRoomInfo.append(paramReqComResult);
      paramRoomInfo.append("]");
      QLog.i("WTogether.Mng", 4, paramRoomInfo.toString());
    }
    if (!paramReqComResult.c) {
      a(paramReqComResult, localWatchTogetherInfo, localWTogetherRoom, "onGetRoomInfo");
    }
  }
  
  void a(WTReqUrlResult paramWTReqUrlResult)
  {
    Object localObject = a(paramWTReqUrlResult.a, paramWTReqUrlResult.b);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((WatchTogetherInfo)localObject).g;
    }
    if ((localObject != null) && (((WTogetherRoom)localObject).e() == 3) && (((WTogetherRoom)localObject).h != null) && (((WTogetherRoom)localObject).h.a != null) && (((WTogetherRoom)localObject).h.a.equals(paramWTReqUrlResult.d)))
    {
      if ((paramWTReqUrlResult.l) && (!TextUtils.isEmpty(paramWTReqUrlResult.h)))
      {
        if (((WTogetherRoom)localObject).h.b == null) {
          ((WTogetherRoom)localObject).h.b = new WTVideoInfo(((WTogetherRoom)localObject).h.a.a, ((WTogetherRoom)localObject).h.a.b, paramWTReqUrlResult.h, paramWTReqUrlResult.i, null, null, null, 0, null, 0L);
        }
        ((WTogetherRoom)localObject).a(4, 0, "onRequestUrl");
      }
      else
      {
        ((WTogetherRoom)localObject).a(3, 3, "onRequestUrl");
      }
      StringBuilder localStringBuilder = new StringBuilder("content:");
      localStringBuilder.append("roomid=");
      localStringBuilder.append(paramWTReqUrlResult.b);
      localStringBuilder.append("|");
      if ((((WTogetherRoom)localObject).h != null) && (((WTogetherRoom)localObject).h.a != null))
      {
        localStringBuilder.append("file_id=");
        localStringBuilder.append(((WTogetherRoom)localObject).h.a.d);
        localStringBuilder.append("|");
        localStringBuilder.append("file_uuid=");
        localStringBuilder.append(((WTogetherRoom)localObject).h.a.c);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRequestUrl, result[");
        ((StringBuilder)localObject).append(paramWTReqUrlResult);
        ((StringBuilder)localObject).append("] \n");
        ((StringBuilder)localObject).append(localStringBuilder.toString());
        QLog.i("WTogether.Mng", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramWTReqUrlResult = new StringBuilder();
      paramWTReqUrlResult.append("onRequestUrl, room[");
      paramWTReqUrlResult.append(localObject);
      paramWTReqUrlResult.append("]");
      QLog.i("WTogether.Mng", 2, paramWTReqUrlResult.toString());
    }
  }
  
  public void a(WTogetherRoom paramWTogetherRoom, int paramInt)
  {
    if (paramWTogetherRoom == null) {
      return;
    }
    Object localObject = new ReqVideoAction(paramWTogetherRoom.a, paramInt, paramWTogetherRoom.h);
    ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).a(paramWTogetherRoom.b, paramWTogetherRoom.c, (ReqVideoAction)localObject);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryRoomInfo, room[");
      ((StringBuilder)localObject).append(paramWTogetherRoom);
      ((StringBuilder)localObject).append("], action[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Mng", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(WatchTogetherInfo paramWatchTogetherInfo)
  {
    c("closeWTogetherMode");
    WTogetherRoom localWTogetherRoom;
    if (paramWatchTogetherInfo == null) {
      localWTogetherRoom = null;
    } else {
      localWTogetherRoom = paramWatchTogetherInfo.g;
    }
    if ((localWTogetherRoom != null) && (localWTogetherRoom.i()) && (localWTogetherRoom.h()))
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("closeWTogetherMode, room[");
        localStringBuilder.append(localWTogetherRoom);
        localStringBuilder.append("]");
        QLog.i("WTogether.Mng", 4, localStringBuilder.toString());
      }
      WTDataReportUtil.a(localWTogetherRoom.h, "closeWTogetherMode");
      paramWatchTogetherInfo.a(false, "closeWTogetherMode");
      localWTogetherRoom.a(5, 1, "closeWTogetherMode");
      ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).a(localWTogetherRoom.b, localWTogetherRoom.c, 0);
      this.e.removeMessages(8);
      this.e.sendEmptyMessageDelayed(8, 30000L);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramWatchTogetherInfo = new StringBuilder();
      paramWatchTogetherInfo.append("closeWTogetherMode, room[");
      paramWatchTogetherInfo.append(localWTogetherRoom);
      paramWatchTogetherInfo.append("]");
      QLog.i("WTogether.Mng", 2, paramWatchTogetherInfo.toString());
    }
  }
  
  protected void a(WatchTogetherInfo paramWatchTogetherInfo, boolean paramBoolean)
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onExitWTMode, isAdmin[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("WTogether.Mng", 2, localStringBuilder.toString());
    }
    e(paramWatchTogetherInfo);
    this.c.a(new Object[] { Integer.valueOf(9008), Long.valueOf(l), Boolean.valueOf(false) });
    TipsInfo.a().a(true);
  }
  
  protected void a(boolean paramBoolean)
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterWTMode, isAdmin[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.i("WTogether.Mng", 2, localStringBuilder.toString());
    }
    this.c.a(new Object[] { Integer.valueOf(9008), Long.valueOf(l), Boolean.valueOf(true) });
    this.e.post(new WTogetherMng.3(this, l));
    TipsInfo.a().a(false);
  }
  
  public boolean a(SessionInfo paramSessionInfo, ChooseFileInfo paramChooseFileInfo)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramSessionInfo);
    if (localWatchTogetherInfo != null)
    {
      localWatchTogetherInfo.a(paramSessionInfo, false);
      paramSessionInfo = localWatchTogetherInfo.f();
    }
    else
    {
      paramSessionInfo = null;
    }
    if ((paramSessionInfo != null) && (paramSessionInfo.i()) && (paramSessionInfo.h()))
    {
      WTDataReportUtil.a(paramSessionInfo.h, "changeFile");
      localWatchTogetherInfo.f = paramChooseFileInfo;
      localWatchTogetherInfo.a(true, "changeFile");
      paramSessionInfo.a(paramSessionInfo.d);
      ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).a(paramSessionInfo.b, paramSessionInfo.c, paramSessionInfo.a, paramChooseFileInfo);
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramChooseFileInfo = new StringBuilder();
      paramChooseFileInfo.append("changeFile, not valid to change file. room[");
      paramChooseFileInfo.append(paramSessionInfo);
      paramChooseFileInfo.append("]");
      QLog.i("WTogether.Mng", 2, paramChooseFileInfo.toString());
    }
    return false;
  }
  
  public boolean a(SessionInfo paramSessionInfo, ReqVideoAction paramReqVideoAction)
  {
    WatchTogetherInfo localWatchTogetherInfo = b(paramSessionInfo);
    if (localWatchTogetherInfo == null) {
      paramSessionInfo = null;
    } else {
      paramSessionInfo = localWatchTogetherInfo.g;
    }
    if ((paramSessionInfo != null) && ((paramSessionInfo.e() == 4) || ((paramSessionInfo.e() == 3) && (paramSessionInfo.f() == 3))) && (paramReqVideoAction != null) && (paramSessionInfo.i()) && (!localWatchTogetherInfo.e()))
    {
      if (paramReqVideoAction.b == 4) {
        a(BaseApplicationImpl.getContext().getString(2131893748, new Object[] { String.valueOf(paramReqVideoAction.d) }), 0L);
      }
      paramReqVideoAction.a = paramSessionInfo.a();
      ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).a(paramSessionInfo.b, paramSessionInfo.c, paramReqVideoAction, 0);
      return true;
    }
    if (QLog.isDevelopLevel())
    {
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("changeVideoStatus, illegal param or no room. info[");
      paramSessionInfo.append(localWatchTogetherInfo);
      paramSessionInfo.append("]");
      QLog.i("WTogether.Mng", 4, paramSessionInfo.toString());
    }
    return false;
  }
  
  boolean a(ReqComResult paramReqComResult, long paramLong, int paramInt)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramReqComResult != null)
    {
      if (paramReqComResult.d == 1009) {
        return false;
      }
      WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.a, paramReqComResult.b);
      Object localObject;
      if (localWatchTogetherInfo == null) {
        localObject = null;
      } else {
        localObject = localWatchTogetherInfo.g;
      }
      boolean bool1;
      switch (paramInt)
      {
      default: 
        bool1 = bool3;
        if (localObject == null) {
          break label263;
        }
        bool1 = bool3;
        if (((WTogetherRoom)localObject).e() != 4) {
          break label263;
        }
        bool1 = bool3;
        if (paramLong != ((WTogetherRoom)localObject).b()) {
          break label263;
        }
      case 10: 
        if ((goto 150) && (localObject != null))
        {
          bool1 = bool3;
          if (((WTogetherRoom)localObject).e() != 6) {
            break label263;
          }
        }
        break;
      }
      do
      {
        for (;;)
        {
          bool1 = true;
          break;
          bool1 = bool3;
          if (localObject == null) {
            break;
          }
          bool1 = bool3;
          if (((WTogetherRoom)localObject).e() != 2) {
            break;
          }
          continue;
          bool1 = bool3;
          if (localObject == null) {
            break;
          }
          bool1 = bool3;
          if (!((WTogetherRoom)localObject).h()) {
            break;
          }
          bool1 = bool3;
          if (!localWatchTogetherInfo.e()) {
            break;
          }
          if ((goto 150) && (localObject != null))
          {
            bool1 = bool3;
            if (((WTogetherRoom)localObject).e() != 5) {
              break;
            }
          }
        }
        bool1 = bool3;
        if (localObject == null) {
          break;
        }
        bool1 = bool3;
      } while (((WTogetherRoom)localObject).e() == 1);
      label263:
      bool2 = bool1;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkForRetry, {result: ");
        ((StringBuilder)localObject).append(paramReqComResult);
        ((StringBuilder)localObject).append(", seq: ");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", action: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("}");
        QLog.i("WTogether.Mng", 4, ((StringBuilder)localObject).toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public WatchTogetherInfo b(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return null;
    }
    return a(paramSessionInfo.z(), paramSessionInfo.A(), false);
  }
  
  void b(ReqComResult paramReqComResult)
  {
    this.e.removeMessages(10);
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.a, paramReqComResult.b);
    Object localObject;
    if (localWatchTogetherInfo == null) {
      localObject = null;
    } else {
      localObject = localWatchTogetherInfo.g;
    }
    if (localObject == null) {
      return;
    }
    int i = localWatchTogetherInfo.i;
    ((WTogetherRoom)localObject).b("onQuitRoom");
    d(localWatchTogetherInfo);
    d(0, "onQuitRoom");
    a(localWatchTogetherInfo, false);
    if (i == 5) {
      a(200L, "onQuitRoom");
    }
    WTDataReportUtil.b();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onQuitRoom, result[");
      ((StringBuilder)localObject).append(paramReqComResult);
      ((StringBuilder)localObject).append("], quitReason[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.Mng", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  void b(ReqComResult paramReqComResult, ChooseFileInfo paramChooseFileInfo, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.a, paramReqComResult.b);
    if ((localWatchTogetherInfo != null) && (paramChooseFileInfo != null) && (paramChooseFileInfo.equals(localWatchTogetherInfo.f)))
    {
      paramChooseFileInfo = localWatchTogetherInfo.g;
      if ((paramChooseFileInfo != null) && (paramChooseFileInfo.i()) && (!paramChooseFileInfo.g()) && (paramChooseFileInfo.h()))
      {
        localWatchTogetherInfo.a(false, "onChangeVideoFile");
        if ((paramReqComResult.c) && (paramRoomInfo != null))
        {
          a(paramChooseFileInfo, paramRoomInfo, "onChangeVideoFile");
          a(localWatchTogetherInfo, "onChangeVideoFile");
        }
        else
        {
          localWatchTogetherInfo.f = null;
        }
        if (QLog.isDevelopLevel())
        {
          paramRoomInfo = new StringBuilder();
          paramRoomInfo.append("onChangeVideoFile, result[");
          paramRoomInfo.append(paramReqComResult);
          paramRoomInfo.append("]");
          QLog.i("WTogether.Mng", 4, paramRoomInfo.toString());
        }
        if (!paramReqComResult.c) {
          a(paramReqComResult, localWatchTogetherInfo, paramChooseFileInfo, "onChangeVideoFile");
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        paramReqComResult = new StringBuilder();
        paramReqComResult.append("onChangeVideoFile, room[");
        paramReqComResult.append(paramChooseFileInfo);
        paramReqComResult.append("]");
        QLog.i("WTogether.Mng", 2, paramReqComResult.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramReqComResult = new StringBuilder();
      paramReqComResult.append("onChangeVideoFile, info[");
      paramReqComResult.append(localWatchTogetherInfo);
      paramReqComResult.append("]");
      QLog.i("WTogether.Mng", 2, paramReqComResult.toString());
    }
  }
  
  void b(ReqComResult paramReqComResult, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    this.e.removeMessages(9);
    WatchTogetherInfo localWatchTogetherInfo = a(paramReqComResult.a, paramReqComResult.b);
    WTogetherRoom localWTogetherRoom;
    if (localWatchTogetherInfo == null) {
      localWTogetherRoom = null;
    } else {
      localWTogetherRoom = localWatchTogetherInfo.g;
    }
    if ((localWTogetherRoom != null) && (localWTogetherRoom.e() == 2))
    {
      if ((paramReqComResult.c) && (paramRoomInfo != null))
      {
        localWTogetherRoom.a(2, 2, "onEnterRoom");
        a(localWTogetherRoom, paramRoomInfo, "onEnterRoom");
        WTDataReportUtil.a();
      }
      else
      {
        localWTogetherRoom.b("onEnterRoom");
      }
      if (paramReqComResult.c) {
        d(1, "onEnterRoom");
      }
      if (!paramReqComResult.c) {
        a(localWatchTogetherInfo, false);
      }
      if (QLog.isDevelopLevel())
      {
        paramRoomInfo = new StringBuilder();
        paramRoomInfo.append("onEnterRoom, result[");
        paramRoomInfo.append(paramReqComResult);
        paramRoomInfo.append("]");
        QLog.i("WTogether.Mng", 4, paramRoomInfo.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramReqComResult = new StringBuilder();
      paramReqComResult.append("onEnterRoom, room[");
      paramReqComResult.append(localWTogetherRoom);
      paramReqComResult.append("]");
      QLog.i("WTogether.Mng", 2, paramReqComResult.toString());
    }
  }
  
  public void b(WatchTogetherInfo paramWatchTogetherInfo)
  {
    WTogetherRoom localWTogetherRoom;
    if (paramWatchTogetherInfo == null) {
      localWTogetherRoom = null;
    } else {
      localWTogetherRoom = paramWatchTogetherInfo.f();
    }
    if ((localWTogetherRoom != null) && (localWTogetherRoom.e() == 0) && (!localWTogetherRoom.i()))
    {
      if (!WTogetherUtil.a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("WTogether.Mng", 2, "enterRoom, not support.");
        }
        this.e.sendEmptyMessage(11);
        return;
      }
      paramWatchTogetherInfo.i = 0;
      this.e.removeMessages(5);
      e(paramWatchTogetherInfo);
      localWTogetherRoom.a(2, 1, "enterRoom");
      a(false);
      ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).c(localWTogetherRoom.b, localWTogetherRoom.c, 0);
      this.e.removeMessages(9);
      this.e.sendEmptyMessageDelayed(9, 30000L);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramWatchTogetherInfo = new StringBuilder();
      paramWatchTogetherInfo.append("enterRoom, room[");
      paramWatchTogetherInfo.append(localWTogetherRoom);
      paramWatchTogetherInfo.append("]");
      QLog.i("WTogether.Mng", 2, paramWatchTogetherInfo.toString());
    }
  }
  
  public boolean b(int paramInt, String paramString)
  {
    boolean bool2 = false;
    paramString = a(paramInt, paramString, false);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.a() == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onConnected, session is null.");
      }
      return;
    }
    WatchTogetherInfo localWatchTogetherInfo = b(paramSessionInfo);
    if ((localWatchTogetherInfo != null) && (localWatchTogetherInfo.a() != 0))
    {
      localWatchTogetherInfo.a(paramSessionInfo, true);
      Object localObject = localWatchTogetherInfo.f();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WTogether.Mng", 2, "onConnected, not valid to create room.");
        }
        return;
      }
      int i = ((WTogetherRoom)localObject).e();
      if ((i == 0) && (localWatchTogetherInfo.f != null))
      {
        if (!WTogetherUtil.b(paramSessionInfo.s))
        {
          a(BaseApplicationImpl.getContext().getString(2131893767), 0L);
          d(localWatchTogetherInfo);
        }
        else if ((localWatchTogetherInfo.f.o == 1) && (!WTogetherUtil.c(paramSessionInfo.s)))
        {
          b(BaseApplicationImpl.getContext().getString(2131893768), true);
          AVUtil.a("0X800B8B7", 0, 0, "", "", "", "");
          d(localWatchTogetherInfo);
        }
        else
        {
          localObject = this.c.B();
          ((WTogetherRealNameVideoProcessHelper)localObject).b(new WTogetherMng.1(this, paramSessionInfo, localWatchTogetherInfo, (WTogetherRealNameVideoProcessHelper)localObject));
        }
      }
      else if (i == 0) {
        b(localWatchTogetherInfo);
      }
      if (QLog.isDevelopLevel())
      {
        paramSessionInfo = new StringBuilder();
        paramSessionInfo.append("onConnected, roomState[");
        paramSessionInfo.append(i);
        paramSessionInfo.append("], room[");
        paramSessionInfo.append(localWatchTogetherInfo.g);
        paramSessionInfo.append("]");
        QLog.i("WTogether.Mng", 4, paramSessionInfo.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "onConnected, no info or flag is 0.");
    }
  }
  
  public void c(WatchTogetherInfo paramWatchTogetherInfo)
  {
    c("quitRoom");
    if (paramWatchTogetherInfo != null)
    {
      if (!paramWatchTogetherInfo.b()) {
        return;
      }
      paramWatchTogetherInfo = paramWatchTogetherInfo.g;
      if ((paramWatchTogetherInfo != null) && (!paramWatchTogetherInfo.i()))
      {
        if (!paramWatchTogetherInfo.h()) {
          return;
        }
        WTDataReportUtil.a(paramWatchTogetherInfo.h, "quitRoom");
        paramWatchTogetherInfo.a(6, 1, "quitRoom");
        ((WTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.c)).b(paramWatchTogetherInfo.b, paramWatchTogetherInfo.c, 0);
        this.e.removeMessages(10);
        this.e.sendEmptyMessageDelayed(10, 30000L);
      }
    }
  }
  
  public void d(SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "checkAndQuit");
    }
    paramSessionInfo = b(paramSessionInfo);
    if ((paramSessionInfo != null) && (paramSessionInfo.g != null))
    {
      a(paramSessionInfo, 6, "checkAndQuit");
      a(BaseApplicationImpl.getContext().getString(2131893775), 100L);
      return;
    }
    d(paramSessionInfo);
  }
  
  public void e(SessionInfo paramSessionInfo)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPeerSwitchTerminal, session[");
      localStringBuilder.append(paramSessionInfo);
      localStringBuilder.append("]");
      QLog.i("WTogether.Mng", 4, localStringBuilder.toString());
    }
    a(b(paramSessionInfo), 4, "onPeerSwitchTerminal");
  }
  
  public WTogetherPlayInfo f(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = b(paramSessionInfo);
    if ((paramSessionInfo != null) && (paramSessionInfo.g != null)) {
      return paramSessionInfo.g.h;
    }
    return null;
  }
  
  public void g(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = b(paramSessionInfo);
    if (paramSessionInfo == null) {
      return;
    }
    a(paramSessionInfo, 1, "closeWTogetherMode");
  }
  
  public boolean h(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = b(paramSessionInfo);
    if (paramSessionInfo == null) {
      paramSessionInfo = null;
    } else {
      paramSessionInfo = paramSessionInfo.g;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSessionInfo != null)
    {
      bool1 = bool2;
      if (paramSessionInfo.e() != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    switch (i)
    {
    default: 
      return true;
    case 11: 
      try
      {
        paramMessage = BaseApplicationImpl.getContext();
        localObject1 = paramMessage.getString(2131893778);
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
        return true;
      }
    case 10: 
      paramMessage = b(SessionMgr.a().b());
      if (paramMessage == null) {
        paramMessage = (Message)localObject2;
      } else {
        paramMessage = paramMessage.g;
      }
      if ((paramMessage == null) || (paramMessage.e() != 6) || (paramMessage.f() != 1)) {
        break label747;
      }
      paramMessage = new ReqComResult(paramMessage.b, paramMessage.c);
      paramMessage.c = false;
      paramMessage.d = -1000;
      b(paramMessage);
      return true;
    case 9: 
      paramMessage = b(SessionMgr.a().b());
      if (paramMessage == null) {
        paramMessage = null;
      } else {
        paramMessage = paramMessage.g;
      }
      if ((paramMessage == null) || (paramMessage.e() != 2) || (paramMessage.f() != 1)) {
        break label747;
      }
      paramMessage = new ReqComResult(paramMessage.b, paramMessage.c);
      paramMessage.c = false;
      paramMessage.d = -1000;
      b(paramMessage, null);
      return true;
    case 8: 
      paramMessage = b(SessionMgr.a().b());
      if (paramMessage == null) {
        paramMessage = localObject3;
      } else {
        paramMessage = paramMessage.g;
      }
      if ((paramMessage == null) || (paramMessage.e() != 5) || (paramMessage.f() != 1)) {
        break label747;
      }
      paramMessage = new ReqComResult(paramMessage.b, paramMessage.c);
      paramMessage.c = false;
      paramMessage.d = -1000;
      a(paramMessage);
      return true;
    case 7: 
      localObject1 = b(SessionMgr.a().b());
      if (localObject1 == null) {
        paramMessage = null;
      } else {
        paramMessage = ((WatchTogetherInfo)localObject1).g;
      }
      if ((paramMessage == null) || (paramMessage.e() != 1) || (paramMessage.f() != 1)) {
        break label747;
      }
      paramMessage = new ReqComResult(paramMessage.b, paramMessage.c);
      paramMessage.c = false;
      paramMessage.d = -1000;
      a(paramMessage, ((WatchTogetherInfo)localObject1).f, null);
      return true;
    case 6: 
      paramMessage = SessionMgr.a().b();
      if ((paramMessage.e()) || (!paramMessage.j())) {
        break label747;
      }
      paramMessage = b(paramMessage);
      if (paramMessage == null) {
        break label747;
      }
      if (a(paramMessage.h)) {
        b(paramMessage.h);
      }
      paramMessage.h = null;
      return true;
    case 5: 
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "MSG_TRY_ENTER_ROOM");
      }
      paramMessage = SessionMgr.a().b();
      if ((paramMessage.e()) || (!paramMessage.j())) {
        break label747;
      }
      localObject2 = a(paramMessage);
      if (localObject2 != null) {
        ((WatchTogetherInfo)localObject2).a(paramMessage, true);
      }
      if (localObject2 == null) {
        paramMessage = (Message)localObject1;
      } else {
        paramMessage = ((WatchTogetherInfo)localObject2).f();
      }
      if ((paramMessage != null) && (paramMessage.e() == 0))
      {
        b((WatchTogetherInfo)localObject2);
        return true;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MSG_TRY_ENTER_ROOM, error, room[");
      ((StringBuilder)localObject1).append(paramMessage);
      ((StringBuilder)localObject1).append("]");
      QLog.i("WTogether.Mng", 2, ((StringBuilder)localObject1).toString());
      return true;
    case 4: 
      if (!(paramMessage.obj instanceof WTogetherCommon.PushMsg)) {
        break label747;
      }
      a((WTogetherCommon.PushMsg)paramMessage.obj);
      return true;
    case 3: 
      if (!(paramMessage.obj instanceof WTogetherRoom)) {
        break label747;
      }
      a((WTogetherRoom)paramMessage.obj);
      return true;
    case 2: 
      if (!(paramMessage.obj instanceof String)) {
        break label747;
      }
      c(paramMessage.arg1, (String)paramMessage.obj);
      return true;
    }
    b();
    label747:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherMng
 * JD-Core Version:    0.7.0.1
 */