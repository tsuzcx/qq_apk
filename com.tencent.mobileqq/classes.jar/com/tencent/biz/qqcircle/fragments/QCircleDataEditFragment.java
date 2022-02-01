package com.tencent.biz.qqcircle.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import java.util.ArrayList;
import java.util.List;
import vax;
import zxj;

public class QCircleDataEditFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 2131560687;
  }
  
  public List<zxj> a()
  {
    ArrayList localArrayList = new ArrayList();
    vax localvax = new vax();
    localvax.a(a());
    localArrayList.add(localvax);
    return localArrayList;
  }
  
  public int c()
  {
    return 32;
  }
  
  public String c()
  {
    return "QCirclePersonalDataEdit";
  }
  
  public String d()
  {
    return null;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleDataEditFragment
 * JD-Core Version:    0.7.0.1
 */