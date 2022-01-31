package com.tencent.biz.qqstory.playmode.util;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.network.handler.SendVidRateDataHandler;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.InteractPasterWidget;
import com.tencent.biz.qqstory.view.widget.RateWidget;
import java.util.Locale;
import nms;

public class PlayModeInteractViewUtils
{
  public static void a(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      SLog.c("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    SLog.a("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramVideoViewHolder.c));
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      SLog.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    InteractPasterWidget localInteractPasterWidget = paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget;
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget.a(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localInteractPasterWidget.a(), localLayoutParams);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.forceLayout();
    b(paramVideoPlayModeBase, paramVideoViewHolder, paramStoryVideoItem, false);
  }
  
  public static void a(VideoPlayModeBase paramVideoPlayModeBase, RateWidget paramRateWidget, float paramFloat)
  {
    boolean bool2 = true;
    if (paramVideoPlayModeBase == null) {
      SLog.c("Q.qqstory.PlayModeInteractViewUtils", "onClickPollViewButton playMode is null!", new NullPointerException());
    }
    int i;
    StoryVideoItem localStoryVideoItem;
    label133:
    do
    {
      return;
      i = paramVideoPlayModeBase.b;
      localStoryVideoItem = paramVideoPlayModeBase.a(paramVideoPlayModeBase.b);
      localObject = paramVideoPlayModeBase.a(paramVideoPlayModeBase.b);
      if ((localStoryVideoItem == null) || (localObject == null))
      {
        paramRateWidget = Locale.getDefault();
        i = paramVideoPlayModeBase.b;
        boolean bool1;
        if (localStoryVideoItem == null)
        {
          bool1 = true;
          if (localObject != null) {
            break label133;
          }
        }
        for (;;)
        {
          SLog.c("Q.qqstory.PlayModeInteractViewUtils", "onRateClick item or holder is null!", new NullPointerException(String.format(paramRateWidget, "index: %d, item is null:%b, holder is null %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) })));
          return;
          bool1 = false;
          break;
          bool2 = false;
        }
      }
    } while (i != ((Integer)paramRateWidget.a().getTag(2131362460)).intValue());
    Object localObject = paramVideoPlayModeBase.a(((VideoPlayerPagerAdapter.VideoViewHolder)localObject).c);
    if (localObject == null)
    {
      localObject = null;
      SendVidRateDataHandler.a((String)localObject, localStoryVideoItem.mVid, (int)paramFloat);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramRateWidget.a()[0]).append(";").append(String.valueOf((int)paramFloat));
      paramRateWidget = ((StringBuilder)localObject).toString();
      i = paramVideoPlayModeBase.a();
      if (!localStoryVideoItem.isMine()) {
        break label292;
      }
    }
    label292:
    for (paramVideoPlayModeBase = "1";; paramVideoPlayModeBase = "0")
    {
      StoryReportor.a("play_video", "in_vote", 2, 0, new String[] { paramRateWidget, String.valueOf(i), paramVideoPlayModeBase, localStoryVideoItem.mVid });
      return;
      localObject = ((VideoListFeedItem)localObject).feedId;
      break;
    }
  }
  
  public static void b(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    SLog.a("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramVideoViewHolder.c));
    int i = paramVideoViewHolder.c;
    b(paramVideoPlayModeBase, paramVideoViewHolder, paramStoryVideoItem, true);
    paramVideoViewHolder = paramVideoPlayModeBase.a(i - 1);
    if (paramVideoViewHolder != null)
    {
      paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget.a(false);
    }
    paramVideoPlayModeBase = paramVideoPlayModeBase.a(i + 1);
    if (paramVideoPlayModeBase != null)
    {
      paramVideoPlayModeBase.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      paramVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget.a(false);
    }
  }
  
  private static void b(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    int n = paramVideoViewHolder.c;
    StoryVideoItem.InteractPasterLayout localInteractPasterLayout = paramStoryVideoItem.getInteractLayout();
    if (localInteractPasterLayout == null) {
      SLog.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
    }
    View localView;
    int i;
    int j;
    int k;
    int m;
    float f1;
    float f2;
    float f3;
    do
    {
      return;
      SLog.b("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(n));
      localView = paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget.a();
      localView.setTag(2131362460, Integer.valueOf(n));
      i = localInteractPasterLayout.b;
      j = localInteractPasterLayout.c;
      k = localInteractPasterLayout.d;
      m = localInteractPasterLayout.e;
      f1 = localInteractPasterLayout.f;
      f2 = localInteractPasterLayout.g;
      f3 = localInteractPasterLayout.h;
      String[] arrayOfString = localInteractPasterLayout.a;
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        SLog.c("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
      }
      SLog.b("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget.a(arrayOfString);
      if (paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.post(new nms(paramVideoPlayModeBase, paramVideoViewHolder, paramStoryVideoItem));
    return;
    n = paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
    int i1 = paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
    paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget.a(localInteractPasterLayout.b, localInteractPasterLayout.c, n, i1, localInteractPasterLayout.d, localInteractPasterLayout.e, localInteractPasterLayout.f, localInteractPasterLayout.g, localInteractPasterLayout.h);
    paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget.a();
    c(paramVideoPlayModeBase, paramVideoViewHolder, paramStoryVideoItem);
    localView.setVisibility(0);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    SLog.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(n), Integer.valueOf(i1) });
    SLog.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getLeft()), Integer.valueOf(paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getRight()));
  }
  
  public static void c(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      SLog.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    do
    {
      return;
      if (paramVideoViewHolder == null)
      {
        SLog.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg holder is null"));
        return;
      }
    } while (!(paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget instanceof RateWidget));
    d(paramVideoPlayModeBase, paramVideoViewHolder, paramStoryVideoItem);
  }
  
  private static void d(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    SLog.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
    paramVideoViewHolder = (RateWidget)paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget;
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramVideoViewHolder.b(false);
      paramVideoViewHolder.a(paramStoryVideoItem.mRateResult);
      paramVideoViewHolder.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramVideoViewHolder.a(true);
        paramVideoViewHolder.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramVideoViewHolder.a(paramVideoPlayModeBase, true);
          return;
        }
        paramVideoViewHolder.a(null, false);
        return;
      }
      paramVideoViewHolder.a(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramVideoViewHolder.b(false);
      paramVideoViewHolder.a(0.0F);
      paramVideoViewHolder.a(null);
      paramVideoViewHolder.a(false);
      return;
    }
    paramVideoViewHolder.b(true);
    paramVideoViewHolder.a(0.0F);
    paramVideoViewHolder.a(paramVideoPlayModeBase);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramVideoViewHolder.a(true);
      paramVideoViewHolder.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramVideoViewHolder.a(paramVideoPlayModeBase, true);
      return;
    }
    paramVideoViewHolder.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils
 * JD-Core Version:    0.7.0.1
 */