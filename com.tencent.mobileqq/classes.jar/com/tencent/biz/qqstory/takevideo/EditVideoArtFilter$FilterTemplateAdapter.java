package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.artfilter.FilterTemplate;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class EditVideoArtFilter$FilterTemplateAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  List<FilterTemplate> jdField_a_of_type_JavaUtilList;
  int b;
  int c = -1;
  
  public EditVideoArtFilter$FilterTemplateAdapter(EditVideoArtFilter paramEditVideoArtFilter, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 130.0F);
    this.b = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 96.0F);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(20);
  }
  
  public FilterTemplate a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (FilterTemplate)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<FilterTemplate> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    FilterTemplate localFilterTemplate = new FilterTemplate();
    this.jdField_a_of_type_JavaUtilList.add(localFilterTemplate);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.c = 0;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EditVideoArtFilter.FilterTemplateAdapter.ViewHolder localViewHolder;
    View localView1;
    if (paramView == null)
    {
      localViewHolder = new EditVideoArtFilter.FilterTemplateAdapter.ViewHolder(this);
      localView1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559434, null);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131379312));
      localViewHolder.jdField_a_of_type_AndroidViewView = localView1.findViewById(2131377746);
      localView1.setTag(localViewHolder);
    }
    FilterTemplate localFilterTemplate;
    for (;;)
    {
      localFilterTemplate = a(paramInt);
      if (localFilterTemplate != null) {
        break;
      }
      EventCollector.getInstance().onListGetView(paramInt, localView1, paramViewGroup, getItemId(paramInt));
      return localView1;
      localViewHolder = (EditVideoArtFilter.FilterTemplateAdapter.ViewHolder)paramView.getTag();
      localView1 = paramView;
    }
    paramView = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localFilterTemplate.jdField_a_of_type_Int + localFilterTemplate.b);
    View localView2 = paramView;
    if (paramView == null)
    {
      if (paramInt != 0) {
        break label272;
      }
      paramView = BitmapManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_AndroidContentContext.getResources(), 2130841673, this.b, this.jdField_a_of_type_Int);
      label180:
      localView2 = paramView;
      if (paramView != null)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localFilterTemplate.jdField_a_of_type_Int + localFilterTemplate.b, paramView);
        localView2 = paramView;
      }
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localView2);
    if (paramInt == 0)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131703817));
      label252:
      if (paramInt != this.c) {
        break label329;
      }
      localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      break;
      label272:
      paramView = BitmapManager.a(localFilterTemplate.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      break label180;
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131703961) + localFilterTemplate.c);
      break label252;
      label329:
      localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoArtFilter.FilterTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */