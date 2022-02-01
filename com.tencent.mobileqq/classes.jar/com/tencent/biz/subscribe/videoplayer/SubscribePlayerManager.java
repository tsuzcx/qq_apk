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
  private static SubscribePlayerManager jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final String jdField_a_of_type_JavaLangString = "SubscribePlayerManager";
  private Map<Integer, AutoVideoItemBuilder.AutoVideoMsgViewHolder> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<AutoVideoItemBuilder.AutoVideoMsgViewHolder> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private Map<Integer, Integer> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private Map<Integer, String> jdField_c_of_type_JavaUtilMap = new HashMap();
  private int d = -1;
  private int e = -1;
  private int f = 0;
  
  private int a()
  {
    ChatXListView localChatXListView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    if (localChatXListView != null)
    {
      if (localChatXListView.getChildAt(0) == null) {
        return 0;
      }
      return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0).getTop();
    }
    return 0;
  }
  
  public static SubscribePlayerManager a()
  {
    if (jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager == null) {
      jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager = new SubscribePlayerManager();
    }
    return jdField_a_of_type_ComTencentBizSubscribeVideoplayerSubscribePlayerManager;
  }
  
  private void a(AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramAutoVideoMsgViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if (NetworkUtil.a(BaseApplicationImpl.context) != 1)
    {
      QLog.d("SubscribePlayerManager", 4, "not wifi autoPlay return");
      return;
    }
    int i = this.f;
    if ((i > this.jdField_c_of_type_Int) && (i < this.d))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mCurrentPosition:");
      localStringBuilder.append(this.f);
      localStringBuilder.append("is play in screen");
      QLog.d("SubscribePlayerManager", 4, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mFirstPosition:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(",mLastPosition:");
    localStringBuilder.append(this.d);
    QLog.d("SubscribePlayerManager", 4, localStringBuilder.toString());
    if (paramBoolean)
    {
      i = this.jdField_c_of_type_Int;
      while (i <= this.d)
      {
        if (b(i)) {
          return;
        }
        i += 1;
      }
    }
    i = this.d;
    while (i >= this.jdField_c_of_type_Int)
    {
      if (b(i)) {
        return;
      }
      i -= 1;
    }
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == this.jdField_b_of_type_Int;
  }
  
  private void b(AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder)
  {
    if (paramAutoVideoMsgViewHolder != null) {
      while ((paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0) instanceof CleanVideoPlayerView))
      {
        Object localObject = paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject);
        localObject = (VideoPlayerView)localObject;
        if (((VideoPlayerView)localObject).e()) {
          ((VideoPlayerView)localObject).g();
        }
        ((VideoPlayerView)localObject).b();
        a(paramAutoVideoMsgViewHolder, false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("release videoPlayer position:");
        ((StringBuilder)localObject).append(paramAutoVideoMsgViewHolder.jdField_b_of_type_Int);
        QLog.d("SubscribePlayerManager", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localAutoVideoMsgViewHolder != null)
      {
        Object localObject = localAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
        Rect localRect = new Rect();
        localAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocalVisibleRect(localRect);
        int i = localAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        if ((localRect.top == 0) && (localRect.bottom == i))
        {
          localObject = ((RelativeLayout)localObject).getChildAt(0);
          if ((localObject instanceof CleanVideoPlayerView))
          {
            localObject = (CleanVideoPlayerView)localObject;
            if (!((CleanVideoPlayerView)localObject).e())
            {
              ((CleanVideoPlayerView)localObject).f();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("play by old player position:");
              ((StringBuilder)localObject).append(localAutoVideoMsgViewHolder.jdField_b_of_type_Int);
              QLog.d("SubscribePlayerManager", 4, ((StringBuilder)localObject).toString());
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("is playing now position:");
            ((StringBuilder)localObject).append(localAutoVideoMsgViewHolder.jdField_b_of_type_Int);
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
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      if (!NetworkUtil.a(BaseApplicationImpl.context))
      {
        ToastUtil.a().a(HardCodeUtil.a(2131714450));
        QLog.d("SubscribePlayerManager", 4, "network not available");
        return;
      }
      if (!TextUtils.isEmpty(paramAutoVideoMsgViewHolder.jdField_b_of_type_JavaLangString))
      {
        b(paramAutoVideoMsgViewHolder);
        Object localObject = a(paramAutoVideoMsgViewHolder.jdField_b_of_type_JavaLangString, "vid");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          CleanVideoPlayerView localCleanVideoPlayerView = new CleanVideoPlayerView(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getContext());
          localCleanVideoPlayerView.setLoopBack(true);
          localCleanVideoPlayerView.setOutPutMute(true);
          localCleanVideoPlayerView.setWifiAutoPlay(true);
          Map localMap = this.jdField_b_of_type_JavaUtilMap;
          if ((localMap != null) && (localMap.get(Integer.valueOf(paramAutoVideoMsgViewHolder.jdField_b_of_type_Int)) != null)) {
            i = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramAutoVideoMsgViewHolder.jdField_b_of_type_Int))).intValue();
          } else {
            i = 0;
          }
          localCleanVideoPlayerView.setVideoPath((String)localObject, "", i);
          localCleanVideoPlayerView.setBaseVideoViewListenerSets(new SubscribePlayerManager.3(this, paramAutoVideoMsgViewHolder));
          localCleanVideoPlayerView.setRevertProgress(true);
          int i = ScreenUtil.dip2px(180.0F);
          localObject = new RelativeLayout.LayoutParams((int)(i * (paramAutoVideoMsgViewHolder.e / paramAutoVideoMsgViewHolder.f)), i);
          ((RelativeLayout.LayoutParams)localObject).addRule(13);
          paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localCleanVideoPlayerView, 0, (ViewGroup.LayoutParams)localObject);
          this.f = paramInt;
          e();
          paramAutoVideoMsgViewHolder = new StringBuilder();
          paramAutoVideoMsgViewHolder.append("playInner mCurrentPlayPosition: ");
          paramAutoVideoMsgViewHolder.append(this.f);
          QLog.d("SubscribePlayerManager", 4, paramAutoVideoMsgViewHolder.toString());
          return;
        }
        QLog.d("SubscribePlayerManager", 4, "vid is empty");
        return;
      }
      QLog.d("SubscribePlayerManager", 4, "url is empty");
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new SubscribePlayerManager.2(this);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  private void e()
  {
    AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder1 = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
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
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramString1 = localObject[i];
      if (paramString1.contains(paramString2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("=");
        return paramString1.replace(((StringBuilder)localObject).toString(), "");
      }
      i += 1;
    }
    return "";
  }
  
  public void a()
  {
    AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    if (localAutoVideoMsgViewHolder != null)
    {
      Object localObject = localAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if ((localObject instanceof CleanVideoPlayerView))
      {
        localObject = (VideoPlayerView)localObject;
        if (!((VideoPlayerView)localObject).e())
        {
          ((VideoPlayerView)localObject).f();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onResume play video position:");
          ((StringBuilder)localObject).append(localAutoVideoMsgViewHolder.jdField_b_of_type_Int);
          QLog.d("SubscribePlayerManager", 4, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void a(AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder)
  {
    View localView = paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
    a(paramAutoVideoMsgViewHolder, false);
    if ((localView instanceof CleanVideoPlayerView))
    {
      paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
      Object localObject = (VideoPlayerView)localView;
      if (((VideoPlayerView)localObject).e())
      {
        ((VideoPlayerView)localObject).g();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleScrollOutScreen:");
        ((StringBuilder)localObject).append(paramAutoVideoMsgViewHolder.jdField_b_of_type_Int);
        QLog.d("SubscribePlayerManager", 4, ((StringBuilder)localObject).toString());
      }
      ((CleanVideoPlayerView)localView).b();
      this.f = -1;
    }
  }
  
  public void a(AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder, int paramInt)
  {
    if ((AutoVideoItemBuilder.AutoVideoMsgViewHolder)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == paramAutoVideoMsgViewHolder) {
      return;
    }
    d();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramAutoVideoMsgViewHolder);
    this.jdField_a_of_type_JavaUtilSet.add(paramAutoVideoMsgViewHolder);
    Object localObject = paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
    if ((localObject instanceof CleanVideoPlayerView))
    {
      paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject);
      localObject = (VideoPlayerView)localObject;
      if (((VideoPlayerView)localObject).e()) {
        ((VideoPlayerView)localObject).g();
      }
      ((VideoPlayerView)localObject).b();
    }
    a(paramAutoVideoMsgViewHolder, false);
    paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new SubscribePlayerManager.1(this, paramAutoVideoMsgViewHolder));
    paramAutoVideoMsgViewHolder = new StringBuilder();
    paramAutoVideoMsgViewHolder.append("bindViewHolder:");
    paramAutoVideoMsgViewHolder.append(paramInt);
    paramAutoVideoMsgViewHolder.append("  HolderSize:");
    paramAutoVideoMsgViewHolder.append(this.jdField_a_of_type_JavaUtilSet.size());
    QLog.d("SubscribePlayerManager", 4, paramAutoVideoMsgViewHolder.toString());
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)paramAbsListView);
    }
    if (paramInt != 0) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Boolean = true;
    paramAbsListView = new StringBuilder();
    paramAbsListView.append("mPerFirstVisible:");
    paramAbsListView.append(this.jdField_b_of_type_Int);
    paramAbsListView.append("  mFiresVisible:");
    paramAbsListView.append(this.jdField_c_of_type_Int);
    QLog.d("SubscribePlayerManager", 4, paramAbsListView.toString());
    if (!this.jdField_b_of_type_Boolean)
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
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)paramAbsListView);
    }
    if (a(paramInt1))
    {
      i = a();
      if (Math.abs(this.jdField_a_of_type_Int - i) > 0) {
        paramInt3 = 1;
      } else {
        paramInt3 = 0;
      }
      if (paramInt3 != 0) {
        if (this.jdField_a_of_type_Int > i) {
          this.jdField_b_of_type_Boolean = true;
        } else {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      this.jdField_a_of_type_Int = i;
    }
    else
    {
      if (paramInt1 > this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Boolean = true;
      } else {
        this.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Int = a();
      this.jdField_b_of_type_Int = paramInt1;
    }
    paramInt3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    this.jdField_c_of_type_Int = (paramInt1 - i);
    this.e = paramInt2;
    this.d = (this.jdField_c_of_type_Int + paramInt2 - paramInt3 - i);
  }
  
  public void b()
  {
    AutoVideoItemBuilder.AutoVideoMsgViewHolder localAutoVideoMsgViewHolder = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    if (localAutoVideoMsgViewHolder != null)
    {
      Object localObject = localAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if ((localObject instanceof CleanVideoPlayerView))
      {
        localObject = (VideoPlayerView)localObject;
        if (((VideoPlayerView)localObject).e())
        {
          ((VideoPlayerView)localObject).g();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onStop pause video position:");
          ((StringBuilder)localObject).append(localAutoVideoMsgViewHolder.jdField_b_of_type_Int);
          QLog.d("SubscribePlayerManager", 4, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void b(AutoVideoItemBuilder.AutoVideoMsgViewHolder paramAutoVideoMsgViewHolder, int paramInt)
  {
    if (paramAutoVideoMsgViewHolder != null)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramAutoVideoMsgViewHolder.jdField_b_of_type_Int));
      Object localObject = paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if ((localObject instanceof CleanVideoPlayerView))
      {
        paramAutoVideoMsgViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)localObject);
        localObject = (VideoPlayerView)localObject;
        if (((VideoPlayerView)localObject).e()) {
          ((VideoPlayerView)localObject).g();
        }
        ((VideoPlayerView)localObject).b();
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.f = -1;
    e();
    this.jdField_c_of_type_Int = -1;
    this.d = -1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager
 * JD-Core Version:    0.7.0.1
 */