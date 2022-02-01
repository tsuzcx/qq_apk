package com.tencent.mobileqq.activity.qwallet.redpacket.specify;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.io.File;
import java.lang.ref.WeakReference;

class SpecifyRedPacketAnimMsg$3$1
  implements Runnable
{
  SpecifyRedPacketAnimMsg$3$1(SpecifyRedPacketAnimMsg.3 param3, IPreloadService.PathResult paramPathResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim start playVideo");
    }
    Object localObject;
    try
    {
      if (SpecifyRedPacketAnimMsg.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg)) {
        return;
      }
      localObject = (MessageForQQWalletMsg)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SpecifyRedPacketAnimMsg", 2, "showAnim start playVideo err:" + localThrowable1.getMessage());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
      return;
    }
    String str = new File(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.folderPath, "video.mp4").getAbsolutePath();
    if (!new File(str).exists())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
      return;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.b.get();
    if ((localBaseChatPie == null) || (localBaseChatPie.h() != 4) || (localBaseChatPie.a() == null) || (localBaseChatPie.a().isFinishing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
      return;
    }
    BaseActivity localBaseActivity = localBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView = new SpecifyGiftView(localBaseActivity, (MessageForQQWalletMsg)localObject);
    if (Build.VERSION.SDK_INT >= 19) {}
    for (int i = 67108872;; i = 8)
    {
      localObject = new WindowManager.LayoutParams(-1, -2, 2, i, -2);
      ((WindowManager.LayoutParams)localObject).gravity = 49;
      View localView = localBaseActivity.findViewById(2131377159);
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      if (LiuHaiUtils.b(localBaseActivity)) {
        ((WindowManager.LayoutParams)localObject).y = localBaseChatPie.a();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)localBaseActivity.getSystemService("window"));
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView);
          label356:
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView, (ViewGroup.LayoutParams)localObject);
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView.a(str, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyRedPacketAnimMsg$3.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener, new SpecifyRedPacketAnimMsg.3.1.1(this));
          return;
          ((WindowManager.LayoutParams)localObject).y = (arrayOfInt[1] + localBaseChatPie.a());
        }
        catch (Throwable localThrowable2)
        {
          break label356;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyRedPacketAnimMsg.3.1
 * JD-Core Version:    0.7.0.1
 */