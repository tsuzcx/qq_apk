package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.simpleui.SimpleUIProtocolUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.List;

public class SimpleUIChoiceView
{
  public static final String[] a = { "极简白", "素雅灰", "浅葱绿", "盛夏黄", "桃桃粉", "星辰紫", "经典蓝", "元气红", "极致黑" };
  public static final String[] b = { "https://gxh.vip.qq.com/xydata/index2018/app/blackList_901/a3a9bc576041a6f2c0c28c32129e09e5.png", "https://gxh.vip.qq.com/xydata/index2018/app/blackList_901/31eed3292c91e1e94081079aa11cf403.png", "https://gxh.vip.qq.com/xydata/index2018/app/blackList_901/80e0007a21efd7b4a965ccae9e7116e9.png", "https://gxh.vip.qq.com/xydata/index2018/app/blackList_901/d03424f689b19f0416dada2dd045f80a.png", "https://gxh.vip.qq.com/xydata/index2018/app/blackList_901/4320843131be258658cc39d31cb1f72d.png", "https://gxh.vip.qq.com/xydata/index2018/app/blackList_901/424cc0074fb91718649d6829f1218d32.png", "https://gxh.vip.qq.com/xydata/index2018/app/blackList_901/5397339a0cc5104048c04f45e7614775.png", "https://gxh.vip.qq.com/xydata/index2018/app/blackList_901/408bcfd1ec1e56cdf9c39ea8e916e45b.png", "https://gxh.vip.qq.com/xydata/index2018/app/blackList_901/79e812b11417bd37a48b955f446139c6.png" };
  public static final int[] c = { 2971, 2921, 3063, 3064, 3066, 3065, 3491, 3067, 2920 };
  private static List<SimpleUIChoiceView.ColorItemInfo> k;
  private QBaseActivity d;
  private QQAppInterface e;
  private RecyclerView f;
  private LinearLayoutManager g;
  private SimpleUIChoiceView.ColorListAdapter h;
  private View i;
  private boolean j = true;
  private URLDrawable.URLDrawableListener2 l;
  private SimpleUIChoiceView.OnModeSelectListener m;
  
  private void a(URLImageView paramURLImageView, SimpleUIChoiceView.ColorItemInfo paramColorItemInfo)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    localObject = URLDrawable.getDrawable(paramColorItemInfo.b, (URLDrawable.URLDrawableOptions)localObject);
    boolean bool = a((URLDrawable)localObject);
    if (paramURLImageView != null)
    {
      paramURLImageView.setImageDrawable(null);
      paramURLImageView.setImageDrawable((Drawable)localObject);
    }
    if (QLog.isColorLevel())
    {
      paramURLImageView = new StringBuilder();
      paramURLImageView.append("onBindViewHolder loadPic colorDrawable=");
      paramURLImageView.append(localObject);
      paramURLImageView.append(" bReady=");
      paramURLImageView.append(bool);
      paramURLImageView.append(" checked=");
      paramURLImageView.append(paramColorItemInfo.c);
      QLog.d("SimpleUIChoiceView", 2, paramURLImageView.toString());
    }
    paramColorItemInfo.d = ((URLDrawable)localObject);
    if (!bool)
    {
      ((URLDrawable)localObject).setURLDrawableListener(this.l);
      ((URLDrawable)localObject).startDownload();
    }
  }
  
  private boolean a(URLDrawable paramURLDrawable)
  {
    return (paramURLDrawable != null) && ((paramURLDrawable.getStatus() == 1) || (paramURLDrawable.getStatus() == 4));
  }
  
  public void a()
  {
    List localList1 = k;
    if (localList1 == null) {
      return;
    }
    try
    {
      if (k == null) {
        return;
      }
      int i1 = Integer.decode(SimpleUIUtil.a(SimpleUIUtil.i())).intValue();
      List localList2 = SimpleUIUtil.a();
      localList2.clear();
      k.clear();
      int n = 0;
      while (n < c.length)
      {
        localObject2 = new SimpleUIChoiceView.ColorItemInfo(this, String.valueOf(c[n]), b[n], n);
        if (i1 == c[n]) {
          ((SimpleUIChoiceView.ColorItemInfo)localObject2).c = true;
        }
        a(null, (SimpleUIChoiceView.ColorItemInfo)localObject2);
        localList2.add(String.valueOf(c[n]));
        if (TextUtils.equals("2920", String.valueOf(c[n]))) {
          SimpleUIUtil.d = n;
        }
        k.add(localObject2);
        MobileReportManager.getInstance().reportAction(SimpleUIUtil.a(c[n]), "4", "platform898", "4", "1", 101, 1, System.currentTimeMillis());
        ReportController.b(this.e, "dc00898", "", "", "qq_vip", "0X800B15B", Integer.decode(SimpleUIUtil.a(c[n])).intValue(), 0, "", "", "", "");
        n += 1;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append("");
      n = SimpleUIUtil.a(((StringBuilder)localObject2).toString());
      SimpleUIProtocolUtil.a(this.e.getCurrentAccountUin(), n, 3);
      this.h.a(k);
      this.h.notifyDataSetChanged();
      if (n < localList2.size()) {
        this.f.scrollToPosition(n);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateSimpleUIChoice bpref=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" needChangeTheme=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SimpleUIChoiceView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt >= 0)
    {
      localObject = this.h;
      if (localObject != null)
      {
        localObject = ((SimpleUIChoiceView.ColorListAdapter)localObject).a(paramInt);
        if (localObject != null)
        {
          ((SimpleUIChoiceView.ColorItemInfo)localObject).e = paramBoolean;
          if ((this.h.a((SimpleUIChoiceView.ColorItemInfo)localObject, paramInt, true)) && (paramBoolean))
          {
            SimpleUIChoiceView.OnModeSelectListener localOnModeSelectListener = this.m;
            if (localOnModeSelectListener != null) {
              localOnModeSelectListener.a(((SimpleUIChoiceView.ColorItemInfo)localObject).f);
            }
          }
          this.f.scrollToPosition(paramInt);
        }
      }
    }
  }
  
  public void a(View paramView, QBaseActivity paramQBaseActivity, QQAppInterface paramQQAppInterface)
  {
    this.d = paramQBaseActivity;
    this.e = paramQQAppInterface;
    this.f = ((RecyclerView)paramView.findViewById(2131430939));
    this.f.setItemViewCacheSize(7);
    this.g = new LinearLayoutManager(paramQBaseActivity);
    this.g.setOrientation(0);
    this.f.setLayoutManager(this.g);
    this.f.addItemDecoration(new SimpleUIChoiceView.SpacesItemDecoration(this, 8));
    this.i = paramView;
    if (k == null) {
      k = new ArrayList();
    }
    this.h = new SimpleUIChoiceView.ColorListAdapter(this, k);
    this.f.setAdapter(this.h);
    int i1 = SimpleUIUtil.i();
    int n = 0;
    while (n < k.size())
    {
      MobileReportManager.getInstance().reportAction(((SimpleUIChoiceView.ColorItemInfo)k.get(n)).a, "4", "platform898", "4", "1", 101, 1, System.currentTimeMillis());
      ReportController.b(this.e, "dc00898", "", "", "qq_vip", "0X800B15B", Integer.decode(((SimpleUIChoiceView.ColorItemInfo)k.get(n)).a).intValue(), 0, "", "", "", "");
      ((SimpleUIChoiceView.ColorItemInfo)k.get(n)).c = false;
      n += 1;
    }
    if ((k.size() > i1) && (i1 >= 0)) {
      ((SimpleUIChoiceView.ColorItemInfo)k.get(i1)).c = true;
    }
    if (k.size() == 0) {
      a();
    }
  }
  
  public void a(URLDrawable.URLDrawableListener2 paramURLDrawableListener2)
  {
    this.l = paramURLDrawableListener2;
  }
  
  public void a(SimpleUIChoiceView.OnModeSelectListener paramOnModeSelectListener)
  {
    this.m = paramOnModeSelectListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    RecyclerView localRecyclerView = this.f;
    boolean bool = true;
    if (localRecyclerView == null) {
      return true;
    }
    float f1 = paramMotionEvent.getY();
    paramMotionEvent = new int[2];
    this.f.getLocationOnScreen(paramMotionEvent);
    if (f1 > paramMotionEvent[1])
    {
      if (f1 >= paramMotionEvent[1] + this.f.getHeight()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void b()
  {
    Object localObject1 = k;
    if (localObject1 != null) {
      try
      {
        k.clear();
        k = null;
      }
      finally {}
    }
    localObject1 = this.h;
    if (localObject1 != null) {
      ((SimpleUIChoiceView.ColorListAdapter)localObject1).a();
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("selectSimpleUIChoice bpref=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isLoading=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SimpleUIChoiceView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt >= 0)
    {
      localObject = this.h;
      if (localObject != null)
      {
        localObject = ((SimpleUIChoiceView.ColorListAdapter)localObject).a(paramInt);
        if (localObject != null)
        {
          ((SimpleUIChoiceView.ColorItemInfo)localObject).e = paramBoolean;
          this.h.a((SimpleUIChoiceView.ColorItemInfo)localObject, paramInt, true);
          this.f.scrollToPosition(paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView
 * JD-Core Version:    0.7.0.1
 */