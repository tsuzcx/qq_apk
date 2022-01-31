package com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.model.filter.PictureFilterConfig;
import com.tencent.biz.qqstory.model.filter.PictureFilterConfig.PictureContent;
import com.tencent.biz.qqstory.model.filter.PictureFilterConfig.PictureElement;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import com.tencent.biz.qqstory.takevideo.doodle.loader.ImageLoader;
import java.io.File;
import java.net.URI;

public class PictureFilterData$PictureFilterItem
  extends FilterData.FilterPageItem
{
  ImageView a;
  
  private PictureFilterData$PictureFilterItem(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    paramViewGroup = new RelativeLayout(paramContext);
    paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.a = new ImageView(paramContext);
    this.a.setScaleType(ImageView.ScaleType.FIT_XY);
    paramViewGroup.addView(this.a);
    return paramViewGroup;
  }
  
  public void a(PictureFilterData paramPictureFilterData, int paramInt)
  {
    super.a(paramPictureFilterData, paramInt);
    Object localObject = paramPictureFilterData.a.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[0];
      if ((localObject != null) && (((PictureFilterConfig.PictureElement)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = ((PictureFilterConfig.PictureElement)localObject).jdField_a_of_type_ComTencentBizQqstoryModelFilterPictureFilterConfig$PictureContent;
        if (localObject != null)
        {
          float f = TakeVideoUtils.a(this.a.getResources()) / ((PictureFilterConfig.PictureContent)localObject).d;
          paramPictureFilterData = new File(paramPictureFilterData.c, ((PictureFilterConfig.PictureContent)localObject).jdField_a_of_type_JavaLangString);
          ImageLoader.a().a(this.a.getContext(), this.a, paramPictureFilterData.toURI().toString(), (int)(((PictureFilterConfig.PictureContent)localObject).b * f), (int)(((PictureFilterConfig.PictureContent)localObject).c * f), null);
          paramPictureFilterData = new RelativeLayout.LayoutParams((int)(((PictureFilterConfig.PictureContent)localObject).b * f), (int)(((PictureFilterConfig.PictureContent)localObject).c * f));
          if ((((PictureFilterConfig.PictureContent)localObject).jdField_a_of_type_Int & 0x1) != 0) {
            paramPictureFilterData.addRule(9);
          }
          if ((((PictureFilterConfig.PictureContent)localObject).jdField_a_of_type_Int & 0x2) != 0) {
            paramPictureFilterData.addRule(10);
          }
          if ((((PictureFilterConfig.PictureContent)localObject).jdField_a_of_type_Int & 0x4) != 0) {
            paramPictureFilterData.addRule(11);
          }
          if ((((PictureFilterConfig.PictureContent)localObject).jdField_a_of_type_Int & 0x8) != 0) {
            paramPictureFilterData.addRule(12);
          }
          if ((((PictureFilterConfig.PictureContent)localObject).jdField_a_of_type_Int & 0x10) != 0) {
            paramPictureFilterData.addRule(14);
          }
          if ((((PictureFilterConfig.PictureContent)localObject).jdField_a_of_type_Int & 0x20) != 0) {
            paramPictureFilterData.addRule(15);
          }
          if ((((PictureFilterConfig.PictureContent)localObject).jdField_a_of_type_Int & 0x40) != 0) {
            paramPictureFilterData.addRule(13);
          }
          if ((((PictureFilterConfig.PictureContent)localObject).jdField_a_of_type_ArrayOfInt != null) && (((PictureFilterConfig.PictureContent)localObject).jdField_a_of_type_ArrayOfInt.length >= 4))
          {
            paramPictureFilterData.leftMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[0] * f));
            paramPictureFilterData.topMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[1] * f));
            paramPictureFilterData.rightMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[2] * f));
            paramPictureFilterData.bottomMargin = ((int)(localObject.jdField_a_of_type_ArrayOfInt[3] * f));
          }
          this.a.setLayoutParams(paramPictureFilterData);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.filter.PictureFilterData.PictureFilterItem
 * JD-Core Version:    0.7.0.1
 */