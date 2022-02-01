import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.HashMap;

public class bozr
{
  private final int a = 10;
  
  private bozr()
  {
    UserAction.initUserAction(BaseApplicationImpl.getContext());
  }
  
  public static bozr a()
  {
    return bozt.a();
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramString, paramHashMap, false);
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      b(paramString, bozv.a().a(), paramBoolean);
      return;
    }
    b(paramString, bozu.a(bozv.a().a(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((bozv.a().a()) || (paramBoolean)) {
      UserAction.onUserAction(paramString, true, -1L, -1L, paramHashMap, true, false);
    }
  }
  
  public void A()
  {
    a("click#shoot_edit#word_done", bozv.a().r());
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
    a("click#shoot_view#make_btn", bozv.a().b());
  }
  
  public void L()
  {
    a("click#shoot_view#photo_make", bozv.a().b());
  }
  
  public void M()
  {
    a("click#shoot_view#now_make", bozv.a().b());
  }
  
  public void N()
  {
    a("click#shoot_view#banner_icon", bozv.a().e());
  }
  
  public void O()
  {
    a("expose#shoot_view#banner_icon", bozv.a().e());
  }
  
  public void P()
  {
    a("click#shoot_view#face_item_list", bozv.a().f());
  }
  
  public void Q()
  {
    a("click#shoot_view#aggregate_icon", bozv.a().g());
  }
  
  public void R()
  {
    a("click#shoot_view#play_switch", null);
  }
  
  public void S()
  {
    a("click#shoot_view#next_btn", bozv.a().c());
  }
  
  public void T()
  {
    a("click#shoot_view#face_outbtn", null);
  }
  
  public void U()
  {
    a("click#shoot_view#done_btn", bozv.a().d());
  }
  
  public void V()
  {
    a("click#shoot_view#rephoto_btn", bozv.a().d());
  }
  
  public void W()
  {
    a("click#transmit_view#cancel_btn", bozv.a().s());
  }
  
  public void X()
  {
    if (bozv.a().c())
    {
      a("performance#camera_app#launch", bozv.a().t());
      bozv.a().e();
    }
  }
  
  public void Y()
  {
    a("expose#camera_app#view", null);
  }
  
  public void Z()
  {
    a("performance#camera_app#shader", bozv.a().u());
  }
  
  public void a()
  {
    a("expose#shoot_edit#view", null);
  }
  
  public void a(float paramFloat)
  {
    a("click#shoot_edit#change_speed", bozv.a().a(paramFloat));
  }
  
  public void a(int paramInt)
  {
    a("click#shoot_edit#pick_done", bozv.a().b(paramInt));
  }
  
  public void a(int paramInt, String paramString)
  {
    a("click#emoticon_edit#recomm_save_btn", bozv.a().a(paramInt, paramString));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a("performance#camera_app#server", bozv.a().a(paramInt1, paramString1, paramString2, paramInt2));
  }
  
  public void a(long paramLong)
  {
    a("click#shoot_edit#edit_choose", bozv.a().c(paramLong));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a("performance#camera_app#cost_time", bozv.a().a(paramLong1, paramLong2));
  }
  
  public void a(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    a("export#basics_view#video", bozv.a().a(paramLocalMediaInfo), true);
  }
  
  public void a(Long paramLong)
  {
    a("click#transmit_view#receiver", bozv.a().a(paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bozv.a().e(paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bozv.a().a(paramString, paramInt));
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    a("performance#camera_app#material_zip_download", bozv.a().a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
  }
  
  public void a(String paramString, long paramLong)
  {
    a("performance#camera_app#material2screen", bozv.a().a(paramString, paramLong));
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    a("performance#camera_app#video", bozv.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bozu.a())
    {
      a("performance#camera_app#res_ready", bozv.a().a(paramBoolean));
      bozu.a();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    a("performance#camera_app#res_download", bozv.a().a(paramBoolean, paramInt, paramString1, paramString2, paramLong1, paramLong2), true);
  }
  
  public void aa()
  {
    a("expose#basics_view#pic_view", null);
  }
  
  public void ab()
  {
    a("expose#basics_view#photo_view", null);
  }
  
  public void ac()
  {
    a("expose#emoticon_view#view", null);
  }
  
  public void ad()
  {
    a("click#emoticon_view#photo_btn", bozv.a().w());
  }
  
  public void ae()
  {
    a("click#emoticon_view#emoticon_item", bozv.a().x());
  }
  
  public void af()
  {
    a("click#emoticon_view#emo_background", null);
  }
  
  public void ag()
  {
    a("enter#emoticon_edit#view", bozv.a().v());
  }
  
  public void ah()
  {
    a("click#emoticon_edit#save_btn", bozv.a().y());
  }
  
  public void ai()
  {
    a("click#emoticon_edit#send_btn", bozv.a().y());
  }
  
  public void aj()
  {
    a("click#emoticon_edit#save_btn", bozv.a().z());
  }
  
  public void ak()
  {
    a("click#emoticon_edit#word_return", bozv.a().A());
  }
  
  public void al()
  {
    a("click#emoticon_edit#word_done", bozv.a().A());
  }
  
  public void b()
  {
    a("enter#shoot_edit#view", bozv.a().h());
  }
  
  public void b(int paramInt)
  {
    a("click#shoot_edit#edit_done", bozv.a().a(paramInt));
  }
  
  public void b(long paramLong)
  {
    a("enter#shoot_view#view", bozv.a().a(paramLong));
  }
  
  public void b(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    a("export#basics_view#picture", bozv.a().b(paramLocalMediaInfo));
  }
  
  public void b(String paramString)
  {
    a("click#shoot_edit#filter_item", bozv.a().f(paramString));
  }
  
  public void c()
  {
    a("click#shoot_edit#post_btn", bozv.a().i());
  }
  
  public void c(int paramInt)
  {
    a("click#shoot_edit#ori_vocal_btn", bozv.a().c(paramInt));
  }
  
  public void c(long paramLong)
  {
    a("click#shoot_view#photo_btn", bozv.a().b(paramLong));
  }
  
  public void c(String paramString)
  {
    a("click#shoot_edit#ai_color_frame_on", bozv.a().g(paramString));
  }
  
  public void d()
  {
    a("click#shoot_edit#rephoto_btn", null);
  }
  
  public void d(int paramInt)
  {
    a("click#shoot_edit#music_vocal_btn", bozv.a().d(paramInt));
  }
  
  public void d(String paramString)
  {
    a("click#shoot_view#face_item", bozv.a().a(paramString));
  }
  
  public void e()
  {
    a("click#shoot_edit#video_edit", bozv.a().b());
  }
  
  public void e(int paramInt)
  {
    a("click#shoot_edit#change_scale", bozv.a().e(paramInt));
  }
  
  public void e(String paramString)
  {
    a("click#shoot_view#filter_ai", bozv.a().b(paramString));
  }
  
  public void f()
  {
    a("click#shoot_edit#text_edit", bozv.a().b());
  }
  
  public void f(int paramInt)
  {
    a("performance#camera_app#api_level", bozv.a().f(paramInt));
  }
  
  public void f(String paramString)
  {
    a("click#shoot_view#filter_item", bozv.a().c(paramString));
  }
  
  public void g()
  {
    a("click#shoot_edit#preview_btn", bozv.a().b());
  }
  
  public void g(String paramString)
  {
    a("expose#shoot_view#face_item", bozv.a().d(paramString));
  }
  
  public void h()
  {
    a("click#shoot_edit#pic_switch", bozv.a().b());
  }
  
  public void h(String paramString)
  {
    a("click#emoticon_view#emo_sort_tab", bozv.a().h(paramString));
  }
  
  public void i()
  {
    a("click#shoot_edit#edit_done", bozv.a().j());
  }
  
  public void i(String paramString)
  {
    a("click#emoticon_view#filter_item", bozv.a().i(paramString));
  }
  
  public void j()
  {
    a("click#shoot_edit#text_btn", bozv.a().k());
  }
  
  public void j(String paramString)
  {
    a("click#emoticon_edit#text_ai", bozv.a().j(paramString));
  }
  
  public void k()
  {
    a("click#shoot_edit#music_btn", bozv.a().l());
  }
  
  public void k(String paramString)
  {
    a("expose#emoticon_edit#emoticon_item", bozv.a().k(paramString));
  }
  
  public void l()
  {
    a("click#shoot_edit#cut_btn", null);
  }
  
  public void l(String paramString)
  {
    a("expose#emoticon_edit#edit_word", bozv.a().l(paramString));
  }
  
  public void m()
  {
    a("click#shoot_edit#apply_btn", bozv.a().l());
  }
  
  public void n()
  {
    a("click#shoot_edit#music_item", bozv.a().m());
  }
  
  public void o()
  {
    a("click#shoot_edit#lyric_btn", bozv.a().n());
  }
  
  public void p()
  {
    a("click#shoot_edit#more_music_btn", bozv.a().l());
  }
  
  public void q()
  {
    a("click#shoot_edit#giveup_btn", bozv.a().l());
  }
  
  public void r()
  {
    a("click#shoot_edit#exit_btn", bozv.a().l());
  }
  
  public void s()
  {
    a("expose#shoot_edit#edit_video", bozv.a().o());
  }
  
  public void t()
  {
    a("click#shoot_edit#color_match", bozv.a().p());
  }
  
  public void u()
  {
    a("expose#shoot_edit#text_item", bozv.a().q());
  }
  
  public void v()
  {
    a("click#shoot_edit#text_item", bozv.a().q());
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
    a("expose#shoot_edit#edit_word", bozv.a().r());
  }
  
  public void z()
  {
    a("click#shoot_edit#word_return", bozv.a().r());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozr
 * JD-Core Version:    0.7.0.1
 */