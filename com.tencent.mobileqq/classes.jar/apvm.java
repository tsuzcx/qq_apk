import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.video.AIOFileVideoData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.gallery.view.GalleryUrlImageView;
import com.tencent.mobileqq.gallery.view.video.AIOGalleryFileVideoView.1;
import com.tencent.mobileqq.gallery.view.video.AIOGalleryFileVideoView.2;
import com.tencent.mobileqq.gallery.view.video.AIOGalleryFileVideoView.3;
import com.tencent.mobileqq.gallery.view.video.AIOGalleryFileVideoView.4;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class apvm
  extends apue
  implements agey, agfa, View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public agez a;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  public aptk a;
  private bbra jdField_a_of_type_Bbra;
  final Runnable jdField_a_of_type_JavaLangRunnable = new AIOGalleryFileVideoView.3(this);
  public ImageView b;
  public SeekBar b;
  public TextView b;
  public final Runnable b;
  public ImageButton c;
  public RelativeLayout c;
  public TextView c;
  private boolean c;
  public int d;
  public ImageButton d;
  public RelativeLayout d;
  public TextView d;
  
  public apvm(Activity paramActivity, aptk paramaptk)
  {
    super(paramActivity, paramaptk);
    this.jdField_b_of_type_JavaLangRunnable = new AIOGalleryFileVideoView.4(this);
    this.jdField_a_of_type_Aptk = paramaptk;
  }
  
  private void a(apsr paramapsr)
  {
    agfe localagfe;
    Bundle localBundle;
    if ((paramapsr != null) && (paramapsr.a != null) && (paramapsr.a.a() == 4))
    {
      paramapsr = (AIOFileVideoData)paramapsr.a;
      localagfe = new apta().a(paramapsr, paramapsr.m);
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onViewDetached, status = " + paramapsr.jdField_e_of_type_Int);
      if (paramapsr.i)
      {
        localBundle = new Bundle();
        if ((this.jdField_a_of_type_Agez != null) && (agfb.class.isInstance(this.jdField_a_of_type_Agez))) {
          localBundle.putFloat("progress", ((agfb)this.jdField_a_of_type_Agez).a(paramapsr.jdField_a_of_type_Long));
        }
        if (paramapsr.jdField_e_of_type_Boolean) {
          break label240;
        }
        this.jdField_a_of_type_Aptk.a(localagfe.jdField_a_of_type_Long, 10, localBundle);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aptk.a(paramapsr.jdField_a_of_type_Long, paramapsr.jdField_a_of_type_Int, 0);
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "updateItemStatus FILE_VIDEO_PEEK_PAUSE id = " + paramapsr.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Agez != null)
      {
        apsm.a().a().a("AIOGalleryFileVideoView", 4, "onViewDetached video onPause...");
        this.jdField_a_of_type_Agez.i();
      }
      return;
      label240:
      this.jdField_a_of_type_Aptk.a(localagfe.jdField_a_of_type_Long, 12, localBundle);
    }
  }
  
  private boolean a(long paramLong)
  {
    apsr localapsr = this.jdField_a_of_type_Aptk.a();
    return (localapsr != null) && (localapsr.a != null) && (localapsr.a.jdField_a_of_type_Long == paramLong);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      apsr localapsr = this.jdField_a_of_type_Aptk.a();
      if ((localapsr == null) || (!(localapsr.a instanceof AIOFileVideoData))) {
        break label74;
      }
      if (!bace.b(((AIOFileVideoData)localapsr.a).jdField_c_of_type_JavaLangString)) {
        return false;
      }
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    label74:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
  }
  
  private void h(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void r()
  {
    Object localObject = this.jdField_a_of_type_Aptk.a();
    if ((localObject != null) && (((apsr)localObject).a != null) && (((apsr)localObject).a.a() == 4))
    {
      localObject = (AIOFileVideoData)((apsr)localObject).a;
      if (bace.b(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString)) {
        break label56;
      }
    }
    label56:
    label195:
    label198:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Bbra != null) {
        this.jdField_a_of_type_Bbra.b();
      }
      long l;
      if (this.jdField_a_of_type_Agez != null)
      {
        l = this.jdField_a_of_type_Agez.a();
        this.jdField_a_of_type_Bbra = new bbra(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_Bbra.a(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString, ((AIOFileVideoData)localObject).jdField_a_of_type_Long, l);
        if (bace.b(((AIOFileVideoData)localObject).jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_Bbra.a(((AIOFileVideoData)localObject).jdField_b_of_type_JavaLangString, ((AIOFileVideoData)localObject).jdField_c_of_type_Int, ((AIOFileVideoData)localObject).jdField_d_of_type_Int);
        }
        if (((AIOFileVideoData)localObject).jdField_c_of_type_Int <= ((AIOFileVideoData)localObject).jdField_d_of_type_Int) {
          break label195;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (!this.jdField_a_of_type_Bbra.a(bool, ((AIOFileVideoData)localObject).jdField_b_of_type_Int)) {
          break label198;
        }
        this.jdField_a_of_type_Aptk.j();
        return;
        l = 0L;
        break;
      }
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof apvp))) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    }
    apsr localapsr;
    for (paramViewGroup = ((apvp)paramView.getTag()).a;; paramViewGroup = (GalleryUrlImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131306224))
    {
      a();
      localapsr = this.jdField_a_of_type_Aptk.a(paramInt);
      if ((localapsr != null) && (localapsr.a != null)) {
        break;
      }
      return paramViewGroup;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131492993, null));
      paramView = new Gallery.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    AIOFileVideoData localAIOFileVideoData;
    apta localapta;
    if (localapsr.a.a() == 4)
    {
      paramView = this.jdField_a_of_type_Aptk.b();
      if ((paramView == null) || (paramView.a == null) || (paramView.a.a() != 4) || (paramView.a.jdField_a_of_type_Long != localapsr.a.jdField_a_of_type_Long) || (paramView.jdField_c_of_type_Boolean)) {
        break label363;
      }
      awqx.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
      paramView.jdField_c_of_type_Boolean = true;
      localAIOFileVideoData = (AIOFileVideoData)localapsr.a;
      localapta = new apta();
      paramView = (Drawable)this.jdField_a_of_type_Aptk.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (!localapta.b(localAIOFileVideoData)) {
        break label399;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296400, Boolean.valueOf(true));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296433, Boolean.valueOf(true));
      paramViewGroup.setImageDrawable(paramView);
      if (localapta.b(localAIOFileVideoData)) {
        paramViewGroup.setImageDrawable(null);
      }
      if (localapsr.jdField_b_of_type_Boolean) {
        localAIOFileVideoData.jdField_g_of_type_Boolean = true;
      }
      paramView = new apvp(this);
      paramView.a = paramViewGroup;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      label363:
      awqx.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
      break;
      label399:
      if ((paramView == null) || (((URLDrawable)paramView).getStatus() != 1)) {
        break label426;
      }
      this.jdField_a_of_type_Aptk.b(paramInt, true);
    }
    label426:
    if (!TextUtils.isEmpty(localAIOFileVideoData.jdField_b_of_type_JavaLangString))
    {
      File localFile = new File(localAIOFileVideoData.jdField_b_of_type_JavaLangString);
      if (!localFile.exists()) {
        break label552;
      }
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = this.jdField_a_of_type_Int;
      paramView.mRequestHeight = this.jdField_b_of_type_Int;
      paramView.mLoadingDrawable = axwd.a;
      paramView.mPlayGifImage = true;
      paramView.mUseExifOrientation = false;
      paramView = URLDrawable.getDrawable(localFile, paramView);
      ((URLDrawable)paramView).setTag(Integer.valueOf(1));
      this.jdField_a_of_type_Aptk.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), (URLDrawable)paramView);
    }
    label552:
    for (;;)
    {
      break;
      paramView = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837854);
      break;
    }
  }
  
  public View a(int paramInt, apsr paramapsr)
  {
    a(paramapsr);
    return null;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131493510, null));
      Object localObject = (RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131305435);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((RelativeLayout)localObject).findViewById(2131305218));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131310010));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305436));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131306305));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131311809));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307309));
      this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription(ajjy.a(2131634234));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131312850));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131312852));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131312851));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131298702));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131298167));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131308956));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307308));
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307310));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307316));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131313272);
      if (bjeh.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bjeh.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bjeh.jdField_a_of_type_Int;
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      d(true);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    apsr localapsr = this.jdField_a_of_type_Aptk.a();
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 4)) {
      a((AIOFileVideoData)localapsr.a, paramInt);
    }
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Aptk.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_Aptk.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void a(int paramInt, View paramView, apsr paramapsr)
  {
    a(paramapsr);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_Aptk.a(paramInt);
    if ((localObject1 == null) || (((apsr)localObject1).a == null) || (paramView == null)) {
      return;
    }
    GalleryUrlImageView localGalleryUrlImageView;
    if ((paramView.getTag() instanceof apvp))
    {
      localGalleryUrlImageView = ((apvp)paramView.getTag()).a;
      if (((apsr)localObject1).a.a() == 4)
      {
        Object localObject2 = (AIOFileVideoData)((apsr)localObject1).a;
        apta localapta = new apta();
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        localObject2 = localapta.a((AIOFileVideoData)localObject2);
        if (localObject2 == null) {
          break label195;
        }
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        if (((URLDrawable)localObject1).getStatus() != 1) {
          break label171;
        }
        localGalleryUrlImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_Aptk.b(paramInt, true);
        this.jdField_a_of_type_Aptk.a().c();
      }
    }
    for (;;)
    {
      super.a(paramInt, paramString1, paramString2, paramView, paramBoolean);
      return;
      label171:
      ((URLDrawable)localObject1).setTag(Integer.valueOf(1));
      ((URLDrawable)localObject1).startDownload();
      localGalleryUrlImageView.setDecodingDrawble((URLDrawable)localObject1);
      break;
      label195:
      localGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837854));
      this.jdField_a_of_type_Aptk.b(paramInt, true);
    }
  }
  
  public void a(int paramInt1, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    apsm.a().a().a("AIOGalleryFileVideoView", 4, "setVideoDrawableWithUrls position = " + paramInt1);
    apsr localapsr = this.jdField_a_of_type_Aptk.a(paramInt1);
    if ((localapsr == null) || (localapsr.a == null)) {}
    apta localapta;
    for (;;)
    {
      return;
      if (localapsr.a.a() == 4)
      {
        paramMessageForShortVideo = (AIOFileVideoData)localapsr.a;
        localapta = new apta();
        if (paramMessageForShortVideo.jdField_d_of_type_Boolean)
        {
          apsm.a().a().a("AIOGalleryFileVideoView", 4, "fileVideo is playing:" + paramMessageForShortVideo.jdField_a_of_type_Long);
          return;
        }
        paramMessageForShortVideo.jdField_d_of_type_Boolean = true;
        if ("I:E".equals(paramString1)) {
          try
          {
            paramMessageForShortVideo.jdField_f_of_type_Long = Long.parseLong(paramArrayOfString[0]);
            paramString2 = paramArrayOfString[1];
            ((AIOFileVideoData)localapsr.a).jdField_h_of_type_JavaLangString = paramString2;
            this.jdField_a_of_type_Aptk.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 7);
            paramInt1 = 0;
            if (paramMessageForShortVideo.jdField_f_of_type_Long == -134L)
            {
              paramString1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131653699);
              paramInt1 = 1;
              if (paramInt1 != 0)
              {
                paramString1 = babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, "", paramString1, null, ajjy.a(2131634271), new apvn(this), null);
                if (paramString1.isShowing()) {
                  continue;
                }
                paramString1.show();
                return;
              }
            }
          }
          catch (NumberFormatException paramString1)
          {
            paramMessageForShortVideo.jdField_f_of_type_Long = -1L;
            paramMessageForShortVideo.jdField_g_of_type_JavaLangString = paramArrayOfString[1];
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aptk.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 0);
      paramString1 = localapta.a(paramMessageForShortVideo, paramMessageForShortVideo.m);
      this.jdField_a_of_type_Agez.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramString1);
      if (this.jdField_a_of_type_Aptk.a(paramMessageForShortVideo.jdField_a_of_type_Long))
      {
        apsm.a().a().a("AIOGalleryFileVideoView", 4, "setVideoDrawableWithUrls autoPlay id = " + paramMessageForShortVideo.jdField_a_of_type_Long);
        this.jdField_a_of_type_Aptk.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 5);
        this.jdField_a_of_type_Agez.b();
        this.jdField_a_of_type_Agez.f();
      }
      j();
      return;
      if (paramMessageForShortVideo.jdField_f_of_type_Long != -7003L)
      {
        long l = paramMessageForShortVideo.jdField_f_of_type_Long;
        paramString1 = paramString2;
        if (l != -6101L) {
          break;
        }
      }
      paramInt1 = 1;
      paramString1 = paramString2;
      break;
      paramMessageForShortVideo.jdField_d_of_type_JavaLangString = paramArrayOfString[0];
      paramMessageForShortVideo.jdField_f_of_type_JavaLangString = paramString1;
      paramMessageForShortVideo.jdField_e_of_type_JavaLangString = paramString2;
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    apsr localapsr = this.jdField_a_of_type_Aptk.a();
    if ((localapsr == null) || (localapsr.a == null) || (localapsr.a.a() != 4)) {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onRevokeMsg exp!");
    }
    while ((this.jdField_a_of_type_Agez == null) || (!this.jdField_a_of_type_Agez.c())) {
      return;
    }
    this.jdField_a_of_type_Agez.h();
  }
  
  public void a(long paramLong, float paramFloat, String paramString)
  {
    if (a(paramLong)) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryFileVideoView.2(this, paramLong, paramFloat, paramString));
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Aptk.a(paramLong, paramInt, 2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Aptk.a(paramLong, paramInt1, paramInt2, paramString1);
    a(this.jdField_a_of_type_Aptk.c(), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(agfe paramagfe)
  {
    if ((paramagfe != null) && (paramagfe.jdField_a_of_type_Boolean))
    {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onPlayStart file need download");
      return;
    }
    if ((paramagfe != null) && (a(paramagfe.jdField_a_of_type_Long)))
    {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onPlayStart id = " + paramagfe.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aptk.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 5);
      this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      if (this.jdField_a_of_type_Aptk.a(this.jdField_a_of_type_Aptk.a()))
      {
        boolean bool2 = false;
        apsr localapsr = this.jdField_a_of_type_Aptk.a();
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
        if (bool1) {
          this.jdField_a_of_type_Aptk.a();
        }
        if ((localapsr != null) && (localapsr.a != null) && (this.jdField_a_of_type_Aptk.a() != null) && (this.jdField_a_of_type_Agez != null)) {
          this.jdField_a_of_type_Aptk.a().a(this.jdField_a_of_type_Aptk.a(localapsr.a.d, this.jdField_a_of_type_Agez.a()));
        }
      }
    }
    if (paramagfe != null)
    {
      c(paramagfe.jdField_a_of_type_Long);
      d(paramagfe.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Aptk.a(0L, 0L, this.jdField_a_of_type_Aptk.a().c());
  }
  
  public void a(agfe paramagfe, int paramInt)
  {
    if ((paramagfe != null) && (a(paramagfe.jdField_a_of_type_Long)))
    {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onEndBuffering id = " + paramagfe.jdField_a_of_type_Long);
      if (!this.jdField_a_of_type_Agez.c()) {
        break label189;
      }
      Object localObject = this.jdField_a_of_type_Aptk.a();
      if ((localObject != null) && (AIOFileVideoData.class.isInstance(((apsr)localObject).a)))
      {
        localObject = (AIOFileVideoData)((apsr)localObject).a;
        apsm.a().a().a("AIOGalleryFileVideoView", 4, "onEndBuffering isDownloadSuccess: " + ((AIOFileVideoData)localObject).jdField_f_of_type_Boolean);
        if (((AIOFileVideoData)localObject).jdField_f_of_type_Boolean) {
          break label170;
        }
        this.jdField_a_of_type_Aptk.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label170:
      this.jdField_a_of_type_Aptk.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 5);
      continue;
      label189:
      if (this.jdField_a_of_type_Agez.d()) {
        this.jdField_a_of_type_Aptk.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 6);
      }
    }
  }
  
  public void a(agfe paramagfe, int paramInt1, int paramInt2, String paramString)
  {
    String str;
    if ((paramagfe != null) && (a(paramagfe.jdField_a_of_type_Long)))
    {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onError id = " + paramagfe.jdField_a_of_type_Long);
      localObject = this.jdField_a_of_type_Aptk.a();
      if ((localObject != null) && (((apsr)localObject).a != null) && (((apsr)localObject).a.a() == 4))
      {
        this.jdField_a_of_type_Aptk.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 7);
        str = qhv.a(paramInt1, paramInt2);
        paramString = (AIOFileVideoData)((apsr)localObject).a;
        if (!paramString.jdField_e_of_type_Boolean) {
          break label129;
        }
      }
    }
    return;
    label129:
    ((AIOFileVideoData)((apsr)localObject).a).jdField_h_of_type_JavaLangString = str;
    Object localObject = new Bundle();
    float f = 0.0F;
    if (agfb.class.isInstance(this.jdField_a_of_type_Agez)) {
      f = ((agfb)this.jdField_a_of_type_Agez).a(paramagfe.jdField_a_of_type_Long);
    }
    ((Bundle)localObject).putFloat("progress", f);
    this.jdField_a_of_type_Aptk.a(paramString.jdField_a_of_type_Long, 10, (Bundle)localObject);
    j();
  }
  
  public void a(agfe paramagfe, long paramLong)
  {
    if ((paramagfe != null) && (a(paramagfe.jdField_a_of_type_Long)))
    {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onDurationReady id = " + paramagfe.jdField_a_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
    }
  }
  
  public void a(agfe paramagfe, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramagfe != null) && (a(paramagfe.jdField_a_of_type_Long)))
    {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onGetUrl id = " + paramagfe.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aptk.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 4);
      this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_d_of_type_Int = (awnv.a(this.jdField_a_of_type_AndroidAppActivity) / 2);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    b(paramViewGroup);
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    this.jdField_a_of_type_Bahv.a(new apvo(this, paramAIOFileVideoData));
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131627268, 2130839591, 59, localArrayList1);
    a(2131627277, 2130839599, 53, localArrayList1);
    awqx.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131627270, 2130843401, 67, localArrayList1);
    a(2131627267, 2130839590, 57, localArrayList1);
    a(2131627279, 2130839600, 58, localArrayList1);
    if ((this.jdField_a_of_type_Apsx.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Apsx.c()))) {
      a(2131627281, 2130839601, 54, localArrayList2);
    }
    if (apdh.b(paramAIOFileVideoData.jdField_c_of_type_JavaLangString)) {
      a(2131627274, 2130839596, 64, localArrayList2, 5);
    }
    a(paramAIOFileVideoData);
    paramAIOFileVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.jdField_a_of_type_Bahv.a(paramAIOFileVideoData);
    this.jdField_a_of_type_Bahv.a();
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    apsm.a().a().a("AIOGalleryFileVideoView", 4, "onItemSelected position = " + paramInt);
    Object localObject = this.jdField_a_of_type_Aptk.a(paramInt);
    if ((localObject == null) || (((apsr)localObject).a == null)) {}
    while (((apsr)localObject).a.a() != 4) {
      return;
    }
    paramAdapterView = (AIOFileVideoData)((apsr)localObject).a;
    apta localapta = new apta();
    this.jdField_a_of_type_Aptk.a(((apsr)localObject).a.jdField_a_of_type_Long, ((apsr)localObject).a.jdField_a_of_type_Int, 0);
    if (((apsr)localObject).jdField_b_of_type_Boolean) {
      paramAdapterView.jdField_g_of_type_Boolean = true;
    }
    if (localapta.a(paramAdapterView, this.jdField_a_of_type_Aptk.a()))
    {
      if (paramAdapterView.l) {
        this.jdField_a_of_type_Aptk.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 1);
      }
      if ((!bace.b(paramAdapterView.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Aptk.a(this.jdField_a_of_type_Aptk.a()))) {
        this.jdField_a_of_type_Aptk.a(false);
      }
      j();
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "FileVideo_AP onItemSelected needUrl return");
      return;
    }
    if ((a(paramAdapterView)) && (this.jdField_a_of_type_Aptk.a(((apsr)localObject).a.jdField_a_of_type_Long)) && (((apsr)localObject).jdField_b_of_type_Boolean))
    {
      if (paramAdapterView.jdField_h_of_type_Boolean)
      {
        paramAdapterView.jdField_h_of_type_Boolean = false;
        localObject = localapta.a(paramAdapterView, paramAdapterView.m);
        this.jdField_a_of_type_Agez.a(paramView, (agfe)localObject);
      }
      this.jdField_a_of_type_Agez.b();
      this.jdField_a_of_type_Agez.f();
    }
    if ((!bace.b(paramAdapterView.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Aptk.a(this.jdField_a_of_type_Aptk.a()))) {
      this.jdField_a_of_type_Aptk.a(false);
    }
    j();
  }
  
  public boolean a(apsr paramapsr)
  {
    return super.a(paramapsr);
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData)
  {
    agfe localagfe = new apta().a(paramAIOFileVideoData, paramAIOFileVideoData.m);
    if ((localagfe == null) || (this.jdField_a_of_type_Agez == null))
    {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "initVideo error");
      this.jdField_a_of_type_Aptk.a(localagfe.jdField_a_of_type_Long, localagfe.jdField_b_of_type_Int, 7);
      return false;
    }
    localagfe.jdField_e_of_type_Boolean = paramAIOFileVideoData.m;
    apsm.a().a().a("AIOGalleryFileVideoView", 4, "initVideo, set playMediaInfo.isMute =  " + paramAIOFileVideoData.m);
    this.jdField_a_of_type_Agez.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localagfe);
    return true;
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(long paramLong)
  {
    Object localObject;
    if (a(paramLong))
    {
      int i = this.jdField_a_of_type_Aptk.a(paramLong, 0, 0, "");
      localObject = this.jdField_a_of_type_Aptk.a(i);
      if ((localObject != null) && (((apsr)localObject).a != null) && (((apsr)localObject).a.a() == 4))
      {
        localObject = (AIOFileVideoData)((apsr)localObject).a;
        if (!((AIOFileVideoData)localObject).jdField_f_of_type_Boolean) {
          break label76;
        }
      }
    }
    return;
    label76:
    ((AIOFileVideoData)localObject).l = false;
    if ((((AIOFileVideoData)localObject).k) || (((AIOFileVideoData)localObject).jdField_f_of_type_Boolean)) {}
    for (((AIOFileVideoData)localObject).jdField_e_of_type_Int = 0;; ((AIOFileVideoData)localObject).jdField_e_of_type_Int = 5)
    {
      new apta().a((AIOFileVideoData)localObject);
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "file[" + paramLong + "],download success, set downloadSuccess");
      this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
  }
  
  public void b(agfe paramagfe)
  {
    if ((paramagfe != null) && (a(paramagfe.jdField_a_of_type_Long)))
    {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onPlayPause id = " + paramagfe.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Agez.d())
      {
        this.jdField_a_of_type_Aptk.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 6);
        this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
        long l = this.jdField_a_of_type_Agez.a();
        int i = (int)(l / this.jdField_a_of_type_Agez.b() * 10000.0D);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l));
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
        if (this.jdField_a_of_type_Aptk.a(this.jdField_a_of_type_Aptk.a())) {
          this.jdField_a_of_type_Aptk.a(true);
        }
      }
    }
  }
  
  public void b(agfe paramagfe, int paramInt)
  {
    if ((paramagfe != null) && (a(paramagfe.jdField_a_of_type_Long)))
    {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onDownloading id = " + paramagfe.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_Agez != null) && (!this.jdField_a_of_type_Agez.c()))
      {
        this.jdField_a_of_type_Aptk.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 1);
        this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    super.b(paramViewGroup);
    this.jdField_a_of_type_Agez = new agfb();
    this.jdField_a_of_type_Agez.a(this.jdField_a_of_type_Aptk.a());
    this.jdField_a_of_type_Agez.a(this);
    this.jdField_a_of_type_Agez.a(this);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Aptk.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.a == null) || (this.jdField_a_of_type_Aptk.a() == null)) {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "there data is null, position: " + paramInt);
    }
    Object localObject;
    do
    {
      return;
      localObject = ((DragGallery)this.jdField_a_of_type_Aptk.a()).a();
    } while ((paramAdapterView.a.a() != 4) || (this.jdField_a_of_type_Agez == null));
    if ((localObject != null) && (this.jdField_a_of_type_Agez.a((MotionEvent)localObject)))
    {
      paramAdapterView = (AIOFileVideoData)paramAdapterView.a;
      localObject = new apta();
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onItemClick id = " + paramAdapterView.jdField_a_of_type_Long);
      if (((apta)localObject).a(paramAdapterView)) {
        this.jdField_a_of_type_Aptk.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 5);
      }
      for (;;)
      {
        ((apta)localObject).a(paramAdapterView, paramView, this.jdField_a_of_type_Agez);
        j();
        return;
        this.jdField_a_of_type_Aptk.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 1);
      }
    }
    if (this.jdField_a_of_type_Aptk.f())
    {
      if (this.jdField_a_of_type_Aptk.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Aptk.e(false);
        this.jdField_a_of_type_Aptk.jdField_a_of_type_Boolean = false;
        m();
        this.jdField_a_of_type_Aptk.p();
        return;
      }
      this.jdField_a_of_type_Aptk.e(true);
      this.jdField_a_of_type_Aptk.q();
      this.jdField_a_of_type_Aptk.jdField_a_of_type_Boolean = true;
      c(true);
      return;
    }
    this.jdField_a_of_type_Aptk.j();
  }
  
  public void c(int paramInt)
  {
    apsr localapsr;
    if ((paramInt == this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(paramInt)))
    {
      localapsr = this.jdField_a_of_type_Aptk.a();
      if ((localapsr == null) || (localapsr.a == null) || (localapsr.a.a() != 4)) {
        break label104;
      }
    }
    label104:
    for (boolean bool = bace.b(((AIOFileVideoData)localapsr.a).jdField_c_of_type_JavaLangString);; bool = false)
    {
      if ((this.jdField_a_of_type_Agez != null) && (this.jdField_a_of_type_Agez.c()) && (bool))
      {
        this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(false);
      return;
    }
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_Aptk.d(paramLong);
  }
  
  public void c(agfe paramagfe)
  {
    if ((paramagfe != null) && (paramagfe.jdField_b_of_type_Boolean) && (a(paramagfe.jdField_a_of_type_Long)))
    {
      Object localObject = this.jdField_a_of_type_Aptk.a();
      if (AIOFileVideoData.class.isInstance(((apsr)localObject).a))
      {
        localObject = (AIOFileVideoData)((apsr)localObject).a;
        ((AIOFileVideoData)localObject).k = true;
        if (!((AIOFileVideoData)localObject).jdField_f_of_type_Boolean)
        {
          apsm.a().a().a("AIOGalleryFileVideoView", 4, "onPlayFinish id = " + paramagfe.jdField_a_of_type_Long + " ,but file is downloading!");
          this.jdField_a_of_type_Agez.b(8);
        }
      }
    }
    else
    {
      return;
    }
    c(paramagfe.jdField_a_of_type_Long);
    apsm.a().a().a("AIOGalleryFileVideoView", 4, "onPlayFinish id = " + paramagfe.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
    this.jdField_a_of_type_Aptk.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 0);
    this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryFileVideoView.1(this));
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doEnterImmersion, isClick = ").append(paramBoolean).append(" ,  isShowingDanmaku =");
      if (this.jdField_a_of_type_Aptk.a() == null) {
        break label96;
      }
    }
    label96:
    for (boolean bool = this.jdField_a_of_type_Aptk.a().b();; bool = false)
    {
      QLog.d("AIOGalleryFileVideoView", 0, bool);
      super.c(paramBoolean);
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(false);
      d(false);
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.d(false);
      return;
    }
    if ((this.jdField_a_of_type_Aptk.a() != null) && (this.jdField_a_of_type_Aptk.a().b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(0.3F);
      }
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.f();
      h(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(false);
    d(false);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Agez != null) {
      this.jdField_a_of_type_Agez.k();
    }
    if (this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    a(this.jdField_a_of_type_Aptk.a());
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_Aptk.e(paramLong);
  }
  
  public void d(agfe paramagfe)
  {
    if ((paramagfe != null) && (a(paramagfe.jdField_a_of_type_Long)))
    {
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "onBuffering id = " + paramagfe.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aptk.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 3);
      long l = this.jdField_a_of_type_Agez.c();
      if (l <= 0L) {
        break label146;
      }
      paramagfe = ShortVideoUtils.a(this.jdField_a_of_type_AndroidAppActivity, l * 1024L);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramagfe + "/s");
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aptk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label146:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public boolean d()
  {
    if (super.d())
    {
      Object localObject = this.jdField_a_of_type_Aptk.a();
      if ((localObject != null) && (((apsr)localObject).a != null) && (((apsr)localObject).a.a() == 4))
      {
        localObject = (AIOFileVideoData)((apsr)localObject).a;
        if ((!this.jdField_a_of_type_Apsx.c()) && (!TextUtils.isEmpty(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void e()
  {
    super.e();
    d(true);
    j();
  }
  
  public void e(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      g(d());
      return;
    }
  }
  
  public void f()
  {
    d(false);
  }
  
  public void f(boolean paramBoolean)
  {
    LinearLayout localLinearLayout;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    DisplayMetrics localDisplayMetrics;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      localDisplayMetrics = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.addRule(12, -1);
      if (paramBoolean) {
        localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 49.0F, localDisplayMetrics));
      }
    }
    else
    {
      return;
    }
    localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 10.0F, localDisplayMetrics));
  }
  
  public void j()
  {
    super.j();
    Object localObject2 = this.jdField_a_of_type_Aptk.a();
    Object localObject1;
    if ((localObject2 != null) && (((apsr)localObject2).a != null) && (((apsr)localObject2).a.a() == 4))
    {
      localObject1 = (AIOFileVideoData)((apsr)localObject2).a;
      a(d());
      b(a((apsr)localObject2));
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "updateUI id = " + ((AIOFileVideoData)localObject1).jdField_a_of_type_Long + ", status = " + ((AIOFileVideoData)localObject1).a());
    }
    switch (((AIOFileVideoData)localObject1).jdField_e_of_type_Int)
    {
    default: 
      apsm.a().a().a("AIOGalleryFileVideoView", 4, "updateUI status is error, status = " + ((AIOFileVideoData)localObject1).jdField_e_of_type_Int);
      return;
    case 1: 
      this.jdField_a_of_type_Aptk.b(this.jdField_a_of_type_Aptk.c(), true);
      f(false);
      e(true);
      b(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agez.a(8, "");
      this.jdField_a_of_type_Agez.b(8);
      a(false);
      return;
    case 2: 
      this.jdField_a_of_type_Aptk.b(this.jdField_a_of_type_Aptk.c(), true);
      float f = (float)((AIOFileVideoData)localObject1).jdField_g_of_type_Long / (float)((AIOFileVideoData)localObject1).jdField_c_of_type_Long * 100.0F;
      localObject1 = new DecimalFormat("0.00").format(f);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(ajjy.a(2131634240) + (String)localObject1 + "%");
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)f * 100);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      e(true);
      b(false);
      this.jdField_a_of_type_Agez.a(8, "");
      this.jdField_a_of_type_Agez.b(8);
      a(false);
      return;
    case 4: 
      this.jdField_a_of_type_Aptk.a(this.jdField_a_of_type_Aptk.c(), (int)((AIOFileVideoData)localObject1).jdField_g_of_type_Long);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      b(false);
      this.jdField_a_of_type_Agez.a(8, "");
      this.jdField_a_of_type_Agez.b(8);
      a(false);
      return;
    case 3: 
      if (this.jdField_a_of_type_Agez.c())
      {
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        this.jdField_a_of_type_Aptk.b(this.jdField_a_of_type_Aptk.c(), true);
        if (!((AIOFileVideoData)localObject1).jdField_f_of_type_Boolean) {
          break label600;
        }
        f(true);
        e(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_Agez.a(8, "");
        a(true);
        return;
        if ((!this.jdField_a_of_type_Agez.d()) || (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
          break;
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        break;
        e(true);
        f(false);
        b(false);
      }
    case 5: 
      this.jdField_a_of_type_Aptk.b(this.jdField_a_of_type_Aptk.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agez.a(8, "");
      this.jdField_a_of_type_Agez.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845180);
      a(true);
      return;
    case 6: 
      this.jdField_a_of_type_Aptk.b(this.jdField_a_of_type_Aptk.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agez.a(8, "");
      this.jdField_a_of_type_Agez.b(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845179);
      a(true);
      return;
    case 7: 
      label600:
      this.jdField_a_of_type_Aptk.b(this.jdField_a_of_type_Aptk.c(), true);
      f(false);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agez.a(0, ((AIOFileVideoData)localObject1).jdField_h_of_type_JavaLangString);
      this.jdField_a_of_type_Agez.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845179);
      a(false);
      return;
    }
    this.jdField_a_of_type_Aptk.b(this.jdField_a_of_type_Aptk.c(), true);
    f(false);
    e(false);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Agez.a(8, "");
    localObject2 = this.jdField_a_of_type_Agez;
    if (((AIOFileVideoData)localObject1).l) {}
    for (int i = 8;; i = 0)
    {
      ((agez)localObject2).b(i);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845179);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      a(true);
      return;
    }
  }
  
  public void n()
  {
    h(true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          Object localObject = this.jdField_a_of_type_Aptk.a();
          if ((localObject != null) && (((apsr)localObject).a != null) && (((apsr)localObject).a.a() == 4) && (this.jdField_a_of_type_Agez != null))
          {
            localObject = (AIOFileVideoData)((apsr)localObject).a;
            if (((AIOFileVideoData)localObject).jdField_h_of_type_Boolean)
            {
              ((AIOFileVideoData)localObject).jdField_h_of_type_Boolean = false;
              localObject = new apta().a((AIOFileVideoData)localObject, false);
              this.jdField_a_of_type_Agez.a(paramView, (agfe)localObject);
            }
            this.jdField_a_of_type_Agez.b();
            this.jdField_a_of_type_Agez.f();
          }
          this.jdField_a_of_type_Aptk.m();
          this.jdField_a_of_type_Aptk.q();
          this.jdField_a_of_type_Aptk.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Aptk.p();
          return;
        } while (this.jdField_a_of_type_Agez == null);
        paramView = this.jdField_a_of_type_Aptk.a();
      } while ((paramView == null) || (paramView.a == null));
      paramView = (AIOFileVideoData)paramView.a;
      paramView.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Agez.c();
      this.jdField_a_of_type_Agez.e();
      this.jdField_a_of_type_Aptk.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Aptk.j();
      return;
      r();
      this.jdField_a_of_type_Aptk.o();
      return;
      l();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryFileVideoView", 0, "onClick qq_gallery_danmaku_view ");
      }
      paramView = this.jdField_a_of_type_Aptk.a();
      long l = this.jdField_a_of_type_Agez.a();
      if ((paramView != null) && (paramView.a != null)) {
        MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apsx.a(), this.jdField_a_of_type_Apsx.a(), false, 26, paramView.a.d, l);
      }
      this.jdField_a_of_type_Aptk.r();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter == null);
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.j();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Agez != null)
      {
        paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_a_of_type_Agez.b());
        this.jdField_a_of_type_Agez.c(paramInt);
      }
      this.jdField_a_of_type_Aptk.n();
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    apsm.a().a().a("AIOGalleryFileVideoView", 4, "onStopTrackingTouch");
    if (this.jdField_a_of_type_Agez != null)
    {
      this.jdField_a_of_type_Agez.n();
      if ((this.jdField_a_of_type_Aptk.a() != null) && (this.jdField_a_of_type_Aptk.a(this.jdField_a_of_type_Aptk.a())) && (paramSeekBar != null))
      {
        apsm.a().a().a("AIOGalleryFileVideoView", 4, "seek danmaku");
        this.jdField_a_of_type_Aptk.a().a(paramSeekBar.getProgress());
        apsr localapsr = this.jdField_a_of_type_Aptk.a();
        if ((localapsr != null) && (localapsr.a != null)) {
          this.jdField_a_of_type_Aptk.a().a(this.jdField_a_of_type_Aptk.a(localapsr.a.d, paramSeekBar.getProgress()));
        }
      }
    }
  }
  
  public void p()
  {
    apsm.a().a().a("AIOGalleryFileVideoView", 4, "onResume");
    if (this.jdField_a_of_type_Agez != null)
    {
      this.jdField_a_of_type_Agez.j();
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Agez.f();
      }
    }
    j();
  }
  
  public void q()
  {
    apsm.a().a().a("AIOGalleryFileVideoView", 4, "onPause");
    if ((this.jdField_a_of_type_Agez != null) && (this.jdField_a_of_type_Agez.c()))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Agez.h();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void v() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apvm
 * JD-Core Version:    0.7.0.1
 */