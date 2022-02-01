package com.tencent.biz.qqstory.takevideo.poilist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;

public class QQStoryPoiListAdapter
  extends XBaseAdapter
{
  public static final TroopBarPOI a;
  protected LayoutInflater a;
  protected ArrayList<TroopBarPOI> a;
  protected TroopBarPOI b = null;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = new TroopBarPOI("-1", "", HardCodeUtil.a(2131710962), 0, "", 0, "");
  }
  
  public QQStoryPoiListAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public void a(ArrayList<TroopBarPOI> paramArrayList, TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (paramTroopBarPOI != null) {
      this.b = new TroopBarPOI(paramTroopBarPOI);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
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
    Object localObject;
    TroopBarPOI localTroopBarPOI;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561899, null);
      localObject = new QQStoryPoiListAdapter.ViewHolder();
      ((QQStoryPoiListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377751));
      ((QQStoryPoiListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370230));
      paramView.setTag(localObject);
      localTroopBarPOI = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      ((QQStoryPoiListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localTroopBarPOI.c);
      localObject = ((QQStoryPoiListAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView;
      if (!localTroopBarPOI.equals(this.b)) {
        break label160;
      }
    }
    label160:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      paramView.setContentDescription(localTroopBarPOI.c);
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (QQStoryPoiListAdapter.ViewHolder)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.poilist.QQStoryPoiListAdapter
 * JD-Core Version:    0.7.0.1
 */