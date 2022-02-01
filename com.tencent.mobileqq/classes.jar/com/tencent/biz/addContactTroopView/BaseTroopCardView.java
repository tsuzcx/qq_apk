package com.tencent.biz.addContactTroopView;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;

public abstract class BaseTroopCardView
  extends RelativeLayout
{
  protected Context a;
  protected ContactBaseView.IAddContactContext a;
  protected QQAppInterface a;
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return;
      }
      paramString = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), paramString);
    } while (paramString == null);
    paramString.a();
  }
  
  public void setContentView(int paramInt)
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.BaseTroopCardView
 * JD-Core Version:    0.7.0.1
 */