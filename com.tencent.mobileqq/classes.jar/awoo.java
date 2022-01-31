import VIP.GetQzoneMusicInfoRsp;
import VIP.MusicInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class awoo
  implements alkr
{
  awoo(awon paramawon) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetQzoneMusicInfoRsp)))
    {
      paramObject = (GetQzoneMusicInfoRsp)paramObject;
      if ((awon.a(this.a)) || (!paramObject.mMusicList.containsKey(awon.a(this.a).g))) {
        break label101;
      }
      awon.a(this.a).b = ((MusicInfo)paramObject.mMusicList.get(awon.a(this.a).g)).sSongUrl;
      this.a.a(BaseApplicationImpl.getContext(), awon.a(this.a));
    }
    for (;;)
    {
      return;
      label101:
      SongInfo[] arrayOfSongInfo = QQPlayerService.a();
      if (arrayOfSongInfo != null)
      {
        paramInt = 0;
        while (paramInt < arrayOfSongInfo.length)
        {
          if (paramObject.mMusicList.containsKey(arrayOfSongInfo[paramInt].g))
          {
            arrayOfSongInfo[paramInt].b = ((MusicInfo)paramObject.mMusicList.get(arrayOfSongInfo[paramInt].g)).sSongUrl;
            if (QLog.isColorLevel()) {
              QLog.d("ProfileMusicBoxController", 2, "requestMusicSongUrl mid:" + arrayOfSongInfo[paramInt].g + " url:" + arrayOfSongInfo[paramInt].b);
            }
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awoo
 * JD-Core Version:    0.7.0.1
 */