package com.tencent.mobileqq.activity.aio.coreui.pluspanel;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class PanelAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int = 4;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PanelRecycleBin jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
  private ArrayList<PluginData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int b = 2;
  
  PanelAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private int a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getTag() instanceof PanelAdapter.PageData)) {
      return PanelAdapter.PageData.b((PanelAdapter.PageData)paramRecyclerView.getTag());
    }
    return 0;
  }
  
  private void a(int paramInt, RecyclerView paramRecyclerView)
  {
    int i = ViewUtils.b(20.0F);
    paramRecyclerView.setPadding(i, 0, i, 0);
    a(paramRecyclerView, paramInt);
    List localList = a(paramInt);
    Object localObject = paramRecyclerView.getAdapter();
    if ((localObject instanceof PlusPanelAppListAdapter))
    {
      localObject = (PlusPanelAppListAdapter)localObject;
      ((PlusPanelAppListAdapter)localObject).a(localList);
      try
      {
        paramRecyclerView.post(new PanelAdapter.2(this, (PlusPanelAppListAdapter)localObject));
        return;
      }
      catch (Exception paramRecyclerView)
      {
        QLog.e("PanelIconAdapter", 1, paramRecyclerView.getMessage());
        return;
      }
    }
    localObject = new PlusPanelAppListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    ((PlusPanelAppListAdapter)localObject).a(localList);
    paramRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getTag() instanceof PanelAdapter.PageData)) {
      paramRecyclerView.setTag(new PanelAdapter.PageData(PanelAdapter.PageData.b((PanelAdapter.PageData)paramRecyclerView.getTag()), XPanelContainer.d, null));
    } else {
      paramRecyclerView.setTag(new PanelAdapter.PageData(0, XPanelContainer.d, null));
    }
    QLog.d("PanelIconAdapter", 1, new Object[] { "updateRecyclerViewAddedHeight -> XPanelContainer.mExternalPanelheight : ", Integer.valueOf(XPanelContainer.jdField_a_of_type_Int), ", XPanelContainer.mDefaultExternalPanelheight : ", Integer.valueOf(XPanelContainer.b), ", XPanelContainer.mAddedHeight -> ", Integer.valueOf(XPanelContainer.d) });
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramRecyclerView.getTag() instanceof PanelAdapter.PageData))
    {
      paramRecyclerView.setTag(new PanelAdapter.PageData(paramInt, PanelAdapter.PageData.a((PanelAdapter.PageData)paramRecyclerView.getTag()), null));
      return;
    }
    paramRecyclerView.setTag(new PanelAdapter.PageData(paramInt, 0, null));
  }
  
  private int b(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getTag() instanceof PanelAdapter.PageData)) {
      return PanelAdapter.PageData.a((PanelAdapter.PageData)paramRecyclerView.getTag());
    }
    return 0;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  List<PluginData> a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int * this.b;
    paramInt *= i;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      i = Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), i + paramInt);
      return this.jdField_a_of_type_JavaUtilArrayList.subList(paramInt, i);
    }
    return new ArrayList(0);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return;
    }
    if (paramInt >= 0)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
      {
        RecyclerView localRecyclerView = (RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
        if ((localRecyclerView != null) && (paramInt == a(localRecyclerView)))
        {
          a(paramInt, localRecyclerView);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  public void a(ArrayList<PluginData> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    RecyclerView localRecyclerView = (RecyclerView)paramObject;
    ((ViewGroup)paramView).removeView(localRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.addScrapView((View)paramObject);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Int != 0) && (this.b != 0))
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (localArrayList != null)
      {
        int i = localArrayList.size();
        int j = this.jdField_a_of_type_Int;
        int k = this.b;
        return (i + j * k - 1) / (j * k);
      }
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean) {
      return -2;
    }
    if (((paramObject instanceof RecyclerView)) && (a((RecyclerView)paramObject) >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("instantiateItem ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("PanelIconAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (RecyclerView)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.getScrapView();
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      int i = b((RecyclerView)localObject2);
      QLog.d("PanelIconAdapter", 1, new Object[] { "reuseViewAddedHeight -> ", Integer.valueOf(i), ", XPanelContainer.mAddedHeight -> ", Integer.valueOf(XPanelContainer.d), ", XPanelContainer.mDefaultExternalPanelheight: ", Integer.valueOf(XPanelContainer.b), ", XPanelContainer.mExternalPanelheight: ", Integer.valueOf(XPanelContainer.jdField_a_of_type_Int) });
      localObject1 = localObject2;
      if (i != XPanelContainer.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.clearScrapViews();
        localObject1 = null;
      }
    }
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.jdField_a_of_type_AndroidViewViewGroup = localViewGroup;
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new RecyclerView(this.jdField_a_of_type_AndroidContentContext, null);
      a((RecyclerView)localObject2);
      ((RecyclerView)localObject2).setOverScrollMode(2);
      ((RecyclerView)localObject2).setLayoutManager(new PanelAdapter.1(this, this.jdField_a_of_type_AndroidContentContext, a()));
    }
    a(paramInt, (RecyclerView)localObject2);
    if ((((RecyclerView)localObject2).getParent() != paramView) && (paramInt < getCount())) {
      localViewGroup.addView((View)localObject2);
    }
    return localObject2;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.pluspanel.PanelAdapter
 * JD-Core Version:    0.7.0.1
 */