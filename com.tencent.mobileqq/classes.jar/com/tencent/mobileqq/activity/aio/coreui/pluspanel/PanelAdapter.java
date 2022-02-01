package com.tencent.mobileqq.activity.aio.coreui.pluspanel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
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
      paramRecyclerView = (PlusPanelAppListAdapter)localObject;
      paramRecyclerView.a(localList);
      paramRecyclerView.notifyDataSetChanged();
      return;
    }
    localObject = new PlusPanelAppListAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    ((PlusPanelAppListAdapter)localObject).a(localList);
    paramRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
  }
  
  private void a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getTag() instanceof PanelAdapter.PageData)) {
      paramRecyclerView.setTag(new PanelAdapter.PageData(PanelAdapter.PageData.b((PanelAdapter.PageData)paramRecyclerView.getTag()), XPanelContainer.d, null));
    }
    for (;;)
    {
      QLog.d("PanelIconAdapter", 1, new Object[] { "updateRecyclerViewAddedHeight -> XPanelContainer.mExternalPanelheight : ", Integer.valueOf(XPanelContainer.jdField_a_of_type_Int), ", XPanelContainer.mDefaultExternalPanelheight : ", Integer.valueOf(XPanelContainer.b), ", XPanelContainer.mAddedHeight -> ", Integer.valueOf(XPanelContainer.d) });
      return;
      paramRecyclerView.setTag(new PanelAdapter.PageData(0, XPanelContainer.d, null));
    }
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
    paramInt = i * paramInt;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      i = Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), i + paramInt);
      return this.jdField_a_of_type_JavaUtilArrayList.subList(paramInt, i);
    }
    return new ArrayList(0);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    for (;;)
    {
      return;
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
    if ((this.jdField_a_of_type_Int == 0) || (this.b == 0) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      return 0;
    }
    return (this.jdField_a_of_type_JavaUtilArrayList.size() + this.jdField_a_of_type_Int * this.b - 1) / (this.jdField_a_of_type_Int * this.b);
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
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconAdapter", 2, "instantiateItem " + paramInt);
    }
    RecyclerView localRecyclerView1 = (RecyclerView)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.getScrapView();
    if (localRecyclerView1 != null)
    {
      int i = b(localRecyclerView1);
      QLog.d("PanelIconAdapter", 1, new Object[] { "reuseViewAddedHeight -> ", Integer.valueOf(i), ", XPanelContainer.mAddedHeight -> ", Integer.valueOf(XPanelContainer.d), ", XPanelContainer.mDefaultExternalPanelheight: ", Integer.valueOf(XPanelContainer.b), ", XPanelContainer.mExternalPanelheight: ", Integer.valueOf(XPanelContainer.jdField_a_of_type_Int) });
      if (i != XPanelContainer.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.clearScrapViews();
        localRecyclerView1 = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      RecyclerView localRecyclerView2 = localRecyclerView1;
      if (localRecyclerView1 == null)
      {
        localRecyclerView2 = new RecyclerView(this.jdField_a_of_type_AndroidContentContext, null);
        a(localRecyclerView2);
        localRecyclerView2.setOverScrollMode(2);
        localRecyclerView2.setLayoutManager(new PanelAdapter.1(this, this.jdField_a_of_type_AndroidContentContext, a()));
      }
      a(paramInt, localRecyclerView2);
      if ((localRecyclerView2.getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView(localRecyclerView2);
      }
      return localRecyclerView2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.pluspanel.PanelAdapter
 * JD-Core Version:    0.7.0.1
 */