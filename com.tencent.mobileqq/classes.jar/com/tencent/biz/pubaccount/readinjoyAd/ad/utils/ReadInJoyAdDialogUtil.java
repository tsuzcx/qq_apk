package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ReadInJoyAdDialogUtil
{
  private static String a(String paramString)
  {
    String str = "0";
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        str = String.format("%.3f", new Object[] { Float.valueOf((float)Long.parseLong(paramString) * 1.0F / 1048576.0F) });
      }
      return str;
    }
    catch (Exception paramString) {}
    return "0";
  }
  
  public static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener, SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131755842);
    localQQCustomDialog.setContentView(2131559060);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localQQCustomDialog.getMessageTextView().getLayoutParams();
    localLayoutParams.leftMargin = AIOUtils.a(30.0F, paramContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.a(30.0F, paramContext.getResources());
    localLayoutParams.width = -1;
    localQQCustomDialog.getMessageTextView().setLayoutParams(localLayoutParams);
    localQQCustomDialog.setMessage(paramSpannableStringBuilder);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setPositiveButton(paramString2, new ReadInJoyAdDialogUtil.2(paramOnClickListener));
    localQQCustomDialog.setNegativeButton(paramString3, new ReadInJoyAdDialogUtil.3(paramOnClickListener));
    localQQCustomDialog.show();
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.gameAdComData == null)) {
      return;
    }
    String str1;
    SpannableStringBuilder localSpannableStringBuilder;
    String str2;
    if (!paramBoolean1)
    {
      str1 = HardCodeUtil.a(2131712910);
      if (!a(paramAdvertisementInfo.gameAdComData.m).equals("0")) {
        str1 = String.format(HardCodeUtil.a(2131712785), new Object[] { a(paramAdvertisementInfo.gameAdComData.m) });
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.y)) {
        str1 = paramAdvertisementInfo.gameAdComData.y;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(str1);
      if (!paramBoolean2)
      {
        String str4 = HardCodeUtil.a(2131713032);
        String str5 = "#E06F00";
        String str3 = str5;
        str2 = str4;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.z))
        {
          str3 = str5;
          str2 = str4;
          if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.A))
          {
            str2 = paramAdvertisementInfo.gameAdComData.z;
            str3 = paramAdvertisementInfo.gameAdComData.A;
          }
        }
        if (str1.contains(str2))
        {
          int i = str1.indexOf(str2);
          int j = str2.length();
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str3)), i, j + i, 33);
        }
      }
      str1 = HardCodeUtil.a(2131713029);
      if (paramBoolean2) {
        str1 = HardCodeUtil.a(2131713001);
      }
      if (TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.w)) {
        break label363;
      }
      str1 = paramAdvertisementInfo.gameAdComData.w;
    }
    label363:
    for (;;)
    {
      str2 = HardCodeUtil.a(2131712703);
      if (PackageUtil.a(BaseApplicationImpl.getContext(), paramAdvertisementInfo.gameAdComData.d)) {
        str2 = HardCodeUtil.a(2131712845);
      }
      if (paramBoolean2) {}
      for (paramAdvertisementInfo = HardCodeUtil.a(2131712962);; paramAdvertisementInfo = HardCodeUtil.a(2131712679))
      {
        a(paramContext, paramOnClickListener, localSpannableStringBuilder, str1, str2, paramAdvertisementInfo);
        return;
        str1 = HardCodeUtil.a(2131712890);
        if (TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.x)) {
          break;
        }
        str1 = paramAdvertisementInfo.gameAdComData.x;
        break;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(HardCodeUtil.a(2131712786));
    String str2 = HardCodeUtil.a(2131712937);
    String str1 = HardCodeUtil.a(2131712702);
    if (PackageUtil.a(BaseApplicationImpl.getContext(), paramString)) {
      str1 = HardCodeUtil.a(2131712971);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str2, str1, HardCodeUtil.a(2131713078));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdDialogUtil
 * JD-Core Version:    0.7.0.1
 */