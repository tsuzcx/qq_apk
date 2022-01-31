package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import java.util.ArrayList;
import java.util.List;
import tql;
import tsv;
import ttl;
import tvg;
import txe;
import tym;

public class QCircleContentDetailFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 2131560525;
  }
  
  public List<tvg> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new txe());
    localArrayList.add(new tsv());
    localArrayList.add(new ttl());
    return localArrayList;
  }
  
  public void a()
  {
    tym.a().a(57);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (tym.a().b(57)) {
      tym.a().a(getActivity().getIntent());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    tql.a();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment
 * JD-Core Version:    0.7.0.1
 */