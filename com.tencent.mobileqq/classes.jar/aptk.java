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

public class aptk
  extends AIOGalleryBasePresenter
{
  public apvm a;
  public MqqHandler a;
  private ConcurrentHashMap<Long, Set<DanmuItemBean>> b = new ConcurrentHashMap();
  
  public aptk()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new aptl(this);
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
          localampo.b(localDanmuItemBean.jdField_c_of_type_Long);
          if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.a(localalwa.a))) {
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
    if ((this.jdField_a_of_type_Apvm != null) && (this.jdField_a_of_type_Apvm.jdField_a_of_type_Agez != null)) {
      return this.jdField_a_of_type_Apvm.jdField_a_of_type_Agez.a();
    }
    return 0L;
  }
  
  public List<ampo> a(long paramLong1, long paramLong2)
  {
    Set localSet = (Set)this.b.get(Long.valueOf(paramLong1));
    if (localSet != null) {
      return a(a(localSet, paramLong2));
    }
    return null;
  }
  
  public List<ampo> a(long paramLong, List<DanmuItemBean> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      apsm.a().a().a("AIOFileVideoPresenter", 4, "buildDanmakuList list is null");
      return null;
    }
    return a(b(paramLong, paramList));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    apsr localapsr = a(paramLong1);
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 4))
    {
      AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localapsr.a;
      localAIOFileVideoData.g = ((paramInt3 / 10000.0F * (float)localAIOFileVideoData.jdField_c_of_type_Long));
      localapsr.a = localAIOFileVideoData;
      a(localapsr);
    }
    localapsr = a();
    if ((paramInt2 == 1) && (localapsr != null) && (localapsr.a != null) && (localapsr.a.a == paramLong1)) {
      this.jdField_a_of_type_Apvm.j();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    apsr localapsr = a(paramLong);
    boolean bool = false;
    paramBoolean = bool;
    AIOFileVideoData localAIOFileVideoData;
    if (paramInt2 == 269484034)
    {
      paramBoolean = bool;
      if (localapsr != null)
      {
        paramBoolean = bool;
        if (localapsr.a != null)
        {
          paramBoolean = bool;
          if (localapsr.a.a() == 4)
          {
            localAIOFileVideoData = (AIOFileVideoData)localapsr.a;
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
            localapsr.a = localAIOFileVideoData;
            a(localapsr);
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
          bbmy.a(this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity.getString(2131652996), 0).a();
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Apvm.j();
      return;
      label228:
      if (paramInt3 != 2) {
        break;
      }
      localAIOFileVideoData.f = false;
      break;
      label243:
      if (paramInt3 == 2) {
        bbmy.a(this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity.getString(2131652992), 0).a();
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Apvm.a(paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(apsu paramapsu)
  {
    super.a(paramapsu);
  }
  
  public void a(apul paramapul)
  {
    super.a(paramapul);
    if ((paramapul instanceof apvm)) {
      this.jdField_a_of_type_Apvm = ((apvm)paramapul);
    }
  }
  
  public boolean a(long paramLong)
  {
    apsr localapsr = a(paramLong);
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 4)) {
      return ((AIOFileVideoData)localapsr.a).l;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.a != null) && (this.jdField_a_of_type_Apte.a() != null))
    {
      boolean bool2 = false;
      apsr localapsr = a();
      boolean bool1 = bool2;
      if (localapsr != null)
      {
        bool1 = bool2;
        if (localapsr.a != null)
        {
          bool1 = bool2;
          if (localapsr.a.a() == 4) {
            bool1 = bace.b(((AIOFileVideoData)localapsr.a).jdField_c_of_type_JavaLangString);
          }
        }
      }
      if (bool1)
      {
        if (!bjeh.b()) {
          break label147;
        }
        this.jdField_a_of_type_Apte.a().a((int)aciy.a(bjeh.a, this.jdField_a_of_type_Apvm.jdField_a_of_type_AndroidAppActivity.getResources()) + 46);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Apte.a().c();
      this.jdField_a_of_type_Apte.a().e();
      this.jdField_a_of_type_Apte.a.h();
      return;
      label147:
      this.jdField_a_of_type_Apte.a().a(46);
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
      apsm.a().a().a("AIOFileVideoPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public void d(long paramLong)
  {
    apsr localapsr = a(paramLong);
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 4))
    {
      ((AIOFileVideoData)localapsr.a).l = false;
      a(localapsr);
    }
  }
  
  public void e(long paramLong)
  {
    apsr localapsr = a(paramLong);
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 4))
    {
      ((AIOFileVideoData)localapsr.a).m = false;
      a(localapsr);
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isVideoEnable() = " + alvt.f());
    }
    return alvt.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aptk
 * JD-Core Version:    0.7.0.1
 */