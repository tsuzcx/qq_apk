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
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class aqpp
  extends aqog
  implements agqu, agqw, View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public agqv a;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  public aqnm a;
  private bcuq jdField_a_of_type_Bcuq;
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
  
  public aqpp(Activity paramActivity, aqnm paramaqnm)
  {
    super(paramActivity, paramaqnm);
    this.jdField_b_of_type_JavaLangRunnable = new AIOGalleryFileVideoView.4(this);
    this.jdField_a_of_type_Aqnm = paramaqnm;
  }
  
  private void a(aqmi paramaqmi)
  {
    agra localagra;
    Bundle localBundle;
    if ((paramaqmi != null) && (paramaqmi.a != null) && (paramaqmi.a.a() == 4))
    {
      paramaqmi = (AIOFileVideoData)paramaqmi.a;
      localagra = new aqmr().a(paramaqmi, paramaqmi.m);
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onViewDetached, status = " + paramaqmi.jdField_e_of_type_Int);
      if (paramaqmi.i)
      {
        localBundle = new Bundle();
        if ((this.jdField_a_of_type_Agqv != null) && (agqx.class.isInstance(this.jdField_a_of_type_Agqv))) {
          localBundle.putFloat("progress", ((agqx)this.jdField_a_of_type_Agqv).a(paramaqmi.jdField_a_of_type_Long));
        }
        if (paramaqmi.jdField_e_of_type_Boolean) {
          break label240;
        }
        this.jdField_a_of_type_Aqnm.a(localagra.jdField_a_of_type_Long, 10, localBundle);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnm.a(paramaqmi.jdField_a_of_type_Long, paramaqmi.jdField_a_of_type_Int, 0);
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "updateItemStatus FILE_VIDEO_PEEK_PAUSE id = " + paramaqmi.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Agqv != null)
      {
        aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onViewDetached video onPause...");
        this.jdField_a_of_type_Agqv.i();
      }
      return;
      label240:
      this.jdField_a_of_type_Aqnm.a(localagra.jdField_a_of_type_Long, 12, localBundle);
    }
  }
  
  private boolean a(long paramLong)
  {
    aqmi localaqmi = this.jdField_a_of_type_Aqnm.a();
    return (localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.jdField_a_of_type_Long == paramLong);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      aqmi localaqmi = this.jdField_a_of_type_Aqnm.a();
      if ((localaqmi == null) || (!(localaqmi.a instanceof AIOFileVideoData))) {
        break label74;
      }
      if (!bbdx.b(((AIOFileVideoData)localaqmi.a).jdField_c_of_type_JavaLangString)) {
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
  
  private void s()
  {
    Object localObject = this.jdField_a_of_type_Aqnm.a();
    if ((localObject != null) && (((aqmi)localObject).a != null) && (((aqmi)localObject).a.a() == 4))
    {
      localObject = (AIOFileVideoData)((aqmi)localObject).a;
      if (bbdx.b(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString)) {
        break label56;
      }
    }
    label56:
    label195:
    label198:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Bcuq != null) {
        this.jdField_a_of_type_Bcuq.b();
      }
      long l;
      if (this.jdField_a_of_type_Agqv != null)
      {
        l = this.jdField_a_of_type_Agqv.a();
        this.jdField_a_of_type_Bcuq = new bcuq(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_Bcuq.a(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString, ((AIOFileVideoData)localObject).jdField_a_of_type_Long, l);
        if (bbdx.b(((AIOFileVideoData)localObject).jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_Bcuq.a(((AIOFileVideoData)localObject).jdField_b_of_type_JavaLangString, ((AIOFileVideoData)localObject).jdField_c_of_type_Int, ((AIOFileVideoData)localObject).jdField_d_of_type_Int);
        }
        if (((AIOFileVideoData)localObject).jdField_c_of_type_Int <= ((AIOFileVideoData)localObject).jdField_d_of_type_Int) {
          break label195;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (!this.jdField_a_of_type_Bcuq.a(bool, ((AIOFileVideoData)localObject).jdField_b_of_type_Int)) {
          break label198;
        }
        this.jdField_a_of_type_Aqnm.j();
        return;
        l = 0L;
        break;
      }
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof aqps))) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    }
    aqmi localaqmi;
    for (paramViewGroup = ((aqps)paramView.getTag()).a;; paramViewGroup = (GalleryUrlImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371919))
    {
      a();
      localaqmi = this.jdField_a_of_type_Aqnm.a(paramInt);
      if ((localaqmi != null) && (localaqmi.a != null)) {
        break;
      }
      return paramViewGroup;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558545, null));
      paramView = new Gallery.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    AIOFileVideoData localAIOFileVideoData;
    aqmr localaqmr;
    if (localaqmi.a.a() == 4)
    {
      paramView = this.jdField_a_of_type_Aqnm.b();
      if ((paramView == null) || (paramView.a == null) || (paramView.a.a() != 4) || (paramView.a.jdField_a_of_type_Long != localaqmi.a.jdField_a_of_type_Long) || (paramView.jdField_c_of_type_Boolean)) {
        break label377;
      }
      axqy.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
      paramView.jdField_c_of_type_Boolean = true;
      localAIOFileVideoData = (AIOFileVideoData)localaqmi.a;
      localaqmr = new aqmr();
      paramView = (Drawable)this.jdField_a_of_type_Aqnm.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (!localaqmr.b(localAIOFileVideoData)) {
        break label413;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296400, Boolean.valueOf(true));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296433, Boolean.valueOf(true));
      paramViewGroup.setImageDrawable(paramView);
      paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691636));
      if (localaqmr.b(localAIOFileVideoData)) {
        paramViewGroup.setImageDrawable(null);
      }
      if (localaqmi.jdField_b_of_type_Boolean) {
        localAIOFileVideoData.jdField_g_of_type_Boolean = true;
      }
      paramView = new aqps(this);
      paramView.a = paramViewGroup;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      label377:
      axqy.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
      break;
      label413:
      if ((paramView == null) || (((URLDrawable)paramView).getStatus() != 1)) {
        break label440;
      }
      this.jdField_a_of_type_Aqnm.b(paramInt, true);
    }
    label440:
    if (!TextUtils.isEmpty(localAIOFileVideoData.jdField_b_of_type_JavaLangString))
    {
      File localFile = new File(localAIOFileVideoData.jdField_b_of_type_JavaLangString);
      if (!localFile.exists()) {
        break label566;
      }
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = this.jdField_a_of_type_Int;
      paramView.mRequestHeight = this.jdField_b_of_type_Int;
      paramView.mLoadingDrawable = aywm.a;
      paramView.mPlayGifImage = true;
      paramView.mUseExifOrientation = false;
      paramView = URLDrawable.getDrawable(localFile, paramView);
      ((URLDrawable)paramView).setTag(Integer.valueOf(1));
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), (URLDrawable)paramView);
    }
    label566:
    for (;;)
    {
      break;
      paramView = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911);
      break;
    }
  }
  
  public View a(int paramInt, aqmi paramaqmi)
  {
    a(paramaqmi);
    return null;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559079, null));
      Object localObject = (RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371128);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((RelativeLayout)localObject).findViewById(2131370891));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131375776));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371129));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372002));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377624));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373021));
      this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription(ajya.a(2131700033));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131378679));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131378681));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131378680));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131364259));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363721));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374698));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373020));
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373022));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373028));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379112);
      if (bkvi.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bkvi.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bkvi.jdField_a_of_type_Int;
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      d(true);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    aqmi localaqmi = this.jdField_a_of_type_Aqnm.a();
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 4)) {
      a((AIOFileVideoData)localaqmi.a, paramInt);
    }
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Aqnm.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void a(int paramInt, View paramView, aqmi paramaqmi)
  {
    a(paramaqmi);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_Aqnm.a(paramInt);
    if ((localObject1 == null) || (((aqmi)localObject1).a == null) || (paramView == null)) {
      return;
    }
    GalleryUrlImageView localGalleryUrlImageView;
    if ((paramView.getTag() instanceof aqps))
    {
      localGalleryUrlImageView = ((aqps)paramView.getTag()).a;
      if (((aqmi)localObject1).a.a() == 4)
      {
        Object localObject2 = (AIOFileVideoData)((aqmi)localObject1).a;
        aqmr localaqmr = new aqmr();
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        localObject2 = localaqmr.a((AIOFileVideoData)localObject2);
        if (localObject2 == null) {
          break label195;
        }
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        if (((URLDrawable)localObject1).getStatus() != 1) {
          break label171;
        }
        localGalleryUrlImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_Aqnm.b(paramInt, true);
        this.jdField_a_of_type_Aqnm.a().c();
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
      localGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911));
      this.jdField_a_of_type_Aqnm.b(paramInt, true);
    }
  }
  
  public void a(int paramInt1, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    aqmd.a().a().a("AIOGalleryFileVideoView", 4, "setVideoDrawableWithUrls position = " + paramInt1);
    aqmi localaqmi = this.jdField_a_of_type_Aqnm.a(paramInt1);
    if ((localaqmi == null) || (localaqmi.a == null)) {}
    aqmr localaqmr;
    for (;;)
    {
      return;
      if (localaqmi.a.a() == 4)
      {
        paramMessageForShortVideo = (AIOFileVideoData)localaqmi.a;
        localaqmr = new aqmr();
        if (paramMessageForShortVideo.jdField_d_of_type_Boolean)
        {
          aqmd.a().a().a("AIOGalleryFileVideoView", 4, "fileVideo is playing:" + paramMessageForShortVideo.jdField_a_of_type_Long);
          return;
        }
        paramMessageForShortVideo.jdField_d_of_type_Boolean = true;
        if ("I:E".equals(paramString1)) {
          try
          {
            paramMessageForShortVideo.jdField_f_of_type_Long = Long.parseLong(paramArrayOfString[0]);
            paramString2 = paramArrayOfString[1];
            ((AIOFileVideoData)localaqmi.a).jdField_h_of_type_JavaLangString = paramString2;
            this.jdField_a_of_type_Aqnm.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 7);
            paramInt1 = 0;
            if (paramMessageForShortVideo.jdField_f_of_type_Long == -134L)
            {
              paramString1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131719594);
              paramInt1 = 1;
              if (paramInt1 != 0)
              {
                paramString1 = bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, "", paramString1, null, ajya.a(2131700070), new aqpq(this), null);
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
      this.jdField_a_of_type_Aqnm.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 0);
      paramString1 = localaqmr.a(paramMessageForShortVideo, paramMessageForShortVideo.m);
      this.jdField_a_of_type_Agqv.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramString1);
      if (this.jdField_a_of_type_Aqnm.a(paramMessageForShortVideo.jdField_a_of_type_Long))
      {
        aqmd.a().a().a("AIOGalleryFileVideoView", 4, "setVideoDrawableWithUrls autoPlay id = " + paramMessageForShortVideo.jdField_a_of_type_Long);
        this.jdField_a_of_type_Aqnm.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 5);
        this.jdField_a_of_type_Agqv.b();
        this.jdField_a_of_type_Agqv.f();
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
    aqmi localaqmi = this.jdField_a_of_type_Aqnm.a();
    if ((localaqmi == null) || (localaqmi.a == null) || (localaqmi.a.a() != 4)) {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onRevokeMsg exp!");
    }
    while ((this.jdField_a_of_type_Agqv == null) || (!this.jdField_a_of_type_Agqv.c())) {
      return;
    }
    this.jdField_a_of_type_Agqv.h();
  }
  
  public void a(long paramLong, float paramFloat, String paramString)
  {
    if (a(paramLong)) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryFileVideoView.2(this, paramLong, paramFloat, paramString));
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Aqnm.a(paramLong, paramInt, 2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Aqnm.a(paramLong, paramInt1, paramInt2, paramString1);
    a(this.jdField_a_of_type_Aqnm.c(), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(agra paramagra)
  {
    if ((paramagra != null) && (paramagra.jdField_a_of_type_Boolean))
    {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onPlayStart file need download");
      return;
    }
    if ((paramagra != null) && (a(paramagra.jdField_a_of_type_Long)))
    {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onPlayStart id = " + paramagra.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqnm.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 5);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      if (this.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Aqnm.a()))
      {
        boolean bool2 = false;
        aqmi localaqmi = this.jdField_a_of_type_Aqnm.a();
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
        if (bool1) {
          this.jdField_a_of_type_Aqnm.a();
        }
        if ((localaqmi != null) && (localaqmi.a != null) && (this.jdField_a_of_type_Aqnm.a() != null) && (this.jdField_a_of_type_Agqv != null)) {
          this.jdField_a_of_type_Aqnm.a().a(this.jdField_a_of_type_Aqnm.a(localaqmi.a.d, this.jdField_a_of_type_Agqv.a()));
        }
      }
    }
    if (paramagra != null)
    {
      c(paramagra.jdField_a_of_type_Long);
      d(paramagra.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Aqnm.a(0L, 0L, this.jdField_a_of_type_Aqnm.a().c());
  }
  
  public void a(agra paramagra, int paramInt)
  {
    if ((paramagra != null) && (a(paramagra.jdField_a_of_type_Long)))
    {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onEndBuffering id = " + paramagra.jdField_a_of_type_Long);
      if (!this.jdField_a_of_type_Agqv.c()) {
        break label189;
      }
      Object localObject = this.jdField_a_of_type_Aqnm.a();
      if ((localObject != null) && (AIOFileVideoData.class.isInstance(((aqmi)localObject).a)))
      {
        localObject = (AIOFileVideoData)((aqmi)localObject).a;
        aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onEndBuffering isDownloadSuccess: " + ((AIOFileVideoData)localObject).jdField_f_of_type_Boolean);
        if (((AIOFileVideoData)localObject).jdField_f_of_type_Boolean) {
          break label170;
        }
        this.jdField_a_of_type_Aqnm.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label170:
      this.jdField_a_of_type_Aqnm.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 5);
      continue;
      label189:
      if (this.jdField_a_of_type_Agqv.d()) {
        this.jdField_a_of_type_Aqnm.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 6);
      }
    }
  }
  
  public void a(agra paramagra, int paramInt1, int paramInt2, String paramString)
  {
    String str;
    if ((paramagra != null) && (a(paramagra.jdField_a_of_type_Long)))
    {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onError id = " + paramagra.jdField_a_of_type_Long);
      localObject = this.jdField_a_of_type_Aqnm.a();
      if ((localObject != null) && (((aqmi)localObject).a != null) && (((aqmi)localObject).a.a() == 4))
      {
        this.jdField_a_of_type_Aqnm.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 7);
        str = qtx.a(paramInt1, paramInt2);
        paramString = (AIOFileVideoData)((aqmi)localObject).a;
        if (!paramString.jdField_e_of_type_Boolean) {
          break label129;
        }
      }
    }
    return;
    label129:
    ((AIOFileVideoData)((aqmi)localObject).a).jdField_h_of_type_JavaLangString = str;
    Object localObject = new Bundle();
    float f = 0.0F;
    if (agqx.class.isInstance(this.jdField_a_of_type_Agqv)) {
      f = ((agqx)this.jdField_a_of_type_Agqv).a(paramagra.jdField_a_of_type_Long);
    }
    ((Bundle)localObject).putFloat("progress", f);
    this.jdField_a_of_type_Aqnm.a(paramString.jdField_a_of_type_Long, 10, (Bundle)localObject);
    j();
  }
  
  public void a(agra paramagra, long paramLong)
  {
    if ((paramagra != null) && (a(paramagra.jdField_a_of_type_Long)))
    {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onDurationReady id = " + paramagra.jdField_a_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
    }
  }
  
  public void a(agra paramagra, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramagra != null) && (a(paramagra.jdField_a_of_type_Long)))
    {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onGetUrl id = " + paramagra.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqnm.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 4);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_d_of_type_Int = (axns.a(this.jdField_a_of_type_AndroidAppActivity) / 2);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    b(paramViewGroup);
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    this.jdField_a_of_type_Bcvf.a(new aqpr(this, paramAIOFileVideoData));
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131692907, 2130839638, 59, localArrayList1);
    a(2131692916, 2130839647, 53, localArrayList1);
    axqy.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131692909, 2130843486, 67, localArrayList1);
    a(2131692906, 2130839637, 57, localArrayList1);
    a(2131692918, 2130839648, 58, localArrayList1);
    if ((this.jdField_a_of_type_Aqmo.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aqmo.c()))) {
      a(2131692920, 2130839649, 54, localArrayList2);
    }
    if (apvd.b(paramAIOFileVideoData.jdField_c_of_type_JavaLangString)) {
      a(2131692913, 2130839643, 64, localArrayList2, 5);
    }
    a(paramAIOFileVideoData);
    this.jdField_a_of_type_Bcvf.a(localArrayList1, localArrayList2);
    this.jdField_a_of_type_Bcvf.a();
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onItemSelected position = " + paramInt);
    Object localObject = this.jdField_a_of_type_Aqnm.a(paramInt);
    if ((localObject == null) || (((aqmi)localObject).a == null)) {}
    while (((aqmi)localObject).a.a() != 4) {
      return;
    }
    paramAdapterView = (AIOFileVideoData)((aqmi)localObject).a;
    aqmr localaqmr = new aqmr();
    this.jdField_a_of_type_Aqnm.a(((aqmi)localObject).a.jdField_a_of_type_Long, ((aqmi)localObject).a.jdField_a_of_type_Int, 0);
    if (((aqmi)localObject).jdField_b_of_type_Boolean) {
      paramAdapterView.jdField_g_of_type_Boolean = true;
    }
    if (localaqmr.a(paramAdapterView, this.jdField_a_of_type_Aqnm.a()))
    {
      if (paramAdapterView.l) {
        this.jdField_a_of_type_Aqnm.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 1);
      }
      if ((!bbdx.b(paramAdapterView.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Aqnm.a()))) {
        this.jdField_a_of_type_Aqnm.a(false);
      }
      j();
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "FileVideo_AP onItemSelected needUrl return");
      return;
    }
    if ((a(paramAdapterView)) && (this.jdField_a_of_type_Aqnm.a(((aqmi)localObject).a.jdField_a_of_type_Long)) && (((aqmi)localObject).jdField_b_of_type_Boolean))
    {
      if (paramAdapterView.jdField_h_of_type_Boolean)
      {
        paramAdapterView.jdField_h_of_type_Boolean = false;
        localObject = localaqmr.a(paramAdapterView, paramAdapterView.m);
        this.jdField_a_of_type_Agqv.a(paramView, (agra)localObject);
      }
      this.jdField_a_of_type_Agqv.b();
      this.jdField_a_of_type_Agqv.f();
    }
    if ((!bbdx.b(paramAdapterView.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Aqnm.a()))) {
      this.jdField_a_of_type_Aqnm.a(false);
    }
    j();
  }
  
  public boolean a(aqmi paramaqmi)
  {
    return super.a(paramaqmi);
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData)
  {
    agra localagra = new aqmr().a(paramAIOFileVideoData, paramAIOFileVideoData.m);
    if ((localagra == null) || (this.jdField_a_of_type_Agqv == null))
    {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "initVideo error");
      this.jdField_a_of_type_Aqnm.a(localagra.jdField_a_of_type_Long, localagra.jdField_b_of_type_Int, 7);
      return false;
    }
    localagra.jdField_e_of_type_Boolean = paramAIOFileVideoData.m;
    aqmd.a().a().a("AIOGalleryFileVideoView", 4, "initVideo, set playMediaInfo.isMute =  " + paramAIOFileVideoData.m);
    this.jdField_a_of_type_Agqv.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localagra);
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
      int i = this.jdField_a_of_type_Aqnm.a(paramLong, 0, 0, "");
      localObject = this.jdField_a_of_type_Aqnm.a(i);
      if ((localObject != null) && (((aqmi)localObject).a != null) && (((aqmi)localObject).a.a() == 4))
      {
        localObject = (AIOFileVideoData)((aqmi)localObject).a;
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
      new aqmr().a((AIOFileVideoData)localObject);
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "file[" + paramLong + "],download success, set downloadSuccess");
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
  }
  
  public void b(agra paramagra)
  {
    if ((paramagra != null) && (a(paramagra.jdField_a_of_type_Long)))
    {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onPlayPause id = " + paramagra.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Agqv.d())
      {
        this.jdField_a_of_type_Aqnm.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 6);
        this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
        long l = this.jdField_a_of_type_Agqv.a();
        int i = (int)(l / this.jdField_a_of_type_Agqv.b() * 10000.0D);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l));
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
        if (this.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Aqnm.a())) {
          this.jdField_a_of_type_Aqnm.a(true);
        }
      }
    }
  }
  
  public void b(agra paramagra, int paramInt)
  {
    if ((paramagra != null) && (a(paramagra.jdField_a_of_type_Long)))
    {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onDownloading id = " + paramagra.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_Agqv != null) && (!this.jdField_a_of_type_Agqv.c()))
      {
        this.jdField_a_of_type_Aqnm.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 1);
        this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    super.b(paramViewGroup);
    this.jdField_a_of_type_Agqv = new agqx();
    this.jdField_a_of_type_Agqv.a(this.jdField_a_of_type_Aqnm.a());
    this.jdField_a_of_type_Agqv.a(this);
    this.jdField_a_of_type_Agqv.a(this);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Aqnm.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.a == null) || (this.jdField_a_of_type_Aqnm.a() == null)) {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "there data is null, position: " + paramInt);
    }
    Object localObject;
    do
    {
      return;
      localObject = ((DragGallery)this.jdField_a_of_type_Aqnm.a()).a();
    } while ((paramAdapterView.a.a() != 4) || (this.jdField_a_of_type_Agqv == null));
    if ((localObject != null) && (this.jdField_a_of_type_Agqv.a((MotionEvent)localObject)))
    {
      paramAdapterView = (AIOFileVideoData)paramAdapterView.a;
      localObject = new aqmr();
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onItemClick id = " + paramAdapterView.jdField_a_of_type_Long);
      if (((aqmr)localObject).a(paramAdapterView)) {
        this.jdField_a_of_type_Aqnm.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 5);
      }
      for (;;)
      {
        ((aqmr)localObject).a(paramAdapterView, paramView, this.jdField_a_of_type_Agqv);
        j();
        return;
        this.jdField_a_of_type_Aqnm.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 1);
      }
    }
    if (this.jdField_a_of_type_Aqnm.f())
    {
      if (this.jdField_a_of_type_Aqnm.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Aqnm.e(false);
        this.jdField_a_of_type_Aqnm.jdField_a_of_type_Boolean = false;
        m();
        this.jdField_a_of_type_Aqnm.p();
        return;
      }
      this.jdField_a_of_type_Aqnm.e(true);
      this.jdField_a_of_type_Aqnm.q();
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_Boolean = true;
      c(true);
      return;
    }
    this.jdField_a_of_type_Aqnm.j();
  }
  
  public void c(int paramInt)
  {
    aqmi localaqmi;
    if ((paramInt == this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(paramInt)))
    {
      localaqmi = this.jdField_a_of_type_Aqnm.a();
      if ((localaqmi == null) || (localaqmi.a == null) || (localaqmi.a.a() != 4)) {
        break label104;
      }
    }
    label104:
    for (boolean bool = bbdx.b(((AIOFileVideoData)localaqmi.a).jdField_c_of_type_JavaLangString);; bool = false)
    {
      if ((this.jdField_a_of_type_Agqv != null) && (this.jdField_a_of_type_Agqv.c()) && (bool))
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
    this.jdField_a_of_type_Aqnm.d(paramLong);
  }
  
  public void c(agra paramagra)
  {
    if ((paramagra != null) && (paramagra.jdField_b_of_type_Boolean) && (a(paramagra.jdField_a_of_type_Long)))
    {
      Object localObject = this.jdField_a_of_type_Aqnm.a();
      if (AIOFileVideoData.class.isInstance(((aqmi)localObject).a))
      {
        localObject = (AIOFileVideoData)((aqmi)localObject).a;
        ((AIOFileVideoData)localObject).k = true;
        if (!((AIOFileVideoData)localObject).jdField_f_of_type_Boolean)
        {
          aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onPlayFinish id = " + paramagra.jdField_a_of_type_Long + " ,but file is downloading!");
          this.jdField_a_of_type_Agqv.b(8);
        }
      }
    }
    else
    {
      return;
    }
    c(paramagra.jdField_a_of_type_Long);
    aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onPlayFinish id = " + paramagra.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
    this.jdField_a_of_type_Aqnm.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 0);
    this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryFileVideoView.1(this));
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doEnterImmersion, isClick = ").append(paramBoolean).append(" ,  isShowingDanmaku =");
      if (this.jdField_a_of_type_Aqnm.a() == null) {
        break label96;
      }
    }
    label96:
    for (boolean bool = this.jdField_a_of_type_Aqnm.a().b();; bool = false)
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
    if ((this.jdField_a_of_type_Aqnm.a() != null) && (this.jdField_a_of_type_Aqnm.a().b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.jdField_a_of_type_Boolean = false;
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
    if (this.jdField_a_of_type_Agqv != null) {
      this.jdField_a_of_type_Agqv.k();
    }
    if (this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    a(this.jdField_a_of_type_Aqnm.a());
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_Aqnm.e(paramLong);
  }
  
  public void d(agra paramagra)
  {
    if ((paramagra != null) && (a(paramagra.jdField_a_of_type_Long)))
    {
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onBuffering id = " + paramagra.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqnm.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 3);
      long l = this.jdField_a_of_type_Agqv.c();
      if (l <= 0L) {
        break label146;
      }
      paramagra = ShortVideoUtils.a(this.jdField_a_of_type_AndroidAppActivity, l * 1024L);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramagra + "/s");
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label146:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public boolean d()
  {
    if (super.d())
    {
      Object localObject = this.jdField_a_of_type_Aqnm.a();
      if ((localObject != null) && (((aqmi)localObject).a != null) && (((aqmi)localObject).a.a() == 4))
      {
        localObject = (AIOFileVideoData)((aqmi)localObject).a;
        if ((!this.jdField_a_of_type_Aqmo.c()) && (!TextUtils.isEmpty(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString))) {
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
    Object localObject2 = this.jdField_a_of_type_Aqnm.a();
    Object localObject1;
    if ((localObject2 != null) && (((aqmi)localObject2).a != null) && (((aqmi)localObject2).a.a() == 4))
    {
      localObject1 = (AIOFileVideoData)((aqmi)localObject2).a;
      a(d());
      b(a((aqmi)localObject2));
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "updateUI id = " + ((AIOFileVideoData)localObject1).jdField_a_of_type_Long + ", status = " + ((AIOFileVideoData)localObject1).a());
    }
    switch (((AIOFileVideoData)localObject1).jdField_e_of_type_Int)
    {
    default: 
      aqmd.a().a().a("AIOGalleryFileVideoView", 4, "updateUI status is error, status = " + ((AIOFileVideoData)localObject1).jdField_e_of_type_Int);
      return;
    case 1: 
      this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
      f(false);
      e(true);
      b(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqv.a(8, "");
      this.jdField_a_of_type_Agqv.b(8);
      a(false);
      return;
    case 2: 
      this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
      float f = (float)((AIOFileVideoData)localObject1).jdField_g_of_type_Long / (float)((AIOFileVideoData)localObject1).jdField_c_of_type_Long * 100.0F;
      localObject1 = new DecimalFormat("0.00").format(f);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(ajya.a(2131700039) + (String)localObject1 + "%");
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)f * 100);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      e(true);
      b(false);
      this.jdField_a_of_type_Agqv.a(8, "");
      this.jdField_a_of_type_Agqv.b(8);
      a(false);
      return;
    case 4: 
      this.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Aqnm.c(), (int)((AIOFileVideoData)localObject1).jdField_g_of_type_Long);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      b(false);
      this.jdField_a_of_type_Agqv.a(8, "");
      this.jdField_a_of_type_Agqv.b(8);
      a(false);
      return;
    case 3: 
      if (this.jdField_a_of_type_Agqv.c())
      {
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
        if (!((AIOFileVideoData)localObject1).jdField_f_of_type_Boolean) {
          break label600;
        }
        f(true);
        e(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_Agqv.a(8, "");
        a(true);
        return;
        if ((!this.jdField_a_of_type_Agqv.d()) || (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
          break;
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        break;
        e(true);
        f(false);
        b(false);
      }
    case 5: 
      this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqv.a(8, "");
      this.jdField_a_of_type_Agqv.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845268);
      a(true);
      return;
    case 6: 
      this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqv.a(8, "");
      this.jdField_a_of_type_Agqv.b(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845267);
      a(true);
      return;
    case 7: 
      label600:
      this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
      f(false);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqv.a(0, ((AIOFileVideoData)localObject1).jdField_h_of_type_JavaLangString);
      this.jdField_a_of_type_Agqv.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845267);
      a(false);
      return;
    }
    this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
    f(false);
    e(false);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Agqv.a(8, "");
    localObject2 = this.jdField_a_of_type_Agqv;
    if (((AIOFileVideoData)localObject1).l) {}
    for (int i = 8;; i = 0)
    {
      ((agqv)localObject2).b(i);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845267);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      a(true);
      return;
    }
  }
  
  public void o()
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
          Object localObject = this.jdField_a_of_type_Aqnm.a();
          if ((localObject != null) && (((aqmi)localObject).a != null) && (((aqmi)localObject).a.a() == 4) && (this.jdField_a_of_type_Agqv != null))
          {
            localObject = (AIOFileVideoData)((aqmi)localObject).a;
            if (((AIOFileVideoData)localObject).jdField_h_of_type_Boolean)
            {
              ((AIOFileVideoData)localObject).jdField_h_of_type_Boolean = false;
              localObject = new aqmr().a((AIOFileVideoData)localObject, false);
              this.jdField_a_of_type_Agqv.a(paramView, (agra)localObject);
            }
            this.jdField_a_of_type_Agqv.b();
            this.jdField_a_of_type_Agqv.f();
          }
          this.jdField_a_of_type_Aqnm.m();
          this.jdField_a_of_type_Aqnm.q();
          this.jdField_a_of_type_Aqnm.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Aqnm.p();
          return;
        } while (this.jdField_a_of_type_Agqv == null);
        paramView = this.jdField_a_of_type_Aqnm.a();
      } while ((paramView == null) || (paramView.a == null));
      paramView = (AIOFileVideoData)paramView.a;
      paramView.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Agqv.c();
      this.jdField_a_of_type_Agqv.e();
      this.jdField_a_of_type_Aqnm.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Aqnm.j();
      return;
      s();
      this.jdField_a_of_type_Aqnm.o();
      return;
      l();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryFileVideoView", 0, "onClick qq_gallery_danmaku_view ");
      }
      paramView = this.jdField_a_of_type_Aqnm.a();
      long l = this.jdField_a_of_type_Agqv.a();
      if ((paramView != null) && (paramView.a != null)) {
        MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqmo.a(), this.jdField_a_of_type_Aqmo.a(), false, 26, paramView.a.d, l);
      }
      this.jdField_a_of_type_Aqnm.r();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter == null);
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.j();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Agqv != null)
      {
        paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_a_of_type_Agqv.b());
        this.jdField_a_of_type_Agqv.c(paramInt);
      }
      this.jdField_a_of_type_Aqnm.n();
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onStopTrackingTouch");
    if (this.jdField_a_of_type_Agqv != null)
    {
      this.jdField_a_of_type_Agqv.n();
      if ((this.jdField_a_of_type_Aqnm.a() != null) && (this.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Aqnm.a())) && (paramSeekBar != null))
      {
        aqmd.a().a().a("AIOGalleryFileVideoView", 4, "seek danmaku");
        this.jdField_a_of_type_Aqnm.a().a(paramSeekBar.getProgress());
        aqmi localaqmi = this.jdField_a_of_type_Aqnm.a();
        if ((localaqmi != null) && (localaqmi.a != null)) {
          this.jdField_a_of_type_Aqnm.a().a(this.jdField_a_of_type_Aqnm.a(localaqmi.a.d, paramSeekBar.getProgress()));
        }
      }
    }
  }
  
  public void q()
  {
    aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onResume");
    if (this.jdField_a_of_type_Agqv != null)
    {
      this.jdField_a_of_type_Agqv.j();
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Agqv.f();
      }
    }
    j();
  }
  
  public void r()
  {
    aqmd.a().a().a("AIOGalleryFileVideoView", 4, "onPause");
    if ((this.jdField_a_of_type_Agqv != null) && (this.jdField_a_of_type_Agqv.c()))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Agqv.h();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void v() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpp
 * JD-Core Version:    0.7.0.1
 */