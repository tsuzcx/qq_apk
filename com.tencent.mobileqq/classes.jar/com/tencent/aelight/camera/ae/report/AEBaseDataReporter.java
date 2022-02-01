package com.tencent.aelight.camera.ae.report;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.HashMap;
import java.util.Map;

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
      b(paramString, AEBaseReportParam.a().e(), paramBoolean);
      return;
    }
    b(paramString, AEBaseDataUtil.a(AEBaseReportParam.a().e(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((AEBaseReportParam.a().c()) || (paramBoolean))
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
    a("click#shoot_edit#color_match", AEBaseReportParam.a().G());
  }
  
  public void B()
  {
    a("expose#shoot_edit#edit_word", AEBaseReportParam.a().H());
  }
  
  public void C()
  {
    a("click#shoot_edit#word_return", AEBaseReportParam.a().H());
  }
  
  public void D()
  {
    a("click#shoot_edit#word_done", AEBaseReportParam.a().H());
  }
  
  public void E()
  {
    a("expose#shoot_edit#com_video_page", null);
  }
  
  public void F()
  {
    a("click#shoot_edit#add_video", null);
  }
  
  public void G()
  {
    a("click#shoot_edit#cancel_video", null);
  }
  
  public void H()
  {
    a("click#shoot_edit#video_drag", null);
  }
  
  public void I()
  {
    a("click#shoot_edit#change_location", null);
  }
  
  public void J()
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEBaseReportParam.a().k());
    localStringBuilder.append("");
    localHashMap.put("is_ai_btn", localStringBuilder.toString());
    a("expose#shoot_view#view", localHashMap);
  }
  
  public void K()
  {
    a("click#shoot_view#cancel_btn", null);
  }
  
  public void L()
  {
    a("click#shoot_view#local_btn", null);
  }
  
  public void M()
  {
    a("click#shoot_view#flash_btn", null);
  }
  
  public void N()
  {
    a("click#shoot_view#switch_btn", null);
  }
  
  public void O()
  {
    a("click#shoot_view#face_btn", null);
  }
  
  public void P()
  {
    a("click#shoot_view#photo_switch", null);
  }
  
  public void Q()
  {
    a("click#shoot_view#emoticon_switch", null);
  }
  
  public void R()
  {
    a("click#shoot_view#module_btn", null);
  }
  
  public void S()
  {
    a("click#shoot_view#make_btn", AEBaseReportParam.a().o());
  }
  
  public void T()
  {
    a("click#shoot_view#photo_make", AEBaseReportParam.a().o());
  }
  
  public void U()
  {
    a("click#shoot_view#now_make", AEBaseReportParam.a().o());
  }
  
  public void V()
  {
    a("click#shoot_view#banner_icon", AEBaseReportParam.a().r());
  }
  
  public void W()
  {
    a("expose#shoot_view#banner_icon", AEBaseReportParam.a().r());
  }
  
  public void X()
  {
    a("click#shoot_view#face_item_list", AEBaseReportParam.a().s());
  }
  
  public void Y()
  {
    a("click#shoot_view#aggregate_icon", AEBaseReportParam.a().t());
  }
  
  public void Z()
  {
    a("click#shoot_view#play_switch", null);
  }
  
  public void a(float paramFloat, String paramString)
  {
    a("click#shoot_edit#change_speed", AEBaseReportParam.a().a(paramFloat, paramString));
  }
  
  public void a(int paramInt)
  {
    a("click#shoot_edit#pick_done", AEBaseReportParam.a().l(paramInt));
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
    a("click#emoticon_edit#recomm_save_btn", AEBaseReportParam.a().b(paramInt, paramString));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a("performance#camera_app#server", AEBaseReportParam.a().a(paramInt1, paramString1, paramString2, paramInt2));
  }
  
  public void a(long paramLong)
  {
    a("click#shoot_edit#cut_btn", AEBaseReportParam.a().e(paramLong));
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
    a("click#shoot_edit#post_btn", AEBaseReportParam.a().x(paramString));
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
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("beauty_name", paramString1);
    localHashMap.put("beauty_subname", paramString2);
    localHashMap.put("beauty_value", String.valueOf(paramInt));
    a("click#shoot_view#basic_beauty_face", localHashMap);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a("expose#shoot_view#tab_item", AEBaseReportParam.a().a(paramString1, paramString2, paramString3));
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    a("performance#camera_app#video", AEBaseReportParam.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    a("click#shoot_view#photo_btn", paramHashMap);
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
    a("click#shoot_view#watermark", null);
  }
  
  public void aB()
  {
    a("expose#watermark_view#view", null);
  }
  
  public void aC()
  {
    a("expose#watermark_view#default_watermark", null);
  }
  
  public void aD()
  {
    a("click#watermark_view#cancel_btn", null);
  }
  
  public void aE()
  {
    a("expose#current_position#view", null);
  }
  
  public void aF()
  {
    a("click#current_position#cancel_btn", null);
  }
  
  public void aG()
  {
    a("face_recognition_page#first_enter_guide#expose", null, true);
  }
  
  public void aH()
  {
    a("face_recognition_page#first_enter_guide#click_knead_face", null, true);
  }
  
  public void aI()
  {
    a("face_recognition_page#camera_page#expose", null, true);
  }
  
  public void aJ()
  {
    a("face_recognition_page#camera_page#click_photos_btn", null, true);
  }
  
  public void aK()
  {
    a("face_recognition_page#camera_page#picture_guide_expose", null, true);
  }
  
  public void aL()
  {
    a("face_recognition_page#camera_page#click_start_scanning", null, true);
  }
  
  public void aM()
  {
    a("face_recognition_page#camera_page#click_close_btn", null, true);
  }
  
  public void aN()
  {
    a("face_recognition_page#photos_page#expose", null, true);
  }
  
  public void aO()
  {
    a("face_recognition_page#photos_page#click_check_btn", null, true);
  }
  
  public void aP()
  {
    a("face_recognition_page#photos_page#click_close_btn", null, true);
  }
  
  public void aQ()
  {
    a("face_recognition_page#preview_page#click_sure", null, true);
  }
  
  public void aR()
  {
    a("face_recognition_page#preview_page#click_return", null, true);
  }
  
  public void aS()
  {
    a("face_recognition_page#knead_face_success#expose", null, true);
  }
  
  public void aT()
  {
    a("face_recognition_page#knead_face_success#click_done", null, true);
  }
  
  public void aU()
  {
    a("face_recognition_page#knead_face_success#click_again_scanning", null, true);
  }
  
  public void aV()
  {
    a("face_recognition_page#knead_face_failed#click_again_scanning", null, true);
  }
  
  public void aW()
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEBaseReportParam.a().k());
    localStringBuilder.append("");
    localHashMap.put("is_ai_btn", localStringBuilder.toString());
    a("click#shoot_view#ai_beauty", localHashMap, true);
  }
  
  public void aX()
  {
    a("click#shoot_view#ai_beauty_desc", null, true);
  }
  
  public void aY()
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEBaseReportParam.a().k());
    localStringBuilder.append("");
    localHashMap.put("is_ai_btn", localStringBuilder.toString());
    localHashMap.put("face_info", AEBaseReportParam.a().j());
    a("expose#shoot_view#get_face_first", localHashMap, true);
  }
  
  public void aZ()
  {
    a("click#edit_page#graffiti_btn", AEBaseReportParam.a().y(), true);
  }
  
  public void aa()
  {
    a("click#shoot_view#next_btn", AEBaseReportParam.a().p());
  }
  
  public void ab()
  {
    a("click#shoot_view#face_outbtn", null);
  }
  
  public void ac()
  {
    a("click#shoot_view#done_btn", AEBaseReportParam.a().q());
  }
  
  public void ad()
  {
    a("click#shoot_view#rephoto_btn", AEBaseReportParam.a().q());
  }
  
  public void ae()
  {
    a("click#shoot_view#beautify_btn", null);
  }
  
  public void af()
  {
    a("click#shoot_view#basic_beauty_tab", null);
  }
  
  public void ag()
  {
    a("click#shoot_view#basic_makeup_tab", null);
  }
  
  public void ah()
  {
    a("click#shoot_view#filter_tab", null);
  }
  
  public void ai()
  {
    a("click#transmit_view#cancel_btn", AEBaseReportParam.a().I());
  }
  
  public void aj()
  {
    if (AEBaseReportParam.a().P())
    {
      a("performance#camera_app#launch", AEBaseReportParam.a().J());
      AEBaseReportParam.a().L();
    }
  }
  
  public void ak()
  {
    a("expose#camera_app#view", null);
  }
  
  public void al()
  {
    a("performance#camera_app#shader", AEBaseReportParam.a().K());
  }
  
  public void am()
  {
    a("expose#basics_view#pic_view", null);
  }
  
  public void an()
  {
    a("expose#basics_view#photo_view", null);
  }
  
  public void ao()
  {
    a("expose#emoticon_view#view", null);
  }
  
  public void ap()
  {
    a("click#emoticon_view#photo_btn", AEBaseReportParam.a().U());
  }
  
  public void aq()
  {
    a("click#emoticon_view#emoticon_item", AEBaseReportParam.a().V());
  }
  
  public void ar()
  {
    a("click#emoticon_view#emo_sort_tab", AEBaseReportParam.a().W());
  }
  
  public void as()
  {
    a("click#emoticon_view#emo_background", null);
  }
  
  public void at()
  {
    a("enter#emoticon_edit#view", AEBaseReportParam.a().T());
  }
  
  public void au()
  {
    a("click#emoticon_edit#save_btn", AEBaseReportParam.a().X());
  }
  
  public void av()
  {
    a("click#emoticon_edit#send_btn", AEBaseReportParam.a().X());
  }
  
  public void aw()
  {
    a("click#emoticon_edit#save_btn", AEBaseReportParam.a().Y());
  }
  
  public void ax()
  {
    a("click#emoticon_edit#word_return", AEBaseReportParam.a().Z());
  }
  
  public void ay()
  {
    a("click#emoticon_edit#word_done", AEBaseReportParam.a().Z());
  }
  
  public void az()
  {
    a("click#shoot_view#watermark_icon", null);
  }
  
  public HashMap<String, String> b(int paramInt)
  {
    HashMap localHashMap = AEBaseReportParam.a().j(paramInt);
    a("click#shoot_edit#edit_done", localHashMap);
    return localHashMap;
  }
  
  public void b()
  {
    a("expose#shoot_edit#view", AEBaseReportParam.a().w());
  }
  
  public void b(int paramInt, String paramString)
  {
    HashMap localHashMap = AEBaseReportParam.a().y();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("filter_type", localStringBuilder.toString());
    localHashMap.put("filter_id", paramString);
    a("click#edit_page#filter_type", localHashMap, true);
  }
  
  public void b(long paramLong)
  {
    a("click#shoot_edit#edit_choose", AEBaseReportParam.a().f(paramLong));
  }
  
  public void b(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    a("export#basics_view#picture", AEBaseReportParam.a().b(paramLocalMediaInfo));
  }
  
  public void b(String paramString)
  {
    a("click#shoot_edit#filter_item", AEBaseReportParam.a().y(paramString));
  }
  
  public void b(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("makeup_name", paramString);
    localHashMap.put("makeup_value", String.valueOf(paramInt));
    a("click#shoot_view#basic_makeup_face", localHashMap);
  }
  
  public void b(HashMap<String, String> paramHashMap)
  {
    a("expose#shoot_view#view", paramHashMap);
  }
  
  public void b(boolean paramBoolean)
  {
    if (AEBaseDataUtil.b())
    {
      a("performance#camera_app#res_ready", AEBaseReportParam.a().f(paramBoolean));
      AEBaseDataUtil.c();
    }
  }
  
  public void ba()
  {
    a("click#edit_page#mark_btn", AEBaseReportParam.a().y(), true);
  }
  
  public void bb()
  {
    a("click#edit_page#text_btn", AEBaseReportParam.a().y(), true);
  }
  
  public void bc()
  {
    a("click#edit_page#sticker_btn", AEBaseReportParam.a().y(), true);
  }
  
  public void bd()
  {
    a("click#edit_page#filter_btn", AEBaseReportParam.a().y(), true);
  }
  
  public void be()
  {
    a("click#edit_page#cut_btn", AEBaseReportParam.a().y(), true);
  }
  
  public void bf()
  {
    a("click#edit_page#music_btn", AEBaseReportParam.a().y(), true);
  }
  
  public void bg()
  {
    a("click#edit_page#mark_input", AEBaseReportParam.a().y(), true);
  }
  
  public void bh()
  {
    a("click#edit_page#enhance_btn", AEBaseReportParam.a().y(), true);
  }
  
  public void c()
  {
    a("enter#shoot_edit#view", AEBaseReportParam.a().u());
  }
  
  public void c(int paramInt)
  {
    a("click#shoot_edit#change_scale", AEBaseReportParam.a().m(paramInt));
  }
  
  public void c(long paramLong)
  {
    a("enter#shoot_view#view", AEBaseReportParam.a().c(paramLong));
  }
  
  public void c(String paramString)
  {
    a("click#shoot_view#face_item", AEBaseReportParam.a().s(paramString));
  }
  
  public void c(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("makeup_name", paramString);
    localHashMap.put("makeup_value", String.valueOf(paramInt));
    a("click#shoot_view#basic_makeup_seekbar", localHashMap);
  }
  
  public void d()
  {
    HashMap localHashMap = AEBaseReportParam.a().v();
    Map localMap = AEBeautyReportParam.a().b();
    if (localHashMap != null) {
      localHashMap.putAll(localMap);
    }
    a("click#shoot_edit#post_btn", localHashMap, true);
  }
  
  public void d(int paramInt)
  {
    a("performance#camera_app#api_level", AEBaseReportParam.a().n(paramInt));
  }
  
  public void d(long paramLong)
  {
    a("click#shoot_view#photo_btn", AEBaseReportParam.a().d(paramLong));
  }
  
  public void d(String paramString)
  {
    a("click#shoot_view#filter_ai", AEBaseReportParam.a().t(paramString));
  }
  
  public void d(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("filter_id", paramString);
    localHashMap.put("filter_value", String.valueOf(paramInt));
    a("click#shoot_view#filter_item", localHashMap);
  }
  
  public void e()
  {
    a("click#shoot_edit#rephoto_btn", null);
  }
  
  public void e(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext_int1", String.valueOf(paramInt));
    a("face_recognition_page#knead_face_failed#expose", localHashMap, true);
  }
  
  public void e(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#camera_page#page_stop_time", localHashMap, true);
  }
  
  public void e(String paramString)
  {
    a("click#shoot_view#filter_item", AEBaseReportParam.a().u(paramString));
  }
  
  public void e(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("filter_id", paramString);
    localHashMap.put("filter_value", String.valueOf(paramInt));
    a("click#shoot_view#filter_sliding", localHashMap);
  }
  
  public void f()
  {
    a("click#shoot_edit#download_btn", AEBaseReportParam.a().x(), true);
  }
  
  public void f(int paramInt)
  {
    HashMap localHashMap = AEBaseReportParam.a().y();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("graffiti_type", localStringBuilder.toString());
    a("click#edit_page#graffiti_type", localHashMap, true);
  }
  
  public void f(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#photos_page#page_stop_time", localHashMap, true);
  }
  
  public void f(String paramString)
  {
    a("expose#shoot_view#face_item", AEBaseReportParam.a().v(paramString));
  }
  
  public void f(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("filter_id", paramString);
    localHashMap.put("filter_value", String.valueOf(paramInt));
    a("click#shoot_view#filter_seekbar", localHashMap);
  }
  
  public void g()
  {
    a("ARvediodone_downloadsclick", null);
  }
  
  public void g(int paramInt)
  {
    HashMap localHashMap = AEBaseReportParam.a().y();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("mark_type", localStringBuilder.toString());
    a("click#edit_page#mark_type", localHashMap, true);
  }
  
  public void g(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", String.valueOf(paramLong));
    a("face_recognition_page#knead_face_success#page_stop_time", localHashMap, true);
  }
  
  public void g(String paramString)
  {
    a("expose#shoot_view#tab_item", AEBaseReportParam.a().w(paramString));
  }
  
  public void h()
  {
    a("ARvediodone_sharesclick", null);
  }
  
  public void h(String paramString)
  {
    a("expose#shoot_view#gift_btn", AEBaseReportParam.a().w(paramString));
  }
  
  public void i()
  {
    a("ARvediodone_exp", null);
  }
  
  public void i(String paramString)
  {
    a("click#shoot_view#gift_btn", AEBaseReportParam.a().w(paramString));
  }
  
  public void j()
  {
    a("ARweb_exp", null);
  }
  
  public void j(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("beauty_name", paramString);
    a("click#shoot_view#basic_beauty_seekbar", localHashMap);
  }
  
  public void k()
  {
    a("ARcake_sclick", null);
  }
  
  public void k(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ratio_status", paramString);
    a("click#shoot_view#ratio_change", localHashMap);
  }
  
  public void l()
  {
    a("ARvedio_sclick", null);
  }
  
  public void l(String paramString)
  {
    a("click#emoticon_view#filter_item", AEBaseReportParam.a().E(paramString));
  }
  
  public void m()
  {
    a("click#shoot_edit#video_edit", AEBaseReportParam.a().o());
  }
  
  public void m(String paramString)
  {
    a("click#emoticon_edit#text_ai", AEBaseReportParam.a().F(paramString));
  }
  
  public void n()
  {
    a("click#shoot_edit#text_edit", AEBaseReportParam.a().o());
  }
  
  public void n(String paramString)
  {
    a("expose#emoticon_edit#emoticon_item", AEBaseReportParam.a().G(paramString));
  }
  
  public void o()
  {
    a("click#shoot_edit#preview_btn", AEBaseReportParam.a().o());
  }
  
  public void o(String paramString)
  {
    a("expose#emoticon_edit#edit_word", AEBaseReportParam.a().H(paramString));
  }
  
  public void p()
  {
    a("click#shoot_edit#pic_switch", AEBaseReportParam.a().o());
  }
  
  public void p(String paramString)
  {
    a("click#watermark_view#watermark", AEBaseReportParam.a().I(paramString));
  }
  
  public void q()
  {
    a("click#shoot_edit#edit_done", AEBaseReportParam.a().z());
  }
  
  public void q(String paramString)
  {
    a("click#watermark_view#watermark_edit", AEBaseReportParam.a().I(paramString));
  }
  
  public void r()
  {
    a("click#shoot_edit#text_btn", AEBaseReportParam.a().A());
  }
  
  public void r(String paramString)
  {
    a("click#current_position#position", AEBaseReportParam.a().J(paramString));
  }
  
  public void s()
  {
    a("click#shoot_edit#music_btn", AEBaseReportParam.a().B());
  }
  
  public void s(String paramString)
  {
    HashMap localHashMap = AEBaseReportParam.a().y();
    localHashMap.put("text_id", paramString);
    a("click#edit_page#text_type", localHashMap, true);
  }
  
  public void t()
  {
    a("click#shoot_edit#apply_btn", AEBaseReportParam.a().B());
  }
  
  public void t(String paramString)
  {
    HashMap localHashMap = AEBaseReportParam.a().y();
    localHashMap.put("btn_type", paramString);
    a("click#edit_page#enhance_home", localHashMap, true);
  }
  
  public void u()
  {
    a("click#shoot_edit#music_item", AEBaseReportParam.a().D());
  }
  
  public void u(String paramString)
  {
    HashMap localHashMap = AEBaseReportParam.a().y();
    localHashMap.put("btn_type", paramString);
    a("click#edit_page#enhance_adjust", localHashMap, true);
  }
  
  public void v()
  {
    a("click#shoot_edit#lyric_btn", AEBaseReportParam.a().E());
  }
  
  public void v(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("face_id", AEBaseReportParam.a().f());
    localHashMap.put("trigger_code", paramString);
    a("run#shoot_view#face_action", localHashMap, true);
  }
  
  public void w()
  {
    a("click#shoot_edit#more_music_btn", AEBaseReportParam.a().B());
  }
  
  public void x()
  {
    a("click#shoot_edit#giveup_btn", AEBaseReportParam.a().B());
  }
  
  public void y()
  {
    a("click#shoot_edit#exit_btn", AEBaseReportParam.a().B());
  }
  
  public void z()
  {
    a("expose#shoot_edit#edit_video", AEBaseReportParam.a().F());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.report.AEBaseDataReporter
 * JD-Core Version:    0.7.0.1
 */