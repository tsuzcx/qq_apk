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
import com.tencent.common.app.AppInterface;
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
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ZhituPicAdapter
  extends BaseAdapter
  implements View.OnClickListener, HorizontalListView.RecycleListener
{
  public static int a = 6;
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
    this.c = AIOUtils.b(85.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.d = AIOUtils.b(85.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.e = AIOUtils.b(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.f = AIOUtils.b(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.g = AIOUtils.b(2.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ZhituPicAdapter setPicItemCount: picCount = ,mReqKey = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",this.mReqKey =");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.i("ZhituManager", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramInt > 0)
    {
      if (!paramString.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8008C71", "0X8008C71", ZhituManager.a(ZhituManager.a((AppInterface)localObject).a()), 0, "", "", "", "");
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      int i = 0;
      while (i < paramInt)
      {
        this.jdField_a_of_type_JavaUtilList.add(new ZhituPicData());
        i += 1;
      }
      this.jdField_b_of_type_Int = -1;
      notifyDataSetChanged();
    }
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
    if (TextUtils.isEmpty(((ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(i - 1)).d)) {
      return;
    }
    if (i > this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = i;
      ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString);
    }
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
    int i = getCount();
    Object localObject1 = null;
    if (paramInt >= i)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get view position exception , position = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(",size = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.e("ZhituManager", 2, ((StringBuilder)localObject2).toString());
    }
    ZhituPicData localZhituPicData;
    for (;;)
    {
      localObject2 = paramView;
      break label938;
      localZhituPicData = a(paramInt);
      if (localZhituPicData != null) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getView emoticon empty position = ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.e("ZhituManager", 1, ((StringBuilder)localObject2).toString());
    }
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject1 = (ZhituPicAdapter.ViewHolder)paramView.getTag();
    }
    else
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
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839401));
      float f1 = this.jdField_a_of_type_Float;
      paramView = new RelativeLayout.LayoutParams((int)(f1 * 30.0F), (int)(f1 * 30.0F));
      paramView.addRule(13, -1);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar, paramView);
      paramView = ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(localObject1);
      paramView.setOnClickListener(this);
    }
    ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localZhituPicData);
    ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    Object localObject4;
    Object localObject3;
    if (localZhituPicData.jdField_a_of_type_Boolean)
    {
      localObject4 = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localZhituPicData);
      localObject3 = ZhituManager.a((String)localObject4);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(localZhituPicData);
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get gif image from cache fail, ");
          ((StringBuilder)localObject2).append((String)localObject4);
          QLog.d("ZhituManager", 2, ((StringBuilder)localObject2).toString());
          localObject2 = localObject3;
        }
      }
    }
    else
    {
      localObject2 = null;
    }
    if ((localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (localObject2 == null))
    {
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      localObject2 = ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      i = this.c;
      ((ViewGroup.LayoutParams)localObject2).width = i;
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    else
    {
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setMinimumWidth(0);
      localObject3 = localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject4 = ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localZhituPicData.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(localZhituPicData.e);
      ((BubbleImageView)localObject4).setTag(localStringBuilder.toString());
      if (localObject2 != null) {
        localObject3 = new GifDrawable((AbstractGifImage)localObject2);
      }
      i = ((Drawable)localObject3).getIntrinsicWidth();
      int j = ((Drawable)localObject3).getIntrinsicHeight();
      int k = this.f;
      if (j == k)
      {
        ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER);
      }
      else if (j > k)
      {
        i = i * k / j;
        ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      else
      {
        i = i * this.e / j;
        ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      }
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().width = i;
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject3);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    if (paramInt == 0)
    {
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = (i + this.g);
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, this.g, 0);
    }
    else
    {
      ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = (i + this.g * 2);
      localObject1 = ((ZhituPicAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
      i = this.g;
      ((RelativeLayout)localObject1).setPadding(i, 0, i, 0);
    }
    if ((localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData != null) && (!localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData.jdField_a_of_type_Boolean))
    {
      ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localZhituPicData);
      localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData.jdField_a_of_type_Boolean = true;
    }
    Object localObject2 = paramView;
    localObject1 = paramView;
    label938:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void onClick(View paramView)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_b_of_type_Long < 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "filter multi click");
      }
    }
    else
    {
      this.jdField_b_of_type_Long = l;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof ZhituPicAdapter.ViewHolder))) {
        localObject = (ZhituPicAdapter.ViewHolder)localObject;
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        localObject = (ZhituPicData)((ZhituPicAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject != null) && (((ZhituPicData)localObject).jdField_a_of_type_JavaLangString != null) && (((ZhituPicData)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData != null))
        {
          ThreadManager.post(new ZhituPicAdapter.1(this, (ZhituPicData)localObject), 8, null, false);
          ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((ZhituPicData)localObject);
          localObject = this.jdField_a_of_type_MqqOsMqqHandler;
          if (localObject != null)
          {
            localObject = ((MqqHandler)localObject).obtainMessage(84);
            ((Message)localObject).arg1 = 1;
            ((Message)localObject).sendToTarget();
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPicAdapter
 * JD-Core Version:    0.7.0.1
 */