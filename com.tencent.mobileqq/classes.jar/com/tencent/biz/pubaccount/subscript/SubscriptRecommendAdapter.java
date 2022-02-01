package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class SubscriptRecommendAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  Activity jdField_a_of_type_AndroidAppActivity;
  private SubscriptPicManager jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  public IFaceDecoder a;
  protected List<SubscriptRecommendAccountInfo> a;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public SubscriptRecommendAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, SubscriptPicManager paramSubscriptPicManager)
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(11);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = paramSubscriptPicManager;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(paramQQAppInterface);
    if (Build.MANUFACTURER.toUpperCase().equals("XIAOMI")) {
      this.b = true;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(SubscriptRecommendAccountInfo paramSubscriptRecommendAccountInfo)
  {
    if (paramSubscriptRecommendAccountInfo != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramSubscriptRecommendAccountInfo);
    }
  }
  
  public void a(List<SubscriptRecommendAccountInfo> paramList)
  {
    if (paramList != null)
    {
      int j = paramList.size();
      int i = 10;
      if (j < 10) {
        i = paramList.size();
      }
      j = 0;
      while (j < i)
      {
        a((SubscriptRecommendAccountInfo)paramList.get(j));
        j += 1;
      }
      paramList = new SubscriptRecommendAccountInfo();
      paramList.a = -1L;
      a(paramList);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt <= getCount()) && (paramInt >= 0)) {
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
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131560403, null);
      paramView = new SubscriptRecommendAdapter.RecommendItem(this, localView, this.jdField_a_of_type_Boolean);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localView.setTag(paramView);
    }
    else
    {
      SubscriptRecommendAdapter.RecommendItem localRecommendItem = (SubscriptRecommendAdapter.RecommendItem)paramView.getTag();
      localView = paramView;
      paramView = localRecommendItem;
    }
    paramView.a((SubscriptRecommendAccountInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter
 * JD-Core Version:    0.7.0.1
 */