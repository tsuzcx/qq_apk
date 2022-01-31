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
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import qrd;
import qre;
import qrk;
import qrl;
import qrp;
import qrq;
import qrw;
import xin;

public class VideoCaptureFragment
  extends PublicBaseFragment
  implements qrd
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CaptureOperateTouchLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout;
  private VideoMeasureScaleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView;
  private qre jdField_a_of_type_Qre;
  private qrl jdField_a_of_type_Qrl;
  private qrq jdField_a_of_type_Qrq;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setOnCaptureOperateCallback(new qrp(this));
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
    this.jdField_a_of_type_Qrl.notifyItemChanged(paramInt);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setDuration(paramLong);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    if (this.jdField_a_of_type_Qre != null) {
      this.jdField_a_of_type_Qre.a(paramBitmap);
    }
  }
  
  public void a(List<qrw> paramList)
  {
    this.jdField_a_of_type_Qrl = new qrl(this.jdField_a_of_type_AndroidAppActivity, paramList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Qrl);
  }
  
  public void a(qre paramqre)
  {
    this.jdField_a_of_type_Qre = paramqre;
  }
  
  public void a(qrk paramqrk)
  {
    this.jdField_a_of_type_Qrq.a(paramqrk);
  }
  
  public int b()
  {
    return (int)((xin.a(BaseApplication.getContext()) - xin.b(this.jdField_a_of_type_AndroidAppActivity, 5.0F)) / a());
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setDuration(paramLong);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setEnabled(true);
  }
  
  public void b(List<qrw> paramList)
  {
    if (this.jdField_a_of_type_Qrl != null)
    {
      this.jdField_a_of_type_Qrl.b();
      this.jdField_a_of_type_Qrl.b(paramList);
      this.jdField_a_of_type_Qrl.notifyDataSetChanged();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131559843, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Qrq.c();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Qrq.e();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Qrq.d();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131379645));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131379639));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout = ((CaptureOperateTouchLayout)paramView.findViewById(2131379643));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379640));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379644));
    this.b = ((TextView)paramView.findViewById(2131379646));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView = ((VideoMeasureScaleView)paramView.findViewById(2131379642));
    this.jdField_a_of_type_Qrq = new qrq(this.jdField_a_of_type_AndroidAppActivity, getArguments(), this);
    paramView = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutParams().height = b();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    a();
    b();
    this.jdField_a_of_type_Qrq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.VideoCaptureFragment
 * JD-Core Version:    0.7.0.1
 */