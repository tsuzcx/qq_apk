package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.concurrent.Executor;

public class CandidateCaptureManager
  implements CapturePreparedListener, ISuperPlayer.OnSeekCompleteListener
{
  private int jdField_a_of_type_Int = -1;
  private CaptureTask.OnCaptureCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback;
  private CaptureTask jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask = null;
  private ICaptureProxy jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy = new PlayerCaptureProxy();
  private String jdField_a_of_type_JavaLangString;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManagerExecutor.getExecutorService(64);
  private int b;
  private int c;
  
  private void d()
  {
    e();
    CaptureTask localCaptureTask = new CaptureTask(2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask = localCaptureTask;
    localCaptureTask.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy);
    localCaptureTask.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask.cancel(true);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask = null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a(paramInt, this);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback = paramOnCaptureCallback;
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, CapturePreparedListener paramCapturePreparedListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a(paramString, paramViewGroup);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a(paramCapturePreparedListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a(this);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback = null;
    e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a();
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.CandidateCaptureManager
 * JD-Core Version:    0.7.0.1
 */