package com.tencent.mobileqq.activity.contact.connections;

import aicz;
import aida;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import bchc;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tdu;
import tdz;

public class ConnectionsTabLayout
  extends TabLayoutCompat
  implements tdu
{
  private ArrayList<aicz> a = new ArrayList();
  
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
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("ConnectionsTabLayout", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void a(tdz paramtdz, aida paramaida, aicz paramaicz)
  {
    if ((paramtdz == null) || (paramaida == null) || (paramaicz == null)) {}
    label236:
    label246:
    for (;;)
    {
      return;
      paramtdz.a(Integer.valueOf(paramaicz.jdField_a_of_type_Int));
      paramaida.jdField_a_of_type_AndroidWidgetTextView.setText(paramaicz.jdField_a_of_type_JavaLangString);
      paramtdz = getContext().getResources().getString(2131698378, new Object[] { Integer.valueOf(paramaicz.jdField_b_of_type_Int) });
      if (!paramaicz.jdField_a_of_type_Boolean) {
        paramtdz = getContext().getResources().getString(2131698376);
      }
      paramaida.jdField_b_of_type_AndroidWidgetTextView.setText(paramtdz);
      paramtdz = a(paramaicz.jdField_b_of_type_JavaLangString, paramaicz.c);
      if (paramtdz != null) {
        paramaida.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramtdz);
      }
      int i = getContext().getResources().getColor(2131167151);
      int j = Color.parseColor("#F5F6FA");
      paramtdz = a(i, j);
      if (paramtdz != null)
      {
        paramaida.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramtdz);
        if (i == 0) {
          break label236;
        }
        paramaida.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(i);
      }
      for (;;)
      {
        if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label246;
        }
        paramtdz = getContext().getResources().getColorStateList(2131166433);
        paramaicz = getContext().getResources().getColorStateList(2131166435);
        paramaida.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramtdz);
        paramaida.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaicz);
        return;
        paramaida.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850441);
        break;
        paramaida.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(j);
      }
    }
  }
  
  private void c()
  {
    setSelectedTabIndicatorHeight(0);
  }
  
  public int a(ArrayList<aicz> paramArrayList, int paramInt)
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
      if (((aicz)paramArrayList.get(i)).jdField_a_of_type_Int == paramInt) {
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
    bchc localbchc;
    do
    {
      return localObject;
      localObject = new bchc(paramInt1, 50, 50, ViewUtils.dip2px(6.0F));
      localStateListDrawable = new StateListDrawable();
      localbchc = new bchc(paramInt2, 50, 50, ViewUtils.dip2px(6.0F));
      if (localObject != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject);
      }
      localObject = localStateListDrawable;
    } while (localbchc == null);
    localStateListDrawable.addState(new int[] { -16842913 }, localbchc);
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
    tdz localtdz;
    do
    {
      return;
      localtdz = a(paramInt);
    } while (localtdz == null);
    localtdz.b();
  }
  
  public void a(ArrayList<aicz> paramArrayList, int paramInt)
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
    paramArrayList.a(2131561241);
    a(paramArrayList, new aida(paramArrayList.a()), (aicz)this.a.get(paramInt));
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
  
  public void a(tdz paramtdz)
  {
    new aida(paramtdz.a()).a();
  }
  
  public void b(ArrayList<aicz> paramArrayList, int paramInt)
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
    aida localaida;
    if (paramInt < a())
    {
      paramArrayList = a(paramInt);
      if (paramArrayList != null)
      {
        aicz localaicz = (aicz)this.a.get(paramInt);
        localaida = new aida(paramArrayList.a());
        a(paramArrayList, localaida, localaicz);
        if (i != paramInt) {
          break label209;
        }
        a(paramInt);
        localaida.a();
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label134;
      break;
      label209:
      localaida.b();
    }
  }
  
  public void b(tdz paramtdz)
  {
    new aida(paramtdz.a()).b();
  }
  
  public void c(tdz paramtdz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsTabLayout
 * JD-Core Version:    0.7.0.1
 */