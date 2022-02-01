package com.tencent.biz.qqstory.takevideo;

import agfs;
import ajap;
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
import yuk;
import yuq;
import yux;
import yvm;
import yxo;
import yxp;
import yxr;
import yxs;
import yxt;
import yyf;
import yzb;
import yzc;
import yzd;
import zhn;
import zhr;
import zih;
import zlk;
import zll;
import zom;

public class EditVideoMusic
  extends yxr
  implements agfs, yvm
{
  int jdField_a_of_type_Int = 0;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public SparseArray<zhr> a;
  protected EditVideoMusic.TakePhotoMusicTimerTask a;
  protected AudioPlayer a;
  public ArrayList<zhr> a;
  protected Timer a;
  yzc jdField_a_of_type_Yzc;
  protected boolean a;
  private int b;
  protected boolean b;
  boolean c = false;
  boolean d = false;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public EditVideoMusic(@NonNull yxt paramyxt)
  {
    super(paramyxt);
    this.jdField_a_of_type_AndroidOsHandler = new yxp(this);
  }
  
  private zhr a(yzc paramyzc)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramyzc.e);
      localJSONObject.put("audio_url", paramyzc.f);
      localJSONObject.put("type", 2);
      localJSONObject.put("id", paramyzc.d);
      return new zhr(localJSONObject.toString());
    }
    catch (JSONException paramyzc)
    {
      for (;;)
      {
        paramyzc.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if (this.f) {
      return;
    }
    Object localObject = a();
    if ((localObject == null) || (((zhr)localObject).equals(zhr.jdField_b_of_type_Zhr)))
    {
      localObject = (yyf)this.jdField_a_of_type_Yxt.a(yyf.class);
      if (localObject != null) {
        ((yyf)localObject).a(this.e);
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
    this.jdField_a_of_type_Yxt.a(2);
  }
  
  public void W_()
  {
    super.W_();
    this.jdField_a_of_type_Boolean = true;
    m();
  }
  
  public zhr a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (zhr)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Yxt.a());
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Yxt.a();
    Object localObject3 = null;
    String str = this.jdField_a_of_type_Yxt.a.a("video_tag_info");
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Yzc = ((yzc)JsonORM.a(new JSONObject(str), yzc.class));
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Yzc != null)
      {
        if (this.jdField_a_of_type_Yzc.c != 0) {
          break label207;
        }
        localObject1 = localObject3;
        if (zhn.a(a()))
        {
          localObject1 = zhn.a(a(), this.jdField_a_of_type_Yzc.d);
          yuk.b("Q.qqstory.publish.edit.EditVideoMusic", "set the default music : music id = %s, success = %s", this.jdField_a_of_type_Yzc.d, localObject1);
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
        yuk.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JsonParseException", localJsonParseException);
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
        yuk.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        if (this.jdField_a_of_type_Yzc.c == 1)
        {
          localObject2 = a(this.jdField_a_of_type_Yzc);
          yuk.b("Q.qqstory.publish.edit.EditVideoMusic", "set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Yzc.d, localObject2);
        }
        else
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Yzc.c == 2)
          {
            localObject2 = a(this.jdField_a_of_type_Yzc);
            yuk.b("Q.qqstory.publish.edit.EditVideoMusic", "from qzone topic, set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Yzc.d, localObject2);
            continue;
            bool = false;
            continue;
            if (this.jdField_a_of_type_Yxt.a()) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, zhr.jdField_a_of_type_Zhr);
            } else {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, zhr.jdField_b_of_type_Zhr);
            }
          }
        }
      }
      label329:
      if ((localObject2 == null) && (this.jdField_a_of_type_Yxt.a()))
      {
        a(zhr.jdField_a_of_type_Zhr);
        a(0);
      }
      a(yvm.class, this);
    }
  }
  
  public void a(int paramInt)
  {
    yux localyux = (yux)a(yux.class);
    if (localyux != null)
    {
      if (paramInt == 0) {
        localyux.a(2130846666);
      }
    }
    else {
      return;
    }
    if ((3 == paramInt) || (2 == paramInt))
    {
      localyux.a(2130846665);
      return;
    }
    localyux.a(2130846659);
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
      yuq.a("0X80076BB", yuq.jdField_b_of_type_Int);
      bool3 = paramObject instanceof yzc;
      paramObject = a(yzd.class);
      if (paramObject == null) {
        break;
      }
    }
    for (paramObject = ((yzd)paramObject).a(this.jdField_a_of_type_Yxt.a());; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.a.jdField_a_of_type_Int == 1) {
          bool1 = true;
        }
      }
      paramObject = new EditVideoMusicDialog(a(), this, this.jdField_b_of_type_Boolean, (int)this.jdField_a_of_type_Yxt.a(this.jdField_a_of_type_Yxt.a()), this.jdField_a_of_type_Yxt.a, bool3, bool1);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new yxo(this));
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
  
  public void a(int paramInt, @NonNull zih paramzih)
  {
    super.a(paramInt, paramzih);
    zhr localzhr = (zhr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localzhr == null)
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a() instanceof AmrPlayer)) && (localzhr.d - 1000 > 0)) {
      localzhr.d -= 1000;
    }
    paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = localzhr.g;
    Object localObject1 = paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    if (localzhr.jdField_b_of_type_Int != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject1).isMuteRecordVoice = bool;
      paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicOffset = localzhr.d;
      paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicDuration = ((int)this.jdField_a_of_type_Yxt.a(paramInt));
      if (!TextUtils.isEmpty(localzhr.g)) {
        yuk.d("Q.qqstory.publish.edit.EditVideoMusic", "pre publish music file exist:%b path:%s", new Object[] { Boolean.valueOf(zom.b(localzhr.g)), localzhr.g });
      }
      switch (localzhr.jdField_b_of_type_Int)
      {
      default: 
        yuk.d("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    Object localObject2;
    if (localzhr.jdField_b_of_type_Int == 2)
    {
      localObject1 = "1";
      yxt localyxt = this.jdField_a_of_type_Yxt;
      paramInt = this.jdField_a_of_type_Yxt.b();
      String str = localzhr.jdField_b_of_type_JavaLangString;
      if (!this.jdField_b_of_type_Boolean) {
        break label427;
      }
      localObject2 = "2";
      label302:
      localyxt.b("pub_music", paramInt, 0, new String[] { localObject1, str, localObject2 });
      if (!((String)localObject1).equals("1")) {
        break label435;
      }
      localObject1 = "0X80076E6";
      label347:
      yuq.a((String)localObject1, String.valueOf(yuq.jdField_b_of_type_Int), "", localzhr.jdField_b_of_type_JavaLangString, "");
      localObject2 = new TribeVideoPublishParams.Music();
      ((TribeVideoPublishParams.Music)localObject2).name = localzhr.jdField_b_of_type_JavaLangString;
      if (localzhr.jdField_b_of_type_Int != 3) {
        break label443;
      }
    }
    label427:
    label435:
    label443:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((TribeVideoPublishParams.Music)localObject2).type = ((String)localObject1);
      paramzih.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.music = ((TribeVideoPublishParams.Music)localObject2);
      return;
      localObject1 = "2";
      break;
      localObject2 = "1";
      break label302;
      localObject1 = "0X80076E5";
      break label347;
    }
    this.jdField_a_of_type_Yxt.b("sound_off", this.jdField_a_of_type_Yxt.b(), 0, new String[0]);
    yuq.a("0X80076E7", yuq.jdField_b_of_type_Int);
    paramzih.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = false;
    return;
    this.jdField_a_of_type_Yxt.b("sound_on", this.jdField_a_of_type_Yxt.b(), 0, new String[0]);
    yuq.a("0X80076E8");
    paramzih.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = true;
    return;
    paramzih = new Properties();
    paramzih.setProperty("bless_param_voice_id", "" + localzhr.c);
    ajap.a("bless_event_voice_result", paramzih);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void a(String paramString)
  {
    zhr localzhr = a();
    if (localzhr != null)
    {
      localzhr.g = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        yuk.d("Q.qqstory.publish.edit.EditVideoMusic", "music file exist:%b path:%s", new Object[] { Boolean.valueOf(zom.b(paramString)), paramString });
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Yxt.a(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void a(yzb paramyzb)
  {
    zhr localzhr = a();
    if (localzhr == null)
    {
      paramyzb.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localzhr.jdField_b_of_type_Int != 2) && (localzhr.jdField_b_of_type_Int != 3))
    {
      paramyzb.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localzhr.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      try
      {
        paramyzb.jdField_a_of_type_Long = Long.valueOf(localzhr.jdField_a_of_type_JavaLangString).longValue();
        paramyzb.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        yuk.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localzhr.jdField_b_of_type_JavaLangString, localzhr.jdField_a_of_type_JavaLangString });
        paramyzb.jdField_a_of_type_Boolean = false;
      }
      paramyzb.jdField_a_of_type_Int = 0;
      continue;
      paramyzb.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(zhr paramzhr)
  {
    zhr localzhr = null;
    if (paramzhr != null)
    {
      localzhr = new zhr();
      localzhr.a(paramzhr);
      if (paramzhr.jdField_b_of_type_Int != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Yxt.a(), localzhr);
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
    zhr localzhr;
    label97:
    yyf localyyf;
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
      localzhr = a();
      if (localzhr == null) {
        break;
      }
      a(localzhr.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "Message change fragment()");
      }
      if ((zhr.jdField_a_of_type_Zhr.equals(localzhr)) || (zhr.jdField_b_of_type_Zhr.equals(localzhr))) {
        i();
      }
      localyyf = (yyf)a(yyf.class);
    } while (localyyf == null);
    if (!zhr.jdField_b_of_type_Zhr.equals(localzhr)) {}
    for (;;)
    {
      localyyf.a(bool);
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
    zhr localzhr = a();
    if ((!this.jdField_a_of_type_Boolean) || (this.e) || (localzhr == null))
    {
      yuk.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    i();
    if (this.jdField_a_of_type_Yxt.jdField_b_of_type_Int == 6)
    {
      yuk.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, edit face, return");
      return;
    }
    if ((TextUtils.isEmpty(localzhr.g)) || (localzhr.jdField_b_of_type_Int == 0) || (localzhr.jdField_b_of_type_Int == 1))
    {
      yuk.a("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, music path:%s, type:%d", localzhr.g, Integer.valueOf(localzhr.jdField_b_of_type_Int));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new EditVideoMusic.3(this, a(), this, localzhr);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    if (paramInt >= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(localzhr.g, paramInt);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(localzhr.g, localzhr.d);
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Yzc == null) {}
    while (this.jdField_a_of_type_Yzc.c != 2) {
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
    this.jdField_a_of_type_Yzc = null;
    this.d = false;
    yxs localyxs = a(yzd.class);
    if (localyxs != null) {
      ((yzd)localyxs).a(this.jdField_a_of_type_Yxt.a());
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
    this.jdField_a_of_type_Yxt.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void k()
  {
    this.jdField_a_of_type_Yxt.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void l()
  {
    this.jdField_a_of_type_Yxt.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */