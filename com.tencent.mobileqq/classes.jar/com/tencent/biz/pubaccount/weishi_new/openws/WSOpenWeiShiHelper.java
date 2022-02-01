package com.tencent.biz.pubaccount.weishi_new.openws;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSLastAction;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSOpenWeiShiData;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSReportParams;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;

public class WSOpenWeiShiHelper
{
  private static WSOpenWeiShiHelper a;
  
  private WSOnDialogItemClickListener a(@NonNull Context paramContext, @NonNull WSReportParams paramWSReportParams)
  {
    return new WSOpenWeiShiHelper.1(this, paramWSReportParams, paramContext);
  }
  
  public static WSOpenWeiShiHelper a()
  {
    if (a == null) {
      a = new WSOpenWeiShiHelper();
    }
    return a;
  }
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveActionToSp() type = ");
    localStringBuilder.append(paramInt);
    WSLog.e("WSOpenWeiShiHelper", localStringBuilder.toString());
    WSSharePreferencesUtil.a("key_last_open_ws_action", WSLastAction.a(paramInt, System.currentTimeMillis()));
  }
  
  private void a(@NonNull Context paramContext, @Nullable String paramString)
  {
    WSLog.e("WSOpenWeiShiHelper", "directOpenWeiShi()");
    WeishiScehmeUtil.a(paramContext, "biz_src_jc_gzh_weishi", paramString);
  }
  
  private boolean a(long paramLong1, long paramLong2, int paramInt)
  {
    boolean bool;
    if (paramLong1 >= b(paramInt) + paramLong2) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isExpire() result = ");
    localStringBuilder.append(bool);
    localStringBuilder.append(", curTime = ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", lastTime = ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", validityPeriodDay = ");
    localStringBuilder.append(paramInt);
    WSLog.e("WSOpenWeiShiHelper", localStringBuilder.toString());
    return bool;
  }
  
  private long b(int paramInt)
  {
    return paramInt * 24 * 60 * 60 * 1000;
  }
  
  private void b(@NonNull Context paramContext, @NonNull WSOpenWeiShiData paramWSOpenWeiShiData, @NonNull WSReportParams paramWSReportParams)
  {
    WSLog.e("WSOpenWeiShiHelper", "showTipsDialog()");
    WSOpenWeiShiTipsDialog localWSOpenWeiShiTipsDialog = new WSOpenWeiShiTipsDialog(paramContext);
    localWSOpenWeiShiTipsDialog.a(paramWSOpenWeiShiData);
    localWSOpenWeiShiTipsDialog.a(a(paramContext, paramWSReportParams));
    localWSOpenWeiShiTipsDialog.show();
    WSOpenWeiShiReport.a(paramWSReportParams);
  }
  
  public void a(@Nullable Context paramContext, @Nullable WSOpenWeiShiData paramWSOpenWeiShiData, @Nullable WSReportParams paramWSReportParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkIfNeedShowOpenWeiShiDialog() ");
    ((StringBuilder)localObject).append(paramWSOpenWeiShiData);
    WSLog.e("WSOpenWeiShiHelper", ((StringBuilder)localObject).toString());
    if ((paramContext != null) && (paramWSOpenWeiShiData != null))
    {
      if (paramWSReportParams == null) {
        return;
      }
      localObject = WSSharePreferencesUtil.b("key_last_open_ws_action", "");
      WSLastAction localWSLastAction = WSLastAction.a((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkIfNeedShowOpenWeiShiDialog() lastActionSpString = ");
      localStringBuilder.append((String)localObject);
      WSLog.e("WSOpenWeiShiHelper", localStringBuilder.toString());
      if ((localWSLastAction.a() != 0) && (localWSLastAction.b() != 0L))
      {
        long l = System.currentTimeMillis();
        int i = localWSLastAction.a();
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          if (a(l, localWSLastAction.b(), paramWSOpenWeiShiData.a()))
          {
            b(paramContext, paramWSOpenWeiShiData, paramWSReportParams);
            return;
          }
          return;
        }
        if (a(l, localWSLastAction.b(), paramWSOpenWeiShiData.b()))
        {
          b(paramContext, paramWSOpenWeiShiData, paramWSReportParams);
          return;
        }
        a(paramContext, paramWSOpenWeiShiData.g());
        return;
      }
      b(paramContext, paramWSOpenWeiShiData, paramWSReportParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiHelper
 * JD-Core Version:    0.7.0.1
 */