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

public class bdii
  extends URLDrawableParams
{
  private beqx jdField_a_of_type_Beqx;
  private ProtocolDownloader jdField_a_of_type_ComTencentImageProtocolDownloader;
  private ProtocolDownloader b;
  private ProtocolDownloader c;
  private ProtocolDownloader d;
  private ProtocolDownloader e;
  private ProtocolDownloader f;
  private ProtocolDownloader g;
  private ProtocolDownloader h;
  private ProtocolDownloader i;
  
  public bdii(Application paramApplication)
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
        this.jdField_a_of_type_ComTencentImageProtocolDownloader = new beuf(bool, paramObject);
        return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
        label52:
        bool = false;
      }
    }
    if (("nearbyimage".equals(paramString)) || ("nearbylocalimage".equals(paramString)))
    {
      if (this.e == null) {
        this.e = new bevg();
      }
      return this.e;
    }
    if (("chatthumb".equals(paramString)) || ("chatimg".equals(paramString)) || ("chatraw".equals(paramString)))
    {
      if (this.b == null) {
        this.b = new besk(BaseApplicationImpl.getApplication());
      }
      return this.b;
    }
    if ("datalineimage".equals(paramString)) {
      return new besn(BaseApplicationImpl.getApplication());
    }
    if ("datalineface".equals(paramString)) {
      return new besq(BaseApplicationImpl.getApplication());
    }
    if ("emotion".equals(paramString)) {
      return new besw(BaseApplicationImpl.getApplication());
    }
    if ("emotion_pic".equals(paramString)) {
      return new bevr(BaseApplicationImpl.getApplication());
    }
    if ("favorite".equals(paramString)) {
      return new asqm();
    }
    if ("albumthumb".equals(paramString)) {
      return new AlbumThumbDownloader();
    }
    if ("videothumb".equals(paramString)) {
      return new beyx();
    }
    if ("videocover".equals(paramString)) {
      return new beyv();
    }
    if ("pubaccountimage".equals(paramString)) {
      return new tye(BaseApplicationImpl.getApplication());
    }
    if (("billdthumb".equals(paramString)) || ("billdimg".equals(paramString)))
    {
      if (this.c == null) {
        this.c = new bevc(BaseApplicationImpl.getApplication());
      }
      return this.c;
    }
    if (("profile_img_big".equals(paramString)) || ("profile_img_thumb".equals(paramString)) || ("profile_img_icon".equals(paramString)) || ("profile_img_big_fhd".equals(paramString)))
    {
      if (this.d == null) {
        this.d = new bevu();
      }
      return this.d;
    }
    if ("qzone_cover".equals(paramString)) {
      return new bewh();
    }
    if ("favimage".equals(paramString)) {
      return new beta(BaseApplicationImpl.getApplication());
    }
    if ("fileassistantimage".equals(paramString)) {
      return new betb(BaseApplicationImpl.getApplication());
    }
    if ("filegalleryorigimage".equals(paramString)) {
      return new bevs(BaseApplicationImpl.getApplication());
    }
    if ("troop_photo_qzone".equals(paramString)) {
      return new bewi();
    }
    if ("aiothumb".equals(paramString))
    {
      if (this.jdField_a_of_type_Beqx == null) {
        this.jdField_a_of_type_Beqx = new beqx(BaseApplicationImpl.getApplication());
      }
      return this.jdField_a_of_type_Beqx;
    }
    if ("protocol_pendant_image".equals(paramString)) {
      return new berg();
    }
    if (("file".equals(paramString)) && (BaseApplicationImpl.sApplication.getQQProcessName().endsWith(":peak"))) {
      return new aiem(BaseApplicationImpl.getApplication());
    }
    if ("regionalthumb".equals(paramString)) {
      return new bewj(BaseApplicationImpl.getApplication());
    }
    if ("third_part".equals(paramString)) {
      return new bexx(BaseApplicationImpl.getApplication());
    }
    if ("gamead".equals(paramString)) {
      return new beuv();
    }
    if ("shortvideothumb".equals(paramString)) {
      return new bexi();
    }
    if ("shortvideoforpicthumb".equals(paramString)) {
      return new bexc();
    }
    if ("devicemsgthumb".equals(paramString)) {
      return new besr();
    }
    if ("carrier".equals(paramString)) {
      return new besj();
    }
    if ("aioflower".equals(paramString)) {
      return new beqv();
    }
    if (("sig_cover".equals(paramString)) || ("sig_zip".equals(paramString))) {
      return new bexo();
    }
    if ("themediydownloader".equals(paramString)) {
      return new bexw();
    }
    if ("vasapngdownloader".equals(paramString)) {
      return new VasApngDownloader();
    }
    if ("funny_pic".equals(paramString)) {
      return new anzc();
    }
    if ("redtouchpicdownloadprotoc".equals(paramString)) {
      return new bbay(BaseApplicationImpl.getApplication());
    }
    if ("protocol_vas_extension_image".equals(paramString)) {
      return new beyt(BaseApplicationImpl.getApplication());
    }
    if ("apollo_pic".equals(paramString)) {
      return new anof(BaseApplicationImpl.getApplication());
    }
    if ("apollo_gif".equals(paramString)) {
      return new agyo();
    }
    if ("apollo_image".equals(paramString)) {
      return new anit();
    }
    if ("hot_pic".equals(paramString))
    {
      if (this.f == null) {
        this.f = new avte();
      }
      return this.f;
    }
    if ("hot_pic_origin".equals(paramString)) {
      return new avtp();
    }
    if ("hot_video_preview".equals(paramString))
    {
      if (this.g == null) {
        this.g = new avvc();
      }
      return this.g;
    }
    if ("readinjoy_skin_gif".equals(paramString)) {
      return new qup();
    }
    if ("pubaccountimage_gifplaytime".equals(paramString)) {
      return new txd(BaseApplicationImpl.getApplication());
    }
    if ("qzonecontentboxdownloader".equals(paramString)) {
      return new bmyk();
    }
    if ("qwallet_downloader".equals(paramString)) {
      return new alep();
    }
    if ("sticker_recommended_pic".equals(paramString))
    {
      if (this.h == null) {
        this.h = new aitd();
      }
      return this.h;
    }
    if ("albumthumbpreview".equals(paramString))
    {
      if (this.i == null) {
        this.i = new berc();
      }
      return this.i;
    }
    if ("webcover".equals(paramString)) {
      return new aqtn();
    }
    if ("qqsys_emoji".equals(paramString)) {
      return new bewg();
    }
    return null;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return bhzi.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838069);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838072);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdii
 * JD-Core Version:    0.7.0.1
 */