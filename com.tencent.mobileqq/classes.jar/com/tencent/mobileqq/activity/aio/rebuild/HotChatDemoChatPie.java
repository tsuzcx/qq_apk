package com.tencent.mobileqq.activity.aio.rebuild;

import ahgz;
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
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SimpleTextView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class HotChatDemoChatPie
  extends ahgz
{
  protected int a;
  protected ImageView a;
  protected LinearLayout a;
  protected int b;
  protected int c;
  protected String d;
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = ((HotChatManager)this.app.getManager(60)).a(paramString2);
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
  
  private void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.mActivity);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
        int i = this.b;
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localLayoutParams.bottomMargin = i;
        localLayoutParams.topMargin = i;
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        paramDrawable = new SimpleTextView(this.mActivity);
        paramDrawable.setText(this.mActivity.getText(2131698293));
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = this.b;
        localLayoutParams.gravity = 1;
        paramDrawable.setLayoutParams(localLayoutParams);
        paramDrawable.setTextColor(Color.rgb(119, 119, 119));
        paramDrawable.setTextSize(1, 14.0F);
        paramDrawable.setGravity(1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.mActivity);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramDrawable);
        paramDrawable = new RelativeLayout.LayoutParams(-2, -2);
        paramDrawable.addRule(11);
        paramDrawable.addRule(15);
        paramDrawable.rightMargin = this.c;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramDrawable);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845347);
      } while (this.mContent == null);
      this.mContent.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      return;
    } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  public void doOnCreate_initUI()
  {
    super.doOnCreate_initUI();
    if (this.mInputBar != null) {
      this.mInputBar.setVisibility(8);
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
        a(localDrawable);
      }
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void leftBackEvent(boolean paramBoolean)
  {
    super.leftBackEvent(paramBoolean);
    this.mActivity.finish();
  }
  
  public void onShow()
  {
    super.onShow();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      if (TextUtils.isEmpty(this.d)) {
        this.d = a(this.sessionInfo.curFriendNick, this.sessionInfo.troopUin);
      }
      ThreadManager.getFileThreadHandler().post(new HotChatDemoChatPie.LoadQRCodeImg(this.d, this.uiHandler, this.jdField_a_of_type_Int));
    }
  }
  
  public void setTag()
  {
    this.tag = "HotChatDemoChatPie";
  }
  
  public void updateSession_business(Intent paramIntent)
  {
    this.mCacnelSellPttPanle = true;
    if ((this.sessionInfo.troopUin == null) || (this.sessionInfo.troopUin.length() == 0))
    {
      paramIntent = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.curFriendUin);
      if (paramIntent != null) {
        this.sessionInfo.troopUin = paramIntent.troopcode;
      }
    }
    this.d = a(this.sessionInfo.curFriendNick, this.sessionInfo.troopUin);
  }
  
  public void updateSession_updateTitleLeftView(Intent paramIntent)
  {
    if (this.mTitleBtnLeft != null)
    {
      this.mTitleBtnLeft.setText(2131698292);
      this.mTitleBtnLeft.setContentDescription(this.mActivity.getString(2131698292));
      this.mTitleBtnLeft.setBackgroundDrawable(null);
    }
  }
  
  public void updateSession_updateTitleRightView()
  {
    if (this.mTitleBtnRight != null) {
      this.mTitleBtnRight.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatDemoChatPie
 * JD-Core Version:    0.7.0.1
 */