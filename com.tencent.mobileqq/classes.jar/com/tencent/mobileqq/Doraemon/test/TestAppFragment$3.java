package com.tencent.mobileqq.Doraemon.test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;

class TestAppFragment$3
  implements DialogInterface.OnClickListener
{
  TestAppFragment$3(TestAppFragment paramTestAppFragment, EditText paramEditText1, EditText paramEditText2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.getText().toString();
    Object localObject1 = this.b.getText().toString();
    if ((!TextUtils.isEmpty(paramDialogInterface)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      Object localObject2 = this.c;
      ((TestAppFragment)localObject2).e = paramDialogInterface;
      ((TestAppFragment)localObject2).f = Integer.parseInt((String)localObject1);
      this.c.c = ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(this.c.getQBaseActivity(), this.c.f, paramDialogInterface);
      localObject1 = this.c.getActivity();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("appid切换为:");
      ((StringBuilder)localObject2).append(paramDialogInterface);
      QQToast.makeText((Context)localObject1, ((StringBuilder)localObject2).toString(), 1).show();
      return;
    }
    QQToast.makeText(this.c.getQBaseActivity(), HardCodeUtil.a(2131912167), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.3
 * JD-Core Version:    0.7.0.1
 */