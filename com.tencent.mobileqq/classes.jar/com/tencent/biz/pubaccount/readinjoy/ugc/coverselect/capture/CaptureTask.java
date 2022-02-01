package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.lang.ref.SoftReference;

public class CaptureTask
  extends AsyncTask<Void, Void, Bitmap>
{
  int jdField_a_of_type_Int = -2147483648;
  private CaptureTask.OnCaptureCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback;
  private CaptureTask.OnTaskListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnTaskListener;
  private ICaptureProxy jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private SoftReference<Bitmap> jdField_a_of_type_JavaLangRefSoftReference;
  public int b;
  public int c;
  public int d;
  public int e;
  private int f = 0;
  
  public CaptureTask(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback = paramOnCaptureCallback;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnTaskListener = null;
  }
  
  private void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public Bitmap a()
  {
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null))
    {
      Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaLangRefSoftReference.get();
      if (!localBitmap.isRecycled()) {
        return localBitmap;
      }
    }
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
    return null;
  }
  
  protected Bitmap a(Void... arg1)
  {
    ??? = a();
    if (??? != null) {
      return ???;
    }
    this.f += 1;
    Bitmap[] arrayOfBitmap = new Bitmap[1];
    arrayOfBitmap[0] = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy.a(this, new CaptureTask.1(this, arrayOfBitmap));
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait();
        return arrayOfBitmap[0];
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramBitmap);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnTaskListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnTaskListener.b(this);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback != null)
    {
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label68;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback.a(paramBitmap, this);
    }
    for (;;)
    {
      a();
      return;
      label68:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnCaptureCallback.a();
    }
  }
  
  public void a(CaptureTask.OnTaskListener paramOnTaskListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnTaskListener = paramOnTaskListener;
  }
  
  public void a(ICaptureProxy paramICaptureProxy)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureICaptureProxy = paramICaptureProxy;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    a();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnTaskListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectCaptureCaptureTask$OnTaskListener.a(this);
    }
  }
  
  public String toString()
  {
    return "CaptureTask{id=" + this.jdField_a_of_type_Int + ", type=" + this.b + ", path='" + this.jdField_a_of_type_JavaLangString + '\'' + ", position=" + this.c + ", width=" + this.d + ", height=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.CaptureTask
 * JD-Core Version:    0.7.0.1
 */