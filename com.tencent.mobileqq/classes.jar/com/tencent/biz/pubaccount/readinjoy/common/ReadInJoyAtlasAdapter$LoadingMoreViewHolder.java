package com.tencent.biz.pubaccount.readinjoy.common;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyAtlasPageLoader.Result;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModeLoadingMore;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModel;

public class ReadInJoyAtlasAdapter$LoadingMoreViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AtlasModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel;
  
  protected ReadInJoyAtlasAdapter$LoadingMoreViewHolder(ReadInJoyAtlasAdapter paramReadInJoyAtlasAdapter) {}
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((localObject instanceof Animatable))
    {
      localObject = (Animatable)localObject;
      if (!((Animatable)localObject).isRunning())
      {
        ((Animatable)localObject).start();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void a(AtlasModeLoadingMore paramAtlasModeLoadingMore)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelAtlasModel = paramAtlasModeLoadingMore;
    if (paramAtlasModeLoadingMore.mIsLoadingState)
    {
      a();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    b();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAtlasModeLoadingMore.mErrorInfo.a);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((localObject instanceof Animatable))
    {
      localObject = (Animatable)localObject;
      if (((Animatable)localObject).isRunning()) {
        ((Animatable)localObject).stop();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasAdapter.LoadingMoreViewHolder
 * JD-Core Version:    0.7.0.1
 */