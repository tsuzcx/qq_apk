package com.tencent.biz.qqstory.takevideo;

import alpo;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Build.VERSION;
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
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import axpq;
import bdcb;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import java.util.ArrayList;
import java.util.List;
import uqj;
import uqm;
import uqs;
import urk;
import urr;
import wsv;
import wta;
import wtb;
import wtk;
import wve;
import wvf;
import wvg;
import wwc;
import wwe;
import xej;
import xek;
import xel;
import xeq;
import xet;
import xgs;

public class EditVideoFilter
  extends wwc
  implements wtk
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f = alpo.a(2131704171);
  public static final String g = alpo.a(2131704108);
  public static final String h = alpo.a(2131704102);
  public int a;
  public long a;
  public SparseArray<xej> a;
  private SparseIntArray a;
  protected View a;
  public EditVideoFilter.FilterPagerAdapter a;
  public UnHandleTouchEventViewPager a;
  protected xel a;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131704165);
    jdField_b_of_type_JavaLangString = alpo.a(2131704156);
    c = alpo.a(2131704283);
    d = alpo.a(2131704240);
    jdField_e_of_type_JavaLangString = alpo.a(2131704180);
  }
  
  public EditVideoFilter(@NonNull wwe paramwwe)
  {
    super(paramwwe);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  }
  
  public static int a(@NonNull xej paramxej)
  {
    wsv.b("Q.qqstory.publish.edit.EditVideoFilter", "getSpecialSaveMode : mVideoPlayMode = " + paramxej.jdField_a_of_type_Int);
    switch (paramxej.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 1: 
      return 5;
    case 3: 
      return 2;
    case 4: 
      return 6;
    case 5: 
      return 7;
    case 6: 
      return 8;
    }
    return 9;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getVisibility() != paramInt) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setVisibility(paramInt);
      }
    } while (this.jdField_a_of_type_AndroidViewView.getVisibility() == paramInt);
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public static void a(xek paramxek)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    paramxek.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public int a()
  {
    return b(this.jdField_a_of_type_Wwe.a());
  }
  
  public int a(int paramInt)
  {
    xej localxej = (xej)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localxej == null) {
      return 0;
    }
    return localxej.jdField_a_of_type_Int;
  }
  
  @Nullable
  public View a()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    Object localObject = (xej)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if ((localObject != null) && (((xek)localObject).a())) {
      return ((xek)localObject).jdField_a_of_type_AndroidViewView;
    }
    return null;
  }
  
  public xel a()
  {
    return this.jdField_a_of_type_Xel;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)a(2131364822));
    this.jdField_a_of_type_AndroidViewView = a(2131366364);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new wve(this));
    if ((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 12))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getLayoutParams();
      localLayoutParams.height = ((int)(bdcb.k() * this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()));
      this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter = new EditVideoFilter.FilterPagerAdapter(a());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(new wvf(this));
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new wvg(this, null));
    wsv.b("Q.qqstory.publish.edit.EditVideoFilter", "init filter view pager : " + this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager);
    f();
    g();
    a(wtk.class, this);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 11: 
    case 12: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 25: 
    case 26: 
    default: 
      a(4);
    case 10: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 24: 
      return;
    }
    a(0);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.notifyDataSetChanged();
  }
  
  public void a(int paramInt, @NonNull xgs paramxgs)
  {
    super.a(paramInt, paramxgs);
    Object localObject2 = a();
    if (localObject2 != null) {
      paramxgs.a.videoAddress = AddressItem.generatePoiJson(QQStoryContext.a().a(), ((xel)localObject2).jdField_e_of_type_JavaLangString, ((xel)localObject2).f, ((xel)localObject2).g, ((xel)localObject2).h, ((xel)localObject2).i, ((xel)localObject2).c, ((xel)localObject2).d, ((xel)localObject2).jdField_e_of_type_Int);
    }
    Object localObject1 = (xej)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof xel))) {
      paramxgs.a.gpsFilterDescription = ((xel)localObject2).a();
    }
    if (this.jdField_a_of_type_Wwe.a.d()) {
      paramxgs.a.localCreateCity = this.jdField_a_of_type_Wwe.a.a("extra_local_address_city_name");
    }
    paramxgs.a(a());
    paramxgs.a.saveMode = b(paramInt);
    paramxgs.a.putExtra("useFlowDecode", Boolean.valueOf(axpq.b));
    paramxgs = "";
    int i = -1;
    paramInt = 0;
    if (localObject1 != null)
    {
      paramxgs = ((xej)localObject1).jdField_a_of_type_JavaLangString;
      i = ((xej)localObject1).jdField_b_of_type_Int;
      paramInt = ((xej)localObject1).jdField_a_of_type_Int;
    }
    long l;
    if (i != -1)
    {
      localObject2 = this.jdField_a_of_type_Wwe;
      int j = this.jdField_a_of_type_Wwe.b();
      if (this.jdField_a_of_type_Wwe.a())
      {
        localObject1 = "2";
        ((wwe)localObject2).b("pub_filter_menu", j, 0, new String[] { String.valueOf(i), paramxgs, localObject1 });
      }
    }
    else
    {
      if (i != -1) {
        wtb.a("0X80076E9", String.valueOf(wtb.jdField_b_of_type_Int), String.valueOf(paramInt), paramxgs, String.valueOf(i));
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      paramInt = this.jdField_a_of_type_Int;
      wsv.a("Q.qqstory.publish.edit.EditVideoFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l), Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_Wwe.a()) {
        break label398;
      }
    }
    label398:
    for (paramxgs = "2";; paramxgs = "1")
    {
      wta.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l), String.valueOf(paramInt), paramxgs });
      return;
      localObject1 = "1";
      break;
    }
  }
  
  public boolean a(int paramInt)
  {
    xej localxej = (xej)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    return (localxej != null) && (localxej.a());
  }
  
  public boolean a(int paramInt1, Canvas paramCanvas, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    paramInt1 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1);
    Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getWidth();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getHeight();
    if (localObject2 != null)
    {
      if (!((xek)localObject2).a()) {
        break label226;
      }
      localObject1 = ((xek)localObject2).jdField_a_of_type_AndroidViewView;
      localObject2 = null;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        paramCanvas.save();
        paramCanvas.scale(paramInt2 / i, paramInt3 / j);
        ((View)localObject1).draw(paramCanvas);
        paramCanvas.restore();
        if (localObject2 != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.destroyItem((ViewGroup)localObject1, paramInt1, localObject2);
        }
        return true;
        localObject1 = new FrameLayout(a());
        ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getLayoutParams()));
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.instantiateItem((ViewGroup)localObject1, paramInt1);
        ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getMeasuredHeight(), 1073741824));
        ((View)localObject1).layout(0, 0, this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getWidth(), this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getHeight());
      }
      else
      {
        return false;
        label226:
        localObject2 = null;
      }
    }
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof uqm))
      {
        paramMessage = (uqm)paramMessage.obj;
        this.jdField_a_of_type_Xel = new xel(0, h, 8, paramMessage.c, paramMessage.d, paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.jdField_b_of_type_JavaLangString, paramMessage.jdField_e_of_type_JavaLangString, "", paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int, 1);
        g();
        wsv.a("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE POIFilterData is available : country : %s, city : %s, district : %s .", paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.d);
      }
      for (;;)
      {
        return true;
        wsv.e("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE Message Error! Message obj type mismatch");
      }
      int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
      int j = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Wwe.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a() * 50);
      wsv.b("Q.qqstory.publish.edit.EditVideoFilter", "change video block from %d to %d, change page from %d to %d", Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2), Integer.valueOf(i), Integer.valueOf(j));
      if (i != j) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(j, false);
      }
    }
  }
  
  public void ad_()
  {
    super.ad_();
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    xej localxej = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if (localxej != null) {
      return localxej.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    xej localxej = (xej)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localxej == null) {
      return 0;
    }
    return a(localxej);
  }
  
  protected void f()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = a();
      if ((localObject != null) && (((Context)localObject).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
        return;
      }
    }
    String str2 = null;
    String str3 = null;
    Object localObject = null;
    String str1 = null;
    String str4 = null;
    int k = 0;
    int m = 0;
    uqj localuqj = (uqj)((uqs)urr.a(20)).a(1);
    uqm localuqm = (uqm)localuqj.a();
    int i;
    if (localuqm != null)
    {
      wsv.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from cache.");
      str2 = localuqm.jdField_a_of_type_JavaLangString;
      str3 = localuqm.jdField_b_of_type_JavaLangString;
      localObject = localuqm.c;
      str1 = localuqm.d;
      str4 = localuqm.jdField_e_of_type_JavaLangString;
      k = localuqm.jdField_a_of_type_Int;
      m = localuqm.jdField_b_of_type_Int;
      if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.isEmpty(str1))) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0)
      {
        wsv.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from sp.");
        str2 = localuqj.a();
        str3 = localuqj.b();
        localObject = localuqj.c();
        str1 = localuqj.d();
        str4 = localuqj.e();
        k = localuqj.a();
        m = localuqj.b();
        long l = localuqj.a();
        if (((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str1))) || ((float)(System.currentTimeMillis() - l) >= 1800000.0F)) {
          break label305;
        }
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label318;
        }
        wsv.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from net.");
        localuqj.a();
        return;
        wsv.b("Q.qqstory.publish.edit.EditVideoFilter", "country,city,district all empty.");
        i = 0;
        break;
        label305:
        wsv.b("Q.qqstory.publish.edit.EditVideoFilter", "country,city,district all empty or overTime.");
      }
      label318:
      this.jdField_a_of_type_Xel = new xel(0, h, 8, (String)localObject, str1, str2, (String)localObject, str3, str4, "", k, m, 1);
      return;
      i = 0;
    }
  }
  
  public void g()
  {
    wsv.a("Q.qqstory.publish.edit.EditVideoFilter", "updateFilterMode : %s", this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new xet("", -1, 0, 0));
    boolean bool;
    if (((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)))
    {
      if (((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
      {
        if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
        {
          bool = ((Boolean)((urk)urr.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
          if ((!(this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || (bool)) {
            break label444;
          }
          wsv.d("Q.qqstory.publish.edit.EditVideoFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        label201:
        if ((!(this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || (axpq.a)) {
          break label509;
        }
        wsv.d("Q.qqstory.publish.edit.EditVideoFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
    }
    else
    {
      label247:
      localArrayList.add(new xeq(0, g, 7, this.jdField_a_of_type_Wwe.a));
      if (this.jdField_a_of_type_Xel != null) {
        localArrayList.add(this.jdField_a_of_type_Xel);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(localArrayList);
      this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!localArrayList.isEmpty()) {
        break label609;
      }
    }
    label444:
    label609:
    for (int i = 0;; i = ((xej)localArrayList.get(0)).jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      return;
      bool = ((Boolean)((urk)urr.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!bool))
      {
        wsv.d("Q.qqstory.publish.edit.EditVideoFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break;
      }
      localArrayList.add(new xet(jdField_a_of_type_JavaLangString, 1, 2130845999, 2));
      break;
      if ((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 10) && (!this.jdField_a_of_type_Wwe.a.i()))
      {
        wsv.d("Q.qqstory.publish.edit.EditVideoFilter", "it's tribe slow black model, disable slow!");
        break label201;
      }
      localArrayList.add(new xet(jdField_b_of_type_JavaLangString, 2, 2130846000, 3));
      break label201;
      label509:
      if ((this.jdField_a_of_type_Wwe.a.jdField_a_of_type_Int == 10) && (!this.jdField_a_of_type_Wwe.a.h()))
      {
        wsv.d("Q.qqstory.publish.edit.EditVideoFilter", "it's tribe revert black model, disable revert!");
        break label247;
      }
      xet localxet = new xet(c, 3, 2130845998, 1);
      if (this.jdField_a_of_type_Wwe.a.g()) {}
      for (String str = alpo.a(2131704307);; str = null)
      {
        localxet.jdField_b_of_type_JavaLangString = str;
        localArrayList.add(localxet);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter
 * JD-Core Version:    0.7.0.1
 */