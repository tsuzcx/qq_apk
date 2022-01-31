package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import ache;
import ajjy;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awqx;
import baip;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;
import vms;

public class ReminderCardItemPage
  extends ActivateBasePage
  implements View.OnClickListener
{
  public AcsMsg a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ActivateFriendActivity jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  
  public ReminderCardItemPage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReminderCardItemPage(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity = ((ActivateFriendActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramString != null) {
      paramImageView.setImageDrawable(paramString);
    }
  }
  
  private void a(String paramString)
  {
    if (baip.a(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = Uri.parse(paramString);
        } while (localObject == null);
        localObject = ((Uri)localObject).getScheme();
      } while (baip.a((String)localObject));
      if ((((String)localObject).startsWith("http")) || (((String)localObject).startsWith("https"))) {
        FakeUrl.gotoH5(getContext(), paramString, true, true);
      }
    } while (!((String)localObject).startsWith("mqqapi"));
    FakeUrl.gotoMqq(getContext(), paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495034, this, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298368));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298369));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298367));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298364));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298365));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius(vms.a(getContext(), 5.0F), true);
    this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298370));
    this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298363));
    this.i = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298361));
    this.i.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298362));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298366));
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(AcsMsg paramAcsMsg)
  {
    try
    {
      this.jdField_a_of_type_WalletAcsMsg = paramAcsMsg;
      if (paramAcsMsg == null)
      {
        this.f.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        a(this.jdField_a_of_type_AndroidWidgetImageView, "https://i.gtimg.cn/channel/imglib/201905/upload_d06258d2e506e8f9f37614f2826e8234.png");
        return;
      }
      this.f.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.f.setText(ache.a(paramAcsMsg.notice_time * 1000L, "HH:mm"));
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, "https://i.gtimg.cn/channel/imglib/201910/upload_a62b5e83214048120b15b81f8a2d7ec3.png");
      this.j.setText(ache.a(paramAcsMsg.sub_time * 1000L, "yyyy.MM.dd") + ajjy.a(2131651781) + paramAcsMsg.busi_name + ajjy.a(2131651782));
      this.g.setText(paramAcsMsg.title);
      this.h.setText(paramAcsMsg.content);
      this.jdField_b_of_type_AndroidWidgetButton.setText(paramAcsMsg.btn_text);
      this.jdField_b_of_type_AndroidWidgetButton.setTag(paramAcsMsg.jump_url);
      return;
    }
    catch (Throwable paramAcsMsg)
    {
      QLog.e("ReminderCardItemPage", 1, "initData throw an exception: " + paramAcsMsg);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298361: 
      if (this.jdField_a_of_type_WalletAcsMsg != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.all");
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.all", 0, 0, "", "", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id);
      }
      ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendActivity);
      return;
    }
    if (this.jdField_a_of_type_WalletAcsMsg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.click");
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.click", 0, 0, "", "", this.jdField_a_of_type_WalletAcsMsg.busi_id, this.jdField_a_of_type_WalletAcsMsg.msg_id);
    }
    a((String)paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage
 * JD-Core Version:    0.7.0.1
 */