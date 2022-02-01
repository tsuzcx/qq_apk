package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Scroller;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Sentence;
import java.util.ArrayList;

public class LyricViewInternalSingleLine
  extends LyricViewInternalBase
{
  protected volatile boolean ah;
  
  public LyricViewInternalSingleLine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scrollToXPos() xoffset => ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",time => ");
    localStringBuilder.append(paramInt2);
    Log.d("LyricViewInternalSL", localStringBuilder.toString(), new Exception());
    if (this.ah)
    {
      paramInt1 -= this.w.getFinalX();
      if (paramInt1 != 0) {
        this.w.startScroll(this.w.getFinalX(), this.w.getFinalY(), paramInt1, 0, paramInt2);
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.H != paramInt1)
    {
      this.ah = false;
      scrollTo(0, 0);
      this.w.setFinalX(0);
    }
    super.a(paramInt1, paramInt2);
  }
  
  protected void a(Canvas paramCanvas, int paramInt)
  {
    if (this.K) {
      return;
    }
    Object localObject = this.u.mSentences;
    int k = ((ArrayList)localObject).size();
    int j = this.H;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = i;
    if (i >= k) {
      j = k - 1;
    }
    if (!((ArrayList)localObject).isEmpty())
    {
      k = paramInt + getAdJust();
      paramInt = ((ArrayList)localObject).size();
      if (this.C)
      {
        paramInt = this.F;
        i = this.G;
      }
      else
      {
        i = paramInt - 1;
        paramInt = 0;
      }
      if (j >= paramInt)
      {
        if (j > i) {
          return;
        }
        localObject = (Sentence)((ArrayList)localObject).get(j);
        if ((this.R) && (this.u.mType == 2) && (!this.ac))
        {
          a((Sentence)localObject, paramCanvas, k, 0);
          return;
        }
        paramInt = k;
        if (this.u.mType == 1)
        {
          i = (int)this.a.measureText(((Sentence)localObject).mText);
          if ((i > this.B + (getAdJust() >> 1)) && (this.B != -1))
          {
            paramInt = k;
            if (!this.ah)
            {
              this.ah = true;
              b(i - this.B, (int)((Sentence)localObject).mDuration);
              paramInt = k;
            }
          }
          else
          {
            paramInt = k;
            if (i > this.B) {
              paramInt = k - (i - this.B >> 1);
            }
          }
        }
        if (this.Z)
        {
          a((Sentence)localObject, paramCanvas, paramInt, 0, this.a, this.e, this.Z);
          return;
        }
        a((Sentence)localObject, paramCanvas, paramInt, 0, this.a);
      }
    }
  }
  
  public void computeScroll()
  {
    if ((this.w.computeScrollOffset()) && (this.ah))
    {
      scrollTo(this.w.getCurrX(), this.w.getCurrY());
      postInvalidate();
    }
    super.computeScroll();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = (View)((View)getParent()).getParent();
    int j = localView.getMeasuredWidth();
    int k = localView.getMeasuredHeight();
    if (this.K)
    {
      setMeasuredDimension(j, k);
      return;
    }
    if (this.x == 70)
    {
      if ((this.M == j) && (this.N))
      {
        setMeasuredDimension(j, this.A + k);
      }
      else
      {
        this.M = j;
        paramInt1 = j - (getAdJust() << 1);
        this.B = paramInt1;
        if (this.u.mType == 1) {
          this.u.generateUiLyricLineList(this.b, this.a, paramInt1, true);
        } else {
          this.u.generateUiLyricLineList(this.b, this.a, paramInt1);
        }
        if (this.u.mType == 2)
        {
          a(LyricViewHelper.a(this.u), null);
          this.u.generateUiLyricLineList(this.b, this.a, paramInt1);
        }
        this.N = true;
      }
      paramInt1 = 0;
      int m = this.m;
      int n = this.n;
      if (this.C)
      {
        if (this.G >= this.u.mSentences.size())
        {
          Log.e("LyricViewInternalSL", "onMeasure -> mSongEndLine error");
          this.G = (this.u.size() - 1);
        }
        int i = this.F;
        for (;;)
        {
          paramInt2 = paramInt1;
          if (i > this.G) {
            break;
          }
          paramInt2 = paramInt1;
          if (this.u.mSentences.get(i) != null) {
            paramInt2 = paramInt1 + ((Sentence)this.u.mSentences.get(i)).getUiLineSize();
          }
          paramInt1 = paramInt2;
          if (this.P)
          {
            paramInt1 = paramInt2;
            if (this.v != null)
            {
              paramInt1 = paramInt2;
              if (this.u.size() == this.v.size())
              {
                paramInt1 = paramInt2;
                if (this.v.mSentences.get(i) != null) {
                  paramInt1 = paramInt2 + ((Sentence)this.u.mSentences.get(i)).getUiLineSize();
                }
              }
            }
          }
          i += 1;
        }
      }
      paramInt1 = this.u.getUILineSize();
      paramInt2 = paramInt1;
      if (this.P)
      {
        paramInt2 = paramInt1;
        if (this.v != null)
        {
          paramInt2 = paramInt1;
          if (this.u.size() == this.v.size()) {
            paramInt2 = paramInt1 + this.v.getUILineSize();
          }
        }
      }
      this.A = (paramInt2 * (m + n));
      setMeasuredDimension(j, this.A + k);
      return;
    }
    setMeasuredDimension(j, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewInternalSingleLine
 * JD-Core Version:    0.7.0.1
 */