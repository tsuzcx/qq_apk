package com.tencent.mobileqq.activity.aio.photo;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOGallerySceneWithBusiness$1
  implements View.OnClickListener
{
  AIOGallerySceneWithBusiness$1(AIOGallerySceneWithBusiness paramAIOGallerySceneWithBusiness) {}
  
  public void onClick(View paramView)
  {
    String str = "";
    Object localObject2;
    if (paramView == this.a.a)
    {
      Object localObject1 = paramView.getTag();
      if ((localObject1 instanceof StructMsgForImageShare))
      {
        localObject1 = (StructMsgForImageShare)localObject1;
        if (AIOGallerySceneWithBusiness.a(((StructMsgForImageShare)localObject1).mMsgActionData))
        {
          this.a.b((StructMsgForImageShare)localObject1, "5");
        }
        else if (AIOGallerySceneWithBusiness.b(((StructMsgForImageShare)localObject1).mMsgActionData))
        {
          AIOGallerySceneWithBusiness.a(this.a, (StructMsgForImageShare)localObject1);
          Object localObject4 = AIOGallerySceneWithBusiness.b(((StructMsgForImageShare)localObject1).mMsgActionData);
          if ((localObject4 != null) && (localObject4.length > 2))
          {
            localObject1 = Uri.parse(localObject4[1]);
            try
            {
              localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              localObject2 = "";
            }
            Object localObject3 = localObject2;
            if (localObject2 == null) {
              localObject3 = "";
            }
            localObject2 = str;
            if (localObject4.length > 3)
            {
              localObject4 = localObject4[3];
              localObject2 = str;
              if (localObject4 != null) {
                if (!((String)localObject4).equals("1")) {
                  localObject2 = str;
                } else {
                  localObject2 = localObject4;
                }
              }
            }
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800712E", "0X800712E", 0, 0, (String)localObject3, (String)localObject2, "", "");
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X800712E", "", (String)localObject3, (String)localObject2, "", "");
          }
        }
      }
    }
    else if (paramView == this.a.b)
    {
      localObject2 = paramView.getTag();
      if ((localObject2 instanceof StructMsgForImageShare)) {
        this.a.c((StructMsgForImageShare)localObject2, "5");
      }
    }
    else if (paramView == this.a.c)
    {
      localObject2 = paramView.getTag();
      if ((localObject2 instanceof StructMsgForImageShare)) {
        localObject2 = (StructMsgForImageShare)localObject2;
      }
      this.a.a(4);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness.1
 * JD-Core Version:    0.7.0.1
 */