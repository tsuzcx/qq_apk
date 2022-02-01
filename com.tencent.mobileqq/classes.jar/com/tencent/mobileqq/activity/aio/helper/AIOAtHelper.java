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
  private TroopChatPie a;
  private Activity b;
  private AtPanel c;
  
  public AIOAtHelper(TroopChatPie paramTroopChatPie)
  {
    this.a = paramTroopChatPie;
    this.b = paramTroopChatPie.aX();
  }
  
  private boolean c(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.a.Y.getSelectionStart();
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
      paramCharSequence = (FullScreenInputHelper)this.a.q(24);
      if (paramCharSequence.e()) {
        paramCharSequence.b(true);
      }
      if (this.c == null)
      {
        if (this.a.aW().findViewById(2131427929) == null)
        {
          paramCharSequence = new View(this.b);
          paramCharSequence.setId(2131427929);
          localObject = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131435809);
          ((RelativeLayout)this.b.findViewById(2131430542)).addView(paramCharSequence, 3, (ViewGroup.LayoutParams)localObject);
        }
        this.c = new AtPanel(this.a);
        this.a.Y.setKeyEventPreImeListener(this);
      }
    }
    paramCharSequence = this.a.Y.getText().toString();
    paramInt3 = i - 1;
    paramInt1 = paramCharSequence.lastIndexOf("＠", paramInt3);
    paramInt2 = this.a.Y.getText().toString().lastIndexOf("@", paramInt3);
    if (paramInt1 <= paramInt2) {
      paramInt1 = paramInt2;
    }
    int j = AtUtil.c(this.a.Y);
    int k = AtUtil.b(this.a.Y);
    paramCharSequence = null;
    if (paramInt3 >= 0) {
      paramCharSequence = this.a.Y.getText().toString().substring(paramInt3, i);
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
      paramCharSequence.append(this.c);
      QLog.d("AIOAtHelper", 2, paramCharSequence.toString());
    }
    if ((j < paramInt1) && (paramInt1 >= 0) && (this.c != null))
    {
      paramCharSequence = this.a.Y.getText().toString().substring(paramInt1 + 1, i);
      bool1 = AtUtil.a(this.a.Y, this.a.d);
      localObject = this.b.findViewById(2131427929);
      this.c.a((View)localObject, paramCharSequence, bool1);
      return false;
    }
    paramCharSequence = this.c;
    if ((paramCharSequence != null) && (paramInt3 == 0) && (paramInt2 == 0)) {
      paramCharSequence.d();
    }
    return false;
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
    Object localObject = this.c;
    if ((localObject != null) && (((AtPanel)localObject).e()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAtHelper", 2, "beforeTextChanged mAtPanel spanChange");
      }
      return;
    }
    if ((paramInt3 == 0) && (paramInt2 > 0) && (paramCharSequence.length() > 0))
    {
      paramCharSequence = AtUtil.a(this.a.Y);
      paramInt2 = AtUtil.c(this.a.Y);
      if ((paramCharSequence != null) && (paramInt2 == paramInt1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOAtHelper", 2, new Object[] { " delete member:", paramCharSequence.a(), " nick:", paramCharSequence.b() });
        }
        localObject = this.c;
        if (localObject != null) {
          ((AtPanel)localObject).a(paramCharSequence.a());
        }
      }
    }
  }
  
  public boolean a()
  {
    AtPanel localAtPanel = this.c;
    return (localAtPanel != null) && (localAtPanel.d());
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.c;
      if ((paramKeyEvent != null) && (paramKeyEvent.d())) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    if (this.c != null)
    {
      View localView = this.a.aX().findViewById(2131427929);
      if (localView != null) {
        this.a.aW().removeView(localView);
      }
      this.c.b();
      this.a.Y.setKeyEventPreImeListener(null);
      this.c = null;
    }
  }
  
  public void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AtPanel localAtPanel = this.c;
    if ((localAtPanel != null) && (localAtPanel.e()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAtHelper", 2, "mAtPanel spanChange");
      }
    }
    else if (this.a.aR() != 3) {
      c(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public String getTag()
  {
    return "AIOAtHelper";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOAtHelper
 * JD-Core Version:    0.7.0.1
 */