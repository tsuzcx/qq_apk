import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bmtd
  extends bnec
  implements View.OnClickListener, bmtf, bnck
{
  private bmtm jdField_a_of_type_Bmtm = (bmtm)bmql.a().c(8);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
  public bmtd(@NonNull bnee parambnee, boolean paramBoolean)
  {
    super(parambnee);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_Bnee.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_Bnee.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private MusicItemInfo a()
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
  
  private void a(int paramInt, bnot parambnot, MusicItemInfo paramMusicItemInfo)
  {
    boolean bool = parambnot.a.getBooleanExtra("isMixOriginal", this.jdField_a_of_type_Boolean);
    if (paramMusicItemInfo != null)
    {
      parambnot.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
      int j = paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart;
      int i = j;
      if (!this.jdField_a_of_type_Bnee.c()) {
        i = Math.min(j, (int)this.jdField_a_of_type_Bnee.a(paramInt));
      }
      parambnot.a.backgroundMusicDuration = i;
      parambnot.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
      PublishVideoEntry localPublishVideoEntry = parambnot.a;
      if (!bool)
      {
        bool = true;
        localPublishVideoEntry.isMuteRecordVoice = bool;
        parambnot.a.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(paramMusicItemInfo.mItemId));
        parambnot.a.putExtra("vs_publish_entry_json_key_music_mid_id", paramMusicItemInfo.mSongMid);
        parambnot.a.putExtra("vs_publish_entry_json_key_song_name", paramMusicItemInfo.mMusicName);
        parambnot.a.putExtra("vs_publish_entry_json_key_music_album_pic", paramMusicItemInfo.mAlbumUrl);
      }
    }
    do
    {
      return;
      bool = false;
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Bmtm.b();
    } while ((paramMusicItemInfo == null) || ((paramMusicItemInfo.mType != 3) && (!paramMusicItemInfo.isDownloading())));
    parambnot.a.backgroundMusicPath = null;
  }
  
  private void b(int paramInt, @NonNull bnot parambnot, MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo != null) {
      if (paramMusicItemInfo.isMyMusicInfo())
      {
        parambnot.a.backgroundMusicOffset = paramMusicItemInfo.musicStart;
        paramInt = Math.min(paramMusicItemInfo.musicEnd - paramMusicItemInfo.musicStart, (int)this.jdField_a_of_type_Bnee.a(paramInt));
        parambnot.a.backgroundMusicDuration = paramInt;
        parambnot.a.backgroundMusicPath = paramMusicItemInfo.getLocalPath();
        parambnot.a.isMuteRecordVoice = true;
      }
    }
    do
    {
      return;
      parambnot.a.backgroundMusicOffset = 0;
      parambnot.a.backgroundMusicDuration = ((int)this.jdField_a_of_type_Bnee.a(paramInt));
      break;
      paramMusicItemInfo = this.jdField_a_of_type_Bmtm.b();
    } while ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType != 3));
    parambnot.a.backgroundMusicPath = null;
    parambnot.a.isMuteRecordVoice = true;
  }
  
  public void a()
  {
    super.a();
    a(bnck.class, this);
    if (this.jdField_a_of_type_Bmtm != null)
    {
      this.jdField_a_of_type_Bmtm.a(this);
      this.jdField_a_of_type_Bmtm.a(this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(int paramInt, @NonNull bnot parambnot)
  {
    super.a(paramInt, parambnot);
    if (this.jdField_a_of_type_Bmtm == null) {
      return;
    }
    MusicItemInfo localMusicItemInfo = this.jdField_a_of_type_Bmtm.a();
    if ((this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a == 14))
    {
      a(paramInt, parambnot, localMusicItemInfo);
      return;
    }
    b(paramInt, parambnot, localMusicItemInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    bnel localbnel = (bnel)this.jdField_a_of_type_Bnee.a(bnel.class);
    if (localbnel != null) {
      localbnel.a(paramBoolean);
    }
  }
  
  public void aF_()
  {
    super.aF_();
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bmtm != null) {
      this.jdField_a_of_type_Bmtm.b();
    }
  }
  
  public void aG_()
  {
    super.aG_();
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "onResume");
    }
  }
  
  public void aJ_()
  {
    super.aJ_();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bmtm == null) {}
    do
    {
      return;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditVideoQimMusic", 2, "playBgMusic in = null isPause=" + this.jdField_b_of_type_Boolean);
    return;
    this.jdField_a_of_type_Bmtm = ((bmtm)bmql.a().c(8));
    MusicItemInfo localMusicItemInfo2;
    if (this.c)
    {
      this.c = false;
      localMusicItemInfo2 = a();
      localMusicItemInfo1 = localMusicItemInfo2;
      if (localMusicItemInfo2 == null) {
        this.jdField_a_of_type_Bmtm.c();
      }
    }
    for (MusicItemInfo localMusicItemInfo1 = localMusicItemInfo2;; localMusicItemInfo1 = this.jdField_a_of_type_Bmtm.a())
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQimMusic", 2, "playBgMusic in mPreTime=" + this.jdField_b_of_type_Long + " currentTime=" + l);
      }
      this.jdField_a_of_type_Bmtm.a(localMusicItemInfo1, true, this.jdField_a_of_type_Bnee.c());
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bmtm != null) {
      this.jdField_a_of_type_Bmtm.b();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoQimMusic", 2, "resumeClipMusic isPause=" + this.jdField_b_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Bmtm == null) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Bmtm.a();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_Bmtm.a(null);
    this.jdField_a_of_type_Bmtm = null;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bnee.a(0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtd
 * JD-Core Version:    0.7.0.1
 */