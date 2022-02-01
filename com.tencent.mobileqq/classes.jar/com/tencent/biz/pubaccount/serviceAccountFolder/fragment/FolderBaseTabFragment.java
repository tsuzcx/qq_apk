package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class FolderBaseTabFragment
  extends BaseFragment
{
  public static String a = "FolderBaseTabFragment";
  public static int d = 0;
  public static int e = 1;
  protected View b;
  protected boolean c = false;
  protected String f = "";
  
  protected abstract void a();
  
  public abstract void a(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, int paramInt);
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getBaseActivity() != null) {
      this.f = getBaseActivity().app.getAccount();
    }
    if ((!this.c) && (getBaseActivity() != null))
    {
      a();
      this.c = true;
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setUserVisibleHint :");
    localStringBuilder.append(getUserVisibleHint());
    QLog.d(str, 4, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment
 * JD-Core Version:    0.7.0.1
 */