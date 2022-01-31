package com.tencent.mobileqq.ark.setting;

import actj;
import alwj;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class ArkAppListActivity
  extends IphoneTitleBarActivity
{
  private ViewGroup a;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int i = 0;
    super.doOnCreate(paramBundle);
    paramBundle = new LinearLayout(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130838515);
    paramBundle.setLayoutParams(localLayoutParams);
    paramBundle.setOrientation(1);
    paramBundle.setPadding(0, actj.a(20.0F, getResources()), 0, 0);
    this.a = paramBundle;
    paramBundle = getIntent().getStringArrayExtra("intent_extra_authority_app_list");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      int j = paramBundle.length;
      while (i < j)
      {
        localLayoutParams = paramBundle[i];
        if (!TextUtils.isEmpty(localLayoutParams))
        {
          FormSimpleItem localFormSimpleItem = new FormSimpleItem(this);
          localFormSimpleItem.setLeftText(localLayoutParams);
          localFormSimpleItem.a(true);
          localFormSimpleItem.setOnClickListener(new alwj(this, localLayoutParams));
          this.a.addView(localFormSimpleItem);
        }
        i += 1;
      }
    }
    super.setContentView(this.a);
    super.setTitle(2131690189);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.setting.ArkAppListActivity
 * JD-Core Version:    0.7.0.1
 */