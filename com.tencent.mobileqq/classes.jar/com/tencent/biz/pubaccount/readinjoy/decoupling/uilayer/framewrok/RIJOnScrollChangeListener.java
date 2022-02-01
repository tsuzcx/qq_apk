package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.view.IReadInJoyListItemAutoPlayCallback;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.widget.ListView;
import com.tencent.widget.ListView.OnScrollChangeListener;

public class RIJOnScrollChangeListener
  implements ListView.OnScrollChangeListener
{
  RIJDataManager a;
  
  public RIJOnScrollChangeListener(RIJDataManager paramRIJDataManager)
  {
    this.a = paramRIJDataManager;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    ReadInJoyXListView localReadInJoyXListView = null;
    paramInt1 = 0;
    for (;;)
    {
      Object localObject1 = localReadInJoyXListView;
      if (paramInt1 < this.a.a().a().a().getChildCount())
      {
        localObject1 = this.a.a().a().a().getChildAt(paramInt1);
        if ((localObject1 instanceof ProteusItemView))
        {
          localObject1 = ((ProteusItemView)localObject1).a();
          if (localObject1 != null)
          {
            localObject1 = (IReadInJoyListItemAutoPlayCallback)((Container)localObject1).getTag(2131376584);
            if ((localObject1 == null) || (!((IReadInJoyListItemAutoPlayCallback)localObject1).a())) {}
          }
        }
      }
      else
      {
        localReadInJoyXListView = (ReadInJoyXListView)this.a.a().a().a();
        paramInt1 = paramInt2;
        if (localObject1 != null)
        {
          paramInt1 = paramInt2;
          if (!localReadInJoyXListView.a())
          {
            ((IReadInJoyListItemAutoPlayCallback)localObject1).a();
            paramInt1 = paramInt2;
          }
        }
        while (paramInt1 < localReadInJoyXListView.getChildCount())
        {
          Object localObject2 = localReadInJoyXListView.getChildAt(paramInt1);
          if ((localObject2 instanceof ProteusItemView))
          {
            localObject2 = ((ProteusItemView)localObject2).a();
            if (localObject2 != null)
            {
              localObject2 = (IReadInJoyListItemAutoPlayCallback)((Container)localObject2).getTag(2131376584);
              if ((localObject2 != null) && (localObject2 != localObject1)) {
                ((IReadInJoyListItemAutoPlayCallback)localObject2).b();
              }
            }
          }
          paramInt1 += 1;
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJOnScrollChangeListener
 * JD-Core Version:    0.7.0.1
 */