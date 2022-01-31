import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

public class bliu
{
  private final int a = 10;
  
  private bliu()
  {
    UserAction.initUserAction(BaseApplicationImpl.getContext());
  }
  
  public static bliu a()
  {
    return bliw.a();
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramString, paramHashMap, false);
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      b(paramString, bliy.a().a(), paramBoolean);
      return;
    }
    b(paramString, blix.a(bliy.a().a(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((bliy.a().a()) || (paramBoolean)) {
      UserAction.onUserAction(paramString, true, -1L, -1L, paramHashMap, true, false);
    }
  }
  
  public void A()
  {
    a("click#shoot_view#banner_icon", bliy.a().e());
  }
  
  public void B()
  {
    a("expose#shoot_view#banner_icon", bliy.a().e());
  }
  
  public void C()
  {
    a("click#shoot_view#play_switch", null);
  }
  
  public void D()
  {
    a("click#shoot_view#next_btn", bliy.a().c());
  }
  
  public void E()
  {
    a("click#shoot_view#face_outbtn", null);
  }
  
  public void F()
  {
    a("click#shoot_view#done_btn", bliy.a().d());
  }
  
  public void G()
  {
    a("click#shoot_view#rephoto_btn", bliy.a().d());
  }
  
  public void H()
  {
    a("click#transmit_view#cancel_btn", bliy.a().l());
  }
  
  public void I()
  {
    if (bliy.a().c())
    {
      a("performance#camera_app#launch", bliy.a().m());
      bliy.a().e();
    }
  }
  
  public void J()
  {
    a("expose#camera_app#view", null);
  }
  
  public void K()
  {
    a("performance#camera_app#shader", bliy.a().n());
  }
  
  public void L()
  {
    a("expose#basics_view#pic_view", null);
  }
  
  public void M()
  {
    a("expose#basics_view#photo_view", null);
  }
  
  public void N()
  {
    a("click#emoticon_view#photo_btn", bliy.a().p());
  }
  
  public void O()
  {
    a("click#emoticon_view#emoticon_item", bliy.a().q());
  }
  
  public void P()
  {
    a("enter#emoticon_edit#view", bliy.a().o());
  }
  
  public void Q()
  {
    a("click#emoticon_edit#save_btn", bliy.a().r());
  }
  
  public void R()
  {
    a("click#emoticon_edit#send_btn", bliy.a().r());
  }
  
  public void S()
  {
    a("click#emoticon_edit#save_btn", bliy.a().s());
  }
  
  public void a()
  {
    a("expose#shoot_edit#view", null);
  }
  
  public void a(int paramInt)
  {
    a("click#shoot_edit#pick_done", bliy.a().b(paramInt));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a("performance#camera_app#server", bliy.a().a(paramInt1, paramString1, paramString2, paramInt2));
  }
  
  public void a(long paramLong)
  {
    a("enter#shoot_view#view", bliy.a().a(paramLong));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a("performance#camera_app#cost_time", bliy.a().a(paramLong1, paramLong2));
  }
  
  public void a(Long paramLong)
  {
    a("click#transmit_view#receiver", bliy.a().a(paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bliy.a().e(paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bliy.a().a(paramString, paramInt));
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    a("performance#camera_app#material_zip_download", bliy.a().a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
  }
  
  public void a(String paramString, long paramLong)
  {
    a("performance#camera_app#material2screen", bliy.a().a(paramString, paramLong));
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    a("performance#camera_app#video", bliy.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (blix.a())
    {
      a("performance#camera_app#res_ready", bliy.a().a(paramBoolean));
      blix.a();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    a("performance#camera_app#res_download", bliy.a().a(paramBoolean, paramInt, paramString1, paramString2, paramLong1, paramLong2), true);
  }
  
  public void b()
  {
    a("enter#shoot_edit#view", bliy.a().f());
  }
  
  public void b(int paramInt)
  {
    a("click#shoot_edit#edit_done", bliy.a().a(paramInt));
  }
  
  public void b(long paramLong)
  {
    a("click#shoot_view#photo_btn", bliy.a().b(paramLong));
  }
  
  public void b(String paramString)
  {
    a("click#shoot_edit#filter_item", bliy.a().f(paramString));
  }
  
  public void c()
  {
    a("click#shoot_edit#post_btn", bliy.a().g());
  }
  
  public void c(String paramString)
  {
    a("click#shoot_view#face_item", bliy.a().a(paramString));
  }
  
  public void d()
  {
    a("click#shoot_edit#rephoto_btn", null);
  }
  
  public void d(String paramString)
  {
    a("click#shoot_view#filter_ai", bliy.a().b(paramString));
  }
  
  public void e()
  {
    a("click#shoot_edit#video_edit", bliy.a().b());
  }
  
  public void e(String paramString)
  {
    a("click#shoot_view#filter_item", bliy.a().c(paramString));
  }
  
  public void f()
  {
    a("click#shoot_edit#text_edit", bliy.a().b());
  }
  
  public void f(String paramString)
  {
    a("expose#shoot_view#face_item", bliy.a().d(paramString));
  }
  
  public void g()
  {
    a("click#shoot_edit#preview_btn", bliy.a().b());
  }
  
  public void g(String paramString)
  {
    a("click#emoticon_edit#text_ai", bliy.a().i(paramString));
  }
  
  public void h()
  {
    a("click#shoot_edit#pic_switch", bliy.a().b());
  }
  
  public void h(String paramString)
  {
    a("expose#emoticon_edit#emoticon_item", bliy.a().g(paramString));
  }
  
  public void i()
  {
    a("click#shoot_edit#edit_done", bliy.a().h());
  }
  
  public void i(String paramString)
  {
    a("click#emoticon_view#filter_item", bliy.a().h(paramString));
  }
  
  public void j()
  {
    a("click#shoot_edit#text_btn", bliy.a().i());
  }
  
  public void k()
  {
    a("click#shoot_edit#music_btn", bliy.a().j());
  }
  
  public void l()
  {
    a("click#shoot_edit#cut_btn", null);
  }
  
  public void m()
  {
    a("click#shoot_edit#apply_btn", bliy.a().j());
  }
  
  public void n()
  {
    a("click#shoot_edit#music_item", bliy.a().k());
  }
  
  public void o()
  {
    a("expose#shoot_view#view", null);
  }
  
  public void p()
  {
    a("click#shoot_view#cancel_btn", null);
  }
  
  public void q()
  {
    a("click#shoot_view#local_btn", null);
  }
  
  public void r()
  {
    a("click#shoot_view#flash_btn", null);
  }
  
  public void s()
  {
    a("click#shoot_view#switch_btn", null);
  }
  
  public void t()
  {
    a("click#shoot_view#face_btn", null);
  }
  
  public void u()
  {
    a("click#shoot_view#photo_switch", null);
  }
  
  public void v()
  {
    a("click#shoot_view#emoticon_switch", null);
  }
  
  public void w()
  {
    a("click#shoot_view#module_btn", null);
  }
  
  public void x()
  {
    a("click#shoot_view#make_btn", bliy.a().b());
  }
  
  public void y()
  {
    a("click#shoot_view#photo_make", bliy.a().b());
  }
  
  public void z()
  {
    a("click#shoot_view#now_make", bliy.a().b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bliu
 * JD-Core Version:    0.7.0.1
 */