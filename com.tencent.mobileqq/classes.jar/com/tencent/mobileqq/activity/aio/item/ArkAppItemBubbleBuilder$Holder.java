package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAdapterItemInterface;

public class ArkAppItemBubbleBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public ArkAppLoadLayout a;
  public ArkAppView a;
  public TextView b;
  public String b;
  public View c;
  
  public void a(Holder paramHolder, ArkAdapterItemInterface paramArkAdapterItemInterface)
  {
    Object localObject2 = paramArkAdapterItemInterface.getArkAppNameAndPath();
    String str = localObject2[0];
    Object localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    paramArkAdapterItemInterface.clickTail(null, paramHolder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getContext());
    if (localObject1 != null)
    {
      ArkAppCacheMgr.getAppIcon(str, new ArkAppItemBubbleBuilder.Holder.1(this, paramHolder));
      paramArkAdapterItemInterface = ArkAppCacheMgr.getApplicationDesc(str);
      if (paramArkAdapterItemInterface != null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramArkAdapterItemInterface);
      }
    }
    else
    {
      if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
        return;
      }
      ArkAppMgr.getInstance().getAppPathByName(str, "0.0.0.1", new ArkAppItemBubbleBuilder.Holder.2(this, str, paramHolder));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */