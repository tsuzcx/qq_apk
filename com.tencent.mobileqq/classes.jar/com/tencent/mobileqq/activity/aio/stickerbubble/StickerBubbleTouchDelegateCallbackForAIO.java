package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Point;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.ZhituTextChangeCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;

public class StickerBubbleTouchDelegateCallbackForAIO
  implements StickerBubbleAnimationViewHolder.AnimationViewCallback, StickerBubbleSendCallback
{
  private Context a;
  private AIOContext b;
  private PEItemData c;
  private StickerBubbleTouchDelegate d;
  
  public StickerBubbleTouchDelegateCallbackForAIO(Context paramContext, AIOContext paramAIOContext)
  {
    this.a = paramContext;
    this.b = paramAIOContext;
    StickerBubbleAnimationViewHolder.b().b(this);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return 0;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.c = PEPanelHelper.e(StickerBubbleAnimationHelper.a(this.b.a().getCurrentUin()));
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    localObject = ((PEItemData)localObject).b;
    if (localObject == null) {
      return;
    }
    StickerBubbleAnimationViewHolder.b().a(this.b.r(), this.a).a(StickerBubbleAnimationHelper.b(new Point((int)paramFloat1, (int)paramFloat2), (String)localObject, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StickerBubbleAnimationViewHolder.b().d(this.a).d();
    PEItemData localPEItemData = this.c;
    if (localPEItemData != null)
    {
      StickerBubbleAnimationHelper.a(localPEItemData, this.b.a().getCurrentUin());
      Iterator localIterator = this.b.p().c().j().iterator();
      while (localIterator.hasNext())
      {
        IEditTextChangeCallback localIEditTextChangeCallback = (IEditTextChangeCallback)localIterator.next();
        if ((localIEditTextChangeCallback instanceof ZhituTextChangeCallback)) {
          ((ZhituTextChangeCallback)localIEditTextChangeCallback).a(this.b, null);
        }
      }
      ThreadManager.post(new StickerBubbleTouchDelegateCallbackForAIO.1(this, localPEItemData, paramInt2), 10, null, false);
      ReportController.b(this.b.a(), "dc00898", "", this.b.O().b, "0X80091A5", "0X80091A5", localPEItemData.a, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public void a(StickerBubbleTouchDelegate paramStickerBubbleTouchDelegate)
  {
    this.d = paramStickerBubbleTouchDelegate;
  }
  
  public void b()
  {
    d();
    StickerBubbleTouchDelegate localStickerBubbleTouchDelegate = this.d;
    if (localStickerBubbleTouchDelegate != null) {
      localStickerBubbleTouchDelegate.c();
    }
  }
  
  public void b(float paramFloat1, float paramFloat2) {}
  
  public void c()
  {
    StickerBubbleAnimationHelper.b(this, this.b.r());
  }
  
  public boolean c(float paramFloat1, float paramFloat2)
  {
    return this.b.p().d().c().a(paramFloat1, paramFloat2);
  }
  
  public void d()
  {
    StickerBubbleAnimationHelper.a(this, this.b.r());
  }
  
  public void e() {}
  
  public int getMaxSendCount()
  {
    return PokeItemHelper.b(this.b.a(), 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO
 * JD-Core Version:    0.7.0.1
 */