package com.tencent.biz.pubaccount.readinjoy.capture;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import lic;
import lid;
import lie;

public class ReadInJoyCameraTemplateAdapter
  extends BaseAdapter
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadInJoyCameraTemplateItemView.TemplateItemCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateItemView$TemplateItemCallback = new lid(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private SplitEffectsCameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView;
  private PtvTemplateManager.IPtvTemplateDownloadListener jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = new lie(this);
  private PtvTemplateManager.PtvTemplateInfo jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
  private PtvTemplateManager jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  
  public ReadInJoyCameraTemplateAdapter(AppInterface paramAppInterface, Context paramContext, HorizontalListView paramHorizontalListView, SplitEffectsCameraCaptureView paramSplitEffectsCameraCaptureView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager = PtvTemplateManager.a(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSplitEffectsCameraCaptureView = paramSplitEffectsCameraCaptureView;
    this.b = paramInt;
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels / 4.5F));
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new lic(this, paramArrayList));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (!(paramView instanceof ReadInJoyCameraTemplateItemView)))
    {
      paramView = new ReadInJoyCameraTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      paramView.a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCaptureReadInJoyCameraTemplateItemView$TemplateItemCallback);
      return paramView;
      paramView = (ReadInJoyCameraTemplateItemView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */