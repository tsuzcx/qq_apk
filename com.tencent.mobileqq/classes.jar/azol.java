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

public class azol
  extends URLDrawableParams
{
  private baqm jdField_a_of_type_Baqm;
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
  
  public azol(Application paramApplication)
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
        this.jdField_a_of_type_ComTencentImageProtocolDownloader = new batt(bool, paramObject);
        return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
        label52:
        bool = false;
      }
    }
    if (("nearbyimage".equals(paramString)) || ("nearbylocalimage".equals(paramString)))
    {
      if (this.f == null) {
        this.f = new bauz();
      }
      return this.f;
    }
    if (("chatthumb".equals(paramString)) || ("chatimg".equals(paramString)) || ("chatraw".equals(paramString)))
    {
      if (this.b == null) {
        this.b = new barz(BaseApplicationImpl.getApplication());
      }
      return this.b;
    }
    if (("lbsthumb".equals(paramString)) || ("lbsimg".equals(paramString)))
    {
      if (this.c == null) {
        this.c = new baum(BaseApplicationImpl.getApplication());
      }
      return this.c;
    }
    if ("datalineimage".equals(paramString)) {
      return new basb(BaseApplicationImpl.getApplication());
    }
    if ("datalineface".equals(paramString)) {
      return new base(BaseApplicationImpl.getApplication());
    }
    if ("emotion".equals(paramString)) {
      return new bask(BaseApplicationImpl.getApplication());
    }
    if ("emotion_pic".equals(paramString)) {
      return new bavk(BaseApplicationImpl.getApplication());
    }
    if ("favorite".equals(paramString)) {
      return new apxe(BaseApplicationImpl.getApplication());
    }
    if ("albumthumb".equals(paramString)) {
      return new AlbumThumbDownloader(BaseApplicationImpl.getApplication());
    }
    if ("videothumb".equals(paramString)) {
      return new bazc();
    }
    if ("videocover".equals(paramString)) {
      return new bayz();
    }
    if ("pubaccountimage".equals(paramString)) {
      return new swu(BaseApplicationImpl.getApplication());
    }
    if ("location".equals(paramString)) {
      return new bauv(BaseApplicationImpl.getApplication());
    }
    if (("billdthumb".equals(paramString)) || ("billdimg".equals(paramString)))
    {
      if (this.d == null) {
        this.d = new bauu(BaseApplicationImpl.getApplication());
      }
      return this.d;
    }
    if (("profile_img_big".equals(paramString)) || ("profile_img_thumb".equals(paramString)) || ("profile_img_icon".equals(paramString)) || ("profile_img_big_fhd".equals(paramString)))
    {
      if (this.e == null) {
        this.e = new bavn();
      }
      return this.e;
    }
    if ("qzone_cover".equals(paramString)) {
      return new bawg();
    }
    if ("favimage".equals(paramString)) {
      return new baso(BaseApplicationImpl.getApplication());
    }
    if ("fileassistantimage".equals(paramString)) {
      return new basp(BaseApplicationImpl.getApplication());
    }
    if ("filegalleryorigimage".equals(paramString)) {
      return new bavl(BaseApplicationImpl.getApplication());
    }
    if ("troop_photo_qzone".equals(paramString)) {
      return new bawh();
    }
    if ("aiothumb".equals(paramString))
    {
      if (this.jdField_a_of_type_Baqm == null) {
        this.jdField_a_of_type_Baqm = new baqm(BaseApplicationImpl.getApplication());
      }
      return this.jdField_a_of_type_Baqm;
    }
    if ("protocol_pendant_image".equals(paramString)) {
      return new baqx();
    }
    if (("file".equals(paramString)) && (BaseApplicationImpl.sApplication.getQQProcessName().endsWith(":peak"))) {
      return new agkv(BaseApplicationImpl.getApplication());
    }
    if ("regionalthumb".equals(paramString)) {
      return new bawj(BaseApplicationImpl.getApplication());
    }
    if ("third_part".equals(paramString)) {
      return new bayb(BaseApplicationImpl.getApplication());
    }
    if ("gamead".equals(paramString)) {
      return new baun();
    }
    if ("shortvideothumb".equals(paramString)) {
      return new baxk();
    }
    if ("shortvideoforpicthumb".equals(paramString)) {
      return new baxd();
    }
    if ("devicemsgthumb".equals(paramString)) {
      return new basf();
    }
    if ("carrier".equals(paramString)) {
      return new bary();
    }
    if ("aioflower".equals(paramString)) {
      return new baql();
    }
    if (("sig_cover".equals(paramString)) || ("sig_zip".equals(paramString))) {
      return new baxs();
    }
    if ("themediydownloader".equals(paramString)) {
      return new baya();
    }
    if ("vasapngdownloader".equals(paramString)) {
      return new VasApngDownloader();
    }
    if ("funny_pic".equals(paramString)) {
      return new altt();
    }
    if ("redtouchpicdownloadprotoc".equals(paramString)) {
      return new axmb(BaseApplicationImpl.getApplication());
    }
    if ("protocol_vas_extension_image".equals(paramString)) {
      return new bayx(BaseApplicationImpl.getApplication());
    }
    if ("apollo_pic".equals(paramString)) {
      return new aljd(BaseApplicationImpl.getApplication());
    }
    if ("apollo_gif".equals(paramString)) {
      return new afia();
    }
    if ("apollo_image".equals(paramString)) {
      return new aldt();
    }
    if ("hot_pic".equals(paramString))
    {
      if (this.g == null) {
        this.g = new astt();
      }
      return this.g;
    }
    if ("hot_pic_origin".equals(paramString)) {
      return new asue();
    }
    if ("hot_video_preview".equals(paramString))
    {
      if (this.h == null) {
        this.h = new asvr();
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
      return new bjja();
    }
    if ("qwallet_downloader".equals(paramString)) {
      return new ajbk();
    }
    if ("sticker_recommended_pic".equals(paramString))
    {
      if (this.i == null) {
        this.i = new agyq();
      }
      return this.i;
    }
    if ("albumthumbpreview".equals(paramString))
    {
      if (this.j == null) {
        this.j = new baqt();
      }
      return this.j;
    }
    if ("webcover".equals(paramString)) {
      return new aodz();
    }
    if ("qqsys_emoji".equals(paramString)) {
      return new bawf();
    }
    return null;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return bdua.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837965);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837968);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azol
 * JD-Core Version:    0.7.0.1
 */