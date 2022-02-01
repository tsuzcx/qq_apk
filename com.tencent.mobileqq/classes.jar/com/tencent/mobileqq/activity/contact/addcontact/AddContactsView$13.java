package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.qphone.base.util.QLog;

class AddContactsView$13
  implements Runnable
{
  AddContactsView$13(AddContactsView paramAddContactsView) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.i != null)
      {
        if (this.this$0.D != null) {
          return;
        }
        View localView = ((LayoutInflater)this.this$0.F.getSystemService("layout_inflater")).inflate(2131624052, this.this$0.i, false);
        localView.measure(0, 0);
        this.this$0.D = new PopupWindow(localView);
        this.this$0.D.setHeight(-2);
        this.this$0.D.setWidth(-2);
        this.this$0.D.setOutsideTouchable(false);
        this.this$0.D.setFocusable(false);
        int i = ViewUtils.dip2px(16.0F);
        int j = -localView.getMeasuredHeight();
        int k = this.this$0.i.getMeasuredHeight();
        int m = ViewUtils.dip2px(24.0F);
        this.this$0.D.showAsDropDown(this.this$0.i, i, j - k + m);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AddContactsView", 1, "face2faceGuideTipsRunnable exception, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.13
 * JD-Core Version:    0.7.0.1
 */