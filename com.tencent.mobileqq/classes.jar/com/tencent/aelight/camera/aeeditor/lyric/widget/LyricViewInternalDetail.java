package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.LyricCharacter;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.SentenceAttachInfo;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.SentenceUI;
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
    Object localObject = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric;
    int k = 0;
    if ((localObject != null) && (!this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.isEmpty()))
    {
      int j = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.size() - 1;
      int i;
      if (this.jdField_c_of_type_Boolean)
      {
        i = this.r;
        j = this.s;
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
        m = ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i)).getUiLineSize();
        k += this.jdField_d_of_type_Int * m + this.e * (m - 1) + this.e;
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
    paramInt = d(paramInt + this.jdField_d_of_type_Int);
    postInvalidate();
    return paramInt;
  }
  
  public void a()
  {
    if (this.jdField_l_of_type_Int != 70) {
      return;
    }
    int k = this.jdField_d_of_type_Int;
    int m = this.e;
    int n = this.t;
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences;
    if (localArrayList == null) {
      return;
    }
    int j = localArrayList.size() - 1;
    if (this.jdField_c_of_type_Boolean)
    {
      i = this.r;
      j = this.s;
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
    int i = this.A;
    if (this.z > 0) {
      if (this.z < this.A) {
        i = this.z;
      } else {
        i = this.A;
      }
    }
    this.v = (this.jdField_k_of_type_Int + (k + m) * (j - (int)(i * 0.3F) + 1));
    if (this.v < 0) {
      this.v = 0;
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt)
  {
    this.jdField_k_of_type_Int = ((int)(((View)((View)getParent()).getParent()).getMeasuredHeight() * 0.3F) + this.jdField_d_of_type_Int / 2);
    int m = this.jdField_d_of_type_Int;
    int n = this.e;
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences;
    int i1 = localArrayList.size();
    int j = this.t;
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
      int i2 = paramInt + c();
      int k = this.jdField_k_of_type_Int;
      i = 0;
      while (i <= i1 - 1)
      {
        Sentence localSentence = (Sentence)localArrayList.get(i);
        if (i == j)
        {
          if ((this.h) && (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mType == 2) && (!this.jdField_l_of_type_Boolean))
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
          a(localSentence, paramCanvas, i2, k, this.jdField_a_of_type_AndroidGraphicsPaint);
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
    this.x = ((this.jdField_d_of_type_Int + this.e) * 2);
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        localObject1 = paramSentence.getUILyricLineList();
        i = ((ArrayList)localObject1).size();
        i3 = this.u;
        localPaint = this.b;
        if ((!this.i) || (paramSentence.mNormalLeftAttachInfo == null)) {
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
          n = this.e;
          continue;
        }
        n = this.e + this.jdField_f_of_type_Int;
        continue;
        if (!this.jdField_k_of_type_Boolean) {
          continue;
        }
        localSentenceUI.drawLyricContour(paramCanvas, paramInt1, m + n, this.jdField_f_of_type_AndroidGraphicsPaint, true);
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
        f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, i1));
        continue;
        if (localSentenceUI.mText.length() >= ((LyricCharacter)localObject1).mEnd) {
          f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, ((LyricCharacter)localObject1).mEnd));
        } else {
          f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, i1));
        }
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException1)
      {
        continue;
      }
      f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(0, i1));
      j = localPaint.getColor();
      i1 = this.jdField_c_of_type_AndroidGraphicsPaint.getColor();
      localSentenceUI.paint(paramCanvas, paramInt1, m + n, this.jdField_c_of_type_AndroidGraphicsPaint, localPaint, this.jdField_d_of_type_AndroidGraphicsPaint, i, f1, f4, new int[] { j, i1 }, new float[] { f3, f2 });
      continue;
      if (localSentenceUI.getEndTime() < l2) {
        localSentenceUI.paint(paramCanvas, paramInt1, m + n, localPaint, true);
      } else {
        localSentenceUI.paint(paramCanvas, paramInt1, m + n, this.jdField_c_of_type_AndroidGraphicsPaint, true);
      }
      i = this.g;
      m += n + i;
      k += 1;
    }
  }
  
  public int b()
  {
    int i = this.jdField_l_of_type_Int;
    int j = 0;
    if (i != 70) {
      return 0;
    }
    int m = this.jdField_d_of_type_Int;
    int n = this.e;
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences;
    if (localArrayList == null) {
      return 0;
    }
    i = localArrayList.size();
    int k;
    if (this.jdField_c_of_type_Boolean)
    {
      i = this.r;
      k = this.s;
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
    i = this.A;
    if (this.z > 0) {
      if (this.z < this.A) {
        i = this.z;
      } else {
        i = this.A;
      }
    }
    return this.jdField_k_of_type_Int + (m + n) * (j - (int)(i * 0.3F) + 1);
  }
  
  public int b(int paramInt)
  {
    super.b(paramInt);
    paramInt = d(paramInt + this.jdField_d_of_type_Int);
    postInvalidate();
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewInternalDetail
 * JD-Core Version:    0.7.0.1
 */