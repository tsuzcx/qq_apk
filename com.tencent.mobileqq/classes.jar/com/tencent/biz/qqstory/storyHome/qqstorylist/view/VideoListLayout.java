package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import com.tencent.widget.TraceUtils;

public class VideoListLayout
  extends ViewGroup
{
  private QQStoryAutoPlayView a;
  private TextView b;
  private StoryNickNameView c;
  @Deprecated
  private ImageView d;
  @Deprecated
  private TextView e;
  private StoryHomeHorizontalListView f;
  private LinearLayout g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  
  public VideoListLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  private void a()
  {
    this.i = UIUtils.a(getContext(), 15.0F);
    this.j = this.i;
    this.q = UIUtils.a(getContext(), 2.0F);
    this.m = getContext().getResources().getDimensionPixelSize(2131299306);
    this.n = UIUtils.a(getContext(), 10.0F);
    this.k = UIUtils.a(getContext(), 205.0F);
    this.l = UIUtils.a(getContext(), 332.0F);
    this.h = UIUtils.a(getContext(), 252.0F);
    this.o = UIUtils.a(getContext(), 10.0F);
    this.p = UIUtils.a(getContext(), 2.0F);
    this.r = UIUtils.a(getContext(), 7.0F);
    this.t = UIUtils.a(getContext(), 10.0F);
    this.s = UIUtils.a(getContext(), 3.0F);
  }
  
  private void b()
  {
    TraceUtils.traceBegin("VideoListLayout.init");
    this.e = ((TextView)LayoutInflater.from(getContext()).inflate(2131628040, this, false));
    this.d = new ImageView(getContext());
    this.d.setImageResource(2130848523);
    addView(this.d);
    addView(this.e);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
    this.b = ((TextView)LayoutInflater.from(getContext()).inflate(2131628048, this, false));
    addView(this.b);
    this.c = ((StoryNickNameView)LayoutInflater.from(getContext()).inflate(2131628048, this, false));
    addView(this.c);
    this.a = ((QQStoryAutoPlayView)LayoutInflater.from(getContext()).inflate(2131628043, this, false));
    addView(this.a);
    this.f = ((StoryHomeHorizontalListView)LayoutInflater.from(getContext()).inflate(2131628050, this, false));
    addView(this.f);
    TraceUtils.traceEnd();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    paramInt2 = this.n;
    Object localObject = this.d;
    paramInt1 = paramInt2;
    if (localObject != null)
    {
      paramInt1 = paramInt2;
      if (((ImageView)localObject).getVisibility() != 8)
      {
        this.d.measure(View.MeasureSpec.makeMeasureSpec(this.i, 1073741824), View.MeasureSpec.makeMeasureSpec(this.j, 1073741824));
        paramInt1 = paramInt2 + this.j + this.o;
      }
    }
    localObject = this.e;
    if ((localObject != null) && (((TextView)localObject).getVisibility() != 8)) {
      this.e.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648));
    }
    localObject = this.a;
    if ((localObject != null) && (((QQStoryAutoPlayView)localObject).getVisibility() != 8))
    {
      paramInt1 = paramInt1 + this.l + this.r;
      this.a.measure(View.MeasureSpec.makeMeasureSpec(this.k, 1073741824), View.MeasureSpec.makeMeasureSpec(this.l, 1073741824));
      if (this.b.getVisibility() != 8) {
        this.b.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648));
      }
      if (this.c.getVisibility() != 8) {
        this.c.measure(View.MeasureSpec.makeMeasureSpec(this.k, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648));
      }
      if (this.b.getVisibility() != 0)
      {
        paramInt2 = paramInt1;
        if (this.c.getVisibility() != 0) {
          break label329;
        }
      }
      paramInt2 = this.b.getMeasuredHeight();
    }
    else
    {
      localObject = this.f;
      paramInt2 = paramInt1;
      if (localObject == null) {
        break label329;
      }
      paramInt2 = paramInt1;
      if (((StoryHomeHorizontalListView)localObject).getVisibility() == 8) {
        break label329;
      }
      this.f.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.h, 1073741824));
      paramInt2 = this.h;
    }
    paramInt2 = paramInt1 + paramInt2;
    label329:
    localObject = this.g;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() != 8)) {
      this.g.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
    setMeasuredDimension(i1, paramInt2);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = this.m;
    paramInt4 = this.n;
    Object localObject = this.d;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() != 8))
    {
      paramInt3 = this.i + paramInt2;
      paramInt1 = this.j + paramInt4;
      this.d.layout(paramInt2, paramInt4, paramInt3, paramInt1);
    }
    else
    {
      paramInt3 = paramInt2;
      paramInt1 = paramInt4;
    }
    localObject = this.e;
    if ((localObject != null) && (((TextView)localObject).getVisibility() != 8))
    {
      paramInt3 += this.p;
      int i1 = this.q;
      int i2 = this.e.getMeasuredWidth();
      this.e.layout(paramInt3, paramInt4 - i1, i2 + paramInt3, paramInt1);
    }
    localObject = this.a;
    if ((localObject != null) && (((QQStoryAutoPlayView)localObject).getVisibility() != 8))
    {
      localObject = this.d;
      paramInt3 = paramInt1;
      if (localObject != null) {
        if (((ImageView)localObject).getVisibility() == 8) {
          paramInt3 = paramInt1;
        } else {
          paramInt3 = paramInt1 + this.o;
        }
      }
      paramInt1 = this.k;
      paramInt4 = this.l + paramInt3;
      this.a.layout(paramInt2, paramInt3 + 0, paramInt1 + paramInt2, paramInt4);
      localObject = this.f;
      if (localObject != null) {
        ((StoryHomeHorizontalListView)localObject).layout(0, 0, 0, 0);
      }
      paramInt3 = paramInt4 + this.r;
      localObject = this.b;
      if ((localObject != null) && (((TextView)localObject).getVisibility() != 8))
      {
        paramInt4 = this.b.getMeasuredWidth() + paramInt2;
        paramInt1 = this.b.getMeasuredHeight() + paramInt3;
        this.b.layout(paramInt2, paramInt3, paramInt4, paramInt1);
        paramInt2 = paramInt4;
      }
      else
      {
        paramInt1 = paramInt3;
      }
      localObject = this.c;
      if ((localObject != null) && (((StoryNickNameView)localObject).getVisibility() != 8))
      {
        paramInt2 += this.s;
        paramInt4 = this.c.getMeasuredWidth();
        this.c.layout(paramInt2, paramInt3, paramInt4 + paramInt2, paramInt1);
      }
    }
    else
    {
      localObject = this.f;
      if ((localObject != null) && (((StoryHomeHorizontalListView)localObject).getVisibility() != 8))
      {
        localObject = this.d;
        paramInt2 = paramInt1;
        if (localObject != null) {
          if (((ImageView)localObject).getVisibility() == 8) {
            paramInt2 = paramInt1;
          } else {
            paramInt2 = paramInt1 + this.o;
          }
        }
        paramInt1 = getMeasuredWidth();
        paramInt3 = this.h;
        this.f.layout(0, paramInt2 + 0, paramInt1, paramInt3 + paramInt2);
        localObject = this.a;
        if (localObject != null) {
          ((QQStoryAutoPlayView)localObject).layout(0, 0, 0, 0);
        }
      }
    }
    localObject = this.g;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() != 8))
    {
      paramInt1 = getMeasuredWidth() - this.t;
      paramInt2 = this.g.getMeasuredWidth();
      paramInt3 = this.g.getMeasuredHeight();
      this.g.layout(paramInt1 - paramInt2, 0, paramInt1, paramInt3);
      return;
    }
    localObject = this.g;
    if (localObject != null) {
      ((LinearLayout)localObject).layout(0, 0, 0, 0);
    }
  }
  
  public LinearLayout getAddGroupGuide()
  {
    if (this.g == null)
    {
      this.g = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131628035, this, false));
      addView(this.g);
    }
    return this.g;
  }
  
  public ImageView getFailedIcon()
  {
    return this.d;
  }
  
  public TextView getFailedTxt()
  {
    return this.e;
  }
  
  public StoryNickNameView getInfoView()
  {
    return this.c;
  }
  
  public QQStoryAutoPlayView getSingleVideoView()
  {
    return this.a;
  }
  
  public TextView getTimeView()
  {
    return this.b;
  }
  
  public StoryHomeHorizontalListView getVideoListView()
  {
    return this.f;
  }
  
  /* Error */
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc 239
    //   2: invokestatic 110	com/tencent/widget/TraceUtils:traceBegin	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: iload_1
    //   7: iload_2
    //   8: iload_3
    //   9: iload 4
    //   11: iload 5
    //   13: invokevirtual 241	com/tencent/biz/qqstory/storyHome/qqstorylist/view/VideoListLayout:a	(ZIIII)V
    //   16: invokestatic 164	com/tencent/widget/TraceUtils:traceEnd	()V
    //   19: return
    //   20: astore 6
    //   22: goto +43 -> 65
    //   25: astore 6
    //   27: new 243	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   34: astore 7
    //   36: aload 7
    //   38: ldc 247
    //   40: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 7
    //   46: aload 6
    //   48: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: new 256	java/lang/Error
    //   55: dup
    //   56: aload 7
    //   58: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 262	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   64: athrow
    //   65: invokestatic 164	com/tencent/widget/TraceUtils:traceEnd	()V
    //   68: aload 6
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	VideoListLayout
    //   0	71	1	paramBoolean	boolean
    //   0	71	2	paramInt1	int
    //   0	71	3	paramInt2	int
    //   0	71	4	paramInt3	int
    //   0	71	5	paramInt4	int
    //   20	1	6	localObject	Object
    //   25	44	6	localException	java.lang.Exception
    //   34	23	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	16	20	finally
    //   27	65	20	finally
    //   5	16	25	java/lang/Exception
  }
  
  /* Error */
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 265
    //   3: invokestatic 110	com/tencent/widget/TraceUtils:traceBegin	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: iload_1
    //   8: iload_2
    //   9: invokevirtual 267	com/tencent/biz/qqstory/storyHome/qqstorylist/view/VideoListLayout:a	(II)V
    //   12: invokestatic 164	com/tencent/widget/TraceUtils:traceEnd	()V
    //   15: return
    //   16: astore_3
    //   17: goto +41 -> 58
    //   20: astore_3
    //   21: new 243	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   28: astore 4
    //   30: aload 4
    //   32: ldc 247
    //   34: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: aload_3
    //   41: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: new 256	java/lang/Error
    //   48: dup
    //   49: aload 4
    //   51: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 262	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   57: athrow
    //   58: invokestatic 164	com/tencent/widget/TraceUtils:traceEnd	()V
    //   61: aload_3
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	VideoListLayout
    //   0	63	1	paramInt1	int
    //   0	63	2	paramInt2	int
    //   16	1	3	localObject	Object
    //   20	42	3	localException	java.lang.Exception
    //   28	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	12	16	finally
    //   21	58	16	finally
    //   6	12	20	java/lang/Exception
  }
  
  public void setAddGroupGuide(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (!paramBoolean)
    {
      paramOnClickListener = this.g;
      if (paramOnClickListener != null) {
        paramOnClickListener.setVisibility(8);
      }
      return;
    }
    if (this.g == null)
    {
      this.g = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131628035, this, false));
      addView(this.g);
    }
    this.g.setVisibility(0);
    this.g.setOnClickListener(paramOnClickListener);
  }
  
  public void setFailedTxt(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (!paramBoolean)
    {
      this.e.setVisibility(8);
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    this.e.setVisibility(0);
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  public void setHorizontalViewHeight(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setMarginTop(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setSingleVideoSize(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout
 * JD-Core Version:    0.7.0.1
 */