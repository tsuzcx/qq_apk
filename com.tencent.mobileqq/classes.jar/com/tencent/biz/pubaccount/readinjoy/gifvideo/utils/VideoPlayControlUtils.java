package com.tencent.biz.pubaccount.readinjoy.gifvideo.utils;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController.Companion;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VideoPlayControlUtils
{
  private static VideoPlayControlUtils.VideoCheckHandler a = new VideoPlayControlUtils.VideoCheckHandler(Looper.getMainLooper());
  
  public static void a(View paramView)
  {
    if ((paramView instanceof IPlayableView)) {
      ((IPlayableView)paramView).a();
    }
  }
  
  public static void a(Container paramContainer)
  {
    if (VideoPlayController.a.a())
    {
      paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
      while (paramContainer.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContainer.next();
        if ((localEntry.getValue() instanceof ReadInJoyVideoView)) {
          ((ReadInJoyVideoView)localEntry.getValue()).a().startPlay();
        }
      }
    }
  }
  
  public static void a(AbsListView paramAbsListView)
  {
    a(paramAbsListView, null);
  }
  
  public static void a(AbsListView paramAbsListView, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramAbsListView, paramBaseArticleInfo, false);
  }
  
  public static void a(AbsListView paramAbsListView, BaseArticleInfo paramBaseArticleInfo, int paramInt, long paramLong)
  {
    QLog.d("gifvideo.VideoPlayControlUtils", 1, "sendMessage: " + paramInt);
    a.removeMessages(1001);
    a.removeMessages(paramInt);
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.obj = new Object[] { paramAbsListView, paramBaseArticleInfo };
    a.sendMessageDelayed(localMessage, paramLong);
  }
  
  public static void a(AbsListView paramAbsListView, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    a(paramAbsListView, paramBaseArticleInfo, 1001, 100L);
  }
  
  public static void a(ListView paramListView)
  {
    a.removeMessages(1001);
    f(paramListView);
  }
  
  public static void b(Container paramContainer)
  {
    paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
    while (paramContainer.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramContainer.next();
      if ((localEntry.getValue() instanceof ReadInJoyVideoView)) {
        ((ReadInJoyVideoView)localEntry.getValue()).a().stop();
      }
    }
  }
  
  public static void b(AbsListView paramAbsListView)
  {
    if ((!RIJAppSetting.a(paramAbsListView.getContext())) || (paramAbsListView.getChildCount() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramAbsListView.getChildCount())
      {
        View localView = paramAbsListView.getChildAt(i);
        if ((localView instanceof IPlayableView)) {
          ((IPlayableView)localView).a();
        }
        i += 1;
      }
    }
  }
  
  public static void c(AbsListView paramAbsListView)
  {
    a.removeMessages(1001);
    b(paramAbsListView);
  }
  
  private static void c(AbsListView paramAbsListView, BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 0;
    int i = 0;
    View localView;
    float f;
    if (i < paramAbsListView.getChildCount())
    {
      localView = paramAbsListView.getChildAt(i);
      if ((localView instanceof IPlayableView))
      {
        f = ReadInJoyDisplayUtils.a(localView);
        if (paramBaseArticleInfo != null)
        {
          if (!paramBaseArticleInfo.equals(((IPlayableView)localView).a())) {
            break label207;
          }
          QLog.d("gifvideo.VideoPlayControlUtils", 2, "find article: " + paramBaseArticleInfo.innerUniqueID);
        }
      }
    }
    for (;;)
    {
      label83:
      if (i != -1)
      {
        QLog.d("gifvideo.VideoPlayControlUtils", 2, "item to play: " + i);
        for (;;)
        {
          if (j < paramAbsListView.getChildCount())
          {
            localView = paramAbsListView.getChildAt(j);
            if (((localView instanceof IPlayableView)) && (((IPlayableView)localView).a()) && (j != i)) {
              ((IPlayableView)localView).a();
            }
            j += 1;
            continue;
            if ((((IPlayableView)localView).a()) && (f >= 80.0F))
            {
              QLog.d("gifvideo.VideoPlayControlUtils", 2, ">= 80f");
              break label83;
            }
            i += 1;
            break;
          }
        }
        paramAbsListView = paramAbsListView.getChildAt(i);
        if ((paramAbsListView instanceof IPlayableView))
        {
          if (paramBaseArticleInfo == null) {
            break label244;
          }
          ((IPlayableView)paramAbsListView).a(8);
        }
      }
      label207:
      return;
      label244:
      ((IPlayableView)paramAbsListView).a(3);
      return;
      i = -1;
    }
  }
  
  public static void d(AbsListView paramAbsListView)
  {
    if (paramAbsListView == null) {
      return;
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(paramAbsListView);
  }
  
  public static void e(AbsListView paramAbsListView)
  {
    a.removeMessages(1001);
    d(paramAbsListView);
  }
  
  private static void f(AbsListView paramAbsListView)
  {
    if ((!RIJAppSetting.a(paramAbsListView.getContext())) || (paramAbsListView.getChildCount() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramAbsListView.getChildCount())
      {
        View localView = paramAbsListView.getChildAt(i);
        if ((localView instanceof IPlayableView)) {
          ((IPlayableView)localView).b();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoPlayControlUtils
 * JD-Core Version:    0.7.0.1
 */