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
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CommodityListView.CommodityAdapter jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter;
  private CommodityListView.onDataChangeListener jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$onDataChangeListener;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  
  public CommodityListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommodityListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int a()
  {
    return 2131558736;
  }
  
  public String a()
  {
    if (a() == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < ((ArrayList)a()).size())
    {
      Object localObject = ((ArrayList)a()).get(i);
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
      if (i != ((ArrayList)a()).size() - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    CommodityListView.CommodityAdapter localCommodityAdapter = this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter;
    if (localCommodityAdapter != null)
    {
      localCommodityAdapter.a();
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter.notifyDataSetChanged();
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376871));
    this.b = ((TextView)paramView.findViewById(2131379930));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379857));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380360);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter = new CommodityListView.CommodityAdapter(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter);
  }
  
  protected void a(ArrayList paramArrayList) {}
  
  public void setData(ArrayList paramArrayList)
  {
    super.setData(paramArrayList);
    CommodityListView.CommodityAdapter localCommodityAdapter = this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$CommodityAdapter;
    if (localCommodityAdapter != null) {
      localCommodityAdapter.a(paramArrayList);
    }
  }
  
  public void setOnDataChangeListener(CommodityListView.onDataChangeListener paramonDataChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$onDataChangeListener = paramonDataChangeListener;
  }
  
  public void setOrientation(int paramInt)
  {
    LinearLayoutManager localLinearLayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
    if (localLinearLayoutManager != null) {
      localLinearLayoutManager.setOrientation(paramInt);
    }
  }
  
  public void setPublishUI(boolean paramBoolean)
  {
    Object localObject = this.b;
    int j = 8;
    int i;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = 8;
      } else {
        i = 0;
      }
      ((TextView)localObject).setVisibility(i);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = 8;
      } else {
        i = 0;
      }
      ((TextView)localObject).setVisibility(i);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = j;
      } else {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
    }
    setOrientation(1);
    this.jdField_a_of_type_Boolean = paramBoolean;
    localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    if (localObject != null)
    {
      ((RecyclerView)localObject).getLayoutParams().height = ImmersiveUtils.dpToPx(250.0F);
      requestLayout();
    }
  }
  
  public void setShopData(CertifiedAccountMeta.StFeed paramStFeed)
  {
    CertifiedAccountMeta.StUser localStUser = paramStFeed.poster;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (localStUser.youZhan.size() > 0) && (((CertifiedAccountMeta.StYouZanShop)localStUser.youZhan.get(0)).goodNum.get() > 0))
    {
      paramStFeed = localStUser.id.get();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("auth_");
      ((StringBuilder)localObject).append(SubscribeShareHelper.a(a()));
      VSReporter.a(paramStFeed, ((StringBuilder)localObject).toString(), "exp_shop", 0, 0, new String[0]);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      String str = HardCodeUtil.a(2131719354);
      if (SubscribeUtils.a(localStUser.attr.get())) {
        paramStFeed = HardCodeUtil.a(2131702405);
      } else {
        paramStFeed = localStUser.nick.get();
      }
      ((TextView)localObject).setText(String.format(str, new Object[] { paramStFeed }));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new CommodityListView.1(this, localStUser));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityListView
 * JD-Core Version:    0.7.0.1
 */