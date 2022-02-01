package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.subscript.SubscriptPicManager;
import com.tencent.biz.pubaccount.subscript.SubscriptPicManager.ImageHostListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ShopFolderAdapter
  extends BaseAdapter
  implements View.OnClickListener, SubscriptPicManager.ImageHostListener
{
  List<RecentShopParcel> a;
  LayoutInflater b;
  Context c;
  int d;
  int e;
  SubscriptPicManager f;
  DragFrameLayout g;
  SwipListView h;
  EcshopCacheTool i;
  View j;
  
  public ShopFolderAdapter(Context paramContext, SwipListView paramSwipListView, EcshopCacheTool paramEcshopCacheTool, String paramString)
  {
    this.c = paramContext;
    this.b = LayoutInflater.from(this.c);
    DisplayMetrics localDisplayMetrics = this.c.getResources().getDisplayMetrics();
    this.d = ((localDisplayMetrics.widthPixels - 8) / 3);
    this.e = ((localDisplayMetrics.widthPixels - 8) % 3);
    this.f = new SubscriptPicManager();
    this.h = paramSwipListView;
    this.i = paramEcshopCacheTool;
    paramContext = View.inflate(paramContext, 2131628303, null);
    this.j = paramContext.findViewById(2131432523);
    paramContext.findViewById(2131429881).setOnClickListener(new ShopFolderAdapter.1(this, paramString));
    this.h.addFooterView(paramContext);
  }
  
  public void a()
  {
    this.f.a();
    this.h = null;
    List localList = this.a;
    if (localList != null)
    {
      localList.clear();
      this.a = null;
    }
    this.i = null;
  }
  
  public void a(RecentShopParcel paramRecentShopParcel)
  {
    Object localObject;
    if (paramRecentShopParcel != null)
    {
      if (TextUtils.isEmpty(paramRecentShopParcel.a)) {
        return;
      }
      if (paramRecentShopParcel.h == 1)
      {
        paramRecentShopParcel = ((EcshopWebActivity)this.c).d;
        if (TextUtils.isEmpty(paramRecentShopParcel)) {
          return;
        }
        localObject = new Intent(this.c, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramRecentShopParcel);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        this.c.startActivity((Intent)localObject);
      }
    }
    try
    {
      this.i.f.a(134246437, null, null, null, null, ((EcshopWebActivity)this.c).e, false);
      return;
    }
    catch (Exception paramRecentShopParcel) {}
    int m = paramRecentShopParcel.g;
    String str = paramRecentShopParcel.a;
    Intent localIntent = new Intent(this.c, ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uinname", paramRecentShopParcel.b);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("red_hot_count", m);
    localIntent.putExtra("jump_from", 1);
    int k = 0;
    boolean bool;
    if (m > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localIntent.putExtra("has_unread_msg", bool);
    paramRecentShopParcel.g = 0;
    if (this.i.d.get(str) != null) {
      k = ((Integer)this.i.d.get(str)).intValue();
    }
    if (k > 0)
    {
      if (k / 1000 > 0)
      {
        localObject = new BigDecimal(k / 1000.0F);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.c.getResources().getString(2131892066));
        localStringBuilder.append(((BigDecimal)localObject).setScale(1, 4).floatValue());
        localStringBuilder.append("km");
        localObject = localStringBuilder.toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.c.getString(2131892066));
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append("m");
        localObject = ((StringBuilder)localObject).toString();
      }
      localIntent.putExtra("pub_account_type", "type_ecshop_account");
      localIntent.putExtra("ecshop_distance_tip", (String)localObject);
    }
    this.c.startActivity(localIntent);
    ReportController.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helper", "Clk_shopItem", 0, 0, str, "", paramRecentShopParcel.b, "");
    return;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.g = paramDragFrameLayout;
  }
  
  public void a(String paramString)
  {
    if ((this.h != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (this.i == null) {
        return;
      }
      int k = this.h.getFirstVisiblePosition();
      int m = this.h.getLastVisiblePosition();
      while (k <= m)
      {
        Object localObject = this.h.getChildAt(k);
        if (localObject != null)
        {
          localObject = (ShopFolderAdapter.EcshopHolder)((View)localObject).getTag();
          if ((localObject != null) && (paramString.equals(((ShopFolderAdapter.EcshopHolder)localObject).a)))
          {
            Bitmap localBitmap = this.i.c(paramString);
            if (localBitmap != null) {
              ((ShopFolderAdapter.EcshopHolder)localObject).c.setImageBitmap(localBitmap);
            }
          }
        }
        k += 1;
      }
    }
  }
  
  public void a(List<RecentShopParcel> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.j.setVisibility(8);
    } else {
      this.j.setVisibility(0);
    }
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public boolean a(ImageView paramImageView)
  {
    SwipListView localSwipListView = this.h;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localSwipListView != null)
    {
      if (paramImageView == null) {
        return false;
      }
      int k = ((Integer)paramImageView.getTag(2131442953)).intValue();
      int m = this.h.getFirstVisiblePosition();
      int n = this.h.getLastVisiblePosition();
      bool1 = bool2;
      if (k >= m)
      {
        bool1 = bool2;
        if (k <= n) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.a;
    if (localList == null) {
      return null;
    }
    return localList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    ShopFolderAdapter.EcshopHolder localEcshopHolder;
    float f1;
    if (paramView == null)
    {
      localEcshopHolder = new ShopFolderAdapter.EcshopHolder(this);
      paramView = this.b.inflate(2131628305, null);
      localEcshopHolder.c = ((ImageView)paramView.findViewById(2131435219));
      localEcshopHolder.g = new ImageView[] { (ImageView)paramView.findViewById(2131435504), (ImageView)paramView.findViewById(2131435505), (ImageView)paramView.findViewById(2131435506) };
      localEcshopHolder.d = ((SingleLineTextView)paramView.findViewById(2131439121));
      localEcshopHolder.f = ((SingleLineTextView)paramView.findViewById(2131438908));
      localEcshopHolder.e = ((DragTextView)paramView.findViewById(2131449123));
      localEcshopHolder.e.setDragViewType(0, paramView);
      localEcshopHolder.e.setOnModeChangeListener(this.g);
      localEcshopHolder.h = ((Button)paramView.findViewById(2131438112));
      localEcshopHolder.b = paramView.findViewById(2131432296);
      localObject2 = this.c.getResources().getColorStateList(2131168133);
      localEcshopHolder.f.setExtendTextColor((ColorStateList)localObject2, 0);
      localEcshopHolder.f.setExtendTextSize(12.0F, 0);
      f1 = DeviceInfoUtil.A();
      localEcshopHolder.f.setExtendTextPadding((int)(f1 * 5.0F), 2);
      paramView.setTag(localEcshopHolder);
      localObject2 = this.i;
      if ((localObject2 != null) && (((EcshopCacheTool)localObject2).g))
      {
        paramView.findViewById(2131432003).setVisibility(0);
        localObject2 = new ColorStateList(new int[][] { new int[0] }, new int[] { -8947849 });
        paramView.findViewById(2131432296).setBackgroundResource(2130848985);
        localEcshopHolder.f.setExtendTextColor((ColorStateList)localObject2, 0);
        localEcshopHolder.d.setTextColor(Color.parseColor("#FF777777"));
        localEcshopHolder.f.setTextColor(Color.parseColor("#FF000000"));
      }
    }
    else
    {
      localEcshopHolder = (ShopFolderAdapter.EcshopHolder)paramView.getTag();
    }
    Object localObject2 = (RecentShopParcel)getItem(paramInt);
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      int k;
      if (((RecentShopParcel)localObject2).k > ((RecentShopParcel)localObject2).j) {
        k = 1;
      } else {
        k = 0;
      }
      localEcshopHolder.a = ((RecentShopParcel)localObject2).a;
      if (((RecentShopParcel)localObject2).f != 0)
      {
        localObject1 = this.c.getResources().getDrawable(((RecentShopParcel)localObject2).f);
        localEcshopHolder.d.setCompoundDrawablePadding(AIOUtils.b(6.0F, this.c.getResources()));
        ((Drawable)localObject1).setBounds(0, 0, AIOUtils.b(15.0F, this.c.getResources()), AIOUtils.b(15.0F, this.c.getResources()));
        localEcshopHolder.d.setCompoundDrawables(null, (Drawable)localObject1);
      }
      else
      {
        localEcshopHolder.d.setCompoundDrawables(null, null);
      }
      localObject1 = (String)this.i.e.get(((RecentShopParcel)localObject2).a);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.i.a((String)localObject1)))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((RecentShopParcel)localObject2).b);
        ((StringBuilder)localObject3).append("(");
        ((StringBuilder)localObject3).append(this.i.b((String)localObject1));
        ((StringBuilder)localObject3).append(")");
        localObject1 = ((StringBuilder)localObject3).toString();
      }
      else
      {
        localObject1 = ((RecentShopParcel)localObject2).b;
      }
      localEcshopHolder.d.setText((CharSequence)localObject1);
      localEcshopHolder.d.setExtendText("", 1);
      if (!TextUtils.isEmpty(((RecentShopParcel)localObject2).c)) {
        localEcshopHolder.f.setExtendText(((RecentShopParcel)localObject2).c, 0);
      } else {
        localEcshopHolder.f.setExtendText("", 0);
      }
      localEcshopHolder.f.setExtendText(" ", 2);
      int m;
      if (((RecentShopParcel)localObject2).g > 0) {
        m = 3;
      } else {
        m = 0;
      }
      CustomWidgetUtil.a(localEcshopHolder.e, m, ((RecentShopParcel)localObject2).g, 2130852592, 99, null);
      localEcshopHolder.e.setTag(2131442952, localObject2);
      localObject1 = this.i.c(((RecentShopParcel)localObject2).a);
      if (localObject1 != null) {
        localEcshopHolder.c.setImageBitmap((Bitmap)localObject1);
      } else {
        this.i.a(this.c, ((RecentShopParcel)localObject2).a);
      }
      localEcshopHolder.c.setOnClickListener(this);
      localEcshopHolder.c.setTag(-1, Integer.valueOf(paramInt));
      localEcshopHolder.c.setTag(2131442952, localObject2);
      if ((this.i.d != null) && (!this.i.d.isEmpty()) && (this.i.d.get(((RecentShopParcel)localObject2).a) != null)) {
        m = ((Integer)this.i.d.get(((RecentShopParcel)localObject2).a)).intValue();
      } else {
        m = 0;
      }
      if (m > 0)
      {
        if (m / 1000 > 0)
        {
          localObject1 = new BigDecimal(m / 1000.0F);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[");
          ((StringBuilder)localObject3).append(this.c.getResources().getString(2131892066));
          ((StringBuilder)localObject3).append(((BigDecimal)localObject1).setScale(1, 4).floatValue());
          ((StringBuilder)localObject3).append("km]");
          localObject1 = ((StringBuilder)localObject3).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[");
          ((StringBuilder)localObject1).append(this.c.getResources().getString(2131892066));
          ((StringBuilder)localObject1).append(m);
          ((StringBuilder)localObject1).append("m]");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else {
        localObject1 = "";
      }
      localObject3 = new QQText(String.valueOf(((RecentShopParcel)localObject2).d).replaceFirst("^\\s+", ""), 3, 20);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = new SpannableString((CharSequence)localObject1);
        ((Spannable)localObject4).setSpan(new ForegroundColorSpan(Color.rgb(255, 132, 68)), 0, ((String)localObject1).length(), 33);
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject4);
        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject3);
        localEcshopHolder.f.setText((CharSequence)localObject1);
      }
      else
      {
        localEcshopHolder.f.setText((CharSequence)localObject3);
      }
      if (k != 0) {
        localEcshopHolder.f.setCompoundDrawablesWithIntrinsicBounds(2130839732, 0);
      } else {
        localEcshopHolder.f.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
      localEcshopHolder.h.setTag(2131442952, localObject2);
      localEcshopHolder.h.setOnClickListener(this);
      f1 = AIOUtils.b(65.0F, this.c.getResources());
      if ((!TextUtils.isEmpty(((RecentShopParcel)localObject2).e)) && (k == 0))
      {
        localObject1 = new ArrayList(Arrays.asList(((RecentShopParcel)localObject2).e.split(",")));
        k = 0;
        while (k < 3)
        {
          localEcshopHolder.g[k].setTag(2131442953, Integer.valueOf(paramInt));
          localObject3 = localEcshopHolder.g[k].getLayoutParams();
          m = this.d;
          ((ViewGroup.LayoutParams)localObject3).width = m;
          ((ViewGroup.LayoutParams)localObject3).height = m;
          if (k == 2) {
            ((ViewGroup.LayoutParams)localObject3).width += this.e;
          }
          localEcshopHolder.g[k].setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.f.a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL((String)((List)localObject1).get(k), 1), localEcshopHolder.g[k], ((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height, this);
          k += 1;
        }
        paramView.findViewById(2131435626).setVisibility(0);
      }
      else
      {
        paramView.findViewById(2131435626).setVisibility(8);
      }
      localEcshopHolder.b.setTag(2131442952, localObject2);
      localEcshopHolder.b.setOnClickListener(this);
      paramView.setTag(-3, Integer.valueOf((int)f1));
      localObject1 = (LinearLayout.LayoutParams)localEcshopHolder.d.getLayoutParams();
      if (((RecentShopParcel)localObject2).h == 1)
      {
        localEcshopHolder.f.setExtendText("", 0);
        localEcshopHolder.c.setOnClickListener(this);
        localObject3 = (ImageButton)paramView.findViewById(2131429841);
        ((ImageButton)localObject3).setVisibility(0);
        ((ImageButton)localObject3).setTag(2131442952, localObject2);
        ((ImageButton)localObject3).setOnClickListener(this);
        localObject3 = ((EcshopWebActivity)this.c).c;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = (URLImageView)paramView.findViewById(2131427729);
          localObject4 = this.c.getResources().getDrawable(2130839696);
        }
      }
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject4);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
      localObject3 = URLDrawable.getDrawable((String)localObject3, localURLDrawableOptions);
      if (localObject3 != null)
      {
        if (((URLDrawable)localObject3).getStatus() == 2) {
          ((URLDrawable)localObject3).restartDownload();
        }
        ((URLImageView)localObject2).setImageDrawable((Drawable)localObject3);
        ((URLImageView)localObject2).setVisibility(0);
      }
    }
    catch (Exception localException)
    {
      label1734:
      break label1734;
    }
    ((LinearLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(6.0F, this.c.getResources());
    break label1797;
    paramView.findViewById(2131429841).setVisibility(8);
    paramView.findViewById(2131427729).setVisibility(8);
    ((LinearLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(45.0F, this.c.getResources());
    label1797:
    localEcshopHolder.d.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramView.setOnClickListener(this);
    paramView.setTag(-1, Integer.valueOf(paramInt));
    localObject1 = paramView;
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    RecentShopParcel localRecentShopParcel = (RecentShopParcel)paramView.getTag(2131442952);
    if (k == 2131432296)
    {
      a(localRecentShopParcel);
    }
    else
    {
      Object localObject;
      if ((k != 2131438112) && (k != 2131429841))
      {
        if (k == 2131435219)
        {
          localObject = new ActivityURIRequest(this.c, "/pubaccount/detail");
          ((ActivityURIRequest)localObject).extra().putString("uin", localRecentShopParcel.a);
          ((ActivityURIRequest)localObject).extra().putString("report_src_param_type", "");
          ((ActivityURIRequest)localObject).extra().putString("report_src_param_name", "");
          ((ActivityURIRequest)localObject).setFlags(67108864);
          QRoute.startUri((URIRequest)localObject, null);
          ReportController.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helperhead", "Clk_shopItemhead", 0, 0, localRecentShopParcel.a, "", localRecentShopParcel.b, "");
        }
      }
      else
      {
        k = localRecentShopParcel.g;
        this.a.remove(localRecentShopParcel);
        notifyDataSetChanged();
        if (this.a.isEmpty()) {
          this.j.setVisibility(0);
        }
        localObject = new Intent("action_shop_set_read");
        ((Intent)localObject).putExtra("uin", localRecentShopParcel.a);
        ((Intent)localObject).putExtra("needDelete", true);
        ((Intent)localObject).putExtra("unReadNum", k);
        this.c.sendBroadcast((Intent)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopFolderAdapter
 * JD-Core Version:    0.7.0.1
 */