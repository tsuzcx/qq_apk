package com.tencent.biz.qqstory.takevideo;

import aelc;
import agye;
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
import wsv;
import wtb;
import wti;
import wtx;
import wvz;
import wwa;
import wwc;
import wwd;
import wwe;
import wwq;
import wxm;
import wxn;
import wxo;
import xfy;
import xgc;
import xgs;
import xjv;
import xjw;
import xmx;

public class EditVideoMusic
  extends wwc
  implements aelc, wtx
{
  int jdField_a_of_type_Int = 0;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public SparseArray<xgc> a;
  protected EditVideoMusic.TakePhotoMusicTimerTask a;
  protected AudioPlayer a;
  public ArrayList<xgc> a;
  protected Timer a;
  wxn jdField_a_of_type_Wxn;
  protected boolean a;
  private int b;
  protected boolean b;
  boolean c = false;
  boolean d = false;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public EditVideoMusic(@NonNull wwe paramwwe)
  {
    super(paramwwe);
    this.jdField_a_of_type_AndroidOsHandler = new wwa(this);
  }
  
  private xgc a(wxn paramwxn)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramwxn.e);
      localJSONObject.put("audio_url", paramwxn.f);
      localJSONObject.put("type", 2);
      localJSONObject.put("id", paramwxn.d);
      return new xgc(localJSONObject.toString());
    }
    catch (JSONException paramwxn)
    {
      for (;;)
      {
        paramwxn.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if (this.f) {
      return;
    }
    Object localObject = a();
    if ((localObject == null) || (((xgc)localObject).equals(xgc.jdField_b_of_type_Xgc)))
    {
      localObject = (wwq)this.jdField_a_of_type_Wwe.a(wwq.class);
      if (localObject != null) {
        ((wwq)localObject).a(this.e);
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
    this.jdField_a_of_type_Wwe.a(2);
  }
  
  public xgc a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (xgc)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Wwe.a());
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Wwe.a();
    Object localObject3 = null;
    String str = this.jdField_a_of_type_Wwe.a.a("video_tag_info");
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Wxn = ((wxn)JsonORM.a(new JSONObject(str), wxn.class));
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Wxn != null)
      {
        if (this.jdField_a_of_type_Wxn.c != 0) {
          break label207;
        }
        localObject1 = localObject3;
        if (xfy.a(a()))
        {
          localObject1 = xfy.a(a(), this.jdField_a_of_type_Wxn.d);
          wsv.b("Q.qqstory.publish.edit.EditVideoMusic", "set the default music : music id = %s, success = %s", this.jdField_a_of_type_Wxn.d, localObject1);
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
        wsv.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JsonParseException", localJsonParseException);
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
        wsv.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        if (this.jdField_a_of_type_Wxn.c == 1)
        {
          localObject2 = a(this.jdField_a_of_type_Wxn);
          wsv.b("Q.qqstory.publish.edit.EditVideoMusic", "set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Wxn.d, localObject2);
        }
        else
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Wxn.c == 2)
          {
            localObject2 = a(this.jdField_a_of_type_Wxn);
            wsv.b("Q.qqstory.publish.edit.EditVideoMusic", "from qzone topic, set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Wxn.d, localObject2);
            continue;
            bool = false;
            continue;
            if (this.jdField_a_of_type_Wwe.a()) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, xgc.jdField_a_of_type_Xgc);
            } else {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, xgc.jdField_b_of_type_Xgc);
            }
          }
        }
      }
      label329:
      if ((localObject2 == null) && (this.jdField_a_of_type_Wwe.a()))
      {
        a(xgc.jdField_a_of_type_Xgc);
        a(0);
      }
      a(wtx.class, this);
    }
  }
  
  public void a(int paramInt)
  {
    wti localwti = (wti)a(wti.class);
    if (localwti != null)
    {
      if (paramInt == 0) {
        localwti.a(2130846137);
      }
    }
    else {
      return;
    }
    if ((3 == paramInt) || (2 == paramInt))
    {
      localwti.a(2130846136);
      return;
    }
    localwti.a(2130846130);
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
      wtb.a("0X80076BB", wtb.jdField_b_of_type_Int);
      bool3 = paramObject instanceof wxn;
      paramObject = a(wxo.class);
      if (paramObject == null) {
        break;
      }
    }
    for (paramObject = ((wxo)paramObject).a(this.jdField_a_of_type_Wwe.a());; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.a.jdField_a_of_type_Int == 1) {
          bool1 = true;
        }
      }
      paramObject = new EditVideoMusicDialog(a(), this, this.jdField_b_of_type_Boolean, (int)this.jdField_a_of_type_Wwe.a(this.jdField_a_of_type_Wwe.a()), this.jdField_a_of_type_Wwe.a, bool3, bool1);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new wvz(this));
      paramObject.setCancelable(true);
      paramObject.show();
      return;
      ah_();
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
  
  public void a(int paramInt, @NonNull xgs paramxgs)
  {
    super.a(paramInt, paramxgs);
    xgc localxgc = (xgc)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localxgc == null)
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a() instanceof AmrPlayer)) && (localxgc.d - 1000 > 0)) {
      localxgc.d -= 1000;
    }
    paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = localxgc.g;
    Object localObject1 = paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    if (localxgc.jdField_b_of_type_Int != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject1).isMuteRecordVoice = bool;
      paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicOffset = localxgc.d;
      paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicDuration = ((int)this.jdField_a_of_type_Wwe.a(paramInt));
      if (!TextUtils.isEmpty(localxgc.g)) {
        wsv.d("Q.qqstory.publish.edit.EditVideoMusic", "pre publish music file exist:%b path:%s", new Object[] { Boolean.valueOf(xmx.b(localxgc.g)), localxgc.g });
      }
      switch (localxgc.jdField_b_of_type_Int)
      {
      default: 
        wsv.d("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    Object localObject2;
    if (localxgc.jdField_b_of_type_Int == 2)
    {
      localObject1 = "1";
      wwe localwwe = this.jdField_a_of_type_Wwe;
      paramInt = this.jdField_a_of_type_Wwe.b();
      String str = localxgc.jdField_b_of_type_JavaLangString;
      if (!this.jdField_b_of_type_Boolean) {
        break label427;
      }
      localObject2 = "2";
      label302:
      localwwe.b("pub_music", paramInt, 0, new String[] { localObject1, str, localObject2 });
      if (!((String)localObject1).equals("1")) {
        break label435;
      }
      localObject1 = "0X80076E6";
      label347:
      wtb.a((String)localObject1, String.valueOf(wtb.jdField_b_of_type_Int), "", localxgc.jdField_b_of_type_JavaLangString, "");
      localObject2 = new TribeVideoPublishParams.Music();
      ((TribeVideoPublishParams.Music)localObject2).name = localxgc.jdField_b_of_type_JavaLangString;
      if (localxgc.jdField_b_of_type_Int != 3) {
        break label443;
      }
    }
    label427:
    label435:
    label443:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((TribeVideoPublishParams.Music)localObject2).type = ((String)localObject1);
      paramxgs.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.music = ((TribeVideoPublishParams.Music)localObject2);
      return;
      localObject1 = "2";
      break;
      localObject2 = "1";
      break label302;
      localObject1 = "0X80076E5";
      break label347;
    }
    this.jdField_a_of_type_Wwe.b("sound_off", this.jdField_a_of_type_Wwe.b(), 0, new String[0]);
    wtb.a("0X80076E7", wtb.jdField_b_of_type_Int);
    paramxgs.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = false;
    return;
    this.jdField_a_of_type_Wwe.b("sound_on", this.jdField_a_of_type_Wwe.b(), 0, new String[0]);
    wtb.a("0X80076E8");
    paramxgs.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = true;
    return;
    paramxgs = new Properties();
    paramxgs.setProperty("bless_param_voice_id", "" + localxgc.c);
    agye.a("bless_event_voice_result", paramxgs);
  }
  
  public void a(AudioPlayer paramAudioPlayer) {}
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void a(String paramString)
  {
    xgc localxgc = a();
    if (localxgc != null)
    {
      localxgc.g = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        wsv.d("Q.qqstory.publish.edit.EditVideoMusic", "music file exist:%b path:%s", new Object[] { Boolean.valueOf(xmx.b(paramString)), paramString });
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Wwe.a(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void a(wxm paramwxm)
  {
    xgc localxgc = a();
    if (localxgc == null)
    {
      paramwxm.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localxgc.jdField_b_of_type_Int != 2) && (localxgc.jdField_b_of_type_Int != 3))
    {
      paramwxm.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localxgc.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      try
      {
        paramwxm.jdField_a_of_type_Long = Long.valueOf(localxgc.jdField_a_of_type_JavaLangString).longValue();
        paramwxm.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        wsv.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localxgc.jdField_b_of_type_JavaLangString, localxgc.jdField_a_of_type_JavaLangString });
        paramwxm.jdField_a_of_type_Boolean = false;
      }
      paramwxm.jdField_a_of_type_Int = 0;
      continue;
      paramwxm.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(xgc paramxgc)
  {
    xgc localxgc = null;
    if (paramxgc != null)
    {
      localxgc = new xgc();
      localxgc.a(paramxgc);
      if (paramxgc.jdField_b_of_type_Int != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Wwe.a(), localxgc);
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
    xgc localxgc;
    label97:
    wwq localwwq;
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
      localxgc = a();
      if (localxgc == null) {
        break;
      }
      a(localxgc.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "Message change fragment()");
      }
      if ((xgc.jdField_a_of_type_Xgc.equals(localxgc)) || (xgc.jdField_b_of_type_Xgc.equals(localxgc))) {
        i();
      }
      localwwq = (wwq)a(wwq.class);
    } while (localwwq == null);
    if (!xgc.jdField_b_of_type_Xgc.equals(localxgc)) {}
    for (;;)
    {
      localwwq.a(bool);
      break;
      a(1);
      break label97;
      bool = false;
    }
  }
  
  public void ad_()
  {
    super.ad_();
    this.jdField_a_of_type_Boolean = true;
    m();
  }
  
  public void ah_()
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
    xgc localxgc = a();
    if ((!this.jdField_a_of_type_Boolean) || (this.e) || (localxgc == null))
    {
      wsv.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    i();
    if (this.jdField_a_of_type_Wwe.jdField_b_of_type_Int == 6)
    {
      wsv.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, edit face, return");
      return;
    }
    if ((TextUtils.isEmpty(localxgc.g)) || (localxgc.jdField_b_of_type_Int == 0) || (localxgc.jdField_b_of_type_Int == 1))
    {
      wsv.a("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, music path:%s, type:%d", localxgc.g, Integer.valueOf(localxgc.jdField_b_of_type_Int));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new EditVideoMusic.3(this, a(), this, localxgc);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    if (paramInt >= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localxgc.g, paramInt);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localxgc.g, localxgc.d);
    }
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Wxn == null) {}
    while (this.jdField_a_of_type_Wxn.c != 2) {
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
    this.jdField_a_of_type_Wxn = null;
    this.d = false;
    wwd localwwd = a(wxo.class);
    if (localwwd != null) {
      ((wxo)localwwd).a(this.jdField_a_of_type_Wwe.a());
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
    this.jdField_a_of_type_Wwe.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void k()
  {
    this.jdField_a_of_type_Wwe.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void l()
  {
    this.jdField_a_of_type_Wwe.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */