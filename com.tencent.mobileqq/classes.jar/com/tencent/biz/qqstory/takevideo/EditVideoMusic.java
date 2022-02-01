package com.tencent.biz.qqstory.takevideo;

import afpx;
import aipy;
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
import ykq;
import ykw;
import ylb;
import ylq;
import yns;
import ynt;
import ynu;
import ynv;
import ynw;
import yoi;
import ypd;
import ype;
import ypf;
import yxg;
import yxk;
import yya;
import zbd;
import zbe;
import zeb;

public class EditVideoMusic
  extends ynu
  implements afpx, ylq
{
  int jdField_a_of_type_Int = 0;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public SparseArray<yxk> a;
  protected EditVideoMusic.TakePhotoMusicTimerTask a;
  protected AudioPlayer a;
  public ArrayList<yxk> a;
  protected Timer a;
  ype jdField_a_of_type_Ype;
  protected boolean a;
  private int b;
  protected boolean b;
  boolean c = false;
  boolean d = false;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public EditVideoMusic(@NonNull ynw paramynw)
  {
    super(paramynw);
    this.jdField_a_of_type_AndroidOsHandler = new ynt(this);
  }
  
  private yxk a(ype paramype)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramype.e);
      localJSONObject.put("audio_url", paramype.f);
      localJSONObject.put("type", 2);
      localJSONObject.put("id", paramype.d);
      return new yxk(localJSONObject.toString());
    }
    catch (JSONException paramype)
    {
      for (;;)
      {
        paramype.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if (this.f) {
      return;
    }
    Object localObject = a();
    if ((localObject == null) || (((yxk)localObject).equals(yxk.jdField_b_of_type_Yxk)))
    {
      localObject = (yoi)this.jdField_a_of_type_Ynw.a(yoi.class);
      if (localObject != null) {
        ((yoi)localObject).a(this.e);
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
    this.jdField_a_of_type_Ynw.a(2);
  }
  
  public void S_()
  {
    super.S_();
    this.jdField_a_of_type_Boolean = true;
    m();
  }
  
  public void V_()
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
  
  public yxk a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (yxk)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Ynw.a());
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Ynw.a();
    Object localObject3 = null;
    String str = this.jdField_a_of_type_Ynw.a.getStringExtra("video_tag_info");
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Ype = ((ype)JsonORM.a(new JSONObject(str), ype.class));
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Ype != null)
      {
        if (this.jdField_a_of_type_Ype.c != 0) {
          break label207;
        }
        localObject1 = localObject3;
        if (yxg.a(a()))
        {
          localObject1 = yxg.a(a(), this.jdField_a_of_type_Ype.d);
          ykq.b("Q.qqstory.publish.edit.EditVideoMusic", "set the default music : music id = %s, success = %s", this.jdField_a_of_type_Ype.d, localObject1);
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
        ykq.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JsonParseException", localJsonParseException);
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
        ykq.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        if (this.jdField_a_of_type_Ype.c == 1)
        {
          localObject2 = a(this.jdField_a_of_type_Ype);
          ykq.b("Q.qqstory.publish.edit.EditVideoMusic", "set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Ype.d, localObject2);
        }
        else
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Ype.c == 2)
          {
            localObject2 = a(this.jdField_a_of_type_Ype);
            ykq.b("Q.qqstory.publish.edit.EditVideoMusic", "from qzone topic, set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Ype.d, localObject2);
            continue;
            bool = false;
            continue;
            if (this.jdField_a_of_type_Ynw.a()) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, yxk.jdField_a_of_type_Yxk);
            } else {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, yxk.jdField_b_of_type_Yxk);
            }
          }
        }
      }
      label329:
      if ((localObject2 == null) && (this.jdField_a_of_type_Ynw.a()))
      {
        a(yxk.jdField_a_of_type_Yxk);
        a(0);
      }
      a(ylq.class, this);
    }
  }
  
  public void a(int paramInt)
  {
    ylb localylb = (ylb)a(ylb.class);
    if (localylb != null)
    {
      if (paramInt == 0) {
        localylb.a(2130846670);
      }
    }
    else {
      return;
    }
    if ((3 == paramInt) || (2 == paramInt))
    {
      localylb.a(2130846669);
      return;
    }
    localylb.a(2130846663);
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
      ykw.a("0X80076BB", ykw.jdField_b_of_type_Int);
      bool3 = paramObject instanceof ype;
      paramObject = a(ypf.class);
      if (paramObject == null) {
        break;
      }
    }
    for (paramObject = ((ypf)paramObject).a(this.jdField_a_of_type_Ynw.a());; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.a.jdField_a_of_type_Int == 1) {
          bool1 = true;
        }
      }
      paramObject = new EditVideoMusicDialog(a(), this, this.jdField_b_of_type_Boolean, (int)this.jdField_a_of_type_Ynw.a(this.jdField_a_of_type_Ynw.a()), this.jdField_a_of_type_Ynw.a, bool3, bool1);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new yns(this));
      paramObject.setCancelable(true);
      paramObject.show();
      return;
      V_();
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
  
  public void a(int paramInt, @NonNull yya paramyya)
  {
    super.a(paramInt, paramyya);
    yxk localyxk = (yxk)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localyxk == null)
    {
      ykq.d("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a() instanceof AmrPlayer)) && (localyxk.d - 1000 > 0)) {
      localyxk.d -= 1000;
    }
    paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = localyxk.g;
    Object localObject1 = paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    if (localyxk.jdField_b_of_type_Int != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject1).isMuteRecordVoice = bool;
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicOffset = localyxk.d;
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicDuration = ((int)this.jdField_a_of_type_Ynw.a(paramInt));
      if (!TextUtils.isEmpty(localyxk.g)) {
        ykq.d("Q.qqstory.publish.edit.EditVideoMusic", "pre publish music file exist:%b path:%s", new Object[] { Boolean.valueOf(zeb.b(localyxk.g)), localyxk.g });
      }
      switch (localyxk.jdField_b_of_type_Int)
      {
      default: 
        ykq.d("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    Object localObject2;
    if (localyxk.jdField_b_of_type_Int == 2)
    {
      localObject1 = "1";
      ynw localynw = this.jdField_a_of_type_Ynw;
      paramInt = this.jdField_a_of_type_Ynw.b();
      String str = localyxk.jdField_b_of_type_JavaLangString;
      if (!this.jdField_b_of_type_Boolean) {
        break label427;
      }
      localObject2 = "2";
      label302:
      localynw.b("pub_music", paramInt, 0, new String[] { localObject1, str, localObject2 });
      if (!((String)localObject1).equals("1")) {
        break label435;
      }
      localObject1 = "0X80076E6";
      label347:
      ykw.a((String)localObject1, String.valueOf(ykw.jdField_b_of_type_Int), "", localyxk.jdField_b_of_type_JavaLangString, "");
      localObject2 = new TribeVideoPublishParams.Music();
      ((TribeVideoPublishParams.Music)localObject2).name = localyxk.jdField_b_of_type_JavaLangString;
      if (localyxk.jdField_b_of_type_Int != 3) {
        break label443;
      }
    }
    label427:
    label435:
    label443:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((TribeVideoPublishParams.Music)localObject2).type = ((String)localObject1);
      paramyya.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.music = ((TribeVideoPublishParams.Music)localObject2);
      return;
      localObject1 = "2";
      break;
      localObject2 = "1";
      break label302;
      localObject1 = "0X80076E5";
      break label347;
    }
    this.jdField_a_of_type_Ynw.b("sound_off", this.jdField_a_of_type_Ynw.b(), 0, new String[0]);
    ykw.a("0X80076E7", ykw.jdField_b_of_type_Int);
    paramyya.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = false;
    return;
    this.jdField_a_of_type_Ynw.b("sound_on", this.jdField_a_of_type_Ynw.b(), 0, new String[0]);
    ykw.a("0X80076E8");
    paramyya.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = true;
    return;
    paramyya = new Properties();
    paramyya.setProperty("bless_param_voice_id", "" + localyxk.c);
    aipy.a("bless_event_voice_result", paramyya);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void a(String paramString)
  {
    yxk localyxk = a();
    if (localyxk != null)
    {
      localyxk.g = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        ykq.d("Q.qqstory.publish.edit.EditVideoMusic", "music file exist:%b path:%s", new Object[] { Boolean.valueOf(zeb.b(paramString)), paramString });
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ynw.a(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void a(ypd paramypd)
  {
    yxk localyxk = a();
    if (localyxk == null)
    {
      paramypd.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localyxk.jdField_b_of_type_Int != 2) && (localyxk.jdField_b_of_type_Int != 3))
    {
      paramypd.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localyxk.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      try
      {
        paramypd.jdField_a_of_type_Long = Long.valueOf(localyxk.jdField_a_of_type_JavaLangString).longValue();
        paramypd.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        ykq.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localyxk.jdField_b_of_type_JavaLangString, localyxk.jdField_a_of_type_JavaLangString });
        paramypd.jdField_a_of_type_Boolean = false;
      }
      paramypd.jdField_a_of_type_Int = 0;
      continue;
      paramypd.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(yxk paramyxk)
  {
    yxk localyxk = null;
    if (paramyxk != null)
    {
      localyxk = new yxk();
      localyxk.a(paramyxk);
      if (paramyxk.jdField_b_of_type_Int != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Ynw.a(), localyxk);
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
    yxk localyxk;
    label97:
    yoi localyoi;
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
      localyxk = a();
      if (localyxk == null) {
        break;
      }
      a(localyxk.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "Message change fragment()");
      }
      if ((yxk.jdField_a_of_type_Yxk.equals(localyxk)) || (yxk.jdField_b_of_type_Yxk.equals(localyxk))) {
        i();
      }
      localyoi = (yoi)a(yoi.class);
    } while (localyoi == null);
    if (!yxk.jdField_b_of_type_Yxk.equals(localyxk)) {}
    for (;;)
    {
      localyoi.a(bool);
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
    yxk localyxk = a();
    if ((!this.jdField_a_of_type_Boolean) || (this.e) || (localyxk == null))
    {
      ykq.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    i();
    if (this.jdField_a_of_type_Ynw.jdField_b_of_type_Int == 6)
    {
      ykq.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, edit face, return");
      return;
    }
    if ((TextUtils.isEmpty(localyxk.g)) || (localyxk.jdField_b_of_type_Int == 0) || (localyxk.jdField_b_of_type_Int == 1))
    {
      ykq.a("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, music path:%s, type:%d", localyxk.g, Integer.valueOf(localyxk.jdField_b_of_type_Int));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new EditVideoMusic.3(this, a(), this, localyxk);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    if (paramInt >= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(localyxk.g, paramInt);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(localyxk.g, localyxk.d);
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Ype == null) {}
    while (this.jdField_a_of_type_Ype.c != 2) {
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
    this.jdField_a_of_type_Ype = null;
    this.d = false;
    ynv localynv = a(ypf.class);
    if (localynv != null) {
      ((ypf)localynv).a(this.jdField_a_of_type_Ynw.a());
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
    this.jdField_a_of_type_Ynw.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void k()
  {
    this.jdField_a_of_type_Ynw.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void l()
  {
    this.jdField_a_of_type_Ynw.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */