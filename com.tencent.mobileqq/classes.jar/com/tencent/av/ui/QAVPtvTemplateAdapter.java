package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class QAVPtvTemplateAdapter
  extends BaseAdapter
{
  public static int a;
  public static int b;
  public static int c;
  float jdField_a_of_type_Float = 6.25F;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private View jdField_a_of_type_AndroidViewView = null;
  QAVPtvTemplateAdapter.IEffectCallback jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback;
  QAVPtvTemplateAdapter.IItemDownloadMgr jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr;
  private QavListItemBase.IClickCallback jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback = new QAVPtvTemplateAdapter.4(this);
  private QavListItemBase.IDownloadCallback jdField_a_of_type_ComTencentAvUiQavListItemBase$IDownloadCallback = new QAVPtvTemplateAdapter.5(this);
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  public ArrayList<QavListItemBase.ItemInfo> a;
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  public boolean c;
  protected volatile int d = -1;
  protected int e = -1;
  
  public QAVPtvTemplateAdapter(AppInterface paramAppInterface, Context paramContext, ArrayList<QavListItemBase.ItemInfo> paramArrayList, HorizontalListView paramHorizontalListView)
  {
    this(paramAppInterface, paramContext, paramArrayList, paramHorizontalListView, 6.25F);
  }
  
  public QAVPtvTemplateAdapter(AppInterface paramAppInterface, Context paramContext, ArrayList<QavListItemBase.ItemInfo> paramArrayList, HorizontalListView paramHorizontalListView, float paramFloat)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_Float = paramFloat;
    a(paramArrayList);
    jdField_a_of_type_Int = a(this.jdField_a_of_type_AndroidContentResResources, a());
    jdField_b_of_type_Int = a(this.jdField_a_of_type_AndroidContentResResources, a(), 0.1666667F);
    jdField_c_of_type_Int = jdField_a_of_type_Int + AIOUtils.b(30.0F, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_a_of_type_Float < 6.0F) {
      jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297662);
    }
    if (QLog.isDevelopLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("init, w[");
      paramAppInterface.append(jdField_a_of_type_Int);
      paramAppInterface.append("], h[");
      paramAppInterface.append(jdField_c_of_type_Int);
      paramAppInterface.append("], half[");
      paramAppInterface.append(jdField_b_of_type_Int);
      paramAppInterface.append("]");
      QLog.i("QAVPtvTemplateAdapter", 4, paramAppInterface.toString());
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.addOnLayoutChangeListener(new QAVPtvTemplateAdapter.1(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(new QAVPtvTemplateAdapter.2(this));
    paramAppInterface = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams();
    paramAppInterface.width = -1;
    paramAppInterface.height = jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setLayoutParams(paramAppInterface);
  }
  
  public static int a(Resources paramResources, float paramFloat)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / paramFloat + 0.5F);
  }
  
  public static int a(Resources paramResources, float paramFloat1, float paramFloat2)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public QavListItemBase.ItemInfo a()
  {
    int i = this.e;
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.e);
    }
    return null;
  }
  
  public QavListItemBase.ItemInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() >= paramInt)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPositionFromLeftOrRight(paramInt, 0, 200);
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition() <= paramInt)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt);
      if ((localView == null) || (localView.getRight() > this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getRight()))
      {
        int i;
        if (paramInt == getCount() - 1) {
          i = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().widthPixels - jdField_a_of_type_Int;
        } else {
          i = jdField_a_of_type_Int * 5;
        }
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPositionFromLeftOrRight(paramInt, -i, 200);
      }
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      View localView1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt1);
      View localView2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt2);
      if ((paramInt2 != paramInt1) && (localView1 != null) && ((localView1 instanceof QavListItemBase))) {
        ((QavListItemBase)localView1).setHighlight(false);
      }
      if ((localView2 != null) && ((localView2 instanceof QavListItemBase))) {
        ((QavListItemBase)localView2).setHighlight(true);
      }
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (paramInt >= 0)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt) {
        return;
      }
      QavListItemBase.ItemInfo localItemInfo = (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if ((!TextUtils.isEmpty(localItemInfo.jdField_a_of_type_JavaLangString)) && (!localItemInfo.jdField_a_of_type_JavaLangString.equals("0")))
      {
        if (localItemInfo.jdField_a_of_type_Boolean)
        {
          a(paramLong, localItemInfo);
          return;
        }
        if ((!localItemInfo.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(localItemInfo.jdField_a_of_type_JavaLangString)))
        {
          QAVPtvTemplateAdapter.IItemDownloadMgr localIItemDownloadMgr = this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr;
          if (localIItemDownloadMgr != null)
          {
            localIItemDownloadMgr.startDownloadTemplate(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong, localItemInfo, this.jdField_a_of_type_ComTencentAvUiQavListItemBase$IDownloadCallback);
            localItemInfo.jdField_b_of_type_Boolean = true;
            return;
          }
          throw new IllegalArgumentException("mIItemDownloadMgr is null, pealse call setItemDownloadMgr");
        }
        return;
      }
      a(paramLong, localItemInfo);
    }
  }
  
  void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback == null) {
      return;
    }
    if ((TextUtils.isEmpty(paramItemInfo.jdField_a_of_type_JavaLangString)) || (paramItemInfo.jdField_a_of_type_JavaLangString.equals("0")) || (paramItemInfo.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback.a(paramLong, paramItemInfo);
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new QAVPtvTemplateAdapter.6(this, paramString, paramBoolean, paramLong));
  }
  
  void a(View paramView, QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    paramView = paramView.findViewById(2131373387);
    if ((paramView != null) && (paramItemInfo != null))
    {
      paramView.setContentDescription(paramItemInfo.d);
      ViewCompat.setAccessibilityDelegate(paramView, new QAVPtvTemplateAdapter.3(this, paramInt));
    }
  }
  
  public void a(QAVPtvTemplateAdapter.IEffectCallback paramIEffectCallback)
  {
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback = paramIEffectCallback;
  }
  
  public void a(QAVPtvTemplateAdapter.IItemDownloadMgr paramIItemDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr = paramIItemDownloadMgr;
  }
  
  public void a(String paramString, int paramInt)
  {
    c(paramString, paramInt);
  }
  
  public void a(ArrayList<QavListItemBase.ItemInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    int i = this.d;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    boolean bool;
    if ((this.d != paramInt) && (paramInt >= 0) && (paramInt < j))
    {
      this.d = paramInt;
      notifyDataSetChanged();
      bool = true;
    }
    else
    {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSelectedIndex, ret[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], index[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mCurSelectedPosition[");
    localStringBuilder.append(i);
    localStringBuilder.append("->");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], size[");
    localStringBuilder.append(j);
    localStringBuilder.append("]");
    QLog.w("QAVPtvTemplateAdapter", 1, localStringBuilder.toString());
    return bool;
  }
  
  void b(String paramString, int paramInt)
  {
    int m = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int i1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = m;
    Object localObject2;
    for (;;)
    {
      localObject2 = null;
      if (i > i1) {
        break;
      }
      if (i >= 0)
      {
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        localObject3 = (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localObject3 != null) && (((QavListItemBase.ItemInfo)localObject3).jdField_a_of_type_JavaLangString.equals(paramString)))
        {
          View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - m);
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (!(localView instanceof QavListItemBase)) {
            break label160;
          }
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (!this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter().equals(this)) {
            break label160;
          }
          localObject4 = (QavListItemBase)localView;
          localObject1 = localObject3;
          break label160;
        }
      }
      i += 1;
    }
    Object localObject1 = null;
    Object localObject4 = localObject2;
    label160:
    int k = i;
    Object localObject3 = localObject1;
    if (localObject1 == null)
    {
      k = i;
      localObject3 = localObject1;
      if (paramInt == 101)
      {
        int n = this.jdField_a_of_type_JavaUtilArrayList.size();
        k = 0;
        int j;
        for (;;)
        {
          j = i;
          localObject2 = localObject1;
          if (k >= m) {
            break;
          }
          j = i;
          localObject2 = localObject1;
          if (k >= n) {
            break;
          }
          localObject2 = (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(k);
          if ((localObject2 != null) && (((QavListItemBase.ItemInfo)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            j = k;
            break;
          }
          k += 1;
        }
        k = j;
        localObject3 = localObject2;
        if (localObject2 == null)
        {
          i = i1 + 1;
          for (;;)
          {
            k = j;
            localObject3 = localObject2;
            if (i >= n) {
              break;
            }
            localObject3 = (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
            if ((localObject3 != null) && (((QavListItemBase.ItemInfo)localObject3).jdField_a_of_type_JavaLangString.equals(paramString)))
            {
              k = i;
              break;
            }
            i += 1;
          }
        }
      }
    }
    if (localObject3 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateManager", 2, String.format("onProgressUpdate, index[%s], [%s][%s], progress[%s]", new Object[] { Integer.valueOf(k), ((QavListItemBase.ItemInfo)localObject3).jdField_a_of_type_JavaLangString, ((QavListItemBase.ItemInfo)localObject3).c, Integer.valueOf(paramInt) }));
      }
      if (paramInt == -1)
      {
        ((QavListItemBase.ItemInfo)localObject3).jdField_b_of_type_Boolean = false;
      }
      else if (paramInt == 101)
      {
        ((QavListItemBase.ItemInfo)localObject3).jdField_b_of_type_Boolean = false;
        ((QavListItemBase.ItemInfo)localObject3).jdField_a_of_type_Boolean = true;
      }
      else
      {
        i = paramInt;
        if (paramInt == 100) {
          i = 99;
        }
        ((QavListItemBase.ItemInfo)localObject3).jdField_b_of_type_Boolean = true;
        paramInt = i;
      }
      if (localObject4 != null) {
        ((QavListItemBase)localObject4).a(paramInt);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  void c(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new QAVPtvTemplateAdapter.7(this, paramString, paramInt));
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QavListItemBase.ItemInfo localItemInfo = a(paramInt);
    Object localObject2 = null;
    if (localItemInfo == null)
    {
      a(paramView, null, paramInt);
      localObject2 = paramView;
    }
    else
    {
      Object localObject1;
      Object localObject3;
      if ("-1".equals(localItemInfo.jdField_a_of_type_JavaLangString))
      {
        localObject1 = localObject2;
        if (paramView != null)
        {
          localObject1 = localObject2;
          if (paramView.getId() == Integer.valueOf(localItemInfo.jdField_a_of_type_JavaLangString).intValue()) {
            localObject1 = paramView;
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = this.jdField_a_of_type_AndroidViewView;
          localObject2 = localObject1;
          if (localObject3 != null) {
            localObject2 = localObject3;
          }
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new View(this.jdField_a_of_type_AndroidContentContext);
          ((View)localObject1).setId(Integer.valueOf(localItemInfo.jdField_a_of_type_JavaLangString).intValue());
          ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(jdField_b_of_type_Int, -1));
          this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
        }
        localObject2 = localObject1;
        if (AudioHelper.a(0) == 1)
        {
          ((View)localObject1).setBackgroundColor(-256);
          localObject2 = localObject1;
        }
      }
      else
      {
        if (!(paramView instanceof QavListItemBase))
        {
          if (localItemInfo.jdField_a_of_type_Int == 2)
          {
            localObject1 = new VoiceChangeItemView2(this.jdField_a_of_type_AndroidContentContext);
          }
          else
          {
            localObject2 = new QavPtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
            ((QavPtvTemplateItemView)localObject2).jdField_a_of_type_Boolean = this.jdField_c_of_type_Boolean;
            localObject1 = localObject2;
            if (this.jdField_a_of_type_Float < 6.0F)
            {
              localObject3 = ((QavPtvTemplateItemView)localObject2).findViewById(2131373553);
              localObject1 = localObject2;
              if ((localObject3 instanceof LinearLayout))
              {
                ((LinearLayout)localObject3).setGravity(49);
                localObject1 = localObject2;
              }
            }
          }
          ((QavListItemBase)localObject1).a(jdField_a_of_type_Int, jdField_c_of_type_Int);
        }
        else
        {
          localObject1 = (QavListItemBase)paramView;
        }
        if (AudioHelper.a(0) == 1)
        {
          ((QavListItemBase)localObject1).a(localItemInfo, paramInt);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setBackgroundColor(-1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getView, itemView[");
          ((StringBuilder)localObject2).append(localObject1.hashCode());
          ((StringBuilder)localObject2).append("], mListView[");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.hashCode());
          ((StringBuilder)localObject2).append("], position[");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append("], getPosition[");
          ((StringBuilder)localObject2).append(((QavListItemBase)localObject1).a());
          ((StringBuilder)localObject2).append("], mFullItemWidth[");
          ((StringBuilder)localObject2).append(jdField_a_of_type_Int);
          ((StringBuilder)localObject2).append("], mListViewHeight[");
          ((StringBuilder)localObject2).append(jdField_c_of_type_Int);
          ((StringBuilder)localObject2).append("], mListView.Height[");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getMeasuredHeight());
          ((StringBuilder)localObject2).append("|");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight());
          ((StringBuilder)localObject2).append("], itemView.Height[");
          ((StringBuilder)localObject2).append(((QavListItemBase)localObject1).getMeasuredHeight());
          ((StringBuilder)localObject2).append("|");
          ((StringBuilder)localObject2).append(((QavListItemBase)localObject1).getHeight());
          ((StringBuilder)localObject2).append("], info[");
          ((StringBuilder)localObject2).append(localItemInfo);
          ((StringBuilder)localObject2).append("]");
          QLog.w("QAVPtvTemplateAdapter", 1, ((StringBuilder)localObject2).toString());
        }
        ((QavListItemBase)localObject1).b(jdField_a_of_type_Int, jdField_c_of_type_Int);
        int i;
        if (paramInt == this.d) {
          i = 1;
        } else {
          i = 0;
        }
        boolean bool1;
        if ((this.jdField_a_of_type_Boolean) && (i != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2 = this.jdField_b_of_type_Boolean;
        localObject3 = this.jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback;
        localObject2 = localObject1;
        ((QavListItemBase)localObject2).a(paramInt, bool1, bool2, localItemInfo, (QavListItemBase.IClickCallback)localObject3);
        a((View)localObject1, localItemInfo, paramInt);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */