package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class StickerBubbleReceiverAnimationRunnable
  implements StickerBubbleAnimationViewHolder.AnimationViewCallback, Runnable
{
  private Context a;
  private QQAppInterface b;
  private Handler c;
  private View d;
  private int e;
  private int f;
  private String g;
  private boolean h = false;
  private int[] i;
  private boolean j = false;
  private boolean k;
  private boolean l;
  private boolean m;
  private Runnable n = new StickerBubbleReceiverAnimationRunnable.1(this);
  
  public StickerBubbleReceiverAnimationRunnable(QQAppInterface paramQQAppInterface, int paramInt, @NonNull View paramView, @NonNull String paramString)
  {
    this.a = paramQQAppInterface.getApp().getApplicationContext();
    this.b = paramQQAppInterface;
    this.e = paramInt;
    this.c = new Handler(Looper.getMainLooper());
    this.d = paramView;
    this.g = paramString;
    this.k = (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.b) ^ true);
    StickerBubbleAnimationViewHolder.b().a(this);
  }
  
  @NonNull
  private int[] c()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.e * 80 < 5000) {
      return StickerBubbleAnimationHelper.a((QQAppInterface)localObject);
    }
    localObject = StickerBubbleAnimationHelper.a((QQAppInterface)localObject);
    int i5 = localObject.length;
    int i4 = 0;
    int i2 = 0;
    int i3;
    for (int i1 = 0; i2 < i5; i1 = i3)
    {
      i3 = i1;
      if (localObject[i2] <= this.e) {
        i3 = i1 + 1;
      }
      i2 += 1;
    }
    localObject = new int[i1];
    i5 = 62 / i1;
    for (i2 = i4; i2 < i1; i2 = i3)
    {
      i3 = i2 + 1;
      localObject[i2] = (i5 * i3);
    }
    return localObject;
  }
  
  public void a()
  {
    if (AIOUtils.p > 0) {
      AIOUtils.p -= 1;
    }
  }
  
  public void b()
  {
    this.c.removeCallbacksAndMessages(null);
    StickerBubbleAnimationHelper.a(this, this.d);
    this.h = true;
    AIOUtils.p = 0;
    if (this.k)
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.b, "StickerBubble", false);
      this.l = true;
    }
  }
  
  public void run()
  {
    if (this.h) {
      return;
    }
    if ((this.k) && (!this.l))
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.b, "StickerBubble", true);
      this.l = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleRunnable", 2, "showReceiveAnimationView from runnable");
    }
    Object localObject = StickerBubbleAnimationViewHolder.b().b((ViewGroup)this.d, this.a);
    if (!this.j)
    {
      ((StickerBubbleAnimationView)localObject).bringToFront();
      this.j = true;
    }
    if (this.i == null) {
      this.i = c();
    }
    this.f += 1;
    int i1 = this.f;
    if ((i1 <= this.e) && (i1 * 80 <= 5000))
    {
      if (i1 == 2)
      {
        StickerBubbleAnimationHelper.b(this, this.d);
        this.m = false;
      }
      ((StickerBubbleAnimationView)localObject).a(StickerBubbleAnimationHelper.a(this.a.getResources().getDisplayMetrics().widthPixels, this.g, this.f, this.i));
      this.c.postDelayed(this, 80L);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Sticker bubble receiver animation sending finished ");
      ((StringBuilder)localObject).append(this);
      QLog.d("StickerBubbleRunnable", 2, ((StringBuilder)localObject).toString());
    }
    this.m = true;
    this.c.postDelayed(this.n, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleReceiverAnimationRunnable
 * JD-Core Version:    0.7.0.1
 */