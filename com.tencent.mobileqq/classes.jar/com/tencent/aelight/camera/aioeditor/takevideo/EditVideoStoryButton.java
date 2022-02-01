package com.tencent.aelight.camera.aioeditor.takevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.StaticStickerProviderView;
import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelItemInfo;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

public class EditVideoStoryButton
  extends EditVideoPart
  implements View.OnClickListener
{
  FrameLayout a;
  View b;
  float c;
  boolean d;
  float e = 3.0F;
  int f = -1;
  ProgressPieDrawable g;
  private long h;
  private long i;
  private ProviderView j;
  private DoodleLayout k;
  private ViewGroup l;
  private RelativeLayout m;
  private View n;
  private int o = 0;
  private SendPanelItemInfo p;
  private String q;
  private String r;
  private Dialog s;
  
  public EditVideoStoryButton(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void b(int paramInt)
  {
    int i1 = paramInt;
    if (n()) {
      i1 = (int)(paramInt * 50.0F / 100.0F + 50.0F);
    }
    c(i1);
  }
  
  private void b(String paramString)
  {
    PeakIpcController.a(paramString, new EditVideoStoryButton.2(this));
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    ((ProgressPieDrawable)localObject).b();
    this.g.d(paramInt);
    this.g.b(true);
    this.g.d(false);
    localObject = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("%");
    ((ProgressPieDrawable)localObject).a(localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setProgress] current:");
      ((StringBuilder)localObject).append(this.g.c());
      ((StringBuilder)localObject).append(", progress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("EditVideoStoryButton", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @TargetApi(16)
  private void k()
  {
    d(2063990936).setVisibility(8);
    this.l = ((ViewGroup)d(2063991593));
    this.l.setVisibility(0);
    this.m = ((RelativeLayout)d(2063991595));
    if (LiuHaiUtils.g())
    {
      this.n = d(2063991604);
      this.n.setBackground(null);
    }
    d(2063991598).setOnClickListener(this);
    if ((!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryDefaultShare(this.u.getActivity().getIntent())) && (this.t.I.a == 14)) {
      ((TextView)d(2063991598)).setText(HardCodeUtil.a(2131901883));
    }
    Object localObject = this.u.getActivity().getIntent();
    int i1 = ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).getAEFromType((Intent)localObject);
    if ((((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry((Intent)localObject)) || (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromMiniApp((Intent)localObject)) || (i1 == AECameraEntry.n.a()) || (i1 == AECameraEntry.g.a()) || (i1 == AECameraEntry.q.a()) || (i1 == AECameraEntry.r.a()) || (i1 == AECameraEntry.o.a()) || (i1 == AECameraEntry.s.a()) || (i1 == AECameraEntry.v.a())) {
      ((TextView)d(2063991598)).setText(u().getText(2064187698));
    }
    if ((!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto((Intent)localObject, this.t.I.h())) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(this.u.getActivity().getIntent())))
    {
      d(2063991602).setOnClickListener(this);
      d(2063991603).setOnClickListener(this);
    }
    else
    {
      d(2063991607).setVisibility(8);
      d(2063991602).setVisibility(8);
      d(2063991603).setVisibility(8);
    }
    if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_from_pic_choose", false))) {
      ((TextView)d(2063991507)).setText(2064187669);
    }
    d(2063991597).setOnClickListener(this);
    this.a = ((FrameLayout)d(2063991600));
    this.b = d(2063991596);
    if (this.t.Z != null)
    {
      i1 = this.t.Z.getHeight();
      localObject = this.a.getLayoutParams();
      if (i1 <= 0) {
        ((ViewGroup.LayoutParams)localObject).height += LiuHaiUtils.j;
      } else {
        ((ViewGroup.LayoutParams)localObject).height += i1;
      }
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.b.getLayoutParams();
      if (i1 <= 0) {
        ((ViewGroup.LayoutParams)localObject).height += LiuHaiUtils.j;
      } else {
        ((ViewGroup.LayoutParams)localObject).height += i1;
      }
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((VideoUtils.b()) && (ScreenUtil.getRealHeight(u()) / ScreenUtil.getRealWidth(u()) >= 2.0F) && (LiuHaiUtils.b))
    {
      localObject = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).topMargin + LiuHaiUtils.e((Activity)u()), ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
      this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.t.k()) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    VSReporter.a("mystatus_edit", "edit_exp", 0, 0, new String[] { localObject });
    if (this.t.j())
    {
      CaptureReportUtil.f(this.t);
      return;
    }
    CaptureReportUtil.h(this.t);
  }
  
  private void l()
  {
    if (this.j == null)
    {
      this.j = new StaticStickerProviderView(u());
      this.j.setTabBarPosition(1);
      this.a.addView(this.j);
    }
    ProviderView localProviderView = this.j;
    if (localProviderView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditVideoStoryButton", 2, "build provider view failed ");
      }
      return;
    }
    if (!localProviderView.l())
    {
      if (this.t.Z != null)
      {
        int i3 = this.j.getContentHeight();
        int i2 = this.t.Z.getHeight();
        int i1 = i2;
        if (i2 <= 0) {
          i1 = LiuHaiUtils.j;
        }
        i1 = (int)UIUtils.c(u(), i1);
        this.j.d(i3 + i1);
      }
      this.j.a(m());
    }
    this.j.setVisibility(0);
    this.j.c();
    this.a.setVisibility(0);
    this.b.setVisibility(0);
  }
  
  private Bundle m()
  {
    if (this.t.ad != null) {
      return this.t.ad.getBundle("container");
    }
    return null;
  }
  
  private boolean n()
  {
    EditVideoParams localEditVideoParams = this.t.I;
    boolean bool2 = false;
    int i1;
    if (localEditVideoParams.a("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.q))
    {
      bool1 = bool2;
      if (i1 == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void o()
  {
    ShortVideoForwardManager.a(this.u.getActivity(), 21, "baseView", "{\n  \"data\": {\n    \"puin\": \"892820726\",\n    \"nick\": \"我五岁了哦！\",\n    \"id\": \"xx\",\n    \"avatarJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenmainpage%3Fuin%3D892820726%26issinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"contentJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopendetail%3Ffeedid%3DB_193ead5f48eb06008928207260X5c%26sourcetype%3D10%26createtime%3D1605189145%26uin%3D892820726%26shareuin%3D1715054455%26issinglefeed%3D1%26from%3D6%26is_feed_detail%3D1%26sharecategory%3D2%26shareentrance%3D1\",\n    \"iconJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenfolder%3Fissinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"media\": [\n      {\n        \"isVideo\": true,\n        \"videoDuration\": 6153,\n        \"height\": 1080,\n        \"width\": 612,\n        \"url\": \"https://photogz.photo.store.qq.com/psc?/V54acxHN3cWMMd1uSEP42tVDpt3rbFDX/bqQfVz5yrrGYSXMvKr.cqfwp.5mjtGNPmLXd7x240uDFGDWpqsTaAx9IH1rzBk4C2oJi9NLpvQo.nrHoAHTVX6w0vBQPm2u1D8U5owjcQfc!/b&ek=1&kp=1&pt=0&bo=ZAI4BGQCOAQRECc!&tl=1&lsr=6&vuin=1715054455&tm=1607943600#sce=79-11-1&rf=v1_and_sq_8.5.0_0_rdm_b_t_-2-0-31\"\n      }\n    ],\n    \"total\": 1,\n    \"title\": \"分享了来自小世界的作品\",\n    \"type\": 2,\n    \"isAIO\": 1,\n    \"appName\": \"qcircle\",\n    \"fuelNum\": 57393,\n    \"likeNum\": 41463\n  }\n}");
  }
  
  private ProgressPieDrawable p()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(u());
    localProgressPieDrawable.a(AIOUtils.b(50.0F, s()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.h(-1);
    localProgressPieDrawable.g(0);
    localProgressPieDrawable.e(-15550475);
    localProgressPieDrawable.j(3);
    localProgressPieDrawable.D = true;
    localProgressPieDrawable.A = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new EditVideoStoryButton.5(this));
    return localProgressPieDrawable;
  }
  
  public void a()
  {
    super.a();
    this.q = this.u.getActivity().getIntent().getStringExtra("KEY_SEND_ARK_MSG_ID");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate--arkViewId=");
    localStringBuilder.append(this.q);
    AEQLog.b("EditVideoStoryButton", localStringBuilder.toString());
    k();
  }
  
  public void a(int paramInt)
  {
    int i1 = paramInt;
    if (n()) {
      i1 = (int)(paramInt * 50.0F / 100.0F);
    }
    c(i1);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 21)
    {
      if (paramInt1 != 211) {
        return;
      }
      if (paramIntent != null)
      {
        localObject = this.r;
        if ((localObject == null) || (!((String)localObject).equals(paramIntent.getStringExtra("fakeId")))) {
          return;
        }
      }
      boolean bool;
      if (this.o == 20) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject = this.p;
      this.t.d(0);
      this.d = true;
      if (paramInt2 == -1)
      {
        a(100);
        ThreadManager.excute(new EditVideoStoryButton.1(this, paramIntent, bool, (SendPanelItemInfo)localObject), 64, null, true);
        return;
      }
      if (paramInt2 == 1)
      {
        i();
        if (n())
        {
          this.t.v();
          return;
        }
        localObject = new StringBuilder(HardCodeUtil.a(2131901941));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null))
        {
          ((StringBuilder)localObject).append(": ");
          ((StringBuilder)localObject).append(paramIntent.getStringExtra("error"));
        }
        QQToast.makeText(this.u.getContext(), 1, (CharSequence)localObject, 0).show();
        return;
      }
      if (paramInt2 == 0) {
        i();
      }
    }
    else if (paramInt2 == -1)
    {
      this.t.H.finish(paramInt2, paramIntent, 2130772081, 0);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    if (paramInt2 != 0)
    {
      if (paramInt2 != 3)
      {
        if (paramInt2 != 6)
        {
          if (paramInt2 != 20)
          {
            c();
            return;
          }
          this.o = paramInt2;
          if ((paramObject instanceof SendPanelItemInfo)) {
            this.p = ((SendPanelItemInfo)paramObject);
          }
        }
        else
        {
          a(false, false);
        }
      }
      else {
        l();
      }
    }
    else
    {
      if (paramInt1 == 6) {
        a(true, true, false);
      } else {
        a(true, false);
      }
      c();
      this.o = paramInt2;
      this.p = null;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.c = paramInt;
    this.d = false;
    this.e = (50000.0F / (float)paramLong);
    if (this.e == 0.0F) {
      this.e = 1.0F;
    }
    d();
  }
  
  public void a(String paramString)
  {
    this.r = paramString;
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.s == null)
    {
      this.s = new Dialog(u());
      Object localObject = this.s.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.s.requestWindowFeature(1);
      this.s.setContentView(2131628207);
      localObject = (ImageView)this.s.findViewById(2131440726);
      this.g = p();
      ((ImageView)localObject).setImageDrawable(this.g);
    }
    ((TextView)this.s.findViewById(2131438908)).setText(paramString);
    this.s.setCancelable(paramBoolean);
    this.s.setCanceledOnTouchOutside(paramBoolean);
    this.g.d(0);
    t().getRootView().postDelayed(new EditVideoStoryButton.3(this), paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      this.v = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.v += 500L;
      }
      if (paramBoolean1) {
        TakeVideoUtils.a(this.l, paramBoolean3);
      } else {
        TakeVideoUtils.a(this.l);
      }
    }
    else
    {
      this.l.setAnimation(null);
      ViewGroup localViewGroup = this.l;
      int i1;
      if (paramBoolean1) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localViewGroup.setVisibility(i1);
      this.v = 0L;
    }
    this.t.a(Message.obtain(null, 11, Long.valueOf(this.v)));
  }
  
  public boolean au_()
  {
    return System.currentTimeMillis() < this.v;
  }
  
  public void c()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  void d()
  {
    if (this.u == null) {
      return;
    }
    this.u.getRootView().postDelayed(new EditVideoStoryButton.4(this), 1000L);
  }
  
  public void g()
  {
    i();
    super.g();
  }
  
  public void i()
  {
    Dialog localDialog = this.s;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (Math.abs(SystemClock.uptimeMillis() - this.h) > 500L)
    {
      this.h = SystemClock.uptimeMillis();
      int i1 = paramView.getId();
      if (this.v > System.currentTimeMillis())
      {
        SLog.d("EditVideoStoryButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.v), Long.valueOf(System.currentTimeMillis()) });
        return;
      }
      this.t.C();
      if ((this.t.O != null) && (this.k == null))
      {
        this.k = this.t.O.b();
        this.k.setEditMode(false);
        if ((this.t.I.e()) && (this.t.X() != null) && (!this.t.X().getTakePicToVideo())) {
          this.k.setEditMode(true);
        }
      }
      switch (i1)
      {
      case 2063991599: 
      case 2063991600: 
      case 2063991601: 
      default: 
        return;
      case 2063991603: 
        if (this.t.c(2))
        {
          this.t.d(0);
          return;
        }
        this.t.F();
        VSReporter.a("mystatus_edit", "word_entry_clk", 0, 0, new String[0]);
        return;
      case 2063991602: 
        if (this.t.c(3))
        {
          this.t.d(0);
          return;
        }
        this.t.d(3);
        VSReporter.a("mystatus_edit", "sticker_entry_clk", 0, 0, new String[0]);
        return;
      case 2063991598: 
        AEQLog.b("EditVideoStoryButton", "【Click】+ video_story_control_publish");
        long l1 = SystemClock.uptimeMillis();
        if (l1 - this.i >= 800L)
        {
          if (this.u.getActivity().isFinishing()) {
            return;
          }
          this.i = l1;
          QLog.i("[vs_publish_flow] ", 1, "on vs publish button click");
          ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
          this.t.i();
          ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportPostBtn();
          ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).clearLatestPostMd5();
          if (this.t.j())
          {
            CaptureReportUtil.e(this.t);
            return;
          }
          CaptureReportUtil.g(this.t);
          return;
        }
        return;
      }
      this.t.b();
      return;
    }
    SLog.d("EditVideoStoryButton", "you click button too fast, ignore it !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton
 * JD-Core Version:    0.7.0.1
 */