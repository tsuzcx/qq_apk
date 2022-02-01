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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
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
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 0;
  }
  
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
    jdField_c_of_type_Int = jdField_a_of_type_Int + AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_a_of_type_Float < 6.0F) {
      jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297671);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("QAVPtvTemplateAdapter", 4, "init, w[" + jdField_a_of_type_Int + "], h[" + jdField_c_of_type_Int + "], half[" + jdField_b_of_type_Int + "]");
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
    if ((this.e < 0) || (this.e >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.e);
  }
  
  public QavListItemBase.ItemInfo a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() >= paramInt) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPositionFromLeftOrRight(paramInt, 0, 200);
    }
    View localView;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition() > paramInt);
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt);
    } while ((localView != null) && (localView.getRight() <= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getRight()));
    if (paramInt == getCount() - 1) {}
    for (int i = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().widthPixels - jdField_a_of_type_Int;; i = jdField_a_of_type_Int * 5)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPositionFromLeftOrRight(paramInt, -i, 200);
      return;
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
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt)) {}
    QavListItemBase.ItemInfo localItemInfo;
    do
    {
      return;
      localItemInfo = (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if ((TextUtils.isEmpty(localItemInfo.jdField_a_of_type_JavaLangString)) || (localItemInfo.jdField_a_of_type_JavaLangString.equals("0")))
      {
        a(paramLong, localItemInfo);
        return;
      }
      if (localItemInfo.jdField_a_of_type_Boolean)
      {
        a(paramLong, localItemInfo);
        return;
      }
    } while ((localItemInfo.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(localItemInfo.jdField_a_of_type_JavaLangString)));
    if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr.startDownloadTemplate(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong, localItemInfo, this.jdField_a_of_type_ComTencentAvUiQavListItemBase$IDownloadCallback);
      localItemInfo.jdField_b_of_type_Boolean = true;
      return;
    }
    throw new IllegalArgumentException("mIItemDownloadMgr is null, pealse call setItemDownloadMgr");
  }
  
  void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback == null) {}
    while ((!TextUtils.isEmpty(paramItemInfo.jdField_a_of_type_JavaLangString)) && (!paramItemInfo.jdField_a_of_type_JavaLangString.equals("0")) && (!paramItemInfo.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback.a(paramLong, paramItemInfo);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new QAVPtvTemplateAdapter.6(this, paramString, paramBoolean, paramLong));
  }
  
  void a(View paramView, QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.findViewById(2131373815);
    } while ((paramView == null) || (paramItemInfo == null));
    paramView.setContentDescription(paramItemInfo.d);
    ViewCompat.setAccessibilityDelegate(paramView, new QAVPtvTemplateAdapter.3(this, paramInt));
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
    boolean bool2 = false;
    int i = this.d;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    boolean bool1 = bool2;
    if (this.d != paramInt)
    {
      bool1 = bool2;
      if (paramInt >= 0)
      {
        bool1 = bool2;
        if (paramInt < j)
        {
          this.d = paramInt;
          notifyDataSetChanged();
          bool1 = true;
        }
      }
    }
    QLog.w("QAVPtvTemplateAdapter", 1, "setSelectedIndex, ret[" + bool1 + "], index[" + paramInt + "], mCurSelectedPosition[" + i + "->" + this.d + "], size[" + j + "]");
    return bool1;
  }
  
  void b(String paramString, int paramInt)
  {
    QavListItemBase.ItemInfo localItemInfo2 = null;
    int k = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int n = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = k;
    Object localObject;
    QavListItemBase.ItemInfo localItemInfo1;
    for (;;)
    {
      if (i <= n) {
        if (i < 0)
        {
          i += 1;
        }
        else if (i >= this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = null;
          localItemInfo1 = localItemInfo2;
        }
      }
    }
    for (;;)
    {
      label59:
      int j;
      label134:
      label145:
      if ((localItemInfo1 == null) && (paramInt == 101))
      {
        int m = this.jdField_a_of_type_JavaUtilArrayList.size();
        j = 0;
        label82:
        if ((j < k) && (j < m))
        {
          localItemInfo2 = (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          if ((localItemInfo2 != null) && (localItemInfo2.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            i = j;
            localItemInfo1 = localItemInfo2;
            if (localItemInfo1 != null) {
              break label407;
            }
            j = n + 1;
            if (j >= m) {
              break label407;
            }
            localItemInfo2 = (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
            if ((localItemInfo2 == null) || (!localItemInfo2.jdField_a_of_type_JavaLangString.equals(paramString))) {
              break label355;
            }
            localItemInfo1 = localItemInfo2;
            i = j;
          }
        }
      }
      for (;;)
      {
        if (localItemInfo1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PtvTemplateManager", 2, String.format("onProgressUpdate, index[%s], [%s][%s], progress[%s]", new Object[] { Integer.valueOf(i), localItemInfo1.jdField_a_of_type_JavaLangString, localItemInfo1.c, Integer.valueOf(paramInt) }));
          }
          if (paramInt != -1) {
            break label364;
          }
          localItemInfo1.jdField_b_of_type_Boolean = false;
        }
        for (;;)
        {
          if (localObject != null) {
            ((QavListItemBase)localObject).a(paramInt);
          }
          return;
          localItemInfo1 = (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localItemInfo1 == null) || (!localItemInfo1.jdField_a_of_type_JavaLangString.equals(paramString))) {
            break;
          }
          localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - k);
          if ((!(localObject instanceof QavListItemBase)) || (!this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter().equals(this))) {
            break label416;
          }
          localObject = (QavListItemBase)localObject;
          break label59;
          j += 1;
          break label82;
          label355:
          j += 1;
          break label145;
          label364:
          if (paramInt == 101)
          {
            localItemInfo1.jdField_b_of_type_Boolean = false;
            localItemInfo1.jdField_a_of_type_Boolean = true;
          }
          else
          {
            i = paramInt;
            if (paramInt == 100) {
              i = 99;
            }
            localItemInfo1.jdField_b_of_type_Boolean = true;
            paramInt = i;
          }
        }
        label407:
        continue;
        break label134;
      }
      label416:
      localObject = null;
      continue;
      localObject = null;
      localItemInfo1 = localItemInfo2;
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
    Object localObject2 = null;
    boolean bool = true;
    QavListItemBase.ItemInfo localItemInfo = a(paramInt);
    Object localObject1;
    if (localItemInfo == null)
    {
      a(paramView, null, paramInt);
      localObject1 = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      if (!"-1".equals(localItemInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
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
        localObject2 = localObject1;
        if (this.jdField_a_of_type_AndroidViewView != null) {
          localObject2 = this.jdField_a_of_type_AndroidViewView;
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
      if (AudioHelper.a(0) == 1) {
        ((View)localObject1).setBackgroundColor(-256);
      }
    }
    label226:
    label237:
    int i;
    if (!(paramView instanceof QavListItemBase)) {
      if (localItemInfo.jdField_a_of_type_Int == 2)
      {
        localObject1 = new VoiceChangeItemView2(this.jdField_a_of_type_AndroidContentContext);
        ((QavListItemBase)localObject1).a(jdField_a_of_type_Int, jdField_c_of_type_Int);
        if (AudioHelper.a(0) == 1)
        {
          ((QavListItemBase)localObject1).a(localItemInfo, paramInt);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setBackgroundColor(-1);
          QLog.w("QAVPtvTemplateAdapter", 1, "getView, itemView[" + localObject1.hashCode() + "], mListView[" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.hashCode() + "], position[" + paramInt + "], getPosition[" + ((QavListItemBase)localObject1).a() + "], mFullItemWidth[" + jdField_a_of_type_Int + "], mListViewHeight[" + jdField_c_of_type_Int + "], mListView.Height[" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getMeasuredHeight() + "|" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight() + "], itemView.Height[" + ((QavListItemBase)localObject1).getMeasuredHeight() + "|" + ((QavListItemBase)localObject1).getHeight() + "], info[" + localItemInfo + "]");
        }
        ((QavListItemBase)localObject1).b(jdField_a_of_type_Int, jdField_c_of_type_Int);
        if (paramInt != this.d) {
          break label567;
        }
        i = 1;
        label453:
        if ((!this.jdField_a_of_type_Boolean) || (i == 0)) {
          break label573;
        }
      }
    }
    for (;;)
    {
      ((QavListItemBase)localObject1).a(paramInt, bool, this.jdField_b_of_type_Boolean, localItemInfo, this.jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback);
      a((View)localObject1, localItemInfo, paramInt);
      break;
      localObject1 = new QavPtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      ((QavPtvTemplateItemView)localObject1).jdField_a_of_type_Boolean = this.jdField_c_of_type_Boolean;
      if (this.jdField_a_of_type_Float < 6.0F)
      {
        localObject2 = ((QavPtvTemplateItemView)localObject1).findViewById(2131373981);
        if ((localObject2 instanceof LinearLayout)) {
          ((LinearLayout)localObject2).setGravity(49);
        }
      }
      break label226;
      localObject1 = (QavListItemBase)paramView;
      break label237;
      label567:
      i = 0;
      break label453;
      label573:
      bool = false;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */