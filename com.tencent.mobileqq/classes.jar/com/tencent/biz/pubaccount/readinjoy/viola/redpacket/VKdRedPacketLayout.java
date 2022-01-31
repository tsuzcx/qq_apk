package com.tencent.biz.pubaccount.readinjoy.viola.redpacket;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;

public class VKdRedPacketLayout
  extends FrameLayout
  implements IVView<VKdRedPacketProgress>
{
  private WeakReference<VKdRedPacketProgress> a;
  
  public VKdRedPacketLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public VKdRedPacketProgress a()
  {
    if (this.a != null) {
      return (VKdRedPacketProgress)this.a.get();
    }
    return null;
  }
  
  public void a(VKdRedPacketProgress paramVKdRedPacketProgress)
  {
    this.a = new WeakReference(paramVKdRedPacketProgress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.redpacket.VKdRedPacketLayout
 * JD-Core Version:    0.7.0.1
 */