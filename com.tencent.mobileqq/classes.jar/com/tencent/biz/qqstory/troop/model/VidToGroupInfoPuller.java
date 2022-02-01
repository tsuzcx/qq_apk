package com.tencent.biz.qqstory.troop.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller.OnFinishCallBack;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class VidToGroupInfoPuller
  implements IEventReceiver
{
  public int a = 0;
  protected AtomicBoolean b = new AtomicBoolean(false);
  protected String c;
  protected BatchHandlerListPuller d;
  protected StoryManager e;
  protected List<String> f;
  IVidToVideoInfoPuller.OnFinishCallBack g;
  
  public VidToGroupInfoPuller(String paramString, List<String> paramList)
  {
    this.c = paramString;
    this.e = ((StoryManager)SuperManager.a(5));
    paramString = paramList;
    if (paramList == null) {
      paramString = new ArrayList();
    }
    this.f = paramString;
  }
  
  protected BatchHandlerListPuller a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!StoryVideoItem.isFakeVid(str))
      {
        StoryVideoItem localStoryVideoItem = this.e.a(str);
        if ((localStoryVideoItem == null) || (localStoryVideoItem.mBasicInfoState != 1) || (TextUtils.isEmpty(localStoryVideoItem.getVideoUrl())) || (TextUtils.isEmpty(localStoryVideoItem.getThumbUrl()))) {
          localArrayList.add(str);
        }
      }
    }
    paramList = new ArrayList();
    int j;
    for (int i = 0; i < localArrayList.size(); i = j)
    {
      j = Math.min(localArrayList.size(), i + 20);
      if (i >= j) {
        break;
      }
      paramList.add(new VidToBasicInfoHandler(localArrayList.subList(i, j)));
    }
    return new BatchHandlerListPuller(paramList);
  }
  
  public void a()
  {
    if (this.b.getAndSet(true)) {
      return;
    }
    this.a = 1;
    Bosses.get().postJob(new VidToGroupInfoPuller.1(this, "Q.qqstory.net:VidToGroupInfoPuller"));
  }
  
  protected boolean a(List<String> paramList, ErrorMessage paramErrorMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (String)((Iterator)localObject).next();
      StoryVideoItem localStoryVideoItem = this.e.a(paramList);
      if (localStoryVideoItem == null)
      {
        localObject = new StoryVideoItem();
        ((StoryVideoItem)localObject).mStoryType = 2;
        ((StoryVideoItem)localObject).mVid = paramList;
      }
      while ((!paramBoolean1) && ((TextUtils.isEmpty(localStoryVideoItem.getVideoUrl())) || (TextUtils.isEmpty(localStoryVideoItem.getThumbUrl()))))
      {
        bool = true;
        break;
      }
      localArrayList.add(localStoryVideoItem);
    }
    boolean bool = false;
    if (bool) {
      localArrayList.clear();
    }
    paramList = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    paramList.g = paramErrorMessage;
    paramList.i = (paramBoolean1 ^ true);
    paramList.a = this.c;
    paramList.j = (bool ^ true);
    paramList.e = localArrayList;
    paramList.h = localArrayList.size();
    StoryDispatcher.a().dispatch(paramList);
    if (paramBoolean1)
    {
      int i = this.a;
      if (i == 1)
      {
        this.a = 2;
        return bool;
      }
      if (i == 3)
      {
        this.a = 4;
        paramList = this.g;
        if (paramList != null) {
          paramList.a(localArrayList, paramBoolean2);
        }
      }
    }
    return bool;
  }
  
  public void b()
  {
    this.d = a(this.f);
    this.d.a("Q.qqstory.net:VidToGroupInfoPuller");
    this.d.a(new VidToGroupInfoPuller.2(this));
    this.d.b();
  }
  
  public boolean c()
  {
    int i = this.a;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean isValidate()
  {
    return this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.VidToGroupInfoPuller
 * JD-Core Version:    0.7.0.1
 */