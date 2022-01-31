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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView;
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

public class bicj
  extends bifz
  implements bhpp, bici, bimt
{
  public static String a;
  float jdField_a_of_type_Float;
  public int a;
  protected View a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bhim jdField_a_of_type_Bhim = new bicq(this);
  private bhku jdField_a_of_type_Bhku;
  private bhky jdField_a_of_type_Bhky = new bicp(this);
  private bhkz jdField_a_of_type_Bhkz;
  private bhlc jdField_a_of_type_Bhlc = new bico(this);
  private bhol jdField_a_of_type_Bhol;
  private bign jdField_a_of_type_Bign = new bicn(this);
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
  
  public bicj(@NonNull bigb parambigb)
  {
    super(parambigb);
    this.jdField_a_of_type_Int = -1;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private void a(int paramInt)
  {
    c(paramInt, null);
  }
  
  private void a(ProviderView paramProviderView, Object paramObject)
  {
    paramProviderView.h = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
    if ((paramProviderView instanceof MusicProviderView))
    {
      paramProviderView = (MusicProviderView)MusicProviderView.class.cast(paramProviderView);
      if ((paramObject != null) && (paramObject.equals(Integer.valueOf(1001)))) {
        paramProviderView.setPreSelectTagIndex(((QIMMusicConfigManager)bhfm.a(2)).a() - 1);
      }
    }
    try
    {
      paramProviderView.h();
      return;
    }
    catch (Throwable paramProviderView)
    {
      QLog.d("EditProviderPart", 1, String.format("throwable = %s", new Object[] { paramProviderView }));
    }
  }
  
  private void c(int paramInt, Object paramObject)
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
      ProviderView localProviderView = this.jdField_a_of_type_Bhol.a(a(), paramInt);
      if (localProviderView != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localProviderView);
      }
      localObject = localProviderView;
      if ((localProviderView instanceof TransitionProviderView))
      {
        i = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
        ((TransitionProviderView)localProviderView).jdField_a_of_type_Int = i;
        localObject = localProviderView;
      }
    }
    a((ProviderView)localObject, paramObject);
    if (!((ProviderView)localObject).d())
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_Bigb.jdField_a_of_type_Bief.a();
      }
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramInt = ((ProviderView)localObject).d();
        i = this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        ((ProviderView)localObject).d(paramInt + (int)vms.a(a(), i));
      }
      ((ProviderView)localObject).a(a());
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView = ((ProviderView)localObject);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getId() != 2131298328) {
      b(false);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.c();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void v()
  {
    Object localObject1;
    if (this.jdField_a_of_type_Bigb != null)
    {
      localObject1 = this.jdField_a_of_type_Bigb;
      if (bigb.a(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 16))
      {
        localObject1 = this.jdField_a_of_type_Bigb;
        if (!bigb.a(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 137438953472L))
        {
          localObject1 = ((bhgs)bhfm.a(5)).jdField_a_of_type_Bjad;
          if (localObject1 != null) {
            break label86;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "comboFilterData null");
          }
        }
      }
    }
    label86:
    do
    {
      return;
      localObject1 = ((bjad)localObject1).b();
      if ((localObject1 == null) || (((List)localObject1).size() >= 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QCombo", 2, "recommend trans less than 3");
    return;
    this.c = a(2131311842);
    Object localObject2;
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (!this.jdField_a_of_type_Bigb.e) {
        break label240;
      }
      localObject2 = (RelativeLayout)a(2131299942);
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
      label240:
      localObject2 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, 0);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  private void w()
  {
    String str = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_default");
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "EditProviderPart setDedaultTransition transId=" + str);
    }
    Object localObject = ((bhgs)bhfm.a(5)).jdField_a_of_type_Bjad;
    if (localObject != null)
    {
      localObject = ((bjad)localObject).a();
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((FilterCategory)((ArrayList)localObject).get(0)).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TransitionCategoryItem localTransitionCategoryItem = (TransitionCategoryItem)((Iterator)localObject).next();
          if (localTransitionCategoryItem.k.equals(str))
          {
            bjac.a().a(localTransitionCategoryItem);
            e(Integer.parseInt(localTransitionCategoryItem.jdField_a_of_type_JavaLangString));
          }
        }
      }
    }
  }
  
  private void x()
  {
    Object localObject = vhd.a(a()).a();
    bhiu localbhiu = (bhiu)bhfm.a().c(8);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      QIMMusicConfigManager localQIMMusicConfigManager = (QIMMusicConfigManager)bhfm.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        vhe localvhe = (vhe)((Iterator)localObject).next();
        boolean bool = localbhiu.a(localQIMMusicConfigManager.a(localvhe.jdField_a_of_type_Int, localvhe.jdField_b_of_type_Int), this.jdField_a_of_type_Bhim);
        if (QLog.isColorLevel()) {
          QLog.d("EditProviderPart", 2, "EditProviderPart preDownloadMusic needDownload=" + bool + " itemId=" + localvhe.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public int a()
  {
    return (int)this.jdField_a_of_type_Bigb.a(this.jdField_a_of_type_Bigb.a());
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
    a(bici.class, this);
    int i = b();
    this.jdField_a_of_type_Int = i;
    bjac.a().a(this.jdField_a_of_type_Bigb);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131306357));
    this.jdField_b_of_type_AndroidViewView = a(2131299108);
    int j;
    Object localObject;
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      j = this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (j > 0) {
        break label443;
      }
      ((ViewGroup.LayoutParams)localObject).height += bjeh.e;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      if (j > 0) {
        break label456;
      }
    }
    label443:
    label456:
    for (((ViewGroup.LayoutParams)localObject).height += bjeh.e;; ((ViewGroup.LayoutParams)localObject).height = (j + ((ViewGroup.LayoutParams)localObject).height))
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_Bhol = new bhol(i);
      this.jdField_a_of_type_Bhol.a();
      this.jdField_a_of_type_Bhkz = new bhkz();
      this.jdField_a_of_type_Bhkz.a(this.jdField_a_of_type_Bhlc);
      this.jdField_a_of_type_Bhkz.a(this.jdField_a_of_type_Bihj.a());
      this.jdField_a_of_type_Bhku = new bhku();
      this.jdField_a_of_type_Bhku.a(this.jdField_a_of_type_Bhky);
      this.jdField_a_of_type_Bhku.a(this.jdField_a_of_type_Bihj.a());
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)a(2131307109));
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setReadyToApply(false);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setCaptureScene(this.jdField_a_of_type_Int);
      if (bgww.b.a(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f)) {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.jdField_b_of_type_Boolean = true;
      }
      j();
      this.jdField_a_of_type_AndroidViewView = a(2131307110);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new bick(this));
      if ((this.jdField_a_of_type_Bihj instanceof EditVideoActivity)) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131299905));
      }
      d(true);
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        ((ViewStub)a(2131307111)).inflate();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)a(2131306353));
        i = this.jdField_a_of_type_Bigb.h();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(i);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setProviderViewListener(this);
        localObject = (BgmRecognitionProviderView)this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(110);
        if (localObject != null) {
          ((BgmRecognitionProviderView)localObject).setRecognitionPart(this.jdField_a_of_type_Bigb.jdField_a_of_type_Bicr);
        }
      }
      return;
      ((ViewGroup.LayoutParams)localObject).height += j;
      break;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (1 == paramInt1) {
      bbmy.a(this.jdField_a_of_type_Bihj.a(), ajjy.a(2131637905), 0).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    super.a(paramInt, parambitz);
    if ((QIMFilterProviderView)a(QIMFilterProviderView.class) != null) {
      if (bjac.a().b(this.jdField_a_of_type_Int) == null) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      parambitz.c = bool;
      if ((parambitz.c) && (this.jdField_a_of_type_Bigb.a()))
      {
        parambitz = parambitz.a;
        parambitz.jdField_a_of_type_Int += 1;
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
    this.jdField_a_of_type_Bigb.a(paramInt, paramObject);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Pair localPair = new Pair(Integer.valueOf(paramInt), paramVarArgs);
    this.jdField_a_of_type_Bigb.a(31, localPair);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(biov parambiov)
  {
    ((spz)sqg.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
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
        Object localObject1 = (bhgs)bhfm.a(5);
        Object localObject2 = localObject1.jdField_a_of_type_ArrayOfBhgw[this.jdField_a_of_type_Int].jdField_a_of_type_Bhhh;
        if (localObject2 == null) {
          break label183;
        }
        localObject2 = (QIMFilterCategoryItem)((bhhh)localObject2).a;
        if (localObject2 == null) {
          break label183;
        }
        localJSONObject.put("comboItem", ((QIMFilterCategoryItem)localObject2).a());
        i = 1;
        localObject1 = localObject1.jdField_a_of_type_ArrayOfBhgw[this.jdField_a_of_type_Int].jdField_a_of_type_Bhhk;
        j = i;
        if (localObject1 != null)
        {
          localObject1 = (QIMFilterCategoryItem)((bhhk)localObject1).a;
          j = i;
          if (localObject1 != null)
          {
            localJSONObject.put("filterItem", ((QIMFilterCategoryItem)localObject1).a());
            j = 1;
          }
        }
        localObject1 = ((bhiu)bhfm.a().c(8)).a();
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
  
  public void a_(int paramInt, Object paramObject)
  {
    super.a_(paramInt, paramObject);
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
      a(103);
      continue;
      a(104);
      if (vhg.a().b() == 22)
      {
        LpReportInfo_pf00064.allReport(680, 3, 1);
        continue;
        c(104, paramObject);
        continue;
        a(107);
        continue;
        a(101);
        continue;
        a(108);
        continue;
        a(112);
        continue;
        this.jdField_a_of_type_Boolean = true;
        l();
        continue;
        this.jdField_a_of_type_Boolean = false;
        l();
        if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
        }
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Bigb.b())
    {
      if (this.jdField_a_of_type_Bigb.a()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_a_of_type_Bigb.a()) {
      return 1;
    }
    return 2;
  }
  
  public void b()
  {
    v();
  }
  
  public void b(int paramInt) {}
  
  public void b(int paramInt, Object paramObject)
  {
    if (paramInt == 7) {
      l();
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Bhkz.a();
    this.jdField_a_of_type_Bhkz.a().a(true, this.jdField_a_of_type_Bihj.getActivity());
    this.jdField_a_of_type_Bhkz.a().a(this.jdField_a_of_type_Bign, paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {}
    for (;;)
    {
      return;
      MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(104));
      MusicItemInfo localMusicItemInfo = ((bhiu)bhfm.a().c(8)).a();
      if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.needPlay())) && (localMusicProviderView.b())) {}
      for (paramBoolean = true; (this.jdField_a_of_type_Bihj != null) && ((this.jdField_a_of_type_Bihj instanceof EditVideoActivity)) && (this.jdField_a_of_type_Bihj.getActivity() != null); paramBoolean = false)
      {
        this.jdField_a_of_type_Bihj.getActivity().runOnUiThread(new EditProviderPart.4(this, paramBoolean));
        return;
      }
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void bf_()
  {
    super.bf_();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).f();
    }
  }
  
  public void c()
  {
    if ((this.c != null) && (this.c.getVisibility() == 0)) {
      this.c.setVisibility(8);
    }
  }
  
  public void c(int paramInt) {}
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bigb.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.jdField_a_of_type_Bigb.a(Message.obtain(null, 3, 2, 0));
  }
  
  public void d()
  {
    Object localObject;
    if (this.jdField_a_of_type_Bihj != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout = ((HorizontalAlumbListLayout)a(2131305067));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131307643));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setTipsContent(this.jdField_a_of_type_AndroidWidgetTextView);
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        break label394;
      }
      if (!this.jdField_a_of_type_Bigb.e) {
        break label345;
      }
      localObject = (RelativeLayout)a(2131299942);
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
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setEditVideoUI(this.jdField_a_of_type_Bihj);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.a(vhg.a().a());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(0);
      if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("PhotoConst.IS_FROM_EDIT", false)) {
        vhg.a().b();
      }
      vhg.a().a(this.jdField_a_of_type_Bihj.getActivity());
      c();
      if (bigb.a(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 16)) {
        w();
      }
      x();
      try
      {
        localObject = this.jdField_a_of_type_Bihj.getActivity().getIntent();
        int i = ((EditVideoParams)((Intent)localObject).getParcelableExtra(EditVideoParams.class.getName())).a("extra_slide_entrance", -1);
        urp.a("video_edit_new", "exp_albumbar", (Intent)localObject, new String[] { i + "" });
        return;
        label345:
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, a().getDimensionPixelOffset(2131166812));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        continue;
        label394:
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, a().getDimensionPixelOffset(2131166812));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("EditProviderPart", 2, befj.a(localException));
      }
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Bigb.a(32);
    this.jdField_a_of_type_Bigb.a(paramInt);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "preloadProviderView count" + this.jdField_a_of_type_Bhol.a());
    }
    Bundle localBundle = a();
    int i = 0;
    if (i < this.jdField_a_of_type_Bhol.a())
    {
      int j = this.jdField_a_of_type_Bhol.d(i);
      if ((paramBoolean) && (!this.jdField_a_of_type_Bhol.b(j))) {}
      label223:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if ((ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)) == null)
          {
            ProviderView localProviderView = this.jdField_a_of_type_Bhol.a(a(), j);
            if (localProviderView == null) {
              break label223;
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Bhol.d(i)), localProviderView);
            localProviderView.setProviderViewListener(this);
            localProviderView.setDoodleEventListener(this);
            localProviderView.b(localBundle);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
            localProviderView.setVisibility(8);
            if ((localProviderView instanceof TransitionProviderView))
            {
              j = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
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
  
  public void e(int paramInt)
  {
    ((bidd)a(bidd.class)).a(paramInt);
  }
  
  public void f()
  {
    super.f();
    bjac.a().a(this.jdField_a_of_type_Int);
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ProviderView)((Iterator)localObject).next()).e();
    }
    ((bhgs)bhfm.a(5)).jdField_a_of_type_ArrayOfBhgw[this.jdField_a_of_type_Int].a((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    localObject = this.jdField_a_of_type_Bigb;
    if ((bigb.a(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 137438953472L)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.a(vhg.a().a());
    }
    if (!this.jdField_b_of_type_Boolean) {
      ThreadManager.getUIHandler().postDelayed(new EditProviderPart.3(this), 500L);
    }
  }
  
  public void g()
  {
    super.g();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a();
    }
    bjac.a().b();
  }
  
  public void h() {}
  
  public void i() {}
  
  public void j()
  {
    boolean bool2 = true;
    bjad localbjad = ((bhgs)bhfm.a(5)).jdField_a_of_type_Bjad;
    if ((localbjad != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null))
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a(localbjad.a(this.jdField_a_of_type_Int).c);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.b();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    boolean bool1;
    if (localbjad == null)
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
  
  public void k()
  {
    this.jdField_a_of_type_Bigb.jdField_a_of_type_Bihb.a(this.jdField_a_of_type_Bigb.a());
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
    ((bhgs)bhfm.a(5)).jdField_a_of_type_ArrayOfBhgw[this.jdField_a_of_type_Int].c((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    n();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Bigb != null)
    {
      bigb localbigb = this.jdField_a_of_type_Bigb;
      if (bigb.a(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 137438953472L))
      {
        if (vhg.a().a() != 13) {
          break label101;
        }
        vhg.a().f();
        vhg.a().d();
      }
    }
    for (;;)
    {
      ((bhiu)bhfm.a().c(8)).e();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(8);
      }
      return;
      label101:
      vhg.a().f();
    }
  }
  
  public void o() {}
  
  public void p() {}
  
  public void q() {}
  
  public void r() {}
  
  public void s() {}
  
  public void t() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bicj
 * JD-Core Version:    0.7.0.1
 */