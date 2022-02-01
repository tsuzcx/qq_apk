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
  private int jdField_a_of_type_Int = -1;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  StoryQIMBadgeView jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView;
  StoryUserBadgeView jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private int jdField_b_of_type_Int = -1;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private CharSequence jdField_b_of_type_JavaLangCharSequence = "";
  private int jdField_c_of_type_Int;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private CharSequence jdField_c_of_type_JavaLangCharSequence = "";
  private int jdField_d_of_type_Int;
  private CharSequence jdField_d_of_type_JavaLangCharSequence = "";
  private int e;
  private int f;
  private int g;
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
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131374505);
    addView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView = new StoryQIMBadgeView(getContext());
    addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561668, this, false));
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561667, this, false));
    addView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView = new StoryUserBadgeView(getContext());
    addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561667, this, false));
    addView(this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)LayoutInflater.from(getContext()).inflate(2131561666, this, false));
    this.jdField_a_of_type_AndroidWidgetButton.setId(2131362184);
    addView(this.jdField_a_of_type_AndroidWidgetButton);
    TraceUtils.traceEnd();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_c_of_type_Int, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_d_of_type_Int, 1073741824));
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView;
    if ((localObject != null) && (((StoryQIMBadgeView)localObject).getVisibility() != 8)) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView.measure(View.MeasureSpec.makeMeasureSpec(this.g, 1073741824), View.MeasureSpec.makeMeasureSpec(this.h, 1073741824));
    }
    int i2 = this.e;
    int i3 = this.f;
    int i4 = this.jdField_c_of_type_Int;
    int i5 = this.p;
    int i1 = paramInt1 - i2 - i3 - i4 - i5;
    paramInt1 = paramInt1 - i2 - i3 - i4 - i5;
    localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if ((localObject != null) && (((Button)localObject).getVisibility() != 8))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetButton.getPaint();
      this.jdField_c_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidWidgetButton.getText();
      localCharSequence = this.jdField_c_of_type_JavaLangCharSequence;
      this.m = ((int)((TextPaint)localObject).measureText(localCharSequence, 0, localCharSequence.length()) + this.jdField_a_of_type_AndroidWidgetButton.getPaddingLeft() + this.jdField_a_of_type_AndroidWidgetButton.getPaddingRight());
      this.jdField_a_of_type_AndroidWidgetButton.measure(View.MeasureSpec.makeMeasureSpec(this.m, 1073741824), View.MeasureSpec.makeMeasureSpec(this.n, 1073741824));
      i2 = this.m;
      i3 = this.p;
      i4 = this.o;
      i1 = i1 - i2 - i3 - i4;
      paramInt1 = paramInt1 - i2 - i3 - i4;
    }
    else
    {
      this.m = 0;
    }
    i2 = i1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.getVisibility() != 8)
    {
      i3 = this.i;
      i2 = i1 - i3 - this.k;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.j, 1073741824));
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView.getPaint();
    this.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidWidgetTextView.getText();
    CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
    float f1 = ((TextPaint)localObject).measureText(localCharSequence, 0, localCharSequence.length());
    if (f1 > i2) {
      this.jdField_a_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec((int)f1, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
    localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    i1 = paramInt1;
    if (localObject != null)
    {
      i1 = paramInt1;
      if (((TextView)localObject).getVisibility() != 8)
      {
        localObject = this.jdField_c_of_type_AndroidWidgetTextView.getPaint();
        this.jdField_d_of_type_JavaLangCharSequence = this.jdField_c_of_type_AndroidWidgetTextView.getText();
        localCharSequence = this.jdField_d_of_type_JavaLangCharSequence;
        i2 = (int)((TextPaint)localObject).measureText(localCharSequence, 0, localCharSequence.length());
        i1 = paramInt1 - i2 - this.r;
        this.jdField_c_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
      }
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 8)
    {
      localObject = this.jdField_b_of_type_AndroidWidgetTextView.getPaint();
      this.jdField_b_of_type_JavaLangCharSequence = this.jdField_b_of_type_AndroidWidgetTextView.getText();
      localCharSequence = this.jdField_b_of_type_JavaLangCharSequence;
      f1 = ((TextPaint)localObject).measureText(localCharSequence, 0, localCharSequence.length());
      if (f1 > i1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec((int)f1, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
  }
  
  private void b()
  {
    this.jdField_c_of_type_Int = getContext().getResources().getDimensionPixelSize(2131298591);
    this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    this.f = getContext().getResources().getDimensionPixelSize(2131298596);
    this.e = getContext().getResources().getDimensionPixelSize(2131298592);
    this.g = getContext().getResources().getDimensionPixelSize(2131298593);
    this.h = this.g;
    this.q = getContext().getResources().getDimensionPixelSize(2131298595);
    this.i = getContext().getResources().getDimensionPixelSize(2131298590);
    this.j = this.i;
    this.l = getContext().getResources().getDimensionPixelSize(2131298589);
    this.k = getContext().getResources().getDimensionPixelSize(2131298588);
    this.r = UIUtils.a(getContext(), 2.0F);
    this.o = UIUtils.a(getContext(), 10.0F);
    this.p = UIUtils.a(getContext(), 15.0F);
    this.n = getContext().getResources().getDimensionPixelSize(2131298594);
    this.m = 0;
  }
  
  @NonNull
  public Button a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  @NonNull
  public StoryQIMBadgeView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView;
  }
  
  @NonNull
  public StoryUserBadgeView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView;
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = this.e;
    paramInt1 = this.jdField_b_of_type_Int;
    paramInt3 = this.jdField_d_of_type_Int;
    paramInt4 = (paramInt1 - paramInt3) / 2;
    paramInt1 = this.jdField_c_of_type_Int + paramInt2;
    paramInt3 += paramInt4;
    this.jdField_a_of_type_AndroidWidgetImageView.layout(paramInt2, paramInt4, paramInt1, paramInt3);
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView;
    if ((localObject != null) && (((StoryQIMBadgeView)localObject).getVisibility() != 8))
    {
      paramInt2 = this.g;
      paramInt4 = this.h;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView.layout(paramInt1 - paramInt2, paramInt3 - paramInt4, paramInt1, paramInt3);
    }
    paramInt2 = paramInt1 + this.f;
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 8) {
      paramInt1 = (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight()) / 2;
    } else {
      paramInt1 = (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight() - this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredHeight() - this.q) / 2;
    }
    paramInt4 = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() + paramInt2;
    paramInt3 = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight() + paramInt1;
    this.jdField_a_of_type_AndroidWidgetTextView.layout(paramInt2, paramInt1 + 0, paramInt4, paramInt3);
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView;
    if ((localObject != null) && (((StoryUserBadgeView)localObject).getVisibility() != 8))
    {
      paramInt4 += this.k;
      paramInt1 += this.l;
      int i1 = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.getMeasuredWidth();
      int i2 = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.getMeasuredHeight();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.layout(paramInt4, paramInt1, i1 + paramInt4, i2 + paramInt1);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 8)
    {
      paramInt1 = paramInt3 + this.q;
      paramInt3 = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() + paramInt2;
      paramInt4 = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredHeight();
      this.jdField_b_of_type_AndroidWidgetTextView.layout(paramInt2, paramInt1, paramInt3, paramInt4 + paramInt1);
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if ((localObject != null) && (((TextView)localObject).getVisibility() != 8))
      {
        paramInt2 = paramInt3 + this.r;
        paramInt3 = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth();
        paramInt4 = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredHeight();
        this.jdField_c_of_type_AndroidWidgetTextView.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
      }
    }
    localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if ((localObject != null) && (((Button)localObject).getVisibility() != 8))
    {
      paramInt1 = this.jdField_a_of_type_Int - this.p;
      paramInt2 = this.m;
      paramInt4 = this.jdField_b_of_type_Int;
      paramInt3 = this.n;
      paramInt4 = (paramInt4 - paramInt3) / 2;
      this.jdField_a_of_type_AndroidWidgetButton.layout(paramInt1 - paramInt2, paramInt4, paramInt1, paramInt3 + paramInt4);
    }
  }
  
  public TextView b()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public TextView c()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  /* Error */
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc_w 264
    //   3: invokestatic 66	com/tencent/widget/TraceUtils:traceBegin	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: iload_1
    //   8: iload_2
    //   9: iload_3
    //   10: iload 4
    //   12: iload 5
    //   14: invokevirtual 266	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:a	(ZIIII)V
    //   17: invokestatic 125	com/tencent/widget/TraceUtils:traceEnd	()V
    //   20: return
    //   21: astore 6
    //   23: goto +44 -> 67
    //   26: astore 6
    //   28: new 268	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   35: astore 7
    //   37: aload 7
    //   39: ldc_w 272
    //   42: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 7
    //   48: aload 6
    //   50: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: new 281	java/lang/Error
    //   57: dup
    //   58: aload 7
    //   60: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 287	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   66: athrow
    //   67: invokestatic 125	com/tencent/widget/TraceUtils:traceEnd	()V
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
    //   0: ldc_w 290
    //   3: invokestatic 66	com/tencent/widget/TraceUtils:traceBegin	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: iload_1
    //   8: invokestatic 293	android/view/View$MeasureSpec:getSize	(I)I
    //   11: putfield 41	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:jdField_a_of_type_Int	I
    //   14: aload_0
    //   15: iload_2
    //   16: invokestatic 293	android/view/View$MeasureSpec:getSize	(I)I
    //   19: putfield 43	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:jdField_b_of_type_Int	I
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 41	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:jdField_a_of_type_Int	I
    //   27: aload_0
    //   28: getfield 43	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:jdField_b_of_type_Int	I
    //   31: invokespecial 295	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:a	(II)V
    //   34: aload_0
    //   35: aload_0
    //   36: getfield 41	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:jdField_a_of_type_Int	I
    //   39: aload_0
    //   40: getfield 43	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:jdField_b_of_type_Int	I
    //   43: invokevirtual 298	com/tencent/biz/qqstory/storyHome/qqstorylist/view/QQStoryOwnerInfoView:setMeasuredDimension	(II)V
    //   46: invokestatic 125	com/tencent/widget/TraceUtils:traceEnd	()V
    //   49: return
    //   50: astore_3
    //   51: goto +42 -> 93
    //   54: astore_3
    //   55: new 268	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   62: astore 4
    //   64: aload 4
    //   66: ldc_w 272
    //   69: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 4
    //   75: aload_3
    //   76: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: new 281	java/lang/Error
    //   83: dup
    //   84: aload 4
    //   86: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokespecial 287	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   92: athrow
    //   93: invokestatic 125	com/tencent/widget/TraceUtils:traceEnd	()V
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  public void setBadge(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryUserBadgeView.setImageDrawable(paramDrawable);
  }
  
  public void setButtonTxt(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_JavaLangCharSequence = "";
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_JavaLangCharSequence = paramString;
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(paramString);
  }
  
  public void setName(@NonNull String paramString)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramString;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void setOwnerInfoOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setQIMIcon(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      paramDrawable = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView;
      if (paramDrawable != null) {
        paramDrawable.setVisibility(8);
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView = new StoryQIMBadgeView(getContext());
      addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryQIMBadgeView.setImageDrawable(paramDrawable);
  }
  
  public void setSubTitle(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_JavaLangCharSequence = "";
      paramString = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      return;
    }
    this.jdField_b_of_type_JavaLangCharSequence = paramString;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void setSubTitleSuffix(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_d_of_type_JavaLangCharSequence = "";
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_JavaLangCharSequence = paramString;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.QQStoryOwnerInfoView
 * JD-Core Version:    0.7.0.1
 */