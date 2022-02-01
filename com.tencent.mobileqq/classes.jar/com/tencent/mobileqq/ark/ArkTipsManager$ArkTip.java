package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.tips.ArkTipsBar;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.data.MessageForArkApp;
import java.lang.ref.WeakReference;

class ArkTipsManager$ArkTip
{
  ArkAioContainerWrapper a;
  public String b;
  public long c;
  public String d;
  public int e;
  public String f;
  public long g;
  public String h;
  public MessageForArkApp i;
  public WeakReference<TipsBar> j = null;
  public WeakReference<ArkTipsBar> k = null;
  
  ArkTipsManager$ArkTip(ArkAioContainerWrapper paramArkAioContainerWrapper, String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt, String paramString3, MessageForArkApp paramMessageForArkApp)
  {
    a(paramArkAioContainerWrapper, paramString1, paramLong1, paramLong2, paramString2, paramInt, paramString3, paramMessageForArkApp);
  }
  
  void a(ArkAioContainerWrapper paramArkAioContainerWrapper, String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt, String paramString3, MessageForArkApp paramMessageForArkApp)
  {
    this.a = paramArkAioContainerWrapper;
    this.b = paramString1;
    this.c = paramLong1;
    this.f = paramString2;
    this.e = paramInt;
    this.g = paramLong2;
    this.h = paramString3;
    this.i = paramMessageForArkApp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.ArkTip
 * JD-Core Version:    0.7.0.1
 */