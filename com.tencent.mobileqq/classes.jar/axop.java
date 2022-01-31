import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.transfile.VasApngDownloader;

public class axop
  extends URLDrawableParams
{
  private ayof jdField_a_of_type_Ayof;
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
  
  public axop(Application paramApplication)
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
        this.jdField_a_of_type_ComTencentImageProtocolDownloader = new ayrn(bool, paramObject);
        return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
        label52:
        bool = false;
      }
    }
    if (("nearbyimage".equals(paramString)) || ("nearbylocalimage".equals(paramString)))
    {
      if (this.f == null) {
        this.f = new aysr();
      }
      return this.f;
    }
    if (("chatthumb".equals(paramString)) || ("chatimg".equals(paramString)) || ("chatraw".equals(paramString)))
    {
      if (this.b == null) {
        this.b = new aypt(BaseApplicationImpl.getApplication());
      }
      return this.b;
    }
    if (("lbsthumb".equals(paramString)) || ("lbsimg".equals(paramString)))
    {
      if (this.c == null) {
        this.c = new ayse(BaseApplicationImpl.getApplication());
      }
      return this.c;
    }
    if ("datalineimage".equals(paramString)) {
      return new aypv(BaseApplicationImpl.getApplication());
    }
    if ("datalineface".equals(paramString)) {
      return new aypy(BaseApplicationImpl.getApplication());
    }
    if ("emotion".equals(paramString)) {
      return new ayqe(BaseApplicationImpl.getApplication());
    }
    if ("emotion_pic".equals(paramString)) {
      return new aytc(BaseApplicationImpl.getApplication());
    }
    if ("favorite".equals(paramString)) {
      return new aoat(BaseApplicationImpl.getApplication());
    }
    if ("albumthumb".equals(paramString)) {
      return new ayon(BaseApplicationImpl.getApplication());
    }
    if ("videothumb".equals(paramString)) {
      return new ayws();
    }
    if ("videocover".equals(paramString)) {
      return new aywp();
    }
    if ("pubaccountimage".equals(paramString)) {
      return new sfd(BaseApplicationImpl.getApplication());
    }
    if ("location".equals(paramString)) {
      return new aysn(BaseApplicationImpl.getApplication());
    }
    if (("billdthumb".equals(paramString)) || ("billdimg".equals(paramString)))
    {
      if (this.d == null) {
        this.d = new aysm(BaseApplicationImpl.getApplication());
      }
      return this.d;
    }
    if (("profile_img_big".equals(paramString)) || ("profile_img_thumb".equals(paramString)) || ("profile_img_icon".equals(paramString)) || ("profile_img_big_fhd".equals(paramString)))
    {
      if (this.e == null) {
        this.e = new aytf();
      }
      return this.e;
    }
    if ("qzone_cover".equals(paramString)) {
      return new aytx();
    }
    if ("favimage".equals(paramString)) {
      return new ayqi(BaseApplicationImpl.getApplication());
    }
    if ("fileassistantimage".equals(paramString)) {
      return new ayqj(BaseApplicationImpl.getApplication());
    }
    if ("filegalleryorigimage".equals(paramString)) {
      return new aytd(BaseApplicationImpl.getApplication());
    }
    if ("troop_photo_qzone".equals(paramString)) {
      return new ayty();
    }
    if ("aiothumb".equals(paramString))
    {
      if (this.jdField_a_of_type_Ayof == null) {
        this.jdField_a_of_type_Ayof = new ayof(BaseApplicationImpl.getApplication());
      }
      return this.jdField_a_of_type_Ayof;
    }
    if ("protocol_pendant_image".equals(paramString)) {
      return new ayor();
    }
    if (("file".equals(paramString)) && (BaseApplicationImpl.sApplication.getQQProcessName().endsWith(":peak"))) {
      return new aejq(BaseApplicationImpl.getApplication());
    }
    if ("regionalthumb".equals(paramString)) {
      return new aytz(BaseApplicationImpl.getApplication());
    }
    if ("third_part".equals(paramString)) {
      return new ayvr(BaseApplicationImpl.getApplication());
    }
    if ("gamead".equals(paramString)) {
      return new aysf();
    }
    if ("shortvideothumb".equals(paramString)) {
      return new ayva();
    }
    if ("shortvideoforpicthumb".equals(paramString)) {
      return new ayut();
    }
    if ("devicemsgthumb".equals(paramString)) {
      return new aypz();
    }
    if ("carrier".equals(paramString)) {
      return new ayps();
    }
    if ("aioflower".equals(paramString)) {
      return new ayoe();
    }
    if (("sig_cover".equals(paramString)) || ("sig_zip".equals(paramString))) {
      return new ayvi();
    }
    if ("themediydownloader".equals(paramString)) {
      return new ayvq();
    }
    if ("vasapngdownloader".equals(paramString)) {
      return new VasApngDownloader();
    }
    if ("funny_pic".equals(paramString)) {
      return new ajxs();
    }
    if ("redtouchpicdownloadprotoc".equals(paramString)) {
      return new avps(BaseApplicationImpl.getApplication());
    }
    if ("protocol_vas_extension_image".equals(paramString)) {
      return new aywn(BaseApplicationImpl.getApplication());
    }
    if ("apollo_pic".equals(paramString)) {
      return new ajnd(BaseApplicationImpl.getApplication());
    }
    if ("apollo_gif".equals(paramString)) {
      return new adld();
    }
    if ("apollo_image".equals(paramString)) {
      return new ajhu();
    }
    if ("hot_pic".equals(paramString))
    {
      if (this.g == null) {
        this.g = new aqyu();
      }
      return this.g;
    }
    if ("hot_pic_origin".equals(paramString)) {
      return new aqzf();
    }
    if ("hot_video_preview".equals(paramString))
    {
      if (this.h == null) {
        this.h = new aras();
      }
      return this.h;
    }
    if ("readinjoy_skin_gif".equals(paramString)) {
      return new qab();
    }
    if ("pubaccountimage_gifplaytime".equals(paramString)) {
      return new see(BaseApplicationImpl.getApplication());
    }
    if ("qzonecontentboxdownloader".equals(paramString)) {
      return new bhcs();
    }
    if ("qwallet_downloader".equals(paramString)) {
      return new ahct();
    }
    if ("sticker_recommended_pic".equals(paramString))
    {
      if (this.i == null) {
        this.i = new aewy();
      }
      return this.i;
    }
    if ("albumthumbpreview".equals(paramString))
    {
      if (this.j == null) {
        this.j = new ayom();
      }
      return this.j;
    }
    if ("webcover".equals(paramString)) {
      return new amiq();
    }
    return null;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return bbqj.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837908);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axop
 * JD-Core Version:    0.7.0.1
 */