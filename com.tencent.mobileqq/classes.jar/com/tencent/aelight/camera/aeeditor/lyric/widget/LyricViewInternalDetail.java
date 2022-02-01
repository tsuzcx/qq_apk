package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.LyricCharacter;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Sentence;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.SentenceAttachInfo;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.SentenceUI;
import java.util.ArrayList;

public class LyricViewInternalDetail
  extends LyricViewInternalBase
{
  public LyricViewInternalDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int d(int paramInt)
  {
    Object localObject = this.u;
    int k = 0;
    if ((localObject != null) && (!this.u.isEmpty()))
    {
      int j = this.u.size() - 1;
      int i;
      if (this.C)
      {
        i = this.F;
        j = this.G;
      }
      else
      {
        i = 0;
      }
      int m;
      for (;;)
      {
        m = j;
        if (i > j) {
          break;
        }
        m = ((Sentence)this.u.mSentences.get(i)).getUiLineSize();
        k += this.m * m + this.n * (m - 1) + this.n;
        if (paramInt < k)
        {
          m = i;
          break;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("computeHilightWhileScrolling() y => ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",position => ");
      ((StringBuilder)localObject).append(m);
      AEQLog.a("LyricViewInternalDetail", ((StringBuilder)localObject).toString());
      return m;
    }
    Log.e("LyricViewInternalDetail", "computeHilightWhileScrolling -> mLineLyric == null");
    return 0;
  }
  
  public int a(int paramInt)
  {
    super.a(paramInt);
    paramInt = d(paramInt + this.m);
    postInvalidate();
    return paramInt;
  }
  
  public void a()
  {
    if (this.x != 70) {
      return;
    }
    int k = this.m;
    int m = this.n;
    int n = this.H;
    ArrayList localArrayList = this.u.mSentences;
    if (localArrayList == null) {
      return;
    }
    int j = localArrayList.size() - 1;
    if (this.C)
    {
      i = this.F;
      j = this.G;
    }
    else
    {
      i = 0;
    }
    if (n > j) {
      return;
    }
    j = 0;
    while (i < n)
    {
      j += ((Sentence)localArrayList.get(i)).getUiLineSize();
      i += 1;
    }
    int i = this.U;
    if (this.T > 0) {
      if (this.T < this.U) {
        i = this.T;
      } else {
        i = this.U;
      }
    }
    this.J = (this.t + (k + m) * (j - (int)(i * 0.3F) + 1));
    if (this.J < 0) {
      this.J = 0;
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt)
  {
    this.t = ((int)(((View)((View)getParent()).getParent()).getMeasuredHeight() * 0.3F) + this.m / 2);
    int m = this.m;
    int n = this.n;
    ArrayList localArrayList = this.u.mSentences;
    int i1 = localArrayList.size();
    int j = this.H;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = i;
    if (i >= i1) {
      j = i1 - 1;
    }
    if (!localArrayList.isEmpty())
    {
      int i2 = paramInt + getAdJust();
      int k = this.t;
      i = 0;
      while (i <= i1 - 1)
      {
        Sentence localSentence = (Sentence)localArrayList.get(i);
        if (i == j)
        {
          if ((this.R) && (this.u.mType == 2) && (!this.ac))
          {
            a(localSentence, paramCanvas, i2, k);
            paramInt = localSentence.getUiLineSize();
          }
          else
          {
            a(localSentence, paramCanvas, i2, k, true);
            paramInt = localSentence.getUiLineSize();
          }
        }
        else
        {
          a(localSentence, paramCanvas, i2, k, this.a);
          paramInt = localSentence.getUiLineSize();
        }
        k += paramInt * (m + n);
        i += 1;
      }
    }
  }
  
  public void a(LyricViewAttribute paramLyricViewAttribute)
  {
    super.a(paramLyricViewAttribute);
    this.O = ((this.m + this.n) * 2);
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        localObject1 = paramSentence.getUILyricLineList();
        i = ((ArrayList)localObject1).size();
        i3 = this.I;
        localPaint = this.b;
        if ((!this.S) || (paramSentence.mNormalLeftAttachInfo == null)) {
          continue;
        }
        localPaint.setColor(paramSentence.mNormalLeftAttachInfo.mSentenceColor);
      }
      finally
      {
        Object localObject1;
        int i;
        int i3;
        Paint localPaint;
        SentenceUI localSentenceUI;
        ArrayList localArrayList;
        int i4;
        int i1;
        int n;
        long l1;
        long l2;
        int j;
        LyricCharacter localLyricCharacter;
        float f1;
        int i2;
        float f5;
        float f4;
        continue;
        throw paramSentence;
        continue;
        int m = paramInt2;
        int k = 0;
        paramSentence = localStringIndexOutOfBoundsException1;
        paramInt2 = i;
        continue;
        continue;
        continue;
        Object localObject2 = null;
        continue;
        float f2 = f1;
        float f3 = f1;
        continue;
        continue;
      }
      if (k >= paramInt2) {
        continue;
      }
      localSentenceUI = (SentenceUI)paramSentence.get(k);
      if ((localSentenceUI.mCharacters != null) && (localSentenceUI.mCharacters.size() > 0))
      {
        localArrayList = localSentenceUI.mCharacters;
        i4 = localArrayList.size();
        i1 = localSentenceUI.mText.length();
        if (k == 0)
        {
          n = this.n;
          continue;
        }
        n = this.n + this.o;
        continue;
        if (!this.Z) {
          continue;
        }
        localSentenceUI.drawLyricContour(paramCanvas, paramInt1, m + n, this.f, true);
        l1 = localSentenceUI.mStartTime;
        l2 = i3;
        if ((l1 <= l2) && (localSentenceUI.mEndTime >= l2))
        {
          i = 0;
          localObject1 = null;
          j = 0;
          f3 = 0.0F;
          if (i < i4)
          {
            localObject1 = (LyricCharacter)localArrayList.get(i);
            if (i >= i4 - 1) {
              continue;
            }
            localLyricCharacter = (LyricCharacter)localArrayList.get(i + 1);
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
            i2 = i + 1;
            j = i;
            i = i2;
            continue;
          }
          i = j;
          f2 = 0.0F;
          if (localObject1 == null) {
            continue;
          }
          f5 = paramInt1;
          f4 = f5;
          if (i != 0) {
            j = i - 1;
          }
        }
      }
      try
      {
        if (i1 >= ((LyricCharacter)localArrayList.get(j)).mEnd) {
          f1 = this.b.measureText(localSentenceUI.mText.substring(0, ((LyricCharacter)localArrayList.get(j)).mEnd));
        } else {
          f1 = this.b.measureText(localSentenceUI.mText.substring(0, i1));
        }
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException2)
      {
        continue;
      }
      f1 = this.b.measureText(localSentenceUI.mText.substring(0, i1));
      f4 = f5 + f1;
      if (i == i4 - 1) {}
      try
      {
        f1 = this.d.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, i1));
        continue;
        if (localSentenceUI.mText.length() >= ((LyricCharacter)localObject1).mEnd) {
          f1 = this.d.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, ((LyricCharacter)localObject1).mEnd));
        } else {
          f1 = this.d.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, i1));
        }
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException1)
      {
        continue;
      }
      f1 = this.d.measureText(localSentenceUI.mText.substring(0, i1));
      j = localPaint.getColor();
      i1 = this.c.getColor();
      localSentenceUI.paint(paramCanvas, paramInt1, m + n, this.c, localPaint, this.d, i, f1, f4, new int[] { j, i1 }, new float[] { f3, f2 });
      continue;
      if (localSentenceUI.getEndTime() < l2) {
        localSentenceUI.paint(paramCanvas, paramInt1, m + n, localPaint, true);
      } else {
        localSentenceUI.paint(paramCanvas, paramInt1, m + n, this.c, true);
      }
      i = this.p;
      m += n + i;
      k += 1;
    }
  }
  
  public int b(int paramInt)
  {
    super.b(paramInt);
    paramInt = d(paramInt + this.m);
    postInvalidate();
    return paramInt;
  }
  
  public int getEndScrollY()
  {
    int i = this.x;
    int j = 0;
    if (i != 70) {
      return 0;
    }
    int m = this.m;
    int n = this.n;
    ArrayList localArrayList = this.u.mSentences;
    if (localArrayList == null) {
      return 0;
    }
    i = localArrayList.size();
    int k;
    if (this.C)
    {
      i = this.F;
      k = this.G;
    }
    else
    {
      k = i - 1;
      i = 0;
    }
    while (i < k)
    {
      j += ((Sentence)localArrayList.get(i)).getUiLineSize();
      i += 1;
    }
    i = this.U;
    if (this.T > 0) {
      if (this.T < this.U) {
        i = this.T;
      } else {
        i = this.U;
      }
    }
    return this.t + (m + n) * (j - (int)(i * 0.3F) + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewInternalDetail
 * JD-Core Version:    0.7.0.1
 */