package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.core.VcSystemInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZimuViewRibon
  extends ZimuViewMotion
{
  int[] n = { 86, 60, 56, 44, 32 };
  IZimuItemView.FontPara[] o = { new IZimuItemView.FontPara(Color.parseColor("#cc8de1"), Color.parseColor("#ffffff"), 7), new IZimuItemView.FontPara(Color.parseColor("#57d4d9"), Color.parseColor("#ffffff"), 7), new IZimuItemView.FontPara(Color.parseColor("#ffc903"), Color.parseColor("#ffffff"), 7) };
  Random p = new Random();
  WeakReference<ZimuView> q = new WeakReference(this);
  private int r = 0;
  private int s = 0;
  
  public ZimuViewRibon(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
  }
  
  @NonNull
  private ZimuItemViewRibon a(SentenceInfo paramSentenceInfo, int paramInt1, int paramInt2, boolean paramBoolean, ZimuItemViewRibon paramZimuItemViewRibon)
  {
    int j = this.n.length;
    int i = this.o.length;
    j = paramInt1 % j;
    paramZimuItemViewRibon.a(paramBoolean);
    paramZimuItemViewRibon.a(this.b, this.n[j], this.o[(paramInt1 % i)]);
    paramZimuItemViewRibon.a(paramSentenceInfo);
    i = a(this.j * (paramInt1 % 4), paramZimuItemViewRibon.i());
    paramZimuItemViewRibon.a(this.e, i);
    paramSentenceInfo = new StringBuilder();
    paramSentenceInfo.append("onCreateItemView:");
    paramSentenceInfo.append(paramInt1);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(paramInt2);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(i);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(this.j);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(this.n[j]);
    AVLog.printColorLog("ZimuViewRibon", paramSentenceInfo.toString());
    paramZimuItemViewRibon.b(paramInt2);
    return paramZimuItemViewRibon;
  }
  
  protected List<ZimuItemView> b(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    int i;
    int j;
    Object localObject;
    int k;
    if (this.s % 3 == 0)
    {
      i = this.p.nextInt(3000);
      if ((i & 0x1) == 1) {
        j = 1;
      } else {
        j = 0;
      }
      localObject = new ZimuItemViewRibon(getContext(), this.q, this.e, this.f, this.g);
      int m = this.r;
      if (j != 0) {
        k = i;
      } else {
        k = 0;
      }
      localArrayList.add(a(paramSentenceInfo, m, k, paramBoolean, (ZimuItemViewRibon)localObject));
      this.r += 1;
      localObject = new ZimuItemViewRibon(getContext(), this.q, this.e, this.f, this.g);
      k = this.r;
      if (j != 0) {
        i = 0;
      }
      localArrayList.add(a(paramSentenceInfo, k, i, paramBoolean, (ZimuItemViewRibon)localObject));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreateItemView random 00 :");
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append("||");
      ((StringBuilder)localObject).append(paramSentenceInfo.b);
      AVLog.printColorLog("ZimuViewRibon", ((StringBuilder)localObject).toString());
    }
    else
    {
      j = this.p.nextInt(3000);
      if ((j & 0x1) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = new ZimuItemViewRibon(getContext(), this.q, this.e, this.f, this.g);
      k = this.r;
      if (i != 0) {
        i = j;
      } else {
        i = 0;
      }
      localArrayList.add(a(paramSentenceInfo, k, i, paramBoolean, (ZimuItemViewRibon)localObject));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreateItemView random zz :");
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramSentenceInfo.b);
      AVLog.printColorLog("ZimuViewRibon", ((StringBuilder)localObject).toString());
    }
    this.r += 1;
    this.s += 1;
    return localArrayList;
  }
  
  public void b()
  {
    float f = this.g * 0.48F;
    int k = this.n.length;
    int j = 0;
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = this.n;
      localObject[i] = ((int)(localObject[i] * f));
      i += 1;
    }
    k = this.o.length;
    i = j;
    while (i < k)
    {
      localObject = this.o;
      localObject[i].c *= f;
      i += 1;
    }
    getFrameInterval();
    super.b();
  }
  
  protected void b(ZimuItemView paramZimuItemView)
  {
    super.b(paramZimuItemView);
    paramZimuItemView.m();
    SentenceInfo localSentenceInfo = paramZimuItemView.l;
    paramZimuItemView = (ZimuItemViewRibon)paramZimuItemView;
    a(localSentenceInfo, this.r, 0, true, paramZimuItemView);
    this.r += 1;
  }
  
  long getFrameInterval()
  {
    long l = VcSystemInfo.getMaxCpuFreq();
    if (l > 1800000L) {
      this.l = 50L;
    } else if (l > 1400000L) {
      this.l = 62L;
    } else {
      this.l = 83L;
    }
    return this.l;
  }
  
  public String getID()
  {
    return "ribbon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewRibon
 * JD-Core Version:    0.7.0.1
 */