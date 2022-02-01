package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tjw;

public class ReadInJoyDiandianHeaderController$ViewPagerAdapter
  extends PagerAdapter
  implements tjw
{
  private List<MeasureGridView> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  ReadInJoyDiandianHeaderController$ViewPagerAdapter(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int a(int paramInt)
  {
    int j = a();
    int i = 0;
    if (j > 1)
    {
      if (paramInt == 0) {
        i = j - 1;
      }
    }
    else {
      return i;
    }
    if (paramInt > j) {
      return paramInt - j - 1;
    }
    return paramInt - 1;
  }
  
  public void a(List<MeasureGridView> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController, new View[getCount()]);
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    QLog.d("ReadInJoyDiandianHeaderController", 2, "destroyItem position : " + paramInt + " object: " + paramObject);
    paramViewGroup.removeView((View)paramObject);
    if (paramInt < ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController).length) {
      ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController)[paramInt] = null;
    }
  }
  
  public int getCount()
  {
    int i = a();
    if (i <= 1) {
      return i;
    }
    return i + 3;
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (MeasureGridView)paramObject;
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramObject);
    if (i >= 0) {
      return i;
    }
    return -2;
  }
  
  public float getPageWidth(int paramInt)
  {
    return 0.95F;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = null;
    QLog.d("ReadInJoyDiandianHeaderController", 2, "instantiateItem " + paramViewGroup + "  " + paramInt);
    int i = a();
    Object localObject2;
    if (i == 0)
    {
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyDiandianHeaderController", 2, "data list count is 0");
        localObject2 = localObject1;
      }
    }
    do
    {
      return localObject2;
      if ((i > 1) && ((paramInt == 1) || (paramInt == i) || (paramInt == i + 1))) {
        if (paramViewGroup == null)
        {
          if (ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController)[paramInt] != null) {
            return ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController)[paramInt];
          }
        }
        else
        {
          if ((ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController)[paramInt] == null) || (ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController)[paramInt].getParent() != null)) {
            ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController)[paramInt] = ((View)instantiateItem(null, paramInt));
          }
          paramViewGroup.addView(ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController)[paramInt]);
          return ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController)[paramInt];
        }
      }
      i = a(paramInt);
      localObject2 = (View)this.jdField_a_of_type_JavaUtilList.get(i);
      localObject1 = localObject2;
      if (((View)localObject2).getParent() != null) {
        localObject1 = ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController, i);
      }
      ReadInJoyDiandianHeaderController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyDiandianHeaderController)[paramInt] = localObject1;
      QLog.d("ReadInJoyDiandianHeaderController", 2, "childs " + paramInt);
      localObject2 = localObject1;
    } while (paramViewGroup == null);
    paramViewGroup.addView((View)localObject1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.ViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */