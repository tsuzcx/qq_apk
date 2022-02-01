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
  public List<ZhituPicData> b;
  public List<ZhituPicData> c;
  public MqqHandler d;
  public long e = 0L;
  public String f;
  public int g;
  private float h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private Context n;
  private QQAppInterface o;
  private BaseActivity p;
  private SessionInfo q;
  private long r;
  private ColorDrawable s = new ColorDrawable();
  
  public ZhituPicAdapter(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler)
  {
    this.n = paramContext;
    this.o = paramQQAppInterface;
    this.p = paramBaseActivity;
    this.q = paramSessionInfo;
    this.d = paramMqqHandler;
    this.e = System.currentTimeMillis();
    this.b = new ArrayList();
    this.c = new ArrayList();
    int i1 = 0;
    while (i1 < a)
    {
      this.c.add(new ZhituPicData());
      i1 += 1;
    }
    this.b.addAll(this.c);
    this.h = this.n.getResources().getDisplayMetrics().density;
    this.i = AIOUtils.b(85.0F, this.n.getResources());
    this.j = AIOUtils.b(85.0F, this.n.getResources());
    this.k = AIOUtils.b(80.0F, this.n.getResources());
    this.l = AIOUtils.b(80.0F, this.n.getResources());
    this.m = AIOUtils.b(2.5F, this.n.getResources());
  }
  
  public ZhituPicData a(int paramInt)
  {
    if (paramInt < this.b.size()) {
      return (ZhituPicData)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "[ZhituPicAdapter]-resetData");
    }
    this.b.clear();
    this.b.addAll(this.c);
    this.f = "";
    this.g = -1;
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
      ((StringBuilder)localObject).append(this.f);
      QLog.i("ZhituManager", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramInt > 0)
    {
      if (!paramString.equals(this.f))
      {
        this.b.clear();
        localObject = this.o;
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X8008C71", "0X8008C71", ZhituManager.a(ZhituManager.a((AppInterface)localObject).a()), 0, "", "", "", "");
      }
      this.f = paramString;
      int i1 = 0;
      while (i1 < paramInt)
      {
        this.b.add(new ZhituPicData());
        i1 += 1;
      }
      this.g = -1;
      notifyDataSetChanged();
    }
  }
  
  public void a(ZhituPicData paramZhituPicData)
  {
    if (paramZhituPicData != null)
    {
      int i1 = paramZhituPicData.g;
      if ((i1 >= 0) && (i1 < this.b.size())) {
        ((ZhituPicData)this.b.get(i1)).a(paramZhituPicData);
      }
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    int i1 = this.b.size();
    if (TextUtils.isEmpty(((ZhituPicData)this.b.get(i1 - 1)).f)) {
      return;
    }
    if (i1 > this.g)
    {
      this.g = i1;
      ZhituManager.a(this.o).a(this.b.size(), this.f);
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = getCount();
    Object localObject1 = null;
    if (paramInt >= i1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get view position exception , position = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(",size = ");
      ((StringBuilder)localObject2).append(this.b.size());
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
      ((ZhituPicAdapter.ViewHolder)localObject1).a = new RelativeLayout(this.n);
      paramView = new ViewGroup.LayoutParams(-2, this.j);
      ((ZhituPicAdapter.ViewHolder)localObject1).a.setLayoutParams(paramView);
      ((ZhituPicAdapter.ViewHolder)localObject1).b = new BubbleImageView(this.n);
      ((ZhituPicAdapter.ViewHolder)localObject1).b.c(false);
      ((ZhituPicAdapter.ViewHolder)localObject1).b.setRadius(5.0F);
      ((ZhituPicAdapter.ViewHolder)localObject1).b.c = false;
      ((ZhituPicAdapter.ViewHolder)localObject1).b.setScaleType(ImageView.ScaleType.FIT_XY);
      paramView = new RelativeLayout.LayoutParams(-2, this.l);
      paramView.addRule(13, -1);
      ((ZhituPicAdapter.ViewHolder)localObject1).a.addView(((ZhituPicAdapter.ViewHolder)localObject1).b, paramView);
      ((ZhituPicAdapter.ViewHolder)localObject1).c = new ProgressBar(this.n);
      ((ZhituPicAdapter.ViewHolder)localObject1).c.setIndeterminateDrawable(this.n.getResources().getDrawable(2130839585));
      float f1 = this.h;
      paramView = new RelativeLayout.LayoutParams((int)(f1 * 30.0F), (int)(f1 * 30.0F));
      paramView.addRule(13, -1);
      ((ZhituPicAdapter.ViewHolder)localObject1).a.addView(((ZhituPicAdapter.ViewHolder)localObject1).c, paramView);
      paramView = ((ZhituPicAdapter.ViewHolder)localObject1).a;
      paramView.setTag(localObject1);
      paramView.setOnClickListener(this);
    }
    ((ZhituPicAdapter.ViewHolder)localObject1).d = new WeakReference(localZhituPicData);
    ((ZhituPicAdapter.ViewHolder)localObject1).c.setVisibility(0);
    Object localObject4;
    Object localObject3;
    if (localZhituPicData.e)
    {
      localObject4 = ZhituManager.a(this.o).f(localZhituPicData);
      localObject3 = ZhituManager.a((String)localObject4);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        ZhituManager.a(this.o).d(localZhituPicData);
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
    if ((localZhituPicData.i == null) && (localObject2 == null))
    {
      ((ZhituPicAdapter.ViewHolder)localObject1).b.setImageDrawable(this.s);
      localObject2 = ((ZhituPicAdapter.ViewHolder)localObject1).b.getLayoutParams();
      i1 = this.i;
      ((ViewGroup.LayoutParams)localObject2).width = i1;
      ((ZhituPicAdapter.ViewHolder)localObject1).c.setVisibility(0);
    }
    else
    {
      ((ZhituPicAdapter.ViewHolder)localObject1).a.setMinimumWidth(0);
      localObject3 = localZhituPicData.i;
      localObject4 = ((ZhituPicAdapter.ViewHolder)localObject1).b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localZhituPicData.a);
      localStringBuilder.append(localZhituPicData.h);
      ((BubbleImageView)localObject4).setTag(localStringBuilder.toString());
      if (localObject2 != null) {
        localObject3 = new GifDrawable((AbstractGifImage)localObject2);
      }
      i1 = ((Drawable)localObject3).getIntrinsicWidth();
      int i2 = ((Drawable)localObject3).getIntrinsicHeight();
      int i3 = this.l;
      if (i2 == i3)
      {
        ((ZhituPicAdapter.ViewHolder)localObject1).b.setScaleType(ImageView.ScaleType.CENTER);
      }
      else if (i2 > i3)
      {
        i1 = i1 * i3 / i2;
        ((ZhituPicAdapter.ViewHolder)localObject1).b.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      else
      {
        i1 = i1 * this.k / i2;
        ((ZhituPicAdapter.ViewHolder)localObject1).b.setScaleType(ImageView.ScaleType.FIT_XY);
      }
      ((ZhituPicAdapter.ViewHolder)localObject1).b.getLayoutParams().width = i1;
      ((ZhituPicAdapter.ViewHolder)localObject1).b.setImageDrawable((Drawable)localObject3);
      ((ZhituPicAdapter.ViewHolder)localObject1).b.setBackgroundDrawable(null);
      ((ZhituPicAdapter.ViewHolder)localObject1).c.setVisibility(8);
    }
    if (paramInt == 0)
    {
      ((ZhituPicAdapter.ViewHolder)localObject1).a.getLayoutParams().width = (i1 + this.m);
      ((ZhituPicAdapter.ViewHolder)localObject1).a.setPadding(0, 0, this.m, 0);
    }
    else
    {
      ((ZhituPicAdapter.ViewHolder)localObject1).a.getLayoutParams().width = (i1 + this.m * 2);
      localObject1 = ((ZhituPicAdapter.ViewHolder)localObject1).a;
      i1 = this.m;
      ((RelativeLayout)localObject1).setPadding(i1, 0, i1, 0);
    }
    if ((localZhituPicData.l != null) && (!localZhituPicData.l.i))
    {
      ZhituManager.a(this.o).b(localZhituPicData);
      localZhituPicData.l.i = true;
    }
    Object localObject2 = paramView;
    localObject1 = paramView;
    label938:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void onClick(View paramView)
  {
    long l1 = SystemClock.uptimeMillis();
    if (l1 - this.r < 200L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "filter multi click");
      }
    }
    else
    {
      this.r = l1;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof ZhituPicAdapter.ViewHolder))) {
        localObject = (ZhituPicAdapter.ViewHolder)localObject;
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        localObject = (ZhituPicData)((ZhituPicAdapter.ViewHolder)localObject).d.get();
        if ((localObject != null) && (((ZhituPicData)localObject).a != null) && (((ZhituPicData)localObject).l != null))
        {
          ThreadManager.post(new ZhituPicAdapter.1(this, (ZhituPicData)localObject), 8, null, false);
          ZhituManager.a(this.o).a((ZhituPicData)localObject);
          localObject = this.d;
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
      if (paramView.b != null) {
        paramView.b.setImageDrawable(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPicAdapter
 * JD-Core Version:    0.7.0.1
 */