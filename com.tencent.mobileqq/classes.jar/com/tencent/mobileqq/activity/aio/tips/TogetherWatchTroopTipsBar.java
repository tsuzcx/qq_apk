package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import mqq.app.AppRuntime;

public class TogetherWatchTroopTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString;
  
  public TogetherWatchTroopTipsBar(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, TipsManager paramTipsManager, Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TogetherWatchTroopTipsBar.");
    localStringBuilder.append(paramBaseSessionInfo.jdField_a_of_type_Int);
    localStringBuilder.append(".");
    localStringBuilder.append(paramBaseSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131558593, null);
      this.jdField_a_of_type_AndroidViewView.setId(2131378968);
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      float f = this.jdField_a_of_type_Float;
      ((View)localObject).setPadding(0, (int)(f * 2.0F), 0, (int)(f * 2.0F));
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      localObject = (ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368352);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379926);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368351);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839468);
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(2130839462);
        ((TextView)localObject).setTextColor(-1);
        localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839461));
      }
      ((TextView)localObject).setText(HardCodeUtil.a(2131714810));
    }
  }
  
  public int a()
  {
    return 67;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1))
    {
      paramVarArgs = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      if ((paramVarArgs != null) && (paramVarArgs.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())))
      {
        paramVarArgs = TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramVarArgs != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "troop ", paramVarArgs.jdField_a_of_type_JavaLangString, " newNum=", Integer.valueOf(paramVarArgs.b), " unreadNum=", Integer.valueOf(paramVarArgs.jdField_a_of_type_Int) });
          }
          a();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Admin but Not message");
        }
      }
    }
  }
  
  public int[] a()
  {
    return new int[2];
  }
  
  public int b()
  {
    return 24;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", "https://qvideo.qq.com/qq/together-signing/index.html");
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ReportController.b((AppRuntime)localObject, "dc00899", "Grp_AIO", "", "video_tab", "clk_whitebar", 0, 1, ((QQAppInterface)localObject).getCurrentUin(), "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TogetherWatchTroopTipsBar
 * JD-Core Version:    0.7.0.1
 */