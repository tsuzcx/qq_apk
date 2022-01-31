import android.os.Build;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewStub;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter.1;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class bmju
  extends EditVideoFilter
  implements bmzs
{
  private static String l = "EditVideoSpeedFilter";
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public PickerContainer a;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public bmju(@NonNull bmix parambmix, boolean paramBoolean)
  {
    super(parambmix);
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = b();
    }
    wsv.b("Q.qqstory.publish.editEditVideoSpeedFilter", "EditVideoSpeedFilter : enable: " + this.jdField_c_of_type_Boolean);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Int == 2) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer == null);
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.setVisibility(0);
      return;
    } while ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 4) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.getVisibility() == 8));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.setVisibility(4);
  }
  
  private boolean b()
  {
    boolean bool1;
    urk localurk;
    if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
    {
      bool1 = true;
      if (!bool1) {
        wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's Meizu MX4 Pro, in backlist");
      }
      localurk = (urk)urr.a(10);
      if (localurk != null) {
        break label62;
      }
      wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "storyConfigManager == null !!!");
    }
    label62:
    boolean bool2;
    do
    {
      return bool1;
      bool1 = false;
      break;
      bool2 = bool1;
      if (bool1)
      {
        bool1 = ((Boolean)localurk.b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue();
        bool2 = bool1;
        if (!bool1)
        {
          wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
          bool2 = bool1;
        }
      }
      bool1 = bool2;
      if (bool2)
      {
        bool2 = ((Boolean)localurk.b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
        bool1 = bool2;
        if (!bool2)
        {
          wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
          bool1 = bool2;
        }
      }
      if (!bool1) {
        return bool1;
      }
      bool2 = ((Boolean)localurk.b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue();
      bool1 = bool2;
    } while (bool2);
    wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
    return bool2;
    return bool1;
  }
  
  private int c(int paramInt)
  {
    int i = 2;
    wsv.b("Q.qqstory.publish.editEditVideoSpeedFilter", "transSpecialPlayMode : nSpeedIndex = " + paramInt);
    if (xir.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, 13);
    }
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    case 4: 
    case 3: 
    case 2: 
    case 1: 
    case 0: 
      do
      {
        return paramInt;
        if (xir.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 5);
        }
        return 9;
        if (xir.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 4);
        }
        return 3;
        if (xir.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 1);
        }
        return 0;
        if (xir.a().b() == 22) {
          LpReportInfo_pf00064.allReport(680, 10, 2);
        }
        return 8;
        paramInt = i;
      } while (xir.a().b() != 22);
      LpReportInfo_pf00064.allReport(680, 10, 3);
      return 2;
    }
    if (xir.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 10, 6);
    }
    return 1;
  }
  
  private int d(int paramInt)
  {
    wsv.b("Q.qqstory.publish.editEditVideoSpeedFilter", "transSpecialPlayMode : nPlayMode = " + paramInt);
    switch (paramInt)
    {
    case 0: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 2;
    case 9: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 0;
    case 8: 
      return 1;
    }
    return 5;
  }
  
  private void e(int paramInt, String paramString)
  {
    int k = 0;
    wsv.b("Q.qqstory.publish.editEditVideoSpeedFilter", "onPlayModeChanged:" + paramInt + "  " + paramString);
    List localList = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < localList.size())
      {
        bmtz localbmtz = (bmtz)localList.get(i);
        if ((!TextUtils.isEmpty(localbmtz.jdField_a_of_type_JavaLangString)) && (localbmtz.jdField_a_of_type_Int == paramInt))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(i, false);
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          QQToast.a(a(), alpo.a(2131704200) + paramString, 1000).a();
        }
        return;
      }
      i += 1;
    }
  }
  
  private void k()
  {
    ThreadManager.getUIHandler().postDelayed(new EditVideoSpeedFilter.1(this), 500L);
  }
  
  public void a()
  {
    super.a();
    k();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      bmtz localbmtz = a();
      if (localbmtz == null) {
        return;
      }
      int i = localbmtz.jdField_a_of_type_Int;
      if (i != 0)
      {
        localJSONObject.put("playMode", i);
        localJSONObject.put("filterName", localbmtz.jdField_a_of_type_JavaLangString);
        localJSONObject.put("filterId", localbmtz.jdField_b_of_type_Int);
        localJSONObject.put("hintWording", localbmtz.jdField_b_of_type_JavaLangString);
      }
      paramJSONObject.put(l, localJSONObject);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public boolean a(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    if (this.jdField_c_of_type_Boolean) {
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      bool1 = super.a(paramMessage);
      do
      {
        return bool1;
        this.jdField_b_of_type_Int = paramMessage.arg1;
        int i = paramMessage.arg2;
      } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer == null);
      paramMessage = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer;
      if (this.jdField_b_of_type_Int != 1)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Int != 3) {}
      }
      else
      {
        bool1 = true;
      }
      paramMessage.a(bool1, this.jdField_d_of_type_Long);
      return true;
      b(false);
      continue;
      b(true);
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    super.a_(paramInt, paramObject);
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    switch (paramInt)
    {
    default: 
      b(true);
      return;
    case 28: 
      paramInt = d(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a(paramInt, false);
      }
      b(true);
      return;
    }
    b(false);
  }
  
  public void b(int paramInt, String paramString)
  {
    wsv.b("Q.qqstory.publish.editEditVideoSpeedFilter", "onPickSpeedStart:" + paramInt + "  " + paramString);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c(int paramInt, String paramString)
  {
    wsv.b("Q.qqstory.publish.editEditVideoSpeedFilter", "onPickSpeed:" + paramInt + "  " + paramString + " moving:" + this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    e(c(paramInt), paramString);
    paramString = this.jdField_a_of_type_Bmix.a(bmfg.class);
    if ((paramString instanceof bmfg)) {
      ((bmfg)paramString).c();
    }
    this.jdField_a_of_type_Bmix.a(Message.obtain(null, 9, 28, paramInt));
  }
  
  public void d()
  {
    wsv.a("Q.qqstory.publish.editEditVideoSpeedFilter", "updateFilterMode : %s", this.jdField_a_of_type_Bmix.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (((this.jdField_a_of_type_Bmix.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_Bmix.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Bmix.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)))
    {
      localObject = (urk)urr.a(10);
      localArrayList.add(new bmug(jdField_a_of_type_JavaLangString, -1, 0, 0));
      if (((Boolean)((urk)localObject).b("boolean_enable_fast_play_mode", Boolean.valueOf(true))).booleanValue()) {
        break label316;
      }
      wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's fast black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)))
      {
        if (((Boolean)((urk)localObject).b("boolean_enable_slow_play_mode", Boolean.valueOf(true))).booleanValue()) {
          break label361;
        }
        wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's slow black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
      label209:
      if (!(this.jdField_a_of_type_Bmix.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        if (((Boolean)((urk)localObject).b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue()) {
          break label489;
        }
        wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's revert black model ! manufacturer=%s, model=%s", new Object[] { Build.MANUFACTURER, Build.MODEL });
      }
    }
    label267:
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (localArrayList.isEmpty()) {}
    for (int i = 0;; i = ((bmtz)localArrayList.get(0)).jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i;
      return;
      label316:
      localArrayList.add(new bmug(jdField_b_of_type_JavaLangString, 1, 0, 2));
      localArrayList.add(new bmug(j, 9, 0, 8));
      break;
      label361:
      if ((this.jdField_a_of_type_Bmix.a.jdField_a_of_type_Int == 11) && (!this.jdField_a_of_type_Bmix.a.h()))
      {
        wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's tribe slow black model, disable slow!");
        break label209;
      }
      if ((this.jdField_a_of_type_Bmix.a.jdField_a_of_type_Int == 12) && (!this.jdField_a_of_type_Bmix.a.h()))
      {
        wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's readinjoy slow black model, disable slow!");
        break label209;
      }
      localArrayList.add(new bmug(jdField_c_of_type_JavaLangString, 2, 0, 3));
      localArrayList.add(new bmug(k, 10, 0, 9));
      this.jdField_a_of_type_Boolean = true;
      break label209;
      label489:
      if ((this.jdField_a_of_type_Bmix.a.jdField_a_of_type_Int == 11) && (!this.jdField_a_of_type_Bmix.a.g()))
      {
        wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's tribe revert black model, disable revert!");
        break label267;
      }
      if ((this.jdField_a_of_type_Bmix.a.jdField_a_of_type_Int == 12) && (!this.jdField_a_of_type_Bmix.a.g()))
      {
        wsv.d("Q.qqstory.publish.editEditVideoSpeedFilter", "it's tribe readinjoy black model, disable revert!");
        break label267;
      }
      bmug localbmug = new bmug(jdField_d_of_type_JavaLangString, 3, 0, 1);
      if (this.jdField_a_of_type_Bmix.a.i()) {}
      for (localObject = alpo.a(2131704262);; localObject = null)
      {
        localbmug.jdField_b_of_type_JavaLangString = ((String)localObject);
        localArrayList.add(localbmug);
        break;
      }
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    wsv.b("Q.qqstory.publish.editEditVideoSpeedFilter", "onSpeedPickEnd:" + paramInt + "  " + paramString);
    e(c(paramInt), paramString);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_AndroidViewViewStub = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer = null;
    }
  }
  
  public void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmju
 * JD-Core Version:    0.7.0.1
 */