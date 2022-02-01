package com.tencent.ad.tangram.preorder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdAppReceiver;
import com.tencent.ad.tangram.util.AdClickUtil.Params;

final class d
  extends AdAppReceiver
{
  public static final String KEY_TASK_ID = "APP_PREORDER_TASK_ID";
  private static final String TAG = "AdAppPreOrderReceiver";
  
  private void onReceivePackageAddedInternal(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null) || (!TextUtils.equals(paramIntent.getAction(), "android.intent.action.PACKAGE_ADDED")) || (paramIntent.getData() == null) || (TextUtils.isEmpty(paramIntent.getData().getSchemeSpecificPart())))
    {
      AdLog.e("AdAppPreOrderReceiver", "onReceivePackageAdded error");
      return;
    }
    paramContext = paramIntent.getData().getSchemeSpecificPart();
    AdLog.i("AdAppPreOrderReceiver", String.format("onReceivePackageAdded %s", new Object[] { paramContext }));
    paramContext = getParams(paramContext);
    if ((paramContext == null) || (paramContext.extrasForIntent == null) || (!paramContext.extrasForIntent.containsKey("APP_PREORDER_TASK_ID")))
    {
      AdLog.e("AdAppPreOrderReceiver", "onReceivePackageAdded error");
      return;
    }
    paramIntent = paramContext.extrasForIntent.getString("APP_PREORDER_TASK_ID");
    paramContext.extrasForIntent.remove("APP_PREORDER_TASK_ID");
    AdLog.i("AdAppPreOrderReceiver", String.format("onReceivePackageAdded taskId:%s", new Object[] { paramIntent }));
    AdAppPreOrderManager.INSTANCE.setTaskStatusAndCommit(paramIntent, 33);
  }
  
  public void onReceivePackageAdded(Context paramContext, Intent paramIntent)
  {
    onReceivePackageAddedInternal(paramContext, paramIntent);
    super.onReceivePackageAdded(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.d
 * JD-Core Version:    0.7.0.1
 */