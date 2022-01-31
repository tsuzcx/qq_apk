import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bhci
{
  private final int a = 10;
  
  public static bhci a()
  {
    return bhck.a();
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramString, paramHashMap, false);
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      b(paramString, bhcm.a().a(), paramBoolean);
      return;
    }
    b(paramString, bhcl.a(bhcm.a().a(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((bhcm.a().a()) || (paramBoolean)) {
      UserAction.onUserAction(paramString, true, -1L, -1L, paramHashMap, true, false);
    }
  }
  
  public void A()
  {
    if (bhcm.a().c())
    {
      HashMap localHashMap = bhcm.a().h();
      a("performance#camera_app#launch", localHashMap);
      bhcm.a().e();
      if (QLog.isDevelopLevel()) {
        QLog.d("CameraLaunchPerf", 4, "realReport2beacon=" + localHashMap);
      }
    }
  }
  
  public void B()
  {
    a("expose#camera_app#view", null);
  }
  
  public void C()
  {
    a("performance#camera_app#shader", bhcm.a().i());
  }
  
  public void D()
  {
    a("click#emoticon_view#photo_btn", bhcm.a().k());
  }
  
  public void E()
  {
    a("click#emoticon_view#emoticon_item", bhcm.a().l());
  }
  
  public void F()
  {
    a("enter#emoticon_edit#view", bhcm.a().j());
  }
  
  public void G()
  {
    a("click#emoticon_edit#save_btn", bhcm.a().m());
  }
  
  public void H()
  {
    a("click#emoticon_edit#save_btn", bhcm.a().n());
  }
  
  public void a()
  {
    a("expose#shoot_edit#view", null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    a("performance#camera_app#server", bhcm.a().a(paramInt, paramString1, paramString2));
  }
  
  public void a(long paramLong)
  {
    a("enter#shoot_view#view", bhcm.a().a(paramLong));
  }
  
  public void a(Long paramLong)
  {
    a("click#transmit_view#receiver", bhcm.a().a(paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bhcm.a().e(paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bhcm.a().a(paramString, paramInt));
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    a("performance#camera_app#material_zip_download", bhcm.a().a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    a("performance#camera_app#video", bhcm.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bhcl.a())
    {
      a("performance#camera_app#res_ready", bhcm.a().a(paramBoolean));
      bhcl.a();
    }
  }
  
  public void b()
  {
    a("enter#shoot_edit#view", bhcm.a().e());
  }
  
  public void b(long paramLong)
  {
    a("click#shoot_view#photo_btn", bhcm.a().b(paramLong));
  }
  
  public void b(String paramString)
  {
    a("click#shoot_view#face_item", bhcm.a().a(paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    a("performance#camera_app#res_download", bhcm.a().b(paramBoolean), true);
  }
  
  public void c()
  {
    a("click#shoot_edit#post_btn", bhcm.a().f());
  }
  
  public void c(String paramString)
  {
    a("click#shoot_view#filter_ai", bhcm.a().b(paramString));
  }
  
  public void c(boolean paramBoolean)
  {
    a("performance#camera_app#res_download", bhcm.a().c(paramBoolean), true);
  }
  
  public void d()
  {
    a("click#shoot_edit#rephoto_btn", null);
  }
  
  public void d(String paramString)
  {
    a("click#shoot_view#filter_item", bhcm.a().c(paramString));
  }
  
  public void e()
  {
    a("click#shoot_edit#video_edit", bhcm.a().b());
  }
  
  public void e(String paramString)
  {
    a("expose#shoot_view#face_item", bhcm.a().d(paramString));
  }
  
  public void f()
  {
    a("click#shoot_edit#text_edit", bhcm.a().b());
  }
  
  public void f(String paramString)
  {
    a("click#emoticon_edit#text_ai", bhcm.a().h(paramString));
  }
  
  public void g()
  {
    a("click#shoot_edit#preview_btn", bhcm.a().b());
  }
  
  public void g(String paramString)
  {
    a("expose#emoticon_edit#emoticon_item", bhcm.a().f(paramString));
  }
  
  public void h()
  {
    a("click#shoot_edit#pic_switch", bhcm.a().b());
  }
  
  public void h(String paramString)
  {
    a("click#emoticon_view#filter_item", bhcm.a().g(paramString));
  }
  
  public void i()
  {
    a("expose#shoot_view#view", null);
  }
  
  public void j()
  {
    a("click#shoot_view#cancel_btn", null);
  }
  
  public void k()
  {
    a("click#shoot_view#local_btn", null);
  }
  
  public void l()
  {
    a("click#shoot_view#flash_btn", null);
  }
  
  public void m()
  {
    a("click#shoot_view#switch_btn", null);
  }
  
  public void n()
  {
    a("click#shoot_view#face_btn", null);
  }
  
  public void o()
  {
    a("click#shoot_view#photo_switch", null);
  }
  
  public void p()
  {
    a("click#shoot_view#emoticon_switch", null);
  }
  
  public void q()
  {
    a("click#shoot_view#module_btn", null);
  }
  
  public void r()
  {
    a("click#shoot_view#make_btn", bhcm.a().b());
  }
  
  public void s()
  {
    a("click#shoot_view#photo_make", bhcm.a().b());
  }
  
  public void t()
  {
    a("click#shoot_view#now_make", bhcm.a().b());
  }
  
  public void u()
  {
    a("click#shoot_view#play_switch", null);
  }
  
  public void v()
  {
    a("click#shoot_view#next_btn", bhcm.a().c());
  }
  
  public void w()
  {
    a("click#shoot_view#face_outbtn", null);
  }
  
  public void x()
  {
    a("click#shoot_view#done_btn", bhcm.a().d());
  }
  
  public void y()
  {
    a("click#shoot_view#rephoto_btn", bhcm.a().d());
  }
  
  public void z()
  {
    a("click#transmit_view#cancel_btn", bhcm.a().g());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhci
 * JD-Core Version:    0.7.0.1
 */