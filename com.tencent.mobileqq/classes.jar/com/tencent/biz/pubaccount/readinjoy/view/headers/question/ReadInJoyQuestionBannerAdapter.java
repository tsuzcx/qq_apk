package com.tencent.biz.pubaccount.readinjoy.view.headers.question;

import aciy;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import obj;
import obz;
import pro;
import prq;
import prs;
import qcn;
import rcj;
import rck;
import rif;
import rih;
import rsl;
import vms;

public class ReadInJoyQuestionBannerAdapter
  extends PagerAdapter
  implements rif, rih
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private TopBannerInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo;
  private String jdField_a_of_type_JavaLangString = "ReadInJoyQuestionBannerAdapter";
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private rck jdField_a_of_type_Rck;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  
  public ReadInJoyQuestionBannerAdapter(Context paramContext, RollViewPager paramRollViewPager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramRollViewPager.setOnUserFling(this);
  }
  
  private View a(Context paramContext, pro parampro)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131494199, null);
    KanDianUrlRoundCornerImageView localKanDianUrlRoundCornerImageView = (KanDianUrlRoundCornerImageView)localView.findViewById(2131302786);
    localKanDianUrlRoundCornerImageView.setCorner(vms.a(paramContext, 3.0F));
    obj.a(localKanDianUrlRoundCornerImageView, rsl.a(a(parampro.c), 3), this.jdField_a_of_type_AndroidContentContext);
    localView.setTag(parampro);
    return localView;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.items.size();
  }
  
  public int a(int paramInt)
  {
    int j = 0;
    int k = a();
    int i = j;
    if (k > 1)
    {
      if (paramInt != 0) {
        break label27;
      }
      i = k - 1;
    }
    label27:
    do
    {
      return i;
      i = j;
    } while (paramInt == k + 1);
    return paramInt - 1;
  }
  
  public String a(String paramString)
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    return obz.a(paramString, localResources.getDisplayMetrics().widthPixels - aciy.a(24.0F, localResources), aciy.a(58.0F, localResources));
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    pro localpro = (pro)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.items.get(paramInt);
    Object localObject;
    switch (localpro.a)
    {
    default: 
      localObject = (prq)localpro;
      obz.a(this.jdField_a_of_type_AndroidContentContext, ((prq)localObject).f);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Rck != null) {
        this.jdField_a_of_type_Rck.b(localpro);
      }
      return;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        localObject = (prs)localpro;
        qcn.a((Activity)this.jdField_a_of_type_AndroidContentContext, null, 19, ((prs)localObject).jdField_e_of_type_JavaLangString, ((prs)localObject).jdField_e_of_type_Int, ((prs)localObject).jdField_g_of_type_JavaLangString, ((prs)localObject).jdField_c_of_type_Int, ((prs)localObject).d, ((prs)localObject).jdField_b_of_type_Int, ((prs)localObject).i, "", ((prs)localObject).f, ((prs)localObject).h, "" + ((prs)localObject).jdField_b_of_type_Long, 0L, ((prs)localObject).a(), ((prs)localObject).jdField_c_of_type_Long, ((prs)localObject).jdField_g_of_type_Int, null, null, null, null, null);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt)))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramInt));
      pro localpro = (pro)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.items.get(paramInt);
      if (this.jdField_a_of_type_Rck != null) {
        this.jdField_a_of_type_Rck.a(localpro);
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    if (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
      this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] = null;
    }
  }
  
  public int getCount()
  {
    int i = a();
    if (i <= 1) {
      return i;
    }
    return i + 2;
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (pro)((View)paramObject).getTag();
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.items.indexOf(paramObject);
    if (i >= 0) {
      return i;
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = null;
    int i = a();
    Object localObject;
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (i == 0))
    {
      localObject = localView;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "instantiateItem activity is null or data list count is 0");
        localObject = localView;
      }
    }
    do
    {
      return localObject;
      if ((i > 1) && ((paramInt == 1) || (paramInt == i))) {
        if (paramViewGroup == null)
        {
          if (this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] != null) {
            return this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] == null) || (this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt].getParent() != null)) {
            this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] = ((View)instantiateItem(null, paramInt));
          }
          paramViewGroup.addView(this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt]);
          return this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];
        }
      }
      i = a(paramInt);
      localObject = (pro)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.items.get(i);
      localView = a(this.jdField_a_of_type_AndroidContentContext, (pro)localObject);
      this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] = localView;
      localView.setOnClickListener(new rcj(this, i));
      localObject = localView;
    } while (paramViewGroup == null);
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.question.ReadInJoyQuestionBannerAdapter
 * JD-Core Version:    0.7.0.1
 */