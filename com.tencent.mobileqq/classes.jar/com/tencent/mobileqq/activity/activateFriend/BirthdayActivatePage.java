package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;
import uja;
import ujb;

public class BirthdayActivatePage
  extends ActivateBasePage
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new uja(this);
  private ActivateFriendGrid.GridCallBack jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack = new ujb(this);
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  public long[] a;
  
  public BirthdayActivatePage(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((ActivateFriendActivity)paramContext);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131437248);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setGridCallBack(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack);
    this.e.setVisibility(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970173, this, false);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369402));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131369406));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369412));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369407));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)this.jdField_a_of_type_AndroidViewView.findViewById(2131369405));
    a((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369403));
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, long[] paramArrayOfLong1, String[] paramArrayOfString, long[] paramArrayOfLong2)
  {
    Object localObject = TimeFormatterUtils.a(getContext(), 3, paramLong);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong1;
    if (paramArrayOfLong1 == null)
    {
      findViewById(2131366489).setVisibility(0);
      findViewById(2131369404).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(paramQQAppInterface, new ArrayList());
      return;
    }
    findViewById(2131366489).setVisibility(8);
    findViewById(2131369404).setVisibility(0);
    localObject = new ArrayList(paramArrayOfLong1.length);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      ActivateFriendItem localActivateFriendItem = new ActivateFriendItem(2, paramArrayOfLong1[i]);
      localActivateFriendItem.birthdayDesc = paramArrayOfString[i];
      localActivateFriendItem.birthSendTime = paramArrayOfLong2[i];
      ((ArrayList)localObject).add(localActivateFriendItem);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(paramQQAppInterface, (ArrayList)localObject);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007AD0", "0X8007AD0", 0, 0, "", "", "", "");
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(BirthdayActivatePage.class.getSimpleName(), 2, "showLoading ");
    }
    findViewById(2131369401).setVisibility(8);
    findViewById(2131369408).setVisibility(0);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(BirthdayActivatePage.class.getSimpleName(), 2, "hideLoading ");
    }
    findViewById(2131369401).setVisibility(0);
    if (this.jdField_a_of_type_ArrayOfLong == null) {
      findViewById(2131366489).setVisibility(0);
    }
    for (;;)
    {
      findViewById(2131369408).setVisibility(8);
      return;
      findViewById(2131366489).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePage
 * JD-Core Version:    0.7.0.1
 */