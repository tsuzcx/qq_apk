package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class GetMyStoryDesFromVidListStep$1
  implements BatchHandlerListPuller.IPullResultCallback
{
  GetMyStoryDesFromVidListStep$1(GetMyStoryDesFromVidListStep paramGetMyStoryDesFromVidListStep, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    SLog.d("GetMyStoryDesFromVidListStep", "onFinishAll(%b[isEveryTaskSuccess])", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      SLog.e("GetMyStoryDesFromVidListStep", "Get vid to basic info failed!");
      if (this.b.a != null)
      {
        this.b.a.a(this.b.c());
        return;
      }
      SLog.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    Object localObject1 = (StoryManager)SuperManager.a(5);
    Iterator localIterator = this.a.iterator();
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject3 = ((StoryManager)localObject1).a((String)localObject2);
      SLog.b("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) = %s", localObject2, localObject3);
      if (localObject3 == null) {
        SLog.e("GetMyStoryDesFromVidListStep", "manager.queryVideoByVid(%s) return null", new Object[] { localObject2 });
      } else {
        localArrayList.add(localObject3);
      }
    }
    ((StoryManager)localObject1).a(QQStoryContext.a().i(), 0, localArrayList, true);
    localIterator = ((StoryManager)localObject1).a(false).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (StoryVideoItem)localIterator.next();
      localObject3 = HomeFeedPresenter.b((StoryVideoItem)localObject2, localArrayList);
      if (localObject3 != null)
      {
        ((StoryManager)localObject1).j(((StoryVideoItem)localObject2).mVid);
        SLog.d("GetMyStoryDesFromVidListStep", "delete local fake item because we get real item from server, local vid=%s, network vid=%s", new Object[] { ((StoryVideoItem)localObject2).mVid, localObject3 });
      }
      else
      {
        HomeFeedPresenter.a((StoryVideoItem)localObject2);
      }
    }
    localObject1 = ((StoryManager)localObject1).g(QQStoryContext.a().i());
    GetMyStoryDesFromVidListStep.a(this.b).e();
    GetMyStoryDesFromVidListStep.a(this.b).a((List)localObject1);
    GetMyStoryDesFromVidListStep.a(this.b).t = this.b.c.f;
    GetMyStoryDesFromVidListStep.a(this.b).g = this.b.c.c;
    Collections.sort(GetMyStoryDesFromVidListStep.a(this.b).b());
    if (GetMyStoryDesFromVidListStep.b(this.b) != null) {
      GetMyStoryDesFromVidListStep.b(this.b).a(GetMyStoryDesFromVidListStep.a(this.b));
    }
    if (this.b.a != null)
    {
      this.b.a.a(this.b.c());
      return;
    }
    SLog.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryDesFromVidListStep.1
 * JD-Core Version:    0.7.0.1
 */