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
import bdag;
import bhou;
import com.tencent.biz.pubaccount.readinjoy.view.AlbumPermissionView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import mqq.app.QQPermissionCallback;
import oxb;
import qnz;
import qrf;
import qri;
import qsb;
import qtd;
import qwl;
import qwn;
import qwo;
import qwp;
import qwy;

public class SelectVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, QQPermissionCallback, qri, qwl
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AlbumPermissionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private qrf jdField_a_of_type_Qrf;
  private qtd jdField_a_of_type_Qtd = new qwn(this);
  private qwp jdField_a_of_type_Qwp;
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
    if ((bhou.k()) && (!bdag.b()) && (!bdag.d()))
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.a())
    {
      this.jdField_a_of_type_Qwp.a();
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
    return this.jdField_a_of_type_Qrf.getItemCount();
  }
  
  public qnz a(int paramInt)
  {
    return (qnz)this.jdField_a_of_type_Qrf.a(paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qwp.a(paramInt);
  }
  
  public void a(List<qnz> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qrf.b(paramList);
    if (this.jdField_a_of_type_Qrf.a())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(qnz paramqnz)
  {
    this.jdField_a_of_type_Qwp.a(paramqnz);
  }
  
  public boolean a(int paramInt, qnz paramqnz)
  {
    return this.jdField_a_of_type_Qwp.a(paramqnz);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Qrf.a(paramInt);
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 10000)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setVisibility(8);
      this.jdField_a_of_type_Qwp.a();
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
    this.jdField_a_of_type_Qwp = new qwp(getActivity(), this);
    oxb.a().a(this.jdField_a_of_type_Qtd);
    qsb.d();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.jdField_a_of_type_AndroidWidgetTextView.getId()) {
      this.jdField_a_of_type_Qwp.b();
    }
    while (i != this.jdField_a_of_type_AndroidViewView.getId()) {
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    c();
    return View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131559843, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Qwp.a().c();
    oxb.a().b(this.jdField_a_of_type_Qtd);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Qwp.a().b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Qwp.a().a();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131379688));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378842));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131379743));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131377910));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131377976));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364338);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView = ((AlbumPermissionView)paramView.findViewById(2131362504));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365740);
    d();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_Qrf = new qrf(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Qrf.a(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 3, 1, false));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Qrf);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new qwo(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setContextStyleBlack(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setCallback(this);
    this.jdField_a_of_type_Qwp.a().a(this.jdField_a_of_type_AndroidViewViewGroup);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment
 * JD-Core Version:    0.7.0.1
 */