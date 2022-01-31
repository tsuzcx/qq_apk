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
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyAtlasPageLoader.Result;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModeLoadingMore;
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
import lmz;
import tencent.im.oidb.gallery.gallery.PictureInfo;

public class ReadInJoyAtlasAdapter
  extends BaseAdapter
{
  public static final String a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadInJoyAtlasAdapter.OnLoadMoreClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter$OnLoadMoreClickListener;
  private AtlasModeLoadingMore jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModeLoadingMore;
  private AtlasModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas.." + ReadInJoyAtlasAdapter.class.getSimpleName();
  }
  
  public ReadInJoyAtlasAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private View a(AtlasModel paramAtlasModel, ViewGroup paramViewGroup)
  {
    if (paramAtlasModel.type == 4)
    {
      paramAtlasModel = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970693, null);
      paramViewGroup = new ReadInJoyAtlasAdapter.LoadingMoreViewHolder(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramAtlasModel.findViewById(2131361845));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramAtlasModel.findViewById(2131366918);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramAtlasModel.findViewById(2131366919));
      paramAtlasModel.setTag(paramViewGroup);
      return paramAtlasModel;
    }
    paramAtlasModel = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130971507, null);
    ReadInJoyAtlasAdapter.ViewHolder localViewHolder = new ReadInJoyAtlasAdapter.ViewHolder(this);
    localViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramAtlasModel.findViewById(2131361846));
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramAtlasModel.findViewById(2131361845));
    paramViewGroup = paramViewGroup.getContext().getResources().getDrawable(2130840412);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    paramAtlasModel.setTag(localViewHolder);
    return paramAtlasModel;
  }
  
  private void a(AtlasModel paramAtlasModel, View paramView)
  {
    if ((paramAtlasModel instanceof AtlasModeLoadingMore)) {
      ((ReadInJoyAtlasAdapter.LoadingMoreViewHolder)paramView.getTag()).a((AtlasModeLoadingMore)paramAtlasModel);
    }
    while (!(paramAtlasModel instanceof AtlasModelImage)) {
      return;
    }
    ((ReadInJoyAtlasAdapter.ViewHolder)paramView.getTag()).a((AtlasModelImage)paramAtlasModel);
  }
  
  private void a(boolean paramBoolean, ReadinjoyAtlasPageLoader.Result paramResult)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModeLoadingMore.mIsLoadingState = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModeLoadingMore.mErrorInfo = paramResult;
  }
  
  public int a()
  {
    int j = getCount();
    int i = j;
    if (j > 0)
    {
      i = j;
      if (this.jdField_a_of_type_Boolean) {
        i = j - 1;
      }
    }
    return i;
  }
  
  public AtlasModel a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel;
  }
  
  public AtlasModel a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount()) && (paramInt >= 0)) {
      return (AtlasModel)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, AtlasModel paramAtlasModel)
  {
    if ((a() - paramInt < 10) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter$OnLoadMoreClickListener != null) && (!this.b))
    {
      this.b = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter$OnLoadMoreClickListener.a();
    }
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
  
  public void a(View paramView, int paramInt, AtlasModel paramAtlasModel)
  {
    if (paramAtlasModel == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramAtlasModel instanceof AtlasModeLoadingMore)) {
              break;
            }
          } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter$OnLoadMoreClickListener == null) || (this.b));
          this.b = true;
          a(true, null);
          notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter$OnLoadMoreClickListener.a();
          return;
        } while ((paramView == null) || (!(paramAtlasModel instanceof AtlasModelImage)));
        paramAtlasModel = paramView.getTag();
      } while ((paramAtlasModel == null) || (!(paramAtlasModel instanceof ReadInJoyAtlasAdapter.ViewHolder)));
      paramView = ((ReadInJoyAtlasAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
    } while ((paramView == null) || (!(paramView instanceof URLDrawable)) || (((URLDrawable)paramView).getStatus() != 2));
    ((URLDrawable)paramView).restartDownload();
  }
  
  public void a(ReadInJoyAtlasAdapter.OnLoadMoreClickListener paramOnLoadMoreClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasAdapter$OnLoadMoreClickListener = paramOnLoadMoreClickListener;
  }
  
  public void a(ReadinjoyAtlasPageLoader.Result paramResult)
  {
    if (paramResult.a == 0) {
      a(true, paramResult);
    }
    for (;;)
    {
      notifyDataSetChanged();
      this.b = false;
      return;
      a(false, paramResult);
    }
  }
  
  public void a(AtlasModel paramAtlasModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel = paramAtlasModel;
  }
  
  public void a(AtlasModelImage paramAtlasModelImage, ReadInJoyAtlasAdapter.ViewHolder paramViewHolder)
  {
    URLImageView localURLImageView = paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
    paramViewHolder = paramViewHolder.jdField_a_of_type_AndroidWidgetImageView;
    Object localObject = paramAtlasModelImage.pictureInfo.bytes_pic_url.get().toStringUtf8();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadThumbImage() path = " + (String)localObject);
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846411);
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
    if (((URLDrawable)localObject).getStatus() == 1) {
      paramAtlasModelImage.modelImageShowTime = paramAtlasModelImage.modelEnterTime;
    }
    for (;;)
    {
      localURLImageView.setImageDrawable((Drawable)localObject);
      a(paramViewHolder);
      localURLImageView.setURLDrawableDownListener(new lmz(this, paramViewHolder, paramAtlasModelImage, localURLImageView));
      return;
      if (((URLDrawable)localObject).getStatus() == 2) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
  }
  
  public void a(List paramList, boolean paramBoolean)
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
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModeLoadingMore == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModeLoadingMore = new AtlasModeLoadingMore(true, null);
      }
      a(true, null);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModeLoadingMore);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateData add loadmore view:");
      }
    }
    notifyDataSetChanged();
  }
  
  public void b(List paramList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      a(paramList, paramBoolean);
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    AtlasModel localAtlasModel = (AtlasModel)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    if ((localAtlasModel instanceof AtlasModeLoadingMore)) {
      this.jdField_a_of_type_JavaUtilList.remove(localAtlasModel);
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (paramBoolean)
    {
      a(true, null);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModeLoadingMore);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "appendData add loadmore view:");
      }
    }
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
  
  public int getItemViewType(int paramInt)
  {
    AtlasModel localAtlasModel = a(paramInt);
    if ((localAtlasModel != null) && (localAtlasModel.type == 4)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AtlasModel localAtlasModel = (AtlasModel)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localAtlasModel.position = paramInt;
    View localView = paramView;
    if (paramView == null) {
      localView = a(localAtlasModel, paramViewGroup);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel.equals(localAtlasModel)))
    {
      localAtlasModel.modelEnterTime = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel.modelExitTime = localAtlasModel.modelEnterTime;
      }
    }
    a(localAtlasModel, localView);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasAdapter
 * JD-Core Version:    0.7.0.1
 */