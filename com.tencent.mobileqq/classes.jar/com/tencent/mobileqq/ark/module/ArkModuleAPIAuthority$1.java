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
    Activity localActivity = ArkAppModuleBase.b();
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(localActivity, 2131756189);
    localQQCustomDialog.setContentView(2131558955);
    localQQCustomDialog.setTitle(localActivity.getString(2131690122, new Object[] { this.jdField_a_of_type_JavaLangString }));
    ((ImageView)localQQCustomDialog.findViewById(2131365600)).setImageDrawable(localActivity.getResources().getDrawable(2130838626));
    ((TextView)localQQCustomDialog.findViewById(2131365602)).setText(this.jdField_a_of_type_JavaLangString);
    ((TextView)localQQCustomDialog.findViewById(2131365644)).setText(this.b);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    ArkAppCacheMgr.getAppIcon(this.c, new ArkModuleAPIAuthority.1.1(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(2131720400, new ArkModuleAPIAuthority.1.2(this, localQQCustomDialog, localActivity));
    localQQCustomDialog.setPositiveButton(2131720390, new ArkModuleAPIAuthority.1.3(this, localQQCustomDialog));
    try
    {
      localQQCustomDialog.show();
      label154:
      if (ArkModuleAPIAuthority.a(this.jdField_a_of_type_JavaLangString, this.d, this.e) == 0) {
        ArkModuleAPIAuthority.a(this.jdField_a_of_type_JavaLangString, this.d, this.e, 2);
      }
      return;
    }
    catch (Exception localException)
    {
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority.1
 * JD-Core Version:    0.7.0.1
 */