package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.AppletsMsgListRefresher;
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
  private View m;
  
  public AppletsChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private void bj()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
  }
  
  public void A()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c == 22))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new AppletsChatPie.1(this));
      return;
    }
    super.A();
  }
  
  public void B()
  {
    super.B();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130840683, 2130840683);
  }
  
  public void J()
  {
    super.J();
  }
  
  public AIOContext a()
  {
    return new AppletsContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  public MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new AppletsMsgListRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  void a()
  {
    int i;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioshowemptyview", 1) == 1) {
      i = 1;
    }
    for (;;)
    {
      AnyScaleTypeImageView localAnyScaleTypeImageView;
      Object localObject;
      if (i != 0) {
        if (this.m == null)
        {
          this.m = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558622, null);
          if (this.m != null)
          {
            localAnyScaleTypeImageView = (AnyScaleTypeImageView)this.m.findViewById(2131366330);
            if (localAnyScaleTypeImageView != null) {
              localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioemptybackgroundurl", "https://qzonestyle.gtimg.cn/aoi/sola/20190329164016_N0Y2CuctLc.png");
            }
          }
        }
      }
      try
      {
        localAnyScaleTypeImageView.setImageURL((String)localObject);
        localObject = (TextView)this.m.findViewById(2131366346);
        if (localObject != null) {
          ((TextView)localObject).setText(QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioemptytips", "还没收到过小程序通知哦"));
        }
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.m, new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.m != null) {
          this.m.setVisibility(0);
        }
        return;
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("AppletsChatPie", 1, "initEmptyLayout set image error! url: " + (String)localObject, localThrowable);
        }
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
  
  void bi()
  {
    if (this.m != null) {
      this.m.setVisibility(8);
    }
  }
  
  public void g()
  {
    super.g();
    bj();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PublicFragmentActivity.a(a(), AppletsSettingFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.AppletsChatPie
 * JD-Core Version:    0.7.0.1
 */