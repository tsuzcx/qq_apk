package com.tencent.biz.pubaccount.ecshopassit.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class CustomTitleView
  extends FrameLayout
{
  public int a;
  private long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new CustomTitleView.2(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new CustomTitleView.1(this);
  private List<EcshopConfBean.TabConfBean> jdField_a_of_type_JavaUtilList;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ArrayList<RedPointInfo> jdField_b_of_type_JavaUtilArrayList = null;
  
  public CustomTitleView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
  }
  
  public CustomTitleView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
  }
  
  private int a(int paramInt)
  {
    return paramInt * paramInt + 100;
  }
  
  private ImageView a(RelativeLayout paramRelativeLayout, EcshopConfBean.TabConfBean paramTabConfBean, TextView paramTextView)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setId(b(paramTabConfBean.jdField_a_of_type_Int));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView.setImageResource(2130847468);
    localImageView.setVisibility(8);
    int i = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramTabConfBean = new RelativeLayout.LayoutParams(i, i);
    paramTabConfBean.addRule(1, paramTextView.getId());
    paramTabConfBean.leftMargin = (-AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramRelativeLayout.addView(localImageView, paramTabConfBean);
    return localImageView;
  }
  
  private RelativeLayout a(EcshopConfBean.TabConfBean paramTabConfBean)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    TextView localTextView = a(localRelativeLayout, paramTabConfBean);
    localRelativeLayout.setOnClickListener(new CustomTitleView.3(this, paramTabConfBean, a(localRelativeLayout, paramTabConfBean, localTextView), localTextView, localRelativeLayout));
    return localRelativeLayout;
  }
  
  private TextView a(RelativeLayout paramRelativeLayout, EcshopConfBean.TabConfBean paramTabConfBean)
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setTextColor(-8618884);
    localTextView.setTextSize(17.0F);
    localTextView.setText(paramTabConfBean.jdField_a_of_type_JavaLangString);
    localTextView.setId(a(paramTabConfBean.jdField_a_of_type_Int));
    paramTabConfBean = new RelativeLayout.LayoutParams(-2, -2);
    paramTabConfBean.leftMargin = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramTabConfBean.addRule(13);
    paramRelativeLayout.addView(localTextView, paramTabConfBean);
    paramTabConfBean = new View(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 1);
    localLayoutParams.addRule(1, localTextView.getId());
    paramRelativeLayout.addView(paramTabConfBean, localLayoutParams);
    return localTextView;
  }
  
  private ArrayList<EcshopConfBean.TabConfBean> a()
  {
    Object localObject = EcshopConfUtil.a();
    if (localObject == null)
    {
      QLog.i("CustomTitleView", 2, "[CustomTabView] ecshopConfBean is null");
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
    QLog.i("CustomTitleView", 2, "[CustomTabView] tabConfs is null");
    return new ArrayList();
  }
  
  private void a(RelativeLayout paramRelativeLayout, List<EcshopConfBean.TabConfBean> paramList)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840454);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || (TextUtils.isEmpty(((AppRuntime)localObject).getAccount()))) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = ((AppRuntime)localObject).getAccount();
    if ((localObject instanceof QQAppInterface)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((QQAppInterface)localObject).getFaceDrawable(this.jdField_a_of_type_JavaLangString));
    }
    for (;;)
    {
      int i = AIOUtils.a(46.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(j, j, j, j);
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131369502);
      localObject = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131369501);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      paramRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847468);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      i = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, this.jdField_a_of_type_AndroidWidgetImageView.getId());
      ((RelativeLayout.LayoutParams)localObject).addRule(7, this.jdField_a_of_type_AndroidWidgetImageView.getId());
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new CustomTitleView.5(this, paramList));
      if (paramList.size() != 1) {
        break;
      }
      paramRelativeLayout = (EcshopConfBean.TabConfBean)paramList.get(0);
      if (!a(paramRelativeLayout)) {
        break;
      }
      ReportUtil.a(null, "gouwu.tab.show", paramRelativeLayout.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_Int);
      ReportUtil.b(null, "gouwu_tab_show", paramRelativeLayout.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_Int);
      return;
      localObject = new IntentFilter("action_decode_finish");
      try
      {
        BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
        label490:
        localObject = new Intent("action_get_PA_head");
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject);
      }
      catch (Exception localException)
      {
        break label490;
      }
    }
  }
  
  private void a(RedPointInfo paramRedPointInfo, int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(paramRedPointInfo.jdField_b_of_type_Int);
    int i;
    if (localRelativeLayout != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < localRelativeLayout.getChildCount())
      {
        Object localObject = localRelativeLayout.getChildAt(i);
        if ((localObject instanceof ImageView))
        {
          localObject = (ImageView)localObject;
          if (((ImageView)localObject).getId() == b(paramRedPointInfo.jdField_b_of_type_Int)) {
            ((ImageView)localObject).postDelayed(new CustomTitleView.9(this, paramRedPointInfo, (ImageView)localObject), paramInt);
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(EcshopConfBean.TabConfBean paramTabConfBean)
  {
    if (paramTabConfBean == null) {
      return;
    }
    switch (paramTabConfBean.jdField_b_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", ReportUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString, "tab"));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidContentContext, ReportUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString, "tab"), 1035, new CustomTitleView.7(this));
  }
  
  private void a(EcshopConfBean.TabConfBean paramTabConfBean, TextView paramTextView, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_Int = paramTabConfBean.jdField_a_of_type_Int;
    paramTextView.setTextColor(-29438);
    paramRelativeLayout.setBackgroundResource(2130847473);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8618884);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
  }
  
  private void a(EcshopConfBean.TabConfBean paramTabConfBean, RedPointInfo paramRedPointInfo)
  {
    if (paramRedPointInfo != null) {}
    try
    {
      RedPointUtil.a(paramRedPointInfo.jdField_b_of_type_Int, paramRedPointInfo.jdField_a_of_type_Int);
      a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilArrayList);
      if (paramTabConfBean != null)
      {
        ReportUtil.a(null, "gouwu.tab.click", paramTabConfBean.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_Int);
        ReportUtil.b(null, "gouwu_tab_click", paramTabConfBean.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_Int);
        QLog.d("CustomTitleView", 2, paramTabConfBean.jdField_a_of_type_JavaLangString);
        a(paramTabConfBean);
      }
      return;
    }
    catch (Throwable paramRedPointInfo)
    {
      for (;;)
      {
        QLog.e("CustomTitleView", 1, QLog.getStackTraceString(paramRedPointInfo));
      }
    }
  }
  
  private void a(List<EcshopConfBean.TabConfBean> paramList, ArrayList<RedPointInfo> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      EcshopMenuDialog.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramList, paramArrayList, new CustomTitleView.6(this)).showAsDropDown(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetImageView.getWidth() / 2 - ViewUtils.a(152.0F) / 2 - ViewUtils.a(7.0F), ViewUtils.a(2.0F));
      int i = 0;
      if (i < paramList.size())
      {
        paramArrayList = (EcshopConfBean.TabConfBean)paramList.get(i);
        if (!a(paramArrayList)) {}
        for (;;)
        {
          i += 1;
          break;
          ReportUtil.a(null, "gouwu.tab.show", paramArrayList.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_Int);
          ReportUtil.b(null, "gouwu_tab_show", paramArrayList.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_Int);
        }
      }
    }
  }
  
  private void a(List<EcshopConfBean.TabConfBean> paramList, List<RedPointInfo> paramList1)
  {
    paramList = paramList.iterator();
    int i = 0;
    EcshopConfBean.TabConfBean localTabConfBean;
    if (paramList.hasNext())
    {
      localTabConfBean = (EcshopConfBean.TabConfBean)paramList.next();
      if ((i == 0) && (paramList1 != null)) {}
    }
    else
    {
      if (i == 0) {
        break label155;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      RedPointInfo localRedPointInfo = (RedPointInfo)localIterator.next();
      if (localTabConfBean.jdField_a_of_type_Int == localRedPointInfo.jdField_b_of_type_Int)
      {
        boolean bool = RedPointUtil.a(localRedPointInfo.jdField_b_of_type_Int, localRedPointInfo.jdField_a_of_type_Int);
        long l1 = localRedPointInfo.c;
        long l2 = localRedPointInfo.d;
        long l3 = NetConnInfoCenter.getServerTime();
        if ((!bool) && (l1 <= l3) && (l2 >= l3)) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      break;
      label155:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  private boolean a(EcshopConfBean.TabConfBean paramTabConfBean)
  {
    if (paramTabConfBean == null) {
      return false;
    }
    if (AppSetting.a(paramTabConfBean.g) < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CustomTitleView", 2, "current qq version not support this tab item");
      }
      return false;
    }
    if ((paramTabConfBean.jdField_b_of_type_Int == 1) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramTabConfBean.jdField_a_of_type_Int))))
    {
      QLog.i("CustomTitleView", 2, "native tab item illegal!");
      return false;
    }
    if ((paramTabConfBean.jdField_b_of_type_Int == 0) && ((StringUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString)) || (!paramTabConfBean.jdField_b_of_type_JavaLangString.startsWith("http")) || (!paramTabConfBean.jdField_b_of_type_JavaLangString.startsWith("https"))))
    {
      QLog.i("CustomTitleView", 2, "web tab item illegal!");
      return false;
    }
    if ((paramTabConfBean.jdField_b_of_type_Int == 2) && (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramTabConfBean.jdField_b_of_type_JavaLangString)))
    {
      QLog.i("CustomTitleView", 2, "miniapp tab item illegal!");
      return false;
    }
    if ((!paramTabConfBean.e.startsWith("#")) || (!paramTabConfBean.f.startsWith("#")))
    {
      QLog.i("CustomTitleView", 2, "tab item color hex illegal!");
      return false;
    }
    if ((StringUtil.a(paramTabConfBean.jdField_a_of_type_JavaLangString)) || (paramTabConfBean.jdField_a_of_type_JavaLangString.trim().length() == 0))
    {
      QLog.i("CustomTitleView", 2, "tab item name illegal!");
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
    Object localObject = a();
    if (((ArrayList)localObject).isEmpty()) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    label18:
    label99:
    for (;;)
    {
      RelativeLayout localRelativeLayout;
      int i;
      if (((Iterator)localObject).hasNext())
      {
        localRelativeLayout = (RelativeLayout)findViewById(((EcshopConfBean.TabConfBean)((Iterator)localObject).next()).jdField_a_of_type_Int);
        if (localRelativeLayout != null) {
          i = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (i >= localRelativeLayout.getChildCount()) {
            break label99;
          }
          View localView = localRelativeLayout.getChildAt(i);
          if ((localView instanceof TextView))
          {
            ((TextView)localView).setTextColor(-8618884);
            localRelativeLayout.setBackgroundDrawable(null);
            break label18;
            break;
          }
          i += 1;
        }
      }
    }
  }
  
  private void b(EcshopConfBean.TabConfBean paramTabConfBean, TextView paramTextView, RelativeLayout paramRelativeLayout)
  {
    if (paramTabConfBean == null) {
      return;
    }
    switch (paramTabConfBean.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 0: 
      a(paramTabConfBean, paramTextView, paramRelativeLayout);
      JumpUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, ReportUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString, "tab"));
      return;
    case 1: 
      if (paramTabConfBean.jdField_a_of_type_Int == 1)
      {
        a(paramTabConfBean, paramTextView, paramRelativeLayout);
        JumpUtil.a(this.jdField_a_of_type_AndroidContentContext, "3046055438", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691928), false);
        return;
      }
      QLog.i("CustomTitleView", 2, "can't match tabId: " + paramTabConfBean.jdField_a_of_type_Int);
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidContentContext, ReportUtil.a(paramTabConfBean.jdField_b_of_type_JavaLangString, "tab"), 1035, new CustomTitleView.8(this));
  }
  
  public void a()
  {
    Object localObject = a();
    if (((ArrayList)localObject).isEmpty()) {}
    do
    {
      return;
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        RedPointUtil.b(((EcshopConfBean.TabConfBean)((Iterator)localObject).next()).jdField_a_of_type_Int);
      }
      RedPointUtil.a();
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while ((localObject == null) || ((localObject instanceof QQAppInterface)));
    BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void a(int paramInt)
  {
    b();
    this.jdField_a_of_type_Int = paramInt;
    EcshopConfUtil.a(this.jdField_a_of_type_Int);
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(paramInt);
    if (localRelativeLayout != null) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < localRelativeLayout.getChildCount())
      {
        Object localObject = localRelativeLayout.getChildAt(paramInt);
        if ((localObject instanceof TextView))
        {
          localObject = (TextView)localObject;
          ((TextView)localObject).setTextColor(-29438);
          localRelativeLayout.setBackgroundResource(2130847473);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
        }
      }
      else
      {
        return;
      }
      paramInt += 1;
    }
  }
  
  public void a(ArrayList<RedPointInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      RedPointInfo localRedPointInfo = (RedPointInfo)paramArrayList.next();
      QLog.i("CustomTitleView", 2, "tab_id: " + localRedPointInfo.jdField_b_of_type_Int + ",red_type: " + localRedPointInfo.f + ",red_url: " + localRedPointInfo.jdField_a_of_type_JavaLangString + " task_id: " + localRedPointInfo.jdField_a_of_type_Int);
      ReportUtil.a(null, "gouwu.tab.show", localRedPointInfo.jdField_b_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", localRedPointInfo.jdField_a_of_type_Int + "", this.jdField_a_of_type_Int);
      ReportUtil.b(null, "gouwu_tab_show", localRedPointInfo.jdField_b_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", localRedPointInfo.jdField_a_of_type_Int + "", this.jdField_a_of_type_Int);
      int i = localRedPointInfo.jdField_a_of_type_Int;
      if ((RedPointUtil.a(localRedPointInfo.jdField_b_of_type_Int, i)) || (this.jdField_a_of_type_Int == localRedPointInfo.jdField_b_of_type_Int) || (RedPointUtil.a(this.jdField_a_of_type_Int)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CustomTitleView", 2, "tab_id: " + localRedPointInfo.jdField_b_of_type_Int + " has clicked!!!");
        }
      }
      else
      {
        long l1 = localRedPointInfo.c;
        long l2 = localRedPointInfo.d;
        long l3 = NetConnInfoCenter.getServerTime();
        QLog.i("CustomTitleView", 2, "startTime: " + l1 + " endTime: " + l2 + " currentTime: " + l3);
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
    a(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilArrayList);
  }
  
  public boolean a(EcshopConfBean paramEcshopConfBean, int paramInt)
  {
    if (paramEcshopConfBean == null) {
      return false;
    }
    this.jdField_a_of_type_Int = paramInt;
    ArrayList localArrayList = paramEcshopConfBean.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      QLog.i("CustomTitleView", 2, "[initView] config is empty!");
      return false;
    }
    RelativeLayout localRelativeLayout1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    for (;;)
    {
      try
      {
        localRelativeLayout1.setBackgroundColor(Color.parseColor(paramEcshopConfBean.jdField_b_of_type_JavaLangString));
        addView(localRelativeLayout1, new RelativeLayout.LayoutParams(-1, -2));
        localRelativeLayout1.setOnClickListener(new CustomTitleView.4(this));
        paramInt = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramEcshopConfBean = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramEcshopConfBean.setId(2131369878);
        paramEcshopConfBean.setImageResource(2130843416);
        paramEcshopConfBean.setPadding(paramInt, paramInt, paramInt, paramInt);
        Object localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        localRelativeLayout1.addView(paramEcshopConfBean, (ViewGroup.LayoutParams)localObject);
        paramEcshopConfBean = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramEcshopConfBean.setId(2131369501);
        paramEcshopConfBean.setImageResource(2130840629);
        paramEcshopConfBean.setPadding(paramInt, paramInt, paramInt, paramInt);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        localRelativeLayout1.addView(paramEcshopConfBean, (ViewGroup.LayoutParams)localObject);
        paramEcshopConfBean = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramEcshopConfBean.setOrientation(0);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        localRelativeLayout1.addView(paramEcshopConfBean, (ViewGroup.LayoutParams)localObject);
        paramInt = 0;
        if ((paramInt < localArrayList.size()) && (paramInt < 2))
        {
          localObject = (EcshopConfBean.TabConfBean)localArrayList.get(paramInt);
          if (!a((EcshopConfBean.TabConfBean)localObject)) {
            break label667;
          }
          EcshopUtils.a(((EcshopConfBean.TabConfBean)localObject).jdField_a_of_type_Int, false);
          ReportUtil.a(null, "gouwu.tab.show", ((EcshopConfBean.TabConfBean)localObject).jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_Int);
          ReportUtil.b(null, "gouwu_tab_show", ((EcshopConfBean.TabConfBean)localObject).jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", "", this.jdField_a_of_type_Int);
          RelativeLayout localRelativeLayout2 = a((EcshopConfBean.TabConfBean)localObject);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.gravity = 16;
          if (paramInt != 0) {
            localLayoutParams.leftMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          }
          paramEcshopConfBean.addView(localRelativeLayout2, localLayoutParams);
          localRelativeLayout2.setId(((EcshopConfBean.TabConfBean)localObject).jdField_a_of_type_Int);
        }
      }
      catch (Throwable paramEcshopConfBean)
      {
        QLog.e("CustomTitleView", 1, QLog.getStackTraceString(paramEcshopConfBean));
      }
      try
      {
        for (;;)
        {
          if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
          {
            localRelativeLayout1.measure(0, 0);
            paramEcshopConfBean = new View(this.jdField_a_of_type_AndroidContentContext);
            paramEcshopConfBean.setBackgroundColor(1996488704);
            removeView(paramEcshopConfBean);
            addView(paramEcshopConfBean);
            paramEcshopConfBean.getLayoutParams().width = -1;
            paramEcshopConfBean.getLayoutParams().height = localRelativeLayout1.getMeasuredHeight();
          }
          return true;
          if (localArrayList.size() > 2)
          {
            this.jdField_a_of_type_JavaUtilList = localArrayList.subList(2, localArrayList.size());
            a(localRelativeLayout1, this.jdField_a_of_type_JavaUtilList);
          }
          paramEcshopConfBean.setWeightSum(paramEcshopConfBean.getChildCount());
        }
      }
      catch (Throwable paramEcshopConfBean)
      {
        for (;;)
        {
          QLog.e("CustomTitleView", 1, QLog.getStackTraceString(paramEcshopConfBean));
        }
      }
      label667:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.CustomTitleView
 * JD-Core Version:    0.7.0.1
 */