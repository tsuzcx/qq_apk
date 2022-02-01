package com.tencent.biz.expand.ui;

import android.os.Bundle;
import android.support.v4.app.QFragmentActivity;
import com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.extendfriend.wiget.FillBirthdayDialog.OnConfirmListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/ui/ExpandBirthPickFragment$onCreateView$fillBirthdayDialog$1", "Lcom/tencent/mobileqq/extendfriend/wiget/FillBirthdayDialog$OnConfirmListener;", "onCancel", "", "onConfirm", "newBirthday", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandBirthPickFragment$onCreateView$fillBirthdayDialog$1
  implements FillBirthdayDialog.OnConfirmListener
{
  public void a()
  {
    QFragmentActivity localQFragmentActivity = this.a.getActivity();
    if (localQFragmentActivity != null) {
      localQFragmentActivity.finish();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("birthdate", paramInt);
    ExpandFlutterIPCClient.a().a("METHOD_SET_BIRTH_DATE", (Bundle)localObject);
    localObject = this.a.getActivity();
    if (localObject != null) {
      ((QFragmentActivity)localObject).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandBirthPickFragment.onCreateView.fillBirthdayDialog.1
 * JD-Core Version:    0.7.0.1
 */