package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import ogu;
import ohh;
import ohi;
import ohk;
import ohm;
import ohn;
import oho;
import ohq;
import ohs;
import oht;

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
  
  private ImageView a(RelativeLayout paramRelativeLayout, ohi paramohi)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      localImageView.setId(a(paramohi.jdField_a_of_type_Int));
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramRelativeLayout.addView(localImageView);
      paramRelativeLayout = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      paramRelativeLayout.width = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout.height = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout.addRule(14);
      paramRelativeLayout.topMargin = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 4.0F);
      paramRelativeLayout = URLDrawable.URLDrawableOptions.obtain();
      paramRelativeLayout.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130850605);
      paramRelativeLayout.mRequestHeight = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout.mRequestWidth = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout = URLDrawable.getDrawable(paramohi.c, paramRelativeLayout);
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
  
  private ImageView a(RelativeLayout paramRelativeLayout, ohi paramohi, ImageView paramImageView)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setId(b(paramohi.jdField_a_of_type_Int));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView.setVisibility(8);
    paramRelativeLayout.addView(localImageView);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    paramRelativeLayout.width = -2;
    paramRelativeLayout.height = -2;
    paramRelativeLayout.addRule(1, paramImageView.getId());
    paramRelativeLayout.addRule(10);
    paramRelativeLayout.topMargin = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 2.0F);
    return localImageView;
  }
  
  private RelativeLayout a(ohi paramohi)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ImageView localImageView = a(localRelativeLayout, paramohi);
    localRelativeLayout.setOnClickListener(new ohs(this, paramohi, a(localRelativeLayout, paramohi, localImageView), a(localRelativeLayout, paramohi, localImageView), localImageView));
    return localRelativeLayout;
  }
  
  private TextView a(RelativeLayout paramRelativeLayout, ohi paramohi, ImageView paramImageView)
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setTextColor(Color.parseColor(paramohi.e));
    localTextView.setTextSize(1, UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 3.0F));
    localTextView.setText(paramohi.jdField_a_of_type_JavaLangString);
    paramRelativeLayout.addView(localTextView);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    paramRelativeLayout.width = -2;
    paramRelativeLayout.height = -2;
    paramRelativeLayout.addRule(3, paramImageView.getId());
    paramRelativeLayout.addRule(14);
    paramRelativeLayout.topMargin = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 2.0F);
    paramRelativeLayout.bottomMargin = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    return localTextView;
  }
  
  private ArrayList<ohi> a()
  {
    Object localObject = ohk.a();
    if (localObject == null)
    {
      QLog.i("EcshopCustomTabView", 2, "[CustomTabView] ecshopConfBean is null");
      localObject = new ArrayList();
    }
    ArrayList localArrayList;
    do
    {
      return localObject;
      localArrayList = ((ohh)localObject).jdField_a_of_type_JavaUtilArrayList;
      if (localArrayList == null) {
        break;
      }
      localObject = localArrayList;
    } while (!localArrayList.isEmpty());
    QLog.i("EcshopCustomTabView", 2, "[CustomTabView] tabConfs is null");
    return new ArrayList();
  }
  
  private void a(ogu paramogu, int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(paramogu.jdField_b_of_type_Int);
    if (localRelativeLayout != null)
    {
      int i = 0;
      while (i < localRelativeLayout.getChildCount())
      {
        Object localObject = localRelativeLayout.getChildAt(i);
        if ((localObject instanceof ImageView))
        {
          localObject = (ImageView)localObject;
          if (((ImageView)localObject).getId() == b(paramogu.jdField_b_of_type_Int)) {
            ((ImageView)localObject).postDelayed(new CustomTabView.4(this, paramogu, (ImageView)localObject, localRelativeLayout), paramInt);
          }
        }
        i += 1;
      }
    }
  }
  
  private void a(ohi paramohi, TextView paramTextView, ImageView paramImageView)
  {
    this.jdField_a_of_type_Int = paramohi.jdField_a_of_type_Int;
    paramTextView.setTextColor(Color.parseColor(paramohi.f));
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!StringUtil.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(this.jdField_a_of_type_JavaLangString));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_JavaLangString = paramohi.e;
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130850605);
    paramTextView = URLDrawable.getDrawable(paramohi.d, (URLDrawable.URLDrawableOptions)localObject);
    if (paramTextView != null)
    {
      if (paramTextView.getStatus() == 2) {
        paramTextView.restartDownload();
      }
      paramImageView.setImageDrawable(paramTextView);
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (!StringUtil.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if (paramTextView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_b_of_type_JavaLangString = paramohi.c;
  }
  
  private boolean a(ohi paramohi)
  {
    if (paramohi == null) {}
    do
    {
      return false;
      if (AppSetting.a(paramohi.g) >= 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("EcshopCustomTabView", 2, "current qq version not support this tab item");
    return false;
    if ((paramohi.jdField_b_of_type_Int == 1) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramohi.jdField_a_of_type_Int))))
    {
      QLog.i("EcshopCustomTabView", 2, "native tab item illegal!");
      return false;
    }
    if ((paramohi.jdField_b_of_type_Int == 0) && ((StringUtil.isEmpty(paramohi.jdField_b_of_type_JavaLangString)) || (!paramohi.jdField_b_of_type_JavaLangString.startsWith("http")) || (!paramohi.jdField_b_of_type_JavaLangString.startsWith("https"))))
    {
      QLog.i("EcshopCustomTabView", 2, "web tab item illegal!");
      return false;
    }
    if ((paramohi.jdField_b_of_type_Int == 2) && (!MiniAppLauncher.isMiniAppUrl(paramohi.jdField_b_of_type_JavaLangString)))
    {
      QLog.i("EcshopCustomTabView", 2, "miniapp tab item illegal!");
      return false;
    }
    if ((!paramohi.e.startsWith("#")) || (!paramohi.f.startsWith("#")))
    {
      QLog.i("EcshopCustomTabView", 2, "tab item color hex illegal!");
      return false;
    }
    if ((StringUtil.isEmpty(paramohi.jdField_a_of_type_JavaLangString)) || (paramohi.jdField_a_of_type_JavaLangString.trim().length() == 0))
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
  
  private void b()
  {
    Object localObject1 = a();
    if (((ArrayList)localObject1).isEmpty()) {}
    ohi localohi;
    RelativeLayout localRelativeLayout;
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext()) {
        localObject1 = ((ArrayList)localObject1).iterator();
      }
      localohi = (ohi)((Iterator)localObject1).next();
      localRelativeLayout = (RelativeLayout)findViewById(localohi.jdField_a_of_type_Int);
    } while (localRelativeLayout == null);
    int i = 0;
    label57:
    Object localObject2;
    if (i < localRelativeLayout.getChildCount())
    {
      localObject2 = localRelativeLayout.getChildAt(i);
      if (!(localObject2 instanceof TextView)) {
        break label104;
      }
      ((TextView)localObject2).setTextColor(Color.parseColor(localohi.e));
    }
    for (;;)
    {
      i += 1;
      break label57;
      break;
      label104:
      if ((localObject2 instanceof ImageView))
      {
        localObject2 = (ImageView)localObject2;
        if (((ImageView)localObject2).getId() == a(localohi.jdField_a_of_type_Int))
        {
          Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
          localObject3 = URLDrawable.getDrawable(localohi.c, (URLDrawable.URLDrawableOptions)localObject3);
          if (localObject3 != null) {
            ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
          }
        }
      }
    }
  }
  
  private void b(ohi paramohi, TextView paramTextView, ImageView paramImageView)
  {
    if (paramohi == null) {
      return;
    }
    switch (paramohi.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 0: 
      a(paramohi, paramTextView, paramImageView);
      ohn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, ohq.a(paramohi.jdField_b_of_type_JavaLangString, "tab"));
      return;
    case 1: 
      if (paramohi.jdField_a_of_type_Int == 1)
      {
        a(paramohi, paramTextView, paramImageView);
        ohn.a(this.jdField_a_of_type_AndroidContentContext, "3046055438", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691722), false);
        return;
      }
      QLog.i("EcshopCustomTabView", 2, "can't match tabId: " + paramohi.jdField_a_of_type_Int);
      return;
    }
    MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, ohq.a(paramohi.jdField_b_of_type_JavaLangString, "tab"), 1035, new oht(this));
  }
  
  public void a()
  {
    Object localObject = a();
    if (((ArrayList)localObject).isEmpty()) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      oho.b(((ohi)((Iterator)localObject).next()).jdField_a_of_type_Int);
    }
    oho.a();
  }
  
  public void a(int paramInt)
  {
    b();
    this.jdField_a_of_type_Int = paramInt;
    ohi localohi = ohk.a(this.jdField_a_of_type_Int);
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
          ((TextView)localObject1).setTextColor(Color.parseColor(localohi.f));
          this.jdField_a_of_type_JavaLangString = localohi.e;
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
              this.jdField_b_of_type_JavaLangString = localohi.c;
              Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              localObject2 = URLDrawable.getDrawable(localohi.d, (URLDrawable.URLDrawableOptions)localObject2);
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
  
  public void a(ArrayList<ogu> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ogu localogu = (ogu)paramArrayList.next();
        QLog.i("EcshopCustomTabView", 2, "tab_id: " + localogu.jdField_b_of_type_Int + ",red_type: " + localogu.f + ",red_url: " + localogu.jdField_a_of_type_JavaLangString + " task_id: " + localogu.jdField_a_of_type_Int);
        ohq.a(null, "gouwu.tab.show", localogu.jdField_b_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", localogu.jdField_a_of_type_Int + "");
        ohq.b(null, "gouwu_tab_show", localogu.jdField_b_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", localogu.jdField_a_of_type_Int + "");
        int i = localogu.jdField_a_of_type_Int;
        if ((oho.a(localogu.jdField_b_of_type_Int, i)) || (this.jdField_a_of_type_Int == localogu.jdField_b_of_type_Int) || (oho.a(this.jdField_a_of_type_Int)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("EcshopCustomTabView", 2, "tab_id: " + localogu.jdField_b_of_type_Int + " has clicked!!!");
          }
        }
        else
        {
          long l1 = localogu.c;
          long l2 = localogu.d;
          long l3 = NetConnInfoCenter.getServerTime();
          QLog.i("EcshopCustomTabView", 2, "startTime: " + l1 + " endTime: " + l2 + " currentTime: " + l3);
          if (oho.a(localogu.jdField_b_of_type_Int))
          {
            a(localogu, 0);
          }
          else if ((l1 <= l3) && (l2 >= l3))
          {
            l1 = NetConnInfoCenter.getServerTime();
            l2 = this.jdField_a_of_type_Long;
            a(localogu, (int)Math.abs(localogu.e * 1000 - (l1 - l2)));
          }
        }
      }
    }
  }
  
  public boolean a(ohh paramohh)
  {
    if (paramohh == null) {
      return false;
    }
    ArrayList localArrayList = paramohh.jdField_a_of_type_JavaUtilArrayList;
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
        localLinearLayout.setBackgroundColor(Color.parseColor(paramohh.jdField_b_of_type_JavaLangString));
        localLinearLayout.setOrientation(0);
        addView(localLinearLayout);
        paramohh = (FrameLayout.LayoutParams)localLinearLayout.getLayoutParams();
        if (paramohh == null) {
          break label408;
        }
        paramohh.width = -1;
        paramohh.height = -2;
      }
      catch (Throwable paramohh)
      {
        RelativeLayout localRelativeLayout;
        QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(paramohh));
        try
        {
          if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
          {
            localLinearLayout.measure(0, 0);
            paramohh = new View(this.jdField_a_of_type_AndroidContentContext);
            paramohh.setBackgroundColor(1996488704);
            removeView(paramohh);
            addView(paramohh);
            paramohh.getLayoutParams().width = -1;
            paramohh.getLayoutParams().height = localLinearLayout.getMeasuredHeight();
          }
          i = localLinearLayout.getChildCount();
          if (i >= 2)
          {
            localLinearLayout.setWeightSum(i);
            return true;
          }
        }
        catch (Throwable paramohh)
        {
          QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(paramohh));
          continue;
        }
        return false;
      }
      if (i < localArrayList.size())
      {
        paramohh = (ohi)localArrayList.get(i);
        if (a(paramohh))
        {
          ohm.a(paramohh.jdField_a_of_type_Int, false);
          ohq.a(null, "gouwu.tab.show", paramohh.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
          ohq.b(null, "gouwu_tab_show", paramohh.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "");
          localRelativeLayout = a(paramohh);
          localLinearLayout.addView(localRelativeLayout);
          localRelativeLayout.setId(paramohh.jdField_a_of_type_Int);
          paramohh = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
          if (paramohh != null) {
            paramohh.weight = 1.0F;
          }
        }
      }
      else
      {
        label408:
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