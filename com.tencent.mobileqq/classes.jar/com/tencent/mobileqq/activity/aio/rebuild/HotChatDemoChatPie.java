package com.tencent.mobileqq.activity.aio.rebuild;

import ailn;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SimpleTextView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class HotChatDemoChatPie
  extends ailn
{
  protected LinearLayout b;
  protected String i;
  protected ImageView l;
  protected int q;
  protected int r;
  protected int s;
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(paramString2);
      str = paramString1;
      if (paramString2 != null) {
        str = paramString2.name;
      }
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        paramString1 = URLEncoder.encode(str, "UTF-8");
        paramString1 = String.format("https://play.mobile.qq.com/play/mqqplay/hotchat/jump.html?_bid=2152&hotnamecode=%s", new Object[] { paramString1 });
        if (QLog.isDevelopLevel()) {
          QLog.i("HotChatDemoChatPie", 4, "makeUrl: " + paramString1);
        }
        return paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = str;
        continue;
      }
      paramString1 = null;
    }
  }
  
  private void b(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      do
      {
        return;
        if (this.b != null) {
          break;
        }
        this.l = new ImageView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.q, this.q);
        int j = this.r;
        localLayoutParams.rightMargin = j;
        localLayoutParams.leftMargin = j;
        localLayoutParams.bottomMargin = j;
        localLayoutParams.topMargin = j;
        this.l.setLayoutParams(localLayoutParams);
        this.l.setImageDrawable(paramDrawable);
        paramDrawable = new SimpleTextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        paramDrawable.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131698128));
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = this.r;
        localLayoutParams.gravity = 1;
        paramDrawable.setLayoutParams(localLayoutParams);
        paramDrawable.setTextColor(Color.rgb(119, 119, 119));
        paramDrawable.setTextSize(1, 14.0F);
        paramDrawable.setGravity(1);
        this.b = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.b.setOrientation(1);
        this.b.addView(this.l);
        this.b.addView(paramDrawable);
        paramDrawable = new RelativeLayout.LayoutParams(-2, -2);
        paramDrawable.addRule(11);
        paramDrawable.addRule(15);
        paramDrawable.rightMargin = this.s;
        this.b.setLayoutParams(paramDrawable);
        this.b.setBackgroundResource(2130845468);
      } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.b);
      return;
    } while (this.l == null);
    this.l.setImageDrawable(paramDrawable);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "HotChatDemoChatPie";
  }
  
  public void ai()
  {
    super.ai();
    if (this.b == null)
    {
      if (TextUtils.isEmpty(this.i)) {
        this.i = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
      ThreadManager.getFileThreadHandler().post(new HotChatDemoChatPie.LoadQRCodeImg(this.i, this.jdField_a_of_type_MqqOsMqqHandler, this.q));
    }
  }
  
  public void d(Intent paramIntent)
  {
    this.u = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
      }
    }
    this.i = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
  }
  
  public void e(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698127);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698127));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
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
  
  public void z()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatDemoChatPie
 * JD-Core Version:    0.7.0.1
 */