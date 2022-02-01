package com.dataline.util.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.TextView;

public class WaitTextView
  extends TextView
{
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private WaitTextView.RefreshListener jdField_a_of_type_ComDatalineUtilWidgetWaitTextView$RefreshListener;
  private Runnable jdField_a_of_type_JavaLangRunnable = new WaitTextView.1(this);
  private String jdField_a_of_type_JavaLangString;
  
  public WaitTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WaitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WaitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("...");
          setText(localStringBuilder.toString());
          this.jdField_a_of_type_Int = 0;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(".. ");
        setText(localStringBuilder.toString());
        this.jdField_a_of_type_Int += 1;
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(".  ");
      setText(localStringBuilder.toString());
      this.jdField_a_of_type_Int += 1;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("   ");
    setText(localStringBuilder.toString());
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    }
  }
  
  public void b()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public void setRefreshListener(WaitTextView.RefreshListener paramRefreshListener)
  {
    this.jdField_a_of_type_ComDatalineUtilWidgetWaitTextView$RefreshListener = paramRefreshListener;
  }
  
  public void setWaitText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = 0;
    paramString = new StringBuilder();
    paramString.append(this.jdField_a_of_type_JavaLangString);
    paramString.append("   ");
    setText(paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.widget.WaitTextView
 * JD-Core Version:    0.7.0.1
 */