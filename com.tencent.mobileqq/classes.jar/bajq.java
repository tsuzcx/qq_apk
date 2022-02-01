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
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.BrowserURLImageView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class bajq
  extends bajk
{
  public bakw a;
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "TYPE_ORIGINAL_IMAGE result = " + paramInt3 + ", resultStr = " + paramString);
    Object localObject;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (paramInt3 == 1)
    {
      localObject = paramString;
      a(paramLong, paramInt1, paramInt2, (String)localObject);
      if (paramInt3 == 1)
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localObject = null;
        paramString = (String)localObject;
      }
    }
    else
    {
      try
      {
        localURLDrawableOptions.mPlayGifImage = true;
        paramString = (String)localObject;
        localURLDrawableOptions.mUseExifOrientation = false;
        paramString = (String)localObject;
        localURLDrawable = URLDrawable.getFileDrawable(((AIOPictureData)paramRichMediaBrowserInfo.baseData).jdField_b_of_type_JavaLangString, null);
        if (localURLDrawable == null) {
          break label232;
        }
        paramString = (String)localObject;
        localURLDrawable.downloadImediatly();
        paramString = (String)localObject;
        localURLDrawableOptions.mLoadingDrawable = localURLDrawable;
        label145:
        paramString = (String)localObject;
        localObject = URLDrawable.getDrawable(new baji().a((AIOPictureData)paramRichMediaBrowserInfo.baseData, 4), localURLDrawableOptions);
        paramString = (String)localObject;
        ((URLDrawable)localObject).setTag(Integer.valueOf(1));
        paramString = (String)localObject;
      }
      catch (Throwable localThrowable)
      {
        GalleryUrlImageView localGalleryUrlImageView;
        do
        {
          for (;;)
          {
            URLDrawable localURLDrawable;
            localThrowable.printStackTrace();
          }
          localGalleryUrlImageView = (GalleryUrlImageView)this.jdField_a_of_type_Bakw.mBrowserItemView.findViewById(2131368344);
        } while (localGalleryUrlImageView == null);
        localGalleryUrlImageView.setGalleryImageListener(new bajr(this, paramString, paramRichMediaBrowserInfo));
        localGalleryUrlImageView.setImageDrawable(paramString);
        this.jdField_a_of_type_Bakw.a = AIOUtils.showDelayView(this.jdField_a_of_type_Bakw.b, paramString);
        return;
      }
      if (paramString == null) {
        QQToast.a(this.jdField_a_of_type_Bakw.mContext, this.jdField_a_of_type_Bakw.mContext.getString(2131694569), 0).a();
      }
    }
    label232:
    while ("TroopFileError".equals(paramString))
    {
      return;
      localObject = "I:E";
      break;
      paramString = (String)localObject;
      localURLDrawable = URLDrawable.getFileDrawable(((AIOPictureData)paramRichMediaBrowserInfo.baseData).jdField_a_of_type_JavaLangString, null);
      if (localURLDrawable == null) {
        break label145;
      }
      paramString = (String)localObject;
      localURLDrawable.downloadImediatly();
      paramString = (String)localObject;
      localURLDrawableOptions.mLoadingDrawable = localURLDrawable;
      break label145;
    }
    QQToast.a(this.jdField_a_of_type_Bakw.mContext, this.jdField_a_of_type_Bakw.mContext.getString(2131694569), 0).a();
  }
  
  public static void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt)
  {
    if ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
      return;
    }
    AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
    baji localbaji = new baji();
    File localFile = localbaji.a(localAIOPictureData, 4);
    if (localFile == null) {
      localFile = localbaji.a(localAIOPictureData, 2);
    }
    for (int i = 0;; i = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localbaji.a(localAIOPictureData, 1));
      if ((paramRichMediaBrowserInfo.baseData instanceof AIOPictureData))
      {
        paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
        localbaji = new baji();
        if (i == 0) {
          break label256;
        }
      }
      for (int j = 4;; j = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localbaji.a(paramRichMediaBrowserInfo, j));
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
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", bakb.a(localAIOPictureData));
          if (localAIOPictureData.d == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramRichMediaBrowserInfo = new Intent();
          paramRichMediaBrowserInfo.putExtras(localBundle);
          atky.a(paramActivity, paramRichMediaBrowserInfo, paramInt);
          return;
        }
        catch (NullPointerException paramRichMediaBrowserInfo)
        {
          label256:
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramRichMediaBrowserInfo);
          return;
        }
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,cache path is null");
      return;
    }
  }
  
  public static Intent b(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt)
  {
    if ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
      return null;
    }
    AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
    baji localbaji = new baji();
    File localFile = localbaji.a(localAIOPictureData, 4);
    if (localFile == null) {
      localFile = localbaji.a(localAIOPictureData, 2);
    }
    for (paramInt = 0;; paramInt = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localbaji.a(localAIOPictureData, 1));
      if ((paramRichMediaBrowserInfo.baseData instanceof AIOPictureData))
      {
        paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
        localbaji = new baji();
        if (paramInt == 0) {
          break label250;
        }
      }
      for (int i = 4;; i = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localbaji.a(paramRichMediaBrowserInfo, i));
        if (localFile == null) {
          break;
        }
        try
        {
          localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (paramInt != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", bakb.a(localAIOPictureData));
          if (localAIOPictureData.d == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramRichMediaBrowserInfo = new Intent();
          paramRichMediaBrowserInfo.putExtras(localBundle);
          return paramRichMediaBrowserInfo;
        }
        catch (NullPointerException paramRichMediaBrowserInfo)
        {
          label250:
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramRichMediaBrowserInfo);
          return null;
        }
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,cache path is null");
      return null;
    }
  }
  
  public Intent a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (AIOPictureData.class.isInstance(paramRichMediaBrowserInfo.baseData)))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      if ((localAIOPictureData.jdField_b_of_type_Int == 1) && (localAIOPictureData.k))
      {
        if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
        {
          paramRichMediaBrowserInfo = RichMediaBrowserManager.getInstance().getProvider().getForwardData(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 0);
          if (paramRichMediaBrowserInfo == null)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "forwardPicToFriend getForwardData is null!");
            return null;
          }
          paramRichMediaBrowserInfo.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
          if (localAIOPictureData.jdField_b_of_type_Int == 1) {}
          for (boolean bool = true;; bool = false) {
            return bakc.a(paramActivity, paramRichMediaBrowserInfo, bool);
          }
        }
      }
      else {
        return a(paramRichMediaBrowserInfo, paramActivity, 0);
      }
    }
    return null;
  }
  
  public Intent a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt)
  {
    int i = bais.a().c();
    AIOPictureData localAIOPictureData;
    baji localbaji;
    if ((i == 1) || (i == 2) || (i == 3) || (i == 5) || (i == 6))
    {
      if ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
        return null;
      }
      localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      localbaji = new baji();
      paramRichMediaBrowserInfo = localbaji.a(localAIOPictureData, 4);
      if (paramRichMediaBrowserInfo != null) {
        break label383;
      }
      paramRichMediaBrowserInfo = localbaji.a(localAIOPictureData, 2);
    }
    label383:
    for (paramInt = 0;; paramInt = 1)
    {
      Bundle localBundle = new Bundle(paramActivity.getIntent().getExtras());
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localbaji.a(localAIOPictureData, 1));
      if (paramInt != 0) {}
      for (i = 4;; i = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localbaji.a(localAIOPictureData, i));
        if (paramRichMediaBrowserInfo == null) {
          break;
        }
        try
        {
          localBundle.putString("forward_filepath", paramRichMediaBrowserInfo.getAbsolutePath());
          localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (paramInt != 0) {
            localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOPictureData);
          localBundle.putBoolean("key_help_forward_pic", true);
          localBundle.putBoolean("key_allow_multiple_forward_from_limit", false);
          if (!TextUtils.isEmpty(localAIOPictureData.o))
          {
            localBundle.putBoolean("forward_send_template_pic", true);
            localBundle.putString("widgetinfo", localAIOPictureData.o);
            localBundle.putString("key_camera_material_name", localAIOPictureData.p);
          }
          paramRichMediaBrowserInfo = new Intent();
          paramRichMediaBrowserInfo.putExtras(localBundle);
          return paramRichMediaBrowserInfo;
        }
        catch (NullPointerException paramRichMediaBrowserInfo)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramRichMediaBrowserInfo.getMessage());
          return null;
        }
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,cache path is null");
      return null;
      return b(paramRichMediaBrowserInfo, paramActivity, paramInt);
    }
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof BrowserURLImageView))
    {
      paramView = (BrowserURLImageView)paramView;
      Object localObject1 = getItem(paramInt);
      if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 100) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof AIOPictureData)))
      {
        Object localObject2 = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
        Object localObject3 = new baji();
        if ((paramBoolean) && (((baji)localObject3).a((AIOPictureData)localObject2, 8) != null))
        {
          localObject1 = paramView.getDrawable();
          localObject2 = ((baji)localObject3).a((AIOPictureData)localObject2, 8);
          localObject2 = (String)localObject2 + "#" + "DISPLAY";
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject3).mUseExifOrientation = false;
          localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
          paramView.setDecodingDrawble((URLDrawable)localObject1);
          ((URLDrawable)localObject1).startDownload();
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "updateDisplayView(): Update dp image, position=" + paramInt);
          a().b();
        }
      }
    }
  }
  
  public void a(int paramInt, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      this.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      if ((this.jdField_a_of_type_Bakw != null) && (paramInt == getCurrentPosition())) {
        this.jdField_a_of_type_Bakw.bindView(paramInt);
      }
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    Object localObject = a(paramLong1, paramInt1);
    AIOPictureData localAIOPictureData;
    int i;
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOPictureData)))
    {
      localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      i = 0;
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      localAIOPictureData.status = i;
      localAIOPictureData.progress = paramInt3;
      ((RichMediaBrowserInfo)localObject).baseData = localAIOPictureData;
      updateItem((RichMediaBrowserInfo)localObject);
      localObject = getSelectedItem();
      if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOPictureData)))
      {
        localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
        if ((((AIOPictureData)localObject).jdField_a_of_type_Long == paramLong1) && (((AIOPictureData)localObject).jdField_a_of_type_Int == paramInt1) && (this.jdField_a_of_type_Bakw != null))
        {
          this.jdField_a_of_type_Bakw.updateUI();
          if ((paramBoolean) && (paramInt2 == 2) && (this.jdField_a_of_type_Bakw.mBrowserItemView != null)) {
            a(getSelectedIndex(), this.jdField_a_of_type_Bakw.mBrowserItemView, true);
          }
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
    RichMediaBrowserInfo localRichMediaBrowserInfo = a(paramLong, paramInt1);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData.getType() == 100) && ((localRichMediaBrowserInfo.baseData instanceof AIOPictureData)))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)localRichMediaBrowserInfo.baseData;
      localAIOPictureData.status = 0;
      localAIOPictureData.progress = 0;
      localRichMediaBrowserInfo.baseData = localAIOPictureData;
      updateItem(localRichMediaBrowserInfo);
    }
    localRichMediaBrowserInfo = getSelectedItem();
    if ((this.jdField_a_of_type_Bakw != null) && (localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOPictureData)) && (((AIOPictureData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long == paramLong) && (((AIOPictureData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Int == paramInt1))
    {
      if (paramInt2 != 2) {
        break label350;
      }
      if (paramInt3 != 1) {
        break label343;
      }
      paramInt2 = a(paramLong, paramInt1, paramInt2, paramString);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "notifyImageResult(): TYPE_LARGE_IMAGE Gallery position is " + paramInt2);
      paramString = a(paramLong, paramInt1);
      if ((paramString != null) && (paramString.baseData != null) && (paramString.baseData.getType() == 100) && (paramInt3 == 1))
      {
        paramString = (AIOPictureData)paramString.baseData;
        if ((!paramString.j) && (new File(paramString.jdField_a_of_type_JavaLangString + "_hd").exists())) {
          paramString.jdField_a_of_type_JavaLangString += "_hd";
        }
      }
      onLoadFinish(paramInt2, true);
      this.jdField_a_of_type_Bakw.a(paramInt2, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bakw.updateUI();
      return;
      label343:
      paramString = "I:E";
      break;
      label350:
      if (paramInt2 == 24)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "save pic result = " + paramInt3 + ", resultStr = " + paramString);
        if (paramInt3 == 1) {
          QQToast.a(this.jdField_a_of_type_Bakw.mContext, this.jdField_a_of_type_Bakw.mContext.getString(2131717775), 0).a();
        }
        for (;;)
        {
          this.jdField_a_of_type_Bakw.g();
          break;
          QQToast.a(this.jdField_a_of_type_Bakw.mContext, this.jdField_a_of_type_Bakw.mContext.getString(2131717771), 0).a();
        }
      }
      if (paramInt2 == 4)
      {
        a(paramLong, paramInt1, paramInt2, paramInt3, paramString, localRichMediaBrowserInfo);
        this.jdField_a_of_type_Bakw.g();
      }
    }
  }
  
  public void a(AIOPictureData paramAIOPictureData)
  {
    if ((paramAIOPictureData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "dealSaveOriginalImage");
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramAIOPictureData.jdField_a_of_type_Long, paramAIOPictureData.jdField_a_of_type_Int, 24);
    }
  }
  
  protected void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt1, bajs parambajs, int paramInt2, String paramString)
  {
    int i = bais.a().c();
    if ((i == 1) || (i == 2) || (i == 3) || (i == 5) || (i == 6))
    {
      if ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
        return;
      }
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      baji localbaji = new baji();
      paramInt1 = 1;
      Object localObject = localbaji.a(localAIOPictureData, 4);
      paramRichMediaBrowserInfo = (RichMediaBrowserInfo)localObject;
      if (localObject == null)
      {
        paramRichMediaBrowserInfo = localbaji.a(localAIOPictureData, 2);
        paramInt1 = 0;
      }
      localObject = new Bundle(paramActivity.getIntent().getExtras());
      ((Bundle)localObject).putInt("forward_type", 1);
      ((Bundle)localObject).putBoolean("forward_urldrawable", true);
      ((Bundle)localObject).putString("forward_urldrawable_thumb_url", localbaji.a(localAIOPictureData, 1));
      if (paramInt1 != 0) {}
      for (i = 4;; i = 2)
      {
        ((Bundle)localObject).putString("forward_urldrawable_big_url", localbaji.a(localAIOPictureData, i));
        if (paramRichMediaBrowserInfo == null) {
          break;
        }
        try
        {
          ((Bundle)localObject).putString("forward_filepath", paramRichMediaBrowserInfo.getAbsolutePath());
          ((Bundle)localObject).putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
          if (paramInt1 != 0) {
            ((Bundle)localObject).putInt("PhotoConst.SEND_SIZE_SPEC", 2);
          }
          ((Bundle)localObject).putParcelable("FORWARD_MSG_FOR_PIC", localAIOPictureData);
          ((Bundle)localObject).putBoolean("key_help_forward_pic", true);
          ((Bundle)localObject).putBoolean("key_allow_multiple_forward_from_limit", false);
          if (!TextUtils.isEmpty(localAIOPictureData.o))
          {
            ((Bundle)localObject).putBoolean("forward_send_template_pic", true);
            ((Bundle)localObject).putString("widgetinfo", localAIOPictureData.o);
            ((Bundle)localObject).putString("key_camera_material_name", localAIOPictureData.p);
          }
          paramRichMediaBrowserInfo = new Intent();
          paramRichMediaBrowserInfo.putExtras((Bundle)localObject);
          if ((parambajs == null) || (parambajs.jdField_a_of_type_Int != 72)) {
            break label446;
          }
          paramRichMediaBrowserInfo.putExtra("key_req", ForwardRecentActivity.f);
          paramRichMediaBrowserInfo.putExtra("key_direct_show_uin_type", parambajs.jdField_b_of_type_Int);
          paramRichMediaBrowserInfo.putExtra("key_direct_show_uin", parambajs.jdField_a_of_type_JavaLangString);
          atky.a(paramActivity, paramRichMediaBrowserInfo, ForwardRecentTranslucentActivity.class, 19005, paramInt2, paramString);
          return;
        }
        catch (NullPointerException paramRichMediaBrowserInfo)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramRichMediaBrowserInfo.getMessage());
          return;
        }
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "showFriendPickerForForward ,cache path is null");
      return;
      label446:
      atky.a(paramActivity, paramRichMediaBrowserInfo, 19005, paramInt2, paramString);
      return;
    }
    a(paramRichMediaBrowserInfo, paramActivity, paramInt1);
  }
  
  public void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, bajs parambajs, int paramInt, String paramString)
  {
    boolean bool = false;
    AIOPictureData localAIOPictureData;
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (AIOPictureData.class.isInstance(paramRichMediaBrowserInfo.baseData)))
    {
      localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      if ((localAIOPictureData.jdField_b_of_type_Int != 1) || (!localAIOPictureData.k)) {
        break label154;
      }
      if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
      {
        paramRichMediaBrowserInfo = RichMediaBrowserManager.getInstance().getProvider().getForwardData(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 0);
        if (paramRichMediaBrowserInfo != null) {
          break label120;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "forwardPicToFriend getForwardData is null!");
      }
    }
    return;
    label120:
    paramRichMediaBrowserInfo.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    if (localAIOPictureData.jdField_b_of_type_Int == 1) {
      bool = true;
    }
    bakc.a(paramActivity, paramRichMediaBrowserInfo, bool, paramInt, paramString);
    return;
    label154:
    a(paramRichMediaBrowserInfo, paramActivity, 0, parambajs, paramInt, paramString);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bakw != null) && (this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.a != null) && (this.jdField_a_of_type_Bajl.a() != null))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (!LiuHaiUtils.b()) {
        break label108;
      }
      this.jdField_a_of_type_Bajl.a().a((int)AIOUtils.px2dp(LiuHaiUtils.jdField_a_of_type_Int, this.jdField_a_of_type_Bakw.mContext.getResources()) + 40);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bajl.a().c();
      this.jdField_a_of_type_Bajl.a().e();
      this.jdField_a_of_type_Bajl.a.a();
      return;
      label108:
      this.jdField_a_of_type_Bajl.a().a(40);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.mActiveDrawable.remove(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public boolean b()
  {
    boolean bool = appl.a();
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "isImmersionOpen:" + bool);
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bakw.a != null) {
      this.jdField_a_of_type_Bakw.b.removeCallbacks(this.jdField_a_of_type_Bakw.a);
    }
  }
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    super.setGalleryModel(paramBrowserBaseModel);
  }
  
  public void setGalleryView(BrowserBaseView paramBrowserBaseView)
  {
    super.setGalleryView(paramBrowserBaseView);
    if ((paramBrowserBaseView instanceof bakw)) {
      this.jdField_a_of_type_Bakw = ((bakw)paramBrowserBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajq
 * JD-Core Version:    0.7.0.1
 */