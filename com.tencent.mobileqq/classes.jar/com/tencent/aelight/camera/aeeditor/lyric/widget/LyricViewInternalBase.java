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
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.LyricCharacter;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.SentenceAttachInfo;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.SentenceUI;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class LyricViewInternalBase
  extends View
  implements LyricBaseInternalViewInterface
{
  protected int A;
  protected int B = -1;
  protected int C = 0;
  protected int D = 0;
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  protected final Paint a;
  protected final Handler a;
  protected Scroller a;
  protected Lyric a;
  protected final String a;
  public boolean a;
  protected int b;
  protected final Paint b;
  protected Lyric b;
  protected boolean b;
  protected int c;
  protected final Paint c;
  protected volatile boolean c;
  protected int d;
  protected final Paint d;
  protected volatile boolean d;
  protected int e;
  protected final Paint e;
  protected volatile boolean e;
  protected int f;
  protected final Paint f;
  protected volatile boolean f;
  protected int g;
  protected Paint g;
  protected volatile boolean g;
  protected int h;
  protected Paint h;
  protected volatile boolean h;
  protected int i;
  protected volatile boolean i;
  protected int j;
  protected volatile boolean j;
  protected int k;
  protected boolean k;
  protected int l;
  protected boolean l;
  protected int m = -1;
  protected int n = 3500;
  protected int o = -1;
  protected int p = -1;
  protected int q = -1;
  protected int r = 0;
  protected int s = 0;
  protected int t = 0;
  protected int u = 0;
  protected volatile int v = 0;
  protected int w;
  protected int x;
  protected volatile int y = 0;
  protected int z = -1;
  
  public LyricViewInternalBase(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"NewApi"})
  public LyricViewInternalBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_f_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new LyricViewInternalBase.1(this, Looper.getMainLooper());
    this.jdField_d_of_type_Boolean = true;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_g_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_h_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
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
      this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = localLyric;
      if ((paramLyric2 != null) && (paramLyric1.size() == paramLyric2.size()))
      {
        paramLyric1 = new Lyric(2, 0, null);
        paramLyric1.copy(paramLyric2);
        this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = paramLyric1;
      }
      else
      {
        this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null);
      }
      setState(70);
      return;
    }
    setState(40);
    this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null);
    this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null);
  }
  
  public int a()
  {
    return this.v;
  }
  
  public int a(int paramInt)
  {
    paramInt = this.t;
    this.jdField_e_of_type_Boolean = false;
    return paramInt;
  }
  
  protected int a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = paramSentence.getUILyricLineList();
    if (paramBoolean) {
      paramSentence = this.jdField_b_of_type_AndroidGraphicsPaint;
    } else {
      paramSentence = this.jdField_a_of_type_AndroidGraphicsPaint;
    }
    int i2 = this.jdField_d_of_type_Int;
    int i3 = this.jdField_e_of_type_Int;
    int i1 = paramInt2;
    paramInt2 = 0;
    while (paramInt2 < localArrayList.size())
    {
      ((SentenceUI)localArrayList.get(paramInt2)).paint(paramCanvas, paramInt1, i1 + this.jdField_e_of_type_Int, paramSentence, paramBoolean);
      i1 += i2 + i3;
      paramInt2 += 1;
    }
    return i1;
  }
  
  public Lyric a()
  {
    return this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric;
  }
  
  public abstract void a();
  
  public void a(int paramInt1, int paramInt2)
  {
    this.t = paramInt1;
    this.u = paramInt2;
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
    int i2 = this.jdField_e_of_type_Int;
    int i1 = 0;
    while (i1 < paramString.length)
    {
      int i3 = getWidth();
      int i4 = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString[i1]);
      paramCanvas.drawText(paramString[i1], (i3 - i4 >> 1) + paramInt1, paramInt2 + i2, paramPaint);
      paramPaint.getTextBounds(paramString[i1], 0, paramString[i1].length(), (Rect)localObject);
      i2 += ((Rect)localObject).height() + 20;
      i1 += 1;
    }
  }
  
  public void a(LyricViewAttribute paramLyricViewAttribute)
  {
    this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null);
    this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null);
    this.jdField_f_of_type_Int = paramLyricViewAttribute.jdField_i_of_type_Int;
    this.jdField_d_of_type_Int = paramLyricViewAttribute.jdField_c_of_type_Int;
    this.jdField_e_of_type_Int = paramLyricViewAttribute.jdField_h_of_type_Int;
    this.jdField_h_of_type_Int = paramLyricViewAttribute.jdField_d_of_type_Int;
    this.jdField_i_of_type_Int = paramLyricViewAttribute.jdField_e_of_type_Int;
    this.jdField_j_of_type_Int = paramLyricViewAttribute.jdField_f_of_type_Int;
    this.jdField_g_of_type_Int = paramLyricViewAttribute.jdField_g_of_type_Int;
    this.jdField_c_of_type_Int = paramLyricViewAttribute.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = paramLyricViewAttribute.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = paramLyricViewAttribute.jdField_a_of_type_Boolean;
    this.jdField_h_of_type_Boolean = paramLyricViewAttribute.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Int = paramLyricViewAttribute.jdField_k_of_type_Int;
    this.jdField_a_of_type_Boolean = paramLyricViewAttribute.jdField_c_of_type_Boolean;
    this.jdField_j_of_type_Boolean = paramLyricViewAttribute.jdField_d_of_type_Boolean;
    this.B = paramLyricViewAttribute.jdField_j_of_type_Int;
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_h_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_j_of_type_Int);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_h_of_type_Int);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(this.jdField_i_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_h_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_i_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setFakeBoldText(this.jdField_j_of_type_Boolean);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(this.jdField_b_of_type_Boolean);
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_b_of_type_Int);
    this.jdField_e_of_type_AndroidGraphicsPaint.setFakeBoldText(this.jdField_b_of_type_Boolean);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_e_of_type_AndroidGraphicsPaint.setAlpha(19);
    this.jdField_f_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_f_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_h_of_type_Int);
    this.jdField_f_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_f_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_f_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_f_of_type_AndroidGraphicsPaint.setAlpha(19);
    this.jdField_g_of_type_AndroidGraphicsPaint.setColor(paramLyricViewAttribute.n);
    this.jdField_g_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_h_of_type_AndroidGraphicsPaint.setColor(paramLyricViewAttribute.jdField_l_of_type_Int);
    this.jdField_h_of_type_AndroidGraphicsPaint.setTextSize(paramLyricViewAttribute.m);
    this.jdField_g_of_type_AndroidGraphicsPaint.setColor(paramLyricViewAttribute.n);
    this.jdField_k_of_type_Int = paramLyricViewAttribute.o;
  }
  
  protected void a(Lyric paramLyric1, Lyric paramLyric2)
  {
    try
    {
      boolean bool = this.jdField_c_of_type_Boolean;
      int i1 = this.p;
      int i2 = this.q;
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
        i8 = this.u;
        localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
        if ((!this.jdField_i_of_type_Boolean) || (paramSentence.mNormalLeftAttachInfo == null)) {
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
          i5 = this.jdField_e_of_type_Int;
        } else {
          i5 = this.jdField_f_of_type_Int;
        }
        if (!this.jdField_k_of_type_Boolean) {
          continue;
        }
        localSentenceUI.drawLyricContour(paramCanvas, paramInt1, i4 + i5, this.jdField_f_of_type_AndroidGraphicsPaint, true);
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
          f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(0, ((LyricCharacter)localArrayList.get(i2)).mEnd));
        } else {
          f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(0, i6));
        }
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException2)
      {
        continue;
      }
      f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(0, i6));
      f4 = f5 + f1;
      if (i1 == i9 - 1) {}
      try
      {
        f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, i6));
        continue;
        if (localSentenceUI.mText.length() >= ((LyricCharacter)localObject1).mEnd) {
          f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, ((LyricCharacter)localObject1).mEnd));
        } else {
          f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(((LyricCharacter)localObject1).mStart, i6));
        }
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException1)
      {
        continue;
      }
      f1 = this.jdField_d_of_type_AndroidGraphicsPaint.measureText(localSentenceUI.mText.substring(0, i6));
      i2 = localPaint.getColor();
      i6 = this.jdField_c_of_type_AndroidGraphicsPaint.getColor();
      localSentenceUI.paint(paramCanvas, paramInt1, i4 + i5, this.jdField_c_of_type_AndroidGraphicsPaint, localPaint, this.jdField_d_of_type_AndroidGraphicsPaint, i1, f1, f4, new int[] { i2, i6 }, new float[] { f3, f2 });
      continue;
      if (localSentenceUI.getEndTime() < l2) {
        localSentenceUI.paint(paramCanvas, paramInt1, i4 + i5, localPaint, true);
      } else {
        localSentenceUI.paint(paramCanvas, paramInt1, i4 + i5, this.jdField_c_of_type_AndroidGraphicsPaint, true);
      }
      i1 = this.jdField_g_of_type_Int;
      i4 += i5 + i1;
      i3 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    paramSentence = paramSentence.getUILyricLineList();
    int i3 = this.jdField_d_of_type_Int;
    int i4 = this.jdField_e_of_type_Int;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramSentence.size())
    {
      ((SentenceUI)paramSentence.get(paramInt2)).paint(paramCanvas, paramInt1, i1 + this.jdField_e_of_type_Int, paramPaint, false);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  protected void a(Sentence paramSentence, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint1, Paint paramPaint2, boolean paramBoolean)
  {
    paramSentence = paramSentence.getUILyricLineList();
    int i3 = this.jdField_d_of_type_Int;
    int i4 = this.jdField_e_of_type_Int;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < paramSentence.size())
    {
      ((SentenceUI)paramSentence.get(paramInt2)).paintWithContour(paramCanvas, paramInt1, i1 + this.jdField_e_of_type_Int, paramPaint1, paramPaint2, paramBoolean);
      i1 += i3 + i4;
      paramInt2 += 1;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public int b(int paramInt)
  {
    this.jdField_e_of_type_Boolean = true;
    return this.t;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
    this.p = -1;
    this.q = -1;
    this.r = 0;
    this.s = 0;
    this.jdField_f_of_type_Boolean = false;
  }
  
  protected int c()
  {
    if (this.m == -1) {
      this.m = this.B;
    }
    return this.m;
  }
  
  protected int c(int paramInt)
  {
    return 0;
  }
  
  protected void c()
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.jdField_j_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
  }
  
  public void d()
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_l_of_type_Int != 70)
    {
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        scrollTo(0, 0);
        this.jdField_a_of_type_AndroidWidgetScroller.setFinalX(0);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_JavaLangString, 0, this.jdField_k_of_type_Int);
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
    if (this.jdField_l_of_type_Int == 70)
    {
      paramInt1 = i2 - (c() << 1);
      paramInt2 = 0;
      int i4 = this.jdField_d_of_type_Int;
      int i5 = this.jdField_e_of_type_Int;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.generateUiLyricLineList(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1, false, true);
      } else {
        this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.generateUiLyricLineList(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
      }
      if ((this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null) && (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.size() == this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.size())) {
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.generateUiLyricLineList(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1, false, true);
        } else {
          this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.generateUiLyricLineList(this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt1);
        }
      }
      int i1;
      if (this.jdField_c_of_type_Boolean)
      {
        i1 = this.r;
        for (;;)
        {
          paramInt1 = paramInt2;
          if (i1 > this.s) {
            break;
          }
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i1) != null) {
            paramInt1 = paramInt2 + ((Sentence)this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i1)).getUiLineSize();
          }
          i1 += 1;
          paramInt2 = paramInt1;
        }
      }
      paramInt1 = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.getUILineSize();
      paramInt2 = paramInt1;
      if (this.jdField_g_of_type_Boolean)
      {
        localObject = this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric;
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt2 = paramInt1;
          if (((Lyric)localObject).mSentences != null)
          {
            if (this.jdField_c_of_type_Boolean)
            {
              i1 = this.r;
              for (;;)
              {
                paramInt2 = paramInt1;
                if (i1 > this.s) {
                  break;
                }
                paramInt2 = paramInt1;
                if (i1 < this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.size()) {
                  if (i1 < 0) {
                    paramInt2 = paramInt1;
                  } else {
                    paramInt2 = paramInt1 + ((Sentence)this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.mSentences.get(i1)).getUiLineSize();
                  }
                }
                i1 += 1;
                paramInt1 = paramInt2;
              }
            }
            paramInt2 = paramInt1 + this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.getUILineSize();
          }
        }
      }
      this.n = (paramInt2 * (i4 + i5));
      this.A = (i3 / (this.jdField_e_of_type_Int + this.jdField_d_of_type_Int) + 1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMeasure -> Show line count:");
      ((StringBuilder)localObject).append(this.A);
      Log.d("ModuleLyricViewInternal", ((StringBuilder)localObject).toString());
      setMeasuredDimension(i2, this.n + i3);
      return;
    }
    setMeasuredDimension(i2, i3);
  }
  
  public void setEffectEnable(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setLeftAlign(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    d();
  }
  
  public void setLineHeight(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setLyric(Lyric paramLyric1, Lyric paramLyric2)
  {
    Log.d("ModuleLyricViewInternal", "setLyric begin");
    this.jdField_d_of_type_Boolean = true;
    c();
    this.jdField_f_of_type_Boolean = false;
    if (paramLyric1 != null)
    {
      b();
      Lyric localLyric = new Lyric(2, 0, null);
      localLyric.copy(paramLyric1);
      this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = localLyric;
      if ((paramLyric2 != null) && (paramLyric1.size() == paramLyric2.size()))
      {
        paramLyric1 = new Lyric(2, 0, null);
        paramLyric1.copy(paramLyric2);
        this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = paramLyric1;
      }
      else
      {
        Log.w("ModuleLyricViewInternal", "setLyric -> pronounce lyric is empty or has incorrect lines");
        this.jdField_b_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric = new Lyric(2, 0, null);
      }
      this.jdField_l_of_type_Boolean = a(this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric);
      paramLyric1 = new StringBuilder();
      paramLyric1.append("setLyric -> is special qrc:");
      paramLyric1.append(this.jdField_l_of_type_Boolean);
      Log.w("ModuleLyricViewInternal", paramLyric1.toString());
      setState(70);
    }
    else
    {
      Log.w("ModuleLyricViewInternal", "setLyric -> lyric is null");
      setState(40);
    }
    this.jdField_d_of_type_Boolean = false;
    Log.d("ModuleLyricViewInternal", "setLyric end");
  }
  
  public void setLyricPadding(int paramInt)
  {
    this.B = paramInt;
    d();
  }
  
  public void setMode(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void setSegment(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 > paramInt1))
    {
      Lyric localLyric = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric;
      if ((localLyric != null) && (!localLyric.isEmpty()))
      {
        if ((this.p == paramInt1) && (this.q == paramInt2))
        {
          Log.d("ModuleLyricViewInternal", "setSegment -> same start and end");
          return;
        }
        this.p = paramInt1;
        this.q = paramInt2;
        this.r = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.findLineNoByStartTime(paramInt1);
        this.s = this.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.findEndLineByStartTime(paramInt2);
        if ((this.r >= 0) && (this.s >= 0))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_f_of_type_Boolean = false;
          return;
        }
        Log.e("ModuleLyricViewInternal", "setSegment -> lyric line number is illegal");
        this.jdField_c_of_type_Boolean = false;
        return;
      }
      Log.e("ModuleLyricViewInternal", "setSegment -> lyric is empty");
      return;
    }
    Log.e("ModuleLyricViewInternal", "setSegment -> the time of lyric is illegal");
  }
  
  public void setState(int paramInt)
  {
    this.jdField_l_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
    localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
    localPaint = this.jdField_c_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
    localPaint = this.jdField_d_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
    localPaint = this.jdField_e_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
    localPaint = this.jdField_f_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setTypeface(paramTypeface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewInternalBase
 * JD-Core Version:    0.7.0.1
 */