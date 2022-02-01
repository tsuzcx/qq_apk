package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.widget.TraceUtils;

public class QQStoryOwnerInfoView
  extends ViewGroup
{
  private CharSequence A = "";
  private CharSequence B = "";
  private CharSequence C = "";
  TextView a;
  TextView b;
  TextView c;
  StoryUserBadgeView d;
  ImageView e;
  StoryQIMBadgeView f;
  Button g;
  private int h = -1;
  private int i = -1;
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
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private CharSequence z = "";
  
  public QQStoryOwnerInfoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQStoryOwnerInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QQStoryOwnerInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
    a();
  }
  
  private void a()
  {
    TraceUtils.traceBegin("QQStoryInfoView.init");
    this.e = new ImageView(getContext());
    this.e.setId(2131442675);
    addView(this.e);
    this.f = new StoryQIMBadgeView(getContext());
    addView(this.f);
    this.a = ((TextView)LayoutInflater.from(getContext()).inflate(2131628047, this, false));
    addView(this.a);
    this.b = ((TextView)LayoutInflater.from(getContext()).inflate(2131628046, this, false));
    addView(this.b);
    this.d = new StoryUserBadgeView(getContext());
    addView(this.d);
    this.c = ((TextView)LayoutInflater.from(getContext()).inflate(2131628046, this, false));
    addView(this.c);
    this.g = ((Button)LayoutInflater.from(getContext()).inflate(2131628045, this, false));
    this.g.setId(2131427766);
    addView(this.g);
    TraceUtils.traceEnd();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.e.measure(View.MeasureSpec.makeMeasureSpec(this.j, 1073741824), View.MeasureSpec.makeMeasureSpec(this.k, 1073741824));
    Object localObject = this.f;
    if ((localObject != null) && (((StoryQIMBadgeView)localObject).getVisibility() != 8)) {
      this.f.measure(View.MeasureSpec.makeMeasureSpec(this.n, 1073741824), View.MeasureSpec.makeMeasureSpec(this.o, 1073741824));
    }
    int i2 = this.l;
    int i3 = this.m;
    int i4 = this.j;
    int i5 = this.w;
    int i1 = paramInt1 - i2 - i3 - i4 - i5;
    paramInt1 = paramInt1 - i2 - i3 - i4 - i5;
    localObject = this.g;
    if ((localObject != null) && (((Button)localObject).getVisibility() != 8))
    {
      localObject = this.g.getPaint();
      this.B = this.g.getText();
      localCharSequence = this.B;
      this.t = ((int)((TextPaint)localObject).measureText(localCharSequence, 0, localCharSequence.length()) + this.g.getPaddingLeft() + this.g.getPaddingRight());
      this.g.measure(View.MeasureSpec.makeMeasureSpec(this.t, 1073741824), View.MeasureSpec.makeMeasureSpec(this.u, 1073741824));
      i2 = this.t;
      i3 = this.w;
      i4 = this.v;
      i1 = i1 - i2 - i3 - i4;
      paramInt1 = paramInt1 - i2 - i3 - i4;
    }
    else
    {
      this.t = 0;
    }
    i2 = i1;
    if (this.d.getVisibility() != 8)
    {
      i3 = this.p;
      i2 = i1 - i3 - this.r;
      this.d.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.q, 1073741824));
    }
    localObject = this.a.getPaint();
    this.z = this.a.getText();
    CharSequence localCharSequence = this.z;
    float f1 = ((TextPaint)localObject).measureText(localCharSequence, 0, localCharSequence.length());
    if (f1 > i2) {
      this.a.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    } else {
      this.a.measure(View.MeasureSpec.makeMeasureSpec((int)f1, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
    localObject = this.c;
    i1 = paramInt1;
    if (localObject != null)
    {
      i1 = paramInt1;
      if (((TextView)localObject).getVisibility() != 8)
      {
        localObject = this.c.getPaint();
        this.C = this.c.getText();
        localCharSequence = this.C;
        i2 = (int)((TextPaint)localObject).measureText(localCharSequence, 0, localCharSequence.length());
        i1 = paramInt1 - i2 - this.y;
        this.c.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
      }
    }
    if (this.b.getVisibility() != 8)
    {
      localObject = this.b.getPaint();
      this.A = this.b.getText();
      localCharSequence = this.A;
      f1 = ((TextPaint)localObject).measureText(localCharSequence, 0, localCharSequence.length());
      if (f1 > i1)
      {
        this.b.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
        return;
      }
      this.b.measure(View.MeasureSpec.makeMeasureSpec((int)f1, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
  }
  
  private void b()
  {
    this.j = getContext().getResources().getDimensionPixelSize(2131299305);
    this.k = this.j;
    this.m = getContext().getResources().getDimensionPixelSize(2131299310);
    this.l = getContext().getResources().getDimensionPixelSize(2131299306);
    this.n = getContext().getResources().getDimensionPixelSize(2131299307);
    this.o = this.n;
    this.x = getContext().getResources().getDimensionPixelSize(2131299309);
    this.p = getContext().getResources().getDimensionPixelSize(2131299304);
    this.q = this.p;
    this.s = getContext().getResources().getDimensionPixelSize(2131299303);
    this.r = getContext().getResources().getDimensionPixelSize(2131299302);
    this.y = UIUtils.a(getContext(), 2.0F);
    this.v = UIUtils.a(getContext(), 10.0F);
    this.w = UIUtils.a(getContext(), 15.0F);
    this.u = getContext().getResources().getDimensionPixelSize(2131299308);
    this.t = 0;
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = this.l;
    paramInt1 = this.i;
    paramInt3 = this.k;
    paramInt4 = (paramInt1 - paramInt3) / 2;
    paramInt1 = this.j + paramInt2;
    paramInt3 += paramInt4;
    this.e.layout(paramInt2, paramInt4, paramInt1, paramInt3);
    Object localObject = this.f;
    if ((localObject != null) && (((StoryQIMBadgeView)localObject).getVisibility() != 8))
    {
      paramInt2 = this.n;
      paramInt4 = this.o;
      this.f.layout(paramInt1 - paramInt2, paramInt3 - paramInt4, paramInt1, paramInt3);
    }
    paramInt2 = paramInt1 + this.m;
    if (this.b.getVisibility() == 8) {
      paramInt1 = (this.i - this.a.getMeasuredHeight()) / 2;
    } else {
      paramInt1 = (this.i - this.a.getMeasuredHeight() - this.b.getMeasuredHeight() - this.x) / 2;
    }
    paramInt4 = this.a.getMeasuredWidth() + paramInt2;
    paramInt3 = this.a.getMeasuredHeight() + paramInt1;
    this.a.layout(paramInt2, paramInt1 + 0, paramInt4, paramInt3);
    localObject = this.d;
    if ((localObject != null) && (((StoryUserBadgeView)localObject).getVisibility() != 8))
    {
      paramInt4 += this.r;
      paramInt1 += this.s;
      int i1 = this.d.getMeasuredWidth();
      int i2 = this.d.getMeasuredHeight();
      this.d.layout(paramInt4, paramInt1, i1 + paramInt4, i2 + paramInt1);
    }
    if (this.b.getVisibility() != 8)
    {
      paramInt1 = paramInt3 + this.x;
      paramInt3 = this.b.getMeasuredWidth() + paramInt2;
      paramInt4 = this.b.getMeasuredHeight();
      this.b.layout(paramInt2, paramInt1, paramInt3, paramInt4 + paramInt1);
      localObject = this.c;
      if ((localObject != null) && (((TextView)localObject).getVisibility() != 8))
      {
        paramInt2 = paramInt3 + this.y;
        paramInt3 = this.c.getMeasuredWidth();
        paramInt4 = this.c.getMeasuredHeight();
        this.c.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
      }
    }
    localObject = this.g;
    if ((localObject != null) && (((Button)localObject).getVisibility() != 8))
    {
      paramInt1 = this.h - this.w;
      paramInt2 = this.t;
      paramInt4 = this.i;
      paramInt3 = this.u;
      paramInt4 = (paramInt4 - paramInt3) / 2;
      this.g.layout(paramInt1 - paramInt2, paramInt4, paramInt1, paramInt3 + paramInt4);
    }
  }
  
  public ImageView getAvatar()
  {
    return this.e;
  }
  
  @NonNull
  public StoryUserBadgeView getBadge()
  {
    return this.d;
  }
  
  @NonNull
  public StoryQIMBadgeView getIcon()
  {
    return this.f;
  }
  
  public TextView getNameView()
  {
    return this.a;
  }
  
  @NonNull
  public Button getRightBtn()
  {
    return this.g;
  }
  
  public TextView getSubTitleSuffix()
  {
    return this.c;
  }
  
  public TextView getSubTitleView()
  {
    return this.b;
  }
  
  /* Error */
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc_w 282
    //   3: invokestatic 77	com/tencent/widget/TraceUtils:traceBegin	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: iload_1
    //   8: iload_2
    //   9: iload_3
    //   10: iload 4
    //   12: iload 5
    //   14: invokevirtual 284	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:a	(ZIIII)V
    //   17: invokestatic 136	com/tencent/widget/TraceUtils:traceEnd	()V
    //   20: return
    //   21: astore 6
    //   23: goto +44 -> 67
    //   26: astore 6
    //   28: new 286	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   35: astore 7
    //   37: aload 7
    //   39: ldc_w 290
    //   42: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 7
    //   48: aload 6
    //   50: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: new 299	java/lang/Error
    //   57: dup
    //   58: aload 7
    //   60: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 305	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   66: athrow
    //   67: invokestatic 136	com/tencent/widget/TraceUtils:traceEnd	()V
    //   70: aload 6
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	QQStoryOwnerInfoView
    //   0	73	1	paramBoolean	boolean
    //   0	73	2	paramInt1	int
    //   0	73	3	paramInt2	int
    //   0	73	4	paramInt3	int
    //   0	73	5	paramInt4	int
    //   21	1	6	localObject	Object
    //   26	45	6	localException	java.lang.Exception
    //   35	24	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	17	21	finally
    //   28	67	21	finally
    //   6	17	26	java/lang/Exception
  }
  
  /* Error */
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 308
    //   3: invokestatic 77	com/tencent/widget/TraceUtils:traceBegin	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: iload_1
    //   8: invokestatic 311	android/view/View$MeasureSpec:getSize	(I)I
    //   11: putfield 52	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:h	I
    //   14: aload_0
    //   15: iload_2
    //   16: invokestatic 311	android/view/View$MeasureSpec:getSize	(I)I
    //   19: putfield 54	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:i	I
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 52	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:h	I
    //   27: aload_0
    //   28: getfield 54	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:i	I
    //   31: invokespecial 313	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:a	(II)V
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 52	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:h	I
    //   39: aload_0
    //   40: getfield 54	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:i	I
    //   43: invokevirtual 316	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:setMeasuredDimension	(II)V
    //   46: invokestatic 136	com/tencent/widget/TraceUtils:traceEnd	()V
    //   49: return
    //   50: astore_3
    //   51: goto +42 -> 93
    //   54: astore_3
    //   55: new 286	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   62: astore 4
    //   64: aload 4
    //   66: ldc_w 290
    //   69: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 4
    //   75: aload_3
    //   76: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: new 299	java/lang/Error
    //   83: dup
    //   84: aload 4
    //   86: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokespecial 305	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   92: athrow
    //   93: invokestatic 136	com/tencent/widget/TraceUtils:traceEnd	()V
    //   96: aload_3
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	QQStoryOwnerInfoView
    //   0	98	1	paramInt1	int
    //   0	98	2	paramInt2	int
    //   50	1	3	localObject	Object
    //   54	43	3	localException	java.lang.Exception
    //   62	23	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	46	50	finally
    //   55	93	50	finally
    //   6	46	54	java/lang/Exception
  }
  
  public void setAvatar(@NonNull Drawable paramDrawable)
  {
    this.e.setImageDrawable(paramDrawable);
  }
  
  public void setBadge(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    this.d.setImageDrawable(paramDrawable);
  }
  
  public void setButtonTxt(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.B = "";
      this.g.setVisibility(8);
      return;
    }
    this.B = paramString;
    this.g.setVisibility(0);
    this.g.setText(paramString);
  }
  
  public void setName(@NonNull String paramString)
  {
    this.z = paramString;
    this.a.setText(paramString);
    this.a.setVisibility(0);
  }
  
  public void setOwnerInfoOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  public void setQIMIcon(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      paramDrawable = this.f;
      if (paramDrawable != null) {
        paramDrawable.setVisibility(8);
      }
      return;
    }
    if (this.f == null)
    {
      this.f = new StoryQIMBadgeView(getContext());
      addView(this.f);
    }
    this.f.setVisibility(0);
    this.f.setImageDrawable(paramDrawable);
  }
  
  public void setSubTitle(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.A = "";
      paramString = this.b;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      return;
    }
    this.A = paramString;
    this.b.setText(paramString);
    this.b.setVisibility(0);
  }
  
  public void setSubTitleSuffix(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.C = "";
      this.c.setVisibility(8);
      return;
    }
    this.C = paramString;
    this.c.setText(paramString);
    this.c.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.QQStoryOwnerInfoView
 * JD-Core Version:    0.7.0.1
 */