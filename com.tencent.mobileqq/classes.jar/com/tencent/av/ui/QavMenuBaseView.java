package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QavMenuBaseView
  extends RelativeLayout
{
  protected VideoAppInterface a;
  protected QavPanel a;
  protected String a;
  
  public QavMenuBaseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavMenuBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavMenuBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], onBegin[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
  }
  
  public void a(QavPanel paramQavPanel)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate, panel[");
      localStringBuilder.append(paramQavPanel);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel = paramQavPanel;
    if (paramQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramQavPanel.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHide, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], onBegin[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "refreshUI");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavMenuBaseView
 * JD-Core Version:    0.7.0.1
 */