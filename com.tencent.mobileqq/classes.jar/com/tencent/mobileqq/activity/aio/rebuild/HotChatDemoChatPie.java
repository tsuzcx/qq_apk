package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SimpleTextView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class HotChatDemoChatPie
  extends HotChatPie
{
  protected LinearLayout a;
  protected String d;
  protected int g;
  protected int h;
  protected int i;
  protected ImageView l;
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString2);
      str = paramString1;
      if (paramString2 != null) {
        str = paramString2.name;
      }
    }
    if (!TextUtils.isEmpty(str))
    {
      try
      {
        paramString1 = URLEncoder.encode(str, "UTF-8");
        str = paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
      }
      paramString1 = String.format("https://play.mobile.qq.com/play/mqqplay/hotchat/jump.html?_bid=2152&hotnamecode=%s", new Object[] { str });
    }
    else
    {
      paramString1 = null;
    }
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("makeUrl: ");
      paramString2.append(paramString1);
      QLog.i("HotChatDemoChatPie", 4, paramString2.toString());
    }
    return paramString1;
  }
  
  private void b(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.l = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
      int j = this.g;
      localObject = new LinearLayout.LayoutParams(j, j);
      j = this.h;
      ((LinearLayout.LayoutParams)localObject).rightMargin = j;
      ((LinearLayout.LayoutParams)localObject).leftMargin = j;
      ((LinearLayout.LayoutParams)localObject).bottomMargin = j;
      ((LinearLayout.LayoutParams)localObject).topMargin = j;
      this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.l.setImageDrawable(paramDrawable);
      paramDrawable = new SimpleTextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramDrawable.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getText(2131698962));
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).bottomMargin = this.h;
      ((LinearLayout.LayoutParams)localObject).gravity = 1;
      paramDrawable.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramDrawable.setTextColor(Color.rgb(119, 119, 119));
      paramDrawable.setTextSize(1, 14.0F);
      paramDrawable.setGravity(1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.l);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramDrawable);
      paramDrawable = new RelativeLayout.LayoutParams(-2, -2);
      paramDrawable.addRule(11);
      paramDrawable.addRule(15);
      paramDrawable.rightMargin = this.i;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramDrawable);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845622);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      }
    }
    else
    {
      localObject = this.l;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(paramDrawable);
      }
    }
  }
  
  protected void K()
  {
    super.K();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      if (TextUtils.isEmpty(this.d)) {
        this.d = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
      ThreadManager.getFileThreadHandler().post(new HotChatDemoChatPie.LoadQRCodeImg(this.d, this.jdField_a_of_type_MqqOsMqqHandler, this.g));
    }
  }
  
  protected void c()
  {
    this.b = "HotChatDemoChatPie";
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  protected void d(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
      }
    }
    this.d = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
  }
  
  protected void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
  }
  
  protected void e(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698961);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698961));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 34)
    {
      Drawable localDrawable = null;
      if ((paramMessage.obj instanceof Drawable)) {
        localDrawable = (Drawable)paramMessage.obj;
      }
      if (paramMessage.arg1 == 2) {
        b(localDrawable);
      }
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatDemoChatPie
 * JD-Core Version:    0.7.0.1
 */