package com.tencent.aelight.camera.aioeditor.takevideo.sendpanel;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.StoryMediaEditNotifier;
import com.tencent.aelight.camera.aioeditor.takevideo.StoryMediaEditNotifier.IEditListener;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.ISlidePanelListener;
import com.tencent.mobileqq.widget.SlideBottomPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.Iterator;
import java.util.List;

public class SendPanelPart
  extends EditVideoPart
  implements View.OnClickListener, StoryMediaEditNotifier.IEditListener, IHeaderUpdateListener, IPanelDataListener, ISlidePanelListener
{
  public boolean a = false;
  private View b;
  private SlideBottomPanel c;
  private View d;
  private XListView e;
  private View f;
  private View g;
  private ImageView h;
  private SendPanelAdapter i;
  private Handler j;
  private ObjectAnimator k;
  private boolean l = false;
  private volatile boolean m = false;
  
  public SendPanelPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramInt1, paramInt2);
    this.f.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setDuration(500L);
    this.f.setVisibility(paramInt3);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt1 == 1)
    {
      if ((paramInt2 == 0) || (paramInt2 == 1000) || (paramInt2 == 1004)) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt1 == 4)
    {
      bool1 = bool3;
      if (paramInt2 == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramInt1 == 101)
    {
      bool1 = bool2;
      if (paramInt2 == 3000) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(List<SendPanelItemInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((SendPanelItemInfo)paramList.next()).a();
      }
    }
  }
  
  private void i()
  {
    this.b = ((ViewStub)d(2063991422)).inflate();
    this.c = ((SlideBottomPanel)this.b.findViewById(2131446082));
    this.d = this.b.findViewById(2131431368);
    this.e = ((XListView)this.b.findViewById(2131437272));
    this.f = this.b.findViewById(2131445620);
    this.g = this.b.findViewById(2131429234);
    this.h = ((ImageView)this.b.findViewById(2131447802));
    this.e.addFooterView(l());
    this.i = new SendPanelAdapter(u(), this);
    this.i.a(this);
    this.e.setAdapter(this.i);
    this.c.setSlidePanelListener(this);
    this.f.findViewById(2131445568).setOnClickListener(this);
  }
  
  private void k()
  {
    this.j = new Handler(Looper.getMainLooper());
    SendPanelManager.a().a(this);
    List localList = SendPanelManager.a().b();
    if ((localList != null) && (this.i != null))
    {
      b(localList);
      this.i.a(localList);
    }
    StoryMediaEditNotifier.b().a(this);
  }
  
  private View l()
  {
    View localView = new View(u());
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(130.0F, s())));
    localView.setBackgroundResource(2130852507);
    return localView;
  }
  
  private void m()
  {
    Object localObject = this.f;
    if ((localObject != null) && (((View)localObject).getVisibility() == 8) && (this.c.h()))
    {
      localObject = this.i;
      if ((localObject != null) && (((SendPanelAdapter)localObject).a()))
      {
        this.m = true;
        a(0, 1, 0);
        CaptureReportUtil.b(this.t);
      }
    }
  }
  
  private void n()
  {
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.3F, 0.0F), Keyframe.ofFloat(0.45F, -80.0F), Keyframe.ofFloat(0.65F, 50.0F), Keyframe.ofFloat(0.8F, -30.0F), Keyframe.ofFloat(0.9F, 10.0F), Keyframe.ofFloat(1.0F, 0.0F) });
    this.k = ObjectAnimator.ofPropertyValuesHolder(this.d, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.k.setDuration(1600L);
    this.k.setStartDelay(1000L);
    this.k.setRepeatCount(1);
    this.k.start();
    this.l = true;
  }
  
  public void a()
  {
    super.a();
    i();
    k();
  }
  
  public void a(int paramInt, SendPanelItemInfo paramSendPanelItemInfo)
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      ((SendPanelAdapter)localObject).a(paramInt, paramSendPanelItemInfo);
      localObject = this.e;
      if (localObject != null)
      {
        int n = ((XListView)localObject).getFirstVisiblePosition();
        int i1 = this.e.getLastVisiblePosition();
        if ((paramInt >= n) && (paramInt <= i1))
        {
          localObject = this.e.getChildAt(paramInt - n);
          if ((((View)localObject).getTag() instanceof SendPanelAdapter.SendPanelViewHolder))
          {
            localObject = (SendPanelAdapter.SendPanelViewHolder)((View)localObject).getTag();
            ((SendPanelAdapter.SendPanelViewHolder)localObject).d = paramSendPanelItemInfo;
            this.i.a(paramInt, (SendPanelAdapter.SendPanelViewHolder)localObject);
          }
        }
      }
      if (!this.m) {
        m();
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendPanelPart", 4, "onUpdateIcon uin is empty");
      }
      return;
    }
    List localList = SendPanelManager.a().b();
    int i1;
    int n;
    if ((localList != null) && (localList.size() > 0))
    {
      i1 = localList.size();
      n = 0;
    }
    while (n < i1)
    {
      SendPanelItemInfo localSendPanelItemInfo = (SendPanelItemInfo)localList.get(n);
      if ((!TextUtils.isEmpty(localSendPanelItemInfo.a)) && (localSendPanelItemInfo.a.equals(paramString1)) && (a(paramInt, localSendPanelItemInfo.d)))
      {
        localSendPanelItemInfo.h = paramBitmap;
        localSendPanelItemInfo.g = paramString2;
        paramString1 = this.j;
        if (paramString1 != null) {
          paramString1.post(new SendPanelPart.2(this, n, localSendPanelItemInfo));
        }
      }
      else
      {
        n += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("SendPanelPart", 4, "onUpdateIcon itemInfoList is empty");
        }
      }
    }
  }
  
  public void a(List<SendPanelItemInfo> paramList)
  {
    SendPanelAdapter localSendPanelAdapter = this.i;
    if (localSendPanelAdapter != null) {
      localSendPanelAdapter.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SlideBottomPanel localSlideBottomPanel = this.c;
    if (localSlideBottomPanel != null) {
      if (paramBoolean)
      {
        if (!localSlideBottomPanel.e()) {
          this.c.c();
        }
      }
      else if (localSlideBottomPanel.e()) {
        this.c.d();
      }
    }
  }
  
  public boolean au_()
  {
    return super.au_();
  }
  
  public void b()
  {
    if (this.i != null)
    {
      Handler localHandler = this.j;
      if (localHandler != null)
      {
        localHandler.post(new SendPanelPart.3(this));
        this.m = false;
      }
    }
  }
  
  public void c() {}
  
  public void cancelAnimator()
  {
    if (this.l)
    {
      ObjectAnimator localObjectAnimator = this.k;
      if (localObjectAnimator != null)
      {
        localObjectAnimator.cancel();
        this.l = false;
      }
    }
  }
  
  public void d()
  {
    SendPanelAdapter localSendPanelAdapter = this.i;
    if (localSendPanelAdapter != null) {
      localSendPanelAdapter.c();
    }
  }
  
  public void displayPanel()
  {
    m();
    View localView = this.g;
    if (localView != null) {
      localView.setVisibility(0);
    }
    CaptureReportUtil.d(this.t);
  }
  
  public void displayPanelFinish()
  {
    ImageView localImageView = this.h;
    if (localImageView != null) {
      localImageView.setBackgroundResource(2130851763);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SendPanelPart", 4, "compositeFail");
    }
    Handler localHandler = this.j;
    if (localHandler != null) {
      localHandler.post(new SendPanelPart.1(this));
    }
  }
  
  public void f()
  {
    super.f();
    if (SendPanelManager.a().a)
    {
      SendPanelManager.a().a = false;
      n();
      SendPanelManager.a().a(false);
    }
  }
  
  public void fadeBackground(float paramFloat)
  {
    View localView = this.g;
    if (localView != null)
    {
      localView.setVisibility(0);
      this.g.setAlpha(paramFloat);
    }
  }
  
  public void g()
  {
    SendPanelAdapter localSendPanelAdapter = this.i;
    if (localSendPanelAdapter != null) {
      localSendPanelAdapter.b();
    }
    this.m = false;
    StoryMediaEditNotifier.b().b(this);
    super.g();
  }
  
  public void hidePanel()
  {
    View localView = this.f;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      a(1, 0, 8);
    }
    localView = this.g;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void hidePanelFinish()
  {
    ImageView localImageView = this.h;
    if (localImageView != null) {
      localImageView.setBackgroundResource(2130851762);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131445568) {
      return;
    }
    if (this.t.I.m()) {
      this.a = true;
    }
    this.t.b();
    CaptureReportUtil.a(this.t);
    ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).clearLatestPostMd5();
  }
  
  @NonNull
  public Context u()
  {
    return super.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelPart
 * JD-Core Version:    0.7.0.1
 */