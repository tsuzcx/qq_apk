package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView.RecycleListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ZhituPicAdapter
  extends BaseAdapter
  implements View.OnClickListener, HorizontalListView.RecycleListener
{
  public static int a;
  private float jdField_a_of_type_Float;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  public List<ZhituPicData> a;
  public MqqHandler a;
  public int b;
  private long b;
  public List<ZhituPicData> b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  static
  {
    jdField_a_of_type_Int = 6;
  }
  
  public ZhituPicAdapter(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    int i = 0;
    while (i < jdField_a_of_type_Int)
    {
      this.jdField_b_of_type_JavaUtilList.add(new ZhituPicData());
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.c = AIOUtils.a(85.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.d = AIOUtils.a(85.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.e = AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.f = AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.g = AIOUtils.a(2.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public ZhituPicData a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "[ZhituPicAdapter]-resetData");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = -1;
    notifyDataSetChanged();
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ZhituManager", 2, "ZhituPicAdapter setPicItemCount: picCount = ,mReqKey = " + paramString + ",this.mReqKey =" + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    while (paramInt <= 0) {
      return;
    }
    if (!paramString.equals(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008C71", "0X8008C71", ZhituManager.a(ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()), 0, "", "", "", "");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    while (i < paramInt)
    {
      this.jdField_a_of_type_JavaUtilList.add(new ZhituPicData());
      i += 1;
    }
    this.jdField_b_of_type_Int = -1;
    notifyDataSetChanged();
  }
  
  public void a(ZhituPicData paramZhituPicData)
  {
    if (paramZhituPicData != null)
    {
      int i = paramZhituPicData.jdField_a_of_type_Int;
      if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
        ((ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramZhituPicData);
      }
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (TextUtils.isEmpty(((ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(i - 1)).d)) {}
    while (i <= this.jdField_b_of_type_Int) {
      return;
    }
    this.jdField_b_of_type_Int = i;
    ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= getCount())
    {
      QLog.e("ZhituManager", 2, "get view position exception , position = " + paramInt + ",size = " + this.jdField_a_of_type_JavaUtilList.size());
      localObject1 = paramView;
    }
    ZhituPicData localZhituPicData;
    for (paramView = null;; paramView = (View)localObject2)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localZhituPicData = a(paramInt);
      if (localZhituPicData != null) {
        break;
      }
      QLog.e("ZhituManager", 1, "getView emoticon empty position = " + paramInt);
      localObject2 = null;
      localObject1 = paramView;
    }
    label373:
    Object localObject3;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localObject1 = new ZhituPicAdapter.ViewHolder(null);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ViewGroup.LayoutParams(-2, this.d);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(5.0F);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.b = false;
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramView = new RelativeLayout.LayoutParams(-2, this.f);
      paramView.addRule(13, -1);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramView);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839545));
      paramView = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 30.0F), (int)(this.jdField_a_of_type_Float * 30.0F));
      paramView.addRule(13, -1);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar, paramView);
      paramView = ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(localObject1);
      paramView.setOnClickListener(this);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localZhituPicData);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if (!localZhituPicData.jdField_a_of_type_Boolean) {
        break label891;
      }
      String str = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localZhituPicData);
      localObject3 = ZhituManager.a(str);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(localZhituPicData);
        localObject2 = localObject3;
        if (QLog.isColorLevel()) {
          QLog.d("ZhituManager", 2, "get gif image from cache fail, " + str);
        }
      }
    }
    label600:
    label884:
    label891:
    for (Object localObject2 = localObject3;; localObject2 = null)
    {
      if ((localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (localObject2 != null))
      {
        ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setMinimumWidth(0);
        localObject3 = localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(localZhituPicData.jdField_a_of_type_JavaLangString + localZhituPicData.e);
        if (localObject2 == null) {
          break label884;
        }
      }
      for (localObject2 = new GifDrawable((AbstractGifImage)localObject2);; localObject2 = localObject3)
      {
        int i = ((Drawable)localObject2).getIntrinsicWidth();
        int j = ((Drawable)localObject2).getIntrinsicHeight();
        if (j == this.f)
        {
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER);
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().width = i;
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject2);
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          if (paramInt != 0) {
            break label843;
          }
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = (this.g + i);
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, this.g, 0);
        }
        for (;;)
        {
          if ((localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData != null) && (!localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData.jdField_a_of_type_Boolean))
          {
            ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localZhituPicData);
            localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData.jdField_a_of_type_Boolean = true;
          }
          localObject1 = paramView;
          break;
          localObject1 = (ZhituPicAdapter.ViewHolder)paramView.getTag();
          break label373;
          if (j > this.f)
          {
            i = i * this.f / j;
            ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            break label600;
          }
          i = i * this.e / j;
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          break label600;
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().width = this.c;
          i = this.c;
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          break label642;
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = (this.g * 2 + i);
          ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.g, 0, this.g, 0);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_b_of_type_Long < 200L) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "filter multi click");
      }
    }
    label175:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_b_of_type_Long = l;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof ZhituPicAdapter.ViewHolder))) {}
      for (localObject = (ZhituPicAdapter.ViewHolder)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label175;
        }
        localObject = (ZhituPicData)((ZhituPicAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject == null) || (((ZhituPicData)localObject).jdField_a_of_type_JavaLangString == null) || (((ZhituPicData)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData == null)) {
          break;
        }
        ThreadManager.post(new ZhituPicAdapter.1(this, (ZhituPicData)localObject), 8, null, false);
        ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((ZhituPicData)localObject);
        if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
          break;
        }
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(84);
        ((Message)localObject).arg1 = 1;
        ((Message)localObject).sendToTarget();
        break;
      }
    }
  }
  
  public void onRecycle(View paramView) {}
  
  public void onViewRecycled(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof ZhituPicAdapter.ViewHolder)))
    {
      paramView = (ZhituPicAdapter.ViewHolder)paramView.getTag();
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPicAdapter
 * JD-Core Version:    0.7.0.1
 */