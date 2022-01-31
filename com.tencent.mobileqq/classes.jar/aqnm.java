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

public class aqnm
  extends AIOGalleryBasePresenter
{
  public aqpp a;
  public MqqHandler a;
  private ConcurrentHashMap<Long, Set<DanmuItemBean>> b = new ConcurrentHashMap();
  
  public aqnm()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new aqnn(this);
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
          localanga.b(localDanmuItemBean.jdField_c_of_type_Long);
          if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.a(localamlp.a))) {
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
    if ((this.jdField_a_of_type_Aqpp != null) && (this.jdField_a_of_type_Aqpp.jdField_a_of_type_Agqv != null)) {
      return this.jdField_a_of_type_Aqpp.jdField_a_of_type_Agqv.a();
    }
    return 0L;
  }
  
  public List<anga> a(long paramLong1, long paramLong2)
  {
    Set localSet = (Set)this.b.get(Long.valueOf(paramLong1));
    if (localSet != null) {
      return a(a(localSet, paramLong2));
    }
    return null;
  }
  
  public List<anga> a(long paramLong, List<DanmuItemBean> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      aqmd.a().a().a("AIOFileVideoPresenter", 4, "buildDanmakuList list is null");
      return null;
    }
    return a(b(paramLong, paramList));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    aqmi localaqmi = a(paramLong1);
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 4))
    {
      AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localaqmi.a;
      localAIOFileVideoData.g = ((paramInt3 / 10000.0F * (float)localAIOFileVideoData.jdField_c_of_type_Long));
      localaqmi.a = localAIOFileVideoData;
      a(localaqmi);
    }
    localaqmi = a();
    if ((paramInt2 == 1) && (localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a == paramLong1)) {
      this.jdField_a_of_type_Aqpp.j();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    aqmi localaqmi = a(paramLong);
    boolean bool = false;
    paramBoolean = bool;
    AIOFileVideoData localAIOFileVideoData;
    if (paramInt2 == 269484034)
    {
      paramBoolean = bool;
      if (localaqmi != null)
      {
        paramBoolean = bool;
        if (localaqmi.a != null)
        {
          paramBoolean = bool;
          if (localaqmi.a.a() == 4)
          {
            localAIOFileVideoData = (AIOFileVideoData)localaqmi.a;
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
            localaqmi.a = localAIOFileVideoData;
            a(localaqmi);
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
          bcql.a(this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity.getString(2131718834), 0).a();
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqpp.j();
      return;
      label228:
      if (paramInt3 != 2) {
        break;
      }
      localAIOFileVideoData.f = false;
      break;
      label243:
      if (paramInt3 == 2) {
        bcql.a(this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity.getString(2131718830), 0).a();
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Aqpp.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(aqml paramaqml)
  {
    super.a(paramaqml);
  }
  
  public void a(aqon paramaqon)
  {
    super.a(paramaqon);
    if ((paramaqon instanceof aqpp)) {
      this.jdField_a_of_type_Aqpp = ((aqpp)paramaqon);
    }
  }
  
  public boolean a(long paramLong)
  {
    aqmi localaqmi = a(paramLong);
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 4)) {
      return ((AIOFileVideoData)localaqmi.a).l;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.a != null) && (this.jdField_a_of_type_Aqnf.a() != null))
    {
      boolean bool2 = false;
      aqmi localaqmi = a();
      boolean bool1 = bool2;
      if (localaqmi != null)
      {
        bool1 = bool2;
        if (localaqmi.a != null)
        {
          bool1 = bool2;
          if (localaqmi.a.a() == 4) {
            bool1 = bbdx.b(((AIOFileVideoData)localaqmi.a).jdField_c_of_type_JavaLangString);
          }
        }
      }
      if (bool1)
      {
        if (!bkvi.b()) {
          break label147;
        }
        this.jdField_a_of_type_Aqnf.a().a((int)actj.a(bkvi.a, this.jdField_a_of_type_Aqpp.jdField_a_of_type_AndroidAppActivity.getResources()) + 46);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnf.a().c();
      this.jdField_a_of_type_Aqnf.a().e();
      this.jdField_a_of_type_Aqnf.a.h();
      return;
      label147:
      this.jdField_a_of_type_Aqnf.a().a(46);
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
      aqmd.a().a().a("AIOFileVideoPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public void d(long paramLong)
  {
    aqmi localaqmi = a(paramLong);
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 4))
    {
      ((AIOFileVideoData)localaqmi.a).l = false;
      a(localaqmi);
    }
  }
  
  public void e(long paramLong)
  {
    aqmi localaqmi = a(paramLong);
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 4))
    {
      ((AIOFileVideoData)localaqmi.a).m = false;
      a(localaqmi);
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isVideoEnable() = " + amli.f());
    }
    return amli.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqnm
 * JD-Core Version:    0.7.0.1
 */