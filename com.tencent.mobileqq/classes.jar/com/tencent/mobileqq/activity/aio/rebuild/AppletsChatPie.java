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
import com.tencent.mobileqq.activity.aio.coreui.msglist.BaseTroopScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
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
  private View bi;
  
  public AppletsChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void bA()
  {
    this.Y.setVisibility(8);
    this.X.setVisibility(8);
    this.i.p().d().c().a().setVisibility(8);
    this.k.d().b();
    this.W.setVisibility(8);
  }
  
  protected void C()
  {
    if ((this.ah != null) && (this.ah.s == 22))
    {
      this.m.post(new AppletsChatPie.1(this));
      return;
    }
    super.C();
  }
  
  protected void D()
  {
    super.D();
    this.p.setRight1Icon(2130841324, 2130841324);
  }
  
  public void K()
  {
    super.K();
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
      if (this.bi == null)
      {
        this.bi = LayoutInflater.from(this.e).inflate(2131624075, null);
        localObject = this.bi;
        if (localObject != null)
        {
          AnyScaleTypeImageView localAnyScaleTypeImageView = (AnyScaleTypeImageView)((View)localObject).findViewById(2131432506);
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
          localObject = (TextView)this.bi.findViewById(2131432526);
          if (localObject != null) {
            ((TextView)localObject).setText(QzoneConfig.getInstance().getConfig("qqminiapp", "miniappaioemptytips", "还没收到过小程序通知哦"));
          }
          if (this.o != null) {
            this.o.addView(this.bi, new ViewGroup.LayoutParams(-1, -1));
          }
        }
      }
      Object localObject = this.bi;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    return super.a(paramBoolean);
  }
  
  void bz()
  {
    View localView = this.bi;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  protected AIOContext d()
  {
    return new AppletsContext();
  }
  
  protected MsgList e()
  {
    return new MsgListBuilder(this.i).a(new BaseTroopScroller()).a(new ListUI(this.i)).a(new UnreadTask(this.i)).a(new AppletsMsgListRefresher(this.i)).a();
  }
  
  protected void l()
  {
    super.l();
    bA();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131436194) {
      super.onClick(paramView);
    } else {
      PublicFragmentActivity.a(aX(), AppletsSettingFragment.class);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.AppletsChatPie
 * JD-Core Version:    0.7.0.1
 */