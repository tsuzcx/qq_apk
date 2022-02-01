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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    }
    if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    }
    localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDrawable downLoadUrl ->");
      localStringBuilder.append(paramString);
      QLog.d("ConnectionsTabLayout", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  private void a(TabLayoutCompat.Tab paramTab, ConnectionsTabLayout.TabItemViewHolder paramTabItemViewHolder, ConnectionsTabInfo paramConnectionsTabInfo)
  {
    if ((paramTab != null) && (paramTabItemViewHolder != null))
    {
      if (paramConnectionsTabInfo == null) {
        return;
      }
      paramTab.a(Integer.valueOf(paramConnectionsTabInfo.jdField_a_of_type_Int));
      paramTabItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramConnectionsTabInfo.jdField_a_of_type_JavaLangString);
      paramTab = getContext().getResources().getString(2131699056, new Object[] { Integer.valueOf(paramConnectionsTabInfo.jdField_b_of_type_Int) });
      if (!paramConnectionsTabInfo.jdField_a_of_type_Boolean) {
        paramTab = getContext().getResources().getString(2131699054);
      }
      paramTabItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramTab);
      paramTab = a(paramConnectionsTabInfo.jdField_b_of_type_JavaLangString, paramConnectionsTabInfo.c);
      if (paramTab != null) {
        paramTabItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramTab);
      }
      int i = getContext().getResources().getColor(2131167197);
      int j = Color.parseColor("#F5F6FA");
      paramTab = a(i, j);
      if (paramTab != null) {
        paramTabItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramTab);
      } else {
        paramTabItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850910);
      }
      if (i != 0) {
        paramTabItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(i);
      } else {
        paramTabItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(j);
      }
      if (ThemeUtil.isNowThemeIsNight(null, false, null))
      {
        paramTab = getContext().getResources().getColorStateList(2131166461);
        paramConnectionsTabInfo = getContext().getResources().getColorStateList(2131166463);
        paramTabItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramTab);
        paramTabItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramConnectionsTabInfo);
      }
    }
  }
  
  private void c()
  {
    setSelectedTabIndicatorHeight(0);
  }
  
  public int a(ArrayList<ConnectionsTabInfo> paramArrayList, int paramInt)
  {
    int i = 0;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return 0;
      }
      int j = 0;
      while (i < paramArrayList.size())
      {
        if (((ConnectionsTabInfo)paramArrayList.get(i)).jdField_a_of_type_Int == paramInt) {
          j = i;
        }
        i += 1;
      }
      return j;
    }
    return 0;
  }
  
  public Drawable a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      RoundedColorDrawable localRoundedColorDrawable1 = new RoundedColorDrawable(paramInt1, 50, 50, ViewUtils.a(6.0F));
      StateListDrawable localStateListDrawable = new StateListDrawable();
      RoundedColorDrawable localRoundedColorDrawable2 = new RoundedColorDrawable(paramInt2, 50, 50, ViewUtils.a(6.0F));
      localStateListDrawable.addState(new int[] { 16842913 }, localRoundedColorDrawable1);
      localStateListDrawable.addState(new int[] { -16842913 }, localRoundedColorDrawable2);
      return localStateListDrawable;
    }
    return null;
  }
  
  public Drawable a(String paramString1, String paramString2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    boolean bool = TextUtils.isEmpty(paramString1);
    String str = null;
    if (!bool)
    {
      URLDrawable localURLDrawable = a(paramString1);
      paramString1 = localURLDrawable;
      if (localURLDrawable != null)
      {
        localURLDrawable.startDownload();
        paramString1 = localURLDrawable;
      }
    }
    else
    {
      paramString1 = null;
    }
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
  
  public void a(int paramInt)
  {
    int i = b();
    if (i == paramInt)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("selectTabWithoutCallback viewPosition ->");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(",position =");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("ConnectionsTabLayout", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = a(paramInt);
    if (localObject != null) {
      ((TabLayoutCompat.Tab)localObject).b();
    }
  }
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    new ConnectionsTabLayout.TabItemViewHolder(paramTab.a()).a();
  }
  
  public void a(ArrayList<ConnectionsTabInfo> paramArrayList, int paramInt)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      this.a.clear();
      this.a.addAll(paramArrayList);
      a();
      a(this);
      if (this.a.size() <= 3)
      {
        setTabMode(1);
        setTabGravity(0);
      }
      else
      {
        setTabMode(0);
        setTabGravity(1);
      }
      int i = a(paramArrayList, paramInt);
      paramInt = 0;
      while (paramInt < this.a.size())
      {
        paramArrayList = a();
        if (paramArrayList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ConnectionsTabLayout", 2, "createTab newTab: null");
          }
          return;
        }
        paramArrayList.a(2131561246);
        a(paramArrayList, new ConnectionsTabLayout.TabItemViewHolder(paramArrayList.a()), (ConnectionsTabInfo)this.a.get(paramInt));
        if (i == paramInt) {
          a(paramArrayList, true);
        } else {
          a(paramArrayList, false);
        }
        paramInt += 1;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ConnectionsTabLayout", 2, "createTab infos: null");
    }
  }
  
  public void b(TabLayoutCompat.Tab paramTab)
  {
    new ConnectionsTabLayout.TabItemViewHolder(paramTab.a()).b();
  }
  
  public void b(ArrayList<ConnectionsTabInfo> paramArrayList, int paramInt)
  {
    Object localObject;
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      this.a.clear();
      this.a.addAll(paramArrayList);
      int i = paramArrayList.size();
      if (a() != i)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateTabs getTabCount() != infoSize ");
          ((StringBuilder)localObject).append(a());
          ((StringBuilder)localObject).append(", infoSize =");
          ((StringBuilder)localObject).append(i);
          QLog.d("ConnectionsTabLayout", 2, ((StringBuilder)localObject).toString());
        }
        a(paramArrayList, paramInt);
        return;
      }
      i = a(paramArrayList, paramInt);
      paramInt = 0;
      while (paramInt < a())
      {
        paramArrayList = a(paramInt);
        if (paramArrayList != null)
        {
          localObject = (ConnectionsTabInfo)this.a.get(paramInt);
          ConnectionsTabLayout.TabItemViewHolder localTabItemViewHolder = new ConnectionsTabLayout.TabItemViewHolder(paramArrayList.a());
          a(paramArrayList, localTabItemViewHolder, (ConnectionsTabInfo)localObject);
          if (i == paramInt)
          {
            a(paramInt);
            localTabItemViewHolder.a();
          }
          else
          {
            localTabItemViewHolder.b();
          }
        }
        paramInt += 1;
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTabs infos: ");
      ((StringBuilder)localObject).append(paramArrayList);
      QLog.d("ConnectionsTabLayout", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c(TabLayoutCompat.Tab paramTab) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsTabLayout
 * JD-Core Version:    0.7.0.1
 */