package com.tencent.av.ui.chatroom;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.chatroom.ChatRoomMsg;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoChatRoomUIContoller
{
  private final VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private final AVActivity jdField_a_of_type_ComTencentAvUiAVActivity;
  private VideoChatRoomContainer jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
  private final VideoChatRoomUIContoller.ChatRoomMsgObserver jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller$ChatRoomMsgObserver;
  private final VideoChatRoomUIContoller.ChatRoomUIObserver jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller$ChatRoomUIObserver;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = null;
  private ArrayList<ChatRoomMsg> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private List<VideoChatMessage> jdField_a_of_type_JavaUtilList = null;
  private ArrayList<VideoChatMessage> b = new ArrayList(10);
  private ArrayList<VideoChatMessage> c = new ArrayList(10);
  
  public VideoChatRoomUIContoller(AVActivity paramAVActivity, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller$ChatRoomUIObserver = new VideoChatRoomUIContoller.ChatRoomUIObserver(this);
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller$ChatRoomMsgObserver = new VideoChatRoomUIContoller.ChatRoomMsgObserver(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller$ChatRoomUIObserver);
    paramAVActivity = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (paramAVActivity != null) {
      paramAVActivity.a(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller$ChatRoomMsgObserver);
    }
  }
  
  private VideoChatRoomContainer a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null)
    {
      ((ViewStub)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131373618)).inflate();
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer = ((VideoChatRoomContainer)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131373361));
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    return this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
  }
  
  private void a(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject != null) {
      ((ChatRoomMng)localObject).a(paramChatRoomInfo, this.jdField_a_of_type_JavaUtilArrayList);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    paramChatRoomInfo = this.b;
    if (localObject == paramChatRoomInfo)
    {
      paramChatRoomInfo = this.c;
      if (localObject == paramChatRoomInfo) {
        paramChatRoomInfo = null;
      }
    }
    a(this.jdField_a_of_type_JavaUtilArrayList, paramChatRoomInfo);
    this.jdField_a_of_type_JavaUtilList = paramChatRoomInfo;
    this.jdField_a_of_type_ComTencentAvUiAVActivity.runOnUiThread(new VideoChatRoomUIContoller.3(this));
  }
  
  private void a(List<ChatRoomMsg> paramList, List<VideoChatMessage> paramList1)
  {
    if (paramList != null)
    {
      if (paramList1 == null) {
        return;
      }
      String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      paramList1.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatRoomMsg localChatRoomMsg = (ChatRoomMsg)paramList.next();
        if (localChatRoomMsg != null)
        {
          String str2 = String.valueOf(localChatRoomMsg.jdField_a_of_type_Long);
          VideoChatMessage localVideoChatMessage = VideoChatMessage.a();
          localVideoChatMessage.b(str2);
          localVideoChatMessage.a(localChatRoomMsg.jdField_a_of_type_JavaLangString);
          int i;
          if (TextUtils.equals(str2, str1)) {
            i = 1;
          } else {
            i = 2;
          }
          localVideoChatMessage.a(i);
          localVideoChatMessage.c(String.format("%s|%s", new Object[] { Long.valueOf(localChatRoomMsg.d), Long.valueOf(localChatRoomMsg.b) }));
          paramList1.add(localVideoChatMessage);
        }
      }
    }
  }
  
  private int b()
  {
    VideoChatRoomContainer localVideoChatRoomContainer = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
    int i = 0;
    if (localVideoChatRoomContainer != null)
    {
      i = localVideoChatRoomContainer.getWidth();
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.measure(0, 0);
        return this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getMeasuredWidth();
      }
    }
    return i;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(1)) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a();
    }
  }
  
  private void d(int paramInt)
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if ((!localSessionInfo.az) && (!localSessionInfo.y) && (!localSessionInfo.r()))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI;
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
      if ((localObject2 != null) && (((VideoChatRoomContainer)localObject2).getVisibility() == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel has already show");
        }
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null) {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer = a();
      }
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setVisibility(0);
      b();
      if (paramInt == 2)
      {
        localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "TranslationX", new float[] { b(), 0.0F });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "alpha", new float[] { 0.0F, 1.0F });
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObject2, localObjectAnimator });
        localAnimatorSet.setDuration(300L);
        localAnimatorSet.start();
      }
      else if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setTranslationX(0.0F);
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setAlpha(1.0F);
      }
      b(((VideoControlUI)localObject1).c());
      a();
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject1 != null)
      {
        localObject1 = ((ChatRoomMng)localObject1).a(localSessionInfo, true);
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomUtil", 2, String.format("showChatRoomPanelWithAnimation, session[%s], chat_room[%s]", new Object[] { localSessionInfo, localObject1 }));
        }
        a((ChatRoomInfo)localObject1);
      }
      ChatRoomUtil.a("0X800A8D3");
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel can not show when recording.");
    }
  }
  
  public int a()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a();
    }
    return 0;
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI, this.jdField_a_of_type_ComTencentAvUiAVActivity.c());
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showChatRoomPanel, which[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("VideoChatRoomUIContoller", 4, localStringBuilder.toString());
    }
    d(paramInt);
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return;
      }
      ChatRoomMng localChatRoomMng = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localChatRoomMng != null)
      {
        ChatRoomInfo localChatRoomInfo = localChatRoomMng.a(SessionMgr.a().a(), true);
        if (localChatRoomInfo != null) {
          localChatRoomMng.a(localChatRoomInfo, paramString, System.currentTimeMillis());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    if (!paramBoolean) {
      SessionMgr.a().a().at = a();
    } else {
      SessionMgr.a().a().at = false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject != null) {
      ((ChatRoomMng)localObject).b(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller$ChatRoomMsgObserver);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller$ChatRoomUIObserver);
    localObject = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
    if (localObject != null) {
      localObject = ((VideoChatRoomContainer)localObject).a;
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = ((EditText)localObject).getText();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((Editable)localObject).getFilters();
      }
      while ((localObject != null) && (i < localObject.length))
      {
        localObject[i] = null;
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VideoChatRoomUIContoller-destroy, isQuit[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], mCheckFirstShowChatRoomPanel[");
      ((StringBuilder)localObject).append(SessionMgr.a().a().at);
      ((StringBuilder)localObject).append("]");
      QLog.i("ChatRoomUtil", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a()
  {
    VideoChatRoomContainer localVideoChatRoomContainer = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
    return (localVideoChatRoomContainer != null) && (localVideoChatRoomContainer.getVisibility() == 0);
  }
  
  public void b(int paramInt)
  {
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.c() == 4)
      {
        SessionInfo localSessionInfo = null;
        VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (localVideoController != null) {
          localSessionInfo = localVideoController.a();
        }
        if ((localSessionInfo != null) && (localSessionInfo.k()) && (localSessionInfo.t()))
        {
          i = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.m + paramInt + this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getDimensionPixelSize(2131297708);
          break label90;
        }
      }
      int i = paramInt;
      label90:
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatRoomUtil", 4, String.format("updateChatRoomPanel, [%s --> %s], layoutMode[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_ComTencentAvUiAVActivity.c()) }));
      }
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a(i);
    }
  }
  
  public boolean b()
  {
    VideoChatRoomContainer localVideoChatRoomContainer = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
    return (localVideoChatRoomContainer != null) && (localVideoChatRoomContainer.c());
  }
  
  public void c(int paramInt)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideChatRoomPanel, from[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("ChatRoomUtil", 4, ((StringBuilder)localObject).toString());
    }
    if (a())
    {
      if (paramInt == 2)
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(300L);
        ((AlphaAnimation)localObject).setAnimationListener(new VideoChatRoomUIContoller.1(this));
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.startAnimation((Animation)localObject);
        return;
      }
      if (paramInt == 1)
      {
        localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "TranslationX", new float[] { 0.0F, b() });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "alpha", new float[] { 1.0F, 0.0F });
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator });
        localAnimatorSet.setDuration(300L);
        localAnimatorSet.addListener(new VideoChatRoomUIContoller.2(this));
        localAnimatorSet.start();
        return;
      }
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setVisibility(8);
    }
  }
  
  public boolean c()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller
 * JD-Core Version:    0.7.0.1
 */