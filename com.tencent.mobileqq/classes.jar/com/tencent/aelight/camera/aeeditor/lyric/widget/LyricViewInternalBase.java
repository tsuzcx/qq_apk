package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.LyricCharacter;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Sentence;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.SentenceAttachInfo;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.SentenceUI;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class LyricViewInternalBase
  extends View
  implements LyricBaseInternalViewInterface
{
  protected int A = 3500;
  protected int B = -1;
  protected volatile boolean C;
  protected int D = -1;
  protected int E = -1;
  protected int F = 0;
  protected int G = 0;
  protected int H = 0;
  protected int I = 0;
  protected volatile int J = 0;
  protected volatile boolean K = true;
  protected volatile boolean L;
  protected int M;
  protected volatile boolean N;
  protected int O;
  protected volatile boolean P;
  protected volatile int Q = 0;
  protected volatile boolean R;
  protected volatile boolean S;
  protected int T = -1;
  protected int U;
  protected int V = -1;
  protected volatile boolean W;
  protected boolean Z = true;
  protected final Paint a = new Paint();
  protected int aa = 0;
  protected int ab = 0;
  protected boolean ac;
  protected Paint ad = new Paint();
  protected Paint ae = new Paint();
  Bitmap af = null;
  Context ag;
  protected final Paint b = new Paint();
  protected final Paint c = new Paint();
  protected final Paint d = new Paint();
  protected final Paint e = new Paint();
  protected final Paint f = new Paint();
  protected final String g;
  public int h;
  public boolean i;
  protected int j;
  protected int k;
  protected boolean l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  protected Lyric u;
  protected Lyric v;
  protected Scroller w;
  protected int x = 0;
  protected final Handler y = new LyricViewInternalBase.1(this, Looper.getMainLooper());
  protected int z = -1;
  
  public LyricViewInternalBase(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"NewApi"})
  public LyricViewInternalBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ag = paramContext;
    this.g = "";
    this.w = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
  }
  
  protected static boolean a(Lyric paramLyric)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLyric != null)
    {
      bool1 = bool2;
      if (paramLyric.mType == 2)
      {
        bool1 = bool2;
        if (paramLyric.mSentences != null)
        {
          paramLyric = paramLyric.mSentences.iterator();
          while (paramLyric.hasNext())
          {
            Sentence localSentence = (Sentence)paramLyric.next();
            bool1 = bool2;
            if (localSentence.mCharacters == null) {
              return bool1;
            }
            bool1 = bool2;
            if (localSentence.mCharacters.size() != 1) {
              return bool1;
            }
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(Lyric paramLyric1, Lyric paramLyric2)
  {
    if (paramLyric1 != null)
    {
      b();
      Lyric localLyric = new Lyric(2, 0, null);
      localLyric.copy(paramLyric1);
      this.u = localLyric;
      if ((paramLyric2 != null) && (paramLyric1.size() == paramLyric2.size()))
      {
        paramLyric1 = new Lyric(2, 0, null);
        paramLyric1.copy(paramLyric2);
        this.v = paramLyric1;
      }
      else
      {
        this.v = new Lyric(2, 0, null);
      }
      setState(70);
      return;
    }
    setState(40);
    this.u = new Lyric(2, 0, null);
    this.v = new Lyric(2, 0, null);
  }
  
  public int a(int paramInt)
  {
    paramInt = this.H;
    this.L = false;
    return paramInt;
  }
  
  protected int a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = paramSentence.getUILyricLineList();
    if (paramBoolean) {
      paramSentence = this.b;
    } else {
      paramSentence = this.a;
    }
    int i2 = this.m;
    int i3 = this.n;
    int i1 = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < localArrayList.size())
    {
      ((SentenceUI)localArrayList.get(paramInt2)).paint(paramCanvas, paramInt1, i1 + this.n, paramSentence, paramBoolean);
      i1 += i2 + i3;
      paramInt2 += 1;
    }
    return i1;
  }
  
  public abstract void a();
  
  public void a(int paramInt1, int paramInt2)
  {
    this.H = paramInt1;
    this.I = paramInt2;
    a();
    postInvalidate();
  }
  
  protected void a(Canvas paramCanvas, int paramInt) {}
  
  protected void a(Canvas paramCanvas, Paint paramPaint, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("drawString -> str:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", y:");
    ((StringBuilder)localObject).append(paramInt2);
    Log.d("ModuleLyricViewInternal", ((StringBuilder)localObject).toString());
    localObject = new Rect();
    paramString = paramString.split("\n");
    int i2 = this.n;
    int i1 = 0;
    while (i1 < paramString.length)
    {
      int i3 = getWidth();
      int i4 = (int)this.a.measureText(paramString[i1]);
      paramCanvas.drawText(paramString[i1], (i3 - i4 >> 1) + paramInt1, paramInt2 + i2, paramPaint);
      paramPaint.getTextBounds(paramString[i1], 0, paramString[i1].length(), (Rect)localObject);
      i2 += ((Rect)localObject).height() + 20;
      i1 += 1;
    }
  }
  
  public void a(LyricViewAttribute paramLyricViewAttribute)
  {
    this.u = new Lyric(2, 0, null);
    this.v = new Lyric(2, 0, null);
    this.o = paramLyricViewAttribute.j;
    this.m = paramLyricViewAttribute.d;
    this.n = paramLyricViewAttribute.i;
    this.q = paramLyricViewAttribute.e;
    this.r = paramLyricViewAttribute.f;
    this.s = paramLyricViewAttribute.g;
    this.p = paramLyricViewAttribute.h;
    this.k = paramLyricViewAttribute.b;
    this.j = paramLyricViewAttribute.a;
    this.l = paramLyricViewAttribute.c;
    this.R = paramLyricViewAttribute.l;
    this.h = paramLyricViewAttribute.m;
    this.i = paramLyricViewAttribute.n;
    this.W = paramLyricViewAttribute.o;
    this.V = paramLyricViewAttribute.k;
    this.c.setAntiAlias(true);
    this.c.setTextSize(this.q);
    this.c.setColor(this.s);
    this.d.setAntiAlias(true);
    this.d.setTextSize(this.q);
    this.d.setColor(this.r);
    this.b.setAntiAlias(true);
    this.b.setTextSize(this.q);
    this.b.setColor(this.r);
    this.b.setFakeBoldText(this.W);
    this.a.setAntiAlias(true);
    this.a.setTextSize(this.j);
    this.a.setColor(this.k);
    this.a.setFakeBoldText(this.l);
    this.e.setAntiAlias(true);
    this.e.setTextSize(this.j);
    this.e.setFakeBoldText(this.l);
    this.e.setStrokeWidth(1.0F);
    this.e.setColor(0);
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setAlpha(19);
    this.f.setAntiAlias(true);
    this.f.setTextSize(this.q);
    this.f.setColor(0);
    this.f.setStrokeWidth(2.0F);
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setAlpha(19);
    this.ad.setColor(paramLyricViewAttribute.r);
    this.ad.setStyle(Paint.Style.FILL);
    this.ae.setColor(paramLyricViewAttribute.p);
    this.ae.setTextSize(paramLyricViewAttribute.q);
    this.ad.setColor(paramLyricViewAttribute.r);
    this.t = paramLyricViewAttribute.s;
  }
  
  protected void a(Lyric paramLyric1, Lyric paramLyric2)
  {
    try
    {
      boolean bool = this.C;
      int i1 = this.D;
      int i2 = this.E;
      b(paramLyric1, paramLyric2);
      if (bool) {
        setSegment(i1, i2);
      }
      return;
    }
    finally {}
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        localObject1 = paramSentence.getUILyricLineList();
        i1 = ((ArrayList)localObject1).size();
        i8 = this.I;
        localPaint = this.b;
        if ((!this.S) || (paramSentence.mNormalLeftAttachInfo == null)) {
          continue;
        }
        localPaint.setColor(paramSentence.mNormalLeftAttachInfo.mSentenceColor);
      }
      finally
      {
        Object localObject1;
        int i1;
        int i8;
        Paint localPaint;
        SentenceUI localSentenceUI;
        ArrayList localArrayList;
        int i9;
        int i6;
        int i5;
        long l1;
        long l2;
        int i2;
        LyricCharacter localLyricCharacter;
        float f1;
        int i7;
        float f5;
        float f4;
        continue;
        throw paramSentence;
        continue;
        int i4 = paramInt2;
        int i3 = 0;
        paramSentence = localStringIndexOutOfBoundsException1;
        paramInt2 = i1;
        continue;
        continue;
        Object localObject2 = null;
        continue;
        float f2 = f1;
        float f3 = f1;
        continue;
        continue;
      }
      if (i3 >= paramInt2) {
        continue;
      }
      localSentenceUI = (SentenceUI)paramSentence.get(i3);
      if ((localSentenceUI.mCharacters != null) && (localSentenceUI.mCharacters.size() > 0))
      {
        localArrayList = localSentenceUI.mCharacters;
        i9 = localArrayList.size();
        i6 = localSentenceUI.mText.length();
        if (i3 == 0) {
          i5 = this.n;
        } else {
          i5 = this.o;
        }
        if (!this.Z) {
          continue;
        }
        localSentenceUI.drawLyricContour(paramCanvas, paramInt1, i4 + i5, this.f, true);
        l1 = localSentenceUI.mStartTime;
        l2 = i8;
        if ((l1 <= l2) && (localSentenceUI.mEndTime >= l2))
        {
          i1 = 0;
          localObject1 = null;
          i2 = 0;
          f3 = 0.0F;
          if (i1 < i9)
          {
            localObject1 = (LyricCharacter)localArrayList.get(i1);
            if (i1 >= i9 - 1) {
              continue;
            }
            localLyricCharacter = (LyricCharacter)localArrayList.get(i1 + 1);
            if ((((LyricCharacter)localObject1).mStartTime <= l2) && (localLyricCharacter != null) && (localLyricCharacter.mStartTime > l2))
            {
              f1 = (float)(l2 - ((LyricCharacter)localObject1).mStartTime) / (float)((LyricCharacter)localObject1).mDuration;
              continue;
            }
            if ((((LyricCharacter)localObject1).mStartTime <= l2) && (((LyricCharacter)localObject1).mStartTime + ((LyricCharacter)localObject1).mDuration >= l2))
            {
              f1 = (float)(l2 - ((LyricCharacter)localObject1).mStartTime);
              l1 = ((LyricCharacter)localObject1).mDuration;
              f1 /= (float)l1;
              continue;
            }
            i7 = i1 + 1;
            i2 = i1;
            i1 = i7;
            continue;
          }
          i1 = i2;
          f2 = 0.0F;
          if (localObject1 == null) {
            continue;
          }
          f5 = paramInt1;
          f4 = f5;
          if (i1 != 0) {
            i2 = i1 - 1;
          }
        }
      }
      try
      {
        if (i6 >= ((LyricCharacter)localArrayList.get(i2)).mEnd) {
          f1 = this.b.measureText(localSentenceUI.mText.substring(0, ((LyricCharacter)localArrayList.get(i2)).mEnd));
        } else {
          f1 = this.b.measureText(localSentenceUI.mText.substring(0, i6));
        }
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException2)
      {
        continue;
      }
      f1 = this.b.measureText(localSentenceUI.mText.substring(0, i6));
      f4 = f5 + f1;
      if (i1 == i9 - 1) {}
      try
      {
        f1 = this.d.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, i6));
        continue;
        if (localSentenceUI.mText.length() >= ((LyricCharacter)localObject1).mEnd) {
          f1 = this.d.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, ((LyricCharacter)localObject1).mEnd));
        } else {
          f1 = this.d.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, i6));
        }
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException1)
      {
        continue;
      }
      f1 = this.d.measureText(localSentenceUI.mText.substring(0, i6));
      i2 = localPaint.getColor();
      i6 = this.c.getColor();
      localSentenceUI.paint(paramCanvas, paramInt1, i4 + i5, this.c, localPaint, this.d, i1, f1, f4, new int[] { i2, i6 }, new float[] { f3, f2 });
      continue;
      if (localSentenceUI.getEndTime() < l2) {
        localSentenceUI.paint(paramCanvas, paramInt1, i4 + i5, localPaint, true);
      } else {
        localSentenceUI.paint(paramCanvas, paramInt1, i4 + i5, this.c, true);
      }
      i1 = this.p;
      i4 += i5 + i1;
      i3 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramSentence = paramSentence.getUILyricLineList();
    int i3 = this.m;
    int i4 = this.n;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramSentence.size())
    {
      ((SentenceUI)paramSentence.get(paramInt2)).paint(paramCanvas, paramInt1, i1 + this.n, paramPaint, false);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, boolean paramBoolean)
  {
    paramSentence = paramSentence.getUILyricLineList();
    int i3 = this.m;
    int i4 = this.n;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramSentence.size())
    {
      ((SentenceUI)paramSentence.get(paramInt2)).paintWithContour(paramCanvas, paramInt1, i1 + this.n, paramPaint1, paramPaint2, paramBoolean);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  public int b(int paramInt)
  {
    this.L = true;
    return this.H;
  }
  
  public void b()
  {
    this.C = false;
    this.D = -1;
    this.E = -1;
    this.F = 0;
    this.G = 0;
    this.N = false;
  }
  
  protected int c(int paramInt)
  {
    return 0;
  }
  
  protected void c()
  {
    this.c.setColor(this.s);
    this.b.setColor(this.r);
    this.a.setColor(this.k);
  }
  
  public void d()
  {
    this.N = false;
    this.y.sendEmptyMessage(0);
  }
  
  protected int getAdJust()
  {
    if (this.z == -1) {
      this.z = this.V;
    }
    return this.z;
  }
  
  public int getEndScrollY()
  {
    return 0;
  }
  
  public Lyric getLyric()
  {
    return this.u;
  }
  
  public Lyric getMeasuredLyric()
  {
    return this.u;
  }
  
  public int getTopScroll()
  {
    return this.J;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.x != 70)
    {
      if (this.g != null)
      {
        scrollTo(0, 0);
        this.w.setFinalX(0);
        a(paramCanvas, this.a, this.g, 0, this.t);
      }
    }
    else {
      a(paramCanvas, 0);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = (View)((View)getParent()).getParent();
    int i2 = ((View)localObject).getMeasuredWidth();
    int i3 = ((View)localObject).getMeasuredHeight();
    if (this.x == 70)
    {
      paramInt1 = i2 - (getAdJust() << 1);
      paramInt2 = 0;
      int i4 = this.m;
      int i5 = this.n;
      if (this.i) {
        this.u.generateUiLyricLineList(this.b, this.a, paramInt1, false, true);
      } else {
        this.u.generateUiLyricLineList(this.b, this.a, paramInt1);
      }
      if ((this.v != null) && (this.u.size() == this.v.size())) {
        if (this.i) {
          this.v.generateUiLyricLineList(this.b, this.a, paramInt1, false, true);
        } else {
          this.v.generateUiLyricLineList(this.b, this.a, paramInt1);
        }
      }
      int i1;
      if (this.C)
      {
        i1 = this.F;
        for (;;)
        {
          paramInt1 = paramInt2;
          if (i1 > this.G) {
            break;
          }
          paramInt1 = paramInt2;
          if (this.u.mSentences.get(i1) != null) {
            paramInt1 = paramInt2 + ((Sentence)this.u.mSentences.get(i1)).getUiLineSize();
          }
          i1 += 1;
          paramInt2 = paramInt1;
        }
      }
      paramInt1 = this.u.getUILineSize();
      paramInt2 = paramInt1;
      if (this.P)
      {
        localObject = this.v;
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt2 = paramInt1;
          if (((Lyric)localObject).mSentences != null)
          {
            if (this.C)
            {
              i1 = this.F;
              for (;;)
              {
                paramInt2 = paramInt1;
                if (i1 > this.G) {
                  break;
                }
                paramInt2 = paramInt1;
                if (i1 < this.v.mSentences.size()) {
                  if (i1 < 0) {
                    paramInt2 = paramInt1;
                  } else {
                    paramInt2 = paramInt1 + ((Sentence)this.v.mSentences.get(i1)).getUiLineSize();
                  }
                }
                i1 += 1;
                paramInt1 = paramInt2;
              }
            }
            paramInt2 = paramInt1 + this.v.getUILineSize();
          }
        }
      }
      this.A = (paramInt2 * (i4 + i5));
      this.U = (i3 / (this.n + this.m) + 1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMeasure -> Show line count:");
      ((StringBuilder)localObject).append(this.U);
      Log.d("ModuleLyricViewInternal", ((StringBuilder)localObject).toString());
      setMeasuredDimension(i2, this.A + i3);
      return;
    }
    setMeasuredDimension(i2, i3);
  }
  
  public void setEffectEnable(boolean paramBoolean)
  {
    this.Z = paramBoolean;
    invalidate();
  }
  
  public void setLeftAlign(boolean paramBoolean)
  {
    this.i = paramBoolean;
    d();
  }
  
  public void setLineHeight(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setLyric(Lyric paramLyric1, Lyric paramLyric2)
  {
    Log.d("ModuleLyricViewInternal", "setLyric begin");
    this.K = true;
    c();
    this.N = false;
    if (paramLyric1 != null)
    {
      b();
      Lyric localLyric = new Lyric(2, 0, null);
      localLyric.copy(paramLyric1);
      this.u = localLyric;
      if ((paramLyric2 != null) && (paramLyric1.size() == paramLyric2.size()))
      {
        paramLyric1 = new Lyric(2, 0, null);
        paramLyric1.copy(paramLyric2);
        this.v = paramLyric1;
      }
      else
      {
        Log.w("ModuleLyricViewInternal", "setLyric -> pronounce lyric is empty or has incorrect lines");
        this.v = new Lyric(2, 0, null);
      }
      this.ac = a(this.u);
      paramLyric1 = new StringBuilder();
      paramLyric1.append("setLyric -> is special qrc:");
      paramLyric1.append(this.ac);
      Log.w("ModuleLyricViewInternal", paramLyric1.toString());
      setState(70);
    }
    else
    {
      Log.w("ModuleLyricViewInternal", "setLyric -> lyric is null");
      setState(40);
    }
    this.K = false;
    Log.d("ModuleLyricViewInternal", "setLyric end");
  }
  
  public void setLyricPadding(int paramInt)
  {
    this.V = paramInt;
    d();
  }
  
  public void setMode(int paramInt)
  {
    this.Q = paramInt;
  }
  
  public void setSegment(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 > paramInt1))
    {
      Lyric localLyric = this.u;
      if ((localLyric != null) && (!localLyric.isEmpty()))
      {
        if ((this.D == paramInt1) && (this.E == paramInt2))
        {
          Log.d("ModuleLyricViewInternal", "setSegment -> same start and end");
          return;
        }
        this.D = paramInt1;
        this.E = paramInt2;
        this.F = this.u.findLineNoByStartTime(paramInt1);
        this.G = this.u.findEndLineByStartTime(paramInt2);
        if ((this.F >= 0) && (this.G >= 0))
        {
          this.C = true;
          this.N = false;
          return;
        }
        Log.e("ModuleLyricViewInternal", "setSegment -> lyric line number is illegal");
        this.C = false;
        return;
      }
      Log.e("ModuleLyricViewInternal", "setSegment -> lyric is empty");
      return;
    }
    Log.e("ModuleLyricViewInternal", "setSegment -> the time of lyric is illegal");
  }
  
  public void setState(int paramInt)
  {
    this.x = paramInt;
    this.y.sendEmptyMessage(0);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    Paint localPaint = this.a;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
    localPaint = this.b;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
    localPaint = this.c;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
    localPaint = this.d;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
    localPaint = this.e;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
    localPaint = this.f;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewInternalBase
 * JD-Core Version:    0.7.0.1
 */