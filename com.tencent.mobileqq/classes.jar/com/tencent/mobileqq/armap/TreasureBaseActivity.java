package com.tencent.mobileqq.armap;

import abls;
import ablt;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;

public class TreasureBaseActivity
  extends ARMapBaseActivity
{
  private ImageView mArrowDown;
  private ImageView mArrowLeft;
  private ImageView mArrowLeftDown;
  private ImageView mArrowLeftUp;
  private ImageView mArrowRight;
  private ImageView mArrowRightDown;
  private ImageView mArrowRightUp;
  private ImageView mArrowUp;
  protected View mGuideLayout;
  protected TextView mGuideTips;
  
  private void setViewVisible(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if ((ARMapManager)this.app.getManager(209) != null) {
      ARMapManager.a(this, true);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if ((ARMapManager)this.app.getManager(209) != null) {
      ARMapManager.a(this, false);
    }
  }
  
  Drawable getRotateDrawable(Bitmap paramBitmap, float paramFloat)
  {
    return new abls(this, getResources(), paramBitmap, paramFloat, paramBitmap);
  }
  
  protected void hideGuide()
  {
    if (this.mGuideTips != null) {
      this.mGuideTips.setVisibility(8);
    }
    if (this.mGuideLayout != null) {
      this.mGuideLayout.setVisibility(8);
    }
  }
  
  public void initArrowImageView(String paramString)
  {
    Object localObject = paramString + "/arrow_left.png";
    paramString = BitmapManager.a((String)localObject);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ARMapBaseActivity", 2, "arrow_left bitmap null,return. path:" + (String)localObject);
      }
      return;
    }
    Drawable localDrawable = getRotateDrawable(paramString, 315.0F);
    this.mArrowLeftDown = ((ImageView)findViewById(2131369607));
    if ((localDrawable != null) && (this.mArrowLeftDown != null)) {
      this.mArrowLeftDown.setImageDrawable(localDrawable);
    }
    localDrawable = Drawable.createFromPath((String)localObject);
    this.mArrowLeft = ((ImageView)findViewById(2131369602));
    if ((this.mArrowLeft != null) && (localDrawable != null)) {
      this.mArrowLeft.setImageDrawable(localDrawable);
    }
    while (!QLog.isColorLevel())
    {
      localObject = getRotateDrawable(paramString, 45.0F);
      this.mArrowLeftUp = ((ImageView)findViewById(2131369603));
      if ((localObject != null) && (this.mArrowLeftUp != null)) {
        this.mArrowLeftUp.setImageDrawable((Drawable)localObject);
      }
      localObject = getRotateDrawable(paramString, 90.0F);
      this.mArrowUp = ((ImageView)findViewById(2131369604));
      if ((localObject != null) && (this.mArrowUp != null)) {
        this.mArrowUp.setImageDrawable((Drawable)localObject);
      }
      localObject = getRotateDrawable(paramString, 135.0F);
      this.mArrowRightUp = ((ImageView)findViewById(2131369605));
      if ((localObject != null) && (this.mArrowRightUp != null)) {
        this.mArrowRightUp.setImageDrawable((Drawable)localObject);
      }
      localObject = getRotateDrawable(paramString, 180.0F);
      this.mArrowRight = ((ImageView)findViewById(2131366832));
      if ((localObject != null) && (this.mArrowRight != null)) {
        this.mArrowRight.setImageDrawable((Drawable)localObject);
      }
      localObject = getRotateDrawable(paramString, 225.0F);
      this.mArrowRightDown = ((ImageView)findViewById(2131369606));
      if ((localObject != null) && (this.mArrowRightDown != null)) {
        this.mArrowRightDown.setImageDrawable((Drawable)localObject);
      }
      paramString = getRotateDrawable(paramString, 270.0F);
      this.mArrowDown = ((ImageView)findViewById(2131364603));
      if ((paramString == null) || (this.mArrowDown == null)) {
        break;
      }
      this.mArrowDown.setImageDrawable(paramString);
      return;
    }
    localObject = new StringBuilder().append("arrow_left drawable null, path:").append((String)localObject).append(", view null ? ");
    if (this.mArrowLeft == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ARMapBaseActivity", 2, bool);
      break;
    }
  }
  
  protected void initGuide(String paramString, Handler paramHandler) {}
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onTreasureDirectionChange(float paramFloat1, boolean paramBoolean, float paramFloat2)
  {
    runOnUiThread(new ablt(this, paramBoolean, paramFloat1));
  }
  
  protected void showGuide()
  {
    if (this.mGuideTips != null) {
      this.mGuideTips.setVisibility(0);
    }
    if (this.mGuideLayout != null) {
      this.mGuideLayout.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.TreasureBaseActivity
 * JD-Core Version:    0.7.0.1
 */