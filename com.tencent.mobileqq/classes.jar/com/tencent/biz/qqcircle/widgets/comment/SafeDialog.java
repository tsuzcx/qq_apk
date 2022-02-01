package com.tencent.biz.qqcircle.widgets.comment;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

public class SafeDialog
  extends BaseDialog
{
  protected WeakReference<Context> o;
  
  public SafeDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.o = new WeakReference(paramContext);
  }
  
  public boolean m()
  {
    Context localContext = (Context)this.o.get();
    return ((localContext instanceof Activity)) && (((Activity)localContext).isFinishing());
  }
  
  public long n()
  {
    WeakReference localWeakReference = this.o;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((Context)this.o.get()).hashCode();
    }
    return 0L;
  }
  
  public void show()
  {
    if (m()) {
      return;
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.comment.SafeDialog
 * JD-Core Version:    0.7.0.1
 */