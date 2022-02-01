package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopAdapterForAddContact;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper;
import com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper.RecommendTroopListWrapperCallback;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class AddContactFindTroopRTLW
  extends RecommendTroopListWrapper
{
  static int f = 50;
  public int a;
  public AddContactFindTroopRTLW.onRefreshCallback b;
  boolean c;
  int d;
  ArrayList<RecommendTroopItem> e = new ArrayList();
  String g;
  boolean h = false;
  
  public AddContactFindTroopRTLW(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, RecommendTroopListWrapper.RecommendTroopListWrapperCallback paramRecommendTroopListWrapperCallback, int paramInt, String paramString)
  {
    this.i = paramQQAppInterface;
    this.j = paramContext;
    this.k = paramXListView;
    this.o = paramRecommendTroopListWrapperCallback;
    this.a = paramInt;
    this.g = paramString;
    this.q = false;
    b();
  }
  
  protected RecommendTroopAdapter a()
  {
    return new RecommendTroopAdapterForAddContact(this.j, (QQAppInterface)this.i, false);
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
    b(false);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    int i = this.e.size();
    int j = paramArrayList.size();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetAddContactFindTroopNearbyTroopList isSuccess = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",itemType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",this.itemType = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(",serverPageID = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",dataListSize = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",newDataListSize = ");
      localStringBuilder.append(j);
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, localStringBuilder.toString());
    }
    if (paramInt1 == this.a)
    {
      this.c = paramBoolean2;
      if (paramBoolean1)
      {
        if (!paramBoolean3)
        {
          this.h = true;
          this.e.clear();
        }
        i = this.e.size();
        int k = f;
        if (i + j >= k)
        {
          this.e.addAll(paramArrayList.subList(0, k - i));
          this.c = true;
          if (QLog.isColorLevel())
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("onGetAddContactFindTroopRecommendTroopList reach limit,this.dataList.size() = ");
            paramArrayList.append(this.e.size());
            QLog.d("ac_ft.AddContactFindTroopRTLW", 2, paramArrayList.toString());
          }
        }
        else
        {
          this.e.addAll(paramArrayList);
        }
        i = this.e.size();
        d();
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("onGetAddContactFindTroopNearbyTroopList do update Data,itemType = ");
          paramArrayList.append(paramInt1);
          paramArrayList.append(",this.itemType = ");
          paramArrayList.append(this.a);
          paramArrayList.append(",serverPageID = ");
          paramArrayList.append(paramInt2);
          paramArrayList.append(",dataListSize = ");
          paramArrayList.append(i);
          paramArrayList.append(",newDataListSize = ");
          paramArrayList.append(j);
          QLog.d("ac_ft.AddContactFindTroopRTLW", 2, paramArrayList.toString());
        }
        if (this.e.size() > 0)
        {
          this.l.setVisibility(0);
          if (this.c) {
            this.l.setText("没有更多内容了");
          }
        }
        this.d = paramInt2;
      }
      paramArrayList = this.b;
      if (paramArrayList != null) {
        paramArrayList.a(paramBoolean1, i);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    int i = this.e.size();
    int j = paramArrayList.size();
    this.c = paramBoolean2;
    if ((paramInt1 == this.a) && (paramString.equals(this.g)))
    {
      if (paramBoolean1)
      {
        if (!paramBoolean3)
        {
          this.h = true;
          this.e.clear();
        }
        i = this.e.size();
        int k = f;
        if (i + j >= k)
        {
          this.e.addAll(paramArrayList.subList(0, k - i));
          this.c = true;
          if (QLog.isColorLevel())
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("onGetAddContactFindTroopRecommendTroopList reach limit,this.dataList.size() = ");
            paramArrayList.append(this.e.size());
            QLog.d("ac_ft.AddContactFindTroopRTLW", 2, paramArrayList.toString());
          }
        }
        else
        {
          this.e.addAll(paramArrayList);
        }
        i = this.e.size();
        d();
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("onGetAddContactFindTroopRecommendTroopList,do update Data ,itemType = ");
          paramArrayList.append(paramInt1);
          paramArrayList.append(",this.itemType = ");
          paramArrayList.append(this.a);
          paramArrayList.append(",keyWord = ");
          paramArrayList.append(paramString);
          paramArrayList.append(",this.keyWord = ");
          paramArrayList.append(this.g);
          paramArrayList.append(",serverPageID = ");
          paramArrayList.append(paramInt2);
          paramArrayList.append(",dataListSize = ");
          paramArrayList.append(i);
          paramArrayList.append(",newDataListSize = ");
          paramArrayList.append(j);
          paramArrayList.append(",this = ");
          paramArrayList.append(this);
          QLog.d("ac_ft.AddContactFindTroopRTLW", 2, paramArrayList.toString());
        }
        if (this.e.size() > 0)
        {
          this.l.setVisibility(0);
          if (this.c) {
            this.l.setText("没有更多内容了");
          }
        }
        this.d = paramInt2;
      }
      paramString = this.b;
      if (paramString != null) {
        paramString.a(paramBoolean1, i);
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    ITroopRecommendHandler localITroopRecommendHandler = (ITroopRecommendHandler)this.i.getBusinessHandler(BusinessHandlerFactory.TROOP_RECOMMEND_HANDLER);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRecommendTroopList ,itemType = ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(",keyWord = ");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(",loadMore = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",this = ");
      ((StringBuilder)localObject).append(this);
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      this.d = -1;
      this.c = false;
    }
    bP_();
    int i = this.a;
    int j = 1;
    boolean bool = true;
    if (i == 1)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        if ((this.j.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == -1) || (this.j.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == -1)) {
          bool = false;
        }
        j = bool;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getRecommendTroopList  >= M, canRequestLocation = ");
          ((StringBuilder)localObject).append(bool);
          QLog.w("ac_ft.AddContactFindTroopRTLW", 2, ((StringBuilder)localObject).toString());
          j = bool;
        }
      }
      if (j != 0)
      {
        localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("recommend_troop");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getRecommendTroopList  >= M, info = ");
          localStringBuilder.append(localObject);
          QLog.i("ac_ft.AddContactFindTroopRTLW", 2, localStringBuilder.toString());
        }
        if (localObject == null)
        {
          ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new AddContactFindTroopRTLW.1(this, "recommend_troop", localITroopRecommendHandler, paramBoolean));
          return;
        }
        localITroopRecommendHandler.a(1, this.d, 25, paramBoolean, h());
      }
    }
    else
    {
      if (i == 0)
      {
        localITroopRecommendHandler.b(i, this.g, this.d, 25, paramBoolean);
        return;
      }
      localITroopRecommendHandler.a(i, this.g, this.d, 25, paramBoolean);
    }
  }
  
  void bP_()
  {
    if (this.l.getVisibility() != 0) {
      this.l.post(new AddContactFindTroopRTLW.2(this));
    }
  }
  
  protected boolean c()
  {
    return this.c;
  }
  
  protected void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshListView,this.dataList.size() = ");
      localStringBuilder.append(this.e.size());
      localStringBuilder.append(",needResetListViewPostion = ");
      localStringBuilder.append(this.h);
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, localStringBuilder.toString());
    }
    this.m.a(this.e);
    this.m.notifyDataSetChanged();
    if (this.h)
    {
      this.k.setSelection(0);
      this.h = false;
    }
  }
  
  public void e()
  {
    super.e();
    ArrayList localArrayList = this.e;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactFindTroopRTLW
 * JD-Core Version:    0.7.0.1
 */