package com.tencent.biz.qcircleshadow.lib;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import cooperation.qqcircle.report.QCircleReporter;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class QCirclePluginTrace
  implements Serializable
{
  public static final String TAG = "QCirclePluginLoadTrace";
  public static final String TRACE_EVENT_ID_INIT_INFO = "qcircle_init_info";
  public static final String TRACE_LOAD_PLUGIN_LOADER = "qcircle_load_plugin_loader";
  public static final String TRACE_LOAD_RUNTIME = "qcircle_load_runtime";
  public static final String TRACE_ODEX_INSTALL = "qcircle_odex_install";
  public static final String TRACE_ON_CREATE = "qcircle_on_create";
  public static final String TRACE_START_SPLASH = "qcircle_trace_splash";
  public static final String TRACE_WAIT_FOR_SERVICE = "qcircle_wait_service_connect";
  private ConcurrentHashMap<String, Long> mTraceMapCost = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> mTraceMapStart = new ConcurrentHashMap();
  
  public static void traceEndAndUpdate(Bundle paramBundle, String paramString)
  {
    QCirclePluginInitBean localQCirclePluginInitBean = (QCirclePluginInitBean)paramBundle.getSerializable("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN");
    if ((localQCirclePluginInitBean != null) && (localQCirclePluginInitBean.getTrace() != null))
    {
      localQCirclePluginInitBean.getTrace().traceEnd(paramString);
      paramBundle.putSerializable("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN", localQCirclePluginInitBean);
    }
  }
  
  public static void traceStartAndUpdate(Bundle paramBundle, String paramString)
  {
    QCirclePluginInitBean localQCirclePluginInitBean = (QCirclePluginInitBean)paramBundle.getSerializable("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN");
    if (localQCirclePluginInitBean != null)
    {
      QCirclePluginTrace localQCirclePluginTrace2 = localQCirclePluginInitBean.getTrace();
      QCirclePluginTrace localQCirclePluginTrace1 = localQCirclePluginTrace2;
      if (localQCirclePluginTrace2 == null) {
        localQCirclePluginTrace1 = new QCirclePluginTrace();
      }
      localQCirclePluginTrace1.traceStart(paramString);
      localQCirclePluginInitBean.setTrace(localQCirclePluginTrace1);
      paramBundle.putSerializable("KEY_Q_CIRCLE_PLUGIN_INIT_BEAN", localQCirclePluginInitBean);
    }
  }
  
  public void flush(long paramLong, String paramString, boolean paramBoolean)
  {
    QCircleReporter.getInstance().getReportHandler().post(new QCirclePluginTrace.1(this, paramLong, paramString, paramBoolean));
  }
  
  public void traceEnd(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.mTraceMapStart.containsKey(paramString)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = ((Long)this.mTraceMapStart.get(paramString)).longValue();
      this.mTraceMapCost.put(paramString, Long.valueOf(l1 - l2));
    }
  }
  
  public void traceStart(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.mTraceMapStart.containsKey(paramString))) {
      this.mTraceMapStart.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginTrace
 * JD-Core Version:    0.7.0.1
 */