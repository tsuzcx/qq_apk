package com.tencent.biz.addContactTroopView;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.ListView;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item1;

public class TroopCardGroup$CMyAdapter
  extends FacePreloadBaseAdapter
{
  public TroopCardGroup$CMyAdapter(TroopCardGroup paramTroopCardGroup, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    super(paramContext, paramQQAppInterface, paramListView, 1, true);
  }
  
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
    View localView = paramView;
    if (paramView == null) {
      localView = GroupViewAdapter.a(this.a.jdField_a_of_type_AndroidContentContext, paramViewGroup, 5, true, 1);
    }
    GroupViewAdapter.a(localView, this.a.jdField_a_of_type_AndroidContentContext, localItem1);
    paramView = (FacePreloadBaseAdapter.ViewHolder)localView.getTag();
    if (!TextUtils.isEmpty(localItem1.str_img_url.get())) {
      paramView.c.setImageDrawable(URLDrawable.getDrawable(localItem1.str_img_url.get(), paramView.c.getWidth(), paramView.c.getHeight()));
    }
    while (localItem1.uint64_group_code.get() <= 0L) {
      return localView;
    }
    paramView.a = String.valueOf(localItem1.uint64_group_code.get());
    paramView.c.setImageBitmap(a(4, String.valueOf(localItem1.uint64_group_code.get())));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardGroup.CMyAdapter
 * JD-Core Version:    0.7.0.1
 */