package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.PermissionPageUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;

public class DenyRunnable$JumpSettingAction
  implements DenyRunnable.OnCancelAction
{
  private WeakReference<QQAppInterface> a;
  private int b = 2;
  
  public DenyRunnable$JumpSettingAction(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public void onCancel(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (VersionUtils.k())
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
        if (localQQAppInterface != null) {
          ((IPhoneContactService)localQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).markOrClearUserSettingFlag(true);
        }
        paramContext = new PermissionPageUtil(paramContext, paramContext.getPackageName());
        try
        {
          paramContext.a();
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          paramContext.b();
          return;
        }
      }
      Intent localIntent = new Intent(paramContext, GuideBindPhoneActivity.class);
      localIntent.putExtra("fromKeyForContactBind", this.b);
      paramContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DenyRunnable.JumpSettingAction
 * JD-Core Version:    0.7.0.1
 */