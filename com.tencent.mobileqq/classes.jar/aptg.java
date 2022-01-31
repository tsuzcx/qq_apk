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

public class aptg
  extends AIOGalleryBasePresenter
{
  public apur a;
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
  
  public List<ampo> a(long paramLong, List<DanmuItemBean> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.jdField_a_of_type_Apte.a() == null)) {
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
      Object localObject2 = new alwa((DanmuItemBean)((Iterator)localObject1).next());
      localObject2 = this.jdField_a_of_type_Apte.a().a((alwa)localObject2);
      if (localObject2 != null)
      {
        ((ampo)localObject2).a(5000);
        ((ampo)localObject2).e(true);
        paramList.add(localObject2);
      }
    }
    return paramList;
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    apsr localapsr = a(paramLong1);
    AIOFilePicData localAIOFilePicData;
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 3))
    {
      localAIOFilePicData = (AIOFilePicData)localapsr.a;
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
      localapsr.a = localAIOFilePicData;
      a(localapsr);
      localapsr = a();
      if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a == paramLong1)) {
        this.jdField_a_of_type_Apur.j();
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
    if ((localObject1 != null) && (((apsr)localObject1).a != null) && (((apsr)localObject1).a.a() == 3))
    {
      localObject2 = (AIOFilePicData)((apsr)localObject1).a;
      ((AIOFilePicData)localObject2).e = 0;
      ((AIOFilePicData)localObject2).f = 0;
      ((apsr)localObject1).a = ((GalleryBaseData)localObject2);
      a((apsr)localObject1);
    }
    Object localObject2 = a();
    if ((localObject2 != null) && (((apsr)localObject2).a != null) && (((apsr)localObject2).a.a == paramLong))
    {
      if (paramInt2 != 18) {
        break label188;
      }
      if (paramInt3 != 1) {
        break label181;
      }
      paramInt1 = a(paramLong, paramInt1, paramInt2, paramString);
      this.jdField_a_of_type_Apur.a(paramInt1, this.jdField_a_of_type_Apur.jdField_a_of_type_AndroidWidgetRelativeLayout, paramBoolean);
      apsm.a().a().a("AIOFilePicPresenter", 2, "notifyImageResult(): Gallery position is " + paramInt1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Apur.j();
      return;
      label181:
      paramString = "I:E";
      break;
      label188:
      if (paramInt2 == 20)
      {
        if (paramInt3 == 1) {}
        String str;
        for (localObject1 = paramString;; localObject1 = "I:E")
        {
          a(paramLong, paramInt1, paramInt2, (String)localObject1);
          apsm.a().a().a("AIOFilePicPresenter", 2, "AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:" + paramInt3 + ",resultStr: " + paramString);
          if (paramInt3 != 1) {
            break label578;
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
          str = new apsy().a((AIOFilePicData)((apsr)localObject2).a, 20);
          if (!TextUtils.isEmpty(str)) {
            break;
          }
          apsm.a().a().a("AIOFilePicPresenter", 2, "null url");
          return;
        }
        paramString = null;
        URLDrawable localURLDrawable = URLDrawable.getFileDrawable(((AIOFilePicData)((apsr)localObject2).a).c, null);
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
            apsm.a().a().a("AIOFilePicPresenter", 4, "URLDrawable.getDrawable failed : " + localThrowable.getMessage());
            continue;
            localGalleryUrlImageView = (GalleryUrlImageView)this.jdField_a_of_type_Apur.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302158);
          }
          if (paramString != null) {
            continue;
          }
          bbmy.a(this.jdField_a_of_type_Apur.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apur.jdField_a_of_type_AndroidAppActivity.getString(2131629659), 0).a();
          return;
          localURLDrawable = URLDrawable.getFileDrawable(((AIOFilePicData)((apsr)localObject2).a).b, null);
          if (localURLDrawable != null)
          {
            localURLDrawable.downloadImediatly();
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localURLDrawable;
          }
        }
        GalleryUrlImageView localGalleryUrlImageView;
        if (localGalleryUrlImageView != null)
        {
          localGalleryUrlImageView.setGalleryImageListener(new apth(this, paramString, (apsr)localObject2));
          localGalleryUrlImageView.setImageDrawable(paramString);
          if ((paramString.getStatus() == 0) || (paramString.getStatus() == 4)) {
            this.jdField_a_of_type_Apur.b.setVisibility(0);
          }
        }
      }
    }
    label578:
    if (!"TroopFileError".equals(paramString))
    {
      if (!this.jdField_a_of_type_Apur.jdField_a_of_type_AndroidAppActivity.getString(2131627218).equals(paramString)) {
        break label638;
      }
      bbmy.a(this.jdField_a_of_type_Apur.jdField_a_of_type_AndroidAppActivity, paramString, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Apur.e(true);
      break;
      label638:
      bbmy.a(this.jdField_a_of_type_Apur.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apur.jdField_a_of_type_AndroidAppActivity.getString(2131629659), 0).a();
    }
  }
  
  public void a(apsu paramapsu)
  {
    super.a(paramapsu);
  }
  
  public void a(apul paramapul)
  {
    super.a(paramapul);
    if ((paramapul instanceof apur)) {
      this.jdField_a_of_type_Apur = ((apur)paramapul);
    }
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.jdField_a_of_type_Apur != null))
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
    if ((this.jdField_a_of_type_Apte != null) && (this.jdField_a_of_type_Apte.a != null) && (this.jdField_a_of_type_Apte.a() != null))
    {
      this.b.clear();
      if (!bjeh.b()) {
        break label101;
      }
      this.jdField_a_of_type_Apte.a().a((int)aciy.a(bjeh.a, this.jdField_a_of_type_Apur.jdField_a_of_type_AndroidAppActivity.getResources()) + 40);
    }
    for (;;)
    {
      this.jdField_a_of_type_Apte.a().c();
      this.jdField_a_of_type_Apte.a().e();
      this.jdField_a_of_type_Apte.a.h();
      return;
      label101:
      this.jdField_a_of_type_Apte.a().a(40);
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
      apsm.a().a().a("AIOFilePicPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFilePicPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isImageEnable() = " + alvt.e());
    }
    return alvt.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aptg
 * JD-Core Version:    0.7.0.1
 */