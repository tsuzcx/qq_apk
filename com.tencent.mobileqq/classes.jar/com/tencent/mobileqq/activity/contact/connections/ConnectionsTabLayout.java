package com.tencent.mobileqq.activity.contact.connections;

import ajiq;
import ajir;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import bdor;
import beyq;
import bhtq;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import szu;
import szz;

public class ConnectionsTabLayout
  extends TabLayoutCompat
  implements szu
{
  private ArrayList<ajiq> a = new ArrayList();
  
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
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = beyq.a;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = beyq.a;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("ConnectionsTabLayout", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void a(szz paramszz, ajir paramajir, ajiq paramajiq)
  {
    if ((paramszz == null) || (paramajir == null) || (paramajiq == null)) {}
    label236:
    label246:
    for (;;)
    {
      return;
      paramszz.a(Integer.valueOf(paramajiq.jdField_a_of_type_Int));
      paramajir.jdField_a_of_type_AndroidWidgetTextView.setText(paramajiq.jdField_a_of_type_JavaLangString);
      paramszz = getContext().getResources().getString(2131698213, new Object[] { Integer.valueOf(paramajiq.jdField_b_of_type_Int) });
      if (!paramajiq.jdField_a_of_type_Boolean) {
        paramszz = getContext().getResources().getString(2131698211);
      }
      paramajir.jdField_b_of_type_AndroidWidgetTextView.setText(paramszz);
      paramszz = a(paramajiq.jdField_b_of_type_JavaLangString, paramajiq.c);
      if (paramszz != null) {
        paramajir.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramszz);
      }
      int i = getContext().getResources().getColor(2131167128);
      int j = Color.parseColor("#F5F6FA");
      paramszz = a(i, j);
      if (paramszz != null)
      {
        paramajir.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramszz);
        if (i == 0) {
          break label236;
        }
        paramajir.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(i);
      }
      for (;;)
      {
        if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label246;
        }
        paramszz = getContext().getResources().getColorStateList(2131166414);
        paramajiq = getContext().getResources().getColorStateList(2131166416);
        paramajir.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramszz);
        paramajir.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramajiq);
        return;
        paramajir.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850516);
        break;
        paramajir.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(j);
      }
    }
  }
  
  private void c()
  {
    setSelectedTabIndicatorHeight(0);
  }
  
  public int a(ArrayList<ajiq> paramArrayList, int paramInt)
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
      if (((ajiq)paramArrayList.get(i)).jdField_a_of_type_Int == paramInt) {
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
    bdor localbdor;
    do
    {
      return localObject;
      localObject = new bdor(paramInt1, 50, 50, bhtq.a(6.0F));
      localStateListDrawable = new StateListDrawable();
      localbdor = new bdor(paramInt2, 50, 50, bhtq.a(6.0F));
      if (localObject != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject);
      }
      localObject = localStateListDrawable;
    } while (localbdor == null);
    localStateListDrawable.addState(new int[] { -16842913 }, localbdor);
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
    szz localszz;
    do
    {
      return;
      localszz = a(paramInt);
    } while (localszz == null);
    localszz.b();
  }
  
  public void a(ArrayList<ajiq> paramArrayList, int paramInt)
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
    paramArrayList.a(2131561366);
    a(paramArrayList, new ajir(paramArrayList.a()), (ajiq)this.a.get(paramInt));
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
  
  public void a(szz paramszz)
  {
    new ajir(paramszz.a()).a();
  }
  
  public void b(ArrayList<ajiq> paramArrayList, int paramInt)
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
    ajir localajir;
    if (paramInt < a())
    {
      paramArrayList = a(paramInt);
      if (paramArrayList != null)
      {
        ajiq localajiq = (ajiq)this.a.get(paramInt);
        localajir = new ajir(paramArrayList.a());
        a(paramArrayList, localajir, localajiq);
        if (i != paramInt) {
          break label209;
        }
        a(paramInt);
        localajir.a();
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label134;
      break;
      label209:
      localajir.b();
    }
  }
  
  public void b(szz paramszz)
  {
    new ajir(paramszz.a()).b();
  }
  
  public void c(szz paramszz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsTabLayout
 * JD-Core Version:    0.7.0.1
 */