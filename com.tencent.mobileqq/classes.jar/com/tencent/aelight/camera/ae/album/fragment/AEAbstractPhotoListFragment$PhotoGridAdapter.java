package com.tencent.aelight.camera.ae.album.fragment;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic.IadapterCallback;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCommonUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class AEAbstractPhotoListFragment$PhotoGridAdapter
  extends RecyclerView.Adapter<AEAbstractPhotoListFragment.PhotoVH>
  implements URLDrawableDownListener
{
  public ColorDrawable a;
  public Drawable a;
  public LayoutInflater a;
  public ArrayList<LocalMediaInfo> a;
  
  public AEAbstractPhotoListFragment$PhotoGridAdapter(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramAEAbstractPhotoListFragment.getActivity().getLayoutInflater();
  }
  
  public TextView a()
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.getActivity());
    localTextView.setGravity(17);
    localTextView.setTextSize(10.0F);
    localTextView.setTextColor(-1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setSize(QAlbumCommonUtil.dp2px(30.0F, this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.getResources()), QAlbumCommonUtil.dp2px(18.0F, this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.getResources()));
    localGradientDrawable.setCornerRadii(new float[] { QAlbumCommonUtil.dp2px(2.0F, this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.getResources()), QAlbumCommonUtil.dp2px(2.0F, this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.getResources()), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setColor(1291845632);
    localTextView.setBackgroundDrawable(localGradientDrawable);
    return localTextView;
  }
  
  public AEAbstractPhotoListFragment.PhotoVH a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a != null))
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment;
          return new AEAbstractPhotoListFragment.PhotoVH(paramViewGroup, paramViewGroup.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a.c());
        }
      }
      else if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a != null)
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment;
        return new AEAbstractPhotoListFragment.PhotoVH(paramViewGroup, paramViewGroup.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a.b());
      }
    }
    else if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a != null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment;
      return new AEAbstractPhotoListFragment.PhotoVH(paramViewGroup, paramViewGroup.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a.a());
    }
    return null;
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, int paramInt)
  {
    AEAbstractPhotoListFragment.PhotoItemClickListener localPhotoItemClickListener = new AEAbstractPhotoListFragment.PhotoItemClickListener(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment);
    int i = getItemViewType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a != null) {
          this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a.c(paramInt, paramPhotoVH, localPhotoItemClickListener);
        }
      }
      else if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a.b(paramInt, paramPhotoVH, localPhotoItemClickListener);
      }
    }
    else if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a.a(paramInt, paramPhotoVH, localPhotoItemClickListener);
    }
  }
  
  public void a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if ((!this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.r) && (QAlbumUtil.getMediaType((LocalMediaInfo)paramList.get(0)) == 2)) {
        paramList.remove(0);
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogic.a(this.jdField_a_of_type_JavaUtilArrayList, paramBoolean);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    new Rect();
    paramView = (LocalMediaInfo)paramURLDrawable.getTag();
    int i = paramView.listViewPosition;
    if (i != -1)
    {
      if (paramView.visableTime == 0L) {
        return;
      }
      long l1 = SystemClock.uptimeMillis();
      long l2 = paramView.visableTime;
      if (QLog.isColorLevel())
      {
        paramURLDrawable = new StringBuilder();
        paramURLDrawable.append("onLoadSuccessed,no next ,listViewPositon:");
        paramURLDrawable.append(i);
        paramURLDrawable.append(" costTime:");
        paramURLDrawable.append(l1 - l2);
        paramURLDrawable.append(" imageInfo;");
        paramURLDrawable.append(paramView);
        QLog.d("PhotoListActivity", 2, paramURLDrawable.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter
 * JD-Core Version:    0.7.0.1
 */