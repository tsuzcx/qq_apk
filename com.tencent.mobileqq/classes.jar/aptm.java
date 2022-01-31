import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class aptm
  extends AIOGalleryBasePresenter
  implements INetInfoHandler
{
  public apvq a;
  public MqqHandler a;
  public ConcurrentHashMap<Integer, URLDrawable> b = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, Set<DanmuItemBean>> c = new ConcurrentHashMap();
  
  public aptm()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new aptn(this);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    amym localamym = new amym(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localamym, localamym);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        apsm.a().a().a("AIOVideoPresenter", 4, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString + "exception = " + localException.getMessage());
      }
    }
    return localamym;
  }
  
  private List<ampo> a(List<DanmuItemBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (this.jdField_a_of_type_Apte.a() != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DanmuItemBean localDanmuItemBean = (DanmuItemBean)paramList.next();
        alwa localalwa = new alwa(localDanmuItemBean);
        ampo localampo = this.jdField_a_of_type_Apte.a().a(localalwa);
        if (localampo != null)
        {
          localampo.b(localDanmuItemBean.c);
          if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.a(localalwa.jdField_a_of_type_JavaLangString))) {
            localampo.e(true);
          }
          localArrayList.add(localampo);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private List<DanmuItemBean> a(Set<DanmuItemBean> paramSet, long paramLong)
  {
    if ((paramSet != null) && (!paramSet.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        DanmuItemBean localDanmuItemBean = (DanmuItemBean)paramSet.next();
        if (localDanmuItemBean.c + 1000L >= paramLong) {
          localArrayList.add(localDanmuItemBean);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private List<DanmuItemBean> b(long paramLong, List<DanmuItemBean> paramList)
  {
    Set localSet = (Set)this.c.get(Long.valueOf(paramLong));
    long l = a();
    Object localObject = new ArraySet();
    ((Set)localObject).addAll(paramList);
    if (localSet == null)
    {
      this.c.put(Long.valueOf(paramLong), localObject);
      return a((Set)localObject, l);
    }
    this.c.clear();
    paramList = new ArraySet();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DanmuItemBean localDanmuItemBean = (DanmuItemBean)((Iterator)localObject).next();
      if (!localSet.contains(localDanmuItemBean)) {
        paramList.add(localDanmuItemBean);
      }
    }
    localSet.addAll(paramList);
    this.c.put(Long.valueOf(paramLong), localSet);
    return a(paramList, l);
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Apvq != null) && (this.jdField_a_of_type_Apvq.jdField_a_of_type_Agez != null)) {
      return this.jdField_a_of_type_Apvq.jdField_a_of_type_Agez.a();
    }
    return 0L;
  }
  
  public agfe a(AIOShortVideoData paramAIOShortVideoData)
  {
    if (paramAIOShortVideoData == null) {
      return null;
    }
    Object localObject = new File(paramAIOShortVideoData.b);
    long l = 0L;
    boolean bool;
    if (((File)localObject).exists())
    {
      l = ((File)localObject).length();
      if (paramAIOShortVideoData.d == 1) {
        bool = false;
      }
    }
    for (;;)
    {
      apsm.a().a().a("AIOVideoPresenter", 4, "getVideoPlayMedioInfo longvideo GetUrlAction =" + bool);
      if (bool)
      {
        localObject = aptw.a().a(paramAIOShortVideoData.jdField_a_of_type_Long);
        if ((localObject != null) && (((aptz)localObject).a()))
        {
          agfe localagfe = new agfe();
          localagfe.jdField_a_of_type_Boolean = true;
          localagfe.jdField_a_of_type_ArrayOfJavaLangString = ((aptz)localObject).jdField_a_of_type_ArrayOfJavaLangString;
          localagfe.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((aptz)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
          localagfe.jdField_a_of_type_Int = ((aptz)localObject).jdField_a_of_type_Int;
          localagfe.jdField_a_of_type_Long = paramAIOShortVideoData.jdField_a_of_type_Long;
          localagfe.b = paramAIOShortVideoData.jdField_a_of_type_Int;
          return localagfe;
          if (l < paramAIOShortVideoData.c)
          {
            bool = true;
            continue;
            apsm.a().a().a("AIOVideoPresenter", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
            bool = true;
          }
        }
        else
        {
          return null;
        }
      }
      else
      {
        localObject = new agfe();
        ((agfe)localObject).jdField_a_of_type_Boolean = false;
        ((agfe)localObject).jdField_a_of_type_Long = paramAIOShortVideoData.jdField_a_of_type_Long;
        ((agfe)localObject).b = paramAIOShortVideoData.jdField_a_of_type_Int;
        ((agfe)localObject).jdField_a_of_type_JavaLangString = paramAIOShortVideoData.b;
        ((agfe)localObject).d = l;
        return localObject;
      }
      bool = false;
    }
  }
  
  public List<ampo> a(long paramLong1, long paramLong2)
  {
    Set localSet = (Set)this.c.get(Long.valueOf(paramLong1));
    if (localSet != null) {
      return a(a(localSet, paramLong2));
    }
    return null;
  }
  
  public List<ampo> a(long paramLong, List<DanmuItemBean> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      apsm.a().a().a("AIOVideoPresenter", 4, "buildDanmakuList list is null");
      return null;
    }
    return a(b(paramLong, paramList));
  }
  
  public void a(int paramInt, File paramFile)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = null;
      if (str != null) {
        awqx.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      str = ShortVideoUtils.c();
      if (vlm.a(BaseApplication.getContext(), paramFile.getAbsolutePath(), str)) {
        bbmy.a(this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity, 2, ajjy.a(2131634342), 0).a();
      }
      break;
    }
    for (;;)
    {
      awqx.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
      return;
      str = "0X8007A24";
      break;
      str = "0X8007A25";
      break;
      bbmy.a(this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity, 1, ajjy.a(2131634343), 0).a();
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    apsr localapsr = a(paramLong1);
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 2))
    {
      AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)localapsr.a;
      if (paramInt2 == 256) {
        localAIOShortVideoData.l = 2;
      }
      localAIOShortVideoData.m = paramInt3;
      localapsr.a = localAIOShortVideoData;
      a(localapsr);
    }
    localapsr = a();
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.jdField_a_of_type_Long == paramLong1)) {
      this.jdField_a_of_type_Apvq.j();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    apsr localapsr = a(paramLong);
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 2))
    {
      AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)localapsr.a;
      localAIOShortVideoData.l = 0;
      localAIOShortVideoData.m = 0;
      localapsr.a = localAIOShortVideoData;
      a(localapsr);
    }
    localapsr = a();
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.jdField_a_of_type_Long == paramLong))
    {
      this.jdField_a_of_type_Apvq.j();
      if (paramInt2 != 256) {
        break label213;
      }
      apsm.a().a().a("AIOVideoPresenter", 4, "save video result resultStr = " + paramString);
      if (paramInt3 != 1) {
        break label184;
      }
      bbmy.a(this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity.getString(2131652996), 0).a();
    }
    label184:
    label213:
    while ((paramInt2 != 1) && (paramInt2 != 0))
    {
      return;
      bbmy.a(this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity.getString(2131652992), 0).a();
      return;
    }
    if (paramInt3 == 1) {}
    for (;;)
    {
      a(paramLong, paramInt1, paramInt2, paramString);
      this.jdField_a_of_type_Apvq.a(c(), this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidWidgetRelativeLayout, paramBoolean);
      return;
      paramString = "I:E";
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Apvq.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(apsu paramapsu)
  {
    super.a(paramapsu);
  }
  
  public void a(apul paramapul)
  {
    super.a(paramapul);
    if ((paramapul instanceof apvq)) {
      this.jdField_a_of_type_Apvq = ((apvq)paramapul);
    }
  }
  
  public void a(AIOShortVideoData paramAIOShortVideoData)
  {
    if (paramAIOShortVideoData != null)
    {
      apsm.a().a().a("AIOVideoPresenter", 4, "dealSaveVideo");
      b(paramAIOShortVideoData.jdField_a_of_type_Long, paramAIOShortVideoData.jdField_a_of_type_Int, 256);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (bace.b(paramString))
    {
      paramString = ShortVideoUtils.a(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.b.put(Integer.valueOf(paramInt3), (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
      }
    }
    else
    {
      return;
    }
    apsm.a().a().a("AIOVideoPresenter", 4, "url  is null");
  }
  
  public boolean a(long paramLong)
  {
    apsr localapsr = a(paramLong);
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 2)) {
      return ((AIOShortVideoData)localapsr.a).f;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.a != null) && (this.jdField_a_of_type_Apte.a() != null))
    {
      if (!bjeh.b()) {
        break label94;
      }
      this.jdField_a_of_type_Apte.a().a((int)aciy.a(bjeh.jdField_a_of_type_Int, this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity.getResources()) + 46);
    }
    for (;;)
    {
      this.jdField_a_of_type_Apte.a().d();
      this.jdField_a_of_type_Apte.a().c();
      this.jdField_a_of_type_Apte.a.h();
      return;
      label94:
      this.jdField_a_of_type_Apte.a().a(46);
    }
  }
  
  public void b(AIOShortVideoData paramAIOShortVideoData)
  {
    b(paramAIOShortVideoData.jdField_a_of_type_Long, paramAIOShortVideoData.jdField_a_of_type_Int, 1);
    if (this.jdField_a_of_type_Apvq.jdField_a_of_type_Agez != null) {
      this.jdField_a_of_type_Apvq.jdField_a_of_type_Agez.a(aptt.a(paramAIOShortVideoData), true, false);
    }
  }
  
  public void c()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity, this);
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.b.remove(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      apsm.a().a().a("AIOVideoPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public void d(long paramLong)
  {
    apsr localapsr = a(paramLong);
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 2))
    {
      ((AIOShortVideoData)localapsr.a).f = false;
      a(localapsr);
    }
  }
  
  public void e(long paramLong)
  {
    apsr localapsr = a(paramLong);
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 2))
    {
      ((AIOShortVideoData)localapsr.a).g = false;
      a(localapsr);
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isVideoEnable() = " + alvt.f());
    }
    return alvt.f();
  }
  
  public boolean g()
  {
    apsr localapsr = a();
    if ((localapsr != null) && (localapsr.a != null) && (this.c.get(Long.valueOf(localapsr.a.d)) != null)) {
      return ((Set)this.c.get(Long.valueOf(localapsr.a.d))).size() > 0;
    }
    return false;
  }
  
  public void l()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this);
    aptw.a().a();
  }
  
  public void onNetMobile2None()
  {
    apsm.a().a().a("AIOVideoPresenter", 4, "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    apsm.a().a().a("AIOVideoPresenter", 4, "onNetMobile2Wifi s = " + paramString);
    if (this.jdField_a_of_type_Apvq.jdField_a_of_type_Agez != null) {
      this.jdField_a_of_type_Apvq.jdField_a_of_type_Agez.d(1);
    }
    aptw.a().a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    apsm.a().a().a("AIOVideoPresenter", 4, "onNetNone2Mobile s = " + paramString);
    this.jdField_a_of_type_Apvq.r();
    aptw.a().a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    apsm.a().a().a("AIOVideoPresenter", 4, "onNetNone2Wifi s = " + paramString);
    aptw.a().a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    apsm.a().a().a("AIOVideoPresenter", 4, "onNetWifi2Mobile s = " + paramString);
    this.jdField_a_of_type_Apvq.r();
    aptw.a().a();
  }
  
  public void onNetWifi2None()
  {
    apsm.a().a().a("AIOVideoPresenter", 4, "onNetWifi2None");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aptm
 * JD-Core Version:    0.7.0.1
 */