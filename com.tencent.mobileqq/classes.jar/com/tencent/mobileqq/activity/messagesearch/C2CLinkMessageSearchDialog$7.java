package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class C2CLinkMessageSearchDialog$7
  implements AdapterView.OnItemClickListener
{
  C2CLinkMessageSearchDialog$7(C2CLinkMessageSearchDialog paramC2CLinkMessageSearchDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("onItemClick, position = ");
      paramAdapterView.append(paramInt);
      QLog.i("LinkMessageSearchDialog", 2, paramAdapterView.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CLinkMessageResultAdapter.getCount() > 0)
    {
      if (paramInt <= 0) {
        return;
      }
      paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CLinkMessageResultAdapter.a(paramInt - 1);
      if (paramAdapterView != null)
      {
        paramView = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramView.putExtra("url", paramAdapterView.url);
        this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        return;
      }
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("link element is null pos:");
      paramAdapterView.append(paramInt);
      QLog.e("LinkMessageSearchDialog", 2, paramAdapterView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageSearchDialog.7
 * JD-Core Version:    0.7.0.1
 */