package com.tencent.av.ui.effect.toolbar.oldversion;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.toolbar.BaseToolbar.UIInfo;
import com.tencent.av.utils.AVColorStateList;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.VideoUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseToolbarOldVersion
  extends BaseToolbar
{
  public BaseToolbarOldVersion(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private void changImageButtonStyle(Button paramButton, int paramInt1, int paramInt2)
  {
    if (paramButton == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "changButtonStyle button is null");
      }
      return;
    }
    if (paramInt1 != 0)
    {
      Object localObject = paramButton.getResources();
      int i = (int)((Resources)localObject).getDimension(2131298425);
      if (paramInt2 > 0) {
        localObject = TintStateDrawable.a((Resources)localObject, paramInt1, paramInt2);
      } else {
        localObject = ((Resources)localObject).getDrawable(paramInt1);
      }
      ((Drawable)localObject).setBounds(0, 0, i, i);
      paramButton.setCompoundDrawables(null, (Drawable)localObject, null, null);
    }
  }
  
  protected Button createEffectButton(ViewGroup paramViewGroup, int paramInt, BaseToolbar.UIInfo paramUIInfo)
  {
    if (paramViewGroup != null)
    {
      if (paramUIInfo == null) {
        return null;
      }
      Button localButton = new Button(paramViewGroup.getContext());
      Object localObject = paramViewGroup.getResources();
      int i = (int)((Resources)localObject).getDimension(2131298429);
      localButton.setId(paramInt);
      localButton.setGravity(17);
      localButton.setSingleLine();
      localButton.setContentDescription(paramUIInfo.g);
      localButton.setBackgroundDrawable(null);
      localButton.setCompoundDrawablePadding(AIOUtils.b(5.0F, (Resources)localObject));
      localButton.setText(paramUIInfo.g);
      localButton.setTextSize(ViewUtils.pxTosp(AIOUtils.b(12.0F, (Resources)localObject)));
      paramUIInfo = paramUIInfo.g;
      localObject = localButton.getPaint();
      paramInt = i;
      if (localObject != null)
      {
        paramInt = i;
        if (!TextUtils.isEmpty(paramUIInfo))
        {
          paramInt = i;
          if (paramUIInfo.length() > 2)
          {
            paramInt = (int)((((TextPaint)localObject).measureText(paramUIInfo) + 0.5F) / paramUIInfo.length() * (paramUIInfo.length() - 2));
            if (QLog.isColorLevel())
            {
              paramUIInfo = new StringBuilder();
              paramUIInfo.append("CreateImageButton moreTextWidth[");
              paramUIInfo.append(paramInt);
              paramUIInfo.append("], btn_width[");
              paramUIInfo.append(i);
              paramUIInfo.append("]");
              QLog.i("", 2, paramUIInfo.toString());
            }
            paramInt = i + paramInt;
          }
        }
      }
      paramUIInfo = new LinearLayout.LayoutParams(paramInt, -2);
      paramUIInfo.weight = 1.0F;
      localButton.setLayoutParams(paramUIInfo);
      paramViewGroup.addView(localButton);
      return localButton;
    }
    return null;
  }
  
  public void updateEffectBtnStatus()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtnStatus, EffectBtnId[");
      localStringBuilder.append(getEffectBtnId());
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.mEffectBtn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "updateBtnStatus, mEffectBtn为空");
      }
      return;
    }
    int i;
    if ((VideoUtil.a(this.mApp, true)) && (!this.mApp.b().k().j()) && (getEffectBtnId() != 1)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject = this.mEffectBtn;
    boolean bool;
    if ((i != 0) && (isEffectBtnEnable())) {
      bool = true;
    } else {
      bool = false;
    }
    ((Button)localObject).setEnabled(bool);
    localObject = getUIInfo();
    if (localObject == null) {
      return;
    }
    int j = ((BaseToolbar.UIInfo)localObject).f;
    int m = ((BaseToolbar.UIInfo)localObject).b;
    int n = 2131166708;
    int k;
    if ((i != 0) && (isEffectBtnNormal()))
    {
      i = j;
      if (((BaseToolbar.UIInfo)localObject).c != 0)
      {
        i = j;
        if (this.mEffectBtn.isSelected()) {
          i = ((BaseToolbar.UIInfo)localObject).c;
        }
      }
      int i1 = ((BaseToolbar.UIInfo)localObject).a;
      j = i;
      m = i1;
      k = n;
      if (this.mEffectBtnRedTouch != null)
      {
        this.mEffectBtnRedTouch.setHostEnable(true);
        j = i;
        m = i1;
        k = n;
      }
    }
    else
    {
      if (this.mEffectBtnRedTouch != null) {
        this.mEffectBtnRedTouch.setHostEnable(false);
      }
      k = ((BaseToolbar.UIInfo)localObject).b;
    }
    changImageButtonStyle(this.mEffectBtn, j, m);
    localObject = AVColorStateList.a(this.mEffectBtn.getResources(), k);
    this.mEffectBtn.setTextColor((ColorStateList)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.BaseToolbarOldVersion
 * JD-Core Version:    0.7.0.1
 */