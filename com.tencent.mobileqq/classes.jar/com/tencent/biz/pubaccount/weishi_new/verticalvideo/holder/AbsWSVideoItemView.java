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
    b();
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131380843);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout = ((WSVerticalVideoRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380780));
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (ViewStub)((View)localObject).findViewById(2131380791);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new WSVerticalItemVideoAreaController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a((ViewStub)localObject);
      a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup);
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (ViewStub)((View)localObject).findViewById(2131380785);
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new WSVerticalItemVideoProgressController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout);
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a((ViewStub)localObject);
      a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup);
    }
  }
  
  public View a()
  {
    AbsWsUIGroup localAbsWsUIGroup = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
    if ((localAbsWsUIGroup instanceof WSVerticalItemVideoAreaController)) {
      return ((WSVerticalItemVideoAreaController)localAbsWsUIGroup).b();
    }
    return null;
  }
  
  public FrameLayout a()
  {
    AbsWsUIGroup localAbsWsUIGroup = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
    if ((localAbsWsUIGroup instanceof WSVerticalItemVideoAreaController)) {
      return ((WSVerticalItemVideoAreaController)localAbsWsUIGroup).a();
    }
    return null;
  }
  
  public AbsWsUIGroup a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue()).d();
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue()).b(paramInt);
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
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramWSVerticalItemData);
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
  
  public void b()
  {
    e();
    f();
    g();
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsWsUIGroup localAbsWsUIGroup = (AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localAbsWsUIGroup instanceof AbsWsVerticalUIGroup)) {
          ((AbsWsVerticalUIGroup)localAbsWsUIGroup).c(paramInt);
        }
      }
    }
  }
  
  public void b(WSVerticalItemData paramWSVerticalItemData) {}
  
  public void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsWsUIGroup localAbsWsUIGroup = (AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localAbsWsUIGroup instanceof AbsWsVerticalUIGroup)) {
          ((AbsWsVerticalUIGroup)localAbsWsUIGroup).d(paramInt);
        }
      }
    }
  }
  
  public void c(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if ((!TextUtils.equals((CharSequence)localEntry.getKey(), WSVerticalItemVideoAreaController.class.getName())) && (!TextUtils.equals((CharSequence)localEntry.getKey(), WSVerticalItemVideoProgressController.class.getName()))) {
        ((AbsWsUIGroup)localEntry.getValue()).a(paramWSVerticalItemData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView
 * JD-Core Version:    0.7.0.1
 */