package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class SearchBarAssistant
  implements View.OnClickListener
{
  public static final String a = "SearchBarAssistant";
  private WeakReference<BaseActivity> b;
  private TextView c;
  private EditText d;
  private long e;
  private int f;
  
  public SearchBarAssistant(BaseActivity paramBaseActivity, int paramInt, View paramView)
  {
    this.b = new WeakReference(paramBaseActivity);
    this.f = paramInt;
    paramBaseActivity = paramView.findViewById(2131445416);
    IphoneTitleBarActivity.setLayerType(paramBaseActivity);
    paramView = paramBaseActivity.findViewById(2131429816);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.d = ((EditText)paramBaseActivity.findViewById(2131432634));
    this.c = ((TextView)paramBaseActivity.findViewById(2131448724));
    this.d.setFocusableInTouchMode(false);
    this.d.setCursorVisible(false);
    this.d.setOnClickListener(this);
    a();
  }
  
  protected void a()
  {
    if (QQTheme.isNowSimpleUI())
    {
      this.c.setTextSize(0, ViewUtils.dpToPx(14.0F));
      return;
    }
    this.c.setTextSize(0, ViewUtils.dpToPx(16.0F));
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!paramQQAppInterface.equals(SearchConfigManager.curUin))) {
      SearchConfigManager.isConfigLoaded = false;
    }
  }
  
  public void b()
  {
    this.c.setText(SearchEntryConfigManager.c());
  }
  
  public void c()
  {
    if (this.f == 1) {
      ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).resetAttribute();
    }
  }
  
  public void d()
  {
    a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131432634)
    {
      long l = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick() time stamp = ");
        localStringBuilder.append(l - this.e);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (Math.abs(l - this.e) >= 1500L)
      {
        int j = this.f;
        int i = 1;
        if (j == 2) {
          i = 2;
        }
        this.e = l;
        FrameHelperActivity.c(false);
        localObject = (BaseActivity)this.b.get();
        if (localObject != null)
        {
          UniteSearchReportController.a(null, i, 0, "0X8009D15", 0, 0, null, null);
          UniteSearchActivity.a((Activity)localObject, null, this.f, i);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.SearchBarAssistant
 * JD-Core Version:    0.7.0.1
 */