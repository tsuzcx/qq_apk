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
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.util.ArrayList;
import mqq.util.WeakReference;
import ujc;
import ujd;
import uje;

public class PositionActivatePage
  extends ActivateBasePage
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ujd(this);
  private ActivateFriendGrid.GridCallBack jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack = new ujc(this);
  public String a;
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  private View.OnClickListener b;
  
  public PositionActivatePage(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new uje(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((ActivateFriendActivity)paramContext);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131437241);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setGridCallBack(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack);
    this.d.setVisibility(0);
    this.d.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970174, this, false);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369402));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369410));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369411));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131369406));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369412));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369407));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)this.jdField_a_of_type_AndroidViewView.findViewById(2131369405));
    a((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369403));
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, long[] paramArrayOfLong)
  {
    Object localObject = TimeFormatterUtils.a(getContext(), 3, paramLong);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c.setText(paramString);
    if (paramArrayOfLong.length > 1) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131437241);
    }
    for (;;)
    {
      paramString = new ArrayList(paramArrayOfLong.length);
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        localObject = new ActivateFriendItem(1, paramArrayOfLong[i]);
        ((ActivateFriendItem)localObject).birthdayDesc = " ";
        paramString.add(localObject);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131437242);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(paramQQAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.PositionActivatePage
 * JD-Core Version:    0.7.0.1
 */