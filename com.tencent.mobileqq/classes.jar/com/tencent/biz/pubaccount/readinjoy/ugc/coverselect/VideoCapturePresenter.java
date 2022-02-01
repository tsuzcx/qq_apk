package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.CandidateCaptureManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.CapturePreparedListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.CaptureTask;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.ICaptureProxy;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.PreviewCaptureManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SavePicTask;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoCapturePresenter
  implements CapturePreparedListener
{
  private static float jdField_a_of_type_Float = 0.8F;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private IVideoCaptureView jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView;
  private CandidateCaptureManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCandidateCaptureManager;
  private ICaptureProxy jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy;
  private PreviewCaptureManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCapturePreviewCaptureManager;
  private String jdField_a_of_type_JavaLangString;
  private List<CaptureTask> jdField_a_of_type_JavaUtilList = new ArrayList();
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<CaptureTask> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public VideoCapturePresenter(Activity paramActivity, Bundle paramBundle, IVideoCaptureView paramIVideoCaptureView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView = paramIVideoCaptureView;
    a(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy = new SystemCaptureProxy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCandidateCaptureManager = new CandidateCaptureManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCapturePreviewCaptureManager = new PreviewCaptureManager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCandidateCaptureManager.a(new VideoCapturePresenter.1(this, paramIVideoCaptureView));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, List<CaptureTask> paramList)
  {
    CaptureTask localCaptureTask = new CaptureTask(1, this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2, paramInt3, new VideoCapturePresenter.PreviewCaptureCallback(this, paramList.size()));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCapturePreviewCaptureManager.c(localCaptureTask);
    paramList.add(localCaptureTask);
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = (URLDrawableHelper.diskCachePath + File.separator + AbsDownloader.getFileName(new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("-").append(paramInt).toString()));
    new SavePicTask(paramBitmap, this.jdField_b_of_type_JavaLangString).a();
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("ARG_VIDEO_URL");
    this.jdField_b_of_type_Float = paramBundle.getFloat("ARG_INITIAL_PROGRESS");
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView.b() * jdField_a_of_type_Float));
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * paramInt2 / paramInt1);
    }
    for (;;)
    {
      paramInt1 = (int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView.b() * jdField_a_of_type_Float);
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_a_of_type_Int = paramInt1;
      return;
      this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView.b() * jdField_a_of_type_Float));
      this.jdField_a_of_type_Int = (this.jdField_b_of_type_Int * paramInt1 / paramInt2);
    }
  }
  
  private void f()
  {
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView.a();
    float f = 0.0F;
    if (j > 0) {
      f = (float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a() / j;
    }
    int i = 0;
    while (i < j)
    {
      a((int)(i * f), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaUtilList);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCandidateCaptureManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView.a(), new VideoCapturePresenter.2(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a(this.jdField_a_of_type_JavaLangString, null);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCandidateCaptureManager.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView.a())
    {
      int j = (i - paramInt2) * CaptureOperateTouchLayout.jdField_a_of_type_Int + paramInt1;
      a(j, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaUtilList);
      localArrayList.add(Integer.valueOf(j));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView.b(this.jdField_b_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("VideoCapturePresenter", 2, "expandCandidateImageList positionList:" + localArrayList + " position：" + paramInt1 + " seedPosition：" + paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    b(paramInt1, paramInt2);
    f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a());
  }
  
  public void a(OutputPicListener paramOutputPicListener)
  {
    paramOutputPicListener.a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectIVideoCaptureView.b(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCapturePreviewCaptureManager.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCandidateCaptureManager.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCandidateCaptureManager.a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCandidateCaptureManager.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.VideoCapturePresenter
 * JD-Core Version:    0.7.0.1
 */