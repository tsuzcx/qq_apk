package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;

public final class EdgeEffectCompat
{
  private EdgeEffect mEdgeEffect;
  
  @Deprecated
  public EdgeEffectCompat(Context paramContext)
  {
    this.mEdgeEffect = new EdgeEffect(paramContext);
  }
  
  public static void onPull(@NonNull EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramEdgeEffect.onPull(paramFloat1, paramFloat2);
      return;
    }
    paramEdgeEffect.onPull(paramFloat1);
  }
  
  @Deprecated
  public boolean draw(Canvas paramCanvas)
  {
    return this.mEdgeEffect.draw(paramCanvas);
  }
  
  @Deprecated
  public void finish()
  {
    this.mEdgeEffect.finish();
  }
  
  @Deprecated
  public boolean isFinished()
  {
    return this.mEdgeEffect.isFinished();
  }
  
  @Deprecated
  public boolean onAbsorb(int paramInt)
  {
    this.mEdgeEffect.onAbsorb(paramInt);
    return true;
  }
  
  @Deprecated
  public boolean onPull(float paramFloat)
  {
    this.mEdgeEffect.onPull(paramFloat);
    return true;
  }
  
  @Deprecated
  public boolean onPull(float paramFloat1, float paramFloat2)
  {
    onPull(this.mEdgeEffect, paramFloat1, paramFloat2);
    return true;
  }
  
  @Deprecated
  public boolean onRelease()
  {
    this.mEdgeEffect.onRelease();
    return this.mEdgeEffect.isFinished();
  }
  
  @Deprecated
  public void setSize(int paramInt1, int paramInt2)
  {
    this.mEdgeEffect.setSize(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.widget.EdgeEffectCompat
 * JD-Core Version:    0.7.0.1
 */