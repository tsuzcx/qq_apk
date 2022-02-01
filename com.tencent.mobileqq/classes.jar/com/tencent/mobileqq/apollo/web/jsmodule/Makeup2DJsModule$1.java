package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.res.api.IApolloResHelper;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.ChangeRoleCallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import org.jetbrains.annotations.Nullable;

class Makeup2DJsModule$1
  implements IStoreAvatar2D.ChangeRoleCallback
{
  Makeup2DJsModule$1(Makeup2DJsModule paramMakeup2DJsModule, String paramString) {}
  
  public void a(int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt, int paramInt3)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt != null)
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt.length > 0) {}
    }
    else
    {
      arrayOfInt = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(paramInt2);
    }
    this.b.d().mDressIds = arrayOfInt;
    this.b.d().mRoleId = paramInt2;
    this.b.d().mApolloStatus = 1;
    if ((paramInt1 == 0) && (arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      this.b.b(this.a);
      return;
    }
    this.b.a(this.a, HardCodeUtil.a(2131898658));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup2DJsModule.1
 * JD-Core Version:    0.7.0.1
 */