import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.TransitionProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.2;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.3;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.4;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class bosq
  extends botu
  implements boop, bosp, bozd
{
  public static String a;
  float jdField_a_of_type_Float;
  public int a;
  protected View a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  boiw jdField_a_of_type_Boiw = new bosu(this);
  private bono jdField_a_of_type_Bono;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  public ProviderViewEditContainer a;
  private DoodleLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  HorizontalAlumbListLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  private HashMap<Integer, ProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  private View c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EditProviderPart";
  }
  
  public bosq(@NonNull botw parambotw)
  {
    super(parambotw);
    this.jdField_a_of_type_Int = -1;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private void e(int paramInt)
  {
    if ((this.c != null) && (this.c.getVisibility() == 0))
    {
      this.c.setVisibility(8);
      this.c = null;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      localObject = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    int i;
    while (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditProviderPart", 2, "build provider view failed " + paramInt);
      }
      return;
      ProviderView localProviderView = this.jdField_a_of_type_Bono.a(a(), paramInt);
      if (localProviderView != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localProviderView);
      }
      localObject = localProviderView;
      if ((localProviderView instanceof TransitionProviderView))
      {
        i = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
        ((TransitionProviderView)localProviderView).jdField_a_of_type_Int = i;
        localObject = localProviderView;
      }
    }
    if (!((ProviderView)localObject).d())
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a();
      }
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramInt = ((ProviderView)localObject).d();
        i = this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        ((ProviderView)localObject).d(paramInt + (int)UIUtils.px2dip(a(), i));
      }
      ((ProviderView)localObject).a(a());
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView = ((ProviderView)localObject);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getId() != 2131364285) {
      b(false);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.c();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void q()
  {
    Object localObject1;
    if (this.jdField_a_of_type_Botw != null)
    {
      localObject1 = this.jdField_a_of_type_Botw;
      if (botw.a(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 16))
      {
        localObject1 = this.jdField_a_of_type_Botw;
        if (!botw.a(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 16384))
        {
          localObject1 = ((bohj)bogd.a(5)).jdField_a_of_type_Bpju;
          if (localObject1 != null) {
            break label84;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "comboFilterData null");
          }
        }
      }
    }
    label84:
    do
    {
      return;
      localObject1 = ((bpju)localObject1).b();
      if ((localObject1 == null) || (((List)localObject1).size() >= 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QCombo", 2, "recommend trans less than 3");
    return;
    this.c = a(2131379336);
    Object localObject2;
    if (this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (!this.jdField_a_of_type_Botw.d) {
        break label237;
      }
      localObject2 = (RelativeLayout)a(2131366017);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(2, 0);
      ((ViewGroup)this.c.getParent()).removeView(this.c);
      ((RelativeLayout)localObject2).addView(this.c, localLayoutParams);
    }
    for (;;)
    {
      this.c.postDelayed(new EditProviderPart.2(this, (List)localObject1), 1000L);
      return;
      label237:
      localObject2 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, 0);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  private void r()
  {
    String str = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_default");
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "EditProviderPart setDedaultTransition transId=" + str);
    }
    Object localObject = ((bohj)bogd.a(5)).jdField_a_of_type_Bpju;
    if (localObject != null)
    {
      localObject = ((bpju)localObject).a();
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((FilterCategory)((ArrayList)localObject).get(0)).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TransitionCategoryItem localTransitionCategoryItem = (TransitionCategoryItem)((Iterator)localObject).next();
          if (localTransitionCategoryItem.k.equals(str))
          {
            bpjt.a().a(localTransitionCategoryItem);
            d(Integer.parseInt(localTransitionCategoryItem.jdField_a_of_type_JavaLangString));
          }
        }
      }
    }
  }
  
  private void s()
  {
    Object localObject = yzw.a(a()).a();
    boje localboje = (boje)bogd.a().c(8);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      QIMMusicConfigManager localQIMMusicConfigManager = (QIMMusicConfigManager)bogd.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        yzx localyzx = (yzx)((Iterator)localObject).next();
        boolean bool = localboje.a(localQIMMusicConfigManager.a(localyzx.jdField_a_of_type_Int, localyzx.jdField_b_of_type_Int), this.jdField_a_of_type_Boiw);
        if (QLog.isColorLevel()) {
          QLog.d("EditProviderPart", 2, "EditProviderPart preDownloadMusic needDownload=" + bool + " itemId=" + localyzx.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public int a()
  {
    return (int)this.jdField_a_of_type_Botw.a(this.jdField_a_of_type_Botw.a());
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
    a(bosp.class, this);
    int i = b();
    this.jdField_a_of_type_Int = i;
    bpjt.a().a(this.jdField_a_of_type_Botw);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131373276));
    this.jdField_b_of_type_AndroidViewView = a(2131365133);
    int j;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      j = this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (j > 0) {
        break label339;
      }
      localLayoutParams.height += LiuHaiUtils.e;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
      localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      if (j > 0) {
        break label352;
      }
    }
    label339:
    label352:
    for (localLayoutParams.height += LiuHaiUtils.e;; localLayoutParams.height = (j + localLayoutParams.height))
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Bono = new bono(i);
      this.jdField_a_of_type_Bono.a();
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)a(2131374124));
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setReadyToApply(false);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setCaptureScene(this.jdField_a_of_type_Int);
      if (bnlb.c.a(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f)) {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.jdField_b_of_type_Boolean = true;
      }
      k();
      this.jdField_a_of_type_AndroidViewView = a(2131374125);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new bosr(this));
      if ((this.jdField_a_of_type_Bouo instanceof EditVideoActivity)) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131365976));
      }
      d(true);
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        ((ViewStub)a(2131374126)).inflate();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)a(2131373272));
        i = this.jdField_a_of_type_Botw.g();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(i);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setProviderViewListener(this);
      }
      return;
      localLayoutParams.height += j;
      break;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (1 == paramInt1) {
      QQToast.a(this.jdField_a_of_type_Bouo.a(), anvx.a(2131703175), 0).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, @NonNull bpel parambpel)
  {
    super.a(paramInt, parambpel);
    if ((QIMFilterProviderView)a(QIMFilterProviderView.class) != null) {
      if (bpjt.a().b(this.jdField_a_of_type_Int) == null) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      parambpel.c = bool;
      if ((parambpel.c) && (this.jdField_a_of_type_Botw.a()))
      {
        parambpel = parambpel.a;
        parambpel.jdField_a_of_type_Int += 1;
      }
      return;
    }
  }
  
  public void a(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (paramInt != -1) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setCurrentItem(paramInt, false);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      l();
    }
    for (;;)
    {
      if ((paramInt != -1) && (paramInt != 0) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setTipsGone();
      }
      return;
      e(103);
      continue;
      e(104);
      if (yzz.a().b() == 22)
      {
        LpReportInfo_pf00064.allReport(680, 3, 1);
        continue;
        e(101);
        continue;
        e(106);
        continue;
        e(108);
        continue;
        this.jdField_a_of_type_Boolean = false;
        l();
        if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Pair localPair = new Pair(Integer.valueOf(paramInt), paramVarArgs);
    this.jdField_a_of_type_Botw.a(15, localPair);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(bpbd parambpbd)
  {
    ((wjl)wjs.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString) {}
  
  public void a(String paramString) {}
  
  public void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int j;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        Object localObject1 = (bohj)bogd.a(5);
        Object localObject2 = localObject1.jdField_a_of_type_ArrayOfBohn[this.jdField_a_of_type_Int].jdField_a_of_type_Bohz;
        if (localObject2 == null) {
          break label183;
        }
        localObject2 = (QIMFilterCategoryItem)((bohz)localObject2).a;
        if (localObject2 == null) {
          break label183;
        }
        localJSONObject.put("comboItem", ((QIMFilterCategoryItem)localObject2).a());
        i = 1;
        localObject1 = localObject1.jdField_a_of_type_ArrayOfBohn[this.jdField_a_of_type_Int].jdField_a_of_type_Boic;
        j = i;
        if (localObject1 != null)
        {
          localObject1 = (QIMFilterCategoryItem)((boic)localObject1).a;
          j = i;
          if (localObject1 != null)
          {
            localJSONObject.put("filterItem", ((QIMFilterCategoryItem)localObject1).a());
            j = 1;
          }
        }
        localObject1 = ((boje)bogd.a().c(8)).a();
        if (localObject1 != null)
        {
          localJSONObject.put("musicItem", ((MusicItemInfo)localObject1).convertToJSON());
          i = 1;
          if (i != 0) {
            paramJSONObject.put(jdField_a_of_type_JavaLangString, localJSONObject);
          }
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      int i = j;
      continue;
      label183:
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(byte[] paramArrayOfByte) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void aH_()
  {
    super.aH_();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).f();
    }
  }
  
  public void aI_()
  {
    super.aI_();
    bpjt.a().a(this.jdField_a_of_type_Int);
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ProviderView)((Iterator)localObject).next()).e();
    }
    ((bohj)bogd.a(5)).jdField_a_of_type_ArrayOfBohn[this.jdField_a_of_type_Int].a((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    localObject = this.jdField_a_of_type_Botw;
    if ((botw.a(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 16384)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.a(yzz.a().a());
    }
    if (!this.jdField_b_of_type_Boolean) {
      ThreadManager.getUIHandler().postDelayed(new EditProviderPart.3(this), 500L);
    }
  }
  
  public void aJ_() {}
  
  public void aK_()
  {
    Object localObject;
    if (this.jdField_a_of_type_Bouo != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout = ((HorizontalAlumbListLayout)a(2131371889));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131374703));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setTipsContent(this.jdField_a_of_type_AndroidWidgetTextView);
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        break label394;
      }
      if (!this.jdField_a_of_type_Botw.d) {
        break label345;
      }
      localObject = (RelativeLayout)a(2131366017);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(2, 0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, 0);
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getParent();
      localViewGroup.removeView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout);
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout, localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetTextView);
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setEditVideoUI(this.jdField_a_of_type_Bouo);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.a(yzz.a().a());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(0);
      if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("PhotoConst.IS_FROM_EDIT", false)) {
        yzz.a().b();
      }
      yzz.a().a(this.jdField_a_of_type_Bouo.getActivity());
      d();
      if (botw.a(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 16)) {
        r();
      }
      s();
      try
      {
        localObject = this.jdField_a_of_type_Bouo.getActivity().getIntent();
        int i = ((EditVideoParams)((Intent)localObject).getParcelableExtra(EditVideoParams.class.getName())).a("extra_slide_entrance", -1);
        ykv.a("video_edit_new", "exp_albumbar", (Intent)localObject, new String[] { i + "" });
        return;
        label345:
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, a().getDimensionPixelOffset(2131298074));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        continue;
        label394:
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, a().getDimensionPixelOffset(2131298074));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("EditProviderPart", 2, bkym.a(localException));
      }
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    if (paramInt == 7) {
      l();
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Botw.b())
    {
      if (this.jdField_a_of_type_Botw.a()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_a_of_type_Botw.a()) {
      return 1;
    }
    return 2;
  }
  
  public void b()
  {
    q();
  }
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {}
    for (;;)
    {
      return;
      MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(104));
      MusicItemInfo localMusicItemInfo = ((boje)bogd.a().c(8)).a();
      if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.needPlay())) && (localMusicProviderView.b())) {}
      for (paramBoolean = true; (this.jdField_a_of_type_Bouo != null) && ((this.jdField_a_of_type_Bouo instanceof EditVideoActivity)) && (this.jdField_a_of_type_Bouo.getActivity() != null); paramBoolean = false)
      {
        this.jdField_a_of_type_Bouo.getActivity().runOnUiThread(new EditProviderPart.4(this, paramBoolean));
        return;
      }
    }
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Botw.a(16);
    this.jdField_a_of_type_Botw.a(paramInt);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Botw.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.jdField_a_of_type_Botw.a(Message.obtain(null, 3, 2, 0));
  }
  
  public void d()
  {
    if ((this.c != null) && (this.c.getVisibility() == 0)) {
      this.c.setVisibility(8);
    }
  }
  
  public void d(int paramInt)
  {
    ((bosy)a(bosy.class)).a(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "preloadProviderView count" + this.jdField_a_of_type_Bono.a());
    }
    Bundle localBundle = a();
    int i = 0;
    if (i < this.jdField_a_of_type_Bono.a())
    {
      int j = this.jdField_a_of_type_Bono.c(i);
      if ((paramBoolean) && (!this.jdField_a_of_type_Bono.b(j))) {}
      label223:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if ((ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)) == null)
          {
            ProviderView localProviderView = this.jdField_a_of_type_Bono.a(a(), j);
            if (localProviderView == null) {
              break label223;
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Bono.c(i)), localProviderView);
            localProviderView.setProviderViewListener(this);
            localProviderView.setDoodleEventListener(this);
            localProviderView.b(localBundle);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
            localProviderView.setVisibility(8);
            if ((localProviderView instanceof TransitionProviderView))
            {
              j = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
              ((TransitionProviderView)localProviderView).jdField_a_of_type_Int = j;
            }
            if (!paramBoolean) {
              localProviderView.e();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("EditProviderPart", 2, "preloadProviderView failed " + i);
    }
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g()
  {
    super.g();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a();
    }
    bpjt.a().b();
  }
  
  public void h() {}
  
  public void i() {}
  
  public void k()
  {
    boolean bool2 = true;
    bpju localbpju = ((bohj)bogd.a(5)).jdField_a_of_type_Bpju;
    if ((localbpju != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null))
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a(localbpju.a(this.jdField_a_of_type_Int).c);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.b();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    boolean bool1;
    if (localbpju == null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        break label111;
      }
    }
    for (;;)
    {
      QLog.d("EditProviderPart", 2, new Object[] { "comboFilterData is null, ", Boolean.valueOf(bool1), " ", Boolean.valueOf(bool2) });
      return;
      bool1 = false;
      break;
      label111:
      bool2 = false;
    }
  }
  
  public void l()
  {
    if ((this.c != null) && (this.c.getVisibility() == 0))
    {
      this.c.setVisibility(8);
      this.c = null;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void m()
  {
    super.m();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.b();
    }
    ((bohj)bogd.a(5)).jdField_a_of_type_ArrayOfBohn[this.jdField_a_of_type_Int].c((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    n();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Botw != null)
    {
      botw localbotw = this.jdField_a_of_type_Botw;
      if (botw.a(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 16384))
      {
        if (yzz.a().a() != 13) {
          break label101;
        }
        yzz.a().f();
        yzz.a().d();
      }
    }
    for (;;)
    {
      ((boje)bogd.a().c(8)).c();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(8);
      }
      return;
      label101:
      yzz.a().f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosq
 * JD-Core Version:    0.7.0.1
 */