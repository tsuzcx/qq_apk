package com.tencent.biz.qqstory.playmode.util;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.network.handler.SendVidRateDataHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.InteractPasterWidget;
import com.tencent.biz.qqstory.view.widget.RateWidget;
import com.tencent.biz.qqstory.view.widget.RateWidget.AttendViewClickListener;
import com.tencent.biz.qqstory.view.widget.RateWidget.WidgetRatingChangedListener;

public class PlayModeInteractViewUtils
{
  public static void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem, RateWidget paramRateWidget, float paramFloat)
  {
    if (paramInt == ((Integer)paramRateWidget.a().getTag(2131375100)).intValue())
    {
      SendVidRateDataHandler.a(paramString, paramStoryVideoItem.mVid, (int)paramFloat);
      new StringBuilder().append(paramRateWidget.a()[0]).append(";").append(String.valueOf((int)paramFloat));
    }
  }
  
  public static void a(RateWidget.WidgetRatingChangedListener paramWidgetRatingChangedListener, RateWidget.AttendViewClickListener paramAttendViewClickListener, FrameLayout paramFrameLayout, InteractPasterWidget paramInteractPasterWidget, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null)
    {
      SLog.c("Q.qqstory.PlayModeInteractViewUtils", "preparePollView error!", new IllegalArgumentException("storyVideoItem is null"));
      return;
    }
    SLog.a("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    paramFrameLayout.setVisibility(4);
    if (paramStoryVideoItem.getInteractLayout() == null)
    {
      SLog.b("Q.qqstory.PlayModeInteractViewUtils", "preparePollView %s don't have poll view layout", paramStoryVideoItem.mVid);
      return;
    }
    paramFrameLayout.removeAllViews();
    paramInteractPasterWidget.a(false);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.addView(paramInteractPasterWidget.a(), localLayoutParams);
    paramFrameLayout.forceLayout();
    b(paramWidgetRatingChangedListener, paramAttendViewClickListener, paramFrameLayout, paramInteractPasterWidget, paramInt, paramStoryVideoItem, false);
  }
  
  public static void a(RateWidget.WidgetRatingChangedListener paramWidgetRatingChangedListener, RateWidget.AttendViewClickListener paramAttendViewClickListener, InteractPasterWidget paramInteractPasterWidget, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      SLog.c("Q.qqstory.PlayModeInteractViewUtils", "bindPollView error! holder is null!", new IllegalArgumentException("arg storyVideoItem is null"));
    }
    while (!(paramInteractPasterWidget instanceof RateWidget)) {
      return;
    }
    b(paramWidgetRatingChangedListener, paramAttendViewClickListener, paramInteractPasterWidget, paramStoryVideoItem);
  }
  
  public static void b(RateWidget.WidgetRatingChangedListener paramWidgetRatingChangedListener, RateWidget.AttendViewClickListener paramAttendViewClickListener, FrameLayout paramFrameLayout, InteractPasterWidget paramInteractPasterWidget, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    SLog.a("Q.qqstory.PlayModeInteractViewUtils", "showPollView %s index = %d", paramStoryVideoItem.mVid, Integer.valueOf(paramInt));
    b(paramWidgetRatingChangedListener, paramAttendViewClickListener, paramFrameLayout, paramInteractPasterWidget, paramInt, paramStoryVideoItem, true);
  }
  
  private static void b(RateWidget.WidgetRatingChangedListener paramWidgetRatingChangedListener, RateWidget.AttendViewClickListener paramAttendViewClickListener, FrameLayout paramFrameLayout, InteractPasterWidget paramInteractPasterWidget, int paramInt, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
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
      SLog.b("Q.qqstory.PlayModeInteractViewUtils", "initPollView %d", Integer.valueOf(paramInt));
      localView = paramInteractPasterWidget.a();
      localView.setTag(2131375100, Integer.valueOf(paramInt));
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
      SLog.b("Q.qqstory.PlayModeInteractViewUtils", "[%d]Using json poll layout screen_size(%d, %d) poll_size(%d, %d) center(%.1f, %.1f) rotation(%.1f)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      paramInteractPasterWidget.a(arrayOfString);
      if (paramFrameLayout.getWidth() != 0) {
        break;
      }
    } while (!paramBoolean);
    paramFrameLayout.post(new PlayModeInteractViewUtils.1(paramWidgetRatingChangedListener, paramAttendViewClickListener, paramFrameLayout, paramInteractPasterWidget, paramInt, paramStoryVideoItem));
    return;
    paramInt = paramFrameLayout.getWidth();
    int n = paramFrameLayout.getHeight();
    paramInteractPasterWidget.a(localInteractPasterLayout.b, localInteractPasterLayout.c, paramInt, n, localInteractPasterLayout.d, localInteractPasterLayout.e, localInteractPasterLayout.f, localInteractPasterLayout.g, localInteractPasterLayout.h);
    paramInteractPasterWidget.a();
    a(paramWidgetRatingChangedListener, paramAttendViewClickListener, paramInteractPasterWidget, paramStoryVideoItem);
    localView.setVisibility(0);
    paramFrameLayout.setVisibility(0);
    SLog.b("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView src=(w=%d, h=%d), poll=(x=%.2f, y=%.2f, w=%d, h=%d), r=%.2f, dst(%d, %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f3), Integer.valueOf(paramInt), Integer.valueOf(n) });
    SLog.a("Q.qqstory.PlayModeInteractViewUtils", "onInitPollView view(%d, %d) parent(%d, %d)", Integer.valueOf(localView.getLeft()), Integer.valueOf(localView.getTop()), Integer.valueOf(paramFrameLayout.getLeft()), Integer.valueOf(paramFrameLayout.getRight()));
  }
  
  private static void b(RateWidget.WidgetRatingChangedListener paramWidgetRatingChangedListener, RateWidget.AttendViewClickListener paramAttendViewClickListener, InteractPasterWidget paramInteractPasterWidget, StoryVideoItem paramStoryVideoItem)
  {
    SLog.b("Q.qqstory.PlayModeInteractViewUtils", "bindRateView, vid=%s, rateResult=%s, totalScore=%s, totalCount=%s", paramStoryVideoItem.mVid, Integer.valueOf(paramStoryVideoItem.mRateResult), Long.valueOf(paramStoryVideoItem.mTotalScore), Integer.valueOf(paramStoryVideoItem.mTotalRateCount));
    if (!(paramInteractPasterWidget instanceof RateWidget)) {
      return;
    }
    paramInteractPasterWidget = (RateWidget)paramInteractPasterWidget;
    boolean bool = TextUtils.equals(paramStoryVideoItem.mOwnerUid, QQStoryContext.a().b());
    if (paramStoryVideoItem.mRateResult > 0)
    {
      paramInteractPasterWidget.b(false);
      paramInteractPasterWidget.a(paramStoryVideoItem.mRateResult);
      paramInteractPasterWidget.a(null);
      if (paramStoryVideoItem.mTotalRateCount > 0)
      {
        paramInteractPasterWidget.a(true);
        paramInteractPasterWidget.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
        if (bool)
        {
          paramInteractPasterWidget.a(paramAttendViewClickListener, true);
          return;
        }
        paramInteractPasterWidget.a(null, false);
        return;
      }
      paramInteractPasterWidget.a(false);
      return;
    }
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      paramInteractPasterWidget.b(false);
      paramInteractPasterWidget.a(0.0F);
      paramInteractPasterWidget.a(null);
      paramInteractPasterWidget.a(false);
      return;
    }
    paramInteractPasterWidget.b(true);
    paramInteractPasterWidget.a(0.0F);
    paramInteractPasterWidget.a(paramWidgetRatingChangedListener);
    if ((bool) && (paramStoryVideoItem.mTotalRateCount > 0))
    {
      paramInteractPasterWidget.a(true);
      paramInteractPasterWidget.a(paramStoryVideoItem.mTotalScore, paramStoryVideoItem.mTotalRateCount);
      paramInteractPasterWidget.a(paramAttendViewClickListener, true);
      return;
    }
    paramInteractPasterWidget.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeInteractViewUtils
 * JD-Core Version:    0.7.0.1
 */