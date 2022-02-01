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
    View localView;
    if (paramView == null)
    {
      paramView = new TroopCardXingquBuluo.ViewHolder();
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131559968, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368810));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379247));
      paramView.b = ((TextView)localView.findViewById(2131379201));
      paramView.c = ((TextView)localView.findViewById(2131379157));
      localView.setTag(paramView);
    }
    for (;;)
    {
      Object localObject = (searchtab.Item3)this.a.a.get(paramInt);
      int i = AIOUtils.a(30.0F, this.a.getResources());
      URLDrawable localURLDrawable = URLDrawable.getDrawable(((searchtab.Item3)localObject).str_img_url.get(), i, i);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
      if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
        localURLDrawable.restartDownload();
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((searchtab.Item3)localObject).str_name.get());
      paramView.b.setText(((searchtab.Item3)localObject).str_desc1.get());
      paramView.c.setText(((searchtab.Item3)localObject).str_desc2.get());
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (TroopCardXingquBuluo.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardXingquBuluo.3
 * JD-Core Version:    0.7.0.1
 */