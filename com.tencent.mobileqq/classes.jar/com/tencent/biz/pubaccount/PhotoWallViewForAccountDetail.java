package com.tencent.biz.pubaccount;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bljm;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.GridView;
import java.util.List;
import oag;
import oah;
import oai;
import oak;

@TargetApi(9)
public class PhotoWallViewForAccountDetail
  extends LinearLayout
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bljm jdField_a_of_type_Bljm = new oah(this);
  public PhotoHorizontalScrollView a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public GridView a;
  public List<oag> a;
  public oak a;
  public int b;
  private View b;
  public int c = -1;
  
  public PhotoWallViewForAccountDetail(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public PhotoWallViewForAccountDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  @TargetApi(11)
  public PhotoWallViewForAccountDetail(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public void a()
  {
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_JavaUtilList != null)) {
      QLog.i("AccountDetail.PhotoWallViewForAccountDetail", 2, "updatePhotoView urlList size=" + this.jdField_a_of_type_JavaUtilList.size());
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      if (i > 0)
      {
        this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(0);
        this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.c);
        oai localoai = new oai(this, this.jdField_a_of_type_AndroidAppActivity);
        localoai.a(this.jdField_a_of_type_JavaUtilList);
        i = this.jdField_a_of_type_JavaUtilList.size();
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((this.jdField_a_of_type_Int + this.c) * i, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(i);
        this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(localoai);
        this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Bljm);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
        setVisibility(0);
      }
      return;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, List<oag> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountDetail.PhotoWallViewForAccountDetail", 2, "initView");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    if ((paramList != null) && (paramList.size() > 20)) {}
    for (this.jdField_a_of_type_JavaUtilList = paramList.subList(0, 20);; this.jdField_a_of_type_JavaUtilList = paramList)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2131559573, this, true);
      this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372592));
      this.jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountPhotoHorizontalScrollView = ((PhotoHorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372593));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373035));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375030);
      this.c = getResources().getDimensionPixelSize(2131296256);
      this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131296258);
      this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131296257);
      if (VersionUtils.isGingerBread()) {
        this.jdField_a_of_type_ComTencentBizPubaccountPhotoHorizontalScrollView.setOverScrollMode(2);
      }
      a();
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setPhotoWallCallback(oak paramoak)
  {
    this.jdField_a_of_type_Oak = paramoak;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail
 * JD-Core Version:    0.7.0.1
 */