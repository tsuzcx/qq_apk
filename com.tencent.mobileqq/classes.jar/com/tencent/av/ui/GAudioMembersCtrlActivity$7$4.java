package com.tencent.av.ui;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.EllipsisUtil;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GAudioMembersCtrlActivity$7$4
  implements Runnable
{
  GAudioMembersCtrlActivity$7$4(GAudioMembersCtrlActivity.7 param7, ArrayList paramArrayList) {}
  
  public void run()
  {
    TextPaint localTextPaint = new TextView(GAudioMembersCtrlActivity.b(this.b.b)).getPaint();
    Object localObject1 = HardCodeUtil.a(2131903139);
    float f2 = GAudioMembersCtrlActivity.c(this.b.b).getDisplayMetrics().widthPixels;
    float f6 = localTextPaint.measureText((String)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    int m = this.a.size();
    float f1;
    AVUserInfo localAVUserInfo;
    String str;
    Object localObject2;
    if (m == 1)
    {
      f2 = f2 - DisplayUtil.a(GAudioMembersCtrlActivity.d(this.b.b), 60.0F) - f6;
      f1 = f2;
      if (f2 <= 0.0F) {
        f1 = GAudioMembersCtrlActivity.e(this.b.b).getDimensionPixelSize(2131297557);
      }
      localAVUserInfo = (AVUserInfo)this.a.get(0);
      str = this.b.b.b.a(String.valueOf(localAVUserInfo.account), String.valueOf(this.b.b.b.k().aN), 1);
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = String.valueOf(String.valueOf(localAVUserInfo.account));
      }
      EllipsisUtil.b(localStringBuilder, (String)localObject2, localTextPaint, f1);
      localObject2 = localObject1;
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("等99人");
      ((StringBuilder)localObject2).append((String)localObject1);
      f1 = localTextPaint.measureText(((StringBuilder)localObject2).toString());
      float f7 = localTextPaint.measureText("...");
      float f3 = f2 - DisplayUtil.a(GAudioMembersCtrlActivity.f(this.b.b), 60.0F) - f1 - f7;
      f1 = f3;
      if (f3 <= 0.0F) {
        f1 = GAudioMembersCtrlActivity.g(this.b.b).getDimensionPixelSize(2131297557);
      }
      float f4 = localTextPaint.measureText("、");
      int i = 0;
      int j = 0;
      f3 = f1;
      f1 = f4;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= 2) {
          break label657;
        }
        int k = 0;
        while (k < m)
        {
          localAVUserInfo = (AVUserInfo)this.a.get(k);
          localObject2 = this.b.b.b;
          f4 = f1;
          str = ((VideoController)localObject2).a(String.valueOf(localAVUserInfo.account), String.valueOf(this.b.b.b.k().aN), 1);
          localObject2 = str;
          if (TextUtils.isEmpty(str)) {
            localObject2 = String.valueOf(String.valueOf(localAVUserInfo.account));
          }
          float f5 = EllipsisUtil.a(localStringBuilder, (String)localObject2, localTextPaint, f3);
          if ((f4 * 2.0F < f5) && (k < m - 1))
          {
            localStringBuilder.append("、");
            k += 1;
            f3 = f5;
            f1 = f4;
          }
          else
          {
            if ((k == 0) && (f5 == f3) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
              EllipsisUtil.a(localStringBuilder, (String)localObject2, localTextPaint, GAudioMembersCtrlActivity.h(this.b.b).getDimensionPixelSize(2131297557));
            }
            f3 = f5;
            if (f7 > f5)
            {
              localStringBuilder.append("...等");
              localStringBuilder.append(m);
              localStringBuilder.append("人");
              f3 = f5;
            }
          }
        }
        if ((f7 < f3) || (j != 0)) {
          break;
        }
        localStringBuilder.delete(0, localStringBuilder.length());
        f3 = f2 - DisplayUtil.a(GAudioMembersCtrlActivity.i(this.b.b), 60.0F) - f6;
        i += 1;
        j = 1;
      }
      break label661;
    }
    label657:
    localObject1 = localObject2;
    label661:
    localStringBuilder.append((String)localObject1);
    QQToast.makeText(this.b.b, localStringBuilder.toString(), 1).show();
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.7.4
 * JD-Core Version:    0.7.0.1
 */