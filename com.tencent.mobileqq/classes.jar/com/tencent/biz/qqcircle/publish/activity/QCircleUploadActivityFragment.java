package com.tencent.biz.qqcircle.publish.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;
import com.tencent.biz.qqcircle.publish.viewmodel.QCircleLabelViewModel;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.List;

public class QCircleUploadActivityFragment
  extends QCircleBaseFragment
{
  private List<Part> c;
  private QCircleTitlePart d;
  private QCirclePublishContentPart e;
  private QCircleMediaPart f;
  private QCircleLabelPart g;
  private QCircleLbsPart h;
  private QCirclePublishSharePart i;
  private QCircleSavePart j;
  private QCirclePublishViewModel k;
  private QCircleLabelViewModel l;
  
  private void u()
  {
    QLog.d("[QcirclePublish]QCircleUploadActivityFragment", 1, "initViewModelData...");
    if (this.k == null) {
      this.k = ((QCirclePublishViewModel)a(QCirclePublishViewModel.class));
    }
    this.k.a(this, getActivity().getIntent(), false);
    if (this.l == null) {
      this.l = ((QCircleLabelViewModel)a(QCircleLabelViewModel.class));
    }
    this.l.a(getActivity().getIntent());
    this.l.a(getActivity(), getActivity().getIntent());
  }
  
  public int a()
  {
    return -1;
  }
  
  public String b()
  {
    return "[QcirclePublish]QCircleUploadActivityFragment";
  }
  
  protected int c()
  {
    return 2131626925;
  }
  
  protected List<Part> d()
  {
    u();
    if (this.c == null)
    {
      this.c = new ArrayList();
      this.d = new QCircleTitlePart();
      this.c.add(this.d);
      this.e = new QCirclePublishContentPart();
      this.c.add(this.e);
      this.f = new QCircleMediaPart();
      this.c.add(this.f);
      this.g = new QCircleLabelPart();
      this.c.add(this.g);
      this.h = new QCircleLbsPart();
      this.c.add(this.h);
      this.i = new QCirclePublishSharePart();
      this.c.add(this.i);
      this.j = new QCircleSavePart();
      this.c.add(this.j);
    }
    return this.c;
  }
  
  protected String f()
  {
    return "pg_xsj_publish_page";
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() != null) {
      getActivity().getWindow().setSoftInputMode(3);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("[onCreate...] + END, time cost:");
    paramBundle.append(System.currentTimeMillis() - l1);
    QLog.d("[Performance2][QcirclePublish]QCircleUploadActivityFragment", 1, paramBundle.toString());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("[onCreateView...] + END, time cost:");
    paramViewGroup.append(System.currentTimeMillis() - l1);
    QLog.d("[Performance2][QcirclePublish]QCircleUploadActivityFragment", 1, paramViewGroup.toString());
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QCirclePublishViewModel localQCirclePublishViewModel = this.k;
    if (localQCirclePublishViewModel != null) {
      localQCirclePublishViewModel.onCleared();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d("[QcirclePublish]QCircleUploadActivityFragment", 1, "onNewIntent...");
    getActivity().setIntent(paramIntent);
    if (this.k == null) {
      this.k = ((QCirclePublishViewModel)a(QCirclePublishViewModel.class));
    }
    this.k.a(this, getActivity().getIntent(), true);
  }
  
  public void onPause()
  {
    long l1 = System.currentTimeMillis();
    super.onPause();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onPause...] + END, time cost:");
    localStringBuilder.append(System.currentTimeMillis() - l1);
    QLog.d("[Performance2][QcirclePublish]QCircleUploadActivityFragment", 1, localStringBuilder.toString());
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.k;
    if (localObject != null) {
      localObject = String.valueOf(((QCirclePublishViewModel)localObject).l);
    } else {
      localObject = "";
    }
    QCirclePublishReport.a(15, 1, 0, (String)localObject, "");
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle = this.k;
    if ((paramBundle != null) && (paramBundle.e()) && (!this.k.f()) && (!this.k.n)) {
      this.k.a(this, 2);
    }
  }
  
  public void onStart()
  {
    long l1 = System.currentTimeMillis();
    super.onStart();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onStart...] + END, time cost:");
    localStringBuilder.append(System.currentTimeMillis() - l1);
    QLog.d("[Performance2][QcirclePublish]QCircleUploadActivityFragment", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleUploadActivityFragment
 * JD-Core Version:    0.7.0.1
 */