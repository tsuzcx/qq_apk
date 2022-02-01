package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.trooptodo.TroopTodoInfoObserver;
import com.tencent.mobileqq.troop.trooptodo.api.ITroopTodoInfoHandler;
import com.tencent.mobileqq.troop.trooptodo.handler.TroopTodoInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e.InfoValue;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e.UserNode;

public class TodoInfoPresenter
{
  private static volatile TodoInfoPresenter a;
  private QQAppInterface b;
  private ITroopTodoInfoHandler c = null;
  private final Map<Long, oidb_0xf8e.UserNode> d = new ConcurrentHashMap();
  private final Map<Long, oidb_0xf8e.InfoValue> e = new ConcurrentHashMap();
  private TodoInfoPresenter.ITodoInfoListener f = null;
  private final TroopTodoInfoObserver g = new TodoInfoPresenter.1(this);
  private final TroopObserver h = new TodoInfoPresenter.2(this);
  
  public static TodoInfoPresenter a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TodoInfoPresenter();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(int paramInt1, List<oidb_0xf8e.UserNode> paramList, int paramInt2, int paramInt3, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleTodoInfoListRsp] errorCode = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", groupCode = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", reqType = ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", expTime = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", userNodeList.size = ");
    Object localObject;
    if (paramList != null) {
      localObject = Integer.valueOf(paramList.size());
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    QLog.w("TodoInfoPresenter-TodoInfo", 2, localStringBuilder.toString());
    if ((paramInt1 == 0) && (paramList != null) && (paramList.size() > 0))
    {
      d();
      c(paramList);
      a(paramList);
      b(paramList);
      d();
    }
    else
    {
      g(paramLong);
    }
    if (paramInt3 != 4)
    {
      if (!k(paramLong))
      {
        b(paramLong, paramInt3);
        return;
      }
      g(paramLong);
    }
  }
  
  private void a(int paramInt1, oidb_0xf8e.InfoValue paramInfoValue, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleTodoInfoDetailRsp] errorCode = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", groupCode = ");
    String str = "null";
    if (paramInfoValue != null) {
      localObject = Long.valueOf(paramInfoValue.group_code.get());
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", seq = ");
    Object localObject = str;
    if (paramInfoValue != null) {
      localObject = Long.valueOf(paramInfoValue.seq.get());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", reqType = ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", expTime = ");
    localStringBuilder.append(paramInt2);
    QLog.w("TodoInfoPresenter-TodoInfo", 2, localStringBuilder.toString());
    if ((paramInt1 == 0) && (paramInfoValue != null))
    {
      d();
      b(paramInfoValue);
      this.e.put(Long.valueOf(paramInfoValue.group_code.get()), paramInfoValue);
      a(paramInfoValue);
      d();
      return;
    }
    a(TodoInfoPresenter.ErrorType.ERROR_RSP_TODO_INFO_DETAIL);
  }
  
  private void a(long paramLong, int paramInt)
  {
    ITroopTodoInfoHandler localITroopTodoInfoHandler = this.c;
    if (localITroopTodoInfoHandler != null) {
      localITroopTodoInfoHandler.b(Long.valueOf(paramLong), paramInt);
    }
  }
  
  private void a(TodoInfoPresenter.ErrorType paramErrorType)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[triggerError] type = ");
    ((StringBuilder)localObject).append(paramErrorType);
    QLog.e("TodoInfoPresenter-TodoInfo", 1, ((StringBuilder)localObject).toString());
    localObject = this.f;
    if (localObject != null) {
      ((TodoInfoPresenter.ITodoInfoListener)localObject).a(paramErrorType);
    }
  }
  
  private void a(List<oidb_0xf8e.UserNode> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.d.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      if (a(((Long)localObject2).longValue(), paramList)) {
        localArrayList.add(localObject2);
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = this.e.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Long localLong = (Long)((Iterator)localObject2).next();
      if (a(localLong.longValue(), paramList)) {
        ((List)localObject1).add(localLong);
      }
    }
    paramList = new StringBuilder();
    paramList.append("[correctionTodoInfoCache] notExistUserNodeKey.size = ");
    paramList.append(localArrayList.size());
    paramList.append(", notExistUserNodeKey.data = ");
    paramList.append(localArrayList.toString());
    paramList.append(", notExistInfoValueKey.size = ");
    paramList.append(((List)localObject1).size());
    paramList.append(", notExistUserNodeKey.data = ");
    paramList.append(localObject1.toString());
    QLog.w("TodoInfoPresenter-TodoInfo", 2, paramList.toString());
    try
    {
      paramList = this.d.keySet().iterator();
      while (paramList.hasNext()) {
        if (localArrayList.contains((Long)paramList.next())) {
          paramList.remove();
        }
      }
      paramList = this.e.keySet().iterator();
      while (paramList.hasNext()) {
        if (((List)localObject1).contains((Long)paramList.next())) {
          paramList.remove();
        }
      }
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("TodoInfoPresenter-TodoInfo", 1, "correctionTodoInfoCache error", paramList);
    }
  }
  
  private void a(oidb_0xf8e.InfoValue paramInfoValue)
  {
    if (!AIOUtils.d())
    {
      QLog.w("TodoInfoPresenter-TodoInfo", 1, "[triggerCallback] not in any aio, just return.");
      a(TodoInfoPresenter.ErrorType.ERROR_NOT_IN_AIO);
      return;
    }
    TroopInfo localTroopInfo = a(String.valueOf(paramInfoValue.group_code.get()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[triggerCallback] group user, group_code = ");
    localStringBuilder.append(paramInfoValue.group_code.get());
    localStringBuilder.append(", joinTime = ");
    if (localTroopInfo != null) {
      localObject = Long.valueOf(localTroopInfo.dwCmdUinJoinTime);
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", todoInfo createTime = ");
    localStringBuilder.append(paramInfoValue.create_time.get());
    QLog.i("TodoInfoPresenter-TodoInfo", 1, localStringBuilder.toString());
    if ((localTroopInfo != null) && (localTroopInfo.dwCmdUinJoinTime > paramInfoValue.create_time.get()))
    {
      a(TodoInfoPresenter.ErrorType.ERROR_NEW_GROUP_USER);
      return;
    }
    int i = j(paramInfoValue.group_code.get());
    a(paramInfoValue, i);
    Object localObject = this.f;
    if (localObject != null) {
      ((TodoInfoPresenter.ITodoInfoListener)localObject).a(TroopToDoBannerModel.a(paramInfoValue, i));
    }
  }
  
  private void a(oidb_0xf8e.InfoValue paramInfoValue, int paramInt)
  {
    oidb_0xf8e.UserNode localUserNode = new oidb_0xf8e.UserNode();
    localUserNode.group_code.set(paramInfoValue.group_code.get());
    localUserNode.seq.set(paramInfoValue.seq.get());
    localUserNode.status.set(paramInt);
    a(localUserNode);
  }
  
  private void a(oidb_0xf8e.UserNode paramUserNode)
  {
    this.d.put(Long.valueOf(paramUserNode.group_code.get()), paramUserNode);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleTodoInfoPushRsp] 0xef0, isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", troopUin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TodoInfoPresenter-TodoInfo", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject = a(paramString);
      if ((localObject != null) && (((TroopInfo)localObject).mTroopInfoExtObj != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleTodoInfoPushRsp] 0xef0, todoSeq = ");
        localStringBuilder.append(((TroopInfo)localObject).mTroopInfoExtObj.todoSeq);
        localStringBuilder.append(", joinTime = ");
        localStringBuilder.append(((TroopInfo)localObject).dwCmdUinJoinTime);
        QLog.i("TodoInfoPresenter-TodoInfo", 2, localStringBuilder.toString());
        b(Long.parseLong(paramString), ((TroopInfo)localObject).mTroopInfoExtObj.todoSeq);
        return;
      }
      QLog.e("TodoInfoPresenter-TodoInfo", 2, "[handleTodoInfoPushRsp] 0xef0, troopInfo.mTroopInfoExtObj null");
    }
  }
  
  private boolean a(long paramLong, List<oidb_0xf8e.UserNode> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((oidb_0xf8e.UserNode)paramList.next()).group_code.get() == paramLong) {
        return false;
      }
    }
    return true;
  }
  
  private void b(long paramLong, int paramInt)
  {
    ITroopTodoInfoHandler localITroopTodoInfoHandler = this.c;
    if (localITroopTodoInfoHandler != null) {
      localITroopTodoInfoHandler.a(Long.valueOf(paramLong), paramInt);
    }
  }
  
  private void b(long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[notifyChange] groupCode = ");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(", pushTodoSeq = ");
    ((StringBuilder)localObject).append(paramLong2);
    QLog.i("TodoInfoPresenter-TodoInfo", 2, ((StringBuilder)localObject).toString());
    if (paramLong2 == 0L)
    {
      QLog.w("TodoInfoPresenter-TodoInfo", 2, "[notifyChange] pushTodoSeq = 0, clear cache and dismiss if need");
      l(paramLong1);
      return;
    }
    if (b())
    {
      QLog.i("TodoInfoPresenter-TodoInfo", 2, "[notifyChange] empty TodoInfoListCache, start requestTodoInfoList");
      a(paramLong1, 2);
      return;
    }
    if (e(paramLong1))
    {
      QLog.i("TodoInfoPresenter-TodoInfo", 2, "[notifyChange] not hit TodoInfoListCache, start requestTodoInfoList");
      a(paramLong1, 2);
      return;
    }
    localObject = h(paramLong1);
    if ((localObject != null) && (paramLong2 != ((oidb_0xf8e.UserNode)localObject).seq.get()))
    {
      QLog.i("TodoInfoPresenter-TodoInfo", 2, "[notifyChange] hit, but seq change, start requestTodoInfoList");
      a(paramLong1, 2);
      return;
    }
    if (j(paramLong1) == 2)
    {
      QLog.w("TodoInfoPresenter-TodoInfo", 1, "[notifyChange] todo status is close, return.");
      a(TodoInfoPresenter.ErrorType.ERROR_TODO_STATUS_CLOSE);
      return;
    }
    QLog.i("TodoInfoPresenter-TodoInfo", 2, "[notifyChange] just read cache...");
    localObject = i(paramLong1);
    if (localObject != null)
    {
      a((oidb_0xf8e.InfoValue)localObject);
      return;
    }
    a(TodoInfoPresenter.ErrorType.ERROR_CACHE_ERROR);
  }
  
  private void b(List<oidb_0xf8e.UserNode> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((oidb_0xf8e.UserNode)paramList.next());
    }
  }
  
  private void b(oidb_0xf8e.InfoValue paramInfoValue)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[printServerTodoInfoDetail] groupCode = ");
    localStringBuilder.append(paramInfoValue.group_code.get());
    localStringBuilder.append(", seq = ");
    localStringBuilder.append(paramInfoValue.seq.get());
    localStringBuilder.append(", random = ");
    localStringBuilder.append(paramInfoValue.random.get());
    localStringBuilder.append(", uin = ");
    localStringBuilder.append(paramInfoValue.uin.get());
    localStringBuilder.append(", nickname = ");
    localStringBuilder.append(paramInfoValue.nickname.get());
    localStringBuilder.append(", title = ");
    localStringBuilder.append(paramInfoValue.title.get());
    localStringBuilder.append(", jump_url = ");
    localStringBuilder.append(paramInfoValue.jump_url.get());
    localStringBuilder.append(", icon_url = ");
    localStringBuilder.append(paramInfoValue.icon_url.get());
    localStringBuilder.append(", create_time = ");
    localStringBuilder.append(paramInfoValue.create_time.get());
    QLog.i("TodoInfoPresenter-TodoInfo", 2, localStringBuilder.toString());
  }
  
  private boolean b()
  {
    return this.d.isEmpty();
  }
  
  private void c(List<oidb_0xf8e.UserNode> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0xf8e.UserNode localUserNode = (oidb_0xf8e.UserNode)paramList.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[printServerTodoInfoList] groupCode = ");
      localStringBuilder.append(localUserNode.group_code.get());
      localStringBuilder.append(", seq = ");
      localStringBuilder.append(localUserNode.seq.get());
      localStringBuilder.append(", status = ");
      localStringBuilder.append(localUserNode.status.get());
      QLog.i("TodoInfoPresenter-TodoInfo", 2, localStringBuilder.toString());
    }
  }
  
  private boolean c()
  {
    return this.e.isEmpty();
  }
  
  private void d()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[printCacheTodoInfo] userNodeListCache.size = ");
    ((StringBuilder)localObject1).append(this.d.size());
    QLog.d("TodoInfoPresenter-TodoInfo", 2, ((StringBuilder)localObject1).toString());
    localObject1 = this.d.entrySet().iterator();
    Object localObject2;
    long l;
    StringBuilder localStringBuilder;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      l = ((Long)((Map.Entry)localObject2).getKey()).longValue();
      localObject2 = (oidb_0xf8e.UserNode)((Map.Entry)localObject2).getValue();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[printCacheTodoInfo] groupCode = ");
      localStringBuilder.append(l);
      localStringBuilder.append(", UserNode(groupCode = ");
      localStringBuilder.append(((oidb_0xf8e.UserNode)localObject2).group_code.get());
      localStringBuilder.append(", seq = ");
      localStringBuilder.append(((oidb_0xf8e.UserNode)localObject2).seq.get());
      localStringBuilder.append(", status = ");
      localStringBuilder.append(((oidb_0xf8e.UserNode)localObject2).status.get());
      localStringBuilder.append(")");
      QLog.d("TodoInfoPresenter-TodoInfo", 2, localStringBuilder.toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[printCacheTodoInfo] infoValueMapCache.size = ");
    ((StringBuilder)localObject1).append(this.e.size());
    QLog.d("TodoInfoPresenter-TodoInfo", 2, ((StringBuilder)localObject1).toString());
    localObject1 = this.e.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      l = ((Long)((Map.Entry)localObject2).getKey()).longValue();
      localObject2 = (oidb_0xf8e.InfoValue)((Map.Entry)localObject2).getValue();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[printCacheTodoInfo] groupCode = ");
      localStringBuilder.append(l);
      localStringBuilder.append(", infoValue(groupCode = ");
      localStringBuilder.append(((oidb_0xf8e.InfoValue)localObject2).group_code.get());
      localStringBuilder.append(", seq = ");
      localStringBuilder.append(((oidb_0xf8e.InfoValue)localObject2).seq.get());
      localStringBuilder.append(", random = ");
      localStringBuilder.append(((oidb_0xf8e.InfoValue)localObject2).random.get());
      localStringBuilder.append(", uin = ");
      localStringBuilder.append(((oidb_0xf8e.InfoValue)localObject2).uin.get());
      localStringBuilder.append(", nickname = ");
      localStringBuilder.append(((oidb_0xf8e.InfoValue)localObject2).nickname.get());
      localStringBuilder.append(", title = ");
      localStringBuilder.append(((oidb_0xf8e.InfoValue)localObject2).title.get());
      localStringBuilder.append(", jump_url = ");
      localStringBuilder.append(((oidb_0xf8e.InfoValue)localObject2).jump_url.get());
      localStringBuilder.append(", icon_url = ");
      localStringBuilder.append(((oidb_0xf8e.InfoValue)localObject2).icon_url.get());
      localStringBuilder.append(", create_time = ");
      localStringBuilder.append(((oidb_0xf8e.InfoValue)localObject2).create_time.get());
      localStringBuilder.append(")");
      QLog.d("TodoInfoPresenter-TodoInfo", 2, localStringBuilder.toString());
    }
  }
  
  private boolean d(long paramLong)
  {
    if (c())
    {
      QLog.i("TodoInfoPresenter-TodoInfo", 2, "[checkIfNeedRequestDetail] empty infoValueMapCache, start requestTodoInfoDetail");
      return true;
    }
    if (!f(paramLong))
    {
      QLog.i("TodoInfoPresenter-TodoInfo", 2, "[checkIfNeedRequestDetail] did not hit infoValueMapCache, start requestTodoInfoDetail");
      return true;
    }
    return false;
  }
  
  private boolean e(long paramLong)
  {
    return h(paramLong) == null;
  }
  
  private boolean f(long paramLong)
  {
    return this.e.containsKey(Long.valueOf(paramLong));
  }
  
  private void g(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[clearTodoInfoCache] groupCode = ");
    localStringBuilder.append(paramLong);
    QLog.i("TodoInfoPresenter-TodoInfo", 2, localStringBuilder.toString());
    this.d.remove(Long.valueOf(paramLong));
    this.e.remove(Long.valueOf(paramLong));
  }
  
  private oidb_0xf8e.UserNode h(long paramLong)
  {
    return (oidb_0xf8e.UserNode)this.d.get(Long.valueOf(paramLong));
  }
  
  private oidb_0xf8e.InfoValue i(long paramLong)
  {
    return (oidb_0xf8e.InfoValue)this.e.get(Long.valueOf(paramLong));
  }
  
  private int j(long paramLong)
  {
    Object localObject = h(paramLong);
    int i;
    if (localObject != null) {
      i = ((oidb_0xf8e.UserNode)localObject).status.get();
    } else {
      i = 3;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getTodoStatus] groupCode = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", status = ");
    ((StringBuilder)localObject).append(i);
    QLog.i("TodoInfoPresenter-TodoInfo", 2, ((StringBuilder)localObject).toString());
    return i;
  }
  
  private boolean k(long paramLong)
  {
    Object localObject = h(paramLong);
    boolean bool;
    if ((localObject != null) && (((oidb_0xf8e.UserNode)localObject).seq.get() == 0L)) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[isSeqIllegal] groupCode = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", isIllegal = ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("TodoInfoPresenter-TodoInfo", 2, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private void l(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[triggerRecall] invoke, groupCode = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("TodoInfoPresenter-TodoInfo", 1, ((StringBuilder)localObject).toString());
    localObject = i(paramLong);
    if (localObject == null)
    {
      QLog.i("TodoInfoPresenter-TodoInfo", 1, "[triggerRecall] no cache, just return.");
      return;
    }
    g(paramLong);
    if (!AIOUtils.d())
    {
      QLog.w("TodoInfoPresenter-TodoInfo", 1, "[triggerRecall] not in any aio, just return.");
      a(TodoInfoPresenter.ErrorType.ERROR_NOT_IN_AIO);
      return;
    }
    TodoInfoPresenter.ITodoInfoListener localITodoInfoListener = this.f;
    if (localITodoInfoListener != null) {
      localITodoInfoListener.a(TroopToDoBannerModel.a((oidb_0xf8e.InfoValue)localObject, 4));
    }
    d();
  }
  
  protected TroopInfo a(String paramString)
  {
    return ((ITroopInfoService)this.b.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
  }
  
  public void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestByEnterGroup] groupCode = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("TodoInfoPresenter-TodoInfo", 2, ((StringBuilder)localObject).toString());
    if (!c(paramLong))
    {
      QLog.i("TodoInfoPresenter-TodoInfo", 2, "[requestByEnterGroup] no todo seq exist, return");
      return;
    }
    d();
    if (b())
    {
      QLog.i("TodoInfoPresenter-TodoInfo", 2, "[requestByEnterGroup] empty TodoInfoListCache, start requestTodoInfoList");
      a(paramLong, 1);
      return;
    }
    if (e(paramLong))
    {
      QLog.i("TodoInfoPresenter-TodoInfo", 2, "[requestByEnterGroup] not hit TodoInfoListCache, start requestTodoInfoList");
      a(paramLong, 1);
      return;
    }
    if (j(paramLong) == 2)
    {
      QLog.w("TodoInfoPresenter-TodoInfo", 1, "[requestByEnterGroup] todo status is close, return.");
      a(TodoInfoPresenter.ErrorType.ERROR_TODO_STATUS_CLOSE);
      return;
    }
    if (d(paramLong))
    {
      b(paramLong, 1);
      return;
    }
    QLog.w("TodoInfoPresenter-TodoInfo", 2, "[requestByEnterGroup] just read cache...");
    localObject = i(paramLong);
    if (localObject != null)
    {
      a((oidb_0xf8e.InfoValue)localObject);
      return;
    }
    a(TodoInfoPresenter.ErrorType.ERROR_CACHE_ERROR);
  }
  
  public void a(@NonNull QQAppInterface paramQQAppInterface, TodoInfoPresenter.ITodoInfoListener paramITodoInfoListener)
  {
    QLog.i("TodoInfoPresenter-TodoInfo", 2, "[attachApp] invoke");
    this.b = paramQQAppInterface;
    this.b.addObserver(this.g);
    this.b.addObserver(this.h);
    this.f = paramITodoInfoListener;
    this.c = ((ITroopTodoInfoHandler)this.b.getBusinessHandler(TroopTodoInfoHandler.class.getName()));
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    boolean bool1 = b();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    oidb_0xf8e.UserNode localUserNode = h(paramLong1);
    bool1 = bool2;
    if (localUserNode != null)
    {
      bool1 = bool2;
      if (localUserNode.seq.get() == paramLong2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[requestByCRUD] groupCode = ");
    localStringBuilder.append(paramLong);
    QLog.i("TodoInfoPresenter-TodoInfo", 2, localStringBuilder.toString());
    a(paramLong, 4);
  }
  
  protected boolean c(long paramLong)
  {
    TroopInfo localTroopInfo = a(String.valueOf(paramLong));
    if ((localTroopInfo != null) && (localTroopInfo.mTroopInfoExtObj != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isTodoExist] todoSeq = ");
      localStringBuilder.append(localTroopInfo.mTroopInfoExtObj.todoSeq);
      QLog.i("TodoInfoPresenter-TodoInfo", 2, localStringBuilder.toString());
      return localTroopInfo.mTroopInfoExtObj.todoSeq != 0;
    }
    QLog.w("TodoInfoPresenter-TodoInfo", 2, "[isTodoExist] troopInfo = null || troopInfo.mTroopInfoExtObj = null");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.TodoInfoPresenter
 * JD-Core Version:    0.7.0.1
 */