package com.tencent.biz.qqcircle.publish.preview.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.qqcircle.publish.bean.QCirclePicPreviewBean;
import com.tencent.biz.qqcircle.publish.view.QCirclePicPreviewImage;
import java.util.ArrayList;
import java.util.LinkedList;

public class QCirclePicPreviewPagerAdapter
  extends PagerAdapter
{
  private ArrayList<QCirclePicPreviewBean> a = new ArrayList();
  private LinkedList<View> b = new LinkedList();
  
  public void a(ArrayList<QCirclePicPreviewBean> paramArrayList)
  {
    this.a.clear();
    notifyDataSetChanged();
    if (paramArrayList != null)
    {
      this.a.addAll(paramArrayList);
      notifyDataSetChanged();
    }
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    this.b.add(paramObject);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (getCount() == 0) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    QCirclePicPreviewBean localQCirclePicPreviewBean = (QCirclePicPreviewBean)this.a.get(paramInt);
    Object localObject;
    if (this.b.size() > 0)
    {
      localObject = (View)this.b.removeFirst();
    }
    else
    {
      localObject = new QCirclePicPreviewImage(paramViewGroup.getContext());
      ((View)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    }
    paramViewGroup.addView((View)localObject);
    ((QCirclePicPreviewImage)localObject).setData(localQCirclePicPreviewBean, paramInt);
    return localObject;
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePicPreviewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */