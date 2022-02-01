package com.tencent.av.utils;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bhlq;
import bhpc;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mth;
import mti;
import mtj;

public class PopupDialogQQSide
  extends PublicBaseFragment
{
  public bhpc a = null;
  
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
    localObject1 = new mth(this, (ResultReceiver)localObject2);
    localObject2 = new mti(this, (ResultReceiver)localObject2);
    if (i == 0) {
      i = 2131719223;
    }
    for (;;)
    {
      if (j == 0) {
        j = 2131719223;
      }
      for (;;)
      {
        bhpc localbhpc = bhlq.a(getActivity(), k);
        localbhpc.setMessage(str2);
        localbhpc.setTitle(str1);
        if (bool1) {
          localbhpc.setNegativeButton(i, (DialogInterface.OnClickListener)localObject1);
        }
        if (bool2) {
          localbhpc.setPositiveButton(j, (DialogInterface.OnClickListener)localObject2);
        }
        localbhpc.setOnDismissListener(new mtj(this));
        localbhpc.setCancelable(true);
        localbhpc.show();
        this.a = localbhpc;
        return;
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialogQQSide
 * JD-Core Version:    0.7.0.1
 */