package com.tencent.biz.qqcircle.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.widgets.QCircleProgressDialog;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QCircleLoadingFragment
  extends BasePartFragment
{
  private QCircleProgressDialog a;
  
  private void a()
  {
    long l = Long.valueOf(HostDataTransUtils.getAccount()).longValue();
    Intent localIntent = getActivity().getIntent();
    if (localIntent != null)
    {
      int i = localIntent.getIntExtra("fromType", 0);
      String str = QCirclePublishQualityReporter.getTraceId();
      if (QCirclePluginInitHelper.isPeakAlive(getContext()))
      {
        QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PUBLIC_START, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", str), QCircleReportHelper.newEntry("ext1", String.valueOf(i)), QCircleReportHelper.newEntry("ext2", "PeakAlive"), QCircleReportHelper.newEntry("ret_code", "0") }));
        QCircleLauncher.a(getActivity(), localIntent.getExtras(), String.valueOf(l), i, str);
      }
      else
      {
        QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PUBLIC_START, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", str), QCircleReportHelper.newEntry("ext1", String.valueOf(i)), QCircleReportHelper.newEntry("ext2", "PeakNoAlive"), QCircleReportHelper.newEntry("ret_code", "0") }));
        QCirclePluginInitHelper.preloadPeakProcess(getContext());
        QLog.d("[QcirclePublish]QCircleLoadingFragment", 1, "onActivityCreated... preloadPeakProcess");
        RFThreadManager.getSerialThreadHandler().postDelayed(new QCircleLoadingFragment.1(this, localIntent, l, i, str), QCircleConfigHelper.w());
      }
      localIntent.putExtra("key_scheme", "");
    }
  }
  
  public String b()
  {
    return "[QcirclePublish]QCircleLoadingFragment";
  }
  
  protected int c()
  {
    return 0;
  }
  
  protected List<Part> d()
  {
    return new ArrayList();
  }
  
  protected int j()
  {
    return 0;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("[QcirclePublish]QCircleLoadingFragment", 1, "onCreateView...");
    paramLayoutInflater = paramLayoutInflater.inflate(2131626867, paramViewGroup, false);
    this.a = new QCircleProgressDialog(getActivity());
    paramViewGroup = this.a;
    if (paramViewGroup != null) {
      paramViewGroup.show();
    }
    a();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onStop()
  {
    QLog.d("[QcirclePublish]QCircleLoadingFragment", 1, "onStop...");
    super.onStop();
    QCircleProgressDialog localQCircleProgressDialog = this.a;
    if ((localQCircleProgressDialog != null) && (localQCircleProgressDialog.isShowing())) {
      this.a.dismiss();
    }
    getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleLoadingFragment
 * JD-Core Version:    0.7.0.1
 */