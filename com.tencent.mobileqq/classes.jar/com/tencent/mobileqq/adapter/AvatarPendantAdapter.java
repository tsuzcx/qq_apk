package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.PendantMarketConfig;
import com.tencent.mobileqq.activity.pendant.PendantMarketConfig.EntryConfig;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.apollo.utils.api.ICMShowWnsHelper;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarInPendantHeadportraitInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantShopSeriesInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AvatarPendantAdapter
  extends BaseAdapter
{
  static LRULinkedHashMap<String, URLDrawable> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(15);
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  String jdField_a_of_type_JavaLangString;
  List<Object> jdField_a_of_type_JavaUtilList;
  public boolean a;
  final int b;
  final int c = 1;
  final int d = 2;
  final int e = 3;
  final int f = 4;
  int g;
  int h;
  int i;
  int j;
  int k = 4;
  int l;
  int m;
  int n;
  int o;
  
  public AvatarPendantAdapter(Context paramContext, View.OnClickListener paramOnClickListener, AdapterView.OnItemClickListener paramOnItemClickListener, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.g = paramInt2;
    this.j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    paramInt1 = this.jdField_a_of_type_Int;
    paramInt2 = this.j;
    int i1 = this.k;
    this.h = ((paramInt1 - paramInt2 * (i1 + 1)) / i1);
    paramInt1 = this.h;
    this.i = (paramInt1 * 176 / 150);
    this.l = (paramInt1 - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.m = (this.i - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
  }
  
  public void a(List<AvatarPendantShopSeriesInfo> paramList, List<AvatarInPendantHeadportraitInfo> paramList1, List<CmAvatarFaceInfo> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList2 != null) && (paramList2.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.add(0, paramList2);
    }
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.add(paramList1);
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    if (paramList != null)
    {
      this.jdField_a_of_type_Long = paramList.pendantId;
      this.n = paramList.faceId;
    }
    super.notifyDataSetChanged();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      List localList = PendantMarketConfig.jdField_a_of_type_JavaUtilList;
      if ((localList != null) && (!localList.isEmpty()))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        int i1 = 0;
        while (i1 < localList.size())
        {
          Object localObject1 = (PendantMarketConfig.EntryConfig)localList.get(i1);
          View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561873, null);
          Object localObject2 = (ImageView)localView.findViewById(2131363161);
          TextView localTextView1 = (TextView)localView.findViewById(2131365782);
          TextView localTextView2 = (TextView)localView.findViewById(2131365780);
          ImageView localImageView = (ImageView)localView.findViewById(2131378147);
          if (!TextUtils.isEmpty(((PendantMarketConfig.EntryConfig)localObject1).jdField_a_of_type_JavaLangString)) {
            ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((PendantMarketConfig.EntryConfig)localObject1).jdField_a_of_type_JavaLangString));
          }
          localTextView1.setText(((PendantMarketConfig.EntryConfig)localObject1).c);
          localTextView2.setText(((PendantMarketConfig.EntryConfig)localObject1).d);
          int i2 = ((PendantMarketConfig.EntryConfig)localObject1).jdField_b_of_type_Int;
          if (i2 != 0)
          {
            if (i2 != 4)
            {
              if (i2 != 5)
              {
                if (i2 != 6)
                {
                  localImageView.setVisibility(8);
                }
                else
                {
                  localImageView.setImageResource(2130838524);
                  localImageView.setVisibility(0);
                }
              }
              else
              {
                localImageView.setImageResource(2130847298);
                localImageView.setVisibility(0);
              }
            }
            else
            {
              localImageView.setImageResource(2130847299);
              localImageView.setVisibility(0);
            }
          }
          else {
            localImageView.setVisibility(8);
          }
          if (localImageView.getVisibility() == 0)
          {
            localObject2 = localImageView.getDrawable();
            if (localObject2 != null) {
              localImageView.setLayoutParams(new LinearLayout.LayoutParams(((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight()));
            }
          }
          localView.setOnClickListener(new AvatarPendantAdapter.1(this, (PendantMarketConfig.EntryConfig)localObject1, i1));
          localView.addOnLayoutChangeListener(new AvatarPendantAdapter.2(this));
          if (i1 != 0) {
            localView.findViewById(2131377796).setVisibility(0);
          }
          localObject1 = new LinearLayout.LayoutParams(0, AIOUtils.b(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          i1 += 1;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > 0) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
    if ((localObject instanceof List))
    {
      List localList = (List)localObject;
      if ((localList.size() > 0) && ((localList.get(0) instanceof CmAvatarFaceInfo))) {
        return 4;
      }
    }
    if ((localObject instanceof AvatarPendantShopSeriesInfo)) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    if ((paramInt < getCount()) && (paramInt >= 0))
    {
      int i1 = getItemViewType(paramInt);
      Object localObject1;
      Object localObject3;
      if (paramView == null)
      {
        localObject2 = new AvatarPendantAdapter.ViewHolder(this);
        if (i1 == 0)
        {
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561876, paramViewGroup, false);
          localObject1 = paramView.findViewById(2131380143);
          localObject3 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject3).height = this.g;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366279));
          this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380144);
          b();
          paramView.setTag(localObject2);
          localObject1 = localObject2;
        }
        else if (i1 == 1)
        {
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561875, paramViewGroup, false);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372427));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372431));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372433));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372432));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131372420));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372425));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372424));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372411));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372413));
          ((AvatarPendantAdapter.ViewHolder)localObject2).d = ((TextView)paramView.findViewById(2131372412));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365768);
          localObject1 = new AvatarPendantAdapter.PendantGridAdapter(this);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject1);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.k);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.h);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.j);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.j);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.setTag(localObject2);
          localObject1 = localObject2;
        }
        else if (i1 == 2)
        {
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561870, paramViewGroup, false);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366427));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366445));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366447));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366446));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131374767));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366425));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366424));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366406));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366408));
          ((AvatarPendantAdapter.ViewHolder)localObject2).d = ((TextView)paramView.findViewById(2131366407));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365768);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new AvatarPendantAdapter.FaceGridAdapter(this));
          localObject1 = ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(HardCodeUtil.a(2131701101));
          ((StringBuilder)localObject3).append(AvatarPendantManager.jdField_a_of_type_Int);
          ((StringBuilder)localObject3).append(")");
          ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.k);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.h);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.j);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.j);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.setTag(localObject2);
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localObject2;
          if (i1 == 4)
          {
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561868, paramViewGroup, false);
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364794));
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364797));
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364799));
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364798));
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131364790));
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364793));
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364791));
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364786));
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364788));
            ((AvatarPendantAdapter.ViewHolder)localObject2).d = ((TextView)paramView.findViewById(2131364787));
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365768);
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new CmshowFaceGridAdapter(this.jdField_a_of_type_AndroidContentContext, this.h, this.i, this.n, this.o));
            localObject1 = ((ICMShowWnsHelper)QRoute.api(ICMShowWnsHelper.class)).getCmshowAvatarTitle();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append("(");
            ((StringBuilder)localObject3).append(((AvatarPendantActivity)this.jdField_a_of_type_AndroidContentContext).c());
            ((StringBuilder)localObject3).append(")");
            localObject1 = ((StringBuilder)localObject3).toString();
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.k);
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.h);
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.j);
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.j);
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((AvatarPendantAdapter.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramView.setTag(localObject2);
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        localObject1 = (AvatarPendantAdapter.ViewHolder)paramView.getTag();
      }
      ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_Int = paramInt;
      if (i1 == 1)
      {
        AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo = (AvatarPendantShopSeriesInfo)getItem(paramInt);
        ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setTag(localAvatarPendantShopSeriesInfo);
        if (localAvatarPendantShopSeriesInfo.c != null) {
          if (localAvatarPendantShopSeriesInfo.c.equals("1"))
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847678));
          }
          else if (localAvatarPendantShopSeriesInfo.c.equals("3"))
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847677));
          }
          else
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString != null)
        {
          localObject2 = ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.size());
          ((StringBuilder)localObject3).append(")");
          ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
        }
        ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_b_of_type_Int));
        File localFile;
        switch (localAvatarPendantShopSeriesInfo.jdField_b_of_type_Int)
        {
        default: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
        case 7: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847684));
          break;
        case 6: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847685));
          break;
        case 5: 
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(AvatarPendantUtil.c);
          ((StringBuilder)localObject2).append("/rare.png");
          localFile = new File(((StringBuilder)localObject2).toString());
          if (localFile.exists())
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject3 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_rare.png");
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              localObject3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
              localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
              localObject2 = localObject3;
              if (((URLDrawable)localObject3).getStatus() == 1)
              {
                jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_rare.png", localObject3);
                localObject2 = localObject3;
              }
            }
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          }
          else
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          break;
        case 4: 
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(AvatarPendantUtil.c);
          ((StringBuilder)localObject2).append("/free.png");
          localFile = new File(((StringBuilder)localObject2).toString());
          if (localFile.exists())
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject3 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_free.png");
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              localObject3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject3);
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject3);
              localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
              localObject2 = localObject3;
              if (((URLDrawable)localObject3).getStatus() == 1)
              {
                jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_free.png", localObject3);
                localObject2 = localObject3;
              }
            }
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          }
          else
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          break;
        case 3: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847679));
          break;
        case 2: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847298));
          break;
        case 1: 
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847299));
        }
        if ((localAvatarPendantShopSeriesInfo.e != null) && (localAvatarPendantShopSeriesInfo.e.equals("actLiTpl")))
        {
          if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString != null)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            i1 = 1;
          }
          else
          {
            i1 = 0;
          }
          if (localAvatarPendantShopSeriesInfo.jdField_b_of_type_JavaLangString != null)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).d.setText(localAvatarPendantShopSeriesInfo.jdField_b_of_type_JavaLangString);
            ((AvatarPendantAdapter.ViewHolder)localObject1).d.setVisibility(0);
            i1 = 1;
          }
          if (i1 != 0)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          else
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          }
        }
        else
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        ((AvatarPendantAdapter.PendantGridAdapter)((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.getAdapter()).a(localAvatarPendantShopSeriesInfo);
        ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_a_of_type_Int));
        ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_a_of_type_Int));
        if ((localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.size() > 4) && ((localAvatarPendantShopSeriesInfo.e == null) || (localAvatarPendantShopSeriesInfo.e.equals(""))))
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          if (!localAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131695122);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850107);
          }
          else
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131716878);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850110);
          }
        }
        else
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (paramInt == getCount() - 1)
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
          localObject2 = paramView;
        }
        else
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          localObject2 = paramView;
        }
      }
      else if (i1 == 2)
      {
        localObject2 = (List)getItem(paramInt);
        ((AvatarPendantAdapter.FaceGridAdapter)((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.getAdapter()).a((List)localObject2);
        if (((List)localObject2).size() == 8)
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701088));
          localObject2 = paramView;
        }
        else
        {
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          localObject2 = paramView;
        }
      }
      else
      {
        localObject2 = paramView;
        if (i1 == 4)
        {
          localObject2 = (List)getItem(paramInt);
          ((CmshowFaceGridAdapter)((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.getAdapter()).a((List)localObject2);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject2 = this.jdField_a_of_type_AndroidContentContext;
          boolean bool;
          if ((localObject2 instanceof AvatarPendantActivity)) {
            bool = ((AvatarPendantActivity)localObject2).c();
          } else {
            bool = false;
          }
          if (bool)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701088));
          }
          else
          {
            i1 = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
            ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "openmore", "expose", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).f(i1).a());
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131690048));
          }
          localObject2 = paramView.findViewById(2131364792);
          if (BaseApplicationImpl.getApplication().getSharedPreferences("facechoosedata", 0).getBoolean("cmshow_avatar_red_dot", false))
          {
            ((View)localObject2).setVisibility(0);
            i1 = AIOUtils.b(12, this.jdField_a_of_type_AndroidContentContext.getResources());
            int i2 = AIOUtils.b(6, this.jdField_a_of_type_AndroidContentContext.getResources());
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setPadding(i1, i2, 0, 0);
          }
          i1 = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "cmshowavatar", "expose", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).f(i1).a());
          localObject2 = paramView;
        }
      }
    }
    else
    {
      localObject2 = paramView;
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AvatarPendantAdapter
 * JD-Core Version:    0.7.0.1
 */