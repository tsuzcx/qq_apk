package com.tencent.mobileqq.activity.qwallet.redpacket.specify;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SpecifyGiftView$1
  implements View.OnClickListener
{
  SpecifyGiftView$1(SpecifyGiftView paramSpecifyGiftView, FrameSprite.OnFrameEndListener paramOnFrameEndListener, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView).a();
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
    }
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface != null)
    {
      AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)localQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (localAIOAnimationControlManager != null) {
        localAIOAnimationControlManager.a(SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView).frienduin);
      }
    }
    QWalletTools.a(localQQAppInterface, "212", "only.animation.close");
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyGiftView.1
 * JD-Core Version:    0.7.0.1
 */