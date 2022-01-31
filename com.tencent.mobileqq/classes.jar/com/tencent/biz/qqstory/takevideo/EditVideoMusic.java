package com.tencent.biz.qqstory.takevideo;

import aepr;
import ahct;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.Music;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import wxe;
import wxk;
import wxr;
import wyg;
import xai;
import xaj;
import xal;
import xam;
import xan;
import xaz;
import xbv;
import xbw;
import xbx;
import xkh;
import xkl;
import xlb;
import xoe;
import xof;
import xrg;

public class EditVideoMusic
  extends xal
  implements aepr, wyg
{
  int jdField_a_of_type_Int = 0;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public SparseArray<xkl> a;
  protected EditVideoMusic.TakePhotoMusicTimerTask a;
  protected AudioPlayer a;
  public ArrayList<xkl> a;
  protected Timer a;
  xbw jdField_a_of_type_Xbw;
  protected boolean a;
  private int b;
  protected boolean b;
  boolean c = false;
  boolean d = false;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public EditVideoMusic(@NonNull xan paramxan)
  {
    super(paramxan);
    this.jdField_a_of_type_AndroidOsHandler = new xaj(this);
  }
  
  private xkl a(xbw paramxbw)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramxbw.e);
      localJSONObject.put("audio_url", paramxbw.f);
      localJSONObject.put("type", 2);
      localJSONObject.put("id", paramxbw.d);
      return new xkl(localJSONObject.toString());
    }
    catch (JSONException paramxbw)
    {
      for (;;)
      {
        paramxbw.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if (this.f) {
      return;
    }
    Object localObject = a();
    if ((localObject == null) || (((xkl)localObject).equals(xkl.jdField_b_of_type_Xkl)))
    {
      localObject = (xaz)this.jdField_a_of_type_Xan.a(xaz.class);
      if (localObject != null) {
        ((xaz)localObject).a(this.e);
      }
      VideoSourceHelper.nativeSetPlayAFMute(this.e);
      return;
    }
    if (this.e)
    {
      i();
      return;
    }
    f();
  }
  
  private void n()
  {
    if (this.g)
    {
      QQToast.a(a(), "GIF不支持添加音乐", 0).a();
      return;
    }
    this.jdField_a_of_type_Xan.a(2);
  }
  
  public xkl a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (xkl)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Xan.a());
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Xan.a();
    Object localObject3 = null;
    String str = this.jdField_a_of_type_Xan.a.a("video_tag_info");
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Xbw = ((xbw)JsonORM.a(new JSONObject(str), xbw.class));
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Xbw != null)
      {
        if (this.jdField_a_of_type_Xbw.c != 0) {
          break label207;
        }
        localObject1 = localObject3;
        if (xkh.a(a()))
        {
          localObject1 = xkh.a(a(), this.jdField_a_of_type_Xbw.d);
          wxe.b("Q.qqstory.publish.edit.EditVideoMusic", "set the default music : music id = %s, success = %s", this.jdField_a_of_type_Xbw.d, localObject1);
        }
      }
      if (localObject1 != null)
      {
        bool = true;
        this.d = bool;
        if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
          break label329;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(6);
        i = 0;
        for (;;)
        {
          if (i >= 6) {
            break label329;
          }
          if (localObject1 == null) {
            break;
          }
          this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject1);
          i += 1;
        }
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        wxe.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      label207:
      Object localObject2;
      for (;;)
      {
        boolean bool;
        int i;
        wxe.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        if (this.jdField_a_of_type_Xbw.c == 1)
        {
          localObject2 = a(this.jdField_a_of_type_Xbw);
          wxe.b("Q.qqstory.publish.edit.EditVideoMusic", "set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Xbw.d, localObject2);
        }
        else
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Xbw.c == 2)
          {
            localObject2 = a(this.jdField_a_of_type_Xbw);
            wxe.b("Q.qqstory.publish.edit.EditVideoMusic", "from qzone topic, set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Xbw.d, localObject2);
            continue;
            bool = false;
            continue;
            if (this.jdField_a_of_type_Xan.a()) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, xkl.jdField_a_of_type_Xkl);
            } else {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, xkl.jdField_b_of_type_Xkl);
            }
          }
        }
      }
      label329:
      if ((localObject2 == null) && (this.jdField_a_of_type_Xan.a()))
      {
        a(xkl.jdField_a_of_type_Xkl);
        a(0);
      }
      a(wyg.class, this);
    }
  }
  
  public void a(int paramInt)
  {
    wxr localwxr = (wxr)a(wxr.class);
    if (localwxr != null)
    {
      if (paramInt == 0) {
        localwxr.a(2130846210);
      }
    }
    else {
      return;
    }
    if ((3 == paramInt) || (2 == paramInt))
    {
      localwxr.a(2130846209);
      return;
    }
    localwxr.a(2130846203);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, new Object[] { "doOnActivityResult selectMusic(), selected:", Boolean.valueOf(this.h), " data:", paramIntent });
      }
    } while (this.h);
    paramIntent = a();
    if ((paramIntent != null) && ((paramIntent.jdField_b_of_type_Int == 0) || (paramIntent.jdField_b_of_type_Int == 1))) {
      a().sendBroadcast(new Intent("action_music_refresh_list"));
    }
    k();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool3;
    switch (paramInt2)
    {
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    default: 
      return;
    case 2: 
      wxk.a("0X80076BB", wxk.jdField_b_of_type_Int);
      bool3 = paramObject instanceof xbw;
      paramObject = a(xbx.class);
      if (paramObject == null) {
        break;
      }
    }
    for (paramObject = ((xbx)paramObject).a(this.jdField_a_of_type_Xan.a());; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.a.jdField_a_of_type_Int == 1) {
          bool1 = true;
        }
      }
      paramObject = new EditVideoMusicDialog(a(), this, this.jdField_b_of_type_Boolean, (int)this.jdField_a_of_type_Xan.a(this.jdField_a_of_type_Xan.a()), this.jdField_a_of_type_Xan.a, bool3, bool1);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new xai(this));
      paramObject.setCancelable(true);
      paramObject.show();
      return;
      ae_();
      return;
      if ((this.jdField_b_of_type_Boolean) && (a() == null)) {
        a(0);
      }
      if (paramInt1 != 6) {
        break;
      }
      f();
      return;
    }
  }
  
  public void a(int paramInt, @NonNull xlb paramxlb)
  {
    super.a(paramInt, paramxlb);
    xkl localxkl = (xkl)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localxkl == null)
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a() instanceof AmrPlayer)) && (localxkl.d - 1000 > 0)) {
      localxkl.d -= 1000;
    }
    paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = localxkl.g;
    Object localObject1 = paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    if (localxkl.jdField_b_of_type_Int != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject1).isMuteRecordVoice = bool;
      paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicOffset = localxkl.d;
      paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicDuration = ((int)this.jdField_a_of_type_Xan.a(paramInt));
      if (!TextUtils.isEmpty(localxkl.g)) {
        wxe.d("Q.qqstory.publish.edit.EditVideoMusic", "pre publish music file exist:%b path:%s", new Object[] { Boolean.valueOf(xrg.b(localxkl.g)), localxkl.g });
      }
      switch (localxkl.jdField_b_of_type_Int)
      {
      default: 
        wxe.d("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    Object localObject2;
    if (localxkl.jdField_b_of_type_Int == 2)
    {
      localObject1 = "1";
      xan localxan = this.jdField_a_of_type_Xan;
      paramInt = this.jdField_a_of_type_Xan.b();
      String str = localxkl.jdField_b_of_type_JavaLangString;
      if (!this.jdField_b_of_type_Boolean) {
        break label427;
      }
      localObject2 = "2";
      label302:
      localxan.b("pub_music", paramInt, 0, new String[] { localObject1, str, localObject2 });
      if (!((String)localObject1).equals("1")) {
        break label435;
      }
      localObject1 = "0X80076E6";
      label347:
      wxk.a((String)localObject1, String.valueOf(wxk.jdField_b_of_type_Int), "", localxkl.jdField_b_of_type_JavaLangString, "");
      localObject2 = new TribeVideoPublishParams.Music();
      ((TribeVideoPublishParams.Music)localObject2).name = localxkl.jdField_b_of_type_JavaLangString;
      if (localxkl.jdField_b_of_type_Int != 3) {
        break label443;
      }
    }
    label427:
    label435:
    label443:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((TribeVideoPublishParams.Music)localObject2).type = ((String)localObject1);
      paramxlb.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.music = ((TribeVideoPublishParams.Music)localObject2);
      return;
      localObject1 = "2";
      break;
      localObject2 = "1";
      break label302;
      localObject1 = "0X80076E5";
      break label347;
    }
    this.jdField_a_of_type_Xan.b("sound_off", this.jdField_a_of_type_Xan.b(), 0, new String[0]);
    wxk.a("0X80076E7", wxk.jdField_b_of_type_Int);
    paramxlb.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = false;
    return;
    this.jdField_a_of_type_Xan.b("sound_on", this.jdField_a_of_type_Xan.b(), 0, new String[0]);
    wxk.a("0X80076E8");
    paramxlb.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = true;
    return;
    paramxlb = new Properties();
    paramxlb.setProperty("bless_param_voice_id", "" + localxkl.c);
    ahct.a("bless_event_voice_result", paramxlb);
  }
  
  public void a(AudioPlayer paramAudioPlayer) {}
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void a(String paramString)
  {
    xkl localxkl = a();
    if (localxkl != null)
    {
      localxkl.g = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        wxe.d("Q.qqstory.publish.edit.EditVideoMusic", "music file exist:%b path:%s", new Object[] { Boolean.valueOf(xrg.b(paramString)), paramString });
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xan.a(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void a(xbv paramxbv)
  {
    xkl localxkl = a();
    if (localxkl == null)
    {
      paramxbv.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localxkl.jdField_b_of_type_Int != 2) && (localxkl.jdField_b_of_type_Int != 3))
    {
      paramxbv.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localxkl.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      try
      {
        paramxbv.jdField_a_of_type_Long = Long.valueOf(localxkl.jdField_a_of_type_JavaLangString).longValue();
        paramxbv.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        wxe.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localxkl.jdField_b_of_type_JavaLangString, localxkl.jdField_a_of_type_JavaLangString });
        paramxbv.jdField_a_of_type_Boolean = false;
      }
      paramxbv.jdField_a_of_type_Int = 0;
      continue;
      paramxbv.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(xkl paramxkl)
  {
    xkl localxkl = null;
    if (paramxkl != null)
    {
      localxkl = new xkl();
      localxkl.a(paramxkl);
      if (paramxkl.jdField_b_of_type_Int != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Xan.a(), localxkl);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    m();
  }
  
  public boolean a(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    xkl localxkl;
    label97:
    xaz localxaz;
    do
    {
      do
      {
        for (;;)
        {
          return super.a(paramMessage);
          this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoMusic.2(this));
        }
      } while (paramMessage.arg1 != 32);
      n();
      return true;
      localxkl = a();
      if (localxkl == null) {
        break;
      }
      a(localxkl.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "Message change fragment()");
      }
      if ((xkl.jdField_a_of_type_Xkl.equals(localxkl)) || (xkl.jdField_b_of_type_Xkl.equals(localxkl))) {
        i();
      }
      localxaz = (xaz)a(xaz.class);
    } while (localxaz == null);
    if (!xkl.jdField_b_of_type_Xkl.equals(localxkl)) {}
    for (;;)
    {
      localxaz.a(bool);
      break;
      a(1);
      break label97;
      bool = false;
    }
  }
  
  public void aa_()
  {
    super.aa_();
    this.jdField_a_of_type_Boolean = true;
    m();
  }
  
  public void ae_()
  {
    if (this.jdField_b_of_type_Boolean) {
      i();
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()));
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "pauseClipMusic()");
  }
  
  public void b()
  {
    b(-1);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "playBgMusic()");
    }
    xkl localxkl = a();
    if ((!this.jdField_a_of_type_Boolean) || (this.e) || (localxkl == null))
    {
      wxe.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    i();
    if (this.jdField_a_of_type_Xan.jdField_b_of_type_Int == 6)
    {
      wxe.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, edit face, return");
      return;
    }
    if ((TextUtils.isEmpty(localxkl.g)) || (localxkl.jdField_b_of_type_Int == 0) || (localxkl.jdField_b_of_type_Int == 1))
    {
      wxe.a("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, music path:%s, type:%d", localxkl.g, Integer.valueOf(localxkl.jdField_b_of_type_Int));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new EditVideoMusic.3(this, a(), this, localxkl);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    if (paramInt >= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localxkl.g, paramInt);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic$TakePhotoMusicTimerTask = new EditVideoMusic.TakePhotoMusicTimerTask(this, null);
        this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic$TakePhotoMusicTimerTask, 5000L, 5000L);
      }
      a().sendBroadcast(new Intent("action_music_start"));
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localxkl.g, localxkl.d);
    }
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Xbw == null) {}
    while (this.jdField_a_of_type_Xbw.c != 2) {
      return true;
    }
    return false;
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void d()
  {
    super.d();
    a(1);
    i();
  }
  
  public void d(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void f()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      b();
      return;
    }
    b(this.jdField_a_of_type_Int);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Xbw = null;
    this.d = false;
    xam localxam = a(xbx.class);
    if (localxam != null) {
      ((xbx)localxam).a(this.jdField_a_of_type_Xan.a());
    }
  }
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_Boolean = false;
    i();
    if (this.jdField_b_of_type_Int > 0) {
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_b_of_type_Int, 0);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic$TakePhotoMusicTimerTask != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic$TakePhotoMusicTimerTask.cancel();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic$TakePhotoMusicTimerTask = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "stopClipMusic()");
      }
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_Xan.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void k()
  {
    this.jdField_a_of_type_Xan.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void l()
  {
    this.jdField_a_of_type_Xan.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */