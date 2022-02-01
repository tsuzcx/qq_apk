package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.AppletsMsgListRefresher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import mqq.os.MqqHandler;

public class AppletsChatPie
  extends BaseChatPie
{
  private View g;
  
  public AppletsChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void ap()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a().setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
  }
  
  protected AIOContext a()
  {
    return new AppletsContext();
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new AppletsMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  void a()
  {
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioshowemptyview", 1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.g == null)
      {
        this.g = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558522, null);
        localObject = this.g;
        if (localObject != null)
        {
          AnyScaleTypeImageView localAnyScaleTypeImageView = (AnyScaleTypeImageView)((View)localObject).findViewById(2131366218);
          if (localAnyScaleTypeImageView != null)
          {
            localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioemptybackgroundurl", "https://qzonestyle.gtimg.cn/aoi/sola/20190329164016_N0Y2CuctLc.png");
            try
            {
              localAnyScaleTypeImageView.setImageURL((String)localObject);
            }
            catch (Throwable localThrowable)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("initEmptyLayout set image error! url: ");
              localStringBuilder.append((String)localObject);
              QLog.e("AppletsChatPie", 1, localStringBuilder.toString(), localThrowable);
            }
          }
          localObject = (TextView)this.g.findViewById(2131366234);
          if (localObject != null) {
            ((TextView)localObject).setText(QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioemptytips", "还没收到过小程序通知哦"));
          }
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.g, new ViewGroup.LayoutParams(-1, -1));
          }
        }
      }
      Object localObject = this.g;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
  
  void ao()
  {
    View localView = this.g;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  protected void e()
  {
    super.e();
    ap();
  }
  
  protected void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == 22))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new AppletsChatPie.1(this));
      return;
    }
    super.l();
  }
  
  protected void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130840558, 2130840558);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131369216) {
      super.onClick(paramView);
    } else {
      PublicFragmentActivity.a(a(), AppletsSettingFragment.class);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    super.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.AppletsChatPie
 * JD-Core Version:    0.7.0.1
 */