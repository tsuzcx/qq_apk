package com.tencent.biz.pubaccount.readinjoy.magic;

import android.content.Context;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Set;
import mqq.os.MqqHandler;
import ony;
import ooa;

public class ReadInJoyWatcherObserver$1
  implements Runnable
{
  public ReadInJoyWatcherObserver$1(ony paramony, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if (this.a.get() != null)
    {
      Set localSet = ony.a(new File(ooa.a()));
      localSet = ony.a(this.this$0, ony.a((Context)this.a.get(), localSet));
      ony.a(this.this$0, localSet);
      ony.a(this.this$0).postDelayed(this, ony.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.magic.ReadInJoyWatcherObserver.1
 * JD-Core Version:    0.7.0.1
 */