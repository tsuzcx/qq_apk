package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.core.VcSystemInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ZimuViewPacMan
  extends ZimuViewMotion
{
  static final IZimuItemView.FontPara[] s = { new IZimuItemView.FontPara(Color.parseColor("#ffffff"), Color.parseColor("#000000"), 4) };
  int[] n = { 48, 38, 34 };
  final int[] o = { 70, 58, 52 };
  int[] p = { 116, 102, 90 };
  Random q = new Random();
  List<ZimuViewPacMan.RAILWAY> r = new ArrayList(4);
  Bitmap[] t = { null, null };
  WeakReference<ZimuView> u;
  
  public ZimuViewPacMan(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
    int i = 0;
    while (i < 4)
    {
      paramVideoAppInterface = new ZimuViewPacMan.RAILWAY(this, i, 0);
      this.r.add(paramVideoAppInterface);
      i += 1;
    }
    this.u = new WeakReference(this);
  }
  
  void a(int paramInt)
  {
    Iterator localIterator = this.r.iterator();
    while (localIterator.hasNext())
    {
      ZimuViewPacMan.RAILWAY localRAILWAY = (ZimuViewPacMan.RAILWAY)localIterator.next();
      if (localRAILWAY.a == paramInt)
      {
        localRAILWAY.b -= 1;
        if (localRAILWAY.b == 0)
        {
          localIterator.remove();
          this.r.add(0, localRAILWAY);
        }
      }
    }
  }
  
  protected void a(ZimuItemView paramZimuItemView)
  {
    a(((ZimuItemViewPacMan)paramZimuItemView).o());
  }
  
  protected List<ZimuItemView> b(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    int k = this.q.nextInt(40);
    int m = this.o.length;
    int i1 = this.p.length;
    int i = k % this.n.length;
    int j = i();
    Object localObject = new ZimuItemViewPacMan.PacManPara(this.t, this.p[(k % i1)], this.o[(k % m)], j);
    localObject = new ZimuItemViewPacMan(getContext(), this.u, this.e, this.f, this.g, (ZimuItemViewPacMan.PacManPara)localObject);
    ((ZimuItemViewPacMan)localObject).a(paramBoolean);
    ((ZimuItemViewPacMan)localObject).a(this.b, this.n[i], s[0]);
    ((ZimuItemViewPacMan)localObject).a(paramSentenceInfo);
    m = this.j;
    k = ((ZimuItemViewPacMan)localObject).i();
    j = a(j * m, k);
    ((ZimuItemViewPacMan)localObject).a(this.e, j);
    ((ZimuItemViewPacMan)localObject).b(0L);
    localArrayList.add(localObject);
    paramSentenceInfo = new StringBuilder();
    paramSentenceInfo.append("onCreateItemView:|");
    paramSentenceInfo.append(j);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(k);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(this.j);
    paramSentenceInfo.append("|");
    paramSentenceInfo.append(this.n[i]);
    AVLog.printColorLog("ZimuViewPacMan", paramSentenceInfo.toString());
    return localArrayList;
  }
  
  public void b()
  {
    float f = this.g * 0.48F;
    int j = this.n.length;
    int i = 0;
    int[] arrayOfInt;
    while (i < j)
    {
      arrayOfInt = this.n;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f));
      i += 1;
    }
    j = this.o.length;
    i = 0;
    while (i < j)
    {
      arrayOfInt = this.o;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f));
      i += 1;
    }
    j = this.p.length;
    i = 0;
    while (i < j)
    {
      arrayOfInt = this.p;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f));
      i += 1;
    }
    try
    {
      this.t[0] = BitmapFactory.decodeResource(getContext().getResources(), 2130843353);
      this.t[1] = BitmapFactory.decodeResource(getContext().getResources(), 2130843354);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    getFrameInterval();
    super.b();
  }
  
  protected void b(ZimuItemView paramZimuItemView)
  {
    super.b(paramZimuItemView);
    paramZimuItemView.m();
    paramZimuItemView = (ZimuItemViewPacMan)paramZimuItemView;
    int i = this.q.nextInt(40);
    int j = this.p.length;
    int k = this.o.length;
    int m = this.n.length;
    int i1 = i();
    paramZimuItemView.a(new ZimuItemViewPacMan.PacManPara(this.t, this.p[(i % j)], this.o[(i % k)], i1));
    paramZimuItemView.a(this.b, this.n[(i % m)], s[0]);
    i = a(i1 * this.j, paramZimuItemView.i());
    paramZimuItemView.a(this.e, i);
    paramZimuItemView.b(0L);
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
    return "pacman";
  }
  
  int i()
  {
    int i = this.h.size();
    int j = this.r.size();
    if (i < j)
    {
      i = j - i;
      if (i > 1)
      {
        i = this.q.nextInt(i * 10) % i;
        break label53;
      }
    }
    i = 0;
    label53:
    ZimuViewPacMan.RAILWAY localRAILWAY = (ZimuViewPacMan.RAILWAY)this.r.get(i);
    localRAILWAY.b += 1;
    this.r.remove(i);
    this.r.add(localRAILWAY);
    return localRAILWAY.a;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    int j = this.t.length;
    int i = 0;
    while (i < j)
    {
      Bitmap[] arrayOfBitmap = this.t;
      if (arrayOfBitmap[i] != null)
      {
        arrayOfBitmap[i].recycle();
        this.t[i] = null;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewPacMan
 * JD-Core Version:    0.7.0.1
 */