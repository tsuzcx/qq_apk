package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor.InflateParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class VideoFeedsResourceLoader
{
  private static int jdField_a_of_type_Int = 0;
  private static LayoutInflateProcessor jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor;
  private static HashMap<Integer, Drawable> jdField_a_of_type_JavaUtilHashMap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  
  public VideoFeedsResourceLoader(Context paramContext)
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor = new LayoutInflateProcessor(paramContext.getApplicationContext());
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    jdField_a_of_type_Int += 1;
    a(paramContext);
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    do
    {
      return null;
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        return (Drawable)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
      try
      {
        paramContext = paramContext.getResources().getDrawable(paramInt);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramContext);
        return paramContext;
      }
      catch (OutOfMemoryError paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsResourceLoader", 2, "innerGetDrawableFromCache() OutOfMemoryError e=" + paramContext.getMessage());
    return null;
  }
  
  public static View a(int paramInt, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    View localView = null;
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor != null) {
      localView = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a(paramInt, paramBoolean, paramLayoutParams);
    }
    while (!paramBoolean) {
      return localView;
    }
    localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(paramInt, null, false);
    localView.setLayoutParams(paramLayoutParams);
    return localView;
  }
  
  private LayoutInflateProcessor.InflateParams a()
  {
    return new LayoutInflateProcessor.InflateParams(2131560450, null, new VideoFeedsResourceLoader.2(this));
  }
  
  private LayoutInflateProcessor.InflateParams a(int paramInt)
  {
    if (ReadInJoyHelper.d()) {
      return new LayoutInflateProcessor.InflateParams(2131560470, paramInt, null, new VideoFeedsResourceLoader.3(this));
    }
    return new LayoutInflateProcessor.InflateParams(2131560454, paramInt, null, new VideoFeedsResourceLoader.4(this));
  }
  
  public static LayoutInflateProcessor a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor;
  }
  
  private void a(Context paramContext)
  {
    ThreadManager.excute(new VideoFeedsResourceLoader.1(this, new WeakReference(paramContext)), 16, null, true);
  }
  
  public void a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor != null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a();
    }
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    jdField_a_of_type_Int -= 1;
    if (jdField_a_of_type_Int <= 0)
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor = null;
      jdField_a_of_type_JavaUtilHashMap = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (LayoutInflateProcessor.InflateParams localInflateParams1 = new LayoutInflateProcessor.InflateParams(2131560486, null, null);; localInflateParams1 = null)
    {
      LayoutInflateProcessor.InflateParams localInflateParams2 = new LayoutInflateProcessor.InflateParams(2131560228, null, null);
      LayoutInflateProcessor.InflateParams localInflateParams3 = new LayoutInflateProcessor.InflateParams(2131560381, null, null);
      LayoutInflateProcessor.InflateParams localInflateParams4 = a(1);
      LayoutInflateProcessor.InflateParams localInflateParams5 = a();
      LayoutInflateProcessor.InflateParams localInflateParams6 = a(2);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a(new LayoutInflateProcessor.InflateParams[] { localInflateParams1, localInflateParams2, localInflateParams3, localInflateParams4, localInflateParams5, localInflateParams6 });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsResourceLoader
 * JD-Core Version:    0.7.0.1
 */