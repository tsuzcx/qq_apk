package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModel;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import lkl;
import tencent.im.oidb.gallery.gallery.PictureInfo;

public class ReadInJoyAtlasAdapter
  extends BaseAdapter
{
  public static final String a;
  private Context jdField_a_of_type_AndroidContentContext;
  private AtlasModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel;
  private List jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas.." + ReadInJoyAtlasAdapter.class.getSimpleName();
  }
  
  public ReadInJoyAtlasAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public AtlasModel a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel;
  }
  
  public AtlasModelImage a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (AtlasModelImage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, ReadInJoyAtlasAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {}
    URLImageView localURLImageView;
    AtlasModelImage localAtlasModelImage;
    do
    {
      do
      {
        return;
        localURLImageView = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
        paramViewHolder = paramViewHolder.jdField_a_of_type_AndroidWidgetImageView;
        localAtlasModelImage = a(paramInt);
      } while (!(localAtlasModelImage instanceof AtlasModelImage));
      localAtlasModelImage = (AtlasModelImage)localAtlasModelImage;
      localObject = localAtlasModelImage.pictureInfo.bytes_pic_url.get().toStringUtf8();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadThumbImage() path = " + (String)localObject);
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846329);
    localURLDrawableOptions.mPlayGifImage = true;
    Object localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
    if (((URLDrawable)localObject).getStatus() == 1) {
      localAtlasModelImage.modelImageShowTime = localAtlasModelImage.modelEnterTime;
    }
    localURLImageView.setImageDrawable((Drawable)localObject);
    a(paramViewHolder);
    localURLImageView.setURLDrawableDownListener(new lkl(this, paramViewHolder, localAtlasModelImage, localURLImageView));
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
      } while (paramView.getVisibility() == 4);
      paramView.setVisibility(4);
    } while (!(paramView.getTag() instanceof Animatable));
    ((Animatable)paramView.getTag()).stop();
  }
  
  public void a(AtlasModel paramAtlasModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel = paramAtlasModel;
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel = null;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AtlasModelImage localAtlasModelImage = (AtlasModelImage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localAtlasModelImage.position = paramInt;
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130971482, null);
      paramView = new ReadInJoyAtlasAdapter.ViewHolder(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131361846));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361845));
      paramViewGroup = paramViewGroup.getContext().getResources().getDrawable(2130840397);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel = localAtlasModelImage;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel.equals(localAtlasModelImage)))
      {
        localAtlasModelImage.modelEnterTime = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel.modelExitTime = localAtlasModelImage.modelEnterTime;
        }
      }
      a(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView);
      a(paramInt, paramViewGroup);
      return localView;
      paramViewGroup = (ReadInJoyAtlasAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasAdapter
 * JD-Core Version:    0.7.0.1
 */