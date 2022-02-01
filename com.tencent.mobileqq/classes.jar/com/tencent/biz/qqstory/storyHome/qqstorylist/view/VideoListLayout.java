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
  private int jdField_a_of_type_Int;
  @Deprecated
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQStoryAutoPlayView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  private StoryHomeHorizontalListView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView;
  private StoryNickNameView jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView;
  private int jdField_b_of_type_Int;
  @Deprecated
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
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
    this.jdField_b_of_type_Int = UIUtils.a(getContext(), 15.0F);
    this.c = this.jdField_b_of_type_Int;
    this.j = UIUtils.a(getContext(), 2.0F);
    this.f = getContext().getResources().getDimensionPixelSize(2131298592);
    this.g = UIUtils.a(getContext(), 10.0F);
    this.d = UIUtils.a(getContext(), 205.0F);
    this.e = UIUtils.a(getContext(), 332.0F);
    this.jdField_a_of_type_Int = UIUtils.a(getContext(), 252.0F);
    this.h = UIUtils.a(getContext(), 10.0F);
    this.i = UIUtils.a(getContext(), 2.0F);
    this.k = UIUtils.a(getContext(), 7.0F);
    this.m = UIUtils.a(getContext(), 10.0F);
    this.l = UIUtils.a(getContext(), 3.0F);
  }
  
  private void b()
  {
    TraceUtils.traceBegin("VideoListLayout.init");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561661, this, false));
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846971);
    addView(this.jdField_a_of_type_AndroidWidgetImageView);
    addView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(getContext()).inflate(2131561669, this, false));
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView = ((StoryNickNameView)LayoutInflater.from(getContext()).inflate(2131561669, this, false));
    addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = ((QQStoryAutoPlayView)LayoutInflater.from(getContext()).inflate(2131561664, this, false));
    addView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView = ((StoryHomeHorizontalListView)LayoutInflater.from(getContext()).inflate(2131561671, this, false));
    addView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView);
    TraceUtils.traceEnd();
  }
  
  public LinearLayout a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131561656, this, false));
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public TextView a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public QQStoryAutoPlayView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
  }
  
  public StoryHomeHorizontalListView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView;
  }
  
  public StoryNickNameView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    paramInt2 = this.g;
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    paramInt1 = paramInt2;
    if (localObject != null)
    {
      paramInt1 = paramInt2;
      if (((ImageView)localObject).getVisibility() != 8)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_b_of_type_Int, 1073741824), View.MeasureSpec.makeMeasureSpec(this.c, 1073741824));
        paramInt1 = paramInt2 + this.c + this.h;
      }
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (((TextView)localObject).getVisibility() != 8)) {
      this.jdField_b_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec(n, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648));
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
    if ((localObject != null) && (((QQStoryAutoPlayView)localObject).getVisibility() != 8))
    {
      paramInt1 = paramInt1 + this.e + this.k;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.measure(View.MeasureSpec.makeMeasureSpec(this.d, 1073741824), View.MeasureSpec.makeMeasureSpec(this.e, 1073741824));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        this.jdField_a_of_type_AndroidWidgetTextView.measure(View.MeasureSpec.makeMeasureSpec(n, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648));
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView.measure(View.MeasureSpec.makeMeasureSpec(this.d, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)
      {
        paramInt2 = paramInt1;
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView.getVisibility() != 0) {
          break label329;
        }
      }
      paramInt2 = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight();
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView;
      paramInt2 = paramInt1;
      if (localObject == null) {
        break label329;
      }
      paramInt2 = paramInt1;
      if (((StoryHomeHorizontalListView)localObject).getVisibility() == 8) {
        break label329;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.measure(View.MeasureSpec.makeMeasureSpec(n, 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824));
      paramInt2 = this.jdField_a_of_type_Int;
    }
    paramInt2 = paramInt1 + paramInt2;
    label329:
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(n, -2147483648), View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648));
    }
    setMeasuredDimension(n, paramInt2);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = this.f;
    paramInt4 = this.g;
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() != 8))
    {
      paramInt3 = this.jdField_b_of_type_Int + paramInt2;
      paramInt1 = this.c + paramInt4;
      this.jdField_a_of_type_AndroidWidgetImageView.layout(paramInt2, paramInt4, paramInt3, paramInt1);
    }
    else
    {
      paramInt3 = paramInt2;
      paramInt1 = paramInt4;
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (((TextView)localObject).getVisibility() != 8))
    {
      paramInt3 += this.i;
      int n = this.j;
      int i1 = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth();
      this.jdField_b_of_type_AndroidWidgetTextView.layout(paramInt3, paramInt4 - n, i1 + paramInt3, paramInt1);
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
    if ((localObject != null) && (((QQStoryAutoPlayView)localObject).getVisibility() != 8))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      paramInt3 = paramInt1;
      if (localObject != null) {
        if (((ImageView)localObject).getVisibility() == 8) {
          paramInt3 = paramInt1;
        } else {
          paramInt3 = paramInt1 + this.h;
        }
      }
      paramInt1 = this.d;
      paramInt4 = this.e + paramInt3;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.layout(paramInt2, paramInt3 + 0, paramInt1 + paramInt2, paramInt4);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView;
      if (localObject != null) {
        ((StoryHomeHorizontalListView)localObject).layout(0, 0, 0, 0);
      }
      paramInt3 = paramInt4 + this.k;
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if ((localObject != null) && (((TextView)localObject).getVisibility() != 8))
      {
        paramInt4 = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth() + paramInt2;
        paramInt1 = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight() + paramInt3;
        this.jdField_a_of_type_AndroidWidgetTextView.layout(paramInt2, paramInt3, paramInt4, paramInt1);
        paramInt2 = paramInt4;
      }
      else
      {
        paramInt1 = paramInt3;
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView;
      if ((localObject != null) && (((StoryNickNameView)localObject).getVisibility() != 8))
      {
        paramInt2 += this.l;
        paramInt4 = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView.getMeasuredWidth();
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStoryNickNameView.layout(paramInt2, paramInt3, paramInt4 + paramInt2, paramInt1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView;
      if ((localObject != null) && (((StoryHomeHorizontalListView)localObject).getVisibility() != 8))
      {
        localObject = this.jdField_a_of_type_AndroidWidgetImageView;
        paramInt2 = paramInt1;
        if (localObject != null) {
          if (((ImageView)localObject).getVisibility() == 8) {
            paramInt2 = paramInt1;
          } else {
            paramInt2 = paramInt1 + this.h;
          }
        }
        paramInt1 = getMeasuredWidth();
        paramInt3 = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.layout(0, paramInt2 + 0, paramInt1, paramInt3 + paramInt2);
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView;
        if (localObject != null) {
          ((QQStoryAutoPlayView)localObject).layout(0, 0, 0, 0);
        }
      }
    }
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() != 8))
    {
      paramInt1 = getMeasuredWidth() - this.m;
      paramInt2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
      paramInt3 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(paramInt1 - paramInt2, 0, paramInt1, paramInt3);
      return;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).layout(0, 0, 0, 0);
    }
  }
  
  public TextView b()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  /* Error */
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc 224
    //   2: invokestatic 103	com/tencent/widget/TraceUtils:traceBegin	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: iload_1
    //   7: iload_2
    //   8: iload_3
    //   9: iload 4
    //   11: iload 5
    //   13: invokevirtual 226	com/tencent/biz/qqstory/storyHome/qqstorylist/view/VideoListLayout:a	(ZIIII)V
    //   16: invokestatic 157	com/tencent/widget/TraceUtils:traceEnd	()V
    //   19: return
    //   20: astore 6
    //   22: goto +43 -> 65
    //   25: astore 6
    //   27: new 228	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   34: astore 7
    //   36: aload 7
    //   38: ldc 232
    //   40: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 7
    //   46: aload 6
    //   48: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: new 241	java/lang/Error
    //   55: dup
    //   56: aload 7
    //   58: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 247	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   64: athrow
    //   65: invokestatic 157	com/tencent/widget/TraceUtils:traceEnd	()V
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
    //   0: ldc 250
    //   2: invokestatic 103	com/tencent/widget/TraceUtils:traceBegin	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: iload_1
    //   7: iload_2
    //   8: invokevirtual 252	com/tencent/biz/qqstory/storyHome/qqstorylist/view/VideoListLayout:a	(II)V
    //   11: invokestatic 157	com/tencent/widget/TraceUtils:traceEnd	()V
    //   14: return
    //   15: astore_3
    //   16: goto +41 -> 57
    //   19: astore_3
    //   20: new 228	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: ldc 232
    //   33: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: aload_3
    //   40: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: new 241	java/lang/Error
    //   47: dup
    //   48: aload 4
    //   50: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 247	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   56: athrow
    //   57: invokestatic 157	com/tencent/widget/TraceUtils:traceEnd	()V
    //   60: aload_3
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	VideoListLayout
    //   0	62	1	paramInt1	int
    //   0	62	2	paramInt2	int
    //   15	1	3	localObject	Object
    //   19	42	3	localException	java.lang.Exception
    //   27	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	11	15	finally
    //   20	57	15	finally
    //   5	11	19	java/lang/Exception
  }
  
  public void setAddGroupGuide(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (!paramBoolean)
    {
      paramOnClickListener = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramOnClickListener != null) {
        paramOnClickListener.setVisibility(8);
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131561656, this, false));
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
  }
  
  public void setFailedTxt(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void setHorizontalViewHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMarginTop(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setSingleVideoSize(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout
 * JD-Core Version:    0.7.0.1
 */