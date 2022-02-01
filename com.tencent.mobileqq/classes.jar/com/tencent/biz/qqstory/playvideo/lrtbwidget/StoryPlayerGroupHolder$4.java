package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.app.Activity;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class StoryPlayerGroupHolder$4
  implements VideoViewVideoHolder.VideoViewListener
{
  StoryPlayerGroupHolder$4(StoryPlayerGroupHolder paramStoryPlayerGroupHolder) {}
  
  private boolean a(StoryPlayerGroupHolder paramStoryPlayerGroupHolder, int paramInt, boolean paramBoolean, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < paramStoryPlayerGroupHolder.k.getCount()))
    {
      Object localObject = paramStoryPlayerGroupHolder.b(paramInt);
      if (localObject != null)
      {
        localObject = (VideoViewVideoHolder)((VideoHolderBase)localObject).a(VideoViewVideoHolder.class);
        if ((localObject != null) && (!((VideoViewVideoHolder)localObject).f()))
        {
          if (((VideoViewVideoHolder)localObject).c != null) {
            paramStoryPlayerGroupHolder = ((VideoViewVideoHolder)localObject).c.b;
          } else {
            paramStoryPlayerGroupHolder = null;
          }
          if ((paramStoryPlayerGroupHolder != null) && (!paramStoryPlayerGroupHolder.startsWith("Loading")))
          {
            if (paramBoolean)
            {
              SLog.a(this.a.a, "pre-prepared video %s. vid = %s", paramString, paramStoryPlayerGroupHolder);
              ((VideoViewVideoHolder)localObject).a(8, "pre-prepared");
              return true;
            }
            SLog.a(this.a.a, "pre-load video %s. vid = %s", paramString, paramStoryPlayerGroupHolder);
            TVKPreloader.a(paramStoryPlayerGroupHolder, true);
            return true;
          }
          SLog.a(this.a.a, "pre-prepared-load video %s failed. vid = %s", paramString, paramStoryPlayerGroupHolder);
        }
      }
      else
      {
        SLog.a(this.a.a, "pre-prepared-load video %s failed. group=%d, video=%d", paramString, Integer.valueOf(paramStoryPlayerGroupHolder.d), Integer.valueOf(paramInt));
      }
    }
    return false;
  }
  
  public void a(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView)
  {
    SLog.a(this.a.a, "onPrepared, position ver=%d, hor=%d", Integer.valueOf(paramVideoViewVideoHolder.d), Integer.valueOf(paramVideoViewVideoHolder.e));
  }
  
  public void a(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, String paramString2, File paramFile, boolean paramBoolean)
  {
    SLog.a(this.a.a, "onDownloadSuccess, view pager current item = %d, holder position = %d. newDownload=%s", Integer.valueOf(this.a.j.getCurrentItem()), Integer.valueOf(paramVideoViewVideoHolder.e), Boolean.valueOf(paramBoolean));
    if (this.a.l())
    {
      paramVideoViewVideoHolder = (StoryPlayerGroupAdapter)this.a.c().getAdapter();
      if (paramVideoViewVideoHolder != null)
      {
        paramString2 = this.a;
        a(paramString2, paramString2.l + 1, true, "[↓]");
        paramVideoViewVideoHolder = paramVideoViewVideoHolder.a.values().iterator();
        while (paramVideoViewVideoHolder.hasNext())
        {
          paramString2 = (StoryPlayerGroupHolder)paramVideoViewVideoHolder.next();
          if ((paramString2 != this.a) && (paramString2.d > this.a.d)) {
            a(paramString2, paramString2.l, true, "[→]");
          }
        }
      }
    }
    if (paramBoolean) {
      StoryDispatcher.a().dispatch(new StoryPlayerGroupHolder.DownloadVideoResultEvent(paramString1, true, paramFile));
    }
  }
  
  public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView, int paramInt, Object paramObject)
  {
    return false;
  }
  
  public boolean a(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView, boolean paramBoolean)
  {
    SLog.d(this.a.a, "onCompletion, current item = %d, repeat = %s, repeatMode=%d", new Object[] { Integer.valueOf(this.a.j.getCurrentItem()), Boolean.valueOf(paramBoolean), Integer.valueOf(StoryPlayerGroupHolder.e(this.a)) });
    if (((StoryPlayerGroupHolder.e(this.a) & 0x1) != 1) && (!paramBoolean))
    {
      if (this.a.j.getCurrentItem() < this.a.k.getCount() - 1)
      {
        this.a.j.setCurrentItem(this.a.j.getCurrentItem() + 1, true);
      }
      else if ((StoryPlayerGroupHolder.e(this.a) & 0x2) == 2)
      {
        if (this.a.k.getCount() == 1)
        {
          paramVideoViewVideoHolder.u();
          paramVideoViewVideoHolder.a(10, true, "repeat feed");
        }
        else
        {
          this.a.j.setCurrentItem(0, true);
        }
      }
      else
      {
        if (this.a.j.getCurrentItem() == this.a.k.getCount() - 1)
        {
          if ((StoryPlayerGroupHolder.f(this.a) != null) && (StoryPlayerGroupHolder.f(this.a).a(paramVideoViewVideoHolder, paramIVideoView, false))) {
            return true;
          }
          if (this.a.q())
          {
            paramVideoViewVideoHolder = (LoadingMoreWidget)this.a.b(LoadingMoreWidget.class);
            if (paramVideoViewVideoHolder != null) {
              paramVideoViewVideoHolder.h();
            }
            paramVideoViewVideoHolder = new StringBuilder();
            paramVideoViewVideoHolder.append(this.a.a);
            paramVideoViewVideoHolder.append("Q.qqstory.weishi");
            SLog.b(paramVideoViewVideoHolder.toString(), "onCompletion, showLoadingMoreWidget");
            break label371;
          }
          paramVideoViewVideoHolder = this.a.c();
          if (paramVideoViewVideoHolder.getCurrentItem() < paramVideoViewVideoHolder.getAdapter().getCount() - 1)
          {
            paramVideoViewVideoHolder.setEnableScrollDirection(true, true, false, false);
            paramVideoViewVideoHolder.setCurrentItem(paramVideoViewVideoHolder.getCurrentItem() + 1, true);
            break label371;
          }
        }
        i = 1;
        break label374;
      }
    }
    else
    {
      paramVideoViewVideoHolder.u();
      paramVideoViewVideoHolder.a(10, true, "repeat video");
    }
    label371:
    int i = 0;
    label374:
    if (i != 0)
    {
      SLog.d(this.a.a, "onCompletion, current item = %d, finish", new Object[] { Integer.valueOf(this.a.j.getCurrentItem()) });
      StoryReportor.a("play_video", "auto_quit", 0, 0, new String[0]);
      this.a.a().finish();
    }
    return true;
  }
  
  public void b(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView)
  {
    SLog.a(this.a.a, "onStarting, position ver=%d, hor=%d", Integer.valueOf(paramVideoViewVideoHolder.d), Integer.valueOf(paramVideoViewVideoHolder.e));
  }
  
  public void c(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView)
  {
    if (this.a.l())
    {
      TVKPreloader.a();
      paramIVideoView = (StoryPlayerGroupAdapter)this.a.c().getAdapter();
      if (paramIVideoView != null)
      {
        StoryPlayerGroupHolder localStoryPlayerGroupHolder = this.a;
        a(localStoryPlayerGroupHolder, localStoryPlayerGroupHolder.l + 1, true, "[↓]");
        paramIVideoView = paramIVideoView.a.values().iterator();
        while (paramIVideoView.hasNext())
        {
          localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramIVideoView.next();
          if (localStoryPlayerGroupHolder != this.a) {
            if (localStoryPlayerGroupHolder.d < this.a.d) {
              a(localStoryPlayerGroupHolder, localStoryPlayerGroupHolder.l, false, "[←]");
            } else if (localStoryPlayerGroupHolder.d > this.a.d) {
              a(localStoryPlayerGroupHolder, localStoryPlayerGroupHolder.l, true, "[→]");
            }
          }
        }
        paramIVideoView = this.a;
        a(paramIVideoView, paramIVideoView.l - 1, false, "[↑]");
      }
      paramIVideoView = this.a.f;
      int i = paramIVideoView.size();
      if (paramVideoViewVideoHolder.e + 2 < i)
      {
        paramVideoViewVideoHolder = ((StoryPlayerVideoData)paramIVideoView.get(paramVideoViewVideoHolder.e + 2)).b;
        if (!paramVideoViewVideoHolder.startsWith("Loading"))
        {
          SLog.a(this.a.a, "pre-load video [↓↓]. vid = %s", paramVideoViewVideoHolder);
          TVKPreloader.a(paramVideoViewVideoHolder, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.4
 * JD-Core Version:    0.7.0.1
 */