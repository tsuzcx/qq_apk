package com.tencent.biz.pubaccount.weishi_new.recommend.holder;

import UserGrowth.stCardInfo;
import UserGrowth.stCollection;
import UserGrowth.stCollectionCardInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.collection.WSCollectionItemData;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedCollectionController;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;

public class WSGridCollectionItemView
  implements IWSItemView<stSimpleMetaFeed>
{
  private final Context a;
  private final WSGridCollectionHolder b;
  private final ViewGroup c;
  private TextView d;
  private final SparseArray<WSGridFeedCollectionController> e;
  private WSRecommendAdapter f;
  private stSimpleMetaFeed g;
  
  public WSGridCollectionItemView(Context paramContext, View paramView, WSGridCollectionHolder paramWSGridCollectionHolder)
  {
    this.a = paramContext;
    this.b = paramWSGridCollectionHolder;
    this.c = ((ViewGroup)paramView);
    this.e = new SparseArray();
    b();
  }
  
  private void a(int paramInt1, int paramInt2, ArrayList<stCollection> paramArrayList)
  {
    int j = this.b.getLayoutPosition();
    Object localObject = this.f;
    if (localObject != null) {
      localObject = ((WSRecommendAdapter)localObject).l;
    } else {
      localObject = "";
    }
    int i = 0;
    while (i < paramInt2)
    {
      WSCollectionItemData localWSCollectionItemData = new WSCollectionItemData((stCollection)paramArrayList.get(i), paramInt1);
      WSGridFeedCollectionController localWSGridFeedCollectionController2 = (WSGridFeedCollectionController)this.e.get(i);
      WSGridFeedCollectionController localWSGridFeedCollectionController1 = localWSGridFeedCollectionController2;
      if (localWSGridFeedCollectionController2 == null)
      {
        localWSGridFeedCollectionController1 = new WSGridFeedCollectionController(this.a, this.g);
        this.e.append(i, localWSGridFeedCollectionController1);
      }
      localWSGridFeedCollectionController1.b(j);
      localWSGridFeedCollectionController1.a(this.c);
      localWSGridFeedCollectionController1.c(i);
      localWSGridFeedCollectionController1.a((String)localObject);
      localWSGridFeedCollectionController1.a(localWSCollectionItemData);
      i += 1;
    }
  }
  
  private void e()
  {
    stCardInfo localstCardInfo = this.g.cardInfo;
    Object localObject1 = localstCardInfo.collectionCardInfo;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setData :");
    ((StringBuilder)localObject2).append(((stCollectionCardInfo)localObject1).toString());
    WSLog.a("WSGridCollectionItemView", ((StringBuilder)localObject2).toString());
    localObject2 = ((stCollectionCardInfo)localObject1).title;
    this.d.setText((CharSequence)localObject2);
    localObject1 = ((stCollectionCardInfo)localObject1).collectionList;
    int i = Math.min(((ArrayList)localObject1).size(), 5);
    a(localstCardInfo.cardType, i, (ArrayList)localObject1);
    e(i);
  }
  
  private void e(int paramInt)
  {
    int i = paramInt;
    if (paramInt + 1 >= this.e.size()) {
      return;
    }
    while (i < this.e.size())
    {
      WSGridFeedCollectionController localWSGridFeedCollectionController = (WSGridFeedCollectionController)this.e.get(i);
      if (localWSGridFeedCollectionController != null) {
        localWSGridFeedCollectionController.i();
      }
      i += 1;
    }
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.g = paramstSimpleMetaFeed;
    e();
  }
  
  public void a(WSRecommendAdapter paramWSRecommendAdapter)
  {
    this.f = paramWSRecommendAdapter;
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initUI:");
    localStringBuilder.append(this.g);
    WSLog.a("WSGridCollectionItemView", localStringBuilder.toString());
    this.d = ((TextView)this.c.findViewById(2131432956));
  }
  
  public void b(int paramInt) {}
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void d() {}
  
  public void d(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSGridCollectionItemView
 * JD-Core Version:    0.7.0.1
 */