import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.transfile.VasApngDownloader;

public class axor
  extends URLDrawableParams
{
  private ayoh jdField_a_of_type_Ayoh;
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
  
  public axor(Application paramApplication)
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
        this.jdField_a_of_type_ComTencentImageProtocolDownloader = new ayrp(bool, paramObject);
        return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
        label52:
        bool = false;
      }
    }
    if (("nearbyimage".equals(paramString)) || ("nearbylocalimage".equals(paramString)))
    {
      if (this.f == null) {
        this.f = new ayst();
      }
      return this.f;
    }
    if (("chatthumb".equals(paramString)) || ("chatimg".equals(paramString)) || ("chatraw".equals(paramString)))
    {
      if (this.b == null) {
        this.b = new aypv(BaseApplicationImpl.getApplication());
      }
      return this.b;
    }
    if (("lbsthumb".equals(paramString)) || ("lbsimg".equals(paramString)))
    {
      if (this.c == null) {
        this.c = new aysg(BaseApplicationImpl.getApplication());
      }
      return this.c;
    }
    if ("datalineimage".equals(paramString)) {
      return new aypx(BaseApplicationImpl.getApplication());
    }
    if ("datalineface".equals(paramString)) {
      return new ayqa(BaseApplicationImpl.getApplication());
    }
    if ("emotion".equals(paramString)) {
      return new ayqg(BaseApplicationImpl.getApplication());
    }
    if ("emotion_pic".equals(paramString)) {
      return new ayte(BaseApplicationImpl.getApplication());
    }
    if ("favorite".equals(paramString)) {
      return new aoay(BaseApplicationImpl.getApplication());
    }
    if ("albumthumb".equals(paramString)) {
      return new ayop(BaseApplicationImpl.getApplication());
    }
    if ("videothumb".equals(paramString)) {
      return new aywu();
    }
    if ("videocover".equals(paramString)) {
      return new aywr();
    }
    if ("pubaccountimage".equals(paramString)) {
      return new sfa(BaseApplicationImpl.getApplication());
    }
    if ("location".equals(paramString)) {
      return new aysp(BaseApplicationImpl.getApplication());
    }
    if (("billdthumb".equals(paramString)) || ("billdimg".equals(paramString)))
    {
      if (this.d == null) {
        this.d = new ayso(BaseApplicationImpl.getApplication());
      }
      return this.d;
    }
    if (("profile_img_big".equals(paramString)) || ("profile_img_thumb".equals(paramString)) || ("profile_img_icon".equals(paramString)) || ("profile_img_big_fhd".equals(paramString)))
    {
      if (this.e == null) {
        this.e = new ayth();
      }
      return this.e;
    }
    if ("qzone_cover".equals(paramString)) {
      return new aytz();
    }
    if ("favimage".equals(paramString)) {
      return new ayqk(BaseApplicationImpl.getApplication());
    }
    if ("fileassistantimage".equals(paramString)) {
      return new ayql(BaseApplicationImpl.getApplication());
    }
    if ("filegalleryorigimage".equals(paramString)) {
      return new aytf(BaseApplicationImpl.getApplication());
    }
    if ("troop_photo_qzone".equals(paramString)) {
      return new ayua();
    }
    if ("aiothumb".equals(paramString))
    {
      if (this.jdField_a_of_type_Ayoh == null) {
        this.jdField_a_of_type_Ayoh = new ayoh(BaseApplicationImpl.getApplication());
      }
      return this.jdField_a_of_type_Ayoh;
    }
    if ("protocol_pendant_image".equals(paramString)) {
      return new ayot();
    }
    if (("file".equals(paramString)) && (BaseApplicationImpl.sApplication.getQQProcessName().endsWith(":peak"))) {
      return new aejo(BaseApplicationImpl.getApplication());
    }
    if ("regionalthumb".equals(paramString)) {
      return new ayub(BaseApplicationImpl.getApplication());
    }
    if ("third_part".equals(paramString)) {
      return new ayvt(BaseApplicationImpl.getApplication());
    }
    if ("gamead".equals(paramString)) {
      return new aysh();
    }
    if ("shortvideothumb".equals(paramString)) {
      return new ayvc();
    }
    if ("shortvideoforpicthumb".equals(paramString)) {
      return new ayuv();
    }
    if ("devicemsgthumb".equals(paramString)) {
      return new ayqb();
    }
    if ("carrier".equals(paramString)) {
      return new aypu();
    }
    if ("aioflower".equals(paramString)) {
      return new ayog();
    }
    if (("sig_cover".equals(paramString)) || ("sig_zip".equals(paramString))) {
      return new ayvk();
    }
    if ("themediydownloader".equals(paramString)) {
      return new ayvs();
    }
    if ("vasapngdownloader".equals(paramString)) {
      return new VasApngDownloader();
    }
    if ("funny_pic".equals(paramString)) {
      return new ajxq();
    }
    if ("redtouchpicdownloadprotoc".equals(paramString)) {
      return new avpu(BaseApplicationImpl.getApplication());
    }
    if ("protocol_vas_extension_image".equals(paramString)) {
      return new aywp(BaseApplicationImpl.getApplication());
    }
    if ("apollo_pic".equals(paramString)) {
      return new ajnb(BaseApplicationImpl.getApplication());
    }
    if ("apollo_gif".equals(paramString)) {
      return new adlb();
    }
    if ("apollo_image".equals(paramString)) {
      return new ajhs();
    }
    if ("hot_pic".equals(paramString))
    {
      if (this.g == null) {
        this.g = new aqyw();
      }
      return this.g;
    }
    if ("hot_pic_origin".equals(paramString)) {
      return new aqzh();
    }
    if ("hot_video_preview".equals(paramString))
    {
      if (this.h == null) {
        this.h = new arau();
      }
      return this.h;
    }
    if ("readinjoy_skin_gif".equals(paramString)) {
      return new pzy();
    }
    if ("pubaccountimage_gifplaytime".equals(paramString)) {
      return new seb(BaseApplicationImpl.getApplication());
    }
    if ("qzonecontentboxdownloader".equals(paramString)) {
      return new bhdj();
    }
    if ("qwallet_downloader".equals(paramString)) {
      return new ahcr();
    }
    if ("sticker_recommended_pic".equals(paramString))
    {
      if (this.i == null) {
        this.i = new aeww();
      }
      return this.i;
    }
    if ("albumthumbpreview".equals(paramString))
    {
      if (this.j == null) {
        this.j = new ayoo();
      }
      return this.j;
    }
    if ("webcover".equals(paramString)) {
      return new amip();
    }
    return null;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return bbqx.a();
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
 * Qualified Name:     axor
 * JD-Core Version:    0.7.0.1
 */