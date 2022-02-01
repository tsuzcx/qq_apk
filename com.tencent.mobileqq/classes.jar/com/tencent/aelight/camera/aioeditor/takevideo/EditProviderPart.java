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
  public static String d = "EditProviderPart";
  protected View a;
  FrameLayout b;
  View c;
  public boolean e;
  public ProviderViewEditContainer f;
  public boolean g;
  public int h = -1;
  private QIMProviderViewBuilder i;
  private HashMap<Integer, ProviderView> j = new HashMap();
  private ProviderView k;
  private AEFilterContentView l;
  private DoodleLayout m;
  private VideoFilterViewPager n;
  private RelativeLayout o;
  private boolean p;
  private ScaleGestureDetector q;
  private GestureDetector r;
  private boolean s;
  private TextView x;
  private View y;
  private int z = 0;
  
  public EditProviderPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private Bundle A()
  {
    if (this.t.ad != null) {
      return this.t.ad.getBundle("container");
    }
    return null;
  }
  
  private void c(int paramInt)
  {
    Object localObject = this.y;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      this.y.setVisibility(8);
      this.y = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((ProviderView)localObject).d();
      this.k.setVisibility(8);
      this.k = null;
    }
    int i1;
    if (this.j.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = (ProviderView)this.j.get(Integer.valueOf(paramInt));
    }
    else
    {
      ProviderView localProviderView = this.i.a(u(), paramInt);
      if (localProviderView != null) {
        this.j.put(Integer.valueOf(paramInt), localProviderView);
      }
      localObject = localProviderView;
      if ((localProviderView instanceof TransitionProviderView))
      {
        i1 = this.t.I.a("extra_transiton_src_from", -1);
        ((TransitionProviderView)localProviderView).c = i1;
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
    if (!((ProviderView)localObject).l())
    {
      if (this.m == null) {
        this.m = this.t.O.b();
      }
      if (this.t.Z != null)
      {
        paramInt = ((ProviderView)localObject).getContentHeight();
        i1 = this.t.Z.getHeight();
        ((ProviderView)localObject).d(paramInt + (int)UIUtils.c(u(), i1));
      }
      ((ProviderView)localObject).a(A());
    }
    this.k = ((ProviderView)localObject);
    if (this.k.getId() != 2131430308) {
      b(false);
    }
    this.k.setVisibility(0);
    this.k.c();
    this.b.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  private void q()
  {
    if (this.t != null)
    {
      Object localObject1 = this.t;
      if (EditVideoPartManager.a(this.t.I.c, 16))
      {
        localObject1 = ((CaptureComboManager)QIMManager.a(5)).l;
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "comboFilterData null");
          }
          return;
        }
        localObject1 = ((VideoFilterTools.ComboFilterData)localObject1).d();
        if ((localObject1 != null) && (((List)localObject1).size() < 3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "recommend trans less than 3");
          }
          return;
        }
        this.y = d(2063991503);
        if (this.t.Z != null)
        {
          Object localObject2;
          if (this.t.aa)
          {
            localObject2 = (RelativeLayout)d(2063991042);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.y.getLayoutParams();
            localLayoutParams.bottomMargin = 0;
            localLayoutParams.addRule(12, -1);
            localLayoutParams.addRule(2, 0);
            ((ViewGroup)this.y.getParent()).removeView(this.y);
            ((RelativeLayout)localObject2).addView(this.y, localLayoutParams);
          }
          else
          {
            localObject2 = (RelativeLayout.LayoutParams)this.y.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
            ((RelativeLayout.LayoutParams)localObject2).addRule(2, 0);
            this.y.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        this.y.postDelayed(new EditProviderPart.3(this, (List)localObject1), 1000L);
      }
    }
  }
  
  private void y()
  {
    z();
    this.o.setVisibility(0);
    if ((this.n.getAdapter() != null) && (this.l.getFilterCount() > this.n.getAdapter().getCount() / 100)) {
      d(false);
    }
  }
  
  private void z()
  {
    if (this.l == null)
    {
      AEQLog.a("EditProviderPart", "view is null.");
      this.l = new AEFilterContentView(u());
      this.o.addView(this.l);
      this.l.setProviderViewListener(this);
    }
    this.l.a(k());
  }
  
  public <T extends ProviderView> T a(Class<? extends ProviderView> paramClass)
  {
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext())
    {
      ProviderView localProviderView = (ProviderView)localIterator.next();
      if (paramClass.isInstance(localProviderView)) {
        return localProviderView;
      }
    }
    return null;
  }
  
  public String a(Bitmap paramBitmap)
  {
    VideoFilterViewPager localVideoFilterViewPager = this.n;
    if (localVideoFilterViewPager != null) {
      return localVideoFilterViewPager.a(paramBitmap);
    }
    return "";
  }
  
  public void a()
  {
    super.a();
    a(EditProviderExport.class, this);
    int i1 = k();
    this.h = i1;
    VideoFilterTools.a().a(this.t);
    this.b = ((FrameLayout)d(2063991330));
    this.o = ((RelativeLayout)d(2063991070));
    this.c = d(2063990978);
    if (this.t.Z != null)
    {
      int i2 = this.t.Z.getHeight();
      ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
      if (i2 <= 0) {
        localLayoutParams.height += LiuHaiUtils.j;
      } else {
        localLayoutParams.height += i2;
      }
      this.b.setLayoutParams(localLayoutParams);
      localLayoutParams = this.c.getLayoutParams();
      if (i2 <= 0) {
        localLayoutParams.height += LiuHaiUtils.j;
      } else {
        localLayoutParams.height += i2;
      }
      this.c.setLayoutParams(localLayoutParams);
    }
    this.i = new QIMProviderViewBuilder(i1);
    this.i.a();
    this.n = ((VideoFilterViewPager)d(2063991341));
    this.n.setReadyToApply(false);
    this.n.setCaptureScene(this.h);
    if (AECameraEntry.c.b(this.t.I.h)) {
      this.n.a = true;
    }
    this.n.setIaiSubLabelReady(new EditProviderPart.1(this));
    d(true);
    this.q = new ScaleGestureDetector(u(), new EditProviderPart.ScaleDetectorListener(this, null));
    this.r = new GestureDetector(u(), new EditProviderPart.TapDetectorListener(this, null));
    this.a = d(2063991342);
    this.a.setOnTouchListener(new EditProviderPart.2(this));
    if ((this.u instanceof EditVideoActivity)) {
      this.x = ((TextView)d(2063991036));
    }
    e(true);
    if (this.f == null)
    {
      ((ViewStub)d(2063991343)).inflate();
      this.f = ((ProviderViewEditContainer)d(2063991329));
      i1 = this.t.U();
      this.f.a(i1);
      this.f.setProviderViewListener(this);
    }
  }
  
  public void a(int paramInt)
  {
    this.t.d(16);
    this.t.d(paramInt);
    ProviderViewEditContainer localProviderViewEditContainer = this.f;
    if (localProviderViewEditContainer != null) {
      localProviderViewEditContainer.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (1 == paramInt1) {
      QQToast.makeText(this.u.getContext(), HardCodeUtil.a(2131901797), 0).show();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.j.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (paramInt != -1) {
      this.n.setCurrentItem(paramInt, false);
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if ((QIMFilterProviderView)a(QIMFilterProviderView.class) != null)
    {
      boolean bool;
      if (VideoFilterTools.a().b(this.h) != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramGenerateContext.h = bool;
      if ((paramGenerateContext.h) && (this.t.j()))
      {
        paramGenerateContext = paramGenerateContext.l;
        paramGenerateContext.f += 1;
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    this.z = paramInt;
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
                  i();
                  return;
                }
                c(106);
                return;
              }
              y();
              return;
            }
            if ((this.n != null) && (this.t.j()))
            {
              this.n.d();
              this.n.a(0, true);
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
        if (SlideShowPhotoListManager.a().e() == 22) {
          LpReportInfo_pf00064.allReport(680, 3, 1);
        }
      }
    }
    else
    {
      this.e = false;
      i();
      paramObject = this.f;
      if (paramObject != null) {
        paramObject.a();
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Object localObject = new Pair(Integer.valueOf(paramInt), paramVarArgs);
    this.t.a(15, localObject);
    localObject = this.f;
    if (localObject != null) {
      ((ProviderViewEditContainer)localObject).a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(LocationFacePackage.Item paramItem)
  {
    ((StoryConfigManager)SuperManager.a(10)).d("has_show_add_poi_paster_guide", Boolean.valueOf(true));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i2 = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject1 = (CaptureComboManager)QIMManager.a(5);
      Object localObject2 = localObject1.o[this.h].a;
      int i1 = i2;
      if (localObject2 != null)
      {
        localObject2 = (QIMFilterCategoryItem)((ComboSet)localObject2).e;
        i1 = i2;
        if (localObject2 != null)
        {
          localJSONObject.put("comboItem", ((QIMFilterCategoryItem)localObject2).h());
          i1 = 1;
        }
      }
      localObject1 = localObject1.o[this.h].c;
      i2 = i1;
      if (localObject1 != null)
      {
        localObject1 = (QIMFilterCategoryItem)((FilterSet)localObject1).e;
        i2 = i1;
        if (localObject1 != null)
        {
          localJSONObject.put("filterItem", ((QIMFilterCategoryItem)localObject1).h());
          i2 = 1;
        }
      }
      localObject1 = ((QimMusicPlayer)QIMManager.a().d(8)).i();
      if (localObject1 != null)
      {
        localJSONObject.put("musicItem", ((MusicItemInfo)localObject1).convertToJSON());
        i2 = 1;
      }
      if (i2 != 0) {
        paramJSONObject.put(d, localJSONObject);
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void ax_()
  {
    super.ax_();
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).f();
    }
  }
  
  public int b()
  {
    return (int)this.t.b(this.t.m());
  }
  
  public void b(int paramInt)
  {
    ((EditTransferExport)b(EditTransferExport.class)).a(paramInt);
  }
  
  public void b(int paramInt, Object paramObject)
  {
    if (paramInt == 7) {
      i();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.x == null) {
      return;
    }
    MusicProviderView localMusicProviderView = (MusicProviderView)this.j.get(Integer.valueOf(104));
    MusicItemInfo localMusicItemInfo = ((QimMusicPlayer)QIMManager.a().d(8)).i();
    if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.needPlay())) && (localMusicProviderView.h())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if ((this.u != null) && ((this.u instanceof EditVideoActivity)) && (this.u.getActivity() != null)) {
      this.u.getActivity().runOnUiThread(new EditProviderPart.5(this, paramBoolean));
    }
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.t.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.t.a(Message.obtain(null, 3, 2, 0));
  }
  
  public void d()
  {
    q();
  }
  
  public void d(boolean paramBoolean)
  {
    VideoFilterTools.ComboFilterData localComboFilterData = ((CaptureComboManager)QIMManager.a(5)).l;
    if (localComboFilterData != null)
    {
      VideoFilterViewPager localVideoFilterViewPager = this.n;
      if (localVideoFilterViewPager != null)
      {
        localVideoFilterViewPager.a(VideoFilterTools.ComboFilterData.a(localComboFilterData.a(this.h).c));
        if (!paramBoolean) {
          return;
        }
        this.n.c();
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
      if (this.n == null) {
        bool = true;
      }
      QLog.d("EditProviderPart", 2, new Object[] { "comboFilterData is null, ", Boolean.valueOf(paramBoolean), " ", Boolean.valueOf(bool) });
    }
  }
  
  void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preloadProviderView count");
      ((StringBuilder)localObject).append(this.i.b());
      QLog.d("EditProviderPart", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = A();
    int i1 = 0;
    while (i1 < this.i.b())
    {
      int i2 = this.i.e(i1);
      if (((!paramBoolean) || (this.i.f(i2))) && ((ProviderView)this.j.get(Integer.valueOf(i2)) == null))
      {
        ProviderView localProviderView = this.i.a(u(), i2);
        if (localProviderView != null)
        {
          this.j.put(Integer.valueOf(this.i.e(i1)), localProviderView);
          localProviderView.setProviderViewListener(this);
          localProviderView.setDoodleEventListener(this);
          localProviderView.b((Bundle)localObject);
          this.b.addView(localProviderView);
          localProviderView.setVisibility(8);
          if ((localProviderView instanceof TransitionProviderView))
          {
            i2 = this.t.I.a("extra_transiton_src_from", -1);
            ((TransitionProviderView)localProviderView).c = i2;
          }
          if (!paramBoolean) {
            localProviderView.e();
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("preloadProviderView failed ");
          ((StringBuilder)localObject).append(i1);
          QLog.e("EditProviderPart", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      i1 += 1;
    }
  }
  
  public void f()
  {
    super.f();
    VideoFilterTools.a().d(this.h);
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).e();
    }
    ((CaptureComboManager)QIMManager.a(5)).o[this.h].a((Activity)this.b.getContext());
    if (!this.g) {
      ThreadManager.getUIHandler().postDelayed(new EditProviderPart.4(this), 500L);
    }
  }
  
  public void g()
  {
    super.g();
    Iterator localIterator = this.j.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a();
    }
    VideoFilterTools.a().h();
  }
  
  public void h()
  {
    View localView = this.y;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      this.y.setVisibility(8);
    }
  }
  
  public void i()
  {
    Object localObject = this.y;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      this.y.setVisibility(8);
      this.y = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((ProviderView)localObject).d();
      this.k.setVisibility(8);
      this.k = null;
    }
    this.o.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  public void j()
  {
    super.j();
    ProviderViewEditContainer localProviderViewEditContainer = this.f;
    if (localProviderViewEditContainer != null) {
      localProviderViewEditContainer.b();
    }
    ((CaptureComboManager)QIMManager.a(5)).o[this.h].c((Activity)this.b.getContext());
  }
  
  public int k()
  {
    if (this.t.k())
    {
      if (this.t.j()) {
        return 3;
      }
      return 4;
    }
    if (this.t.j()) {
      return 1;
    }
    return 2;
  }
  
  public void l()
  {
    VideoFilterViewPager localVideoFilterViewPager = this.n;
    if (localVideoFilterViewPager != null) {
      localVideoFilterViewPager.d();
    }
  }
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
  
  public boolean p()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart
 * JD-Core Version:    0.7.0.1
 */