package com.tencent.ilivesdk.faceverifyservice_interface;

import android.content.Context;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface FaceVerifyServiceInterface
  extends ServiceBaseInterface
{
  public abstract void setAdapter(FaceVerifyServiceAdapter paramFaceVerifyServiceAdapter);
  
  public abstract boolean startFaceVerify(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, FaceVerifyServiceInterface.VerifyMode paramVerifyMode, String paramString7, FaceVerifyServiceInterface.FaceVerifyListener paramFaceVerifyListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.faceverifyservice_interface.FaceVerifyServiceInterface
 * JD-Core Version:    0.7.0.1
 */