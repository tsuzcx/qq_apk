package com.tencent.biz.subscribe.widget.commodity;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import aaba;
import aabm;
import aabn;
import aabp;
import aanb;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import anvx;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import zqn;

public class CommodityListView
  extends BaseWidgetView<ArrayList>
{
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private aabn jdField_a_of_type_Aabn;
  private aabp jdField_a_of_type_Aabp;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
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
  
  public int a()
  {
    return 2131558798;
  }
  
  public String a()
  {
    if (a() == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < ((ArrayList)a()).size())
    {
      Object localObject = ((ArrayList)a()).get(i);
      if ((localObject instanceof CommodityBean))
      {
        long l = ((CommodityBean)localObject).mItemID;
        if (l > 0L) {
          localObject = String.valueOf(l);
        }
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject);
        if (i != ((ArrayList)a()).size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
        break;
        localObject = ((CommodityBean)localObject).mAlias;
        continue;
        if (((CertifiedAccountMeta.StYouZanGood)localObject).itemID.get() > 0L) {
          localObject = String.valueOf(((CertifiedAccountMeta.StYouZanGood)localObject).itemID.get());
        } else {
          localObject = ((CertifiedAccountMeta.StYouZanGood)localObject).alias.get();
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aabn != null)
    {
      this.jdField_a_of_type_Aabn.e();
      this.jdField_a_of_type_Aabn.notifyDataSetChanged();
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377013));
    this.b = ((TextView)paramView.findViewById(2131380210));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380134));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380658);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Aabn = new aabn(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aabn);
  }
  
  protected void a(ArrayList paramArrayList) {}
  
  public void setData(ArrayList paramArrayList)
  {
    super.setData(paramArrayList);
    if (this.jdField_a_of_type_Aabn != null) {
      this.jdField_a_of_type_Aabn.a(paramArrayList);
    }
  }
  
  public void setOnDataChangeListener(aabp paramaabp)
  {
    this.jdField_a_of_type_Aabp = paramaabp;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(paramInt);
    }
  }
  
  public void setPublishUI(boolean paramBoolean)
  {
    int j = 8;
    Object localObject;
    if (this.b != null)
    {
      localObject = this.b;
      if (paramBoolean)
      {
        i = 8;
        ((TextView)localObject).setVisibility(i);
      }
    }
    else
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label122;
        }
        i = 8;
        label49:
        ((TextView)localObject).setVisibility(i);
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (!paramBoolean) {
          break label127;
        }
      }
    }
    label122:
    label127:
    for (int i = j;; i = 0)
    {
      ((View)localObject).setVisibility(i);
      setOrientation(1);
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutParams().height = ImmersiveUtils.a(250.0F);
        requestLayout();
      }
      return;
      i = 0;
      break;
      i = 0;
      break label49;
    }
  }
  
  public void setShopData(CertifiedAccountMeta.StFeed paramStFeed)
  {
    CertifiedAccountMeta.StUser localStUser = paramStFeed.poster;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    TextView localTextView;
    String str;
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (localStUser.youZhan.size() > 0) && (((CertifiedAccountMeta.StYouZanShop)localStUser.youZhan.get(0)).goodNum.get() > 0))
    {
      aanb.a(localStUser.id.get(), "auth_" + aaba.a(a()), "exp_shop", 0, 0, new String[0]);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      str = anvx.a(2131719095);
      if (!zqn.a(localStUser.attr.get())) {
        break label164;
      }
    }
    label164:
    for (paramStFeed = anvx.a(2131701718);; paramStFeed = localStUser.nick.get())
    {
      localTextView.setText(String.format(str, new Object[] { paramStFeed }));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aabm(this, localStUser));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityListView
 * JD-Core Version:    0.7.0.1
 */