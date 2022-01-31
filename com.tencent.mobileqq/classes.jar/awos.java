import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.transfile.VasApngDownloader;

public class awos
  extends URLDrawableParams
{
  private axnz jdField_a_of_type_Axnz;
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
  
  public awos(Application paramApplication)
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
        this.jdField_a_of_type_ComTencentImageProtocolDownloader = new axrg(bool, paramObject);
        return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
        label52:
        bool = false;
      }
    }
    if (("nearbyimage".equals(paramString)) || ("nearbylocalimage".equals(paramString)))
    {
      if (this.f == null) {
        this.f = new axsk();
      }
      return this.f;
    }
    if (("chatthumb".equals(paramString)) || ("chatimg".equals(paramString)) || ("chatraw".equals(paramString)))
    {
      if (this.b == null) {
        this.b = new axpm(BaseApplicationImpl.getApplication());
      }
      return this.b;
    }
    if (("lbsthumb".equals(paramString)) || ("lbsimg".equals(paramString)))
    {
      if (this.c == null) {
        this.c = new axrx(BaseApplicationImpl.getApplication());
      }
      return this.c;
    }
    if ("datalineimage".equals(paramString)) {
      return new axpo(BaseApplicationImpl.getApplication());
    }
    if ("datalineface".equals(paramString)) {
      return new axpr(BaseApplicationImpl.getApplication());
    }
    if ("emotion".equals(paramString)) {
      return new axpx(BaseApplicationImpl.getApplication());
    }
    if ("emotion_pic".equals(paramString)) {
      return new axsv(BaseApplicationImpl.getApplication());
    }
    if ("favorite".equals(paramString)) {
      return new ankk(BaseApplicationImpl.getApplication());
    }
    if ("albumthumb".equals(paramString)) {
      return new axoh(BaseApplicationImpl.getApplication());
    }
    if ("videothumb".equals(paramString)) {
      return new axwl();
    }
    if ("videocover".equals(paramString)) {
      return new axwi();
    }
    if ("pubaccountimage".equals(paramString)) {
      return new rsl(BaseApplicationImpl.getApplication());
    }
    if ("location".equals(paramString)) {
      return new axsg(BaseApplicationImpl.getApplication());
    }
    if (("billdthumb".equals(paramString)) || ("billdimg".equals(paramString)))
    {
      if (this.d == null) {
        this.d = new axsf(BaseApplicationImpl.getApplication());
      }
      return this.d;
    }
    if (("profile_img_big".equals(paramString)) || ("profile_img_thumb".equals(paramString)) || ("profile_img_icon".equals(paramString)) || ("profile_img_big_fhd".equals(paramString)))
    {
      if (this.e == null) {
        this.e = new axsy();
      }
      return this.e;
    }
    if ("qzone_cover".equals(paramString)) {
      return new axtq();
    }
    if ("favimage".equals(paramString)) {
      return new axqb(BaseApplicationImpl.getApplication());
    }
    if ("fileassistantimage".equals(paramString)) {
      return new axqc(BaseApplicationImpl.getApplication());
    }
    if ("filegalleryorigimage".equals(paramString)) {
      return new axsw(BaseApplicationImpl.getApplication());
    }
    if ("troop_photo_qzone".equals(paramString)) {
      return new axtr();
    }
    if ("aiothumb".equals(paramString))
    {
      if (this.jdField_a_of_type_Axnz == null) {
        this.jdField_a_of_type_Axnz = new axnz(BaseApplicationImpl.getApplication());
      }
      return this.jdField_a_of_type_Axnz;
    }
    if ("protocol_pendant_image".equals(paramString)) {
      return new axol();
    }
    if (("file".equals(paramString)) && (BaseApplicationImpl.sApplication.getQQProcessName().endsWith(":peak"))) {
      return new adyr(BaseApplicationImpl.getApplication());
    }
    if ("regionalthumb".equals(paramString)) {
      return new axts(BaseApplicationImpl.getApplication());
    }
    if ("third_part".equals(paramString)) {
      return new axvk(BaseApplicationImpl.getApplication());
    }
    if ("gamead".equals(paramString)) {
      return new axry();
    }
    if ("shortvideothumb".equals(paramString)) {
      return new axut();
    }
    if ("shortvideoforpicthumb".equals(paramString)) {
      return new axum();
    }
    if ("devicemsgthumb".equals(paramString)) {
      return new axps();
    }
    if ("carrier".equals(paramString)) {
      return new axpl();
    }
    if ("aioflower".equals(paramString)) {
      return new axny();
    }
    if (("sig_cover".equals(paramString)) || ("sig_zip".equals(paramString))) {
      return new axvb();
    }
    if ("themediydownloader".equals(paramString)) {
      return new axvj();
    }
    if ("vasapngdownloader".equals(paramString)) {
      return new VasApngDownloader();
    }
    if ("funny_pic".equals(paramString)) {
      return new ajjo();
    }
    if ("redtouchpicdownloadprotoc".equals(paramString)) {
      return new auqj(BaseApplicationImpl.getApplication());
    }
    if ("protocol_vas_extension_image".equals(paramString)) {
      return new axwg(BaseApplicationImpl.getApplication());
    }
    if ("apollo_pic".equals(paramString)) {
      return new aizb(BaseApplicationImpl.getApplication());
    }
    if ("apollo_gif".equals(paramString)) {
      return new adab();
    }
    if ("apollo_image".equals(paramString)) {
      return new aitu();
    }
    if ("hot_pic".equals(paramString))
    {
      if (this.g == null) {
        this.g = new aqes();
      }
      return this.g;
    }
    if ("hot_pic_origin".equals(paramString)) {
      return new aqfd();
    }
    if ("hot_video_preview".equals(paramString))
    {
      if (this.h == null) {
        this.h = new aqgq();
      }
      return this.h;
    }
    if ("readinjoy_skin_gif".equals(paramString)) {
      return new pog();
    }
    if ("pubaccountimage_gifplaytime".equals(paramString)) {
      return new rrm(BaseApplicationImpl.getApplication());
    }
    if ("qzonecontentboxdownloader".equals(paramString)) {
      return new bfui();
    }
    if ("qwallet_downloader".equals(paramString)) {
      return new agqe();
    }
    if ("sticker_recommended_pic".equals(paramString))
    {
      if (this.i == null) {
        this.i = new aemd();
      }
      return this.i;
    }
    if ("albumthumbpreview".equals(paramString))
    {
      if (this.j == null) {
        this.j = new axog();
      }
      return this.j;
    }
    if ("webcover".equals(paramString)) {
      return new altw();
    }
    return null;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return baon.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837759);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837854);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awos
 * JD-Core Version:    0.7.0.1
 */