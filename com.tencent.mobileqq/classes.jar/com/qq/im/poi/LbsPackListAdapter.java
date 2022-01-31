package com.qq.im.poi;

import amx;
import amy;
import amz;
import ana;
import anb;
import anc;
import and;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ane;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader;
import com.tencent.mobileqq.armap.NonMainAppHeadLoader.FaceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.LbsPackHorizontalListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LbsPackListAdapter
  extends BaseAdapter
{
  public static long a;
  public static String a;
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private LbsPackListAdapter.LbsPackItemCallback jdField_a_of_type_ComQqImPoiLbsPackListAdapter$LbsPackItemCallback;
  LbsPackManager jdField_a_of_type_ComQqImPoiLbsPackManager;
  ArMapInterface jdField_a_of_type_ComTencentMobileqqArmapArMapInterface;
  NonMainAppHeadLoader.FaceObserver jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver = new ane(this);
  private LbsPackHorizontalListView jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView;
  public List a;
  boolean jdField_a_of_type_Boolean = true;
  public int b;
  boolean b;
  public int c;
  boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "LbsPack";
    jdField_a_of_type_Long = -2L;
  }
  
  public LbsPackListAdapter(ArMapInterface paramArMapInterface, Context paramContext, LbsPackHorizontalListView paramLbsPackHorizontalListView, RelativeLayout paramRelativeLayout, int paramInt1, int paramInt2, int paramInt3, LbsPackListAdapter.LbsPackItemCallback paramLbsPackItemCallback)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = paramArMapInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetLbsPackHorizontalListView = paramLbsPackHorizontalListView;
    this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter$LbsPackItemCallback = paramLbsPackItemCallback;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.a.a(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.a.b(this.jdField_a_of_type_ComTencentMobileqqArmapNonMainAppHeadLoader$FaceObserver);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    ana localana = new ana(this, paramInt1, paramView.getMeasuredWidth(), paramView);
    anb localanb = new anb(this, paramInt2);
    if (localanb != null) {
      localana.setAnimationListener(localanb);
    }
    localana.setDuration(300L);
    paramView.startAnimation(localana);
  }
  
  public void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "removeItem " + paramInt);
    }
    LbsPackListAdapter.LbsPackListAdpterHolder localLbsPackListAdpterHolder = (LbsPackListAdapter.LbsPackListAdpterHolder)paramView2.getTag();
    if (localLbsPackListAdpterHolder != null) {
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    paramView1 = new anc(this, paramView3, paramInt, paramView1);
    paramView3 = new and(this, paramView2, paramView2.getMeasuredHeight() / 2);
    if (paramView1 != null) {
      paramView3.setAnimationListener(paramView1);
    }
    paramView3.setDuration(800L);
    paramView3.setStartOffset(400L);
    paramView3.setInterpolator(this.jdField_a_of_type_AndroidContentContext, 2131099649);
    paramView2.startAnimation(paramView3);
  }
  
  public void a(List paramList, LbsPackManager paramLbsPackManager)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_ComQqImPoiLbsPackManager = paramLbsPackManager;
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        LbsPackInfo localLbsPackInfo = (LbsPackInfo)localIterator.next();
        if (TextUtils.isEmpty(localLbsPackInfo.c))
        {
          String str1 = localLbsPackInfo.jdField_a_of_type_Long + "";
          String str2 = paramLbsPackManager.b(str1);
          if (TextUtils.isEmpty(str2)) {
            localArrayList.add(str1);
          } else {
            localLbsPackInfo.c = str2;
          }
        }
      }
      paramLbsPackManager.a(localArrayList);
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      paramList = new LbsPackInfo();
      paramList.b = jdField_a_of_type_Long;
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    paramList = paramLbsPackManager.a;
    if (paramList != null)
    {
      if ((paramList.packShow & 0x4) <= 0) {
        break label308;
      }
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if ((paramList.packShow & 0x2) <= 0) {
        break label313;
      }
      bool1 = true;
      label221:
      this.jdField_b_of_type_Boolean = bool1;
      if ((paramList.packShow & 0x1) <= 0) {
        break label318;
      }
    }
    label308:
    label313:
    label318:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_c_of_type_Boolean = bool1;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "config poi:" + this.jdField_a_of_type_Boolean + " ava:" + this.jdField_b_of_type_Boolean + " nic:" + this.jdField_c_of_type_Boolean);
      }
      notifyDataSetChanged();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label221;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LbsPackInfo localLbsPackInfo = (LbsPackInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localLbsPackInfo == null) {
      return null;
    }
    if (localLbsPackInfo.b == jdField_a_of_type_Long) {
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    LbsPackListAdapter.LbsPackListAdpterHolder localLbsPackListAdpterHolder;
    if ((paramView == null) || (!(paramView instanceof LbsPackItemView)))
    {
      localLbsPackListAdpterHolder = new LbsPackListAdapter.LbsPackListAdpterHolder();
      paramViewGroup = new LbsPackItemView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.a(paramInt, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, localLbsPackListAdpterHolder);
      paramViewGroup.setTag(localLbsPackListAdpterHolder);
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      ((LbsPackItemView)paramViewGroup).a(paramInt, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (!this.jdField_b_of_type_Boolean) {
        break label784;
      }
      localLbsPackListAdpterHolder.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130839274);
      localLbsPackListAdpterHolder.jdField_b_of_type_ComTencentImageURLImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.a.a(localLbsPackInfo.jdField_a_of_type_Long + "", true));
      localLbsPackListAdpterHolder.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localLbsPackListAdpterHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      localLbsPackListAdpterHolder.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label214:
      if (!this.jdField_c_of_type_Boolean) {
        break label805;
      }
      if (this.jdField_a_of_type_ComQqImPoiLbsPackManager != null)
      {
        String str = localLbsPackInfo.c;
        paramView = str;
        if (TextUtils.isEmpty(str))
        {
          str = this.jdField_a_of_type_ComQqImPoiLbsPackManager.b(localLbsPackInfo.jdField_a_of_type_Long + "");
          paramView = str;
          if (TextUtils.isEmpty(str)) {
            paramView = localLbsPackInfo.jdField_a_of_type_Long + "";
          }
        }
        localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      }
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(20.0F);
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-863840);
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int - this.jdField_a_of_type_Int - 80);
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      label398:
      if (!this.jdField_a_of_type_Boolean) {
        break label817;
      }
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839275), null, null, null);
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localLbsPackInfo.d);
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetTextView.setTextSize(12.0F);
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-2063772);
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int - this.jdField_a_of_type_Int - 80);
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      label530:
      if (localLbsPackInfo.jdField_a_of_type_Int != 0) {
        break label829;
      }
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetButton.setText("猜红包");
      label549:
      paramView = this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getCurrentAccountUin();
      if (!String.valueOf(localLbsPackInfo.jdField_a_of_type_Long).equals(paramView)) {
        break label843;
      }
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "my uin, show share " + paramView);
      }
    }
    for (;;)
    {
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839272);
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetButton.setTextSize(17.0F);
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(-3985334);
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new amx(this, localLbsPackInfo, paramInt));
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839278);
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetButton.setTextSize(17.0F);
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetButton.setText("分享");
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetButton.setTextColor(-863840);
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new amy(this, localLbsPackInfo, paramInt));
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839261);
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new amz(this, paramInt, localLbsPackInfo));
      return paramViewGroup;
      localLbsPackListAdpterHolder = (LbsPackListAdapter.LbsPackListAdpterHolder)paramView.getTag();
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      paramViewGroup = paramView;
      break;
      label784:
      localLbsPackListAdpterHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
      localLbsPackListAdpterHolder.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(4);
      break label214;
      label805:
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      break label398;
      label817:
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      break label530;
      label829:
      localLbsPackListAdpterHolder.jdField_a_of_type_AndroidWidgetButton.setText("查看");
      break label549;
      label843:
      localLbsPackListAdpterHolder.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackListAdapter
 * JD-Core Version:    0.7.0.1
 */