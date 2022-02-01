package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.StrangerRecomInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.config.GameCenterMsgBean;
import com.tencent.mobileqq.gamecenter.config.GameCenterMsgConfigProcessor;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.view.TriangleView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;

public class GameMsgChatHelper
  extends SimpleUIAIOHelper
{
  private ImageButton a;
  private GameMsgChatPie.StrangerRecomInfo b;
  private boolean h;
  
  private void a(View paramView)
  {
    PopupWindow localPopupWindow = new PopupWindow(paramView.getContext());
    localPopupWindow.setBackgroundDrawable(null);
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(paramView.getContext()).inflate(2131624896, null);
    localViewGroup.measure(0, 0);
    localPopupWindow.setContentView(localViewGroup);
    localPopupWindow.setOutsideTouchable(true);
    localPopupWindow.setFocusable(true);
    Object localObject = (TriangleView)localViewGroup.findViewById(2131447860);
    int i = ((TriangleView)localObject).getMeasuredWidth() / 2;
    int j = ((ViewGroup.MarginLayoutParams)((TriangleView)localObject).getLayoutParams()).rightMargin;
    localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    localPopupWindow.showAtLocation(paramView, 51, localObject[0] + paramView.getMeasuredWidth() / 2 - localViewGroup.getMeasuredWidth() + (i + j), localObject[1] - localViewGroup.getMeasuredHeight());
  }
  
  private GameDetailInfo e()
  {
    return ((GameMsgChatPie)this.c).bH();
  }
  
  private SessionInfo h()
  {
    return this.c.aE();
  }
  
  private void i()
  {
    if (this.a != null) {
      return;
    }
    Object localObject = e();
    if ((localObject != null) && ("1104466820".equals(((GameDetailInfo)localObject).c)))
    {
      localObject = GameCenterMsgConfigProcessor.a();
      if (localObject != null)
      {
        if (!((GameCenterMsgBean)localObject).k) {
          return;
        }
        localObject = (ViewStub)this.c.X.findViewById(2131428096);
        if (localObject != null)
        {
          this.a = ((ImageButton)((ViewStub)localObject).inflate());
          this.a.setBackgroundResource(2130840496);
          this.a.setOnClickListener(this);
          this.a.setVisibility(0);
          k();
          if (!((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getAIOGameEntryShown(this.c.i().getAccount())) {
            this.a.getViewTreeObserver().addOnPreDrawListener(new GameMsgChatHelper.1(this));
          }
        }
      }
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this.c.aX(), QQBrowserActivity.class);
    String str = h().c();
    localIntent.putExtra("url", String.format("https://imgcache.qq.com/ogame/sgame-team/index.html#/subscribe-form?_wv=7&gameappid=%s&fromRoleid=%s&toRoleid=%s&pvsrc=msg-helper", new Object[] { "1104466820", h().d(), str }));
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    this.c.aX().startActivity(localIntent);
  }
  
  private void k()
  {
    if ((!this.h) && (this.a != null) && (this.b != null))
    {
      this.h = true;
      IGameMsgHelperApi localIGameMsgHelperApi = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
      String str1;
      if (this.b.a == 0) {
        str1 = "92015";
      } else {
        str1 = "92005";
      }
      String str2;
      if (this.b.a == 0) {
        str2 = "207979";
      } else {
        str2 = "207977";
      }
      localIGameMsgHelperApi.reportForGameMsg("1104466820", "1", "145", "920", str1, str2, "", "", "20", h().c(), h().d(), "");
    }
  }
  
  private void r()
  {
    if (this.b != null)
    {
      String str1;
      if ((this.c != null) && (this.c.i() != null)) {
        str1 = ((IGameMsgManagerService)this.c.i().getRuntimeService(IGameMsgManagerService.class, "all")).getAIORedDotStyleId();
      } else {
        str1 = "";
      }
      IGameMsgHelperApi localIGameMsgHelperApi = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
      String str2;
      if (this.b.a == 0) {
        str2 = "92015";
      } else {
        str2 = "92005";
      }
      String str3;
      if (this.b.a == 0) {
        str3 = "207980";
      } else {
        str3 = "207978";
      }
      localIGameMsgHelperApi.reportForGameMsg865WithTianJi("1104466820", "1", "145", "920", str2, str3, "", "", "20", h().c(), h().d(), "", str1);
    }
  }
  
  protected void a()
  {
    super.a();
    if (this.e != null) {
      this.e.setVisibility(8);
    }
    if (this.c.Z != null)
    {
      Object localObject1 = (LinearLayout)this.c.aZ.findViewById(2131433921);
      Object localObject2 = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = this.c.Z;
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.c.Z.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).width = AIOUtils.b(60.0F, this.c.f.getResources());
        ((LinearLayout.LayoutParams)localObject2).height = AIOUtils.b(34.0F, this.c.f.getResources());
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.c.Z.setVisibility(0);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.c.Z.setBackgroundResource(g());
        this.c.Z.setText(2131887750);
        if (AppSetting.e) {
          this.c.Z.setContentDescription(HardCodeUtil.a(2131911585));
        }
      }
      this.c.Z.setEnabled(false);
    }
    i();
  }
  
  protected void b()
  {
    this.g = true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.f != null) {
      this.f.setSelected(false);
    }
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    try
    {
      super.d();
      LinearLayout localLinearLayout = (LinearLayout)this.c.aZ.findViewById(2131433921);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLinearLayout.setLayoutParams(localLayoutParams);
      if (TextUtils.isEmpty(this.c.Y.getText().toString()))
      {
        this.c.Z.setEnabled(false);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GameMsgChatHelper", 1, localThrowable.getMessage());
    }
  }
  
  public void g_(boolean paramBoolean) {}
  
  public String getTag()
  {
    return "GameMsgChatHelper";
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131432400)
    {
      if (i == 2131433961)
      {
        j();
        r();
        break label91;
      }
    }
    else
    {
      GameDetailInfo localGameDetailInfo = e();
      if (localGameDetailInfo != null) {
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(localGameDetailInfo.c, "1", "145", "920", "92005", "206353", "", "", "20", "0");
      }
    }
    super.onClick(paramView);
    label91:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgChatHelper
 * JD-Core Version:    0.7.0.1
 */