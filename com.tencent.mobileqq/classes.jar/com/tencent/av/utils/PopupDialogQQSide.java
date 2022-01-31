package com.tencent.av.utils;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kiq;
import kir;
import kis;

public class PopupDialogQQSide
  extends PublicBaseFragment
{
  public QQCustomDialog a = null;
  
  void a()
  {
    if (this.a != null)
    {
      this.a.dismiss();
      this.a = null;
    }
  }
  
  void b()
  {
    Object localObject = (Bundle)getArguments().getParcelable("request");
    int m = ((Bundle)localObject).getInt("type", 230);
    String str1 = ((Bundle)localObject).getString("titleText");
    String str2 = ((Bundle)localObject).getString("contentText");
    int k = ((Bundle)localObject).getInt("leftBtnText", 0);
    int j = ((Bundle)localObject).getInt("rightBtnText", 0);
    localObject = (ResultReceiver)((Bundle)localObject).getParcelable("resultReceiver");
    a();
    localObject = new kiq(this, null);
    kir localkir = new kir(this, null);
    int i = k;
    if (k == 0) {
      i = 2131428674;
    }
    if (j == 0) {
      j = 2131428674;
    }
    for (;;)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), m);
      localQQCustomDialog.setMessage(str2);
      localQQCustomDialog.setTitle(str1);
      localQQCustomDialog.setNegativeButton(i, (DialogInterface.OnClickListener)localObject);
      localQQCustomDialog.setPositiveButton(j, localkir);
      localQQCustomDialog.setOnDismissListener(new kis(this));
      localQQCustomDialog.setCancelable(true);
      localQQCustomDialog.show();
      this.a = localQQCustomDialog;
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialogQQSide
 * JD-Core Version:    0.7.0.1
 */