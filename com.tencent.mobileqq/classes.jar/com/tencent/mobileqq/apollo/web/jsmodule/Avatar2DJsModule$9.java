package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.res.api.IApolloResHelper;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class Avatar2DJsModule$9
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  Avatar2DJsModule$9(Avatar2DJsModule paramAvatar2DJsModule, String paramString, ApolloWebAvatarParam paramApolloWebAvatarParam, Avatar2DJsModule.OnCheckApolloResListener paramOnCheckApolloResListener, ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (!paramBoolean) {
      this.e.a(this.a, HardCodeUtil.a(2131898692));
    }
    if ((this.b.dressIds == null) || (this.b.dressIds.length == 0)) {
      this.b.dressIds = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(this.b.roleId);
    }
    paramString = this.e.e();
    if (paramString == null) {
      return;
    }
    this.c.a(paramString, this.b, this.d, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Avatar2DJsModule.9
 * JD-Core Version:    0.7.0.1
 */