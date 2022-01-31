import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bjdu
  extends bjxl
  implements View.OnClickListener, bjdw, bjtk
{
  private long jdField_a_of_type_Long = -1L;
  private bjed jdField_a_of_type_Bjed = (bjed)bjav.a().c(8);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  public bjdu(@NonNull bjxn parambjxn, boolean paramBoolean)
  {
    super(parambjxn);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bjxn.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private void a(int paramInt, bkld parambkld, MusicItemInfo paramMusicItemInfo)
  {
    boolean bool = parambkld.a.getBooleanExtra("isMixOriginal", this.jdField_a_of_type_Boolean);
    if (paramMusicItemInfo != null)
    {
      parambkld.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
      int j = paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart;
      int i = j;
      if (!this.jdField_a_of_type_Bjxn.c()) {
        i = Math.min(j, (int)this.jdField_a_of_type_Bjxn.a(paramInt));
      }
      parambkld.a.backgroundMusicDuration = i;
      parambkld.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      PublishVideoEntry localPublishVideoEntry = parambkld.a;
      if (!bool)
      {
        bool = true;
        localPublishVideoEntry.isMuteRecordVoice = bool;
        parambkld.a.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(paramMusicItemInfo.mItemId));
        parambkld.a.putExtra("vs_publish_entry_json_key_music_mid_id", paramMusicItemInfo.mSongMid);
        parambkld.a.putExtra("vs_publish_entry_json_key_song_name", paramMusicItemInfo.mMusicName);
        parambkld.a.putExtra("vs_publish_entry_json_key_music_album_pic", paramMusicItemInfo.mAlbumUrl);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Bjed.b();
    } while ((paramMusicItemInfo == null) || ((paramMusicItemInfo.mType != 3) && (!paramMusicItemInfo.isDownloading())));
    parambkld.a.backgroundMusicPath = null;
  }
  
  private MusicItemInfo b()
  {
    Object localObject2 = null;
    Object localObject1 = a();
    if (localObject1 != null) {}
    for (localObject1 = ((Bundle)localObject1).getBundle(MusicProviderView.class.getSimpleName());; localObject1 = null)
    {
      MusicItemInfo localMusicItemInfo;
      boolean bool;
      if (localObject1 != null)
      {
        localMusicItemInfo = (MusicItemInfo)((Bundle)localObject1).getParcelable("select_music");
        localObject2 = ((Bundle)localObject1).getString("select_music_local_path");
        bool = ((Bundle)localObject1).getBoolean("select_mute");
        if (localMusicItemInfo == null) {
          break label111;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localMusicItemInfo.setPath((String)localObject2);
        }
        localObject2 = localMusicItemInfo;
        if (QLog.isColorLevel())
        {
          QLog.i("EditVideoQimMusic", 2, "restore music" + localMusicItemInfo.mMusicName);
          localObject2 = localMusicItemInfo;
        }
      }
      label111:
      do
      {
        return localObject2;
        localObject2 = localMusicItemInfo;
      } while (!bool);
      localObject1 = new MusicItemInfo();
      ((MusicItemInfo)localObject1).mType = 3;
      ((MusicItemInfo)localObject1).mItemId = -2;
      return localObject1;
    }
  }
  
  private void b(int paramInt, @NonNull bkld parambkld, MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null) {
      if (paramMusicItemInfo.isMyMusicInfo())
      {
        parambkld.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
        paramInt = Math.min(paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart, (int)this.jdField_a_of_type_Bjxn.a(paramInt));
        parambkld.a.backgroundMusicDuration = paramInt;
        parambkld.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
        parambkld.a.isMuteRecordVoice = true;
      }
    }
    do
    {
      return;
      parambkld.a.backgroundMusicOffset = 0;
      parambkld.a.backgroundMusicDuration = ((int)this.jdField_a_of_type_Bjxn.a(paramInt));
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Bjed.b();
    } while ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType != 3));
    parambkld.a.backgroundMusicPath = null;
    parambkld.a.isMuteRecordVoice = true;
  }
  
  @Nullable
  public MusicItemInfo a()
  {
    if (this.jdField_a_of_type_Bjed == null) {
      return null;
    }
    return this.jdField_a_of_type_Bjed.a();
  }
  
  public void a()
  {
    super.a();
    a(bjtk.class, this);
    if (this.jdField_a_of_type_Bjed != null)
    {
      this.jdField_a_of_type_Bjed.a(this);
      this.jdField_a_of_type_Bjed.a(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    super.a(paramInt, parambkld);
    if (this.jdField_a_of_type_Bjed == null) {
      return;
    }
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_Bjed.a();
    if ((this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14))
    {
      a(paramInt, parambkld, localMusicItemInfo);
      return;
    }
    b(paramInt, parambkld, localMusicItemInfo);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Bjed == null) {}
    while (this.jdField_a_of_type_Bjed.a() == null) {
      return;
    }
    this.jdField_a_of_type_Bjed.a(paramLong);
  }
  
  public void a(bjyr parambjyr)
  {
    MusicItemInfo localMusicItemInfo = a();
    if (localMusicItemInfo == null)
    {
      parambjyr.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localMusicItemInfo.mType != 5) && (localMusicItemInfo.mType != 1))
    {
      parambjyr.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localMusicItemInfo.mType)
    {
    }
    for (;;)
    {
      try
      {
        parambjyr.jdField_a_of_type_Long = localMusicItemInfo.mItemId;
        parambjyr.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EditVideoQimMusic", 2, "music id is error: title:" + localMusicItemInfo.mMusicName + ", id:" + localMusicItemInfo.mItemId);
        parambjyr.jdField_a_of_type_Boolean = false;
      }
      parambjyr.jdField_a_of_type_Int = 0;
      continue;
      parambjyr.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    bjxx localbjxx = (bjxx)this.jdField_a_of_type_Bjxn.a(bjxx.class);
    if (localbjxx != null) {
      localbjxx.a(paramBoolean);
    }
  }
  
  public void aW_()
  {
    super.aW_();
  }
  
  public void ab_()
  {
    if (this.jdField_a_of_type_Bjed != null) {
      this.jdField_a_of_type_Bjed.d();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bjed == null) {}
    do
    {
      return;
      if (!this.b) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditVideoQimMusic", 2, "playBgMusic in = null isPause=" + this.b);
    return;
    this.jdField_a_of_type_Bjed = ((bjed)bjav.a().c(8));
    MusicItemInfo localMusicItemInfo2;
    if (this.c)
    {
      this.c = false;
      localMusicItemInfo2 = b();
      localMusicItemInfo1 = localMusicItemInfo2;
      if (localMusicItemInfo2 == null) {
        this.jdField_a_of_type_Bjed.e();
      }
    }
    for (MusicItemInfo localMusicItemInfo1 = localMusicItemInfo2;; localMusicItemInfo1 = this.jdField_a_of_type_Bjed.a())
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQimMusic", 2, "playBgMusic in mPreTime=" + this.jdField_a_of_type_Long + " currentTime=" + l);
      }
      this.jdField_a_of_type_Bjed.a(localMusicItemInfo1, true, this.jdField_a_of_type_Bjxn.c());
      return;
    }
  }
  
  public void ba_()
  {
    super.ba_();
    this.b = true;
    if (this.jdField_a_of_type_Bjed != null) {
      this.jdField_a_of_type_Bjed.d();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "resumeClipMusic isPause=" + this.b);
    }
    if ((this.jdField_a_of_type_Bjed == null) || (this.b)) {
      return;
    }
    this.jdField_a_of_type_Bjed.c();
  }
  
  public void f()
  {
    super.f();
    this.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "onResume");
    }
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_Bjed.a(null);
    this.jdField_a_of_type_Bjed = null;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bjxn.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjdu
 * JD-Core Version:    0.7.0.1
 */