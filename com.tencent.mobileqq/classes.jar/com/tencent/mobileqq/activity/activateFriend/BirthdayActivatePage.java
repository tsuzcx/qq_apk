package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class BirthdayActivatePage
  extends ActivateBasePage
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new BirthdayActivatePage.1(this);
  private ActivateFriendGrid.GridCallBack jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack = new BirthdayActivatePage.2(this);
  private WeakReference<ActivateFriendActivity> jdField_a_of_type_MqqUtilWeakReference;
  public long[] a;
  
  public BirthdayActivatePage(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((ActivateFriendActivity)paramContext);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131689529);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setGridCallBack(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack);
    this.e.setVisibility(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561037, this, false);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362002));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131361996));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362001));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361995));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)this.jdField_a_of_type_AndroidViewView.findViewById(2131367562));
    a((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362017));
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(BirthdayActivatePage.class.getSimpleName(), 2, "hideLoading ");
    }
    findViewById(2131363577).setVisibility(0);
    if (this.jdField_a_of_type_ArrayOfLong == null) {
      findViewById(2131366342).setVisibility(0);
    }
    for (;;)
    {
      findViewById(2131362000).setVisibility(8);
      return;
      findViewById(2131366342).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePage
 * JD-Core Version:    0.7.0.1
 */