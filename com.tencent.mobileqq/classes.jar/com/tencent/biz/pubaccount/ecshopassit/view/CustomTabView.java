package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nrh;
import nrq;
import nrr;
import nrt;
import nru;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;
import vzl;

public class CustomTabView
  extends FrameLayout
{
  public int a;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public CustomTabView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
  }
  
  public CustomTabView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
  }
  
  private int a(int paramInt)
  {
    return paramInt * paramInt + 100;
  }
  
  private int b(int paramInt)
  {
    return paramInt * paramInt + 200;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    nrr localnrr = nrt.a(this.jdField_a_of_type_Int);
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(paramInt);
    if (localRelativeLayout != null)
    {
      paramInt = 0;
      if (paramInt < localRelativeLayout.getChildCount())
      {
        Object localObject1 = localRelativeLayout.getChildAt(paramInt);
        if ((localObject1 instanceof TextView))
        {
          localObject1 = (TextView)localObject1;
          ((TextView)localObject1).setTextColor(Color.parseColor(localnrr.f));
          this.jdField_a_of_type_JavaLangString = localnrr.e;
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if ((localObject1 instanceof ImageView))
          {
            localObject1 = (ImageView)localObject1;
            if (((ImageView)localObject1).getId() == a(this.jdField_a_of_type_Int))
            {
              this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
              this.b = localnrr.c;
              Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = vzl.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = vzl.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              localObject2 = URLDrawable.getDrawable(localnrr.d, (URLDrawable.URLDrawableOptions)localObject2);
              if (localObject2 != null) {
                ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView.getParent() == null) {}
    do
    {
      return;
      if ((paramView instanceof ViewGroup)) {
        ((ViewGroup)paramView).setClipChildren(false);
      }
    } while (!(paramView.getParent() instanceof View));
    a((View)paramView.getParent());
  }
  
  public void a(List<qq_ad.QQAdGetRsp.RedPointInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      label13:
      return;
      break label21;
    }
    else
    {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      label21:
      qq_ad.QQAdGetRsp.RedPointInfo localRedPointInfo;
      if (paramList.hasNext())
      {
        localRedPointInfo = (qq_ad.QQAdGetRsp.RedPointInfo)paramList.next();
        if (QLog.isColorLevel()) {
          QLog.i("EcshopCustomTabView", 2, "tab_id: " + localRedPointInfo.tab_id.get() + ",red_type: " + localRedPointInfo.red_type.get() + ",red_url: " + localRedPointInfo.red_url.get());
        }
        if ((localRedPointInfo == null) || (!localRedPointInfo.tab_id.has()) || (!localRedPointInfo.task_id.has())) {
          continue;
        }
        if (nrh.a(localRedPointInfo.tab_id.get(), localRedPointInfo.task_id.get()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("EcshopCustomTabView", 2, "tab_id: " + localRedPointInfo.tab_id.get() + " has clicked!!!");
        }
      }
      else
      {
        break label13;
      }
      if ((!localRedPointInfo.begin_time.has()) || (!localRedPointInfo.delay_second.has()) || (!localRedPointInfo.end_time.has())) {
        break;
      }
      long l1 = localRedPointInfo.begin_time.get();
      long l2 = localRedPointInfo.end_time.get();
      long l3 = NetConnInfoCenter.getServerTime();
      if (QLog.isColorLevel()) {
        QLog.i("EcshopCustomTabView", 2, "startTime: " + l1 + " endTime: " + l2 + " currentTime: " + l3);
      }
      if ((l1 > l3) || (l2 < l3)) {
        break;
      }
      RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(localRedPointInfo.tab_id.get());
      if (localRelativeLayout == null) {
        break;
      }
      int i = 0;
      while (i < localRelativeLayout.getChildCount())
      {
        Object localObject = localRelativeLayout.getChildAt(i);
        if ((localObject instanceof ImageView))
        {
          localObject = (ImageView)localObject;
          if (((ImageView)localObject).getId() == b(localRedPointInfo.tab_id.get()))
          {
            l1 = NetConnInfoCenter.getServerTime() - this.jdField_a_of_type_Long;
            if (QLog.isColorLevel()) {
              QLog.i("EcshopCustomTabView", 2, "hasEnterTs: " + l1);
            }
            ((ImageView)localObject).postDelayed(new CustomTabView.2(this, localRedPointInfo, (ImageView)localObject, localRelativeLayout), localRedPointInfo.delay_second.get() * 1000 - l1);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(nrq paramnrq)
  {
    if (paramnrq == null) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = paramnrq.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList == null) || (localArrayList.size() == 0) || (localArrayList.size() < 2))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("EcshopCustomTabView", 2, "[initView] config is empty!");
        return;
      }
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      try
      {
        localLinearLayout.setBackgroundColor(Color.parseColor(paramnrq.jdField_a_of_type_JavaLangString));
        localLinearLayout.setOrientation(0);
        localLinearLayout.setWeightSum(localArrayList.size());
        addView(localLinearLayout);
        paramnrq = (FrameLayout.LayoutParams)localLinearLayout.getLayoutParams();
        if (paramnrq != null)
        {
          paramnrq.width = -1;
          paramnrq.height = -2;
          break label680;
          for (;;)
          {
            if (i >= localArrayList.size()) {
              break label609;
            }
            paramnrq = (nrr)localArrayList.get(i);
            RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
            localRelativeLayout.setId(paramnrq.jdField_a_of_type_Int);
            localLinearLayout.addView(localRelativeLayout);
            ((LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams()).weight = 1.0F;
            ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            try
            {
              localImageView.setId(a(paramnrq.jdField_a_of_type_Int));
              localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
              localRelativeLayout.addView(localImageView);
              localObject1 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).width = vzl.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              ((RelativeLayout.LayoutParams)localObject1).height = vzl.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              ((RelativeLayout.LayoutParams)localObject1).addRule(14);
              ((RelativeLayout.LayoutParams)localObject1).topMargin = vzl.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
              localObject1 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = vzl.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = vzl.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              localObject1 = URLDrawable.getDrawable(paramnrq.c, (URLDrawable.URLDrawableOptions)localObject1);
              if (localObject1 != null) {
                localImageView.setImageDrawable((Drawable)localObject1);
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Object localObject1;
                Object localObject2;
                RelativeLayout.LayoutParams localLayoutParams;
                QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(localException));
              }
            }
            localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject1).setId(b(paramnrq.jdField_a_of_type_Int));
            ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
            ((ImageView)localObject1).setVisibility(8);
            localRelativeLayout.addView((View)localObject1);
            localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).width = -2;
            ((RelativeLayout.LayoutParams)localObject2).height = -2;
            ((RelativeLayout.LayoutParams)localObject2).addRule(1, localImageView.getId());
            ((RelativeLayout.LayoutParams)localObject2).addRule(10);
            ((RelativeLayout.LayoutParams)localObject2).topMargin = vzl.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
            localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
            ((TextView)localObject2).setTextColor(Color.parseColor(paramnrq.e));
            ((TextView)localObject2).setTextSize(1, vzl.a(this.jdField_a_of_type_AndroidContentContext, 3.0F));
            ((TextView)localObject2).setText(paramnrq.jdField_a_of_type_JavaLangString);
            localRelativeLayout.addView((View)localObject2);
            localLayoutParams = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
            localLayoutParams.width = -2;
            localLayoutParams.height = -2;
            localLayoutParams.addRule(3, localImageView.getId());
            localLayoutParams.addRule(14);
            localLayoutParams.topMargin = vzl.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
            localLayoutParams.bottomMargin = vzl.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
            localRelativeLayout.setOnClickListener(new nru(this, paramnrq, (ImageView)localObject1, (TextView)localObject2, localImageView));
            i += 1;
          }
        }
      }
      catch (Exception paramnrq)
      {
        for (;;)
        {
          try
          {
            label609:
            if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
              break;
            }
            localLinearLayout.measure(0, 0);
            paramnrq = new View(this.jdField_a_of_type_AndroidContentContext);
            paramnrq.setBackgroundColor(1996488704);
            removeView(paramnrq);
            addView(paramnrq);
            paramnrq.getLayoutParams().width = -1;
            paramnrq.getLayoutParams().height = localLinearLayout.getMeasuredHeight();
            return;
          }
          catch (Exception paramnrq)
          {
            return;
          }
          label680:
          int i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView
 * JD-Core Version:    0.7.0.1
 */