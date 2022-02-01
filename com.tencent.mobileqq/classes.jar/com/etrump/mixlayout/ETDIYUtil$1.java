package com.etrump.mixlayout;

import QC.GetUserDiyFontRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import java.io.File;

final class ETDIYUtil$1
  implements BusinessObserver
{
  ETDIYUtil$1(File paramFile, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetUserDiyFontRsp)))
    {
      paramObject = ((GetUserDiyFontRsp)paramObject).url;
      ETDIYUtil.a(this.a, paramObject, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETDIYUtil.1
 * JD-Core Version:    0.7.0.1
 */