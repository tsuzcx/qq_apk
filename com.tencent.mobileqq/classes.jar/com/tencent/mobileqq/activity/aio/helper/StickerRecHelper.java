package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.Editable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecMvvmCreator;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecViewBinder;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecViewModel;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.data.LayoutStatusLiveData;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.os.MqqHandler;

public class StickerRecHelper
  implements Handler.Callback, ILifeCycleHelper
{
  private QQAppInterface a;
  private BaseActivity b;
  private BaseChatPie c;
  private SessionInfo d;
  private MqqHandler e;
  private IStickerRecViewModel f;
  private IStickerRecViewBinder g;
  private long h;
  
  public StickerRecHelper(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.a = paramBaseChatPie.d;
    this.b = paramBaseChatPie.f;
    this.d = paramBaseChatPie.ah;
    this.e = paramBaseChatPie.j();
    paramBaseChatPie.bv().d().a(this);
    e();
  }
  
  private void e()
  {
    LifeCycleAndViewModelStoreOwner localLifeCycleAndViewModelStoreOwner = LifeCycleFragment.a(this.b);
    this.f = ((IStickerRecMvvmCreator)QRoute.api(IStickerRecMvvmCreator.class)).createViewModel(localLifeCycleAndViewModelStoreOwner);
    this.g = ((IStickerRecMvvmCreator)QRoute.api(IStickerRecMvvmCreator.class)).createViewBinder(this.a, this.c.aX(), this.c.bv(), this.f);
    this.f.a(this.a);
    this.f.a(new LayoutStatusLiveData());
    this.g.a(localLifeCycleAndViewModelStoreOwner);
  }
  
  public void a()
  {
    this.c.j().removeMessages(67);
    b();
    a(true);
    a(12);
  }
  
  void a(int paramInt)
  {
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.c.q(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.d(paramInt);
    }
  }
  
  public void a(Editable paramEditable)
  {
    String str = ((SpecWordEmotionThinkHelper)this.c.q(41)).d();
    boolean bool = this.f.a(paramEditable, str);
    long l = System.currentTimeMillis() - this.h - 3000L;
    if (!bool)
    {
      if (l > 0L)
      {
        a();
        return;
      }
      this.e.sendEmptyMessageDelayed(67, -l);
    }
  }
  
  void a(boolean paramBoolean)
  {
    IApolloAIOHelper localIApolloAIOHelper = (IApolloAIOHelper)this.c.q(8);
    if (localIApolloAIOHelper != null) {
      localIApolloAIOHelper.showApolloView(paramBoolean);
    }
  }
  
  public void b()
  {
    this.f.a(new LayoutStatusLiveData(2));
  }
  
  public void b(Editable paramEditable)
  {
    if (paramEditable.length() == 0) {
      a();
    }
  }
  
  public boolean c()
  {
    return this.f.a();
  }
  
  public void d()
  {
    if (this.c == null) {
      return;
    }
    b();
    a(true);
    a(12);
  }
  
  public String getTag()
  {
    return getClass().getName();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    BaseChatPie localBaseChatPie = this.c;
    int i = paramMessage.what;
    if (i != 67)
    {
      if (i != 69)
      {
        if (i != 92) {
          return false;
        }
        this.f.a(new LayoutStatusLiveData(2));
        if (localBaseChatPie != null) {
          localBaseChatPie.j().removeMessages(67);
        }
        a(true);
        a(12);
        return true;
      }
      String str = null;
      if ((paramMessage.obj instanceof String)) {
        str = (String)paramMessage.obj;
      }
      paramMessage = new LayoutStatusLiveData(1);
      paramMessage.b = str;
      this.f.a(paramMessage);
      if (localBaseChatPie != null)
      {
        a(false);
        paramMessage = (IDoutuService)this.a.getRuntimeService(IDoutuService.class, "");
        if (paramMessage != null) {
          paramMessage.hideDoutuEmotionLayout();
        }
        a(11);
        EmojiStickerManager.a().c(localBaseChatPie);
        localBaseChatPie.j().removeMessages(67);
        localBaseChatPie.j().sendEmptyMessageDelayed(67, 6000L);
        this.h = System.currentTimeMillis();
      }
      return true;
    }
    this.c.j().removeMessages(67);
    this.f.a(new LayoutStatusLiveData(3));
    this.f.b(true);
    a(true);
    a(12);
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 9, 10, 7, 6 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 6)
    {
      if (paramInt != 7)
      {
        if (paramInt != 9)
        {
          if (paramInt != 10)
          {
            if (paramInt != 15) {
              return;
            }
            this.f.a(new LayoutStatusLiveData(3));
            this.f.a(false);
            return;
          }
          BaseChatPie localBaseChatPie = this.c;
          if ((localBaseChatPie != null) && (localBaseChatPie.aY())) {
            this.g.a(this.c.aW(), this.c.bl(), this.c.Y);
          }
        }
        else
        {
          this.f.a(this.d);
        }
      }
      else {
        this.f.a(true);
      }
    }
    else {
      this.f.a(new LayoutStatusLiveData(4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StickerRecHelper
 * JD-Core Version:    0.7.0.1
 */