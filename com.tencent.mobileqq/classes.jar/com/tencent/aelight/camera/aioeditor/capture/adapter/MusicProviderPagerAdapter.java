package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.DoodleMusicCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.List;

public class MusicProviderPagerAdapter
  extends PagerAdapter
{
  public static final int a;
  public static final int b = AIOUtils.b(0.0F, BaseApplication.getContext().getResources());
  private Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  private SparseArray<GridView> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  MusicProviderView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicProviderView;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  private List<DoodleMusicCategoryItem> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_Int = AIOUtils.b(7.0F, BaseApplication.getContext().getResources());
  }
  
  public MusicProviderPagerAdapter(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicProviderView = paramMusicProviderView;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray.size();
  }
  
  public GridView a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt);
    return (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(List<DoodleMusicCategoryItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public GridView b(int paramInt)
  {
    return (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("instantiateItem position = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("MusicProviderView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = new GridView(this.jdField_a_of_type_AndroidContentContext);
      ((GridView)localObject1).setNumColumns(4);
      ((GridView)localObject1).setSelector(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((GridView)localObject1).setVerticalSpacing(b);
      ((GridView)localObject1).setHorizontalSpacing(b);
      ((GridView)localObject1).setVerticalScrollBarEnabled(false);
      int i = jdField_a_of_type_Int;
      ((GridView)localObject1).setPadding(i, i, i, i * 2 + AIOUtils.b(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GridView)localObject1).setClipToPadding(false);
      localObject2 = new MusicProviderGridAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicProviderView);
      ((GridView)localObject1).setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    else
    {
      localObject2 = (MusicProviderGridAdapter)((GridView)localObject1).getAdapter();
    }
    ((MusicProviderGridAdapter)localObject2).a(((DoodleMusicCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
    ((GridView)localObject1).setAdapter((ListAdapter)localObject2);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicProviderView.c == paramInt)
    {
      ((GridView)localObject1).setSelection(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicProviderView.d);
      localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicProviderView;
      ((MusicProviderView)localObject2).c = -1;
      ((MusicProviderView)localObject2).d = -1;
    }
    paramViewGroup.addView((View)localObject1, -1, -1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.MusicProviderPagerAdapter
 * JD-Core Version:    0.7.0.1
 */