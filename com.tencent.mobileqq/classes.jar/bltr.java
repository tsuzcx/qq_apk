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

public class bltr
  extends bmnh
  implements View.OnClickListener, bltt, bmjg
{
  private long jdField_a_of_type_Long = -1L;
  private blua jdField_a_of_type_Blua = (blua)blqr.a().c(8);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  public bltr(@NonNull bmnj parambmnj, boolean paramBoolean)
  {
    super(parambmnj);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bmnj.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private void a(int paramInt, bnaz parambnaz, MusicItemInfo paramMusicItemInfo)
  {
    boolean bool = parambnaz.a.getBooleanExtra("isMixOriginal", this.jdField_a_of_type_Boolean);
    if (paramMusicItemInfo != null)
    {
      parambnaz.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
      int j = paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart;
      int i = j;
      if (!this.jdField_a_of_type_Bmnj.c()) {
        i = Math.min(j, (int)this.jdField_a_of_type_Bmnj.a(paramInt));
      }
      parambnaz.a.backgroundMusicDuration = i;
      parambnaz.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      PublishVideoEntry localPublishVideoEntry = parambnaz.a;
      if (!bool)
      {
        bool = true;
        localPublishVideoEntry.isMuteRecordVoice = bool;
        parambnaz.a.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(paramMusicItemInfo.mItemId));
        parambnaz.a.putExtra("vs_publish_entry_json_key_music_mid_id", paramMusicItemInfo.mSongMid);
        parambnaz.a.putExtra("vs_publish_entry_json_key_song_name", paramMusicItemInfo.mMusicName);
        parambnaz.a.putExtra("vs_publish_entry_json_key_music_album_pic", paramMusicItemInfo.mAlbumUrl);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Blua.b();
    } while ((paramMusicItemInfo == null) || ((paramMusicItemInfo.mType != 3) && (!paramMusicItemInfo.isDownloading())));
    parambnaz.a.backgroundMusicPath = null;
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
  
  private void b(int paramInt, @NonNull bnaz parambnaz, MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null) {
      if (paramMusicItemInfo.isMyMusicInfo())
      {
        parambnaz.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
        paramInt = Math.min(paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart, (int)this.jdField_a_of_type_Bmnj.a(paramInt));
        parambnaz.a.backgroundMusicDuration = paramInt;
        parambnaz.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
        parambnaz.a.isMuteRecordVoice = true;
      }
    }
    do
    {
      return;
      parambnaz.a.backgroundMusicOffset = 0;
      parambnaz.a.backgroundMusicDuration = ((int)this.jdField_a_of_type_Bmnj.a(paramInt));
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Blua.b();
    } while ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType != 3));
    parambnaz.a.backgroundMusicPath = null;
    parambnaz.a.isMuteRecordVoice = true;
  }
  
  @Nullable
  public MusicItemInfo a()
  {
    if (this.jdField_a_of_type_Blua == null) {
      return null;
    }
    return this.jdField_a_of_type_Blua.a();
  }
  
  public void a()
  {
    super.a();
    a(bmjg.class, this);
    if (this.jdField_a_of_type_Blua != null)
    {
      this.jdField_a_of_type_Blua.a(this);
      this.jdField_a_of_type_Blua.a(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(int paramInt, @NonNull bnaz parambnaz)
  {
    super.a(paramInt, parambnaz);
    if (this.jdField_a_of_type_Blua == null) {
      return;
    }
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_Blua.a();
    if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14))
    {
      a(paramInt, parambnaz, localMusicItemInfo);
      return;
    }
    b(paramInt, parambnaz, localMusicItemInfo);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Blua == null) {}
    while (this.jdField_a_of_type_Blua.a() == null) {
      return;
    }
    this.jdField_a_of_type_Blua.a(paramLong);
  }
  
  public void a(bmon parambmon)
  {
    MusicItemInfo localMusicItemInfo = a();
    if (localMusicItemInfo == null)
    {
      parambmon.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localMusicItemInfo.mType != 5) && (localMusicItemInfo.mType != 1))
    {
      parambmon.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localMusicItemInfo.mType)
    {
    }
    for (;;)
    {
      try
      {
        parambmon.jdField_a_of_type_Long = localMusicItemInfo.mItemId;
        parambmon.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EditVideoQimMusic", 2, "music id is error: title:" + localMusicItemInfo.mMusicName + ", id:" + localMusicItemInfo.mItemId);
        parambmon.jdField_a_of_type_Boolean = false;
      }
      parambmon.jdField_a_of_type_Int = 0;
      continue;
      parambmon.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    bmnt localbmnt = (bmnt)this.jdField_a_of_type_Bmnj.a(bmnt.class);
    if (localbmnt != null) {
      localbmnt.a(paramBoolean);
    }
  }
  
  public void aW_()
  {
    super.aW_();
  }
  
  public void ag_()
  {
    if (this.jdField_a_of_type_Blua != null) {
      this.jdField_a_of_type_Blua.d();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Blua == null) {}
    do
    {
      return;
      if (!this.b) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditVideoQimMusic", 2, "playBgMusic in = null isPause=" + this.b);
    return;
    this.jdField_a_of_type_Blua = ((blua)blqr.a().c(8));
    MusicItemInfo localMusicItemInfo2;
    if (this.c)
    {
      this.c = false;
      localMusicItemInfo2 = b();
      localMusicItemInfo1 = localMusicItemInfo2;
      if (localMusicItemInfo2 == null) {
        this.jdField_a_of_type_Blua.e();
      }
    }
    for (MusicItemInfo localMusicItemInfo1 = localMusicItemInfo2;; localMusicItemInfo1 = this.jdField_a_of_type_Blua.a())
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQimMusic", 2, "playBgMusic in mPreTime=" + this.jdField_a_of_type_Long + " currentTime=" + l);
      }
      this.jdField_a_of_type_Blua.a(localMusicItemInfo1, true, this.jdField_a_of_type_Bmnj.c());
      return;
    }
  }
  
  public void ba_()
  {
    super.ba_();
    this.b = true;
    if (this.jdField_a_of_type_Blua != null) {
      this.jdField_a_of_type_Blua.d();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "resumeClipMusic isPause=" + this.b);
    }
    if ((this.jdField_a_of_type_Blua == null) || (this.b)) {
      return;
    }
    this.jdField_a_of_type_Blua.c();
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
    this.jdField_a_of_type_Blua.a(null);
    this.jdField_a_of_type_Blua = null;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bmnj.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltr
 * JD-Core Version:    0.7.0.1
 */