package com.tencent.mobileqq.activity.pendant;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AvatarPendantActivity$28$1
  implements Runnable
{
  AvatarPendantActivity$28$1(AvatarPendantActivity.28 param28, boolean paramBoolean, List paramList, int paramInt) {}
  
  public void run()
  {
    AvatarPendantActivity.j(this.d.a).setEnabled(true);
    AvatarPendantActivity.k(this.d.a).setVisibility(8);
    Object localObject;
    if (this.a)
    {
      localObject = this.b;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)this.b.get(0));
        AvatarPendantActivity.a(this.d.a, (Intent)localObject);
        QQToast.makeText(this.d.a, 2, 2131917774, 0).show(this.d.a.getTitleBarHeight());
      }
    }
    else
    {
      QQToast.makeText(this.d.a, 1, 2131916287, 0).show(this.d.a.getTitleBarHeight());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnProcessFinishListener avatar video process error! actionId: ");
      ((StringBuilder)localObject).append(this.c);
      QLog.e("AvatarPendantActivity", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.28.1
 * JD-Core Version:    0.7.0.1
 */