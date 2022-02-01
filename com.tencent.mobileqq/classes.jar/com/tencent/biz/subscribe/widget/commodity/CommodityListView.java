package com.tencent.biz.subscribe.widget.commodity;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class CommodityListView
  extends BaseWidgetView<ArrayList>
{
  private RecyclerView c;
  private LinearLayoutManager d;
  private CommodityListView.onDataChangeListener e;
  private TextView f;
  private CertifiedAccountMeta.StFeed g;
  private CommodityListView.CommodityAdapter h;
  private TextView i;
  private View j;
  private boolean k;
  
  public CommodityListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommodityListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    CommodityListView.CommodityAdapter localCommodityAdapter = this.h;
    if (localCommodityAdapter != null)
    {
      localCommodityAdapter.b();
      this.h.notifyDataSetChanged();
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.c = ((RecyclerView)paramView.findViewById(2131445205));
    this.i = ((TextView)paramView.findViewById(2131448814));
    this.f = ((TextView)paramView.findViewById(2131448714));
    this.j = paramView.findViewById(2131449305);
    this.d = new LinearLayoutManager(getContext(), 0, false);
    this.c.setLayoutManager(this.d);
    this.h = new CommodityListView.CommodityAdapter(this);
    this.c.setAdapter(this.h);
  }
  
  protected void a(ArrayList paramArrayList) {}
  
  public CommodityListView.CommodityAdapter getCommodityAdapter()
  {
    return this.h;
  }
  
  protected int getLayoutId()
  {
    return 2131624356;
  }
  
  public String getSelectedIds()
  {
    if (getData() == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    while (m < ((ArrayList)getData()).size())
    {
      Object localObject = ((ArrayList)getData()).get(m);
      if ((localObject instanceof CommodityBean))
      {
        localObject = (CommodityBean)localObject;
        long l = ((CommodityBean)localObject).mItemID;
        if (l > 0L) {
          localObject = String.valueOf(l);
        } else {
          localObject = ((CommodityBean)localObject).mAlias;
        }
      }
      else
      {
        localObject = (CertifiedAccountMeta.StYouZanGood)localObject;
        if (((CertifiedAccountMeta.StYouZanGood)localObject).itemID.get() > 0L) {
          localObject = String.valueOf(((CertifiedAccountMeta.StYouZanGood)localObject).itemID.get());
        } else {
          localObject = ((CertifiedAccountMeta.StYouZanGood)localObject).alias.get();
        }
      }
      localStringBuilder.append((String)localObject);
      if (m != ((ArrayList)getData()).size() - 1) {
        localStringBuilder.append(",");
      }
      m += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void setData(ArrayList paramArrayList)
  {
    super.setData(paramArrayList);
    CommodityListView.CommodityAdapter localCommodityAdapter = this.h;
    if (localCommodityAdapter != null) {
      localCommodityAdapter.b(paramArrayList);
    }
  }
  
  public void setOnDataChangeListener(CommodityListView.onDataChangeListener paramonDataChangeListener)
  {
    this.e = paramonDataChangeListener;
  }
  
  public void setOrientation(int paramInt)
  {
    LinearLayoutManager localLinearLayoutManager = this.d;
    if (localLinearLayoutManager != null) {
      localLinearLayoutManager.setOrientation(paramInt);
    }
  }
  
  public void setPublishUI(boolean paramBoolean)
  {
    Object localObject = this.i;
    int n = 8;
    int m;
    if (localObject != null)
    {
      if (paramBoolean) {
        m = 8;
      } else {
        m = 0;
      }
      ((TextView)localObject).setVisibility(m);
    }
    localObject = this.f;
    if (localObject != null)
    {
      if (paramBoolean) {
        m = 8;
      } else {
        m = 0;
      }
      ((TextView)localObject).setVisibility(m);
    }
    localObject = this.j;
    if (localObject != null)
    {
      if (paramBoolean) {
        m = n;
      } else {
        m = 0;
      }
      ((View)localObject).setVisibility(m);
    }
    setOrientation(1);
    this.k = paramBoolean;
    localObject = this.c;
    if (localObject != null)
    {
      ((RecyclerView)localObject).getLayoutParams().height = ImmersiveUtils.dpToPx(250.0F);
      requestLayout();
    }
  }
  
  public void setShopData(CertifiedAccountMeta.StFeed paramStFeed)
  {
    CertifiedAccountMeta.StUser localStUser = paramStFeed.poster;
    this.g = paramStFeed;
    if ((this.f != null) && (localStUser.youZhan.size() > 0) && (((CertifiedAccountMeta.StYouZanShop)localStUser.youZhan.get(0)).goodNum.get() > 0))
    {
      paramStFeed = localStUser.id.get();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("auth_");
      ((StringBuilder)localObject).append(SubscribeShareHelper.a(getExtraTypeInfo()));
      VSReporter.a(paramStFeed, ((StringBuilder)localObject).toString(), "exp_shop", 0, 0, new String[0]);
      this.f.setVisibility(0);
      localObject = this.f;
      String str = HardCodeUtil.a(2131916906);
      if (SubscribeUtils.a(localStUser.attr.get())) {
        paramStFeed = HardCodeUtil.a(2131900409);
      } else {
        paramStFeed = localStUser.nick.get();
      }
      ((TextView)localObject).setText(String.format(str, new Object[] { paramStFeed }));
      this.f.setOnClickListener(new CommodityListView.1(this, localStUser));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityListView
 * JD-Core Version:    0.7.0.1
 */