package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import jzm;
import jzn;
import jzo;
import jzp;
import jzq;
import jzr;

public class QAVPtvTemplateAdapter
  extends BaseAdapter
{
  static float jdField_a_of_type_Float = 6.25F;
  public int a;
  public long a;
  public Context a;
  Resources jdField_a_of_type_AndroidContentResResources;
  private View jdField_a_of_type_AndroidViewView;
  public QAVPtvTemplateAdapter.IEffectCallback a;
  QAVPtvTemplateAdapter.IItemDownloadMgr jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr;
  private QavListItemBase.IClickCallback jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback = new jzo(this);
  private QavListItemBase.IDownloadCallback jdField_a_of_type_ComTencentAvUiQavListItemBase$IDownloadCallback = new jzp(this);
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public HorizontalListView a;
  public ArrayList a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  boolean b;
  public int c;
  public boolean c;
  
  public QAVPtvTemplateAdapter(AppInterface paramAppInterface, Context paramContext, ArrayList paramArrayList, HorizontalListView paramHorizontalListView)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Float = a(paramContext);
    a(paramAppInterface, paramContext, paramArrayList, paramHorizontalListView, jdField_a_of_type_Float, 0.1666667F);
  }
  
  public static float a(Context paramContext)
  {
    return jdField_a_of_type_Float;
  }
  
  public static int a(Resources paramResources, float paramFloat1, float paramFloat2)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public int a(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().widthPixels / paramFloat + 0.5F);
  }
  
  public QavListItemBase.ItemInfo a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() >= paramInt) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(paramInt, 0, 200);
    }
    View localView;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition() > paramInt);
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(paramInt);
    } while ((localView != null) && (localView.getRight() <= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getRight()));
    if (paramInt == getCount() - 1) {}
    for (int i = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().widthPixels - this.jdField_a_of_type_Int;; i = this.jdField_a_of_type_Int * ((int)jdField_a_of_type_Float - 1))
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(paramInt, -i, 200);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      View localView1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(paramInt1);
      View localView2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(paramInt2);
      if ((paramInt2 != paramInt1) && (localView1 != null) && ((localView1 instanceof QavListItemBase))) {
        ((QavListItemBase)localView1).setHighlight(false);
      }
      if ((localView2 != null) && ((localView2 instanceof QavListItemBase))) {
        ((QavListItemBase)localView2).setHighlight(true);
      }
    }
  }
  
  void a(View paramView, QavListItemBase.ItemInfo paramItemInfo)
  {
    Object localObject = null;
    if (paramView == null) {}
    label56:
    for (;;)
    {
      return;
      View localView = paramView.findViewById(2131366237);
      if (paramItemInfo == null) {
        paramView.setContentDescription(null);
      }
      for (paramView = localObject;; paramView = paramItemInfo.d)
      {
        if (localView == null) {
          break label56;
        }
        localView.setContentDescription(paramView);
        return;
        if (!paramItemInfo.jdField_a_of_type_JavaLangString.equals("liveshow")) {
          break;
        }
      }
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
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback == null) {}
    while ((!TextUtils.isEmpty(paramItemInfo.jdField_a_of_type_JavaLangString)) && (!paramItemInfo.jdField_a_of_type_JavaLangString.equals("0")) && (!paramItemInfo.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IEffectCallback.a(paramItemInfo);
  }
  
  @TargetApi(11)
  void a(AppInterface paramAppInterface, Context paramContext, ArrayList paramArrayList, HorizontalListView paramHorizontalListView, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = a(paramFloat1);
    this.jdField_b_of_type_Int = a(this.jdField_a_of_type_AndroidContentResResources, paramFloat1, paramFloat2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.addOnLayoutChangeListener(new jzm(this));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    if (AudioHelper.a(0) == 1) {
      QLog.d("QAVPtvTemplateAdapter", 4, String.format("initAdapter, mTemplateList[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(new jzn(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    c(paramString, paramInt);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new jzq(this, paramString, paramBoolean));
  }
  
  public void a(ArrayList paramArrayList)
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
    int i = paramInt;
    if (paramInt == -1) {
      i = 1;
    }
    if ((this.jdField_c_of_type_Int != i) && (((i > 0) && (i < this.jdField_a_of_type_JavaUtilArrayList.size())) || ((i == -1) && (this.jdField_c_of_type_Int != 1))))
    {
      this.jdField_c_of_type_Int = i;
      notifyDataSetChanged();
      return true;
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt)) {
      return;
    }
    int j = 1;
    int i = 0;
    label20:
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (HttpUtil.a(((QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_JavaLangString)) {
        break label58;
      }
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label58:
      if (j == paramInt) {
        break label70;
      }
      j += 1;
    }
    label70:
    this.jdField_c_of_type_Int = i;
    c(this.jdField_c_of_type_Int);
  }
  
  public void b(String paramString, int paramInt)
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
          if ((!(localObject instanceof QavListItemBase)) || (!this.jdField_a_of_type_ComTencentWidgetHorizontalListView.a().equals(this))) {
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
  
  public void c(int paramInt)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt)) {}
    QavListItemBase.ItemInfo localItemInfo;
    do
    {
      return;
      localItemInfo = (QavListItemBase.ItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if ((TextUtils.isEmpty(localItemInfo.jdField_a_of_type_JavaLangString)) || (localItemInfo.jdField_a_of_type_JavaLangString.equals("0")))
      {
        a(localItemInfo);
        return;
      }
      if (localItemInfo.jdField_a_of_type_Boolean)
      {
        a(localItemInfo);
        return;
      }
    } while ((localItemInfo.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(localItemInfo.jdField_a_of_type_JavaLangString)));
    if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr.startDownloadTemplate(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localItemInfo, this.jdField_a_of_type_ComTencentAvUiQavListItemBase$IDownloadCallback);
      localItemInfo.jdField_b_of_type_Boolean = true;
      return;
    }
    throw new IllegalArgumentException("mIItemDownloadMgr is null, pealse call setItemDownloadMgr");
  }
  
  void c(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new jzr(this, paramString, paramInt));
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
    boolean bool = true;
    QavListItemBase.ItemInfo localItemInfo = a(paramInt);
    if (localItemInfo == null) {
      a(paramView, null);
    }
    do
    {
      return paramView;
      if (!"-1".equals(localItemInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
      Object localObject = null;
      paramViewGroup = localObject;
      if (paramView != null)
      {
        paramViewGroup = localObject;
        if (paramView.getId() == Integer.valueOf(localItemInfo.jdField_a_of_type_JavaLangString).intValue()) {
          paramViewGroup = paramView;
        }
      }
      paramView = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_AndroidViewView != null) {
          paramView = this.jdField_a_of_type_AndroidViewView;
        }
      }
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(Integer.valueOf(localItemInfo.jdField_a_of_type_JavaLangString).intValue());
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(this.jdField_b_of_type_Int, -1));
        this.jdField_a_of_type_AndroidViewView = paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (AudioHelper.a(0) != 1);
    paramViewGroup.setBackgroundColor(-256);
    return paramViewGroup;
    label210:
    int i;
    if ((paramView == null) || (!(paramView instanceof QavListItemBase))) {
      if (localItemInfo.jdField_a_of_type_Int == 2)
      {
        paramView = new VoiceChangeItemView2(this.jdField_a_of_type_AndroidContentContext);
        paramView.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight());
        if (AudioHelper.a(0) == 1)
        {
          paramView.a(localItemInfo, paramInt);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setBackgroundColor(-1);
          QLog.d("QAVPtvTemplateAdapter", 4, String.format("[%s][%s]getView[%s, %s], mFullItemWidth[%s], mListView[%s, %s], itemView[%s, %s], %s", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(paramView.a()), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getMeasuredHeight()), Integer.valueOf(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight()), Integer.valueOf(paramView.getMeasuredHeight()), Integer.valueOf(paramView.getHeight()), localItemInfo }));
        }
        paramView.b(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight());
        if (paramInt != this.jdField_c_of_type_Int) {
          break label450;
        }
        i = 1;
        label381:
        if ((!this.jdField_a_of_type_Boolean) || (i == 0)) {
          break label456;
        }
      }
    }
    for (;;)
    {
      paramView.a(paramInt, bool, this.jdField_b_of_type_Boolean, localItemInfo, this.jdField_a_of_type_ComTencentAvUiQavListItemBase$IClickCallback);
      a(paramView, localItemInfo);
      return paramView;
      paramView = new QavPtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.jdField_a_of_type_Boolean = this.jdField_c_of_type_Boolean;
      break;
      paramView = (QavListItemBase)paramView;
      break label210;
      label450:
      i = 0;
      break label381;
      label456:
      bool = false;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */