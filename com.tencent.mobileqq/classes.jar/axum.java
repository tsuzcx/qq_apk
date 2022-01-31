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
import com.tencent.richmediabrowser.view.BaseView;
import com.tencent.richmediabrowser.view.BrowserBaseAdapter.URLImageView2;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.page.Gallery;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class axum
  extends axug
{
  public axvr a;
  
  public static void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt)
  {
    if ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
      return;
    }
    AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
    axue localaxue = new axue();
    File localFile = localaxue.a(localAIOPictureData, 4);
    if (localFile == null) {
      localFile = localaxue.a(localAIOPictureData, 2);
    }
    for (int i = 0;; i = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localaxue.a(localAIOPictureData, 1));
      if ((paramRichMediaBrowserInfo.baseData instanceof AIOPictureData))
      {
        paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
        localaxue = new axue();
        if (i == 0) {
          break label255;
        }
      }
      for (int j = 4;; j = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localaxue.a(paramRichMediaBrowserInfo, j));
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
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", axuw.a(localAIOPictureData));
          if (localAIOPictureData.d == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramRichMediaBrowserInfo = new Intent();
          paramRichMediaBrowserInfo.putExtras(localBundle);
          arum.a(paramActivity, paramRichMediaBrowserInfo, paramInt);
          return;
        }
        catch (NullPointerException paramRichMediaBrowserInfo)
        {
          label255:
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
    axue localaxue = new axue();
    File localFile = localaxue.a(localAIOPictureData, 4);
    if (localFile == null) {
      localFile = localaxue.a(localAIOPictureData, 2);
    }
    for (paramInt = 0;; paramInt = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localaxue.a(localAIOPictureData, 1));
      if ((paramRichMediaBrowserInfo.baseData instanceof AIOPictureData))
      {
        paramRichMediaBrowserInfo = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
        localaxue = new axue();
        if (paramInt == 0) {
          break label249;
        }
      }
      for (int i = 4;; i = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localaxue.a(paramRichMediaBrowserInfo, i));
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
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", axuw.a(localAIOPictureData));
          if (localAIOPictureData.d == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramRichMediaBrowserInfo = new Intent();
          paramRichMediaBrowserInfo.putExtras(localBundle);
          return paramRichMediaBrowserInfo;
        }
        catch (NullPointerException paramRichMediaBrowserInfo)
        {
          label249:
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
            return axux.a(paramActivity, paramRichMediaBrowserInfo, bool);
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
    int i = axtu.a().c();
    AIOPictureData localAIOPictureData;
    axue localaxue;
    if ((i == 1) || (i == 2) || (i == 3) || (i == 5) || (i == 6))
    {
      if ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
        return null;
      }
      localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      localaxue = new axue();
      paramRichMediaBrowserInfo = localaxue.a(localAIOPictureData, 4);
      if (paramRichMediaBrowserInfo != null) {
        break label375;
      }
      paramRichMediaBrowserInfo = localaxue.a(localAIOPictureData, 2);
    }
    label375:
    for (paramInt = 0;; paramInt = 1)
    {
      Bundle localBundle = new Bundle(paramActivity.getIntent().getExtras());
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localaxue.a(localAIOPictureData, 1));
      if (paramInt != 0) {}
      for (i = 4;; i = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localaxue.a(localAIOPictureData, i));
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
    if ((paramView instanceof BrowserBaseAdapter.URLImageView2))
    {
      paramView = (BrowserBaseAdapter.URLImageView2)paramView;
      Object localObject1 = getItem(paramInt);
      if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 100) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof AIOPictureData)))
      {
        Object localObject2 = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
        Object localObject3 = new axue();
        if ((paramBoolean) && (((axue)localObject3).a((AIOPictureData)localObject2, 8) != null))
        {
          localObject1 = paramView.getDrawable();
          localObject2 = ((axue)localObject3).a((AIOPictureData)localObject2, 8);
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
        if ((((AIOPictureData)localObject).jdField_a_of_type_Long == paramLong1) && (((AIOPictureData)localObject).jdField_a_of_type_Int == paramInt1) && (this.jdField_a_of_type_Axvr != null))
        {
          this.jdField_a_of_type_Axvr.updateUI();
          if ((paramBoolean) && (paramInt2 == 2) && (this.jdField_a_of_type_Axvr.galleryView != null)) {
            a(getSelectedIndex(), this.jdField_a_of_type_Axvr.galleryView, true);
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
    Object localObject1 = a(paramLong, paramInt1);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 100) && ((((RichMediaBrowserInfo)localObject1).baseData instanceof AIOPictureData)))
    {
      localObject2 = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
      ((AIOPictureData)localObject2).status = 0;
      ((AIOPictureData)localObject2).progress = 0;
      ((RichMediaBrowserInfo)localObject1).baseData = ((RichMediaBaseData)localObject2);
      updateItem((RichMediaBrowserInfo)localObject1);
    }
    Object localObject2 = getSelectedItem();
    if ((this.jdField_a_of_type_Axvr != null) && (localObject2 != null) && ((((RichMediaBrowserInfo)localObject2).baseData instanceof AIOPictureData)) && (((AIOPictureData)((RichMediaBrowserInfo)localObject2).baseData).jdField_a_of_type_Long == paramLong) && (((AIOPictureData)((RichMediaBrowserInfo)localObject2).baseData).jdField_a_of_type_Int == paramInt1))
    {
      if (paramInt2 != 2) {
        break label351;
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
      this.jdField_a_of_type_Axvr.a(paramInt2, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Axvr.updateUI();
      return;
      label343:
      paramString = "I:E";
      break;
      label351:
      if (paramInt2 == 24)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "save pic result = " + paramInt3 + ", resultStr = " + paramString);
        if (paramInt3 == 1) {
          QQToast.a(this.jdField_a_of_type_Axvr.mContext, this.jdField_a_of_type_Axvr.mContext.getString(2131719309), 0).a();
        } else {
          QQToast.a(this.jdField_a_of_type_Axvr.mContext, this.jdField_a_of_type_Axvr.mContext.getString(2131719305), 0).a();
        }
      }
      else if (paramInt2 == 4)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 2, "TYPE_ORIGINAL_IMAGE result = " + paramInt3 + ", resultStr = " + paramString);
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
              localURLDrawable = URLDrawable.getFileDrawable(((AIOPictureData)((RichMediaBrowserInfo)localObject2).baseData).jdField_b_of_type_JavaLangString, null);
              if (localURLDrawable == null) {
                continue;
              }
              localURLDrawable.downloadImediatly();
              ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localURLDrawable;
              localObject1 = URLDrawable.getDrawable(new axue().a((AIOPictureData)((RichMediaBrowserInfo)localObject2).baseData, 4), (URLDrawable.URLDrawableOptions)localObject1);
              paramString = (String)localObject1;
            }
            catch (Throwable localThrowable)
            {
              URLDrawable localURLDrawable;
              localThrowable.printStackTrace();
              continue;
              localGalleryUrlImageView = (GalleryUrlImageView)this.jdField_a_of_type_Axvr.galleryView.findViewById(2131367910);
            }
            if (paramString != null) {
              continue;
            }
            QQToast.a(this.jdField_a_of_type_Axvr.mContext, this.jdField_a_of_type_Axvr.mContext.getString(2131695499), 0).a();
            return;
            localObject1 = "I:E";
            break;
            localURLDrawable = URLDrawable.getFileDrawable(((AIOPictureData)((RichMediaBrowserInfo)localObject2).baseData).jdField_a_of_type_JavaLangString, null);
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
          localGalleryUrlImageView.setGalleryImageListener(new axun(this, paramString, (RichMediaBrowserInfo)localObject2));
          localGalleryUrlImageView.setImageDrawable(paramString);
          this.jdField_a_of_type_Axvr.a = aekt.a(this.jdField_a_of_type_Axvr.b, paramString);
          continue;
        }
        if (!"TroopFileError".equals(paramString)) {
          QQToast.a(this.jdField_a_of_type_Axvr.mContext, this.jdField_a_of_type_Axvr.mContext.getString(2131695499), 0).a();
        }
      }
    }
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.jdField_a_of_type_Axvr != null))
    {
      if (getGallery() != null) {
        this.jdField_a_of_type_Axvr.a(paramURLDrawable, getGallery().getSelectedItemPosition());
      }
      notifyDataSetChanged();
      if (getGallery() != null) {
        getGallery().reset();
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
  
  protected void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, int paramInt1, axuo paramaxuo, int paramInt2, String paramString)
  {
    int i = axtu.a().c();
    if ((i == 1) || (i == 2) || (i == 3) || (i == 5) || (i == 6))
    {
      if ((paramRichMediaBrowserInfo == null) || (paramRichMediaBrowserInfo.baseData == null) || (paramRichMediaBrowserInfo.baseData.getType() != 100)) {
        return;
      }
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      axue localaxue = new axue();
      paramInt1 = 1;
      Object localObject = localaxue.a(localAIOPictureData, 4);
      paramRichMediaBrowserInfo = (RichMediaBrowserInfo)localObject;
      if (localObject == null)
      {
        paramRichMediaBrowserInfo = localaxue.a(localAIOPictureData, 2);
        paramInt1 = 0;
      }
      localObject = new Bundle(paramActivity.getIntent().getExtras());
      ((Bundle)localObject).putInt("forward_type", 1);
      ((Bundle)localObject).putBoolean("forward_urldrawable", true);
      ((Bundle)localObject).putString("forward_urldrawable_thumb_url", localaxue.a(localAIOPictureData, 1));
      if (paramInt1 != 0) {}
      for (i = 4;; i = 2)
      {
        ((Bundle)localObject).putString("forward_urldrawable_big_url", localaxue.a(localAIOPictureData, i));
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
          if ((paramaxuo == null) || (paramaxuo.jdField_a_of_type_Int != 72)) {
            break label438;
          }
          paramRichMediaBrowserInfo.putExtra("key_req", ForwardRecentActivity.f);
          paramRichMediaBrowserInfo.putExtra("key_direct_show_uin_type", paramaxuo.jdField_b_of_type_Int);
          paramRichMediaBrowserInfo.putExtra("key_direct_show_uin", paramaxuo.jdField_a_of_type_JavaLangString);
          arum.a(paramActivity, paramRichMediaBrowserInfo, ForwardRecentTranslucentActivity.class, 19005, paramInt2, paramString);
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
      label438:
      arum.a(paramActivity, paramRichMediaBrowserInfo, 19005, paramInt2, paramString);
      return;
    }
    a(paramRichMediaBrowserInfo, paramActivity, paramInt1);
  }
  
  public void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, Activity paramActivity, axuo paramaxuo, int paramInt, String paramString)
  {
    boolean bool = false;
    AIOPictureData localAIOPictureData;
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (AIOPictureData.class.isInstance(paramRichMediaBrowserInfo.baseData)))
    {
      localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      if ((localAIOPictureData.jdField_b_of_type_Int != 1) || (!localAIOPictureData.k)) {
        break label152;
      }
      if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
      {
        paramRichMediaBrowserInfo = RichMediaBrowserManager.getInstance().getProvider().getForwardData(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 0);
        if (paramRichMediaBrowserInfo != null) {
          break label119;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "forwardPicToFriend getForwardData is null!");
      }
    }
    return;
    label119:
    paramRichMediaBrowserInfo.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    if (localAIOPictureData.jdField_b_of_type_Int == 1) {
      bool = true;
    }
    axux.a(paramActivity, paramRichMediaBrowserInfo, bool, paramInt, paramString);
    return;
    label152:
    a(paramRichMediaBrowserInfo, paramActivity, 0, paramaxuo, paramInt, paramString);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Axvr != null) && (this.jdField_a_of_type_Axuh != null) && (this.jdField_a_of_type_Axuh.a != null) && (this.jdField_a_of_type_Axuh.a() != null))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (!bngs.b()) {
        break label108;
      }
      this.jdField_a_of_type_Axuh.a().a((int)aekt.a(bngs.jdField_a_of_type_Int, this.jdField_a_of_type_Axvr.mContext.getResources()) + 40);
    }
    for (;;)
    {
      this.jdField_a_of_type_Axuh.a().c();
      this.jdField_a_of_type_Axuh.a().e();
      this.jdField_a_of_type_Axuh.a.a();
      return;
      label108:
      this.jdField_a_of_type_Axuh.a().a(40);
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
    boolean bool = aocg.e();
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPicturePresenter", 4, "isImmersionOpen:" + bool);
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Axvr.a != null) {
      this.jdField_a_of_type_Axvr.b.removeCallbacks(this.jdField_a_of_type_Axvr.a);
    }
  }
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    super.setGalleryModel(paramBrowserBaseModel);
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    super.setGalleryView(paramBaseView);
    if ((paramBaseView instanceof axvr)) {
      this.jdField_a_of_type_Axvr = ((axvr)paramBaseView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axum
 * JD-Core Version:    0.7.0.1
 */