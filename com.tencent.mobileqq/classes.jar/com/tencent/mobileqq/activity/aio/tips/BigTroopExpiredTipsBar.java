package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.LiangGroupHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BigTroopExpiredTipsBar
  implements View.OnClickListener, TipsBarTask
{
  public static String a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://imgcache.qq.com/club/client/group/release/index.html?_bid=199&groupId=%s&from=%s";
  }
  
  public BigTroopExpiredTipsBar(QQAppInterface paramQQAppInterface, Context paramContext, TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
  }
  
  public int a()
  {
    return 25;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558694, null);
    ImageView localImageView1 = (ImageView)paramVarArgs.findViewById(2131362567);
    ImageView localImageView2 = (ImageView)paramVarArgs.findViewById(2131362577);
    ((TextView)paramVarArgs.findViewById(2131362578)).setText(this.jdField_a_of_type_AndroidTextSpannableString);
    if (this.jdField_a_of_type_Int == 0)
    {
      localImageView1.setImageResource(2130839613);
      paramVarArgs.setBackgroundResource(2130839610);
      localImageView2.setImageResource(2130850557);
    }
    for (;;)
    {
      paramVarArgs.setOnClickListener(this);
      return paramVarArgs;
      localImageView1.setImageResource(2130844381);
      paramVarArgs.setBackgroundResource(2130847518);
      localImageView2.setImageResource(2130844537);
      localImageView2.setOnClickListener(this);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidTextSpannableString = paramSpannableString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if ((paramInt2 == 3) || (paramInt2 == 4)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 23;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BigTroopExpiredTipsBar", 2, "click tips, jump");
        }
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", String.format(jdField_a_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString, "group_aio_tip" }));
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009E34", this.jdField_b_of_type_Int, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      }
      TroopManager.LiangGroupHelper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, "group_aio_tip");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_b_of_type_Int == 3) {}
      for (localObject = "0X800A57A";; localObject = "0X800A57C")
      {
        ReportController.b(localQQAppInterface, "dc00898", "", "", "qq_vip", (String)localObject, 1, 0, "", "", "", "");
        break;
      }
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      int i = ((TroopManager)localObject).f(this.jdField_b_of_type_JavaLangString);
      ((TroopManager)localObject).g(this.jdField_b_of_type_JavaLangString, i + 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    } while (!this.jdField_a_of_type_Boolean);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_b_of_type_Int == 3) {}
    for (Object localObject = "0X800A57A";; localObject = "0X800A57C")
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "qq_vip", (String)localObject, 2, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.BigTroopExpiredTipsBar
 * JD-Core Version:    0.7.0.1
 */