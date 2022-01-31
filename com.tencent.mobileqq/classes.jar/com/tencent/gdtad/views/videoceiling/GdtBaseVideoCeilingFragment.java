package com.tencent.gdtad.views.videoceiling;

import abtq;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import yxp;
import yzb;

public abstract class GdtBaseVideoCeilingFragment
  extends PublicBaseFragment
{
  private GdtVideoCeilingView a;
  
  public static void a(Activity paramActivity, Class<? extends GdtBaseVideoCeilingFragment> paramClass, GdtVideoCeilingData paramGdtVideoCeilingData)
  {
    a(paramActivity, paramClass, paramGdtVideoCeilingData, null);
  }
  
  public static void a(Activity paramActivity, Class<? extends GdtBaseVideoCeilingFragment> paramClass, GdtVideoCeilingData paramGdtVideoCeilingData, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramGdtVideoCeilingData == null) || (!paramGdtVideoCeilingData.isValid()))
    {
      yxp.d("GdtBaseVideoCeilingFragment", "start error");
      return;
    }
    yxp.b("GdtBaseVideoCeilingFragment", "start");
    Bundle localBundle = new Bundle();
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putSerializable("data", paramGdtVideoCeilingData);
    paramBundle = new Intent();
    if ((paramGdtVideoCeilingData.getAd() != null) && (paramGdtVideoCeilingData.getAd().getNocoId() != 0L)) {
      paramBundle.putExtra("GdtNocoId", paramGdtVideoCeilingData.getAd().getNocoId());
    }
    paramBundle.putExtra("public_fragment_window_feature", 1);
    paramBundle.putExtra("big_brother_source_key", "biz_src_ads");
    paramBundle.putExtras(localBundle);
    if (TextUtils.isEmpty(paramBundle.getStringExtra("big_brother_ref_source_key"))) {
      yxp.d("GdtBaseVideoCeilingFragment", "start gdt empty refId");
    }
    if (paramGdtVideoCeilingData.getStyle() == 4)
    {
      abtq.a(paramActivity, paramBundle, PublicFragmentActivity.class, paramClass);
      return;
    }
    abtq.a(paramActivity, paramBundle, PublicFragmentActivityForTool.class, paramClass);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    return (this.a != null) && (this.a.a());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559111, paramViewGroup, false);
    this.a = ((GdtVideoCeilingView)paramLayoutInflater.findViewById(2131379117));
    yzb.a(this.a);
    this.a.a(paramBundle);
    if ((getArguments() != null) && ((getArguments().getSerializable("data") instanceof GdtVideoCeilingData))) {
      this.a.setData((GdtVideoCeilingData)getArguments().getSerializable("data"));
    }
    if ((getActivity() != null) && (getActivity().getWindow() != null)) {
      getActivity().getWindow().setSoftInputMode(16);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.a();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.a != null) {
      this.a.c();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtBaseVideoCeilingFragment
 * JD-Core Version:    0.7.0.1
 */