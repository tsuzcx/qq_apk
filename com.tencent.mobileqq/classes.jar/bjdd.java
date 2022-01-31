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

public class bjdd
  extends bjwu
  implements View.OnClickListener, bjdf, bjst
{
  private long jdField_a_of_type_Long = -1L;
  private bjdm jdField_a_of_type_Bjdm = (bjdm)bjae.a().c(8);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  public bjdd(@NonNull bjww parambjww, boolean paramBoolean)
  {
    super(parambjww);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bjww.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bjww.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private void a(int paramInt, bkkm parambkkm, MusicItemInfo paramMusicItemInfo)
  {
    boolean bool = parambkkm.a.getBooleanExtra("isMixOriginal", this.jdField_a_of_type_Boolean);
    if (paramMusicItemInfo != null)
    {
      parambkkm.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
      int j = paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart;
      int i = j;
      if (!this.jdField_a_of_type_Bjww.c()) {
        i = Math.min(j, (int)this.jdField_a_of_type_Bjww.a(paramInt));
      }
      parambkkm.a.backgroundMusicDuration = i;
      parambkkm.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      PublishVideoEntry localPublishVideoEntry = parambkkm.a;
      if (!bool)
      {
        bool = true;
        localPublishVideoEntry.isMuteRecordVoice = bool;
        parambkkm.a.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(paramMusicItemInfo.mItemId));
        parambkkm.a.putExtra("vs_publish_entry_json_key_music_mid_id", paramMusicItemInfo.mSongMid);
        parambkkm.a.putExtra("vs_publish_entry_json_key_song_name", paramMusicItemInfo.mMusicName);
        parambkkm.a.putExtra("vs_publish_entry_json_key_music_album_pic", paramMusicItemInfo.mAlbumUrl);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Bjdm.b();
    } while ((paramMusicItemInfo == null) || ((paramMusicItemInfo.mType != 3) && (!paramMusicItemInfo.isDownloading())));
    parambkkm.a.backgroundMusicPath = null;
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
  
  private void b(int paramInt, @NonNull bkkm parambkkm, MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null) {
      if (paramMusicItemInfo.isMyMusicInfo())
      {
        parambkkm.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
        paramInt = Math.min(paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart, (int)this.jdField_a_of_type_Bjww.a(paramInt));
        parambkkm.a.backgroundMusicDuration = paramInt;
        parambkkm.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
        parambkkm.a.isMuteRecordVoice = true;
      }
    }
    do
    {
      return;
      parambkkm.a.backgroundMusicOffset = 0;
      parambkkm.a.backgroundMusicDuration = ((int)this.jdField_a_of_type_Bjww.a(paramInt));
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Bjdm.b();
    } while ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType != 3));
    parambkkm.a.backgroundMusicPath = null;
    parambkkm.a.isMuteRecordVoice = true;
  }
  
  @Nullable
  public MusicItemInfo a()
  {
    if (this.jdField_a_of_type_Bjdm == null) {
      return null;
    }
    return this.jdField_a_of_type_Bjdm.a();
  }
  
  public void a()
  {
    super.a();
    a(bjst.class, this);
    if (this.jdField_a_of_type_Bjdm != null)
    {
      this.jdField_a_of_type_Bjdm.a(this);
      this.jdField_a_of_type_Bjdm.a(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(int paramInt, @NonNull bkkm parambkkm)
  {
    super.a(paramInt, parambkkm);
    if (this.jdField_a_of_type_Bjdm == null) {
      return;
    }
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_Bjdm.a();
    if ((this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14))
    {
      a(paramInt, parambkkm, localMusicItemInfo);
      return;
    }
    b(paramInt, parambkkm, localMusicItemInfo);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Bjdm == null) {}
    while (this.jdField_a_of_type_Bjdm.a() == null) {
      return;
    }
    this.jdField_a_of_type_Bjdm.a(paramLong);
  }
  
  public void a(bjya parambjya)
  {
    MusicItemInfo localMusicItemInfo = a();
    if (localMusicItemInfo == null)
    {
      parambjya.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localMusicItemInfo.mType != 5) && (localMusicItemInfo.mType != 1))
    {
      parambjya.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localMusicItemInfo.mType)
    {
    }
    for (;;)
    {
      try
      {
        parambjya.jdField_a_of_type_Long = localMusicItemInfo.mItemId;
        parambjya.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EditVideoQimMusic", 2, "music id is error: title:" + localMusicItemInfo.mMusicName + ", id:" + localMusicItemInfo.mItemId);
        parambjya.jdField_a_of_type_Boolean = false;
      }
      parambjya.jdField_a_of_type_Int = 0;
      continue;
      parambjya.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    bjxg localbjxg = (bjxg)this.jdField_a_of_type_Bjww.a(bjxg.class);
    if (localbjxg != null) {
      localbjxg.a(paramBoolean);
    }
  }
  
  public void aV_()
  {
    super.aV_();
  }
  
  public void aZ_()
  {
    super.aZ_();
    this.b = true;
    if (this.jdField_a_of_type_Bjdm != null) {
      this.jdField_a_of_type_Bjdm.d();
    }
  }
  
  public void ab_()
  {
    if (this.jdField_a_of_type_Bjdm != null) {
      this.jdField_a_of_type_Bjdm.d();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bjdm == null) {}
    do
    {
      return;
      if (!this.b) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditVideoQimMusic", 2, "playBgMusic in = null isPause=" + this.b);
    return;
    this.jdField_a_of_type_Bjdm = ((bjdm)bjae.a().c(8));
    MusicItemInfo localMusicItemInfo2;
    if (this.c)
    {
      this.c = false;
      localMusicItemInfo2 = b();
      localMusicItemInfo1 = localMusicItemInfo2;
      if (localMusicItemInfo2 == null) {
        this.jdField_a_of_type_Bjdm.e();
      }
    }
    for (MusicItemInfo localMusicItemInfo1 = localMusicItemInfo2;; localMusicItemInfo1 = this.jdField_a_of_type_Bjdm.a())
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQimMusic", 2, "playBgMusic in mPreTime=" + this.jdField_a_of_type_Long + " currentTime=" + l);
      }
      this.jdField_a_of_type_Bjdm.a(localMusicItemInfo1, true, this.jdField_a_of_type_Bjww.c());
      return;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "resumeClipMusic isPause=" + this.b);
    }
    if ((this.jdField_a_of_type_Bjdm == null) || (this.b)) {
      return;
    }
    this.jdField_a_of_type_Bjdm.c();
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
    this.jdField_a_of_type_Bjdm.a(null);
    this.jdField_a_of_type_Bjdm = null;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bjww.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjdd
 * JD-Core Version:    0.7.0.1
 */