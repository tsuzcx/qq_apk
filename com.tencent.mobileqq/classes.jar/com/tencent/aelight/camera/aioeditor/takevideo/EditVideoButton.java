package com.tencent.aelight.camera.aioeditor.takevideo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;
import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzEditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.view.PressScaleAnimDelegate;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.EditActivityEntranceUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.BubblePopupWindow;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@TargetApi(11)
public class EditVideoButton
  extends EditVideoPart
  implements View.OnClickListener, EditButtonExport
{
  private static final int[] a = { 2063991024, 2063991025, 2063991027, 2063991028, 2063991029, 2063991030, 2063991031, 2063991032, 2063991033, 2063991034, 2063991026 };
  private static int m = 248959;
  private static final LongSparseArray<EditVideoButton.EntryButtonInfo> n = new LongSparseArray();
  private boolean A;
  private long B = 0L;
  private boolean C = true;
  private int D = 0;
  private boolean E = false;
  protected ViewGroup b;
  protected ViewGroup c;
  protected ImageView d;
  protected TextView e;
  protected TextView f;
  protected BubblePopupWindow g;
  boolean h = true;
  boolean i = false;
  protected SparseArray<Long> j = new SparseArray();
  protected LongSparseArray<ImageView> k = new LongSparseArray();
  public int l;
  private View o;
  private LayoutTransition p = new LayoutTransition();
  private ViewGroup q;
  private ImageView[] r;
  private View s;
  private ImageView x;
  private ImageView y;
  private long z = 0L;
  
  public EditVideoButton(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.l = paramInt;
  }
  
  @Nullable
  private String a(FaceLayer paramFaceLayer)
  {
    if (paramFaceLayer != null)
    {
      Object localObject1 = paramFaceLayer.k();
      paramFaceLayer = new StringBuilder();
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Object localObject3 = (List)((Map.Entry)localObject2).getValue();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject2 = (String)((Map.Entry)localObject2).getKey();
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            paramFaceLayer.append((String)localObject2);
            paramFaceLayer.append('_');
            paramFaceLayer.append(str);
            paramFaceLayer.append(',');
          }
        }
      }
      return paramFaceLayer.toString();
    }
    return null;
  }
  
  private void a(View paramView)
  {
    int i1 = paramView.getId();
    int i2 = 1;
    long l1;
    switch (i1)
    {
    default: 
      break;
    case 2063991499: 
      PressScaleAnimDelegate.a(this.x, 200L, null);
      ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
      this.t.A();
      i1 = i2;
      if (this.t.I.a != 2)
      {
        i1 = i2;
        if (this.t.I.a != 5) {
          if (this.t.I.a == 6) {
            i1 = i2;
          } else {
            i1 = 0;
          }
        }
      }
      StoryReportor.a("video_edit_aio", "download_clk", 0, i1, new String[0]);
      StoryReportor.a("video_edit_new", "clk_download", 0, i1, new String[0]);
      ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportDownloadBtn();
      break;
    case 2063991498: 
      this.t.B();
      break;
    case 2063990985: 
    case 2063990986: 
      StoryReportor.b("clk_reshoot", x(), 0, new String[0]);
      if ((this.t instanceof QzEditVideoPartManager)) {
        ((QzEditVideoPartManager)this.t).B = true;
      }
      if (this.t.I.l()) {
        ReportController.b(null, "dc00898", "", "", "0X800A06F", "0X800A06F", 0, 0, "", "", "", "");
      }
      this.t.b();
      if ((this.t.I.b == 2) && (SlideShowPhotoListManager.a().d() == 13) && (this.u != null) && (this.u.getActivity() != null)) {
        StoryReportor.a("video_edit_new", "back_smartalbum", this.u.getActivity().getIntent(), new String[0]);
      }
      break;
    case 2063990984: 
      l1 = SystemClock.uptimeMillis();
      if (l1 - this.B >= 800L)
      {
        if (this.u.getActivity().isFinishing()) {
          return;
        }
        this.B = l1;
        if (SlideShowPhotoListManager.a().e() == 22)
        {
          LpReportInfo_pf00064.allReport(680, 2, 7);
          LpReportInfo_pf00064.allReport(680, 11, 1);
        }
        ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
        this.t.i();
        ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportPostBtn();
        ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).clearLatestPostMd5();
        AEQLog.b("Q.qqstory.record.EditVideoButton", "【Click】+ control_publish");
        k();
      }
      else
      {
        return;
      }
      break;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      EditVideoParams.EditSource localEditSource = this.t.I.e;
      l1 = 0L;
      if (((localEditSource instanceof EditLocalVideoSource)) || ((localEditSource instanceof EditTakeVideoSource))) {
        l1 = this.t.b(0);
      }
      localHashMap.put("ae_duration", Long.valueOf(l1));
      AECameraDaTongHelper.a.a(paramView, localHashMap);
      return;
    }
    catch (Exception paramView)
    {
      AEQLog.a("Q.qqstory.record.EditVideoButton", "report datong error", paramView);
    }
  }
  
  private void a(View... paramVarArgs)
  {
    float f1 = FontSettingManager.getFontLevel();
    if (f1 > 16.0F)
    {
      int i2 = paramVarArgs.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = paramVarArgs[i1];
        if (localObject == null) {
          break;
        }
        if (((View)localObject).getLayoutParams() == null) {
          return;
        }
        if ((localObject instanceof TextView))
        {
          localObject = (TextView)localObject;
          ((TextView)localObject).setTextSize(0, ((TextView)localObject).getTextSize() * (16.0F / f1));
        }
        i1 += 1;
      }
    }
  }
  
  private void b(int paramInt)
  {
    c();
    if ((this.t.M() != null) && ((this.t.M().getActivity() instanceof EditPicActivity))) {
      n.put(32L, new EditVideoButton.EntryButtonInfo(32L, 2063925627, HardCodeUtil.a(2131901895)));
    }
    int i1 = this.t.I.a;
    if ((i1 == 2) || (i1 == 6)) {
      if (this.t.j())
      {
        if (((paramInt & 0x1) != 0) && ((paramInt & 0x4) != 0) && ((paramInt & 0x8) != 0) && ((paramInt & 0x40) != 0) && ((paramInt & 0x400) != 0))
        {
          if ((paramInt & 0x20000) == 0) {
            return;
          }
          n.put(1L, new EditVideoButton.EntryButtonInfo(1024L, 2063925632, HardCodeUtil.a(2131901966)));
          n.put(4L, new EditVideoButton.EntryButtonInfo(131072L, 2063925636, u().getResources().getString(2064187532)));
          n.put(8L, new EditVideoButton.EntryButtonInfo(1L, 2063925637, HardCodeUtil.a(2131901834)));
          n.put(64L, new EditVideoButton.EntryButtonInfo(4L, 2063925628, HardCodeUtil.a(2131901931)));
          n.put(1024L, new EditVideoButton.EntryButtonInfo(8L, 2063925638, HardCodeUtil.a(2131901820)));
          n.put(131072L, new EditVideoButton.EntryButtonInfo(64L, 2063925629, HardCodeUtil.a(2131901961)));
        }
      }
      else
      {
        n.put(1L, new EditVideoButton.EntryButtonInfo(1024L, 2063925632, HardCodeUtil.a(2131901848)));
        n.put(2L, new EditVideoButton.EntryButtonInfo(8L, 2063925638, HardCodeUtil.a(2131901875)));
        n.put(8L, new EditVideoButton.EntryButtonInfo(64L, 2063925629, HardCodeUtil.a(2131901961)));
        n.put(64L, new EditVideoButton.EntryButtonInfo(1L, 2063925637, HardCodeUtil.a(2131901834)));
        n.put(1024L, new EditVideoButton.EntryButtonInfo(2L, 2063925634, HardCodeUtil.a(2131901831)));
      }
    }
    if ((i1 == 3) && (SlideShowPhotoListManager.a().e() == 22))
    {
      n.put(1L, new EditVideoButton.EntryButtonInfo(2L, 2063925634, HardCodeUtil.a(2131901840)));
      n.put(2L, new EditVideoButton.EntryButtonInfo(16384L, 2063925626, HardCodeUtil.a(2131901954)));
      n.put(8L, new EditVideoButton.EntryButtonInfo(16L, 2063925640, HardCodeUtil.a(2131901951)));
      n.put(16L, new EditVideoButton.EntryButtonInfo(8L, 2063925638, HardCodeUtil.a(2131901820)));
      n.put(16384L, new EditVideoButton.EntryButtonInfo(1L, 2063925637, HardCodeUtil.a(2131901829)));
      return;
    }
    if ((i1 == 3) && (this.t.j()))
    {
      n.put(1L, new EditVideoButton.EntryButtonInfo(1024L, 2063925632, HardCodeUtil.a(2131901916)));
      n.put(1024L, new EditVideoButton.EntryButtonInfo(1L, 2063925637, HardCodeUtil.a(2131901872)));
    }
  }
  
  private void b(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      TextView localTextView = (TextView)paramView;
      this.t.I.h();
      if (this.t.I.a == 2)
      {
        paramView = HardCodeUtil.a(2131901970);
        int i3 = this.t.I.j();
        if ((i3 == 122) || (i3 == 125) || (i3 == 133) || (EditVideoParams.a(i3)) || (this.t.I.l())) {
          paramView = e(2131886532);
        }
        Activity localActivity = this.u.getActivity();
        int i2 = 0;
        int i1 = i2;
        if (localActivity != null)
        {
          i1 = i2;
          if (this.u.getActivity().getIntent() != null)
          {
            i1 = i2;
            if (this.u.getActivity().getIntent().getBooleanExtra("input_full_screen_mode", false)) {
              i1 = 1;
            }
          }
        }
        if (i1 != 0) {
          paramView = e(2131892267);
        }
        if (i3 == 126)
        {
          paramView = HardCodeUtil.a(2131886532);
          localTextView.setCompoundDrawables(null, null, null, null);
        }
        localTextView.setText(paramView);
        localTextView.setContentDescription(paramView);
        return;
      }
      if (this.t.I.a == 8)
      {
        localTextView.setText(HardCodeUtil.a(2131899883));
        localTextView.setContentDescription(HardCodeUtil.a(2131899883));
        return;
      }
      if (this.t.I.a == 3)
      {
        paramView = this.t.I.a("extra_publish_text");
        if (!TextUtils.isEmpty(paramView))
        {
          localTextView.setText(paramView);
          localTextView.setContentDescription(paramView);
          return;
        }
        paramView = HardCodeUtil.a(2131886532);
        localTextView.setText(paramView);
        localTextView.setContentDescription(paramView);
        localTextView.setCompoundDrawables(null, null, null, null);
        return;
      }
      if ((this.t.I.a == 5) || (this.t.I.a == 6))
      {
        localTextView.setText(HardCodeUtil.a(2131901959));
        localTextView.setContentDescription(HardCodeUtil.a(2131901971));
        paramView = localTextView.getLayoutParams();
        paramView.width = AIOUtils.b(70.0F, localTextView.getContext().getResources());
        localTextView.setLayoutParams(paramView);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.b == null) {
      AEQLog.d("Q.qqstory.record.EditVideoButton", "mButtonLayout is null.");
    }
    View localView1 = this.b.findViewById(2063990938);
    View localView2 = this.b.findViewById(2063991467);
    int i2 = 0;
    int i1;
    if (localView1 != null)
    {
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localView1.setVisibility(i1);
    }
    if (localView2 != null)
    {
      if (paramBoolean) {
        i1 = i2;
      } else {
        i1 = 8;
      }
      localView2.setVisibility(i1);
    }
  }
  
  private void c()
  {
    n.put(2L, new EditVideoButton.EntryButtonInfo(2L, 2063925634, HardCodeUtil.a(2131901897)));
    n.put(1024L, new EditVideoButton.EntryButtonInfo(1024L, 2063925632, HardCodeUtil.a(2131901865)));
    n.put(131072L, new EditVideoButton.EntryButtonInfo(131072L, 2063925636, u().getResources().getString(2064187532)));
    n.put(1L, new EditVideoButton.EntryButtonInfo(1L, 2063925637, HardCodeUtil.a(2131901926)));
    n.put(8L, new EditVideoButton.EntryButtonInfo(8L, 2063925638, HardCodeUtil.a(2131901898)));
    n.put(4L, new EditVideoButton.EntryButtonInfo(4L, 2063925628, HardCodeUtil.a(2131901931)));
    n.put(64L, new EditVideoButton.EntryButtonInfo(64L, 2063925629, HardCodeUtil.a(2131901922)));
    n.put(32L, new EditVideoButton.EntryButtonInfo(32L, 2063925627, HardCodeUtil.a(2131901962)));
    n.put(16L, new EditVideoButton.EntryButtonInfo(16L, 2063925640, HardCodeUtil.a(2131901968)));
    n.put(2048L, new EditVideoButton.EntryButtonInfo(2048L, 2063925635, "跳转到P图"));
    n.put(16384L, new EditVideoButton.EntryButtonInfo(16384L, 2063925626, HardCodeUtil.a(2131901867)));
    n.put(65536L, new EditVideoButton.EntryButtonInfo(65536L, 2063925633, BaseApplicationImpl.getContext().getString(2064187444)));
  }
  
  private void c(int paramInt)
  {
    if (this.t.I != null)
    {
      int i2 = this.t.I.a;
      int i1 = 3;
      if (i2 == 3)
      {
        if (paramInt != 1) {
          if (paramInt != 4)
          {
            if (paramInt != 8)
            {
              if (paramInt != 1024) {
                i1 = -1;
              } else {
                i1 = 1;
              }
            }
            else {
              i1 = 4;
            }
          }
          else {
            i1 = 2;
          }
        }
        LpReportInfo_pf00064.report(615, i1);
      }
    }
  }
  
  private int d()
  {
    int i2 = m;
    int i3 = this.t.I.a;
    int i1;
    if (i3 != 2)
    {
      i1 = i2;
      if (i3 != 6) {}
    }
    else
    {
      i1 = i2;
      if (EditPicMeiHua.b(this.l))
      {
        i1 = i2;
        if (this.t.j()) {
          i1 = i2 & 0xFFFFF7FF & 0xFFFEFFFF;
        }
      }
    }
    return i1;
  }
  
  private void f(int paramInt)
  {
    if (SlideShowPhotoListManager.a().e() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, paramInt);
    }
  }
  
  private void k()
  {
    l();
    TransitionCategoryItem localTransitionCategoryItem = VideoFilterTools.a().c();
    if (localTransitionCategoryItem != null) {
      StoryReportor.a("video_edit_transition", "pub_effects", EditVideoTransfer.b(this.t.I.a("extra_transiton_src_from", -1)), 0, new String[] { localTransitionCategoryItem.t, localTransitionCategoryItem.w, localTransitionCategoryItem.u, localTransitionCategoryItem.v });
    }
    if (this.t.I.j() == 122) {
      AIOLongShotHelper.a("0X8009DEF");
    }
    if (this.t.I.l()) {
      ReportController.b(null, "dc00898", "", "", "0X800A06E", "0X800A06E", 0, 0, "", "", "", "");
    }
  }
  
  private void l()
  {
    int i1;
    try
    {
      localJSONObject = new JSONObject();
      i4 = this.t.T();
      i5 = this.t.I.j();
      if (i4 == 9) {
        break label612;
      }
      if (i4 != 2) {
        break label607;
      }
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      int i4;
      int i5;
      Object localObject1;
      int i6;
      String str;
      if (!QLog.isColorLevel()) {
        break label606;
      }
      QLog.e("Q.qqstory.record.EditVideoButton", 2, localException, new Object[0]);
      return;
    }
    localObject1 = a(this.t.O.b().getFaceLayer());
    Object localObject3 = this.t.O.b().getDynamicFaceLayer();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(a((FaceLayer)localObject3));
    localObject1 = ((StringBuilder)localObject4).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localJSONObject.put("sticker", localObject1);
    }
    localObject1 = (QIMCaptureVarManager)QIMManager.a(13);
    label179:
    int i2;
    int i3;
    if (localObject1 != null)
    {
      if (((QIMCaptureVarManager)localObject1).a() == 4)
      {
        i1 = 2;
      }
      else
      {
        if (((QIMCaptureVarManager)localObject1).a() != 8) {
          break label617;
        }
        i1 = 1;
      }
      localObject3 = ((QIMCaptureVarManager)localObject1).f();
      localObject4 = ((QIMCaptureVarManager)localObject1).e();
      if (i2 != 0)
      {
        localObject3 = localObject3[1];
        localObject1 = localObject4[1];
      }
      else
      {
        i6 = localObject3.length;
        i3 = 0;
        localObject1 = null;
        label222:
        if (i3 < i6)
        {
          str = localObject3[i3];
          if (str == null) {
            break label622;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(",");
          localObject1 = ((StringBuilder)localObject1).toString();
          break label622;
        }
        i6 = localObject4.length;
        i3 = 0;
        localObject3 = null;
        label285:
        if (i3 >= i6) {
          break label636;
        }
        str = localObject4[i3];
        if (str == null) {
          break label629;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(",");
        localObject3 = ((StringBuilder)localObject3).toString();
        break label629;
      }
      label338:
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localJSONObject.put("effect", localObject3);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localJSONObject.put("filter", localObject1);
      }
      localObject1 = (QimMusicPlayer)QIMManager.a(8);
      if ((localObject1 == null) || (((QimMusicPlayer)localObject1).j() == null)) {
        break label662;
      }
      localObject1 = String.valueOf(((QimMusicPlayer)localObject1).j().mItemId);
      label415:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localJSONObject.put("music", localObject1);
      }
      if (i2 != 0)
      {
        localObject1 = (QIMPtvTemplateManager)QIMManager.a(3);
        if (localObject1 == null) {
          break label668;
        }
        localObject1 = ((QIMPtvTemplateManager)localObject1).k();
        label462:
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localJSONObject.put("face", localObject1);
        }
      }
      localObject1 = this.t.O.b().getTextLayer().o();
      if (localObject1 == null) {
        break label674;
      }
      localObject1 = String.valueOf(((DynamicTextItem)localObject1).k());
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localJSONObject.put("text", localObject1);
      }
      StoryReportor.a("video_edit_new", "send_clk", x(), 0, new String[] { StoryReportor.d(i4), localJSONObject.toString(), String.valueOf(i1), String.valueOf(i5) });
      return;
      label606:
      label607:
      i2 = 0;
      break;
      label612:
      i2 = 1;
      break;
      label617:
      i1 = 0;
      break label179;
      label622:
      i3 += 1;
      break label222;
      label629:
      i3 += 1;
      break label285;
      label636:
      localObject4 = localException;
      Object localObject2 = localObject3;
      localObject3 = localObject4;
      break label338;
      localObject2 = null;
      i1 = 0;
      localObject3 = null;
      break label338;
      label662:
      localObject2 = null;
      break label415;
      label668:
      localObject2 = null;
      break label462;
      label674:
      localObject2 = null;
    }
  }
  
  private void m()
  {
    ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).downloadModule("cyber_clink_version_2.jar", new EditVideoButton.2(this));
  }
  
  public void a()
  {
    super.a();
    this.b = ((ViewGroup)d(2063990936));
    this.b.setVisibility(0);
    this.e = ((TextView)d(2063990985));
    this.e.setOnClickListener(this);
    this.e.setVisibility(8);
    this.d = ((ImageView)d(2063990986));
    this.d.setContentDescription(HardCodeUtil.a(2131901853));
    this.d.setOnClickListener(this);
    AECameraDaTongHelper.a.a(this.d, "em_ae_cancel_btn");
    this.f = ((TextView)d(2063990984));
    this.f.setOnClickListener(this);
    AECameraDaTongHelper.a.a(this.f, "em_ae_send_btn");
    this.s = d(2063991035);
    this.s.setVisibility(8);
    this.s.setOnClickListener(this);
    b(this.f);
    this.o = d(2063991134);
    this.r = a(this.l, this);
    this.q = ((ViewGroup)d(2063990938));
    this.c = ((ViewGroup)d(2063990937));
    if (LiuHaiUtils.g())
    {
      localObject = this.q.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject;
        localMarginLayoutParams.topMargin += LiuHaiUtils.h();
        this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    this.x = ((ImageView)d(2063991499));
    if ((this.l & 0x200) != 0)
    {
      if ((this.t instanceof QzEditVideoPartManager)) {
        this.x.setImageResource(2063925649);
      }
      this.x.setVisibility(0);
      this.x.setOnClickListener(this);
    }
    else
    {
      this.x.setVisibility(8);
    }
    AECameraDaTongHelper.a.a(this.x, "em_ae_save_btn");
    this.y = ((ImageView)d(2063991498));
    if ((this.l & 0x8000) != 0)
    {
      this.y.setOnClickListener(this);
      if ((((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).isModuleDownloaded("cyber_clink_version_2.jar")) && (!((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).checkIfNeedUpdate("cyber_clink_version_2.jar"))) {
        this.y.setVisibility(0);
      } else {
        m();
      }
    }
    else
    {
      this.y.setVisibility(8);
    }
    a(new View[] { this.e, this.f });
    a(this.r);
    this.p.setAnimator(3, ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F }));
    this.p.setDuration(3, 500L);
    this.p.setAnimator(2, ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F }));
    this.p.setDuration(2, 500L);
    a(EditButtonExport.class, this);
    this.h = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
    Object localObject = this.t.I.d;
    if (localObject != null) {
      this.E = ((Bundle)localObject).getBoolean("key_enable_edit_title_bar", false);
    }
    if (this.t.j())
    {
      localObject = this.c.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = UIUtils.a(u(), 28.0F);
        this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.x.setVisibility(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    BubblePopupWindow localBubblePopupWindow = this.g;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      this.g.dismiss();
    }
    switch (paramInt2)
    {
    case 12: 
    case 18: 
    case 19: 
    case 20: 
    case 22: 
    case 24: 
    default: 
    case 26: 
      a(false, false);
      return;
    case 25: 
      a((ImageView)this.k.get(131072L));
      if (!this.t.j()) {
        this.c.setBackgroundColor(s().getColor(2131165583));
      }
      this.o.setVisibility(8);
      if (paramInt1 == 5)
      {
        if ((paramObject instanceof Boolean))
        {
          a(true, ((Boolean)paramObject).booleanValue());
          return;
        }
        a(true, true);
        return;
      }
      a(true, false);
      return;
    case 23: 
      if ((paramObject instanceof Boolean))
      {
        AEQLog.b("Q.qqstory.record.EditVideoButton", "in show hide top bar.");
        b(((Boolean)paramObject).booleanValue());
        return;
      }
      AEQLog.d("Q.qqstory.record.EditVideoButton", "extra is null.");
      return;
    case 21: 
      a((ImageView)this.k.get(65536L));
      b(false, false, true);
      return;
    case 17: 
      a((ImageView)this.k.get(16L));
      b(false, false, true);
      return;
    case 16: 
      if (paramInt1 == 15)
      {
        this.c.setVisibility(0);
        this.o.setVisibility(0);
        return;
      }
      break;
    case 15: 
      this.c.setVisibility(8);
      this.o.setVisibility(8);
      return;
    case 14: 
      a((ImageView)this.k.get(32L));
      b(false, false, true);
      return;
    case 13: 
      a((ImageView)this.k.get(64L));
      b(false, false, true);
      return;
    case 11: 
      a(false, true, false);
      VideoEditReport.b("0X80080E5", VideoEditReport.c);
      return;
    case 10: 
      a((ImageView)this.k.get(2048L));
      return;
    case 9: 
      a(null);
      a(true, false);
      return;
    case 8: 
      a(false, false);
      return;
    case 7: 
      a((ImageView)this.k.get(4L));
      a(false, false);
      return;
    case 6: 
      if ((paramInt1 != 5) && (paramInt1 != 26))
      {
        a(false, true);
        return;
      }
      break;
    case 5: 
      if ((paramInt1 != 5) && (paramInt1 != 26))
      {
        a(false, true);
        return;
      }
      break;
    case 4: 
      a((ImageView)this.k.get(1024L));
      if (!this.t.j()) {
        this.c.setBackgroundColor(s().getColor(2131165583));
      }
      this.o.setVisibility(8);
      if (paramInt1 == 5)
      {
        if ((paramObject instanceof Boolean))
        {
          a(true, true, ((Boolean)paramObject).booleanValue());
          return;
        }
        a(true, true);
        return;
      }
      a(true, false);
      return;
    case 3: 
      a((ImageView)this.k.get(8L));
      b(false, false, true);
      return;
    case 2: 
      if ((paramInt1 != paramInt2) && (this.i)) {
        a((ImageView)this.k.get(1L));
      }
      int i2 = -1;
      int i1 = i2;
      if (paramObject != null)
      {
        i1 = i2;
        if ((paramObject instanceof Integer)) {
          i1 = ((Integer)paramObject).intValue();
        }
      }
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("editVideoStateChanged text old:");
        paramObject.append(paramInt1);
        paramObject.append(" new:");
        paramObject.append(paramInt2);
        paramObject.append(" softInputMode:");
        paramObject.append(i1);
        QLog.i("Q.qqstory.record.EditVideoButton", 2, paramObject.toString());
      }
      if (i1 == 0)
      {
        this.c.setVisibility(8);
        this.o.setVisibility(8);
      }
      else
      {
        a(true, false);
      }
      b(false, false, true);
      if ((this.E) && (this.t.j()))
      {
        paramObject = this.d;
        if ((paramObject != null) && (paramObject.getVisibility() == 0)) {
          this.d.setVisibility(4);
        }
        paramObject = this.x;
        if ((paramObject != null) && (paramObject.getVisibility() == 0))
        {
          a(4);
          return;
        }
      }
      break;
    case 1: 
      a((ImageView)this.k.get(2L));
      b(false, false, true);
      return;
    case 0: 
      a(null);
      this.c.setBackgroundColor(this.D);
      this.o.setVisibility(0);
      if (paramInt1 == 6) {
        a(true, true, false);
      } else if (paramInt1 == 11) {
        a(true, true, false);
      } else {
        a(true, false);
      }
      if (this.C)
      {
        this.t.a(Message.obtain(null, 12, 3, (int)this.v));
        this.C = false;
      }
      if ((this.E) && (this.t.j()))
      {
        paramObject = this.d;
        if ((paramObject != null) && (paramObject.getVisibility() != 0)) {
          this.d.setVisibility(0);
        }
        paramObject = this.x;
        if ((paramObject != null) && (paramObject.getVisibility() != 0) && ((this.l & 0x200) != 0)) {
          this.x.setVisibility(0);
        }
      }
      break;
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
  }
  
  protected void a(@Nullable ImageView paramImageView)
  {
    int i1 = 0;
    while (i1 < this.k.size())
    {
      ImageView localImageView = (ImageView)this.k.valueAt(i1);
      if (localImageView != null)
      {
        localImageView.getDrawable().clearColorFilter();
        localImageView.clearColorFilter();
      }
      i1 += 1;
    }
    if (paramImageView != null) {
      paramImageView.setColorFilter(s().getColor(2131167113), PorterDuff.Mode.SRC_IN);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1;
    if (paramBoolean2)
    {
      this.v = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.v += 500L;
      }
      if (paramBoolean1) {
        TakeVideoUtils.a(this.b, paramBoolean3);
      } else {
        TakeVideoUtils.a(this.b);
      }
    }
    else
    {
      this.b.setAnimation(null);
      ViewGroup localViewGroup = this.b;
      if (paramBoolean1) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localViewGroup.setVisibility(i1);
      this.v = 0L;
    }
    this.t.a(Message.obtain(null, 11, Long.valueOf(this.v)));
    if (paramBoolean1)
    {
      i1 = 0;
      while (i1 < this.k.size())
      {
        ((ImageView)this.k.valueAt(i1)).setVisibility(0);
        i1 += 1;
      }
    }
    if (paramBoolean1)
    {
      if (this.q.getVisibility() != 0) {
        this.q.setVisibility(0);
      }
      if (this.c.getVisibility() != 0) {
        this.c.setVisibility(0);
      }
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      ImageView localImageView = (ImageView)this.k.get(paramMessage.arg1);
      if (localImageView != null)
      {
        SLog.b("Q.qqstory.record.EditVideoButton", "perform button click %s", localImageView);
        localImageView.performClick();
      }
      else
      {
        SLog.d("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", new Object[] { Integer.valueOf(paramMessage.arg1) });
      }
    }
    return super.a(paramMessage);
  }
  
  protected ImageView[] a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if ((this.t.I.h() == 11) || (this.t.I.h() == 12)) {
      this.i = true;
    }
    int i4 = paramInt & d();
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (paramInt = 0; i1 < 18; paramInt = i2)
    {
      int i5 = 1 << i1;
      i2 = paramInt;
      if ((i4 & i5 & m) == i5) {
        i2 = paramInt + 1;
      }
      i1 += 1;
    }
    i1 = a.length;
    if (i1 >= paramInt)
    {
      ImageView[] arrayOfImageView = new ImageView[i1];
      paramInt = 0;
      Object localObject;
      while (paramInt < i1)
      {
        localObject = d(a[paramInt]);
        if ((localObject instanceof ImageView))
        {
          arrayOfImageView[paramInt] = ((ImageView)localObject);
          paramInt += 1;
        }
        else
        {
          paramOnClickListener = new StringBuilder();
          paramOnClickListener.append("can not find ImageView by id : ");
          paramOnClickListener.append(a[paramInt]);
          paramOnClickListener.append(", view : ");
          paramOnClickListener.append(localObject);
          throw new IllegalArgumentException(paramOnClickListener.toString());
        }
      }
      this.j.clear();
      this.k.clear();
      b(i4);
      paramInt = 0;
      i1 = i3;
      for (;;)
      {
        i2 = paramInt;
        if (i1 >= 18) {
          break;
        }
        long l1 = 1L << i1;
        i2 = paramInt;
        if ((i4 & l1) == l1)
        {
          i2 = paramInt;
          if ((m & l1) == l1)
          {
            localObject = arrayOfImageView[paramInt];
            EditVideoButton.EntryButtonInfo localEntryButtonInfo = (EditVideoButton.EntryButtonInfo)n.get(l1);
            if (localEntryButtonInfo != null)
            {
              ((ImageView)localObject).setImageResource(localEntryButtonInfo.b);
              ((ImageView)localObject).setContentDescription(localEntryButtonInfo.c);
              ((ImageView)localObject).setOnClickListener(paramOnClickListener);
              this.j.put(((ImageView)localObject).getId(), Long.valueOf(localEntryButtonInfo.a));
              this.k.put(localEntryButtonInfo.a, localObject);
            }
            i2 = paramInt + 1;
          }
        }
        i1 += 1;
        paramInt = i2;
      }
      while (i2 < a.length)
      {
        arrayOfImageView[i2].setOnClickListener(null);
        arrayOfImageView[i2].setVisibility(8);
        i2 += 1;
      }
      return arrayOfImageView;
    }
    paramOnClickListener = new IllegalArgumentException("too many parts, there is no enough view to show");
    for (;;)
    {
      throw paramOnClickListener;
    }
  }
  
  public boolean au_()
  {
    return System.currentTimeMillis() < this.v;
  }
  
  public void b()
  {
    ImageView localImageView = (ImageView)this.k.get(16L);
    if (localImageView != null) {
      localImageView.setImageResource(2063925639);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1;
    if (paramBoolean2)
    {
      this.v = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.v += 500L;
      }
      if (paramBoolean1) {
        TakeVideoUtils.a(this.c, paramBoolean3);
      } else {
        TakeVideoUtils.a(this.c);
      }
    }
    else
    {
      this.c.setAnimation(null);
      ViewGroup localViewGroup = this.c;
      if (paramBoolean1) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localViewGroup.setVisibility(i1);
      this.v = 0L;
    }
    this.t.a(Message.obtain(null, 11, Long.valueOf(this.v)));
    if (paramBoolean1)
    {
      i1 = 0;
      while (i1 < this.k.size())
      {
        ((ImageView)this.k.valueAt(i1)).setVisibility(0);
        i1 += 1;
      }
    }
  }
  
  public void f()
  {
    super.f();
    if ((this.t.C == 0) && (!this.A))
    {
      if (((this.t.I.e instanceof EditTakePhotoSource)) || ((this.t.I.e instanceof EditTakeVideoSource)))
      {
        int i1 = AIOUtils.b(-48.0F, s());
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.q, "translationY", new float[] { i1, 0.0F });
        localObjectAnimator1.setDuration(800L);
        i1 = AIOUtils.b(s().getDimension(2131298834), s());
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.c, "translationY", new float[] { i1, 0.0F });
        localObjectAnimator2.setDuration(800L);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
        localAnimatorSet.start();
      }
      this.A = true;
    }
  }
  
  public View i()
  {
    LongSparseArray localLongSparseArray = this.k;
    if (localLongSparseArray != null) {
      return (View)localLongSparseArray.get(16L);
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (Math.abs(SystemClock.uptimeMillis() - this.z) > 500L)
    {
      this.z = SystemClock.uptimeMillis();
      int i3 = paramView.getId();
      long l1 = this.v;
      long l2 = System.currentTimeMillis();
      int i2 = 1;
      if (l1 > l2)
      {
        SLog.d("Q.qqstory.record.EditVideoButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.v), Long.valueOf(System.currentTimeMillis()) });
        return;
      }
      Object localObject1 = a;
      int i4 = localObject1.length;
      int i1 = 0;
      while (i1 < i4)
      {
        if (localObject1[i1] == i3)
        {
          l1 = ((Long)this.j.get(i3)).longValue();
          SLog.d("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Long.valueOf(l1), paramView });
          localObject1 = this.t;
          Object localObject2 = null;
          i1 = ((EditVideoPartManager)localObject1).a(Message.obtain(null, 1, new Object[] { Long.valueOf(l1), paramView }));
          if (i1 > 0)
          {
            paramView = new StringBuilder();
            paramView.append("%d parts intercept the click event : ");
            paramView.append(i1);
            SLog.c("Q.qqstory.record.EditVideoButton", paramView.toString());
            return;
          }
          this.t.C();
          i4 = (int)(0xFFFFFFFF & l1);
          if (i4 != 1)
          {
            if (i4 != 2)
            {
              i1 = 4;
              if (i4 != 4)
              {
                i3 = 3;
                if (i4 != 8)
                {
                  if (i4 != 16)
                  {
                    if (i4 != 32)
                    {
                      if (i4 != 64)
                      {
                        if (i4 != 1024)
                        {
                          if (i4 != 2048)
                          {
                            if (i4 != 16384)
                            {
                              if (i4 != 65536)
                              {
                                if (i4 == 131072)
                                {
                                  if (this.t.c(25))
                                  {
                                    this.t.d(0);
                                    i1 = -1;
                                  }
                                  else
                                  {
                                    i1 = 25;
                                  }
                                  AEBaseDataReporter.a().ba();
                                  break label1267;
                                }
                              }
                              else if (this.t.c(21))
                              {
                                this.t.d(0);
                              }
                              else
                              {
                                i1 = 21;
                                break label1267;
                              }
                            }
                            else
                            {
                              if (SlideShowPhotoListManager.a().e() == 22) {
                                LpReportInfo_pf00064.allReport(680, 2, 2);
                              }
                              localObject1 = new ArrayList(SlideShowPhotoListManager.a().f());
                              QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
                              Bundle localBundle = new Bundle();
                              localBundle.putParcelableArrayList("qzone_slide_show_matters", (ArrayList)localObject1);
                              QZoneHelper.forwardToQzDynamicEditVideoActivity(this.u.getActivity(), localUserInfo, localBundle, 666);
                            }
                          }
                          else
                          {
                            if (this.t.C == 10) {
                              this.t.d(0);
                            } else {
                              this.t.d(10);
                            }
                            i1 = i2;
                            if (this.t.I.a != 2)
                            {
                              i1 = i2;
                              if (this.t.I.a != 5) {
                                if (this.t.I.a == 6) {
                                  i1 = i2;
                                } else {
                                  i1 = 0;
                                }
                              }
                            }
                            StoryReportor.a("video_edit_aio", "ttpt_clk", 0, i1, new String[0]);
                            StoryReportor.a("video_edit_new", "clk_pitu", 0, i1, new String[0]);
                          }
                        }
                        else
                        {
                          if (this.t.c(4))
                          {
                            this.t.d(0);
                            i1 = -1;
                          }
                          AEBaseDataReporter.a().aZ();
                          VideoEditReport.b("0X80075C4", VideoEditReport.c);
                          StoryReportor.b("clk_graffiti", x(), 0, new String[0]);
                          c(1024);
                          if (this.t.j()) {
                            EditActivityEntranceUtil.a("0X800B3C5", this.t.I.j());
                          }
                          break label1267;
                        }
                      }
                      else
                      {
                        if (this.t.c(13)) {
                          this.t.d(0);
                        } else {
                          this.t.d(13);
                        }
                        AEBaseDataReporter.a().bd();
                        i1 = x();
                        if (this.t.j()) {
                          localObject1 = "1";
                        } else {
                          localObject1 = "2";
                        }
                        StoryReportor.a("video_edit_new", "clk_filter", i1, 0, new String[] { "", localObject1, "", "" });
                      }
                    }
                    else
                    {
                      localObject1 = this.t;
                      i1 = 14;
                      if (((EditVideoPartManager)localObject1).c(14))
                      {
                        this.t.d(0);
                        i1 = -1;
                      }
                      StoryReportor.b("clk_effect", x(), 0, new String[0]);
                      f(10);
                      break label1267;
                    }
                  }
                  else
                  {
                    localObject1 = (EditTransferExport)b(EditTransferExport.class);
                    if (localObject1 != null)
                    {
                      if (((EditTransferExport)localObject1).b() == 0)
                      {
                        if (this.t.c(17))
                        {
                          this.t.d(0);
                          i1 = -1;
                        }
                        else
                        {
                          i1 = 17;
                        }
                        StoryReportor.a("video_edit_transition", "clk_transition", EditVideoTransfer.b(this.t.I.a("extra_transiton_src_from", -1)), 0, new String[0]);
                        f(11);
                        break label1267;
                      }
                      ((EditTransferExport)localObject1).c();
                      StoryReportor.a("video_edit_transition", "exp_toastFail", EditVideoTransfer.b(this.t.I.a("extra_transiton_src_from", -1)), 0, new String[0]);
                    }
                  }
                }
                else
                {
                  i1 = i3;
                  if (this.t.c(3))
                  {
                    this.t.d(0);
                    i1 = -1;
                  }
                  AEBaseDataReporter.a().bc();
                  VideoEditReport.b("0X80075C7", VideoEditReport.c);
                  c(8);
                  StoryReportor.a("video_edit_new", "clk_sticker", x(), 0, new String[0]);
                  f(12);
                  break label1267;
                }
              }
              else
              {
                this.t.D();
                AEBaseDataReporter.a().be();
                VideoEditReport.b("0X80075C5", VideoEditReport.c);
                c(4);
                StoryReportor.a("video_edit_new", "clk_cut", x(), 0, new String[0]);
                EditActivityEntranceUtil.a("0X800B3C7", this.t.I.j());
              }
            }
            else
            {
              if (this.t.c(1))
              {
                this.t.d(0);
                i1 = -1;
              }
              else
              {
                i1 = 1;
              }
              AEBaseDataReporter.a().bf();
              f(1);
              StoryReportor.b("clk_music", x(), 0, new String[0]);
              break label1267;
            }
          }
          else
          {
            if (this.t.c(2)) {
              this.t.d(0);
            } else {
              this.t.F();
            }
            AEBaseDataReporter.a().bb();
            VideoEditReport.b("0X80075C6", VideoEditReport.c);
            StoryReportor.b("clk_text", x(), 0, new String[0]);
            c(1);
            f(9);
            if (this.t.j()) {
              EditActivityEntranceUtil.a("0X800B3C9", this.t.I.j());
            }
          }
          i1 = -1;
          label1267:
          localObject1 = localObject2;
          if (i1 != -1) {
            localObject1 = new EditVideoButton.1(this, i1);
          }
          if ((m & l1) == l1) {
            PressScaleAnimDelegate.a(paramView, 200L, (View.OnClickListener)localObject1);
          }
          return;
        }
        i1 += 1;
      }
      a(paramView);
      return;
    }
    SLog.d("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoButton
 * JD-Core Version:    0.7.0.1
 */