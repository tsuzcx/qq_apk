package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import cooperation.liveroom.LiveRoomGiftCallback;

public class ReadInJoyAdVpngVideo
  extends ViewBase
{
  private FrameLayout a;
  
  public ReadInJoyAdVpngVideo(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new FrameLayout(paramVafContext.getContext());
  }
  
  public void a(String paramString, VPNGImageView paramVPNGImageView, LiveRoomGiftCallback paramLiveRoomGiftCallback)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.a.addView(paramVPNGImageView, localLayoutParams);
    paramVPNGImageView.setVideo(paramString, true, 1, paramLiveRoomGiftCallback);
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    return super.setAttribute(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVpngVideo
 * JD-Core Version:    0.7.0.1
 */