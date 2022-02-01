package com.tencent.biz.qqcircle.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import biau;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import uxo;
import zxj;

public class QCircleLoadingFragment
  extends BasePartFragment
{
  private biau a;
  
  public int a()
  {
    return 0;
  }
  
  public List<zxj> a()
  {
    return new ArrayList();
  }
  
  public int b()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QZLog.d("QCircleLoadingFragment", 1, "onCreate...");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QZLog.d("QCircleLoadingFragment", 1, "onCreateView...");
    paramLayoutInflater = paramLayoutInflater.inflate(2131560724, paramViewGroup, false);
    this.a = new biau(getActivity());
    if (this.a != null) {
      this.a.show();
    }
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    uxo.a(getActivity(), getActivity().getIntent().getExtras(), String.valueOf(l), 0);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onStop()
  {
    QZLog.d("QCircleLoadingFragment", 1, "onStop...");
    super.onStop();
    this.a.dismiss();
    getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleLoadingFragment
 * JD-Core Version:    0.7.0.1
 */