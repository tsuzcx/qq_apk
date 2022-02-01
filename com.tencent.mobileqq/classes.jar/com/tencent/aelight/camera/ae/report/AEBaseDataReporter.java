package com.tencent.aelight.camera.ae.report;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.HashMap;

public class AEBaseDataReporter
{
  private final int a = 10;
  
  private AEBaseDataReporter()
  {
    UserAction.initUserAction(BaseApplicationImpl.getContext());
  }
  
  public static AEBaseDataReporter a()
  {
    return AEBaseDataReporter.SingletonHolder.a();
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramString, paramHashMap, false);
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      b(paramString, AEBaseReportParam.a().a(), paramBoolean);
      return;
    }
    b(paramString, AEBaseDataUtil.a(AEBaseReportParam.a().a(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((AEBaseReportParam.a().a()) || (paramBoolean))
    {
      UserAction.onUserAction(paramString, true, -1L, -1L, paramHashMap, true, false);
      String str = UserAction.getAppKey();
      UserAction.setAppKey("0AND0PWXC34GZX1C");
      UserAction.onUserAction(paramString, true, -1L, -1L, paramHashMap, true, false);
      UserAction.setAppKey(str);
    }
  }
  
  public void A()
  {
    a("expose#shoot_edit#edit_word", AEBaseReportParam.a().t());
  }
  
  public void B()
  {
    a("click#shoot_edit#word_return", AEBaseReportParam.a().t());
  }
  
  public void C()
  {
    a("click#shoot_edit#word_done", AEBaseReportParam.a().t());
  }
  
  public void D()
  {
    a("expose#shoot_edit#com_video_page", null);
  }
  
  public void E()
  {
    a("click#shoot_edit#add_video", null);
  }
  
  public void F()
  {
    a("click#shoot_edit#cancel_video", null);
  }
  
  public void G()
  {
    a("click#shoot_edit#video_drag", null);
  }
  
  public void H()
  {
    a("click#shoot_edit#change_location", null);
  }
  
  public void I()
  {
    a("expose#shoot_view#view", null);
  }
  
  public void J()
  {
    a("click#shoot_view#cancel_btn", null);
  }
  
  public void K()
  {
    a("click#shoot_view#local_btn", null);
  }
  
  public void L()
  {
    a("click#shoot_view#flash_btn", null);
  }
  
  public void M()
  {
    a("click#shoot_view#switch_btn", null);
  }
  
  public void N()
  {
    a("click#shoot_view#face_btn", null);
  }
  
  public void O()
  {
    a("click#shoot_view#photo_switch", null);
  }
  
  public void P()
  {
    a("click#shoot_view#emoticon_switch", null);
  }
  
  public void Q()
  {
    a("click#shoot_view#module_btn", null);
  }
  
  public void R()
  {
    a("click#shoot_view#make_btn", AEBaseReportParam.a().b());
  }
  
  public void S()
  {
    a("click#shoot_view#photo_make", AEBaseReportParam.a().b());
  }
  
  public void T()
  {
    a("click#shoot_view#now_make", AEBaseReportParam.a().b());
  }
  
  public void U()
  {
    a("click#shoot_view#banner_icon", AEBaseReportParam.a().e());
  }
  
  public void V()
  {
    a("expose#shoot_view#banner_icon", AEBaseReportParam.a().e());
  }
  
  public void W()
  {
    a("click#shoot_view#face_item_list", AEBaseReportParam.a().f());
  }
  
  public void X()
  {
    a("click#shoot_view#aggregate_icon", AEBaseReportParam.a().g());
  }
  
  public void Y()
  {
    a("click#shoot_view#play_switch", null);
  }
  
  public void Z()
  {
    a("click#shoot_view#next_btn", AEBaseReportParam.a().c());
  }
  
  public HashMap<String, String> a(int paramInt)
  {
    HashMap localHashMap = AEBaseReportParam.a().a(paramInt);
    a("click#shoot_edit#edit_done", localHashMap);
    return localHashMap;
  }
  
  public void a()
  {
    a("expose#shoot_edit#view", AEBaseReportParam.a().j());
  }
  
  public void a(float paramFloat, String paramString)
  {
    a("click#shoot_edit#change_speed", AEBaseReportParam.a().a(paramFloat, paramString));
  }
  
  public void a(int paramInt)
  {
    a("click#shoot_edit#pick_done", AEBaseReportParam.a().c(paramInt));
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
    a("click#emoticon_edit#recomm_save_btn", AEBaseReportParam.a().a(paramInt, paramString));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a("performance#camera_app#server", AEBaseReportParam.a().a(paramInt1, paramString1, paramString2, paramInt2));
  }
  
  public void a(long paramLong)
  {
    a("click#shoot_edit#cut_btn", AEBaseReportParam.a().c(paramLong));
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    a("click#shoot_edit#com_video_next", AEBaseReportParam.a().a(paramLong, paramInt, paramString));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a("performance#camera_app#cost_time", AEBaseReportParam.a().a(paramLong1, paramLong2));
  }
  
  public void a(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    a("export#basics_view#video", AEBaseReportParam.a().a(paramLocalMediaInfo), true);
  }
  
  public void a(Long paramLong)
  {
    a("click#transmit_view#receiver", AEBaseReportParam.a().a(paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", AEBaseReportParam.a().f(paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a("click#shoot_edit#post_btn", AEBaseReportParam.a().a(paramString, paramInt), true);
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    a("performance#camera_app#material_zip_download", AEBaseReportParam.a().a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    a("performance#camera_app#video", AEBaseReportParam.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
  }
  
  public void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "2";
    }
    localHashMap.put("combine_type", str);
    a("click#shoot_edit#combine_btn", localHashMap);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    a("performance#camera_app#res_download", AEBaseReportParam.a().a(paramBoolean, paramInt, paramString1, paramString2, paramLong1, paramLong2), true);
  }
  
  public void aA()
  {
    a("click#current_position#cancel_btn", null);
  }
  
  public void aB()
  {
    a("face_recognition_page#first_enter_guide#expose", null, true);
  }
  
  public void aC()
  {
    a("face_recognition_page#first_enter_guide#click_knead_face", null, true);
  }
  
  public void aD()
  {
    a("face_recognition_page#camera_page#expose", null, true);
  }
  
  public void aE()
  {
    a("face_recognition_page#camera_page#click_photos_btn", null, true);
  }
  
  public void aF()
  {
    a("face_recognition_page#camera_page#picture_guide_expose", null, true);
  }
  
  public void aG()
  {
    a("face_recognition_page#camera_page#click_start_scanning", null, true);
  }
  
  public void aH()
  {
    a("face_recognition_page#camera_page#click_close_btn", null, true);
  }
  
  public void aI()
  {
    a("face_recognition_page#photos_page#expose", null, true);
  }
  
  public void aJ()
  {
    a("face_recognition_page#photos_page#click_check_btn", null, true);
  }
  
  public void aK()
  {
    a("face_recognition_page#photos_page#click_close_btn", null, true);
  }
  
  public void aL()
  {
    a("face_recognition_page#preview_page#click_sure", null, true);
  }
  
  public void aM()
  {
    a("face_recognition_page#preview_page#click_return", null, true);
  }
  
  public void aN()
  {
    a("face_recognition_page#knead_face_success#expose", null, true);
  }
  
  public void aO()
  {
    a("face_recognition_page#knead_face_success#click_done", null, true);
  }
  
  public void aP()
  {
    a("face_recognition_page#knead_face_success#click_again_scanning", null, true);
  }
  
  public void aQ()
  {
    a("face_recognition_page#knead_face_failed#click_again_scanning", null, true);
  }
  
  public void aR()
  {
    a("click#edit_page#graffiti_btn", AEBaseReportParam.a().l(), true);
  }
  
  public void aS()
  {
    a("click#edit_page#mark_btn", AEBaseReportParam.a().l(), true);
  }
  
  public void aT()
  {
    a("click#edit_page#text_btn", AEBaseReportParam.a().l(), true);
  }
  
  public void aU()
  {
    a("click#edit_page#sticker_btn", AEBaseReportParam.a().l(), true);
  }
  
  public void aV()
  {
    a("click#edit_page#filter_btn", AEBaseReportParam.a().l(), true);
  }
  
  public void aW()
  {
    a("click#edit_page#cut_btn", AEBaseReportParam.a().l(), true);
  }
  
  public void aX()
  {
    a("click#edit_page#music_btn", AEBaseReportParam.a().l(), true);
  }
  
  public void aY()
  {
    a("click#edit_page#mark_input", AEBaseReportParam.a().l(), true);
  }
  
  public void aZ()
  {
    a("click#edit_page#enhance_btn", AEBaseReportParam.a().l(), true);
  }
  
  public void aa()
  {
    a("click#shoot_view#face_outbtn", null);
  }
  
  public void ab()
  {
    a("click#shoot_view#done_btn", AEBaseReportParam.a().d());
  }
  
  public void ac()
  {
    a("click#shoot_view#rephoto_btn", AEBaseReportParam.a().d());
  }
  
  public void ad()
  {
    a("click#transmit_view#cancel_btn", AEBaseReportParam.a().u());
  }
  
  public void ae()
  {
    if (AEBaseReportParam.a().c())
    {
      a("performance#camera_app#launch", AEBaseReportParam.a().v());
      AEBaseReportParam.a().g();
    }
  }
  
  public void af()
  {
    a("expose#camera_app#view", null);
  }
  
  public void ag()
  {
    a("performance#camera_app#shader", AEBaseReportParam.a().w());
  }
  
  public void ah()
  {
    a("expose#basics_view#pic_view", null);
  }
  
  public void ai()
  {
    a("expose#basics_view#photo_view", null);
  }
  
  public void aj()
  {
    a("expose#emoticon_view#view", null);
  }
  
  public void ak()
  {
    a("click#emoticon_view#photo_btn", AEBaseReportParam.a().y());
  }
  
  public void al()
  {
    a("click#emoticon_view#emoticon_item", AEBaseReportParam.a().z());
  }
  
  public void am()
  {
    a("click#emoticon_view#emo_sort_tab", AEBaseReportParam.a().A());
  }
  
  public void an()
  {
    a("click#emoticon_view#emo_background", null);
  }
  
  public void ao()
  {
    a("enter#emoticon_edit#view", AEBaseReportParam.a().x());
  }
  
  public void ap()
  {
    a("click#emoticon_edit#save_btn", AEBaseReportParam.a().B());
  }
  
  public void aq()
  {
    a("click#emoticon_edit#send_btn", AEBaseReportParam.a().B());
  }
  
  public void ar()
  {
    a("click#emoticon_edit#save_btn", AEBaseReportParam.a().C());
  }
  
  public void as()
  {
    a("click#emoticon_edit#word_return", AEBaseReportParam.a().D());
  }
  
  public void at()
  {
    a("click#emoticon_edit#word_done", AEBaseReportParam.a().D());
  }
  
  public void au()
  {
    a("click#shoot_view#watermark_icon", null);
  }
  
  public void av()
  {
    a("click#shoot_view#watermark", null);
  }
  
  public void aw()
  {
    a("expose#watermark_view#view", null);
  }
  
  public void ax()
  {
    a("expose#watermark_view#default_watermark", null);
  }
  
  public void ay()
  {
    a("click#watermark_view#cancel_btn", null);
  }
  
  public void az()
  {
    a("expose#current_position#view", null);
  }
  
  public void b()
  {
    a("enter#shoot_edit#view", AEBaseReportParam.a().h());
  }
  
  public void b(int paramInt)
  {
    a("click#shoot_edit#change_scale", AEBaseReportParam.a().d(paramInt));
  }
  
  public void b(int paramInt, String paramString)
  {
    HashMap localHashMap = AEBaseReportParam.a().l();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("filter_type", localStringBuilder.toString());
    localHashMap.put("filter_id", paramString);
    a("click#edit_page#filter_type", localHashMap, true);
  }
  
  public void b(long paramLong)
  {
    a("click#shoot_edit#edit_choose", AEBaseReportParam.a().d(paramLong));
  }
  
  public void b(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    a("export#basics_view#picture", AEBaseReportParam.a().b(paramLocalMediaInfo));
  }
  
  public void b(String paramString)
  {
    a("click#shoot_edit#filter_item", AEBaseReportParam.a().g(paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    if (AEBaseDataUtil.a())
    {
      a("performance#camera_app#res_ready", AEBaseReportParam.a().a(paramBoolean));
      AEBaseDataUtil.a();
    }
  }
  
  public void c()
  {
    a("click#shoot_edit#post_btn", AEBaseReportParam.a().i(), true);
  }
  
  public void c(int paramInt)
  {
    a("performance#camera_app#api_level", AEBaseReportParam.a().e(paramInt));
  }
  
  public void c(long paramLong)
  {
    a("enter#shoot_view#view", AEBaseReportParam.a().a(paramLong));
  }
  
  public void c(String paramString)
  {
    a("click#shoot_view#face_item", AEBaseReportParam.a().a(paramString));
  }
  
  public void d()
  {
    a("click#shoot_edit#rephoto_btn", null);
  }
  
  public void d(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext_int1", String.valueOf(paramInt));
    a("face_recognition_page#knead_face_failed#expose", localHashMap, true);
  }
  
  public void d(long paramLong)
  {
    a("click#shoot_view#photo_btn", AEBaseReportParam.a().b(paramLong));
  }
  
  public void d(String paramString)
  {
    a("click#shoot_view#filter_ai", AEBaseReportParam.a().b(paramString));
  }
  
  public void e()
  {
    a("click#shoot_edit#download_btn", AEBaseReportParam.a().k(), true);
  }
  
  public void e(int paramInt)
  {
    HashMap localHashMap = AEBaseReportParam.a().l();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("graffiti_type", localStringBuilder.toString());
    a("click#edit_page#graffiti_type", localHashMap, true);
  }
  
  public void e(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#camera_page#page_stop_time", localHashMap, true);
  }
  
  public void e(String paramString)
  {
    a("click#shoot_view#filter_item", AEBaseReportParam.a().c(paramString));
  }
  
  public void f()
  {
    a("ARvediodone_downloadsclick", null);
  }
  
  public void f(int paramInt)
  {
    HashMap localHashMap = AEBaseReportParam.a().l();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("mark_type", localStringBuilder.toString());
    a("click#edit_page#mark_type", localHashMap, true);
  }
  
  public void f(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#photos_page#page_stop_time", localHashMap, true);
  }
  
  public void f(String paramString)
  {
    a("expose#shoot_view#face_item", AEBaseReportParam.a().d(paramString));
  }
  
  public void g()
  {
    a("ARvediodone_sharesclick", null);
  }
  
  public void g(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#knead_face_success#page_stop_time", localHashMap, true);
  }
  
  public void g(String paramString)
  {
    a("expose#shoot_view#tab_item", AEBaseReportParam.a().e(paramString));
  }
  
  public void h()
  {
    a("ARvediodone_exp", null);
  }
  
  public void h(String paramString)
  {
    a("expose#shoot_view#gift_btn", AEBaseReportParam.a().e(paramString));
  }
  
  public void i()
  {
    a("ARweb_exp", null);
  }
  
  public void i(String paramString)
  {
    a("click#shoot_view#gift_btn", AEBaseReportParam.a().e(paramString));
  }
  
  public void j()
  {
    a("ARcake_sclick", null);
  }
  
  public void j(String paramString)
  {
    a("click#emoticon_view#filter_item", AEBaseReportParam.a().h(paramString));
  }
  
  public void k()
  {
    a("ARvedio_sclick", null);
  }
  
  public void k(String paramString)
  {
    a("click#emoticon_edit#text_ai", AEBaseReportParam.a().i(paramString));
  }
  
  public void l()
  {
    a("click#shoot_edit#video_edit", AEBaseReportParam.a().b());
  }
  
  public void l(String paramString)
  {
    a("expose#emoticon_edit#emoticon_item", AEBaseReportParam.a().j(paramString));
  }
  
  public void m()
  {
    a("click#shoot_edit#text_edit", AEBaseReportParam.a().b());
  }
  
  public void m(String paramString)
  {
    a("expose#emoticon_edit#edit_word", AEBaseReportParam.a().k(paramString));
  }
  
  public void n()
  {
    a("click#shoot_edit#preview_btn", AEBaseReportParam.a().b());
  }
  
  public void n(String paramString)
  {
    a("click#watermark_view#watermark", AEBaseReportParam.a().l(paramString));
  }
  
  public void o()
  {
    a("click#shoot_edit#pic_switch", AEBaseReportParam.a().b());
  }
  
  public void o(String paramString)
  {
    a("click#watermark_view#watermark_edit", AEBaseReportParam.a().l(paramString));
  }
  
  public void p()
  {
    a("click#shoot_edit#edit_done", AEBaseReportParam.a().m());
  }
  
  public void p(String paramString)
  {
    a("click#current_position#position", AEBaseReportParam.a().m(paramString));
  }
  
  public void q()
  {
    a("click#shoot_edit#text_btn", AEBaseReportParam.a().n());
  }
  
  public void q(String paramString)
  {
    HashMap localHashMap = AEBaseReportParam.a().l();
    localHashMap.put("text_id", paramString);
    a("click#edit_page#text_type", localHashMap, true);
  }
  
  public void r()
  {
    a("click#shoot_edit#music_btn", AEBaseReportParam.a().o());
  }
  
  public void s()
  {
    a("click#shoot_edit#apply_btn", AEBaseReportParam.a().o());
  }
  
  public void t()
  {
    a("click#shoot_edit#music_item", AEBaseReportParam.a().p());
  }
  
  public void u()
  {
    a("click#shoot_edit#lyric_btn", AEBaseReportParam.a().q());
  }
  
  public void v()
  {
    a("click#shoot_edit#more_music_btn", AEBaseReportParam.a().o());
  }
  
  public void w()
  {
    a("click#shoot_edit#giveup_btn", AEBaseReportParam.a().o());
  }
  
  public void x()
  {
    a("click#shoot_edit#exit_btn", AEBaseReportParam.a().o());
  }
  
  public void y()
  {
    a("expose#shoot_edit#edit_video", AEBaseReportParam.a().r());
  }
  
  public void z()
  {
    a("click#shoot_edit#color_match", AEBaseReportParam.a().s());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.report.AEBaseDataReporter
 * JD-Core Version:    0.7.0.1
 */