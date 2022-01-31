package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

public class PublicFragmentActivityForMini
  extends PublicFragmentActivity
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    MiniAppConfig localMiniAppConfig = (MiniAppConfig)getIntent().getParcelableExtra("CONFIG");
    if ((localMiniAppConfig != null) && (localMiniAppConfig.isEngineTypeMiniGame()))
    {
      this.mNeedStatusTrans = false;
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
    }
    return super.doOnCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivityForMini
 * JD-Core Version:    0.7.0.1
 */