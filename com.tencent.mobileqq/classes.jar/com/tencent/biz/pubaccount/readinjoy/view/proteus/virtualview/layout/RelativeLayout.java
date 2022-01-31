package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout;

import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.RelativeLayoutHelper;
import java.util.Iterator;
import java.util.List;

public class RelativeLayout
  extends Layout
{
  private RelativeLayoutHelper a;
  private List b;
  private List c;
  
  public RelativeLayout(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper = new RelativeLayoutHelper();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i;
    if (-2147483648 == paramInt1)
    {
      i = paramInt2;
      if (paramInt2 <= 0) {
        i = l();
      }
    }
    do
    {
      return i;
      i = paramInt2;
    } while (1073741824 == paramInt1);
    return l();
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int i;
    if (-2147483648 == paramInt1)
    {
      i = paramInt2;
      if (paramInt2 <= 0) {
        i = m();
      }
    }
    do
    {
      return i;
      i = paramInt2;
    } while (1073741824 == paramInt1);
    return m();
  }
  
  private List b()
  {
    if ((this.b == null) || (this.b.size() != this.jdField_a_of_type_JavaUtilList.size()))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.a() == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.a(this);
      }
      this.b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.a();
      this.b = this.jdField_a_of_type_JavaUtilList;
    }
    return this.b;
  }
  
  private List c()
  {
    if ((this.c == null) || (this.c.size() != this.jdField_a_of_type_JavaUtilList.size()))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.a() == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.a(this);
      }
      this.c = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.b();
      this.c = this.jdField_a_of_type_JavaUtilList;
    }
    return this.c;
  }
  
  private int l()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.d())
      {
        RelativeLayout.Params localParams = (RelativeLayout.Params)localViewBase.b();
        int j = localParams.g;
        j = localViewBase.a() + j + localParams.d;
        if (j <= i) {
          break label99;
        }
        i = j;
      }
    }
    label99:
    for (;;)
    {
      break;
      return this.q + this.r + (this.e << 1) + i;
    }
  }
  
  private int m()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.d())
      {
        RelativeLayout.Params localParams = (RelativeLayout.Params)localViewBase.b();
        int j = localParams.h;
        j = localViewBase.k() + j + localParams.f;
        if (j <= i) {
          break label99;
        }
        i = j;
      }
    }
    label99:
    for (;;)
    {
      break;
      return this.q + this.r + (this.e << 1) + i;
    }
  }
  
  public RelativeLayout.Params a()
  {
    return new RelativeLayout.Params();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (k != 0) {}
    for (;;)
    {
      if (m != 0) {}
      for (;;)
      {
        List localList = b();
        int n = localList.size();
        boolean bool1;
        boolean bool2;
        label67:
        label70:
        ViewBase localViewBase;
        int i;
        RelativeLayout.Params localParams;
        if (k != 1073741824)
        {
          bool1 = true;
          if (m == 1073741824) {
            break label197;
          }
          bool2 = true;
          j = 0;
          if (j >= n) {
            break label206;
          }
          localViewBase = (ViewBase)localList.get(j);
          i = paramInt1;
          if (localViewBase.c() != 2)
          {
            localParams = (RelativeLayout.Params)localViewBase.b();
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.a(localParams, paramInt1);
            i = paramInt1;
            if (bool1)
            {
              i = paramInt1;
              if (localParams.a == -1)
              {
                i = l();
                if (i <= 0) {
                  break label203;
                }
                paramInt1 = i;
              }
            }
          }
        }
        label197:
        label203:
        for (;;)
        {
          i = paramInt1;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.a(localViewBase, localParams, i, paramInt2);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.a(localViewBase, localParams, i, bool1);
          j += 1;
          paramInt1 = i;
          break label70;
          bool1 = false;
          break;
          bool2 = false;
          break label67;
        }
        label206:
        localList = c();
        int j = 0;
        if (j < n)
        {
          localViewBase = (ViewBase)localList.get(j);
          i = paramInt2;
          if (localViewBase.c() != 2)
          {
            localParams = (RelativeLayout.Params)localViewBase.b();
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.b(localParams, paramInt2);
            i = paramInt2;
            if (bool2)
            {
              i = paramInt2;
              if (localParams.b == -1)
              {
                i = m();
                if (i <= 0) {
                  break label337;
                }
                paramInt2 = i;
              }
            }
          }
          label337:
          for (;;)
          {
            i = paramInt2;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.b(localViewBase, localParams, paramInt1, i);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutHelperRelativeLayoutHelper.a(localViewBase, localParams, i, bool2);
            j += 1;
            paramInt2 = i;
            break;
          }
        }
        b(a(k, paramInt1), b(m, paramInt2));
        return;
        paramInt2 = -1;
      }
      paramInt1 = -1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (!localViewBase.d())
      {
        RelativeLayout.Params localParams = (RelativeLayout.Params)localViewBase.b();
        localViewBase.b(localParams.g + paramInt1, localParams.h + paramInt2, localParams.i + paramInt1, localParams.j + paramInt2);
      }
    }
  }
  
  protected boolean a(int paramInt, String paramString)
  {
    boolean bool = super.a(paramInt, paramString);
    if (!bool) {}
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout
 * JD-Core Version:    0.7.0.1
 */