package com.tencent.biz.pubaccount.readinjoyAd.ad.home_watcher;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.kandian.ad.api.entity.IHomeWatcher;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReadInJoyAdHomeWatcher
  implements IHomeWatcher
{
  private Context a;
  private IntentFilter b;
  private OnHomePressedListener c;
  private ReadInJoyAdHomeWatcher.InnerRecevier d;
  private AtomicBoolean e = new AtomicBoolean(false);
  
  public ReadInJoyAdHomeWatcher(Context paramContext)
  {
    this.a = paramContext;
    this.b = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
  }
  
  public void a(OnHomePressedListener paramOnHomePressedListener)
  {
    this.c = paramOnHomePressedListener;
    this.d = new ReadInJoyAdHomeWatcher.InnerRecevier(this);
  }
  
  public boolean a()
  {
    return this.e.get();
  }
  
  public void b()
  {
    if ((this.d != null) && (this.e.compareAndSet(false, true))) {
      this.a.registerReceiver(this.d, this.b);
    }
  }
  
  public void c()
  {
    if ((this.d != null) && (this.e.compareAndSet(true, false))) {
      this.a.unregisterReceiver(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.home_watcher.ReadInJoyAdHomeWatcher
 * JD-Core Version:    0.7.0.1
 */