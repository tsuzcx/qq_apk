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
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
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
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  EcshopCacheTool jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool;
  SubscriptPicManager jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  List<RecentShopParcel> jdField_a_of_type_JavaUtilList;
  int b;
  
  public ShopFolderAdapter(Context paramContext, SwipListView paramSwipListView, EcshopCacheTool paramEcshopCacheTool, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = ((localDisplayMetrics.widthPixels - 8) / 3);
    this.jdField_b_of_type_Int = ((localDisplayMetrics.widthPixels - 8) % 3);
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = new SubscriptPicManager();
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool = paramEcshopCacheTool;
    paramContext = View.inflate(paramContext, 2131561885, null);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131366232);
    paramContext.findViewById(2131363925).setOnClickListener(new ShopFolderAdapter.1(this, paramString));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(paramContext);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a();
    this.jdField_a_of_type_ComTencentWidgetSwipListView = null;
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null)
    {
      localList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool = null;
  }
  
  public void a(RecentShopParcel paramRecentShopParcel)
  {
    Object localObject;
    if (paramRecentShopParcel != null)
    {
      if (TextUtils.isEmpty(paramRecentShopParcel.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (paramRecentShopParcel.jdField_c_of_type_Int == 1)
      {
        paramRecentShopParcel = ((EcshopWebActivity)this.jdField_a_of_type_AndroidContentContext).jdField_b_of_type_JavaLangString;
        if (TextUtils.isEmpty(paramRecentShopParcel)) {
          return;
        }
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramRecentShopParcel);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopReportHandler.a(134246437, null, null, null, null, ((EcshopWebActivity)this.jdField_a_of_type_AndroidContentContext).jdField_a_of_type_Long, false);
      return;
    }
    catch (Exception paramRecentShopParcel) {}
    int j = paramRecentShopParcel.jdField_b_of_type_Int;
    String str = paramRecentShopParcel.jdField_a_of_type_JavaLangString;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uinname", paramRecentShopParcel.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("red_hot_count", j);
    localIntent.putExtra("jump_from", 1);
    int i = 0;
    boolean bool;
    if (j > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localIntent.putExtra("has_unread_msg", bool);
    paramRecentShopParcel.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c.get(str) != null) {
      i = ((Integer)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c.get(str)).intValue();
    }
    if (i > 0)
    {
      if (i / 1000 > 0)
      {
        localObject = new BigDecimal(i / 1000.0F);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694387));
        localStringBuilder.append(((BigDecimal)localObject).setScale(1, 4).floatValue());
        localStringBuilder.append("km");
        localObject = localStringBuilder.toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getString(2131694387));
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("m");
        localObject = ((StringBuilder)localObject).toString();
      }
      localIntent.putExtra("pub_account_type", "type_ecshop_account");
      localIntent.putExtra("ecshop_distance_tip", (String)localObject);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helper", "Clk_shopItem", 0, 0, str, "", paramRecentShopParcel.jdField_b_of_type_JavaLangString, "");
    return;
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool == null) {
        return;
      }
      int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
      int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getLastVisiblePosition();
      while (i <= j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(i);
        if (localObject != null)
        {
          localObject = (ShopFolderAdapter.EcshopHolder)((View)localObject).getTag();
          if ((localObject != null) && (paramString.equals(((ShopFolderAdapter.EcshopHolder)localObject).jdField_a_of_type_JavaLangString)))
          {
            Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a(paramString);
            if (localBitmap != null) {
              ((ShopFolderAdapter.EcshopHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(List<RecentShopParcel> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    } else {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public boolean a(ImageView paramImageView)
  {
    SwipListView localSwipListView = this.jdField_a_of_type_ComTencentWidgetSwipListView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localSwipListView != null)
    {
      if (paramImageView == null) {
        return false;
      }
      int i = ((Integer)paramImageView.getTag(2131374763)).intValue();
      int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetSwipListView.getLastVisiblePosition();
      bool1 = bool2;
      if (i >= j)
      {
        bool1 = bool2;
        if (i <= k) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
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
    float f;
    if (paramView == null)
    {
      localEcshopHolder = new ShopFolderAdapter.EcshopHolder(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561887, null);
      localEcshopHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
      localEcshopHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { (ImageView)paramView.findViewById(2131368592), (ImageView)paramView.findViewById(2131368593), (ImageView)paramView.findViewById(2131368594) };
      localEcshopHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371697));
      localEcshopHolder.b = ((SingleLineTextView)paramView.findViewById(2131371529));
      localEcshopHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380207));
      localEcshopHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
      localEcshopHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      localEcshopHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370802));
      localEcshopHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366021);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167152);
      localEcshopHolder.b.setExtendTextColor((ColorStateList)localObject2, 0);
      localEcshopHolder.b.setExtendTextSize(12.0F, 0);
      f = DeviceInfoUtil.a();
      localEcshopHolder.b.setExtendTextPadding((int)(f * 5.0F), 2);
      paramView.setTag(localEcshopHolder);
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool;
      if ((localObject2 != null) && (((EcshopCacheTool)localObject2).jdField_a_of_type_Boolean))
      {
        paramView.findViewById(2131365759).setVisibility(0);
        localObject2 = new ColorStateList(new int[][] { new int[0] }, new int[] { -8947849 });
        paramView.findViewById(2131366021).setBackgroundResource(2130847334);
        localEcshopHolder.b.setExtendTextColor((ColorStateList)localObject2, 0);
        localEcshopHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#FF777777"));
        localEcshopHolder.b.setTextColor(Color.parseColor("#FF000000"));
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
      int i;
      if (((RecentShopParcel)localObject2).jdField_b_of_type_Long > ((RecentShopParcel)localObject2).jdField_a_of_type_Long) {
        i = 1;
      } else {
        i = 0;
      }
      localEcshopHolder.jdField_a_of_type_JavaLangString = ((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString;
      if (((RecentShopParcel)localObject2).jdField_a_of_type_Int != 0)
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(((RecentShopParcel)localObject2).jdField_a_of_type_Int);
        localEcshopHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        ((Drawable)localObject1).setBounds(0, 0, AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localEcshopHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, (Drawable)localObject1);
      }
      else
      {
        localEcshopHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      }
      localObject1 = (String)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.d.get(((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a((String)localObject1)))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((RecentShopParcel)localObject2).jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject3).append("(");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a((String)localObject1));
        ((StringBuilder)localObject3).append(")");
        localObject1 = ((StringBuilder)localObject3).toString();
      }
      else
      {
        localObject1 = ((RecentShopParcel)localObject2).jdField_b_of_type_JavaLangString;
      }
      localEcshopHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject1);
      localEcshopHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
      if (!TextUtils.isEmpty(((RecentShopParcel)localObject2).jdField_c_of_type_JavaLangString)) {
        localEcshopHolder.b.setExtendText(((RecentShopParcel)localObject2).jdField_c_of_type_JavaLangString, 0);
      } else {
        localEcshopHolder.b.setExtendText("", 0);
      }
      localEcshopHolder.b.setExtendText(" ", 2);
      int j;
      if (((RecentShopParcel)localObject2).jdField_b_of_type_Int > 0) {
        j = 3;
      } else {
        j = 0;
      }
      CustomWidgetUtil.a(localEcshopHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, j, ((RecentShopParcel)localObject2).jdField_b_of_type_Int, 2130850770, 99, null);
      localEcshopHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131374762, localObject2);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a(((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString);
      if (localObject1 != null) {
        localEcshopHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      } else {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a(this.jdField_a_of_type_AndroidContentContext, ((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString);
      }
      localEcshopHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localEcshopHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
      localEcshopHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(2131374762, localObject2);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c.isEmpty()) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c.get(((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString) != null)) {
        j = ((Integer)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c.get(((RecentShopParcel)localObject2).jdField_a_of_type_JavaLangString)).intValue();
      } else {
        j = 0;
      }
      if (j > 0)
      {
        if (j / 1000 > 0)
        {
          localObject1 = new BigDecimal(j / 1000.0F);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694387));
          ((StringBuilder)localObject3).append(((BigDecimal)localObject1).setScale(1, 4).floatValue());
          ((StringBuilder)localObject3).append("km]");
          localObject1 = ((StringBuilder)localObject3).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694387));
          ((StringBuilder)localObject1).append(j);
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
        localEcshopHolder.b.setText((CharSequence)localObject1);
      }
      else
      {
        localEcshopHolder.b.setText((CharSequence)localObject3);
      }
      if (i != 0) {
        localEcshopHolder.b.setCompoundDrawablesWithIntrinsicBounds(2130839534, 0);
      } else {
        localEcshopHolder.b.setCompoundDrawablesWithIntrinsicBounds(0, 0);
      }
      localEcshopHolder.jdField_a_of_type_AndroidWidgetButton.setTag(2131374762, localObject2);
      localEcshopHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      f = AIOUtils.b(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if ((!TextUtils.isEmpty(((RecentShopParcel)localObject2).e)) && (i == 0))
      {
        localObject1 = new ArrayList(Arrays.asList(((RecentShopParcel)localObject2).e.split(",")));
        i = 0;
        while (i < 3)
        {
          localEcshopHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setTag(2131374763, Integer.valueOf(paramInt));
          localObject3 = localEcshopHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].getLayoutParams();
          j = this.jdField_a_of_type_Int;
          ((ViewGroup.LayoutParams)localObject3).width = j;
          ((ViewGroup.LayoutParams)localObject3).height = j;
          if (i == 2) {
            ((ViewGroup.LayoutParams)localObject3).width += this.jdField_b_of_type_Int;
          }
          localEcshopHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL((String)((List)localObject1).get(i), 1), localEcshopHolder.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i], ((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height, this);
          i += 1;
        }
        paramView.findViewById(2131368713).setVisibility(0);
      }
      else
      {
        paramView.findViewById(2131368713).setVisibility(8);
      }
      localEcshopHolder.jdField_a_of_type_AndroidViewView.setTag(2131374762, localObject2);
      localEcshopHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(-3, Integer.valueOf((int)f));
      localObject1 = (LinearLayout.LayoutParams)localEcshopHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
      if (((RecentShopParcel)localObject2).jdField_c_of_type_Int == 1)
      {
        localEcshopHolder.b.setExtendText("", 0);
        localEcshopHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        localObject3 = (ImageButton)paramView.findViewById(2131363891);
        ((ImageButton)localObject3).setVisibility(0);
        ((ImageButton)localObject3).setTag(2131374762, localObject2);
        ((ImageButton)localObject3).setOnClickListener(this);
        localObject3 = ((EcshopWebActivity)this.jdField_a_of_type_AndroidContentContext).jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = (URLImageView)paramView.findViewById(2131362150);
          localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839505);
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
    ((LinearLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    break label1797;
    paramView.findViewById(2131363891).setVisibility(8);
    paramView.findViewById(2131362150).setVisibility(8);
    ((LinearLayout.LayoutParams)localObject1).rightMargin = AIOUtils.b(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    label1797:
    localEcshopHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramView.setOnClickListener(this);
    paramView.setTag(-1, Integer.valueOf(paramInt));
    localObject1 = paramView;
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    RecentShopParcel localRecentShopParcel = (RecentShopParcel)paramView.getTag(2131374762);
    if (i == 2131366021)
    {
      a(localRecentShopParcel);
    }
    else
    {
      Object localObject;
      if ((i != 2131370802) && (i != 2131363891))
      {
        if (i == 2131368343)
        {
          localObject = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/pubaccount/detail");
          ((ActivityURIRequest)localObject).extra().putString("uin", localRecentShopParcel.jdField_a_of_type_JavaLangString);
          ((ActivityURIRequest)localObject).extra().putString("report_src_param_type", "");
          ((ActivityURIRequest)localObject).extra().putString("report_src_param_name", "");
          ((ActivityURIRequest)localObject).setFlags(67108864);
          QRoute.startUri((URIRequest)localObject, null);
          ReportController.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helperhead", "Clk_shopItemhead", 0, 0, localRecentShopParcel.jdField_a_of_type_JavaLangString, "", localRecentShopParcel.jdField_b_of_type_JavaLangString, "");
        }
      }
      else
      {
        i = localRecentShopParcel.jdField_b_of_type_Int;
        this.jdField_a_of_type_JavaUtilList.remove(localRecentShopParcel);
        notifyDataSetChanged();
        if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        localObject = new Intent("action_shop_set_read");
        ((Intent)localObject).putExtra("uin", localRecentShopParcel.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("needDelete", true);
        ((Intent)localObject).putExtra("unReadNum", i);
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopFolderAdapter
 * JD-Core Version:    0.7.0.1
 */