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
  protected ContactBaseView.IAddContactContext a;
  protected Context b;
  protected QQAppInterface c;
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      paramString = JumpParser.a(this.a.a(), this.a.b(), paramString);
      if (paramString != null) {
        paramString.a();
      }
    }
    else
    {
      Intent localIntent = new Intent(this.b, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      this.b.startActivity(localIntent);
    }
  }
  
  public void setContentView(int paramInt)
  {
    LayoutInflater.from(this.b).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.BaseTroopCardView
 * JD-Core Version:    0.7.0.1
 */