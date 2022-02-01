package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopVidToVideoInfoPuller
  implements IEventReceiver
{
  protected BatchHandlerListPuller a;
  protected TroopUidToVidListHandler b;
  protected TroopVidToVideoInfoPuller.StoryVidListReceiver c;
  protected IVidToVideoInfoPuller.OnFinishCallBack d;
  protected IVidToVideoInfoPuller.OnFinishCallBack e;
  protected AtomicBoolean f = new AtomicBoolean(false);
  protected int g;
  protected String h;
  protected String i;
  protected boolean j = false;
  public int k = 0;
  protected long l;
  protected List<String> m = new ArrayList();
  
  public TroopVidToVideoInfoPuller(String paramString1, String paramString2, int paramInt)
  {
    this.i = paramString1;
    this.h = paramString2;
    this.g = paramInt;
  }
  
  public void a()
  {
    if (this.f.getAndSet(true)) {
      return;
    }
    this.l = System.currentTimeMillis();
    this.k = 1;
    SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", String.format("Start , %s", new Object[] { this }));
    b();
  }
  
  protected void a(@NonNull List<String> paramList)
  {
    this.m = paramList;
    this.a = b(paramList);
    this.a.b();
  }
  
  protected void a(List<String> paramList, ErrorMessage paramErrorMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = localStoryManager.a(str);
      paramList = (List<String>)localObject;
      if (localObject == null)
      {
        paramList = new StoryVideoItem();
        paramList.mVid = str;
      }
      localArrayList.add(paramList);
    }
    paramList = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    paramList.g = paramErrorMessage;
    paramList.i = (paramBoolean1 ^ true);
    paramList.a = this.i;
    paramList.j = paramBoolean1;
    paramList.e = localArrayList;
    paramList.h = localArrayList.size();
    paramList.b = this.h;
    StoryDispatcher.a().dispatch(paramList);
    if (paramBoolean1)
    {
      n = this.k;
      if (n == 1)
      {
        this.k = 2;
        localObject = this.d;
        if (localObject != null) {
          ((IVidToVideoInfoPuller.OnFinishCallBack)localObject).a(paramList.e, paramBoolean2);
        }
      }
      else if (n == 3)
      {
        this.k = 4;
        localObject = this.e;
        if (localObject != null) {
          ((IVidToVideoInfoPuller.OnFinishCallBack)localObject).a(paramList.e, paramBoolean2);
        }
      }
    }
    Object localObject = this.h;
    int n = localArrayList.size();
    if (paramBoolean1) {
      paramList = "from net ";
    } else {
      paramList = "from local";
    }
    SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", "Dispatch event , uin = %s , count = %d , error = %s , %s ,video list = %s ,use total time = %d", new Object[] { localObject, Integer.valueOf(n), paramErrorMessage, paramList, localArrayList, Long.valueOf(System.currentTimeMillis() - this.l) });
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  protected BatchHandlerListPuller b(@NonNull List<String> paramList)
  {
    BatchHandlerListPuller localBatchHandlerListPuller = BatchHandlerListPuller.a(paramList);
    localBatchHandlerListPuller.a("Q.qqstory.net:TroopVidToVideoInfoPuller");
    localBatchHandlerListPuller.a(new TroopVidToVideoInfoPuller.2(this, paramList));
    return localBatchHandlerListPuller;
  }
  
  protected void b()
  {
    if (this.k == 3)
    {
      List localList = this.m;
      if ((localList != null) && (localList.size() > 0))
      {
        a(this.m);
        return;
      }
    }
    if (this.g == 3) {
      c();
    }
  }
  
  protected void c()
  {
    Bosses.get().postJob(new TroopVidToVideoInfoPuller.1(this, "Q.qqstory.net:TroopVidToVideoInfoPuller"));
  }
  
  public boolean isValidate()
  {
    return this.f.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VidToVideoInfoPuller{, mUin='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContext='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller
 * JD-Core Version:    0.7.0.1
 */