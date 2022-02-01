package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;

public abstract class FolderBaseTabFragment
  extends ReportV4Fragment
{
  public static int a;
  public static String a;
  public static int b;
  protected View a;
  protected boolean a;
  protected String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "FolderBaseTabFragment";
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
  }
  
  public FolderBaseTabFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  protected abstract void a();
  
  public abstract void a(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, int paramInt);
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() != null) {
      this.jdField_b_of_type_JavaLangString = getActivity().app.getAccount();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((getUserVisibleHint()) && (!this.jdField_a_of_type_Boolean))
    {
      a();
      this.jdField_a_of_type_Boolean = true;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "setUserVisibleHint :" + getUserVisibleHint());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment
 * JD-Core Version:    0.7.0.1
 */