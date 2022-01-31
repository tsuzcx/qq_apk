import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.gallery.view.GalleryBaseAdapter.URLImageView2;
import com.tencent.mobileqq.gallery.view.GalleryUrlImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class apti
  extends AIOGalleryBasePresenter
{
  public apux a;
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
  
  public static void b(apsr paramapsr, Activity paramActivity, int paramInt)
  {
    if ((paramapsr == null) || (paramapsr.a == null) || (paramapsr.a.a() != 1)) {
      return;
    }
    AIOPicData localAIOPicData = (AIOPicData)paramapsr.a;
    apsz localapsz = new apsz();
    File localFile = localapsz.a(localAIOPicData, 4);
    if (localFile == null) {
      localFile = localapsz.a(localAIOPicData, 2);
    }
    for (int i = 0;; i = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localapsz.a(localAIOPicData, 1));
      if ((paramapsr.a instanceof AIOPicData))
      {
        paramapsr = (AIOPicData)paramapsr.a;
        localapsz = new apsz();
        if (i == 0) {
          break label254;
        }
      }
      for (int j = 4;; j = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localapsz.a(paramapsr, j));
        if (localFile == null) {
          break;
        }
        try
        {
          localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (i != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", aptt.a(localAIOPicData));
          if (localAIOPicData.d == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramapsr = new Intent();
          paramapsr.putExtras(localBundle);
          aphp.a(paramActivity, paramapsr, paramInt);
          return;
        }
        catch (NullPointerException paramapsr)
        {
          label254:
          apsm.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramapsr);
          return;
        }
      }
      apsm.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,cache path is null");
      return;
    }
  }
  
  public List<ampo> a(long paramLong, List<DanmuItemBean> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.jdField_a_of_type_Apte.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOPicPresenter", 4, "buildDanmakuList list is null");
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
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof GalleryBaseAdapter.URLImageView2))
    {
      paramView = (GalleryBaseAdapter.URLImageView2)paramView;
      Object localObject1 = a(paramInt);
      if ((localObject1 != null) && (((apsr)localObject1).a != null) && (((apsr)localObject1).a.a() == 1))
      {
        Object localObject2 = (AIOPicData)((apsr)localObject1).a;
        Object localObject3 = new apsz();
        if ((paramBoolean) && (((apsz)localObject3).a((AIOPicData)localObject2, 8) != null))
        {
          localObject1 = paramView.getDrawable();
          localObject2 = ((apsz)localObject3).a((AIOPicData)localObject2, 8);
          localObject2 = (String)localObject2 + "#" + "DISPLAY";
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject3).mUseExifOrientation = false;
          localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
          paramView.setDecodingDrawble((URLDrawable)localObject1);
          ((URLDrawable)localObject1).startDownload();
          apsm.a().a().a("AIOPicPresenter", 2, "updateDisplayView(): Update dp image, position=" + paramInt);
          a().b();
        }
      }
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    apsr localapsr = a(paramLong1, paramInt1);
    AIOPicData localAIOPicData;
    int i;
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 1))
    {
      localAIOPicData = (AIOPicData)localapsr.a;
      i = 0;
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      localAIOPicData.h = i;
      localAIOPicData.i = paramInt3;
      localapsr.a = localAIOPicData;
      a(localapsr);
      localapsr = a();
      if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.jdField_a_of_type_Long == paramLong1) && (localapsr.a.jdField_a_of_type_Int == paramInt1) && (this.jdField_a_of_type_Apux != null))
      {
        this.jdField_a_of_type_Apux.j();
        if ((paramBoolean) && (paramInt2 == 2) && (this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
          a(c(), this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
        }
      }
      return;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 2;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Object localObject1 = a(paramLong, paramInt1);
    if ((localObject1 != null) && (((apsr)localObject1).a != null) && (((apsr)localObject1).a.a() == 1))
    {
      localObject2 = (AIOPicData)((apsr)localObject1).a;
      ((AIOPicData)localObject2).h = 0;
      ((AIOPicData)localObject2).i = 0;
      ((apsr)localObject1).a = ((GalleryBaseData)localObject2);
      a((apsr)localObject1);
    }
    Object localObject2 = a();
    if ((localObject2 != null) && (((apsr)localObject2).a != null) && (((apsr)localObject2).a.jdField_a_of_type_Long == paramLong) && (((apsr)localObject2).a.jdField_a_of_type_Int == paramInt1))
    {
      if (paramInt2 != 2) {
        break label330;
      }
      if (paramInt3 != 1) {
        break label322;
      }
      paramInt2 = a(paramLong, paramInt1, paramInt2, paramString);
      apsm.a().a().a("AIOPicPresenter", 2, "notifyImageResult(): TYPE_LARGE_IMAGE Gallery position is " + paramInt2);
      paramString = a(paramLong, paramInt1);
      if ((paramString != null) && (paramString.a != null) && (paramString.a.a() == 1) && (paramInt3 == 1))
      {
        paramString = (AIOPicData)paramString.a;
        if ((!paramString.j) && (new File(paramString.jdField_a_of_type_JavaLangString + "_hd").exists())) {
          paramString.jdField_a_of_type_JavaLangString += "_hd";
        }
      }
      b(paramInt2, true);
      this.jdField_a_of_type_Apux.a(paramInt2, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Apux.j();
      return;
      label322:
      paramString = "I:E";
      break;
      label330:
      if (paramInt2 == 24)
      {
        apsm.a().a().a("AIOPicPresenter", 2, "save pic result = " + paramInt3 + ", resultStr = " + paramString);
        if (paramInt3 == 1) {
          bbmy.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity.getString(2131652996), 0).a();
        } else {
          bbmy.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity.getString(2131652992), 0).a();
        }
      }
      else if (paramInt2 == 4)
      {
        apsm.a().a().a("AIOPicPresenter", 2, "TYPE_ORIGINAL_IMAGE result = " + paramInt3 + ", resultStr = " + paramString);
        if (paramInt3 == 1)
        {
          localObject1 = paramString;
          a(paramLong, paramInt1, paramInt2, (String)localObject1);
          if (paramInt3 == 1)
          {
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            paramString = null;
          }
        }
        else
        {
          for (;;)
          {
            try
            {
              ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
              ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
              localURLDrawable = URLDrawable.getFileDrawable(((AIOPicData)((apsr)localObject2).a).jdField_b_of_type_JavaLangString, null);
              if (localURLDrawable == null) {
                continue;
              }
              localURLDrawable.downloadImediatly();
              ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localURLDrawable;
              localObject1 = URLDrawable.getDrawable(new apsz().a((AIOPicData)((apsr)localObject2).a, 4), (URLDrawable.URLDrawableOptions)localObject1);
              paramString = (String)localObject1;
            }
            catch (Throwable localThrowable)
            {
              URLDrawable localURLDrawable;
              localThrowable.printStackTrace();
              continue;
              localGalleryUrlImageView = (GalleryUrlImageView)this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302158);
            }
            if (paramString != null) {
              continue;
            }
            bbmy.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity.getString(2131629659), 0).a();
            return;
            localObject1 = "I:E";
            break;
            localURLDrawable = URLDrawable.getFileDrawable(((AIOPicData)((apsr)localObject2).a).jdField_a_of_type_JavaLangString, null);
            if (localURLDrawable != null)
            {
              localURLDrawable.downloadImediatly();
              ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localURLDrawable;
            }
          }
          GalleryUrlImageView localGalleryUrlImageView;
          if (localGalleryUrlImageView == null) {
            continue;
          }
          localGalleryUrlImageView.setGalleryImageListener(new aptj(this, paramString, (apsr)localObject2));
          localGalleryUrlImageView.setImageDrawable(paramString);
          if ((paramString.getStatus() != 0) && (paramString.getStatus() != 4)) {
            continue;
          }
          this.jdField_a_of_type_Apux.b.setVisibility(0);
          continue;
        }
        if (!"TroopFileError".equals(paramString)) {
          bbmy.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity.getString(2131629659), 0).a();
        }
      }
    }
  }
  
  public void a(apsr paramapsr, Activity paramActivity)
  {
    AIOPicData localAIOPicData;
    if ((paramapsr != null) && (paramapsr.a != null) && (AIOPicData.class.isInstance(paramapsr.a)))
    {
      localAIOPicData = (AIOPicData)paramapsr.a;
      if ((localAIOPicData == null) || (paramapsr.a.jdField_b_of_type_Int != 1) || (!localAIOPicData.k)) {
        break label134;
      }
      if (e())
      {
        paramapsr = a(localAIOPicData.jdField_a_of_type_Long, localAIOPicData.jdField_a_of_type_Int, 0);
        if (paramapsr != null) {
          break label101;
        }
        apsm.a().a().a("AIOPicPresenter", 4, "forwardPicToFriend getForwardData is null!");
      }
    }
    return;
    label101:
    paramapsr.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    if (localAIOPicData.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      aptu.a(paramActivity, paramapsr, bool);
      return;
    }
    label134:
    a(paramapsr, paramActivity, 0);
  }
  
  protected void a(apsr paramapsr, Activity paramActivity, int paramInt)
  {
    if (a() == null) {
      apsm.a().a().a("AIOPicPresenter", 4, "forwardPicToFriend paramsManager is null!");
    }
    int i;
    do
    {
      return;
      i = a().c();
      if ((i != 1) && (i != 2) && (i != 3) && (i != 5) && (i != 6)) {
        break;
      }
    } while ((paramapsr == null) || (paramapsr.a == null) || (paramapsr.a.a() != 1));
    AIOPicData localAIOPicData = (AIOPicData)paramapsr.a;
    apsz localapsz = new apsz();
    paramapsr = localapsz.a(localAIOPicData, 4);
    if (paramapsr == null) {
      paramapsr = localapsz.a(localAIOPicData, 2);
    }
    for (paramInt = 0;; paramInt = 1)
    {
      Bundle localBundle = new Bundle(paramActivity.getIntent().getExtras());
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localapsz.a(localAIOPicData, 1));
      if (paramInt != 0) {}
      for (i = 4;; i = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localapsz.a(localAIOPicData, i));
        if (paramapsr == null) {
          break;
        }
        try
        {
          localBundle.putString("forward_filepath", paramapsr.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (paramInt != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOPicData);
          localBundle.putBoolean("key_help_forward_pic", true);
          localBundle.putBoolean("key_allow_multiple_forward_from_limit", false);
          if (!TextUtils.isEmpty(localAIOPicData.o))
          {
            localBundle.putBoolean("forward_send_template_pic", true);
            localBundle.putString("widgetinfo", localAIOPicData.o);
          }
          paramapsr = new Intent();
          paramapsr.putExtras(localBundle);
          aphp.a(paramActivity, paramapsr, 19005);
          return;
        }
        catch (NullPointerException paramapsr)
        {
          apsm.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramapsr.getMessage());
          return;
        }
      }
      apsm.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,cache path is null");
      return;
      b(paramapsr, paramActivity, paramInt);
      return;
    }
  }
  
  public void a(apsu paramapsu)
  {
    super.a(paramapsu);
  }
  
  public void a(apul paramapul)
  {
    super.a(paramapul);
    if ((paramapul instanceof apux)) {
      this.jdField_a_of_type_Apux = ((apux)paramapul);
    }
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.jdField_a_of_type_Apux != null))
    {
      if (a() != null) {
        this.jdField_a_of_type_Apux.a(paramURLDrawable, a().getSelectedItemPosition());
      }
      k();
      if (a() != null) {
        a().e();
      }
    }
  }
  
  public void a(AIOPicData paramAIOPicData)
  {
    if (paramAIOPicData != null)
    {
      apsm.a().a().a("AIOPicPresenter", 2, "dealSaveOriginalImage");
      b(paramAIOPicData.jdField_a_of_type_Long, paramAIOPicData.jdField_a_of_type_Int, 24);
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
      this.jdField_a_of_type_Apte.a().a((int)aciy.a(bjeh.jdField_a_of_type_Int, this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity.getResources()) + 40);
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
      apsm.a().a().a("AIOPicPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPicPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isImageEnable() = " + alvt.e());
    }
    return alvt.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apti
 * JD-Core Version:    0.7.0.1
 */