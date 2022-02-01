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
      ETDIYUtil.a(this.jdField_a_of_type_JavaIoFile, paramObject, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.ETDIYUtil.1
 * JD-Core Version:    0.7.0.1
 */