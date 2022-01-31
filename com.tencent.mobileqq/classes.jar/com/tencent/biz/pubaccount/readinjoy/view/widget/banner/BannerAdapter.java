package com.tencent.biz.pubaccount.readinjoy.view.widget.banner;

import aciy;
import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import anud;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import obj;
import obz;
import pro;
import prq;
import prs;
import qcn;
import rhz;
import ria;
import rif;
import rih;
import rsl;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import vms;
import yof;

public class BannerAdapter
  extends PagerAdapter
  implements rif, rih
{
  public static int a;
  public static int b;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private TopBannerInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo;
  private String jdField_a_of_type_JavaLangString = "BannerAdapter";
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private int c;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public BannerAdapter(Activity paramActivity, RollViewPager paramRollViewPager, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramRollViewPager.setOnUserFling(this);
    this.jdField_c_of_type_Int = paramInt;
  }
  
  private View a(Activity paramActivity, pro parampro, View paramView)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramActivity).inflate(2131494202, null);
    }
    paramView = (KanDianUrlRoundCornerImageView)localView.findViewById(2131302786);
    int i = vms.a(paramActivity, 3.0F);
    paramView.setCorner(i);
    TextView localTextView1 = (TextView)localView.findViewById(2131312543);
    TextView localTextView2 = (TextView)localView.findViewById(2131312553);
    localTextView2.setText(parampro.d);
    if (TextUtils.isEmpty(parampro.d))
    {
      localTextView2.setVisibility(8);
      if ((!TextUtils.isEmpty(parampro.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parampro.jdField_a_of_type_JavaLangString)))
      {
        localTextView1.setText(parampro.jdField_b_of_type_JavaLangString);
        localTextView1.setBackgroundDrawable(anud.a(Utils.parseColor(parampro.jdField_a_of_type_JavaLangString), i, 0.0F, i, 0.0F));
      }
      if (this.jdField_c_of_type_Int != jdField_b_of_type_Int) {
        break label198;
      }
    }
    for (;;)
    {
      try
      {
        obj.a(paramView, new URL(parampro.c), paramActivity);
        localView.setTag(parampro);
        return localView;
        localTextView2.setVisibility(0);
      }
      catch (MalformedURLException paramActivity)
      {
        paramActivity.printStackTrace();
        continue;
      }
      label198:
      obj.a(paramView, rsl.a(a(parampro.c), 3), paramActivity);
    }
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
  
  public View a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
      return this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];
    }
    return null;
  }
  
  public String a(String paramString)
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = localResources.getDisplayMetrics().widthPixels - aciy.a(30.0F, localResources);
    return obz.a(paramString, i, (int)(i * 0.424242D));
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Int == jdField_a_of_type_Int) {
      ria.a("0X8009555", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.mChannelId, a(), false);
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onItemClick : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.items.get(paramInt));
    pro localpro = (pro)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.items.get(paramInt);
    Object localObject;
    switch (localpro.jdField_a_of_type_Int)
    {
    default: 
      localObject = (prq)localpro;
      obz.a(this.jdField_a_of_type_AndroidAppActivity, ((prq)localObject).f);
      if (this.jdField_c_of_type_Int == jdField_a_of_type_Int) {
        ria.a("0X8009556", paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.mChannelId, a(), localpro);
      }
      break;
    }
    for (;;)
    {
      if ((localpro.jdField_a_of_type_Boolean) && (localpro.jdField_a_of_type_JavaUtilList != null) && (localpro.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.trace_info.aid.set(localpro.jdField_a_of_type_Long);
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.thirdparty_monitor_urls.api_click_monitor_url.set(localpro.a(localpro.jdField_a_of_type_JavaUtilList));
        yof.a(1, 1, (qq_ad_get.QQAdGetRsp.AdInfo)localObject);
      }
      return;
      localObject = (prs)localpro;
      qcn.a(this.jdField_a_of_type_AndroidAppActivity, null, 19, ((prs)localObject).jdField_e_of_type_JavaLangString, ((prs)localObject).jdField_e_of_type_Int, ((prs)localObject).jdField_g_of_type_JavaLangString, ((prs)localObject).jdField_c_of_type_Int, ((prs)localObject).d, ((prs)localObject).jdField_b_of_type_Int, ((prs)localObject).i, "", ((prs)localObject).f, ((prs)localObject).h, "" + ((prs)localObject).jdField_b_of_type_Long, 0L, ((prs)localObject).a(), ((prs)localObject).jdField_c_of_type_Long, ((prs)localObject).jdField_g_of_type_Int, null, null, null, null, null);
      break;
      if (this.jdField_c_of_type_Int == jdField_b_of_type_Int) {
        ria.a("0X8009B91", a(), localpro);
      }
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo == paramTopBannerInfo) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo = paramTopBannerInfo;
    if (this.jdField_c_of_type_Int == jdField_a_of_type_Int)
    {
      paramTopBannerInfo = paramTopBannerInfo.items.iterator();
      do
      {
        if (!paramTopBannerInfo.hasNext()) {
          break;
        }
      } while (!((pro)paramTopBannerInfo.next()).jdField_a_of_type_Boolean);
    }
    for (boolean bool = true;; bool = false)
    {
      ria.a("0X8009553", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.mChannelId, a(), bool);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[getCount()];
      c();
      notifyDataSetChanged();
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null) {}
    label61:
    for (;;)
    {
      return;
      View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
      int j = arrayOfView.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label61;
        }
        View localView = arrayOfView[i];
        if (localView == null) {
          break;
        }
        pro localpro = (pro)localView.getTag();
        a(this.jdField_a_of_type_AndroidAppActivity, localpro, localView);
        i += 1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    pro localpro;
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramInt)))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramInt));
      localpro = (pro)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.items.get(paramInt);
      if (this.jdField_c_of_type_Int != jdField_a_of_type_Int) {
        break label151;
      }
      ria.a("0X8009554", paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopBannerInfo.mChannelId, a(), localpro);
    }
    for (;;)
    {
      if ((localpro.jdField_a_of_type_Boolean) && (localpro.jdField_b_of_type_JavaUtilList != null) && (localpro.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
        localAdInfo.report_info.trace_info.aid.set(localpro.jdField_a_of_type_Long);
        localAdInfo.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(localpro.a(localpro.jdField_b_of_type_JavaUtilList));
        yof.a(0, 1, localAdInfo);
      }
      return;
      label151:
      if (this.jdField_c_of_type_Int == jdField_b_of_type_Int) {
        ria.a("0X8009B90", a(), localpro);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "destroyItem position : " + paramInt + " object: " + paramObject);
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
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "instantiateItem " + paramViewGroup + "  " + paramInt);
    int i = a();
    Object localObject;
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (i == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "instantiateItem activity is null or data list count is 0");
      }
      localObject = null;
    }
    View localView;
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
      localView = a(this.jdField_a_of_type_AndroidAppActivity, (pro)localObject, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] = localView;
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "childs " + paramInt);
      localView.setOnClickListener(new rhz(this, i));
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.banner.BannerAdapter
 * JD-Core Version:    0.7.0.1
 */