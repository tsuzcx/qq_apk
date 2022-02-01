package com.tencent.biz.qqcircle.fragments;

import aabe;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import java.util.ArrayList;
import java.util.List;
import vcn;

public class QCircleDataEditFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 2131560704;
  }
  
  public List<aabe> a()
  {
    ArrayList localArrayList = new ArrayList();
    vcn localvcn = new vcn();
    localvcn.a(a());
    localArrayList.add(localvcn);
    return localArrayList;
  }
  
  public int c()
  {
    return 32;
  }
  
  public String c()
  {
    return "QCircleDataEditFragment";
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