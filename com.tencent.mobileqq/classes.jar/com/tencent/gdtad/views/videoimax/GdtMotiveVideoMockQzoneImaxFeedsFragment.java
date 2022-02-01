package com.tencent.gdtad.views.videoimax;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pic.URLDrawableDepWrapInit;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.qzone.util.QZLog;
import java.io.File;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;

public class GdtMotiveVideoMockQzoneImaxFeedsFragment
  extends PublicBaseFragment
{
  private static boolean jdField_a_of_type_Boolean = false;
  private GdtImaxData jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData;
  
  private static void a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Boolean) {
          return;
        }
        if (paramContext == null) {
          break;
        }
        URLDrawable.DEBUG = false;
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          localFile = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
          localFile = new File(localFile, "diskcache");
          URLDrawable.init(URLDrawableDepWrapInit.a(), new GdtMotiveVideoMockQzoneImaxFeedsFragment.URLDrawableFactory(paramContext, localFile));
          jdField_a_of_type_Boolean = true;
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        QZLog.e("GdtMotiveVideoMockQzoneImaxFeedsFragment", "UrlDrawable init exception.", paramContext);
        return;
      }
      File localFile = paramContext.getCacheDir();
    }
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    GdtLog.a("GdtMotiveVideoMockQzoneImaxFeedsFragment", "bindPreviewImage() called with: iv = [" + paramImageView + "], url = [" + paramString + "]");
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramImageView.getResources().getDrawable(2130851162);
    localURLDrawableOptions.mFailedDrawable = paramImageView.getResources().getDrawable(2130851162);
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    paramImageView.setOnClickListener(new GdtMotiveVideoMockQzoneImaxFeedsFragment.1(this));
  }
  
  private void a(String paramString) {}
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      a(paramActivity.getApplication());
      this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData = ((GdtImaxData)paramActivity.getIntent().getSerializableExtra("data"));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GdtMotiveVideoMockQzoneImaxFeedsFragment", 1, "", localThrowable);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    GdtLog.a("GdtMotiveVideoMockQzoneImaxFeedsFragment", "onCreateView: ");
    paramLayoutInflater = paramLayoutInflater.inflate(2131559322, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    paramView = (ImageView)paramView.findViewById(2131369454);
    paramBundle = this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtImaxData.getAd().info.display_info.basic_info.img.get();
    a(paramView, paramBundle);
    a(paramBundle);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtMotiveVideoMockQzoneImaxFeedsFragment
 * JD-Core Version:    0.7.0.1
 */