package com.tencent.biz.qqstory.takevideo;

import actw;
import afbb;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import bcpw;
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
import veg;
import vem;
import vet;
import vfi;
import vhk;
import vhl;
import vhn;
import vho;
import vhp;
import vib;
import vix;
import viy;
import viz;
import vrj;
import vrn;
import vsd;
import vvg;
import vvh;
import vyi;

public class EditVideoMusic
  extends vhn
  implements actw, vfi
{
  int jdField_a_of_type_Int = 0;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public SparseArray<vrn> a;
  protected EditVideoMusic.TakePhotoMusicTimerTask a;
  protected AudioPlayer a;
  public ArrayList<vrn> a;
  protected Timer a;
  viy jdField_a_of_type_Viy;
  protected boolean a;
  private int b;
  protected boolean b;
  boolean c = false;
  boolean d = false;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public EditVideoMusic(@NonNull vhp paramvhp)
  {
    super(paramvhp);
    this.jdField_a_of_type_AndroidOsHandler = new vhl(this);
  }
  
  private vrn a(viy paramviy)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramviy.e);
      localJSONObject.put("audio_url", paramviy.f);
      localJSONObject.put("type", 2);
      localJSONObject.put("id", paramviy.d);
      return new vrn(localJSONObject.toString());
    }
    catch (JSONException paramviy)
    {
      for (;;)
      {
        paramviy.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if (this.f) {
      return;
    }
    Object localObject = a();
    if ((localObject == null) || (((vrn)localObject).equals(vrn.jdField_b_of_type_Vrn)))
    {
      localObject = (vib)this.jdField_a_of_type_Vhp.a(vib.class);
      if (localObject != null) {
        ((vib)localObject).a(this.e);
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
      bcpw.a(a(), "GIF不支持添加音乐", 0).a();
      return;
    }
    this.jdField_a_of_type_Vhp.a(2);
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
  
  public vrn a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (vrn)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Vhp.a());
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Vhp.a();
    Object localObject3 = null;
    String str = this.jdField_a_of_type_Vhp.a.a("video_tag_info");
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_Viy = ((viy)JsonORM.a(new JSONObject(str), viy.class));
      localObject1 = localObject3;
      if (this.jdField_a_of_type_Viy != null)
      {
        if (this.jdField_a_of_type_Viy.c != 0) {
          break label207;
        }
        localObject1 = localObject3;
        if (vrj.a(a()))
        {
          localObject1 = vrj.a(a(), this.jdField_a_of_type_Viy.d);
          veg.b("Q.qqstory.publish.edit.EditVideoMusic", "set the default music : music id = %s, success = %s", this.jdField_a_of_type_Viy.d, localObject1);
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
        veg.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JsonParseException", localJsonParseException);
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
        veg.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        if (this.jdField_a_of_type_Viy.c == 1)
        {
          localObject2 = a(this.jdField_a_of_type_Viy);
          veg.b("Q.qqstory.publish.edit.EditVideoMusic", "set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Viy.d, localObject2);
        }
        else
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_Viy.c == 2)
          {
            localObject2 = a(this.jdField_a_of_type_Viy);
            veg.b("Q.qqstory.publish.edit.EditVideoMusic", "from qzone topic, set the qq music : music id = %s, success = %s", this.jdField_a_of_type_Viy.d, localObject2);
            continue;
            bool = false;
            continue;
            if (this.jdField_a_of_type_Vhp.a()) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, vrn.jdField_a_of_type_Vrn);
            } else {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, vrn.jdField_b_of_type_Vrn);
            }
          }
        }
      }
      label329:
      if ((localObject2 == null) && (this.jdField_a_of_type_Vhp.a()))
      {
        a(vrn.jdField_a_of_type_Vrn);
        a(0);
      }
      a(vfi.class, this);
    }
  }
  
  public void a(int paramInt)
  {
    vet localvet = (vet)a(vet.class);
    if (localvet != null)
    {
      if (paramInt == 0) {
        localvet.a(2130845752);
      }
    }
    else {
      return;
    }
    if ((3 == paramInt) || (2 == paramInt))
    {
      localvet.a(2130845751);
      return;
    }
    localvet.a(2130845745);
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
      vem.a("0X80076BB", vem.jdField_b_of_type_Int);
      bool3 = paramObject instanceof viy;
      paramObject = a(viz.class);
      if (paramObject == null) {
        break;
      }
    }
    for (paramObject = ((viz)paramObject).a(this.jdField_a_of_type_Vhp.a());; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.a.jdField_a_of_type_Int == 1) {
          bool1 = true;
        }
      }
      paramObject = new EditVideoMusicDialog(a(), this, this.jdField_b_of_type_Boolean, (int)this.jdField_a_of_type_Vhp.a(this.jdField_a_of_type_Vhp.a()), this.jdField_a_of_type_Vhp.a, bool3, bool1);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new vhk(this));
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
  
  public void a(int paramInt, @NonNull vsd paramvsd)
  {
    super.a(paramInt, paramvsd);
    vrn localvrn = (vrn)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localvrn == null)
    {
      veg.d("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a() instanceof AmrPlayer)) && (localvrn.d - 1000 > 0)) {
      localvrn.d -= 1000;
    }
    paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = localvrn.g;
    Object localObject1 = paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    if (localvrn.jdField_b_of_type_Int != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject1).isMuteRecordVoice = bool;
      paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicOffset = localvrn.d;
      paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicDuration = ((int)this.jdField_a_of_type_Vhp.a(paramInt));
      if (!TextUtils.isEmpty(localvrn.g)) {
        veg.d("Q.qqstory.publish.edit.EditVideoMusic", "pre publish music file exist:%b path:%s", new Object[] { Boolean.valueOf(vyi.b(localvrn.g)), localvrn.g });
      }
      switch (localvrn.jdField_b_of_type_Int)
      {
      default: 
        veg.d("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    Object localObject2;
    if (localvrn.jdField_b_of_type_Int == 2)
    {
      localObject1 = "1";
      vhp localvhp = this.jdField_a_of_type_Vhp;
      paramInt = this.jdField_a_of_type_Vhp.b();
      String str = localvrn.jdField_b_of_type_JavaLangString;
      if (!this.jdField_b_of_type_Boolean) {
        break label427;
      }
      localObject2 = "2";
      label302:
      localvhp.b("pub_music", paramInt, 0, new String[] { localObject1, str, localObject2 });
      if (!((String)localObject1).equals("1")) {
        break label435;
      }
      localObject1 = "0X80076E6";
      label347:
      vem.a((String)localObject1, String.valueOf(vem.jdField_b_of_type_Int), "", localvrn.jdField_b_of_type_JavaLangString, "");
      localObject2 = new TribeVideoPublishParams.Music();
      ((TribeVideoPublishParams.Music)localObject2).name = localvrn.jdField_b_of_type_JavaLangString;
      if (localvrn.jdField_b_of_type_Int != 3) {
        break label443;
      }
    }
    label427:
    label435:
    label443:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((TribeVideoPublishParams.Music)localObject2).type = ((String)localObject1);
      paramvsd.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.music = ((TribeVideoPublishParams.Music)localObject2);
      return;
      localObject1 = "2";
      break;
      localObject2 = "1";
      break label302;
      localObject1 = "0X80076E5";
      break label347;
    }
    this.jdField_a_of_type_Vhp.b("sound_off", this.jdField_a_of_type_Vhp.b(), 0, new String[0]);
    vem.a("0X80076E7", vem.jdField_b_of_type_Int);
    paramvsd.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = false;
    return;
    this.jdField_a_of_type_Vhp.b("sound_on", this.jdField_a_of_type_Vhp.b(), 0, new String[0]);
    vem.a("0X80076E8");
    paramvsd.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = true;
    return;
    paramvsd = new Properties();
    paramvsd.setProperty("bless_param_voice_id", "" + localvrn.c);
    afbb.a("bless_event_voice_result", paramvsd);
  }
  
  public void a(AudioPlayer paramAudioPlayer) {}
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void a(String paramString)
  {
    vrn localvrn = a();
    if (localvrn != null)
    {
      localvrn.g = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        veg.d("Q.qqstory.publish.edit.EditVideoMusic", "music file exist:%b path:%s", new Object[] { Boolean.valueOf(vyi.b(paramString)), paramString });
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Vhp.a(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void a(vix paramvix)
  {
    vrn localvrn = a();
    if (localvrn == null)
    {
      paramvix.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localvrn.jdField_b_of_type_Int != 2) && (localvrn.jdField_b_of_type_Int != 3))
    {
      paramvix.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localvrn.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      try
      {
        paramvix.jdField_a_of_type_Long = Long.valueOf(localvrn.jdField_a_of_type_JavaLangString).longValue();
        paramvix.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        veg.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localvrn.jdField_b_of_type_JavaLangString, localvrn.jdField_a_of_type_JavaLangString });
        paramvix.jdField_a_of_type_Boolean = false;
      }
      paramvix.jdField_a_of_type_Int = 0;
      continue;
      paramvix.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(vrn paramvrn)
  {
    vrn localvrn = null;
    if (paramvrn != null)
    {
      localvrn = new vrn();
      localvrn.a(paramvrn);
      if (paramvrn.jdField_b_of_type_Int != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Vhp.a(), localvrn);
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
    vrn localvrn;
    label97:
    vib localvib;
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
      localvrn = a();
      if (localvrn == null) {
        break;
      }
      a(localvrn.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "Message change fragment()");
      }
      if ((vrn.jdField_a_of_type_Vrn.equals(localvrn)) || (vrn.jdField_b_of_type_Vrn.equals(localvrn))) {
        i();
      }
      localvib = (vib)a(vib.class);
    } while (localvib == null);
    if (!vrn.jdField_b_of_type_Vrn.equals(localvrn)) {}
    for (;;)
    {
      localvib.a(bool);
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
    vrn localvrn = a();
    if ((!this.jdField_a_of_type_Boolean) || (this.e) || (localvrn == null))
    {
      veg.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    i();
    if (this.jdField_a_of_type_Vhp.jdField_b_of_type_Int == 6)
    {
      veg.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, edit face, return");
      return;
    }
    if ((TextUtils.isEmpty(localvrn.g)) || (localvrn.jdField_b_of_type_Int == 0) || (localvrn.jdField_b_of_type_Int == 1))
    {
      veg.a("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, music path:%s, type:%d", localvrn.g, Integer.valueOf(localvrn.jdField_b_of_type_Int));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new EditVideoMusic.3(this, a(), this, localvrn);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(3);
    if (paramInt >= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localvrn.g, paramInt);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(localvrn.g, localvrn.d);
    }
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Viy == null) {}
    while (this.jdField_a_of_type_Viy.c != 2) {
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
    this.jdField_a_of_type_Viy = null;
    this.d = false;
    vho localvho = a(viz.class);
    if (localvho != null) {
      ((viz)localvho).a(this.jdField_a_of_type_Vhp.a());
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
    this.jdField_a_of_type_Vhp.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void k()
  {
    this.jdField_a_of_type_Vhp.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void l()
  {
    this.jdField_a_of_type_Vhp.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */