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
  private AbsWsUIGroup<WSVerticalItemData> a;
  private AbsWsUIGroup<WSVerticalItemData> b;
  private WSVerticalVideoRelativeLayout c;
  public Map<String, AbsWsUIGroup<WSVerticalItemData>> d = new HashMap();
  public WSVerticalPageFragment e;
  public WSVerticalVideoHolder f;
  public Context g;
  public View h;
  private View i;
  
  public AbsWSVideoItemView(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    this.g = paramContext;
    this.f = paramWSVerticalVideoHolder;
    if (paramWSVerticalVideoHolder != null)
    {
      this.h = paramWSVerticalVideoHolder.itemView;
      this.e = paramWSVerticalVideoHolder.d;
    }
    b();
  }
  
  private void e()
  {
    this.i = this.h.findViewById(2131449819);
    this.c = ((WSVerticalVideoRelativeLayout)this.h.findViewById(2131449750));
  }
  
  private void f()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = (ViewStub)((View)localObject).findViewById(2131449761);
      this.a = new WSVerticalItemVideoAreaController(this.g, this.f);
      this.a.a((ViewStub)localObject);
      a(this.a);
    }
  }
  
  private void l()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = (ViewStub)((View)localObject).findViewById(2131449755);
      this.b = new WSVerticalItemVideoProgressController(this.g, this.f, this.c);
      this.b.a((ViewStub)localObject);
      a(this.b);
    }
  }
  
  public void a()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue()).g();
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.d;
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
      this.d.put(paramAbsWsUIGroup.getClass().getName(), paramAbsWsUIGroup);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    this.i.setVisibility(0);
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramWSVerticalItemData);
      }
    }
  }
  
  public void b()
  {
    e();
    f();
    l();
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.d;
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
  
  public void b(WSVerticalItemData paramWSVerticalItemData) {}
  
  public void c(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsWsUIGroup localAbsWsUIGroup = (AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localAbsWsUIGroup instanceof AbsWsVerticalUIGroup)) {
          ((AbsWsVerticalUIGroup)localAbsWsUIGroup).e(paramInt);
        }
      }
    }
  }
  
  public void c(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject = this.d;
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
  
  public AbsWsUIGroup<WSVerticalItemData> g()
  {
    return this.a;
  }
  
  public AbsWsUIGroup<WSVerticalItemData> h()
  {
    return this.b;
  }
  
  public FrameLayout i()
  {
    AbsWsUIGroup localAbsWsUIGroup = this.a;
    if ((localAbsWsUIGroup instanceof WSVerticalItemVideoAreaController)) {
      return ((WSVerticalItemVideoAreaController)localAbsWsUIGroup).l();
    }
    return null;
  }
  
  public View j()
  {
    AbsWsUIGroup localAbsWsUIGroup = this.a;
    if ((localAbsWsUIGroup instanceof WSVerticalItemVideoAreaController)) {
      return ((WSVerticalItemVideoAreaController)localAbsWsUIGroup).m();
    }
    return null;
  }
  
  public View k()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView
 * JD-Core Version:    0.7.0.1
 */