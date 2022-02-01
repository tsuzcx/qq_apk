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
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ProviderView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
  private DoodleLayout jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
  private SendPanelItemInfo jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo;
  ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float = 3.0F;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private long c;
  
  public EditVideoStoryButton(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private Bundle a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null) {
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return null;
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(a());
    localProgressPieDrawable.a(AIOUtils.b(50.0F, a()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new EditVideoStoryButton.5(this));
    return localProgressPieDrawable;
  }
  
  private void b(int paramInt)
  {
    int i = paramInt;
    if (b()) {
      i = (int)(paramInt * 50.0F / 100.0F + 50.0F);
    }
    c(i);
  }
  
  private void b(String paramString)
  {
    PeakIpcController.a(paramString, new EditVideoStoryButton.2(this));
  }
  
  private boolean b()
  {
    EditVideoParams localEditVideoParams = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams;
    boolean bool2 = false;
    int i;
    if (localEditVideoParams.a("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    if (localObject == null) {
      return;
    }
    ((ProgressPieDrawable)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("%");
    ((ProgressPieDrawable)localObject).a(localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setProgress] current:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a());
      ((StringBuilder)localObject).append(", progress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("EditVideoStoryButton", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  @TargetApi(16)
  private void j()
  {
    a(2064122005).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2064122819));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2064122821));
    if (LiuHaiUtils.f())
    {
      this.jdField_b_of_type_AndroidViewView = a(2064122830);
      this.jdField_b_of_type_AndroidViewView.setBackground(null);
    }
    a(2064122824).setOnClickListener(this);
    if ((!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryDefaultShare(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent())) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 14)) {
      ((TextView)a(2064122824)).setText(HardCodeUtil.a(2131703951));
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent();
    int i = ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).getAEFromType((Intent)localObject);
    if ((((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry((Intent)localObject)) || (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromMiniApp((Intent)localObject)) || (i == AECameraEntry.n.a()) || (i == AECameraEntry.g.a()) || (i == AECameraEntry.q.a()) || (i == AECameraEntry.r.a()) || (i == AECameraEntry.o.a()) || (i == AECameraEntry.s.a()) || (i == AECameraEntry.v.a())) {
      ((TextView)a(2064122824)).setText(a().getText(2064515411));
    }
    if ((!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto((Intent)localObject, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a())) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent())))
    {
      a(2064122828).setOnClickListener(this);
      a(2064122829).setOnClickListener(this);
    }
    else
    {
      a(2064122833).setVisibility(8);
      a(2064122828).setVisibility(8);
      a(2064122829).setVisibility(8);
    }
    if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_from_pic_choose", false))) {
      ((TextView)a(2064122735)).setText(2064515383);
    }
    a(2064122823).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2064122826));
    this.jdField_a_of_type_AndroidViewView = a(2064122822);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (i <= 0) {
        ((ViewGroup.LayoutParams)localObject).height += LiuHaiUtils.e;
      } else {
        ((ViewGroup.LayoutParams)localObject).height += i;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (i <= 0) {
        ((ViewGroup.LayoutParams)localObject).height += LiuHaiUtils.e;
      } else {
        ((ViewGroup.LayoutParams)localObject).height += i;
      }
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((VideoUtils.b()) && (ScreenUtil.getRealHeight(a()) / ScreenUtil.getRealWidth(a()) >= 2.0F) && (LiuHaiUtils.jdField_a_of_type_Boolean))
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).topMargin + LiuHaiUtils.b((Activity)a()), ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.d()) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    VSReporter.a("mystatus_edit", "edit_exp", 0, 0, new String[] { localObject });
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c())
    {
      CaptureReportUtil.f(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager);
      return;
    }
    CaptureReportUtil.h(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView = new StaticStickerProviderView(a());
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setTabBarPosition(1);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView);
    }
    ProviderView localProviderView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
    if (localProviderView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditVideoStoryButton", 2, "build provider view failed ");
      }
      return;
    }
    if (!localProviderView.d())
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        int k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.c();
        int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        int i = j;
        if (j <= 0) {
          i = LiuHaiUtils.e;
        }
        i = (int)UIUtils.a(a(), i);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.d(k + i);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.a(a());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setVisibility(0);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.c();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void l()
  {
    ShortVideoForwardManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity(), 21, "baseView", "{\n  \"data\": {\n    \"puin\": \"892820726\",\n    \"nick\": \"我五岁了哦！\",\n    \"id\": \"xx\",\n    \"avatarJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenmainpage%3Fuin%3D892820726%26issinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"contentJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopendetail%3Ffeedid%3DB_193ead5f48eb06008928207260X5c%26sourcetype%3D10%26createtime%3D1605189145%26uin%3D892820726%26shareuin%3D1715054455%26issinglefeed%3D1%26from%3D6%26is_feed_detail%3D1%26sharecategory%3D2%26shareentrance%3D1\",\n    \"iconJumpUrl\": \"https://h5.qzone.qq.com/v2/wezone/jump?_wv=3&_proxy=1&schema=mqqapi%3A%2F%2Fqcircle%2Fopenfolder%3Fissinglefeed%3D1%26from%3D6%26sharecategory%3D2%26shareentrance%3D1\",\n    \"media\": [\n      {\n        \"isVideo\": true,\n        \"videoDuration\": 6153,\n        \"height\": 1080,\n        \"width\": 612,\n        \"url\": \"https://photogz.photo.store.qq.com/psc?/V54acxHN3cWMMd1uSEP42tVDpt3rbFDX/bqQfVz5yrrGYSXMvKr.cqfwp.5mjtGNPmLXd7x240uDFGDWpqsTaAx9IH1rzBk4C2oJi9NLpvQo.nrHoAHTVX6w0vBQPm2u1D8U5owjcQfc!/b&ek=1&kp=1&pt=0&bo=ZAI4BGQCOAQRECc!&tl=1&lsr=6&vuin=1715054455&tm=1607943600#sce=79-11-1&rf=v1_and_sq_8.5.0_0_rdm_b_t_-2-0-31\"\n      }\n    ],\n    \"total\": 1,\n    \"title\": \"分享了来自小世界的作品\",\n    \"type\": 2,\n    \"isAIO\": 1,\n    \"appName\": \"qcircle\",\n    \"fuelNum\": 57393,\n    \"likeNum\": 41463\n  }\n}");
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent().getStringExtra("KEY_SEND_ARK_MSG_ID");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate--arkViewId=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    AEQLog.b("EditVideoStoryButton", localStringBuilder.toString());
    j();
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (b()) {
      i = (int)(paramInt * 50.0F / 100.0F);
    }
    c(i);
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
        localObject = this.jdField_b_of_type_JavaLangString;
        if ((localObject == null) || (!((String)localObject).equals(paramIntent.getStringExtra("fakeId")))) {
          return;
        }
      }
      boolean bool;
      if (this.jdField_b_of_type_Int == 20) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        ThreadManager.excute(new EditVideoStoryButton.1(this, paramIntent, bool, (SendPanelItemInfo)localObject), 64, null, true);
        return;
      }
      if (paramInt2 == 1)
      {
        h();
        if (b())
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.m();
          return;
        }
        localObject = new StringBuilder(HardCodeUtil.a(2131704015));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null))
        {
          ((StringBuilder)localObject).append(": ");
          ((StringBuilder)localObject).append(paramIntent.getStringExtra("error"));
        }
        QQToast.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), 1, (CharSequence)localObject, 0).a();
        return;
      }
      if (paramInt2 == 0) {
        h();
      }
    }
    else if (paramInt2 == -1)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(paramInt2, paramIntent, 2130772056, 0);
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
            b();
            return;
          }
          this.jdField_b_of_type_Int = paramInt2;
          if ((paramObject instanceof SendPanelItemInfo)) {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo = ((SendPanelItemInfo)paramObject);
          }
        }
        else
        {
          a(false, false);
        }
      }
      else {
        k();
      }
    }
    else
    {
      if (paramInt1 == 6) {
        a(true, true, false);
      } else {
        a(true, false);
      }
      b();
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo = null;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Float = paramInt;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Float = (50000.0F / (float)paramLong);
    if (this.jdField_b_of_type_Float == 0.0F) {
      this.jdField_b_of_type_Float = 1.0F;
    }
    g();
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561828);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373123);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371529)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(0);
    a().getRootView().postDelayed(new EditVideoStoryButton.3(this), paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.jdField_a_of_type_Long += 500L;
      }
      if (paramBoolean1) {
        TakeVideoUtils.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
      } else {
        TakeVideoUtils.a(this.jdField_a_of_type_AndroidViewViewGroup);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
      ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      int i;
      if (paramBoolean1) {
        i = 0;
      } else {
        i = 8;
      }
      localViewGroup.setVisibility(i);
      this.jdField_a_of_type_Long = 0L;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 11, Long.valueOf(this.jdField_a_of_type_Long)));
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() < this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void e()
  {
    h();
    super.e();
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getRootView().postDelayed(new EditVideoStoryButton.4(this), 1000L);
  }
  
  public void h()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (Math.abs(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) > 500L)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      int i = paramView.getId();
      if (this.jdField_a_of_type_Long > System.currentTimeMillis())
      {
        SLog.d("EditVideoStoryButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()) });
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.r();
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout == null))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setEditMode(false);
        if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d()) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a() != null) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().getTakePicToVideo())) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.setEditMode(true);
        }
      }
      switch (i)
      {
      case 2064122825: 
      case 2064122826: 
      case 2064122827: 
      default: 
        return;
      case 2064122829: 
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(2))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.u();
        VSReporter.a("mystatus_edit", "word_entry_clk", 0, 0, new String[0]);
        return;
      case 2064122828: 
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(3))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(3);
        VSReporter.a("mystatus_edit", "sticker_entry_clk", 0, 0, new String[0]);
        return;
      case 2064122824: 
        AEQLog.b("EditVideoStoryButton", "【Click】+ video_story_control_publish");
        long l = SystemClock.uptimeMillis();
        if (l - this.c >= 800L)
        {
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().isFinishing()) {
            return;
          }
          this.c = l;
          QLog.i("[vs_publish_flow] ", 1, "on vs publish button click");
          ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.f();
          ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportPostBtn();
          ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).clearLatestPostMd5();
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c())
          {
            CaptureReportUtil.e(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager);
            return;
          }
          CaptureReportUtil.g(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager);
          return;
        }
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b();
      return;
    }
    SLog.d("EditVideoStoryButton", "you click button too fast, ignore it !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton
 * JD-Core Version:    0.7.0.1
 */