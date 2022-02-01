package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeClickRequest;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabGroupId;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class StoryPlayerGlobalHolder$GroupOnPageChangeListener
  implements XViewPager.OnPageChangeListener
{
  int a = 0;
  int b = -1;
  boolean c = false;
  private String e;
  
  private StoryPlayerGlobalHolder$GroupOnPageChangeListener(StoryPlayerGlobalHolder paramStoryPlayerGlobalHolder) {}
  
  public void a(int paramInt)
  {
    StoryPlayerGlobalHolder.b(this.d);
    Object localObject1 = StoryPlayerGlobalHolder.d(this.d).a();
    if ((localObject1 != null) && (paramInt < ((List)localObject1).size())) {
      StoryPlayerGlobalHolder.a(this.d, ((IDataProvider.GroupInfo)((List)localObject1).get(paramInt)).b);
    }
    localObject1 = this.d.a(paramInt);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((StoryPlayerGroupHolder)localObject1).h();
      SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, Group=%s, Video=%s", localObject1, localObject2);
      if (localObject2 != null)
      {
        boolean bool1;
        if (((StoryPlayerGroupHolder)localObject1).l == ((StoryPlayerGroupHolder)localObject1).f.size() - 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2;
        if (((StoryPlayerGroupHolder)localObject1).l == 0) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        boolean bool3 = bool1;
        if (bool1)
        {
          bool3 = bool1;
          if (((StoryPlayerGroupHolder)localObject1).q()) {
            bool3 = false;
          }
        }
        this.d.b.setEnableScrollDirection(bool3, bool2, true, true);
        if (StoryPlayerGlobalHolder.c(this.d) != null) {
          StoryPlayerGlobalHolder.c(this.d).a(paramInt, ((VideoHolderBase)localObject2).e, ((VideoHolderBase)localObject2).e);
        }
      }
    }
    else
    {
      SLog.e("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, GroupHolder=null");
    }
    if ((StoryPlayerGlobalHolder.b(this.d) instanceof MsgTabPlayPageLoader.MsgTabGroupId))
    {
      localObject1 = ((MsgTabPlayPageLoader.MsgTabGroupId)StoryPlayerGlobalHolder.b(this.d)).a;
      if (localObject1 != null) {
        if (!TextUtils.equals(((MsgTabNodeInfo)localObject1).d, this.e))
        {
          this.e = ((MsgTabNodeInfo)localObject1).d;
          localObject2 = new MsgTabNodeClickRequest();
          ((MsgTabNodeClickRequest)localObject2).g = ((MsgTabNodeInfo)localObject1).b;
          ((MsgTabNodeClickRequest)localObject2).f = ((MsgTabNodeInfo)localObject1).d;
          ((MsgTabNodeClickRequest)localObject2).h = ((MsgTabNodeInfo)localObject1).j;
          ((MsgTabNodeInfo)localObject1).B = false;
          CmdTaskManger.a().a((NetworkRequest)localObject2, null);
          SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, send MsgTabNodeClickRequest:%s", localObject1);
        }
        else
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, repeat unionId : %s", this.e);
        }
      }
    }
    else
    {
      SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "onPageSelected, read node event error");
    }
    c(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (StoryPlayerGlobalHolder.c(this.d) != null) {
      StoryPlayerGlobalHolder.c(this.d).a(this.d.b.getCurrentItem(), paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void b(int paramInt)
  {
    int i = this.d.b.getCurrentItem();
    Object localObject = this.d.a(i);
    if (localObject != null)
    {
      localObject = ((StoryPlayerGroupHolder)localObject).h();
      if ((localObject instanceof VideoHolderContainer))
      {
        localObject = (VideoViewVideoHolder)((VideoHolderContainer)localObject).b(VideoViewVideoHolder.class);
        if (localObject != null) {
          if (paramInt == 1)
          {
            SLog.b("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, pause because of dragging");
            ((VideoViewVideoHolder)localObject).p();
          }
          else if (paramInt == 0)
          {
            SLog.a("Q.qqstory.playernew.StoryPlayerGlobalHolder", "Vertical, start because of idle. direction=%d", Integer.valueOf(this.d.b.getmDraggedDirection()));
            if (!((VideoViewVideoHolder)localObject).p.i()) {
              ((VideoViewVideoHolder)localObject).h();
            }
            ThreadManager.executeOnSubThread(new StoryPlayerGlobalHolder.GroupOnPageChangeListener.1(this));
          }
        }
      }
    }
    if (StoryPlayerGlobalHolder.c(this.d) != null) {
      StoryPlayerGlobalHolder.c(this.d).a(i, paramInt);
    }
  }
  
  public void c(int paramInt)
  {
    Iterator localIterator = StoryPlayerGlobalHolder.d(this.d).a.values().iterator();
    int i = 0;
    do
    {
      paramInt = i;
      if (!localIterator.hasNext()) {
        break;
      }
      StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)localIterator.next();
      if ((i == 0) && (!localStoryPlayerGroupHolder.s())) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      i = paramInt;
    } while (paramInt == 0);
    if (paramInt == 0) {
      this.d.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGlobalHolder.GroupOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */