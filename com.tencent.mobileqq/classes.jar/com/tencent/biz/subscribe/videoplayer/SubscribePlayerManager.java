package com.tencent.biz.subscribe.videoplayer;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.item.AutoVideoItemBuilder.AutoVideoMsgViewHolder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SubscribePlayerManager
{
  private static SubscribePlayerManager b;
  private final String a = "SubscribePlayerManager";
  private int c;
  private ChatXListView d;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = 0;
  private Runnable j;
  private Handler k = new Handler(Looper.getMainLooper());
  private boolean l;
  private boolean m = false;
  private Map<Integer, AutoVideoItemBuilder.AutoVideoMsgViewHolder> n = new HashMap();
  private Set<AutoVideoItemBuilder.AutoVideoMsgViewHolder> o = new HashSet();
  private Map<Integer, Integer> p = new HashMap();
  private Map<Integer, String> q = new HashMap();
  
  public static SubscribePlayerManager a()
  {
    if (b == null) {
      b = new SubscribePlayerManager();
    }
    return b;
  }
  
  private void a(AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramAutoVideoMsgViewHolder.b.setVisibility(8);
      paramAutoVideoMsgViewHolder.c.setVisibility(8);
      paramAutoVideoMsgViewHolder.d.setVisibility(0);
      return;
    }
    paramAutoVideoMsgViewHolder.b.setVisibility(0);
    paramAutoVideoMsgViewHolder.c.setVisibility(0);
    paramAutoVideoMsgViewHolder.d.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if (NetworkUtil.b(BaseApplicationImpl.context) != 1)
    {
      QLog.d("SubscribePlayerManager", 4, "not wifi autoPlay return");
      return;
    }
    int i1 = this.i;
    if ((i1 > this.f) && (i1 < this.g))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mCurrentPosition:");
      localStringBuilder.append(this.i);
      localStringBuilder.append("is play in screen");
      QLog.d("SubscribePlayerManager", 4, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mFirstPosition:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",mLastPosition:");
    localStringBuilder.append(this.g);
    QLog.d("SubscribePlayerManager", 4, localStringBuilder.toString());
    if (paramBoolean)
    {
      i1 = this.f;
      while (i1 <= this.g)
      {
        if (b(i1)) {
          return;
        }
        i1 += 1;
      }
    }
    i1 = this.g;
    while (i1 >= this.f)
    {
      if (b(i1)) {
        return;
      }
      i1 -= 1;
    }
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == this.e;
  }
  
  private void b(AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder)
  {
    if (paramAutoVideoMsgViewHolder != null) {
      while ((paramAutoVideoMsgViewHolder.a.getChildAt(0) instanceof CleanVideoPlayerView))
      {
        Object localObject = paramAutoVideoMsgViewHolder.a.getChildAt(0);
        paramAutoVideoMsgViewHolder.a.removeView((View)localObject);
        localObject = (VideoPlayerView)localObject;
        if (((VideoPlayerView)localObject).s()) {
          ((VideoPlayerView)localObject).h();
        }
        ((VideoPlayerView)localObject).g();
        a(paramAutoVideoMsgViewHolder, false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("release videoPlayer position:");
        ((StringBuilder)localObject).append(paramAutoVideoMsgViewHolder.l);
        QLog.d("SubscribePlayerManager", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    if (this.d != null)
    {
      AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)this.n.get(Integer.valueOf(paramInt));
      if (localAutoVideoMsgViewHolder != null)
      {
        Object localObject = localAutoVideoMsgViewHolder.a;
        Rect localRect = new Rect();
        localAutoVideoMsgViewHolder.a.getLocalVisibleRect(localRect);
        int i1 = localAutoVideoMsgViewHolder.a.getHeight();
        if ((localRect.top == 0) && (localRect.bottom == i1))
        {
          localObject = ((RelativeLayout)localObject).getChildAt(0);
          if ((localObject instanceof CleanVideoPlayerView))
          {
            localObject = (CleanVideoPlayerView)localObject;
            if (!((CleanVideoPlayerView)localObject).s())
            {
              ((CleanVideoPlayerView)localObject).e();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("play by old player position:");
              ((StringBuilder)localObject).append(localAutoVideoMsgViewHolder.l);
              QLog.d("SubscribePlayerManager", 4, ((StringBuilder)localObject).toString());
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("is playing now position:");
            ((StringBuilder)localObject).append(localAutoVideoMsgViewHolder.l);
            QLog.d("SubscribePlayerManager", 4, ((StringBuilder)localObject).toString());
            a(localAutoVideoMsgViewHolder, true);
            return true;
          }
          c(localAutoVideoMsgViewHolder, paramInt);
          return true;
        }
      }
    }
    return false;
  }
  
  private void c(AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder, int paramInt)
  {
    if (this.d != null)
    {
      if (!NetworkUtil.a(BaseApplicationImpl.context))
      {
        ToastUtil.a().a(HardCodeUtil.a(2131911960));
        QLog.d("SubscribePlayerManager", 4, "network not available");
        return;
      }
      if (!TextUtils.isEmpty(paramAutoVideoMsgViewHolder.e))
      {
        b(paramAutoVideoMsgViewHolder);
        Object localObject = a(paramAutoVideoMsgViewHolder.e, "vid");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          CleanVideoPlayerView localCleanVideoPlayerView = new CleanVideoPlayerView(this.d.getContext());
          localCleanVideoPlayerView.setLoopBack(true);
          localCleanVideoPlayerView.setOutPutMute(true);
          localCleanVideoPlayerView.setWifiAutoPlay(true);
          Map localMap = this.p;
          if ((localMap != null) && (localMap.get(Integer.valueOf(paramAutoVideoMsgViewHolder.l)) != null)) {
            i1 = ((Integer)this.p.get(Integer.valueOf(paramAutoVideoMsgViewHolder.l))).intValue();
          } else {
            i1 = 0;
          }
          localCleanVideoPlayerView.setVideoPath((String)localObject, "", i1);
          localCleanVideoPlayerView.setBaseVideoViewListenerSets(new SubscribePlayerManager.3(this, paramAutoVideoMsgViewHolder));
          localCleanVideoPlayerView.setRevertProgress(true);
          int i1 = ScreenUtil.dip2px(180.0F);
          localObject = new RelativeLayout.LayoutParams((int)(i1 * (paramAutoVideoMsgViewHolder.f / paramAutoVideoMsgViewHolder.g)), i1);
          ((RelativeLayout.LayoutParams)localObject).addRule(13);
          paramAutoVideoMsgViewHolder.a.addView(localCleanVideoPlayerView, 0, (ViewGroup.LayoutParams)localObject);
          this.i = paramInt;
          g();
          paramAutoVideoMsgViewHolder = new StringBuilder();
          paramAutoVideoMsgViewHolder.append("playInner mCurrentPlayPosition: ");
          paramAutoVideoMsgViewHolder.append(this.i);
          QLog.d("SubscribePlayerManager", 4, paramAutoVideoMsgViewHolder.toString());
          return;
        }
        QLog.d("SubscribePlayerManager", 4, "vid is empty");
        return;
      }
      QLog.d("SubscribePlayerManager", 4, "url is empty");
    }
  }
  
  private int e()
  {
    ChatXListView localChatXListView = this.d;
    if (localChatXListView != null)
    {
      if (localChatXListView.getChildAt(0) == null) {
        return 0;
      }
      return this.d.getChildAt(0).getTop();
    }
    return 0;
  }
  
  private void f()
  {
    if (this.j == null) {
      this.j = new SubscribePlayerManager.2(this);
    }
    if (!this.l) {
      this.k.postDelayed(this.j, 1000L);
    }
  }
  
  private void g()
  {
    AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder1 = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)this.n.get(Integer.valueOf(this.i));
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
    {
      AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder2 = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)localIterator.next();
      if (localAutoVideoMsgViewHolder2 != localAutoVideoMsgViewHolder1) {
        b(localAutoVideoMsgViewHolder2);
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject = paramString1.substring(paramString1.indexOf("?") + 1).split("&");
    int i2 = localObject.length;
    int i1 = 0;
    while (i1 < i2)
    {
      paramString1 = localObject[i1];
      if (paramString1.contains(paramString2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("=");
        return paramString1.replace(((StringBuilder)localObject).toString(), "");
      }
      i1 += 1;
    }
    return "";
  }
  
  public void a(AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder)
  {
    View localView = paramAutoVideoMsgViewHolder.a.getChildAt(0);
    a(paramAutoVideoMsgViewHolder, false);
    if ((localView instanceof CleanVideoPlayerView))
    {
      paramAutoVideoMsgViewHolder.a.removeView(localView);
      Object localObject = (VideoPlayerView)localView;
      if (((VideoPlayerView)localObject).s())
      {
        ((VideoPlayerView)localObject).h();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleScrollOutScreen:");
        ((StringBuilder)localObject).append(paramAutoVideoMsgViewHolder.l);
        QLog.d("SubscribePlayerManager", 4, ((StringBuilder)localObject).toString());
      }
      ((CleanVideoPlayerView)localView).g();
      this.i = -1;
    }
  }
  
  public void a(AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder, int paramInt)
  {
    if ((AutoVideoItemBuilder.AutoVideoMsgViewHolder)this.n.get(Integer.valueOf(paramInt)) == paramAutoVideoMsgViewHolder) {
      return;
    }
    f();
    this.n.put(Integer.valueOf(paramInt), paramAutoVideoMsgViewHolder);
    this.o.add(paramAutoVideoMsgViewHolder);
    Object localObject = paramAutoVideoMsgViewHolder.a.getChildAt(0);
    if ((localObject instanceof CleanVideoPlayerView))
    {
      paramAutoVideoMsgViewHolder.a.removeView((View)localObject);
      localObject = (VideoPlayerView)localObject;
      if (((VideoPlayerView)localObject).s()) {
        ((VideoPlayerView)localObject).h();
      }
      ((VideoPlayerView)localObject).g();
    }
    a(paramAutoVideoMsgViewHolder, false);
    paramAutoVideoMsgViewHolder.c.setOnClickListener(new SubscribePlayerManager.1(this, paramAutoVideoMsgViewHolder));
    paramAutoVideoMsgViewHolder = new StringBuilder();
    paramAutoVideoMsgViewHolder.append("bindViewHolder:");
    paramAutoVideoMsgViewHolder.append(paramInt);
    paramAutoVideoMsgViewHolder.append("  HolderSize:");
    paramAutoVideoMsgViewHolder.append(this.o.size());
    QLog.d("SubscribePlayerManager", 4, paramAutoVideoMsgViewHolder.toString());
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.d == null) {
      this.d = ((ChatXListView)paramAbsListView);
    }
    if (paramInt != 0) {
      return;
    }
    this.k.removeCallbacks(this.j);
    this.l = true;
    paramAbsListView = new StringBuilder();
    paramAbsListView.append("mPerFirstVisible:");
    paramAbsListView.append(this.e);
    paramAbsListView.append("  mFiresVisible:");
    paramAbsListView.append(this.f);
    QLog.d("SubscribePlayerManager", 4, paramAbsListView.toString());
    if (!this.m)
    {
      a(true);
      QLog.d("SubscribePlayerManager", 4, "begin start");
      return;
    }
    a(false);
    QLog.d("SubscribePlayerManager", 4, "begin end");
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      return;
    }
    if (this.d == null) {
      this.d = ((ChatXListView)paramAbsListView);
    }
    if (a(paramInt1))
    {
      i1 = e();
      if (Math.abs(this.c - i1) > 0) {
        paramInt3 = 1;
      } else {
        paramInt3 = 0;
      }
      if (paramInt3 != 0) {
        if (this.c > i1) {
          this.m = true;
        } else {
          this.m = false;
        }
      }
      this.c = i1;
    }
    else
    {
      if (paramInt1 > this.e) {
        this.m = true;
      } else {
        this.m = false;
      }
      this.c = e();
      this.e = paramInt1;
    }
    paramInt3 = this.d.getFooterViewsCount();
    int i1 = this.d.getHeaderViewsCount();
    this.f = (paramInt1 - i1);
    this.h = paramInt2;
    this.g = (this.f + paramInt2 - paramInt3 - i1);
  }
  
  public void b()
  {
    AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)this.n.get(Integer.valueOf(this.i));
    if (localAutoVideoMsgViewHolder != null)
    {
      Object localObject = localAutoVideoMsgViewHolder.a.getChildAt(0);
      if ((localObject instanceof CleanVideoPlayerView))
      {
        localObject = (VideoPlayerView)localObject;
        if (!((VideoPlayerView)localObject).s())
        {
          ((VideoPlayerView)localObject).e();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onResume play video position:");
          ((StringBuilder)localObject).append(localAutoVideoMsgViewHolder.l);
          QLog.d("SubscribePlayerManager", 4, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void b(AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder, int paramInt)
  {
    if (paramAutoVideoMsgViewHolder != null)
    {
      this.n.remove(Integer.valueOf(paramAutoVideoMsgViewHolder.l));
      Object localObject = paramAutoVideoMsgViewHolder.a.getChildAt(0);
      if ((localObject instanceof CleanVideoPlayerView))
      {
        paramAutoVideoMsgViewHolder.a.removeView((View)localObject);
        localObject = (VideoPlayerView)localObject;
        if (((VideoPlayerView)localObject).s()) {
          ((VideoPlayerView)localObject).h();
        }
        ((VideoPlayerView)localObject).g();
        a(paramAutoVideoMsgViewHolder, false);
        paramAutoVideoMsgViewHolder = new StringBuilder();
        paramAutoVideoMsgViewHolder.append("unbind view position:");
        paramAutoVideoMsgViewHolder.append(paramInt);
        QLog.d("SubscribePlayerManager", 4, paramAutoVideoMsgViewHolder.toString());
      }
    }
  }
  
  public void c()
  {
    AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)this.n.get(Integer.valueOf(this.i));
    if (localAutoVideoMsgViewHolder != null)
    {
      Object localObject = localAutoVideoMsgViewHolder.a.getChildAt(0);
      if ((localObject instanceof CleanVideoPlayerView))
      {
        localObject = (VideoPlayerView)localObject;
        if (((VideoPlayerView)localObject).s())
        {
          ((VideoPlayerView)localObject).h();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onStop pause video position:");
          ((StringBuilder)localObject).append(localAutoVideoMsgViewHolder.l);
          QLog.d("SubscribePlayerManager", 4, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void d()
  {
    this.l = false;
    this.e = -1;
    this.i = -1;
    g();
    this.f = -1;
    this.g = -1;
    this.d = null;
    this.n.clear();
    this.o.clear();
    this.p.clear();
    this.q.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager
 * JD-Core Version:    0.7.0.1
 */