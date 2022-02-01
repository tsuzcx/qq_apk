package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class TroopMessageSettingSingleAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public TroopMessageSettingSingleAdapter(Context paramContext, QQAppInterface paramQQAppInterface, List<Long> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMessageSettingAdapter", 2, "setItemBackground() childPos = " + paramInt1 + ", listSize = " + paramInt2);
    }
    if (paramInt2 <= 1)
    {
      paramView.setBackgroundResource(2130839575);
      return;
    }
    if (paramInt1 == 0)
    {
      paramView.setBackgroundResource(2130839591);
      return;
    }
    if (paramInt1 == paramInt2 - 1)
    {
      paramView.setBackgroundResource(2130839582);
      return;
    }
    paramView.setBackgroundResource(2130839585);
  }
  
  public void a(List<Long> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    String str = String.valueOf(this.jdField_a_of_type_JavaUtilList.get(paramInt));
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(str);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(String.valueOf(this.jdField_a_of_type_JavaUtilList.get(paramInt)));
    Object localObject;
    View localView;
    if (paramView != null)
    {
      localObject = (TroopMessageSettingSingleAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceDrawable(localTroopInfo.troopuin);
      if (localObject != null) {
        break label219;
      }
      localObject = ImageUtil.a();
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopInfo.getTroopDisplayName());
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      a(localView, paramInt, getCount());
      localView.setBackgroundResource(2130839575);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563014, null);
      paramView = new TroopMessageSettingSingleAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368076));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368123));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368091));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376968));
      localView.setTag(paramView);
      break;
      label219:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopMessageSettingSingleAdapter
 * JD-Core Version:    0.7.0.1
 */