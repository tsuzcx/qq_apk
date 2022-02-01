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
  private boolean f = true;
  
  public WSVerticalForHomePresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private Object a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_should_clear_data_on_refresh", Boolean.valueOf(this.f));
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
    if (paramWSVerticalItemData == null) {
      return;
    }
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramWSVerticalPageAdapter.getItem(0);
    if (localWSVerticalItemData == null) {
      return;
    }
    a(localWSVerticalItemData, paramWSVerticalItemData, paramWSVerticalPageAdapter);
    paramWSVerticalItemData = paramWSVerticalPageAdapter.a();
    if (paramWSVerticalItemData != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSuccess getItemCount: ");
      localStringBuilder.append(paramWSVerticalPageAdapter.getItemCount());
      WSLog.a("WSVerticalForHomePresenter", localStringBuilder.toString());
      paramWSVerticalItemData = paramWSVerticalItemData.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView;
      if ((paramWSVerticalItemData instanceof AbsWSVideoItemView)) {
        ((AbsWSVideoItemView)paramWSVerticalItemData).b(localWSVerticalItemData);
      }
    }
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
    if ((paramList != null) && (paramList.size() > 1))
    {
      if (localObject1 != null)
      {
        localObject1 = ((WSVerticalPageContract.View)localObject1).a();
        if ((localObject1 != null) && (((WSVerticalPageAdapter)localObject1).getItemCount() > 0))
        {
          Object localObject2 = (WSVerticalItemData)((WSVerticalPageAdapter)localObject1).getItem(0);
          WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.get(0);
          if ((localObject2 != null) && (localWSVerticalItemData != null))
          {
            localObject2 = ((WSVerticalItemData)localObject2).a();
            stSimpleMetaFeed localstSimpleMetaFeed = localWSVerticalItemData.a();
            if ((localObject2 != null) && (localstSimpleMetaFeed != null))
            {
              if (TextUtils.equals(((stSimpleMetaFeed)localObject2).id, localstSimpleMetaFeed.id))
              {
                WSLog.a("WSVerticalForHomePresenter", "updateFirstItem");
                paramList.remove(localWSVerticalItemData);
                a(localWSVerticalItemData, (WSVerticalPageAdapter)localObject1);
                return;
              }
              paramList = new StringBuilder();
              paramList.append("data not equip，feedInScreen.id = ");
              paramList.append(((stSimpleMetaFeed)localObject2).id);
              paramList.append("，feedFromServer.id = ");
              paramList.append(localstSimpleMetaFeed.id);
              WSLog.a("WSVerticalForHomePresenter", paramList.toString());
              return;
            }
            WSLog.a("WSVerticalForHomePresenter", "data type is incorrect");
            return;
          }
          WSLog.a("WSVerticalForHomePresenter", "data could be null");
          return;
        }
      }
      WSLog.a("WSVerticalForHomePresenter", "not data in screen");
      return;
    }
    WSLog.a("WSVerticalForHomePresenter", "data from cache or pushMsg");
  }
  
  private void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      a(paramList);
      return;
    }
    if (paramBoolean2) {
      l();
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str2 = "";
    String str1 = str2;
    if (!paramBoolean)
    {
      str1 = str2;
      if (TextUtils.isEmpty(""))
      {
        str1 = str2;
        if (paramstSimpleMetaFeed != null) {
          str1 = paramstSimpleMetaFeed.id;
        }
      }
    }
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    WSReportDc00898.a(301, new Object[] { Integer.valueOf(paramInt), "0", str1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2) });
  }
  
  private void a(boolean paramBoolean, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject = a();
    if (!(localObject instanceof WSVerticalPageFragment)) {
      return;
    }
    localObject = ((WSVerticalPageFragment)localObject).getBaseActivity();
    WSFallKeyPicMonitor.a().a((Activity)localObject, paramInt, paramstSimpleMetaFeed);
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      try
      {
        boolean bool = new JSONObject((String)paramObject).optBoolean("key_should_clear_data_on_refresh", true);
        return bool;
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
      }
    }
    return true;
  }
  
  private boolean e()
  {
    WSVerticalPageContract.View localView = a();
    if ((localView != null) && (localView.a() != null))
    {
      Object localObject = localView.a().a();
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localObject = new ArrayList((Collection)localObject);
        localView.a((List)localObject);
        WSVerticalUtils.a("[WSVerticalForHomePresenter.java][fillFirstDataOnRefresh]", (List)localObject);
        return true;
      }
    }
    return false;
  }
  
  private void l()
  {
    WSVerticalPageContract.View localView = a();
    if (localView != null)
    {
      Object localObject = localView.a();
      if (localObject == null) {
        return;
      }
      int i = ((WSVerticalPageAdapter)localObject).a();
      localObject = ((WSVerticalPageAdapter)localObject).getDataList();
      if (i > ((List)localObject).size()) {
        return;
      }
      ((List)localObject).removeAll(((List)localObject).subList(i, ((List)localObject).size()));
      localView.a().notifyItemMoved(i, ((List)localObject).size());
      WSVerticalUtils.a("[WSVerticalForHomePresenter.java][preFilterDataForRefresh] firstVideo", (List)localObject);
    }
  }
  
  public long a()
  {
    return this.a;
  }
  
  public void a(@NonNull WSVerticalPageContract.View paramView)
  {
    super.a(paramView);
    if (i()) {
      WSReportUtils.b(String.valueOf(System.currentTimeMillis()));
    }
  }
  
  public void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    a(paramList, paramBoolean2, paramBoolean1);
    super.a(paramList, paramBoolean1, paramBoolean2, paramObject);
    WSVerticalUtils.a("[WSVerticalForHomePresenter.java][onSuccess] >>>>>", paramList);
    if (paramObject == null) {
      return;
    }
    if (paramBoolean2) {
      this.a = (System.currentTimeMillis() - this.a);
    }
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      paramList = ((WSVerticalItemData)paramList.get(0)).a();
      if (!(paramList instanceof stSimpleMetaFeed)) {
        return;
      }
      paramList = (stSimpleMetaFeed)paramList;
      int i = 1;
      paramObject = WSGlobalConfig.a().a(12);
      if (paramObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("RockDownloader:");
        localStringBuilder.append(paramObject.download);
        WSLog.d("WSVerticalForHomePresenter", localStringBuilder.toString());
        i = paramObject.link_strategy_type;
      }
      a(false, i, paramList);
      a(paramBoolean2, paramList, i);
    }
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
      return h();
    }
    return (a(paramObject)) && (paramBoolean1);
  }
  
  public int b()
  {
    return b;
  }
  
  public void b(String paramString)
  {
    WSVerticalPageContract.View localView = a();
    if (localView == null) {
      return;
    }
    this.f = true;
    if (e())
    {
      this.f = false;
      localView.e();
    }
    super.b(paramString);
  }
  
  public void g()
  {
    super.g();
    k();
  }
  
  protected boolean g()
  {
    return true;
  }
  
  public boolean i()
  {
    WSVerticalPageContract.View localView = a();
    return (localView != null) && (localView.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForHomePresenter
 * JD-Core Version:    0.7.0.1
 */