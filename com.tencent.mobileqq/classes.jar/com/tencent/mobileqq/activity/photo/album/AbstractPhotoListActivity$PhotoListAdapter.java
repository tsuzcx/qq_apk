package com.tencent.mobileqq.activity.photo.album;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AbstractPhotoListActivity$PhotoListAdapter
  extends BaseAdapter
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
    this.mDefaultPhotoDrawable = this.mResources.getDrawable(2130847367);
  }
  
  public int getCount()
  {
    return this.mAllImages.size();
  }
  
  public LocalMediaInfo getItem(int paramInt)
  {
    return (LocalMediaInfo)this.mAllImages.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.mAllImages.get(paramInt));
  }
  
  public List<LocalMediaInfo> getPhotoList()
  {
    return this.mAllImages;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AbstractPhotoListActivity.CheckBoxClickedListener localCheckBoxClickedListener = new AbstractPhotoListActivity.CheckBoxClickedListener(this.this$0);
    AbstractPhotoListActivity.PhotoListAdapter.Holder localHolder;
    if (paramView == null)
    {
      localHolder = new AbstractPhotoListActivity.PhotoListAdapter.Holder(this);
      switch (getItemViewType(paramInt))
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return paramView;
          localHolder = (AbstractPhotoListActivity.PhotoListAdapter.Holder)paramView.getTag();
          break;
        } while (this.this$0.mPhotoListLogic == null);
        return this.this$0.mPhotoListLogic.getViewCaseImage(paramInt, paramView, paramViewGroup, localHolder, localCheckBoxClickedListener);
      } while (this.this$0.mPhotoListLogic == null);
      return this.this$0.mPhotoListLogic.getViewCaseVideo(paramInt, paramView, paramViewGroup, localHolder, localCheckBoxClickedListener);
    } while (this.this$0.mPhotoListLogic == null);
    return this.this$0.mPhotoListLogic.getViewCaseCamera(paramInt, paramView, paramViewGroup);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter
 * JD-Core Version:    0.7.0.1
 */