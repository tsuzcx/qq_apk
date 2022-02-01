package com.tencent.mobileqq.activity.qwallet.redpacket.specify;

import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketConfigManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.IAnimationMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class SpecifyRedPacketAnimMsg
  implements AIOAnimationControlManager.IAnimationMessage
{
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  SpecifyGiftView jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView;
  public MessageForQQWalletMsg a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = false;
  
  public SpecifyRedPacketAnimMsg(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = paramMessageForQQWalletMsg;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramQQAppInterface == null) || (paramMessageForQQWalletMsg == null)) {
      return false;
    }
    boolean bool = a(paramMessageForQQWalletMsg, paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "tryScheduleSpecifyAnim isValidAnim=" + bool);
    }
    if (bool)
    {
      ((AIOAnimationControlManager)paramQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER)).a(new SpecifyRedPacketAnimMsg(paramMessageForQQWalletMsg), false);
      return true;
    }
    return false;
  }
  
  public static boolean a(Object paramObject, QQAppInterface paramQQAppInterface)
  {
    if (!(paramObject instanceof MessageForQQWalletMsg)) {
      return false;
    }
    paramObject = (MessageForQQWalletMsg)paramObject;
    int i = paramObject.messageType;
    if ((i == 7) || (i == 8) || (i == 11) || (i == 12))
    {
      if (TextUtils.isEmpty(paramObject.mQQWalletRedPacketMsg.body.feedId)) {
        return false;
      }
      if (paramObject.isRedPackExpired()) {
        return false;
      }
      if ((!RedPacketConfigManager.a().a()) && (!paramQQAppInterface.getCurrentUin().equals(paramObject.senderuin)))
      {
        if (paramObject.mQQWalletRedPacketMsg.specifyUinList == null) {
          break label176;
        }
        paramObject = paramObject.mQQWalletRedPacketMsg.specifyUinList.iterator();
        Long localLong;
        do
        {
          if (!paramObject.hasNext()) {
            break;
          }
          localLong = (Long)paramObject.next();
        } while (!paramQQAppInterface.getCurrentUin().equals(localLong + ""));
      }
    }
    label176:
    for (i = 1;; i = 0)
    {
      return i != 0;
      return false;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView.removeAllViews();
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView = null;
      this.jdField_a_of_type_AndroidViewWindowManager = null;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.send_gift", 2, "closeRedPackGiftAnimation exception ", localException);
        }
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    QWalletTools.a(QWalletTools.a(), "212", "only.animation.show");
    String str = SpecifyAnimInfo.a() + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId + ".zip";
    WeakReference localWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    paramBaseChatPie = new WeakReference(paramBaseChatPie);
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim start");
    }
    paramOnFrameEndListener = new SpecifyRedPacketAnimMsg.1(this, paramOnFrameEndListener);
    this.jdField_a_of_type_JavaLangRunnable = new SpecifyRedPacketAnimMsg.2(this, paramOnFrameEndListener);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    PreloadStaticApi.a().getResPath(str, new SpecifyRedPacketAnimMsg.3(this, localWeakReference, paramOnFrameEndListener, paramBaseChatPie));
  }
  
  public String getFriendUin()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin;
  }
  
  public int getLimitType()
  {
    return 1;
  }
  
  public long getSenderUin()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
      return l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
  
  public long getShmsgseq()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.shmsgseq;
  }
  
  public boolean isReaded()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyRedPacketAnimMsg
 * JD-Core Version:    0.7.0.1
 */