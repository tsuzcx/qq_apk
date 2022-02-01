import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

public class bnyh
{
  private final int a = 10;
  
  private bnyh()
  {
    UserAction.initUserAction(BaseApplicationImpl.getContext());
  }
  
  public static bnyh a()
  {
    return bnyj.a();
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramString, paramHashMap, false);
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      b(paramString, bnyl.a().a(), paramBoolean);
      return;
    }
    b(paramString, bnyk.a(bnyl.a().a(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((bnyl.a().a()) || (paramBoolean)) {
      UserAction.onUserAction(paramString, true, -1L, -1L, paramHashMap, true, false);
    }
  }
  
  public void A()
  {
    a("click#shoot_edit#word_done", bnyl.a().p());
  }
  
  public void B()
  {
    a("expose#shoot_view#view", null);
  }
  
  public void C()
  {
    a("click#shoot_view#cancel_btn", null);
  }
  
  public void D()
  {
    a("click#shoot_view#local_btn", null);
  }
  
  public void E()
  {
    a("click#shoot_view#flash_btn", null);
  }
  
  public void F()
  {
    a("click#shoot_view#switch_btn", null);
  }
  
  public void G()
  {
    a("click#shoot_view#face_btn", null);
  }
  
  public void H()
  {
    a("click#shoot_view#photo_switch", null);
  }
  
  public void I()
  {
    a("click#shoot_view#emoticon_switch", null);
  }
  
  public void J()
  {
    a("click#shoot_view#module_btn", null);
  }
  
  public void K()
  {
    a("click#shoot_view#make_btn", bnyl.a().b());
  }
  
  public void L()
  {
    a("click#shoot_view#photo_make", bnyl.a().b());
  }
  
  public void M()
  {
    a("click#shoot_view#now_make", bnyl.a().b());
  }
  
  public void N()
  {
    a("click#shoot_view#banner_icon", bnyl.a().e());
  }
  
  public void O()
  {
    a("expose#shoot_view#banner_icon", bnyl.a().e());
  }
  
  public void P()
  {
    a("click#shoot_view#play_switch", null);
  }
  
  public void Q()
  {
    a("click#shoot_view#next_btn", bnyl.a().c());
  }
  
  public void R()
  {
    a("click#shoot_view#face_outbtn", null);
  }
  
  public void S()
  {
    a("click#shoot_view#done_btn", bnyl.a().d());
  }
  
  public void T()
  {
    a("click#shoot_view#rephoto_btn", bnyl.a().d());
  }
  
  public void U()
  {
    a("click#transmit_view#cancel_btn", bnyl.a().q());
  }
  
  public void V()
  {
    if (bnyl.a().c())
    {
      a("performance#camera_app#launch", bnyl.a().r());
      bnyl.a().e();
    }
  }
  
  public void W()
  {
    a("expose#camera_app#view", null);
  }
  
  public void X()
  {
    a("performance#camera_app#shader", bnyl.a().s());
  }
  
  public void Y()
  {
    a("expose#basics_view#pic_view", null);
  }
  
  public void Z()
  {
    a("expose#basics_view#photo_view", null);
  }
  
  public void a()
  {
    a("expose#shoot_edit#view", null);
  }
  
  public void a(float paramFloat)
  {
    a("click#shoot_edit#change_speed", bnyl.a().a(paramFloat));
  }
  
  public void a(int paramInt)
  {
    a("click#shoot_edit#pick_done", bnyl.a().b(paramInt));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a("performance#camera_app#server", bnyl.a().a(paramInt1, paramString1, paramString2, paramInt2));
  }
  
  public void a(long paramLong)
  {
    a("click#shoot_edit#edit_choose", bnyl.a().c(paramLong));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a("performance#camera_app#cost_time", bnyl.a().a(paramLong1, paramLong2));
  }
  
  public void a(Long paramLong)
  {
    a("click#transmit_view#receiver", bnyl.a().a(paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bnyl.a().e(paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bnyl.a().a(paramString, paramInt));
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    a("performance#camera_app#material_zip_download", bnyl.a().a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
  }
  
  public void a(String paramString, long paramLong)
  {
    a("performance#camera_app#material2screen", bnyl.a().a(paramString, paramLong));
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    a("performance#camera_app#video", bnyl.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bnyk.a())
    {
      a("performance#camera_app#res_ready", bnyl.a().a(paramBoolean));
      bnyk.a();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    a("performance#camera_app#res_download", bnyl.a().a(paramBoolean, paramInt, paramString1, paramString2, paramLong1, paramLong2), true);
  }
  
  public void aa()
  {
    a("click#emoticon_view#photo_btn", bnyl.a().u());
  }
  
  public void ab()
  {
    a("click#emoticon_view#emoticon_item", bnyl.a().v());
  }
  
  public void ac()
  {
    a("enter#emoticon_edit#view", bnyl.a().t());
  }
  
  public void ad()
  {
    a("click#emoticon_edit#save_btn", bnyl.a().w());
  }
  
  public void ae()
  {
    a("click#emoticon_edit#send_btn", bnyl.a().w());
  }
  
  public void af()
  {
    a("click#emoticon_edit#save_btn", bnyl.a().x());
  }
  
  public void b()
  {
    a("enter#shoot_edit#view", bnyl.a().f());
  }
  
  public void b(int paramInt)
  {
    a("click#shoot_edit#edit_done", bnyl.a().a(paramInt));
  }
  
  public void b(long paramLong)
  {
    a("enter#shoot_view#view", bnyl.a().a(paramLong));
  }
  
  public void b(String paramString)
  {
    a("click#shoot_edit#filter_item", bnyl.a().f(paramString));
  }
  
  public void c()
  {
    a("click#shoot_edit#post_btn", bnyl.a().g());
  }
  
  public void c(int paramInt)
  {
    a("click#shoot_edit#ori_vocal_btn", bnyl.a().c(paramInt));
  }
  
  public void c(long paramLong)
  {
    a("click#shoot_view#photo_btn", bnyl.a().b(paramLong));
  }
  
  public void c(String paramString)
  {
    a("click#shoot_edit#ai_color_frame_on", bnyl.a().g(paramString));
  }
  
  public void d()
  {
    a("click#shoot_edit#rephoto_btn", null);
  }
  
  public void d(int paramInt)
  {
    a("click#shoot_edit#music_vocal_btn", bnyl.a().d(paramInt));
  }
  
  public void d(String paramString)
  {
    a("click#shoot_view#face_item", bnyl.a().a(paramString));
  }
  
  public void e()
  {
    a("click#shoot_edit#video_edit", bnyl.a().b());
  }
  
  public void e(int paramInt)
  {
    a("click#shoot_edit#change_scale", bnyl.a().e(paramInt));
  }
  
  public void e(String paramString)
  {
    a("click#shoot_view#filter_ai", bnyl.a().b(paramString));
  }
  
  public void f()
  {
    a("click#shoot_edit#text_edit", bnyl.a().b());
  }
  
  public void f(String paramString)
  {
    a("click#shoot_view#filter_item", bnyl.a().c(paramString));
  }
  
  public void g()
  {
    a("click#shoot_edit#preview_btn", bnyl.a().b());
  }
  
  public void g(String paramString)
  {
    a("expose#shoot_view#face_item", bnyl.a().d(paramString));
  }
  
  public void h()
  {
    a("click#shoot_edit#pic_switch", bnyl.a().b());
  }
  
  public void h(String paramString)
  {
    a("click#emoticon_edit#text_ai", bnyl.a().j(paramString));
  }
  
  public void i()
  {
    a("click#shoot_edit#edit_done", bnyl.a().h());
  }
  
  public void i(String paramString)
  {
    a("expose#emoticon_edit#emoticon_item", bnyl.a().h(paramString));
  }
  
  public void j()
  {
    a("click#shoot_edit#text_btn", bnyl.a().i());
  }
  
  public void j(String paramString)
  {
    a("click#emoticon_view#filter_item", bnyl.a().i(paramString));
  }
  
  public void k()
  {
    a("click#shoot_edit#music_btn", bnyl.a().j());
  }
  
  public void l()
  {
    a("click#shoot_edit#cut_btn", null);
  }
  
  public void m()
  {
    a("click#shoot_edit#apply_btn", bnyl.a().j());
  }
  
  public void n()
  {
    a("click#shoot_edit#music_item", bnyl.a().k());
  }
  
  public void o()
  {
    a("click#shoot_edit#lyric_btn", bnyl.a().l());
  }
  
  public void p()
  {
    a("click#shoot_edit#more_music_btn", bnyl.a().j());
  }
  
  public void q()
  {
    a("click#shoot_edit#giveup_btn", bnyl.a().j());
  }
  
  public void r()
  {
    a("click#shoot_edit#exit_btn", bnyl.a().j());
  }
  
  public void s()
  {
    a("expose#shoot_edit#edit_video", bnyl.a().m());
  }
  
  public void t()
  {
    a("click#shoot_edit#color_match", bnyl.a().n());
  }
  
  public void u()
  {
    a("expose#shoot_edit#text_item", bnyl.a().o());
  }
  
  public void v()
  {
    a("click#shoot_edit#text_item", bnyl.a().o());
  }
  
  public void w()
  {
    a("click#shoot_edit#ai_color_frame", null);
  }
  
  public void x()
  {
    a("expose#shoot_edit#ai_filter_use", null);
  }
  
  public void y()
  {
    a("expose#shoot_edit#edit_word", bnyl.a().p());
  }
  
  public void z()
  {
    a("click#shoot_edit#word_return", bnyl.a().p());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnyh
 * JD-Core Version:    0.7.0.1
 */