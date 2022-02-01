package com.tencent.mobileqq.activity.contact.troop;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

class TroopActivity$GetUnReadNumRunnable
  implements Runnable
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<TroopActivity> jdField_a_of_type_MqqUtilWeakReference;
  
  public TroopActivity$GetUnReadNumRunnable(QQAppInterface paramQQAppInterface, WeakReference<TroopActivity> paramWeakReference, TextView paramTextView, ImageView paramImageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (!((TroopActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).isFinishing()) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b();
      ThreadManager.getUIHandler().post(new TroopActivity.GetUnReadNumRunnable.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.GetUnReadNumRunnable
 * JD-Core Version:    0.7.0.1
 */