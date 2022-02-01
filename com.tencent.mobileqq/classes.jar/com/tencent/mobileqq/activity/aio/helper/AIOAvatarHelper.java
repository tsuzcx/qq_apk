package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class AIOAvatarHelper
  implements ILifeCycleHelper, AbsListView.OnScrollListener
{
  private QQAppInterface a;
  private Context b;
  private BaseChatPie c;
  private SessionInfo d;
  private AvatarObserver e = new AIOAvatarHelper.1(this);
  
  public AIOAvatarHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie.d;
    this.b = paramBaseChatPie.e;
    this.c = paramBaseChatPie;
    this.d = paramBaseChatPie.ah;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOAvatarHelper", 2, "doOnCreate");
    }
    this.a.addObserver(this.e);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOAvatarHelper", 2, "doOnDestroy");
    }
    this.a.removeObserver(this.e);
  }
  
  @NonNull
  public String getTag()
  {
    return "AIOAvatarHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 4 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      b();
      return;
    }
    a();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    ((VasExtensionManager)this.a.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).c.a(this.c.U, this.c.V, paramInt);
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      AbstractVideoImage.resumeAll();
      ApngImage.playByTag(0);
      VasFaceManager.b();
      ShortVideoItemBuilder.i();
      ShortVideoRealItemBuilder.i();
      this.c.bv().h().e();
      AvatarPendantUtil.a(this.a);
      ((AvatarPendantManager)this.a.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).b();
      BubbleDiyFetcher.a().a(this.a, 0);
      DiyPendantFetcher.a().a(this.a, 0);
      return;
    }
    VasFaceManager.a();
    if (!PicItemBuilder.C)
    {
      AbstractGifImage.pauseAll();
      ApngImage.pauseAll();
    }
    AbstractVideoImage.pauseAll();
    ShortVideoItemBuilder.h();
    ShortVideoRealItemBuilder.h();
    this.c.bv().h().d();
    if (paramInt == 1) {
      this.c.i(false);
    }
    ((AvatarPendantManager)this.a.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOAvatarHelper
 * JD-Core Version:    0.7.0.1
 */