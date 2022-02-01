package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.music.GetMusicInfoListHandler;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.mobileqq.qqaudio.audioplayer.AmrPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.Music;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoMusic
  extends EditVideoPart
  implements EditMusicExport, AudioPlayerBase.AudioPlayerListener
{
  int jdField_a_of_type_Int = 0;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public SparseArray<QQStoryMusicInfo> a;
  protected EditVideoMusic.TakePhotoMusicTimerTask a;
  EditVideoTag.TakeVideoTag jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag;
  protected AudioPlayer a;
  public ArrayList<QQStoryMusicInfo> a;
  protected Timer a;
  protected boolean a;
  private int b;
  protected boolean b;
  boolean c = false;
  boolean d = false;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public EditVideoMusic(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic$TakePhotoMusicTimerTask = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidUtilSparseArray = null;
    this.jdField_a_of_type_AndroidOsHandler = new EditVideoMusic.4(this);
  }
  
  private QQStoryMusicInfo a(EditVideoTag.TakeVideoTag paramTakeVideoTag)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", paramTakeVideoTag.e);
      localJSONObject.put("audio_url", paramTakeVideoTag.f);
      localJSONObject.put("type", 2);
      localJSONObject.put("id", paramTakeVideoTag.d);
      return new QQStoryMusicInfo(localJSONObject.toString());
    }
    catch (JSONException paramTakeVideoTag)
    {
      for (;;)
      {
        paramTakeVideoTag.printStackTrace();
      }
    }
  }
  
  private void m()
  {
    if (this.f) {
      return;
    }
    Object localObject = a();
    if ((localObject == null) || (((QQStoryMusicInfo)localObject).equals(QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo)))
    {
      localObject = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      if (localObject != null) {
        ((EditVideoPlayerExport)localObject).a(this.e);
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(2);
  }
  
  public void U_()
  {
    super.U_();
    this.jdField_a_of_type_Boolean = true;
    m();
  }
  
  public void X_()
  {
    if (this.jdField_b_of_type_Boolean) {
      i();
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer == null) || (!this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a()));
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.d();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = null;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "pauseClipMusic()");
  }
  
  public QQStoryMusicInfo a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (QQStoryMusicInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a());
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a();
    Object localObject3 = null;
    String str = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a("video_tag_info");
    Object localObject1 = localObject3;
    if (str != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag = ((EditVideoTag.TakeVideoTag)JsonORM.a(new JSONObject(str), EditVideoTag.TakeVideoTag.class));
      localObject1 = localObject3;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag != null)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.c != 0) {
          break label207;
        }
        localObject1 = localObject3;
        if (GetMusicInfoListHandler.a(a()))
        {
          localObject1 = GetMusicInfoListHandler.a(a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.d);
          SLog.b("Q.qqstory.publish.edit.EditVideoMusic", "set the default music : music id = %s, success = %s", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.d, localObject1);
        }
      }
      if (localObject1 != null)
      {
        bool = true;
        this.d = bool;
        if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
          break label331;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(6);
        i = 0;
        for (;;)
        {
          if (i >= 6) {
            break label331;
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
        SLog.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JsonParseException", localJsonParseException);
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
        SLog.b("Q.qqstory.publish.edit.EditVideoMusic", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.c == 1)
        {
          localObject2 = a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag);
          SLog.b("Q.qqstory.publish.edit.EditVideoMusic", "set the qq music : music id = %s, success = %s", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.d, localObject2);
        }
        else
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.c == 2)
          {
            localObject2 = a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag);
            SLog.b("Q.qqstory.publish.edit.EditVideoMusic", "from qzone topic, set the qq music : music id = %s, success = %s", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.d, localObject2);
            continue;
            bool = false;
            continue;
            if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, QQStoryMusicInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
            } else {
              this.jdField_a_of_type_AndroidUtilSparseArray.put(i, QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
            }
          }
        }
      }
      label331:
      if ((localObject2 == null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()))
      {
        a(QQStoryMusicInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
        a(0);
      }
      a(EditMusicExport.class, this);
    }
  }
  
  public void a(int paramInt)
  {
    EditButtonExport localEditButtonExport = (EditButtonExport)a(EditButtonExport.class);
    if (localEditButtonExport != null)
    {
      if (paramInt == 0) {
        localEditButtonExport.a(2130847013);
      }
    }
    else {
      return;
    }
    if ((3 == paramInt) || (2 == paramInt))
    {
      localEditButtonExport.a(2130847012);
      return;
    }
    localEditButtonExport.a(2130847006);
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
      VideoEditReport.a("0X80076BB", VideoEditReport.jdField_b_of_type_Int);
      bool3 = paramObject instanceof EditVideoTag.TakeVideoTag;
      paramObject = a(EditVideoTagExport.class);
      if (paramObject == null) {
        break;
      }
    }
    for (paramObject = ((EditVideoTagExport)paramObject).a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a());; paramObject = null)
    {
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.a.jdField_a_of_type_Int == 1) {
          bool1 = true;
        }
      }
      paramObject = new EditVideoMusicDialog(a(), this, this.jdField_b_of_type_Boolean, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a, bool3, bool1);
      paramObject.setCanceledOnTouchOutside(true);
      paramObject.setOnDismissListener(new EditVideoMusic.1(this));
      paramObject.setCancelable(true);
      paramObject.show();
      return;
      X_();
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
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    QQStoryMusicInfo localQQStoryMusicInfo = (QQStoryMusicInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localQQStoryMusicInfo == null)
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoMusic", "editVideoPrePublish music error---------");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null) && ((this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.a() instanceof AmrPlayer)) && (localQQStoryMusicInfo.d - 1000 > 0)) {
      localQQStoryMusicInfo.d -= 1000;
    }
    paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = localQQStoryMusicInfo.g;
    Object localObject1 = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    if (localQQStoryMusicInfo.jdField_b_of_type_Int != 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((PublishVideoEntry)localObject1).isMuteRecordVoice = bool;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicOffset = localQQStoryMusicInfo.d;
      paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicDuration = ((int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt));
      if (!TextUtils.isEmpty(localQQStoryMusicInfo.g)) {
        SLog.d("Q.qqstory.publish.edit.EditVideoMusic", "pre publish music file exist:%b path:%s", new Object[] { Boolean.valueOf(FileUtils.b(localQQStoryMusicInfo.g)), localQQStoryMusicInfo.g });
      }
      switch (localQQStoryMusicInfo.jdField_b_of_type_Int)
      {
      default: 
        SLog.d("Q.qqstory.publish.edit.EditVideoMusic", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(-999) });
        return;
      }
    }
    Object localObject2;
    if (localQQStoryMusicInfo.jdField_b_of_type_Int == 2)
    {
      localObject1 = "1";
      EditVideoPartManager localEditVideoPartManager = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
      paramInt = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b();
      String str = localQQStoryMusicInfo.jdField_b_of_type_JavaLangString;
      if (!this.jdField_b_of_type_Boolean) {
        break label423;
      }
      localObject2 = "2";
      label298:
      localEditVideoPartManager.b("pub_music", paramInt, 0, new String[] { localObject1, str, localObject2 });
      if (!((String)localObject1).equals("1")) {
        break label431;
      }
      localObject1 = "0X80076E6";
      label343:
      VideoEditReport.a((String)localObject1, String.valueOf(VideoEditReport.jdField_b_of_type_Int), "", localQQStoryMusicInfo.jdField_b_of_type_JavaLangString, "");
      localObject2 = new TribeVideoPublishParams.Music();
      ((TribeVideoPublishParams.Music)localObject2).name = localQQStoryMusicInfo.jdField_b_of_type_JavaLangString;
      if (localQQStoryMusicInfo.jdField_b_of_type_Int != 3) {
        break label439;
      }
    }
    label423:
    label431:
    label439:
    for (localObject1 = "1";; localObject1 = "2")
    {
      ((TribeVideoPublishParams.Music)localObject2).type = ((String)localObject1);
      paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.music = ((TribeVideoPublishParams.Music)localObject2);
      return;
      localObject1 = "2";
      break;
      localObject2 = "1";
      break label298;
      localObject1 = "0X80076E5";
      break label343;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b("sound_off", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[0]);
    VideoEditReport.a("0X80076E7", VideoEditReport.jdField_b_of_type_Int);
    paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = false;
    return;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b("sound_on", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[0]);
    VideoEditReport.a("0X80076E8");
    paramGenerateContext.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams.isSoundOn = true;
  }
  
  public void a(EditVideoTag.EditBehavior paramEditBehavior)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = a();
    if (localQQStoryMusicInfo == null)
    {
      paramEditBehavior.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localQQStoryMusicInfo.jdField_b_of_type_Int != 2) && (localQQStoryMusicInfo.jdField_b_of_type_Int != 3))
    {
      paramEditBehavior.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localQQStoryMusicInfo.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      try
      {
        paramEditBehavior.jdField_a_of_type_Long = Long.valueOf(localQQStoryMusicInfo.jdField_a_of_type_JavaLangString).longValue();
        paramEditBehavior.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        SLog.e("Q.qqstory.publish.edit.EditVideoMusic", "music id is error: title:%s, id:%s", new Object[] { localQQStoryMusicInfo.jdField_b_of_type_JavaLangString, localQQStoryMusicInfo.jdField_a_of_type_JavaLangString });
        paramEditBehavior.jdField_a_of_type_Boolean = false;
      }
      paramEditBehavior.jdField_a_of_type_Int = 0;
      continue;
      paramEditBehavior.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = null;
    if (paramQQStoryMusicInfo != null)
    {
      localQQStoryMusicInfo = new QQStoryMusicInfo();
      localQQStoryMusicInfo.a(paramQQStoryMusicInfo);
      if (paramQQStoryMusicInfo.jdField_b_of_type_Int != 0) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(), localQQStoryMusicInfo);
      return;
    }
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void a(String paramString)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = a();
    if (localQQStoryMusicInfo != null)
    {
      localQQStoryMusicInfo.g = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        SLog.d("Q.qqstory.publish.edit.EditVideoMusic", "music file exist:%b path:%s", new Object[] { Boolean.valueOf(FileUtils.b(paramString)), paramString });
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    m();
  }
  
  protected boolean a(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    QQStoryMusicInfo localQQStoryMusicInfo;
    label97:
    EditVideoPlayerExport localEditVideoPlayerExport;
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
      localQQStoryMusicInfo = a();
      if (localQQStoryMusicInfo == null) {
        break;
      }
      a(localQQStoryMusicInfo.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "Message change fragment()");
      }
      if ((QQStoryMusicInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.equals(localQQStoryMusicInfo)) || (QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.equals(localQQStoryMusicInfo))) {
        i();
      }
      localEditVideoPlayerExport = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
    } while (localEditVideoPlayerExport == null);
    if (!QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.equals(localQQStoryMusicInfo)) {}
    for (;;)
    {
      localEditVideoPlayerExport.a(bool);
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
    QQStoryMusicInfo localQQStoryMusicInfo = a();
    if ((!this.jdField_a_of_type_Boolean) || (this.e) || (localQQStoryMusicInfo == null))
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic ignore");
      return;
    }
    i();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_b_of_type_Int == 6)
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, edit face, return");
      return;
    }
    if ((TextUtils.isEmpty(localQQStoryMusicInfo.g)) || (localQQStoryMusicInfo.jdField_b_of_type_Int == 0) || (localQQStoryMusicInfo.jdField_b_of_type_Int == 1))
    {
      SLog.a("Q.qqstory.publish.edit.EditVideoMusic", "playBgMusic, music path:%s, type:%d", localQQStoryMusicInfo.g, Integer.valueOf(localQQStoryMusicInfo.jdField_b_of_type_Int));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = new EditVideoMusic.3(this, a(), this, localQQStoryMusicInfo);
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.d(3);
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.b(12);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.b(localQQStoryMusicInfo.g, paramInt);
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
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.b(12);
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.b(localQQStoryMusicInfo.g, localQQStoryMusicInfo.d);
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag == null) {}
    while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.c != 2) {
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag = null;
    this.d = false;
    EditVideoPart.EditExport localEditExport = a(EditVideoTagExport.class);
    if (localEditExport != null) {
      ((EditVideoTagExport)localEditExport).a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a());
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
    if (this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer.d();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayer = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMusic", 2, "stopClipMusic()");
      }
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 3, 0));
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 1, 0));
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 2, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoMusic
 * JD-Core Version:    0.7.0.1
 */