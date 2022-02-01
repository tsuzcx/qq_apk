package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.quickat.ui.AtPanel;
import com.tencent.mobileqq.troop.quickat.ui.AtUtil;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.OnKeyEventPreImeListener;

public class AIOAtHelper
  implements IHelper, XEditTextEx.OnKeyEventPreImeListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private AtPanel jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel;
  
  public AIOAtHelper(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_AndroidAppActivity = paramTroopChatPie.a();
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    boolean bool1;
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == 65312) || (paramCharSequence.charAt(paramInt1) == '@'))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((paramInt3 == 0) && (i > 0))
    {
      paramInt1 = i - 1;
      if ((paramCharSequence.charAt(paramInt1) == 65312) || (paramCharSequence.charAt(paramInt1) == '@'))
      {
        bool2 = true;
        break label99;
      }
    }
    boolean bool2 = false;
    label99:
    Object localObject;
    if ((bool1) || (bool2))
    {
      paramCharSequence = (FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(24);
      if (paramCharSequence.c()) {
        paramCharSequence.a(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().findViewById(2131362329) == null)
        {
          paramCharSequence = new View(this.jdField_a_of_type_AndroidAppActivity);
          paramCharSequence.setId(2131362329);
          localObject = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131368875);
          ((RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131364485)).addView(paramCharSequence, 3, (ViewGroup.LayoutParams)localObject);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel = new AtPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setKeyEventPreImeListener(this);
      }
    }
    paramCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    paramInt3 = i - 1;
    paramInt1 = paramCharSequence.lastIndexOf("＠", paramInt3);
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().lastIndexOf("@", paramInt3);
    if (paramInt1 <= paramInt2) {
      paramInt1 = paramInt2;
    }
    int j = AtUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    int k = AtUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    paramCharSequence = null;
    if (paramInt3 >= 0) {
      paramCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().substring(paramInt3, i);
    }
    if ((k >= 0) && (k == i)) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if ((k >= 0) && (k == paramInt3) && (paramCharSequence != null) && (paramCharSequence.equals(" "))) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    if (QLog.isColorLevel())
    {
      paramCharSequence = new StringBuilder("selectIndex =");
      paramCharSequence.append(i);
      paramCharSequence.append(" isFirstAddAt=");
      paramCharSequence.append(bool1);
      paramCharSequence.append(" isFirstBackAt=");
      paramCharSequence.append(bool2);
      paramCharSequence.append(" max=");
      paramCharSequence.append(paramInt1);
      paramCharSequence.append(" lastSpanAt=");
      paramCharSequence.append(j);
      paramCharSequence.append(" mAtPanel=");
      paramCharSequence.append(this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel);
      QLog.d("AIOAtHelper", 2, paramCharSequence.toString());
    }
    if ((j < paramInt1) && (paramInt1 >= 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel != null))
    {
      paramCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().substring(paramInt1 + 1, i);
      bool1 = AtUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362329);
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel.a((View)localObject, paramCharSequence, bool1);
      return false;
    }
    paramCharSequence = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel;
    if ((paramCharSequence != null) && (paramInt3 == 0) && (paramInt2 == 0)) {
      paramCharSequence.a();
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().findViewById(2131362329);
      if (localView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().removeView(localView);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setKeyEventPreImeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel = null;
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" beforeTextChanged:  start=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" after=");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" count=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("AIOAtHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel;
    if ((localObject != null) && (((AtPanel)localObject).b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAtHelper", 2, "beforeTextChanged mAtPanel spanChange");
      }
      return;
    }
    if ((paramInt3 == 0) && (paramInt2 > 0) && (paramCharSequence.length() > 0))
    {
      paramCharSequence = AtUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      paramInt2 = AtUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      if ((paramCharSequence != null) && (paramInt2 == paramInt1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOAtHelper", 2, new Object[] { " delete member:", paramCharSequence.a(), " nick:", paramCharSequence.b() });
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel;
        if (localObject != null) {
          ((AtPanel)localObject).a(paramCharSequence.a());
        }
      }
    }
  }
  
  public boolean a()
  {
    AtPanel localAtPanel = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel;
    return (localAtPanel != null) && (localAtPanel.a());
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel;
      if ((paramKeyEvent != null) && (paramKeyEvent.a())) {
        return true;
      }
    }
    return false;
  }
  
  public void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AtPanel localAtPanel = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanel;
    if ((localAtPanel != null) && (localAtPanel.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAtHelper", 2, "mAtPanel spanChange");
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c() != 3) {
      a(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public String getTag()
  {
    return "AIOAtHelper";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOAtHelper
 * JD-Core Version:    0.7.0.1
 */