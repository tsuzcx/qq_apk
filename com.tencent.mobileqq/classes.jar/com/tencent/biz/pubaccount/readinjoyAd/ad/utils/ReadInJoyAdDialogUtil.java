package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ReadInJoyAdDialogUtil
{
  private static String a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = String.format("%.3f", new Object[] { Float.valueOf((float)Long.parseLong(paramString) * 1.0F / 1048576.0F) });
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      label35:
      break label35;
    }
    return "0";
  }
  
  public static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener, SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131953338);
    localQQCustomDialog.setContentView(2131624587);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localQQCustomDialog.getMessageTextView().getLayoutParams();
    localLayoutParams.leftMargin = AIOUtils.b(30.0F, paramContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.b(30.0F, paramContext.getResources());
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
    if (paramAdvertisementInfo != null)
    {
      if (paramAdvertisementInfo.gameAdComData == null) {
        return;
      }
      if (!paramBoolean1)
      {
        str1 = HardCodeUtil.a(2131910455);
        if (!a(paramAdvertisementInfo.gameAdComData.n).equals("0")) {
          str1 = String.format(HardCodeUtil.a(2131910334), new Object[] { a(paramAdvertisementInfo.gameAdComData.n) });
        }
        if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.z)) {
          str1 = paramAdvertisementInfo.gameAdComData.z;
        }
      }
      else
      {
        str1 = HardCodeUtil.a(2131910436);
        if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.y)) {
          str1 = paramAdvertisementInfo.gameAdComData.y;
        }
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str1);
      int i;
      if (!paramBoolean2)
      {
        str2 = HardCodeUtil.a(2131910571);
        String str3;
        if ((!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.A)) && (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.B)))
        {
          str2 = paramAdvertisementInfo.gameAdComData.A;
          str3 = paramAdvertisementInfo.gameAdComData.B;
        }
        else
        {
          str3 = "#E06F00";
        }
        if (str1.contains(str2))
        {
          i = str1.indexOf(str2);
          int j = str2.length();
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str3)), i, j + i, 33);
        }
      }
      String str1 = HardCodeUtil.a(2131910568);
      if (paramBoolean2) {
        str1 = HardCodeUtil.a(2131910541);
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.x)) {
        str1 = paramAdvertisementInfo.gameAdComData.x;
      }
      String str2 = HardCodeUtil.a(2131910256);
      if (PackageUtil.a(BaseApplicationImpl.getContext(), paramAdvertisementInfo.gameAdComData.e)) {
        paramAdvertisementInfo = HardCodeUtil.a(2131910393);
      } else {
        paramAdvertisementInfo = str2;
      }
      if (paramBoolean2) {
        i = 2131910503;
      } else {
        i = 2131910233;
      }
      a(paramContext, paramOnClickListener, localSpannableStringBuilder, str1, paramAdvertisementInfo, HardCodeUtil.a(i));
    }
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(HardCodeUtil.a(2131910335));
    String str2 = HardCodeUtil.a(2131910482);
    String str1 = HardCodeUtil.a(2131910255);
    if (PackageUtil.a(BaseApplicationImpl.getContext(), paramString)) {
      paramString = HardCodeUtil.a(2131910512);
    } else {
      paramString = str1;
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str2, paramString, HardCodeUtil.a(2131910614));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdDialogUtil
 * JD-Core Version:    0.7.0.1
 */