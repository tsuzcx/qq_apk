package com.tencent.mobileqq.adapter;

import android.content.Context;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.pendant.PendantMarketConfig;
import com.tencent.mobileqq.activity.pendant.PendantMarketConfig.EntryConfig;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantShopSeriesInfo;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import ydk;
import ydl;

public class AvatarPendantAdapter
  extends BaseAdapter
{
  static LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(15);
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public QQAppInterface a;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList;
  public boolean a;
  final int b;
  final int c = 1;
  final int d = 2;
  int e;
  int f;
  int g;
  int h;
  int i = 4;
  int j;
  int k;
  
  public AvatarPendantAdapter(Context paramContext, View.OnClickListener paramOnClickListener, AdapterView.OnItemClickListener paramOnItemClickListener, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.e = paramInt2;
    this.h = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    this.f = ((this.jdField_a_of_type_Int - this.h * (this.i + 1)) / this.i);
    this.g = (this.f * 176 / 150);
    this.j = (this.f - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.k = (this.g - DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_JavaLangString);
    if (paramList != null) {
      this.jdField_a_of_type_Long = paramList.pendantId;
    }
    super.notifyDataSetChanged();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if ((PendantMarketConfig.jdField_a_of_type_JavaUtilList != null) && (!PendantMarketConfig.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int m = 0;
      if (m < PendantMarketConfig.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject1 = (PendantMarketConfig.EntryConfig)PendantMarketConfig.jdField_a_of_type_JavaUtilList.get(m);
        View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970887, null);
        Object localObject2 = (ImageView)localView.findViewById(2131372103);
        TextView localTextView1 = (TextView)localView.findViewById(2131372105);
        TextView localTextView2 = (TextView)localView.findViewById(2131372107);
        ImageView localImageView = (ImageView)localView.findViewById(2131372106);
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
          localView.setOnClickListener(new ydk(this, (PendantMarketConfig.EntryConfig)localObject1, m));
          localView.addOnLayoutChangeListener(new ydl(this));
          if (m != 0) {
            localView.findViewById(2131372102).setVisibility(0);
          }
          localObject1 = new LinearLayout.LayoutParams(0, AIOUtils.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          m += 1;
          break;
          localImageView.setImageResource(2130843017);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130843025);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130838117);
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
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int n = 1;
    Object localObject1 = paramView;
    if (paramInt < getCount())
    {
      if (paramInt < 0) {
        localObject1 = paramView;
      }
    }
    else {
      return localObject1;
    }
    int m = getItemViewType(paramInt);
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new AvatarPendantAdapter.ViewHolder(this);
      if (m == 0)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970889, paramViewGroup, false);
        paramViewGroup = paramView.findViewById(2131372119);
        localObject2 = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.e;
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372120));
        this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372121);
        b();
        paramView.setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      localObject1 = paramView;
      if (m != 1) {
        break;
      }
      AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo = (AvatarPendantShopSeriesInfo)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetGridView.setTag(localAvatarPendantShopSeriesInfo);
      if (localAvatarPendantShopSeriesInfo.c != null)
      {
        if (localAvatarPendantShopSeriesInfo.c.equals("1"))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844097));
        }
      }
      else
      {
        label219:
        if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString != null)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_b_of_type_Int));
        switch (localAvatarPendantShopSeriesInfo.jdField_b_of_type_Int)
        {
        default: 
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          label321:
          if ((localAvatarPendantShopSeriesInfo.e != null) && (localAvatarPendantShopSeriesInfo.e.equals("actLiTpl")))
          {
            if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString == null) {
              break label1556;
            }
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaLangString);
            paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          break;
        }
      }
      label1543:
      label1556:
      for (m = 1;; m = 0)
      {
        if (localAvatarPendantShopSeriesInfo.jdField_b_of_type_JavaLangString != null)
        {
          paramViewGroup.d.setText(localAvatarPendantShopSeriesInfo.jdField_b_of_type_JavaLangString);
          paramViewGroup.d.setVisibility(0);
          m = n;
        }
        for (;;)
        {
          if (m != 0)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            label448:
            ((AvatarPendantAdapter.PendantGridAdapter)paramViewGroup.jdField_a_of_type_ComTencentWidgetGridView.a()).a(localAvatarPendantShopSeriesInfo);
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_a_of_type_Int));
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localAvatarPendantShopSeriesInfo.jdField_a_of_type_Int));
            if ((localAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.size() <= 4) || ((localAvatarPendantShopSeriesInfo.e != null) && (!localAvatarPendantShopSeriesInfo.e.equals("")))) {
              break label1522;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean) {
              break label1499;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131436734);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845460);
          }
          for (;;)
          {
            if (paramInt != getCount() - 1) {
              break label1543;
            }
            paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
            return paramView;
            if (m != 1) {
              break label1562;
            }
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970888, paramViewGroup, false);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372109));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372110));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372111));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372112));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131372116));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372117));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372118));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372113));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372114));
            ((AvatarPendantAdapter.ViewHolder)localObject1).d = ((TextView)paramView.findViewById(2131372115));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363937);
            paramViewGroup = new AvatarPendantAdapter.PendantGridAdapter(this);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(paramViewGroup);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.i);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.f);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.h);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.h);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((AvatarPendantAdapter.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramView.setTag(localObject1);
            paramViewGroup = (ViewGroup)localObject1;
            break;
            paramViewGroup = (AvatarPendantAdapter.ViewHolder)paramView.getTag();
            break;
            if (localAvatarPendantShopSeriesInfo.c.equals("3"))
            {
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844096));
              break label219;
            }
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label219;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843025));
            break label321;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843017));
            break label321;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844098));
            break label321;
            File localFile = new File(AvatarPendantUtil.c + "/free.png");
            if (localFile.exists())
            {
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              localObject2 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_free.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_free.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              break label321;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label321;
            localFile = new File(AvatarPendantUtil.c + "/rare.png");
            if (localFile.exists())
            {
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              localObject2 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_rare.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_rare.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              break label321;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label321;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844102));
            break label321;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844101));
            break label321;
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label448;
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label448;
            label1499:
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131436892);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845462);
            continue;
            label1522:
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          return paramView;
        }
      }
      label1562:
      paramViewGroup = (ViewGroup)localObject1;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AvatarPendantAdapter
 * JD-Core Version:    0.7.0.1
 */