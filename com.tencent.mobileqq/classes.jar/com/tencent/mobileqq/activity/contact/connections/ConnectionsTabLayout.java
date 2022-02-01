package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.Tab;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ConnectionsTabLayout
  extends TabLayoutCompat
  implements TabLayoutCompat.OnTabSelectedListener
{
  private ArrayList<ConnectionsTabInfo> a = new ArrayList();
  
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
  
  private void a(TabLayoutCompat.Tab paramTab, ConnectionsTabLayout.TabItemViewHolder paramTabItemViewHolder, ConnectionsTabInfo paramConnectionsTabInfo)
  {
    if ((paramTab == null) || (paramTabItemViewHolder == null) || (paramConnectionsTabInfo == null)) {}
    label236:
    label246:
    for (;;)
    {
      return;
      paramTab.a(Integer.valueOf(paramConnectionsTabInfo.jdField_a_of_type_Int));
      paramTabItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramConnectionsTabInfo.jdField_a_of_type_JavaLangString);
      paramTab = getContext().getResources().getString(2131698977, new Object[] { Integer.valueOf(paramConnectionsTabInfo.jdField_b_of_type_Int) });
      if (!paramConnectionsTabInfo.jdField_a_of_type_Boolean) {
        paramTab = getContext().getResources().getString(2131698975);
      }
      paramTabItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramTab);
      paramTab = a(paramConnectionsTabInfo.jdField_b_of_type_JavaLangString, paramConnectionsTabInfo.c);
      if (paramTab != null) {
        paramTabItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramTab);
      }
      int i = getContext().getResources().getColor(2131167172);
      int j = Color.parseColor("#F5F6FA");
      paramTab = a(i, j);
      if (paramTab != null)
      {
        paramTabItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramTab);
        if (i == 0) {
          break label236;
        }
        paramTabItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(i);
      }
      for (;;)
      {
        if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label246;
        }
        paramTab = getContext().getResources().getColorStateList(2131166450);
        paramConnectionsTabInfo = getContext().getResources().getColorStateList(2131166452);
        paramTabItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramTab);
        paramTabItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramConnectionsTabInfo);
        return;
        paramTabItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850970);
        break;
        paramTabItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(j);
      }
    }
  }
  
  private void c()
  {
    setSelectedTabIndicatorHeight(0);
  }
  
  public int a(ArrayList<ConnectionsTabInfo> paramArrayList, int paramInt)
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
      if (((ConnectionsTabInfo)paramArrayList.get(i)).jdField_a_of_type_Int == paramInt) {
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
    RoundedColorDrawable localRoundedColorDrawable;
    do
    {
      return localObject;
      localObject = new RoundedColorDrawable(paramInt1, 50, 50, ViewUtils.a(6.0F));
      localStateListDrawable = new StateListDrawable();
      localRoundedColorDrawable = new RoundedColorDrawable(paramInt2, 50, 50, ViewUtils.a(6.0F));
      if (localObject != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, (Drawable)localObject);
      }
      localObject = localStateListDrawable;
    } while (localRoundedColorDrawable == null);
    localStateListDrawable.addState(new int[] { -16842913 }, localRoundedColorDrawable);
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
    TabLayoutCompat.Tab localTab;
    do
    {
      return;
      localTab = a(paramInt);
    } while (localTab == null);
    localTab.b();
  }
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    new ConnectionsTabLayout.TabItemViewHolder(paramTab.a()).a();
  }
  
  public void a(ArrayList<ConnectionsTabInfo> paramArrayList, int paramInt)
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
    paramArrayList.a(2131561407);
    a(paramArrayList, new ConnectionsTabLayout.TabItemViewHolder(paramArrayList.a()), (ConnectionsTabInfo)this.a.get(paramInt));
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
  
  public void b(TabLayoutCompat.Tab paramTab)
  {
    new ConnectionsTabLayout.TabItemViewHolder(paramTab.a()).b();
  }
  
  public void b(ArrayList<ConnectionsTabInfo> paramArrayList, int paramInt)
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
    ConnectionsTabLayout.TabItemViewHolder localTabItemViewHolder;
    if (paramInt < a())
    {
      paramArrayList = a(paramInt);
      if (paramArrayList != null)
      {
        ConnectionsTabInfo localConnectionsTabInfo = (ConnectionsTabInfo)this.a.get(paramInt);
        localTabItemViewHolder = new ConnectionsTabLayout.TabItemViewHolder(paramArrayList.a());
        a(paramArrayList, localTabItemViewHolder, localConnectionsTabInfo);
        if (i != paramInt) {
          break label209;
        }
        a(paramInt);
        localTabItemViewHolder.a();
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label134;
      break;
      label209:
      localTabItemViewHolder.b();
    }
  }
  
  public void c(TabLayoutCompat.Tab paramTab) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsTabLayout
 * JD-Core Version:    0.7.0.1
 */