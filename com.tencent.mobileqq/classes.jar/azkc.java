import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.VasApngDownloader;

public class azkc
  extends URLDrawableParams
{
  private bamd jdField_a_of_type_Bamd;
  private ProtocolDownloader jdField_a_of_type_ComTencentImageProtocolDownloader;
  private ProtocolDownloader b;
  private ProtocolDownloader c;
  private ProtocolDownloader d;
  private ProtocolDownloader e;
  private ProtocolDownloader f;
  private ProtocolDownloader g;
  private ProtocolDownloader h;
  private ProtocolDownloader i;
  private ProtocolDownloader j;
  
  public azkc(Application paramApplication)
  {
    super(paramApplication);
    this.mFadeInImage = false;
    this.mUseGifAnimation = false;
    this.mMemoryCache = BaseApplicationImpl.sImageCache;
  }
  
  public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    boolean bool = true;
    if (("http".equals(paramString)) || ("https".equals(paramString)))
    {
      if (this.jdField_a_of_type_ComTencentImageProtocolDownloader == null) {
        if (BaseApplicationImpl.sProcessId != 1) {
          break label52;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentImageProtocolDownloader = new bapk(bool, paramObject);
        return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
        label52:
        bool = false;
      }
    }
    if (("nearbyimage".equals(paramString)) || ("nearbylocalimage".equals(paramString)))
    {
      if (this.f == null) {
        this.f = new baqq();
      }
      return this.f;
    }
    if (("chatthumb".equals(paramString)) || ("chatimg".equals(paramString)) || ("chatraw".equals(paramString)))
    {
      if (this.b == null) {
        this.b = new banq(BaseApplicationImpl.getApplication());
      }
      return this.b;
    }
    if (("lbsthumb".equals(paramString)) || ("lbsimg".equals(paramString)))
    {
      if (this.c == null) {
        this.c = new baqd(BaseApplicationImpl.getApplication());
      }
      return this.c;
    }
    if ("datalineimage".equals(paramString)) {
      return new bans(BaseApplicationImpl.getApplication());
    }
    if ("datalineface".equals(paramString)) {
      return new banv(BaseApplicationImpl.getApplication());
    }
    if ("emotion".equals(paramString)) {
      return new baob(BaseApplicationImpl.getApplication());
    }
    if ("emotion_pic".equals(paramString)) {
      return new barb(BaseApplicationImpl.getApplication());
    }
    if ("favorite".equals(paramString)) {
      return new apsv(BaseApplicationImpl.getApplication());
    }
    if ("albumthumb".equals(paramString)) {
      return new AlbumThumbDownloader(BaseApplicationImpl.getApplication());
    }
    if ("videothumb".equals(paramString)) {
      return new baut();
    }
    if ("videocover".equals(paramString)) {
      return new bauq();
    }
    if ("pubaccountimage".equals(paramString)) {
      return new swu(BaseApplicationImpl.getApplication());
    }
    if ("location".equals(paramString)) {
      return new baqm(BaseApplicationImpl.getApplication());
    }
    if (("billdthumb".equals(paramString)) || ("billdimg".equals(paramString)))
    {
      if (this.d == null) {
        this.d = new baql(BaseApplicationImpl.getApplication());
      }
      return this.d;
    }
    if (("profile_img_big".equals(paramString)) || ("profile_img_thumb".equals(paramString)) || ("profile_img_icon".equals(paramString)) || ("profile_img_big_fhd".equals(paramString)))
    {
      if (this.e == null) {
        this.e = new bare();
      }
      return this.e;
    }
    if ("qzone_cover".equals(paramString)) {
      return new barx();
    }
    if ("favimage".equals(paramString)) {
      return new baof(BaseApplicationImpl.getApplication());
    }
    if ("fileassistantimage".equals(paramString)) {
      return new baog(BaseApplicationImpl.getApplication());
    }
    if ("filegalleryorigimage".equals(paramString)) {
      return new barc(BaseApplicationImpl.getApplication());
    }
    if ("troop_photo_qzone".equals(paramString)) {
      return new bary();
    }
    if ("aiothumb".equals(paramString))
    {
      if (this.jdField_a_of_type_Bamd == null) {
        this.jdField_a_of_type_Bamd = new bamd(BaseApplicationImpl.getApplication());
      }
      return this.jdField_a_of_type_Bamd;
    }
    if ("protocol_pendant_image".equals(paramString)) {
      return new bamo();
    }
    if (("file".equals(paramString)) && (BaseApplicationImpl.sApplication.getQQProcessName().endsWith(":peak"))) {
      return new aggg(BaseApplicationImpl.getApplication());
    }
    if ("regionalthumb".equals(paramString)) {
      return new basa(BaseApplicationImpl.getApplication());
    }
    if ("third_part".equals(paramString)) {
      return new bats(BaseApplicationImpl.getApplication());
    }
    if ("gamead".equals(paramString)) {
      return new baqe();
    }
    if ("shortvideothumb".equals(paramString)) {
      return new batb();
    }
    if ("shortvideoforpicthumb".equals(paramString)) {
      return new basu();
    }
    if ("devicemsgthumb".equals(paramString)) {
      return new banw();
    }
    if ("carrier".equals(paramString)) {
      return new banp();
    }
    if ("aioflower".equals(paramString)) {
      return new bamc();
    }
    if (("sig_cover".equals(paramString)) || ("sig_zip".equals(paramString))) {
      return new batj();
    }
    if ("themediydownloader".equals(paramString)) {
      return new batr();
    }
    if ("vasapngdownloader".equals(paramString)) {
      return new VasApngDownloader();
    }
    if ("funny_pic".equals(paramString)) {
      return new alpe();
    }
    if ("redtouchpicdownloadprotoc".equals(paramString)) {
      return new axhs(BaseApplicationImpl.getApplication());
    }
    if ("protocol_vas_extension_image".equals(paramString)) {
      return new bauo(BaseApplicationImpl.getApplication());
    }
    if ("apollo_pic".equals(paramString)) {
      return new aleo(BaseApplicationImpl.getApplication());
    }
    if ("apollo_gif".equals(paramString)) {
      return new afdl();
    }
    if ("apollo_image".equals(paramString)) {
      return new akze();
    }
    if ("hot_pic".equals(paramString))
    {
      if (this.g == null) {
        this.g = new aspk();
      }
      return this.g;
    }
    if ("hot_pic_origin".equals(paramString)) {
      return new aspv();
    }
    if ("hot_video_preview".equals(paramString))
    {
      if (this.h == null) {
        this.h = new asri();
      }
      return this.h;
    }
    if ("readinjoy_skin_gif".equals(paramString)) {
      return new qjt();
    }
    if ("pubaccountimage_gifplaytime".equals(paramString)) {
      return new svu(BaseApplicationImpl.getApplication());
    }
    if ("qzonecontentboxdownloader".equals(paramString)) {
      return new bjet();
    }
    if ("qwallet_downloader".equals(paramString)) {
      return new aiwv();
    }
    if ("sticker_recommended_pic".equals(paramString))
    {
      if (this.i == null) {
        this.i = new agub();
      }
      return this.i;
    }
    if ("albumthumbpreview".equals(paramString))
    {
      if (this.j == null) {
        this.j = new bamk();
      }
      return this.j;
    }
    if ("webcover".equals(paramString)) {
      return new anzq();
    }
    if ("qqsys_emoji".equals(paramString)) {
      return new barw();
    }
    return null;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return bdpr.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837964);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837967);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkc
 * JD-Core Version:    0.7.0.1
 */