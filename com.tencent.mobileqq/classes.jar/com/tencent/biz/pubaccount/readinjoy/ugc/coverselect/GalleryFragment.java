package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.biz.pubaccount.readinjoy.view.AlbumPermissionView;
import com.tencent.biz.pubaccount.readinjoy.view.ucrop.GestureCropImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ucrop.UCropView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;
import riw;
import rjf;
import rmd;
import rme;
import rmf;
import rmi;
import rml;
import rmn;

public class GalleryFragment
  extends PublicBaseFragment
  implements QQPermissionCallback, rml
{
  private int jdField_a_of_type_Int;
  public Activity a;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private AlbumPermissionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView;
  private UCropView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropUCropView;
  private String jdField_a_of_type_JavaLangString;
  private List<riw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private rjf<riw> jdField_a_of_type_Rjf = new rjf();
  private rmi jdField_a_of_type_Rmi;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  
  public static GalleryFragment a(int paramInt1, int paramInt2, String paramString)
  {
    GalleryFragment localGalleryFragment = new GalleryFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("ARG_VIDEO_WIDTH", paramInt1);
    localBundle.putInt("ARG_VIDEO_HEIGHT", paramInt2);
    localBundle.putString("ARG_PLACEHOLDER_URL", paramString);
    localGalleryFragment.setArguments(localBundle);
    return localGalleryFragment;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.a())
    {
      d();
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setVisibility(0);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      ThreadManager.post(new GalleryFragment.4(this, paramString), 8, null, true);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = localBundle.getString("ARG_PLACEHOLDER_URL");
    this.jdField_a_of_type_Int = localBundle.getInt("ARG_VIDEO_WIDTH");
    this.jdField_b_of_type_Int = localBundle.getInt("ARG_VIDEO_HEIGHT");
  }
  
  private void b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new GalleryFragment.5(this, paramBitmap));
  }
  
  private void b(riw paramriw)
  {
    a(paramriw.b);
  }
  
  private void c()
  {
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Rjf.a();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropUCropView.a();
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0))
    {
      GestureCropImageView localGestureCropImageView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropUCropView.a();
      localGestureCropImageView.setMaxScale(2.0F);
      localGestureCropImageView.setIsDoubleTapEnabled(false);
      localGestureCropImageView.setMaxResultImageSizeX(this.jdField_a_of_type_Int);
      localGestureCropImageView.setMaxResultImageSizeY(this.jdField_b_of_type_Int);
      localGestureCropImageView.setTargetAspectRatio(this.jdField_a_of_type_Int / this.jdField_b_of_type_Int);
      return;
    }
    QLog.e("RIJUGC.GalleryFragment", 1, "setAspectRatio error mVideoWidth:" + this.jdField_a_of_type_Int + "mVideoHeight" + this.jdField_b_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rjf.a(paramInt);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Rmi.a() >= 0) {}
    for (int i = 1;; i = 0)
    {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (i == 0)) {
        b(paramBitmap);
      }
      return;
    }
  }
  
  public void a(riw paramriw)
  {
    e();
    b(paramriw);
  }
  
  public void a(rmn paramrmn)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropUCropView.a().a(Bitmap.CompressFormat.JPEG, 90, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, new rmf(this, paramrmn));
  }
  
  public boolean a(int paramInt, riw paramriw)
  {
    if ((paramriw.a() < this.jdField_a_of_type_Int / 2.0F) || (paramriw.b() < this.jdField_b_of_type_Int / 2.0F))
    {
      Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, 2131717189, 0).show();
      return false;
    }
    return true;
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 10000)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setVisibility(8);
      d();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
    this.jdField_a_of_type_Rjf.a(new rmd(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131559980, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131367296));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365983);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropUCropView = ((UCropView)paramView.findViewById(2131367293));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView = ((AlbumPermissionView)paramView.findViewById(2131362592));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370051);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setCallback(this);
    this.jdField_a_of_type_Rmi = new rmi(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Rmi.a(this);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Rmi.a();
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 4);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new rme(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Rmi);
    e();
    c();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.GalleryFragment
 * JD-Core Version:    0.7.0.1
 */