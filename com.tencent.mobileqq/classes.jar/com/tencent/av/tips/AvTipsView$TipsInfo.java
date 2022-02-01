package com.tencent.av.tips;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.av.VideoUtils;
import com.tencent.av.tips.data.AvTipsItemBase;
import com.tencent.av.tips.data.HypeLinkAvTipsItem;
import com.tencent.av.tips.data.NormalAvTipsItem;
import com.tencent.av.tips.data.WaitingAvTipsItem;

class AvTipsView$TipsInfo
{
  boolean a = false;
  boolean b = false;
  boolean c = false;
  Bitmap d = null;
  int e = -1;
  int f = -1;
  int g = -1;
  int h = -1;
  SpannableString i = null;
  boolean j = false;
  
  static TipsInfo a(Resources paramResources, AvTipsItemBase paramAvTipsItemBase, AvTipsView.BaseTips paramBaseTips)
  {
    TipsInfo localTipsInfo = new TipsInfo();
    if (!TextUtils.isEmpty(paramAvTipsItemBase.f())) {
      localTipsInfo.i = new SpannableString(paramAvTipsItemBase.f());
    }
    localTipsInfo.e = paramBaseTips.d;
    localTipsInfo.f = paramBaseTips.a;
    localTipsInfo.g = paramBaseTips.b;
    localTipsInfo.h = paramBaseTips.c;
    int k = paramAvTipsItemBase.a();
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3) {
          return localTipsInfo;
        }
        paramResources = (HypeLinkAvTipsItem)paramAvTipsItemBase;
        if (paramResources.k() != -1) {
          localTipsInfo.e = paramResources.k();
        }
        if (paramResources.m() != -1) {
          localTipsInfo.g = paramResources.m();
        }
        if (paramResources.l() != -1) {
          localTipsInfo.h = paramResources.l();
        }
        if (localTipsInfo.i != null)
        {
          int m = paramResources.h();
          if (paramResources.i() == -1) {
            k = paramAvTipsItemBase.f().length();
          } else {
            k = paramResources.i();
          }
          k += m;
          paramResources = paramResources.j();
          localTipsInfo.i.setSpan(new AvTipsView.TipsInfo.1(paramResources), m, k, 33);
          paramResources = new ForegroundColorSpan(localTipsInfo.g);
          localTipsInfo.i.setSpan(paramResources, m, k, 17);
          return localTipsInfo;
        }
      }
      else
      {
        paramResources = (WaitingAvTipsItem)paramAvTipsItemBase;
        localTipsInfo.c = paramResources.h();
        localTipsInfo.j = paramResources.i();
        return localTipsInfo;
      }
    }
    else
    {
      paramAvTipsItemBase = (NormalAvTipsItem)paramAvTipsItemBase;
      if ((paramAvTipsItemBase.n() instanceof BitmapDrawable))
      {
        localTipsInfo.d = ((BitmapDrawable)paramAvTipsItemBase.n()).getBitmap();
      }
      else
      {
        paramBaseTips = paramAvTipsItemBase.o();
        if (!TextUtils.isEmpty(paramBaseTips)) {
          localTipsInfo.d = VideoUtils.a(paramResources, paramBaseTips);
        }
      }
      k = paramAvTipsItemBase.p();
      if (k != 1)
      {
        if (k != 2) {
          return localTipsInfo;
        }
        localTipsInfo.b = true;
        return localTipsInfo;
      }
      localTipsInfo.a = true;
    }
    return localTipsInfo;
  }
  
  static void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    paramTextView.setTag(2131446813, Integer.valueOf(paramInt2));
    paramTextView.setTag(2131446814, Integer.valueOf(paramInt1));
    paramTextView.setHighlightColor(0);
    paramTextView.setMovementMethod((RedPacketLinkMovementMethod)RedPacketLinkMovementMethod.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.AvTipsView.TipsInfo
 * JD-Core Version:    0.7.0.1
 */