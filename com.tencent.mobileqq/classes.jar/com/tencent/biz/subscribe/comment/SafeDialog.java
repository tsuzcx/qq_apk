package com.tencent.biz.subscribe.comment;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

public class SafeDialog
  extends BaseDialog
{
  protected WeakReference<Context> c;
  
  public SafeDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.c = new WeakReference(paramContext);
  }
  
  public boolean g()
  {
    Context localContext = (Context)this.c.get();
    return ((localContext instanceof Activity)) && (((Activity)localContext).isFinishing());
  }
  
  public void show()
  {
    if (g()) {
      return;
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SafeDialog
 * JD-Core Version:    0.7.0.1
 */