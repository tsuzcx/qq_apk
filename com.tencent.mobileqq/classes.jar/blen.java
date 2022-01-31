import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

public class blen
{
  private final int a = 10;
  
  private blen()
  {
    UserAction.initUserAction(BaseApplicationImpl.getContext());
  }
  
  public static blen a()
  {
    return blep.a();
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramString, paramHashMap, false);
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      b(paramString, bler.a().a(), paramBoolean);
      return;
    }
    b(paramString, bleq.a(bler.a().a(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((bler.a().a()) || (paramBoolean)) {
      UserAction.onUserAction(paramString, true, -1L, -1L, paramHashMap, true, false);
    }
  }
  
  public void A()
  {
    a("click#shoot_view#banner_icon", bler.a().e());
  }
  
  public void B()
  {
    a("expose#shoot_view#banner_icon", bler.a().e());
  }
  
  public void C()
  {
    a("click#shoot_view#play_switch", null);
  }
  
  public void D()
  {
    a("click#shoot_view#next_btn", bler.a().c());
  }
  
  public void E()
  {
    a("click#shoot_view#face_outbtn", null);
  }
  
  public void F()
  {
    a("click#shoot_view#done_btn", bler.a().d());
  }
  
  public void G()
  {
    a("click#shoot_view#rephoto_btn", bler.a().d());
  }
  
  public void H()
  {
    a("click#transmit_view#cancel_btn", bler.a().k());
  }
  
  public void I()
  {
    if (bler.a().c())
    {
      a("performance#camera_app#launch", bler.a().l());
      bler.a().e();
    }
  }
  
  public void J()
  {
    a("expose#camera_app#view", null);
  }
  
  public void K()
  {
    a("performance#camera_app#shader", bler.a().m());
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
    a("click#emoticon_view#photo_btn", bler.a().o());
  }
  
  public void O()
  {
    a("click#emoticon_view#emoticon_item", bler.a().p());
  }
  
  public void P()
  {
    a("enter#emoticon_edit#view", bler.a().n());
  }
  
  public void Q()
  {
    a("click#emoticon_edit#save_btn", bler.a().q());
  }
  
  public void R()
  {
    a("click#emoticon_edit#send_btn", bler.a().q());
  }
  
  public void S()
  {
    a("click#emoticon_edit#save_btn", bler.a().r());
  }
  
  public void a()
  {
    a("expose#shoot_edit#view", null);
  }
  
  public void a(int paramInt)
  {
    a("click#shoot_edit#pick_done", bler.a().b(paramInt));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a("performance#camera_app#server", bler.a().a(paramInt1, paramString1, paramString2, paramInt2));
  }
  
  public void a(long paramLong)
  {
    a("enter#shoot_view#view", bler.a().a(paramLong));
  }
  
  public void a(Long paramLong)
  {
    a("click#transmit_view#receiver", bler.a().a(paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bler.a().e(paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bler.a().a(paramString, paramInt));
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    a("performance#camera_app#material_zip_download", bler.a().a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
  }
  
  public void a(String paramString, long paramLong)
  {
    a("performance#camera_app#material2screen", bler.a().a(paramString, paramLong));
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    a("performance#camera_app#video", bler.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bleq.a())
    {
      a("performance#camera_app#res_ready", bler.a().a(paramBoolean));
      bleq.a();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    a("performance#camera_app#res_download", bler.a().a(paramBoolean, paramInt, paramString1, paramString2, paramLong1, paramLong2), true);
  }
  
  public void b()
  {
    a("enter#shoot_edit#view", bler.a().f());
  }
  
  public void b(int paramInt)
  {
    a("click#shoot_edit#edit_done", bler.a().a(paramInt));
  }
  
  public void b(long paramLong)
  {
    a("click#shoot_view#photo_btn", bler.a().b(paramLong));
  }
  
  public void b(String paramString)
  {
    a("click#shoot_edit#filter_item", bler.a().f(paramString));
  }
  
  public void c()
  {
    a("click#shoot_edit#post_btn", bler.a().g());
  }
  
  public void c(String paramString)
  {
    a("click#shoot_view#face_item", bler.a().a(paramString));
  }
  
  public void d()
  {
    a("click#shoot_edit#rephoto_btn", null);
  }
  
  public void d(String paramString)
  {
    a("click#shoot_view#filter_ai", bler.a().b(paramString));
  }
  
  public void e()
  {
    a("click#shoot_edit#video_edit", bler.a().b());
  }
  
  public void e(String paramString)
  {
    a("click#shoot_view#filter_item", bler.a().c(paramString));
  }
  
  public void f()
  {
    a("click#shoot_edit#text_edit", bler.a().b());
  }
  
  public void f(String paramString)
  {
    a("expose#shoot_view#face_item", bler.a().d(paramString));
  }
  
  public void g()
  {
    a("click#shoot_edit#preview_btn", bler.a().b());
  }
  
  public void g(String paramString)
  {
    a("click#emoticon_edit#text_ai", bler.a().i(paramString));
  }
  
  public void h()
  {
    a("click#shoot_edit#pic_switch", bler.a().b());
  }
  
  public void h(String paramString)
  {
    a("expose#emoticon_edit#emoticon_item", bler.a().g(paramString));
  }
  
  public void i()
  {
    a("click#shoot_edit#edit_done", bler.a().h());
  }
  
  public void i(String paramString)
  {
    a("click#emoticon_view#filter_item", bler.a().h(paramString));
  }
  
  public void j()
  {
    a("click#shoot_edit#text_btn", bler.a().i());
  }
  
  public void k()
  {
    a("click#shoot_edit#music_btn", null);
  }
  
  public void l()
  {
    a("click#shoot_edit#cut_btn", null);
  }
  
  public void m()
  {
    a("click#shoot_edit#apply_btn", null);
  }
  
  public void n()
  {
    a("click#shoot_edit#music_item", bler.a().j());
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
    a("click#shoot_view#make_btn", bler.a().b());
  }
  
  public void y()
  {
    a("click#shoot_view#photo_make", bler.a().b());
  }
  
  public void z()
  {
    a("click#shoot_view#now_make", bler.a().b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blen
 * JD-Core Version:    0.7.0.1
 */