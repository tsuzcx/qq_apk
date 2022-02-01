package com.tencent.biz.qqstory.takevideo;

import afwa;
import aipg;
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
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
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
import yqp;
import yqv;
import yrc;
import yrr;
import ytt;
import ytu;
import ytw;
import ytx;
import yty;
import yuk;
import yvg;
import yvh;
import yvi;
import zds;
import zdw;
import zem;
import zhp;
import zhq;
import zkr;

public class EditVideoMusic
  extends ytw
  implements afwa, yrr
{
  int jdField_a_of_type_Int = 0;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public SparseArray<zdw> a;
  protected EditVideoMusic.TakePhotoMusicTimerTask a;
  protected AudioPlayer a;
  public ArrayList<zdw> a;
  protected Timer a;
  yvh jdField_a_of_type_Yvh;
  protected boolean a;
  private int b;
  protected boolean b;
  boolean c = false;
  boolean d = false;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public EditVideoMusic(@NonNull yty paramyty)
  {
    super(paramyty);
    this.jdField_a_of_type_AndroidOsHandler = new ytu(this);
  }
  
  private zdw a(yvh paramyvh)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramyvh.e);
      localJSONObject.put("audio_url", paramyvh.f);
      localJSONObject.put("type", 2);
      localJSONObject.put("id", paramyvh.d);
      return new zdw(localJSONObject.toString());
    }
    catch (JSONException paramyvh)
    {
      for (;;)
      {
        paramyvh.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if (this.f) {
      return;
    }
    Object localObject = a();
    if ((localObject == null) || (((zdw)localObject).equals(zdw.jdField_b_of_type_Zdw)))
    {
      localObject = (yuk)this.jdField_a_of_type_Yty.a(yuk.class);
      if (localObject != null) {
        ((yuk)localObject).a(this.e);
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
    this.jdField_a_of_type_Yty.a(2);
  }
  
  public void W_()
  {
    super.W_();
    this.jdField_a_of_type_Boolean = true;
    m();
  }
  
  public zdw a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (zdw)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Yty.a());
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Yty.a();
    Object localObject3 = null;
    String str = this.jdField_a_of_type_Yty.a.a("video_tag_info");
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Yvh = ((yvh)JsonORM.a(new JSONObject(str), yvh.class));
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Yvh != null)
      {
        if (this.jdField_a_of_type_Yvh.c != 0) {
          break label207;
        }
        localObject1 = localObject3;
        if (zds.a(a()))
        {
          localObject1 = zds.a(a(), this.jdField_a_of_type_Yvh.d);
          yqp.b("Q.qqstory.publish.edit.EditVideoMusic", "set the default music : music id = %s, success = %s", this.jdField_a_of_type_Yvh.d, localObject1);
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
        yqp.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JsonParseException", localJsonParseException);
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
        yqp.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        if (this.jdField_a_of_type_Yvh.c == 1)
        {
          localObject2 = a(this.jdField_a_of_type_Yvh);
          yqp.b("Q.qqstory.publish.edit.EditVideoMusic", "set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Yvh.d, localObject2);
        }
        else
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Yvh.c == 2)
          {
            localObject2 = a(this.jdField_a_of_type_Yvh);
            yqp.b("Q.qqstory.publish.edit.EditVideoMusic", "from qzone topic, set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Yvh.d, localObject2);
            continue;
            bool = false;
            continue;
            if (this.jdField_a_of_type_Yty.a()) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, zdw.jdField_a_of_type_Zdw);
            } else {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, zdw.jdField_b_of_type_Zdw);
            }
          }
        }
      }
      label329:
      if ((localObject2 == null) && (this.jdField_a_of_type_Yty.a()))
      {
        a(zdw.jdField_a_of_type_Zdw);
        a(0);
      }
      a(yrr.class, this);
    }
  }
  
  public void a(int paramInt)
  {
    yrc localyrc = (yrc)a(yrc.class);
    if (localyrc != null)
    {
      if (paramInt == 0) {
        localyrc.a(2130846649);
      }
    }
    else {
      return;
    }
    if ((3 == paramInt) || (2 == paramInt))
    {
      localyrc.a(2130846648);
      return;
    }
    localyrc.a(2130846642);
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
      yqv.a("0X80076BB", yqv.jdField_b_of_type_Int);
      bool3 = paramObject instanceof yvh;
      paramObject = a(yvi.class);
      if (paramObject == null) {
        break;
      }
    }
    for (paramObject = ((yvi)paramObject).a(this.jdField_a_of_type_Yty.a());; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.a.jdField_a_of_type_Int == 1) {
          bool1 = true;
        }
      }
      paramObject = new EditVideoMusicDialog(a(), this, this.jdField_b_of_type_Boolean, (int)this.jdField_a_of_type_Yty.a(this.jdField_a_of_type_Yty.a()), this.jdField_a_of_type_Yty.a, bool3, bool1);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new ytt(this));
      paramObject.setCancelable(true);
      paramObject.show();
      return;
      aa_();
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
  
  public void a(int paramInt, @NonNull zem paramzem)
  {
    super.a(paramInt, paramzem);
    zdw localzdw = (zdw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localzdw == null)
    {
      yqp.d("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a() instanceof AmrPlayer)) && (localzdw.d - 1000 > 0)) {
      localzdw.d -= 1000;
    }
    paramzem.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = localzdw.g;
    Object localObject1 = paramzem.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    if (localzdw.jdField_b_of_type_Int != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject1).isMuteRecordVoice = bool;
      paramzem.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicOffset = localzdw.d;
      paramzem.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicDuration = ((int)this.jdField_a_of_type_Yty.a(paramInt));
      if (!TextUtils.isEmpty(localzdw.g)) {
        yqp.d("Q.qqstory.publish.edit.EditVideoMusic", "pre publish music file exist:%b path:%s", new Object[] { Boolean.valueOf(zkr.b(localzdw.g)), localzdw.g });
      }
      switch (localzdw.jdField_b_of_type_Int)
      {
      default: 
        yqp.d("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    Object localObject2;
    if (localzdw.jdField_b_of_type_Int == 2)
    {
      localObject1 = "1";
      yty localyty = this.jdField_a_of_type_Yty;
      paramInt = this.jdField_a_of_type_Yty.b();
      String str = localzdw.jdField_b_of_type_JavaLangString;
      if (!this.jdField_b_of_type_Boolean) {
        break label427;
      }
      localObject2 = "2";
      label302:
      localyty.b("pub_music", paramInt, 0, new String[] { localObject1, str, localObject2 });
      if (!((String)localObject1).equals("1")) {
        break label435;
      }
      localObject1 = "0X80076E6";
      label347:
      yqv.a((String)localObject1, String.valueOf(yqv.jdField_b_of_type_Int), "", localzdw.jdField_b_of_type_JavaLangString, "");
      localObject2 = new TribeVideoPublishParams.Music();
      ((TribeVideoPublishParams.Music)localObject2).name = localzdw.jdField_b_of_type_JavaLangString;
      if (localzdw.jdField_b_of_type_Int != 3) {
        break label443;
      }
    }
    label427:
    label435:
    label443:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((TribeVideoPublishParams.Music)localObject2).type = ((String)localObject1);
      paramzem.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.music = ((TribeVideoPublishParams.Music)localObject2);
      return;
      localObject1 = "2";
      break;
      localObject2 = "1";
      break label302;
      localObject1 = "0X80076E5";
      break label347;
    }
    this.jdField_a_of_type_Yty.b("sound_off", this.jdField_a_of_type_Yty.b(), 0, new String[0]);
    yqv.a("0X80076E7", yqv.jdField_b_of_type_Int);
    paramzem.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = false;
    return;
    this.jdField_a_of_type_Yty.b("sound_on", this.jdField_a_of_type_Yty.b(), 0, new String[0]);
    yqv.a("0X80076E8");
    paramzem.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = true;
    return;
    paramzem = new Properties();
    paramzem.setProperty("bless_param_voice_id", "" + localzdw.c);
    aipg.a("bless_event_voice_result", paramzem);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void a(String paramString)
  {
    zdw localzdw = a();
    if (localzdw != null)
    {
      localzdw.g = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        yqp.d("Q.qqstory.publish.edit.EditVideoMusic", "music file exist:%b path:%s", new Object[] { Boolean.valueOf(zkr.b(paramString)), paramString });
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Yty.a(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void a(yvg paramyvg)
  {
    zdw localzdw = a();
    if (localzdw == null)
    {
      paramyvg.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localzdw.jdField_b_of_type_Int != 2) && (localzdw.jdField_b_of_type_Int != 3))
    {
      paramyvg.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localzdw.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      try
      {
        paramyvg.jdField_a_of_type_Long = Long.valueOf(localzdw.jdField_a_of_type_JavaLangString).longValue();
        paramyvg.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        yqp.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localzdw.jdField_b_of_type_JavaLangString, localzdw.jdField_a_of_type_JavaLangString });
        paramyvg.jdField_a_of_type_Boolean = false;
      }
      paramyvg.jdField_a_of_type_Int = 0;
      continue;
      paramyvg.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(zdw paramzdw)
  {
    zdw localzdw = null;
    if (paramzdw != null)
    {
      localzdw = new zdw();
      localzdw.a(paramzdw);
      if (paramzdw.jdField_b_of_type_Int != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Yty.a(), localzdw);
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
    zdw localzdw;
    label97:
    yuk localyuk;
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
      localzdw = a();
      if (localzdw == null) {
        break;
      }
      a(localzdw.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "Message change fragment()");
      }
      if ((zdw.jdField_a_of_type_Zdw.equals(localzdw)) || (zdw.jdField_b_of_type_Zdw.equals(localzdw))) {
        i();
      }
      localyuk = (yuk)a(yuk.class);
    } while (localyuk == null);
    if (!zdw.jdField_b_of_type_Zdw.equals(localzdw)) {}
    for (;;)
    {
      localyuk.a(bool);
      break;
      a(1);
      break label97;
      bool = false;
    }
  }
  
  public void aa_()
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
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
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
    zdw localzdw = a();
    if ((!this.jdField_a_of_type_Boolean) || (this.e) || (localzdw == null))
    {
      yqp.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    i();
    if (this.jdField_a_of_type_Yty.jdField_b_of_type_Int == 6)
    {
      yqp.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, edit face, return");
      return;
    }
    if ((TextUtils.isEmpty(localzdw.g)) || (localzdw.jdField_b_of_type_Int == 0) || (localzdw.jdField_b_of_type_Int == 1))
    {
      yqp.a("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, music path:%s, type:%d", localzdw.g, Integer.valueOf(localzdw.jdField_b_of_type_Int));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new EditVideoMusic.3(this, a(), this, localzdw);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    if (paramInt >= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(localzdw.g, paramInt);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(localzdw.g, localzdw.d);
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Yvh == null) {}
    while (this.jdField_a_of_type_Yvh.c != 2) {
      return true;
    }
    return false;
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
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
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
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
    this.jdField_a_of_type_Yvh = null;
    this.d = false;
    ytx localytx = a(yvi.class);
    if (localytx != null) {
      ((yvi)localytx).a(this.jdField_a_of_type_Yty.a());
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
    this.jdField_a_of_type_Yty.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void k()
  {
    this.jdField_a_of_type_Yty.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void l()
  {
    this.jdField_a_of_type_Yty.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */