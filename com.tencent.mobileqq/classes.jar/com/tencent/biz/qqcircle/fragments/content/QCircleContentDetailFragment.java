package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import java.util.ArrayList;
import java.util.List;
import tql;
import tra;
import ttl;
import tua;
import tvv;
import txz;
import tzy;

public class QCircleContentDetailFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 2131560525;
  }
  
  public String a()
  {
    return "QCircleContentDetailFragment";
  }
  
  public List<tvv> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new txz());
    localArrayList.add(new ttl());
    localArrayList.add(new tua());
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    tra.a(getActivity(), false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return getResources().getColor(2131167140);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (tzy.a().b(57)) {
      tzy.a().a(getActivity().getIntent());
    }
  }
  
  public void onDestroy()
  {
    tra.a(getActivity());
    tql.a();
    super.onDestroy();
  }
  
  public void onDetach()
  {
    super.onDetach();
    tzy.a().a(57);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment
 * JD-Core Version:    0.7.0.1
 */