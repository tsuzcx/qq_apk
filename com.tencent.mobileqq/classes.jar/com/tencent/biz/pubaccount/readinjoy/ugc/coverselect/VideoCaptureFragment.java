package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout;
import com.tencent.biz.pubaccount.readinjoy.view.VideoMeasureScaleView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;
import rwo;
import rwp;
import rwv;
import rww;
import rxa;
import rxb;
import rxh;

public class VideoCaptureFragment
  extends PublicBaseFragment
  implements rwo
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CaptureOperateTouchLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout;
  private VideoMeasureScaleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView;
  private rwp jdField_a_of_type_Rwp;
  private rww jdField_a_of_type_Rww;
  private rxb jdField_a_of_type_Rxb;
  private TextView b;
  
  public static VideoCaptureFragment a(String paramString, float paramFloat)
  {
    VideoCaptureFragment localVideoCaptureFragment = new VideoCaptureFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("ARG_VIDEO_URL", paramString);
    localBundle.putFloat("ARG_INITIAL_PROGRESS", paramFloat);
    localVideoCaptureFragment.setArguments(localBundle);
    return localVideoCaptureFragment;
  }
  
  private void a()
  {
    int i = b() + this.jdField_a_of_type_AndroidWidgetImageView.getPaddingTop() + this.jdField_a_of_type_AndroidWidgetImageView.getPaddingBottom();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.height = i;
    localLayoutParams.width = i;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setup(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView, a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setOnCaptureOperateCallback(new rxa(this));
  }
  
  public float a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.a();
  }
  
  public int a()
  {
    return 5;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.a(paramFloat, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rww.notifyItemChanged(paramInt);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setDuration(paramLong);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    if (this.jdField_a_of_type_Rwp != null) {
      this.jdField_a_of_type_Rwp.a(paramBitmap);
    }
  }
  
  public void a(List<rxh> paramList)
  {
    this.jdField_a_of_type_Rww = new rww(this.jdField_a_of_type_AndroidAppActivity, paramList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Rww);
  }
  
  public void a(rwp paramrwp)
  {
    this.jdField_a_of_type_Rwp = paramrwp;
  }
  
  public void a(rwv paramrwv)
  {
    this.jdField_a_of_type_Rxb.a(paramrwv);
  }
  
  public int b()
  {
    return (int)((DisplayUtil.getWindowScreenWidth(BaseApplication.getContext()) - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 5.0F)) / a());
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setDuration(paramLong);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setEnabled(true);
  }
  
  public void b(List<rxh> paramList)
  {
    if (this.jdField_a_of_type_Rww != null)
    {
      this.jdField_a_of_type_Rww.b();
      this.jdField_a_of_type_Rww.b(paramList);
      this.jdField_a_of_type_Rww.notifyDataSetChanged();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560033, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Rxb.c();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Rxb.e();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Rxb.d();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131380839));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131380833));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout = ((CaptureOperateTouchLayout)paramView.findViewById(2131380837));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380834));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380838));
    this.b = ((TextView)paramView.findViewById(2131380840));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView = ((VideoMeasureScaleView)paramView.findViewById(2131380836));
    this.jdField_a_of_type_Rxb = new rxb(this.jdField_a_of_type_AndroidAppActivity, getArguments(), this);
    paramView = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutParams().height = b();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    a();
    b();
    this.jdField_a_of_type_Rxb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.VideoCaptureFragment
 * JD-Core Version:    0.7.0.1
 */