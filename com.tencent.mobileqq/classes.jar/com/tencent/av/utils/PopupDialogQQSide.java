package com.tencent.av.utils;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class PopupDialogQQSide
  extends QPublicBaseFragment
{
  QQCustomDialog a = null;
  
  void a()
  {
    QQCustomDialog localQQCustomDialog = this.a;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.a = null;
    }
  }
  
  void b()
  {
    Object localObject1 = (Bundle)getArguments().getParcelable("request");
    int m = ((Bundle)localObject1).getInt("type", 230);
    String str1 = ((Bundle)localObject1).getString("titleText");
    String str2 = ((Bundle)localObject1).getString("contentText");
    int j = ((Bundle)localObject1).getInt("leftBtnText", 0);
    int k = ((Bundle)localObject1).getInt("rightBtnText", 0);
    Object localObject2 = (ResultReceiver)((Bundle)localObject1).getParcelable("resultReceiver");
    boolean bool1 = ((Bundle)localObject1).getBoolean("leftBtnVisiable", true);
    boolean bool2 = ((Bundle)localObject1).getBoolean("rightBtnVisiable", true);
    a();
    localObject1 = new PopupDialogQQSide.1(this, (ResultReceiver)localObject2);
    localObject2 = new PopupDialogQQSide.2(this, (ResultReceiver)localObject2);
    int i = j;
    if (j == 0) {
      i = 2131917882;
    }
    j = k;
    if (k == 0) {
      j = 2131917882;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getQBaseActivity(), m);
    localQQCustomDialog.setMessage(str2);
    localQQCustomDialog.setTitle(str1);
    if (bool1) {
      localQQCustomDialog.setNegativeButton(i, (DialogInterface.OnClickListener)localObject1);
    }
    if (bool2) {
      localQQCustomDialog.setPositiveButton(j, (DialogInterface.OnClickListener)localObject2);
    }
    localQQCustomDialog.setOnDismissListener(new PopupDialogQQSide.3(this));
    localQQCustomDialog.setCancelable(true);
    localQQCustomDialog.show();
    this.a = localQQCustomDialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    a();
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialogQQSide
 * JD-Core Version:    0.7.0.1
 */