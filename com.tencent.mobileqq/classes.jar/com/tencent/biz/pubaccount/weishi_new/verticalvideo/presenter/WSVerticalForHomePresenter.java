package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WSVerticalForHomePresenter
  extends WSVerticalForRecommendPresenter
{
  private static final int b = ScreenUtil.dip2px(48.0F);
  protected long a;
  private boolean d = true;
  
  public WSVerticalForHomePresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private Object a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_should_clear_data_on_refresh", Boolean.valueOf(this.d));
    return new JSONObject(localHashMap).toString();
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
    if (paramWSVerticalItemData == null) {}
    WSVerticalItemData localWSVerticalItemData;
    do
    {
      do
      {
        do
        {
          return;
          localWSVerticalItemData = (WSVerticalItemData)paramWSVerticalPageAdapter.a(0);
        } while (localWSVerticalItemData == null);
        a(localWSVerticalItemData, paramWSVerticalItemData, paramWSVerticalPageAdapter);
        paramWSVerticalItemData = paramWSVerticalPageAdapter.a();
      } while (paramWSVerticalItemData == null);
      WSLog.a("WSVerticalForHomePresenter", "onSuccess getItemCount: " + paramWSVerticalPageAdapter.getItemCount());
      paramWSVerticalItemData = paramWSVerticalItemData.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView;
    } while (!(paramWSVerticalItemData instanceof AbsWSVideoItemView));
    ((AbsWSVideoItemView)paramWSVerticalItemData).b(localWSVerticalItemData);
  }
  
  private void a(WSVerticalItemData paramWSVerticalItemData1, WSVerticalItemData paramWSVerticalItemData2, WSVerticalPageAdapter paramWSVerticalPageAdapter)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = paramWSVerticalItemData1.a();
    paramWSVerticalItemData2 = paramWSVerticalItemData2.a();
    paramWSVerticalItemData2.floatingLayerCardStyle.cardType = localstSimpleMetaFeed.floatingLayerCardStyle.cardType;
    paramWSVerticalItemData2.opInfo = localstSimpleMetaFeed.opInfo;
    paramWSVerticalItemData1.a(paramWSVerticalItemData2);
    paramWSVerticalItemData1 = paramWSVerticalPageAdapter.a();
    if ((paramWSVerticalItemData1 != null) && (paramWSVerticalItemData1.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null)) {
      paramWSVerticalItemData1.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.a = WSPlayerUtils.a(paramWSVerticalItemData2);
    }
  }
  
  private void a(List<WSVerticalItemData> paramList)
  {
    Object localObject1 = a();
    if ((paramList == null) || (paramList.size() <= 1))
    {
      WSLog.a("WSVerticalForHomePresenter", "data from cache or pushMsg");
      return;
    }
    if (localObject1 != null)
    {
      localObject1 = ((WSVerticalPageContract.View)localObject1).a();
      if ((localObject1 != null) && (((WSVerticalPageAdapter)localObject1).getItemCount() > 0)) {}
    }
    else
    {
      WSLog.a("WSVerticalForHomePresenter", "not data in screen");
      return;
    }
    Object localObject2 = (WSVerticalItemData)((WSVerticalPageAdapter)localObject1).a(0);
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.get(0);
    if ((localObject2 == null) || (localWSVerticalItemData == null))
    {
      WSLog.a("WSVerticalForHomePresenter", "data could be null");
      return;
    }
    localObject2 = ((WSVerticalItemData)localObject2).a();
    stSimpleMetaFeed localstSimpleMetaFeed = localWSVerticalItemData.a();
    if ((localObject2 == null) || (localstSimpleMetaFeed == null))
    {
      WSLog.a("WSVerticalForHomePresenter", "data type is incorrect");
      return;
    }
    if (TextUtils.equals(((stSimpleMetaFeed)localObject2).id, localstSimpleMetaFeed.id))
    {
      WSLog.a("WSVerticalForHomePresenter", "updateFirstItem");
      paramList.remove(localWSVerticalItemData);
      a(localWSVerticalItemData, (WSVerticalPageAdapter)localObject1);
      return;
    }
    WSLog.a("WSVerticalForHomePresenter", "data not equip，feedInScreen.id = " + ((stSimpleMetaFeed)localObject2).id + "，feedFromServer.id = " + localstSimpleMetaFeed.id);
  }
  
  private void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      a(paramList);
    }
    while (!paramBoolean2) {
      return;
    }
    b();
  }
  
  private void a(boolean paramBoolean, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((!paramBoolean) && (TextUtils.isEmpty("")) && (paramstSimpleMetaFeed != null)) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;; paramstSimpleMetaFeed = "")
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 2)
      {
        WSReportDc00898.a(301, new Object[] { Integer.valueOf(paramInt), "0", paramstSimpleMetaFeed, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2) });
        return;
      }
    }
  }
  
  private void a(boolean paramBoolean, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if (!paramBoolean) {}
    do
    {
      return;
      localObject = a();
    } while (!(localObject instanceof WSVerticalPageFragment));
    Object localObject = ((WSVerticalPageFragment)localObject).getActivity();
    WSFallKeyPicMonitor.a().a((Activity)localObject, paramInt, paramstSimpleMetaFeed);
  }
  
  private boolean a(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof String)) {}
    try
    {
      bool = new JSONObject((String)paramObject).optBoolean("key_should_clear_data_on_refresh", true);
      return bool;
    }
    catch (JSONException paramObject)
    {
      paramObject.printStackTrace();
    }
    return true;
  }
  
  private void b()
  {
    WSVerticalPageContract.View localView = a();
    Object localObject;
    if (localView != null)
    {
      localObject = localView.a();
      if (localObject != null) {
        break label21;
      }
    }
    label21:
    int i;
    do
    {
      return;
      i = ((WSVerticalPageAdapter)localObject).a();
      localObject = ((WSVerticalPageAdapter)localObject).b();
    } while (i > ((List)localObject).size());
    ((List)localObject).removeAll(((List)localObject).subList(i, ((List)localObject).size()));
    localView.a().notifyItemMoved(i, ((List)localObject).size());
    WSVerticalUtils.a("[WSVerticalForHomePresenter.java][preFilterDataForRefresh] firstVideo", (List)localObject);
  }
  
  private boolean h()
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null))
    {
      localObject = localView.a().a();
      if ((localObject != null) && (((List)localObject).size() != 0)) {}
    }
    else
    {
      return false;
    }
    Object localObject = new ArrayList((Collection)localObject);
    localView.a((List)localObject);
    WSVerticalUtils.a("[WSVerticalForHomePresenter.java][fillFirstDataOnRefresh]", (List)localObject);
    return true;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public void a(@NonNull WSVerticalPageContract.View paramView)
  {
    super.a(paramView);
    if (d()) {
      WSReportUtils.b(String.valueOf(System.currentTimeMillis()));
    }
  }
  
  public void a(String paramString)
  {
    WSVerticalPageContract.View localView = a();
    if (localView == null) {
      return;
    }
    this.d = true;
    if (h())
    {
      this.d = false;
      localView.e();
    }
    super.a(paramString);
  }
  
  public void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    a(paramList, paramBoolean2, paramBoolean1);
    super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
    WSVerticalUtils.a("[WSVerticalForHomePresenter.java][onSuccess] >>>>>", paramList);
    if (paramObject == null) {}
    do
    {
      do
      {
        return;
        if (paramBoolean2) {
          this.a = (System.currentTimeMillis() - this.a);
        }
      } while ((paramList == null) || (paramList.size() <= 0));
      paramList = ((WSVerticalItemData)paramList.get(0)).a();
    } while (!(paramList instanceof stSimpleMetaFeed));
    paramList = (stSimpleMetaFeed)paramList;
    int i = 1;
    paramObject = WSGlobalConfig.a().a(12);
    if (paramObject != null)
    {
      WSLog.d("WSVerticalForHomePresenter", "RockDownloader:" + paramObject.download);
      i = paramObject.link_strategy_type;
    }
    a(false, i, paramList);
    a(paramBoolean2, paramList, i);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (a() == null) {
      return false;
    }
    ThreadManager.executeOnSubThread(new WSVerticalForHomePresenter.1(this, paramBoolean2, paramBoolean1));
    return true;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    if (paramBoolean2) {
      return c();
    }
    return (a(paramObject)) && (paramBoolean1);
  }
  
  public int b()
  {
    return b;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public boolean d()
  {
    WSVerticalPageContract.View localView = a();
    return (localView != null) && (localView.b());
  }
  
  public void h()
  {
    super.h();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForHomePresenter
 * JD-Core Version:    0.7.0.1
 */