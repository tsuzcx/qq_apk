package com.tencent.luggage.wxa.fy;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lp.e;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;

public class u
  implements com.tencent.luggage.wxa.lp.i<View>
{
  private static e b = new u.1();
  private static WeakReference<byte[]> c = null;
  protected final String a;
  @NonNull
  private final i d;
  
  public u(@NonNull i parami)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.AppBrand.XWebVideoContainerChannel4AudioPlay#");
    localStringBuilder.append(hashCode());
    this.a = localStringBuilder.toString();
    this.d = parami;
  }
  
  @NonNull
  public View a(@NonNull Context paramContext)
  {
    return new u.2(this, paramContext);
  }
  
  @NonNull
  public e a()
  {
    return b;
  }
  
  public void a(@NonNull View paramView) {}
  
  public void b(@NonNull View paramView)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayEndWorkaround, view: ");
    localStringBuilder.append(paramView);
    o.d(str, localStringBuilder.toString());
  }
  
  public void b(@NonNull View paramView, @Nullable Runnable paramRunnable)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transferTo, view: ");
    localStringBuilder.append(paramView);
    o.d(str, localStringBuilder.toString());
    if (paramRunnable != null)
    {
      o.d(this.a, "transferTo, run afterTransferToTask");
      paramRunnable.run();
    }
  }
  
  public void c(@NonNull View paramView, @Nullable Runnable paramRunnable)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transferFrom, view: ");
    localStringBuilder.append(paramView);
    o.d(str, localStringBuilder.toString());
    if (paramRunnable != null)
    {
      o.d(this.a, "transferFrom, run afterTransferFromTask");
      paramRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.u
 * JD-Core Version:    0.7.0.1
 */