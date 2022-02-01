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
  public ArrayList<LocalMediaInfo> a = new ArrayList();
  public Drawable b;
  public ColorDrawable c = new ColorDrawable(570425344);
  public LayoutInflater d;
  
  public AEAbstractPhotoListFragment$PhotoGridAdapter(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment)
  {
    this.d = paramAEAbstractPhotoListFragment.getActivity().getLayoutInflater();
  }
  
  public TextView a()
  {
    TextView localTextView = new TextView(this.e.getActivity());
    localTextView.setGravity(17);
    localTextView.setTextSize(10.0F);
    localTextView.setTextColor(-1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setSize(QAlbumCommonUtil.dp2px(30.0F, this.e.getResources()), QAlbumCommonUtil.dp2px(18.0F, this.e.getResources()));
    localGradientDrawable.setCornerRadii(new float[] { QAlbumCommonUtil.dp2px(2.0F, this.e.getResources()), QAlbumCommonUtil.dp2px(2.0F, this.e.getResources()), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
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
        if ((paramInt == 2) && (this.e.a.i != null))
        {
          paramViewGroup = this.e;
          return new AEAbstractPhotoListFragment.PhotoVH(paramViewGroup, paramViewGroup.a.i.k());
        }
      }
      else if (this.e.a.i != null)
      {
        paramViewGroup = this.e;
        return new AEAbstractPhotoListFragment.PhotoVH(paramViewGroup, paramViewGroup.a.i.j());
      }
    }
    else if (this.e.a.i != null)
    {
      paramViewGroup = this.e;
      return new AEAbstractPhotoListFragment.PhotoVH(paramViewGroup, paramViewGroup.a.i.aj_());
    }
    return null;
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    return (LocalMediaInfo)this.a.get(paramInt);
  }
  
  public void a(AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, int paramInt)
  {
    AEAbstractPhotoListFragment.PhotoItemClickListener localPhotoItemClickListener = new AEAbstractPhotoListFragment.PhotoItemClickListener(this.e);
    int i = getItemViewType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        if (this.e.a.i != null) {
          this.e.a.i.c(paramInt, paramPhotoVH, localPhotoItemClickListener);
        }
      }
      else if (this.e.a.i != null)
      {
        this.e.a.i.b(paramInt, paramPhotoVH, localPhotoItemClickListener);
      }
    }
    else if (this.e.a.i != null) {
      this.e.a.i.a(paramInt, paramPhotoVH, localPhotoItemClickListener);
    }
  }
  
  public void a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    this.a.clear();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if ((!this.e.b.O) && (QAlbumUtil.getMediaType((LocalMediaInfo)paramList.get(0)) == 2)) {
        paramList.remove(0);
      }
      this.a.addAll(paramList);
      this.e.a.a(this.a, paramBoolean);
    }
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.a.get(paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter
 * JD-Core Version:    0.7.0.1
 */