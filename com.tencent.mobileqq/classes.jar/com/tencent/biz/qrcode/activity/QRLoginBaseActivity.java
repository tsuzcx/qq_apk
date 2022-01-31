package com.tencent.biz.qrcode.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import vtz;

public abstract class QRLoginBaseActivity
  extends IphoneTitleBarActivity
{
  protected ImageView b;
  
  protected abstract void a();
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    hideTitleBar();
    this.b = ((ImageView)super.findViewById(2131303425));
    this.b.setContentDescription(getText(2131625011));
    this.b.setOnClickListener(new vtz(this));
    return true;
  }
  
  public void doOnResume()
  {
    int j = 0;
    super.doOnResume();
    int i = j;
    if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      i = j;
      if (!ThemeUtil.isGoldenTheme()) {
        i = 1;
      }
    }
    if (i != 0) {
      ImmersiveUtils.a(true, getWindow());
    }
  }
  
  public void setImmersiveStatus()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.mActNeedImmersive)
      {
        int i = getResources().getColor(2131101315);
        if (this.mSystemBarComp == null)
        {
          this.mSystemBarComp = new SystemBarCompact(this, true, i);
          if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
            break label103;
          }
          this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130838503));
        }
      }
    }
    for (;;)
    {
      if (!isInMultiWindow()) {
        ImmersiveUtils.a(getWindow(), this.isClearCoverLayer);
      }
      return;
      label103:
      this.mSystemBarComp.setStatusDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginBaseActivity
 * JD-Core Version:    0.7.0.1
 */