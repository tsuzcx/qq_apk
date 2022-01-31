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
import bdnn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nur;
import nva;
import nvb;
import nvd;
import nve;
import nvf;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;
import xsm;

public class CustomTabView
  extends FrameLayout
{
  public int a;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new CustomTabView.1(this);
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
  
  private ImageView a(RelativeLayout paramRelativeLayout, nvb paramnvb)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      localImageView.setId(a(paramnvb.jdField_a_of_type_Int));
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramRelativeLayout.addView(localImageView);
      paramRelativeLayout = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      paramRelativeLayout.width = xsm.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout.height = xsm.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout.addRule(14);
      paramRelativeLayout.topMargin = xsm.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
      paramRelativeLayout = URLDrawable.URLDrawableOptions.obtain();
      paramRelativeLayout.mRequestHeight = xsm.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout.mRequestWidth = xsm.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout = URLDrawable.getDrawable(paramnvb.c, paramRelativeLayout);
      if (paramRelativeLayout != null) {
        localImageView.setImageDrawable(paramRelativeLayout);
      }
      return localImageView;
    }
    catch (Exception paramRelativeLayout)
    {
      QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(paramRelativeLayout));
    }
    return localImageView;
  }
  
  private ImageView a(RelativeLayout paramRelativeLayout, nvb paramnvb, ImageView paramImageView)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setId(b(paramnvb.jdField_a_of_type_Int));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView.setVisibility(8);
    paramRelativeLayout.addView(localImageView);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    paramRelativeLayout.width = -2;
    paramRelativeLayout.height = -2;
    paramRelativeLayout.addRule(1, paramImageView.getId());
    paramRelativeLayout.addRule(10);
    paramRelativeLayout.topMargin = xsm.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
    return localImageView;
  }
  
  private RelativeLayout a(nvb paramnvb)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ImageView localImageView = a(localRelativeLayout, paramnvb);
    localRelativeLayout.setOnClickListener(new nve(this, paramnvb, a(localRelativeLayout, paramnvb, localImageView), a(localRelativeLayout, paramnvb, localImageView), localImageView));
    return localRelativeLayout;
  }
  
  private TextView a(RelativeLayout paramRelativeLayout, nvb paramnvb, ImageView paramImageView)
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setTextColor(Color.parseColor(paramnvb.e));
    localTextView.setTextSize(1, xsm.a(this.jdField_a_of_type_AndroidContentContext, 3.0F));
    localTextView.setText(paramnvb.jdField_a_of_type_JavaLangString);
    paramRelativeLayout.addView(localTextView);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    paramRelativeLayout.width = -2;
    paramRelativeLayout.height = -2;
    paramRelativeLayout.addRule(3, paramImageView.getId());
    paramRelativeLayout.addRule(14);
    paramRelativeLayout.topMargin = xsm.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
    paramRelativeLayout.bottomMargin = xsm.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    return localTextView;
  }
  
  private void a()
  {
    Object localObject1 = nvd.a();
    if (localObject1 == null) {
      QLog.i("EcshopCustomTabView", 2, "[CustomTabView] ecshopConfBean is null");
    }
    nvb localnvb;
    RelativeLayout localRelativeLayout;
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        localObject1 = ((nva)localObject1).jdField_a_of_type_JavaUtilArrayList;
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
        {
          QLog.i("EcshopCustomTabView", 2, "[CustomTabView] tabConfs is null");
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
      }
      localnvb = (nvb)((Iterator)localObject1).next();
      localRelativeLayout = (RelativeLayout)findViewById(localnvb.jdField_a_of_type_Int);
    } while (localRelativeLayout == null);
    int i = 0;
    label86:
    Object localObject2;
    if (i < localRelativeLayout.getChildCount())
    {
      localObject2 = localRelativeLayout.getChildAt(i);
      if (!(localObject2 instanceof TextView)) {
        break label133;
      }
      ((TextView)localObject2).setTextColor(Color.parseColor(localnvb.e));
    }
    for (;;)
    {
      i += 1;
      break label86;
      break;
      label133:
      if ((localObject2 instanceof ImageView))
      {
        localObject2 = (ImageView)localObject2;
        if (((ImageView)localObject2).getId() == a(localnvb.jdField_a_of_type_Int))
        {
          Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = xsm.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = xsm.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
          localObject3 = URLDrawable.getDrawable(localnvb.c, (URLDrawable.URLDrawableOptions)localObject3);
          if (localObject3 != null) {
            ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
          }
        }
      }
    }
  }
  
  private void a(nvb paramnvb, TextView paramTextView, ImageView paramImageView)
  {
    this.jdField_a_of_type_Int = paramnvb.jdField_a_of_type_Int;
    paramTextView.setTextColor(Color.parseColor(paramnvb.f));
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!bdnn.a(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(this.jdField_a_of_type_JavaLangString));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_JavaLangString = paramnvb.e;
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = xsm.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = xsm.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
    paramTextView = URLDrawable.getDrawable(paramnvb.d, (URLDrawable.URLDrawableOptions)localObject);
    if (paramTextView != null) {
      paramImageView.setImageDrawable(paramTextView);
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (!bdnn.a(this.jdField_b_of_type_JavaLangString)))
    {
      localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if (paramTextView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_b_of_type_JavaLangString = paramnvb.c;
  }
  
  private boolean a(nvb paramnvb)
  {
    if (paramnvb == null) {}
    do
    {
      return false;
      if (AppSetting.a(paramnvb.g) >= 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("EcshopCustomTabView", 2, "current qq version not support this tab item");
    return false;
    if ((paramnvb.jdField_b_of_type_Int == 1) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramnvb.jdField_a_of_type_Int))))
    {
      QLog.i("EcshopCustomTabView", 2, "native tab item illegal!");
      return false;
    }
    if ((paramnvb.jdField_b_of_type_Int == 0) && ((bdnn.a(paramnvb.jdField_b_of_type_JavaLangString)) || (!paramnvb.jdField_b_of_type_JavaLangString.startsWith("http")) || (!paramnvb.jdField_b_of_type_JavaLangString.startsWith("https"))))
    {
      QLog.i("EcshopCustomTabView", 2, "web tab item illegal!");
      return false;
    }
    if ((paramnvb.jdField_b_of_type_Int == 2) && (!MiniAppLauncher.isMiniAppUrl(paramnvb.jdField_b_of_type_JavaLangString)))
    {
      QLog.i("EcshopCustomTabView", 2, "miniapp tab item illegal!");
      return false;
    }
    if ((!paramnvb.e.startsWith("#")) || (!paramnvb.f.startsWith("#")))
    {
      QLog.i("EcshopCustomTabView", 2, "tab item color hex illegal!");
      return false;
    }
    if ((bdnn.a(paramnvb.jdField_a_of_type_JavaLangString)) || (paramnvb.jdField_a_of_type_JavaLangString.trim().length() == 0))
    {
      QLog.i("EcshopCustomTabView", 2, "tab item name illegal!");
      return false;
    }
    return true;
  }
  
  private int b(int paramInt)
  {
    return paramInt * paramInt + 200;
  }
  
  private void b(nvb paramnvb, TextView paramTextView, ImageView paramImageView)
  {
    if (paramnvb == null) {
      return;
    }
    switch (paramnvb.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 0: 
      a(paramnvb, paramTextView, paramImageView);
      nur.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, paramnvb.jdField_b_of_type_JavaLangString);
      return;
    case 1: 
      if (paramnvb.jdField_a_of_type_Int == 1)
      {
        a(paramnvb, paramTextView, paramImageView);
        nur.a(this.jdField_a_of_type_AndroidContentContext, "3046055438", "QQ购物");
        return;
      }
      QLog.i("EcshopCustomTabView", 2, "can't match tabId: " + paramnvb.jdField_a_of_type_Int);
      return;
    }
    MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramnvb.jdField_b_of_type_JavaLangString, 1035, new nvf(this));
  }
  
  public void a(int paramInt)
  {
    a();
    this.jdField_a_of_type_Int = paramInt;
    nvb localnvb = nvd.a(this.jdField_a_of_type_Int);
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
          ((TextView)localObject1).setTextColor(Color.parseColor(localnvb.f));
          this.jdField_a_of_type_JavaLangString = localnvb.e;
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
              this.jdField_b_of_type_JavaLangString = localnvb.c;
              Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = xsm.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = xsm.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              localObject2 = URLDrawable.getDrawable(localnvb.d, (URLDrawable.URLDrawableOptions)localObject2);
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
        QLog.i("EcshopCustomTabView", 2, "tab_id: " + localRedPointInfo.tab_id.get() + ",red_type: " + localRedPointInfo.red_type.get() + ",red_url: " + localRedPointInfo.red_url.get());
        if ((localRedPointInfo == null) || (!localRedPointInfo.tab_id.has()) || (!localRedPointInfo.task_id.has())) {
          continue;
        }
        nur.a(null, "gouwu.tab.show", localRedPointInfo.tab_id.get() + "", NetConnInfoCenter.getServerTimeMillis() + "", localRedPointInfo.task_id.get() + "");
        if (nur.a(localRedPointInfo.tab_id.get(), localRedPointInfo.task_id.get()))
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
      QLog.i("EcshopCustomTabView", 2, "startTime: " + l1 + " endTime: " + l2 + " currentTime: " + l3);
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
            l1 = NetConnInfoCenter.getServerTime();
            l2 = this.jdField_a_of_type_Long;
            ((ImageView)localObject).postDelayed(new CustomTabView.4(this, localRedPointInfo, (ImageView)localObject, localRelativeLayout), Math.abs(localRedPointInfo.delay_second.get() * 1000 - (l1 - l2)));
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean a(nva paramnva)
  {
    if (paramnva == null) {
      return false;
    }
    ArrayList localArrayList = paramnva.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList == null) || (localArrayList.size() == 0) || (localArrayList.size() < 2))
    {
      QLog.i("EcshopCustomTabView", 2, "[initView] config is empty!");
      return false;
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    for (;;)
    {
      int i;
      try
      {
        localLinearLayout.setBackgroundColor(Color.parseColor(paramnva.jdField_a_of_type_JavaLangString));
        localLinearLayout.setOrientation(0);
        addView(localLinearLayout);
        paramnva = (FrameLayout.LayoutParams)localLinearLayout.getLayoutParams();
        if (paramnva == null) {
          break label353;
        }
        paramnva.width = -1;
        paramnva.height = -2;
      }
      catch (Throwable paramnva)
      {
        RelativeLayout localRelativeLayout;
        QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(paramnva));
        try
        {
          if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
          {
            localLinearLayout.measure(0, 0);
            paramnva = new View(this.jdField_a_of_type_AndroidContentContext);
            paramnva.setBackgroundColor(1996488704);
            removeView(paramnva);
            addView(paramnva);
            paramnva.getLayoutParams().width = -1;
            paramnva.getLayoutParams().height = localLinearLayout.getMeasuredHeight();
          }
          i = localLinearLayout.getChildCount();
          if (i >= 2)
          {
            localLinearLayout.setWeightSum(i);
            return true;
          }
        }
        catch (Throwable paramnva)
        {
          QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(paramnva));
          continue;
        }
        return false;
      }
      if (i < localArrayList.size())
      {
        paramnva = (nvb)localArrayList.get(i);
        if (a(paramnva))
        {
          nur.a(paramnva.jdField_a_of_type_Int, false);
          nur.a(null, "gouwu.tab.show", paramnva.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
          localRelativeLayout = a(paramnva);
          localLinearLayout.addView(localRelativeLayout);
          localRelativeLayout.setId(paramnva.jdField_a_of_type_Int);
          paramnva = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
          if (paramnva != null) {
            paramnva.weight = 1.0F;
          }
        }
      }
      else
      {
        label353:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView
 * JD-Core Version:    0.7.0.1
 */