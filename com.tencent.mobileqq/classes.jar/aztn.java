import VIP.GetMusicListReq;
import VIP.GetMusicListRsp;
import VIP.GetQzoneMusicInfoReq;
import VIP.GetQzoneMusicInfoRsp;
import VIP.MusicInfo;
import VIP.MusicListInfo;
import VIP.SingerInfo;
import VIP.SourceInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController.1;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class aztn
  extends awgx
  implements axkk, BusinessObserver
{
  public static int j = 3;
  private long jdField_a_of_type_Long;
  private aztp jdField_a_of_type_Aztp;
  private SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo = new SongInfo();
  private SongInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  private long b;
  private boolean h;
  private boolean i;
  
  public aztn(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Awgv.jdField_b_of_type_Boolean = true;
    paramQQAppInterface.removeObserver(this.jdField_a_of_type_Awfk);
  }
  
  public static boolean a(long paramLong)
  {
    SongInfo localSongInfo = QQPlayerService.b();
    if ((localSongInfo != null) && (QQPlayerService.b().jdField_b_of_type_Int == 10) && (localSongInfo.jdField_b_of_type_Long == paramLong)) {
      return QQPlayerService.a();
    }
    return false;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(j, paramString);
    behx.a().a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout, paramString, j);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equalsIgnoreCase(paramString)))
    {
      this.i = true;
      return;
    }
    this.i = false;
  }
  
  public void a(long paramLong)
  {
    new bhyv("VIP.ProfileMusicBoxServer.ProfileMusicBoxObj", "ProfileMusicBox.getMusicList").a("getMusicList", new GetMusicListReq(paramLong, "", 100L, new SourceInfo(3, "8.4.10"), 0), new GetMusicListRsp(), this, false);
  }
  
  public void a(long paramLong, SongInfo paramSongInfo)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    this.h = a(paramLong);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramSongInfo.g);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, ArrayList<String> paramArrayList)
  {
    new bhyv("VIP.ProfileMusicBoxServer.ProfileMusicBoxObj", "ProfileMusicBox.getQzoneMusicInfo").a("getQzoneMusicInfo", new GetQzoneMusicInfoReq(paramLong, paramArrayList, new SourceInfo(3, "8.4.10")), new GetQzoneMusicInfoRsp(), new azto(this), false);
  }
  
  public void a(Context paramContext, SongInfo paramSongInfo)
  {
    if (QQPlayerService.a() == 3)
    {
      QQPlayerService.a(paramContext, false);
      d(true);
    }
    do
    {
      return;
      new Intent(paramContext, QQBrowserActivity.class).putExtra("url", bkyp.a(arky.a().jdField_b_of_type_JavaLangString, "uin", String.valueOf(this.jdField_a_of_type_Long)));
      QQPlayerService.b(this);
      QQPlayerService.a(103);
      QQPlayerService.a(paramContext, getToken(), new SongInfo[] { paramSongInfo }, 0, false);
      a(this.jdField_a_of_type_Long);
      a(String.valueOf(this.jdField_a_of_type_Long));
      a(paramSongInfo);
    } while (!QLog.isColorLevel());
    QLog.d("ProfileMusicBoxController", 2, "playMusic mid:" + paramSongInfo.g + " url:" + paramSongInfo.jdField_b_of_type_JavaLangString);
  }
  
  public void a(aztp paramaztp)
  {
    this.jdField_a_of_type_Aztp = paramaztp;
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileMusicBoxController", 2, "onPlayMusicChange song.id:" + paramSongInfo.e);
    }
    this.jdField_a_of_type_Awgv.jdField_a_of_type_JavaLangString = paramSongInfo.e;
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Awgv);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equalsIgnoreCase(paramString)))
    {
      this.i = true;
      if (!b()) {
        break label54;
      }
      QQPlayerService.a(BaseApplicationImpl.getContext(), false);
      d(true);
    }
    label54:
    while (TextUtils.isEmpty(paramString))
    {
      return;
      this.i = false;
      break;
    }
    awgx localawgx = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    if (localawgx != null)
    {
      this.jdField_a_of_type_Awgv.jdField_a_of_type_Int = localawgx.a().jdField_a_of_type_Int;
      this.jdField_a_of_type_Awgv.jdField_b_of_type_Int = localawgx.a().jdField_b_of_type_Int;
      this.jdField_a_of_type_Awgv.jdField_a_of_type_Boolean = localawgx.a().jdField_a_of_type_Boolean;
      if (localawgx.a()) {
        localawgx.b(localawgx.a().e, localawgx.a().jdField_b_of_type_JavaLangString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileMusicBoxController", 2, "showLyrics");
    }
    if ((TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Awgv.jdField_b_of_type_JavaLangString)))
    {
      super.a(j, this.jdField_a_of_type_Awgv.jdField_b_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.add(j + "_" + paramString);
    if (!a())
    {
      super.a(j, paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b();
      }
    }
    behx.a().a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout, paramString, j);
  }
  
  public boolean b()
  {
    return (QQPlayerService.a() == 3) && (QQPlayerService.b() != null) && (QQPlayerService.b().jdField_b_of_type_Int == 10) && (a());
  }
  
  public void c()
  {
    aztm.b(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.getContext(), this.jdField_a_of_type_Awgv.jdField_b_of_type_JavaLangString);
    String str;
    if (this.i)
    {
      str = "";
      if (!this.i) {
        break label74;
      }
    }
    label74:
    for (int k = 1;; k = 2)
    {
      bdla.b(null, "dc00898", "", str, "qq_vip", "0X800A7DF", k, 0, "", "", "", "");
      return;
      str = String.valueOf(this.jdField_a_of_type_Long);
      break;
    }
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public void d()
  {
    QQPlayerService.c(BaseApplicationImpl.getContext());
    p();
    String str;
    if (this.i)
    {
      str = "";
      if (!this.i) {
        break label67;
      }
    }
    label67:
    for (int k = 1;; k = 2)
    {
      bdla.b(null, "dc00898", "", str, "qq_vip", "0X800A7E0", k, 0, "", "", "", "");
      return;
      str = String.valueOf(this.jdField_a_of_type_Long);
      break;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ProfileMusicBoxController.1(this, paramBoolean));
  }
  
  public void e()
  {
    QQPlayerService.c(this);
    this.jdField_a_of_type_Aztp = null;
    super.e();
    behx.a().b();
  }
  
  protected void f() {}
  
  public String getToken()
  {
    return QQPlayerService.a(4, "QQMusicWrap");
  }
  
  public void m()
  {
    super.b(j, this.jdField_a_of_type_Awgv.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Awgv.e = 0;
    b(j, this.jdField_a_of_type_Awgv.jdField_b_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      awgx localawgx = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      if (localawgx != null)
      {
        localawgx.a().jdField_a_of_type_Int = this.jdField_a_of_type_Awgv.jdField_a_of_type_Int;
        localawgx.a().jdField_b_of_type_Int = this.jdField_a_of_type_Awgv.jdField_b_of_type_Int;
        localawgx.a().jdField_a_of_type_Boolean = this.jdField_a_of_type_Awgv.jdField_a_of_type_Boolean;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileMusicBoxController", 2, "hideLyrics");
      }
    }
  }
  
  public void n()
  {
    QQPlayerService.a(BaseApplicationImpl.getContext());
    d(false);
  }
  
  public void o()
  {
    QQPlayerService.c(BaseApplicationImpl.getContext());
    p();
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    if (paramSongInfo.jdField_b_of_type_Int == 10)
    {
      if (this.jdField_a_of_type_Aztp != null) {
        this.jdField_a_of_type_Aztp.a(paramSongInfo, this.h);
      }
      q();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileMusicBoxController", 2, "onPlaySongChanged newSong:" + paramSongInfo.c);
      }
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    int k = 1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileMusicBoxController", 2, "onPlayStateChanged playState:" + paramInt);
      }
      return;
      Object localObject = QQPlayerService.b();
      if (((SongInfo)localObject).jdField_b_of_type_Int == 10)
      {
        if (this.jdField_a_of_type_Aztp != null) {
          this.jdField_a_of_type_Aztp.a((SongInfo)localObject, true);
        }
        a((SongInfo)localObject);
        if (!a()) {
          a(String.valueOf(this.jdField_a_of_type_Long));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(true);
        }
        this.h = true;
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      else
      {
        m();
        continue;
        if (this.jdField_a_of_type_Aztp != null) {
          this.jdField_a_of_type_Aztp.a(2);
        }
        d(false);
        this.h = false;
        long l = this.jdField_a_of_type_Long;
        if (this.i)
        {
          localObject = "0X800A7D9";
          label220:
          if (!behx.a().a()) {
            break label281;
          }
        }
        for (;;)
        {
          bdla.b(null, "dc00898", "", String.valueOf(l), "qq_vip", (String)localObject, k, 0, String.valueOf((System.currentTimeMillis() - this.jdField_b_of_type_Long) / 1000L), "", "", "");
          break;
          localObject = "0X800A7DE";
          break label220;
          label281:
          k = 2;
        }
        p();
        this.h = false;
        continue;
        this.h = false;
        localObject = QQPlayerService.b();
        if ((localObject != null) && (((SongInfo)localObject).jdField_b_of_type_Int == 10))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(((SongInfo)localObject).g);
          a(this.jdField_a_of_type_Long, localArrayList);
          continue;
          localObject = QQPlayerService.b();
          if ((localObject != null) && (TextUtils.isEmpty(((SongInfo)localObject).jdField_b_of_type_JavaLangString)) && (((SongInfo)localObject).jdField_b_of_type_Int == 10))
          {
            this.h = false;
            localArrayList = new ArrayList();
            localArrayList.add(((SongInfo)localObject).g);
            a(this.jdField_a_of_type_Long, localArrayList);
          }
        }
      }
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetMusicListRsp)))
    {
      paramObject = (GetMusicListRsp)paramObject;
      ArrayList localArrayList = new ArrayList();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo = new SongInfo[paramObject.stMusicList.vMusicList.size()];
      paramInt = 0;
      while (paramInt < paramObject.stMusicList.vMusicList.size())
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt] = new SongInfo();
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].g = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongId;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].jdField_d_of_type_JavaLangString = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sAlbumName;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].e = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sPic;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].c = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongName;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].jdField_d_of_type_Long = ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).iDuration;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].jdField_b_of_type_Int = 10;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].g.equals(this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.g)) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_b_of_type_JavaLangString;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        int k = 0;
        while (k < ((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).vSingerList.size())
        {
          if (k != 0) {
            localStringBuilder.append("/");
          }
          localStringBuilder.append(((SingerInfo)((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).vSingerList.get(k)).sSingerName);
          k += 1;
        }
        this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[paramInt].h = localStringBuilder.toString();
        localArrayList.add(((MusicInfo)paramObject.stMusicList.vMusicList.get(paramInt)).sSongId);
        paramInt += 1;
      }
      QQPlayerService.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo);
      q();
    }
  }
  
  public void p()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ProfileMusicBoxController.2(this));
    awgx localawgx = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    JSONObject localJSONObject;
    if ((localawgx != null) && (!ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b())) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("type", "musicboxResume");
      localJSONObject.put("uin", localawgx.a().jdField_b_of_type_JavaLangString);
      localJSONObject.put("uinType", localawgx.a().e);
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localJSONObject);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileMusicBoxController", 2, "resetState");
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void q()
  {
    SongInfo localSongInfo = QQPlayerService.c();
    Object localObject = QQPlayerService.b();
    if ((localSongInfo != null) && (localObject != null) && (localSongInfo.jdField_b_of_type_Int == 10) && (!TextUtils.isEmpty(localSongInfo.g)) && (!localSongInfo.g.equals(((SongInfo)localObject).g)))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(localSongInfo.g);
      a(this.jdField_a_of_type_Long, (ArrayList)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztn
 * JD-Core Version:    0.7.0.1
 */