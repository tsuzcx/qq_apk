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
    if ((paramInt >= 0) && (paramInt < paramStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount()))
    {
      Object localObject = paramStoryPlayerGroupHolder.a(paramInt);
      if (localObject != null)
      {
        localObject = (VideoViewVideoHolder)((VideoHolderBase)localObject).a(VideoViewVideoHolder.class);
        if ((localObject != null) && (!((VideoViewVideoHolder)localObject).c()))
        {
          if (((VideoViewVideoHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null) {
            paramStoryPlayerGroupHolder = ((VideoViewVideoHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
          } else {
            paramStoryPlayerGroupHolder = null;
          }
          if ((paramStoryPlayerGroupHolder != null) && (!paramStoryPlayerGroupHolder.startsWith("Loading")))
          {
            if (paramBoolean)
            {
              SLog.a(this.a.jdField_a_of_type_JavaLangString, "pre-prepared video %s. vid = %s", paramString, paramStoryPlayerGroupHolder);
              ((VideoViewVideoHolder)localObject).a(8, "pre-prepared");
              return true;
            }
            SLog.a(this.a.jdField_a_of_type_JavaLangString, "pre-load video %s. vid = %s", paramString, paramStoryPlayerGroupHolder);
            TVKPreloader.a(paramStoryPlayerGroupHolder, true);
            return true;
          }
          SLog.a(this.a.jdField_a_of_type_JavaLangString, "pre-prepared-load video %s failed. vid = %s", paramString, paramStoryPlayerGroupHolder);
        }
      }
      else
      {
        SLog.a(this.a.jdField_a_of_type_JavaLangString, "pre-prepared-load video %s failed. group=%d, video=%d", paramString, Integer.valueOf(paramStoryPlayerGroupHolder.jdField_a_of_type_Int), Integer.valueOf(paramInt));
      }
    }
    return false;
  }
  
  public void a(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView)
  {
    SLog.a(this.a.jdField_a_of_type_JavaLangString, "onPrepared, position ver=%d, hor=%d", Integer.valueOf(paramVideoViewVideoHolder.jdField_a_of_type_Int), Integer.valueOf(paramVideoViewVideoHolder.b));
  }
  
  public void a(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, String paramString2, File paramFile, boolean paramBoolean)
  {
    SLog.a(this.a.jdField_a_of_type_JavaLangString, "onDownloadSuccess, view pager current item = %d, holder position = %d. newDownload=%s", Integer.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Integer.valueOf(paramVideoViewVideoHolder.b), Boolean.valueOf(paramBoolean));
    if (this.a.b())
    {
      paramVideoViewVideoHolder = (StoryPlayerGroupAdapter)this.a.a().a();
      if (paramVideoViewVideoHolder != null)
      {
        paramString2 = this.a;
        a(paramString2, paramString2.b + 1, true, "[↓]");
        paramVideoViewVideoHolder = paramVideoViewVideoHolder.a.values().iterator();
        while (paramVideoViewVideoHolder.hasNext())
        {
          paramString2 = (StoryPlayerGroupHolder)paramVideoViewVideoHolder.next();
          if ((paramString2 != this.a) && (paramString2.jdField_a_of_type_Int > this.a.jdField_a_of_type_Int)) {
            a(paramString2, paramString2.b, true, "[→]");
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
    SLog.d(this.a.jdField_a_of_type_JavaLangString, "onCompletion, current item = %d, repeat = %s, repeatMode=%d", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()), Boolean.valueOf(paramBoolean), Integer.valueOf(StoryPlayerGroupHolder.b(this.a)) });
    if (((StoryPlayerGroupHolder.b(this.a) & 0x1) != 1) && (!paramBoolean))
    {
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() < this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() - 1)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() + 1, true);
      }
      else if ((StoryPlayerGroupHolder.b(this.a) & 0x2) == 2)
      {
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() == 1)
        {
          paramVideoViewVideoHolder.f();
          paramVideoViewVideoHolder.a(10, true, "repeat feed");
        }
        else
        {
          this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.setCurrentItem(0, true);
        }
      }
      else
      {
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() == this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder$StoryPlayerVideoAdapter.getCount() - 1)
        {
          if ((StoryPlayerGroupHolder.a(this.a) != null) && (StoryPlayerGroupHolder.a(this.a).a(paramVideoViewVideoHolder, paramIVideoView, false))) {
            return true;
          }
          if (this.a.d())
          {
            paramVideoViewVideoHolder = (LoadingMoreWidget)this.a.b(LoadingMoreWidget.class);
            if (paramVideoViewVideoHolder != null) {
              paramVideoViewVideoHolder.d();
            }
            paramVideoViewVideoHolder = new StringBuilder();
            paramVideoViewVideoHolder.append(this.a.jdField_a_of_type_JavaLangString);
            paramVideoViewVideoHolder.append("Q.qqstory.weishi");
            SLog.b(paramVideoViewVideoHolder.toString(), "onCompletion, showLoadingMoreWidget");
            break label371;
          }
          paramVideoViewVideoHolder = this.a.a();
          if (paramVideoViewVideoHolder.c() < paramVideoViewVideoHolder.a().getCount() - 1)
          {
            paramVideoViewVideoHolder.setEnableScrollDirection(true, true, false, false);
            paramVideoViewVideoHolder.setCurrentItem(paramVideoViewVideoHolder.c() + 1, true);
            break label371;
          }
        }
        i = 1;
        break label374;
      }
    }
    else
    {
      paramVideoViewVideoHolder.f();
      paramVideoViewVideoHolder.a(10, true, "repeat video");
    }
    label371:
    int i = 0;
    label374:
    if (i != 0)
    {
      SLog.d(this.a.jdField_a_of_type_JavaLangString, "onCompletion, current item = %d, finish", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()) });
      StoryReportor.a("play_video", "auto_quit", 0, 0, new String[0]);
      this.a.a().finish();
    }
    return true;
  }
  
  public void b(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView)
  {
    SLog.a(this.a.jdField_a_of_type_JavaLangString, "onStarting, position ver=%d, hor=%d", Integer.valueOf(paramVideoViewVideoHolder.jdField_a_of_type_Int), Integer.valueOf(paramVideoViewVideoHolder.b));
  }
  
  public void c(VideoViewVideoHolder paramVideoViewVideoHolder, IVideoView paramIVideoView)
  {
    if (this.a.b())
    {
      TVKPreloader.a();
      paramIVideoView = (StoryPlayerGroupAdapter)this.a.a().a();
      if (paramIVideoView != null)
      {
        StoryPlayerGroupHolder localStoryPlayerGroupHolder = this.a;
        a(localStoryPlayerGroupHolder, localStoryPlayerGroupHolder.b + 1, true, "[↓]");
        paramIVideoView = paramIVideoView.a.values().iterator();
        while (paramIVideoView.hasNext())
        {
          localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramIVideoView.next();
          if (localStoryPlayerGroupHolder != this.a) {
            if (localStoryPlayerGroupHolder.jdField_a_of_type_Int < this.a.jdField_a_of_type_Int) {
              a(localStoryPlayerGroupHolder, localStoryPlayerGroupHolder.b, false, "[←]");
            } else if (localStoryPlayerGroupHolder.jdField_a_of_type_Int > this.a.jdField_a_of_type_Int) {
              a(localStoryPlayerGroupHolder, localStoryPlayerGroupHolder.b, true, "[→]");
            }
          }
        }
        paramIVideoView = this.a;
        a(paramIVideoView, paramIVideoView.b - 1, false, "[↑]");
      }
      paramIVideoView = this.a.jdField_a_of_type_JavaUtilList;
      int i = paramIVideoView.size();
      if (paramVideoViewVideoHolder.b + 2 < i)
      {
        paramVideoViewVideoHolder = ((StoryPlayerVideoData)paramIVideoView.get(paramVideoViewVideoHolder.b + 2)).jdField_a_of_type_JavaLangString;
        if (!paramVideoViewVideoHolder.startsWith("Loading"))
        {
          SLog.a(this.a.jdField_a_of_type_JavaLangString, "pre-load video [↓↓]. vid = %s", paramVideoViewVideoHolder);
          TVKPreloader.a(paramVideoViewVideoHolder, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.4
 * JD-Core Version:    0.7.0.1
 */