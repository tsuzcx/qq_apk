package com.tencent.mobileqq.ark.module;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class ArkModuleAPIAuthority$1
  implements Runnable
{
  ArkModuleAPIAuthority$1(String paramString1, String paramString2, String paramString3, AuthDialogEventHandler paramAuthDialogEventHandler, String paramString4, String paramString5) {}
  
  public void run()
  {
    Activity localActivity = ArkAppModuleBase.h();
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(localActivity, 2131953338);
    localQQCustomDialog.setContentView(2131624588);
    localQQCustomDialog.setTitle(localActivity.getString(2131887021, new Object[] { this.a }));
    ((ImageView)localQQCustomDialog.findViewById(2131431831)).setImageDrawable(localActivity.getResources().getDrawable(2130838751));
    ((TextView)localQQCustomDialog.findViewById(2131431833)).setText(this.a);
    ((TextView)localQQCustomDialog.findViewById(2131431876)).setText(this.b);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    ArkAppCacheMgr.getAppIcon(this.c, new ArkModuleAPIAuthority.1.1(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(2131918076, new ArkModuleAPIAuthority.1.2(this, localQQCustomDialog, localActivity));
    localQQCustomDialog.setPositiveButton(2131918066, new ArkModuleAPIAuthority.1.3(this, localQQCustomDialog));
    try
    {
      localQQCustomDialog.show();
      label154:
      if (ArkModuleAPIAuthority.a(this.a, this.e, this.f) == 0) {
        ArkModuleAPIAuthority.a(this.a, this.e, this.f, 2);
      }
      return;
    }
    catch (Exception localException)
    {
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority.1
 * JD-Core Version:    0.7.0.1
 */