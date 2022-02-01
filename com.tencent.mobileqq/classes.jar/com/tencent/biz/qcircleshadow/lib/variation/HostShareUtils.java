package com.tencent.biz.qcircleshadow.lib.variation;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.share.api.IShareActionSheetApi;
import com.tencent.mobileqq.share.api.QCircleActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareConfig;

public class HostShareUtils
{
  private static final String IS_FORCE_NIGHT_THEME_KEY = "is_force_night_theme";
  private IShareActionSheetApi mInstance = (IShareActionSheetApi)QRoute.api(IShareActionSheetApi.class);
  
  public HostShareUtils(Context paramContext)
  {
    this.mInstance.init(paramContext);
  }
  
  public void dismiss()
  {
    IShareActionSheetApi localIShareActionSheetApi = this.mInstance;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.dismiss();
    }
  }
  
  public boolean isShowing()
  {
    IShareActionSheetApi localIShareActionSheetApi = this.mInstance;
    if (localIShareActionSheetApi != null) {
      return localIShareActionSheetApi.isShowing();
    }
    return false;
  }
  
  public void setActionSheetClickListener(ShareActionSheetClickListener paramShareActionSheetClickListener)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.mInstance;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setActionSheetClickListener(paramShareActionSheetClickListener);
    }
  }
  
  public void setActionSheetItems(ShareConfig paramShareConfig)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.mInstance;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setActionSheetItems(paramShareConfig);
    }
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.mInstance;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setCancelListener(paramOnCancelListener);
    }
  }
  
  public void setIntentForStartForwardRecentActivity(Intent paramIntent)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.mInstance;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setIntentForStartForwardRecentActivity(paramIntent);
    }
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.mInstance;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setOnDismissListener(paramOnDismissListener);
    }
  }
  
  public void setQCircleActionSheetClickListener(QCircleActionSheetClickListener paramQCircleActionSheetClickListener)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.mInstance;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setQCircleActionSheetClickListener(paramQCircleActionSheetClickListener);
    }
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.mInstance;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setRowVisibility(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void show()
  {
    IShareActionSheetApi localIShareActionSheetApi = this.mInstance;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.show();
    }
  }
  
  public void show(boolean paramBoolean)
  {
    if (this.mInstance != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("is_force_night_theme", paramBoolean);
      this.mInstance.setExtras(localBundle);
      this.mInstance.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostShareUtils
 * JD-Core Version:    0.7.0.1
 */