package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class WSVerticalCommonVideoHolder
  extends WSVerticalVideoHolder
{
  private static final int a = ScreenUtil.dip2px(45.0F);
  
  public WSVerticalCommonVideoHolder(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, 2131626071, paramInt, paramWSVerticalPageFragment);
  }
  
  public void a(boolean paramBoolean) {}
  
  protected boolean a()
  {
    if ((this.e != null) && (((WSVerticalItemData)this.e).c())) {
      return true;
    }
    if (((WSVerticalPageContract.Presenter)this.d.aO_()).p()) {
      return false;
    }
    boolean bool = WSExpABTestManager.a().j();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalCommonVideoHolder.java][isPlayLoop] isLoop:");
    localStringBuilder.append(bool);
    WSLog.e("WS_VIDEO_PLAY_TIME", localStringBuilder.toString());
    return bool;
  }
  
  public FrameLayout b()
  {
    if ((this.c instanceof AbsWSVideoItemView)) {
      return ((AbsWSVideoItemView)this.c).i();
    }
    return null;
  }
  
  public AbsWSVideoItemView b(int paramInt)
  {
    return new WSVerticalVideoItemView(getContext(), this);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  protected boolean g()
  {
    return true;
  }
  
  protected boolean h()
  {
    return true;
  }
  
  public int i()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalCommonVideoHolder
 * JD-Core Version:    0.7.0.1
 */