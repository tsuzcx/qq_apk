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
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.EditActivityEntranceUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import com.tencent.widget.BubblePopupWindow;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2064122134, 2064122135, 2064122137, 2064122138, 2064122139, 2064122140, 2064122141, 2064122142, 2064122143, 2064122144, 2064122136 };
  private static int jdField_b_of_type_Int = 248959;
  private static final LongSparseArray<EditVideoButton.EntryButtonInfo> jdField_b_of_type_AndroidSupportV4UtilLongSparseArray = new LongSparseArray();
  public int a;
  private LayoutTransition jdField_a_of_type_AndroidAnimationLayoutTransition = new LayoutTransition();
  protected LongSparseArray<ImageView> a;
  protected SparseArray<Long> a;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewGroup a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected TextView a;
  protected BubblePopupWindow a;
  boolean jdField_a_of_type_Boolean = true;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private long jdField_b_of_type_Long = 0L;
  protected ViewGroup b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  private boolean e = false;
  
  public EditVideoButton(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray = new LongSparseArray();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private int a()
  {
    int j = jdField_b_of_type_Int;
    int k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int;
    int i;
    if (k != 2)
    {
      i = j;
      if (k != 6) {}
    }
    else
    {
      i = j;
      if (EditPicMeiHua.a(this.jdField_a_of_type_Int))
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
          i = j & 0xFFFFF7FF & 0xFFFEFFFF;
        }
      }
    }
    return i;
  }
  
  @Nullable
  private String a(FaceLayer paramFaceLayer)
  {
    if (paramFaceLayer != null)
    {
      Object localObject1 = paramFaceLayer.a();
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
    int i = paramView.getId();
    int j = 1;
    switch (i)
    {
    default: 
    case 2064122719: 
      PressScaleAnimDelegate.a(this.jdField_b_of_type_AndroidWidgetImageView, 200L, null);
      ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.p();
      i = j;
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int != 2)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int != 5) {
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 6) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
      StoryReportor.a("video_edit_aio", "download_clk", 0, i, new String[0]);
      StoryReportor.a("video_edit_new", "clk_download", 0, i, new String[0]);
      ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportDownloadBtn();
      return;
    case 2064122718: 
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.q();
      return;
    case 2064122068: 
    case 2064122069: 
      StoryReportor.b("clk_reshoot", c(), 0, new String[0]);
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager instanceof QzEditVideoPartManager)) {
        ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager).n = true;
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.h()) {
        ReportController.b(null, "dc00898", "", "", "0X800A06F", "0X800A06F", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b();
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_b_of_type_Int == 2) && (SlideShowPhotoListManager.a().a() == 13) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity() != null))
      {
        StoryReportor.a("video_edit_new", "back_smartalbum", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent(), new String[0]);
        return;
      }
      break;
    case 2064122067: 
      long l = SystemClock.uptimeMillis();
      if (l - this.jdField_c_of_type_Long >= 800L)
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().isFinishing()) {
          return;
        }
        this.jdField_c_of_type_Long = l;
        if (SlideShowPhotoListManager.a().b() == 22)
        {
          LpReportInfo_pf00064.allReport(680, 2, 7);
          LpReportInfo_pf00064.allReport(680, 11, 1);
        }
        ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.f();
        ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportPostBtn();
        ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).clearLatestPostMd5();
        AEQLog.b("Q.qqstory.record.EditVideoButton", "【Click】+ control_publish");
        h();
      }
      break;
    }
  }
  
  private void a(View... paramVarArgs)
  {
    float f = FontSettingManager.getFontLevel();
    if (f > 16.0F)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramVarArgs[i];
        if (localObject == null) {
          break;
        }
        if (((View)localObject).getLayoutParams() == null) {
          return;
        }
        if ((localObject instanceof TextView))
        {
          localObject = (TextView)localObject;
          ((TextView)localObject).setTextSize(0, ((TextView)localObject).getTextSize() * (16.0F / f));
        }
        i += 1;
      }
    }
  }
  
  private ImageView[] a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a() == 11) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a() == 12)) {
      this.jdField_b_of_type_Boolean = true;
    }
    int m = paramInt & a();
    int k = 0;
    int i = 0;
    int j;
    for (paramInt = 0; i < 18; paramInt = j)
    {
      int n = 1 << i;
      j = paramInt;
      if ((m & n & jdField_b_of_type_Int) == n) {
        j = paramInt + 1;
      }
      i += 1;
    }
    i = jdField_a_of_type_ArrayOfInt.length;
    if (i >= paramInt)
    {
      ImageView[] arrayOfImageView = new ImageView[i];
      paramInt = 0;
      Object localObject;
      while (paramInt < i)
      {
        localObject = a(jdField_a_of_type_ArrayOfInt[paramInt]);
        if ((localObject instanceof ImageView))
        {
          arrayOfImageView[paramInt] = ((ImageView)localObject);
          paramInt += 1;
        }
        else
        {
          paramOnClickListener = new StringBuilder();
          paramOnClickListener.append("can not find ImageView by id : ");
          paramOnClickListener.append(jdField_a_of_type_ArrayOfInt[paramInt]);
          paramOnClickListener.append(", view : ");
          paramOnClickListener.append(localObject);
          throw new IllegalArgumentException(paramOnClickListener.toString());
        }
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.clear();
      b(m);
      paramInt = 0;
      i = k;
      for (;;)
      {
        j = paramInt;
        if (i >= 18) {
          break;
        }
        long l = 1L << i;
        j = paramInt;
        if ((m & l) == l)
        {
          j = paramInt;
          if ((jdField_b_of_type_Int & l) == l)
          {
            localObject = arrayOfImageView[paramInt];
            EditVideoButton.EntryButtonInfo localEntryButtonInfo = (EditVideoButton.EntryButtonInfo)jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.get(l);
            if (localEntryButtonInfo != null)
            {
              ((ImageView)localObject).setImageResource(localEntryButtonInfo.jdField_a_of_type_Int);
              ((ImageView)localObject).setContentDescription(localEntryButtonInfo.jdField_a_of_type_JavaLangCharSequence);
              ((ImageView)localObject).setOnClickListener(paramOnClickListener);
              this.jdField_a_of_type_AndroidUtilSparseArray.put(((ImageView)localObject).getId(), Long.valueOf(localEntryButtonInfo.jdField_a_of_type_Long));
              this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.put(localEntryButtonInfo.jdField_a_of_type_Long, localObject);
            }
            j = paramInt + 1;
          }
        }
        i += 1;
        paramInt = j;
      }
      while (j < jdField_a_of_type_ArrayOfInt.length)
      {
        arrayOfImageView[j].setOnClickListener(null);
        arrayOfImageView[j].setVisibility(8);
        j += 1;
      }
      return arrayOfImageView;
    }
    paramOnClickListener = new IllegalArgumentException("too many parts, there is no enough view to show");
    for (;;)
    {
      throw paramOnClickListener;
    }
  }
  
  private void b(int paramInt)
  {
    g();
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a() != null) && ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().getActivity() instanceof EditPicActivity))) {
      jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(32L, new EditVideoButton.EntryButtonInfo(32L, 2064056662, HardCodeUtil.a(2131703964)));
    }
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int;
    if ((i == 2) || (i == 6)) {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c())
      {
        if (((paramInt & 0x1) != 0) && ((paramInt & 0x4) != 0) && ((paramInt & 0x8) != 0) && ((paramInt & 0x40) != 0) && ((paramInt & 0x400) != 0))
        {
          if ((paramInt & 0x20000) == 0) {
            return;
          }
          jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new EditVideoButton.EntryButtonInfo(1024L, 2064056667, HardCodeUtil.a(2131704041)));
          jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(4L, new EditVideoButton.EntryButtonInfo(131072L, 2064056671, a().getResources().getString(2064515186)));
          jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new EditVideoButton.EntryButtonInfo(1L, 2064056672, HardCodeUtil.a(2131703893)));
          jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(64L, new EditVideoButton.EntryButtonInfo(4L, 2064056663, HardCodeUtil.a(2131704002)));
          jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(1024L, new EditVideoButton.EntryButtonInfo(8L, 2064056673, HardCodeUtil.a(2131703878)));
          jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(131072L, new EditVideoButton.EntryButtonInfo(64L, 2064056664, HardCodeUtil.a(2131704036)));
        }
      }
      else
      {
        jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new EditVideoButton.EntryButtonInfo(1024L, 2064056667, HardCodeUtil.a(2131703911)));
        jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new EditVideoButton.EntryButtonInfo(8L, 2064056673, HardCodeUtil.a(2131703943)));
        jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new EditVideoButton.EntryButtonInfo(64L, 2064056664, HardCodeUtil.a(2131704036)));
        jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(64L, new EditVideoButton.EntryButtonInfo(1L, 2064056672, HardCodeUtil.a(2131703893)));
        jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(1024L, new EditVideoButton.EntryButtonInfo(2L, 2064056669, HardCodeUtil.a(2131703890)));
      }
    }
    if ((i == 3) && (SlideShowPhotoListManager.a().b() == 22))
    {
      jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new EditVideoButton.EntryButtonInfo(2L, 2064056669, HardCodeUtil.a(2131703902)));
      jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new EditVideoButton.EntryButtonInfo(16384L, 2064056661, HardCodeUtil.a(2131704029)));
      jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new EditVideoButton.EntryButtonInfo(16L, 2064056675, HardCodeUtil.a(2131704026)));
      jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(16L, new EditVideoButton.EntryButtonInfo(8L, 2064056673, HardCodeUtil.a(2131703878)));
      jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(16384L, new EditVideoButton.EntryButtonInfo(1L, 2064056672, HardCodeUtil.a(2131703888)));
      return;
    }
    if ((i == 3) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()))
    {
      jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new EditVideoButton.EntryButtonInfo(1024L, 2064056667, HardCodeUtil.a(2131703986)));
      jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(1024L, new EditVideoButton.EntryButtonInfo(1L, 2064056672, HardCodeUtil.a(2131703938)));
    }
  }
  
  private void b(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      TextView localTextView = (TextView)paramView;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a();
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 2)
      {
        paramView = HardCodeUtil.a(2131704045);
        int k = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c();
        if ((k == 122) || (k == 125) || (k == 133) || (EditVideoParams.a(k)) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.h())) {
          paramView = a(2131689891);
        }
        Activity localActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity();
        int j = 0;
        int i = j;
        if (localActivity != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent() != null)
          {
            i = j;
            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent().getBooleanExtra("input_full_screen_mode", false)) {
              i = 1;
            }
          }
        }
        if (i != 0) {
          paramView = a(2131694583);
        }
        if (k == 126)
        {
          paramView = HardCodeUtil.a(2131689891);
          localTextView.setCompoundDrawables(null, null, null, null);
        }
        localTextView.setText(paramView);
        localTextView.setContentDescription(paramView);
        return;
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 8)
      {
        localTextView.setText(HardCodeUtil.a(2131703865));
        localTextView.setContentDescription(HardCodeUtil.a(2131703895));
        return;
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 3)
      {
        paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_publish_text");
        if (!TextUtils.isEmpty(paramView))
        {
          localTextView.setText(paramView);
          localTextView.setContentDescription(paramView);
          return;
        }
        paramView = HardCodeUtil.a(2131689891);
        localTextView.setText(paramView);
        localTextView.setContentDescription(paramView);
        localTextView.setCompoundDrawables(null, null, null, null);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 6))
      {
        localTextView.setText(HardCodeUtil.a(2131704034));
        localTextView.setContentDescription(HardCodeUtil.a(2131704046));
        paramView = localTextView.getLayoutParams();
        paramView.width = AIOUtils.b(70.0F, localTextView.getContext().getResources());
        localTextView.setLayoutParams(paramView);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      AEQLog.d("Q.qqstory.record.EditVideoButton", "mButtonLayout is null.");
    }
    View localView1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122007);
    View localView2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122669);
    int j = 0;
    int i;
    if (localView1 != null)
    {
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView1.setVisibility(i);
    }
    if (localView2 != null)
    {
      if (paramBoolean) {
        i = j;
      } else {
        i = 8;
      }
      localView2.setVisibility(i);
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null)
    {
      int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int;
      int i = 3;
      if (j == 3)
      {
        if (paramInt != 1) {
          if (paramInt != 4)
          {
            if (paramInt != 8)
            {
              if (paramInt != 1024) {
                i = -1;
              } else {
                i = 1;
              }
            }
            else {
              i = 4;
            }
          }
          else {
            i = 2;
          }
        }
        LpReportInfo_pf00064.report(615, i);
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (SlideShowPhotoListManager.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, paramInt);
    }
  }
  
  private void g()
  {
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(2L, new EditVideoButton.EntryButtonInfo(2L, 2064056669, HardCodeUtil.a(2131703966)));
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(1024L, new EditVideoButton.EntryButtonInfo(1024L, 2064056667, HardCodeUtil.a(2131703929)));
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(131072L, new EditVideoButton.EntryButtonInfo(131072L, 2064056671, a().getResources().getString(2064515186)));
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(1L, new EditVideoButton.EntryButtonInfo(1L, 2064056672, HardCodeUtil.a(2131703997)));
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(8L, new EditVideoButton.EntryButtonInfo(8L, 2064056673, HardCodeUtil.a(2131703967)));
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(4L, new EditVideoButton.EntryButtonInfo(4L, 2064056663, HardCodeUtil.a(2131704002)));
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(64L, new EditVideoButton.EntryButtonInfo(64L, 2064056664, HardCodeUtil.a(2131703992)));
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(32L, new EditVideoButton.EntryButtonInfo(32L, 2064056662, HardCodeUtil.a(2131704037)));
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(16L, new EditVideoButton.EntryButtonInfo(16L, 2064056675, HardCodeUtil.a(2131704043)));
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(2048L, new EditVideoButton.EntryButtonInfo(2048L, 2064056670, "跳转到P图"));
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(16384L, new EditVideoButton.EntryButtonInfo(16384L, 2064056661, HardCodeUtil.a(2131703932)));
    jdField_b_of_type_AndroidSupportV4UtilLongSparseArray.put(65536L, new EditVideoButton.EntryButtonInfo(65536L, 2064056668, BaseApplicationImpl.getContext().getString(2064515104)));
  }
  
  private void h()
  {
    j();
    TransitionCategoryItem localTransitionCategoryItem = VideoFilterTools.a().a();
    if (localTransitionCategoryItem != null) {
      StoryReportor.a("video_edit_transition", "pub_effects", EditVideoTransfer.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_transiton_src_from", -1)), 0, new String[] { localTransitionCategoryItem.k, localTransitionCategoryItem.n, localTransitionCategoryItem.l, localTransitionCategoryItem.m });
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c() == 122) {
      AIOLongShotHelper.a("0X8009DEF");
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.h()) {
      ReportController.b(null, "dc00898", "", "", "0X800A06E", "0X800A06E", 0, 0, "", "", "", "");
    }
  }
  
  private void j()
  {
    int i;
    try
    {
      localJSONObject = new JSONObject();
      m = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.g();
      n = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c();
      if (m == 9) {
        break label612;
      }
      if (m != 2) {
        break label607;
      }
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      int m;
      int n;
      Object localObject1;
      int i1;
      String str;
      if (!QLog.isColorLevel()) {
        break label606;
      }
      QLog.e("Q.qqstory.record.EditVideoButton", 2, localException, new Object[0]);
      return;
    }
    localObject1 = a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a().a());
    Object localObject3 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a().a();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(a((FaceLayer)localObject3));
    localObject1 = ((StringBuilder)localObject4).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localJSONObject.put("sticker", localObject1);
    }
    localObject1 = (QIMCaptureVarManager)QIMManager.a(13);
    label179:
    int j;
    int k;
    if (localObject1 != null)
    {
      if (((QIMCaptureVarManager)localObject1).a() == 4)
      {
        i = 2;
      }
      else
      {
        if (((QIMCaptureVarManager)localObject1).a() != 8) {
          break label617;
        }
        i = 1;
      }
      localObject3 = ((QIMCaptureVarManager)localObject1).b();
      localObject4 = ((QIMCaptureVarManager)localObject1).a();
      if (j != 0)
      {
        localObject3 = localObject3[1];
        localObject1 = localObject4[1];
      }
      else
      {
        i1 = localObject3.length;
        k = 0;
        localObject1 = null;
        label222:
        if (k < i1)
        {
          str = localObject3[k];
          if (str == null) {
            break label622;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append(",");
          localObject1 = ((StringBuilder)localObject1).toString();
          break label622;
        }
        i1 = localObject4.length;
        k = 0;
        localObject3 = null;
        label285:
        if (k >= i1) {
          break label636;
        }
        str = localObject4[k];
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
      if ((localObject1 == null) || (((QimMusicPlayer)localObject1).b() == null)) {
        break label662;
      }
      localObject1 = String.valueOf(((QimMusicPlayer)localObject1).b().mItemId);
      label415:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localJSONObject.put("music", localObject1);
      }
      if (j != 0)
      {
        localObject1 = (QIMPtvTemplateManager)QIMManager.a(3);
        if (localObject1 == null) {
          break label668;
        }
        localObject1 = ((QIMPtvTemplateManager)localObject1).a();
        label462:
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localJSONObject.put("face", localObject1);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a().a().a();
      if (localObject1 == null) {
        break label674;
      }
      localObject1 = String.valueOf(((DynamicTextItem)localObject1).c());
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localJSONObject.put("text", localObject1);
      }
      StoryReportor.a("video_edit_new", "send_clk", c(), 0, new String[] { StoryReportor.b(m), localJSONObject.toString(), String.valueOf(i), String.valueOf(n) });
      return;
      label606:
      label607:
      j = 0;
      break;
      label612:
      j = 1;
      break;
      label617:
      i = 0;
      break label179;
      label622:
      k += 1;
      break label222;
      label629:
      k += 1;
      break label285;
      label636:
      localObject4 = localException;
      Object localObject2 = localObject3;
      localObject3 = localObject4;
      break label338;
      localObject2 = null;
      i = 0;
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
  
  private void k()
  {
    ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).downloadModule("cyber_clink_version_2.jar", new EditVideoButton.2(this));
  }
  
  public View a()
  {
    LongSparseArray localLongSparseArray = this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray;
    if (localLongSparseArray != null) {
      return (View)localLongSparseArray.get(16L);
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2064122005));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2064122068));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2064122069));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131703917));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2064122067));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = a(2064122145);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    b(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = a(this.jdField_a_of_type_Int, this);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2064122007));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2064122006));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2064122719));
    if ((this.jdField_a_of_type_Int & 0x200) != 0)
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager instanceof QzEditVideoPartManager)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2064056684);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2064122718));
    if ((this.jdField_a_of_type_Int & 0x8000) != 0)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if ((((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).isModuleDownloaded("cyber_clink_version_2.jar")) && (!((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).checkIfNeedUpdate("cyber_clink_version_2.jar"))) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        k();
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    a(new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView });
    a(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView);
    this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(3, ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F }));
    this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(3, 500L);
    this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(2, ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F }));
    this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(2, 500L);
    a(EditButtonExport.class, this);
    this.jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("showFlashPic", true);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_AndroidOsBundle;
    if (localObject != null) {
      this.e = ((Bundle)localObject).getBoolean("key_enable_edit_title_bar", false);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c())
    {
      localObject = this.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = UIUtils.a(a(), 28.0F);
        this.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
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
      a((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(131072L));
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
        this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(a().getColor(2131165341));
      }
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
      a((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(65536L));
      b(false, false, true);
      return;
    case 17: 
      a((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(16L));
      b(false, false, true);
      return;
    case 16: 
      if (paramInt1 == 15)
      {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        return;
      }
      break;
    case 15: 
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    case 14: 
      a((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(32L));
      b(false, false, true);
      return;
    case 13: 
      a((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(64L));
      b(false, false, true);
      return;
    case 11: 
      a(false, true, false);
      VideoEditReport.b("0X80080E5", VideoEditReport.jdField_a_of_type_Int);
      return;
    case 10: 
      a((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(2048L));
      return;
    case 9: 
      a(null);
      a(true, false);
      return;
    case 8: 
      a(false, false);
      return;
    case 7: 
      a((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(4L));
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
      a((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(1024L));
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
        this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(a().getColor(2131165341));
      }
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
      a((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(8L));
      b(false, false, true);
      return;
    case 2: 
      if ((paramInt1 != paramInt2) && (this.jdField_b_of_type_Boolean)) {
        a((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(1L));
      }
      int j = -1;
      int i = j;
      if (paramObject != null)
      {
        i = j;
        if ((paramObject instanceof Integer)) {
          i = ((Integer)paramObject).intValue();
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
        paramObject.append(i);
        QLog.i("Q.qqstory.record.EditVideoButton", 2, paramObject.toString());
      }
      if (i == 0) {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      } else {
        a(true, false);
      }
      b(false, false, true);
      if ((this.e) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()))
      {
        paramObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if ((paramObject != null) && (paramObject.getVisibility() == 0)) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
        paramObject = this.jdField_b_of_type_AndroidWidgetImageView;
        if ((paramObject != null) && (paramObject.getVisibility() == 0))
        {
          a(4);
          return;
        }
      }
      break;
    case 1: 
      a((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(2L));
      b(false, false, true);
      return;
    case 0: 
      a(null);
      this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_c_of_type_Int);
      if (paramInt1 == 6) {
        a(true, true, false);
      } else if (paramInt1 == 11) {
        a(true, true, false);
      } else {
        a(true, false);
      }
      if (this.d)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 12, 3, (int)this.jdField_a_of_type_Long));
        this.d = false;
      }
      if ((this.e) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()))
      {
        paramObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if ((paramObject != null) && (paramObject.getVisibility() != 0)) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        paramObject = this.jdField_b_of_type_AndroidWidgetImageView;
        if ((paramObject != null) && (paramObject.getVisibility() != 0) && ((this.jdField_a_of_type_Int & 0x200) != 0)) {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
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
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.size())
    {
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(i);
      if (localImageView != null)
      {
        localImageView.getDrawable().clearColorFilter();
        localImageView.clearColorFilter();
      }
      i += 1;
    }
    if (paramImageView != null) {
      paramImageView.setColorFilter(a().getColor(2131166325), PorterDuff.Mode.SRC_IN);
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
    int i;
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
      if (paramBoolean1) {
        i = 0;
      } else {
        i = 8;
      }
      localViewGroup.setVisibility(i);
      this.jdField_a_of_type_Long = 0L;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 11, Long.valueOf(this.jdField_a_of_type_Long)));
    if (paramBoolean1)
    {
      i = 0;
      while (i < this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.size())
      {
        ((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(i)).setVisibility(0);
        i += 1;
      }
    }
    if (paramBoolean1)
    {
      if (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      }
    }
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() < this.jdField_a_of_type_Long;
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(paramMessage.arg1);
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
  
  public void b()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.get(16L);
    if (localImageView != null) {
      localImageView.setImageResource(2064056674);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    if (paramBoolean2)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.jdField_a_of_type_Long += 500L;
      }
      if (paramBoolean1) {
        TakeVideoUtils.a(this.jdField_b_of_type_AndroidViewViewGroup, paramBoolean3);
      } else {
        TakeVideoUtils.a(this.jdField_b_of_type_AndroidViewViewGroup);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidViewViewGroup.setAnimation(null);
      ViewGroup localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
      if (paramBoolean1) {
        i = 0;
      } else {
        i = 8;
      }
      localViewGroup.setVisibility(i);
      this.jdField_a_of_type_Long = 0L;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 11, Long.valueOf(this.jdField_a_of_type_Long)));
    if (paramBoolean1)
    {
      i = 0;
      while (i < this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.size())
      {
        ((ImageView)this.jdField_a_of_type_AndroidSupportV4UtilLongSparseArray.valueAt(i)).setVisibility(0);
        i += 1;
      }
    }
  }
  
  public void d()
  {
    super.d();
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.f == 0) && (!this.jdField_c_of_type_Boolean))
    {
      if (((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditTakeVideoSource)))
      {
        int i = AIOUtils.b(-48.0F, a());
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidViewViewGroup, "translationY", new float[] { i, 0.0F });
        localObjectAnimator1.setDuration(800L);
        i = AIOUtils.b(a().getDimension(2131298148), a());
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewViewGroup, "translationY", new float[] { i, 0.0F });
        localObjectAnimator2.setDuration(800L);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
        localAnimatorSet.start();
      }
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void onClick(View paramView)
  {
    if (Math.abs(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) > 500L)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      int k = paramView.getId();
      long l1 = this.jdField_a_of_type_Long;
      long l2 = System.currentTimeMillis();
      int j = 1;
      if (l1 > l2)
      {
        SLog.d("Q.qqstory.record.EditVideoButton", "animation is playing, please wait, animation end time: %d, now: %d.", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(System.currentTimeMillis()) });
        return;
      }
      Object localObject1 = jdField_a_of_type_ArrayOfInt;
      int m = localObject1.length;
      int i = 0;
      while (i < m)
      {
        if (localObject1[i] == k)
        {
          l1 = ((Long)this.jdField_a_of_type_AndroidUtilSparseArray.get(k)).longValue();
          SLog.d("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Long.valueOf(l1), paramView });
          localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager;
          Object localObject2 = null;
          i = ((EditVideoPartManager)localObject1).a(Message.obtain(null, 1, new Object[] { Long.valueOf(l1), paramView }));
          if (i > 0)
          {
            paramView = new StringBuilder();
            paramView.append("%d parts intercept the click event : ");
            paramView.append(i);
            SLog.c("Q.qqstory.record.EditVideoButton", paramView.toString());
            return;
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.r();
          m = (int)(0xFFFFFFFF & l1);
          if (m != 1)
          {
            if (m != 2)
            {
              i = 4;
              if (m != 4)
              {
                k = 3;
                if (m != 8)
                {
                  if (m != 16)
                  {
                    if (m != 32)
                    {
                      if (m != 64)
                      {
                        if (m != 1024)
                        {
                          if (m != 2048)
                          {
                            if (m != 16384)
                            {
                              if (m != 65536)
                              {
                                if (m == 131072)
                                {
                                  if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(25))
                                  {
                                    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
                                    i = -1;
                                  }
                                  else
                                  {
                                    i = 25;
                                  }
                                  AEBaseDataReporter.a().aS();
                                  break label1264;
                                }
                              }
                              else if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(21))
                              {
                                this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
                              }
                              else
                              {
                                i = 21;
                                break label1264;
                              }
                            }
                            else
                            {
                              if (SlideShowPhotoListManager.a().b() == 22) {
                                LpReportInfo_pf00064.allReport(680, 2, 2);
                              }
                              localObject1 = new ArrayList(SlideShowPhotoListManager.a().a());
                              QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
                              Bundle localBundle = new Bundle();
                              localBundle.putParcelableArrayList("qzone_slide_show_matters", (ArrayList)localObject1);
                              QZoneHelper.forwardToQzDynamicEditVideoActivity(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity(), localUserInfo, localBundle, 666);
                            }
                          }
                          else
                          {
                            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.f == 10) {
                              this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
                            } else {
                              this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(10);
                            }
                            i = j;
                            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int != 2)
                            {
                              i = j;
                              if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int != 5) {
                                if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 6) {
                                  i = j;
                                } else {
                                  i = 0;
                                }
                              }
                            }
                            StoryReportor.a("video_edit_aio", "ttpt_clk", 0, i, new String[0]);
                            StoryReportor.a("video_edit_new", "clk_pitu", 0, i, new String[0]);
                          }
                        }
                        else
                        {
                          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(4))
                          {
                            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
                            i = -1;
                          }
                          AEBaseDataReporter.a().aR();
                          VideoEditReport.b("0X80075C4", VideoEditReport.jdField_a_of_type_Int);
                          StoryReportor.b("clk_graffiti", c(), 0, new String[0]);
                          c(1024);
                          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
                            EditActivityEntranceUtil.a("0X800B3C5", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c());
                          }
                          break label1264;
                        }
                      }
                      else
                      {
                        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(13)) {
                          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
                        } else {
                          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(13);
                        }
                        AEBaseDataReporter.a().aV();
                        i = c();
                        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
                          localObject1 = "1";
                        } else {
                          localObject1 = "2";
                        }
                        StoryReportor.a("video_edit_new", "clk_filter", i, 0, new String[] { "", localObject1, "", "" });
                      }
                    }
                    else
                    {
                      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager;
                      i = 14;
                      if (((EditVideoPartManager)localObject1).a(14))
                      {
                        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
                        i = -1;
                      }
                      StoryReportor.b("clk_effect", c(), 0, new String[0]);
                      d(10);
                      break label1264;
                    }
                  }
                  else
                  {
                    localObject1 = (EditTransferExport)a(EditTransferExport.class);
                    if (localObject1 != null)
                    {
                      if (((EditTransferExport)localObject1).a() == 0)
                      {
                        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(17))
                        {
                          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
                          i = -1;
                        }
                        else
                        {
                          i = 17;
                        }
                        StoryReportor.a("video_edit_transition", "clk_transition", EditVideoTransfer.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_transiton_src_from", -1)), 0, new String[0]);
                        d(11);
                        break label1264;
                      }
                      ((EditTransferExport)localObject1).b();
                      StoryReportor.a("video_edit_transition", "exp_toastFail", EditVideoTransfer.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_transiton_src_from", -1)), 0, new String[0]);
                    }
                  }
                }
                else
                {
                  i = k;
                  if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(3))
                  {
                    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
                    i = -1;
                  }
                  AEBaseDataReporter.a().aU();
                  VideoEditReport.b("0X80075C7", VideoEditReport.jdField_a_of_type_Int);
                  c(8);
                  StoryReportor.a("video_edit_new", "clk_sticker", c(), 0, new String[0]);
                  d(12);
                  break label1264;
                }
              }
              else
              {
                this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.s();
                AEBaseDataReporter.a().aW();
                VideoEditReport.b("0X80075C5", VideoEditReport.jdField_a_of_type_Int);
                c(4);
                StoryReportor.a("video_edit_new", "clk_cut", c(), 0, new String[0]);
                EditActivityEntranceUtil.a("0X800B3C7", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c());
              }
            }
            else
            {
              if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(1))
              {
                this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
                i = -1;
              }
              else
              {
                i = 1;
              }
              AEBaseDataReporter.a().aX();
              d(1);
              StoryReportor.b("clk_music", c(), 0, new String[0]);
              break label1264;
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(2)) {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
            } else {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.u();
            }
            AEBaseDataReporter.a().aT();
            VideoEditReport.b("0X80075C6", VideoEditReport.jdField_a_of_type_Int);
            StoryReportor.b("clk_text", c(), 0, new String[0]);
            c(1);
            d(9);
            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
              EditActivityEntranceUtil.a("0X800B3C9", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c());
            }
          }
          i = -1;
          label1264:
          localObject1 = localObject2;
          if (i != -1) {
            localObject1 = new EditVideoButton.1(this, i);
          }
          if ((jdField_b_of_type_Int & l1) == l1) {
            PressScaleAnimDelegate.a(paramView, 200L, (View.OnClickListener)localObject1);
          }
          return;
        }
        i += 1;
      }
      a(paramView);
      return;
    }
    SLog.d("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoButton
 * JD-Core Version:    0.7.0.1
 */