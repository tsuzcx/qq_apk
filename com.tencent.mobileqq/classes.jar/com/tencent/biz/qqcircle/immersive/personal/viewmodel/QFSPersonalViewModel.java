package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.datacenter.data.QFSUserFollowData;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalFeedInfo;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfoLiveData;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalTab;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSGetFeedListUIStateManager;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSGetLikeFeedListUIStateManager;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSGetMainUIStateManager;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUserInfoRspInterceptor;
import com.tencent.biz.qqcircle.immersive.personal.request.IQFSPersonalFeedRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest.Builder;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetLikeFeedListRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetLikeFeedListRequest.Builder;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetMainPageRequest.Builder;
import com.tencent.biz.qqcircle.immersive.utils.QFSThreadUtils;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.api.IDataManager;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;

public class QFSPersonalViewModel
  extends BaseViewModel
  implements IDataDisplaySurface<FeedBlockData>, Call.OnRspCallBack<QCircleBaseRequest>
{
  private boolean a = false;
  private QFSGetMainUIStateManager b = new QFSGetMainUIStateManager();
  private QFSGetFeedListUIStateManager c = new QFSGetFeedListUIStateManager();
  private QFSGetLikeFeedListUIStateManager d = new QFSGetLikeFeedListUIStateManager();
  private final QFSPersonalInfoLiveData e = new QFSPersonalInfoLiveData();
  private final MutableLiveData<FeedCloudMeta.StFeed> f = new MutableLiveData();
  private final MutableLiveData<Boolean> g = new MutableLiveData();
  private final MutableLiveData<List<QFSPersonalTab>> h = new MutableLiveData();
  private final MutableLiveData<UIStateData<List<FeedBlockData>>> i = new MutableLiveData();
  private final MutableLiveData<UIStateData<List<FeedBlockData>>> j = new MutableLiveData();
  private final MutableLiveData<UIStateData<List<FeedBlockData>>> k = new MutableLiveData();
  private final MutableLiveData<List<QFSPersonalFeedInfo>> l = new MutableLiveData();
  private final MutableLiveData<QFSUserFollowData> m = new MutableLiveData();
  private QFSPersonalViewModel.QFSPersonalFeedObserver n;
  private QFSPersonalViewModel.QFSUserFollowDataObserver o;
  
  private int a(List<String> paramList1, List<String> paramList2)
  {
    paramList1 = paramList1.iterator();
    int i1 = 0;
    while (paramList1.hasNext()) {
      if (paramList2.contains((String)paramList1.next())) {
        i1 += 1;
      }
    }
    return i1;
  }
  
  private UIStateData<List<FeedBlockData>> a(UIStateData<List<FeedBlockData>> paramUIStateData, List<FeedBlockData> paramList)
  {
    if (paramUIStateData == null) {
      return null;
    }
    if (a(paramUIStateData)) {
      return paramUIStateData.a(paramUIStateData.i(), paramList);
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramUIStateData.a(paramUIStateData.i(), paramList);
      paramUIStateData.c(3);
      return paramUIStateData;
    }
    return UIStateData.a();
  }
  
  private List<QFSPersonalTab> a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return Arrays.asList(new QFSPersonalTab[] { new QFSPersonalTab(HardCodeUtil.a(2131896233), 20101, paramInt1), new QFSPersonalTab(HardCodeUtil.a(2131896234), 20103, paramInt2), new QFSPersonalTab(HardCodeUtil.a(2131896232), 20102, paramInt3, paramBoolean) });
  }
  
  private List<String> a(List<IQueueTask> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFSPersonalViewModel", 1, new Object[] { "[getUploadingMissionIds] taskList.size:", Integer.valueOf(paramList.size()) });
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        IQueueTask localIQueueTask = (IQueueTask)paramList.next();
        if (QLog.isColorLevel()) {
          QLog.d("QFSPersonalViewModel", 1, new Object[] { "[getUploadingMissionIds] taskList task.missionId: ", localIQueueTask.getMissionId(), ", task.state: ", Integer.valueOf(localIQueueTask.getState()) });
        }
        if ((localIQueueTask.getState() == 1) || (localIQueueTask.getState() == 0) || (localIQueueTask.getState() == 6)) {
          localArrayList.add(localIQueueTask.getMissionId());
        }
      }
      return localArrayList;
    }
    QLog.d("QFSPersonalViewModel", 1, "[getUploadingMissionIds] taskList == null || taskList.size() == 0.");
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.h.getValue() == null) {
      return;
    }
    Iterator localIterator = ((List)this.h.getValue()).iterator();
    while (localIterator.hasNext())
    {
      QFSPersonalTab localQFSPersonalTab = (QFSPersonalTab)localIterator.next();
      if (localQFSPersonalTab.b() == paramInt1)
      {
        localQFSPersonalTab.a(localQFSPersonalTab.a() + paramInt2);
        QLog.d("QFSPersonalViewModel", 4, localQFSPersonalTab.d());
      }
    }
  }
  
  private void a(QFSGetFeedListRequest paramQFSGetFeedListRequest)
  {
    QCircleRequestCall localQCircleRequestCall = QCircleRequestSender.a().b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("2012");
    localStringBuilder.append(n());
    localQCircleRequestCall.a(localStringBuilder.toString()).a(this.c).b(false).a(paramQFSGetFeedListRequest).a(this).a();
  }
  
  private void a(QFSGetLikeFeedListRequest paramQFSGetLikeFeedListRequest)
  {
    QCircleRequestCall localQCircleRequestCall = QCircleRequestSender.a().b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("2011");
    localStringBuilder.append(n());
    localQCircleRequestCall.a(localStringBuilder.toString()).a(this.d).b(false).a(paramQFSGetLikeFeedListRequest).a(this).a();
  }
  
  private void a(QFSGetMainPageRequest paramQFSGetMainPageRequest)
  {
    QCircleRequestCall localQCircleRequestCall = QCircleRequestSender.a().b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("2001");
    localStringBuilder.append(n());
    localQCircleRequestCall.a(localStringBuilder.toString()).a(this.b).b(false).a(paramQFSGetMainPageRequest).a(new QFSUserInfoRspInterceptor()).a(this).a();
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, List<FeedBlockData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedBlockData localFeedBlockData = (FeedBlockData)paramList.next();
      if ((localFeedBlockData.b() != null) && (TextUtils.equals(localFeedBlockData.b().id.get(), paramStFeed.id.get()))) {
        QFSThreadUtils.a(new QFSPersonalViewModel.1(this, localFeedBlockData, paramStFeed));
      }
    }
  }
  
  private void a(Object paramObject)
  {
    r();
    if (b(paramObject)) {
      return;
    }
    c(paramObject);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.o == null) {
      this.o = new QFSPersonalViewModel.QFSUserFollowDataObserver(this);
    }
    paramString = new QFSUserFollowData(paramString, paramInt);
    this.o.b(paramString);
  }
  
  private boolean a(UIStateData paramUIStateData)
  {
    boolean bool = false;
    if (paramUIStateData == null) {
      return false;
    }
    if ((paramUIStateData.l()) || (paramUIStateData.m())) {
      bool = true;
    }
    return bool;
  }
  
  private String b(List<String> paramList1, List<String> paramList2)
  {
    if (paramList2.size() > 0)
    {
      Iterator localIterator = paramList1.iterator();
      for (paramList1 = null;; paramList1 = (List<String>)localObject) {
        do
        {
          localObject = paramList1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (String)localIterator.next();
        } while ((paramList2.contains(localObject)) || (!TextUtils.isEmpty(paramList1)));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFSPersonalViewModel", 1, "[getDraftData] taskList is empty, get first missionId from draft.");
    }
    Object localObject = (String)paramList1.get(0);
    return localObject;
  }
  
  private boolean b(Object paramObject)
  {
    if (!(paramObject instanceof QFSPersonalInfo))
    {
      QLog.e("QFSPersonalViewModel", 1, "rspObj is not FSPersonalInfo");
      return false;
    }
    paramObject = (QFSPersonalInfo)paramObject;
    this.e.b(paramObject);
    if (!paramObject.u)
    {
      this.h.setValue(a(paramObject.l, paramObject.m, paramObject.C, paramObject.Q));
      if ((!p()) && (!paramObject.Q)) {
        a(d(false));
      }
    }
    return true;
  }
  
  private QFSGetMainPageRequest c(boolean paramBoolean)
  {
    QFSGetMainPageRequest.Builder localBuilder = new QFSGetMainPageRequest.Builder(n());
    if (paramBoolean) {
      localBuilder.c();
    }
    return (QFSGetMainPageRequest)localBuilder.d();
  }
  
  private void c(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    int i1 = paramStFeed.likeInfo.status.get();
    int i3 = 1;
    int i2;
    if (i1 == 1) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    Iterator localIterator = this.d.b().iterator();
    while (localIterator.hasNext())
    {
      FeedBlockData localFeedBlockData = (FeedBlockData)localIterator.next();
      if ((localFeedBlockData.b() != null) && (TextUtils.equals(localFeedBlockData.b().id.get(), paramStFeed.id.get())))
      {
        if (i2 != 0) {
          return;
        }
        localIterator.remove();
        i1 = -1;
        break label113;
      }
    }
    i1 = 0;
    label113:
    if (i2 != 0)
    {
      this.d.b().add(0, new FeedBlockData(paramStFeed));
      i1 = i3;
    }
    a(20102, i1);
  }
  
  private void c(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("QFSPersonalViewModel", 1, "handleProductsFeedList rspObj is null");
      return;
    }
    try
    {
      paramObject = (UIStateData)paramObject;
      this.i.setValue(paramObject);
      return;
    }
    catch (ClassCastException paramObject)
    {
      QLog.e("QFSPersonalViewModel", 1, paramObject.getMessage());
    }
  }
  
  private QFSGetLikeFeedListRequest d(boolean paramBoolean)
  {
    QFSGetLikeFeedListRequest.Builder localBuilder = new QFSGetLikeFeedListRequest.Builder(n()).a(0).b(42);
    if (paramBoolean) {
      localBuilder.c();
    }
    return (QFSGetLikeFeedListRequest)localBuilder.d();
  }
  
  private void d(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = QCirclePushInfoManager.a().a(paramStFeed.id.get());
    if (localObject == null) {
      return;
    }
    int i1 = ((FeedCloudMeta.StPushList)localObject).count.get();
    int i3 = 1;
    int i2;
    if (i1 > 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    localObject = this.c.b().iterator();
    while (((Iterator)localObject).hasNext())
    {
      FeedBlockData localFeedBlockData = (FeedBlockData)((Iterator)localObject).next();
      if ((localFeedBlockData.b() != null) && (TextUtils.equals(localFeedBlockData.b().id.get(), paramStFeed.id.get())))
      {
        if (i2 != 0) {
          return;
        }
        ((Iterator)localObject).remove();
        i1 = -1;
        break label131;
      }
    }
    i1 = 0;
    label131:
    if (i2 != 0)
    {
      this.c.b().add(0, new FeedBlockData(paramStFeed));
      i1 = i3;
    }
    a(20103, i1);
  }
  
  private QFSGetFeedListRequest e(boolean paramBoolean)
  {
    QFSGetFeedListRequest.Builder localBuilder = new QFSGetFeedListRequest.Builder(n()).a(0).b(9);
    if (paramBoolean) {
      localBuilder.c();
    }
    return (QFSGetFeedListRequest)localBuilder.d();
  }
  
  private boolean u()
  {
    if (this.i.getValue() == null) {
      return false;
    }
    return ((UIStateData)this.i.getValue()).h();
  }
  
  private boolean v()
  {
    if (this.j.getValue() == null) {
      return false;
    }
    return ((UIStateData)this.j.getValue()).h();
  }
  
  private boolean w()
  {
    if (this.k.getValue() == null) {
      return false;
    }
    return ((UIStateData)this.k.getValue()).h();
  }
  
  private void x()
  {
    if (!a((UIStateData)this.i.getValue()))
    {
      if (u()) {
        return;
      }
      QCircleRequestSender.a().b().a(this.b).c(true).a(c(false)).a(this).a();
    }
  }
  
  private void y()
  {
    if (!a((UIStateData)this.j.getValue()))
    {
      if (v()) {
        return;
      }
      QCircleRequestSender.a().b().a(this.d).c(true).a(d(false)).a(this).a();
    }
  }
  
  private void z()
  {
    if (!a((UIStateData)this.k.getValue()))
    {
      if (w()) {
        return;
      }
      QCircleRequestSender.a().b().a(this.c).c(true).a(e(false)).a(this).a();
    }
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 0)
    {
      if (!(paramVarArgs[0] instanceof QCircleInitBean)) {
        return null;
      }
      paramVarArgs = (QCircleInitBean)paramVarArgs[0];
      if (paramVarArgs.getExtraTypeInfo() == null) {
        return null;
      }
      switch (paramVarArgs.getExtraTypeInfo().sourceType)
      {
      default: 
        return null;
      case 20103: 
        return this.k;
      case 20102: 
        return this.j;
      }
      return this.i;
    }
    return null;
  }
  
  public String a()
  {
    return "QFSPersonalViewModel";
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 20103: 
      z();
      return;
    case 20102: 
      y();
      return;
    }
    x();
  }
  
  public void a(QFSUserFollowData paramQFSUserFollowData)
  {
    this.m.setValue(paramQFSUserFollowData);
  }
  
  public void a(FeedBlockData paramFeedBlockData)
  {
    if (paramFeedBlockData != null)
    {
      if (paramFeedBlockData.b() == null) {
        return;
      }
      paramFeedBlockData = paramFeedBlockData.b();
      if (p())
      {
        c(paramFeedBlockData);
        d(paramFeedBlockData);
      }
      a(paramFeedBlockData, this.b.b());
      a(paramFeedBlockData, this.c.b());
      a(paramFeedBlockData, this.d.b());
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.i("QFSPersonalViewModel", 1, "setPreFeed() -> stFeed is null");
      return;
    }
    if ((this.f.getValue() != null) && (TextUtils.equals(((FeedCloudMeta.StFeed)this.f.getValue()).id.get(), paramStFeed.id.get())))
    {
      QLog.i("QFSPersonalViewModel", 1, "setPreFeed() -> same stFeed");
      return;
    }
    this.f.setValue(paramStFeed);
    a(paramStFeed.poster);
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser == null)
    {
      QLog.i("QFSPersonalViewModel", 1, "setStUser() -> stUser is null");
      return;
    }
    if ((this.e.getValue() != null) && (TextUtils.equals(((QFSPersonalInfo)this.e.getValue()).c, paramStUser.id.get())))
    {
      QLog.i("QFSPersonalViewModel", 1, "setStUser() -> same user");
      return;
    }
    this.e.b(QFSPersonalInfo.b(paramStUser));
    this.h.setValue(a(0, 0, 0, true));
    a(paramStUser.id.get(), paramStUser.followState.get());
    this.g.setValue(Boolean.valueOf(true));
  }
  
  public void a(String paramString)
  {
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    localStFeed.id.set(paramString);
    b(localStFeed);
  }
  
  public void a(String paramString, long paramLong)
  {
    paramString = (QFSGetMainPageRequest)new QFSGetMainPageRequest.Builder(n()).a(4, n(), paramString, paramLong).d();
    QCircleRequestSender.a().b().a(this.b).c(true).a(paramString).a(this).a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleBaseRequest paramQCircleBaseRequest, Object paramObject, Bundle paramBundle)
  {
    if (((paramQCircleBaseRequest instanceof IQFSPersonalFeedRequest)) && (!TextUtils.equals(((IQFSPersonalFeedRequest)paramQCircleBaseRequest).getUin(), n()))) {
      return;
    }
    if ((paramQCircleBaseRequest instanceof QFSGetMainPageRequest))
    {
      a(paramObject);
      return;
    }
    if (((paramQCircleBaseRequest instanceof QFSGetFeedListRequest)) && ((paramObject instanceof UIStateData)))
    {
      this.k.setValue((UIStateData)paramObject);
      return;
    }
    if (((paramQCircleBaseRequest instanceof QFSGetLikeFeedListRequest)) && ((paramObject instanceof UIStateData))) {
      this.j.setValue((UIStateData)paramObject);
    }
  }
  
  public MutableLiveData<QFSPersonalInfo> b()
  {
    return this.e;
  }
  
  public void b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.n == null) {
      this.n = new QFSPersonalViewModel.QFSPersonalFeedObserver(this);
    }
    this.n.b(new FeedBlockData(paramStFeed));
  }
  
  public void b(String paramString)
  {
    Iterator localIterator = this.b.b().iterator();
    while (localIterator.hasNext())
    {
      FeedBlockData localFeedBlockData = (FeedBlockData)localIterator.next();
      if ((localFeedBlockData.b() != null) && (TextUtils.equals(localFeedBlockData.b().id.get(), paramString)))
      {
        localIterator.remove();
        a(20101, -1);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (a((UIStateData)this.i.getValue())) {
      return;
    }
    a(c(paramBoolean));
    a(e(paramBoolean));
    if (p()) {
      a(d(paramBoolean));
    }
    this.g.setValue(Boolean.valueOf(false));
  }
  
  public void b(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 0)
    {
      if (!(paramVarArgs[0] instanceof QCircleInitBean)) {
        return;
      }
      paramVarArgs = (QCircleInitBean)paramVarArgs[0];
      if (paramVarArgs.getExtraTypeInfo() == null) {
        return;
      }
      a(paramVarArgs.getExtraTypeInfo().sourceType);
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  public MutableLiveData<List<QFSPersonalTab>> d()
  {
    return this.h;
  }
  
  public MutableLiveData<Boolean> e()
  {
    return this.g;
  }
  
  public MutableLiveData<FeedCloudMeta.StFeed> f()
  {
    return this.f;
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> g()
  {
    return this.i;
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> h()
  {
    return this.j;
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> i()
  {
    return this.k;
  }
  
  public MutableLiveData<List<QFSPersonalFeedInfo>> j()
  {
    return this.l;
  }
  
  public MutableLiveData<QFSUserFollowData> k()
  {
    return this.m;
  }
  
  public void l()
  {
    this.i.setValue(UIStateData.a());
    if (this.g.getValue() != null)
    {
      if (((Boolean)this.g.getValue()).booleanValue()) {
        return;
      }
      this.j.setValue(UIStateData.a());
      this.k.setValue(UIStateData.a());
      this.b = new QFSGetMainUIStateManager();
      this.c = new QFSGetFeedListUIStateManager();
      this.d = new QFSGetLikeFeedListUIStateManager();
    }
  }
  
  public String m()
  {
    StringBuilder localStringBuilder;
    String str;
    if (this.a)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      str = "";
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      str = n();
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public String n()
  {
    if (this.e.getValue() != null) {
      return ((QFSPersonalInfo)this.e.getValue()).c;
    }
    return "";
  }
  
  public boolean o()
  {
    if (this.g.getValue() == null) {
      return true;
    }
    return ((Boolean)this.g.getValue()).booleanValue();
  }
  
  public boolean p()
  {
    if (this.e.getValue() == null) {
      return false;
    }
    return ((QFSPersonalInfo)this.e.getValue()).v;
  }
  
  public boolean q()
  {
    if (this.e.getValue() == null) {
      return false;
    }
    return ((QFSPersonalInfo)this.e.getValue()).w;
  }
  
  public void r()
  {
    if (!QCircleConfigHelper.bh())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFSPersonalViewModel", 1, "[handleProductsDraftList] isn't new publish model.");
      }
      return;
    }
    if (p())
    {
      ArrayList localArrayList = new ArrayList();
      QFSPersonalFeedInfo localQFSPersonalFeedInfo = s();
      if (localQFSPersonalFeedInfo != null) {
        localArrayList.add(localQFSPersonalFeedInfo);
      }
      this.l.postValue(localArrayList);
    }
  }
  
  public QFSPersonalFeedInfo s()
  {
    List localList = ((IDataManager)QRoute.api(IDataManager.class)).getMissionIds(HostDataTransUtils.getLongAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QFSPersonalViewModel", 1, new Object[] { "[getDraftData] missionIds: ", localList });
    }
    if (localList != null)
    {
      if (localList.size() == 0) {
        return null;
      }
      Object localObject1 = a(((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).getTaskList());
      if (QLog.isColorLevel()) {
        QLog.d("QFSPersonalViewModel", 1, new Object[] { "[getDraftData] uploadingMissionIds.size:", Integer.valueOf(((List)localObject1).size()) });
      }
      Object localObject2 = b(localList, (List)localObject1);
      int i1 = a(localList, (List)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QFSPersonalViewModel", 1, new Object[] { "[getDraftData] firstValidMissionId: ", localObject2 });
      }
      localObject1 = ((IDataManager)QRoute.api(IDataManager.class)).getData(HostDataTransUtils.getLongAccountUin(), (String)localObject2);
      if (!(localObject1 instanceof DraftBean)) {
        return null;
      }
      localObject1 = (DraftBean)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("QFSPersonalViewModel", 1, new Object[] { "[getDraftData] draftBean: ", localObject1 });
      }
      localObject2 = new QFSPersonalFeedInfo(HostDataTransUtils.getAccount(), null, 20104, 100103);
      ((QFSPersonalFeedInfo)localObject2).a(((DraftBean)localObject1).getCoverUrl());
      ((QFSPersonalFeedInfo)localObject2).a(((DraftBean)localObject1).getCreateTime());
      ((QFSPersonalFeedInfo)localObject2).a(localList.size() - i1);
      return localObject2;
    }
    return null;
  }
  
  public void t()
  {
    MutableLiveData localMutableLiveData = this.i;
    localMutableLiveData.setValue(a((UIStateData)localMutableLiveData.getValue(), this.b.b()));
    localMutableLiveData = this.j;
    localMutableLiveData.setValue(a((UIStateData)localMutableLiveData.getValue(), this.d.b()));
    localMutableLiveData = this.k;
    localMutableLiveData.setValue(a((UIStateData)localMutableLiveData.getValue(), this.c.b()));
    if (this.h.getValue() != null)
    {
      localMutableLiveData = this.h;
      localMutableLiveData.setValue(localMutableLiveData.getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel
 * JD-Core Version:    0.7.0.1
 */