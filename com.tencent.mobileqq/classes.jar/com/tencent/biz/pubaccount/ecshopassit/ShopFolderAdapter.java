package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptPicManager;
import com.tencent.biz.pubaccount.subscript.SubscriptPicManager.ImageHostListener;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipListView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import laf;
import lag;

public class ShopFolderAdapter
  extends BaseAdapter
  implements View.OnClickListener, SubscriptPicManager.ImageHostListener
{
  int jdField_a_of_type_Int;
  public Context a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  public EcshopCacheTool a;
  SubscriptPicManager jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  List jdField_a_of_type_JavaUtilList;
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
    paramContext = View.inflate(paramContext, 2130970940, null);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131372302);
    paramContext.findViewById(2131372303).setOnClickListener(new laf(this, paramString));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(paramContext);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a();
    this.jdField_a_of_type_ComTencentWidgetSwipListView = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool = null;
  }
  
  public void a(RecentShopParcel paramRecentShopParcel)
  {
    if ((paramRecentShopParcel == null) || (TextUtils.isEmpty(paramRecentShopParcel.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      if (paramRecentShopParcel.jdField_c_of_type_Int != 1) {
        break;
      }
      paramRecentShopParcel = ((EcshopWebActivity)this.jdField_a_of_type_AndroidContentContext).jdField_b_of_type_JavaLangString;
    } while (TextUtils.isEmpty(paramRecentShopParcel));
    Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramRecentShopParcel);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopReportHandler.a(134246437, null, null, null, null, ((EcshopWebActivity)this.jdField_a_of_type_AndroidContentContext).jdField_a_of_type_Long, false);
      return;
    }
    catch (Exception paramRecentShopParcel)
    {
      return;
    }
    int i = paramRecentShopParcel.jdField_b_of_type_Int;
    String str = paramRecentShopParcel.jdField_a_of_type_JavaLangString;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uinname", paramRecentShopParcel.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("red_hot_count", i);
    localIntent.putExtra("jump_from", 1);
    boolean bool;
    if (i > 0)
    {
      bool = true;
      localIntent.putExtra("has_unread_msg", bool);
      paramRecentShopParcel.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c.get(str) != null) {
        break label375;
      }
      i = 0;
      label242:
      if (i > 0)
      {
        if (i / 1000 <= 0) {
          break label399;
        }
        localObject = new BigDecimal(i / 1000.0F);
      }
    }
    label399:
    for (localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131435075) + ((BigDecimal)localObject).setScale(1, 4).floatValue() + "km";; localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131435075) + i + "m")
    {
      localIntent.putExtra("pub_account_type", "type_ecshop_account");
      localIntent.putExtra("ecshop_distance_tip", (String)localObject);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ReportController.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helper", "Clk_shopItem", 0, 0, str, "", paramRecentShopParcel.jdField_b_of_type_JavaLangString, "");
      return;
      bool = false;
      break;
      label375:
      i = ((Integer)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c.get(str)).intValue();
      break label242;
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView == null) || (TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool == null)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getLastVisiblePosition();
    label38:
    Object localObject;
    if (i <= j)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(i);
      if (localObject != null) {
        break label65;
      }
    }
    for (;;)
    {
      i += 1;
      break label38;
      break;
      label65:
      localObject = (lag)((View)localObject).getTag();
      if ((localObject != null) && (paramString.equals(((lag)localObject).jdField_a_of_type_JavaLangString)))
      {
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a(paramString);
        if (localBitmap != null) {
          ((lag)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        }
      }
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public boolean a(ImageView paramImageView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView == null) || (paramImageView == null)) {
      return false;
    }
    int i = ((Integer)paramImageView.getTag(2131362186)).intValue();
    int j = this.jdField_a_of_type_ComTencentWidgetSwipListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetSwipListView.getLastVisiblePosition();
    return (i >= j) && (i <= k);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (RecentShopParcel)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    float f;
    if (paramView == null)
    {
      paramViewGroup = new lag(this);
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970943, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362719));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { (ImageView)localView.findViewById(2131371590), (ImageView)localView.findViewById(2131371591), (ImageView)localView.findViewById(2131371592) };
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131362754));
      paramViewGroup.b = ((SingleLineTextView)localView.findViewById(2131366642));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131366832));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, localView);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131365690));
      paramViewGroup.jdField_a_of_type_AndroidViewView = localView.findViewById(2131372304);
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494277);
      paramViewGroup.b.setExtendTextColor(paramView, 0);
      paramViewGroup.b.setExtendTextSize(12.0F, 0);
      f = DeviceInfoUtil.a();
      paramViewGroup.b.setExtendTextPadding((int)(f * 5.0F), 2);
      localView.setTag(paramViewGroup);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool != null) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.jdField_a_of_type_Boolean))
      {
        localView.findViewById(2131363630).setVisibility(0);
        paramView = new ColorStateList(new int[][] { new int[0] }, new int[] { -8947849 });
        localView.findViewById(2131372304).setBackgroundResource(2130843948);
        paramViewGroup.b.setExtendTextColor(paramView, 0);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(Color.parseColor("#FF777777"));
        paramViewGroup.b.setTextColor(Color.parseColor("#FF000000"));
      }
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = (RecentShopParcel)getItem(paramInt);
      if (localObject1 != null) {
        break;
      }
      return null;
      paramViewGroup = (lag)paramView.getTag();
      localView = paramView;
    }
    int i;
    label491:
    int j;
    if (((RecentShopParcel)localObject1).jdField_b_of_type_Long > ((RecentShopParcel)localObject1).jdField_a_of_type_Long)
    {
      i = 1;
      paramViewGroup.jdField_a_of_type_JavaLangString = ((RecentShopParcel)localObject1).jdField_a_of_type_JavaLangString;
      if (((RecentShopParcel)localObject1).jdField_a_of_type_Int == 0) {
        break label1304;
      }
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(((RecentShopParcel)localObject1).jdField_a_of_type_Int);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding(AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setBounds(0, 0, AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, paramView);
      paramView = (String)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.d.get(((RecentShopParcel)localObject1).jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty(paramView)) || (!this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a(paramView))) {
        break label1316;
      }
      paramView = ((RecentShopParcel)localObject1).jdField_b_of_type_JavaLangString + "(" + this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a(paramView) + ")";
      label572:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
      if (TextUtils.isEmpty(((RecentShopParcel)localObject1).jdField_c_of_type_JavaLangString)) {
        break label1325;
      }
      paramViewGroup.b.setExtendText(((RecentShopParcel)localObject1).jdField_c_of_type_JavaLangString, 0);
      label614:
      paramViewGroup.b.setExtendText(" ", 2);
      if (((RecentShopParcel)localObject1).jdField_b_of_type_Int <= 0) {
        break label1338;
      }
      j = 3;
      label636:
      CustomWidgetUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, j, ((RecentShopParcel)localObject1).jdField_b_of_type_Int, 2130846055, 99, null);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131362185, localObject1);
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a(((RecentShopParcel)localObject1).jdField_a_of_type_JavaLangString);
      if (paramView == null) {
        break label1344;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
      label693:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(2131362185, localObject1);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c.isEmpty()) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c.get(((RecentShopParcel)localObject1).jdField_a_of_type_JavaLangString) != null)) {
        break label1363;
      }
      j = 0;
      label773:
      if (j <= 0) {
        break label1689;
      }
      if (j / 1000 <= 0) {
        break label1391;
      }
      paramView = new BigDecimal(j / 1000.0F);
      paramView = "[" + this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131435075) + paramView.setScale(1, 4).floatValue() + "km]";
    }
    for (;;)
    {
      label852:
      Object localObject2 = new QQText(String.valueOf(((RecentShopParcel)localObject1).d).replaceFirst("^\\s+", ""), 3, 20);
      Object localObject3;
      if (!TextUtils.isEmpty(paramView))
      {
        localObject3 = new SpannableString(paramView);
        ((Spannable)localObject3).setSpan(new ForegroundColorSpan(Color.rgb(255, 132, 68)), 0, paramView.length(), 33);
        paramView = new SpannableStringBuilder();
        paramView.append((CharSequence)localObject3);
        paramView.append((CharSequence)localObject2);
        paramViewGroup.b.setText(paramView);
        label959:
        if (i == 0) {
          break label1449;
        }
        paramViewGroup.b.setCompoundDrawablesWithIntrinsicBounds(2130838701, 0);
        label975:
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(2131362185, localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        f = AIOUtils.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if ((!TextUtils.isEmpty(((RecentShopParcel)localObject1).e)) && (i == 0)) {
          break label1461;
        }
        localView.findViewById(2131372306).setVisibility(8);
        label1040:
        paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(2131362185, localObject1);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        localView.setTag(-3, Integer.valueOf((int)f));
        paramView = (LinearLayout.LayoutParams)paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
        if (((RecentShopParcel)localObject1).jdField_c_of_type_Int != 1) {
          break label1638;
        }
        paramViewGroup.b.setExtendText("", 0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        localObject2 = (ImageButton)localView.findViewById(2131372305);
        ((ImageButton)localObject2).setVisibility(0);
        ((ImageButton)localObject2).setTag(2131362185, localObject1);
        ((ImageButton)localObject2).setOnClickListener(this);
        localObject2 = ((EcshopWebActivity)this.jdField_a_of_type_AndroidContentContext).jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = (URLImageView)localView.findViewById(2131370470);
          localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838680);
        }
      }
      label1304:
      label1316:
      label1325:
      label1338:
      label1344:
      label1363:
      label1638:
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject3);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject3);
        localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        if (localObject2 != null)
        {
          if (((URLDrawable)localObject2).getStatus() == 2) {
            ((URLDrawable)localObject2).restartDownload();
          }
          ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
          ((URLImageView)localObject1).setVisibility(0);
        }
      }
      catch (Exception localException)
      {
        label1254:
        label1391:
        break label1254;
      }
      for (paramView.rightMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; paramView.rightMargin = AIOUtils.a(45.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setLayoutParams(paramView);
        localView.setOnClickListener(this);
        localView.setTag(-1, Integer.valueOf(paramInt));
        return localView;
        i = 0;
        break;
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        break label491;
        paramView = ((RecentShopParcel)localObject1).jdField_b_of_type_JavaLangString;
        break label572;
        paramViewGroup.b.setExtendText("", 0);
        break label614;
        j = 0;
        break label636;
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.a(this.jdField_a_of_type_AndroidContentContext, ((RecentShopParcel)localObject1).jdField_a_of_type_JavaLangString);
        break label693;
        j = ((Integer)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.c.get(((RecentShopParcel)localObject1).jdField_a_of_type_JavaLangString)).intValue();
        break label773;
        paramView = "[" + this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131435075) + j + "m]";
        break label852;
        paramViewGroup.b.setText((CharSequence)localObject2);
        break label959;
        label1449:
        paramViewGroup.b.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        break label975;
        label1461:
        paramView = new ArrayList(Arrays.asList(((RecentShopParcel)localObject1).e.split(",")));
        i = 0;
        while (i < 3)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setTag(2131362186, Integer.valueOf(paramInt));
          localObject2 = paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].getLayoutParams();
          j = this.jdField_a_of_type_Int;
          ((ViewGroup.LayoutParams)localObject2).width = j;
          ((ViewGroup.LayoutParams)localObject2).height = j;
          if (i == 2) {
            ((ViewGroup.LayoutParams)localObject2).width += this.jdField_b_of_type_Int;
          }
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager.a(PubAccountHttpDownloader.a((String)paramView.get(i), 1), paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i], ((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height, this);
          i += 1;
        }
        localView.findViewById(2131372306).setVisibility(0);
        break label1040;
        localView.findViewById(2131372305).setVisibility(8);
        localView.findViewById(2131370470).setVisibility(8);
      }
      label1689:
      paramView = "";
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    paramView = (RecentShopParcel)paramView.getTag(2131362185);
    if (i == 2131372304) {
      a(paramView);
    }
    do
    {
      return;
      if ((i == 2131365690) || (i == 2131372305))
      {
        i = paramView.jdField_b_of_type_Int;
        this.jdField_a_of_type_JavaUtilList.remove(paramView);
        notifyDataSetChanged();
        if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        localIntent = new Intent("action_shop_set_read");
        localIntent.putExtra("uin", paramView.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("needDelete", true);
        localIntent.putExtra("unReadNum", i);
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
        return;
      }
    } while (i != 2131362719);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
    localIntent.putExtra("uin", paramView.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("report_src_param_type", "");
    localIntent.putExtra("report_src_param_name", "");
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(null, "P_CliOper", "Shop_lifeservice", "", "Shop_helperhead", "Clk_shopItemhead", 0, 0, paramView.jdField_a_of_type_JavaLangString, "", paramView.jdField_b_of_type_JavaLangString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopFolderAdapter
 * JD-Core Version:    0.7.0.1
 */