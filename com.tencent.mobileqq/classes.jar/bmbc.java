import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.HashMap;

public class bmbc
{
  private final int a = 10;
  
  private bmbc()
  {
    UserAction.initUserAction(BaseApplicationImpl.getContext());
  }
  
  public static bmbc a()
  {
    return bmbe.a();
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramString, paramHashMap, false);
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      b(paramString, bmbg.a().a(), paramBoolean);
      return;
    }
    b(paramString, bmbf.a(bmbg.a().a(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((bmbg.a().a()) || (paramBoolean)) {
      UserAction.onUserAction(paramString, true, -1L, -1L, paramHashMap, true, false);
    }
  }
  
  public void A()
  {
    a("expose#shoot_edit#com_video_page", null);
  }
  
  public void B()
  {
    a("click#shoot_edit#add_video", null);
  }
  
  public void C()
  {
    a("click#shoot_edit#cancel_video", null);
  }
  
  public void D()
  {
    a("click#shoot_edit#video_drag", null);
  }
  
  public void E()
  {
    a("click#shoot_edit#change_location", null);
  }
  
  public void F()
  {
    a("expose#shoot_view#view", null);
  }
  
  public void G()
  {
    a("click#shoot_view#cancel_btn", null);
  }
  
  public void H()
  {
    a("click#shoot_view#local_btn", null);
  }
  
  public void I()
  {
    a("click#shoot_view#flash_btn", null);
  }
  
  public void J()
  {
    a("click#shoot_view#switch_btn", null);
  }
  
  public void K()
  {
    a("click#shoot_view#face_btn", null);
  }
  
  public void L()
  {
    a("click#shoot_view#photo_switch", null);
  }
  
  public void M()
  {
    a("click#shoot_view#emoticon_switch", null);
  }
  
  public void N()
  {
    a("click#shoot_view#module_btn", null);
  }
  
  public void O()
  {
    a("click#shoot_view#make_btn", bmbg.a().b());
  }
  
  public void P()
  {
    a("click#shoot_view#photo_make", bmbg.a().b());
  }
  
  public void Q()
  {
    a("click#shoot_view#now_make", bmbg.a().b());
  }
  
  public void R()
  {
    a("click#shoot_view#banner_icon", bmbg.a().e());
  }
  
  public void S()
  {
    a("expose#shoot_view#banner_icon", bmbg.a().e());
  }
  
  public void T()
  {
    a("click#shoot_view#face_item_list", bmbg.a().f());
  }
  
  public void U()
  {
    a("click#shoot_view#aggregate_icon", bmbg.a().g());
  }
  
  public void V()
  {
    a("click#shoot_view#play_switch", null);
  }
  
  public void W()
  {
    a("click#shoot_view#next_btn", bmbg.a().c());
  }
  
  public void X()
  {
    a("click#shoot_view#face_outbtn", null);
  }
  
  public void Y()
  {
    a("click#shoot_view#done_btn", bmbg.a().d());
  }
  
  public void Z()
  {
    a("click#shoot_view#rephoto_btn", bmbg.a().d());
  }
  
  public void a()
  {
    a("expose#shoot_edit#view", null);
  }
  
  public void a(float paramFloat, String paramString)
  {
    a("click#shoot_edit#change_speed", bmbg.a().a(paramFloat, paramString));
  }
  
  public void a(int paramInt)
  {
    a("click#shoot_edit#pick_done", bmbg.a().b(paramInt));
  }
  
  public void a(int paramInt, String paramString)
  {
    a("click#emoticon_edit#recomm_save_btn", bmbg.a().a(paramInt, paramString));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a("performance#camera_app#server", bmbg.a().a(paramInt1, paramString1, paramString2, paramInt2));
  }
  
  public void a(long paramLong)
  {
    a("click#shoot_edit#cut_btn", bmbg.a().c(paramLong));
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    a("click#shoot_edit#com_video_next", bmbg.a().a(paramLong, paramInt, paramString));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a("performance#camera_app#cost_time", bmbg.a().a(paramLong1, paramLong2));
  }
  
  public void a(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    a("export#basics_view#video", bmbg.a().a(paramLocalMediaInfo), true);
  }
  
  public void a(Long paramLong)
  {
    a("click#transmit_view#receiver", bmbg.a().a(paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bmbg.a().e(paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bmbg.a().a(paramString, paramInt));
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    a("performance#camera_app#material_zip_download", bmbg.a().a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
  }
  
  public void a(String paramString, long paramLong)
  {
    a("performance#camera_app#material2screen", bmbg.a().a(paramString, paramLong));
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    a("performance#camera_app#video", bmbg.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localHashMap.put("combine_type", str);
      a("click#shoot_edit#combine_btn", localHashMap);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    a("performance#camera_app#res_download", bmbg.a().a(paramBoolean, paramInt, paramString1, paramString2, paramLong1, paramLong2), true);
  }
  
  public void aa()
  {
    a("click#transmit_view#cancel_btn", bmbg.a().s());
  }
  
  public void ab()
  {
    if (bmbg.a().c())
    {
      a("performance#camera_app#launch", bmbg.a().t());
      bmbg.a().e();
    }
  }
  
  public void ac()
  {
    a("expose#camera_app#view", null);
  }
  
  public void ad()
  {
    a("performance#camera_app#shader", bmbg.a().u());
  }
  
  public void ae()
  {
    a("expose#basics_view#pic_view", null);
  }
  
  public void af()
  {
    a("expose#basics_view#photo_view", null);
  }
  
  public void ag()
  {
    a("expose#emoticon_view#view", null);
  }
  
  public void ah()
  {
    a("click#emoticon_view#photo_btn", bmbg.a().w());
  }
  
  public void ai()
  {
    a("click#emoticon_view#emoticon_item", bmbg.a().x());
  }
  
  public void aj()
  {
    a("click#emoticon_view#emo_sort_tab", bmbg.a().y());
  }
  
  public void ak()
  {
    a("click#emoticon_view#emo_background", null);
  }
  
  public void al()
  {
    a("enter#emoticon_edit#view", bmbg.a().v());
  }
  
  public void am()
  {
    a("click#emoticon_edit#save_btn", bmbg.a().z());
  }
  
  public void an()
  {
    a("click#emoticon_edit#send_btn", bmbg.a().z());
  }
  
  public void ao()
  {
    a("click#emoticon_edit#save_btn", bmbg.a().A());
  }
  
  public void ap()
  {
    a("click#emoticon_edit#word_return", bmbg.a().B());
  }
  
  public void aq()
  {
    a("click#emoticon_edit#word_done", bmbg.a().B());
  }
  
  public void b()
  {
    a("enter#shoot_edit#view", bmbg.a().h());
  }
  
  public void b(int paramInt)
  {
    a("click#shoot_edit#edit_done", bmbg.a().a(paramInt));
  }
  
  public void b(long paramLong)
  {
    a("click#shoot_edit#edit_choose", bmbg.a().d(paramLong));
  }
  
  public void b(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    a("export#basics_view#picture", bmbg.a().b(paramLocalMediaInfo));
  }
  
  public void b(String paramString)
  {
    a("click#shoot_edit#filter_item", bmbg.a().f(paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    if (bmbf.a())
    {
      a("performance#camera_app#res_ready", bmbg.a().a(paramBoolean));
      bmbf.a();
    }
  }
  
  public void c()
  {
    a("click#shoot_edit#post_btn", bmbg.a().i());
  }
  
  public void c(int paramInt)
  {
    a("click#shoot_edit#ori_vocal_btn", bmbg.a().c(paramInt));
  }
  
  public void c(long paramLong)
  {
    a("enter#shoot_view#view", bmbg.a().a(paramLong));
  }
  
  public void c(String paramString)
  {
    a("click#shoot_edit#ai_color_frame_on", bmbg.a().g(paramString));
  }
  
  public void d()
  {
    a("click#shoot_edit#rephoto_btn", null);
  }
  
  public void d(int paramInt)
  {
    a("click#shoot_edit#music_vocal_btn", bmbg.a().d(paramInt));
  }
  
  public void d(long paramLong)
  {
    a("click#shoot_view#photo_btn", bmbg.a().b(paramLong));
  }
  
  public void d(String paramString)
  {
    a("click#shoot_view#face_item", bmbg.a().a(paramString));
  }
  
  public void e()
  {
    a("click#shoot_edit#video_edit", bmbg.a().b());
  }
  
  public void e(int paramInt)
  {
    a("click#shoot_edit#change_scale", bmbg.a().e(paramInt));
  }
  
  public void e(String paramString)
  {
    a("click#shoot_view#filter_ai", bmbg.a().b(paramString));
  }
  
  public void f()
  {
    a("click#shoot_edit#text_edit", bmbg.a().b());
  }
  
  public void f(int paramInt)
  {
    a("performance#camera_app#api_level", bmbg.a().f(paramInt));
  }
  
  public void f(String paramString)
  {
    a("click#shoot_view#filter_item", bmbg.a().c(paramString));
  }
  
  public void g()
  {
    a("click#shoot_edit#preview_btn", bmbg.a().b());
  }
  
  public void g(String paramString)
  {
    a("expose#shoot_view#face_item", bmbg.a().d(paramString));
  }
  
  public void h()
  {
    a("click#shoot_edit#pic_switch", bmbg.a().b());
  }
  
  public void h(String paramString)
  {
    a("click#emoticon_view#filter_item", bmbg.a().h(paramString));
  }
  
  public void i()
  {
    a("click#shoot_edit#edit_done", bmbg.a().j());
  }
  
  public void i(String paramString)
  {
    a("click#emoticon_edit#text_ai", bmbg.a().i(paramString));
  }
  
  public void j()
  {
    a("click#shoot_edit#text_btn", bmbg.a().k());
  }
  
  public void j(String paramString)
  {
    a("expose#emoticon_edit#emoticon_item", bmbg.a().j(paramString));
  }
  
  public void k()
  {
    a("click#shoot_edit#music_btn", bmbg.a().l());
  }
  
  public void k(String paramString)
  {
    a("expose#emoticon_edit#edit_word", bmbg.a().k(paramString));
  }
  
  public void l()
  {
    a("click#shoot_edit#apply_btn", bmbg.a().l());
  }
  
  public void m()
  {
    a("click#shoot_edit#music_item", bmbg.a().m());
  }
  
  public void n()
  {
    a("click#shoot_edit#lyric_btn", bmbg.a().n());
  }
  
  public void o()
  {
    a("click#shoot_edit#more_music_btn", bmbg.a().l());
  }
  
  public void p()
  {
    a("click#shoot_edit#giveup_btn", bmbg.a().l());
  }
  
  public void q()
  {
    a("click#shoot_edit#exit_btn", bmbg.a().l());
  }
  
  public void r()
  {
    a("expose#shoot_edit#edit_video", bmbg.a().o());
  }
  
  public void s()
  {
    a("click#shoot_edit#color_match", bmbg.a().p());
  }
  
  public void t()
  {
    a("expose#shoot_edit#text_item", bmbg.a().q());
  }
  
  public void u()
  {
    a("click#shoot_edit#text_item", bmbg.a().q());
  }
  
  public void v()
  {
    a("click#shoot_edit#ai_color_frame", null);
  }
  
  public void w()
  {
    a("expose#shoot_edit#ai_filter_use", null);
  }
  
  public void x()
  {
    a("expose#shoot_edit#edit_word", bmbg.a().r());
  }
  
  public void y()
  {
    a("click#shoot_edit#word_return", bmbg.a().r());
  }
  
  public void z()
  {
    a("click#shoot_edit#word_done", bmbg.a().r());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbc
 * JD-Core Version:    0.7.0.1
 */