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
import com.tencent.biz.pubaccount.readinjoy.view.AlbumPermissionView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import mqq.app.QQPermissionCallback;
import ptj;
import pvm;
import pvq;
import rsv;
import rwq;
import rwt;
import rxm;
import scu;
import scw;
import scx;
import scy;
import sdh;

public class SelectVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, QQPermissionCallback, rwt, scu
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AlbumPermissionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private pvq jdField_a_of_type_Pvq = new scw(this);
  private rwq jdField_a_of_type_Rwq;
  private scy jdField_a_of_type_Scy;
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
    if ((VersionUtils.isM()) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.a())
    {
      this.jdField_a_of_type_Scy.a();
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
    return this.jdField_a_of_type_Rwq.getItemCount();
  }
  
  public rsv a(int paramInt)
  {
    return (rsv)this.jdField_a_of_type_Rwq.a(paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Scy.a(paramInt);
  }
  
  public void a(List<rsv> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Rwq.b(paramList);
    if (this.jdField_a_of_type_Rwq.c())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(rsv paramrsv)
  {
    this.jdField_a_of_type_Scy.a(paramrsv);
  }
  
  public boolean a(int paramInt, rsv paramrsv)
  {
    return this.jdField_a_of_type_Scy.a(paramrsv);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Rwq.a(paramInt);
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 10000)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setVisibility(8);
      this.jdField_a_of_type_Scy.a();
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
    this.jdField_a_of_type_Scy = new scy(getActivity(), this);
    pvm.a().a(this.jdField_a_of_type_Pvq);
    rxm.d();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.jdField_a_of_type_AndroidWidgetTextView.getId()) {
      this.jdField_a_of_type_Scy.b();
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
    ptj.a.a(getActivity());
    paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560032, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Scy.a().c();
    pvm.a().b(this.jdField_a_of_type_Pvq);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Scy.a().b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Scy.a().a();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131380952));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380041));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131381010));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131379027));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131379099));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364711);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView = ((AlbumPermissionView)paramView.findViewById(2131362625));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366160);
    d();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_Rwq = new rwq(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Rwq.a(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 3, 1, false));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Rwq);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new scx(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setContextStyleBlack(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setCallback(this);
    this.jdField_a_of_type_Scy.a().a(this.jdField_a_of_type_AndroidViewViewGroup);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment
 * JD-Core Version:    0.7.0.1
 */