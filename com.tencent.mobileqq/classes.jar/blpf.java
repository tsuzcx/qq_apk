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

public class blpf
  extends bmiv
  implements View.OnClickListener, blph, bmeu
{
  private long jdField_a_of_type_Long = -1L;
  private blpo jdField_a_of_type_Blpo = (blpo)blmf.a().c(8);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  public blpf(@NonNull bmix parambmix, boolean paramBoolean)
  {
    super(parambmix);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bmix.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bmix.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private void a(int paramInt, bmwn parambmwn, MusicItemInfo paramMusicItemInfo)
  {
    boolean bool = parambmwn.a.getBooleanExtra("isMixOriginal", this.jdField_a_of_type_Boolean);
    if (paramMusicItemInfo != null)
    {
      parambmwn.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
      int j = paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart;
      int i = j;
      if (!this.jdField_a_of_type_Bmix.c()) {
        i = Math.min(j, (int)this.jdField_a_of_type_Bmix.a(paramInt));
      }
      parambmwn.a.backgroundMusicDuration = i;
      parambmwn.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      PublishVideoEntry localPublishVideoEntry = parambmwn.a;
      if (!bool)
      {
        bool = true;
        localPublishVideoEntry.isMuteRecordVoice = bool;
        parambmwn.a.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(paramMusicItemInfo.mItemId));
        parambmwn.a.putExtra("vs_publish_entry_json_key_music_mid_id", paramMusicItemInfo.mSongMid);
        parambmwn.a.putExtra("vs_publish_entry_json_key_song_name", paramMusicItemInfo.mMusicName);
        parambmwn.a.putExtra("vs_publish_entry_json_key_music_album_pic", paramMusicItemInfo.mAlbumUrl);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Blpo.b();
    } while ((paramMusicItemInfo == null) || ((paramMusicItemInfo.mType != 3) && (!paramMusicItemInfo.isDownloading())));
    parambmwn.a.backgroundMusicPath = null;
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
  
  private void b(int paramInt, @NonNull bmwn parambmwn, MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null) {
      if (paramMusicItemInfo.isMyMusicInfo())
      {
        parambmwn.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
        paramInt = Math.min(paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart, (int)this.jdField_a_of_type_Bmix.a(paramInt));
        parambmwn.a.backgroundMusicDuration = paramInt;
        parambmwn.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
        parambmwn.a.isMuteRecordVoice = true;
      }
    }
    do
    {
      return;
      parambmwn.a.backgroundMusicOffset = 0;
      parambmwn.a.backgroundMusicDuration = ((int)this.jdField_a_of_type_Bmix.a(paramInt));
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Blpo.b();
    } while ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType != 3));
    parambmwn.a.backgroundMusicPath = null;
    parambmwn.a.isMuteRecordVoice = true;
  }
  
  @Nullable
  public MusicItemInfo a()
  {
    if (this.jdField_a_of_type_Blpo == null) {
      return null;
    }
    return this.jdField_a_of_type_Blpo.a();
  }
  
  public void a()
  {
    super.a();
    a(bmeu.class, this);
    if (this.jdField_a_of_type_Blpo != null)
    {
      this.jdField_a_of_type_Blpo.a(this);
      this.jdField_a_of_type_Blpo.a(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    super.a(paramInt, parambmwn);
    if (this.jdField_a_of_type_Blpo == null) {
      return;
    }
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_Blpo.a();
    if ((this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14))
    {
      a(paramInt, parambmwn, localMusicItemInfo);
      return;
    }
    b(paramInt, parambmwn, localMusicItemInfo);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Blpo == null) {}
    while (this.jdField_a_of_type_Blpo.a() == null) {
      return;
    }
    this.jdField_a_of_type_Blpo.a(paramLong);
  }
  
  public void a(bmkb parambmkb)
  {
    MusicItemInfo localMusicItemInfo = a();
    if (localMusicItemInfo == null)
    {
      parambmkb.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localMusicItemInfo.mType != 5) && (localMusicItemInfo.mType != 1))
    {
      parambmkb.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localMusicItemInfo.mType)
    {
    }
    for (;;)
    {
      try
      {
        parambmkb.jdField_a_of_type_Long = localMusicItemInfo.mItemId;
        parambmkb.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EditVideoQimMusic", 2, "music id is error: title:" + localMusicItemInfo.mMusicName + ", id:" + localMusicItemInfo.mItemId);
        parambmkb.jdField_a_of_type_Boolean = false;
      }
      parambmkb.jdField_a_of_type_Int = 0;
      continue;
      parambmkb.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    bmjh localbmjh = (bmjh)this.jdField_a_of_type_Bmix.a(bmjh.class);
    if (localbmjh != null) {
      localbmjh.a(paramBoolean);
    }
  }
  
  public void aZ_()
  {
    super.aZ_();
  }
  
  public void aj_()
  {
    if (this.jdField_a_of_type_Blpo != null) {
      this.jdField_a_of_type_Blpo.d();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Blpo == null) {}
    do
    {
      return;
      if (!this.b) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditVideoQimMusic", 2, "playBgMusic in = null isPause=" + this.b);
    return;
    this.jdField_a_of_type_Blpo = ((blpo)blmf.a().c(8));
    MusicItemInfo localMusicItemInfo2;
    if (this.c)
    {
      this.c = false;
      localMusicItemInfo2 = b();
      localMusicItemInfo1 = localMusicItemInfo2;
      if (localMusicItemInfo2 == null) {
        this.jdField_a_of_type_Blpo.e();
      }
    }
    for (MusicItemInfo localMusicItemInfo1 = localMusicItemInfo2;; localMusicItemInfo1 = this.jdField_a_of_type_Blpo.a())
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQimMusic", 2, "playBgMusic in mPreTime=" + this.jdField_a_of_type_Long + " currentTime=" + l);
      }
      this.jdField_a_of_type_Blpo.a(localMusicItemInfo1, true, this.jdField_a_of_type_Bmix.c());
      return;
    }
  }
  
  public void bd_()
  {
    super.bd_();
    this.b = true;
    if (this.jdField_a_of_type_Blpo != null) {
      this.jdField_a_of_type_Blpo.d();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "resumeClipMusic isPause=" + this.b);
    }
    if ((this.jdField_a_of_type_Blpo == null) || (this.b)) {
      return;
    }
    this.jdField_a_of_type_Blpo.c();
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
    this.jdField_a_of_type_Blpo.a(null);
    this.jdField_a_of_type_Blpo = null;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bmix.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpf
 * JD-Core Version:    0.7.0.1
 */