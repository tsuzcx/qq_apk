package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper;

import android.text.TextUtils;
import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout.Params;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import muo;

public class RelativeLayoutHelper
{
  private RelativeLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout;
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = 1073741824;
    int k = 0;
    int m = 0;
    int j;
    if (paramInt8 < 0)
    {
      j = 1;
      if (j == 0) {
        break label76;
      }
      if ((paramInt1 == -2147483648) || (paramInt2 == -2147483648)) {
        break label58;
      }
      paramInt3 = Math.max(0, paramInt2 - paramInt1);
      paramInt1 = 1073741824;
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
      j = 0;
      break;
      label58:
      if (paramInt3 >= 0)
      {
        paramInt1 = 1073741824;
      }
      else
      {
        paramInt3 = 0;
        paramInt1 = m;
      }
    }
    label76:
    if (paramInt1 == -2147483648) {}
    for (paramInt4 = paramInt6 + paramInt4;; paramInt4 = paramInt1)
    {
      if (paramInt2 == -2147483648) {}
      for (paramInt5 = paramInt8 - paramInt7 - paramInt5;; paramInt5 = paramInt2)
      {
        paramInt4 = paramInt5 - paramInt4;
        if ((paramInt1 != -2147483648) && (paramInt2 != -2147483648))
        {
          paramInt2 = i;
          if (j != 0) {
            paramInt2 = 0;
          }
          paramInt1 = Math.max(0, paramInt4);
        }
        for (;;)
        {
          return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
          if (paramInt3 >= 0)
          {
            if (paramInt4 >= 0)
            {
              paramInt1 = Math.min(paramInt4, paramInt3);
              paramInt2 = i;
            }
            else
            {
              paramInt1 = paramInt3;
              paramInt2 = i;
            }
          }
          else if (paramInt3 == -1)
          {
            paramInt2 = i;
            if (j != 0) {
              paramInt2 = 0;
            }
            paramInt1 = Math.max(0, paramInt4);
          }
          else if (paramInt3 == -2)
          {
            paramInt2 = 0;
            paramInt1 = k;
          }
          else
          {
            paramInt2 = 0;
            paramInt1 = k;
          }
        }
      }
    }
  }
  
  private RelativeLayout.Params a(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString[paramInt] == null) {
      return null;
    }
    paramArrayOfString = (muo)this.jdField_a_of_type_JavaUtilMap.get(paramArrayOfString[paramInt]);
    if ((paramArrayOfString == null) || (paramArrayOfString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.d())) {
      return null;
    }
    return (RelativeLayout.Params)paramArrayOfString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.b();
  }
  
  private List a(List paramList, int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      Object localObject1 = (ViewBase)paramList.get(i);
      localObject1 = (muo)this.jdField_a_of_type_JavaUtilMap.get(((ViewBase)localObject1).c());
      String[] arrayOfString = ((RelativeLayout.Params)((muo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.b()).a();
      int m = paramArrayOfInt.length;
      int j = 0;
      if (j < m)
      {
        Object localObject2 = arrayOfString[paramArrayOfInt[j]];
        if (localObject2 != null)
        {
          localObject2 = (muo)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
          if ((localObject2 != null) && (localObject2 != localObject1)) {
            break label143;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          label143:
          ((muo)localObject2).jdField_a_of_type_JavaUtilList.add(localObject1);
          ((muo)localObject1).b.add(localObject2);
        }
      }
      i += 1;
    }
    paramList = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (paramList.hasNext())
    {
      paramArrayOfInt = (muo)((Map.Entry)paramList.next()).getValue();
      if (paramArrayOfInt.b.isEmpty()) {
        localArrayList.add(paramArrayOfInt);
      }
    }
    return localArrayList;
  }
  
  private static Map a(List paramList)
  {
    HashMap localHashMap = new HashMap(paramList.size());
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    ViewBase localViewBase;
    muo localmuo;
    while (paramList.hasNext())
    {
      localViewBase = (ViewBase)paramList.next();
      if (TextUtils.isEmpty(localViewBase.c()))
      {
        ((List)localObject).add(localViewBase);
      }
      else
      {
        localmuo = new muo();
        localmuo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = localViewBase;
        localHashMap.put(localViewBase.c(), localmuo);
      }
    }
    localObject = ((List)localObject).iterator();
    int i = 10000;
    while (((Iterator)localObject).hasNext())
    {
      localViewBase = (ViewBase)((Iterator)localObject).next();
      localmuo = new muo();
      localmuo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = localViewBase;
      int j;
      for (paramList = String.valueOf(i); localHashMap.containsKey(paramList); paramList = String.valueOf(j))
      {
        j = i + 1;
        i = j;
      }
      localViewBase.b(paramList);
      localHashMap.put(localViewBase.c(), localmuo);
    }
    return localHashMap;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout == null) || (this.jdField_a_of_type_JavaUtilList == null)) {
      throw new IllegalArgumentException("subViews 为 null");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.a() != this.jdField_a_of_type_JavaUtilList) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.a().size() != this.jdField_a_of_type_JavaUtilList.size())) {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.a();
    }
    this.jdField_a_of_type_JavaUtilMap = a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private static void a(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt)
  {
    int i = paramViewBase.a();
    paramInt = (paramInt - i) / 2;
    paramParams.g = paramInt;
    paramParams.i = (i + paramInt);
  }
  
  private static void a(List paramList, String paramString)
  {
    Iterator localIterator = paramList.iterator();
    muo localmuo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localmuo = (muo)localIterator.next();
    } while (!localmuo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.c().equals(paramString));
    for (paramString = localmuo;; paramString = null)
    {
      paramList.remove(paramString);
      return;
    }
  }
  
  private static void b(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt)
  {
    int i = paramViewBase.b();
    paramInt = (paramInt - i) / 2;
    paramParams.h = paramInt;
    paramParams.j = (i + paramInt);
  }
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout;
  }
  
  public List a()
  {
    List localList = a(RelativeLayout.Params.jdField_b_of_type_ArrayOfInt);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (localViewBase.b().jdField_a_of_type_Int == -1) {
        localArrayList.add(localViewBase);
      }
    }
    localList.removeAll(localArrayList);
    localList.addAll(localArrayList);
    return localList;
  }
  
  public List a(int[] paramArrayOfInt)
  {
    a();
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    paramArrayOfInt = a(this.jdField_a_of_type_JavaUtilList, paramArrayOfInt);
    int i = 0;
    while (i < paramArrayOfInt.size())
    {
      Object localObject1 = (muo)paramArrayOfInt.get(i);
      Object localObject2 = ((muo)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
      String str = ((ViewBase)localObject2).c();
      localArrayList.add(localObject2);
      localObject1 = ((muo)localObject1).jdField_a_of_type_JavaUtilList;
      int k = ((List)localObject1).size();
      int j = 0;
      while (j < k)
      {
        localObject2 = (muo)((List)localObject1).get(j);
        List localList = ((muo)localObject2).b;
        a(localList, str);
        if (localList.size() == 0) {
          paramArrayOfInt.add(localObject2);
        }
        j += 1;
      }
      i += 1;
    }
    if (paramArrayOfInt.size() != this.jdField_a_of_type_JavaUtilList.size()) {
      throw new IllegalStateException("Circular dependencies cannot exist in RelativeLayout");
    }
    return localArrayList;
  }
  
  public void a(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt1, int paramInt2)
  {
    int i = a(paramParams.g, paramParams.i, paramParams.jdField_a_of_type_Int, paramParams.c, paramParams.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.f(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.h(), paramInt1);
    if (paramInt2 < 0)
    {
      if (paramParams.jdField_b_of_type_Int >= 0) {}
      for (paramInt1 = View.MeasureSpec.makeMeasureSpec(paramParams.jdField_b_of_type_Int, 1073741824);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
      {
        paramViewBase.c(i, paramInt1);
        return;
      }
    }
    paramInt2 = Math.max(0, paramInt2 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.g() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.i() - paramParams.e - paramParams.f);
    if (paramParams.jdField_b_of_type_Int == -1) {}
    for (paramInt1 = 1073741824;; paramInt1 = -2147483648)
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, paramInt1);
      break;
    }
  }
  
  public void a(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt, boolean paramBoolean)
  {
    String[] arrayOfString = paramParams.a();
    if ((paramParams.g == -2147483648) && (paramParams.i != -2147483648)) {
      paramParams.g = (paramParams.i - paramViewBase.a());
    }
    do
    {
      return;
      if ((paramParams.g != -2147483648) && (paramParams.i == -2147483648))
      {
        paramParams.i = (paramParams.g + paramViewBase.a());
        return;
      }
    } while ((paramParams.g != -2147483648) || (paramParams.i != -2147483648));
    if ((arrayOfString[10] != null) || (arrayOfString[9] != null))
    {
      if (!paramBoolean)
      {
        a(paramViewBase, paramParams, paramInt);
        return;
      }
      paramParams.g = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.f() + paramParams.c);
      paramParams.i = (paramParams.g + paramViewBase.a());
      return;
    }
    paramParams.g = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.f() + paramParams.c);
    paramParams.i = (paramParams.g + paramViewBase.a());
  }
  
  public void a(RelativeLayout.Params paramParams, int paramInt)
  {
    String[] arrayOfString = paramParams.a();
    paramParams.g = -2147483648;
    paramParams.i = -2147483648;
    RelativeLayout.Params localParams = a(arrayOfString, 2);
    if (localParams != null) {
      paramParams.i = (localParams.g - (localParams.c + paramParams.d));
    }
    localParams = a(arrayOfString, 3);
    if (localParams != null)
    {
      int i = localParams.i;
      paramParams.g = (localParams.d + paramParams.c + i);
    }
    if (arrayOfString[4] != null) {
      paramParams.g = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.f() + paramParams.c);
    }
    if ((arrayOfString[5] != null) && (paramInt >= 0)) {
      paramParams.i = (paramInt - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.h() - paramParams.d);
    }
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_JavaUtilList = paramRelativeLayout.a();
    this.jdField_a_of_type_JavaUtilMap = a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public boolean a(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt, boolean paramBoolean)
  {
    String[] arrayOfString = paramParams.a();
    if ((paramParams.h == -2147483648) && (paramParams.j != -2147483648)) {
      paramParams.h = (paramParams.j - paramViewBase.b());
    }
    while (arrayOfString[7] != null)
    {
      return true;
      if ((paramParams.h != -2147483648) && (paramParams.j == -2147483648))
      {
        paramParams.j = (paramParams.h + paramViewBase.b());
      }
      else if ((paramParams.h == -2147483648) && (paramParams.j == -2147483648))
      {
        if ((arrayOfString[10] != null) || (arrayOfString[8] != null))
        {
          if (!paramBoolean)
          {
            b(paramViewBase, paramParams, paramInt);
            return true;
          }
          paramParams.h = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.g() + paramParams.e);
          paramParams.j = (paramParams.h + paramViewBase.b());
          return true;
        }
        paramParams.h = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.g() + paramParams.e);
        paramParams.j = (paramParams.h + paramViewBase.b());
      }
    }
    return false;
  }
  
  public List b()
  {
    List localList = a(RelativeLayout.Params.jdField_a_of_type_ArrayOfInt);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ViewBase localViewBase = (ViewBase)localIterator.next();
      if (localViewBase.b().jdField_b_of_type_Int == -1) {
        localArrayList.add(localViewBase);
      }
    }
    localList.removeAll(localArrayList);
    localList.addAll(localArrayList);
    return localList;
  }
  
  public void b(ViewBase paramViewBase, RelativeLayout.Params paramParams, int paramInt1, int paramInt2)
  {
    paramViewBase.c(a(paramParams.g, paramParams.i, paramParams.jdField_a_of_type_Int, paramParams.c, paramParams.d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.f(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.h(), paramInt1), a(paramParams.h, paramParams.j, paramParams.jdField_b_of_type_Int, paramParams.e, paramParams.f, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.g(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.i(), paramInt2));
  }
  
  public void b(RelativeLayout.Params paramParams, int paramInt)
  {
    String[] arrayOfString = paramParams.a();
    paramParams.h = -2147483648;
    paramParams.j = -2147483648;
    RelativeLayout.Params localParams = a(arrayOfString, 0);
    int i;
    if (localParams != null)
    {
      paramParams.j = (localParams.h - (localParams.e + paramParams.f));
      localParams = a(arrayOfString, 1);
      if (localParams == null) {
        break label182;
      }
      i = localParams.j;
    }
    for (paramParams.h = (localParams.f + paramParams.e + i);; paramParams.h = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.g() + paramParams.e)) {
      label182:
      do
      {
        if (arrayOfString[6] != null) {
          paramParams.h = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.g() + paramParams.e);
        }
        if ((arrayOfString[7] != null) && (paramInt >= 0)) {
          paramParams.j = (paramInt - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.i() - paramParams.f);
        }
        return;
        if ((!paramParams.jdField_a_of_type_Boolean) || (arrayOfString[0] == null) || (paramInt < 0)) {
          break;
        }
        paramParams.j = (paramInt - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewLayoutRelativeLayout.i() - paramParams.f);
        break;
      } while ((!paramParams.jdField_a_of_type_Boolean) || (arrayOfString[1] == null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.RelativeLayoutHelper
 * JD-Core Version:    0.7.0.1
 */