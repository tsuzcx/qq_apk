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

public class bcpq
  extends URLDrawableParams
{
  private bdsg jdField_a_of_type_Bdsg;
  private ProtocolDownloader jdField_a_of_type_ComTencentImageProtocolDownloader;
  private ProtocolDownloader b;
  private ProtocolDownloader c;
  private ProtocolDownloader d;
  private ProtocolDownloader e;
  private ProtocolDownloader f;
  private ProtocolDownloader g;
  private ProtocolDownloader h;
  private ProtocolDownloader i;
  
  public bcpq(Application paramApplication)
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
        this.jdField_a_of_type_ComTencentImageProtocolDownloader = new bdvl(bool, paramObject);
        return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
        label52:
        bool = false;
      }
    }
    if (("nearbyimage".equals(paramString)) || ("nearbylocalimage".equals(paramString)))
    {
      if (this.e == null) {
        this.e = new bdwn();
      }
      return this.e;
    }
    if (("chatthumb".equals(paramString)) || ("chatimg".equals(paramString)) || ("chatraw".equals(paramString)))
    {
      if (this.b == null) {
        this.b = new bdtr(BaseApplicationImpl.getApplication());
      }
      return this.b;
    }
    if ("datalineimage".equals(paramString)) {
      return new bdtt(BaseApplicationImpl.getApplication());
    }
    if ("datalineface".equals(paramString)) {
      return new bdtw(BaseApplicationImpl.getApplication());
    }
    if ("emotion".equals(paramString)) {
      return new bduc(BaseApplicationImpl.getApplication());
    }
    if ("emotion_pic".equals(paramString)) {
      return new bdwy(BaseApplicationImpl.getApplication());
    }
    if ("favorite".equals(paramString)) {
      return new asay();
    }
    if ("albumthumb".equals(paramString)) {
      return new AlbumThumbDownloader();
    }
    if ("videothumb".equals(paramString)) {
      return new beae();
    }
    if ("videocover".equals(paramString)) {
      return new beac();
    }
    if ("pubaccountimage".equals(paramString)) {
      return new tyc(BaseApplicationImpl.getApplication());
    }
    if (("billdthumb".equals(paramString)) || ("billdimg".equals(paramString)))
    {
      if (this.c == null) {
        this.c = new bdwj(BaseApplicationImpl.getApplication());
      }
      return this.c;
    }
    if (("profile_img_big".equals(paramString)) || ("profile_img_thumb".equals(paramString)) || ("profile_img_icon".equals(paramString)) || ("profile_img_big_fhd".equals(paramString)))
    {
      if (this.d == null) {
        this.d = new bdxb();
      }
      return this.d;
    }
    if ("qzone_cover".equals(paramString)) {
      return new bdxo();
    }
    if ("favimage".equals(paramString)) {
      return new bdug(BaseApplicationImpl.getApplication());
    }
    if ("fileassistantimage".equals(paramString)) {
      return new bduh(BaseApplicationImpl.getApplication());
    }
    if ("filegalleryorigimage".equals(paramString)) {
      return new bdwz(BaseApplicationImpl.getApplication());
    }
    if ("troop_photo_qzone".equals(paramString)) {
      return new bdxp();
    }
    if ("aiothumb".equals(paramString))
    {
      if (this.jdField_a_of_type_Bdsg == null) {
        this.jdField_a_of_type_Bdsg = new bdsg(BaseApplicationImpl.getApplication());
      }
      return this.jdField_a_of_type_Bdsg;
    }
    if ("protocol_pendant_image".equals(paramString)) {
      return new bdso();
    }
    if (("file".equals(paramString)) && (BaseApplicationImpl.sApplication.getQQProcessName().endsWith(":peak"))) {
      return new ahuy(BaseApplicationImpl.getApplication());
    }
    if ("regionalthumb".equals(paramString)) {
      return new bdxq(BaseApplicationImpl.getApplication());
    }
    if ("third_part".equals(paramString)) {
      return new bdze(BaseApplicationImpl.getApplication());
    }
    if ("gamead".equals(paramString)) {
      return new bdwc();
    }
    if ("shortvideothumb".equals(paramString)) {
      return new bdyp();
    }
    if ("shortvideoforpicthumb".equals(paramString)) {
      return new bdyj();
    }
    if ("devicemsgthumb".equals(paramString)) {
      return new bdtx();
    }
    if ("carrier".equals(paramString)) {
      return new bdtq();
    }
    if ("aioflower".equals(paramString)) {
      return new bdsf();
    }
    if (("sig_cover".equals(paramString)) || ("sig_zip".equals(paramString))) {
      return new bdyv();
    }
    if ("themediydownloader".equals(paramString)) {
      return new bdzd();
    }
    if ("vasapngdownloader".equals(paramString)) {
      return new VasApngDownloader();
    }
    if ("funny_pic".equals(paramString)) {
      return new annb();
    }
    if ("redtouchpicdownloadprotoc".equals(paramString)) {
      return new baii(BaseApplicationImpl.getApplication());
    }
    if ("protocol_vas_extension_image".equals(paramString)) {
      return new beaa(BaseApplicationImpl.getApplication());
    }
    if ("apollo_pic".equals(paramString)) {
      return new ancl(BaseApplicationImpl.getApplication());
    }
    if ("apollo_gif".equals(paramString)) {
      return new agpi();
    }
    if ("apollo_image".equals(paramString)) {
      return new amwz();
    }
    if ("hot_pic".equals(paramString))
    {
      if (this.f == null) {
        this.f = new avbc();
      }
      return this.f;
    }
    if ("hot_pic_origin".equals(paramString)) {
      return new avbn();
    }
    if ("hot_video_preview".equals(paramString))
    {
      if (this.g == null) {
        this.g = new avda();
      }
      return this.g;
    }
    if ("readinjoy_skin_gif".equals(paramString)) {
      return new rdw();
    }
    if ("pubaccountimage_gifplaytime".equals(paramString)) {
      return new txb(BaseApplicationImpl.getApplication());
    }
    if ("qzonecontentboxdownloader".equals(paramString)) {
      return new blxi();
    }
    if ("qwallet_downloader".equals(paramString)) {
      return new aktd();
    }
    if ("sticker_recommended_pic".equals(paramString))
    {
      if (this.h == null) {
        this.h = new aijk();
      }
      return this.h;
    }
    if ("albumthumbpreview".equals(paramString))
    {
      if (this.i == null) {
        this.i = new bdsk();
      }
      return this.i;
    }
    if ("webcover".equals(paramString)) {
      return new aqek();
    }
    if ("qqsys_emoji".equals(paramString)) {
      return new bdxn();
    }
    return null;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return bgzd.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838059);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838062);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpq
 * JD-Core Version:    0.7.0.1
 */