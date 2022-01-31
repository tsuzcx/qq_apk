import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.io.File;

public class atkm
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  protected Context a;
  protected Handler a;
  protected ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  athz jdField_a_of_type_Athz;
  atjf jdField_a_of_type_Atjf;
  public atkv a;
  protected atkx a;
  protected QQAppInterface a;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  public String a;
  public boolean a;
  private final int jdField_b_of_type_Int = 1024;
  long jdField_b_of_type_Long = 0L;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int = -2147483648;
  long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = 2025;
  private long jdField_d_of_type_Long = -1L;
  private boolean jdField_d_of_type_Boolean;
  private final int e = 2026;
  
  public atkm(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Atkx = a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Athz = new athz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public static TVK_ICacheMgr a()
  {
    if (!TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext())) {
      a(BaseApplicationImpl.getContext());
    }
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext())) {
      return TVK_SDKMgr.getProxyFactory().getCacheMgr(BaseApplicationImpl.getContext());
    }
    return null;
  }
  
  public static String a(File paramFile)
  {
    if (paramFile.exists())
    {
      String str3 = paramFile.getParentFile().getAbsolutePath();
      String str2 = paramFile.getName();
      String str1 = str2;
      if (str2.endsWith(".tmp")) {
        str1 = str2.substring(0, str2.length() - ".tmp".length());
      }
      str1 = str3 + "/" + str1;
      paramFile.renameTo(new File(str1));
      return str1;
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    return MD5.toMD5(paramString);
  }
  
  public static void a(Context paramContext)
  {
    TVK_SDKMgr.setOnLogListener(new atku(null));
    TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "startPreloadVideo");
    }
    TVK_ICacheMgr localTVK_ICacheMgr = a();
    if (localTVK_ICacheMgr == null) {
      QLog.w("VideoPlayerView", 1, "preloadVideo failed , cacheMgr==null!");
    }
    Object localObject = ajsf.aW + ".now_video/" + "vid_" + a(paramString) + ".mp4";
    if (new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "file.exists ! use local file");
      }
      return;
    }
    localObject = atld.a(sul.a("vid_" + a(paramString), 0), (String)localObject + ".tmp", 0L);
    ((TVK_PlayerVideoInfo)localObject).setConfigMap("cache_duration", "5");
    paramString = ayxe.b(paramString.replace("https://", "http://"), 1012);
    localTVK_ICacheMgr.setPreloadCallback(new atkn());
    localTVK_ICacheMgr.preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramString, null, (TVK_PlayerVideoInfo)localObject);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Atkx.a();
  }
  
  public atkx a()
  {
    if (!TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext)) {
      a(this.jdField_a_of_type_AndroidContentContext);
    }
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext)) {
      return new atld(this.jdField_a_of_type_AndroidContentContext);
    }
    QLog.w("VideoPlayerView", 1, "use VideoViewTextureImpl!");
    return new atlk(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "pause");
    }
    this.jdField_a_of_type_Atkx.c();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Long = a();
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368544));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365315));
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2026);
    }
    this.jdField_a_of_type_AndroidOsHandler = new atko(this, this.jdField_a_of_type_AndroidContentContext.getMainLooper());
  }
  
  public void a(RelativeLayout paramRelativeLayout, VideoData paramVideoData, atjf paramatjf)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    a(paramRelativeLayout);
    a(paramVideoData);
  }
  
  public void a(atkv paramatkv)
  {
    this.jdField_a_of_type_Atkv = paramatkv;
  }
  
  public void a(VideoData paramVideoData)
  {
    String str = paramVideoData.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    boolean bool2 = c();
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_b_of_type_JavaLangString = str;
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "play(String videoPath)! path is: " + str + "play stack is: " + Log.getStackTraceString(new Throwable()));
    }
    if (this.jdField_a_of_type_Atkx != null) {
      this.jdField_a_of_type_Atkx.a();
    }
    if ((this.jdField_a_of_type_Atkx != null) && (this.jdField_a_of_type_Atkx.a() != null) && (this.jdField_a_of_type_Atkx.a().getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_Atkx.a().getParent()).removeView(this.jdField_a_of_type_Atkx.a());
    }
    this.jdField_a_of_type_Atkx = a();
    Object localObject;
    if ((this.jdField_a_of_type_Atkx instanceof atld))
    {
      localObject = (atld)this.jdField_a_of_type_Atkx;
      if (paramVideoData.k >= paramVideoData.l) {
        break label225;
      }
    }
    label225:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((atld)localObject).a(bool1);
      if (this.jdField_a_of_type_Atkx != null) {
        break;
      }
      QLog.e("VideoPlayerView", 1, "mPlayer == null!");
      return;
    }
    if ((this.jdField_a_of_type_Atkx != null) && (this.jdField_a_of_type_Atkx.a() != null) && (this.jdField_a_of_type_Atkx.a().getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_Atkx.a().getParent()).removeView(this.jdField_a_of_type_Atkx.a());
    }
    if (this.jdField_a_of_type_Atkx != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Atkx.a(), 0, new RelativeLayout.LayoutParams(-1, -1));
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
    this.jdField_a_of_type_Int = 1;
    ativ.jdField_a_of_type_Int = 0;
    ativ.jdField_a_of_type_Long = System.currentTimeMillis();
    ativ.c = paramVideoData.jdField_a_of_type_JavaLangString;
    ativ.d = String.valueOf(paramVideoData.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Atkv != null) {
      this.jdField_a_of_type_Atkv.d();
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_Atkx.a(new atkp(this));
        this.jdField_a_of_type_Atkx.a(new atkq(this));
        this.jdField_a_of_type_Atkx.a(new atkr(this));
        this.jdField_a_of_type_Atkx.a(new atks(this, paramVideoData));
        localObject = ajsf.aW + ".now_video/" + "vid_" + a(str) + ".mp4";
        localFile = new File((String)localObject);
        if (localFile.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.i("VideoPlayerView", 2, "file.exists ! use local file");
          }
          this.jdField_a_of_type_Long = localFile.length();
          this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
          this.jdField_a_of_type_Atkx.a("vid_" + a(str), (String)localObject, str, paramVideoData.f);
          this.jdField_a_of_type_Atkx.a(new atkt(this, paramVideoData, bool2));
          if (QLog.isColorLevel()) {
            QLog.i("VideoPlayerView", 2, "player start!");
          }
          this.jdField_c_of_type_Boolean = false;
          return;
        }
      }
      catch (Exception paramVideoData)
      {
        Log.e("VideoPlayerView", paramVideoData.toString());
        return;
      }
      File localFile = new File((String)localObject + ".tmp");
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "use remote file,tmp's exsit=" + localFile.exists());
      }
      this.jdField_a_of_type_Atkx.a("vid_" + a(str), (String)localObject + ".tmp", str, paramVideoData.f);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Atkx.a();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "resume");
      }
      this.jdField_a_of_type_Atkx.b();
      this.jdField_a_of_type_Atkx.a(this.jdField_c_of_type_Long);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("VideoPlayerView", 2, "!not paused no resume!");
  }
  
  public boolean b()
  {
    ativ.jdField_a_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "restart");
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString;
    if (c()) {}
    for (int i = 1;; i = 2)
    {
      atiw.a(str, i, "0", "0");
      atiw.a(2);
      atiw.d();
      this.jdField_a_of_type_Atkx.d();
      return true;
    }
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {}
    Object localObject;
    do
    {
      return 0L;
      localObject = ajsf.aW + ".now_video/" + "vid_" + a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_b_of_type_JavaLangString) + ".mp4";
      if (new File((String)localObject).exists()) {
        return ((String)localObject).length();
      }
      localObject = new File(ajsf.aW + ".now_video/" + "vid_" + a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_b_of_type_JavaLangString) + ".mp4.tmp");
    } while (!((File)localObject).exists());
    return ((File)localObject).length();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "stop");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2026);
    }
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_d_of_type_Boolean = false;
    }
    if ((this.jdField_a_of_type_Atkx != null) && (this.jdField_a_of_type_Atkx.a() != null) && (this.jdField_a_of_type_Atkx.a().getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_Atkx.a().getParent()).removeView(this.jdField_a_of_type_Atkx.a());
    }
    this.jdField_a_of_type_Atkx.a();
    this.jdField_a_of_type_Atjf = null;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {}
    do
    {
      return false;
      if (new File(ajsf.aW + ".now_video/" + "vid_" + a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_b_of_type_JavaLangString) + ".mp4").exists()) {
        return true;
      }
    } while ((this.jdField_b_of_type_Long < this.jdField_a_of_type_Long) || (this.jdField_b_of_type_Long == 0L));
    return true;
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atkm
 * JD-Core Version:    0.7.0.1
 */