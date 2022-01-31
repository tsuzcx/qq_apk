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
  List jdField_a_of_type_JavaUtilList;
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
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_JavaUtilList.addAll(paramAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
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
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      localObject1 = paramView;
    }
    Object localObject2;
    label186:
    label208:
    AvatarPendantShopItemInfo localAvatarPendantShopItemInfo;
    do
    {
      return localObject1;
      if (paramView != null) {
        break label663;
      }
      localObject1 = new AvatarPendantAdapter.PendantGridAdapter.GridItemHolder(this);
      localObject2 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidContentContext).inflate(2130970952, paramViewGroup, false);
      ((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject2).findViewById(2131372277));
      ((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131372278));
      ((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)localObject1).b = ((ImageView)((View)localObject2).findViewById(2131372279));
      ((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)localObject1).c = ((ImageView)((View)localObject2).findViewById(2131372280));
      ((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131372283));
      ((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)localObject1).d = ((ImageView)((View)localObject2).findViewById(2131372281));
      ((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)localObject1).e = ((ImageView)((View)localObject2).findViewById(2131372282));
      paramView = ((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramView == null) {
        break;
      }
      paramView.width = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.f;
      paramView.height = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.g;
      ((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      ((View)localObject2).setTag(localObject1);
      paramViewGroup = (ViewGroup)localObject1;
      paramView = (View)localObject2;
      localAvatarPendantShopItemInfo = (AvatarPendantShopItemInfo)getItem(paramInt);
      localObject1 = paramView;
    } while (localAvatarPendantShopItemInfo == null);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(localAvatarPendantShopItemInfo);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localAvatarPendantShopItemInfo.jdField_a_of_type_JavaLangString);
    paramView.setContentDescription(localAvatarPendantShopItemInfo.jdField_a_of_type_JavaLangString);
    switch (localAvatarPendantShopItemInfo.e)
    {
    default: 
      paramViewGroup.d.setVisibility(8);
      label293:
      switch (localAvatarPendantShopItemInfo.f)
      {
      case 7: 
      case 8: 
      default: 
        paramViewGroup.e.setVisibility(8);
        label341:
        localObject1 = localAvatarPendantShopItemInfo.jdField_b_of_type_JavaLangString;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject1 = this.jdField_a_of_type_JavaLangString;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(localObject1);
          if (localObject2 == null) {
            break label1529;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
            ((URLDrawable)localObject2).restartDownload();
          }
        }
        label424:
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localAvatarPendantShopItemInfo);
        if (this.jdField_a_of_type_Int == paramInt)
        {
          paramView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844251));
          label460:
          if (localAvatarPendantShopItemInfo.jdField_a_of_type_Int == 0) {
            break label1749;
          }
          if (localAvatarPendantShopItemInfo.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_Long) {
            break label1701;
          }
          paramViewGroup.c.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_Boolean) {
            break label1739;
          }
        }
        try
        {
          for (;;)
          {
            localObject2 = new URL("protocol_pendant_image", "AIO_STATIC", String.valueOf(localAvatarPendantShopItemInfo.jdField_a_of_type_Int));
            localObject1 = paramView;
            if (localObject2 == null) {
              break;
            }
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.j;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.k;
            ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            localObject2 = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
            paramViewGroup.b.setImageDrawable((Drawable)localObject2);
            localObject1 = paramView;
            if (((URLDrawable)localObject2).getStatus() != 2) {
              break;
            }
            ((URLDrawable)localObject2).restartDownload();
            return paramView;
            if (QLog.isColorLevel()) {
              QLog.d("AvatarPendantAdapter", 2, "getLayoutParams null, it's sad");
            }
            paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.f, this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.g);
            break label186;
            label663:
            paramViewGroup = (AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)paramView.getTag();
            break label208;
            Object localObject4 = new File(AvatarPendantUtil.jdField_c_of_type_JavaLangString + "/new.png");
            if ((((File)localObject4).exists()) && (!this.jdField_b_of_type_JavaLangString.equals("1")))
            {
              paramViewGroup.d.setVisibility(0);
              localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_new.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable((File)localObject4, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_new.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              paramViewGroup.d.setImageDrawable((Drawable)localObject1);
              break label293;
            }
            paramViewGroup.d.setVisibility(8);
            break label293;
            localObject4 = new File(AvatarPendantUtil.jdField_c_of_type_JavaLangString + "/hot.png");
            if ((((File)localObject4).exists()) && (!this.jdField_b_of_type_JavaLangString.equals("3")))
            {
              paramViewGroup.d.setVisibility(0);
              localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_hot.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable((File)localObject4, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_hot.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              paramViewGroup.d.setImageDrawable((Drawable)localObject1);
              break label293;
            }
            paramViewGroup.d.setVisibility(8);
            break label293;
            localObject4 = new File(AvatarPendantUtil.jdField_c_of_type_JavaLangString + "/activity.png");
            if ((((File)localObject4).exists()) && (this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 5))
            {
              paramViewGroup.e.setVisibility(0);
              localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_activity.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable((File)localObject4, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_activity.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              paramViewGroup.e.setImageDrawable((Drawable)localObject1);
              break label341;
            }
            paramViewGroup.e.setVisibility(8);
            break label341;
            localObject4 = new File(AvatarPendantUtil.jdField_c_of_type_JavaLangString + "/limit.png");
            if (((File)localObject4).exists())
            {
              paramViewGroup.e.setVisibility(0);
              localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_limit.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable((File)localObject4, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_limit.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              paramViewGroup.e.setImageDrawable((Drawable)localObject1);
              break label341;
            }
            paramViewGroup.e.setVisibility(8);
            break label341;
            localObject4 = new File(AvatarPendantUtil.jdField_c_of_type_JavaLangString + "/rare.png");
            if ((((File)localObject4).exists()) && (this.jdField_b_of_type_Int != 5))
            {
              paramViewGroup.e.setVisibility(0);
              localObject2 = (URLDrawable)AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_rare.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable((File)localObject4, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_rare.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              paramViewGroup.e.setImageDrawable((Drawable)localObject1);
              break label341;
            }
            paramViewGroup.e.setVisibility(8);
            break label341;
            try
            {
              label1529:
              localObject2 = new URL("protocol_pendant_image", "DEFAULT_HEAD", (String)localObject1);
              if (localObject2 == null) {
                break label424;
              }
              localObject4 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.j;
              ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.k;
              ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              ((URLDrawable.URLDrawableOptions)localObject4).mUseMemoryCache = true;
              ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              localObject2 = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
              if (((URLDrawable)localObject2).getStatus() == 2) {
                ((URLDrawable)localObject2).restartDownload();
              }
            }
            catch (MalformedURLException localMalformedURLException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AvatarPendantAdapter", 2, localMalformedURLException2.getMessage());
                }
                localObject3 = null;
              }
            }
          }
          if (localObject3.getStatus() != 1) {
            break label424;
          }
          AvatarPendantAdapter.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(localObject1, localObject3);
          break label424;
          paramView.setBackgroundDrawable(null);
          break label460;
          label1701:
          paramViewGroup.c.setVisibility(8);
        }
        catch (MalformedURLException localMalformedURLException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AvatarPendantAdapter", 2, localMalformedURLException1.getMessage());
            }
            Object localObject3 = null;
          }
        }
      }
      label1739:
      paramViewGroup.b.setImageDrawable(null);
      return paramView;
      label1749:
      paramViewGroup.b.setImageDrawable(null);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AvatarPendantAdapter.PendantGridAdapter
 * JD-Core Version:    0.7.0.1
 */