package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.LocalMediaGridAdapter;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.LocalMediaGridAdapter.OnItemListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.PlayerCaptureProxy;
import com.tencent.biz.pubaccount.readinjoy.view.AlbumPermissionView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import mqq.app.QQPermissionCallback;

public class SelectVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, LocalMediaGridAdapter.OnItemListener, ISelectVideoView, QQPermissionCallback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new SelectVideoFragment.1(this);
  private LocalMediaGridAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter;
  private SelectVideoPresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter;
  private AlbumPermissionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  
  public static SelectVideoFragment a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAMS_IS_SHOW_TITLEBAR", paramBoolean);
    SelectVideoFragment localSelectVideoFragment = new SelectVideoFragment();
    localSelectVideoFragment.setArguments(localBundle);
    return localSelectVideoFragment;
  }
  
  private void a()
  {
    if ((VersionUtils.k()) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter.a();
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setVisibility(0);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = getArguments().getBoolean("PARAMS_IS_SHOW_TITLEBAR", true);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
      a();
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(8);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter.getItemCount();
  }
  
  public AlbumUtils.LocalMediaInfo a(int paramInt)
  {
    return (AlbumUtils.LocalMediaInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter.a(paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter.a(paramInt);
  }
  
  public void a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter.a(paramLocalMediaInfo);
  }
  
  public void a(List<AlbumUtils.LocalMediaInfo> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter.b(paramList);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter.c())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a(int paramInt, AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter.a(paramLocalMediaInfo);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter.a(paramInt);
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 10000)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter.a();
    }
  }
  
  public boolean needImmersive()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && ((paramInt2 == -1) || (paramInt2 == 3)))
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(paramInt2, paramIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter = new SelectVideoPresenter(getActivity(), this);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    PlayerCaptureProxy.d();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.jdField_a_of_type_AndroidWidgetTextView.getId()) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter.b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == this.jdField_a_of_type_AndroidViewView.getId()) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    c();
    RIJDtReportHelper.a.a(getActivity());
    paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560109, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter.a().c();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter.a().b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter.a().a();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131381409));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380478));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131381469));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131379458));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131379533));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364828);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView = ((AlbumPermissionView)paramView.findViewById(2131362658));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366331);
    d();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter = new LocalMediaGridAdapter(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter.a(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 3, 1, false));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectLocalMediaGridAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new SelectVideoFragment.2(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setContextStyleBlack(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectvideoSelectVideoPresenter.a().a(this.jdField_a_of_type_AndroidViewViewGroup);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment
 * JD-Core Version:    0.7.0.1
 */