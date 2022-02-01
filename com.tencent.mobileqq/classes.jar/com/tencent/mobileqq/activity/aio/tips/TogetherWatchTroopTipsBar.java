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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

public class TogetherWatchTroopTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString;
  
  public TogetherWatchTroopTipsBar(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, TipsManager paramTipsManager, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = ("TogetherWatchTroopTipsBar." + paramSessionInfo.jdField_a_of_type_Int + "." + paramSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a()
  {
    Object localObject;
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131558695, null);
      this.jdField_a_of_type_AndroidViewView.setId(2131379624);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, (int)(this.jdField_a_of_type_Float * 2.0F), 0, (int)(this.jdField_a_of_type_Float * 2.0F));
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      localObject = (ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368613);
      localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380647);
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368612);
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label147;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839610);
    }
    for (;;)
    {
      ((TextView)localObject).setText(HardCodeUtil.a(2131714880));
      return;
      label147:
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(2130839604);
      ((TextView)localObject).setTextColor(-1);
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839603));
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
    if ((paramInt == 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
    {
      paramVarArgs = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((paramVarArgs != null) && (paramVarArgs.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())))
      {
        paramVarArgs = TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramVarArgs == null) {
          break label161;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "troop ", paramVarArgs.jdField_a_of_type_JavaLangString, " newNum=", Integer.valueOf(paramVarArgs.b), " unreadNum=", Integer.valueOf(paramVarArgs.jdField_a_of_type_Int) });
        }
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
      }
    }
    label161:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Admin but Not message");
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
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://qvideo.qq.com/qq/together-signing/index.html");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "video_tab", "clk_whitebar", 0, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TogetherWatchTroopTipsBar
 * JD-Core Version:    0.7.0.1
 */