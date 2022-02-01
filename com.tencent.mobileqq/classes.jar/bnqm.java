import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.HashMap;

public class bnqm
{
  private final int a = 10;
  
  private bnqm()
  {
    UserAction.initUserAction(BaseApplicationImpl.getContext());
  }
  
  public static bnqm a()
  {
    return bnqo.a();
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramString, paramHashMap, false);
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      b(paramString, bnqq.a().a(), paramBoolean);
      return;
    }
    b(paramString, bnqp.a(bnqq.a().a(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((bnqq.a().a()) || (paramBoolean)) {
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
    a("click#shoot_view#make_btn", bnqq.a().b());
  }
  
  public void P()
  {
    a("click#shoot_view#photo_make", bnqq.a().b());
  }
  
  public void Q()
  {
    a("click#shoot_view#now_make", bnqq.a().b());
  }
  
  public void R()
  {
    a("click#shoot_view#banner_icon", bnqq.a().e());
  }
  
  public void S()
  {
    a("expose#shoot_view#banner_icon", bnqq.a().e());
  }
  
  public void T()
  {
    a("click#shoot_view#face_item_list", bnqq.a().f());
  }
  
  public void U()
  {
    a("click#shoot_view#aggregate_icon", bnqq.a().g());
  }
  
  public void V()
  {
    a("click#shoot_view#play_switch", null);
  }
  
  public void W()
  {
    a("click#shoot_view#next_btn", bnqq.a().c());
  }
  
  public void X()
  {
    a("click#shoot_view#face_outbtn", null);
  }
  
  public void Y()
  {
    a("click#shoot_view#done_btn", bnqq.a().d());
  }
  
  public void Z()
  {
    a("click#shoot_view#rephoto_btn", bnqq.a().d());
  }
  
  public void a()
  {
    a("expose#shoot_edit#view", null);
  }
  
  public void a(float paramFloat, String paramString)
  {
    a("click#shoot_edit#change_speed", bnqq.a().a(paramFloat, paramString));
  }
  
  public void a(int paramInt)
  {
    a("click#shoot_edit#pick_done", bnqq.a().b(paramInt));
  }
  
  public void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext_int1", String.valueOf(paramInt));
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#knead_face_failed#page_stop_time", localHashMap, true);
  }
  
  public void a(int paramInt, String paramString)
  {
    a("click#emoticon_edit#recomm_save_btn", bnqq.a().a(paramInt, paramString));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a("performance#camera_app#server", bnqq.a().a(paramInt1, paramString1, paramString2, paramInt2));
  }
  
  public void a(long paramLong)
  {
    a("click#shoot_edit#cut_btn", bnqq.a().c(paramLong));
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    a("click#shoot_edit#com_video_next", bnqq.a().a(paramLong, paramInt, paramString));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a("performance#camera_app#cost_time", bnqq.a().a(paramLong1, paramLong2));
  }
  
  public void a(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    a("export#basics_view#video", bnqq.a().a(paramLocalMediaInfo), true);
  }
  
  public void a(Long paramLong)
  {
    a("click#transmit_view#receiver", bnqq.a().a(paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bnqq.a().e(paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", bnqq.a().a(paramString, paramInt));
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    a("performance#camera_app#material_zip_download", bnqq.a().a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
  }
  
  public void a(String paramString, long paramLong)
  {
    a("performance#camera_app#material2screen", bnqq.a().a(paramString, paramLong));
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    a("performance#camera_app#video", bnqq.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
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
    a("performance#camera_app#res_download", bnqq.a().a(paramBoolean, paramInt, paramString1, paramString2, paramLong1, paramLong2), true);
  }
  
  public void aA()
  {
    a("face_recognition_page#camera_page#expose", null, true);
  }
  
  public void aB()
  {
    a("face_recognition_page#camera_page#click_photos_btn", null, true);
  }
  
  public void aC()
  {
    a("face_recognition_page#camera_page#picture_guide_expose", null, true);
  }
  
  public void aD()
  {
    a("face_recognition_page#camera_page#click_start_scanning", null, true);
  }
  
  public void aE()
  {
    a("face_recognition_page#camera_page#click_close_btn", null, true);
  }
  
  public void aF()
  {
    a("face_recognition_page#photos_page#expose", null, true);
  }
  
  public void aG()
  {
    a("face_recognition_page#photos_page#click_check_btn", null, true);
  }
  
  public void aH()
  {
    a("face_recognition_page#photos_page#click_close_btn", null, true);
  }
  
  public void aI()
  {
    a("face_recognition_page#preview_page#click_sure", null, true);
  }
  
  public void aJ()
  {
    a("face_recognition_page#preview_page#click_return", null, true);
  }
  
  public void aK()
  {
    a("face_recognition_page#knead_face_success#expose", null, true);
  }
  
  public void aL()
  {
    a("face_recognition_page#knead_face_success#click_done", null, true);
  }
  
  public void aM()
  {
    a("face_recognition_page#knead_face_success#click_again_scanning", null, true);
  }
  
  public void aN()
  {
    a("face_recognition_page#knead_face_failed#click_again_scanning", null, true);
  }
  
  public void aa()
  {
    a("click#transmit_view#cancel_btn", bnqq.a().s());
  }
  
  public void ab()
  {
    if (bnqq.a().c())
    {
      a("performance#camera_app#launch", bnqq.a().t());
      bnqq.a().e();
    }
  }
  
  public void ac()
  {
    a("expose#camera_app#view", null);
  }
  
  public void ad()
  {
    a("performance#camera_app#shader", bnqq.a().u());
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
    a("click#emoticon_view#photo_btn", bnqq.a().w());
  }
  
  public void ai()
  {
    a("click#emoticon_view#emoticon_item", bnqq.a().x());
  }
  
  public void aj()
  {
    a("click#emoticon_view#emo_sort_tab", bnqq.a().y());
  }
  
  public void ak()
  {
    a("click#emoticon_view#emo_background", null);
  }
  
  public void al()
  {
    a("enter#emoticon_edit#view", bnqq.a().v());
  }
  
  public void am()
  {
    a("click#emoticon_edit#save_btn", bnqq.a().z());
  }
  
  public void an()
  {
    a("click#emoticon_edit#send_btn", bnqq.a().z());
  }
  
  public void ao()
  {
    a("click#emoticon_edit#save_btn", bnqq.a().A());
  }
  
  public void ap()
  {
    a("click#emoticon_edit#word_return", bnqq.a().B());
  }
  
  public void aq()
  {
    a("click#emoticon_edit#word_done", bnqq.a().B());
  }
  
  public void ar()
  {
    a("click#shoot_view#watermark_icon", null);
  }
  
  public void as()
  {
    a("click#shoot_view#watermark", null);
  }
  
  public void at()
  {
    a("expose#watermark_view#view", null);
  }
  
  public void au()
  {
    a("expose#watermark_view#default_watermark", null);
  }
  
  public void av()
  {
    a("click#watermark_view#cancel_btn", null);
  }
  
  public void aw()
  {
    a("expose#current_position#view", null);
  }
  
  public void ax()
  {
    a("click#current_position#cancel_btn", null);
  }
  
  public void ay()
  {
    a("face_recognition_page#first_enter_guide#expose", null, true);
  }
  
  public void az()
  {
    a("face_recognition_page#first_enter_guide#click_knead_face", null, true);
  }
  
  public void b()
  {
    a("enter#shoot_edit#view", bnqq.a().h());
  }
  
  public void b(int paramInt)
  {
    a("click#shoot_edit#edit_done", bnqq.a().a(paramInt));
  }
  
  public void b(long paramLong)
  {
    a("click#shoot_edit#edit_choose", bnqq.a().d(paramLong));
  }
  
  public void b(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    a("export#basics_view#picture", bnqq.a().b(paramLocalMediaInfo));
  }
  
  public void b(String paramString)
  {
    a("click#shoot_edit#filter_item", bnqq.a().f(paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    if (bnqp.a())
    {
      a("performance#camera_app#res_ready", bnqq.a().a(paramBoolean));
      bnqp.a();
    }
  }
  
  public void c()
  {
    a("click#shoot_edit#post_btn", bnqq.a().i());
  }
  
  public void c(int paramInt)
  {
    a("click#shoot_edit#ori_vocal_btn", bnqq.a().c(paramInt));
  }
  
  public void c(long paramLong)
  {
    a("enter#shoot_view#view", bnqq.a().a(paramLong));
  }
  
  public void c(String paramString)
  {
    a("click#shoot_edit#ai_color_frame_on", bnqq.a().g(paramString));
  }
  
  public void d()
  {
    a("click#shoot_edit#rephoto_btn", null);
  }
  
  public void d(int paramInt)
  {
    a("click#shoot_edit#music_vocal_btn", bnqq.a().d(paramInt));
  }
  
  public void d(long paramLong)
  {
    a("click#shoot_view#photo_btn", bnqq.a().b(paramLong));
  }
  
  public void d(String paramString)
  {
    a("click#shoot_view#face_item", bnqq.a().a(paramString));
  }
  
  public void e()
  {
    a("click#shoot_edit#video_edit", bnqq.a().b());
  }
  
  public void e(int paramInt)
  {
    a("click#shoot_edit#change_scale", bnqq.a().e(paramInt));
  }
  
  public void e(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#camera_page#page_stop_time", localHashMap, true);
  }
  
  public void e(String paramString)
  {
    a("click#shoot_view#filter_ai", bnqq.a().b(paramString));
  }
  
  public void f()
  {
    a("click#shoot_edit#text_edit", bnqq.a().b());
  }
  
  public void f(int paramInt)
  {
    a("performance#camera_app#api_level", bnqq.a().f(paramInt));
  }
  
  public void f(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#photos_page#page_stop_time", localHashMap, true);
  }
  
  public void f(String paramString)
  {
    a("click#shoot_view#filter_item", bnqq.a().c(paramString));
  }
  
  public void g()
  {
    a("click#shoot_edit#preview_btn", bnqq.a().b());
  }
  
  public void g(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext_int1", String.valueOf(paramInt));
    a("face_recognition_page#knead_face_failed#expose", localHashMap, true);
  }
  
  public void g(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#knead_face_success#page_stop_time", localHashMap, true);
  }
  
  public void g(String paramString)
  {
    a("expose#shoot_view#face_item", bnqq.a().d(paramString));
  }
  
  public void h()
  {
    a("click#shoot_edit#pic_switch", bnqq.a().b());
  }
  
  public void h(String paramString)
  {
    a("click#emoticon_view#filter_item", bnqq.a().h(paramString));
  }
  
  public void i()
  {
    a("click#shoot_edit#edit_done", bnqq.a().j());
  }
  
  public void i(String paramString)
  {
    a("click#emoticon_edit#text_ai", bnqq.a().i(paramString));
  }
  
  public void j()
  {
    a("click#shoot_edit#text_btn", bnqq.a().k());
  }
  
  public void j(String paramString)
  {
    a("expose#emoticon_edit#emoticon_item", bnqq.a().j(paramString));
  }
  
  public void k()
  {
    a("click#shoot_edit#music_btn", bnqq.a().l());
  }
  
  public void k(String paramString)
  {
    a("expose#emoticon_edit#edit_word", bnqq.a().k(paramString));
  }
  
  public void l()
  {
    a("click#shoot_edit#apply_btn", bnqq.a().l());
  }
  
  public void l(String paramString)
  {
    a("click#watermark_view#watermark", bnqq.a().l(paramString));
  }
  
  public void m()
  {
    a("click#shoot_edit#music_item", bnqq.a().m());
  }
  
  public void m(String paramString)
  {
    a("click#watermark_view#watermark_edit", bnqq.a().l(paramString));
  }
  
  public void n()
  {
    a("click#shoot_edit#lyric_btn", bnqq.a().n());
  }
  
  public void n(String paramString)
  {
    a("click#current_position#position", bnqq.a().m(paramString));
  }
  
  public void o()
  {
    a("click#shoot_edit#more_music_btn", bnqq.a().l());
  }
  
  public void p()
  {
    a("click#shoot_edit#giveup_btn", bnqq.a().l());
  }
  
  public void q()
  {
    a("click#shoot_edit#exit_btn", bnqq.a().l());
  }
  
  public void r()
  {
    a("expose#shoot_edit#edit_video", bnqq.a().o());
  }
  
  public void s()
  {
    a("click#shoot_edit#color_match", bnqq.a().p());
  }
  
  public void t()
  {
    a("expose#shoot_edit#text_item", bnqq.a().q());
  }
  
  public void u()
  {
    a("click#shoot_edit#text_item", bnqq.a().q());
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
    a("expose#shoot_edit#edit_word", bnqq.a().r());
  }
  
  public void y()
  {
    a("click#shoot_edit#word_return", bnqq.a().r());
  }
  
  public void z()
  {
    a("click#shoot_edit#word_done", bnqq.a().r());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqm
 * JD-Core Version:    0.7.0.1
 */