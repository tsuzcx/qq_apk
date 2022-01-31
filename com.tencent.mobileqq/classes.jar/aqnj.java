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

public class aqnj
  extends AIOGalleryBasePresenter
{
  public aqoz a;
  private ConcurrentHashMap<Long, List<DanmuItemBean>> b = new ConcurrentHashMap();
  
  public static void a(aqmi paramaqmi, Activity paramActivity, int paramInt)
  {
    if ((paramaqmi == null) || (paramaqmi.a == null) || (paramaqmi.a.a() != 1)) {
      return;
    }
    AIOPicData localAIOPicData = (AIOPicData)paramaqmi.a;
    aqmq localaqmq = new aqmq();
    File localFile = localaqmq.a(localAIOPicData, 4);
    if (localFile == null) {
      localFile = localaqmq.a(localAIOPicData, 2);
    }
    for (int i = 0;; i = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localaqmq.a(localAIOPicData, 1));
      if ((paramaqmi.a instanceof AIOPicData))
      {
        paramaqmi = (AIOPicData)paramaqmi.a;
        localaqmq = new aqmq();
        if (i == 0) {
          break label254;
        }
      }
      for (int j = 4;; j = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localaqmq.a(paramaqmi, j));
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
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", aqnv.a(localAIOPicData));
          if (localAIOPicData.d == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramaqmi = new Intent();
          paramaqmi.putExtras(localBundle);
          aqbe.a(paramActivity, paramaqmi, paramInt);
          return;
        }
        catch (NullPointerException paramaqmi)
        {
          label254:
          aqmd.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramaqmi);
          return;
        }
      }
      aqmd.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,cache path is null");
      return;
    }
  }
  
  public static Intent b(aqmi paramaqmi, Activity paramActivity, int paramInt)
  {
    if ((paramaqmi == null) || (paramaqmi.a == null) || (paramaqmi.a.a() != 1)) {
      return null;
    }
    AIOPicData localAIOPicData = (AIOPicData)paramaqmi.a;
    aqmq localaqmq = new aqmq();
    File localFile = localaqmq.a(localAIOPicData, 4);
    if (localFile == null) {
      localFile = localaqmq.a(localAIOPicData, 2);
    }
    for (paramInt = 0;; paramInt = 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localaqmq.a(localAIOPicData, 1));
      if ((paramaqmi.a instanceof AIOPicData))
      {
        paramaqmi = (AIOPicData)paramaqmi.a;
        localaqmq = new aqmq();
        if (paramInt == 0) {
          break label248;
        }
      }
      for (int i = 4;; i = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localaqmq.a(paramaqmi, i));
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
          localBundle.putParcelable("FORWARD_MSG_FOR_PIC", aqnv.a(localAIOPicData));
          if (localAIOPicData.d == 4) {
            localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
          }
          paramaqmi = new Intent();
          paramaqmi.putExtras(localBundle);
          return paramaqmi;
        }
        catch (NullPointerException paramaqmi)
        {
          label248:
          aqmd.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramaqmi);
          return null;
        }
      }
      aqmd.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,cache path is null");
      return null;
    }
  }
  
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
  
  public Intent a(aqmi paramaqmi, Activity paramActivity)
  {
    if ((paramaqmi != null) && (paramaqmi.a != null) && (AIOPicData.class.isInstance(paramaqmi.a)))
    {
      AIOPicData localAIOPicData = (AIOPicData)paramaqmi.a;
      if ((localAIOPicData != null) && (paramaqmi.a.jdField_b_of_type_Int == 1) && (localAIOPicData.k))
      {
        if (e())
        {
          paramaqmi = a(localAIOPicData.jdField_a_of_type_Long, localAIOPicData.jdField_a_of_type_Int, 0);
          if (paramaqmi == null)
          {
            aqmd.a().a().a("AIOPicPresenter", 4, "forwardPicToFriend getForwardData is null!");
            return null;
          }
          paramaqmi.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
          if (localAIOPicData.jdField_b_of_type_Int == 1) {}
          for (boolean bool = true;; bool = false) {
            return aqnw.a(paramActivity, paramaqmi, bool);
          }
        }
      }
      else {
        return a(paramaqmi, paramActivity, 0);
      }
    }
    return null;
  }
  
  public Intent a(aqmi paramaqmi, Activity paramActivity, int paramInt)
  {
    if (a() == null)
    {
      aqmd.a().a().a("AIOPicPresenter", 4, "forwardPicToFriend paramsManager is null!");
      return null;
    }
    int i = a().c();
    AIOPicData localAIOPicData;
    aqmq localaqmq;
    if ((i == 1) || (i == 2) || (i == 3) || (i == 5) || (i == 6))
    {
      if ((paramaqmi == null) || (paramaqmi.a == null) || (paramaqmi.a.a() != 1)) {
        return null;
      }
      localAIOPicData = (AIOPicData)paramaqmi.a;
      localaqmq = new aqmq();
      paramaqmi = localaqmq.a(localAIOPicData, 4);
      if (paramaqmi != null) {
        break label393;
      }
      paramaqmi = localaqmq.a(localAIOPicData, 2);
    }
    label393:
    for (paramInt = 0;; paramInt = 1)
    {
      Bundle localBundle = new Bundle(paramActivity.getIntent().getExtras());
      localBundle.putInt("forward_type", 1);
      localBundle.putBoolean("forward_urldrawable", true);
      localBundle.putString("forward_urldrawable_thumb_url", localaqmq.a(localAIOPicData, 1));
      if (paramInt != 0) {}
      for (i = 4;; i = 2)
      {
        localBundle.putString("forward_urldrawable_big_url", localaqmq.a(localAIOPicData, i));
        if (paramaqmi == null) {
          break;
        }
        try
        {
          localBundle.putString("forward_filepath", paramaqmi.getAbsolutePath());
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
          paramaqmi = new Intent();
          paramaqmi.putExtras(localBundle);
          return paramaqmi;
        }
        catch (NullPointerException paramaqmi)
        {
          aqmd.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramaqmi.getMessage());
          return null;
        }
      }
      aqmd.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,cache path is null");
      return null;
      return b(paramaqmi, paramActivity, paramInt);
    }
  }
  
  public List<anga> a(long paramLong, List<DanmuItemBean> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.jdField_a_of_type_Aqnf.a() == null)) {
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
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof GalleryBaseAdapter.URLImageView2))
    {
      paramView = (GalleryBaseAdapter.URLImageView2)paramView;
      Object localObject1 = a(paramInt);
      if ((localObject1 != null) && (((aqmi)localObject1).a != null) && (((aqmi)localObject1).a.a() == 1))
      {
        Object localObject2 = (AIOPicData)((aqmi)localObject1).a;
        Object localObject3 = new aqmq();
        if ((paramBoolean) && (((aqmq)localObject3).a((AIOPicData)localObject2, 8) != null))
        {
          localObject1 = paramView.getDrawable();
          localObject2 = ((aqmq)localObject3).a((AIOPicData)localObject2, 8);
          localObject2 = (String)localObject2 + "#" + "DISPLAY";
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject3).mUseExifOrientation = false;
          localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
          paramView.setDecodingDrawble((URLDrawable)localObject1);
          ((URLDrawable)localObject1).startDownload();
          aqmd.a().a().a("AIOPicPresenter", 2, "updateDisplayView(): Update dp image, position=" + paramInt);
          a().b();
        }
      }
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    aqmi localaqmi = a(paramLong1, paramInt1);
    AIOPicData localAIOPicData;
    int i;
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 1))
    {
      localAIOPicData = (AIOPicData)localaqmi.a;
      i = 0;
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      localAIOPicData.h = i;
      localAIOPicData.i = paramInt3;
      localaqmi.a = localAIOPicData;
      a(localaqmi);
      localaqmi = a();
      if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.jdField_a_of_type_Long == paramLong1) && (localaqmi.a.jdField_a_of_type_Int == paramInt1) && (this.jdField_a_of_type_Aqoz != null))
      {
        this.jdField_a_of_type_Aqoz.j();
        if ((paramBoolean) && (paramInt2 == 2) && (this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
          a(c(), this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
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
    if ((localObject1 != null) && (((aqmi)localObject1).a != null) && (((aqmi)localObject1).a.a() == 1))
    {
      localObject2 = (AIOPicData)((aqmi)localObject1).a;
      ((AIOPicData)localObject2).h = 0;
      ((AIOPicData)localObject2).i = 0;
      ((aqmi)localObject1).a = ((GalleryBaseData)localObject2);
      a((aqmi)localObject1);
    }
    Object localObject2 = a();
    if ((localObject2 != null) && (((aqmi)localObject2).a != null) && (((aqmi)localObject2).a.jdField_a_of_type_Long == paramLong) && (((aqmi)localObject2).a.jdField_a_of_type_Int == paramInt1))
    {
      if (paramInt2 != 2) {
        break label330;
      }
      if (paramInt3 != 1) {
        break label322;
      }
      paramInt2 = a(paramLong, paramInt1, paramInt2, paramString);
      aqmd.a().a().a("AIOPicPresenter", 2, "notifyImageResult(): TYPE_LARGE_IMAGE Gallery position is " + paramInt2);
      paramString = a(paramLong, paramInt1);
      if ((paramString != null) && (paramString.a != null) && (paramString.a.a() == 1) && (paramInt3 == 1))
      {
        paramString = (AIOPicData)paramString.a;
        if ((!paramString.j) && (new File(paramString.jdField_a_of_type_JavaLangString + "_hd").exists())) {
          paramString.jdField_a_of_type_JavaLangString += "_hd";
        }
      }
      b(paramInt2, true);
      this.jdField_a_of_type_Aqoz.a(paramInt2, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqoz.j();
      return;
      label322:
      paramString = "I:E";
      break;
      label330:
      if (paramInt2 == 24)
      {
        aqmd.a().a().a("AIOPicPresenter", 2, "save pic result = " + paramInt3 + ", resultStr = " + paramString);
        if (paramInt3 == 1) {
          bcql.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity.getString(2131718834), 0).a();
        } else {
          bcql.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity.getString(2131718830), 0).a();
        }
      }
      else if (paramInt2 == 4)
      {
        aqmd.a().a().a("AIOPicPresenter", 2, "TYPE_ORIGINAL_IMAGE result = " + paramInt3 + ", resultStr = " + paramString);
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
              localURLDrawable = URLDrawable.getFileDrawable(((AIOPicData)((aqmi)localObject2).a).jdField_b_of_type_JavaLangString, null);
              if (localURLDrawable == null) {
                continue;
              }
              localURLDrawable.downloadImediatly();
              ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localURLDrawable;
              localObject1 = URLDrawable.getDrawable(new aqmq().a((AIOPicData)((aqmi)localObject2).a, 4), (URLDrawable.URLDrawableOptions)localObject1);
              paramString = (String)localObject1;
            }
            catch (Throwable localThrowable)
            {
              URLDrawable localURLDrawable;
              localThrowable.printStackTrace();
              continue;
              localGalleryUrlImageView = (GalleryUrlImageView)this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367776);
            }
            if (paramString != null) {
              continue;
            }
            bcql.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity.getString(2131695341), 0).a();
            return;
            localObject1 = "I:E";
            break;
            localURLDrawable = URLDrawable.getFileDrawable(((AIOPicData)((aqmi)localObject2).a).jdField_a_of_type_JavaLangString, null);
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
          localGalleryUrlImageView.setGalleryImageListener(new aqnk(this, paramString, (aqmi)localObject2));
          localGalleryUrlImageView.setImageDrawable(paramString);
          if ((paramString.getStatus() != 0) && (paramString.getStatus() != 4)) {
            continue;
          }
          this.jdField_a_of_type_Aqoz.b.setVisibility(0);
          continue;
        }
        if (!"TroopFileError".equals(paramString)) {
          bcql.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity.getString(2131695341), 0).a();
        }
      }
    }
  }
  
  protected void a(aqmi paramaqmi, Activity paramActivity, int paramInt1, aqnl paramaqnl, int paramInt2, String paramString)
  {
    if (a() == null) {
      aqmd.a().a().a("AIOPicPresenter", 4, "forwardPicToFriend paramsManager is null!");
    }
    do
    {
      return;
      i = a().c();
      if ((i != 1) && (i != 2) && (i != 3) && (i != 5) && (i != 6)) {
        break;
      }
    } while ((paramaqmi == null) || (paramaqmi.a == null) || (paramaqmi.a.a() != 1));
    AIOPicData localAIOPicData = (AIOPicData)paramaqmi.a;
    aqmq localaqmq = new aqmq();
    paramInt1 = 1;
    Object localObject = localaqmq.a(localAIOPicData, 4);
    paramaqmi = (aqmi)localObject;
    if (localObject == null)
    {
      paramaqmi = localaqmq.a(localAIOPicData, 2);
      paramInt1 = 0;
    }
    localObject = new Bundle(paramActivity.getIntent().getExtras());
    ((Bundle)localObject).putInt("forward_type", 1);
    ((Bundle)localObject).putBoolean("forward_urldrawable", true);
    ((Bundle)localObject).putString("forward_urldrawable_thumb_url", localaqmq.a(localAIOPicData, 1));
    if (paramInt1 != 0) {}
    for (int i = 4;; i = 2)
    {
      ((Bundle)localObject).putString("forward_urldrawable_big_url", localaqmq.a(localAIOPicData, i));
      if (paramaqmi == null) {
        break;
      }
      try
      {
        ((Bundle)localObject).putString("forward_filepath", paramaqmi.getAbsolutePath());
        ((Bundle)localObject).putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
        if (paramInt1 != 0) {
          ((Bundle)localObject).putInt("PhotoConst.SEND_SIZE_SPEC", 2);
        }
        ((Bundle)localObject).putParcelable("FORWARD_MSG_FOR_PIC", localAIOPicData);
        ((Bundle)localObject).putBoolean("key_help_forward_pic", true);
        ((Bundle)localObject).putBoolean("key_allow_multiple_forward_from_limit", false);
        if (!TextUtils.isEmpty(localAIOPicData.o))
        {
          ((Bundle)localObject).putBoolean("forward_send_template_pic", true);
          ((Bundle)localObject).putString("widgetinfo", localAIOPicData.o);
        }
        paramaqmi = new Intent();
        paramaqmi.putExtras((Bundle)localObject);
        if ((paramaqnl == null) || (paramaqnl.jdField_a_of_type_Int != 72)) {
          break label454;
        }
        paramaqmi.putExtra("key_req", ForwardRecentActivity.f);
        paramaqmi.putExtra("key_direct_show_uin_type", paramaqnl.jdField_b_of_type_Int);
        paramaqmi.putExtra("key_direct_show_uin", paramaqnl.jdField_a_of_type_JavaLangString);
        aqbe.a(paramActivity, paramaqmi, ForwardRecentTranslucentActivity.class, 19005, paramInt2, paramString);
        return;
      }
      catch (NullPointerException paramaqmi)
      {
        aqmd.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,NullPointerException: " + paramaqmi.getMessage());
        return;
      }
    }
    aqmd.a().a().a("AIOPicPresenter", 4, "showFriendPickerForForward ,cache path is null");
    return;
    label454:
    aqbe.a(paramActivity, paramaqmi, 19005, paramInt2, paramString);
    return;
    a(paramaqmi, paramActivity, paramInt1);
  }
  
  public void a(aqmi paramaqmi, Activity paramActivity, aqnl paramaqnl, int paramInt, String paramString)
  {
    boolean bool = false;
    AIOPicData localAIOPicData;
    if ((paramaqmi != null) && (paramaqmi.a != null) && (AIOPicData.class.isInstance(paramaqmi.a)))
    {
      localAIOPicData = (AIOPicData)paramaqmi.a;
      if ((localAIOPicData == null) || (paramaqmi.a.jdField_b_of_type_Int != 1) || (!localAIOPicData.k)) {
        break label136;
      }
      if (e())
      {
        paramaqmi = a(localAIOPicData.jdField_a_of_type_Long, localAIOPicData.jdField_a_of_type_Int, 0);
        if (paramaqmi != null) {
          break label103;
        }
        aqmd.a().a().a("AIOPicPresenter", 4, "forwardPicToFriend getForwardData is null!");
      }
    }
    return;
    label103:
    paramaqmi.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    if (localAIOPicData.jdField_b_of_type_Int == 1) {
      bool = true;
    }
    aqnw.a(paramActivity, paramaqmi, bool, paramInt, paramString);
    return;
    label136:
    a(paramaqmi, paramActivity, 0, paramaqnl, paramInt, paramString);
  }
  
  public void a(aqml paramaqml)
  {
    super.a(paramaqml);
  }
  
  public void a(aqon paramaqon)
  {
    super.a(paramaqon);
    if ((paramaqon instanceof aqoz)) {
      this.jdField_a_of_type_Aqoz = ((aqoz)paramaqon);
    }
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (this.jdField_a_of_type_Aqoz != null))
    {
      if (a() != null) {
        this.jdField_a_of_type_Aqoz.a(paramURLDrawable, a().getSelectedItemPosition());
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
      aqmd.a().a().a("AIOPicPresenter", 2, "dealSaveOriginalImage");
      b(paramAIOPicData.jdField_a_of_type_Long, paramAIOPicData.jdField_a_of_type_Int, 24);
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
      this.jdField_a_of_type_Aqnf.a().a((int)actj.a(bkvi.jdField_a_of_type_Int, this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity.getResources()) + 40);
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
      aqmd.a().a().a("AIOPicPresenter", 4, "onRevokeMsg exception = " + localException.getMessage());
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPicPresenter", 2, "isImmersionOpen, ImmersiveConfProcessor.isImageEnable() = " + amli.e());
    }
    return amli.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqnj
 * JD-Core Version:    0.7.0.1
 */