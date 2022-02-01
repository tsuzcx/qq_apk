package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.paiyipai.PaiYiPaiHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class AvatarOnGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private AvatarGestureDetector a;
  
  private void a(VasAvatar paramVasAvatar, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    new DoubleTapEffect(paramVasAvatar).a();
    ((PaiYiPaiHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PAI_YI_PAI_HANDLER)).a(paramChatMessage.senderuin, paramChatMessage.frienduin, paramChatMessage.istroop);
    int i;
    if (paramChatMessage.istroop == 0) {
      i = 1;
    } else if (paramChatMessage.istroop == 1) {
      i = 2;
    } else {
      i = 10;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B3A1", "0X800B3A1", i, 0, "", "", "", "");
  }
  
  public void a(AvatarGestureDetector paramAvatarGestureDetector)
  {
    this.a = paramAvatarGestureDetector;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDoubleTap() called with: e = [");
      ((StringBuilder)localObject1).append(paramMotionEvent);
      ((StringBuilder)localObject1).append("]");
      QLog.d("AvatarOnGestureListener", 2, ((StringBuilder)localObject1).toString());
    }
    this.a.setIsLongpressEnabled(false);
    Object localObject2 = this.a.a();
    Object localObject1 = (ChatMessage)((VasAvatar)localObject2).getTag();
    QQAppInterface localQQAppInterface = BaseActivity.sTopActivity.app;
    if ((((VasAvatar)localObject2).getContext() instanceof MultiForwardActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() MultiForwardActivity");
      }
      return super.onDoubleTap(paramMotionEvent);
    }
    if (!NetworkUtil.isNetSupport(((VasAvatar)localObject2).getContext()))
    {
      QQToast.a(((VasAvatar)localObject2).getContext(), HardCodeUtil.a(2131714684), 0).a();
      return super.onDoubleTap(paramMotionEvent);
    }
    if (((ChatMessage)localObject1).istroop == 0)
    {
      a((VasAvatar)localObject2, (ChatMessage)localObject1, localQQAppInterface);
    }
    else if (((ChatMessage)localObject1).istroop == 1)
    {
      if (((TroopGagMgr)localQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(((ChatMessage)localObject1).frienduin, true).a)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() DisableSendMsg");
        }
        return super.onDoubleTap(paramMotionEvent);
      }
      if ((!AnonymousChatHelper.a((MessageRecord)localObject1)) && (!AnonymousChatHelper.a().a(((ChatMessage)localObject1).frienduin)))
      {
        if (localQQAppInterface.getTroopMask(((ChatMessage)localObject1).frienduin) == 3)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() MSG_FILTER_CLOSE");
          }
          return super.onDoubleTap(paramMotionEvent);
        }
        TroopManager localTroopManager = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        TroopInfo localTroopInfo = localTroopManager.a(((ChatMessage)localObject1).frienduin, true);
        if (localTroopInfo != null)
        {
          if (localTroopInfo.isDisband())
          {
            QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694689, 0).a();
            if (QLog.isColorLevel()) {
              QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() isDisband");
            }
            return super.onDoubleTap(paramMotionEvent);
          }
          localObject2 = new AvatarOnGestureListener.TroopMemberInfoCallBack((VasAvatar)localObject2, (ChatMessage)localObject1, localQQAppInterface, this);
          localTroopManager.a(((ChatMessage)localObject1).frienduin, ((ChatMessage)localObject1).senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject2);
          return super.onDoubleTap(paramMotionEvent);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarOnGestureListener", 2, "onDoubleTap() AioAnonymous");
        }
        return super.onDoubleTap(paramMotionEvent);
      }
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    super.onLongPress(paramMotionEvent);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLongPress() called with: e = [");
      localStringBuilder.append(paramMotionEvent);
      localStringBuilder.append("]");
      QLog.d("AvatarOnGestureListener", 2, localStringBuilder.toString());
    }
    paramMotionEvent = this.a.a();
    if (paramMotionEvent.a()) {
      paramMotionEvent.performLongClick();
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSingleTapConfirmed() called with: e = [");
      ((StringBuilder)localObject).append(paramMotionEvent);
      ((StringBuilder)localObject).append("]");
      QLog.d("AvatarOnGestureListener", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.a();
    if (((VasAvatar)localObject).hasOnClickListeners()) {
      ((VasAvatar)localObject).performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.AvatarOnGestureListener
 * JD-Core Version:    0.7.0.1
 */