package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.Observable;

public class MiniPieForForward
  extends MiniPie
{
  private ForwardTroopMemberControllerForMiniPie a;
  private View b;
  private RelativeLayout d;
  private RelativeLayout e;
  private boolean g = false;
  
  public MiniPieForForward(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardTroopMemberControllerForMiniPie = null;
  }
  
  private void A()
  {
    if (this.d == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "mGroupMemberView null");
      return;
    }
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "hideGroupMemberDialog");
    this.g = false;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130840293);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840293));
    }
    if (this.e != null) {
      this.e.setVisibility(0);
    }
    this.d.setVisibility(8);
  }
  
  private float a()
  {
    Intent localIntent = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
    if (localIntent != null) {}
    for (float f = localIntent.getFloatExtra("minaio_scaled_ration", 0.78F);; f = 0.78F)
    {
      if (!MiniPieHelper.a()) {
        f = 1.0F;
      }
      return f;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.d == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "mGroupMemberView null");
      return;
    }
    if ((paramInt != 1) && (paramInt != 3000))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "showGroupMemberDialog with wrong uin type");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009BE7", "0X8009BE7", 2, 0, "", "", "", "");
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "showGroupMemberDialog");
    if (this.e != null) {
      this.e.setVisibility(4);
    }
    float f = a();
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardTroopMemberControllerForMiniPie == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardTroopMemberControllerForMiniPie = new ForwardTroopMemberControllerForMiniPie(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardTroopMemberControllerForMiniPie.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt, f);
      paramString = this.jdField_a_of_type_ComTencentMobileqqForwardForwardTroopMemberControllerForMiniPie.a();
      if (paramString != null) {
        this.d.addView(paramString);
      }
    }
    this.g = true;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130840285);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840285));
    }
    this.d.setVisibility(0);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void c() {}
  
  protected void g()
  {
    super.g();
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.e = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377177));
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000)) {
        break label585;
      }
      if (this.e != null)
      {
        this.e.setVisibility(0);
        this.e.setOnClickListener(this);
      }
      localObject = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369501);
      if (localObject != null) {
        ((ImageView)localObject).setBackgroundResource(2130840290);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840293);
      float f = a();
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130840293);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365922);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      this.d = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368101));
      localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377159);
      if (localObject != null)
      {
        int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297133);
        if ((f > 0.0F) && (f <= 1.0F))
        {
          i = (int)(i / f);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.height = i;
            ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
          }
          i = (int)(16.0D / f);
          localObject = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379432);
          if (localObject != null)
          {
            ((TextView)localObject).setTextSize(2, i);
            ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(0));
            localLayoutParams = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
            localLayoutParams.setMargins((int)(localLayoutParams.leftMargin / f), (int)(localLayoutParams.topMargin / f), (int)(localLayoutParams.rightMargin / f), (int)(localLayoutParams.bottomMargin / f));
            ((TextView)localObject).setLayoutParams(localLayoutParams);
          }
          localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369487);
          if (localObject != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
            if (localLayoutParams != null)
            {
              localLayoutParams.height = ((int)(localLayoutParams.height / f));
              localLayoutParams.width = ((int)(localLayoutParams.width / f));
              ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
            }
          }
          localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368865);
          if (localObject != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
            if (localLayoutParams != null)
            {
              localLayoutParams.height = ((int)(localLayoutParams.height / f));
              localLayoutParams.width = ((int)(localLayoutParams.width / f));
              localLayoutParams.setMargins((int)(localLayoutParams.leftMargin / f), (int)(localLayoutParams.topMargin / f), (int)(localLayoutParams.rightMargin / f), (int)(localLayoutParams.bottomMargin / f));
              ((ImageView)localObject).setLayoutParams(localLayoutParams);
            }
          }
          localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369501);
          if (localObject != null)
          {
            localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
            if (localLayoutParams != null)
            {
              i = AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
              localLayoutParams.height = ((int)(i / f));
              localLayoutParams.width = ((int)(i / f));
              ((ImageView)localObject).setLayoutParams(localLayoutParams);
            }
          }
        }
      }
      return;
      label585:
      if (this.e != null) {
        this.e.setVisibility(4);
      }
    }
  }
  
  protected void h()
  {
    super.h();
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
      continue;
      r();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatProvider.a(20);
  }
  
  public void r()
  {
    if (this.g)
    {
      A();
      return;
    }
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "doOnFinish");
    if (this.d != null)
    {
      this.d.removeAllViews();
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardTroopMemberControllerForMiniPie != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardTroopMemberControllerForMiniPie.a();
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardTroopMemberControllerForMiniPie = null;
      }
    }
    super.r();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(0, 0);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, getClass().getSimpleName() + " update");
    }
    if ((paramObject instanceof QQMessageFacade.RefreshMessageContext))
    {
      paramObservable = (QQMessageFacade.RefreshMessageContext)paramObject;
      paramObject = (ChatContext)paramObservable.a;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.a())))
      {
        if ((this.jdField_a_of_type_Long != paramObject.a()) || (!paramObservable.h) || (!paramObservable.d)) {
          break label146;
        }
        l = this.jdField_a_of_type_Long + 300L - SystemClock.uptimeMillis();
        if (l <= 0L) {
          break label141;
        }
        a(131076, l);
      }
    }
    label141:
    label146:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          return;
          long l = 0L;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshMessageContext sync theSameUinAIO return");
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update--> do nothing");
  }
  
  protected void w()
  {
    ImageButton localImageButton = (ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362414);
    if (localImageButton != null) {
      localImageButton.setVisibility(8);
    }
  }
  
  public void x() {}
  
  protected void y()
  {
    this.jdField_a_of_type_JavaLangString = "MiniPieForForward";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieForForward
 * JD-Core Version:    0.7.0.1
 */