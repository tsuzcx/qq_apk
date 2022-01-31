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

public class bhil
  extends bifz
  implements View.OnClickListener, bhin, bibw
{
  private long jdField_a_of_type_Long = -1L;
  private bhiu jdField_a_of_type_Bhiu = (bhiu)bhfm.a().c(8);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  public bhil(@NonNull bigb parambigb, boolean paramBoolean)
  {
    super(parambigb);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bigb.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private void a(int paramInt, bitz parambitz, MusicItemInfo paramMusicItemInfo)
  {
    boolean bool = parambitz.a.getBooleanExtra("isMixOriginal", this.jdField_a_of_type_Boolean);
    if (paramMusicItemInfo != null)
    {
      parambitz.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
      int j = paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart;
      int i = j;
      if (!this.jdField_a_of_type_Bigb.c()) {
        i = Math.min(j, (int)this.jdField_a_of_type_Bigb.a(paramInt));
      }
      parambitz.a.backgroundMusicDuration = i;
      parambitz.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      PublishVideoEntry localPublishVideoEntry = parambitz.a;
      if (!bool)
      {
        bool = true;
        localPublishVideoEntry.isMuteRecordVoice = bool;
        parambitz.a.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(paramMusicItemInfo.mItemId));
        parambitz.a.putExtra("vs_publish_entry_json_key_music_mid_id", paramMusicItemInfo.mSongMid);
        parambitz.a.putExtra("vs_publish_entry_json_key_song_name", paramMusicItemInfo.mMusicName);
        parambitz.a.putExtra("vs_publish_entry_json_key_music_album_pic", paramMusicItemInfo.mAlbumUrl);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Bhiu.b();
    } while ((paramMusicItemInfo == null) || ((paramMusicItemInfo.mType != 3) && (!paramMusicItemInfo.isDownloading())));
    parambitz.a.backgroundMusicPath = null;
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
  
  private void b(int paramInt, @NonNull bitz parambitz, MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null) {
      if (paramMusicItemInfo.isMyMusicInfo())
      {
        parambitz.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
        paramInt = Math.min(paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart, (int)this.jdField_a_of_type_Bigb.a(paramInt));
        parambitz.a.backgroundMusicDuration = paramInt;
        parambitz.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
        parambitz.a.isMuteRecordVoice = true;
      }
    }
    do
    {
      return;
      parambitz.a.backgroundMusicOffset = 0;
      parambitz.a.backgroundMusicDuration = ((int)this.jdField_a_of_type_Bigb.a(paramInt));
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Bhiu.b();
    } while ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType != 3));
    parambitz.a.backgroundMusicPath = null;
    parambitz.a.isMuteRecordVoice = true;
  }
  
  @Nullable
  public MusicItemInfo a()
  {
    if (this.jdField_a_of_type_Bhiu == null) {
      return null;
    }
    return this.jdField_a_of_type_Bhiu.a();
  }
  
  public void a()
  {
    super.a();
    a(bibw.class, this);
    if (this.jdField_a_of_type_Bhiu != null)
    {
      this.jdField_a_of_type_Bhiu.a(this);
      this.jdField_a_of_type_Bhiu.a(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    super.a(paramInt, parambitz);
    if (this.jdField_a_of_type_Bhiu == null) {
      return;
    }
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_Bhiu.a();
    if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14))
    {
      a(paramInt, parambitz, localMusicItemInfo);
      return;
    }
    b(paramInt, parambitz, localMusicItemInfo);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Bhiu == null) {}
    while (this.jdField_a_of_type_Bhiu.a() == null) {
      return;
    }
    this.jdField_a_of_type_Bhiu.a(paramLong);
  }
  
  public void a(bihf parambihf)
  {
    MusicItemInfo localMusicItemInfo = a();
    if (localMusicItemInfo == null)
    {
      parambihf.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localMusicItemInfo.mType != 5) && (localMusicItemInfo.mType != 1))
    {
      parambihf.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localMusicItemInfo.mType)
    {
    }
    for (;;)
    {
      try
      {
        parambihf.jdField_a_of_type_Long = localMusicItemInfo.mItemId;
        parambihf.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EditVideoQimMusic", 2, "music id is error: title:" + localMusicItemInfo.mMusicName + ", id:" + localMusicItemInfo.mItemId);
        parambihf.jdField_a_of_type_Boolean = false;
      }
      parambihf.jdField_a_of_type_Int = 0;
      continue;
      parambihf.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    bigl localbigl = (bigl)this.jdField_a_of_type_Bigb.a(bigl.class);
    if (localbigl != null) {
      localbigl.a(paramBoolean);
    }
  }
  
  public void ae_()
  {
    if (this.jdField_a_of_type_Bhiu != null) {
      this.jdField_a_of_type_Bhiu.d();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bhiu == null) {}
    do
    {
      return;
      if (!this.b) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditVideoQimMusic", 2, "playBgMusic in = null isPause=" + this.b);
    return;
    this.jdField_a_of_type_Bhiu = ((bhiu)bhfm.a().c(8));
    MusicItemInfo localMusicItemInfo2;
    if (this.c)
    {
      this.c = false;
      localMusicItemInfo2 = b();
      localMusicItemInfo1 = localMusicItemInfo2;
      if (localMusicItemInfo2 == null) {
        this.jdField_a_of_type_Bhiu.e();
      }
    }
    for (MusicItemInfo localMusicItemInfo1 = localMusicItemInfo2;; localMusicItemInfo1 = this.jdField_a_of_type_Bhiu.a())
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQimMusic", 2, "playBgMusic in mPreTime=" + this.jdField_a_of_type_Long + " currentTime=" + l);
      }
      this.jdField_a_of_type_Bhiu.a(localMusicItemInfo1, true, this.jdField_a_of_type_Bigb.c());
      return;
    }
  }
  
  public void bb_()
  {
    super.bb_();
  }
  
  public void bf_()
  {
    super.bf_();
    this.b = true;
    if (this.jdField_a_of_type_Bhiu != null) {
      this.jdField_a_of_type_Bhiu.d();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "resumeClipMusic isPause=" + this.b);
    }
    if ((this.jdField_a_of_type_Bhiu == null) || (this.b)) {
      return;
    }
    this.jdField_a_of_type_Bhiu.c();
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
    this.jdField_a_of_type_Bhiu.a(null);
    this.jdField_a_of_type_Bhiu = null;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bigb.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhil
 * JD-Core Version:    0.7.0.1
 */