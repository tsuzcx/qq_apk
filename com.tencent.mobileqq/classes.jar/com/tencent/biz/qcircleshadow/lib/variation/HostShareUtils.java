package com.tencent.biz.qcircleshadow.lib.variation;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.share.api.IShareActionSheetApi;
import com.tencent.mobileqq.share.api.QCircleActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareConfig;

public class HostShareUtils
{
  private IShareActionSheetApi mInstance = (IShareActionSheetApi)QRoute.api(IShareActionSheetApi.class);
  
  public HostShareUtils(Context paramContext)
  {
    this.mInstance.init(paramContext);
  }
  
  public void dismiss()
  {
    if (this.mInstance != null) {
      this.mInstance.dismiss();
    }
  }
  
  public boolean isShowing()
  {
    if (this.mInstance != null) {
      return this.mInstance.isShowing();
    }
    return false;
  }
  
  public void setActionSheetClickListener(ShareActionSheetClickListener paramShareActionSheetClickListener)
  {
    if (this.mInstance != null) {
      this.mInstance.setActionSheetClickListener(paramShareActionSheetClickListener);
    }
  }
  
  public void setActionSheetItems(ShareConfig paramShareConfig)
  {
    if (this.mInstance != null) {
      this.mInstance.setActionSheetItems(paramShareConfig);
    }
  }
  
  public void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (this.mInstance != null) {
      this.mInstance.setCancelListener(paramOnCancelListener);
    }
  }
  
  public void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.mInstance != null) {
      this.mInstance.setOnDismissListener(paramOnDismissListener);
    }
  }
  
  public void setQCircleActionSheetClickListener(QCircleActionSheetClickListener paramQCircleActionSheetClickListener)
  {
    if (this.mInstance != null) {
      this.mInstance.setQCircleActionSheetClickListener(paramQCircleActionSheetClickListener);
    }
  }
  
  public void setRowVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mInstance != null) {
      this.mInstance.setRowVisibility(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void show()
  {
    if (this.mInstance != null) {
      this.mInstance.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostShareUtils
 * JD-Core Version:    0.7.0.1
 */