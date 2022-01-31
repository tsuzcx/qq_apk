package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.LebaUtil.LebaItemComparator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ynu;

public class LebaListMgrAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Drawable a;
  protected LayoutInflater a;
  private LebaListMgrAdapter.LebaItemFilter jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaItemFilter;
  private LebaListMgrAdapter.LebaPluginStateListener jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaPluginStateListener;
  protected QQAppInterface a;
  protected HashMap a;
  protected List a;
  private Drawable b;
  
  public LebaListMgrAdapter(QQAppInterface paramQQAppInterface, Context paramContext, List paramList, LebaListMgrAdapter.LebaItemFilter paramLebaItemFilter, LebaListMgrAdapter.LebaPluginStateListener paramLebaPluginStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842699);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaItemFilter = paramLebaItemFilter;
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaPluginStateListener = paramLebaPluginStateListener;
    a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = paramContext.getResources().getDrawable(2130842699);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaItemFilter == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_a_of_type_Int = 0;
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof LebaViewItem))
        {
          localObject = (LebaViewItem)localObject;
          if ((this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaItemFilter.a((LebaViewItem)localObject)) && (((LebaViewItem)localObject).jdField_a_of_type_Boolean)) {
            localArrayList.add(localObject);
          } else {
            this.jdField_a_of_type_Int += 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList, new LebaUtil.LebaItemComparator());
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    a(localArrayList);
  }
  
  private void a(RedTouch paramRedTouch, LebaViewItem paramLebaViewItem, boolean paramBoolean)
  {
    byte b1 = 0;
    if (paramLebaViewItem.jdField_a_of_type_Byte == 0) {}
    for (boolean bool = true; paramBoolean == bool; bool = false) {
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      paramLebaViewItem.jdField_a_of_type_Byte = b1;
      long l = NetConnInfoCenter.getServerTimeMillis();
      LebaGridShowManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      ((RedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), paramBoolean, l);
      if (paramBoolean)
      {
        RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
        l = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
        localRedTouchManager.b("100600." + (100000000L + l) + "");
        if (paramRedTouch != null) {
          paramRedTouch.b();
        }
      }
      a();
      notifyDataSetChanged();
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaPluginStateListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaPluginStateListener.a(paramLebaViewItem);
      return;
      b1 = 1;
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramString = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramString);
    paramRedTouch.a(paramString);
    a(paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramAppInfo);
  }
  
  private void a(ArrayList paramArrayList)
  {
    int i = 1;
    if (paramArrayList.size() > 0) {}
    switch (paramArrayList.size())
    {
    default: 
      ((LebaViewItem)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
      while (i < paramArrayList.size() - 1)
      {
        ((LebaViewItem)paramArrayList.get(i)).jdField_a_of_type_Int = 3;
        i += 1;
      }
    case 1: 
      ((LebaViewItem)paramArrayList.get(0)).jdField_a_of_type_Int = 0;
      return;
    }
    ((LebaViewItem)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
    ((LebaViewItem)paramArrayList.get(1)).jdField_a_of_type_Int = 2;
    return;
    ((LebaViewItem)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    a();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LebaViewItem localLebaViewItem = (LebaViewItem)getItem(paramInt);
    if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
      return paramView;
    }
    RedTouch localRedTouch;
    if (paramView == null)
    {
      paramView = new LebaListMgrAdapter.ViewHolder();
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968942, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131364355));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364359));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364356));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131363823);
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131364358));
      localRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramViewGroup).c(100).a();
      localRedTouch.setTag(paramView);
      paramViewGroup = paramView;
      paramView = localRedTouch;
      switch (localLebaViewItem.jdField_a_of_type_Int)
      {
      default: 
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838629);
        label198:
        localRedTouch = (RedTouch)paramView;
        if (localLebaViewItem.jdField_a_of_type_Byte == 0)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          label229:
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
          if ((localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL))) {
            break label507;
          }
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.b;
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.b;
          localObject = URLDrawable.getDrawable(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL, (URLDrawable.URLDrawableOptions)localObject);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        break;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ynu(this, localRedTouch, localLebaViewItem));
      if (localLebaViewItem.jdField_a_of_type_Byte != 1) {
        break label521;
      }
      long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
      a((RedTouch)paramView, "100600." + (100000000L + l) + "");
      return paramView;
      paramViewGroup = (LebaListMgrAdapter.ViewHolder)paramView.getTag();
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838629);
      break label198;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838641);
      break label198;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838636);
      break label198;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838639);
      break label198;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label229;
      label507:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.b);
    }
    label521:
    ((RedTouch)paramView).b();
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.LebaListMgrAdapter
 * JD-Core Version:    0.7.0.1
 */