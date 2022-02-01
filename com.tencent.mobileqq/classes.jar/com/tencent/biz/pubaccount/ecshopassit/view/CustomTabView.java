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
import com.tencent.biz.pubaccount.ecshopassit.RedPointInfo;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean.TabConfBean;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils;
import com.tencent.biz.pubaccount.ecshopassit.utils.JumpUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.RedPointUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.ReportUtil;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

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
  
  private ImageView a(RelativeLayout paramRelativeLayout, EcshopConfBean.TabConfBean paramTabConfBean)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      localImageView.setId(a(paramTabConfBean.jdField_a_of_type_Int));
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramRelativeLayout.addView(localImageView);
      paramRelativeLayout = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      paramRelativeLayout.width = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout.height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout.addRule(14);
      paramRelativeLayout.topMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
      paramRelativeLayout = URLDrawable.URLDrawableOptions.obtain();
      paramRelativeLayout.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130851162);
      paramRelativeLayout.mRequestHeight = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout.mRequestWidth = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
      paramRelativeLayout = URLDrawable.getDrawable(paramTabConfBean.c, paramRelativeLayout);
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
  
  private ImageView a(RelativeLayout paramRelativeLayout, EcshopConfBean.TabConfBean paramTabConfBean, ImageView paramImageView)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setId(b(paramTabConfBean.jdField_a_of_type_Int));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView.setVisibility(8);
    paramRelativeLayout.addView(localImageView);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    paramRelativeLayout.width = -2;
    paramRelativeLayout.height = -2;
    paramRelativeLayout.addRule(1, paramImageView.getId());
    paramRelativeLayout.addRule(10);
    paramRelativeLayout.topMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
    return localImageView;
  }
  
  private RelativeLayout a(EcshopConfBean.TabConfBean paramTabConfBean)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ImageView localImageView = a(localRelativeLayout, paramTabConfBean);
    localRelativeLayout.setOnClickListener(new CustomTabView.2(this, paramTabConfBean, a(localRelativeLayout, paramTabConfBean, localImageView), a(localRelativeLayout, paramTabConfBean, localImageView), localImageView));
    return localRelativeLayout;
  }
  
  private TextView a(RelativeLayout paramRelativeLayout, EcshopConfBean.TabConfBean paramTabConfBean, ImageView paramImageView)
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setTextColor(Color.parseColor(paramTabConfBean.e));
    localTextView.setTextSize(1, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 3.0F));
    localTextView.setText(paramTabConfBean.jdField_a_of_type_JavaLangString);
    paramRelativeLayout.addView(localTextView);
    paramRelativeLayout = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    paramRelativeLayout.width = -2;
    paramRelativeLayout.height = -2;
    paramRelativeLayout.addRule(3, paramImageView.getId());
    paramRelativeLayout.addRule(14);
    paramRelativeLayout.topMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
    paramRelativeLayout.bottomMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    return localTextView;
  }
  
  private ArrayList<EcshopConfBean.TabConfBean> a()
  {
    Object localObject = EcshopConfUtil.a();
    if (localObject == null)
    {
      QLog.i("EcshopCustomTabView", 2, "[CustomTabView] ecshopConfBean is null");
      localObject = new ArrayList();
    }
    ArrayList localArrayList;
    do
    {
      return localObject;
      localArrayList = ((EcshopConfBean)localObject).jdField_a_of_type_JavaUtilArrayList;
      if (localArrayList == null) {
        break;
      }
      localObject = localArrayList;
    } while (!localArrayList.isEmpty());
    QLog.i("EcshopCustomTabView", 2, "[CustomTabView] tabConfs is null");
    return new ArrayList();
  }
  
  private void a(RedPointInfo paramRedPointInfo, int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(paramRedPointInfo.jdField_b_of_type_Int);
    if (localRelativeLayout != null)
    {
      int i = 0;
      while (i < localRelativeLayout.getChildCount())
      {
        Object localObject = localRelativeLayout.getChildAt(i);
        if ((localObject instanceof ImageView))
        {
          localObject = (ImageView)localObject;
          if (((ImageView)localObject).getId() == b(paramRedPointInfo.jdField_b_of_type_Int)) {
            ((ImageView)localObject).postDelayed(new CustomTabView.4(this, paramRedPointInfo, (ImageView)localObject, localRelativeLayout), paramInt);
          }
        }
        i += 1;
      }
    }
  }
  
  private void a(EcshopConfBean.TabConfBean paramTabConfBean, TextView paramTextView, ImageView paramImageView)
  {
    this.jdField_a_of_type_Int = paramTabConfBean.jdField_a_of_type_Int;
    paramTextView.setTextColor(Color.parseColor(paramTabConfBean.f));
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(this.jdField_a_of_type_JavaLangString));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_JavaLangString = paramTabConfBean.e;
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130851162);
    paramTextView = URLDrawable.getDrawable(paramTabConfBean.d, (URLDrawable.URLDrawableOptions)localObject);
    if (paramTextView != null)
    {
      if (paramTextView.getStatus() == 2) {
        paramTextView.restartDownload();
      }
      paramImageView.setImageDrawable(paramTextView);
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (!StringUtil.a(this.jdField_b_of_type_JavaLangString)))
    {
      localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if (paramTextView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_b_of_type_JavaLangString = paramTabConfBean.c;
  }
  
  private boolean a(EcshopConfBean.TabConfBean paramTabConfBean)
  {
    if (paramTabConfBean == null) {
      return false;
    }
    if (AppSetting.a(paramTabConfBean.g) < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EcshopCustomTabView", 2, "current qq version not support this tab item");
      }
      return false;
    }
    if ((paramTabConfBean.jdField_b_of_type_Int == 1) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramTabConfBean.jdField_a_of_type_Int))))
    {
      QLog.i("EcshopCustomTabView", 2, "native tab item illegal!");
      return false;
    }
    if ((paramTabConfBean.jdField_b_of_type_Int == 0) && ((StringUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString)) || (!paramTabConfBean.jdField_b_of_type_JavaLangString.startsWith("http")) || (!paramTabConfBean.jdField_b_of_type_JavaLangString.startsWith("https"))))
    {
      QLog.i("EcshopCustomTabView", 2, "web tab item illegal!");
      return false;
    }
    if ((paramTabConfBean.jdField_b_of_type_Int == 2) && (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramTabConfBean.jdField_b_of_type_JavaLangString)))
    {
      QLog.i("EcshopCustomTabView", 2, "miniapp tab item illegal!");
      return false;
    }
    if ((!paramTabConfBean.e.startsWith("#")) || (!paramTabConfBean.f.startsWith("#")))
    {
      QLog.i("EcshopCustomTabView", 2, "tab item color hex illegal!");
      return false;
    }
    if ((StringUtil.a(paramTabConfBean.jdField_a_of_type_JavaLangString)) || (paramTabConfBean.jdField_a_of_type_JavaLangString.trim().length() == 0))
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
    EcshopConfBean.TabConfBean localTabConfBean;
    RelativeLayout localRelativeLayout;
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext()) {
        localObject1 = ((ArrayList)localObject1).iterator();
      }
      localTabConfBean = (EcshopConfBean.TabConfBean)((Iterator)localObject1).next();
      localRelativeLayout = (RelativeLayout)findViewById(localTabConfBean.jdField_a_of_type_Int);
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
      ((TextView)localObject2).setTextColor(Color.parseColor(localTabConfBean.e));
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
        if (((ImageView)localObject2).getId() == a(localTabConfBean.jdField_a_of_type_Int))
        {
          Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
          localObject3 = URLDrawable.getDrawable(localTabConfBean.c, (URLDrawable.URLDrawableOptions)localObject3);
          if (localObject3 != null) {
            ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
          }
        }
      }
    }
  }
  
  private void b(EcshopConfBean.TabConfBean paramTabConfBean, TextView paramTextView, ImageView paramImageView)
  {
    if (paramTabConfBean == null) {
      return;
    }
    switch (paramTabConfBean.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 0: 
      a(paramTabConfBean, paramTextView, paramImageView);
      JumpUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, ReportUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString, "tab"));
      return;
    case 1: 
      if (paramTabConfBean.jdField_a_of_type_Int == 1)
      {
        a(paramTabConfBean, paramTextView, paramImageView);
        JumpUtil.a(this.jdField_a_of_type_AndroidContentContext, "3046055438", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691928), false);
        return;
      }
      QLog.i("EcshopCustomTabView", 2, "can't match tabId: " + paramTabConfBean.jdField_a_of_type_Int);
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidContentContext, ReportUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString, "tab"), 1035, new CustomTabView.3(this));
  }
  
  public void a()
  {
    Object localObject = a();
    if (((ArrayList)localObject).isEmpty()) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      RedPointUtil.b(((EcshopConfBean.TabConfBean)((Iterator)localObject).next()).jdField_a_of_type_Int);
    }
    RedPointUtil.a();
  }
  
  public void a(int paramInt)
  {
    b();
    this.jdField_a_of_type_Int = paramInt;
    EcshopConfBean.TabConfBean localTabConfBean = EcshopConfUtil.a(this.jdField_a_of_type_Int);
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
          ((TextView)localObject1).setTextColor(Color.parseColor(localTabConfBean.f));
          this.jdField_a_of_type_JavaLangString = localTabConfBean.e;
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
              this.jdField_b_of_type_JavaLangString = localTabConfBean.c;
              Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              localObject2 = URLDrawable.getDrawable(localTabConfBean.d, (URLDrawable.URLDrawableOptions)localObject2);
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
  
  public void a(ArrayList<RedPointInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        RedPointInfo localRedPointInfo = (RedPointInfo)paramArrayList.next();
        QLog.i("EcshopCustomTabView", 2, "tab_id: " + localRedPointInfo.jdField_b_of_type_Int + ",red_type: " + localRedPointInfo.f + ",red_url: " + localRedPointInfo.jdField_a_of_type_JavaLangString + " task_id: " + localRedPointInfo.jdField_a_of_type_Int);
        ReportUtil.a(null, "gouwu.tab.show", localRedPointInfo.jdField_b_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", localRedPointInfo.jdField_a_of_type_Int + "", this.jdField_a_of_type_Int);
        ReportUtil.b(null, "gouwu_tab_show", localRedPointInfo.jdField_b_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", localRedPointInfo.jdField_a_of_type_Int + "", this.jdField_a_of_type_Int);
        int i = localRedPointInfo.jdField_a_of_type_Int;
        if ((RedPointUtil.a(localRedPointInfo.jdField_b_of_type_Int, i)) || (this.jdField_a_of_type_Int == localRedPointInfo.jdField_b_of_type_Int) || (RedPointUtil.a(this.jdField_a_of_type_Int)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("EcshopCustomTabView", 2, "tab_id: " + localRedPointInfo.jdField_b_of_type_Int + " has clicked!!!");
          }
        }
        else
        {
          long l1 = localRedPointInfo.c;
          long l2 = localRedPointInfo.d;
          long l3 = NetConnInfoCenter.getServerTime();
          QLog.i("EcshopCustomTabView", 2, "startTime: " + l1 + " endTime: " + l2 + " currentTime: " + l3);
          if (RedPointUtil.a(localRedPointInfo.jdField_b_of_type_Int))
          {
            a(localRedPointInfo, 0);
          }
          else if ((l1 <= l3) && (l2 >= l3))
          {
            l1 = NetConnInfoCenter.getServerTime();
            l2 = this.jdField_a_of_type_Long;
            a(localRedPointInfo, (int)Math.abs(localRedPointInfo.e * 1000 - (l1 - l2)));
          }
        }
      }
    }
  }
  
  public boolean a(EcshopConfBean paramEcshopConfBean, int paramInt)
  {
    if (paramEcshopConfBean == null) {
      return false;
    }
    this.jdField_a_of_type_Int = paramInt;
    ArrayList localArrayList = paramEcshopConfBean.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList == null) || (localArrayList.size() == 0) || (localArrayList.size() < 2))
    {
      QLog.i("EcshopCustomTabView", 2, "[initView] config is empty!");
      return false;
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    for (;;)
    {
      try
      {
        localLinearLayout.setBackgroundColor(Color.parseColor(paramEcshopConfBean.jdField_b_of_type_JavaLangString));
        localLinearLayout.setOrientation(0);
        addView(localLinearLayout);
        paramEcshopConfBean = (FrameLayout.LayoutParams)localLinearLayout.getLayoutParams();
        if (paramEcshopConfBean == null) {
          break label421;
        }
        paramEcshopConfBean.width = -1;
        paramEcshopConfBean.height = -2;
      }
      catch (Throwable paramEcshopConfBean)
      {
        RelativeLayout localRelativeLayout;
        QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(paramEcshopConfBean));
        try
        {
          if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
          {
            localLinearLayout.measure(0, 0);
            paramEcshopConfBean = new View(this.jdField_a_of_type_AndroidContentContext);
            paramEcshopConfBean.setBackgroundColor(1996488704);
            removeView(paramEcshopConfBean);
            addView(paramEcshopConfBean);
            paramEcshopConfBean.getLayoutParams().width = -1;
            paramEcshopConfBean.getLayoutParams().height = localLinearLayout.getMeasuredHeight();
          }
          paramInt = localLinearLayout.getChildCount();
          if (paramInt >= 2)
          {
            localLinearLayout.setWeightSum(paramInt);
            return true;
          }
        }
        catch (Throwable paramEcshopConfBean)
        {
          QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(paramEcshopConfBean));
          continue;
        }
        return false;
      }
      if (paramInt < localArrayList.size())
      {
        paramEcshopConfBean = (EcshopConfBean.TabConfBean)localArrayList.get(paramInt);
        if (a(paramEcshopConfBean))
        {
          EcshopUtils.a(paramEcshopConfBean.jdField_a_of_type_Int, false);
          ReportUtil.a(null, "gouwu.tab.show", paramEcshopConfBean.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_Int);
          ReportUtil.b(null, "gouwu_tab_show", paramEcshopConfBean.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_Int);
          localRelativeLayout = a(paramEcshopConfBean);
          localLinearLayout.addView(localRelativeLayout);
          localRelativeLayout.setId(paramEcshopConfBean.jdField_a_of_type_Int);
          paramEcshopConfBean = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
          if (paramEcshopConfBean != null) {
            paramEcshopConfBean.weight = 1.0F;
          }
        }
      }
      else
      {
        label421:
        paramInt = 0;
        continue;
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView
 * JD-Core Version:    0.7.0.1
 */