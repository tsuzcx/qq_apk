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
  public static final String a = HardCodeUtil.a(2131901919);
  public static final String b = HardCodeUtil.a(2131901940);
  public static final String c = HardCodeUtil.a(2131901854);
  public static final String d = HardCodeUtil.a(2131901828);
  public static final String e = HardCodeUtil.a(2131901936);
  public static final String f = HardCodeUtil.a(2131901956);
  boolean g = false;
  public long h;
  public int i;
  protected UnHandleTouchEventViewPager j;
  protected EditVideoSpeedFilter.FilterPagerAdapter k;
  protected SparseArray<FilterData> l = new SparseArray();
  public PickerContainer m;
  private SparseIntArray n = new SparseIntArray();
  private ViewStub o;
  private boolean p;
  private boolean q;
  private int r = 1;
  
  public EditVideoSpeedFilter(@NonNull EditVideoPartManager paramEditVideoPartManager, boolean paramBoolean)
  {
    super(paramEditVideoPartManager);
    this.q = paramBoolean;
    if (this.q) {
      this.q = l();
    }
    paramEditVideoPartManager = new StringBuilder();
    paramEditVideoPartManager.append("EditVideoSpeedFilter : enable: ");
    paramEditVideoPartManager.append(this.q);
    SLog.b("EditVideoSpeedFilter", paramEditVideoPartManager.toString());
  }
  
  public static int a(@NonNull FilterData paramFilterData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSpecialSaveMode : mVideoPlayMode = ");
    localStringBuilder.append(paramFilterData.a);
    SLog.b("EditVideoSpeedFilter", localStringBuilder.toString());
    int i1 = paramFilterData.a;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 8)
            {
              if (i1 != 9) {
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
    if (this.r == 2) {
      return;
    }
    PickerContainer localPickerContainer = this.m;
    if (localPickerContainer != null) {
      if (paramBoolean)
      {
        if (localPickerContainer.getVisibility() != 0) {
          this.m.setVisibility(0);
        }
      }
      else if ((localPickerContainer.getVisibility() != 4) && (this.m.getVisibility() != 8)) {
        this.m.setVisibility(4);
      }
    }
  }
  
  private void c(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 4) && (paramInt != 8)) {
      return;
    }
    if (this.j.getVisibility() != paramInt) {
      this.j.setVisibility(paramInt);
    }
  }
  
  private void e(int paramInt, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onPlayModeChanged:");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("  ");
    ((StringBuilder)localObject1).append(paramString);
    SLog.b("EditVideoSpeedFilter", ((StringBuilder)localObject1).toString());
    localObject1 = this.k.a;
    int i3 = 0;
    int i1 = 0;
    int i2;
    Object localObject2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= ((List)localObject1).size()) {
        break;
      }
      localObject2 = (FilterData)((List)localObject1).get(i1);
      if ((!TextUtils.isEmpty(((FilterData)localObject2).b)) && (((FilterData)localObject2).a == paramInt))
      {
        this.j.setCurrentItem(i1, false);
        i2 = 1;
        break;
      }
      i1 += 1;
    }
    if (i2 == 0)
    {
      localObject1 = u();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901886));
      ((StringBuilder)localObject2).append(paramString);
      QQToast.makeText((Context)localObject1, ((StringBuilder)localObject2).toString(), 1000).show();
    }
  }
  
  private int f(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transSpecialPlayMode : nSpeedIndex = ");
    localStringBuilder.append(paramInt);
    SLog.b("EditVideoSpeedFilter", localStringBuilder.toString());
    if (SlideShowPhotoListManager.a().e() == 22) {
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
              if (SlideShowPhotoListManager.a().e() == 22) {
                LpReportInfo_pf00064.allReport(680, 10, 6);
              }
              return 1;
            }
            if (SlideShowPhotoListManager.a().e() == 22) {
              LpReportInfo_pf00064.allReport(680, 10, 5);
            }
            return 9;
          }
          if (SlideShowPhotoListManager.a().e() == 22) {
            LpReportInfo_pf00064.allReport(680, 10, 4);
          }
          return 3;
        }
        if (SlideShowPhotoListManager.a().e() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 1);
        }
        return 0;
      }
      if (SlideShowPhotoListManager.a().e() == 22) {
        LpReportInfo_pf00064.allReport(680, 10, 2);
      }
      return 8;
    }
    if (SlideShowPhotoListManager.a().e() == 22) {
      LpReportInfo_pf00064.allReport(680, 10, 3);
    }
    return 2;
  }
  
  private int g(int paramInt)
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
  
  private boolean l()
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
    if ((bool) && (((Boolean)localStoryConfigManager.c("boolean_enable_fast_play_mode", localBoolean)).booleanValue()) && (((Boolean)localStoryConfigManager.c("boolean_enable_revert_play_mode", localBoolean)).booleanValue()) && (((Boolean)localStoryConfigManager.c("boolean_enable_slow_play_mode", localBoolean)).booleanValue())) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {
      SLog.d("EditVideoSpeedFilter", "black model, manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
    }
    return bool;
  }
  
  private void m()
  {
    ThreadManager.getUIHandler().postDelayed(new EditVideoSpeedFilter.1(this), 500L);
  }
  
  public void a()
  {
    super.a();
    this.k = new EditVideoSpeedFilter.FilterPagerAdapter(u());
    this.j = ((UnHandleTouchEventViewPager)d(2063990983));
    this.j.setAdapter(this.k);
    this.j.setOnPageChangeListener(new EditVideoSpeedFilter.FilterPageChangeListener(this, null));
    d();
    a(EditFilterExport.class, this);
    m();
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    Object localObject = (FilterData)this.l.get(paramInt);
    if (this.t.I.e()) {
      paramGenerateContext.d.localCreateCity = this.t.I.a("extra_local_address_city_name");
    }
    paramGenerateContext.a(i());
    paramGenerateContext.d.saveMode = b(paramInt);
    boolean bool = false;
    String str;
    int i2;
    if (localObject != null)
    {
      str = ((FilterData)localObject).b;
      i2 = ((FilterData)localObject).c;
      int i3 = ((FilterData)localObject).a;
      paramGenerateContext = str;
      i1 = i2;
      paramInt = i3;
      if (((FilterData)localObject).c != -1)
      {
        this.t.X().setFilterId(((FilterData)localObject).b);
        this.t.X().setFilterType(2);
        paramGenerateContext = str;
        i1 = i2;
        paramInt = i3;
      }
    }
    else
    {
      paramGenerateContext = "";
      i1 = -1;
      paramInt = 0;
    }
    localObject = "2";
    if (i1 != -1)
    {
      EditVideoPartManager localEditVideoPartManager = this.t;
      i2 = this.t.n();
      if (this.t.j()) {
        str = "2";
      } else {
        str = "1";
      }
      localEditVideoPartManager.a("pub_filter_menu", i2, 0, new String[] { String.valueOf(i1), paramGenerateContext, str });
    }
    if (i1 != -1) {
      VideoEditReport.a("0X80076E9", String.valueOf(VideoEditReport.d), String.valueOf(paramInt), paramGenerateContext, String.valueOf(i1));
    }
    long l1 = System.currentTimeMillis() - this.h;
    int i1 = this.i;
    SLog.a("EditVideoSpeedFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l1), Integer.valueOf(i1));
    if (this.t.j()) {
      paramGenerateContext = (GenerateContext)localObject;
    } else {
      paramGenerateContext = "1";
    }
    StoryReportor.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l1), String.valueOf(i1), paramGenerateContext });
    paramGenerateContext = (IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class);
    if (paramInt != 0) {
      bool = true;
    }
    paramGenerateContext.setEditSpeedChanged(bool);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (!this.q) {
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
            c(4);
            return;
          }
          paramInt = g(this.i);
          paramObject = this.m;
          if (paramObject != null) {
            paramObject.a(paramInt, false);
          }
          a(true);
          c(0);
        }
      }
      else
      {
        a(false);
        c(0);
        return;
      }
    }
    a(true);
    c(0);
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPickSpeedStart:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramString);
    SLog.b("EditVideoSpeedFilter", localStringBuilder.toString());
    this.p = true;
  }
  
  public boolean a(int paramInt)
  {
    FilterData localFilterData = (FilterData)this.l.get(paramInt);
    return (localFilterData != null) && (localFilterData.a());
  }
  
  public boolean a(int paramInt1, Canvas paramCanvas, int paramInt2, int paramInt3)
  {
    paramInt1 = this.n.get(paramInt1);
    Object localObject1 = this.k.c(paramInt1);
    int i1 = this.j.getWidth();
    int i2 = this.j.getHeight();
    Object localObject2 = null;
    if (localObject1 != null)
    {
      if (((FilterData.FilterPageItem)localObject1).b())
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
      localObject2 = new FrameLayout(u());
      ((View)localObject2).setLayoutParams(new ViewGroup.LayoutParams(this.j.getLayoutParams()));
      localObject1 = this.k.instantiateItem((ViewGroup)localObject2, paramInt1);
      ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(this.j.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.j.getMeasuredHeight(), 1073741824));
      ((View)localObject2).layout(0, 0, this.j.getWidth(), this.j.getHeight());
    }
    if (localObject2 != null)
    {
      paramCanvas.save();
      paramCanvas.scale(paramInt2 / i1, paramInt3 / i2);
      ((View)localObject2).draw(paramCanvas);
      paramCanvas.restore();
      if (localObject1 != null) {
        this.k.destroyItem((ViewGroup)localObject2, paramInt1, localObject1);
      }
      return true;
    }
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    if (this.q)
    {
      int i1 = paramMessage.what;
      boolean bool = false;
      if (i1 != 12)
      {
        if (i1 != 21)
        {
          if (i1 == 22) {
            a(true);
          }
        }
        else {
          a(false);
        }
      }
      else
      {
        this.r = paramMessage.arg1;
        paramMessage = this.m;
        if (paramMessage != null)
        {
          i1 = this.r;
          if ((i1 == 1) || (i1 == 3)) {
            bool = true;
          }
          paramMessage.a(bool, this.v);
        }
        return true;
      }
    }
    return super.a(paramMessage);
  }
  
  public int b(int paramInt)
  {
    FilterData localFilterData = (FilterData)this.l.get(paramInt);
    if (localFilterData == null) {
      return 0;
    }
    return a(localFilterData);
  }
  
  public void b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPickSpeed:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" moving:");
    localStringBuilder.append(this.p);
    SLog.b("EditVideoSpeedFilter", localStringBuilder.toString());
    if (this.p) {
      return;
    }
    e(f(paramInt), paramString);
    paramString = this.t.a(EditProviderExport.class);
    if ((paramString instanceof EditProviderExport)) {
      ((EditProviderExport)paramString).h();
    }
    this.t.a(Message.obtain(null, 9, 12, paramInt));
  }
  
  public int c()
  {
    return b(this.t.m());
  }
  
  public void c(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSpeedPickEnd:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  ");
    localStringBuilder.append(paramString);
    SLog.b("EditVideoSpeedFilter", localStringBuilder.toString());
    e(f(paramInt), paramString);
    this.p = false;
  }
  
  public void d()
  {
    SLog.a("EditVideoSpeedFilter", "updateFilterMode : %s", this.t.I.e);
    ArrayList localArrayList = new ArrayList();
    boolean bool = this.t.I.e instanceof EditTakeVideoSource;
    int i1 = 0;
    if ((bool) || ((this.t.I.e instanceof EditLocalVideoSource)))
    {
      Object localObject = (StoryConfigManager)SuperManager.a(10);
      localArrayList.add(new VideoEffectsFilterData(a, -1, 0, 0));
      if (!((Boolean)((StoryConfigManager)localObject).c("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue())
      {
        SLog.d("EditVideoSpeedFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
      else
      {
        localArrayList.add(new VideoEffectsFilterData(b, 1, 0, 2));
        localArrayList.add(new VideoEffectsFilterData(e, 9, 0, 8));
      }
      if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL))) {
        if (!((Boolean)((StoryConfigManager)localObject).c("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue())
        {
          SLog.d("EditVideoSpeedFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        else if ((this.t.I.a == 11) && (!this.t.I.g()))
        {
          SLog.d("EditVideoSpeedFilter", "it's tribe slow black model, disable slow!");
        }
        else if ((this.t.I.a == 12) && (!this.t.I.g()))
        {
          SLog.d("EditVideoSpeedFilter", "it's readinjoy slow black model, disable slow!");
        }
        else
        {
          localArrayList.add(new VideoEffectsFilterData(c, 2, 0, 3));
          localArrayList.add(new VideoEffectsFilterData(f, 10, 0, 9));
          this.g = true;
        }
      }
      if (!(this.t.I.e instanceof EditLocalVideoSource)) {
        if (!((Boolean)((StoryConfigManager)localObject).c("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue())
        {
          SLog.d("EditVideoSpeedFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        else if ((this.t.I.a == 11) && (!this.t.I.f()))
        {
          SLog.d("EditVideoSpeedFilter", "it's tribe revert black model, disable revert!");
        }
        else if ((this.t.I.a == 12) && (!this.t.I.f()))
        {
          SLog.d("EditVideoSpeedFilter", "it's tribe readinjoy black model, disable revert!");
        }
        else
        {
          VideoEffectsFilterData localVideoEffectsFilterData = new VideoEffectsFilterData(d, 3, 0, 1);
          if (this.t.I.k()) {
            localObject = HardCodeUtil.a(2131901933);
          } else {
            localObject = null;
          }
          localVideoEffectsFilterData.d = ((String)localObject);
          localArrayList.add(localVideoEffectsFilterData);
        }
      }
    }
    this.k.a(localArrayList);
    this.j.setCurrentItem(localArrayList.size() * 50, false);
    this.h = System.currentTimeMillis();
    if (!localArrayList.isEmpty()) {
      i1 = ((FilterData)localArrayList.get(0)).a;
    }
    this.i = i1;
  }
  
  public void d(int paramInt, String paramString)
  {
    this.k.a(paramInt, paramString);
    this.k.notifyDataSetChanged();
  }
  
  public void g()
  {
    super.g();
    this.o = null;
    PickerContainer localPickerContainer = this.m;
    if (localPickerContainer != null)
    {
      localPickerContainer.a();
      this.m = null;
    }
  }
  
  @Nullable
  public View i()
  {
    int i1 = this.j.getCurrentItem();
    FilterData.FilterPageItem localFilterPageItem = this.k.c(i1);
    if ((localFilterPageItem != null) && (localFilterPageItem.b())) {
      return localFilterPageItem.a;
    }
    return null;
  }
  
  public int k()
  {
    int i1 = this.j.getCurrentItem();
    FilterData localFilterData = this.k.a(i1);
    if (localFilterData != null) {
      return localFilterData.c;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSpeedFilter
 * JD-Core Version:    0.7.0.1
 */