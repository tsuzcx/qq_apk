package com.tencent.biz.qqstory.playmode.util;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.network.handler.SendVidPollDataHandler;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.OptionElement;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.QuestionElement;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetElement;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import nlj;

public class PlayModePollViewUtils
{
  public static void a(VideoPlayModeBase paramVideoPlayModeBase, PollWidgetUtils.IPollWidget paramIPollWidget, PollWidgetUtils.WidgetElement paramWidgetElement)
  {
    int j = 1;
    boolean bool2 = true;
    if (paramVideoPlayModeBase == null) {
      SLog.c("Q.qqstory.PlayModePollViewUtils", "onClickPollViewButton playMode is null!", new NullPointerException());
    }
    StoryVideoItem localStoryVideoItem;
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder;
    label136:
    int k;
    do
    {
      do
      {
        return;
        i = paramVideoPlayModeBase.b;
        localStoryVideoItem = paramVideoPlayModeBase.a(paramVideoPlayModeBase.b);
        localVideoViewHolder = paramVideoPlayModeBase.a(paramVideoPlayModeBase.b);
        if ((localStoryVideoItem == null) || (localVideoViewHolder == null))
        {
          paramIPollWidget = Locale.getDefault();
          i = paramVideoPlayModeBase.b;
          boolean bool1;
          if (localStoryVideoItem == null)
          {
            bool1 = true;
            if (localVideoViewHolder != null) {
              break label136;
            }
          }
          for (;;)
          {
            SLog.c("Q.qqstory.PlayModePollViewUtils", "onWidgetElementClick item or holder is null!", new NullPointerException(String.format(paramIPollWidget, "index: %d, item is null:%b, holder is null %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) })));
            return;
            bool1 = false;
            break;
            bool2 = false;
          }
        }
      } while ((paramWidgetElement instanceof PollWidgetUtils.QuestionElement));
      k = ((PollWidgetUtils.OptionElement)paramWidgetElement).a();
    } while (i != ((Integer)paramIPollWidget.a().getTag(2131362457)).intValue());
    SLog.c("Q.qqstory.PlayModePollViewUtils", "[%d]vid:%s  投票!! poll index %d!! %.2f %.2f", new Object[] { Integer.valueOf(i), localStoryVideoItem.mVid, Integer.valueOf(k), Float.valueOf(paramIPollWidget.a().getX()), Float.valueOf(paramIPollWidget.a().getY()) });
    Object localObject1 = localStoryVideoItem.getPollLayout();
    if ((localObject1 != null) && (((StoryVideoItem.PollLayout)localObject1).a.length > 0))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localObject1.a[0]);
      i = 1;
      while (i < ((StoryVideoItem.PollLayout)localObject1).a.length)
      {
        ((StringBuilder)localObject2).append(";");
        ((StringBuilder)localObject2).append(localObject1.a[i]);
        i += 1;
      }
      localObject2 = ((StringBuilder)localObject2).toString();
      i = paramVideoPlayModeBase.a();
      if (localStoryVideoItem.isMine())
      {
        localObject1 = "1";
        StoryReportor.a("play_video", "in_vote", 0, 0, new String[] { localObject2, String.valueOf(i), localObject1, localStoryVideoItem.mVid });
      }
    }
    else
    {
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.e(false);
      ((StoryConfigManager)SuperManager.a(10)).b("has_play_poll_animation_guide", Boolean.valueOf(true));
      paramIPollWidget.a(true);
      paramIPollWidget.a(null);
      paramWidgetElement.b(true);
      paramIPollWidget = paramVideoPlayModeBase.a(localVideoViewHolder.c);
      if (paramIPollWidget != null) {
        break label648;
      }
      paramIPollWidget = null;
      label451:
      SendVidPollDataHandler.a(paramIPollWidget, localStoryVideoItem.mVid, k);
      if (localStoryVideoItem.mPollResult == -1)
      {
        paramIPollWidget = QQStoryContext.a().b();
        paramWidgetElement = localStoryVideoItem.mPollUsers.iterator();
        do
        {
          if (!paramWidgetElement.hasNext()) {
            break;
          }
        } while (!TextUtils.equals(((QQUserUIItem)paramWidgetElement.next()).uid, paramIPollWidget));
      }
    }
    for (int i = j;; i = 0)
    {
      if ((localStoryVideoItem.mPollNumbers == null) && (localStoryVideoItem.getPollLayout().a != null))
      {
        localStoryVideoItem.mPollNumbers = new int[localStoryVideoItem.getPollLayout().a.length - 1];
        Arrays.fill(localStoryVideoItem.mPollNumbers, 0);
      }
      if ((localStoryVideoItem.mPollNumbers != null) && (localStoryVideoItem.mPollNumbers.length > k))
      {
        paramIPollWidget = localStoryVideoItem.mPollNumbers;
        paramIPollWidget[k] += 1;
      }
      if (i == 0)
      {
        paramIPollWidget = (UserManager)SuperManager.a(2);
        localStoryVideoItem.mPollUsers.add(0, paramIPollWidget.a());
      }
      localStoryVideoItem.mPollResult = k;
      c(paramVideoPlayModeBase, localVideoViewHolder, localStoryVideoItem);
      return;
      localObject1 = "0";
      break;
      label648:
      paramIPollWidget = paramIPollWidget.feedId;
      break label451;
    }
  }
  
  public static void a(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      SLog.c("Q.qqstory.PlayModePollViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    SLog.a("Q.qqstory.PlayModePollViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramVideoViewHolder.c));
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getPollLayout() == null)
    {
      SLog.b("Q.qqstory.PlayModePollViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    PollWidgetUtils.IPollWidget localIPollWidget = paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget;
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(false);
    paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.c(true);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localIPollWidget.a(), localLayoutParams);
    if (!((Boolean)((StoryConfigManager)SuperManager.a(10)).b("has_play_poll_animation_guide", Boolean.valueOf(false))).booleanValue()) {
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.e(true);
    }
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.forceLayout();
    b(paramVideoPlayModeBase, paramVideoViewHolder, paramStoryVideoItem, false);
  }
  
  public static void a(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, boolean paramBoolean)
  {
    paramVideoPlayModeBase = paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramVideoPlayModeBase.e(paramBoolean);
      return;
    }
  }
  
  public static void b(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    SLog.a("Q.qqstory.PlayModePollViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramVideoViewHolder.c));
    int i = paramVideoViewHolder.c;
    b(paramVideoPlayModeBase, paramVideoViewHolder, paramStoryVideoItem, true);
    paramVideoViewHolder = paramVideoPlayModeBase.a(i - 1);
    if (paramVideoViewHolder != null)
    {
      paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(false);
    }
    paramVideoPlayModeBase = paramVideoPlayModeBase.a(i + 1);
    if (paramVideoPlayModeBase != null)
    {
      paramVideoPlayModeBase.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      paramVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(false);
    }
  }
  
  private static void b(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    int k = paramVideoViewHolder.c;
    StoryVideoItem.PollLayout localPollLayout = paramStoryVideoItem.getPollLayout();
    if (localPollLayout == null) {
      SLog.b("Q.qqstory.PlayModePollViewUtils", "onInitPollView video has no poll attributes, not a poll video item");
    }
    View localView;
    int m;
    int n;
    int i1;
    int i2;
    float f1;
    float f2;
    float f3;
    label208:
    label219:
    do
    {
      return;
      SLog.b("Q.qqstory.PlayModePollViewUtils", "initPollView %d", Integer.valueOf(k));
      localView = paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
      localView.setTag(2131362457, Integer.valueOf(k));
      SLog.b("Q.qqstory.PlayModePollViewUtils", "Users Count: %d", Integer.valueOf(paramStoryVideoItem.mPollUsers.size()));
      if (paramStoryVideoItem.mPollNumbers == null)
      {
        i = 0;
        if (paramStoryVideoItem.mPollNumbers != null) {
          break label208;
        }
      }
      for (j = 0;; j = paramStoryVideoItem.mPollNumbers[1])
      {
        SLog.b("Q.qqstory.PlayModePollViewUtils", "Poll Number: %d %d", Integer.valueOf(i), Integer.valueOf(j));
        m = localPollLayout.c;
        n = localPollLayout.d;
        i1 = localPollLayout.e;
        i2 = localPollLayout.f;
        f1 = localPollLayout.g;
        f2 = localPollLayout.h;
        f3 = localPollLayout.i;
        localObject = localPollLayout.a;
        if ((localObject != null) && (localObject.length != 0)) {
          break label219;
        }
        SLog.c("Q.qqstory.PlayModePollViewUtils", "onInitPollView poll [contents] attributes illegal or missing!");
        return;
        i = paramStoryVideoItem.mPollNumbers[0];
        break;
      }
      SLog.b("Q.qqstory.PlayModePollViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a().a(localObject[0]);
      j = Math.min(localObject.length, paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a());
      i = 1;
      while (i < j)
      {
        paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(i - 1).a(localObject[i]);
        paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(i - 1).b(false);
        i += 1;
      }
      k = 0;
      i = 0;
      Object localObject = new CopyOnWriteArrayList(paramStoryVideoItem.mPollUsers);
      if (paramStoryVideoItem.mPollNumbers != null)
      {
        paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(paramStoryVideoItem.mPollNumbers);
        int[] arrayOfInt = paramStoryVideoItem.mPollNumbers;
        int i3 = arrayOfInt.length;
        j = 0;
        for (;;)
        {
          k = i;
          if (j >= i3) {
            break;
          }
          k = arrayOfInt[j];
          j += 1;
          i = k + i;
        }
      }
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a((List)localObject, k);
      if (paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.post(new nlj(paramVideoPlayModeBase, paramVideoViewHolder, paramStoryVideoItem));
    return;
    int i = paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
    int j = paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
    paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(localPollLayout, i, j);
    paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a();
    c(paramVideoPlayModeBase, paramVideoViewHolder, paramStoryVideoItem);
    localView.setVisibility(0);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    SLog.b("Q.qqstory.PlayModePollViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i1), Integer.valueOf(i2), Float.valueOf(f3), Integer.valueOf(i), Integer.valueOf(j) });
    SLog.a("Q.qqstory.PlayModePollViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getLeft()), Integer.valueOf(paramVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.getRight()));
  }
  
  public static void c(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      SLog.c("Q.qqstory.PlayModePollViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
      return;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList(paramStoryVideoItem.mPollUsers);
    SLog.a("Q.qqstory.PlayModePollViewUtils", "bindPollView Users Count: %d", Integer.valueOf(localCopyOnWriteArrayList.size()));
    int i;
    if (paramStoryVideoItem.mPollNumbers == null)
    {
      i = 0;
      if (paramStoryVideoItem.mPollNumbers != null) {
        break label121;
      }
    }
    label121:
    for (int j = 0;; j = paramStoryVideoItem.mPollNumbers[1])
    {
      SLog.a("Q.qqstory.PlayModePollViewUtils", "bindPollView Poll Number: %d %d", Integer.valueOf(i), Integer.valueOf(j));
      if (paramVideoViewHolder != null) {
        break label132;
      }
      SLog.c("Q.qqstory.PlayModePollViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg holder is null"));
      return;
      i = paramStoryVideoItem.mPollNumbers[0];
      break;
    }
    label132:
    Object localObject;
    if (paramStoryVideoItem.mPollNumbers != null)
    {
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(paramStoryVideoItem.mPollNumbers);
      localObject = paramStoryVideoItem.mPollNumbers;
      int m = localObject.length;
      j = 0;
      for (i = 0;; i = k + i)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = localObject[j];
        j += 1;
      }
    }
    int k = 0;
    boolean bool1;
    label255:
    boolean bool2;
    if (paramStoryVideoItem.mPollResult != -1)
    {
      bool1 = true;
      if (!bool1) {
        break label383;
      }
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(null);
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(true);
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(paramStoryVideoItem.mPollResult).b(true);
      boolean bool3 = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
      if ((!bool3) || (localCopyOnWriteArrayList.size() <= 0)) {
        break label419;
      }
      bool2 = true;
      label286:
      if ((bool3) && (!bool2)) {
        SLog.c("Q.qqstory.PlayModePollViewUtils", "PollUsers data is not ready, wait for User Icon data to display");
      }
      if ((bool3) && (k > 0)) {
        paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(true);
      }
      localObject = paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget;
      if (!bool2) {
        break label425;
      }
    }
    label419:
    label425:
    for (paramStoryVideoItem = paramVideoPlayModeBase;; paramStoryVideoItem = null)
    {
      ((PollWidgetUtils.IPollWidget)localObject).a(paramStoryVideoItem);
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(localCopyOnWriteArrayList, k);
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.b(bool2);
      a(paramVideoPlayModeBase, paramVideoViewHolder, bool1);
      return;
      bool1 = false;
      break;
      label383:
      if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
      {
        paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(null);
        break label255;
      }
      paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget.a(paramVideoPlayModeBase);
      break label255;
      bool2 = false;
      break label286;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModePollViewUtils
 * JD-Core Version:    0.7.0.1
 */