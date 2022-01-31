package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import bdaq;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import java.util.List;
import ors;
import qqw;
import qqx;
import qqy;
import qqz;
import qrk;

public class CoverSelectTabFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { ors.g(2131718807), ors.g(2131718806) };
  private int jdField_a_of_type_Int;
  protected Activity a;
  private View jdField_a_of_type_AndroidViewView;
  private GalleryFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectGalleryFragment;
  private VideoCaptureFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment;
  private TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private List<Fragment> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  private void a()
  {
    Object localObject = getArguments();
    if (localObject == null) {
      return;
    }
    String str = ((Bundle)localObject).getString("ARG_VIDEO_URL");
    float f = ((Bundle)localObject).getFloat("ARG_INITIAL_PROGRESS");
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("ARG_SELECTED_ITEM");
    int i = ((Bundle)localObject).getInt("ARG_VIDEO_WIDTH");
    int j = ((Bundle)localObject).getInt("ARG_VIDEO_HEIGHT");
    localObject = ((Bundle)localObject).getString("ARG_PLACEHOLDER_URL");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment = VideoCaptureFragment.a(str, f);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectGalleryFragment = GalleryFragment.a(i, j, (String)localObject);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectGalleryFragment);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment.a(new qqx(this));
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, float paramFloat, String paramString, UgcVideo paramUgcVideo)
  {
    a(paramActivity, paramInt1, paramInt2, paramFloat, paramString, paramUgcVideo.filePath, paramUgcVideo.width, paramUgcVideo.height);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, float paramFloat, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ARG_SELECTED_ITEM", paramInt2);
    localIntent.putExtra("ARG_VIDEO_URL", paramString2);
    localIntent.putExtra("ARG_INITIAL_PROGRESS", paramFloat);
    localIntent.putExtra("ARG_VIDEO_WIDTH", paramInt3);
    localIntent.putExtra("ARG_VIDEO_HEIGHT", paramInt4);
    localIntent.putExtra("ARG_PLACEHOLDER_URL", paramString1);
    PublicFragmentActivity.a(paramActivity, localIntent, CoverSelectTabFragment.class, paramInt1);
  }
  
  private void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ARG_SELECTED_COVER", paramString);
    localIntent.putExtra("ARG_SELECTED_ITEM", paramInt);
    if (paramInt == 0) {
      localIntent.putExtra("ARG_INITIAL_PROGRESS", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      if (paramInt == 1) {
        localIntent.putExtra("ARG_PLACEHOLDER_URL", paramString);
      }
    }
  }
  
  private void a(qrk paramqrk)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.getCurrentItem() == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment.a(paramqrk);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectGalleryFragment.a(paramqrk);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(new qqy(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 3.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorColor(-1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingLeft(bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 32.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingRight(bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 32.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingBottom(bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 6.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165512), -1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextSize(bdaq.c(this.jdField_a_of_type_AndroidAppActivity, 16.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat, false);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.jdField_a_of_type_AndroidViewView.getId()) {
      a(new qqz(this));
    }
    while (i != this.b.getId()) {
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return View.inflate(getActivity(), 2131559839, null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131378030));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131364901));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramView.findViewById(2131364899));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364900);
    this.b = paramView.findViewById(2131364898);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.a(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    a();
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(new qqw(this, getActivity().getSupportFragmentManager()));
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(1);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment
 * JD-Core Version:    0.7.0.1
 */