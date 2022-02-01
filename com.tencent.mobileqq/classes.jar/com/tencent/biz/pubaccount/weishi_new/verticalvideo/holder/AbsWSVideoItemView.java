package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbsWSVideoItemView
  implements IWSItemView<WSVerticalItemData>
{
  public Context a;
  public View a;
  private AbsWsUIGroup<WSVerticalItemData> jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  public WSVerticalPageFragment a;
  private WSVerticalVideoRelativeLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout;
  public WSVerticalVideoHolder a;
  public Map<String, AbsWsUIGroup<WSVerticalItemData>> a;
  private View jdField_b_of_type_AndroidViewView;
  private AbsWsUIGroup<WSVerticalItemData> jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  
  public AbsWSVideoItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
    if (paramWSVerticalVideoHolder != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramWSVerticalVideoHolder.itemView;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
    d();
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381610);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout = ((WSVerticalVideoRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381545));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381555);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new WSVerticalItemVideoAreaController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(localViewStub);
      a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381549);
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new WSVerticalItemVideoProgressController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout);
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(localViewStub);
      a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup);
    }
  }
  
  public View a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup instanceof WSVerticalItemVideoAreaController)) {
      return ((WSVerticalItemVideoAreaController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).a();
    }
    return null;
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup instanceof WSVerticalItemVideoAreaController)) {
      return ((WSVerticalItemVideoAreaController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).a();
    }
    return null;
  }
  
  public AbsWsUIGroup a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)localIterator.next()).getValue()).d();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)localIterator.next()).getValue()).b(paramInt);
      }
    }
  }
  
  public void a(AbsWsUIGroup<WSVerticalItemData> paramAbsWsUIGroup)
  {
    if (paramAbsWsUIGroup != null) {
      this.jdField_a_of_type_JavaUtilMap.put(paramAbsWsUIGroup.getClass().getName(), paramAbsWsUIGroup);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)localIterator.next()).getValue()).a(paramWSVerticalItemData);
      }
    }
  }
  
  public View b()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public AbsWsUIGroup b()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        AbsWsUIGroup localAbsWsUIGroup = (AbsWsUIGroup)((Map.Entry)localIterator.next()).getValue();
        if ((localAbsWsUIGroup instanceof AbsWsVerticalUIGroup)) {
          ((AbsWsVerticalUIGroup)localAbsWsUIGroup).c(paramInt);
        }
      }
    }
  }
  
  public void b(WSVerticalItemData paramWSVerticalItemData) {}
  
  public void c(WSVerticalItemData paramWSVerticalItemData)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((!TextUtils.equals((CharSequence)localEntry.getKey(), WSVerticalItemVideoAreaController.class.getName())) && (!TextUtils.equals((CharSequence)localEntry.getKey(), WSVerticalItemVideoProgressController.class.getName()))) {
          ((AbsWsUIGroup)localEntry.getValue()).a(paramWSVerticalItemData);
        }
      }
    }
  }
  
  public void d()
  {
    e();
    f();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView
 * JD-Core Version:    0.7.0.1
 */