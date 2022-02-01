package com.tencent.mobileqq.activity.photo;

import NS_MOBILE_OPERATION.PicInfo;
import ajov;
import ajow;
import ajox;
import ajoy;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import cooperation.qzone.widget.LocalPhotoLinearGradientView;
import java.util.ArrayList;
import java.util.HashMap;

public class QzonePhotoPreviewActivity
  extends PublicBaseFragment
{
  public int a;
  protected ajoy a;
  protected TextView a;
  public ListView a;
  protected LocalPhotoLinearGradientView a;
  public ArrayList<String> a;
  protected HashMap<String, PicInfo> a;
  private boolean a;
  public ArrayList<ajox> b;
  protected HashMap<String, LocalMediaInfo> b;
  
  public QzonePhotoPreviewActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private Intent a()
  {
    return getActivity().getIntent();
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_CooperationQzoneWidgetLocalPhotoLinearGradientView = ((LocalPhotoLinearGradientView)paramView.findViewById(2131375775));
    LinearGradient localLinearGradient = new LinearGradient(0.0F, ViewUtils.dip2px(79.0F), 0.0F, 0.0F, -14869219, 0, Shader.TileMode.CLAMP);
    this.jdField_a_of_type_CooperationQzoneWidgetLocalPhotoLinearGradientView.setShader(localLinearGradient);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramView.findViewById(2131375776));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375774));
    this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(new ajov(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ajow(this));
    this.jdField_a_of_type_Ajoy = new ajoy(this, getActivity());
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Ajoy);
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
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject;
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() > 0) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_JavaUtilArrayList.get(i))))
      {
        localObject = (PicInfo)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        if ((localObject != null) && (((PicInfo)localObject).picwidth > 0)) {
          this.jdField_b_of_type_JavaUtilArrayList.add(new ajox(this, (String)this.jdField_a_of_type_JavaUtilArrayList.get(i), (float)(((PicInfo)localObject).picheight * 1.0D / ((PicInfo)localObject).picwidth)));
        }
      }
      int j;
      if ((this.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_JavaUtilArrayList.get(i))))
      {
        localObject = (LocalMediaInfo)this.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        if ((((LocalMediaInfo)localObject).orientation != 90) && (((LocalMediaInfo)localObject).orientation != 270)) {
          break label256;
        }
        j = ((LocalMediaInfo)localObject).mediaWidth;
      }
      for (int k = ((LocalMediaInfo)localObject).mediaHeight;; k = ((LocalMediaInfo)localObject).mediaWidth)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(new ajox(this, (String)this.jdField_a_of_type_JavaUtilArrayList.get(i), (float)(j * 1.0D / k)));
        i += 1;
        break;
        label256:
        j = ((LocalMediaInfo)localObject).mediaHeight;
      }
    }
  }
  
  public void a()
  {
    Intent localIntent = a();
    localIntent.setClass(getActivity(), NewPhotoListActivity.class);
    startActivity(localIntent);
    getActivity().finish();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        getActivity().finish();
        AlbumUtil.anim(getActivity(), true, false);
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
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131562416, null);
    getActivity().getWindow().addFlags(1024);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b();
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */