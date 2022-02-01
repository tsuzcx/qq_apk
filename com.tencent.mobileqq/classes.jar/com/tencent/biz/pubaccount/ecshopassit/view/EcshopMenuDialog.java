package com.tencent.biz.pubaccount.ecshopassit.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.RedPointInfo;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean.TabConfBean;
import com.tencent.biz.pubaccount.ecshopassit.utils.RedPointUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EcshopMenuDialog
  extends PopupWindow
  implements View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private EcshopMenuDialog.OnClickActionListener jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopMenuDialog$OnClickActionListener;
  
  private EcshopMenuDialog(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return AIOUtils.a(paramInt * 50 + 10 + 10 + 9, paramContext.getResources());
  }
  
  private static View a(Activity paramActivity, List<EcshopConfBean.TabConfBean> paramList, ArrayList<RedPointInfo> paramArrayList)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131562055, null);
    a(paramActivity, localView, paramList, paramArrayList);
    return localView;
  }
  
  public static EcshopMenuDialog a(Activity paramActivity, List<EcshopConfBean.TabConfBean> paramList, ArrayList<RedPointInfo> paramArrayList, EcshopMenuDialog.OnClickActionListener paramOnClickActionListener)
  {
    int i = a(paramActivity, paramList.size());
    int j = ViewUtils.a(145.0F);
    paramActivity = new EcshopMenuDialog(paramActivity, a(paramActivity, paramList, paramArrayList), j, i, true);
    paramActivity.setAnimationStyle(2131755032);
    paramActivity.setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.setOutsideTouchable(false);
    paramActivity.a(paramActivity.getContentView());
    paramActivity.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopMenuDialog$OnClickActionListener = paramOnClickActionListener;
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    paramActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  private static void a(Context paramContext, View paramView, List<EcshopConfBean.TabConfBean> paramList, ArrayList<RedPointInfo> paramArrayList)
  {
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131370645);
    localLinearLayout.removeAllViews();
    Iterator localIterator1 = paramList.iterator();
    EcshopConfBean.TabConfBean localTabConfBean;
    View localView;
    ImageView localImageView;
    if (localIterator1.hasNext())
    {
      localTabConfBean = (EcshopConfBean.TabConfBean)localIterator1.next();
      localView = LayoutInflater.from(paramContext).inflate(2131562056, null);
      localImageView = (ImageView)localView.findViewById(2131382017);
      ((TextView)localView.findViewById(2131380427)).setText(localTabConfBean.jdField_a_of_type_JavaLangString);
      paramList = null;
      paramView = null;
      if (paramArrayList != null)
      {
        Iterator localIterator2 = paramArrayList.iterator();
        label102:
        paramList = paramView;
        if (localIterator2.hasNext())
        {
          paramList = (RedPointInfo)localIterator2.next();
          if (paramList.b != localTabConfBean.jdField_a_of_type_Int) {
            break label327;
          }
          paramView = paramList;
        }
      }
    }
    label327:
    for (;;)
    {
      break label102;
      localView.setTag(new EcshopMenuDialog.ViewTag(paramList, localTabConfBean));
      if (paramList != null) {
        if (!RedPointUtil.a(paramList.b, paramList.jdField_a_of_type_Int))
        {
          long l1 = paramList.c;
          long l2 = paramList.d;
          long l3 = NetConnInfoCenter.getServerTime();
          QLog.i("WSPopupMenuDialog", 2, "startTime: " + l1 + " endTime: " + l2 + " currentTime: " + l3);
          if ((l1 <= l3) && (l2 >= l3))
          {
            RedPointUtil.a(paramList.b);
            localImageView.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        localLinearLayout.addView(localView, new LinearLayout.LayoutParams(-1, AIOUtils.a(50.0F, paramContext.getResources())));
        break;
        localImageView.setVisibility(8);
        continue;
        localImageView.setVisibility(8);
        continue;
        localImageView.setVisibility(8);
      }
      return;
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof EcshopMenuDialog.ViewTag))) {
      paramView.setOnClickListener(this);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    a(this.jdField_a_of_type_AndroidAppActivity, 1.0F);
  }
  
  public void onClick(View paramView)
  {
    EcshopMenuDialog.ViewTag localViewTag = (EcshopMenuDialog.ViewTag)paramView.getTag();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopMenuDialog$OnClickActionListener != null) && (localViewTag != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopMenuDialog$OnClickActionListener.a(localViewTag);
    }
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    a(this.jdField_a_of_type_AndroidAppActivity, 0.6F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopMenuDialog
 * JD-Core Version:    0.7.0.1
 */