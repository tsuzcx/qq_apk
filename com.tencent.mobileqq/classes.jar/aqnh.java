import android.app.Activity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.gallery.view.GalleryUrlImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class aqnh
  extends AIOGalleryBasePresenter
{
  public aqot a;
  private ConcurrentHashMap<Long, List<DanmuItemBean>> b = new ConcurrentHashMap();
  
  private List<DanmuItemBean> b(long paramLong, List<DanmuItemBean> paramList)
  {
    List localList = (List)this.b.get(Long.valueOf(paramLong));
    if (localList == null)
    {
      this.b.put(Long.valueOf(paramLong), paramList);
      return paramList;
    }
    this.b.clear();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DanmuItemBean localDanmuItemBean = (DanmuItemBean)paramList.next();
      if (!localList.contains(localDanmuItemBean)) {
        localArrayList.add(localDanmuItemBean);
      }
    }
    localList.addAll(localArrayList);
    this.b.put(Long.valueOf(paramLong), localList);
    return localArrayList;
  }
  
  public List<anga> a(long paramLong, List<DanmuItemBean> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.jdField_a_of_type_Aqnf.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOFilePicPresenter", 4, "buildDanmakuList list is null");
      }
    }
    do
    {
      return null;
      localObject1 = b(paramLong, paramList);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    paramList = new ArrayList();
    Object localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = new amlp((DanmuItemBean)((Iterator)localObject1).next());
      localObject2 = this.jdField_a_of_type_Aqnf.a().a((amlp)localObject2);
      if (localObject2 != null)
      {
        ((anga)localObject2).a(5000);
        ((anga)localObject2).e(true);
        paramList.add(localObject2);
      }
    }
    return paramList;
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    aqmi localaqmi = a(paramLong1);
    AIOFilePicData localAIOFilePicData;
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 3))
    {
      localAIOFilePicData = (AIOFilePicData)localaqmi.a;
      int i = 0;
      paramInt1 = i;
      switch (paramInt2)
      {
      default: 
        paramInt1 = i;
      }
    }
    for (;;)
    {
      localAIOFilePicData.e = paramInt1;
      localAIOFilePicData.f = paramInt3;
      localaqmi.a = localAIOFilePicData;
      a(localaqmi);
      localaqmi = a();
      if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a == paramLong1)) {
        this.jdField_a_of_type_Aqot.j();
      }
      return;
      paramInt1 = 1;
      continue;
      paramInt1 = 2;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Object localObject1 = a(paramLong);
    if ((localObject1 != null) && (((aqmi)localObject1).a != null) && (((aqmi)localObject1).a.a() == 3))
    {
      localObject2 = (AIOFilePicData)((aqmi)localObject1).a;
      ((AIOFilePicData)localObject2).e = 0;
      ((AIOFilePicData)localObject2).f = 0;
      ((aqmi)localObject1).a = ((GalleryBaseData)localObject2);
      a((aqmi)localObject1);
    }
    Object localObject2 = a();
    if ((localObject2 != null) && (((aqmi)localObject2).a != null) && (((aqmi)localObject2).a.a == paramLong))
    {
      if (paramInt2 != 18) {
        break label228;
      }
      if (paramInt3 != 1) {
        break label221;
      }
      localObject1 = paramString;
      paramInt1 = a(paramLong, paramInt1, paramInt2, (String)localObject1);
      if ((paramInt3 == 2) && (!TextUtils.isEmpty(paramString))) {
        new aqmp().b((AIOFilePicData)((aqmi)localObject2).a, paramInt2, paramString);
      }
      this.jdField_a_of_type_Aqot.a(paramInt1, this.jdField_a_of_type_Aqot.jdField_a_of_type_AndroidWidgetRelativeLayout, paramBoolean);
      aqmd.a().a().a("AIOFilePicPresenter", 2, "notifyImageResult(): Gallery position is " + paramInt1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqot.j();
      return;
      label221:
      localObject1 = "I:E";
      break;
      label228:
      if (paramInt2 == 20)
      {
        if (paramInt3 == 1) {}
        String str;
        for (localObject1 = paramString;; localObject1 = "I:E")
        {
          a(paramLong, paramInt1, paramInt2, (String)localObject1);
          aqmd.a().a().a("AIOFilePicPresenter", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + paramInt3 + ",resultStr: " + paramString);
          if (paramInt3 != 1) {
            break label640;
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
          str = new aqmp().a((AIOFilePicData)((aqmi)localObject2).a, 20);
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          aqmd.a().a().a("AIOFilePicPresenter", 2, "null url");
          return;
        }
        paramString = null;
        URLDrawable localURLDrawable = URLDrawable.getFileDrawable(((AIOFilePicData)((aqmi)localObject2).a).c, null);
        if (localURLDrawable != null)
        {
          localURLDrawable.downloadImediatly();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localURLDrawable;
        }
        for (;;)
        {
          try
          {
            localObject1 = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject1);
            paramString = (String)localObject1;
          }
          catch (Throwable localThrowable)
          {
            aqmd.a().a().a("AIOFilePicPresenter", 4, "URLDrawable.getDrawable failed : " + localThrowable.getMessage());
            continue;
            GalleryUrlImageView localGalleryUrlImageView = (GalleryUrlImageView)this.jdField_a_of_type_Aqot.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367776);
            if (localGalleryUrlImageView == null) {
              break label615;
            }
            localGalleryUrlImageView.setGalleryImageListener(new aqni(this, paramString, (aqmi)localObject2));
            localGalleryUrlImageView.setImageDrawable(paramString);
            if ((paramString.getStatus() != 0) && (paramString.getStatus() != 4)) {
              break label615;
            }
            this.jdField_a_of_type_Aqot.b.setVisibility(0);
          }
          if (paramString != null) {
            continue;
          }
          bcql.a(this.jdField_a_of_type_Aqot.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqot.jdField_a_of_type_AndroidAppActivity.getString(2131695341), 0).a();
          return;
          localURLDrawable = URLDrawable.getFileDrawable(((AIOFilePicData)((aqmi)localObject2).a).b, null);
          if (localURLDrawable != null)
          {
            localURLDrawable.downloadImediatly();
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localURLDrawable;
          }
        }
        label615:
        if ((this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter$ImmersionTimerRunnable == null) && (!this.jdField_a_of_type_Boolean))
        {
          q();
          p();
        }
      }
    }
    label640:
    if (!"TroopFileError".equals(paramString))
    {
      if (!this.jdField_a_of_type_Aqot.jdField_a_of_type_AndroidAppActivity.getString(2131692857).equals(paramString)) {
        break label700;
      }
      bcql.a(this.jdField_a_of_type_Aqot.jdField_a_of_type_AndroidAppActivity, paramString, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqot.e(true);
      break;
      label700:
      bcql.a(this.jdField_a_of_type_Aqot.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqot.jdField_a_of_type_AndroidAppActivity.getString(2131695341), 0).a();
    }
  }
  
  public void a(aqml paramaqml)
  {
    super.a(paramaqml);
  }
  
  public void a(aqon paramaqon)
  {
    super.a(paramaqon);
    if ((paramaqon instanceof aqot)) {
      this.jdField_a_of_type_Aqot = ((aqot)paramaqon);
    }
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.jdField_a_of_type_Aqot != null))
    {
      if (a() != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(a().getSelectedItemPosition()), paramURLDrawable);
      }
      k();
      if (a() != null) {
        a().e();
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aqnf != null) && (this.jdField_a_of_type_Aqnf.a != null) && (this.jdField_a_of_type_Aqnf.a() != null))
    {
      this.b.clear();
      if (!bkvi.b()) {
        break label101;
      }
      this.jdField_a_of_type_Aqnf.a().a((int)actj.a(bkvi.a, this.jdField_a_of_type_Aqot.jdField_a_of_type_AndroidAppActivity.getResources()) + 40);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnf.a().c();
      this.jdField_a_of_type_Aqnf.a().e();
      this.jdField_a_of_type_Aqnf.a.h();
      return;
      label101:
      this.jdField_a_of_type_Aqnf.a().a(40);
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
      aqmd.a().a().a("AIOFilePicPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFilePicPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isImageEnable() = " + amli.e());
    }
    return amli.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqnh
 * JD-Core Version:    0.7.0.1
 */