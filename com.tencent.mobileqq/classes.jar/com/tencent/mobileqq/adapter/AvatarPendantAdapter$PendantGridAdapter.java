package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantShopItemInfo;
import com.tencent.mobileqq.vas.AvatarPendantShopSeriesInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AvatarPendantAdapter$PendantGridAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  List<AvatarPendantShopItemInfo> jdField_a_of_type_JavaUtilList;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  
  public AvatarPendantAdapter$PendantGridAdapter(AvatarPendantAdapter paramAvatarPendantAdapter) {}
  
  public void a(AvatarPendantShopSeriesInfo paramAvatarPendantShopSeriesInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramAvatarPendantShopSeriesInfo.d;
    this.jdField_a_of_type_Int = paramAvatarPendantShopSeriesInfo.jdField_c_of_type_Int;
    this.jdField_b_of_type_Int = paramAvatarPendantShopSeriesInfo.jdField_b_of_type_Int;
    this.jdField_b_of_type_JavaLangString = paramAvatarPendantShopSeriesInfo.jdField_c_of_type_JavaLangString;
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = "";
    }
    if ((paramAvatarPendantShopSeriesInfo.e != null) && (paramAvatarPendantShopSeriesInfo.e.equals("actLiTpl"))) {
      this.jdField_b_of_type_Int = 3;
    }
    if ((!paramAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean) && (paramAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.size() > 4) && ((paramAvatarPendantShopSeriesInfo.e == null) || (paramAvatarPendantShopSeriesInfo.e.equals("")))) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.subList(0, 4));
    } else {
      this.jdField_a_of_type_JavaUtilList.addAll(paramAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    label1290:
    Object localObject4;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      localObject2 = paramView;
    }
    else
    {
      AvatarPendantAdapter.PendantGridAdapter.GridItemHolder localGridItemHolder;
      Object localObject1;
      if (paramView == null)
      {
        localGridItemHolder = new AvatarPendantAdapter.PendantGridAdapter.GridItemHolder(this);
        localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidContentContext).inflate(2131561872, paramViewGroup, false);
        localGridItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131372418));
        localGridItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131372417));
        localGridItemHolder.b = ((ImageView)((View)localObject1).findViewById(2131372428));
        localGridItemHolder.c = ((ImageView)((View)localObject1).findViewById(2131372430));
        localGridItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131372426));
        localGridItemHolder.d = ((ImageView)((View)localObject1).findViewById(2131372419));
        localGridItemHolder.e = ((ImageView)((View)localObject1).findViewById(2131372429));
        paramView = localGridItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        if (paramView != null)
        {
          paramView.width = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.h;
          paramView.height = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.i;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantAdapter", 2, "getLayoutParams null, it's sad");
          }
          paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.h, this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.i);
        }
        localGridItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
        ((View)localObject1).setTag(localGridItemHolder);
        paramView = (View)localObject1;
      }
      else
      {
        localGridItemHolder = (AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)paramView.getTag();
      }
      AvatarPendantShopItemInfo localAvatarPendantShopItemInfo = (AvatarPendantShopItemInfo)getItem(paramInt);
      if (localAvatarPendantShopItemInfo != null)
      {
        localGridItemHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(localAvatarPendantShopItemInfo);
        localGridItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localAvatarPendantShopItemInfo.jdField_a_of_type_JavaLangString);
        paramView.setContentDescription(localAvatarPendantShopItemInfo.jdField_a_of_type_JavaLangString);
        int i = localAvatarPendantShopItemInfo.e;
        if (i != 7)
        {
          if (i != 8)
          {
            localGridItemHolder.d.setVisibility(8);
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(AvatarPendantUtil.jdField_c_of_type_JavaLangString);
            ((StringBuilder)localObject1).append("/hot.png");
            localFile = new File(((StringBuilder)localObject1).toString());
            if ((localFile.exists()) && (!this.jdField_b_of_type_JavaLangString.equals("3")))
            {
              localGridItemHolder.d.setVisibility(0);
              localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_hot.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_hot.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              localGridItemHolder.d.setImageDrawable((Drawable)localObject1);
            }
            else
            {
              localGridItemHolder.d.setVisibility(8);
            }
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(AvatarPendantUtil.jdField_c_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("/new.png");
          localFile = new File(((StringBuilder)localObject1).toString());
          if ((localFile.exists()) && (!this.jdField_b_of_type_JavaLangString.equals("1")))
          {
            localGridItemHolder.d.setVisibility(0);
            localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_new.png");
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
              localObject1 = localObject2;
              if (((URLDrawable)localObject2).getStatus() == 1)
              {
                AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_new.png", localObject2);
                localObject1 = localObject2;
              }
            }
            localGridItemHolder.d.setImageDrawable((Drawable)localObject1);
          }
          else
          {
            localGridItemHolder.d.setVisibility(8);
          }
        }
        i = localAvatarPendantShopItemInfo.f;
        if (i != 6)
        {
          if (i != 9)
          {
            if (i != 10)
            {
              localGridItemHolder.e.setVisibility(8);
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(AvatarPendantUtil.jdField_c_of_type_JavaLangString);
              ((StringBuilder)localObject1).append("/limit.png");
              localFile = new File(((StringBuilder)localObject1).toString());
              if (localFile.exists())
              {
                localGridItemHolder.e.setVisibility(0);
                localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_limit.png");
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                  ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                  localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                  localObject1 = localObject2;
                  if (((URLDrawable)localObject2).getStatus() == 1)
                  {
                    AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_limit.png", localObject2);
                    localObject1 = localObject2;
                  }
                }
                localGridItemHolder.e.setImageDrawable((Drawable)localObject1);
              }
              else
              {
                localGridItemHolder.e.setVisibility(8);
              }
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(AvatarPendantUtil.jdField_c_of_type_JavaLangString);
            ((StringBuilder)localObject1).append("/rare.png");
            localFile = new File(((StringBuilder)localObject1).toString());
            if ((localFile.exists()) && (this.jdField_b_of_type_Int != 5))
            {
              localGridItemHolder.e.setVisibility(0);
              localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_rare.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_rare.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              localGridItemHolder.e.setImageDrawable((Drawable)localObject1);
            }
            else
            {
              localGridItemHolder.e.setVisibility(8);
            }
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(AvatarPendantUtil.jdField_c_of_type_JavaLangString);
          ((StringBuilder)localObject1).append("/activity.png");
          localFile = new File(((StringBuilder)localObject1).toString());
          if (localFile.exists())
          {
            i = this.jdField_b_of_type_Int;
            if ((i != 3) && (i != 5))
            {
              localGridItemHolder.e.setVisibility(0);
              localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_activity.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_activity.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              localGridItemHolder.e.setImageDrawable((Drawable)localObject1);
              break label1290;
            }
          }
          localGridItemHolder.e.setVisibility(8);
        }
        localObject2 = localAvatarPendantShopItemInfo.jdField_b_of_type_JavaLangString;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.jdField_a_of_type_JavaLangString;
        }
        File localFile = null;
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(localObject1);
          if (localObject2 != null)
          {
            localGridItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
          else
          {
            Object localObject3;
            try
            {
              localObject2 = new URL("protocol_pendant_image", "DEFAULT_HEAD", (String)localObject1);
            }
            catch (MalformedURLException localMalformedURLException1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AvatarPendantAdapter", 2, localMalformedURLException1.getMessage());
              }
              localObject3 = null;
            }
            if (localObject3 != null)
            {
              URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.l;
              localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.m;
              localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              localURLDrawableOptions.mUseMemoryCache = true;
              localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              localObject3 = URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions);
              localGridItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
              if (((URLDrawable)localObject3).getStatus() == 2) {
                ((URLDrawable)localObject3).restartDownload();
              } else if (((URLDrawable)localObject3).getStatus() == 1) {
                AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(localObject1, localObject3);
              }
            }
          }
        }
        localGridItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localAvatarPendantShopItemInfo);
        if (this.jdField_a_of_type_Int == paramInt) {
          paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847635));
        } else {
          paramView.setBackgroundDrawable(null);
        }
        if (localAvatarPendantShopItemInfo.jdField_a_of_type_Int != 0)
        {
          if (localAvatarPendantShopItemInfo.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_Long) {
            localGridItemHolder.c.setVisibility(0);
          } else {
            localGridItemHolder.c.setVisibility(8);
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_Boolean)
          {
            try
            {
              localObject1 = new URL("protocol_pendant_image", "AIO_STATIC", String.valueOf(localAvatarPendantShopItemInfo.jdField_a_of_type_Int));
            }
            catch (MalformedURLException localMalformedURLException2)
            {
              localObject1 = localFile;
              if (QLog.isColorLevel())
              {
                QLog.d("AvatarPendantAdapter", 2, localMalformedURLException2.getMessage());
                localObject1 = localFile;
              }
            }
            localObject4 = paramView;
            if (localObject1 != null)
            {
              localObject4 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.l;
              ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.m;
              ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject4);
              localGridItemHolder.b.setImageDrawable((Drawable)localObject1);
              localObject4 = paramView;
              if (((URLDrawable)localObject1).getStatus() == 2)
              {
                ((URLDrawable)localObject1).restartDownload();
                localObject4 = paramView;
              }
            }
          }
          else
          {
            localGridItemHolder.b.setImageDrawable(null);
            localObject4 = paramView;
          }
        }
        else
        {
          localGridItemHolder.b.setImageDrawable(null);
          localObject4 = paramView;
        }
      }
      else
      {
        localObject4 = paramView;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject4, paramViewGroup, getItemId(paramInt));
    return localObject4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AvatarPendantAdapter.PendantGridAdapter
 * JD-Core Version:    0.7.0.1
 */