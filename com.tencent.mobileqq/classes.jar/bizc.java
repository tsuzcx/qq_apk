import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;

public class bizc
{
  private final int a = 10;
  
  public static bizc a()
  {
    return bize.a();
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramString, paramHashMap, false);
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      b(paramString, bizg.a().a(), paramBoolean);
      return;
    }
    b(paramString, bizf.a(bizg.a().a(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((bizg.a().a()) || (paramBoolean)) {
      UserAction.onUserAction(paramString, true, -1L, -1L, paramHashMap, true, false);
    }
  }
  
  public void A()
  {
    a("click#shoot_view#rephoto_btn", bizg.a().d());
  }
  
  public void B()
  {
    a("click#transmit_view#cancel_btn", bizg.a().h());
  }
  
  public void C()
  {
    if (bizg.a().c())
    {
      a("performance#camera_app#launch", bizg.a().i());
      bizg.a().e();
    }
  }
  
  public void D()
  {
    a("expose#camera_app#view", null);
  }
  
  public void E()
  {
    a("performance#camera_app#shader", bizg.a().j());
  }
  
  public void F()
  {
    a("click#emoticon_view#photo_btn", bizg.a().l());
  }
  
  public void G()
  {
    a("click#emoticon_view#emoticon_item", bizg.a().m());
  }
  
  public void H()
  {
    a("enter#emoticon_edit#view", bizg.a().k());
  }
  
  public void I()
  {
    a("click#emoticon_edit#save_btn", bizg.a().n());
  }
  
  public void J()
  {
    a("click#emoticon_edit#save_btn", bizg.a().o());
  }
  
  public void a()
  {
    a("expose#shoot_edit#view", null);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a("performance#camera_app#server", bizg.a().a(paramInt1, paramString1, paramString2, paramInt2));
  }
  
  public void a(long paramLong)
  {
    a("enter#shoot_view#view", bizg.a().a(paramLong));
  }
  
  public void a(Long paramLong)
  {
    a("click#transmit_view#receiver", bizg.a().a(paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bizg.a().e(paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bizg.a().a(paramString, paramInt));
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    a("performance#camera_app#material_zip_download", bizg.a().a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
  }
  
  public void a(String paramString, long paramLong)
  {
    a("performance#camera_app#material2screen", bizg.a().a(paramString, paramLong));
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    a("performance#camera_app#video", bizg.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bizf.a())
    {
      a("performance#camera_app#res_ready", bizg.a().a(paramBoolean));
      bizf.a();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong)
  {
    a("performance#camera_app#res_download", bizg.a().a(paramBoolean, paramInt1, paramInt2, paramLong), true);
  }
  
  public void b()
  {
    a("enter#shoot_edit#view", bizg.a().f());
  }
  
  public void b(long paramLong)
  {
    a("click#shoot_view#photo_btn", bizg.a().b(paramLong));
  }
  
  public void b(String paramString)
  {
    a("click#shoot_view#face_item", bizg.a().a(paramString));
  }
  
  public void c()
  {
    a("click#shoot_edit#post_btn", bizg.a().g());
  }
  
  public void c(String paramString)
  {
    a("click#shoot_view#filter_ai", bizg.a().b(paramString));
  }
  
  public void d()
  {
    a("click#shoot_edit#rephoto_btn", null);
  }
  
  public void d(String paramString)
  {
    a("click#shoot_view#filter_item", bizg.a().c(paramString));
  }
  
  public void e()
  {
    a("click#shoot_edit#video_edit", bizg.a().b());
  }
  
  public void e(String paramString)
  {
    a("expose#shoot_view#face_item", bizg.a().d(paramString));
  }
  
  public void f()
  {
    a("click#shoot_edit#text_edit", bizg.a().b());
  }
  
  public void f(String paramString)
  {
    a("click#emoticon_edit#text_ai", bizg.a().h(paramString));
  }
  
  public void g()
  {
    a("click#shoot_edit#preview_btn", bizg.a().b());
  }
  
  public void g(String paramString)
  {
    a("expose#emoticon_edit#emoticon_item", bizg.a().f(paramString));
  }
  
  public void h()
  {
    a("click#shoot_edit#pic_switch", bizg.a().b());
  }
  
  public void h(String paramString)
  {
    a("click#emoticon_view#filter_item", bizg.a().g(paramString));
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
    a("click#shoot_view#make_btn", bizg.a().b());
  }
  
  public void s()
  {
    a("click#shoot_view#photo_make", bizg.a().b());
  }
  
  public void t()
  {
    a("click#shoot_view#now_make", bizg.a().b());
  }
  
  public void u()
  {
    a("click#shoot_view#banner_icon", bizg.a().e());
  }
  
  public void v()
  {
    a("expose#shoot_view#banner_icon", bizg.a().e());
  }
  
  public void w()
  {
    a("click#shoot_view#play_switch", null);
  }
  
  public void x()
  {
    a("click#shoot_view#next_btn", bizg.a().c());
  }
  
  public void y()
  {
    a("click#shoot_view#face_outbtn", null);
  }
  
  public void z()
  {
    a("click#shoot_view#done_btn", bizg.a().d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizc
 * JD-Core Version:    0.7.0.1
 */