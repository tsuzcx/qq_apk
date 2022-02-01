package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.qphone.base.util.QLog;

class ArkAppItemBubbleBuilder$1
  implements ArkViewImplement.LoadCallback
{
  ArkAppItemBubbleBuilder$1(ArkAppItemBubbleBuilder paramArkAppItemBubbleBuilder, MessageForArkApp paramMessageForArkApp, ArkAppItemBubbleBuilder.Holder paramHolder) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppItemBubbleBuilder", 2, new Object[] { "onLoadFinish state=", Integer.valueOf(paramInt), ",app=", this.a.ark_app_message.appName });
    }
    if (paramInt == 1)
    {
      if (!RobotUtils.a(this.c.d, this.a.senderuin))
      {
        localObject = this.b;
        ((ArkAppItemBubbleBuilder.Holder)localObject).a((ArkAppItemBubbleBuilder.Holder)localObject, this.a);
      }
      Object localObject = this.a.arkContainer.getContainerRect();
      float f = ArkAppCenterUtil.d();
      paramInt = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
      int i = (int)(f * (((Rect)localObject).bottom - ((Rect)localObject).top));
      localObject = this.b.c.getLayoutParams();
      StringBuilder localStringBuilder = new StringBuilder("ArkFold.onLoadFinish arkContainer rect(");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      localStringBuilder.append(")");
      localStringBuilder.append(", arkView layout rect(");
      localStringBuilder.append(((ViewGroup.LayoutParams)localObject).width);
      localStringBuilder.append(",");
      localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
      localStringBuilder.append(")");
      localStringBuilder.append(", init mArkWidth=");
      localStringBuilder.append(ArkAppItemBubbleBuilder.b(this.c));
      localStringBuilder.append(",mArkHeight=");
      localStringBuilder.append(ArkAppItemBubbleBuilder.a(this.c));
      localStringBuilder.append(",app=");
      localStringBuilder.append(this.a.ark_app_message.appName);
      QLog.i("ArkAppItemBubbleBuilder", 1, localStringBuilder.toString());
      return;
    }
    this.b.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.1
 * JD-Core Version:    0.7.0.1
 */