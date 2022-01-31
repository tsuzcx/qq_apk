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
import bfnz;
import bfpt;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.List;
import nms;
import nmt;
import nmu;
import nmw;

@TargetApi(9)
public class PhotoWallViewForAccountDetail
  extends LinearLayout
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bfpt jdField_a_of_type_Bfpt = new nmt(this);
  public PhotoHorizontalScrollView a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public GridView a;
  public List<nms> a;
  public nmw a;
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
        nmu localnmu = new nmu(this, this.jdField_a_of_type_AndroidAppActivity);
        localnmu.a(this.jdField_a_of_type_JavaUtilList);
        i = this.jdField_a_of_type_JavaUtilList.size();
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((this.jdField_a_of_type_Int + this.c) * i, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(i);
        this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter(localnmu);
        this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Bfpt);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
        setVisibility(0);
      }
      return;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, List<nms> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountDetail.PhotoWallViewForAccountDetail", 2, "initView");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    if ((paramList != null) && (paramList.size() > 20)) {}
    for (this.jdField_a_of_type_JavaUtilList = paramList.subList(0, 20);; this.jdField_a_of_type_JavaUtilList = paramList)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2131559387, this, true);
      this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371571));
      this.jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountPhotoHorizontalScrollView = ((PhotoHorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371572));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371991));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373661);
      this.c = getResources().getDimensionPixelSize(2131296256);
      this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131296258);
      this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131296257);
      if (bfnz.c()) {
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
  
  public void setPhotoWallCallback(nmw paramnmw)
  {
    this.jdField_a_of_type_Nmw = paramnmw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail
 * JD-Core Version:    0.7.0.1
 */