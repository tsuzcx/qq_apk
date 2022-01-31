package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class PipeLinearLayout
  extends FrameLayout
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new PipeLinearLayout.1(this);
  private final ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131372735, 2131372736, 2131372737 };
  private Handler jdField_b_of_type_AndroidOsHandler;
  private final ArrayList<Long> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  
  public PipeLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PipeLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PipeLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private Bitmap a(long paramLong)
  {
    return null;
  }
  
  private String a()
  {
    return "";
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131559591, this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private boolean a(long paramLong)
  {
    return false;
  }
  
  private void b()
  {
    int i = 0;
    while ((i < this.jdField_a_of_type_ArrayOfInt.length) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      if (a(((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue())) {
        this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_b_of_type_AndroidOsHandler = null;
  }
  
  public void setHeadView(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public void setMemberList(Long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        Long localLong = paramArrayOfLong[i];
        this.jdField_a_of_type_JavaUtilArrayList.add(localLong);
        i += 1;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void setRelationShipViewParent(RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.PipeLinearLayout
 * JD-Core Version:    0.7.0.1
 */