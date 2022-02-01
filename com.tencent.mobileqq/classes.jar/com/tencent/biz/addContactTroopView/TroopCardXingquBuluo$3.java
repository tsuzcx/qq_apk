package com.tencent.biz.addContactTroopView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item3;

class TroopCardXingquBuluo$3
  extends BaseAdapter
{
  public int getCount()
  {
    if (this.a.a != null) {
      return this.a.a.size();
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
    TroopCardXingquBuluo.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new TroopCardXingquBuluo.ViewHolder();
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131559839, paramViewGroup, false);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368538));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378608));
      localViewHolder.b = ((TextView)paramView.findViewById(2131378564));
      localViewHolder.c = ((TextView)paramView.findViewById(2131378520));
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (TroopCardXingquBuluo.ViewHolder)paramView.getTag();
    }
    searchtab.Item3 localItem3 = (searchtab.Item3)this.a.a.get(paramInt);
    int i = AIOUtils.b(30.0F, this.a.getResources());
    URLDrawable localURLDrawable = URLDrawable.getDrawable(localItem3.str_img_url.get(), i, i);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
      localURLDrawable.restartDownload();
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localItem3.str_name.get());
    localViewHolder.b.setText(localItem3.str_desc1.get());
    localViewHolder.c.setText(localItem3.str_desc2.get());
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardXingquBuluo.3
 * JD-Core Version:    0.7.0.1
 */