package com.tencent.mobileqq.activity.aio;

import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.qwallet.elem.SkinRedPkgElem;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CustomizeStrategyFactory$SkinRedPacketStrategy$2
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$SkinRedPacketStrategy$2(CustomizeStrategyFactory.SkinRedPacketStrategy paramSkinRedPacketStrategy, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    Object localObject1 = paramPathResult.folderPath;
    if (paramInt == 0) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.skinType != 1) {
        break label345;
      }
      paramPathResult = (String)localObject1 + File.separator;
      str1 = paramPathResult + "corner.png";
      localObject2 = paramPathResult + "base_bg.png";
      String str2 = paramPathResult + "anim_fg";
      paramInt = (int)(CustomizeStrategyFactory.a * 50.0F + 0.5D);
      i = (int)(CustomizeStrategyFactory.a * 300.0F + 0.5D);
      i = (int)(CustomizeStrategyFactory.a * 50.0F + 0.5D);
      BitmapFactory.Options localOptions = ImageUtil.a(str1, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.corner = SafeBitmapFactory.decodeFile(str1, localOptions);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.resPath = ((String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background = ((String)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.animInfo = AnimationView.AnimationInfo.loadFromFolder(str2);
      localObject1 = SkinRedPkgElem.a;
      j = localObject1.length;
      paramInt = 0;
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        String str1;
        Object localObject2;
        int i;
        int j;
        label345:
        paramPathResult.printStackTrace();
        continue;
        paramInt += 1;
      }
    }
    if (paramInt < j)
    {
      str1 = localObject1[paramInt];
      localObject2 = paramPathResult + str1 + ".png";
      localObject2 = SafeBitmapFactory.decodeFile((String)localObject2, ImageUtil.a((String)localObject2, i));
      if (localObject2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.attribute.putParcelable(str1, (Parcelable)localObject2);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "TYPE_AIO_REDPACKET background=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background + ",animInfo=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.animInfo);
      }
      for (;;)
      {
        CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.skinType == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.resPath = ((String)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("CustomizeStrategyFactory", 2, "TYPE_POP_REDPACKET path=" + (String)localObject1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.2
 * JD-Core Version:    0.7.0.1
 */