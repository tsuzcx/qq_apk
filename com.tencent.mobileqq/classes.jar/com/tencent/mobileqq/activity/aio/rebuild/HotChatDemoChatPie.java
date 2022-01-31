package com.tencent.mobileqq.activity.aio.rebuild;

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
import vrl;

public class HotChatDemoChatPie
  extends HotChatPie
{
  protected LinearLayout d;
  protected String h;
  protected int m;
  protected int n;
  protected ImageView n;
  protected int o;
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramString2);
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
        paramString1 = String.format("http://play.mobile.qq.com/play/mqqplay/hotchat/jump.html?_bid=2152&hotnamecode=%s", new Object[] { paramString1 });
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
        if (this.d != null) {
          break;
        }
        this.jdField_n_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_n_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.m, this.m);
        int i = this.jdField_n_of_type_Int;
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localLayoutParams.bottomMargin = i;
        localLayoutParams.topMargin = i;
        this.jdField_n_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        this.jdField_n_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        paramDrawable = new SimpleTextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        paramDrawable.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131438060));
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = this.jdField_n_of_type_Int;
        localLayoutParams.gravity = 1;
        paramDrawable.setLayoutParams(localLayoutParams);
        paramDrawable.setTextColor(Color.rgb(119, 119, 119));
        paramDrawable.setTextSize(1, 14.0F);
        paramDrawable.setGravity(1);
        this.d = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.d.setOrientation(1);
        this.d.addView(this.jdField_n_of_type_AndroidWidgetImageView);
        this.d.addView(paramDrawable);
        paramDrawable = new RelativeLayout.LayoutParams(-2, -2);
        paramDrawable.addRule(11);
        paramDrawable.addRule(15);
        paramDrawable.rightMargin = this.o;
        this.d.setLayoutParams(paramDrawable);
        this.d.setBackgroundResource(2130842688);
      } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.d);
      return;
    } while (this.jdField_n_of_type_AndroidWidgetImageView == null);
    this.jdField_n_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  protected void X()
  {
    super.X();
    if (this.d == null)
    {
      if (TextUtils.isEmpty(this.h)) {
        this.h = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
      ThreadManager.getFileThreadHandler().post(new vrl(this.h, this.jdField_a_of_type_MqqOsMqqHandler, this.m));
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.b != null) {
      this.b.setVisibility(8);
    }
  }
  
  protected void d(Intent paramIntent)
  {
    this.r = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
      }
    }
    this.h = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
  }
  
  protected void e(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438058);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131438058));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
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
  
  protected void u()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatDemoChatPie
 * JD-Core Version:    0.7.0.1
 */