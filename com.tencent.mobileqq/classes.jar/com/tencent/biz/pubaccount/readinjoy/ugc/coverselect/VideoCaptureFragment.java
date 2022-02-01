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
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.CaptureTask;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout;
import com.tencent.biz.pubaccount.readinjoy.view.VideoMeasureScaleView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;

public class VideoCaptureFragment
  extends PublicBaseFragment
  implements IVideoCaptureView
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageUpdateListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectImageUpdateListener;
  private PreviewImageAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectPreviewImageAdapter;
  private VideoCapturePresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCapturePresenter;
  private CaptureOperateTouchLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout;
  private VideoMeasureScaleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setOnCaptureOperateCallback(new VideoCaptureFragment.1(this));
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectPreviewImageAdapter.notifyItemChanged(paramInt);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setDuration(paramLong);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectImageUpdateListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectImageUpdateListener.a(paramBitmap);
    }
  }
  
  public void a(ImageUpdateListener paramImageUpdateListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectImageUpdateListener = paramImageUpdateListener;
  }
  
  public void a(OutputPicListener paramOutputPicListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCapturePresenter.a(paramOutputPicListener);
  }
  
  public void a(List<CaptureTask> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectPreviewImageAdapter = new PreviewImageAdapter(this.jdField_a_of_type_AndroidAppActivity, paramList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectPreviewImageAdapter);
  }
  
  public int b()
  {
    return (int)((DisplayUtil.a(BaseApplication.getContext()) - DisplayUtil.b(this.jdField_a_of_type_AndroidAppActivity, 5.0F)) / a());
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setDuration(paramLong);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setEnabled(true);
  }
  
  public void b(List<CaptureTask> paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectPreviewImageAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectPreviewImageAdapter.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectPreviewImageAdapter.b(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectPreviewImageAdapter.notifyDataSetChanged();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560110, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCapturePresenter.c();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCapturePresenter.e();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCapturePresenter.d();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131381287));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131381281));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout = ((CaptureOperateTouchLayout)paramView.findViewById(2131381285));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381282));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381286));
    this.b = ((TextView)paramView.findViewById(2131381288));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView = ((VideoMeasureScaleView)paramView.findViewById(2131381284));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCapturePresenter = new VideoCapturePresenter(this.jdField_a_of_type_AndroidAppActivity, getArguments(), this);
    paramView = new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutParams().height = b();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    a();
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCapturePresenter.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.VideoCaptureFragment
 * JD-Core Version:    0.7.0.1
 */