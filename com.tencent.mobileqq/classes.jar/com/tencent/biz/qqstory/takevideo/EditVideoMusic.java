package com.tencent.biz.qqstory.takevideo;

import acts;
import afaz;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import bcql;
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
import ved;
import vej;
import veq;
import vff;
import vhh;
import vhi;
import vhk;
import vhl;
import vhm;
import vhy;
import viu;
import viv;
import viw;
import vrg;
import vrk;
import vsa;
import vvd;
import vve;
import vyf;

public class EditVideoMusic
  extends vhk
  implements acts, vff
{
  int jdField_a_of_type_Int = 0;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public SparseArray<vrk> a;
  protected EditVideoMusic.TakePhotoMusicTimerTask a;
  protected AudioPlayer a;
  public ArrayList<vrk> a;
  protected Timer a;
  viv jdField_a_of_type_Viv;
  protected boolean a;
  private int b;
  protected boolean b;
  boolean c = false;
  boolean d = false;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public EditVideoMusic(@NonNull vhm paramvhm)
  {
    super(paramvhm);
    this.jdField_a_of_type_AndroidOsHandler = new vhi(this);
  }
  
  private vrk a(viv paramviv)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramviv.e);
      localJSONObject.put("audio_url", paramviv.f);
      localJSONObject.put("type", 2);
      localJSONObject.put("id", paramviv.d);
      return new vrk(localJSONObject.toString());
    }
    catch (JSONException paramviv)
    {
      for (;;)
      {
        paramviv.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if (this.f) {
      return;
    }
    Object localObject = a();
    if ((localObject == null) || (((vrk)localObject).equals(vrk.jdField_b_of_type_Vrk)))
    {
      localObject = (vhy)this.jdField_a_of_type_Vhm.a(vhy.class);
      if (localObject != null) {
        ((vhy)localObject).a(this.e);
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
      bcql.a(a(), "GIF不支持添加音乐", 0).a();
      return;
    }
    this.jdField_a_of_type_Vhm.a(2);
  }
  
  public void V_()
  {
    super.V_();
    this.jdField_a_of_type_Boolean = true;
    m();
  }
  
  public void Z_()
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
  
  public vrk a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (vrk)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Vhm.a());
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Vhm.a();
    Object localObject3 = null;
    String str = this.jdField_a_of_type_Vhm.a.a("video_tag_info");
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Viv = ((viv)JsonORM.a(new JSONObject(str), viv.class));
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Viv != null)
      {
        if (this.jdField_a_of_type_Viv.c != 0) {
          break label207;
        }
        localObject1 = localObject3;
        if (vrg.a(a()))
        {
          localObject1 = vrg.a(a(), this.jdField_a_of_type_Viv.d);
          ved.b("Q.qqstory.publish.edit.EditVideoMusic", "set the default music : music id = %s, success = %s", this.jdField_a_of_type_Viv.d, localObject1);
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
        ved.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JsonParseException", localJsonParseException);
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
        ved.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        if (this.jdField_a_of_type_Viv.c == 1)
        {
          localObject2 = a(this.jdField_a_of_type_Viv);
          ved.b("Q.qqstory.publish.edit.EditVideoMusic", "set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Viv.d, localObject2);
        }
        else
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Viv.c == 2)
          {
            localObject2 = a(this.jdField_a_of_type_Viv);
            ved.b("Q.qqstory.publish.edit.EditVideoMusic", "from qzone topic, set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Viv.d, localObject2);
            continue;
            bool = false;
            continue;
            if (this.jdField_a_of_type_Vhm.a()) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, vrk.jdField_a_of_type_Vrk);
            } else {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, vrk.jdField_b_of_type_Vrk);
            }
          }
        }
      }
      label329:
      if ((localObject2 == null) && (this.jdField_a_of_type_Vhm.a()))
      {
        a(vrk.jdField_a_of_type_Vrk);
        a(0);
      }
      a(vff.class, this);
    }
  }
  
  public void a(int paramInt)
  {
    veq localveq = (veq)a(veq.class);
    if (localveq != null)
    {
      if (paramInt == 0) {
        localveq.a(2130845758);
      }
    }
    else {
      return;
    }
    if ((3 == paramInt) || (2 == paramInt))
    {
      localveq.a(2130845757);
      return;
    }
    localveq.a(2130845751);
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
      vej.a("0X80076BB", vej.jdField_b_of_type_Int);
      bool3 = paramObject instanceof viv;
      paramObject = a(viw.class);
      if (paramObject == null) {
        break;
      }
    }
    for (paramObject = ((viw)paramObject).a(this.jdField_a_of_type_Vhm.a());; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.a.jdField_a_of_type_Int == 1) {
          bool1 = true;
        }
      }
      paramObject = new EditVideoMusicDialog(a(), this, this.jdField_b_of_type_Boolean, (int)this.jdField_a_of_type_Vhm.a(this.jdField_a_of_type_Vhm.a()), this.jdField_a_of_type_Vhm.a, bool3, bool1);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new vhh(this));
      paramObject.setCancelable(true);
      paramObject.show();
      return;
      Z_();
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
  
  public void a(int paramInt, @NonNull vsa paramvsa)
  {
    super.a(paramInt, paramvsa);
    vrk localvrk = (vrk)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localvrk == null)
    {
      ved.d("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a() instanceof AmrPlayer)) && (localvrk.d - 1000 > 0)) {
      localvrk.d -= 1000;
    }
    paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = localvrk.g;
    Object localObject1 = paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    if (localvrk.jdField_b_of_type_Int != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject1).isMuteRecordVoice = bool;
      paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicOffset = localvrk.d;
      paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicDuration = ((int)this.jdField_a_of_type_Vhm.a(paramInt));
      if (!TextUtils.isEmpty(localvrk.g)) {
        ved.d("Q.qqstory.publish.edit.EditVideoMusic", "pre publish music file exist:%b path:%s", new Object[] { Boolean.valueOf(vyf.b(localvrk.g)), localvrk.g });
      }
      switch (localvrk.jdField_b_of_type_Int)
      {
      default: 
        ved.d("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    Object localObject2;
    if (localvrk.jdField_b_of_type_Int == 2)
    {
      localObject1 = "1";
      vhm localvhm = this.jdField_a_of_type_Vhm;
      paramInt = this.jdField_a_of_type_Vhm.b();
      String str = localvrk.jdField_b_of_type_JavaLangString;
      if (!this.jdField_b_of_type_Boolean) {
        break label427;
      }
      localObject2 = "2";
      label302:
      localvhm.b("pub_music", paramInt, 0, new String[] { localObject1, str, localObject2 });
      if (!((String)localObject1).equals("1")) {
        break label435;
      }
      localObject1 = "0X80076E6";
      label347:
      vej.a((String)localObject1, String.valueOf(vej.jdField_b_of_type_Int), "", localvrk.jdField_b_of_type_JavaLangString, "");
      localObject2 = new TribeVideoPublishParams.Music();
      ((TribeVideoPublishParams.Music)localObject2).name = localvrk.jdField_b_of_type_JavaLangString;
      if (localvrk.jdField_b_of_type_Int != 3) {
        break label443;
      }
    }
    label427:
    label435:
    label443:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((TribeVideoPublishParams.Music)localObject2).type = ((String)localObject1);
      paramvsa.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.music = ((TribeVideoPublishParams.Music)localObject2);
      return;
      localObject1 = "2";
      break;
      localObject2 = "1";
      break label302;
      localObject1 = "0X80076E5";
      break label347;
    }
    this.jdField_a_of_type_Vhm.b("sound_off", this.jdField_a_of_type_Vhm.b(), 0, new String[0]);
    vej.a("0X80076E7", vej.jdField_b_of_type_Int);
    paramvsa.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = false;
    return;
    this.jdField_a_of_type_Vhm.b("sound_on", this.jdField_a_of_type_Vhm.b(), 0, new String[0]);
    vej.a("0X80076E8");
    paramvsa.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = true;
    return;
    paramvsa = new Properties();
    paramvsa.setProperty("bless_param_voice_id", "" + localvrk.c);
    afaz.a("bless_event_voice_result", paramvsa);
  }
  
  public void a(AudioPlayer paramAudioPlayer) {}
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void a(String paramString)
  {
    vrk localvrk = a();
    if (localvrk != null)
    {
      localvrk.g = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        ved.d("Q.qqstory.publish.edit.EditVideoMusic", "music file exist:%b path:%s", new Object[] { Boolean.valueOf(vyf.b(paramString)), paramString });
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Vhm.a(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void a(viu paramviu)
  {
    vrk localvrk = a();
    if (localvrk == null)
    {
      paramviu.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localvrk.jdField_b_of_type_Int != 2) && (localvrk.jdField_b_of_type_Int != 3))
    {
      paramviu.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localvrk.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      try
      {
        paramviu.jdField_a_of_type_Long = Long.valueOf(localvrk.jdField_a_of_type_JavaLangString).longValue();
        paramviu.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        ved.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localvrk.jdField_b_of_type_JavaLangString, localvrk.jdField_a_of_type_JavaLangString });
        paramviu.jdField_a_of_type_Boolean = false;
      }
      paramviu.jdField_a_of_type_Int = 0;
      continue;
      paramviu.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(vrk paramvrk)
  {
    vrk localvrk = null;
    if (paramvrk != null)
    {
      localvrk = new vrk();
      localvrk.a(paramvrk);
      if (paramvrk.jdField_b_of_type_Int != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Vhm.a(), localvrk);
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
    vrk localvrk;
    label97:
    vhy localvhy;
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
      localvrk = a();
      if (localvrk == null) {
        break;
      }
      a(localvrk.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "Message change fragment()");
      }
      if ((vrk.jdField_a_of_type_Vrk.equals(localvrk)) || (vrk.jdField_b_of_type_Vrk.equals(localvrk))) {
        i();
      }
      localvhy = (vhy)a(vhy.class);
    } while (localvhy == null);
    if (!vrk.jdField_b_of_type_Vrk.equals(localvrk)) {}
    for (;;)
    {
      localvhy.a(bool);
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
    vrk localvrk = a();
    if ((!this.jdField_a_of_type_Boolean) || (this.e) || (localvrk == null))
    {
      ved.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    i();
    if (this.jdField_a_of_type_Vhm.jdField_b_of_type_Int == 6)
    {
      ved.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, edit face, return");
      return;
    }
    if ((TextUtils.isEmpty(localvrk.g)) || (localvrk.jdField_b_of_type_Int == 0) || (localvrk.jdField_b_of_type_Int == 1))
    {
      ved.a("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, music path:%s, type:%d", localvrk.g, Integer.valueOf(localvrk.jdField_b_of_type_Int));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new EditVideoMusic.3(this, a(), this, localvrk);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    if (paramInt >= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localvrk.g, paramInt);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localvrk.g, localvrk.d);
    }
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Viv == null) {}
    while (this.jdField_a_of_type_Viv.c != 2) {
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
    this.jdField_a_of_type_Viv = null;
    this.d = false;
    vhl localvhl = a(viw.class);
    if (localvhl != null) {
      ((viw)localvhl).a(this.jdField_a_of_type_Vhm.a());
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
    this.jdField_a_of_type_Vhm.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void k()
  {
    this.jdField_a_of_type_Vhm.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void l()
  {
    this.jdField_a_of_type_Vhm.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */