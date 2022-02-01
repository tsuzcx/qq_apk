package com.tencent.gdtad.aditem;

import android.app.Activity;
import com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment;
import com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment;
import com.tencent.gdtad.views.videoceiling.GdtBaseVideoCeilingFragment;
import java.lang.ref.WeakReference;

public final class GdtHandler$Params
  extends GdtHandler.Options
{
  public Class<? extends GdtBaseVideoCeilingFragment> a;
  public WeakReference<Activity> a;
  public Class<? extends GdtCanvasBaseFragment> b;
  public WeakReference<GdtAppReceiver> b;
  public int c = -2147483648;
  public Class<? extends GdtBaseHalfScreenFragment> c;
  
  public boolean a()
  {
    return (super.a()) && (b());
  }
  
  public boolean b()
  {
    return (this.a != null) && (this.a.get() != null) && (this.b != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler.Params
 * JD-Core Version:    0.7.0.1
 */