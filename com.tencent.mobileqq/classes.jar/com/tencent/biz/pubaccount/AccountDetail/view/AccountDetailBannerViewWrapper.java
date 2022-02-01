package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;

public class AccountDetailBannerViewWrapper
  extends AccountDetailCustomModuleBaseWrapper
{
  public AccountDetailBannerViewWrapper(Context paramContext, ArrayList<IPublicAccountConfigAttr.PaConfigInfo> paramArrayList, AccountDetailBaseItemClickHandler paramAccountDetailBaseItemClickHandler, String paramString1, String paramString2)
  {
    super(paramContext, paramArrayList, paramAccountDetailBaseItemClickHandler, paramString1, paramString2);
  }
  
  public static View a(Context paramContext, View paramView, ViewGroup paramViewGroup, PublicAccountConfigAttrImpl paramPublicAccountConfigAttrImpl, int paramInt, AccountDetailBaseItemClickHandler paramAccountDetailBaseItemClickHandler, String paramString1, String paramString2)
  {
    paramViewGroup = a(paramPublicAccountConfigAttrImpl, paramInt);
    if (paramViewGroup.isEmpty())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AccountDetailBannerViewWrapper", 2, "createView return convertView!");
      }
      return paramView;
    }
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramView = (RelativeLayout)paramView;
      paramPublicAccountConfigAttrImpl = paramView.getTag();
      if ((paramPublicAccountConfigAttrImpl != null) && ((paramPublicAccountConfigAttrImpl instanceof AccountDetailBannerViewWrapper)) && (((AccountDetailBannerViewWrapper)paramPublicAccountConfigAttrImpl).a(paramViewGroup)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AccountDetailBannerViewWrapper", 2, "createView reuse!");
        }
        return paramView;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountDetailBannerViewWrapper", 2, "createView new create!");
    }
    paramContext = new AccountDetailBannerViewWrapper(paramContext, paramViewGroup, paramAccountDetailBaseItemClickHandler, paramString1, paramString2);
    paramView = paramContext.a();
    paramView.setTag(paramContext);
    return paramView;
  }
  
  private View a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    localURLImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localURLImageView.setBackgroundDrawable(URLDrawable.getDrawable(paramPaConfigInfo.e, null, null, true));
    localURLImageView.setImageDrawable(new ColorDrawable(Color.parseColor("#33000000")));
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localRelativeLayout.addView(localURLImageView);
    localRelativeLayout.setTag(paramPaConfigInfo);
    localRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return localRelativeLayout;
  }
  
  private RelativeLayout a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBannerViewWrapper", 2, "buildView!");
    }
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = AIOUtils.b(160.0F, localResources);
    int j = AIOUtils.b(20.0F, localResources);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, i + j));
    localRelativeLayout.setPadding(0, j, 0, 0);
    AccountDetailBannerViewPager localAccountDetailBannerViewPager = new AccountDetailBannerViewPager(this.jdField_a_of_type_AndroidContentContext);
    localAccountDetailBannerViewPager.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localRelativeLayout.addView(localAccountDetailBannerViewPager);
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(a((IPublicAccountConfigAttr.PaConfigInfo)((Iterator)localObject).next()));
    }
    localObject = new AccountDetailBannerViewWrapper.ViewPagerAdapter();
    ((AccountDetailBannerViewWrapper.ViewPagerAdapter)localObject).a(localArrayList);
    localAccountDetailBannerViewPager.setAdapter((PagerAdapter)localObject);
    localObject = new AccountDetailBannerIndicator(this.jdField_a_of_type_AndroidContentContext, localArrayList.size());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, AIOUtils.b(10.0F, localResources));
    ((AccountDetailBannerIndicator)localObject).setLayoutParams(localLayoutParams);
    localRelativeLayout.addView((View)localObject);
    localAccountDetailBannerViewPager.setIndicator((AccountDetailBannerIndicator)localObject);
    localAccountDetailBannerViewPager.setCurrentItem(1073741823 - 1073741823 % localArrayList.size());
    localRelativeLayout.setClickable(false);
    localRelativeLayout.setOnClickListener(null);
    return localRelativeLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailBannerViewWrapper
 * JD-Core Version:    0.7.0.1
 */