package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import belq;
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import ndn;
import nik;
import oab;
import oag;
import obz;
import ocg;
import odm;
import org.json.JSONException;
import qoe;
import qpp;
import qpu;
import qpv;
import qsb;
import rdg;
import rec;

public class ReadInJoyDailyXListView
  extends ReadInJoyXListView
  implements qsb
{
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-1);
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  public List<belq> a;
  private boolean f;
  private boolean g;
  
  public ReadInJoyDailyXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyDailyXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyDailyXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean b()
  {
    if (getAdapter() == null) {}
    while (getLastVisiblePosition() < getAdapter().getCount() - 1) {
      return false;
    }
    return true;
  }
  
  private void k()
  {
    if (this.g) {
      return;
    }
    ocg localocg = obz.a();
    String str2 = "0";
    String str1;
    if (nik.a() == 1) {
      str1 = "1";
    }
    for (;;)
    {
      localocg.b("is_jump", str1);
      localocg.b("cmd", bgmq.g());
      if ("1".equals(str1)) {
        localocg.b("jump_src", odm.b());
      }
      this.g = true;
      ndn.a(null, "", "0X8009882", "0X8009882", 0, 0, "", "", "", localocg.a(), false);
      return;
      str1 = str2;
      if (!TextUtils.isEmpty(odm.a()))
      {
        str1 = str2;
        if (nik.a() == 3) {
          str1 = "1";
        }
      }
    }
  }
  
  public int a()
  {
    return this.mTouchMode;
  }
  
  public rec a(int paramInt)
  {
    return super.a(paramInt);
  }
  
  public void a(int paramInt)
  {
    if (!this.f) {
      return;
    }
    if (paramInt != 4)
    {
      setFooterView(true);
      if (this.jdField_a_of_type_Qpp != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131652843);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.c = 1;
        this.jdField_a_of_type_Qpp.b(this, paramInt);
      }
    }
    for (;;)
    {
      QLog.d("ReadInJoyDailyXListView", 1, new Object[] { "loadingMore mCurrentStatus = ", Integer.valueOf(this.c), ", type = ", Integer.valueOf(paramInt) });
      return;
      setFooterView(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131652843);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if (this.jdField_a_of_type_Qpp != null)
      {
        this.c = 1;
        this.jdField_a_of_type_Qpp.b(this, paramInt);
      }
    }
  }
  
  public void a(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    if (paramInt1 == 0) {
      super.a(paramInt1, paramView, paramListView, paramInt2);
    }
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    setNeedShowHeaderView(true);
    a(this);
    if (nik.a() != 2)
    {
      a(this);
      return;
    }
    setCanLoadMore(true);
  }
  
  public void a(View paramView, ListView paramListView, int paramInt) {}
  
  public void a(belq parambelq)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      super.setOverScrollListener(new qpv(this));
    }
    this.jdField_a_of_type_JavaUtilList.add(parambelq);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_b_of_type_Int = 0;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.f) && (paramInt == 1))
    {
      a(2);
      return true;
    }
    if (paramInt == 0) {
      return super.a(paramInt, paramView, paramListView);
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    super.b(paramInt, paramView, paramListView);
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
  }
  
  public void c()
  {
    super.c();
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void d()
  {
    super.d();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  public void e()
  {
    super.e();
  }
  
  public void f()
  {
    QLog.d("ReadInJoyDailyXListView", 2, "scroll2TopAndRefresh : ");
  }
  
  public void g()
  {
    TemplateBean localTemplateBean = null;
    try
    {
      rdg localrdg = rdg.a("default_feeds", true);
      if (localrdg != null) {
        localTemplateBean = localrdg.getTemplateBean(odm.a());
      }
      if ((localTemplateBean != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null))
      {
        if (obz.j())
        {
          oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, null, localTemplateBean);
          return;
        }
        obz.b().post(new ReadInJoyDailyXListView.2(this, localTemplateBean));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoyDailyXListView", 1, "onRefreshFooterView, e = " + localJSONException);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.f) {
      if (b()) {
        k();
      }
    }
    while ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_Int >= 0) || (this.c == 1) || (paramInt1 < paramInt3 - paramInt2 * 2) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    a(2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      oab.a(8);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter != null) && ((paramListAdapter instanceof qoe))) {
      ((qoe)paramListAdapter).a(new qpu(this));
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(-1);
  }
  
  public void setCanLoadMore(boolean paramBoolean)
  {
    this.f = paramBoolean;
    setOverScrollTouchMode(1);
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {
      a();
    }
  }
  
  public void setChannelId(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setContentBackground(Drawable paramDrawable, boolean paramBoolean)
  {
    super.setContentBackground(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, false);
  }
  
  public void setFooterView(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean) {
      bool = this.f;
    }
    super.setFooterView(bool);
  }
  
  public void setNeedShowFootView(boolean paramBoolean) {}
  
  public void setNeedShowHeaderView(boolean paramBoolean)
  {
    super.setNeedShowHeaderView(paramBoolean);
  }
  
  public void setNoMoreData(boolean paramBoolean) {}
  
  public void setOverScrollListener(belq parambelq)
  {
    if (parambelq != null) {
      this.jdField_a_of_type_JavaUtilList.add(parambelq);
    }
  }
  
  public void setPTSFooterView(Container paramContainer)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramContainer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView
 * JD-Core Version:    0.7.0.1
 */