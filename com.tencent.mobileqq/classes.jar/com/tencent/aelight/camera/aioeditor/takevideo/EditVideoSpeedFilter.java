package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.filter.FilterData;
import com.tencent.aelight.camera.aioeditor.takevideo.filter.FilterData.FilterPageItem;
import com.tencent.aelight.camera.aioeditor.takevideo.filter.VideoEffectsFilterData;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer;
import com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer.PickerContainerListener;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class EditVideoSpeedFilter
  extends EditVideoPart
  implements EditFilterExport, PickerContainer.PickerContainerListener
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d = HardCodeUtil.a(2131703887);
  public static final String e = HardCodeUtil.a(2131704010);
  public static final String f = HardCodeUtil.a(2131704031);
  public int a;
  protected SparseArray<FilterData> a;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  protected EditVideoSpeedFilter.FilterPagerAdapter a;
  public PickerContainer a;
  protected UnHandleTouchEventViewPager a;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  public long b;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131703989);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131704014);
    jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131703918);
  }
  
  public EditVideoSpeedFilter(@NonNull EditVideoPartManager paramEditVideoPartManager, boolean paramBoolean)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = b();
    }
    paramEditVideoPartManager = new StringBuilder();
    paramEditVideoPartManager.append("EditVideoSpeedFilter : enable: ");
    paramEditVideoPartManager.append(this.jdField_c_of_type_Boolean);
    SLog.b("EditVideoSpeedFilter", paramEditVideoPartManager.toString());
  }
  
  public static int a(@NonNull FilterData paramFilterData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSpecialSaveMode : mVideoPlayMode = ");
    localStringBuilder.append(paramFilterData.jdField_a_of_type_Int);
    SLog.b("EditVideoSpeedFilter", localStringBuilder.toString());
    int i = paramFilterData.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 8)
            {
              if (i != 9) {
                return 0;
              }
              return 4;
            }
            return 3;
          }
          return 2;
        }
        return 1;
      }
      return 5;
    }
    return 0;
  }
  
  private void a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 4) && (paramInt != 8)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getVisibility() != paramInt) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setVisibility(paramInt);
    }
  }
  
  protected static void a(FilterData.FilterPageItem paramFilterPageItem)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    paramFilterPageItem.a.startAnimation(localAlphaAnimation);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Int == 2) {
      return;
    }
    PickerContainer localPickerContainer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer;
    if (localPickerContainer != null) {
      if (paramBoolean)
      {
        if (localPickerContainer.getVisibility() != 0) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer.setVisibility(0);
        }
      }
      else if ((localPickerContainer.getVisibility() != 4) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer.getVisibility() != 8)) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer.setVisibility(4);
      }
    }
  }
  
  private int b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transSpecialPlayMode : nSpeedIndex = ");
    localStringBuilder.append(paramInt);
    SLog.b("EditVideoSpeedFilter", localStringBuilder.toString());
    if (SlideShowPhotoListManager.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, 13);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return 1;
              }
              if (SlideShowPhotoListManager.a().b() == 22) {
                LpReportInfo_pf00064.allReport(680, 10, 6);
              }
              return 1;
            }
            if (SlideShowPhotoListManager.a().b() == 22) {
              LpReportInfo_pf00064.allReport(680, 10, 5);
            }
            return 9;
          }
          if (SlideShowPhotoListManager.a().b() == 22) {
            LpReportInfo_pf00064.allReport(680, 10, 4);
          }
          return 3;
        }
        if (SlideShowPhotoListManager.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 1);
        }
        return 0;
      }
      if (SlideShowPhotoListManager.a().b() == 22) {
        LpReportInfo_pf00064.allReport(680, 10, 2);
      }
      return 8;
    }
    if (SlideShowPhotoListManager.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 10, 3);
    }
    return 2;
  }
  
  private boolean b()
  {
    boolean bool = "Meizu".equalsIgnoreCase(Build.MANUFACTURER);
    Boolean localBoolean = Boolean.valueOf(true);
    if ((bool) && ("MX4 Pro".equalsIgnoreCase(Build.MODEL))) {
      bool = false;
    } else {
      bool = true;
    }
    if (!bool) {
      SLog.d("EditVideoSpeedFilter", "Meizu MX4 Pro, in blacklist");
    }
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    if (localStoryConfigManager == null)
    {
      SLog.d("EditVideoSpeedFilter", "storyConfigManager == null !!!");
      return bool;
    }
    if ((bool) && (((Boolean)localStoryConfigManager.b("boolean_enable_fast_play_mode", localBoolean)).booleanValue()) && (((Boolean)localStoryConfigManager.b("boolean_enable_revert_play_mode", localBoolean)).booleanValue()) && (((Boolean)localStoryConfigManager.b("boolean_enable_slow_play_mode", localBoolean)).booleanValue())) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {
      SLog.d("EditVideoSpeedFilter", "black model, manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
    }
    return bool;
  }
  
  private int c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transSpecialPlayMode : nPlayMode = ");
    localStringBuilder.append(paramInt);
    SLog.b("EditVideoSpeedFilter", localStringBuilder.toString());
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 8)
            {
              if (paramInt != 9) {
                return 2;
              }
              return 4;
            }
            return 1;
          }
          return 3;
        }
        return 0;
      }
      return 5;
    }
    return 2;
  }
  
  private void e(int paramInt, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onPlayModeChanged:");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("  ");
    ((StringBuilder)localObject1).append(paramString);
    SLog.b("EditVideoSpeedFilter", ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a;
    int k = 0;
    int i = 0;
    int j;
    Object localObject2;
    for (;;)
    {
      j = k;
      if (i >= ((List)localObject1).size()) {
        break;
      }
      localObject2 = (FilterData)((List)localObject1).get(i);
      if ((!TextUtils.isEmpty(((FilterData)localObject2).jdField_a_of_type_JavaLangString)) && (((FilterData)localObject2).jdField_a_of_type_Int == paramInt))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(i, false);
        j = 1;
        break;
      }
      i += 1;
    }
    if (j == 0)
    {
      localObject1 = a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131703954));
      ((StringBuilder)localObject2).append(paramString);
      QQToast.a((Context)localObject1, ((StringBuilder)localObject2).toString(), 1000).a();
    }
  }
  
  private void g()
  {
    ThreadManager.getUIHandler().postDelayed(new EditVideoSpeedFilter.1(this), 500L);
  }
  
  public int a()
  {
    return a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a());
  }
  
  public int a(int paramInt)
  {
    FilterData localFilterData = (FilterData)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localFilterData == null) {
      return 0;
    }
    return a(localFilterData);
  }
  
  @Nullable
  public View a()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    FilterData.FilterPageItem localFilterPageItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(i);
    if ((localFilterPageItem != null) && (localFilterPageItem.a())) {
      return localFilterPageItem.a;
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter = new EditVideoSpeedFilter.FilterPagerAdapter(a());
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)a(2064122066));
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new EditVideoSpeedFilter.FilterPageChangeListener(this, null));
    b();
    a(EditFilterExport.class, this);
    g();
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    Object localObject = (FilterData)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.d()) {
      paramGenerateContext.a.localCreateCity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a("extra_local_address_city_name");
    }
    paramGenerateContext.a(a());
    paramGenerateContext.a.saveMode = a(paramInt);
    boolean bool = false;
    String str;
    int j;
    if (localObject != null)
    {
      str = ((FilterData)localObject).jdField_a_of_type_JavaLangString;
      j = ((FilterData)localObject).jdField_b_of_type_Int;
      int k = ((FilterData)localObject).jdField_a_of_type_Int;
      paramGenerateContext = str;
      i = j;
      paramInt = k;
      if (((FilterData)localObject).jdField_b_of_type_Int != -1)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().setFilterId(((FilterData)localObject).jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().setFilterType(2);
        paramGenerateContext = str;
        i = j;
        paramInt = k;
      }
    }
    else
    {
      paramGenerateContext = "";
      i = -1;
      paramInt = 0;
    }
    localObject = "2";
    if (i != -1)
    {
      EditVideoPartManager localEditVideoPartManager = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager;
      j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b();
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
        str = "2";
      } else {
        str = "1";
      }
      localEditVideoPartManager.a("pub_filter_menu", j, 0, new String[] { String.valueOf(i), paramGenerateContext, str });
    }
    if (i != -1) {
      VideoEditReport.a("0X80076E9", String.valueOf(VideoEditReport.jdField_b_of_type_Int), String.valueOf(paramInt), paramGenerateContext, String.valueOf(i));
    }
    long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    int i = this.jdField_a_of_type_Int;
    SLog.a("EditVideoSpeedFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l), Integer.valueOf(i));
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()) {
      paramGenerateContext = (GenerateContext)localObject;
    } else {
      paramGenerateContext = "1";
    }
    StoryReportor.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l), String.valueOf(i), paramGenerateContext });
    paramGenerateContext = (IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class);
    if (paramInt != 0) {
      bool = true;
    }
    paramGenerateContext.setEditSpeedChanged(bool);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 4)) {
      if ((paramInt != 5) && (paramInt != 6))
      {
        if (paramInt != 11)
        {
          if (paramInt != 12)
          {
            a(true);
            a(4);
            return;
          }
          paramInt = c(this.jdField_a_of_type_Int);
          paramObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer;
          if (paramObject != null) {
            paramObject.a(paramInt, false);
          }
          a(true);
          a(0);
        }
      }
      else
      {
        a(false);
        a(0);
        return;
      }
    }
    a(true);
    a(0);
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPickSpeedStart:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramString);
    SLog.b("EditVideoSpeedFilter", localStringBuilder.toString());
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a(int paramInt)
  {
    FilterData localFilterData = (FilterData)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    return (localFilterData != null) && (localFilterData.a());
  }
  
  public boolean a(int paramInt1, Canvas paramCanvas, int paramInt2, int paramInt3)
  {
    paramInt1 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1);
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getWidth();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getHeight();
    Object localObject2 = null;
    if (localObject1 != null)
    {
      if (((FilterData.FilterPageItem)localObject1).a())
      {
        localObject2 = ((FilterData.FilterPageItem)localObject1).a;
        localObject1 = null;
      }
      else
      {
        localObject1 = null;
      }
    }
    else
    {
      localObject2 = new FrameLayout(a());
      ((View)localObject2).setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getLayoutParams()));
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.instantiateItem((ViewGroup)localObject2, paramInt1);
      ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getMeasuredHeight(), 1073741824));
      ((View)localObject2).layout(0, 0, this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getWidth(), this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getHeight());
    }
    if (localObject2 != null)
    {
      paramCanvas.save();
      paramCanvas.scale(paramInt2 / i, paramInt3 / j);
      ((View)localObject2).draw(paramCanvas);
      paramCanvas.restore();
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.destroyItem((ViewGroup)localObject2, paramInt1, localObject1);
      }
      return true;
    }
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      int i = paramMessage.what;
      boolean bool = false;
      if (i != 12)
      {
        if (i != 21)
        {
          if (i == 22) {
            a(true);
          }
        }
        else {
          a(false);
        }
      }
      else
      {
        this.jdField_b_of_type_Int = paramMessage.arg1;
        paramMessage = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer;
        if (paramMessage != null)
        {
          i = this.jdField_b_of_type_Int;
          if ((i == 1) || (i == 3)) {
            bool = true;
          }
          paramMessage.a(bool, this.jdField_a_of_type_Long);
        }
        return true;
      }
    }
    return super.a(paramMessage);
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    FilterData localFilterData = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(i);
    if (localFilterData != null) {
      return localFilterData.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public void b()
  {
    SLog.a("EditVideoSpeedFilter", "updateFilterMode : %s", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource);
    ArrayList localArrayList = new ArrayList();
    boolean bool = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditTakeVideoSource;
    int i = 0;
    if ((bool) || ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      Object localObject = (StoryConfigManager)SuperManager.a(10);
      localArrayList.add(new VideoEffectsFilterData(jdField_a_of_type_JavaLangString, -1, 0, 0));
      if (!((Boolean)((StoryConfigManager)localObject).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue())
      {
        SLog.d("EditVideoSpeedFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
      else
      {
        localArrayList.add(new VideoEffectsFilterData(jdField_b_of_type_JavaLangString, 1, 0, 2));
        localArrayList.add(new VideoEffectsFilterData(e, 9, 0, 8));
      }
      if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL))) {
        if (!((Boolean)((StoryConfigManager)localObject).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue())
        {
          SLog.d("EditVideoSpeedFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.jdField_a_of_type_Int == 11) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.f()))
        {
          SLog.d("EditVideoSpeedFilter", "it's tribe slow black model, disable slow!");
        }
        else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.jdField_a_of_type_Int == 12) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.f()))
        {
          SLog.d("EditVideoSpeedFilter", "it's readinjoy slow black model, disable slow!");
        }
        else
        {
          localArrayList.add(new VideoEffectsFilterData(jdField_c_of_type_JavaLangString, 2, 0, 3));
          localArrayList.add(new VideoEffectsFilterData(f, 10, 0, 9));
          this.jdField_a_of_type_Boolean = true;
        }
      }
      if (!(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        if (!((Boolean)((StoryConfigManager)localObject).b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue())
        {
          SLog.d("EditVideoSpeedFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.jdField_a_of_type_Int == 11) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.e()))
        {
          SLog.d("EditVideoSpeedFilter", "it's tribe revert black model, disable revert!");
        }
        else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.jdField_a_of_type_Int == 12) && (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.e()))
        {
          SLog.d("EditVideoSpeedFilter", "it's tribe readinjoy black model, disable revert!");
        }
        else
        {
          VideoEffectsFilterData localVideoEffectsFilterData = new VideoEffectsFilterData(d, 3, 0, 1);
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.g()) {
            localObject = HardCodeUtil.a(2131704005);
          } else {
            localObject = null;
          }
          localVideoEffectsFilterData.jdField_b_of_type_JavaLangString = ((String)localObject);
          localArrayList.add(localVideoEffectsFilterData);
        }
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (!localArrayList.isEmpty()) {
      i = ((FilterData)localArrayList.get(0)).jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_Int = i;
  }
  
  public void b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPickSpeed:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" moving:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    SLog.b("EditVideoSpeedFilter", localStringBuilder.toString());
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    e(b(paramInt), paramString);
    paramString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(EditProviderExport.class);
    if ((paramString instanceof EditProviderExport)) {
      ((EditProviderExport)paramString).g();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(Message.obtain(null, 9, 12, paramInt));
  }
  
  public void c(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSpeedPickEnd:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramString);
    SLog.b("EditVideoSpeedFilter", localStringBuilder.toString());
    e(b(paramInt), paramString);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter$FilterPagerAdapter.notifyDataSetChanged();
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_AndroidViewViewStub = null;
    PickerContainer localPickerContainer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer;
    if (localPickerContainer != null)
    {
      localPickerContainer.a();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSpeedFilter
 * JD-Core Version:    0.7.0.1
 */