package com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FastWebMergeAdapter
  extends BaseAdapter
{
  private FastWebMergeAdapter.OnDataSetChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener;
  private FastWebMergeAdapter.OnGetViewListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter$OnGetViewListener;
  private List<BaseAdapter> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private View a(ViewGroup paramViewGroup)
  {
    View localView = null;
    if (paramViewGroup != null)
    {
      localView = new View(paramViewGroup.getContext());
      localView.setVisibility(8);
    }
    return localView;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }
  
  public List<BaseAdapter> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a() {}
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramBaseAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBaseAdapter);
    paramBaseAdapter.registerDataSetObserver(new FastWebMergeAdapter.1(this));
  }
  
  public void a(FastWebMergeAdapter.OnDataSetChangeListener paramOnDataSetChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener = paramOnDataSetChangeListener;
  }
  
  public void a(FastWebMergeAdapter.OnGetViewListener paramOnGetViewListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter$OnGetViewListener = paramOnGetViewListener;
  }
  
  public void b(BaseAdapter paramBaseAdapter)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramBaseAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramBaseAdapter);
  }
  
  public int getCount()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((BaseAdapter)localIterator.next()).getCount() + i) {}
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)localIterator.next();
      int i = localBaseAdapter.getCount();
      if (paramInt < i) {
        return localBaseAdapter.getItem(paramInt);
      }
      paramInt -= i;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)localIterator.next();
      int i = localBaseAdapter.getCount();
      if (paramInt < i) {
        return localBaseAdapter.getItemId(paramInt);
      }
      paramInt -= i;
    }
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    BaseAdapter localBaseAdapter;
    if (localIterator.hasNext())
    {
      localBaseAdapter = (BaseAdapter)localIterator.next();
      j = localBaseAdapter.getCount();
      if (i >= j) {}
    }
    for (i = localBaseAdapter.getItemViewType(i);; i = -1)
    {
      return i + paramInt;
      i -= j;
      paramInt = localBaseAdapter.getViewTypeCount() + paramInt;
      break;
    }
  }
  
  /* Error */
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/biz/pubaccount/readinjoy/view/fastweb/adapter/FastWebMergeAdapter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: invokeinterface 75 1 0
    //   9: astore 7
    //   11: iload_1
    //   12: istore 4
    //   14: aload 7
    //   16: invokeinterface 81 1 0
    //   21: ifeq +129 -> 150
    //   24: aload 7
    //   26: invokeinterface 85 1 0
    //   31: checkcast 4	android/widget/BaseAdapter
    //   34: astore 6
    //   36: aload 6
    //   38: invokevirtual 87	android/widget/BaseAdapter:getCount	()I
    //   41: istore 5
    //   43: iload 4
    //   45: iload 5
    //   47: if_icmpge +52 -> 99
    //   50: aload 6
    //   52: iload 4
    //   54: aload_2
    //   55: aload_3
    //   56: invokevirtual 107	android/widget/BaseAdapter:getView	(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   59: astore 6
    //   61: aload_0
    //   62: getfield 65	com/tencent/biz/pubaccount/readinjoy/view/fastweb/adapter/FastWebMergeAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter$OnGetViewListener	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/adapter/FastWebMergeAdapter$OnGetViewListener;
    //   65: ifnull +34 -> 99
    //   68: aload_0
    //   69: getfield 65	com/tencent/biz/pubaccount/readinjoy/view/fastweb/adapter/FastWebMergeAdapter:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter$OnGetViewListener	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/adapter/FastWebMergeAdapter$OnGetViewListener;
    //   72: iload_1
    //   73: aload 6
    //   75: invokeinterface 112 3 0
    //   80: invokestatic 118	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   83: iload 4
    //   85: aload_2
    //   86: aload_3
    //   87: aload_0
    //   88: iload 4
    //   90: invokevirtual 119	com/tencent/biz/pubaccount/readinjoy/view/fastweb/adapter/FastWebMergeAdapter:getItemId	(I)J
    //   93: invokevirtual 123	com/tencent/qqlive/module/videoreport/collect/EventCollector:onListGetView	(ILandroid/view/View;Landroid/view/ViewGroup;J)V
    //   96: aload 6
    //   98: areturn
    //   99: iload 4
    //   101: iload 5
    //   103: isub
    //   104: istore 4
    //   106: goto -92 -> 14
    //   109: astore 6
    //   111: iload_1
    //   112: istore 4
    //   114: ldc 125
    //   116: iconst_1
    //   117: new 127	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   124: ldc 130
    //   126: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 6
    //   131: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_0
    //   141: aload_3
    //   142: invokespecial 149	com/tencent/biz/pubaccount/readinjoy/view/fastweb/adapter/FastWebMergeAdapter:a	(Landroid/view/ViewGroup;)Landroid/view/View;
    //   145: astore 6
    //   147: goto -67 -> 80
    //   150: aconst_null
    //   151: astore 6
    //   153: goto -73 -> 80
    //   156: astore 6
    //   158: goto -44 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	FastWebMergeAdapter
    //   0	161	1	paramInt	int
    //   0	161	2	paramView	View
    //   0	161	3	paramViewGroup	ViewGroup
    //   12	101	4	i	int
    //   41	63	5	j	int
    //   34	63	6	localObject	Object
    //   109	21	6	localException1	java.lang.Exception
    //   145	7	6	localView	View
    //   156	1	6	localException2	java.lang.Exception
    //   9	16	7	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   0	11	109	java/lang/Exception
    //   14	43	156	java/lang/Exception
    //   50	80	156	java/lang/Exception
  }
  
  public int getViewTypeCount()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((BaseAdapter)localIterator.next()).getViewTypeCount() + i) {}
    return Math.max(i, 1);
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.FastWebMergeAdapter
 * JD-Core Version:    0.7.0.1
 */