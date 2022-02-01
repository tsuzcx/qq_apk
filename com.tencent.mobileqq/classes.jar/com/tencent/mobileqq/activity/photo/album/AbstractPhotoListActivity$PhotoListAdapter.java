package com.tencent.mobileqq.activity.photo.album;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AbstractPhotoListActivity$PhotoListAdapter
  extends RecyclerView.Adapter<AbstractPhotoListActivity.Holder>
  implements URLDrawableDownListener
{
  static final String REPORT_OLD_TAG = "AlbumThumbCostOld";
  static final String REPORT_TAG = "AlbumThumbCost";
  ColorDrawable colorDrawable = new ColorDrawable(570425344);
  public ArrayList<LocalMediaInfo> mAllImages = new ArrayList();
  Drawable mDefaultPhotoDrawable;
  public LayoutInflater mInflater;
  Resources mResources;
  
  public AbstractPhotoListActivity$PhotoListAdapter(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    this.mInflater = paramAbstractPhotoListActivity.getLayoutInflater();
    this.mResources = paramAbstractPhotoListActivity.getResources();
    this.mDefaultPhotoDrawable = this.mResources.getDrawable(2130847846);
  }
  
  public void addPhotoList(List<LocalMediaInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    int i = this.mAllImages.size();
    this.mAllImages.addAll(paramList);
    notifyItemRangeInserted(i, paramList.size());
  }
  
  public LocalMediaInfo getItem(int paramInt)
  {
    return (LocalMediaInfo)this.mAllImages.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.mAllImages.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.mAllImages.get(paramInt));
  }
  
  public List<LocalMediaInfo> getPhotoList()
  {
    return this.mAllImages;
  }
  
  public int getViewTypeCount()
  {
    return QAlbumUtil.MEDIA_TYPE_MAPS.size();
  }
  
  public TextView newImageTypeView()
  {
    TextView localTextView = new TextView(this.this$0);
    localTextView.setGravity(17);
    localTextView.setTextSize(10.0F);
    localTextView.setTextColor(-1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setSize(QAlbumCommonUtil.dp2px(30.0F, this.this$0.getResources()), QAlbumCommonUtil.dp2px(18.0F, this.this$0.getResources()));
    localGradientDrawable.setCornerRadii(new float[] { QAlbumCommonUtil.dp2px(2.0F, this.this$0.getResources()), QAlbumCommonUtil.dp2px(2.0F, this.this$0.getResources()), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setColor(1291845632);
    localTextView.setBackgroundDrawable(localGradientDrawable);
    return localTextView;
  }
  
  public void onBindViewHolder(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt)
  {
    paramHolder.mOnItemClickListener.position = paramInt;
    switch (getItemViewType(paramInt))
    {
    default: 
      this.this$0.mPhotoListLogic.getViewCaseImage(paramHolder, paramInt);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramHolder, paramInt, getItemId(paramInt));
      return;
      this.this$0.mPhotoListLogic.getViewCaseVideo(paramHolder, paramInt);
      continue;
      this.this$0.mPhotoListLogic.getViewCaseCamera(paramHolder, paramInt);
    }
  }
  
  @NonNull
  public AbstractPhotoListActivity.Holder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    AbstractPhotoListActivity.CheckBoxClickedListener localCheckBoxClickedListener = new AbstractPhotoListActivity.CheckBoxClickedListener(this.this$0);
    View localView;
    switch (paramInt)
    {
    default: 
      localView = this.this$0.photoListAdapter.mInflater.inflate(2131561342, null);
      paramViewGroup = new AbstractPhotoListActivity.Holder(localView);
      localView.setLayoutParams(new AbsListView.LayoutParams(this.this$0.mImageWidth, this.this$0.mImageHeight));
      paramViewGroup.mImageView = ((ImageView)localView.findViewById(2131372742));
      paramViewGroup.mImageViewPanoramaIcon = ((ImageView)localView.findViewById(2131372703));
      paramViewGroup.mMaskView = ((ImageView)localView.findViewById(2131369123));
      paramViewGroup.mSelectedIconView = ((ImageView)localView.findViewById(2131372747));
      paramViewGroup.mSelectedBtn = localView.findViewById(2131372744);
      paramViewGroup.mCheckBox = ((NumberCheckBox)localView.findViewById(2131372745));
      paramViewGroup.mPhotoFlagView = ((ImageView)localView.findViewById(2131372673));
      paramViewGroup.mPhotoFlagView.setVisibility(8);
      if (this.this$0.mPhotoListLogic.mPhotoCommonData.maxSelectNum > 100) {
        paramViewGroup.mCheckBox.setTextSize(10.0F);
      }
      paramViewGroup.checkBoxListener = localCheckBoxClickedListener;
      if (paramViewGroup.mSelectedBtn != null) {
        paramViewGroup.mSelectedBtn.setOnClickListener(paramViewGroup.checkBoxListener);
      }
      localView.setTag(paramViewGroup);
      if (!this.this$0.mPhotoListData.isSingleMode) {
        paramViewGroup.mSelectedBtn.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      paramViewGroup.mOnItemClickListener = new AbstractPhotoListActivity.OnItemClickListener(this.this$0);
      if (paramViewGroup.mImageView != null)
      {
        paramViewGroup.mImageView.setOnClickListener(paramViewGroup.mOnItemClickListener);
        return paramViewGroup;
        localView = this.this$0.photoListAdapter.mInflater.inflate(2131561615, null);
        paramViewGroup = new AbstractPhotoListActivity.Holder(localView);
        localView.setLayoutParams(new AbsListView.LayoutParams(this.this$0.mImageWidth, this.this$0.mImageHeight));
        paramViewGroup.mImageView = ((ImageView)localView.findViewById(2131372742));
        paramViewGroup.mTextView = ((TextView)localView.findViewById(2131372748));
        paramViewGroup.mMaskView = ((ImageView)localView.findViewById(2131369123));
        paramViewGroup.mSelectedIconView = ((ImageView)localView.findViewById(2131372747));
        paramViewGroup.mSelectedBtn = localView.findViewById(2131372744);
        paramViewGroup.mCheckBox = ((NumberCheckBox)localView.findViewById(2131372745));
        if (this.this$0.mPhotoListLogic.mPhotoCommonData.maxSelectNum > 100) {
          paramViewGroup.mCheckBox.setTextSize(10.0F);
        }
        paramViewGroup.checkBoxListener = localCheckBoxClickedListener;
        if (paramViewGroup.mSelectedBtn != null) {
          paramViewGroup.mSelectedBtn.setOnClickListener(paramViewGroup.checkBoxListener);
        }
        localView.setTag(paramViewGroup);
        if ((!this.this$0.mPhotoListData.isSingleMode) && (this.this$0.mPhotoListData.isSupportVideoCheckbox))
        {
          paramViewGroup.mSelectedBtn.setVisibility(0);
          continue;
          paramViewGroup = this.this$0.photoListAdapter.mInflater.inflate(2131561053, null);
          paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(this.this$0.mImageWidth, this.this$0.mImageHeight));
          paramViewGroup = new AbstractPhotoListActivity.Holder(paramViewGroup);
        }
      }
      else
      {
        paramViewGroup.itemView.setOnClickListener(paramViewGroup.mOnItemClickListener);
        return paramViewGroup;
      }
    }
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
    if ((i == -1) || (paramView.visableTime == 0L)) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = SystemClock.uptimeMillis();
      l2 = paramView.visableTime;
    } while (!QLog.isColorLevel());
    QLog.d("PhotoListActivity", 2, "onLoadSuccessed,no next ,listViewPositon:" + i + " costTime:" + (l1 - l2) + " imageInfo;" + paramView);
  }
  
  public void setPhotoList(List<LocalMediaInfo> paramList)
  {
    this.mAllImages.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if ((!this.this$0.mPhotoListData.isShowCamera) && (QAlbumUtil.getMediaType((LocalMediaInfo)paramList.get(0)) == 2)) {
      paramList.remove(0);
    }
    this.mAllImages.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter
 * JD-Core Version:    0.7.0.1
 */