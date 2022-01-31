package com.dataline.util.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.TextView;
import dp;

public class WaitTextView
  extends TextView
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private WaitTextView.RefreshListener jdField_a_of_type_ComDatalineUtilWidgetWaitTextView$RefreshListener;
  private Runnable jdField_a_of_type_JavaLangRunnable = new dp(this);
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
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      setText(this.jdField_a_of_type_JavaLangString + "...");
      this.jdField_a_of_type_Int = 0;
      return;
    case 0: 
      setText(this.jdField_a_of_type_JavaLangString + "   ");
      this.jdField_a_of_type_Int += 1;
      return;
    case 1: 
      setText(this.jdField_a_of_type_JavaLangString + ".  ");
      this.jdField_a_of_type_Int += 1;
      return;
    }
    setText(this.jdField_a_of_type_JavaLangString + ".. ");
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
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
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
    setText(this.jdField_a_of_type_JavaLangString + "   ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.util.widget.WaitTextView
 * JD-Core Version:    0.7.0.1
 */