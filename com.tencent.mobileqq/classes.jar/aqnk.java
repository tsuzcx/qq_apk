import android.app.Activity;
import android.support.v4.util.ArraySet;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class aqnk
  extends AIOGalleryBasePresenter
{
  public aqpn a;
  public MqqHandler a;
  private ConcurrentHashMap<Long, Set<DanmuItemBean>> b = new ConcurrentHashMap();
  
  public aqnk()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new aqnl(this);
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
          localanfv.b(localDanmuItemBean.jdField_c_of_type_Long);
          if ((this.jdField_a_of_type_Aqnd != null) && (this.jdField_a_of_type_Aqnd.a(localamlq.a))) {
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
        if (localDanmuItemBean.jdField_c_of_type_Long + 1000L >= paramLong) {
          localArrayList.add(localDanmuItemBean);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private List<DanmuItemBean> b(long paramLong, List<DanmuItemBean> paramList)
  {
    Set localSet = (Set)this.b.get(Long.valueOf(paramLong));
    long l = a();
    Object localObject = new ArraySet();
    ((Set)localObject).addAll(paramList);
    if (localSet == null)
    {
      this.b.put(Long.valueOf(paramLong), localObject);
      return a((Set)localObject, l);
    }
    this.b.clear();
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
    this.b.put(Long.valueOf(paramLong), localSet);
    return a(paramList, l);
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Aqpn != null) && (this.jdField_a_of_type_Aqpn.jdField_a_of_type_Agqx != null)) {
      return this.jdField_a_of_type_Aqpn.jdField_a_of_type_Agqx.a();
    }
    return 0L;
  }
  
  public List<anfv> a(long paramLong1, long paramLong2)
  {
    Set localSet = (Set)this.b.get(Long.valueOf(paramLong1));
    if (localSet != null) {
      return a(a(localSet, paramLong2));
    }
    return null;
  }
  
  public List<anfv> a(long paramLong, List<DanmuItemBean> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      aqmb.a().a().a("AIOFileVideoPresenter", 4, "buildDanmakuList list is null");
      return null;
    }
    return a(b(paramLong, paramList));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    aqmg localaqmg = a(paramLong1);
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 4))
    {
      AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localaqmg.a;
      localAIOFileVideoData.g = ((paramInt3 / 10000.0F * (float)localAIOFileVideoData.jdField_c_of_type_Long));
      localaqmg.a = localAIOFileVideoData;
      a(localaqmg);
    }
    localaqmg = a();
    if ((paramInt2 == 1) && (localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a == paramLong1)) {
      this.jdField_a_of_type_Aqpn.j();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    aqmg localaqmg = a(paramLong);
    boolean bool = false;
    paramBoolean = bool;
    AIOFileVideoData localAIOFileVideoData;
    if (paramInt2 == 269484034)
    {
      paramBoolean = bool;
      if (localaqmg != null)
      {
        paramBoolean = bool;
        if (localaqmg.a != null)
        {
          paramBoolean = bool;
          if (localaqmg.a.a() == 4)
          {
            localAIOFileVideoData = (AIOFileVideoData)localaqmg.a;
            if (paramInt3 != 1) {
              break label228;
            }
            localAIOFileVideoData.jdField_c_of_type_JavaLangString = paramString;
            localAIOFileVideoData.f = true;
            localAIOFileVideoData.h = true;
            localAIOFileVideoData.l = false;
            localAIOFileVideoData.jdField_e_of_type_Int = 0;
            localAIOFileVideoData.g = 0L;
            localAIOFileVideoData.jdField_e_of_type_JavaLangString = null;
            localAIOFileVideoData.d = null;
            paramBoolean = localAIOFileVideoData.n;
            localaqmg.a = localAIOFileVideoData;
            a(localaqmg);
          }
        }
      }
    }
    if (paramInt2 == 269484034)
    {
      paramString = a();
      if ((paramString != null) && (paramString.a != null) && (paramString.a.a == paramLong)) {
        if (paramBoolean)
        {
          if (paramInt3 != 1) {
            break label243;
          }
          bcpw.a(this.jdField_a_of_type_Aqpn.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpn.jdField_a_of_type_AndroidAppActivity.getString(2131718823), 0).a();
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqpn.j();
      return;
      label228:
      if (paramInt3 != 2) {
        break;
      }
      localAIOFileVideoData.f = false;
      break;
      label243:
      if (paramInt3 == 2) {
        bcpw.a(this.jdField_a_of_type_Aqpn.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpn.jdField_a_of_type_AndroidAppActivity.getString(2131718819), 0).a();
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Aqpn.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(aqmj paramaqmj)
  {
    super.a(paramaqmj);
  }
  
  public void a(aqol paramaqol)
  {
    super.a(paramaqol);
    if ((paramaqol instanceof aqpn)) {
      this.jdField_a_of_type_Aqpn = ((aqpn)paramaqol);
    }
  }
  
  public boolean a(long paramLong)
  {
    aqmg localaqmg = a(paramLong);
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 4)) {
      return ((AIOFileVideoData)localaqmg.a).l;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aqnd != null) && (this.jdField_a_of_type_Aqnd.a != null) && (this.jdField_a_of_type_Aqnd.a() != null))
    {
      boolean bool2 = false;
      aqmg localaqmg = a();
      boolean bool1 = bool2;
      if (localaqmg != null)
      {
        bool1 = bool2;
        if (localaqmg.a != null)
        {
          bool1 = bool2;
          if (localaqmg.a.a() == 4) {
            bool1 = bbdj.b(((AIOFileVideoData)localaqmg.a).jdField_c_of_type_JavaLangString);
          }
        }
      }
      if (bool1)
      {
        if (!bkur.b()) {
          break label147;
        }
        this.jdField_a_of_type_Aqnd.a().a((int)actn.a(bkur.a, this.jdField_a_of_type_Aqpn.jdField_a_of_type_AndroidAppActivity.getResources()) + 46);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnd.a().c();
      this.jdField_a_of_type_Aqnd.a().e();
      this.jdField_a_of_type_Aqnd.a.h();
      return;
      label147:
      this.jdField_a_of_type_Aqnd.a().a(46);
    }
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      aqmb.a().a().a("AIOFileVideoPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public void d(long paramLong)
  {
    aqmg localaqmg = a(paramLong);
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 4))
    {
      ((AIOFileVideoData)localaqmg.a).l = false;
      a(localaqmg);
    }
  }
  
  public void e(long paramLong)
  {
    aqmg localaqmg = a(paramLong);
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 4))
    {
      ((AIOFileVideoData)localaqmg.a).m = false;
      a(localaqmg);
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isVideoEnable() = " + amlj.f());
    }
    return amlj.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqnk
 * JD-Core Version:    0.7.0.1
 */