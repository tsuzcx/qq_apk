package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

class ArkAppItemBuilder$1
  implements ArkViewImplement.LoadCallback
{
  ArkAppItemBuilder$1(ArkAppItemBuilder paramArkAppItemBuilder, MessageForArkApp paramMessageForArkApp, ArkAppItemBubbleBuilder.Holder paramHolder) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    Object localObject = this.a.arkContainer.getContainerRect();
    float f = ArkAppCenterUtil.d();
    int i = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
    int j = (int)(f * (((Rect)localObject).bottom - ((Rect)localObject).top));
    localObject = this.b.c.getLayoutParams();
    StringBuilder localStringBuilder = new StringBuilder("ArkFold.onLoadFinish arkContainer rect(");
    localStringBuilder.append(i);
    localStringBuilder.append(",");
    localStringBuilder.append(j);
    localStringBuilder.append(")");
    localStringBuilder.append(", arkView layout rect(");
    localStringBuilder.append(((ViewGroup.LayoutParams)localObject).width);
    localStringBuilder.append(",");
    localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
    localStringBuilder.append(")");
    localStringBuilder.append(", init mArkWidth=");
    localStringBuilder.append(ArkAppItemBuilder.a(this.c));
    localStringBuilder.append(", load state=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", app=");
    localStringBuilder.append(this.a.ark_app_message.appName);
    QLog.i("ArkAppItemBuilder", 1, localStringBuilder.toString());
    if ((ArkAppCenterUtil.e) && (paramInt == 1) && (Math.abs(((ViewGroup.LayoutParams)localObject).width - ArkAppItemBuilder.a(this.c)) > 5))
    {
      QLog.d("ArkAppItemBuilder", 1, new Object[] { "ArkFold.onLoadFinish setViewRect(", Integer.valueOf(ArkAppItemBuilder.a(this.c)), ",", Integer.valueOf(j), ")" });
      this.b.c.setFixSize(ArkAppItemBuilder.a(this.c), -1);
      this.b.c.setMaxSize(ArkAppItemBuilder.a(this.c), -1);
      this.b.c.setMinSize(ArkAppItemBuilder.a(this.c), -1);
      this.b.c.setViewRect(ArkAppItemBuilder.a(this.c), j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */