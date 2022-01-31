package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAdapterItemInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import uzn;
import uzo;
import uzq;

public class ArkAppItemBubbleBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
{
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public ArkAppLoadLayout a;
  public ArkAppView a;
  public String b;
  
  public void a(Holder paramHolder, ArkAdapterItemInterface paramArkAdapterItemInterface)
  {
    Object localObject = paramArkAdapterItemInterface.getArkAppNameAndPath();
    String str = localObject[0];
    localObject = localObject[1];
    paramArkAdapterItemInterface.clickTail(null, paramHolder, this.a.getContext());
    if (localObject != null)
    {
      ArkAppCenter.a((String)localObject, new uzn(this, paramHolder));
      ArkAppCenter.a().post(new uzo(this, (String)localObject, paramHolder));
    }
    do
    {
      return;
      paramArkAdapterItemInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    } while (paramArkAdapterItemInterface == null);
    ((ArkAppCenter)paramArkAdapterItemInterface.getManager(120)).a().a(str, "0.0.0.1", null, new uzq(this, paramHolder));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */