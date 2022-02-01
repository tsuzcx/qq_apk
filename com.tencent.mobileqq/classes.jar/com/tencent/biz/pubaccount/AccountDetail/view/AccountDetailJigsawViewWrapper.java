package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AccountDetailJigsawViewWrapper
  extends AccountDetailCustomModuleBaseWrapper
{
  public AccountDetailJigsawViewWrapper(Context paramContext, ArrayList<IPublicAccountConfigAttr.PaConfigInfo> paramArrayList, AccountDetailBaseItemClickHandler paramAccountDetailBaseItemClickHandler, String paramString1, String paramString2)
  {
    super(paramContext, paramArrayList, paramAccountDetailBaseItemClickHandler, paramString1, paramString2);
  }
  
  public static View a(Context paramContext, View paramView, ViewGroup paramViewGroup, PublicAccountConfigAttrImpl paramPublicAccountConfigAttrImpl, int paramInt, AccountDetailBaseItemClickHandler paramAccountDetailBaseItemClickHandler, String paramString1, String paramString2)
  {
    paramPublicAccountConfigAttrImpl = a(paramPublicAccountConfigAttrImpl, paramInt);
    if (paramPublicAccountConfigAttrImpl.size() % 2 != 0)
    {
      paramPublicAccountConfigAttrImpl.remove(paramPublicAccountConfigAttrImpl.size() - 1);
      if (QLog.isDevelopLevel()) {
        QLog.d("AccountDetailJigsawViewWrapper", 2, "createView remove last data!");
      }
    }
    if (paramPublicAccountConfigAttrImpl.isEmpty())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AccountDetailJigsawViewWrapper", 2, "createView return convertView!");
      }
      return paramView;
    }
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
    }
    else
    {
      paramView = new LinearLayout(paramContext);
      paramView.setOrientation(1);
      paramView.setPadding(0, AIOUtils.b(20.0F, paramViewGroup.getResources()), 0, 0);
    }
    paramViewGroup = paramView.getTag();
    if ((paramViewGroup != null) && ((paramViewGroup instanceof AccountDetailJigsawViewWrapper)) && (((AccountDetailJigsawViewWrapper)paramViewGroup).a(paramPublicAccountConfigAttrImpl)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AccountDetailJigsawViewWrapper", 2, "createView reuse!");
      }
      return paramView;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountDetailJigsawViewWrapper", 2, "createView new create!");
    }
    paramContext = new AccountDetailJigsawViewWrapper(paramContext, paramPublicAccountConfigAttrImpl, paramAccountDetailBaseItemClickHandler, paramString1, paramString2);
    paramContext.a(paramView);
    paramView.setTag(paramContext);
    return paramView;
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailJigsawViewWrapper", 2, "buildView!");
    }
    paramLinearLayout.removeAllViews();
    paramLinearLayout.setClickable(false);
    paramLinearLayout.setOnClickListener(null);
    Context localContext = paramLinearLayout.getContext();
    Object localObject1 = localContext.getResources();
    int m = AIOUtils.b(2.0F, (Resources)localObject1);
    int n = (((Resources)localObject1).getDisplayMetrics().widthPixels - m) / 2;
    int i1 = AIOUtils.b(125.0F, (Resources)localObject1);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      int j;
      if (i % 2 == 0) {
        j = 1;
      } else {
        j = 0;
      }
      int i2 = i / 2;
      int k;
      if (i2 == 0) {
        k = 1;
      } else {
        k = 0;
      }
      if (j != 0)
      {
        localObject1 = new LinearLayout(localContext);
        ((LinearLayout)localObject1).setOrientation(0);
        localObject2 = new LinearLayout.LayoutParams(-1, i1);
        if (k == 0) {
          ((LinearLayout.LayoutParams)localObject2).setMargins(0, m, 0, 0);
        }
        ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramLinearLayout.addView((View)localObject1);
      }
      else
      {
        localObject1 = (LinearLayout)paramLinearLayout.getChildAt(i2);
      }
      Object localObject2 = (IPublicAccountConfigAttr.PaConfigInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      RelativeLayout localRelativeLayout = new RelativeLayout(localContext);
      Object localObject3 = new LinearLayout.LayoutParams(n, i1);
      if (j == 0) {
        ((LinearLayout.LayoutParams)localObject3).setMargins(m, 0, 0, 0);
      }
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localRelativeLayout.setTag(localObject2);
      localRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((LinearLayout)localObject1).addView(localRelativeLayout);
      localObject1 = new URLImageView(localContext);
      ((URLImageView)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      ((URLImageView)localObject1).setBackgroundDrawable(URLDrawable.getDrawable(((IPublicAccountConfigAttr.PaConfigInfo)localObject2).e, null, null, true));
      ((URLImageView)localObject1).setImageDrawable(new ColorDrawable(Color.parseColor("#33000000")));
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      localRelativeLayout.addView((View)localObject1);
      localObject1 = new TextView(localContext);
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setText(((IPublicAccountConfigAttr.PaConfigInfo)localObject2).a);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 16.0F);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      localRelativeLayout.addView((View)localObject1);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailJigsawViewWrapper
 * JD-Core Version:    0.7.0.1
 */