package com.tencent.mobileqq.activity.contact.connections;

import aixh;
import aixi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import bcvy;
import bdzx;
import bgtn;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tja;
import tjf;

public class ConnectionsTabLayout
  extends TabLayoutCompat
  implements tja
{
  private ArrayList<aixh> a = new ArrayList();
  
  public ConnectionsTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConnectionsTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ConnectionsTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private URLDrawable a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    URLDrawable localURLDrawable;
    do
    {
      return localObject;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bdzx.a;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bdzx.a;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("ConnectionsTabLayout", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void a(tjf paramtjf, aixi paramaixi, aixh paramaixh)
  {
    if ((paramtjf == null) || (paramaixi == null) || (paramaixh == null)) {}
    label236:
    label246:
    for (;;)
    {
      return;
      paramtjf.a(Integer.valueOf(paramaixh.jdField_a_of_type_Int));
      paramaixi.jdField_a_of_type_AndroidWidgetTextView.setText(paramaixh.jdField_a_of_type_JavaLangString);
      paramtjf = getContext().getResources().getString(2131698112, new Object[] { Integer.valueOf(paramaixh.jdField_b_of_type_Int) });
      if (!paramaixh.jdField_a_of_type_Boolean) {
        paramtjf = getContext().getResources().getString(2131698110);
      }
      paramaixi.jdField_b_of_type_AndroidWidgetTextView.setText(paramtjf);
      paramtjf = a(paramaixh.jdField_b_of_type_JavaLangString, paramaixh.c);
      if (paramtjf != null) {
        paramaixi.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramtjf);
      }
      int i = getContext().getResources().getColor(2131167118);
      int j = Color.parseColor("#F5F6FA");
      paramtjf = a(i, j);
      if (paramtjf != null)
      {
        paramaixi.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramtjf);
        if (i == 0) {
          break label236;
        }
        paramaixi.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(i);
      }
      for (;;)
      {
        if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label246;
        }
        paramtjf = getContext().getResources().getColorStateList(2131166410);
        paramaixh = getContext().getResources().getColorStateList(2131166412);
        paramaixi.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramtjf);
        paramaixi.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaixh);
        return;
        paramaixi.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850503);
        break;
        paramaixi.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(j);
      }
    }
  }
  
  private void c()
  {
    setSelectedTabIndicatorHeight(0);
  }
  
  public int a(ArrayList<aixh> paramArrayList, int paramInt)
  {
    int k;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      k = 0;
      return k;
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      k = j;
      if (i >= paramArrayList.size()) {
        break;
      }
      if (((aixh)paramArrayList.get(i)).jdField_a_of_type_Int == paramInt) {
        j = i;
      }
      i += 1;
    }
  }
  
  public Drawable a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      localObject = null;
    }
    StateListDrawable localStateListDrawable;
    bcvy localbcvy;
    do
    {
      return localObject;
      localObject = new bcvy(paramInt1, 50, 50, bgtn.a(6.0F));
      localStateListDrawable = new StateListDrawable();
      localbcvy = new bcvy(paramInt2, 50, 50, bgtn.a(6.0F));
      if (localObject != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject);
      }
      localObject = localStateListDrawable;
    } while (localbcvy == null);
    localStateListDrawable.addState(new int[] { -16842913 }, localbcvy);
    return localStateListDrawable;
  }
  
  public Drawable a(String paramString1, String paramString2)
  {
    String str = null;
    StateListDrawable localStateListDrawable = new StateListDrawable();
    URLDrawable localURLDrawable;
    if (!TextUtils.isEmpty(paramString1))
    {
      localURLDrawable = a(paramString1);
      paramString1 = localURLDrawable;
      if (localURLDrawable != null) {
        localURLDrawable.startDownload();
      }
    }
    for (paramString1 = localURLDrawable;; paramString1 = null)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = a(paramString2);
        str = paramString2;
        if (paramString2 != null)
        {
          paramString2.startDownload();
          str = paramString2;
        }
      }
      if (paramString1 != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, paramString1);
      }
      if (str != null) {
        localStateListDrawable.addState(new int[] { -16842913 }, str);
      }
      return localStateListDrawable;
    }
  }
  
  public void a(int paramInt)
  {
    int i = b();
    if (i == paramInt) {
      if (QLog.isColorLevel()) {
        QLog.d("ConnectionsTabLayout", 2, "selectTabWithoutCallback viewPosition ->" + i + ",position =" + paramInt);
      }
    }
    tjf localtjf;
    do
    {
      return;
      localtjf = a(paramInt);
    } while (localtjf == null);
    localtjf.b();
  }
  
  public void a(ArrayList<aixh> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConnectionsTabLayout", 2, "createTab infos: null");
      }
      return;
    }
    this.a.clear();
    this.a.addAll(paramArrayList);
    a();
    a(this);
    if (this.a.size() <= 3)
    {
      setTabMode(1);
      setTabGravity(0);
    }
    int i;
    for (;;)
    {
      i = a(paramArrayList, paramInt);
      paramInt = 0;
      label82:
      if (paramInt >= this.a.size()) {
        break label182;
      }
      paramArrayList = a();
      if (paramArrayList != null) {
        break label131;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ConnectionsTabLayout", 2, "createTab newTab: null");
      return;
      setTabMode(0);
      setTabGravity(1);
    }
    label131:
    paramArrayList.a(2131561328);
    a(paramArrayList, new aixi(paramArrayList.a()), (aixh)this.a.get(paramInt));
    if (i == paramInt) {
      a(paramArrayList, true);
    }
    for (;;)
    {
      paramInt += 1;
      break label82;
      label182:
      break;
      a(paramArrayList, false);
    }
  }
  
  public void a(tjf paramtjf)
  {
    new aixi(paramtjf.a()).a();
  }
  
  public void b(ArrayList<aixh> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConnectionsTabLayout", 2, "updateTabs infos: " + paramArrayList);
      }
      return;
    }
    this.a.clear();
    this.a.addAll(paramArrayList);
    int i = paramArrayList.size();
    if (a() != i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConnectionsTabLayout", 2, "updateTabs getTabCount() != infoSize " + a() + ", infoSize =" + i);
      }
      a(paramArrayList, paramInt);
      return;
    }
    i = a(paramArrayList, paramInt);
    paramInt = 0;
    label134:
    aixi localaixi;
    if (paramInt < a())
    {
      paramArrayList = a(paramInt);
      if (paramArrayList != null)
      {
        aixh localaixh = (aixh)this.a.get(paramInt);
        localaixi = new aixi(paramArrayList.a());
        a(paramArrayList, localaixi, localaixh);
        if (i != paramInt) {
          break label209;
        }
        a(paramInt);
        localaixi.a();
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label134;
      break;
      label209:
      localaixi.b();
    }
  }
  
  public void b(tjf paramtjf)
  {
    new aixi(paramtjf.a()).b();
  }
  
  public void c(tjf paramtjf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsTabLayout
 * JD-Core Version:    0.7.0.1
 */