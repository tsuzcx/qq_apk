package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QavMenuBaseView
  extends RelativeLayout
{
  public VideoAppInterface a;
  protected QavPanel a;
  public String a;
  
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
  
  public void a(QavPanel paramQavPanel)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onCreate, panel[" + paramQavPanel + "]");
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel = paramQavPanel;
    if (paramQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramQavPanel.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onDestroy, seq[" + paramLong + "]");
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onShow, seq[" + paramLong + "], onBegin[" + paramBoolean + "]");
    }
  }
  
  public void d(long paramLong, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onHide, seq[" + paramLong + "], onBegin[" + paramBoolean + "]");
    }
  }
  
  public void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "refreshUI");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavMenuBaseView
 * JD-Core Version:    0.7.0.1
 */