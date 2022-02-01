package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
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
  private static final int a = ScreenUtil.dip2px(48.0F);
  protected long b;
  private boolean i = true;
  private long j;
  private long k;
  
  public WSVerticalForHomePresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private boolean O()
  {
    WSVerticalPageContract.View localView = z();
    if ((localView != null) && (localView.b() != null))
    {
      Object localObject = localView.b().f();
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
  
  private void Q()
  {
    WSVerticalPageContract.View localView = z();
    if (localView != null)
    {
      Object localObject = localView.b();
      if (localObject == null) {
        return;
      }
      int m = ((WSVerticalPageAdapter)localObject).h();
      localObject = ((WSVerticalPageAdapter)localObject).getDataList();
      if (m > ((List)localObject).size()) {
        return;
      }
      ((List)localObject).removeAll(((List)localObject).subList(m, ((List)localObject).size()));
      localView.b().notifyItemMoved(m, ((List)localObject).size());
      WSVerticalUtils.a("[WSVerticalForHomePresenter.java][preFilterDataForRefresh] firstVideo", (List)localObject);
    }
  }
  
  private ArrayList<String> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      String str = x();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSVerticalForHomePresenter.java][getContextFeedIds] lastFeedId:");
      localStringBuilder.append(str);
      WSLog.e("WSVerticalForHomePresenter", localStringBuilder.toString());
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
      WSLog.a("WSVerticalForHomePresenter", localStringBuilder.toString());
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
    if ((paramBoolean1) && (!C()))
    {
      a(paramList);
      return;
    }
    if (paramBoolean2) {
      Q();
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
    int m;
    if (paramBoolean) {
      m = 1;
    } else {
      m = 2;
    }
    WSReportDc00898.a(301, new Object[] { Integer.valueOf(paramInt), "0", str1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(m), Integer.valueOf(2) });
  }
  
  private void a(boolean paramBoolean, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject = z();
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
  
  private Object u()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_should_clear_data_on_refresh", Boolean.valueOf(this.i));
    return new JSONObject(localHashMap).toString();
  }
  
  public long A()
  {
    return this.b;
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
  
  public void a(@NonNull WSVerticalPageContract.View paramView)
  {
    super.a(paramView);
    if (F()) {
      WSReportUtils.c(String.valueOf(System.currentTimeMillis()));
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
      this.b = (System.currentTimeMillis() - this.b);
    }
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      paramList = ((WSVerticalItemData)paramList.get(0)).b();
      if (!(paramList instanceof stSimpleMetaFeed)) {
        return;
      }
      paramList = (stSimpleMetaFeed)paramList;
      int m = 1;
      paramObject = WSGlobalConfig.a().a(12);
      if (paramObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("RockDownloader:");
        localStringBuilder.append(paramObject.download);
        WSLog.d("WSVerticalForHomePresenter", localStringBuilder.toString());
        m = paramObject.link_strategy_type;
      }
      a(false, m, paramList);
      a(paramBoolean2, paramList, m);
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    if (paramBoolean2) {
      return C();
    }
    return (a(paramObject)) && (paramBoolean1);
  }
  
  public void b(String paramString)
  {
    WSVerticalPageContract.View localView = z();
    if (localView == null) {
      return;
    }
    this.i = true;
    if (O())
    {
      this.i = false;
      localView.aX_();
    }
    super.b(paramString);
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (z() == null) {
      return false;
    }
    ThreadManager.executeOnSubThread(new WSVerticalForHomePresenter.1(this, paramBoolean2, paramBoolean1));
    return true;
  }
  
  public int c()
  {
    return a;
  }
  
  public void destroy()
  {
    super.destroy();
    int m;
    if (J() != null) {
      m = J().h();
    } else {
      m = 0;
    }
    WsBeaconReportPresenter.a().a(this.j, A(), m, WeishiUtils.a, WeishiScehmeUtil.b, 2);
  }
  
  public void f()
  {
    super.f();
    this.k = System.currentTimeMillis();
  }
  
  public void g()
  {
    super.g();
    this.j += System.currentTimeMillis() - this.k;
    P();
  }
  
  public boolean i()
  {
    return true;
  }
  
  @NonNull
  protected String v()
  {
    return WSVerticalDataUtil.b();
  }
  
  protected boolean w()
  {
    return true;
  }
  
  protected String x()
  {
    return WSVerticalDataUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForHomePresenter
 * JD-Core Version:    0.7.0.1
 */