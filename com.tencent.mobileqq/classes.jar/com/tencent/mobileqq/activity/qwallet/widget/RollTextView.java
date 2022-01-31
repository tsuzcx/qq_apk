package com.tencent.mobileqq.activity.qwallet.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import com.tencent.mobileqq.app.ThreadManager;

public class RollTextView
  extends TextSwitcher
{
  private static final int MSG_UPDATE = 1;
  protected Bitmap bitmap;
  private boolean isRool = true;
  protected boolean mAcitive = true;
  private Context mContext;
  private int mFactor;
  private int mFrom;
  private RollTextView.RollViewHandler mHandler = new RollTextView.RollViewHandler(this);
  private int mInDuring = 200;
  private RollTextView.OnRollTextChangeListener mListener;
  private int mOutDuring = 200;
  private int mTextColor;
  private int mTextSize = 50;
  private int mTo;
  private int mTotalDuring;
  
  public RollTextView(Context paramContext)
  {
    super(paramContext);
    init(paramContext, true);
  }
  
  public RollTextView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.mTextSize = paramInt1;
    this.mTextColor = paramInt2;
    init(paramContext, true);
  }
  
  public RollTextView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramContext);
    this.mFrom = paramInt1;
    this.mTo = paramInt2;
    this.mTextSize = paramInt3;
    this.mTextColor = paramInt4;
    init(paramContext, true);
  }
  
  public RollTextView(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext);
    this.mTextSize = paramInt1;
    this.mTextColor = paramInt2;
    init(paramContext, paramBoolean);
  }
  
  public RollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, true);
  }
  
  public static Bitmap loadBitmapFromView(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(100, 200, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.translate(-paramView.getScrollX(), -paramView.getScrollY());
    paramView.draw(localCanvas);
    return localBitmap;
  }
  
  private void setIsRool(boolean paramBoolean)
  {
    this.isRool = paramBoolean;
    if (paramBoolean)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(this.mContext, 2130772193);
      localAnimation.setFillAfter(true);
      setInAnimation(localAnimation);
      localAnimation = AnimationUtils.loadAnimation(this.mContext, 2130772194);
      localAnimation.setFillAfter(true);
      setOutAnimation(localAnimation);
      return;
    }
    setInAnimation(null);
    setOutAnimation(null);
  }
  
  public void init(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    this.mContext = paramContext;
    setIsRool(paramBoolean);
    setFactory(new RollTextView.1(this, paramBoolean));
  }
  
  public void setContext(int paramInt1, int paramInt2)
  {
    this.mFrom = paramInt1;
    this.mTo = paramInt2;
  }
  
  public void setFactor(int paramInt)
  {
    if (paramInt >= 0) {
      this.mFactor = paramInt;
    }
  }
  
  public void setListener(RollTextView.OnRollTextChangeListener paramOnRollTextChangeListener)
  {
    this.mListener = paramOnRollTextChangeListener;
  }
  
  public void setScope(int paramInt1, int paramInt2)
  {
    if (!this.isRool)
    {
      this.mTo = paramInt2;
      this.mFrom = paramInt2;
      return;
    }
    this.mFrom = paramInt1;
    this.mTo = paramInt2;
  }
  
  public void show()
  {
    ThreadManager.postImmediately(new RollTextView.ContentSupplyThread(this), null, true);
  }
  
  public void stopRoll()
  {
    this.mAcitive = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.RollTextView
 * JD-Core Version:    0.7.0.1
 */