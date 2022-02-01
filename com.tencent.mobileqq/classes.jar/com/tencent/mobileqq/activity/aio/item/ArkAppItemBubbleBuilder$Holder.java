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
  public String a;
  public ArkAppLoadLayout b;
  public ArkAppView c;
  public LinearLayout d;
  public ImageView e;
  public TextView f;
  public TextView g;
  public View s;
  
  public void a(Holder paramHolder, ArkAdapterItemInterface paramArkAdapterItemInterface)
  {
    Object localObject2 = paramArkAdapterItemInterface.getArkAppNameAndPath();
    String str = localObject2[0];
    Object localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    paramArkAdapterItemInterface.clickTail(null, paramHolder.d, this.c.getContext());
    if (localObject1 != null)
    {
      ArkAppCacheMgr.getAppIcon(str, new ArkAppItemBubbleBuilder.Holder.1(this, paramHolder));
      paramArkAdapterItemInterface = ArkAppCacheMgr.getApplicationDesc(str);
      if (paramArkAdapterItemInterface != null)
      {
        this.d.setVisibility(0);
        paramHolder.f.setVisibility(0);
        paramHolder.f.setText(paramArkAdapterItemInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */