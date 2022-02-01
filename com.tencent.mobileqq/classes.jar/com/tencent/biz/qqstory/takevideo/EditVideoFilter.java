package com.tencent.biz.qqstory.takevideo;

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
import anvx;
import bbld;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.ArrayList;
import java.util.List;
import wik;
import win;
import wit;
import wjl;
import wjs;
import ykq;
import ykv;
import ykw;
import yld;
import ymx;
import ymy;
import ymz;
import ynu;
import ynw;
import yvr;
import yvs;
import yvt;
import yvy;
import ywb;
import yya;

public class EditVideoFilter
  extends ynu
  implements yld
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f = anvx.a(2131703273);
  public static final String g = anvx.a(2131703210);
  public static final String h = anvx.a(2131703204);
  public int a;
  public long a;
  public SparseArray<yvr> a;
  private SparseIntArray a;
  protected View a;
  public EditVideoFilter.FilterPagerAdapter a;
  public UnHandleTouchEventViewPager a;
  protected yvt a;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131703267);
    jdField_b_of_type_JavaLangString = anvx.a(2131703258);
    c = anvx.a(2131703382);
    d = anvx.a(2131703339);
    jdField_e_of_type_JavaLangString = anvx.a(2131703281);
  }
  
  public EditVideoFilter(@NonNull ynw paramynw)
  {
    super(paramynw);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  }
  
  public static int a(@NonNull yvr paramyvr)
  {
    ykq.b("Q.qqstory.publish.edit.EditVideoFilter", "getSpecialSaveMode : mVideoPlayMode = " + paramyvr.jdField_a_of_type_Int);
    switch (paramyvr.jdField_a_of_type_Int)
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
  
  public static void a(yvs paramyvs)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillAfter(true);
    paramyvs.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void S_()
  {
    super.S_();
  }
  
  public int a()
  {
    return b(this.jdField_a_of_type_Ynw.a());
  }
  
  public int a(int paramInt)
  {
    yvr localyvr = (yvr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localyvr == null) {
      return 0;
    }
    return localyvr.jdField_a_of_type_Int;
  }
  
  @Nullable
  public View a()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    Object localObject = (yvr)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if ((localObject != null) && (((yvs)localObject).a())) {
      return ((yvs)localObject).jdField_a_of_type_AndroidViewView;
    }
    return null;
  }
  
  public yvt a()
  {
    return this.jdField_a_of_type_Yvt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)a(2131365214));
    this.jdField_a_of_type_AndroidViewView = a(2131366810);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new ymx(this));
    if ((this.jdField_a_of_type_Ynw.a.mBusinessId == 10) || (this.jdField_a_of_type_Ynw.a.mBusinessId == 12))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getLayoutParams();
      localLayoutParams.height = ((int)(DeviceInfoUtil.getWidth() * this.jdField_a_of_type_Ynw.a.mEditSource.getHeight() / this.jdField_a_of_type_Ynw.a.mEditSource.getWidth()));
      this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter = new EditVideoFilter.FilterPagerAdapter(a());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(new ymy(this));
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new ymz(this, null));
    ykq.b("Q.qqstory.publish.edit.EditVideoFilter", "init filter view pager : " + this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager);
    g();
    h();
    a(yld.class, this);
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
  
  public void a(int paramInt, @NonNull yya paramyya)
  {
    super.a(paramInt, paramyya);
    Object localObject2 = a();
    if (localObject2 != null) {
      paramyya.a.videoAddress = AddressItem.generatePoiJson(QQStoryContext.a().a(), ((yvt)localObject2).jdField_e_of_type_JavaLangString, ((yvt)localObject2).f, ((yvt)localObject2).g, ((yvt)localObject2).h, ((yvt)localObject2).i, ((yvt)localObject2).c, ((yvt)localObject2).d, ((yvt)localObject2).jdField_e_of_type_Int);
    }
    Object localObject1 = (yvr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof yvt))) {
      paramyya.a.gpsFilterDescription = ((yvt)localObject2).a();
    }
    if (this.jdField_a_of_type_Ynw.a.isEditLocal()) {
      paramyya.a.localCreateCity = this.jdField_a_of_type_Ynw.a.getStringExtra("extra_local_address_city_name");
    }
    paramyya.a(a());
    paramyya.a.saveMode = b(paramInt);
    paramyya.a.putExtra("useFlowDecode", Boolean.valueOf(bbld.b));
    paramyya = "";
    int i = -1;
    paramInt = 0;
    if (localObject1 != null)
    {
      paramyya = ((yvr)localObject1).jdField_a_of_type_JavaLangString;
      i = ((yvr)localObject1).jdField_b_of_type_Int;
      paramInt = ((yvr)localObject1).jdField_a_of_type_Int;
    }
    long l;
    if (i != -1)
    {
      localObject2 = this.jdField_a_of_type_Ynw;
      int j = this.jdField_a_of_type_Ynw.b();
      if (this.jdField_a_of_type_Ynw.a())
      {
        localObject1 = "2";
        ((ynw)localObject2).b("pub_filter_menu", j, 0, new String[] { String.valueOf(i), paramyya, localObject1 });
      }
    }
    else
    {
      if (i != -1) {
        ykw.a("0X80076E9", String.valueOf(ykw.jdField_b_of_type_Int), String.valueOf(paramInt), paramyya, String.valueOf(i));
      }
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      paramInt = this.jdField_a_of_type_Int;
      ykq.a("Q.qqstory.publish.edit.EditVideoFilter", "intervalTime : %s , videoMode : %s. ", Long.valueOf(l), Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_Ynw.a()) {
        break label398;
      }
    }
    label398:
    for (paramyya = "2";; paramyya = "1")
    {
      ykv.b("video_edit", "pub_filter_interval_time", 0, 0, new String[] { String.valueOf(l), String.valueOf(paramInt), paramyya });
      return;
      localObject1 = "1";
      break;
    }
  }
  
  public boolean a(int paramInt)
  {
    yvr localyvr = (yvr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    return (localyvr != null) && (localyvr.a());
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
      if (!((yvs)localObject2).a()) {
        break label226;
      }
      localObject1 = ((yvs)localObject2).jdField_a_of_type_AndroidViewView;
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
      if ((paramMessage.obj instanceof win))
      {
        paramMessage = (win)paramMessage.obj;
        this.jdField_a_of_type_Yvt = new yvt(0, h, 8, paramMessage.c, paramMessage.d, paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.jdField_b_of_type_JavaLangString, paramMessage.jdField_e_of_type_JavaLangString, "", paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Int, 1);
        h();
        ykq.a("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE POIFilterData is available : country : %s, city : %s, district : %s .", paramMessage.jdField_a_of_type_JavaLangString, paramMessage.c, paramMessage.d);
      }
      for (;;)
      {
        return true;
        ykq.e("Q.qqstory.publish.edit.EditVideoFilter", "handleEditVideoMessage MESSAGE_LOCATION_LOCAL_ADDRESS_UPDATE Message Error! Message obj type mismatch");
      }
      int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
      int j = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Ynw.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a() * 50);
      ykq.b("Q.qqstory.publish.edit.EditVideoFilter", "change video block from %d to %d, change page from %d to %d", Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2), Integer.valueOf(i), Integer.valueOf(j));
      if (i != j) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(j, false);
      }
    }
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    yvr localyvr = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if (localyvr != null) {
      return localyvr.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    yvr localyvr = (yvr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localyvr == null) {
      return 0;
    }
    return a(localyvr);
  }
  
  protected void g()
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
    wik localwik = (wik)((wit)wjs.a(20)).a(1);
    win localwin = (win)localwik.a();
    int i;
    if (localwin != null)
    {
      ykq.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from cache.");
      str2 = localwin.jdField_a_of_type_JavaLangString;
      str3 = localwin.jdField_b_of_type_JavaLangString;
      localObject = localwin.c;
      str1 = localwin.d;
      str4 = localwin.jdField_e_of_type_JavaLangString;
      k = localwin.jdField_a_of_type_Int;
      m = localwin.jdField_b_of_type_Int;
      if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.isEmpty(str1))) {
        i = 1;
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0)
      {
        ykq.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from sp.");
        str2 = localwik.a();
        str3 = localwik.b();
        localObject = localwik.c();
        str1 = localwik.d();
        str4 = localwik.e();
        k = localwik.a();
        m = localwik.b();
        long l = localwik.a();
        if (((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str1))) || ((float)(System.currentTimeMillis() - l) >= 1800000.0F)) {
          break label305;
        }
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label318;
        }
        ykq.b("Q.qqstory.publish.edit.EditVideoFilter", "get address from net.");
        localwik.a();
        return;
        ykq.b("Q.qqstory.publish.edit.EditVideoFilter", "country,city,district all empty.");
        i = 0;
        break;
        label305:
        ykq.b("Q.qqstory.publish.edit.EditVideoFilter", "country,city,district all empty or overTime.");
      }
      label318:
      this.jdField_a_of_type_Yvt = new yvt(0, h, 8, (String)localObject, str1, str2, (String)localObject, str3, str4, "", k, m, 1);
      return;
      i = 0;
    }
  }
  
  public void h()
  {
    ykq.a("Q.qqstory.publish.edit.EditVideoFilter", "updateFilterMode : %s", this.jdField_a_of_type_Ynw.a.mEditSource);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ywb("", -1, 0, 0));
    boolean bool;
    if (((this.jdField_a_of_type_Ynw.a.mEditSource instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_Ynw.a.mEditSource instanceof EditTakeVideoSource)))
    {
      if (((this.jdField_a_of_type_Ynw.a.mEditSource instanceof EditTakeVideoSource)) && ("OPPO R7".equalsIgnoreCase(Build.MODEL)))
      {
        if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
        {
          bool = ((Boolean)((wjl)wjs.a(10)).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
          if ((!(this.jdField_a_of_type_Ynw.a.mEditSource instanceof EditTakeVideoSource)) || (bool)) {
            break label444;
          }
          ykq.d("Q.qqstory.publish.edit.EditVideoFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        }
        label201:
        if ((!(this.jdField_a_of_type_Ynw.a.mEditSource instanceof EditTakeVideoSource)) || (bbld.a)) {
          break label509;
        }
        ykq.d("Q.qqstory.publish.edit.EditVideoFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
    }
    else
    {
      label247:
      localArrayList.add(new yvy(0, g, 7, this.jdField_a_of_type_Ynw.a));
      if (this.jdField_a_of_type_Yvt != null) {
        localArrayList.add(this.jdField_a_of_type_Yvt);
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
    for (int i = 0;; i = ((yvr)localArrayList.get(0)).jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      return;
      bool = ((Boolean)((wjl)wjs.a(10)).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
      if (((this.jdField_a_of_type_Ynw.a.mEditSource instanceof EditTakeVideoSource)) && (!bool))
      {
        ykq.d("Q.qqstory.publish.edit.EditVideoFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
        break;
      }
      localArrayList.add(new ywb(jdField_a_of_type_JavaLangString, 1, 2130846532, 2));
      break;
      if ((this.jdField_a_of_type_Ynw.a.mBusinessId == 10) && (!this.jdField_a_of_type_Ynw.a.getEnableSlow()))
      {
        ykq.d("Q.qqstory.publish.edit.EditVideoFilter", "it's tribe slow black model, disable slow!");
        break label201;
      }
      localArrayList.add(new ywb(jdField_b_of_type_JavaLangString, 2, 2130846533, 3));
      break label201;
      label509:
      if ((this.jdField_a_of_type_Ynw.a.mBusinessId == 10) && (!this.jdField_a_of_type_Ynw.a.getEnableRevert()))
      {
        ykq.d("Q.qqstory.publish.edit.EditVideoFilter", "it's tribe revert black model, disable revert!");
        break label247;
      }
      ywb localywb = new ywb(c, 3, 2130846531, 1);
      if (this.jdField_a_of_type_Ynw.a.getEnableHWEncode()) {}
      for (String str = anvx.a(2131703405);; str = null)
      {
        localywb.jdField_b_of_type_JavaLangString = str;
        localArrayList.add(localywb);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter
 * JD-Core Version:    0.7.0.1
 */