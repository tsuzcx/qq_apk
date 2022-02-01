package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.handler.UidToVidHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.concurrent.atomic.AtomicBoolean;

public class VidToVideoInfoPuller
  implements IVidToVideoInfoPuller, IEventReceiver
{
  protected BatchHandlerListPuller a;
  protected UidToVidHandler b;
  protected VidToVideoInfoPuller.StoryVidListReceiver c;
  protected IVidToVideoInfoPuller.OnFinishCallBack d;
  protected IVidToVideoInfoPuller.OnFinishCallBack e;
  protected AtomicBoolean f = new AtomicBoolean(false);
  protected int g;
  protected int h;
  protected String i;
  protected String j;
  protected String k;
  protected boolean l = false;
  public int m = 0;
  protected long n;
  protected List<String> o = new ArrayList();
  
  public VidToVideoInfoPuller(String paramString1, String paramString2, int paramInt)
  {
    this.g = 1;
    this.k = paramString1;
    this.j = paramString2;
    this.h = paramInt;
  }
  
  public VidToVideoInfoPuller(String paramString1, String paramString2, String paramString3)
  {
    this.g = 0;
    this.k = paramString1;
    this.i = paramString3;
    this.j = paramString2;
  }
  
  public void a()
  {
    if (this.f.getAndSet(true)) {
      return;
    }
    this.n = System.currentTimeMillis();
    this.m = 1;
    SLog.d("Q.qqstory.net:VidToVideoInfoPuller", String.format("Start , %s", new Object[] { this }));
    b();
  }
  
  protected void a(@NonNull List<String> paramList)
  {
    this.o = paramList;
    this.a = b(paramList);
    a(paramList, new ErrorMessage(), false, false);
    this.a.b();
  }
  
  protected void a(List<String> paramList, ErrorMessage paramErrorMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new ArrayList();
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject2 = localStoryManager.a(str);
      paramList = (List<String>)localObject2;
      if (localObject2 == null)
      {
        paramList = new StoryVideoItem();
        paramList.mVid = str;
      }
      if (!TextUtils.isEmpty(this.j)) {
        paramList.mOwnerUid = this.j;
      }
      ((List)localObject1).add(paramList);
    }
    paramList = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    paramList.g = paramErrorMessage;
    paramList.i = (paramBoolean1 ^ true);
    paramList.a = this.k;
    paramList.j = paramBoolean1;
    paramList.e = ((List)localObject1);
    paramList.h = ((List)localObject1).size();
    paramList.b = this.j;
    StoryDispatcher.a().dispatch(paramList);
    if (paramBoolean1)
    {
      i1 = this.m;
      if (i1 == 1)
      {
        this.m = 2;
        localObject2 = this.d;
        if (localObject2 != null) {
          ((IVidToVideoInfoPuller.OnFinishCallBack)localObject2).a(paramList.e, paramBoolean2);
        }
      }
      else if (i1 == 3)
      {
        this.m = 4;
        localObject2 = this.e;
        if (localObject2 != null) {
          ((IVidToVideoInfoPuller.OnFinishCallBack)localObject2).a(paramList.e, paramBoolean2);
        }
      }
    }
    if (((List)localObject1).size() > 10) {
      paramList = ((List)localObject1).subList(0, 10);
    } else {
      paramList = (List<String>)localObject1;
    }
    Object localObject2 = this.j;
    int i1 = ((List)localObject1).size();
    if (paramBoolean1) {
      localObject1 = "from net ";
    } else {
      localObject1 = "from local";
    }
    SLog.d("Q.qqstory.net:VidToVideoInfoPuller", "Dispatch event , uin = %s , count = %d , error = %s , %s ,video list = %s ,use total time = %d", new Object[] { localObject2, Integer.valueOf(i1), paramErrorMessage, localObject1, paramList, Long.valueOf(System.currentTimeMillis() - this.n) });
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  protected BatchHandlerListPuller b(@NonNull List<String> paramList)
  {
    BatchHandlerListPuller localBatchHandlerListPuller = BatchHandlerListPuller.a(paramList);
    localBatchHandlerListPuller.a("Q.qqstory.net:VidToVideoInfoPuller");
    localBatchHandlerListPuller.a(new VidToVideoInfoPuller.5(this, paramList));
    return localBatchHandlerListPuller;
  }
  
  protected void b()
  {
    if (this.m == 3)
    {
      List localList = this.o;
      if ((localList != null) && (localList.size() > 0))
      {
        a(this.o);
        return;
      }
    }
    int i1 = this.g;
    if (i1 == 0)
    {
      c();
      return;
    }
    if (i1 == 1)
    {
      i1 = this.h;
      if (i1 == 4) {
        d();
      } else if (i1 == 6) {
        f();
      } else {
        e();
      }
    }
    if (this.g == 2) {
      a(this.o);
    }
  }
  
  protected void c()
  {
    AssertUtils.checkNotNull(this.i);
    Bosses.get().postJob(new VidToVideoInfoPuller.1(this, "Q.qqstory.net:VidToVideoInfoPuller"));
  }
  
  protected void d()
  {
    if (!this.l)
    {
      SLog.d("Q.qqstory.net:VidToVideoInfoPuller", "requestMyVidList() load from local storage");
      Bosses.get().postJob(new VidToVideoInfoPuller.2(this, "Q.qqstory.net:VidToVideoInfoPuller"));
      return;
    }
    if (this.c == null)
    {
      this.c = new VidToVideoInfoPuller.StoryVidListReceiver(this);
      StoryDispatcher.a().registerSubscriber(this.c);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QQStoryContext.a().i());
    this.b = new UidToVidHandler(localArrayList, this.h);
    this.b.a();
    SLog.d("Q.qqstory.net:VidToVideoInfoPuller", "requestMyVidList() load from network pullType = %d, uinList = %s", new Object[] { Integer.valueOf(this.h), localArrayList });
  }
  
  protected void e()
  {
    Bosses.get().postJob(new VidToVideoInfoPuller.3(this, "Q.qqstory.net:VidToVideoInfoPuller"));
  }
  
  protected void f()
  {
    Bosses.get().postJob(new VidToVideoInfoPuller.4(this, "Q.qqstory.net:VidToVideoInfoPuller"));
  }
  
  public boolean isValidate()
  {
    return this.f.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VidToVideoInfoPuller{, mSource=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mCollectionKey='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mUin='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContext='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.VidToVideoInfoPuller
 * JD-Core Version:    0.7.0.1
 */