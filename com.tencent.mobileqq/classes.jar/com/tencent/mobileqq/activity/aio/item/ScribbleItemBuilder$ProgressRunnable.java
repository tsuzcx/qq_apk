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
    if (this.a != null) {}
    for (MessageForScribble localMessageForScribble = (MessageForScribble)this.a.get();; localMessageForScribble = null)
    {
      if (this.b != null) {}
      for (ScribbleItemBuilder.Holder localHolder = (ScribbleItemBuilder.Holder)this.b.get();; localHolder = null)
      {
        if (this.c != null) {}
        for (Handler localHandler = (Handler)this.c.get();; localHandler = null)
        {
          if (this.d != null) {}
          for (Context localContext = (Context)this.d.get();; localContext = null)
          {
            if ((localMessageForScribble == null) || (localHandler == null) || (localHolder == null) || (localContext == null)) {}
            do
            {
              return;
              ScribbleItemBuilder.a(localMessageForScribble);
              ScribbleItemBuilder.a(localMessageForScribble, localHolder, localMessageForScribble.mUiProgress, false, localContext, localHandler);
            } while (!localHolder.a.isShown());
            localHandler.postDelayed(localMessageForScribble.mUpdateProgressRunnable, 50L);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.ProgressRunnable
 * JD-Core Version:    0.7.0.1
 */