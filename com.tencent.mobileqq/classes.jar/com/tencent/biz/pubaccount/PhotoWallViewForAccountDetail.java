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
  QQAppInterface a;
  View b;
  public List<IPublicAccountConfigAttr.PaConfigInfo> c;
  public PhotoWallViewForAccountDetail.PhotoWallCallback d;
  public int e = -1;
  public int f = -1;
  public int g = -1;
  public GridView h;
  public PhotoHorizontalScrollView i;
  private Activity j;
  private ImageView k;
  private View l;
  private AdapterView.OnItemClickListener m = new PhotoWallViewForAccountDetail.1(this);
  
  public PhotoWallViewForAccountDetail(Context paramContext)
  {
    super(paramContext);
  }
  
  public PhotoWallViewForAccountDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public PhotoWallViewForAccountDetail(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if ((QLog.isColorLevel()) && (this.c != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePhotoView urlList size=");
      ((StringBuilder)localObject).append(this.c.size());
      QLog.i("AccountDetail.PhotoWallViewForAccountDetail", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    int n;
    if (localObject != null) {
      n = ((List)localObject).size();
    } else {
      n = 0;
    }
    if (n > 0)
    {
      this.h.setColumnWidth(this.e);
      this.h.setStretchMode(0);
      this.h.setHorizontalSpacing(this.g);
      localObject = new PhotoWallViewForAccountDetail.PhotoAdapter(this, this.j);
      ((PhotoWallViewForAccountDetail.PhotoAdapter)localObject).a(this.c);
      n = this.c.size();
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((this.e + this.g) * n, this.f);
      this.h.setLayoutParams(localLayoutParams);
      this.h.setNumColumns(n);
      this.h.setAdapter((ListAdapter)localObject);
      this.h.setOnItemClickListener(this.m);
      this.k.setVisibility(8);
      this.l.setVisibility(8);
      this.h.setVisibility(0);
      setVisibility(0);
    }
  }
  
  public void a(BaseActivity paramBaseActivity, List<IPublicAccountConfigAttr.PaConfigInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountDetail.PhotoWallViewForAccountDetail", 2, "initView");
    }
    this.j = paramBaseActivity;
    this.a = paramBaseActivity.app;
    if ((paramList != null) && (paramList.size() > 20)) {
      this.c = paramList.subList(0, 20);
    } else {
      this.c = paramList;
    }
    this.b = LayoutInflater.from(this.a.getApplication()).inflate(2131625586, this, true);
    this.h = ((GridView)this.b.findViewById(2131440206));
    this.h.setClickable(true);
    this.i = ((PhotoHorizontalScrollView)this.b.findViewById(2131440207));
    this.k = ((ImageView)this.b.findViewById(2131440723));
    this.l = this.b.findViewById(2131443117);
    this.g = getResources().getDimensionPixelSize(2131296496);
    this.e = getResources().getDimensionPixelSize(2131296498);
    this.f = getResources().getDimensionPixelSize(2131296497);
    if (VersionUtils.c()) {
      this.i.setOverScrollMode(2);
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
    this.d = paramPhotoWallCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail
 * JD-Core Version:    0.7.0.1
 */