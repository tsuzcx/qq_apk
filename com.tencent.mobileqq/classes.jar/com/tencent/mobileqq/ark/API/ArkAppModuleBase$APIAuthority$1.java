package com.tencent.mobileqq.ark.API;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class ArkAppModuleBase$APIAuthority$1
  implements Runnable
{
  ArkAppModuleBase$APIAuthority$1(String paramString1, String paramString2, String paramString3, ArkAppModuleBase.APIAuthority.AuthDialogEventHandler paramAuthDialogEventHandler, String paramString4, String paramString5) {}
  
  public void run()
  {
    Activity localActivity = ArkAppModuleBase.a();
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(localActivity, 2131755842);
    localQQCustomDialog.setContentView(2131559061);
    localQQCustomDialog.setTitle(localActivity.getString(2131690206, new Object[] { this.jdField_a_of_type_JavaLangString }));
    ((ImageView)localQQCustomDialog.findViewById(2131365763)).setImageDrawable(localActivity.getResources().getDrawable(2130838781));
    ((TextView)localQQCustomDialog.findViewById(2131365765)).setText(this.jdField_a_of_type_JavaLangString);
    ((TextView)localQQCustomDialog.findViewById(2131365807)).setText(this.b);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    ArkAppCacheMgr.getAppIcon(this.c, new ArkAppModuleBase.APIAuthority.1.1(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(2131720681, new ArkAppModuleBase.APIAuthority.1.2(this, localQQCustomDialog, localActivity));
    localQQCustomDialog.setPositiveButton(2131720671, new ArkAppModuleBase.APIAuthority.1.3(this, localQQCustomDialog));
    try
    {
      localQQCustomDialog.show();
      label154:
      if (ArkAppModuleBase.APIAuthority.a(this.jdField_a_of_type_JavaLangString, this.d, this.e) == 0) {
        ArkAppModuleBase.APIAuthority.a(this.jdField_a_of_type_JavaLangString, this.d, this.e, 2);
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
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority.1
 * JD-Core Version:    0.7.0.1
 */