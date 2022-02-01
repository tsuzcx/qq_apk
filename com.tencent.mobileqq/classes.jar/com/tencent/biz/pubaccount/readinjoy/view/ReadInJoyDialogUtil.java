package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TwoLineContentDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import org.jetbrains.annotations.NotNull;

public class ReadInJoyDialogUtil
{
  public static TwoLineContentDialog a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new TwoLineContentDialog(paramContext, 2131755842);
    paramContext.setContentView(2131562898);
    paramContext.setTitle(null);
    paramContext.setMessage(paramString1);
    paramContext.a(paramString2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static void a(@NotNull Context paramContext)
  {
    ReadInJoyDialogUtil.1 local1 = new ReadInJoyDialogUtil.1(paramContext);
    DialogUtil.a(paramContext, 230, null, paramContext.getResources().getString(2131718100), local1, local1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDialogUtil
 * JD-Core Version:    0.7.0.1
 */