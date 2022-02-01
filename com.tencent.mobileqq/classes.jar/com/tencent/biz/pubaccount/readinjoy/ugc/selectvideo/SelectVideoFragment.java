package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo;

import android.app.Activity;
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
import bhjr;
import com.tencent.biz.pubaccount.readinjoy.view.AlbumPermissionView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import mqq.app.QQPermissionCallback;
import pfd;
import pfh;
import qzp;
import rdd;
import rdg;
import rdz;
import rjf;
import rjh;
import rji;
import rjj;
import rjs;

public class SelectVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, QQPermissionCallback, rdg, rjf
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AlbumPermissionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private pfh jdField_a_of_type_Pfh = new rjh(this);
  private rdd jdField_a_of_type_Rdd;
  private rjj jdField_a_of_type_Rjj;
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
    if ((VersionUtils.isM()) && (!bhjr.b()) && (!bhjr.d()))
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.a())
    {
      this.jdField_a_of_type_Rjj.a();
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
    return this.jdField_a_of_type_Rdd.getItemCount();
  }
  
  public qzp a(int paramInt)
  {
    return (qzp)this.jdField_a_of_type_Rdd.a(paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rjj.a(paramInt);
  }
  
  public void a(List<qzp> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Rdd.b(paramList);
    if (this.jdField_a_of_type_Rdd.b())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(qzp paramqzp)
  {
    this.jdField_a_of_type_Rjj.a(paramqzp);
  }
  
  public boolean a(int paramInt, qzp paramqzp)
  {
    return this.jdField_a_of_type_Rjj.a(paramqzp);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Rdd.a(paramInt);
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 10000)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setVisibility(8);
      this.jdField_a_of_type_Rjj.a();
    }
  }
  
  public boolean needImmersive()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rjj = new rjj(getActivity(), this);
    pfd.a().a(this.jdField_a_of_type_Pfh);
    rdz.d();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.jdField_a_of_type_AndroidWidgetTextView.getId()) {
      this.jdField_a_of_type_Rjj.b();
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
    paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131559984, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Rjj.a().c();
    pfd.a().b(this.jdField_a_of_type_Pfh);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Rjj.a().b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Rjj.a().a();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131380880));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379961));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131380936));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131378964));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131379037));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364596);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView = ((AlbumPermissionView)paramView.findViewById(2131362607));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366029);
    d();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_Rdd = new rdd(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Rdd.a(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 3, 1, false));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Rdd);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new rji(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setContextStyleBlack(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setCallback(this);
    this.jdField_a_of_type_Rjj.a().a(this.jdField_a_of_type_AndroidViewViewGroup);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment
 * JD-Core Version:    0.7.0.1
 */