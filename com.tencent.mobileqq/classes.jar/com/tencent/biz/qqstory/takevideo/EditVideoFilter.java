package com.tencent.biz.qqstory.takevideo;

import ajya;
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
import avxr;
import bbdh;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import java.util.ArrayList;
import java.util.List;
import tbr;
import tbu;
import tca;
import tcs;
import tcz;
import ved;
import vei;
import vej;
import ves;
import vgm;
import vgn;
import vgo;
import vhk;
import vhm;
import vpr;
import vps;
import vpt;
import vpy;
import vqb;
import vsa;

public class EditVideoFilter
  extends vhk
  implements ves
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f = ajya.a(2131703799);
  public static final String g = ajya.a(2131703736);
  public static final String h = ajya.a(2131703730);
  public int a;
  public long a;
  public SparseArray<vpr> a;
  private SparseIntArray a;
  protected View a;
  public EditVideoFilter.FilterPagerAdapter a;
  public UnHandleTouchEventViewPager a;
  protected vpt a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131703793);
    jdField_b_of_type_JavaLangString = ajya.a(2131703784);
    c = ajya.a(2131703911);
    d = ajya.a(2131703868);
    jdField_e_of_type_JavaLangString = ajya.a(2131703808);
  }
  
  public EditVideoFilter(@NonNull vhm paramvhm)
  {
    super(paramvhm);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  }
  
  public static int a(@NonNull vpr paramvpr)
  {
    ved.b("Q.qqstory.publish.edit.EditVideoFilter", "getSpecialSaveMode : mVideoPlayMode = " + paramvpr.jdField_a_of_type_Int);
    switch (paramvpr.jdField_a_of_type_Int)
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
  
  public static void a(vps paramvps)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    paramvps.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void V_()
  {
    super.V_();
  }
  
  public int a()
  {
    return b(this.jdField_a_of_type_Vhm.a());
  }
  
  public int a(int paramInt)
  {
    vpr localvpr = (vpr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localvpr == null) {
      return 0;
    }
    return localvpr.jdField_a_of_type_Int;
  }
  
  @Nullable
  public View a()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    Object localObject = (vpr)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if ((localObject != null) && (((vps)localObject).a())) {
      return ((vps)localObject).jdField_a_of_type_AndroidViewView;
    }
    return null;
  }
  
  public vpt a()
  {
    return this.jdField_a_of_type_Vpt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)a(2131364743));
    this.jdField_a_of_type_AndroidViewView = a(2131366270);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new vgm(this));
    if ((this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Int == 12))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getLayoutParams();
      localLayoutParams.height = ((int)(bbdh.k() * this.jdField_a_of_type_Vhm.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Vhm.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()));
      this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter = new EditVideoFilter.FilterPagerAdapter(a());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(new vgn(this));
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new vgo(this, null));
    ved.b("Q.qqstory.publish.edit.EditVideoFilter", "init filter view pager : " + this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager);
    f();
    g();
    a(ves.class, this);
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
  
  public void a(int paramInt, @NonNull vsa paramvsa)
  {
    super.a(paramInt, paramvsa);
    Object localObject2 = a();
    if (localObject2 != null) {
      paramvsa.a.videoAddress = AddressItem.generatePoiJson(QQStoryContext.a().a(), ((vpt)localObject2).jdField_e_of_type_JavaLangString, ((vpt)localObject2).f, ((vpt)localObject2).g, ((vpt)localObject2).h, ((vpt)localObject2).i, ((vpt)localObject2).c, ((vpt)localObject2).d, ((vpt)localObject2).jdField_e_of_type_Int);
    }
    Object localObject1 = (vpr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof vpt))) {
      paramvsa.a.gpsFilterDescription = ((vpt)localObject2).a();
    }
    if (this.jdField_a_of_type_Vhm.a.d()) {
      paramvsa.a.localCreateCity = this.jdField_a_of_type_Vhm.a.a("extra_local_address_city_name");
    }
    paramvsa.a(a());
    paramvsa.a.saveMode = b(paramInt);
    paramvsa.a.putExtra("useFlowDecode", Boolean.valueOf(avxr.b));
    paramvsa = "";
    int i = -1;
    paramInt = 0;
    if (localObject1 != null)
    {
      paramvsa = ((vpr)localObject1).jdField_a_of_type_JavaLangString;
      i = ((vpr)localObject1).jdField_b_of_type_Int;
      paramInt = ((vpr)localObject1).jdField_a_of_type_Int;
    }
    long l;
    if (i != -1)
    {
      localObject2 = this.jdField_a_of_type_Vhm;
      int j = this.jdField_a_of_type_Vhm.b();
      if (this.jdField_a_of_type_Vhm.a())
      {
        localObject1 = "2";
        ((vhm)localObject2).b("pub_filter_menu", j, 0, new String[] { String.valueOf(i), paramvsa, localObject1 });
      }
    }
    else
    {
      if (i != -1) {
        vej.a("0X80076E9", String.valueOf(vej.jdField_b_of_type_Int), String.valueOf(paramInt), paramvsa, String.valueOf(i));
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      paramInt = this.jdField_a_of_type_Int;
      ved.a("Q.qqstory.publish.edit.EditVideoFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l), Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_Vhm.a()) {
        break label398;
      }
    }
    label398:
    for (paramvsa = "2";; paramvsa = "1")
    {
      vei.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l), String.valueOf(paramInt), paramvsa });
      return;
      localObject1 = "1";
      break;
    }
  }
  
  public boolean a(int paramInt)
  {
    vpr localvpr = (vpr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    return (localvpr != null) && (localvpr.a());
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
      if (!((vps)localObject2).a()) {
        break label226;
      }
      localObject1 = ((vps)localObject2).jdField_a_of_type_AndroidViewView;
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
      if ((paramMessage.obj instanceof tbu))
      {
        paramMessage = (tbu)paramMessage.obj;
        this.jdField_a_of_type_Vpt = new vpt(0, h, 8, paramMessage.c, paramMessage.d, paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.jdField_b_of_type_JavaLangString, paramMessage.jdField_e_of_type_JavaLangString, "", paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int, 1);
        g();
        ved.a("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE POIFilterData is available : country : %s, city : %s, district : %s .", paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.d);
      }
      for (;;)
      {
        return true;
        ved.e("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE Message Error! Message obj type mismatch");
      }
      int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
      int j = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Vhm.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a() * 50);
      ved.b("Q.qqstory.publish.edit.EditVideoFilter", "change video block from %d to %d, change page from %d to %d", Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2), Integer.valueOf(i), Integer.valueOf(j));
      if (i != j) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(j, false);
      }
    }
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    vpr localvpr = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if (localvpr != null) {
      return localvpr.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    vpr localvpr = (vpr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localvpr == null) {
      return 0;
    }
    return a(localvpr);
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
    tbr localtbr = (tbr)((tca)tcz.a(20)).a(1);
    tbu localtbu = (tbu)localtbr.a();
    int i;
    if (localtbu != null)
    {
      ved.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from cache.");
      str2 = localtbu.jdField_a_of_type_JavaLangString;
      str3 = localtbu.jdField_b_of_type_JavaLangString;
      localObject = localtbu.c;
      str1 = localtbu.d;
      str4 = localtbu.jdField_e_of_type_JavaLangString;
      k = localtbu.jdField_a_of_type_Int;
      m = localtbu.jdField_b_of_type_Int;
      if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.isEmpty(str1))) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0)
      {
        ved.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from sp.");
        str2 = localtbr.a();
        str3 = localtbr.b();
        localObject = localtbr.c();
        str1 = localtbr.d();
        str4 = localtbr.e();
        k = localtbr.a();
        m = localtbr.b();
        long l = localtbr.a();
        if (((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str1))) || ((float)(System.currentTimeMillis() - l) >= 1800000.0F)) {
          break label305;
        }
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label318;
        }
        ved.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from net.");
        localtbr.a();
        return;
        ved.b("Q.qqstory.publish.edit.EditVideoFilter", "country,city,district all empty.");
        i = 0;
        break;
        label305:
        ved.b("Q.qqstory.publish.edit.EditVideoFilter", "country,city,district all empty or overTime.");
      }
      label318:
      this.jdField_a_of_type_Vpt = new vpt(0, h, 8, (String)localObject, str1, str2, (String)localObject, str3, str4, "", k, m, 1);
      return;
      i = 0;
    }
  }
  
  public void g()
  {
    ved.a("Q.qqstory.publish.edit.EditVideoFilter", "updateFilterMode : %s", this.jdField_a_of_type_Vhm.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new vqb("", -1, 0, 0));
    boolean bool;
    if (((this.jdField_a_of_type_Vhm.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_Vhm.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)))
    {
      if (((this.jdField_a_of_type_Vhm.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
      {
        if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
        {
          bool = ((Boolean)((tcs)tcz.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
          if ((!(this.jdField_a_of_type_Vhm.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || (bool)) {
            break label444;
          }
          ved.d("Q.qqstory.publish.edit.EditVideoFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        label201:
        if ((!(this.jdField_a_of_type_Vhm.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || (avxr.a)) {
          break label509;
        }
        ved.d("Q.qqstory.publish.edit.EditVideoFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
    }
    else
    {
      label247:
      localArrayList.add(new vpy(0, g, 7, this.jdField_a_of_type_Vhm.a));
      if (this.jdField_a_of_type_Vpt != null) {
        localArrayList.add(this.jdField_a_of_type_Vpt);
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
    for (int i = 0;; i = ((vpr)localArrayList.get(0)).jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      return;
      bool = ((Boolean)((tcs)tcz.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.jdField_a_of_type_Vhm.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) && (!bool))
      {
        ved.d("Q.qqstory.publish.edit.EditVideoFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break;
      }
      localArrayList.add(new vqb(jdField_a_of_type_JavaLangString, 1, 2130845620, 2));
      break;
      if ((this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Int == 10) && (!this.jdField_a_of_type_Vhm.a.i()))
      {
        ved.d("Q.qqstory.publish.edit.EditVideoFilter", "it's tribe slow black model, disable slow!");
        break label201;
      }
      localArrayList.add(new vqb(jdField_b_of_type_JavaLangString, 2, 2130845621, 3));
      break label201;
      label509:
      if ((this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Int == 10) && (!this.jdField_a_of_type_Vhm.a.h()))
      {
        ved.d("Q.qqstory.publish.edit.EditVideoFilter", "it's tribe revert black model, disable revert!");
        break label247;
      }
      vqb localvqb = new vqb(c, 3, 2130845619, 1);
      if (this.jdField_a_of_type_Vhm.a.g()) {}
      for (String str = ajya.a(2131703935);; str = null)
      {
        localvqb.jdField_b_of_type_JavaLangString = str;
        localArrayList.add(localvqb);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter
 * JD-Core Version:    0.7.0.1
 */