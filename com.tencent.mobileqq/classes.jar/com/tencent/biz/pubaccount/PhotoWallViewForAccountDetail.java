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
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.ui.PhotoHorizontalScrollView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.List;

@TargetApi(9)
public class PhotoWallViewForAccountDetail
  extends LinearLayout
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public PhotoWallViewForAccountDetail.PhotoWallCallback a;
  public PhotoHorizontalScrollView a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new PhotoWallViewForAccountDetail.1(this);
  public GridView a;
  public List<IPublicAccountConfigAttr.PaConfigInfo> a;
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
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePhotoView urlList size=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.i("AccountDetail.PhotoWallViewForAccountDetail", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localObject != null) {
      i = ((List)localObject).size();
    } else {
      i = 0;
    }
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGridView.setStretchMode(0);
      this.jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.c);
      localObject = new PhotoWallViewForAccountDetail.PhotoAdapter(this, this.jdField_a_of_type_AndroidAppActivity);
      ((PhotoWallViewForAccountDetail.PhotoAdapter)localObject).a(this.jdField_a_of_type_JavaUtilList);
      i = this.jdField_a_of_type_JavaUtilList.size();
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((this.jdField_a_of_type_Int + this.c) * i, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGridView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(i);
      this.jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject);
      this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
      setVisibility(0);
    }
  }
  
  public void a(BaseActivity paramBaseActivity, List<IPublicAccountConfigAttr.PaConfigInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountDetail.PhotoWallViewForAccountDetail", 2, "initView");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    if ((paramList != null) && (paramList.size() > 20)) {
      this.jdField_a_of_type_JavaUtilList = paramList.subList(0, 20);
    } else {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2131559562, this, true);
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372660));
    this.jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
    this.jdField_a_of_type_ComTencentBizUiPhotoHorizontalScrollView = ((PhotoHorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372661));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373120));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374932);
    this.c = getResources().getDimensionPixelSize(2131296334);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131296336);
    this.jdField_b_of_type_Int = getResources().getDimensionPixelSize(2131296335);
    if (VersionUtils.c()) {
      this.jdField_a_of_type_ComTencentBizUiPhotoHorizontalScrollView.setOverScrollMode(2);
    }
    a();
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
  
  public void setPhotoWallCallback(PhotoWallViewForAccountDetail.PhotoWallCallback paramPhotoWallCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$PhotoWallCallback = paramPhotoWallCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail
 * JD-Core Version:    0.7.0.1
 */