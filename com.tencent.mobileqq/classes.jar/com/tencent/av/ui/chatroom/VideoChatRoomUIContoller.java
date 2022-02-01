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
  private VideoChatRoomContainer a;
  private final AVActivity b;
  private final VideoAppInterface c;
  private final VideoChatRoomUIContoller.ChatRoomMsgObserver d;
  private final VideoChatRoomUIContoller.ChatRoomUIObserver e;
  private ArrayList<ChatRoomMsg> f = new ArrayList(10);
  private ArrayList<VideoChatMessage> g = new ArrayList(10);
  private ArrayList<VideoChatMessage> h = new ArrayList(10);
  private List<VideoChatMessage> i = null;
  private StringBuilder j = null;
  
  public VideoChatRoomUIContoller(AVActivity paramAVActivity, VideoAppInterface paramVideoAppInterface)
  {
    this.b = paramAVActivity;
    this.c = paramVideoAppInterface;
    this.e = new VideoChatRoomUIContoller.ChatRoomUIObserver(this);
    this.d = new VideoChatRoomUIContoller.ChatRoomMsgObserver(this);
    this.c.a(this.e);
    paramAVActivity = this.c.A();
    if (paramAVActivity != null) {
      paramAVActivity.a(this.d);
    }
  }
  
  private void a(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo == null) {
      return;
    }
    this.f.clear();
    Object localObject = this.c.A();
    if (localObject != null) {
      ((ChatRoomMng)localObject).a(paramChatRoomInfo, this.f);
    }
    localObject = this.i;
    paramChatRoomInfo = this.g;
    if (localObject == paramChatRoomInfo)
    {
      paramChatRoomInfo = this.h;
      if (localObject == paramChatRoomInfo) {
        paramChatRoomInfo = null;
      }
    }
    a(this.f, paramChatRoomInfo);
    this.i = paramChatRoomInfo;
    this.b.runOnUiThread(new VideoChatRoomUIContoller.3(this));
  }
  
  private void a(List<ChatRoomMsg> paramList, List<VideoChatMessage> paramList1)
  {
    if (paramList != null)
    {
      if (paramList1 == null) {
        return;
      }
      String str1 = this.c.getCurrentAccountUin();
      paramList1.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatRoomMsg localChatRoomMsg = (ChatRoomMsg)paramList.next();
        if (localChatRoomMsg != null)
        {
          String str2 = String.valueOf(localChatRoomMsg.f);
          VideoChatMessage localVideoChatMessage = VideoChatMessage.e();
          localVideoChatMessage.b(str2);
          localVideoChatMessage.a(localChatRoomMsg.g);
          int k;
          if (TextUtils.equals(str2, str1)) {
            k = 1;
          } else {
            k = 2;
          }
          localVideoChatMessage.a(k);
          localVideoChatMessage.c(String.format("%s|%s", new Object[] { Long.valueOf(localChatRoomMsg.k), Long.valueOf(localChatRoomMsg.h) }));
          paramList1.add(localVideoChatMessage);
        }
      }
    }
  }
  
  private void d(int paramInt)
  {
    SessionInfo localSessionInfo = SessionMgr.a().b();
    if ((!localSessionInfo.cB) && (!localSessionInfo.am) && (!localSessionInfo.r()))
    {
      Object localObject1 = this.b.K;
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = this.a;
      if ((localObject2 != null) && (((VideoChatRoomContainer)localObject2).getVisibility() == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel has already show");
        }
        return;
      }
      if (this.a == null) {
        this.a = h();
      }
      this.a.setVisibility(0);
      f();
      if (paramInt == 2)
      {
        localObject2 = ObjectAnimator.ofFloat(this.a, "TranslationX", new float[] { g(), 0.0F });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 0.0F, 1.0F });
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObject2, localObjectAnimator });
        localAnimatorSet.setDuration(300L);
        localAnimatorSet.start();
      }
      else if (paramInt == 0)
      {
        this.a.setTranslationX(0.0F);
        this.a.setAlpha(1.0F);
      }
      b(((VideoControlUI)localObject1).ae());
      e();
      localObject1 = this.c.A();
      if (localObject1 != null)
      {
        localObject1 = ((ChatRoomMng)localObject1).a(localSessionInfo, true);
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomUtil", 2, String.format("showChatRoomPanelWithAnimation, session[%s], chat_room[%s]", new Object[] { localSessionInfo, localObject1 }));
        }
        a((ChatRoomInfo)localObject1);
      }
      ChatRoomUtil.b("0X800A8D3");
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel can not show when recording.");
    }
  }
  
  private void f()
  {
    if (!this.b.ab.a(1)) {
      this.b.ab.a();
    }
  }
  
  private int g()
  {
    VideoChatRoomContainer localVideoChatRoomContainer = this.a;
    int k = 0;
    if (localVideoChatRoomContainer != null)
    {
      k = localVideoChatRoomContainer.getWidth();
      if (k == 0)
      {
        this.a.measure(0, 0);
        return this.a.getMeasuredWidth();
      }
    }
    return k;
  }
  
  private VideoChatRoomContainer h()
  {
    if (this.a == null)
    {
      ((ViewStub)this.b.findViewById(2131441284)).inflate();
      this.a = ((VideoChatRoomContainer)this.b.findViewById(2131441034));
      this.a.a(this.c);
    }
    return this.a;
  }
  
  public int a()
  {
    if (b()) {
      return this.a.getCurrentPanelHeight();
    }
    return 0;
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
      ChatRoomMng localChatRoomMng = this.c.A();
      if (localChatRoomMng != null)
      {
        ChatRoomInfo localChatRoomInfo = localChatRoomMng.a(SessionMgr.a().b(), true);
        if (localChatRoomInfo != null) {
          localChatRoomMng.a(localChatRoomInfo, paramString, System.currentTimeMillis());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int k = 0;
    if (!paramBoolean) {
      SessionMgr.a().b().cd = b();
    } else {
      SessionMgr.a().b().cd = false;
    }
    Object localObject = this.c.A();
    if (localObject != null) {
      ((ChatRoomMng)localObject).b(this.d);
    }
    this.c.b(this.e);
    localObject = this.a;
    if (localObject != null) {
      localObject = ((VideoChatRoomContainer)localObject).b;
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
      while ((localObject != null) && (k < localObject.length))
      {
        localObject[k] = null;
        k += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VideoChatRoomUIContoller-destroy, isQuit[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], mCheckFirstShowChatRoomPanel[");
      ((StringBuilder)localObject).append(SessionMgr.a().b().cd);
      ((StringBuilder)localObject).append("]");
      QLog.i("ChatRoomUtil", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(int paramInt)
  {
    if (b())
    {
      if (this.b.u() == 4)
      {
        SessionInfo localSessionInfo = null;
        VideoController localVideoController = this.c.b();
        if (localVideoController != null) {
          localSessionInfo = localVideoController.k();
        }
        if ((localSessionInfo != null) && (localSessionInfo.k()) && (localSessionInfo.t()))
        {
          k = this.b.L.L + paramInt + this.b.getResources().getDimensionPixelSize(2131298373);
          break label90;
        }
      }
      int k = paramInt;
      label90:
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatRoomUtil", 4, String.format("updateChatRoomPanel, [%s --> %s], layoutMode[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(this.b.u()) }));
      }
      this.a.a(k);
    }
  }
  
  public boolean b()
  {
    VideoChatRoomContainer localVideoChatRoomContainer = this.a;
    return (localVideoChatRoomContainer != null) && (localVideoChatRoomContainer.getVisibility() == 0);
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
    if (b())
    {
      if (paramInt == 2)
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(300L);
        ((AlphaAnimation)localObject).setAnimationListener(new VideoChatRoomUIContoller.1(this));
        this.a.startAnimation((Animation)localObject);
        return;
      }
      if (paramInt == 1)
      {
        localObject = ObjectAnimator.ofFloat(this.a, "TranslationX", new float[] { 0.0F, g() });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 1.0F, 0.0F });
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator });
        localAnimatorSet.setDuration(300L);
        localAnimatorSet.addListener(new VideoChatRoomUIContoller.2(this));
        localAnimatorSet.start();
        return;
      }
      this.a.setVisibility(8);
    }
  }
  
  public boolean c()
  {
    VideoChatRoomContainer localVideoChatRoomContainer = this.a;
    return (localVideoChatRoomContainer != null) && (localVideoChatRoomContainer.c());
  }
  
  public boolean d()
  {
    if (b()) {
      return this.a.a();
    }
    return false;
  }
  
  public void e()
  {
    if (b()) {
      this.a.a(this.b.L, this.b.u());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller
 * JD-Core Version:    0.7.0.1
 */