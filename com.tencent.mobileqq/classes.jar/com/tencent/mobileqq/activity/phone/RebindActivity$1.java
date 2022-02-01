package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class RebindActivity$1
  extends ContactBindObserver
{
  RebindActivity$1(RebindActivity paramRebindActivity) {}
  
  public void onRebindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.b();
    if (paramBoolean)
    {
      paramBundle = new Intent(this.a, BindVerifyActivity.class);
      paramBundle.putExtra("kSrouce", this.a.jdField_a_of_type_Int);
      paramBundle.putExtra("k_number", this.a.jdField_a_of_type_JavaLangString);
      paramBundle.putExtra("kBindType", RebindActivity.a(this.a));
      paramBundle.putExtra("keyReqBindMode", 1);
      paramBundle.putExtra("k_country_code", RebindActivity.a(this.a));
      paramBundle.putExtra("cmd_param_is_from_uni", RebindActivity.a(this.a));
      paramBundle.putExtra("cmd_param_is_from_change_bind", RebindActivity.b(this.a));
      paramBundle.addFlags(67108864);
      paramBundle.putExtra("k_is_block", this.a.getIntent().getBooleanExtra("k_is_block", false));
      paramBundle.putExtra("key_is_from_qqhotspot", this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
      paramBundle.putExtra("key_is_from_qav_multi_call", this.a.getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
      this.a.startActivityForResult(paramBundle, 1);
      return;
    }
    this.a.a(2131718550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.RebindActivity.1
 * JD-Core Version:    0.7.0.1
 */