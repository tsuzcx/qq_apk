package com.tencent.av.switchface;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.MagicFaceDataEntity;
import com.tencent.qphone.base.util.QLog;

public class SwitchFaceMagicFaceDataEntity
  extends MagicFaceDataEntity
{
  public SwitchFaceMagicFaceDataEntity(VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramVideoAppInterface, paramString1, paramString2, paramString3, paramBoolean, paramInt);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, short paramShort1, short paramShort2, short paramShort3, short paramShort4, boolean paramBoolean)
  {
    super.a(paramString, paramArrayOfByte, paramShort1, paramShort2, paramShort3, paramShort4, paramBoolean);
    if (paramBoolean) {
      QLog.d("SwitchFaceMagicFaceDataEntity", 2, "WL_DEBUG onReceivePeerFaceFeature uin = " + paramString + ", width = " + paramShort1 + ", height = " + paramShort2 + ", frameWidth = " + paramShort3 + ", frameHeight = " + paramShort4);
    }
  }
  
  protected void c()
  {
    super.c();
    c(0);
    c(1);
    a(true);
    a(null);
  }
  
  protected void d()
  {
    super.d();
    b(0);
    b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.switchface.SwitchFaceMagicFaceDataEntity
 * JD-Core Version:    0.7.0.1
 */