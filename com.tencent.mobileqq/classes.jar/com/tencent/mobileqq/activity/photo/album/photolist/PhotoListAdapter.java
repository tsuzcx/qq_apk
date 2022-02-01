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
  public LayoutInflater a;
  Resources b;
  Drawable c;
  public ArrayList<LocalMediaInfo> d = new ArrayList();
  ColorDrawable e = new ColorDrawable(570425344);
  PeakFragmentActivity f;
  PhotoListCustomization<? extends OtherCommonData> g;
  public int h;
  public int i;
  int j;
  
  public PhotoListAdapter(PhotoListCustomization<? extends OtherCommonData> paramPhotoListCustomization)
  {
    this.g = paramPhotoListCustomization;
    if (paramPhotoListCustomization != null)
    {
      this.f = paramPhotoListCustomization.d;
      this.a = this.f.getLayoutInflater();
      this.b = this.f.getResources();
    }
    this.c = this.b.getDrawable(2130849738);
    this.j = this.b.getDimensionPixelSize(2131298138);
    this.h = ((this.b.getDisplayMetrics().widthPixels - this.j * 2) / d().M);
    this.i = this.h;
  }
  
  private Holder a(PhotoListAdapter.CheckBoxClickedListener paramCheckBoxClickedListener)
  {
    View localView = this.a.inflate(2131627938, null);
    Holder localHolder = new Holder(localView);
    localView.setLayoutParams(new AbsListView.LayoutParams(this.h, this.i));
    localHolder.b = ((ImageView)localView.findViewById(2131440193));
    localHolder.h = ((TextView)localView.findViewById(2131440200));
    localHolder.c = ((ImageView)localView.findViewById(2131436068));
    localHolder.d = ((ImageView)localView.findViewById(2131440198));
    localHolder.i = localView.findViewById(2131440195);
    localHolder.f = ((NumberCheckBox)localView.findViewById(2131440196));
    if (c().maxSelectNum > 100) {
      localHolder.f.setTextSize(10.0F);
    }
    localHolder.k = paramCheckBoxClickedListener;
    if (localHolder.i != null) {
      localHolder.i.setOnClickListener(localHolder.k);
    }
    localView.setTag(localHolder);
    if ((!c().isSingleMode) && (d().B)) {
      localHolder.i.setVisibility(0);
    }
    return localHolder;
  }
  
  private Holder b(PhotoListAdapter.CheckBoxClickedListener paramCheckBoxClickedListener)
  {
    View localView = this.a.inflate(2131627647, null);
    Holder localHolder = new Holder(localView);
    localView.setLayoutParams(new AbsListView.LayoutParams(this.h, this.i));
    localHolder.b = ((ImageView)localView.findViewById(2131440193));
    localHolder.a = ((ImageView)localView.findViewById(2131440149));
    localHolder.c = ((ImageView)localView.findViewById(2131436068));
    localHolder.d = ((ImageView)localView.findViewById(2131440198));
    localHolder.i = localView.findViewById(2131440195);
    localHolder.f = ((NumberCheckBox)localView.findViewById(2131440196));
    localHolder.e = ((ImageView)localView.findViewById(2131440118));
    localHolder.e.setVisibility(8);
    if (c().maxSelectNum > 100) {
      localHolder.f.setTextSize(10.0F);
    }
    localHolder.k = paramCheckBoxClickedListener;
    if (localHolder.i != null) {
      localHolder.i.setOnClickListener(localHolder.k);
    }
    localView.setTag(localHolder);
    if (!c().isSingleMode) {
      localHolder.i.setVisibility(0);
    }
    return localHolder;
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    return (LocalMediaInfo)this.d.get(paramInt);
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
        paramViewGroup = this.a.inflate(2131627345, null);
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(this.h, this.i));
        paramViewGroup = new Holder(paramViewGroup);
      }
    }
    else {
      paramViewGroup = a(paramViewGroup);
    }
    paramViewGroup.l = new PhotoListAdapter.OnItemClickListener(this);
    if (paramViewGroup.b != null)
    {
      paramViewGroup.b.setOnClickListener(paramViewGroup.l);
      return paramViewGroup;
    }
    paramViewGroup.itemView.setOnClickListener(paramViewGroup.l);
    return paramViewGroup;
  }
  
  public List<LocalMediaInfo> a()
  {
    return this.d;
  }
  
  public void a(@NonNull Holder paramHolder, int paramInt)
  {
    paramHolder.l.a = paramHolder.getAdapterPosition();
    int k = getItemViewType(paramInt);
    if (k != 1)
    {
      if (k != 2) {
        this.g.b(paramHolder, paramInt);
      } else {
        this.g.a(paramHolder, paramInt);
      }
    }
    else {
      this.g.c(paramHolder, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.d.clear();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if ((!d().O) && (QAlbumUtil.getMediaType((LocalMediaInfo)paramList.get(0)) == 2)) {
        paramList.remove(0);
      }
      this.d.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public TextView b()
  {
    TextView localTextView = new TextView(this.f);
    localTextView.setGravity(17);
    localTextView.setTextSize(10.0F);
    localTextView.setTextColor(-1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setSize(QAlbumCommonUtil.dp2px(30.0F, this.b), QAlbumCommonUtil.dp2px(18.0F, this.b));
    localGradientDrawable.setCornerRadii(new float[] { QAlbumCommonUtil.dp2px(2.0F, this.b), QAlbumCommonUtil.dp2px(2.0F, this.b), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setColor(1291845632);
    localTextView.setBackgroundDrawable(localGradientDrawable);
    return localTextView;
  }
  
  PhotoCommonBaseData c()
  {
    PhotoListCustomization localPhotoListCustomization = this.g;
    if (localPhotoListCustomization != null) {
      return localPhotoListCustomization.e;
    }
    return null;
  }
  
  PhotoListBaseData d()
  {
    PhotoListCustomization localPhotoListCustomization = this.g;
    if (localPhotoListCustomization != null) {
      return localPhotoListCustomization.g;
    }
    return null;
  }
  
  public int getItemCount()
  {
    return this.d.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.d.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter
 * JD-Core Version:    0.7.0.1
 */