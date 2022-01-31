package com.tencent.av.utils;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bbdj;
import bbgu;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import msj;
import msk;
import msl;

public class PopupDialogQQSide
  extends PublicBaseFragment
{
  public bbgu a = null;
  
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
    localObject1 = new msj(this, (ResultReceiver)localObject2);
    localObject2 = new msk(this, (ResultReceiver)localObject2);
    if (i == 0) {
      i = 2131720783;
    }
    for (;;)
    {
      if (j == 0) {
        j = 2131720783;
      }
      for (;;)
      {
        bbgu localbbgu = bbdj.a(getActivity(), k);
        localbbgu.setMessage(str2);
        localbbgu.setTitle(str1);
        if (bool1) {
          localbbgu.setNegativeButton(i, (DialogInterface.OnClickListener)localObject1);
        }
        if (bool2) {
          localbbgu.setPositiveButton(j, (DialogInterface.OnClickListener)localObject2);
        }
        localbbgu.setOnDismissListener(new msl(this));
        localbbgu.setCancelable(true);
        localbbgu.show();
        this.a = localbbgu;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialogQQSide
 * JD-Core Version:    0.7.0.1
 */