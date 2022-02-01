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
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
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
  protected LinearLayout b;
  protected String h;
  protected int k;
  protected int l;
  protected ImageView l;
  protected int m;
  
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
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          break;
        }
        this.jdField_l_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_l_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.k, this.k);
        int i = this.jdField_l_of_type_Int;
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localLayoutParams.bottomMargin = i;
        localLayoutParams.topMargin = i;
        this.jdField_l_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        this.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        paramDrawable = new SimpleTextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        paramDrawable.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131698883));
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = this.jdField_l_of_type_Int;
        localLayoutParams.gravity = 1;
        paramDrawable.setLayoutParams(localLayoutParams);
        paramDrawable.setTextColor(Color.rgb(119, 119, 119));
        paramDrawable.setTextSize(1, 14.0F);
        paramDrawable.setGravity(1);
        this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_l_of_type_AndroidWidgetImageView);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramDrawable);
        paramDrawable = new RelativeLayout.LayoutParams(-2, -2);
        paramDrawable.addRule(11);
        paramDrawable.addRule(15);
        paramDrawable.rightMargin = this.m;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramDrawable);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845749);
      } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
      return;
    } while (this.jdField_l_of_type_AndroidWidgetImageView == null);
    this.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void ae()
  {
    super.ae();
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
    {
      if (TextUtils.isEmpty(this.h)) {
        this.h = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      }
      ThreadManager.getFileThreadHandler().post(new HotChatDemoChatPie.LoadQRCodeImg(this.h, this.jdField_a_of_type_MqqOsMqqHandler, this.k));
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "HotChatDemoChatPie";
  }
  
  public void d(Intent paramIntent)
  {
    this.r = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.troopcode;
      }
    }
    this.h = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
  }
  
  public void e(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698882);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698882));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatDemoChatPie
 * JD-Core Version:    0.7.0.1
 */