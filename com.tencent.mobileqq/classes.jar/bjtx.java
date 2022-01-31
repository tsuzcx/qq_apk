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

public class bjtx
  extends bjxl
  implements bjky, bjtw, bkef
{
  public static String a;
  float jdField_a_of_type_Float;
  public int a;
  protected View a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bjdv jdField_a_of_type_Bjdv = new bjue(this);
  private bjgd jdField_a_of_type_Bjgd;
  private bjgh jdField_a_of_type_Bjgh = new bjud(this);
  private bjgi jdField_a_of_type_Bjgi;
  private bjgl jdField_a_of_type_Bjgl = new bjuc(this);
  private bjju jdField_a_of_type_Bjju;
  private bjxz jdField_a_of_type_Bjxz = new bjub(this);
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
  
  public bjtx(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
    this.jdField_a_of_type_Int = -1;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private void a(int paramInt)
  {
    c(paramInt, null);
  }
  
  private void a(ProviderView paramProviderView, Object paramObject)
  {
    paramProviderView.h = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
    if ((paramProviderView instanceof MusicProviderView))
    {
      paramProviderView = (MusicProviderView)MusicProviderView.class.cast(paramProviderView);
      if ((paramObject != null) && (paramObject.equals(Integer.valueOf(1001)))) {
        paramProviderView.setPreSelectTagIndex(((QIMMusicConfigManager)bjav.a(2)).a() - 1);
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
      ProviderView localProviderView = this.jdField_a_of_type_Bjju.a(a(), paramInt);
      if (localProviderView != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localProviderView);
      }
      localObject = localProviderView;
      if ((localProviderView instanceof TransitionProviderView))
      {
        i = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
        ((TransitionProviderView)localProviderView).jdField_a_of_type_Int = i;
        localObject = localProviderView;
      }
    }
    a((ProviderView)localObject, paramObject);
    if (!((ProviderView)localObject).d())
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjvt.a();
      }
      if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramInt = ((ProviderView)localObject).d();
        i = this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        ((ProviderView)localObject).d(paramInt + (int)vzl.a(a(), i));
      }
      ((ProviderView)localObject).a(a());
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView = ((ProviderView)localObject);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getId() != 2131363883) {
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
    if (this.jdField_a_of_type_Bjxn != null)
    {
      localObject1 = this.jdField_a_of_type_Bjxn;
      if (bjxn.a(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 16))
      {
        localObject1 = this.jdField_a_of_type_Bjxn;
        if (!bjxn.a(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 137438953472L))
        {
          localObject1 = ((bjcb)bjav.a(5)).jdField_a_of_type_Bkrg;
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
      localObject1 = ((bkrg)localObject1).b();
      if ((localObject1 == null) || (((List)localObject1).size() >= 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QCombo", 2, "recommend trans less than 3");
    return;
    this.c = a(2131377657);
    Object localObject2;
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (!this.jdField_a_of_type_Bjxn.e) {
        break label240;
      }
      localObject2 = (RelativeLayout)a(2131365521);
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
    String str = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_default");
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "EditProviderPart setDedaultTransition transId=" + str);
    }
    Object localObject = ((bjcb)bjav.a(5)).jdField_a_of_type_Bkrg;
    if (localObject != null)
    {
      localObject = ((bkrg)localObject).a();
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((FilterCategory)((ArrayList)localObject).get(0)).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TransitionCategoryItem localTransitionCategoryItem = (TransitionCategoryItem)((Iterator)localObject).next();
          if (localTransitionCategoryItem.k.equals(str))
          {
            bkrf.a().a(localTransitionCategoryItem);
            e(Integer.parseInt(localTransitionCategoryItem.jdField_a_of_type_JavaLangString));
          }
        }
      }
    }
  }
  
  private void x()
  {
    Object localObject = vtw.a(a()).a();
    bjed localbjed = (bjed)bjav.a().c(8);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      QIMMusicConfigManager localQIMMusicConfigManager = (QIMMusicConfigManager)bjav.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        vtx localvtx = (vtx)((Iterator)localObject).next();
        boolean bool = localbjed.a(localQIMMusicConfigManager.a(localvtx.jdField_a_of_type_Int, localvtx.jdField_b_of_type_Int), this.jdField_a_of_type_Bjdv);
        if (QLog.isColorLevel()) {
          QLog.d("EditProviderPart", 2, "EditProviderPart preDownloadMusic needDownload=" + bool + " itemId=" + localvtx.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public int a()
  {
    return (int)this.jdField_a_of_type_Bjxn.a(this.jdField_a_of_type_Bjxn.a());
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
    a(bjtw.class, this);
    int i = b();
    this.jdField_a_of_type_Int = i;
    bkrf.a().a(this.jdField_a_of_type_Bjxn);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131372054));
    this.jdField_b_of_type_AndroidViewView = a(2131364667);
    int j;
    Object localObject;
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      j = this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (j > 0) {
        break label443;
      }
      ((ViewGroup.LayoutParams)localObject).height += bkvi.e;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      if (j > 0) {
        break label456;
      }
    }
    label443:
    label456:
    for (((ViewGroup.LayoutParams)localObject).height += bkvi.e;; ((ViewGroup.LayoutParams)localObject).height = (j + ((ViewGroup.LayoutParams)localObject).height))
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_Bjju = new bjju(i);
      this.jdField_a_of_type_Bjju.a();
      this.jdField_a_of_type_Bjgi = new bjgi();
      this.jdField_a_of_type_Bjgi.a(this.jdField_a_of_type_Bjgl);
      this.jdField_a_of_type_Bjgi.a(this.jdField_a_of_type_Bjyv.a());
      this.jdField_a_of_type_Bjgd = new bjgd();
      this.jdField_a_of_type_Bjgd.a(this.jdField_a_of_type_Bjgh);
      this.jdField_a_of_type_Bjgd.a(this.jdField_a_of_type_Bjyv.a());
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)a(2131372823));
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setReadyToApply(false);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setCaptureScene(this.jdField_a_of_type_Int);
      if (birt.c.a(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f)) {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.jdField_b_of_type_Boolean = true;
      }
      j();
      this.jdField_a_of_type_AndroidViewView = a(2131372824);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new bjty(this));
      if ((this.jdField_a_of_type_Bjyv instanceof EditVideoActivity)) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131365484));
      }
      d(true);
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        ((ViewStub)a(2131372825)).inflate();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)a(2131372050));
        i = this.jdField_a_of_type_Bjxn.h();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(i);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setProviderViewListener(this);
        localObject = (BgmRecognitionProviderView)this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(110);
        if (localObject != null) {
          ((BgmRecognitionProviderView)localObject).setRecognitionPart(this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjuf);
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
      bcql.a(this.jdField_a_of_type_Bjyv.a(), ajya.a(2131703701), 0).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    super.a(paramInt, parambkld);
    if ((QIMFilterProviderView)a(QIMFilterProviderView.class) != null) {
      if (bkrf.a().b(this.jdField_a_of_type_Int) == null) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      parambkld.c = bool;
      if ((parambkld.c) && (this.jdField_a_of_type_Bjxn.a()))
      {
        parambkld = parambkld.a;
        parambkld.jdField_a_of_type_Int += 1;
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
    this.jdField_a_of_type_Bjxn.a(paramInt, paramObject);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Pair localPair = new Pair(Integer.valueOf(paramInt), paramVarArgs);
    this.jdField_a_of_type_Bjxn.a(31, localPair);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(bkgh parambkgh)
  {
    ((tcs)tcz.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
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
        Object localObject1 = (bjcb)bjav.a(5);
        Object localObject2 = localObject1.jdField_a_of_type_ArrayOfBjcf[this.jdField_a_of_type_Int].jdField_a_of_type_Bjcq;
        if (localObject2 == null) {
          break label183;
        }
        localObject2 = (QIMFilterCategoryItem)((bjcq)localObject2).a;
        if (localObject2 == null) {
          break label183;
        }
        localJSONObject.put("comboItem", ((QIMFilterCategoryItem)localObject2).a());
        i = 1;
        localObject1 = localObject1.jdField_a_of_type_ArrayOfBjcf[this.jdField_a_of_type_Int].jdField_a_of_type_Bjct;
        j = i;
        if (localObject1 != null)
        {
          localObject1 = (QIMFilterCategoryItem)((bjct)localObject1).a;
          j = i;
          if (localObject1 != null)
          {
            localJSONObject.put("filterItem", ((QIMFilterCategoryItem)localObject1).a());
            j = 1;
          }
        }
        localObject1 = ((bjed)bjav.a().c(8)).a();
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
      if (vtz.a().b() == 22)
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
    if (this.jdField_a_of_type_Bjxn.b())
    {
      if (this.jdField_a_of_type_Bjxn.a()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_a_of_type_Bjxn.a()) {
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
    this.jdField_a_of_type_Bjgi.a();
    this.jdField_a_of_type_Bjgi.a().a(true, this.jdField_a_of_type_Bjyv.getActivity());
    this.jdField_a_of_type_Bjgi.a().a(this.jdField_a_of_type_Bjxz, paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {}
    for (;;)
    {
      return;
      MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(104));
      MusicItemInfo localMusicItemInfo = ((bjed)bjav.a().c(8)).a();
      if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.needPlay())) && (localMusicProviderView.b())) {}
      for (paramBoolean = true; (this.jdField_a_of_type_Bjyv != null) && ((this.jdField_a_of_type_Bjyv instanceof EditVideoActivity)) && (this.jdField_a_of_type_Bjyv.getActivity() != null); paramBoolean = false)
      {
        this.jdField_a_of_type_Bjyv.getActivity().runOnUiThread(new EditProviderPart.4(this, paramBoolean));
        return;
      }
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void ba_()
  {
    super.ba_();
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
      this.jdField_a_of_type_Bjxn.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.jdField_a_of_type_Bjxn.a(Message.obtain(null, 3, 2, 0));
  }
  
  public void d()
  {
    Object localObject;
    if (this.jdField_a_of_type_Bjyv != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout = ((HorizontalAlumbListLayout)a(2131370734));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131373358));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setTipsContent(this.jdField_a_of_type_AndroidWidgetTextView);
      if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        break label394;
      }
      if (!this.jdField_a_of_type_Bjxn.e) {
        break label345;
      }
      localObject = (RelativeLayout)a(2131365521);
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
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setEditVideoUI(this.jdField_a_of_type_Bjyv);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.a(vtz.a().a());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(0);
      if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("PhotoConst.IS_FROM_EDIT", false)) {
        vtz.a().b();
      }
      vtz.a().a(this.jdField_a_of_type_Bjyv.getActivity());
      c();
      if (bjxn.a(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 16)) {
        w();
      }
      x();
      try
      {
        localObject = this.jdField_a_of_type_Bjyv.getActivity().getIntent();
        int i = ((EditVideoParams)((Intent)localObject).getParcelableExtra(EditVideoParams.class.getName())).a("extra_slide_entrance", -1);
        vei.a("video_edit_new", "exp_albumbar", (Intent)localObject, new String[] { i + "" });
        return;
        label345:
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, a().getDimensionPixelOffset(2131297902));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        continue;
        label394:
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, a().getDimensionPixelOffset(2131297902));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("EditProviderPart", 2, bfnu.a(localException));
      }
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Bjxn.a(32);
    this.jdField_a_of_type_Bjxn.a(paramInt);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "preloadProviderView count" + this.jdField_a_of_type_Bjju.a());
    }
    Bundle localBundle = a();
    int i = 0;
    if (i < this.jdField_a_of_type_Bjju.a())
    {
      int j = this.jdField_a_of_type_Bjju.d(i);
      if ((paramBoolean) && (!this.jdField_a_of_type_Bjju.b(j))) {}
      label223:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if ((ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)) == null)
          {
            ProviderView localProviderView = this.jdField_a_of_type_Bjju.a(a(), j);
            if (localProviderView == null) {
              break label223;
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Bjju.d(i)), localProviderView);
            localProviderView.setProviderViewListener(this);
            localProviderView.setDoodleEventListener(this);
            localProviderView.b(localBundle);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
            localProviderView.setVisibility(8);
            if ((localProviderView instanceof TransitionProviderView))
            {
              j = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
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
    ((bjur)a(bjur.class)).a(paramInt);
  }
  
  public void f()
  {
    super.f();
    bkrf.a().a(this.jdField_a_of_type_Int);
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ProviderView)((Iterator)localObject).next()).e();
    }
    ((bjcb)bjav.a(5)).jdField_a_of_type_ArrayOfBjcf[this.jdField_a_of_type_Int].a((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    localObject = this.jdField_a_of_type_Bjxn;
    if ((bjxn.a(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 137438953472L)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.a(vtz.a().a());
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
    bkrf.a().b();
  }
  
  public void h() {}
  
  public void i() {}
  
  public void j()
  {
    boolean bool2 = true;
    bkrg localbkrg = ((bjcb)bjav.a(5)).jdField_a_of_type_Bkrg;
    if ((localbkrg != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null))
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a(localbkrg.a(this.jdField_a_of_type_Int).c);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.b();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    boolean bool1;
    if (localbkrg == null)
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
    this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjyn.a(this.jdField_a_of_type_Bjxn.a());
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
    ((bjcb)bjav.a(5)).jdField_a_of_type_ArrayOfBjcf[this.jdField_a_of_type_Int].c((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    n();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Bjxn != null)
    {
      bjxn localbjxn = this.jdField_a_of_type_Bjxn;
      if (bjxn.a(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 137438953472L))
      {
        if (vtz.a().a() != 13) {
          break label101;
        }
        vtz.a().f();
        vtz.a().d();
      }
    }
    for (;;)
    {
      ((bjed)bjav.a().c(8)).e();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(8);
      }
      return;
      label101:
      vtz.a().f();
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
 * Qualified Name:     bjtx
 * JD-Core Version:    0.7.0.1
 */