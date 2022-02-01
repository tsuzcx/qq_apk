package com.tencent.biz.addContactTroopView;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item1;

public class TroopCardGroup$CMyAdapter
  extends FacePreloadBaseAdapter
{
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      return this.a.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    searchtab.Item1 localItem1 = (searchtab.Item1)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null) {
      paramView = GroupViewAdapter.a(this.a.jdField_a_of_type_AndroidContentContext, paramViewGroup, 5, true, 1);
    }
    for (;;)
    {
      GroupViewAdapter.a(paramView, this.a.jdField_a_of_type_AndroidContentContext, localItem1);
      FacePreloadBaseAdapter.ViewHolder localViewHolder = (FacePreloadBaseAdapter.ViewHolder)paramView.getTag();
      paramView.setTag(-1, localItem1);
      if (!TextUtils.isEmpty(localItem1.str_img_url.get())) {
        localViewHolder.c.setImageDrawable(URLDrawable.getDrawable(localItem1.str_img_url.get(), localViewHolder.c.getWidth(), localViewHolder.c.getHeight()));
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        if (localItem1.uint64_group_code.get() > 0L)
        {
          localViewHolder.a = String.valueOf(localItem1.uint64_group_code.get());
          localViewHolder.c.setImageBitmap(a(4, String.valueOf(localItem1.uint64_group_code.get())));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardGroup.CMyAdapter
 * JD-Core Version:    0.7.0.1
 */