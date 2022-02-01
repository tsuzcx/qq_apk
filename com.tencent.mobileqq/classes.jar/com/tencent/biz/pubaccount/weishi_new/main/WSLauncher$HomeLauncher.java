package com.tencent.biz.pubaccount.weishi_new.main;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.WSHomeLaunchParams;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboMainContainerFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;

public class WSLauncher$HomeLauncher
{
  public static void a(@NonNull WSHomeLaunchParams paramWSHomeLaunchParams)
  {
    int j = paramWSHomeLaunchParams.b();
    int i;
    if (j >= 0)
    {
      i = j;
      if (j <= 1) {}
    }
    else
    {
      i = 1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_home_to_index", i);
    localBundle.putString("key_home_to_context_feed_id", paramWSHomeLaunchParams.d());
    localBundle.putString("key_drama_id", paramWSHomeLaunchParams.e());
    localBundle.putString("key_drama_jump_schema", paramWSHomeLaunchParams.f());
    localBundle.putBoolean("key_context_feed_show_musk", paramWSHomeLaunchParams.g());
    localBundle.putSerializable("key_open_home_then_video_params", paramWSHomeLaunchParams.h());
    Intent localIntent = new Intent(paramWSHomeLaunchParams.a(), PublicFragmentActivity.class);
    localIntent.putExtra("key_home_bundle", localBundle);
    localIntent.putExtra("key_from", "home");
    if (paramWSHomeLaunchParams.c()) {
      localIntent.setFlags(67108864);
    }
    if (WSComboExpHelper.a.a())
    {
      PublicFragmentActivity.Launcher.a(paramWSHomeLaunchParams.a(), localIntent, PublicFragmentActivity.class, WSComboMainContainerFragment.class);
      return;
    }
    PublicFragmentActivity.Launcher.a(paramWSHomeLaunchParams.a(), localIntent, PublicFragmentActivity.class, WSMainContainerFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.HomeLauncher
 * JD-Core Version:    0.7.0.1
 */