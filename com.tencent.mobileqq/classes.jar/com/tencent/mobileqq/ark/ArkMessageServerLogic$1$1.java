package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import com.tencent.ark.ArkAppPanelList.AppDetail;
import com.tencent.ark.ArkAppPanelList.RespBody;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ArkMessageServerLogic$1$1
  implements BusinessObserver
{
  ArkMessageServerLogic$1$1(ArkMessageServerLogic.1 param1) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject1 = null;
    if ((paramBoolean) && (paramObject != null))
    {
      Object localObject2 = new ArkAppPanelList.RespBody();
      try
      {
        ((ArkAppPanelList.RespBody)localObject2).mergeFrom((byte[])paramObject);
        ArrayList localArrayList = new ArrayList();
        paramObject = localObject1;
        if (((ArkAppPanelList.RespBody)localObject2).apps.has()) {
          paramObject = ((ArkAppPanelList.RespBody)localObject2).apps.get();
        }
        if ((paramObject != null) && (paramObject.size() > 0))
        {
          paramObject = paramObject.iterator();
          while (paramObject.hasNext())
          {
            Object localObject3 = (ArkAppPanelList.AppDetail)paramObject.next();
            if (localObject3 != null)
            {
              localObject1 = ((ArkAppPanelList.AppDetail)localObject3).appName.get();
              localObject2 = ((ArkAppPanelList.AppDetail)localObject3).cnName.get();
              localObject3 = ((ArkAppPanelList.AppDetail)localObject3).iconUrl.get();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
                localArrayList.add(new ArkAppPanelData((String)localObject1, (String)localObject2, (String)localObject3));
              }
            }
          }
        }
        if (this.a.a == null) {
          return;
        }
        this.a.a.b(localArrayList);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("requestArkAppManagerPanelList mergeFrom exception=");
        ((StringBuilder)localObject1).append(paramObject);
        ArkAppCenter.a("ArkApp.ArkMessageServerLogic", ((StringBuilder)localObject1).toString());
        if (this.a.a != null) {
          this.a.a.b(null);
        }
        return;
      }
    }
    else if (this.a.a != null)
    {
      this.a.a.b(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMessageServerLogic.1.1
 * JD-Core Version:    0.7.0.1
 */