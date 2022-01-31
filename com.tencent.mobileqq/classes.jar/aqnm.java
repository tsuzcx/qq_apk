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

public class aqnm
  extends AIOGalleryBasePresenter
  implements INetInfoHandler
{
  public aqpr a;
  public MqqHandler a;
  public ConcurrentHashMap<Integer, URLDrawable> b = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, Set<DanmuItemBean>> c = new ConcurrentHashMap();
  
  public aqnm()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new aqnn(this);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    anou localanou = new anou(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localanou, localanou);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        aqmb.a().a().a("AIOVideoPresenter", 4, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString + "exception = " + localException.getMessage());
      }
    }
    return localanou;
  }
  
  private List<anfv> a(List<DanmuItemBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (this.jdField_a_of_type_Aqnd.a() != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DanmuItemBean localDanmuItemBean = (DanmuItemBean)paramList.next();
        amlq localamlq = new amlq(localDanmuItemBean);
        anfv localanfv = this.jdField_a_of_type_Aqnd.a().a(localamlq);
        if (localanfv != null)
        {
          localanfv.b(localDanmuItemBean.c);
          if ((this.jdField_a_of_type_Aqnd != null) && (this.jdField_a_of_type_Aqnd.a(localamlq.jdField_a_of_type_JavaLangString))) {
            localanfv.e(true);
          }
          localArrayList.add(localanfv);
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
    if ((this.jdField_a_of_type_Aqpr != null) && (this.jdField_a_of_type_Aqpr.jdField_a_of_type_Agqx != null)) {
      return this.jdField_a_of_type_Aqpr.jdField_a_of_type_Agqx.a();
    }
    return 0L;
  }
  
  public agrc a(AIOShortVideoData paramAIOShortVideoData)
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
      aqmb.a().a().a("AIOVideoPresenter", 4, "getVideoPlayMedioInfo longvideo GetUrlAction =" + bool);
      if (bool)
      {
        localObject = aqnw.a().a(paramAIOShortVideoData.jdField_a_of_type_Long);
        if ((localObject != null) && (((aqnz)localObject).a()))
        {
          agrc localagrc = new agrc();
          localagrc.jdField_a_of_type_Boolean = true;
          localagrc.jdField_a_of_type_ArrayOfJavaLangString = ((aqnz)localObject).jdField_a_of_type_ArrayOfJavaLangString;
          localagrc.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((aqnz)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
          localagrc.jdField_a_of_type_Int = ((aqnz)localObject).jdField_a_of_type_Int;
          localagrc.jdField_a_of_type_Long = paramAIOShortVideoData.jdField_a_of_type_Long;
          localagrc.b = paramAIOShortVideoData.jdField_a_of_type_Int;
          return localagrc;
          if (l < paramAIOShortVideoData.c)
          {
            bool = true;
            continue;
            aqmb.a().a().a("AIOVideoPresenter", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
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
        localObject = new agrc();
        ((agrc)localObject).jdField_a_of_type_Boolean = false;
        ((agrc)localObject).jdField_a_of_type_Long = paramAIOShortVideoData.jdField_a_of_type_Long;
        ((agrc)localObject).b = paramAIOShortVideoData.jdField_a_of_type_Int;
        ((agrc)localObject).jdField_a_of_type_JavaLangString = paramAIOShortVideoData.b;
        ((agrc)localObject).d = l;
        return localObject;
      }
      bool = false;
    }
  }
  
  public List<anfv> a(long paramLong1, long paramLong2)
  {
    Set localSet = (Set)this.c.get(Long.valueOf(paramLong1));
    if (localSet != null) {
      return a(a(localSet, paramLong2));
    }
    return null;
  }
  
  public List<anfv> a(long paramLong, List<DanmuItemBean> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      aqmb.a().a().a("AIOVideoPresenter", 4, "buildDanmakuList list is null");
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
        axqw.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      str = ShortVideoUtils.c();
      if (vyi.a(BaseApplication.getContext(), paramFile.getAbsolutePath(), str)) {
        bcpw.a(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, 2, ajyc.a(2131700130), 0).a();
      }
      break;
    }
    for (;;)
    {
      axqw.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
      return;
      str = "0X8007A24";
      break;
      str = "0X8007A25";
      break;
      bcpw.a(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, 1, ajyc.a(2131700131), 0).a();
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    aqmg localaqmg = a(paramLong1);
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 2))
    {
      AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)localaqmg.a;
      if (paramInt2 == 256) {
        localAIOShortVideoData.l = 2;
      }
      localAIOShortVideoData.m = paramInt3;
      localaqmg.a = localAIOShortVideoData;
      a(localaqmg);
    }
    localaqmg = a();
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.jdField_a_of_type_Long == paramLong1)) {
      this.jdField_a_of_type_Aqpr.j();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    aqmg localaqmg = a(paramLong);
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 2))
    {
      AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)localaqmg.a;
      localAIOShortVideoData.l = 0;
      localAIOShortVideoData.m = 0;
      localaqmg.a = localAIOShortVideoData;
      a(localaqmg);
    }
    localaqmg = a();
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.jdField_a_of_type_Long == paramLong))
    {
      this.jdField_a_of_type_Aqpr.j();
      if (paramInt2 != 256) {
        break label213;
      }
      aqmb.a().a().a("AIOVideoPresenter", 4, "save video result resultStr = " + paramString);
      if (paramInt3 != 1) {
        break label184;
      }
      bcpw.a(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity.getString(2131718823), 0).a();
    }
    label184:
    label213:
    while ((paramInt2 != 1) && (paramInt2 != 0))
    {
      return;
      bcpw.a(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity.getString(2131718819), 0).a();
      return;
    }
    if (paramInt3 == 1) {}
    for (;;)
    {
      a(paramLong, paramInt1, paramInt2, paramString);
      this.jdField_a_of_type_Aqpr.a(c(), this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidWidgetRelativeLayout, paramBoolean);
      return;
      paramString = "I:E";
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Aqpr.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(aqmj paramaqmj)
  {
    super.a(paramaqmj);
  }
  
  public void a(aqol paramaqol)
  {
    super.a(paramaqol);
    if ((paramaqol instanceof aqpr)) {
      this.jdField_a_of_type_Aqpr = ((aqpr)paramaqol);
    }
  }
  
  public void a(AIOShortVideoData paramAIOShortVideoData)
  {
    if (paramAIOShortVideoData != null)
    {
      aqmb.a().a().a("AIOVideoPresenter", 4, "dealSaveVideo");
      b(paramAIOShortVideoData.jdField_a_of_type_Long, paramAIOShortVideoData.jdField_a_of_type_Int, 256);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (bbdj.b(paramString))
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
    aqmb.a().a().a("AIOVideoPresenter", 4, "url  is null");
  }
  
  public boolean a(long paramLong)
  {
    aqmg localaqmg = a(paramLong);
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 2)) {
      return ((AIOShortVideoData)localaqmg.a).f;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aqnd != null) && (this.jdField_a_of_type_Aqnd.a != null) && (this.jdField_a_of_type_Aqnd.a() != null))
    {
      if (!bkur.b()) {
        break label94;
      }
      this.jdField_a_of_type_Aqnd.a().a((int)actn.a(bkur.jdField_a_of_type_Int, this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity.getResources()) + 46);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnd.a().d();
      this.jdField_a_of_type_Aqnd.a().c();
      this.jdField_a_of_type_Aqnd.a.h();
      return;
      label94:
      this.jdField_a_of_type_Aqnd.a().a(46);
    }
  }
  
  public void b(AIOShortVideoData paramAIOShortVideoData)
  {
    b(paramAIOShortVideoData.jdField_a_of_type_Long, paramAIOShortVideoData.jdField_a_of_type_Int, 1);
    if (this.jdField_a_of_type_Aqpr.jdField_a_of_type_Agqx != null) {
      this.jdField_a_of_type_Aqpr.jdField_a_of_type_Agqx.a(aqnt.a(paramAIOShortVideoData), true, false);
    }
  }
  
  public void c()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, this);
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
      aqmb.a().a().a("AIOVideoPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public void d(long paramLong)
  {
    aqmg localaqmg = a(paramLong);
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 2))
    {
      ((AIOShortVideoData)localaqmg.a).f = false;
      a(localaqmg);
    }
  }
  
  public void e(long paramLong)
  {
    aqmg localaqmg = a(paramLong);
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 2))
    {
      ((AIOShortVideoData)localaqmg.a).g = false;
      a(localaqmg);
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isVideoEnable() = " + amlj.f());
    }
    return amlj.f();
  }
  
  public boolean g()
  {
    aqmg localaqmg = a();
    if ((localaqmg != null) && (localaqmg.a != null) && (this.c.get(Long.valueOf(localaqmg.a.d)) != null)) {
      return ((Set)this.c.get(Long.valueOf(localaqmg.a.d))).size() > 0;
    }
    return false;
  }
  
  public void l()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this);
    aqnw.a().a();
  }
  
  public void onNetMobile2None()
  {
    aqmb.a().a().a("AIOVideoPresenter", 4, "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    aqmb.a().a().a("AIOVideoPresenter", 4, "onNetMobile2Wifi s = " + paramString);
    if (this.jdField_a_of_type_Aqpr.jdField_a_of_type_Agqx != null) {
      this.jdField_a_of_type_Aqpr.jdField_a_of_type_Agqx.d(1);
    }
    aqnw.a().a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    aqmb.a().a().a("AIOVideoPresenter", 4, "onNetNone2Mobile s = " + paramString);
    this.jdField_a_of_type_Aqpr.s();
    aqnw.a().a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    aqmb.a().a().a("AIOVideoPresenter", 4, "onNetNone2Wifi s = " + paramString);
    aqnw.a().a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    aqmb.a().a().a("AIOVideoPresenter", 4, "onNetWifi2Mobile s = " + paramString);
    this.jdField_a_of_type_Aqpr.s();
    aqnw.a().a();
  }
  
  public void onNetWifi2None()
  {
    aqmb.a().a().a("AIOVideoPresenter", 4, "onNetWifi2None");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqnm
 * JD-Core Version:    0.7.0.1
 */