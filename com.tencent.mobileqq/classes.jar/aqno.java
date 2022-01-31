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

public class aqno
  extends AIOGalleryBasePresenter
  implements INetInfoHandler
{
  public aqpt a;
  public MqqHandler a;
  public ConcurrentHashMap<Integer, URLDrawable> b = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, Set<DanmuItemBean>> c = new ConcurrentHashMap();
  
  public aqno()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new aqnp(this);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    anoz localanoz = new anoz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localanoz, localanoz);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        aqmd.a().a().a("AIOVideoPresenter", 4, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString + "exception = " + localException.getMessage());
      }
    }
    return localanoz;
  }
  
  private List<anga> a(List<DanmuItemBean> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (this.jdField_a_of_type_Aqnf.a() != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DanmuItemBean localDanmuItemBean = (DanmuItemBean)paramList.next();
        amlp localamlp = new amlp(localDanmuItemBean);
        anga localanga = this.jdField_a_of_type_Aqnf.a().a(localamlp);
        if (localanga != null)
        {
          localanga.b(localDanmuItemBean.c);
          if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.a(localamlp.jdField_a_of_type_JavaLangString))) {
            localanga.e(true);
          }
          localArrayList.add(localanga);
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
    if ((this.jdField_a_of_type_Aqpt != null) && (this.jdField_a_of_type_Aqpt.jdField_a_of_type_Agqv != null)) {
      return this.jdField_a_of_type_Aqpt.jdField_a_of_type_Agqv.a();
    }
    return 0L;
  }
  
  public agra a(AIOShortVideoData paramAIOShortVideoData)
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
      aqmd.a().a().a("AIOVideoPresenter", 4, "getVideoPlayMedioInfo longvideo GetUrlAction =" + bool);
      if (bool)
      {
        localObject = aqny.a().a(paramAIOShortVideoData.jdField_a_of_type_Long);
        if ((localObject != null) && (((aqob)localObject).a()))
        {
          agra localagra = new agra();
          localagra.jdField_a_of_type_Boolean = true;
          localagra.jdField_a_of_type_ArrayOfJavaLangString = ((aqob)localObject).jdField_a_of_type_ArrayOfJavaLangString;
          localagra.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((aqob)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
          localagra.jdField_a_of_type_Int = ((aqob)localObject).jdField_a_of_type_Int;
          localagra.jdField_a_of_type_Long = paramAIOShortVideoData.jdField_a_of_type_Long;
          localagra.b = paramAIOShortVideoData.jdField_a_of_type_Int;
          return localagra;
          if (l < paramAIOShortVideoData.c)
          {
            bool = true;
            continue;
            aqmd.a().a().a("AIOVideoPresenter", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
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
        localObject = new agra();
        ((agra)localObject).jdField_a_of_type_Boolean = false;
        ((agra)localObject).jdField_a_of_type_Long = paramAIOShortVideoData.jdField_a_of_type_Long;
        ((agra)localObject).b = paramAIOShortVideoData.jdField_a_of_type_Int;
        ((agra)localObject).jdField_a_of_type_JavaLangString = paramAIOShortVideoData.b;
        ((agra)localObject).d = l;
        return localObject;
      }
      bool = false;
    }
  }
  
  public List<anga> a(long paramLong1, long paramLong2)
  {
    Set localSet = (Set)this.c.get(Long.valueOf(paramLong1));
    if (localSet != null) {
      return a(a(localSet, paramLong2));
    }
    return null;
  }
  
  public List<anga> a(long paramLong, List<DanmuItemBean> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      aqmd.a().a().a("AIOVideoPresenter", 4, "buildDanmakuList list is null");
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
        axqy.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      str = ShortVideoUtils.c();
      if (vyf.a(BaseApplication.getContext(), paramFile.getAbsolutePath(), str)) {
        bcql.a(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, 2, ajya.a(2131700141), 0).a();
      }
      break;
    }
    for (;;)
    {
      axqy.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
      return;
      str = "0X8007A24";
      break;
      str = "0X8007A25";
      break;
      bcql.a(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, 1, ajya.a(2131700142), 0).a();
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    aqmi localaqmi = a(paramLong1);
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 2))
    {
      AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)localaqmi.a;
      if (paramInt2 == 256) {
        localAIOShortVideoData.l = 2;
      }
      localAIOShortVideoData.m = paramInt3;
      localaqmi.a = localAIOShortVideoData;
      a(localaqmi);
    }
    localaqmi = a();
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.jdField_a_of_type_Long == paramLong1)) {
      this.jdField_a_of_type_Aqpt.j();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    aqmi localaqmi = a(paramLong);
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 2))
    {
      AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)localaqmi.a;
      localAIOShortVideoData.l = 0;
      localAIOShortVideoData.m = 0;
      localaqmi.a = localAIOShortVideoData;
      a(localaqmi);
    }
    localaqmi = a();
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.jdField_a_of_type_Long == paramLong))
    {
      this.jdField_a_of_type_Aqpt.j();
      if (paramInt2 != 256) {
        break label213;
      }
      aqmd.a().a().a("AIOVideoPresenter", 4, "save video result resultStr = " + paramString);
      if (paramInt3 != 1) {
        break label184;
      }
      bcql.a(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity.getString(2131718834), 0).a();
    }
    label184:
    label213:
    while ((paramInt2 != 1) && (paramInt2 != 0))
    {
      return;
      bcql.a(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity.getString(2131718830), 0).a();
      return;
    }
    if (paramInt3 == 1) {}
    for (;;)
    {
      a(paramLong, paramInt1, paramInt2, paramString);
      this.jdField_a_of_type_Aqpt.a(c(), this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidWidgetRelativeLayout, paramBoolean);
      return;
      paramString = "I:E";
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Aqpt.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(aqml paramaqml)
  {
    super.a(paramaqml);
  }
  
  public void a(aqon paramaqon)
  {
    super.a(paramaqon);
    if ((paramaqon instanceof aqpt)) {
      this.jdField_a_of_type_Aqpt = ((aqpt)paramaqon);
    }
  }
  
  public void a(AIOShortVideoData paramAIOShortVideoData)
  {
    if (paramAIOShortVideoData != null)
    {
      aqmd.a().a().a("AIOVideoPresenter", 4, "dealSaveVideo");
      b(paramAIOShortVideoData.jdField_a_of_type_Long, paramAIOShortVideoData.jdField_a_of_type_Int, 256);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (bbdx.b(paramString))
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
    aqmd.a().a().a("AIOVideoPresenter", 4, "url  is null");
  }
  
  public boolean a(long paramLong)
  {
    aqmi localaqmi = a(paramLong);
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 2)) {
      return ((AIOShortVideoData)localaqmi.a).f;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.a != null) && (this.jdField_a_of_type_Aqnf.a() != null))
    {
      if (!bkvi.b()) {
        break label94;
      }
      this.jdField_a_of_type_Aqnf.a().a((int)actj.a(bkvi.jdField_a_of_type_Int, this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity.getResources()) + 46);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnf.a().d();
      this.jdField_a_of_type_Aqnf.a().c();
      this.jdField_a_of_type_Aqnf.a.h();
      return;
      label94:
      this.jdField_a_of_type_Aqnf.a().a(46);
    }
  }
  
  public void b(AIOShortVideoData paramAIOShortVideoData)
  {
    b(paramAIOShortVideoData.jdField_a_of_type_Long, paramAIOShortVideoData.jdField_a_of_type_Int, 1);
    if (this.jdField_a_of_type_Aqpt.jdField_a_of_type_Agqv != null) {
      this.jdField_a_of_type_Aqpt.jdField_a_of_type_Agqv.a(aqnv.a(paramAIOShortVideoData), true, false);
    }
  }
  
  public void c()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, this);
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
      aqmd.a().a().a("AIOVideoPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public void d(long paramLong)
  {
    aqmi localaqmi = a(paramLong);
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 2))
    {
      ((AIOShortVideoData)localaqmi.a).f = false;
      a(localaqmi);
    }
  }
  
  public void e(long paramLong)
  {
    aqmi localaqmi = a(paramLong);
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 2))
    {
      ((AIOShortVideoData)localaqmi.a).g = false;
      a(localaqmi);
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isVideoEnable() = " + amli.f());
    }
    return amli.f();
  }
  
  public boolean g()
  {
    aqmi localaqmi = a();
    if ((localaqmi != null) && (localaqmi.a != null) && (this.c.get(Long.valueOf(localaqmi.a.d)) != null)) {
      return ((Set)this.c.get(Long.valueOf(localaqmi.a.d))).size() > 0;
    }
    return false;
  }
  
  public void l()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this);
    aqny.a().a();
  }
  
  public void onNetMobile2None()
  {
    aqmd.a().a().a("AIOVideoPresenter", 4, "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    aqmd.a().a().a("AIOVideoPresenter", 4, "onNetMobile2Wifi s = " + paramString);
    if (this.jdField_a_of_type_Aqpt.jdField_a_of_type_Agqv != null) {
      this.jdField_a_of_type_Aqpt.jdField_a_of_type_Agqv.d(1);
    }
    aqny.a().a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    aqmd.a().a().a("AIOVideoPresenter", 4, "onNetNone2Mobile s = " + paramString);
    this.jdField_a_of_type_Aqpt.s();
    aqny.a().a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    aqmd.a().a().a("AIOVideoPresenter", 4, "onNetNone2Wifi s = " + paramString);
    aqny.a().a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    aqmd.a().a().a("AIOVideoPresenter", 4, "onNetWifi2Mobile s = " + paramString);
    this.jdField_a_of_type_Aqpt.s();
    aqny.a().a();
  }
  
  public void onNetWifi2None()
  {
    aqmd.a().a().a("AIOVideoPresenter", 4, "onNetWifi2None");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqno
 * JD-Core Version:    0.7.0.1
 */