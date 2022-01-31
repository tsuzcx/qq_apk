package com.tencent.biz.qqstory.takevideo;

import acjg;
import aeqf;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import bbmy;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.Music;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import urk;
import urq;
import urx;
import usm;
import uuo;
import uup;
import uur;
import uus;
import uut;
import uvf;
import uwb;
import uwc;
import uwd;
import ven;
import ver;
import vfh;
import vik;
import vil;
import vlm;

public class EditVideoMusic
  extends uur
  implements acjg, usm
{
  int jdField_a_of_type_Int = 0;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public SparseArray<ver> a;
  protected EditVideoMusic.TakePhotoMusicTimerTask a;
  protected AudioPlayer a;
  public ArrayList<ver> a;
  protected Timer a;
  uwc jdField_a_of_type_Uwc;
  protected boolean a;
  private int b;
  protected boolean b;
  boolean c = false;
  boolean d = false;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public EditVideoMusic(@NonNull uut paramuut)
  {
    super(paramuut);
    this.jdField_a_of_type_AndroidOsHandler = new uup(this);
  }
  
  private ver a(uwc paramuwc)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramuwc.e);
      localJSONObject.put("audio_url", paramuwc.f);
      localJSONObject.put("type", 2);
      localJSONObject.put("id", paramuwc.d);
      return new ver(localJSONObject.toString());
    }
    catch (JSONException paramuwc)
    {
      for (;;)
      {
        paramuwc.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if (this.f) {
      return;
    }
    Object localObject = a();
    if ((localObject == null) || (((ver)localObject).equals(ver.jdField_b_of_type_Ver)))
    {
      localObject = (uvf)this.jdField_a_of_type_Uut.a(uvf.class);
      if (localObject != null) {
        ((uvf)localObject).a(this.e);
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
      bbmy.a(a(), "GIF不支持添加音乐", 0).a();
      return;
    }
    this.jdField_a_of_type_Uut.a(2);
  }
  
  public void X_()
  {
    super.X_();
    this.jdField_a_of_type_Boolean = true;
    m();
  }
  
  public ver a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (ver)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Uut.a());
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Uut.a();
    Object localObject3 = null;
    String str = this.jdField_a_of_type_Uut.a.a("video_tag_info");
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Uwc = ((uwc)JsonORM.a(new JSONObject(str), uwc.class));
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Uwc != null)
      {
        if (this.jdField_a_of_type_Uwc.c != 0) {
          break label207;
        }
        localObject1 = localObject3;
        if (ven.a(a()))
        {
          localObject1 = ven.a(a(), this.jdField_a_of_type_Uwc.d);
          urk.b("Q.qqstory.publish.edit.EditVideoMusic", "set the default music : music id = %s, success = %s", this.jdField_a_of_type_Uwc.d, localObject1);
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
        urk.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JsonParseException", localJsonParseException);
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
        urk.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        if (this.jdField_a_of_type_Uwc.c == 1)
        {
          localObject2 = a(this.jdField_a_of_type_Uwc);
          urk.b("Q.qqstory.publish.edit.EditVideoMusic", "set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Uwc.d, localObject2);
        }
        else
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Uwc.c == 2)
          {
            localObject2 = a(this.jdField_a_of_type_Uwc);
            urk.b("Q.qqstory.publish.edit.EditVideoMusic", "from qzone topic, set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Uwc.d, localObject2);
            continue;
            bool = false;
            continue;
            if (this.jdField_a_of_type_Uut.a()) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, ver.jdField_a_of_type_Ver);
            } else {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, ver.jdField_b_of_type_Ver);
            }
          }
        }
      }
      label329:
      if ((localObject2 == null) && (this.jdField_a_of_type_Uut.a()))
      {
        a(ver.jdField_a_of_type_Ver);
        a(0);
      }
      a(usm.class, this);
    }
  }
  
  public void a(int paramInt)
  {
    urx localurx = (urx)a(urx.class);
    if (localurx != null)
    {
      if (paramInt == 0) {
        localurx.a(2130845569);
      }
    }
    else {
      return;
    }
    if ((3 == paramInt) || (2 == paramInt))
    {
      localurx.a(2130845568);
      return;
    }
    localurx.a(2130845562);
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
      urq.a("0X80076BB", urq.jdField_b_of_type_Int);
      bool3 = paramObject instanceof uwc;
      paramObject = a(uwd.class);
      if (paramObject == null) {
        break;
      }
    }
    for (paramObject = ((uwd)paramObject).a(this.jdField_a_of_type_Uut.a());; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.a.jdField_a_of_type_Int == 1) {
          bool1 = true;
        }
      }
      paramObject = new EditVideoMusicDialog(a(), this, this.jdField_b_of_type_Boolean, (int)this.jdField_a_of_type_Uut.a(this.jdField_a_of_type_Uut.a()), this.jdField_a_of_type_Uut.a, bool3, bool1);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new uuo(this));
      paramObject.setCancelable(true);
      paramObject.show();
      return;
      ab_();
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
  
  public void a(int paramInt, @NonNull vfh paramvfh)
  {
    super.a(paramInt, paramvfh);
    ver localver = (ver)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localver == null)
    {
      urk.d("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a() instanceof AmrPlayer)) && (localver.d - 1000 > 0)) {
      localver.d -= 1000;
    }
    paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = localver.g;
    Object localObject1 = paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    if (localver.jdField_b_of_type_Int != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject1).isMuteRecordVoice = bool;
      paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicOffset = localver.d;
      paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicDuration = ((int)this.jdField_a_of_type_Uut.a(paramInt));
      if (!TextUtils.isEmpty(localver.g)) {
        urk.d("Q.qqstory.publish.edit.EditVideoMusic", "pre publish music file exist:%b path:%s", new Object[] { Boolean.valueOf(vlm.b(localver.g)), localver.g });
      }
      switch (localver.jdField_b_of_type_Int)
      {
      default: 
        urk.d("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    Object localObject2;
    if (localver.jdField_b_of_type_Int == 2)
    {
      localObject1 = "1";
      uut localuut = this.jdField_a_of_type_Uut;
      paramInt = this.jdField_a_of_type_Uut.b();
      String str = localver.jdField_b_of_type_JavaLangString;
      if (!this.jdField_b_of_type_Boolean) {
        break label427;
      }
      localObject2 = "2";
      label302:
      localuut.b("pub_music", paramInt, 0, new String[] { localObject1, str, localObject2 });
      if (!((String)localObject1).equals("1")) {
        break label435;
      }
      localObject1 = "0X80076E6";
      label347:
      urq.a((String)localObject1, String.valueOf(urq.jdField_b_of_type_Int), "", localver.jdField_b_of_type_JavaLangString, "");
      localObject2 = new TribeVideoPublishParams.Music();
      ((TribeVideoPublishParams.Music)localObject2).name = localver.jdField_b_of_type_JavaLangString;
      if (localver.jdField_b_of_type_Int != 3) {
        break label443;
      }
    }
    label427:
    label435:
    label443:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((TribeVideoPublishParams.Music)localObject2).type = ((String)localObject1);
      paramvfh.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.music = ((TribeVideoPublishParams.Music)localObject2);
      return;
      localObject1 = "2";
      break;
      localObject2 = "1";
      break label302;
      localObject1 = "0X80076E5";
      break label347;
    }
    this.jdField_a_of_type_Uut.b("sound_off", this.jdField_a_of_type_Uut.b(), 0, new String[0]);
    urq.a("0X80076E7", urq.jdField_b_of_type_Int);
    paramvfh.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = false;
    return;
    this.jdField_a_of_type_Uut.b("sound_on", this.jdField_a_of_type_Uut.b(), 0, new String[0]);
    urq.a("0X80076E8");
    paramvfh.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = true;
    return;
    paramvfh = new Properties();
    paramvfh.setProperty("bless_param_voice_id", "" + localver.c);
    aeqf.a("bless_event_voice_result", paramvfh);
  }
  
  public void a(AudioPlayer paramAudioPlayer) {}
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void a(String paramString)
  {
    ver localver = a();
    if (localver != null)
    {
      localver.g = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        urk.d("Q.qqstory.publish.edit.EditVideoMusic", "music file exist:%b path:%s", new Object[] { Boolean.valueOf(vlm.b(paramString)), paramString });
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Uut.a(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void a(uwb paramuwb)
  {
    ver localver = a();
    if (localver == null)
    {
      paramuwb.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localver.jdField_b_of_type_Int != 2) && (localver.jdField_b_of_type_Int != 3))
    {
      paramuwb.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localver.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      try
      {
        paramuwb.jdField_a_of_type_Long = Long.valueOf(localver.jdField_a_of_type_JavaLangString).longValue();
        paramuwb.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        urk.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localver.jdField_b_of_type_JavaLangString, localver.jdField_a_of_type_JavaLangString });
        paramuwb.jdField_a_of_type_Boolean = false;
      }
      paramuwb.jdField_a_of_type_Int = 0;
      continue;
      paramuwb.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(ver paramver)
  {
    ver localver = null;
    if (paramver != null)
    {
      localver = new ver();
      localver.a(paramver);
      if (paramver.jdField_b_of_type_Int != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Uut.a(), localver);
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
    ver localver;
    label97:
    uvf localuvf;
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
      localver = a();
      if (localver == null) {
        break;
      }
      a(localver.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "Message change fragment()");
      }
      if ((ver.jdField_a_of_type_Ver.equals(localver)) || (ver.jdField_b_of_type_Ver.equals(localver))) {
        i();
      }
      localuvf = (uvf)a(uvf.class);
    } while (localuvf == null);
    if (!ver.jdField_b_of_type_Ver.equals(localver)) {}
    for (;;)
    {
      localuvf.a(bool);
      break;
      a(1);
      break label97;
      bool = false;
    }
  }
  
  public void ab_()
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
    ver localver = a();
    if ((!this.jdField_a_of_type_Boolean) || (this.e) || (localver == null))
    {
      urk.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    i();
    if (this.jdField_a_of_type_Uut.jdField_b_of_type_Int == 6)
    {
      urk.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, edit face, return");
      return;
    }
    if ((TextUtils.isEmpty(localver.g)) || (localver.jdField_b_of_type_Int == 0) || (localver.jdField_b_of_type_Int == 1))
    {
      urk.a("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, music path:%s, type:%d", localver.g, Integer.valueOf(localver.jdField_b_of_type_Int));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new EditVideoMusic.3(this, a(), this, localver);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    if (paramInt >= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localver.g, paramInt);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localver.g, localver.d);
    }
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Uwc == null) {}
    while (this.jdField_a_of_type_Uwc.c != 2) {
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
    this.jdField_a_of_type_Uwc = null;
    this.d = false;
    uus localuus = a(uwd.class);
    if (localuus != null) {
      ((uwd)localuus).a(this.jdField_a_of_type_Uut.a());
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
    this.jdField_a_of_type_Uut.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void k()
  {
    this.jdField_a_of_type_Uut.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void l()
  {
    this.jdField_a_of_type_Uut.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */