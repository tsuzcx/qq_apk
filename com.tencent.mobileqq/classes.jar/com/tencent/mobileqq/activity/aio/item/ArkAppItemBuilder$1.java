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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer.getContainerRect();
    float f = ArkAppCenterUtil.a();
    int i = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
    int j = (int)((((Rect)localObject).bottom - ((Rect)localObject).top) * f);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder$Holder.a.getLayoutParams();
    StringBuilder localStringBuilder = new StringBuilder("ArkFold.onLoadFinish arkContainer rect(");
    localStringBuilder.append(i).append(",").append(j).append(")").append(", arkView layout rect(").append(((ViewGroup.LayoutParams)localObject).width).append(",").append(((ViewGroup.LayoutParams)localObject).height).append(")").append(", init mArkWidth=").append(ArkAppItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder)).append(", load state=").append(paramInt).append(", app=").append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName);
    QLog.i("ArkAppItemBuilder", 1, localStringBuilder.toString());
    if ((ArkAppCenterUtil.a) && (paramInt == 1) && (Math.abs(((ViewGroup.LayoutParams)localObject).width - ArkAppItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder)) > 5))
    {
      QLog.d("ArkAppItemBuilder", 1, new Object[] { "ArkFold.onLoadFinish setViewRect(", Integer.valueOf(ArkAppItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder)), ",", Integer.valueOf(j), ")" });
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder$Holder.a.setFixSize(ArkAppItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder), -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder$Holder.a.setMaxSize(ArkAppItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder), -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder$Holder.a.setMinSize(ArkAppItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder), -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder$Holder.a.setViewRect(ArkAppItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder), j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */