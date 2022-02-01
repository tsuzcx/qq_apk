import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bpoq
  extends bqgi
  implements View.OnClickListener, bpos, bqch
{
  private long jdField_a_of_type_Long = -1L;
  private bpoz jdField_a_of_type_Bpoz = (bpoz)bplq.a().c(8);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  public bpoq(@NonNull bqgk parambqgk, boolean paramBoolean)
  {
    super(parambqgk);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bqgk.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private void a(int paramInt, bqua parambqua, MusicItemInfo paramMusicItemInfo)
  {
    boolean bool = parambqua.a.getBooleanExtra("isMixOriginal", this.jdField_a_of_type_Boolean);
    if (paramMusicItemInfo != null)
    {
      parambqua.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
      int j = paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart;
      int i = j;
      if (!this.jdField_a_of_type_Bqgk.c()) {
        i = Math.min(j, (int)this.jdField_a_of_type_Bqgk.a(paramInt));
      }
      parambqua.a.backgroundMusicDuration = i;
      parambqua.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      PublishVideoEntry localPublishVideoEntry = parambqua.a;
      if (!bool)
      {
        bool = true;
        localPublishVideoEntry.isMuteRecordVoice = bool;
        parambqua.a.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(paramMusicItemInfo.mItemId));
        parambqua.a.putExtra("vs_publish_entry_json_key_music_mid_id", paramMusicItemInfo.mSongMid);
        parambqua.a.putExtra("vs_publish_entry_json_key_song_name", paramMusicItemInfo.mMusicName);
        parambqua.a.putExtra("vs_publish_entry_json_key_music_album_pic", paramMusicItemInfo.mAlbumUrl);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Bpoz.b();
    } while ((paramMusicItemInfo == null) || ((paramMusicItemInfo.mType != 3) && (!paramMusicItemInfo.isDownloading())));
    parambqua.a.backgroundMusicPath = null;
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
  
  private void b(int paramInt, @NonNull bqua parambqua, MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null) {
      if (paramMusicItemInfo.isMyMusicInfo())
      {
        parambqua.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
        paramInt = Math.min(paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart, (int)this.jdField_a_of_type_Bqgk.a(paramInt));
        parambqua.a.backgroundMusicDuration = paramInt;
        parambqua.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
        parambqua.a.isMuteRecordVoice = true;
      }
    }
    do
    {
      return;
      parambqua.a.backgroundMusicOffset = 0;
      parambqua.a.backgroundMusicDuration = ((int)this.jdField_a_of_type_Bqgk.a(paramInt));
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Bpoz.b();
    } while ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType != 3));
    parambqua.a.backgroundMusicPath = null;
    parambqua.a.isMuteRecordVoice = true;
  }
  
  @Nullable
  public MusicItemInfo a()
  {
    if (this.jdField_a_of_type_Bpoz == null) {
      return null;
    }
    return this.jdField_a_of_type_Bpoz.a();
  }
  
  public void a()
  {
    super.a();
    a(bqch.class, this);
    if (this.jdField_a_of_type_Bpoz != null)
    {
      this.jdField_a_of_type_Bpoz.a(this);
      this.jdField_a_of_type_Bpoz.a(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    super.a(paramInt, parambqua);
    if (this.jdField_a_of_type_Bpoz == null) {
      return;
    }
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_Bpoz.a();
    if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14))
    {
      a(paramInt, parambqua, localMusicItemInfo);
      return;
    }
    b(paramInt, parambqua, localMusicItemInfo);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Bpoz == null) {}
    while (this.jdField_a_of_type_Bpoz.a() == null) {
      return;
    }
    this.jdField_a_of_type_Bpoz.a(paramLong);
  }
  
  public void a(bqho parambqho)
  {
    MusicItemInfo localMusicItemInfo = a();
    if (localMusicItemInfo == null)
    {
      parambqho.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localMusicItemInfo.mType != 5) && (localMusicItemInfo.mType != 1))
    {
      parambqho.jdField_a_of_type_Boolean = false;
      return;
    }
    switch (localMusicItemInfo.mType)
    {
    }
    for (;;)
    {
      try
      {
        parambqho.jdField_a_of_type_Long = localMusicItemInfo.mItemId;
        parambqho.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EditVideoQimMusic", 2, "music id is error: title:" + localMusicItemInfo.mMusicName + ", id:" + localMusicItemInfo.mItemId);
        parambqho.jdField_a_of_type_Boolean = false;
      }
      parambqho.jdField_a_of_type_Int = 0;
      continue;
      parambqho.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    bqgu localbqgu = (bqgu)this.jdField_a_of_type_Bqgk.a(bqgu.class);
    if (localbqgu != null) {
      localbqgu.a(paramBoolean);
    }
  }
  
  public void aU_()
  {
    super.aU_();
  }
  
  public void aY_()
  {
    super.aY_();
    this.b = true;
    if (this.jdField_a_of_type_Bpoz != null) {
      this.jdField_a_of_type_Bpoz.d();
    }
  }
  
  public void ab_()
  {
    if (this.jdField_a_of_type_Bpoz != null) {
      this.jdField_a_of_type_Bpoz.d();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bpoz == null) {}
    do
    {
      return;
      if (!this.b) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditVideoQimMusic", 2, "playBgMusic in = null isPause=" + this.b);
    return;
    this.jdField_a_of_type_Bpoz = ((bpoz)bplq.a().c(8));
    MusicItemInfo localMusicItemInfo2;
    if (this.c)
    {
      this.c = false;
      localMusicItemInfo2 = b();
      localMusicItemInfo1 = localMusicItemInfo2;
      if (localMusicItemInfo2 == null) {
        this.jdField_a_of_type_Bpoz.e();
      }
    }
    for (MusicItemInfo localMusicItemInfo1 = localMusicItemInfo2;; localMusicItemInfo1 = this.jdField_a_of_type_Bpoz.a())
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQimMusic", 2, "playBgMusic in mPreTime=" + this.jdField_a_of_type_Long + " currentTime=" + l);
      }
      this.jdField_a_of_type_Bpoz.a(localMusicItemInfo1, true, this.jdField_a_of_type_Bqgk.c());
      return;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "resumeClipMusic isPause=" + this.b);
    }
    if ((this.jdField_a_of_type_Bpoz == null) || (this.b)) {
      return;
    }
    this.jdField_a_of_type_Bpoz.c();
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
    this.jdField_a_of_type_Bpoz.a(null);
    this.jdField_a_of_type_Bpoz = null;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bqgk.a(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpoq
 * JD-Core Version:    0.7.0.1
 */