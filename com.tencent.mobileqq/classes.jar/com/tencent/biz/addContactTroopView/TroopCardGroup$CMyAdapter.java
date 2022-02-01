package com.tencent.biz.addContactTroopView;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadHolder.ViewHolder;
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
    if (this.a.e != null) {
      return this.a.e.size();
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
    searchtab.Item1 localItem1 = (searchtab.Item1)this.a.e.get(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = GroupViewAdapter.a(this.a.b, paramViewGroup, 5, true, 1);
    }
    GroupViewAdapter.a(localView, this.a.b, localItem1);
    paramView = (FacePreloadHolder.ViewHolder)localView.getTag();
    localView.setTag(-1, localItem1);
    if (!TextUtils.isEmpty(localItem1.str_img_url.get()))
    {
      paramView.A.setImageDrawable(URLDrawable.getDrawable(localItem1.str_img_url.get(), paramView.A.getWidth(), paramView.A.getHeight()));
    }
    else if (localItem1.uint64_group_code.get() > 0L)
    {
      paramView.y = String.valueOf(localItem1.uint64_group_code.get());
      paramView.A.setImageBitmap(a(4, String.valueOf(localItem1.uint64_group_code.get())));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardGroup.CMyAdapter
 * JD-Core Version:    0.7.0.1
 */