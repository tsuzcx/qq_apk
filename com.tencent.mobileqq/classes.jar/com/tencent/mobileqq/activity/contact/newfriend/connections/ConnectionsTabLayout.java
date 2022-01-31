package com.tencent.mobileqq.activity.contact.newfriend.connections;

import ahnq;
import ahnr;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import azuy;
import bayu;
import bdoo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import skj;
import sko;

public class ConnectionsTabLayout
  extends TabLayoutCompat
  implements skj
{
  private ArrayList<ahnq> a = new ArrayList();
  
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
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bayu.a;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bayu.a;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("ConnectionsTabLayout", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void a(sko paramsko, ahnr paramahnr, ahnq paramahnq)
  {
    if ((paramsko == null) || (paramahnr == null) || (paramahnq == null)) {}
    label236:
    label246:
    for (;;)
    {
      return;
      paramsko.a(Integer.valueOf(paramahnq.jdField_a_of_type_Int));
      paramahnr.jdField_a_of_type_AndroidWidgetTextView.setText(paramahnq.jdField_a_of_type_JavaLangString);
      paramsko = getContext().getResources().getString(2131699575, new Object[] { Integer.valueOf(paramahnq.jdField_b_of_type_Int) });
      if (!paramahnq.jdField_a_of_type_Boolean) {
        paramsko = getContext().getResources().getString(2131699573);
      }
      paramahnr.jdField_b_of_type_AndroidWidgetTextView.setText(paramsko);
      paramsko = a(paramahnq.jdField_b_of_type_JavaLangString, paramahnq.c);
      if (paramsko != null) {
        paramahnr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramsko);
      }
      int i = getContext().getResources().getColor(2131167034);
      int j = Color.parseColor("#F5F6FA");
      paramsko = a(i, j);
      if (paramsko != null)
      {
        paramahnr.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramsko);
        if (i == 0) {
          break label236;
        }
        paramahnr.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.setDrawColor(i);
      }
      for (;;)
      {
        if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label246;
        }
        paramsko = getContext().getResources().getColorStateList(2131166339);
        paramahnq = getContext().getResources().getColorStateList(2131166341);
        paramahnr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramsko);
        paramahnr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramahnq);
        return;
        paramahnr.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849911);
        break;
        paramahnr.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendConnectionsTriangleView.setDrawColor(j);
      }
    }
  }
  
  private void c()
  {
    setSelectedTabIndicatorHeight(0);
  }
  
  public int a(ArrayList<ahnq> paramArrayList, int paramInt)
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
      if (((ahnq)paramArrayList.get(i)).jdField_a_of_type_Int == paramInt) {
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
    azuy localazuy;
    do
    {
      return localObject;
      localObject = new azuy(paramInt1, 50, 50, bdoo.a(6.0F));
      localStateListDrawable = new StateListDrawable();
      localazuy = new azuy(paramInt2, 50, 50, bdoo.a(6.0F));
      if (localObject != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject);
      }
      localObject = localStateListDrawable;
    } while (localazuy == null);
    localStateListDrawable.addState(new int[] { -16842913 }, localazuy);
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
    sko localsko;
    do
    {
      return;
      localsko = a(paramInt);
    } while (localsko == null);
    localsko.b();
  }
  
  public void a(ArrayList<ahnq> paramArrayList, int paramInt)
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
    paramArrayList.a(2131561117);
    a(paramArrayList, new ahnr(paramArrayList.a()), (ahnq)this.a.get(paramInt));
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
  
  public void a(sko paramsko)
  {
    new ahnr(paramsko.a()).a();
  }
  
  public void b(ArrayList<ahnq> paramArrayList, int paramInt)
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
    ahnr localahnr;
    if (paramInt < a())
    {
      paramArrayList = a(paramInt);
      if (paramArrayList != null)
      {
        ahnq localahnq = (ahnq)this.a.get(paramInt);
        localahnr = new ahnr(paramArrayList.a());
        a(paramArrayList, localahnr, localahnq);
        if (i != paramInt) {
          break label209;
        }
        a(paramInt);
        localahnr.a();
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label134;
      break;
      label209:
      localahnr.b();
    }
  }
  
  public void b(sko paramsko)
  {
    new ahnr(paramsko.a()).b();
  }
  
  public void c(sko paramsko) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectionsTabLayout
 * JD-Core Version:    0.7.0.1
 */