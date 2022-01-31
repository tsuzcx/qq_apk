package com.tencent.mobileqq.apollo.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.store.ApolloImageDownloader;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.List;

public class ApolloTabAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List jdField_a_of_type_JavaUtilList;
  private int b = -1;
  
  public ApolloTabAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_Int = paramContext.getResources().getColor(2131494041);
  }
  
  public Drawable a(ApolloActionPackage paramApolloActionPackage)
  {
    ApolloActionPackage localApolloActionPackage = null;
    StateListDrawable localStateListDrawable = new StateListDrawable();
    URLDrawable localURLDrawable2;
    if (!TextUtils.isEmpty(paramApolloActionPackage.mIconSelectedUrl))
    {
      localURLDrawable2 = ApolloImageDownloader.a("" + paramApolloActionPackage.mIconSelectedUrl.hashCode(), null, paramApolloActionPackage.mIconSelectedUrl, true);
      localURLDrawable1 = localURLDrawable2;
      if (localURLDrawable2 != null) {
        localURLDrawable2.startDownload();
      }
    }
    for (URLDrawable localURLDrawable1 = localURLDrawable2;; localURLDrawable1 = null)
    {
      if (!TextUtils.isEmpty(paramApolloActionPackage.mIconUnselectedUrl))
      {
        paramApolloActionPackage = ApolloImageDownloader.a("" + paramApolloActionPackage.mIconUnselectedUrl.hashCode(), null, paramApolloActionPackage.mIconUnselectedUrl, true);
        localApolloActionPackage = paramApolloActionPackage;
        if (paramApolloActionPackage != null)
        {
          paramApolloActionPackage.startDownload();
          localApolloActionPackage = paramApolloActionPackage;
        }
      }
      if (localURLDrawable1 != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, localURLDrawable1);
      }
      if (localApolloActionPackage != null) {
        localStateListDrawable.addState(new int[] { -16842913 }, localApolloActionPackage);
      }
      return localStateListDrawable;
    }
  }
  
  public ApolloActionPackage a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (ApolloActionPackage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @TargetApi(14)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968699, paramViewGroup, false);
      paramViewGroup = new ApolloTabAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131363270));
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setActivated(true);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setEnabled(true);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131362957);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363271));
      paramView.setTag(paramViewGroup);
      float f2 = getCount();
      if (f2 > 0.0F)
      {
        float f1 = f2;
        if (f2 > 4.0F) {
          f1 = 4.5F;
        }
        i = (int)((float)(DeviceInfoUtil.j() - AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) / f1);
        localObject = paramView.getLayoutParams();
        if (localObject != null) {
          ((ViewGroup.LayoutParams)localObject).width = i;
        }
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = paramViewGroup.jdField_a_of_type_AndroidViewView;
      if (paramInt == getCount() - 1) {
        break label287;
      }
    }
    label287:
    for (int i = 0;; i = 4)
    {
      ((View)localObject).setVisibility(i);
      localObject = a(paramInt);
      if (localObject != null)
      {
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(a((ApolloActionPackage)localObject));
        if ((((ApolloActionPackage)localObject).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject).redStartTime)) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      if (paramInt != this.b) {
        break label293;
      }
      paramView.setSelected(true);
      return paramView;
      paramViewGroup = (ApolloTabAdapter.ViewHolder)paramView.getTag();
      break;
    }
    label293:
    paramView.setSelected(false);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloTabAdapter
 * JD-Core Version:    0.7.0.1
 */