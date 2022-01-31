import VIP.GetQzoneMusicInfoRsp;
import VIP.MusicInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class auxa
  implements ajtg
{
  auxa(auwz paramauwz) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetQzoneMusicInfoRsp)))
    {
      paramObject = (GetQzoneMusicInfoRsp)paramObject;
      if ((auwz.a(this.a)) || (!paramObject.mMusicList.containsKey(auwz.a(this.a).f))) {
        break label101;
      }
      auwz.a(this.a).a = ((MusicInfo)paramObject.mMusicList.get(auwz.a(this.a).f)).sSongUrl;
      this.a.a(BaseApplicationImpl.getContext(), auwz.a(this.a));
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
          if (paramObject.mMusicList.containsKey(arrayOfSongInfo[paramInt].f))
          {
            arrayOfSongInfo[paramInt].a = ((MusicInfo)paramObject.mMusicList.get(arrayOfSongInfo[paramInt].f)).sSongUrl;
            if (QLog.isColorLevel()) {
              QLog.d("ProfileMusicBoxController", 2, "requestMusicSongUrl mid:" + arrayOfSongInfo[paramInt].f + " url:" + arrayOfSongInfo[paramInt].a);
            }
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxa
 * JD-Core Version:    0.7.0.1
 */