package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.StringUtil;

public class QQReminderJumpFragment
  extends QPublicBaseFragment
{
  private QQNotifyLoadingDialog a;
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("msgid", paramString);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicTransFragmentActivity.class, QQReminderJumpFragment.class);
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.a = new QQNotifyLoadingDialog(getQBaseActivity());
    this.a.show();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    QQNotifyLoadingDialog localQQNotifyLoadingDialog = this.a;
    if ((localQQNotifyLoadingDialog != null) && (localQQNotifyLoadingDialog.isShowing())) {
      this.a.dismiss();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    String str = getArguments().getString("msgid");
    if (!StringUtil.isEmpty(str)) {
      ThreadManagerV2.excute(new QQReminderJumpFragment.1(this, str), 32, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQReminderJumpFragment
 * JD-Core Version:    0.7.0.1
 */