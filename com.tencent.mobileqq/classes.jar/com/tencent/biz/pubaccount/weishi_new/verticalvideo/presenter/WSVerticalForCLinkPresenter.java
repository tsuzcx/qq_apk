package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;

public class WSVerticalForCLinkPresenter
  extends WSVerticalForRecommendPresenter
{
  protected long a;
  
  public WSVerticalForCLinkPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private ArrayList<String> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      String str = WSVerticalDataUtil.a();
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  private void a(WSVerticalItemData paramWSVerticalItemData, WSVerticalPageAdapter paramWSVerticalPageAdapter)
  {
    if (paramWSVerticalItemData == null) {
      return;
    }
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramWSVerticalPageAdapter.getItem(0);
    if (localWSVerticalItemData == null) {
      return;
    }
    a(localWSVerticalItemData, paramWSVerticalItemData, paramWSVerticalPageAdapter);
    paramWSVerticalItemData = paramWSVerticalPageAdapter.b();
    if (paramWSVerticalItemData != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSuccess getItemCount: ");
      localStringBuilder.append(paramWSVerticalPageAdapter.getItemCount());
      WSLog.a("WSVerticalForCLinkPresenter", localStringBuilder.toString());
      paramWSVerticalItemData = paramWSVerticalItemData.c;
      if ((paramWSVerticalItemData instanceof AbsWSVideoItemView)) {
        ((AbsWSVideoItemView)paramWSVerticalItemData).b(localWSVerticalItemData);
      }
    }
  }
  
  private void a(WSVerticalItemData paramWSVerticalItemData1, WSVerticalItemData paramWSVerticalItemData2, WSVerticalPageAdapter paramWSVerticalPageAdapter)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = paramWSVerticalItemData1.b();
    paramWSVerticalItemData2 = paramWSVerticalItemData2.b();
    paramWSVerticalItemData2.floatingLayerCardStyle.cardType = localstSimpleMetaFeed.floatingLayerCardStyle.cardType;
    paramWSVerticalItemData2.opInfo = localstSimpleMetaFeed.opInfo;
    paramWSVerticalItemData1.a(paramWSVerticalItemData2);
    paramWSVerticalItemData1 = paramWSVerticalPageAdapter.b();
    if ((paramWSVerticalItemData1 != null) && (paramWSVerticalItemData1.f != null)) {
      paramWSVerticalItemData1.f.c = WSPlayerUtils.a(paramWSVerticalItemData2);
    }
  }
  
  private void a(List<WSVerticalItemData> paramList)
  {
    Object localObject1 = z();
    if ((paramList != null) && (paramList.size() > 1))
    {
      if (localObject1 != null)
      {
        localObject1 = ((WSVerticalPageContract.View)localObject1).b();
        if ((localObject1 != null) && (((WSVerticalPageAdapter)localObject1).getItemCount() > 0))
        {
          Object localObject2 = (WSVerticalItemData)((WSVerticalPageAdapter)localObject1).getItem(0);
          WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.get(0);
          if ((localObject2 != null) && (localWSVerticalItemData != null))
          {
            localObject2 = ((WSVerticalItemData)localObject2).b();
            stSimpleMetaFeed localstSimpleMetaFeed = localWSVerticalItemData.b();
            if ((localObject2 != null) && (localstSimpleMetaFeed != null))
            {
              if (TextUtils.equals(((stSimpleMetaFeed)localObject2).id, localstSimpleMetaFeed.id))
              {
                WSLog.a("WSVerticalForCLinkPresenter", "updateFirstItem");
                paramList.remove(localWSVerticalItemData);
                a(localWSVerticalItemData, (WSVerticalPageAdapter)localObject1);
                return;
              }
              paramList = new StringBuilder();
              paramList.append("data not equip，feedInScreen.id = ");
              paramList.append(((stSimpleMetaFeed)localObject2).id);
              paramList.append("，feedFromServer.id = ");
              paramList.append(localstSimpleMetaFeed.id);
              WSLog.a("WSVerticalForCLinkPresenter", paramList.toString());
              return;
            }
            WSLog.a("WSVerticalForCLinkPresenter", "data type is incorrect");
            return;
          }
          WSLog.a("WSVerticalForCLinkPresenter", "data could be null");
          return;
        }
      }
      WSLog.a("WSVerticalForCLinkPresenter", "not data in screen");
      return;
    }
    WSLog.a("WSVerticalForCLinkPresenter", "data from cache or pushMsg");
  }
  
  private void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!C())) {
      a(paramList);
    }
  }
  
  protected boolean B()
  {
    return true;
  }
  
  public boolean F()
  {
    WSVerticalPageContract.View localView = z();
    return (localView != null) && (localView.q());
  }
  
  public void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    a(paramList, paramBoolean2, paramBoolean1);
    super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
    WSVerticalUtils.a("[WSVerticalForCLinkPresenter.java][onSuccess] >>>>>", paramList);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    return (paramBoolean2) && (C());
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (z() == null) {
      return false;
    }
    ThreadManager.executeOnSubThread(new WSVerticalForCLinkPresenter.1(this, paramBoolean2, paramBoolean1));
    return true;
  }
  
  public boolean i()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForCLinkPresenter
 * JD-Core Version:    0.7.0.1
 */