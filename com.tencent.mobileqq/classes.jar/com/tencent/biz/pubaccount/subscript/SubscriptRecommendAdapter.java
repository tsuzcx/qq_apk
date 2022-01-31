package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import java.util.ArrayList;
import java.util.List;

public class SubscriptRecommendAdapter
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public Activity a;
  private SubscriptPicManager jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager;
  public QQAppInterface a;
  public FaceDecoder a;
  protected List a;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public SubscriptRecommendAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, SubscriptPicManager paramSubscriptPicManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(11);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
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
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() >= 10) {}
      for (int i = 10;; i = paramList.size())
      {
        int j = 0;
        while (j < i)
        {
          a((SubscriptRecommendAccountInfo)paramList.get(j));
          j += 1;
        }
      }
      paramList = new SubscriptRecommendAccountInfo();
      paramList.a = -1L;
      a(paramList);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
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
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt > getCount()) || (paramInt < 0)) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2130969686, null);
      paramView = new SubscriptRecommendAdapter.RecommendItem(this, localView, this.jdField_a_of_type_Boolean);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a((SubscriptRecommendAccountInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
      return localView;
      paramViewGroup = (SubscriptRecommendAdapter.RecommendItem)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter
 * JD-Core Version:    0.7.0.1
 */