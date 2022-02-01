package com.tencent.hippy.qq.view.tkd.listview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mtt.supportui.views.recyclerview.IRecyclerViewFooter;
import com.tencent.widget.immersive.ImmersiveUtils;

public class HippyTKDDefaultFooter
  extends HippyTKDFooterView
  implements HippyTKDInvalidateCallback, IRecyclerViewFooter
{
  private static final int BALL_COUNT = 3;
  private static final String TAG = "DefaultFooterView";
  private int ballColor = ResourceUtil.getColor(2131167276);
  private int mBallColorId;
  private AnimatingBall[] mBalls = new AnimatingBall[3];
  private Integer mCustomBallColor = null;
  private String mCustomMessage = null;
  private boolean mIsAttached;
  public int mLoadingStatus = 0;
  public int mPullDownToRefreshDistanceBetweenIconText = ImmersiveUtils.dpToPx(8.0F);
  public Drawable mPullDownToRefreshFailIcon;
  public Drawable mPullDownToRefreshSucIcon;
  private boolean mRefreshing;
  private int mShowLoadingDelayTime = 0;
  private PullToRefreshListener refreshListener;
  
  public HippyTKDDefaultFooter(Context paramContext)
  {
    super(paramContext);
    int i = 0;
    while (i < 3)
    {
      this.mBalls[i] = new AnimatingBall(this, i);
      i += 1;
    }
    setFocusable(true);
    setBallColor(0);
    setTextSize(ImmersiveUtils.dpToPx(12.0F));
    setTextMargins(this.mPullDownToRefreshDistanceBetweenIconText, 0, 0, 0);
    setLayoutParams(new ViewGroup.LayoutParams(-1, ImmersiveUtils.dpToPx(36.0F)));
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  public int getLoadingStatus()
  {
    return this.mLoadingStatus;
  }
  
  public void onAttachedToWindow()
  {
    this.mIsAttached = true;
    if (this.mRefreshing)
    {
      Log.d("DefaultFooterView", hashCode() + ",doRefresh");
      int i = 0;
      while (i < 3)
      {
        this.mBalls[i].animateRefresh();
        i += 1;
      }
    }
    super.onAttachedToWindow();
  }
  
  public void onDetachedFromWindow()
  {
    int i = 0;
    this.mIsAttached = false;
    while (i < 3)
    {
      this.mBalls[i].stopAllAnimators();
      i += 1;
    }
    super.onDetachedFromWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.mRefreshing)
    {
      int j = (getWidth() - (AnimatingBall.BALL_SIZE * 2 + AnimatingBall.BALL_MARGIN_H * 2)) / 2;
      int i = 0;
      while (i < this.mBalls.length)
      {
        this.mBalls[i].draw(paramCanvas, 0, getHeight() / 2, j);
        i += 1;
      }
    }
    super.onDraw(paramCanvas);
  }
  
  public void setBallColor(int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      this.ballColor = ResourceUtil.getColor(paramInt);
      this.mBallColorId = paramInt;
      paramInt = i;
      while (paramInt < 3)
      {
        this.mBalls[paramInt].setInitialColor(this.ballColor);
        paramInt += 1;
      }
    }
    if (this.mCustomBallColor != null) {}
    for (this.ballColor = this.mCustomBallColor.intValue();; this.ballColor = ResourceUtil.getColor(2131167276))
    {
      this.mBallColorId = 0;
      paramInt = i;
      break;
    }
    this.mPullDownToRefreshSucIcon = UIBitmapUtils.getColorImage(ResourceUtil.getBitmap(2130851103), this.ballColor);
    setTextColor(this.ballColor);
  }
  
  public void setCustomBallColor(Integer paramInteger)
  {
    this.mCustomBallColor = paramInteger;
    setBallColor(this.mBallColorId);
  }
  
  public void setLoadingStatus(int paramInt)
  {
    setLoadingStatus(paramInt, -1);
  }
  
  public void setLoadingStatus(int paramInt1, int paramInt2)
  {
    this.mLoadingStatus = paramInt1;
    if (this.mLoadingStatus == 1) {
      if (this.mShowLoadingDelayTime > 0) {
        postDelayed(new HippyTKDDefaultFooter.1(this), this.mShowLoadingDelayTime);
      }
    }
    do
    {
      return;
      startLoading();
      return;
      if (this.mLoadingStatus == 2)
      {
        stopLoading();
        setText("");
        setImageDrawable(null);
        return;
      }
      if (this.mLoadingStatus == 3)
      {
        stopLoading();
        setText(ResourceUtil.getString(2131718493));
        setImageDrawable(this.mPullDownToRefreshFailIcon);
        return;
      }
      if (this.mLoadingStatus == 4)
      {
        stopLoading();
        setText(ResourceUtil.getString(2131718500));
        setImageDrawable(this.mPullDownToRefreshFailIcon);
        return;
      }
      if (this.mLoadingStatus == 9)
      {
        stopLoading();
        setText(ResourceUtil.getString(2131718494));
        setImageDrawable(null);
        return;
      }
      if (this.mLoadingStatus == 10)
      {
        stopLoading();
        setText(ResourceUtil.getString(2131718495));
        setImageDrawable(null);
        return;
      }
      if (this.mLoadingStatus == 5)
      {
        stopLoading();
        setText(ResourceUtil.getString(2131718493));
        setImageDrawable(this.mPullDownToRefreshFailIcon);
        postDelayed(new HippyTKDDefaultFooter.2(this), 2000L);
        return;
      }
      if (this.mLoadingStatus == 6)
      {
        stopLoading();
        setText(ResourceUtil.getString(2131718492));
        setImageDrawable(null);
        return;
      }
      if (this.mLoadingStatus == 7)
      {
        stopLoading();
        setText("");
        setImageDrawable(null);
        return;
      }
      if (this.mLoadingStatus == 8)
      {
        stopLoading();
        setImageDrawable(null);
        setText("");
        return;
      }
      if (this.mLoadingStatus == 0)
      {
        stopLoading();
        setImageDrawable(null);
        setText("");
        return;
      }
    } while (this.mLoadingStatus != 100);
    stopLoading();
    setImageDrawable(null);
    setText(this.mCustomMessage);
  }
  
  public void setLoadingStatus(int paramInt, String paramString)
  {
    this.mCustomMessage = paramString;
    setLoadingStatus(paramInt, -1);
  }
  
  public void setPullToRefreshListener(PullToRefreshListener paramPullToRefreshListener)
  {
    this.refreshListener = paramPullToRefreshListener;
  }
  
  public void setShowLoadingDelayTime(int paramInt)
  {
    this.mShowLoadingDelayTime = paramInt;
  }
  
  public void startLoading()
  {
    setTextVisisbility(4);
    setImageVisibility(4);
    Log.d("DefaultFooterView", hashCode() + ",startLoading");
    if (this.mRefreshing) {
      return;
    }
    if (this.mIsAttached)
    {
      int i = 0;
      while (i < 3)
      {
        this.mBalls[i].animateRefresh();
        i += 1;
      }
      invalidate();
    }
    this.mRefreshing = true;
  }
  
  public void stopLoading()
  {
    setTextVisisbility(0);
    setImageVisibility(0);
    Log.d("DefaultFooterView", this + ",stopLoading!!!");
    if (!this.mRefreshing) {
      return;
    }
    Log.d("DefaultFooterView", hashCode() + ",stoped");
    this.mRefreshing = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDDefaultFooter
 * JD-Core Version:    0.7.0.1
 */