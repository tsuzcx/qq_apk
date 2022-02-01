package com.tencent.biz.qqstory.takevideo;

import aeyl;
import ahuz;
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
import xvv;
import xwb;
import xwi;
import xwx;
import xyz;
import xza;
import xzb;
import xzc;
import xzd;
import xzp;
import yak;
import yal;
import yam;
import yin;
import yir;
import yjh;
import ymk;
import yml;
import ypi;

public class EditVideoMusic
  extends xzb
  implements aeyl, xwx
{
  int jdField_a_of_type_Int = 0;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public SparseArray<yir> a;
  protected EditVideoMusic.TakePhotoMusicTimerTask a;
  protected AudioPlayer a;
  public ArrayList<yir> a;
  protected Timer a;
  yal jdField_a_of_type_Yal;
  protected boolean a;
  private int b;
  protected boolean b;
  boolean c = false;
  boolean d = false;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public EditVideoMusic(@NonNull xzd paramxzd)
  {
    super(paramxzd);
    this.jdField_a_of_type_AndroidOsHandler = new xza(this);
  }
  
  private yir a(yal paramyal)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramyal.e);
      localJSONObject.put("audio_url", paramyal.f);
      localJSONObject.put("type", 2);
      localJSONObject.put("id", paramyal.d);
      return new yir(localJSONObject.toString());
    }
    catch (JSONException paramyal)
    {
      for (;;)
      {
        paramyal.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if (this.f) {
      return;
    }
    Object localObject = a();
    if ((localObject == null) || (((yir)localObject).equals(yir.jdField_b_of_type_Yir)))
    {
      localObject = (xzp)this.jdField_a_of_type_Xzd.a(xzp.class);
      if (localObject != null) {
        ((xzp)localObject).a(this.e);
      }
      VideoSourceHelper.nativeSetPlayAFMute(this.e);
      return;
    }
    if (this.e)
    {
      i();
      return;
    }
    g();
  }
  
  private void n()
  {
    if (this.g)
    {
      QQToast.a(a(), "GIF不支持添加音乐", 0).a();
      return;
    }
    this.jdField_a_of_type_Xzd.a(2);
  }
  
  public void Q_()
  {
    super.Q_();
    this.jdField_a_of_type_Boolean = true;
    m();
  }
  
  public void T_()
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
  
  public yir a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (yir)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Xzd.a());
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Xzd.a();
    Object localObject3 = null;
    String str = this.jdField_a_of_type_Xzd.a.getStringExtra("video_tag_info");
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Yal = ((yal)JsonORM.a(new JSONObject(str), yal.class));
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Yal != null)
      {
        if (this.jdField_a_of_type_Yal.c != 0) {
          break label207;
        }
        localObject1 = localObject3;
        if (yin.a(a()))
        {
          localObject1 = yin.a(a(), this.jdField_a_of_type_Yal.d);
          xvv.b("Q.qqstory.publish.edit.EditVideoMusic", "set the default music : music id = %s, success = %s", this.jdField_a_of_type_Yal.d, localObject1);
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
        xvv.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JsonParseException", localJsonParseException);
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
        xvv.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        if (this.jdField_a_of_type_Yal.c == 1)
        {
          localObject2 = a(this.jdField_a_of_type_Yal);
          xvv.b("Q.qqstory.publish.edit.EditVideoMusic", "set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Yal.d, localObject2);
        }
        else
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Yal.c == 2)
          {
            localObject2 = a(this.jdField_a_of_type_Yal);
            xvv.b("Q.qqstory.publish.edit.EditVideoMusic", "from qzone topic, set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Yal.d, localObject2);
            continue;
            bool = false;
            continue;
            if (this.jdField_a_of_type_Xzd.a()) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, yir.jdField_a_of_type_Yir);
            } else {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, yir.jdField_b_of_type_Yir);
            }
          }
        }
      }
      label329:
      if ((localObject2 == null) && (this.jdField_a_of_type_Xzd.a()))
      {
        a(yir.jdField_a_of_type_Yir);
        a(0);
      }
      a(xwx.class, this);
    }
  }
  
  public void a(int paramInt)
  {
    xwi localxwi = (xwi)a(xwi.class);
    if (localxwi != null)
    {
      if (paramInt == 0) {
        localxwi.a(2130846574);
      }
    }
    else {
      return;
    }
    if ((3 == paramInt) || (2 == paramInt))
    {
      localxwi.a(2130846573);
      return;
    }
    localxwi.a(2130846567);
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
      xwb.a("0X80076BB", xwb.jdField_b_of_type_Int);
      bool3 = paramObject instanceof yal;
      paramObject = a(yam.class);
      if (paramObject == null) {
        break;
      }
    }
    for (paramObject = ((yam)paramObject).a(this.jdField_a_of_type_Xzd.a());; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.a.jdField_a_of_type_Int == 1) {
          bool1 = true;
        }
      }
      paramObject = new EditVideoMusicDialog(a(), this, this.jdField_b_of_type_Boolean, (int)this.jdField_a_of_type_Xzd.a(this.jdField_a_of_type_Xzd.a()), this.jdField_a_of_type_Xzd.a, bool3, bool1);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new xyz(this));
      paramObject.setCancelable(true);
      paramObject.show();
      return;
      T_();
      return;
      if ((this.jdField_b_of_type_Boolean) && (a() == null)) {
        a(0);
      }
      if (paramInt1 != 6) {
        break;
      }
      g();
      return;
    }
  }
  
  public void a(int paramInt, @NonNull yjh paramyjh)
  {
    super.a(paramInt, paramyjh);
    yir localyir = (yir)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localyir == null)
    {
      xvv.d("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a() instanceof AmrPlayer)) && (localyir.d - 1000 > 0)) {
      localyir.d -= 1000;
    }
    paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = localyir.g;
    Object localObject1 = paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    if (localyir.jdField_b_of_type_Int != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject1).isMuteRecordVoice = bool;
      paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicOffset = localyir.d;
      paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicDuration = ((int)this.jdField_a_of_type_Xzd.a(paramInt));
      if (!TextUtils.isEmpty(localyir.g)) {
        xvv.d("Q.qqstory.publish.edit.EditVideoMusic", "pre publish music file exist:%b path:%s", new Object[] { Boolean.valueOf(ypi.b(localyir.g)), localyir.g });
      }
      switch (localyir.jdField_b_of_type_Int)
      {
      default: 
        xvv.d("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    Object localObject2;
    if (localyir.jdField_b_of_type_Int == 2)
    {
      localObject1 = "1";
      xzd localxzd = this.jdField_a_of_type_Xzd;
      paramInt = this.jdField_a_of_type_Xzd.b();
      String str = localyir.jdField_b_of_type_JavaLangString;
      if (!this.jdField_b_of_type_Boolean) {
        break label427;
      }
      localObject2 = "2";
      label302:
      localxzd.b("pub_music", paramInt, 0, new String[] { localObject1, str, localObject2 });
      if (!((String)localObject1).equals("1")) {
        break label435;
      }
      localObject1 = "0X80076E6";
      label347:
      xwb.a((String)localObject1, String.valueOf(xwb.jdField_b_of_type_Int), "", localyir.jdField_b_of_type_JavaLangString, "");
      localObject2 = new TribeVideoPublishParams.Music();
      ((TribeVideoPublishParams.Music)localObject2).name = localyir.jdField_b_of_type_JavaLangString;
      if (localyir.jdField_b_of_type_Int != 3) {
        break label443;
      }
    }
    label427:
    label435:
    label443:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((TribeVideoPublishParams.Music)localObject2).type = ((String)localObject1);
      paramyjh.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.music = ((TribeVideoPublishParams.Music)localObject2);
      return;
      localObject1 = "2";
      break;
      localObject2 = "1";
      break label302;
      localObject1 = "0X80076E5";
      break label347;
    }
    this.jdField_a_of_type_Xzd.b("sound_off", this.jdField_a_of_type_Xzd.b(), 0, new String[0]);
    xwb.a("0X80076E7", xwb.jdField_b_of_type_Int);
    paramyjh.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = false;
    return;
    this.jdField_a_of_type_Xzd.b("sound_on", this.jdField_a_of_type_Xzd.b(), 0, new String[0]);
    xwb.a("0X80076E8");
    paramyjh.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = true;
    return;
    paramyjh = new Properties();
    paramyjh.setProperty("bless_param_voice_id", "" + localyir.c);
    ahuz.a("bless_event_voice_result", paramyjh);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void a(String paramString)
  {
    yir localyir = a();
    if (localyir != null)
    {
      localyir.g = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        xvv.d("Q.qqstory.publish.edit.EditVideoMusic", "music file exist:%b path:%s", new Object[] { Boolean.valueOf(ypi.b(paramString)), paramString });
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xzd.a(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void a(yak paramyak)
  {
    yir localyir = a();
    if (localyir == null)
    {
      paramyak.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localyir.jdField_b_of_type_Int != 2) && (localyir.jdField_b_of_type_Int != 3))
    {
      paramyak.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localyir.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      try
      {
        paramyak.jdField_a_of_type_Long = Long.valueOf(localyir.jdField_a_of_type_JavaLangString).longValue();
        paramyak.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        xvv.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localyir.jdField_b_of_type_JavaLangString, localyir.jdField_a_of_type_JavaLangString });
        paramyak.jdField_a_of_type_Boolean = false;
      }
      paramyak.jdField_a_of_type_Int = 0;
      continue;
      paramyak.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(yir paramyir)
  {
    yir localyir = null;
    if (paramyir != null)
    {
      localyir = new yir();
      localyir.a(paramyir);
      if (paramyir.jdField_b_of_type_Int != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Xzd.a(), localyir);
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
    yir localyir;
    label97:
    xzp localxzp;
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
      localyir = a();
      if (localyir == null) {
        break;
      }
      a(localyir.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "Message change fragment()");
      }
      if ((yir.jdField_a_of_type_Yir.equals(localyir)) || (yir.jdField_b_of_type_Yir.equals(localyir))) {
        i();
      }
      localxzp = (xzp)a(xzp.class);
    } while (localxzp == null);
    if (!yir.jdField_b_of_type_Yir.equals(localyir)) {}
    for (;;)
    {
      localxzp.a(bool);
      break;
      a(1);
      break label97;
      bool = false;
    }
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
    yir localyir = a();
    if ((!this.jdField_a_of_type_Boolean) || (this.e) || (localyir == null))
    {
      xvv.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    i();
    if (this.jdField_a_of_type_Xzd.jdField_b_of_type_Int == 6)
    {
      xvv.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, edit face, return");
      return;
    }
    if ((TextUtils.isEmpty(localyir.g)) || (localyir.jdField_b_of_type_Int == 0) || (localyir.jdField_b_of_type_Int == 1))
    {
      xvv.a("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, music path:%s, type:%d", localyir.g, Integer.valueOf(localyir.jdField_b_of_type_Int));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new EditVideoMusic.3(this, a(), this, localyir);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    if (paramInt >= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(localyir.g, paramInt);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(localyir.g, localyir.d);
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Yal == null) {}
    while (this.jdField_a_of_type_Yal.c != 2) {
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
    super.f();
    this.jdField_a_of_type_Boolean = false;
    i();
    if (this.jdField_b_of_type_Int > 0) {
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_b_of_type_Int, 0);
    }
  }
  
  public void g()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      b();
      return;
    }
    b(this.jdField_a_of_type_Int);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Yal = null;
    this.d = false;
    xzc localxzc = a(yam.class);
    if (localxzc != null) {
      ((yam)localxzc).a(this.jdField_a_of_type_Xzd.a());
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
    this.jdField_a_of_type_Xzd.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void k()
  {
    this.jdField_a_of_type_Xzd.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void l()
  {
    this.jdField_a_of_type_Xzd.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */