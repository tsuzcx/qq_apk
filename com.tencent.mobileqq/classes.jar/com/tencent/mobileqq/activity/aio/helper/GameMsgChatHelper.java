package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.config.business.GameCenterMsgBean;
import com.tencent.mobileqq.config.business.GameCenterMsgConfigProcessor;
import com.tencent.mobileqq.gamecenter.message.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.view.TriangleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;

public class GameMsgChatHelper
  extends SimpleUIAIOHelper
{
  public static final String a;
  private GameMsgChatPie.StrangerRecomInfo jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo;
  private GameDetailInfo jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo;
  private ImageButton jdField_c_of_type_AndroidWidgetImageButton;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = GameCenterUnissoHandler.jdField_a_of_type_JavaLangString + "GameMsgChatHelper";
  }
  
  public GameMsgChatHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
    if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof GameMsgChatPie)) {
      throw new IllegalArgumentException("A GameMsgChatPie is required");
    }
  }
  
  private SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
  }
  
  private GameDetailInfo a()
  {
    return ((GameMsgChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).c();
  }
  
  private void a(View paramView)
  {
    PopupWindow localPopupWindow = new PopupWindow(paramView.getContext());
    localPopupWindow.setBackgroundDrawable(null);
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(paramView.getContext()).inflate(2131559267, null);
    localViewGroup.measure(0, 0);
    localPopupWindow.setContentView(localViewGroup);
    localPopupWindow.setOutsideTouchable(true);
    localPopupWindow.setFocusable(true);
    Object localObject = (TriangleView)localViewGroup.findViewById(2131379795);
    int i = ((TriangleView)localObject).getMeasuredWidth() / 2;
    int j = ((ViewGroup.MarginLayoutParams)((TriangleView)localObject).getLayoutParams()).rightMargin;
    localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    localPopupWindow.showAtLocation(paramView, 51, j + i + (localObject[0] + paramView.getMeasuredWidth() / 2 - localViewGroup.getMeasuredWidth()), localObject[1] - localViewGroup.getMeasuredHeight());
  }
  
  private void h()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageButton != null) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = a();
          } while ((localObject == null) || (!"1104466820".equals(((GameDetailInfo)localObject).d)));
          localObject = GameCenterMsgConfigProcessor.a();
        } while ((localObject == null) || (!((GameCenterMsgBean)localObject).a));
        localObject = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131362531);
      } while (localObject == null);
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)((ViewStub)localObject).inflate());
      this.jdField_c_of_type_AndroidWidgetImageButton.setBackgroundResource(2130840325);
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
      j();
    } while (GameMsgUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getAccount()));
    this.jdField_c_of_type_AndroidWidgetImageButton.getViewTreeObserver().addOnPreDrawListener(new GameMsgChatHelper.1(this));
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), QQBrowserActivity.class);
    String str = a().a();
    localIntent.putExtra("url", String.format("https://imgcache.qq.com/ogame/sgame-team/index.html#/subscribe-form?_wv=7&gameappid=%s&fromRoleid=%s&toRoleid=%s&pvsrc=msg-helper", new Object[] { "1104466820", a().b(), str }));
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().startActivity(localIntent);
  }
  
  private void j()
  {
    String str1;
    if ((!this.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_AndroidWidgetImageButton != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null))
    {
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.a != 0) {
        break label97;
      }
      str1 = "92015";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.a != 0) {
        break label104;
      }
    }
    label97:
    label104:
    for (String str2 = "207979";; str2 = "207977")
    {
      GameMsgUtil.a("1104466820", "1", "145", "920", str1, str2, "", "", "20", a().a(), a().b(), "");
      return;
      str1 = "92005";
      break;
    }
  }
  
  private void k()
  {
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.a != 0) {
        break label78;
      }
      str1 = "92015";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo.a != 0) {
        break label85;
      }
    }
    label78:
    label85:
    for (String str2 = "207980";; str2 = "207978")
    {
      GameMsgUtil.a("1104466820", "1", "145", "920", str1, str2, "", "", "20", a().a(), a().b(), "");
      return;
      str1 = "92005";
      break;
    }
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton != null)
    {
      Object localObject1 = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367664);
      Object localObject2 = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton;
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      localObject2 = localLayoutParams;
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
        localObject2 = ((View)localObject1).getLayoutParams();
      }
      if ((localObject2 instanceof LinearLayout.LayoutParams))
      {
        localObject2 = (LinearLayout.LayoutParams)localObject2;
        ((LinearLayout.LayoutParams)localObject2).width = AIOUtils.a(60.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        ((LinearLayout.LayoutParams)localObject2).height = AIOUtils.a(34.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundResource(a());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(2131690891);
        if (AppSetting.d) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131714125));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
    }
    h();
  }
  
  public void a(GameMsgChatPie.StrangerRecomInfo paramStrangerRecomInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie$StrangerRecomInfo = paramStrangerRecomInfo;
    j();
  }
  
  public void a(GameDetailInfo paramGameDetailInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMessageGameDetailInfo = paramGameDetailInfo;
    h();
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setSelected(false);
    }
  }
  
  public void c()
  {
    try
    {
      super.c();
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131367664);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLinearLayout.setLayoutParams(localLayoutParams);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
    }
  }
  
  public String getTag()
  {
    return jdField_a_of_type_JavaLangString;
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
      GameDetailInfo localGameDetailInfo = a();
      if (localGameDetailInfo == null) {
        break;
      }
      GameMsgUtil.a(localGameDetailInfo.d, "1", "145", "920", "92005", "206353", "", "", "20", "0");
      break;
      i();
      k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgChatHelper
 * JD-Core Version:    0.7.0.1
 */