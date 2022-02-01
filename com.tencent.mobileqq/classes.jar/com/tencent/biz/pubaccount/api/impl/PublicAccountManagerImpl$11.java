package com.tencent.biz.pubaccount.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PublicAccountManagerImpl$11
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountManagerImpl$11(PublicAccountManagerImpl paramPublicAccountManagerImpl, AppInterface paramAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        this.e.dismiss();
        return;
      }
      PlusPanelUtils.a((QQAppInterface)this.a, (Activity)this.b, this.d, null, null);
      this.e.dismiss();
      return;
    }
    PlusPanelUtils.a((QQAppInterface)this.a, (BaseActivity)this.b, this.c, this.d);
    paramView = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    if (paramView != null) {
      paramView.putString("LastScreenShotUri", null).apply();
    }
    this.e.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.11
 * JD-Core Version:    0.7.0.1
 */