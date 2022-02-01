package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureRecord;
import com.tencent.aelight.camera.aioeditor.capture.data.ComboSet;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMProviderViewBuilder;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.ProviderViewListener;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderViewEditContainer;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.TransitionProviderView;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.AEFilterContentView;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.Pair;
import com.tencent.widget.ScaleGestureDetector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class EditProviderPart
  extends EditVideoPart
  implements ProviderView.ProviderViewListener, EditProviderExport, DoodleLayout.DoodleEventListener
{
  public static String a = "EditProviderPart";
  public int a;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected View a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoFilterViewPager jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager;
  private QIMProviderViewBuilder jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder;
  private ProviderView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
  public ProviderViewEditContainer a;
  private DoodleLayout jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
  private AEFilterContentView jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetAEFilterContentView;
  private ScaleGestureDetector jdField_a_of_type_ComTencentWidgetScaleGestureDetector;
  private HashMap<Integer, ProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public EditProviderPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Int = -1;
  }
  
  private Bundle a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null) {
      return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return null;
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
    if (localObject != null)
    {
      ((ProviderView)localObject).d();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView = null;
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    else
    {
      ProviderView localProviderView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.a(a(), paramInt);
      if (localProviderView != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localProviderView);
      }
      localObject = localProviderView;
      if ((localProviderView instanceof TransitionProviderView))
      {
        i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_transiton_src_from", -1);
        ((TransitionProviderView)localProviderView).jdField_b_of_type_Int = i;
        localObject = localProviderView;
      }
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("build provider view failed ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.e("EditProviderPart", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (!((ProviderView)localObject).d())
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout == null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a();
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramInt = ((ProviderView)localObject).c();
        i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        ((ProviderView)localObject).d(paramInt + (int)UIUtils.a(a(), i));
      }
      ((ProviderView)localObject).a(a());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView = ((ProviderView)localObject);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.getId() != 2131364288) {
      b(false);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setVisibility(0);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.c();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager;
      if (EditVideoPartManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c, 16))
      {
        localObject1 = ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData;
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "comboFilterData null");
          }
          return;
        }
        localObject1 = ((VideoFilterTools.ComboFilterData)localObject1).b();
        if ((localObject1 != null) && (((List)localObject1).size() < 3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "recommend trans less than 3");
          }
          return;
        }
        this.jdField_c_of_type_AndroidViewView = a(2064122729);
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          Object localObject2;
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.r)
          {
            localObject2 = (RelativeLayout)a(2064122152);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
            localLayoutParams.bottomMargin = 0;
            localLayoutParams.addRule(12, -1);
            localLayoutParams.addRule(2, 0);
            ((ViewGroup)this.jdField_c_of_type_AndroidViewView.getParent()).removeView(this.jdField_c_of_type_AndroidViewView);
            ((RelativeLayout)localObject2).addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
          }
          else
          {
            localObject2 = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
            ((RelativeLayout.LayoutParams)localObject2).addRule(2, 0);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        this.jdField_c_of_type_AndroidViewView.postDelayed(new EditProviderPart.2(this, (List)localObject1), 1000L);
      }
    }
  }
  
  private void r()
  {
    s();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.getAdapter() != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetAEFilterContentView.a() > this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.getAdapter().getCount() / 100)) {
      d(false);
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetAEFilterContentView == null)
    {
      AEQLog.a("EditProviderPart", "view is null.");
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetAEFilterContentView = new AEFilterContentView(a());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetAEFilterContentView);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetAEFilterContentView.setProviderViewListener(this);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetAEFilterContentView.a(b());
  }
  
  public int a()
  {
    return (int)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a());
  }
  
  public <T extends ProviderView> T a(Class<? extends ProviderView> paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      ProviderView localProviderView = (ProviderView)localIterator.next();
      if (paramClass.isInstance(localProviderView)) {
        return localProviderView;
      }
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    a(EditProviderExport.class, this);
    int i = b();
    this.jdField_a_of_type_Int = i;
    VideoFilterTools.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2064122514));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2064122190));
    this.jdField_b_of_type_AndroidViewView = a(2064122059);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (j <= 0) {
        localLayoutParams.height += LiuHaiUtils.e;
      } else {
        localLayoutParams.height += j;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
      localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      if (j <= 0) {
        localLayoutParams.height += LiuHaiUtils.e;
      } else {
        localLayoutParams.height += j;
      }
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder = new QIMProviderViewBuilder(i);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)a(2064122522));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.setReadyToApply(false);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.setCaptureScene(this.jdField_a_of_type_Int);
    if (AECameraEntry.c.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.f)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.jdField_a_of_type_Boolean = true;
    }
    d(true);
    this.jdField_a_of_type_ComTencentWidgetScaleGestureDetector = new ScaleGestureDetector(a(), new EditProviderPart.ScaleDetectorListener(this, null));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new EditProviderPart.TapDetectorListener(this, null));
    this.jdField_a_of_type_AndroidViewView = a(2064122523);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new EditProviderPart.1(this));
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi instanceof EditVideoActivity)) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2064122146));
    }
    e(true);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer == null)
    {
      ((ViewStub)a(2064122524)).inflate();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)a(2064122513));
      i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.h();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer.a(i);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer.setProviderViewListener(this);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(16);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(paramInt);
    ProviderViewEditContainer localProviderViewEditContainer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer;
    if (localProviderViewEditContainer != null) {
      localProviderViewEditContainer.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (1 == paramInt1) {
      QQToast.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), HardCodeUtil.a(2131703851), 0).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (paramInt != -1) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.setCurrentItem(paramInt, false);
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if ((QIMFilterProviderView)a(QIMFilterProviderView.class) != null)
    {
      boolean bool;
      if (VideoFilterTools.a().b(this.jdField_a_of_type_Int) != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramGenerateContext.jdField_c_of_type_Boolean = bool;
      if ((paramGenerateContext.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()))
      {
        paramGenerateContext = paramGenerateContext.a;
        paramGenerateContext.jdField_a_of_type_Int += 1;
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    this.jdField_b_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 17)
          {
            if (paramInt != 24)
            {
              if (paramInt != 13)
              {
                if (paramInt != 14)
                {
                  h();
                  return;
                }
                c(106);
                return;
              }
              r();
              return;
            }
            if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()))
            {
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.c();
              this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.a(0, true);
            }
          }
          else
          {
            c(108);
          }
        }
        else {
          c(103);
        }
      }
      else
      {
        c(104);
        if (SlideShowPhotoListManager.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 3, 1);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
      h();
      paramObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer;
      if (paramObject != null) {
        paramObject.a();
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Object localObject = new Pair(Integer.valueOf(paramInt), paramVarArgs);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(15, localObject);
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer;
    if (localObject != null) {
      ((ProviderViewEditContainer)localObject).a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(LocationFacePackage.Item paramItem)
  {
    ((StoryConfigManager)SuperManager.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int j = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject1 = (CaptureComboManager)QIMManager.a(5);
      Object localObject2 = localObject1.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureDataCaptureComboManager$CaptureRecord[this.jdField_a_of_type_Int].jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataComboSet;
      int i = j;
      if (localObject2 != null)
      {
        localObject2 = (QIMFilterCategoryItem)((ComboSet)localObject2).a;
        i = j;
        if (localObject2 != null)
        {
          localJSONObject.put("comboItem", ((QIMFilterCategoryItem)localObject2).a());
          i = 1;
        }
      }
      localObject1 = localObject1.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureDataCaptureComboManager$CaptureRecord[this.jdField_a_of_type_Int].jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataFilterSet;
      j = i;
      if (localObject1 != null)
      {
        localObject1 = (QIMFilterCategoryItem)((FilterSet)localObject1).a;
        j = i;
        if (localObject1 != null)
        {
          localJSONObject.put("filterItem", ((QIMFilterCategoryItem)localObject1).a());
          j = 1;
        }
      }
      localObject1 = ((QimMusicPlayer)QIMManager.a().c(8)).a();
      if (localObject1 != null)
      {
        localJSONObject.put("musicItem", ((MusicItemInfo)localObject1).convertToJSON());
        j = 1;
      }
      if (j != 0) {
        paramJSONObject.put(jdField_a_of_type_JavaLangString, localJSONObject);
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(byte[] paramArrayOfByte) {}
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.d())
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
      return 1;
    }
    return 2;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    ((EditTransferExport)a(EditTransferExport.class)).a(paramInt);
  }
  
  public void b(int paramInt, Object paramObject)
  {
    if (paramInt == 7) {
      h();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(104));
    MusicItemInfo localMusicItemInfo = ((QimMusicPlayer)QIMManager.a().c(8)).a();
    if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.needPlay())) && (localMusicProviderView.b())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi != null) && ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi instanceof EditVideoActivity)) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity() != null)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().runOnUiThread(new EditProviderPart.4(this, paramBoolean));
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 2, 0));
  }
  
  public void d()
  {
    super.d();
    VideoFilterTools.a().a(this.jdField_a_of_type_Int);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).e();
    }
    ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureDataCaptureComboManager$CaptureRecord[this.jdField_a_of_type_Int].a((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    if (!this.jdField_b_of_type_Boolean) {
      ThreadManager.getUIHandler().postDelayed(new EditProviderPart.3(this), 500L);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    VideoFilterTools.ComboFilterData localComboFilterData = ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterTools$ComboFilterData;
    if (localComboFilterData != null)
    {
      VideoFilterViewPager localVideoFilterViewPager = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager;
      if (localVideoFilterViewPager != null)
      {
        localVideoFilterViewPager.a(VideoFilterTools.ComboFilterData.a(localComboFilterData.a(this.jdField_a_of_type_Int).c));
        if (!paramBoolean) {
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager.b();
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (localComboFilterData == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager == null) {
        bool = true;
      }
      QLog.d("EditProviderPart", 2, new Object[] { "comboFilterData is null, ", Boolean.valueOf(paramBoolean), " ", Boolean.valueOf(bool) });
    }
  }
  
  public void e()
  {
    super.e();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a();
    }
    VideoFilterTools.a().b();
  }
  
  void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preloadProviderView count");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.a());
      QLog.d("EditProviderPart", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.a())
    {
      int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.c(i);
      if (((!paramBoolean) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.b(j))) && ((ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)) == null))
      {
        ProviderView localProviderView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.a(a(), j);
        if (localProviderView != null)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilQIMProviderViewBuilder.c(i)), localProviderView);
          localProviderView.setProviderViewListener(this);
          localProviderView.setDoodleEventListener(this);
          localProviderView.b((Bundle)localObject);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
          localProviderView.setVisibility(8);
          if ((localProviderView instanceof TransitionProviderView))
          {
            j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_transiton_src_from", -1);
            ((TransitionProviderView)localProviderView).jdField_b_of_type_Int = j;
          }
          if (!paramBoolean) {
            localProviderView.e();
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("preloadProviderView failed ");
          ((StringBuilder)localObject).append(i);
          QLog.e("EditProviderPart", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      i += 1;
    }
  }
  
  public void g()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void h()
  {
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView;
    if (localObject != null)
    {
      ((ProviderView)localObject).d();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderView = null;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void i()
  {
    super.i();
    ProviderViewEditContainer localProviderViewEditContainer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer;
    if (localProviderViewEditContainer != null) {
      localProviderViewEditContainer.b();
    }
    ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureDataCaptureComboManager$CaptureRecord[this.jdField_a_of_type_Int].c((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
  }
  
  public void j()
  {
    VideoFilterViewPager localVideoFilterViewPager = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaVideoFilterViewPager;
    if (localVideoFilterViewPager != null) {
      localVideoFilterViewPager.c();
    }
  }
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void v_()
  {
    q();
  }
  
  public void z_()
  {
    super.z_();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart
 * JD-Core Version:    0.7.0.1
 */