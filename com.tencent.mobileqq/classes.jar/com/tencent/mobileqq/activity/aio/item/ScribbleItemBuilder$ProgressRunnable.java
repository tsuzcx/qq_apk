package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

class ScribbleItemBuilder$ProgressRunnable
  implements Runnable
{
  private WeakReference<MessageForScribble> a;
  private WeakReference<ScribbleItemBuilder.Holder> b;
  private WeakReference<Handler> c;
  private WeakReference<Context> d;
  
  public ScribbleItemBuilder$ProgressRunnable(MessageForScribble paramMessageForScribble, ScribbleItemBuilder.Holder paramHolder, Handler paramHandler, Context paramContext)
  {
    this.a = new WeakReference(paramMessageForScribble);
    this.b = new WeakReference(paramHolder);
    this.c = new WeakReference(paramHandler);
    this.d = new WeakReference(paramContext);
  }
  
  public void run()
  {
    Object localObject1 = this.a;
    Context localContext = null;
    if (localObject1 != null) {
      localObject1 = (MessageForScribble)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.b;
    if (localObject2 != null) {
      localObject2 = (ScribbleItemBuilder.Holder)((WeakReference)localObject2).get();
    } else {
      localObject2 = null;
    }
    Object localObject3 = this.c;
    if (localObject3 != null) {
      localObject3 = (Handler)((WeakReference)localObject3).get();
    } else {
      localObject3 = null;
    }
    WeakReference localWeakReference = this.d;
    if (localWeakReference != null) {
      localContext = (Context)localWeakReference.get();
    }
    if ((localObject1 != null) && (localObject3 != null) && (localObject2 != null))
    {
      if (localContext == null) {
        return;
      }
      ScribbleItemBuilder.a((MessageForScribble)localObject1);
      ScribbleItemBuilder.a((MessageForScribble)localObject1, (ScribbleItemBuilder.Holder)localObject2, ((MessageForScribble)localObject1).mUiProgress, false, localContext, (Handler)localObject3);
      if (((ScribbleItemBuilder.Holder)localObject2).b.isShown()) {
        ((Handler)localObject3).postDelayed(((MessageForScribble)localObject1).mUpdateProgressRunnable, 50L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.ProgressRunnable
 * JD-Core Version:    0.7.0.1
 */