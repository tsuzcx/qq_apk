import VIP.GetQzoneMusicInfoRsp;
import VIP.MusicInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class baae
  implements anui
{
  baae(baad parambaad) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetQzoneMusicInfoRsp)))
    {
      paramObject = (GetQzoneMusicInfoRsp)paramObject;
      if ((baad.a(this.a)) || (!paramObject.mMusicList.containsKey(baad.a(this.a).g))) {
        break label101;
      }
      baad.a(this.a).b = ((MusicInfo)paramObject.mMusicList.get(baad.a(this.a).g)).sSongUrl;
      this.a.a(BaseApplicationImpl.getContext(), baad.a(this.a));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baae
 * JD-Core Version:    0.7.0.1
 */