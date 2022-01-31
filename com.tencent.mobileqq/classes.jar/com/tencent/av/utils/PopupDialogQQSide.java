package com.tencent.av.utils;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bdcd;
import bdfq;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import mvd;
import mve;
import mvf;

public class PopupDialogQQSide
  extends PublicBaseFragment
{
  public bdfq a = null;
  
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
    Object localObject1 = (Bundle)getArguments().getParcelable("request");
    int k = ((Bundle)localObject1).getInt("type", 230);
    String str1 = ((Bundle)localObject1).getString("titleText");
    String str2 = ((Bundle)localObject1).getString("contentText");
    int i = ((Bundle)localObject1).getInt("leftBtnText", 0);
    int j = ((Bundle)localObject1).getInt("rightBtnText", 0);
    Object localObject2 = (ResultReceiver)((Bundle)localObject1).getParcelable("resultReceiver");
    boolean bool1 = ((Bundle)localObject1).getBoolean("leftBtnVisiable", true);
    boolean bool2 = ((Bundle)localObject1).getBoolean("rightBtnVisiable", true);
    a();
    localObject1 = new mvd(this, (ResultReceiver)localObject2);
    localObject2 = new mve(this, (ResultReceiver)localObject2);
    if (i == 0) {
      i = 2131721323;
    }
    for (;;)
    {
      if (j == 0) {
        j = 2131721323;
      }
      for (;;)
      {
        bdfq localbdfq = bdcd.a(getActivity(), k);
        localbdfq.setMessage(str2);
        localbdfq.setTitle(str1);
        if (bool1) {
          localbdfq.setNegativeButton(i, (DialogInterface.OnClickListener)localObject1);
        }
        if (bool2) {
          localbdfq.setPositiveButton(j, (DialogInterface.OnClickListener)localObject2);
        }
        localbdfq.setOnDismissListener(new mvf(this));
        localbdfq.setCancelable(true);
        localbdfq.show();
        this.a = localbdfq;
        return;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialogQQSide
 * JD-Core Version:    0.7.0.1
 */