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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.PendantMarketConfig;
import com.tencent.mobileqq.activity.pendant.PendantMarketConfig.EntryConfig;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.api.ui.impl.CmshowFaceGridAdapter;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarInPendantHeadportraitInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantShopSeriesInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import cooperation.qzone.video.QzoneLiveVideoInterface;
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
    this.h = ((this.jdField_a_of_type_Int - this.j * (this.k + 1)) / this.k);
    this.i = (this.h * 176 / 150);
    this.l = (this.h - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
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
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    List localList = PendantMarketConfig.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int i1 = 0;
      if (i1 < localList.size())
      {
        Object localObject1 = (PendantMarketConfig.EntryConfig)localList.get(i1);
        View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562040, null);
        Object localObject2 = (ImageView)localView.findViewById(2131363226);
        TextView localTextView1 = (TextView)localView.findViewById(2131365945);
        TextView localTextView2 = (TextView)localView.findViewById(2131365943);
        ImageView localImageView = (ImageView)localView.findViewById(2131378752);
        if (!TextUtils.isEmpty(((PendantMarketConfig.EntryConfig)localObject1).jdField_a_of_type_JavaLangString)) {
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((PendantMarketConfig.EntryConfig)localObject1).jdField_a_of_type_JavaLangString));
        }
        localTextView1.setText(((PendantMarketConfig.EntryConfig)localObject1).c);
        localTextView2.setText(((PendantMarketConfig.EntryConfig)localObject1).d);
        switch (((PendantMarketConfig.EntryConfig)localObject1).jdField_b_of_type_Int)
        {
        case 1: 
        case 2: 
        case 3: 
        default: 
          localImageView.setVisibility(8);
        }
        for (;;)
        {
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
            localView.findViewById(2131378385).setVisibility(0);
          }
          localObject1 = new LinearLayout.LayoutParams(0, AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          i1 += 1;
          break;
          localImageView.setImageResource(2130847429);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130847430);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130838685);
          localImageView.setVisibility(0);
          continue;
          localImageView.setVisibility(8);
        }
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    if (((localObject instanceof List)) && (((List)localObject).size() > 0) && ((((List)localObject).get(0) instanceof CmAvatarFaceInfo))) {
      return 4;
    }
    if ((localObject instanceof AvatarPendantShopSeriesInfo)) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramInt >= getCount()) || (paramInt < 0))
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    int i1 = getItemViewType(paramInt);
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = new AvatarPendantAdapter.ViewHolder(this);
      if (i1 == 0)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562043, paramViewGroup, false);
        localObject2 = paramView.findViewById(2131380879);
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).height = this.g;
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366399));
        this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380880);
        b();
        paramView.setTag(localObject1);
      }
    }
    label144:
    label2849:
    for (;;)
    {
      ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_Int = paramInt;
      AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo;
      if (i1 == 1)
      {
        localAvatarPendantShopSeriesInfo = (AvatarPendantShopSeriesInfo)getItem(paramInt);
        ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setTag(localAvatarPendantShopSeriesInfo);
        if (localAvatarPendantShopSeriesInfo.c != null)
        {
          if (localAvatarPendantShopSeriesInfo.c.equals("1"))
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847811));
          }
        }
        else
        {
          label228:
          if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString != null)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString + "(" + localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.size() + ")");
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
          }
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_b_of_type_Int));
          switch (localAvatarPendantShopSeriesInfo.jdField_b_of_type_Int)
          {
          default: 
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            label374:
            if ((localAvatarPendantShopSeriesInfo.e != null) && (localAvatarPendantShopSeriesInfo.e.equals("actLiTpl")))
            {
              i1 = 0;
              if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString != null)
              {
                ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
                ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
                ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                i1 = 1;
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
                label511:
                ((AvatarPendantAdapter.PendantGridAdapter)((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.getAdapter()).a(localAvatarPendantShopSeriesInfo);
                ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_a_of_type_Int));
                ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_a_of_type_Int));
                if ((localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.size() <= 4) || ((localAvatarPendantShopSeriesInfo.e != null) && (!localAvatarPendantShopSeriesInfo.e.equals("")))) {
                  break label2380;
                }
                ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean) {
                  break label2355;
                }
                ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131695132);
                ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850180);
                if (paramInt != getCount() - 1) {
                  break label2403;
                }
                ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
              }
            }
            break;
          }
        }
      }
      label2355:
      label2380:
      label2403:
      do
      {
        for (;;)
        {
          localObject1 = paramView;
          break;
          if (i1 == 1)
          {
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562042, paramViewGroup, false);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372848));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372852));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372854));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372853));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131372841));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372846));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372845));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372832));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372834));
            ((AvatarPendantAdapter.ViewHolder)localObject1).d = ((TextView)paramView.findViewById(2131372833));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365931);
            localObject2 = new AvatarPendantAdapter.PendantGridAdapter(this);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject2);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.k);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.h);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.j);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.j);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramView.setTag(localObject1);
            break label144;
          }
          if (i1 == 2)
          {
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562037, paramViewGroup, false);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366550));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366569));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366571));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366570));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131375253));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366548));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366547));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366525));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366527));
            ((AvatarPendantAdapter.ViewHolder)localObject1).d = ((TextView)paramView.findViewById(2131366526));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365931);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new AvatarPendantAdapter.FaceGridAdapter(this));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700958) + AvatarPendantManager.jdField_a_of_type_Int + ")");
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.k);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.h);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.j);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.j);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramView.setTag(localObject1);
            break label144;
          }
          if (i1 != 4) {
            break label2849;
          }
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562035, paramViewGroup, false);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364908));
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364911));
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364913));
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364912));
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131364904));
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364907));
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364905));
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364900));
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364902));
          ((AvatarPendantAdapter.ViewHolder)localObject1).d = ((TextView)paramView.findViewById(2131364901));
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365931);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new CmshowFaceGridAdapter(this.jdField_a_of_type_AndroidContentContext, this.h, this.i, this.n, this.o));
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131690132) + ((AvatarPendantActivity)this.jdField_a_of_type_AndroidContentContext).c() + ")");
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.k);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.h);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.j);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.j);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.setTag(localObject1);
          break label144;
          localObject1 = (AvatarPendantAdapter.ViewHolder)paramView.getTag();
          break label144;
          if (localAvatarPendantShopSeriesInfo.c.equals("3"))
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847810));
            break label228;
          }
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label228;
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847430));
          break label374;
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847429));
          break label374;
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847812));
          break label374;
          File localFile = new File(AvatarPendantUtil.c + "/free.png");
          if (localFile.exists())
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject3 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_free.png");
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
              localObject2 = localObject3;
              if (((URLDrawable)localObject3).getStatus() == 1)
              {
                jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_free.png", localObject3);
                localObject2 = localObject3;
              }
            }
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            break label374;
          }
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label374;
          localFile = new File(AvatarPendantUtil.c + "/rare.png");
          if (localFile.exists())
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject3 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_rare.png");
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
              localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
              localObject2 = localObject3;
              if (((URLDrawable)localObject3).getStatus() == 1)
              {
                jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_rare.png", localObject3);
                localObject2 = localObject3;
              }
            }
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            break label374;
          }
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label374;
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847818));
          break label374;
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847817));
          break label374;
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          break label511;
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          break label511;
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131717219);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850183);
          break label643;
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          break label643;
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          continue;
          if (i1 != 2) {
            break label2517;
          }
          localObject2 = (List)getItem(paramInt);
          ((AvatarPendantAdapter.FaceGridAdapter)((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.getAdapter()).a((List)localObject2);
          if (((List)localObject2).size() == 8)
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700945));
          }
          else
          {
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
      } while (i1 != 4);
      label2517:
      localObject2 = (List)getItem(paramInt);
      ((CmshowFaceGridAdapter)((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.getAdapter()).a((List)localObject2);
      if (((List)localObject2).size() == 4)
      {
        ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        boolean bool = false;
        if ((this.jdField_a_of_type_AndroidContentContext instanceof AvatarPendantActivity)) {
          bool = ((AvatarPendantActivity)this.jdField_a_of_type_AndroidContentContext).c();
        }
        if (bool) {
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700945));
        }
      }
      for (;;)
      {
        localObject2 = paramView.findViewById(2131364906);
        int i2 = 0;
        i1 = i2;
        if (!QzoneLiveVideoInterface.getSharedPreferences("facechoosedata", 0).getBoolean("cmshow_avatar_used", false))
        {
          i1 = i2;
          if (QzoneLiveVideoInterface.getSharedPreferences("facechoosedata", 0).getInt("cmshow_avatar_exposure_cout", 0) < 3) {
            i1 = 1;
          }
        }
        if (i1 != 0)
        {
          ((View)localObject2).setVisibility(0);
          i1 = AIOUtils.a(12, this.jdField_a_of_type_AndroidContentContext.getResources());
          i2 = AIOUtils.a(6, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setPadding(i1, i2, 0, 0);
        }
        i1 = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        ApolloDtReportUtil.a("avatarQQPage", "cmshowavatar", "expose", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).f(i1).a());
        break;
        ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131690131));
        continue;
        ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AvatarPendantAdapter
 * JD-Core Version:    0.7.0.1
 */