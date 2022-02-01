package com.tencent.mobileqq.activity.photo;

import NS_MOBILE_OPERATION.PicInfo;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import cooperation.qzone.widget.LocalPhotoLinearGradientView;
import java.util.ArrayList;
import java.util.HashMap;

public class QzonePhotoPreviewActivity
  extends PublicBaseFragment
{
  int jdField_a_of_type_Int = 0;
  protected TextView a;
  protected QzonePhotoPreviewActivity.VerticalPictureAdapter a;
  protected ListView a;
  protected LocalPhotoLinearGradientView a;
  protected ArrayList<String> a;
  protected HashMap<String, PicInfo> a;
  private boolean jdField_a_of_type_Boolean;
  protected ArrayList<QzonePhotoPreviewActivity.PicInfoItem> b;
  protected HashMap<String, LocalMediaInfo> b;
  
  private Intent a()
  {
    return getBaseActivity().getIntent();
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_CooperationQzoneWidgetLocalPhotoLinearGradientView = ((LocalPhotoLinearGradientView)paramView.findViewById(2131375910));
    LinearGradient localLinearGradient = new LinearGradient(0.0F, ViewUtils.a(79.0F), 0.0F, 0.0F, -14869219, 0, Shader.TileMode.CLAMP);
    this.jdField_a_of_type_CooperationQzoneWidgetLocalPhotoLinearGradientView.setShader(localLinearGradient);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramView.findViewById(2131375911));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375909));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(new QzonePhotoPreviewActivity.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new QzonePhotoPreviewActivity.2(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity$VerticalPictureAdapter = new QzonePhotoPreviewActivity.VerticalPictureAdapter(this, getBaseActivity());
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity$VerticalPictureAdapter);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList = a().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)a().getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.jdField_b_of_type_JavaUtilHashMap = ((HashMap)a().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"));
    this.jdField_a_of_type_Int = a().getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    this.jdField_a_of_type_Boolean = a().getBooleanExtra("PhotoConst.IS_FROM_QZONE_ALBUM", false);
    c();
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(1);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      Object localObject2;
      double d1;
      double d2;
      if ((localObject1 != null) && (((HashMap)localObject1).size() > 0) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_JavaUtilArrayList.get(i))))
      {
        localObject1 = (PicInfo)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        if ((localObject1 != null) && (((PicInfo)localObject1).picwidth > 0))
        {
          localObject2 = this.jdField_b_of_type_JavaUtilArrayList;
          String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          d1 = ((PicInfo)localObject1).picheight;
          Double.isNaN(d1);
          d2 = ((PicInfo)localObject1).picwidth;
          Double.isNaN(d2);
          ((ArrayList)localObject2).add(new QzonePhotoPreviewActivity.PicInfoItem(this, str, (float)(d1 * 1.0D / d2)));
        }
      }
      localObject1 = this.jdField_b_of_type_JavaUtilHashMap;
      if ((localObject1 != null) && (((HashMap)localObject1).containsKey(this.jdField_a_of_type_JavaUtilArrayList.get(i))))
      {
        localObject1 = (LocalMediaInfo)this.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        int k;
        int j;
        if ((((LocalMediaInfo)localObject1).orientation != 90) && (((LocalMediaInfo)localObject1).orientation != 270))
        {
          k = ((LocalMediaInfo)localObject1).mediaHeight;
          j = ((LocalMediaInfo)localObject1).mediaWidth;
        }
        else
        {
          k = ((LocalMediaInfo)localObject1).mediaWidth;
          j = ((LocalMediaInfo)localObject1).mediaHeight;
        }
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList;
        localObject2 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        d1 = k;
        Double.isNaN(d1);
        d2 = j;
        Double.isNaN(d2);
        ((ArrayList)localObject1).add(new QzonePhotoPreviewActivity.PicInfoItem(this, (String)localObject2, (float)(d1 * 1.0D / d2)));
      }
      i += 1;
    }
  }
  
  public void a()
  {
    Intent localIntent = a();
    localIntent.setClass(getBaseActivity(), NewPhotoListActivity.class);
    startActivity(localIntent);
    getBaseActivity().finish();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        getBaseActivity().finish();
        AlbumUtil.anim(getBaseActivity(), true, false);
        return true;
      }
      a();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getBaseActivity()).inflate(2131562442, null);
    getBaseActivity().getWindow().addFlags(1024);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b();
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */