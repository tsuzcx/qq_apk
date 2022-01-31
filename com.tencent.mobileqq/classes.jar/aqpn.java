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

public class aqpn
  extends aqoe
  implements agqw, agqy, View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public agqx a;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  public aqnk a;
  private bcub jdField_a_of_type_Bcub;
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
  
  public aqpn(Activity paramActivity, aqnk paramaqnk)
  {
    super(paramActivity, paramaqnk);
    this.jdField_b_of_type_JavaLangRunnable = new AIOGalleryFileVideoView.4(this);
    this.jdField_a_of_type_Aqnk = paramaqnk;
  }
  
  private void a(aqmg paramaqmg)
  {
    agrc localagrc;
    Bundle localBundle;
    if ((paramaqmg != null) && (paramaqmg.a != null) && (paramaqmg.a.a() == 4))
    {
      paramaqmg = (AIOFileVideoData)paramaqmg.a;
      localagrc = new aqmp().a(paramaqmg, paramaqmg.m);
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onViewDetached, status = " + paramaqmg.jdField_e_of_type_Int);
      if (paramaqmg.i)
      {
        localBundle = new Bundle();
        if ((this.jdField_a_of_type_Agqx != null) && (agqz.class.isInstance(this.jdField_a_of_type_Agqx))) {
          localBundle.putFloat("progress", ((agqz)this.jdField_a_of_type_Agqx).a(paramaqmg.jdField_a_of_type_Long));
        }
        if (paramaqmg.jdField_e_of_type_Boolean) {
          break label240;
        }
        this.jdField_a_of_type_Aqnk.a(localagrc.jdField_a_of_type_Long, 10, localBundle);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnk.a(paramaqmg.jdField_a_of_type_Long, paramaqmg.jdField_a_of_type_Int, 0);
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "updateItemStatus FILE_VIDEO_PEEK_PAUSE id = " + paramaqmg.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Agqx != null)
      {
        aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onViewDetached video onPause...");
        this.jdField_a_of_type_Agqx.i();
      }
      return;
      label240:
      this.jdField_a_of_type_Aqnk.a(localagrc.jdField_a_of_type_Long, 12, localBundle);
    }
  }
  
  private boolean a(long paramLong)
  {
    aqmg localaqmg = this.jdField_a_of_type_Aqnk.a();
    return (localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.jdField_a_of_type_Long == paramLong);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      aqmg localaqmg = this.jdField_a_of_type_Aqnk.a();
      if ((localaqmg == null) || (!(localaqmg.a instanceof AIOFileVideoData))) {
        break label74;
      }
      if (!bbdj.b(((AIOFileVideoData)localaqmg.a).jdField_c_of_type_JavaLangString)) {
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
    Object localObject = this.jdField_a_of_type_Aqnk.a();
    if ((localObject != null) && (((aqmg)localObject).a != null) && (((aqmg)localObject).a.a() == 4))
    {
      localObject = (AIOFileVideoData)((aqmg)localObject).a;
      if (bbdj.b(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString)) {
        break label56;
      }
    }
    label56:
    label195:
    label198:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Bcub != null) {
        this.jdField_a_of_type_Bcub.b();
      }
      long l;
      if (this.jdField_a_of_type_Agqx != null)
      {
        l = this.jdField_a_of_type_Agqx.a();
        this.jdField_a_of_type_Bcub = new bcub(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_Bcub.a(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString, ((AIOFileVideoData)localObject).jdField_a_of_type_Long, l);
        if (bbdj.b(((AIOFileVideoData)localObject).jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_Bcub.a(((AIOFileVideoData)localObject).jdField_b_of_type_JavaLangString, ((AIOFileVideoData)localObject).jdField_c_of_type_Int, ((AIOFileVideoData)localObject).jdField_d_of_type_Int);
        }
        if (((AIOFileVideoData)localObject).jdField_c_of_type_Int <= ((AIOFileVideoData)localObject).jdField_d_of_type_Int) {
          break label195;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (!this.jdField_a_of_type_Bcub.a(bool, ((AIOFileVideoData)localObject).jdField_b_of_type_Int)) {
          break label198;
        }
        this.jdField_a_of_type_Aqnk.j();
        return;
        l = 0L;
        break;
      }
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof aqpq))) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    }
    aqmg localaqmg;
    for (paramViewGroup = ((aqpq)paramView.getTag()).a;; paramViewGroup = (GalleryUrlImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371919))
    {
      a();
      localaqmg = this.jdField_a_of_type_Aqnk.a(paramInt);
      if ((localaqmg != null) && (localaqmg.a != null)) {
        break;
      }
      return paramViewGroup;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558545, null));
      paramView = new Gallery.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    AIOFileVideoData localAIOFileVideoData;
    aqmp localaqmp;
    if (localaqmg.a.a() == 4)
    {
      paramView = this.jdField_a_of_type_Aqnk.b();
      if ((paramView == null) || (paramView.a == null) || (paramView.a.a() != 4) || (paramView.a.jdField_a_of_type_Long != localaqmg.a.jdField_a_of_type_Long) || (paramView.jdField_c_of_type_Boolean)) {
        break label377;
      }
      axqw.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
      paramView.jdField_c_of_type_Boolean = true;
      localAIOFileVideoData = (AIOFileVideoData)localaqmg.a;
      localaqmp = new aqmp();
      paramView = (Drawable)this.jdField_a_of_type_Aqnk.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (!localaqmp.b(localAIOFileVideoData)) {
        break label413;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296400, Boolean.valueOf(true));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296433, Boolean.valueOf(true));
      paramViewGroup.setImageDrawable(paramView);
      paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691636));
      if (localaqmp.b(localAIOFileVideoData)) {
        paramViewGroup.setImageDrawable(null);
      }
      if (localaqmg.jdField_b_of_type_Boolean) {
        localAIOFileVideoData.jdField_g_of_type_Boolean = true;
      }
      paramView = new aqpq(this);
      paramView.a = paramViewGroup;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramView);
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      label377:
      axqw.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
      break;
      label413:
      if ((paramView == null) || (((URLDrawable)paramView).getStatus() != 1)) {
        break label440;
      }
      this.jdField_a_of_type_Aqnk.b(paramInt, true);
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
      paramView.mLoadingDrawable = aywk.a;
      paramView.mPlayGifImage = true;
      paramView.mUseExifOrientation = false;
      paramView = URLDrawable.getDrawable(localFile, paramView);
      ((URLDrawable)paramView).setTag(Integer.valueOf(1));
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), (URLDrawable)paramView);
    }
    label566:
    for (;;)
    {
      break;
      paramView = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837911);
      break;
    }
  }
  
  public View a(int paramInt, aqmg paramaqmg)
  {
    a(paramaqmg);
    return null;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559079, null));
      Object localObject = (RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371128);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((RelativeLayout)localObject).findViewById(2131370891));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131375774));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371129));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372002));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377624));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373019));
      this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription(ajyc.a(2131700022));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131378674));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131378676));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131378675));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131364260));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363722));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374696));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373018));
      if (this.jdField_a_of_type_AndroidWidgetImageButton != null) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373020));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373026));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379107);
      if (bkur.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bkur.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bkur.jdField_a_of_type_Int;
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      d(true);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    aqmg localaqmg = this.jdField_a_of_type_Aqnk.a();
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 4)) {
      a((AIOFileVideoData)localaqmg.a, paramInt);
    }
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Aqnk.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void a(int paramInt, View paramView, aqmg paramaqmg)
  {
    a(paramaqmg);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_Aqnk.a(paramInt);
    if ((localObject1 == null) || (((aqmg)localObject1).a == null) || (paramView == null)) {
      return;
    }
    GalleryUrlImageView localGalleryUrlImageView;
    if ((paramView.getTag() instanceof aqpq))
    {
      localGalleryUrlImageView = ((aqpq)paramView.getTag()).a;
      if (((aqmg)localObject1).a.a() == 4)
      {
        Object localObject2 = (AIOFileVideoData)((aqmg)localObject1).a;
        aqmp localaqmp = new aqmp();
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        localObject2 = localaqmp.a((AIOFileVideoData)localObject2);
        if (localObject2 == null) {
          break label195;
        }
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        if (((URLDrawable)localObject1).getStatus() != 1) {
          break label171;
        }
        localGalleryUrlImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_Aqnk.b(paramInt, true);
        this.jdField_a_of_type_Aqnk.a().c();
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
      this.jdField_a_of_type_Aqnk.b(paramInt, true);
    }
  }
  
  public void a(int paramInt1, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    aqmb.a().a().a("AIOGalleryFileVideoView", 4, "setVideoDrawableWithUrls position = " + paramInt1);
    aqmg localaqmg = this.jdField_a_of_type_Aqnk.a(paramInt1);
    if ((localaqmg == null) || (localaqmg.a == null)) {}
    aqmp localaqmp;
    for (;;)
    {
      return;
      if (localaqmg.a.a() == 4)
      {
        paramMessageForShortVideo = (AIOFileVideoData)localaqmg.a;
        localaqmp = new aqmp();
        if (paramMessageForShortVideo.jdField_d_of_type_Boolean)
        {
          aqmb.a().a().a("AIOGalleryFileVideoView", 4, "fileVideo is playing:" + paramMessageForShortVideo.jdField_a_of_type_Long);
          return;
        }
        paramMessageForShortVideo.jdField_d_of_type_Boolean = true;
        if ("I:E".equals(paramString1)) {
          try
          {
            paramMessageForShortVideo.jdField_f_of_type_Long = Long.parseLong(paramArrayOfString[0]);
            paramString2 = paramArrayOfString[1];
            ((AIOFileVideoData)localaqmg.a).jdField_h_of_type_JavaLangString = paramString2;
            this.jdField_a_of_type_Aqnk.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 7);
            paramInt1 = 0;
            if (paramMessageForShortVideo.jdField_f_of_type_Long == -134L)
            {
              paramString1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131719583);
              paramInt1 = 1;
              if (paramInt1 != 0)
              {
                paramString1 = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, "", paramString1, null, ajyc.a(2131700059), new aqpo(this), null);
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
      this.jdField_a_of_type_Aqnk.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 0);
      paramString1 = localaqmp.a(paramMessageForShortVideo, paramMessageForShortVideo.m);
      this.jdField_a_of_type_Agqx.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramString1);
      if (this.jdField_a_of_type_Aqnk.a(paramMessageForShortVideo.jdField_a_of_type_Long))
      {
        aqmb.a().a().a("AIOGalleryFileVideoView", 4, "setVideoDrawableWithUrls autoPlay id = " + paramMessageForShortVideo.jdField_a_of_type_Long);
        this.jdField_a_of_type_Aqnk.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 5);
        this.jdField_a_of_type_Agqx.b();
        this.jdField_a_of_type_Agqx.f();
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
    aqmg localaqmg = this.jdField_a_of_type_Aqnk.a();
    if ((localaqmg == null) || (localaqmg.a == null) || (localaqmg.a.a() != 4)) {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onRevokeMsg exp!");
    }
    while ((this.jdField_a_of_type_Agqx == null) || (!this.jdField_a_of_type_Agqx.c())) {
      return;
    }
    this.jdField_a_of_type_Agqx.h();
  }
  
  public void a(long paramLong, float paramFloat, String paramString)
  {
    if (a(paramLong)) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryFileVideoView.2(this, paramLong, paramFloat, paramString));
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Aqnk.a(paramLong, paramInt, 2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Aqnk.a(paramLong, paramInt1, paramInt2, paramString1);
    a(this.jdField_a_of_type_Aqnk.c(), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(agrc paramagrc)
  {
    if ((paramagrc != null) && (paramagrc.jdField_a_of_type_Boolean))
    {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onPlayStart file need download");
      return;
    }
    if ((paramagrc != null) && (a(paramagrc.jdField_a_of_type_Long)))
    {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onPlayStart id = " + paramagrc.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqnk.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 5);
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      if (this.jdField_a_of_type_Aqnk.a(this.jdField_a_of_type_Aqnk.a()))
      {
        boolean bool2 = false;
        aqmg localaqmg = this.jdField_a_of_type_Aqnk.a();
        boolean bool1 = bool2;
        if (localaqmg != null)
        {
          bool1 = bool2;
          if (localaqmg.a != null)
          {
            bool1 = bool2;
            if (localaqmg.a.a() == 4) {
              bool1 = bbdj.b(((AIOFileVideoData)localaqmg.a).jdField_c_of_type_JavaLangString);
            }
          }
        }
        if (bool1) {
          this.jdField_a_of_type_Aqnk.a();
        }
        if ((localaqmg != null) && (localaqmg.a != null) && (this.jdField_a_of_type_Aqnk.a() != null) && (this.jdField_a_of_type_Agqx != null)) {
          this.jdField_a_of_type_Aqnk.a().a(this.jdField_a_of_type_Aqnk.a(localaqmg.a.d, this.jdField_a_of_type_Agqx.a()));
        }
      }
    }
    if (paramagrc != null)
    {
      c(paramagrc.jdField_a_of_type_Long);
      d(paramagrc.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Aqnk.a(0L, 0L, this.jdField_a_of_type_Aqnk.a().c());
  }
  
  public void a(agrc paramagrc, int paramInt)
  {
    if ((paramagrc != null) && (a(paramagrc.jdField_a_of_type_Long)))
    {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onEndBuffering id = " + paramagrc.jdField_a_of_type_Long);
      if (!this.jdField_a_of_type_Agqx.c()) {
        break label189;
      }
      Object localObject = this.jdField_a_of_type_Aqnk.a();
      if ((localObject != null) && (AIOFileVideoData.class.isInstance(((aqmg)localObject).a)))
      {
        localObject = (AIOFileVideoData)((aqmg)localObject).a;
        aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onEndBuffering isDownloadSuccess: " + ((AIOFileVideoData)localObject).jdField_f_of_type_Boolean);
        if (((AIOFileVideoData)localObject).jdField_f_of_type_Boolean) {
          break label170;
        }
        this.jdField_a_of_type_Aqnk.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label170:
      this.jdField_a_of_type_Aqnk.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 5);
      continue;
      label189:
      if (this.jdField_a_of_type_Agqx.d()) {
        this.jdField_a_of_type_Aqnk.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 6);
      }
    }
  }
  
  public void a(agrc paramagrc, int paramInt1, int paramInt2, String paramString)
  {
    String str;
    if ((paramagrc != null) && (a(paramagrc.jdField_a_of_type_Long)))
    {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onError id = " + paramagrc.jdField_a_of_type_Long);
      localObject = this.jdField_a_of_type_Aqnk.a();
      if ((localObject != null) && (((aqmg)localObject).a != null) && (((aqmg)localObject).a.a() == 4))
      {
        this.jdField_a_of_type_Aqnk.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 7);
        str = qua.a(paramInt1, paramInt2);
        paramString = (AIOFileVideoData)((aqmg)localObject).a;
        if (!paramString.jdField_e_of_type_Boolean) {
          break label129;
        }
      }
    }
    return;
    label129:
    ((AIOFileVideoData)((aqmg)localObject).a).jdField_h_of_type_JavaLangString = str;
    Object localObject = new Bundle();
    float f = 0.0F;
    if (agqz.class.isInstance(this.jdField_a_of_type_Agqx)) {
      f = ((agqz)this.jdField_a_of_type_Agqx).a(paramagrc.jdField_a_of_type_Long);
    }
    ((Bundle)localObject).putFloat("progress", f);
    this.jdField_a_of_type_Aqnk.a(paramString.jdField_a_of_type_Long, 10, (Bundle)localObject);
    j();
  }
  
  public void a(agrc paramagrc, long paramLong)
  {
    if ((paramagrc != null) && (a(paramagrc.jdField_a_of_type_Long)))
    {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onDurationReady id = " + paramagrc.jdField_a_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
    }
  }
  
  public void a(agrc paramagrc, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramagrc != null) && (a(paramagrc.jdField_a_of_type_Long)))
    {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onGetUrl id = " + paramagrc.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqnk.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 4);
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_d_of_type_Int = (axnq.a(this.jdField_a_of_type_AndroidAppActivity) / 2);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    b(paramViewGroup);
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    this.jdField_a_of_type_Bcuq.a(new aqpp(this, paramAIOFileVideoData));
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131692906, 2130839638, 59, localArrayList1);
    a(2131692915, 2130839647, 53, localArrayList1);
    axqw.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131692908, 2130843485, 67, localArrayList1);
    a(2131692905, 2130839637, 57, localArrayList1);
    a(2131692917, 2130839648, 58, localArrayList1);
    if ((this.jdField_a_of_type_Aqmm.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aqmm.c()))) {
      a(2131692919, 2130839649, 54, localArrayList2);
    }
    if (apvb.b(paramAIOFileVideoData.jdField_c_of_type_JavaLangString)) {
      a(2131692912, 2130839643, 64, localArrayList2, 5);
    }
    a(paramAIOFileVideoData);
    this.jdField_a_of_type_Bcuq.a(localArrayList1, localArrayList2);
    this.jdField_a_of_type_Bcuq.a();
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onItemSelected position = " + paramInt);
    Object localObject = this.jdField_a_of_type_Aqnk.a(paramInt);
    if ((localObject == null) || (((aqmg)localObject).a == null)) {}
    while (((aqmg)localObject).a.a() != 4) {
      return;
    }
    paramAdapterView = (AIOFileVideoData)((aqmg)localObject).a;
    aqmp localaqmp = new aqmp();
    this.jdField_a_of_type_Aqnk.a(((aqmg)localObject).a.jdField_a_of_type_Long, ((aqmg)localObject).a.jdField_a_of_type_Int, 0);
    if (((aqmg)localObject).jdField_b_of_type_Boolean) {
      paramAdapterView.jdField_g_of_type_Boolean = true;
    }
    if (localaqmp.a(paramAdapterView, this.jdField_a_of_type_Aqnk.a()))
    {
      if (paramAdapterView.l) {
        this.jdField_a_of_type_Aqnk.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 1);
      }
      if ((!bbdj.b(paramAdapterView.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Aqnk.a(this.jdField_a_of_type_Aqnk.a()))) {
        this.jdField_a_of_type_Aqnk.a(false);
      }
      j();
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "FileVideo_AP onItemSelected needUrl return");
      return;
    }
    if ((a(paramAdapterView)) && (this.jdField_a_of_type_Aqnk.a(((aqmg)localObject).a.jdField_a_of_type_Long)) && (((aqmg)localObject).jdField_b_of_type_Boolean))
    {
      if (paramAdapterView.jdField_h_of_type_Boolean)
      {
        paramAdapterView.jdField_h_of_type_Boolean = false;
        localObject = localaqmp.a(paramAdapterView, paramAdapterView.m);
        this.jdField_a_of_type_Agqx.a(paramView, (agrc)localObject);
      }
      this.jdField_a_of_type_Agqx.b();
      this.jdField_a_of_type_Agqx.f();
    }
    if ((!bbdj.b(paramAdapterView.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Aqnk.a(this.jdField_a_of_type_Aqnk.a()))) {
      this.jdField_a_of_type_Aqnk.a(false);
    }
    j();
  }
  
  public boolean a(aqmg paramaqmg)
  {
    return super.a(paramaqmg);
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData)
  {
    agrc localagrc = new aqmp().a(paramAIOFileVideoData, paramAIOFileVideoData.m);
    if ((localagrc == null) || (this.jdField_a_of_type_Agqx == null))
    {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "initVideo error");
      this.jdField_a_of_type_Aqnk.a(localagrc.jdField_a_of_type_Long, localagrc.jdField_b_of_type_Int, 7);
      return false;
    }
    localagrc.jdField_e_of_type_Boolean = paramAIOFileVideoData.m;
    aqmb.a().a().a("AIOGalleryFileVideoView", 4, "initVideo, set playMediaInfo.isMute =  " + paramAIOFileVideoData.m);
    this.jdField_a_of_type_Agqx.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localagrc);
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
      int i = this.jdField_a_of_type_Aqnk.a(paramLong, 0, 0, "");
      localObject = this.jdField_a_of_type_Aqnk.a(i);
      if ((localObject != null) && (((aqmg)localObject).a != null) && (((aqmg)localObject).a.a() == 4))
      {
        localObject = (AIOFileVideoData)((aqmg)localObject).a;
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
      new aqmp().a((AIOFileVideoData)localObject);
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "file[" + paramLong + "],download success, set downloadSuccess");
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
  }
  
  public void b(agrc paramagrc)
  {
    if ((paramagrc != null) && (a(paramagrc.jdField_a_of_type_Long)))
    {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onPlayPause id = " + paramagrc.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Agqx.d())
      {
        this.jdField_a_of_type_Aqnk.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 6);
        this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
        long l = this.jdField_a_of_type_Agqx.a();
        int i = (int)(l / this.jdField_a_of_type_Agqx.b() * 10000.0D);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l));
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
        if (this.jdField_a_of_type_Aqnk.a(this.jdField_a_of_type_Aqnk.a())) {
          this.jdField_a_of_type_Aqnk.a(true);
        }
      }
    }
  }
  
  public void b(agrc paramagrc, int paramInt)
  {
    if ((paramagrc != null) && (a(paramagrc.jdField_a_of_type_Long)))
    {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onDownloading id = " + paramagrc.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_Agqx != null) && (!this.jdField_a_of_type_Agqx.c()))
      {
        this.jdField_a_of_type_Aqnk.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 1);
        this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    super.b(paramViewGroup);
    this.jdField_a_of_type_Agqx = new agqz();
    this.jdField_a_of_type_Agqx.a(this.jdField_a_of_type_Aqnk.a());
    this.jdField_a_of_type_Agqx.a(this);
    this.jdField_a_of_type_Agqx.a(this);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Aqnk.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.a == null) || (this.jdField_a_of_type_Aqnk.a() == null)) {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "there data is null, position: " + paramInt);
    }
    Object localObject;
    do
    {
      return;
      localObject = ((DragGallery)this.jdField_a_of_type_Aqnk.a()).a();
    } while ((paramAdapterView.a.a() != 4) || (this.jdField_a_of_type_Agqx == null));
    if ((localObject != null) && (this.jdField_a_of_type_Agqx.a((MotionEvent)localObject)))
    {
      paramAdapterView = (AIOFileVideoData)paramAdapterView.a;
      localObject = new aqmp();
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onItemClick id = " + paramAdapterView.jdField_a_of_type_Long);
      if (((aqmp)localObject).a(paramAdapterView)) {
        this.jdField_a_of_type_Aqnk.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 5);
      }
      for (;;)
      {
        ((aqmp)localObject).a(paramAdapterView, paramView, this.jdField_a_of_type_Agqx);
        j();
        return;
        this.jdField_a_of_type_Aqnk.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 1);
      }
    }
    if (this.jdField_a_of_type_Aqnk.f())
    {
      if (this.jdField_a_of_type_Aqnk.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Aqnk.e(false);
        this.jdField_a_of_type_Aqnk.jdField_a_of_type_Boolean = false;
        m();
        this.jdField_a_of_type_Aqnk.p();
        return;
      }
      this.jdField_a_of_type_Aqnk.e(true);
      this.jdField_a_of_type_Aqnk.q();
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_Boolean = true;
      c(true);
      return;
    }
    this.jdField_a_of_type_Aqnk.j();
  }
  
  public void c(int paramInt)
  {
    aqmg localaqmg;
    if ((paramInt == this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(paramInt)))
    {
      localaqmg = this.jdField_a_of_type_Aqnk.a();
      if ((localaqmg == null) || (localaqmg.a == null) || (localaqmg.a.a() != 4)) {
        break label104;
      }
    }
    label104:
    for (boolean bool = bbdj.b(((AIOFileVideoData)localaqmg.a).jdField_c_of_type_JavaLangString);; bool = false)
    {
      if ((this.jdField_a_of_type_Agqx != null) && (this.jdField_a_of_type_Agqx.c()) && (bool))
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
    this.jdField_a_of_type_Aqnk.d(paramLong);
  }
  
  public void c(agrc paramagrc)
  {
    if ((paramagrc != null) && (paramagrc.jdField_b_of_type_Boolean) && (a(paramagrc.jdField_a_of_type_Long)))
    {
      Object localObject = this.jdField_a_of_type_Aqnk.a();
      if (AIOFileVideoData.class.isInstance(((aqmg)localObject).a))
      {
        localObject = (AIOFileVideoData)((aqmg)localObject).a;
        ((AIOFileVideoData)localObject).k = true;
        if (!((AIOFileVideoData)localObject).jdField_f_of_type_Boolean)
        {
          aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onPlayFinish id = " + paramagrc.jdField_a_of_type_Long + " ,but file is downloading!");
          this.jdField_a_of_type_Agqx.b(8);
        }
      }
    }
    else
    {
      return;
    }
    c(paramagrc.jdField_a_of_type_Long);
    aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onPlayFinish id = " + paramagrc.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
    this.jdField_a_of_type_Aqnk.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 0);
    this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryFileVideoView.1(this));
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doEnterImmersion, isClick = ").append(paramBoolean).append(" ,  isShowingDanmaku =");
      if (this.jdField_a_of_type_Aqnk.a() == null) {
        break label96;
      }
    }
    label96:
    for (boolean bool = this.jdField_a_of_type_Aqnk.a().b();; bool = false)
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
    if ((this.jdField_a_of_type_Aqnk.a() != null) && (this.jdField_a_of_type_Aqnk.a().b()))
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
    if (this.jdField_a_of_type_Agqx != null) {
      this.jdField_a_of_type_Agqx.k();
    }
    if (this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    a(this.jdField_a_of_type_Aqnk.a());
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_Aqnk.e(paramLong);
  }
  
  public void d(agrc paramagrc)
  {
    if ((paramagrc != null) && (a(paramagrc.jdField_a_of_type_Long)))
    {
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onBuffering id = " + paramagrc.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqnk.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 3);
      long l = this.jdField_a_of_type_Agqx.c();
      if (l <= 0L) {
        break label146;
      }
      paramagrc = ShortVideoUtils.a(this.jdField_a_of_type_AndroidAppActivity, l * 1024L);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramagrc + "/s");
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label146:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public boolean d()
  {
    if (super.d())
    {
      Object localObject = this.jdField_a_of_type_Aqnk.a();
      if ((localObject != null) && (((aqmg)localObject).a != null) && (((aqmg)localObject).a.a() == 4))
      {
        localObject = (AIOFileVideoData)((aqmg)localObject).a;
        if ((!this.jdField_a_of_type_Aqmm.c()) && (!TextUtils.isEmpty(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString))) {
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
    Object localObject2 = this.jdField_a_of_type_Aqnk.a();
    Object localObject1;
    if ((localObject2 != null) && (((aqmg)localObject2).a != null) && (((aqmg)localObject2).a.a() == 4))
    {
      localObject1 = (AIOFileVideoData)((aqmg)localObject2).a;
      a(d());
      b(a((aqmg)localObject2));
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "updateUI id = " + ((AIOFileVideoData)localObject1).jdField_a_of_type_Long + ", status = " + ((AIOFileVideoData)localObject1).a());
    }
    switch (((AIOFileVideoData)localObject1).jdField_e_of_type_Int)
    {
    default: 
      aqmb.a().a().a("AIOGalleryFileVideoView", 4, "updateUI status is error, status = " + ((AIOFileVideoData)localObject1).jdField_e_of_type_Int);
      return;
    case 1: 
      this.jdField_a_of_type_Aqnk.b(this.jdField_a_of_type_Aqnk.c(), true);
      f(false);
      e(true);
      b(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqx.a(8, "");
      this.jdField_a_of_type_Agqx.b(8);
      a(false);
      return;
    case 2: 
      this.jdField_a_of_type_Aqnk.b(this.jdField_a_of_type_Aqnk.c(), true);
      float f = (float)((AIOFileVideoData)localObject1).jdField_g_of_type_Long / (float)((AIOFileVideoData)localObject1).jdField_c_of_type_Long * 100.0F;
      localObject1 = new DecimalFormat("0.00").format(f);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(ajyc.a(2131700028) + (String)localObject1 + "%");
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)f * 100);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      e(true);
      b(false);
      this.jdField_a_of_type_Agqx.a(8, "");
      this.jdField_a_of_type_Agqx.b(8);
      a(false);
      return;
    case 4: 
      this.jdField_a_of_type_Aqnk.a(this.jdField_a_of_type_Aqnk.c(), (int)((AIOFileVideoData)localObject1).jdField_g_of_type_Long);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      b(false);
      this.jdField_a_of_type_Agqx.a(8, "");
      this.jdField_a_of_type_Agqx.b(8);
      a(false);
      return;
    case 3: 
      if (this.jdField_a_of_type_Agqx.c())
      {
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        this.jdField_a_of_type_Aqnk.b(this.jdField_a_of_type_Aqnk.c(), true);
        if (!((AIOFileVideoData)localObject1).jdField_f_of_type_Boolean) {
          break label600;
        }
        f(true);
        e(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_Agqx.a(8, "");
        a(true);
        return;
        if ((!this.jdField_a_of_type_Agqx.d()) || (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
          break;
        }
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        break;
        e(true);
        f(false);
        b(false);
      }
    case 5: 
      this.jdField_a_of_type_Aqnk.b(this.jdField_a_of_type_Aqnk.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqx.a(8, "");
      this.jdField_a_of_type_Agqx.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845266);
      a(true);
      return;
    case 6: 
      this.jdField_a_of_type_Aqnk.b(this.jdField_a_of_type_Aqnk.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqx.a(8, "");
      this.jdField_a_of_type_Agqx.b(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845265);
      a(true);
      return;
    case 7: 
      label600:
      this.jdField_a_of_type_Aqnk.b(this.jdField_a_of_type_Aqnk.c(), true);
      f(false);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqx.a(0, ((AIOFileVideoData)localObject1).jdField_h_of_type_JavaLangString);
      this.jdField_a_of_type_Agqx.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845265);
      a(false);
      return;
    }
    this.jdField_a_of_type_Aqnk.b(this.jdField_a_of_type_Aqnk.c(), true);
    f(false);
    e(false);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Agqx.a(8, "");
    localObject2 = this.jdField_a_of_type_Agqx;
    if (((AIOFileVideoData)localObject1).l) {}
    for (int i = 8;; i = 0)
    {
      ((agqx)localObject2).b(i);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845265);
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
          Object localObject = this.jdField_a_of_type_Aqnk.a();
          if ((localObject != null) && (((aqmg)localObject).a != null) && (((aqmg)localObject).a.a() == 4) && (this.jdField_a_of_type_Agqx != null))
          {
            localObject = (AIOFileVideoData)((aqmg)localObject).a;
            if (((AIOFileVideoData)localObject).jdField_h_of_type_Boolean)
            {
              ((AIOFileVideoData)localObject).jdField_h_of_type_Boolean = false;
              localObject = new aqmp().a((AIOFileVideoData)localObject, false);
              this.jdField_a_of_type_Agqx.a(paramView, (agrc)localObject);
            }
            this.jdField_a_of_type_Agqx.b();
            this.jdField_a_of_type_Agqx.f();
          }
          this.jdField_a_of_type_Aqnk.m();
          this.jdField_a_of_type_Aqnk.q();
          this.jdField_a_of_type_Aqnk.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Aqnk.p();
          return;
        } while (this.jdField_a_of_type_Agqx == null);
        paramView = this.jdField_a_of_type_Aqnk.a();
      } while ((paramView == null) || (paramView.a == null));
      paramView = (AIOFileVideoData)paramView.a;
      paramView.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Agqx.c();
      this.jdField_a_of_type_Agqx.e();
      this.jdField_a_of_type_Aqnk.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Aqnk.j();
      return;
      s();
      this.jdField_a_of_type_Aqnk.o();
      return;
      l();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryFileVideoView", 0, "onClick qq_gallery_danmaku_view ");
      }
      paramView = this.jdField_a_of_type_Aqnk.a();
      long l = this.jdField_a_of_type_Agqx.a();
      if ((paramView != null) && (paramView.a != null)) {
        MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqmm.a(), this.jdField_a_of_type_Aqmm.a(), false, 26, paramView.a.d, l);
      }
      this.jdField_a_of_type_Aqnk.r();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter == null);
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.j();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Agqx != null)
      {
        paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_a_of_type_Agqx.b());
        this.jdField_a_of_type_Agqx.c(paramInt);
      }
      this.jdField_a_of_type_Aqnk.n();
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onStopTrackingTouch");
    if (this.jdField_a_of_type_Agqx != null)
    {
      this.jdField_a_of_type_Agqx.n();
      if ((this.jdField_a_of_type_Aqnk.a() != null) && (this.jdField_a_of_type_Aqnk.a(this.jdField_a_of_type_Aqnk.a())) && (paramSeekBar != null))
      {
        aqmb.a().a().a("AIOGalleryFileVideoView", 4, "seek danmaku");
        this.jdField_a_of_type_Aqnk.a().a(paramSeekBar.getProgress());
        aqmg localaqmg = this.jdField_a_of_type_Aqnk.a();
        if ((localaqmg != null) && (localaqmg.a != null)) {
          this.jdField_a_of_type_Aqnk.a().a(this.jdField_a_of_type_Aqnk.a(localaqmg.a.d, paramSeekBar.getProgress()));
        }
      }
    }
  }
  
  public void q()
  {
    aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onResume");
    if (this.jdField_a_of_type_Agqx != null)
    {
      this.jdField_a_of_type_Agqx.j();
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Agqx.f();
      }
    }
    j();
  }
  
  public void r()
  {
    aqmb.a().a().a("AIOGalleryFileVideoView", 4, "onPause");
    if ((this.jdField_a_of_type_Agqx != null) && (this.jdField_a_of_type_Agqx.c()))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Agqx.h();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void v() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpn
 * JD-Core Version:    0.7.0.1
 */