package com.tencent.mobileqq.activity.photo.album.photolist;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCommonUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class PhotoListAdapter
  extends RecyclerView.Adapter<Holder>
{
  public int a;
  Resources jdField_a_of_type_AndroidContentResResources;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public LayoutInflater a;
  PeakFragmentActivity jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity;
  PhotoListCustomization<? extends OtherCommonData> jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization;
  public ArrayList<LocalMediaInfo> a;
  public int b;
  int c;
  
  public PhotoListAdapter(PhotoListCustomization<? extends OtherCommonData> paramPhotoListCustomization)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization = paramPhotoListCustomization;
    if (paramPhotoListCustomization != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity = paramPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity;
      this.jdField_a_of_type_AndroidViewLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getLayoutInflater();
      this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.getResources();
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130848074);
    this.c = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297487);
    this.jdField_a_of_type_Int = ((this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().widthPixels - this.c * 2) / a().g);
    this.b = this.jdField_a_of_type_Int;
  }
  
  private Holder a(PhotoListAdapter.CheckBoxClickedListener paramCheckBoxClickedListener)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561577, null);
    Holder localHolder = new Holder(localView);
    localView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.b));
    localHolder.b = ((ImageView)localView.findViewById(2131372648));
    localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372654));
    localHolder.c = ((ImageView)localView.findViewById(2131369102));
    localHolder.d = ((ImageView)localView.findViewById(2131372653));
    localHolder.jdField_a_of_type_AndroidViewView = localView.findViewById(2131372650);
    localHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)localView.findViewById(2131372651));
    if (a().maxSelectNum > 100) {
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
    }
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$CheckBoxClickedListener = paramCheckBoxClickedListener;
    if (localHolder.jdField_a_of_type_AndroidViewView != null) {
      localHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(localHolder.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$CheckBoxClickedListener);
    }
    localView.setTag(localHolder);
    if ((!a().isSingleMode) && (a().n)) {
      localHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    return localHolder;
  }
  
  private Holder b(PhotoListAdapter.CheckBoxClickedListener paramCheckBoxClickedListener)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561291, null);
    Holder localHolder = new Holder(localView);
    localView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.b));
    localHolder.b = ((ImageView)localView.findViewById(2131372648));
    localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131372609));
    localHolder.c = ((ImageView)localView.findViewById(2131369102));
    localHolder.d = ((ImageView)localView.findViewById(2131372653));
    localHolder.jdField_a_of_type_AndroidViewView = localView.findViewById(2131372650);
    localHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)localView.findViewById(2131372651));
    localHolder.e = ((ImageView)localView.findViewById(2131372580));
    localHolder.e.setVisibility(8);
    if (a().maxSelectNum > 100) {
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setTextSize(10.0F);
    }
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$CheckBoxClickedListener = paramCheckBoxClickedListener;
    if (localHolder.jdField_a_of_type_AndroidViewView != null) {
      localHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(localHolder.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$CheckBoxClickedListener);
    }
    localView.setTag(localHolder);
    if (!a().isSingleMode) {
      localHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    return localHolder;
  }
  
  public TextView a()
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity);
    localTextView.setGravity(17);
    localTextView.setTextSize(10.0F);
    localTextView.setTextColor(-1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setSize(QAlbumCommonUtil.dp2px(30.0F, this.jdField_a_of_type_AndroidContentResResources), QAlbumCommonUtil.dp2px(18.0F, this.jdField_a_of_type_AndroidContentResResources));
    localGradientDrawable.setCornerRadii(new float[] { QAlbumCommonUtil.dp2px(2.0F, this.jdField_a_of_type_AndroidContentResResources), QAlbumCommonUtil.dp2px(2.0F, this.jdField_a_of_type_AndroidContentResResources), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setColor(1291845632);
    localTextView.setBackgroundDrawable(localGradientDrawable);
    return localTextView;
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  PhotoCommonBaseData a()
  {
    PhotoListCustomization localPhotoListCustomization = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization;
    if (localPhotoListCustomization != null) {
      return localPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
    }
    return null;
  }
  
  @NonNull
  public Holder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new PhotoListAdapter.CheckBoxClickedListener(this);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        paramViewGroup = b(paramViewGroup);
      }
      else
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561004, null);
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.b));
        paramViewGroup = new Holder(paramViewGroup);
      }
    }
    else {
      paramViewGroup = a(paramViewGroup);
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$OnItemClickListener = new PhotoListAdapter.OnItemClickListener(this);
    if (paramViewGroup.b != null)
    {
      paramViewGroup.b.setOnClickListener(paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$OnItemClickListener);
      return paramViewGroup;
    }
    paramViewGroup.itemView.setOnClickListener(paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$OnItemClickListener);
    return paramViewGroup;
  }
  
  PhotoListBaseData a()
  {
    PhotoListCustomization localPhotoListCustomization = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization;
    if (localPhotoListCustomization != null) {
      return localPhotoListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
    }
    return null;
  }
  
  public List<LocalMediaInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(@NonNull Holder paramHolder, int paramInt)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter$OnItemClickListener.jdField_a_of_type_Int = paramHolder.getAdapterPosition();
    int i = getItemViewType(paramInt);
    if (i != 1)
    {
      if (i != 2) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.b(paramHolder, paramInt);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a(paramHolder, paramInt);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.c(paramHolder, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if ((!a().r) && (QAlbumUtil.getMediaType((LocalMediaInfo)paramList.get(0)) == 2)) {
        paramList.remove(0);
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      notifyDataSetChanged();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter
 * JD-Core Version:    0.7.0.1
 */