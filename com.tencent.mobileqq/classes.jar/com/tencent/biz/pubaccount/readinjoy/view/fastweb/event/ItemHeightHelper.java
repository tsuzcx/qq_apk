package com.tencent.biz.pubaccount.readinjoy.view.fastweb.event;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.FastWebMergeAdapter.OnGetViewListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import java.util.List;

public class ItemHeightHelper
  implements FastWebMergeAdapter.OnGetViewListener
{
  private final XListView jdField_a_of_type_ComTencentWidgetXListView;
  private final List<BaseData> jdField_a_of_type_JavaUtilList;
  
  public ItemHeightHelper(XListView paramXListView, List<BaseData> paramList, FastWebMergeAdapter paramFastWebMergeAdapter)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramFastWebMergeAdapter.a(this);
  }
  
  private FastWebMergeAdapter a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() instanceof HeaderViewListAdapter))
    {
      HeaderViewListAdapter localHeaderViewListAdapter = (HeaderViewListAdapter)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter();
      if ((localHeaderViewListAdapter.getWrappedAdapter() instanceof FastWebMergeAdapter)) {
        return (FastWebMergeAdapter)localHeaderViewListAdapter.getWrappedAdapter();
      }
    }
    return null;
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0)) {
      return true;
    }
    if ((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt) == null)
    {
      AIOUtils.a("ItemHeightHelper", "", new IllegalArgumentException(" data == null index: " + paramInt + "   itemArrayList.size() :" + this.jdField_a_of_type_JavaUtilList.size()));
      return true;
    }
    return false;
  }
  
  private int b(int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getWidth();
    int i = Utils.dp2px(300.0D);
    j = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
    if ((Build.VERSION.SDK_INT <= 19) && (paramInt == 0)) {}
    Object localObject;
    do
    {
      return i;
      localObject = a();
    } while (localObject == null);
    try
    {
      localObject = ((FastWebMergeAdapter)localObject).a(paramInt, null, this.jdField_a_of_type_ComTencentWidgetXListView, true);
      ((View)localObject).measure(j, 0);
      j = ((View)localObject).getMeasuredHeight();
      QLog.d("ItemHeightHelper", 2, "getItemMeasureHeight index : " + paramInt + " height : " + j);
      return j;
    }
    catch (Exception localException)
    {
      QLog.d("ItemHeightHelper", 2, localException, new Object[] { " index : " + paramInt });
    }
    return i;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int a(int paramInt)
  {
    if (a(paramInt)) {
      return -1;
    }
    BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localBaseData.v > 0) {
      return localBaseData.v;
    }
    localBaseData.v = b(paramInt);
    return localBaseData.v;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (a(paramInt1)) {
      return;
    }
    ((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).v = paramInt2;
    QLog.d("ItemHeightHelper", 2, " index : " + paramInt1 + "   height: " + paramInt2);
  }
  
  public void a(int paramInt, View paramView)
  {
    if (a(paramInt)) {}
    while (((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).v > 0) {
      return;
    }
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ItemHeightHelper.1(this, paramInt, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemHeightHelper
 * JD-Core Version:    0.7.0.1
 */