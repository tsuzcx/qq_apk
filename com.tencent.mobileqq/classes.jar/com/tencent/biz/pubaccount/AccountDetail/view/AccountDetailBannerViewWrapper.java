package com.tencent.biz.pubaccount.AccountDetail.view;

import afur;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import nql;
import nrb;
import nyk;
import nyl;

public class AccountDetailBannerViewWrapper
  extends nrb
{
  public AccountDetailBannerViewWrapper(Context paramContext, ArrayList<nyl> paramArrayList, nql paramnql, String paramString1, String paramString2)
  {
    super(paramContext, paramArrayList, paramnql, paramString1, paramString2);
  }
  
  public static View a(Context paramContext, View paramView, ViewGroup paramViewGroup, nyk paramnyk, int paramInt, nql paramnql, String paramString1, String paramString2)
  {
    paramViewGroup = a(paramnyk, paramInt);
    if (paramViewGroup.isEmpty())
    {
      paramContext = paramView;
      if (QLog.isDevelopLevel())
      {
        QLog.d("AccountDetailBannerViewWrapper", 2, "createView return convertView!");
        paramContext = paramView;
      }
    }
    do
    {
      return paramContext;
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break;
      }
      paramView = (RelativeLayout)paramView;
      paramnyk = paramView.getTag();
      if ((paramnyk == null) || (!(paramnyk instanceof AccountDetailBannerViewWrapper)) || (!((AccountDetailBannerViewWrapper)paramnyk).a(paramViewGroup))) {
        break;
      }
      paramContext = paramView;
    } while (!QLog.isDevelopLevel());
    QLog.d("AccountDetailBannerViewWrapper", 2, "createView reuse!");
    return paramView;
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountDetailBannerViewWrapper", 2, "createView new create!");
    }
    paramContext = new AccountDetailBannerViewWrapper(paramContext, paramViewGroup, paramnql, paramString1, paramString2);
    paramView = paramContext.a();
    paramView.setTag(paramContext);
    return paramView;
  }
  
  private View a(nyl paramnyl)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    URLImageView localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    localURLImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localURLImageView.setBackgroundDrawable(URLDrawable.getDrawable(paramnyl.e, null, null, true));
    localURLImageView.setImageDrawable(new ColorDrawable(Color.parseColor("#33000000")));
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localRelativeLayout.addView(localURLImageView);
    localRelativeLayout.setTag(paramnyl);
    localRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return localRelativeLayout;
  }
  
  private RelativeLayout a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBannerViewWrapper", 2, "buildView!");
    }
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = afur.a(160.0F, localResources);
    int j = afur.a(20.0F, localResources);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, i + j));
    localRelativeLayout.setPadding(0, j, 0, 0);
    AccountDetailBannerViewPager localAccountDetailBannerViewPager = new AccountDetailBannerViewPager(this.jdField_a_of_type_AndroidContentContext);
    localAccountDetailBannerViewPager.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localRelativeLayout.addView(localAccountDetailBannerViewPager);
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(a((nyl)((Iterator)localObject).next()));
    }
    localObject = new AccountDetailBannerViewWrapper.ViewPagerAdapter();
    ((AccountDetailBannerViewWrapper.ViewPagerAdapter)localObject).a(localArrayList);
    localAccountDetailBannerViewPager.setAdapter((PagerAdapter)localObject);
    localObject = new AccountDetailBannerIndicator(this.jdField_a_of_type_AndroidContentContext, localArrayList.size());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, afur.a(10.0F, localResources));
    ((AccountDetailBannerIndicator)localObject).setLayoutParams(localLayoutParams);
    localRelativeLayout.addView((View)localObject);
    localAccountDetailBannerViewPager.setIndicator((AccountDetailBannerIndicator)localObject);
    localAccountDetailBannerViewPager.setCurrentItem(1073741823 - 1073741823 % localArrayList.size());
    localRelativeLayout.setClickable(false);
    localRelativeLayout.setOnClickListener(null);
    return localRelativeLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailBannerViewWrapper
 * JD-Core Version:    0.7.0.1
 */