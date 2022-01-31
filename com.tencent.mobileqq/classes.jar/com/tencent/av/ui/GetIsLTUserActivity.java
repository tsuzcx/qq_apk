package com.tencent.av.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.PstnManager;

public class GetIsLTUserActivity
  extends BaseActivity
{
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool3 = super.doOnCreate(paramBundle);
    paramBundle = new Intent();
    int i;
    int j;
    boolean bool1;
    if (this.app != null)
    {
      Object localObject = (PstnManager)this.app.getManager(142);
      if (localObject != null)
      {
        i = ((PstnManager)localObject).a();
        localObject = (PhoneContactManagerImp)this.app.getManager(10);
        j = i;
        bool1 = bool2;
        if (localObject != null)
        {
          j = i;
          bool1 = bool2;
          if (((PhoneContactManagerImp)localObject).c() >= 9)
          {
            bool1 = true;
            j = i;
          }
        }
      }
    }
    for (;;)
    {
      paramBundle.putExtra("pstnGrayFlag", j);
      paramBundle.putExtra("isBindingContact", bool1);
      setResult(-1, paramBundle);
      finish();
      return bool3;
      i = 0;
      break;
      j = 0;
      bool1 = bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.GetIsLTUserActivity
 * JD-Core Version:    0.7.0.1
 */