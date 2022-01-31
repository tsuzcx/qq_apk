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
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.2;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.3;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.4;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.5;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.DragGallery;
import com.tencent.richmediabrowser.view.page.Gallery.LayoutParams;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class axvm
  extends axvd
  implements ails, ailu, ailx, View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public int a;
  public ailt a;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public RelativeLayout a;
  public SeekBar a;
  public TextView a;
  public axuk a;
  private betz jdField_a_of_type_Betz;
  final Runnable jdField_a_of_type_JavaLangRunnable = new AIOFileVideoView.4(this);
  public String a;
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> a;
  private boolean jdField_a_of_type_Boolean;
  public ImageView b;
  public RelativeLayout b;
  public SeekBar b;
  public TextView b;
  public final Runnable b;
  public RelativeLayout c;
  public TextView c;
  public ImageButton d;
  public TextView d;
  public ImageButton e;
  
  public axvm(Activity paramActivity, axuk paramaxuk)
  {
    super(paramActivity, paramaxuk);
    this.jdField_b_of_type_JavaLangRunnable = new AIOFileVideoView.5(this);
    this.jdField_a_of_type_Axuk = paramaxuk;
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 3000) {
      return 3;
    }
    return 9;
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    ailz localailz;
    Bundle localBundle;
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (paramRichMediaBrowserInfo.baseData.getType() == 103))
    {
      paramRichMediaBrowserInfo = (AIOFileVideoData)paramRichMediaBrowserInfo.baseData;
      localailz = new axub().a(paramRichMediaBrowserInfo, paramRichMediaBrowserInfo.m);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onViewDetached, status = " + paramRichMediaBrowserInfo.status);
      if ((paramRichMediaBrowserInfo.i) && (RichMediaBrowserManager.getInstance().getProvider() != null))
      {
        localBundle = new Bundle();
        if ((this.jdField_a_of_type_Ailt != null) && (ailv.class.isInstance(this.jdField_a_of_type_Ailt))) {
          localBundle.putFloat("progress", ((ailv)this.jdField_a_of_type_Ailt).a(paramRichMediaBrowserInfo.jdField_a_of_type_Long));
        }
        if (paramRichMediaBrowserInfo.jdField_e_of_type_Boolean) {
          break label254;
        }
        RichMediaBrowserManager.getInstance().getProvider().onFileVideoStatusChange(localailz.jdField_a_of_type_Long, 10, localBundle);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Axuk.a(paramRichMediaBrowserInfo.jdField_a_of_type_Long, paramRichMediaBrowserInfo.jdField_a_of_type_Int, 0);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "updateItemStatus FILE_VIDEO_PEEK_PAUSE id = " + paramRichMediaBrowserInfo.id);
      if (this.jdField_a_of_type_Ailt != null)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onViewDetached video onPause...");
        this.jdField_a_of_type_Ailt.i();
      }
      return;
      label254:
      RichMediaBrowserManager.getInstance().getProvider().onFileVideoStatusChange(localailz.jdField_a_of_type_Long, 12, localBundle);
    }
  }
  
  private boolean a(long paramLong)
  {
    AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Axuk.a();
    return (localAIOFileVideoData != null) && (localAIOFileVideoData.jdField_a_of_type_Long == paramLong);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axuk.getSelectedItem();
      if ((localRichMediaBrowserInfo == null) || (!(localRichMediaBrowserInfo.baseData instanceof AIOFileVideoData))) {
        break label74;
      }
      if (!bdcs.b(((AIOFileVideoData)localRichMediaBrowserInfo.baseData).jdField_c_of_type_JavaLangString)) {
        return false;
      }
      this.e.setVisibility(0);
    }
    label74:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      this.e.setVisibility(4);
    }
  }
  
  private void g()
  {
    AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Axuk.a();
    if ((localAIOFileVideoData == null) || (!bdcs.b(localAIOFileVideoData.jdField_c_of_type_JavaLangString))) {}
    label165:
    label168:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Betz != null) {
        this.jdField_a_of_type_Betz.b();
      }
      long l;
      if (this.jdField_a_of_type_Ailt != null)
      {
        l = this.jdField_a_of_type_Ailt.a();
        this.jdField_a_of_type_Betz = new betz(this.mContext);
        this.jdField_a_of_type_Betz.a(localAIOFileVideoData.jdField_c_of_type_JavaLangString, localAIOFileVideoData.jdField_a_of_type_Long, l);
        if (bdcs.b(localAIOFileVideoData.jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_Betz.a(localAIOFileVideoData.jdField_b_of_type_JavaLangString, localAIOFileVideoData.jdField_c_of_type_Int, localAIOFileVideoData.jdField_d_of_type_Int);
        }
        if (localAIOFileVideoData.jdField_c_of_type_Int <= localAIOFileVideoData.jdField_d_of_type_Int) {
          break label165;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (!this.jdField_a_of_type_Betz.a(bool, localAIOFileVideoData.jdField_b_of_type_Int)) {
          break label168;
        }
        this.jdField_a_of_type_Axuk.back();
        return;
        l = 0L;
        break;
      }
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
  
  public void a()
  {
    if (this.contentView == null)
    {
      this.contentView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559120, null));
      Object localObject = (RelativeLayout)this.contentView.findViewById(2131371441);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131371201));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376271));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371442));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372319));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378166));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.e = ((ImageButton)this.contentView.findViewById(2131373457));
      this.e.setContentDescription(alpo.a(2131700402));
      this.e.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131379297));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379299));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379298));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364326));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.contentView.findViewById(2131363777));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.contentView.findViewById(2131375156));
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373456));
      if (this.jdField_c_of_type_AndroidWidgetImageButton != null) {
        this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373458));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373464));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.contentView.findViewById(2131379791);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.contentView.findViewById(2131373459));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (bngs.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bngs.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bngs.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bngs.jdField_a_of_type_Int;
      }
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
  }
  
  public void a(int paramInt1, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "setVideoDrawableWithUrls position = " + paramInt1);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axuk.getItem(paramInt1);
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null)) {}
    axub localaxub;
    for (;;)
    {
      return;
      if (localRichMediaBrowserInfo.baseData.getType() == 103)
      {
        paramMessageForShortVideo = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
        localaxub = new axub();
        if (paramMessageForShortVideo.jdField_d_of_type_Boolean)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "fileVideo is playing:" + paramMessageForShortVideo.id);
          return;
        }
        paramMessageForShortVideo.jdField_d_of_type_Boolean = true;
        if ("I:E".equals(paramString1)) {
          try
          {
            paramMessageForShortVideo.jdField_f_of_type_Long = Long.parseLong(paramArrayOfString[0]);
            paramString2 = paramArrayOfString[1];
            ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).jdField_h_of_type_JavaLangString = paramString2;
            this.jdField_a_of_type_Axuk.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 7);
            paramInt1 = 0;
            if (paramMessageForShortVideo.jdField_f_of_type_Long == -134L)
            {
              paramString1 = this.mContext.getString(2131720126);
              paramInt1 = 1;
              if (paramInt1 != 0)
              {
                paramString1 = bdcd.a(this.mContext, 230, "", paramString1, null, alpo.a(2131700439), new axvo(this), null);
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
      this.jdField_a_of_type_Axuk.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 0);
      paramString1 = localaxub.a(paramMessageForShortVideo, paramMessageForShortVideo.m);
      this.jdField_a_of_type_Ailt.a(this.galleryView, paramString1);
      if (this.jdField_a_of_type_Axuk.a(paramMessageForShortVideo.jdField_a_of_type_Long))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "setVideoDrawableWithUrls autoPlay id = " + paramMessageForShortVideo.id);
        this.jdField_a_of_type_Axuk.a(paramMessageForShortVideo.jdField_a_of_type_Long, paramMessageForShortVideo.jdField_a_of_type_Int, 5);
        this.jdField_a_of_type_Ailt.b();
        this.jdField_a_of_type_Ailt.f();
      }
      updateUI();
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
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_Axuk.getSelectedItem();
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null) || (localRichMediaBrowserInfo.baseData.getType() != 103)) {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onRevokeMsg exp!");
    }
    while ((this.jdField_a_of_type_Ailt == null) || (!this.jdField_a_of_type_Ailt.c())) {
      return;
    }
    this.jdField_a_of_type_Ailt.h();
  }
  
  public void a(long paramLong, float paramFloat, String paramString)
  {
    if (a(paramLong)) {
      this.mContext.runOnUiThread(new AIOFileVideoView.3(this, paramFloat, paramString));
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Axuk.a(paramLong, paramInt, 2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Axuk.a(paramLong, paramInt1, paramInt2, paramString1);
    a(this.jdField_a_of_type_Axuk.getSelectedIndex(), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(ailz paramailz)
  {
    if ((paramailz != null) && (paramailz.jdField_a_of_type_Boolean))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onPlayStart file need download");
      return;
    }
    if ((paramailz != null) && (a(paramailz.jdField_a_of_type_Long)))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onPlayStart id = " + paramailz.jdField_a_of_type_Long);
      this.jdField_a_of_type_Axuk.a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int, 5);
      this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      if (this.jdField_a_of_type_Axuk.a(this.jdField_a_of_type_Axuk.getCurrentPosition()))
      {
        AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Axuk.a();
        if (localAIOFileVideoData != null)
        {
          if (bdcs.b(localAIOFileVideoData.jdField_c_of_type_JavaLangString)) {
            this.jdField_a_of_type_Axuk.a();
          }
          if ((this.jdField_a_of_type_Axuk.a() != null) && (this.jdField_a_of_type_Ailt != null)) {
            this.jdField_a_of_type_Axuk.a().a(axts.a(localAIOFileVideoData.jdField_d_of_type_Long, this.jdField_a_of_type_Ailt.a(), this.jdField_a_of_type_Axuk.a(), this.jdField_a_of_type_Axuk.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap));
          }
        }
      }
    }
    if (paramailz != null)
    {
      c(paramailz.jdField_a_of_type_Long);
      d(paramailz.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Axuk.a(0L, 0L, axtu.a().c());
  }
  
  public void a(ailz paramailz, int paramInt)
  {
    if ((paramailz != null) && (a(paramailz.jdField_a_of_type_Long)))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onEndBuffering id = " + paramailz.jdField_a_of_type_Long);
      if (!this.jdField_a_of_type_Ailt.c()) {
        break label189;
      }
      Object localObject = this.jdField_a_of_type_Axuk.getSelectedItem();
      if ((localObject != null) && (AIOFileVideoData.class.isInstance(((RichMediaBrowserInfo)localObject).baseData)))
      {
        localObject = (AIOFileVideoData)((RichMediaBrowserInfo)localObject).baseData;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onEndBuffering isDownloadSuccess: " + ((AIOFileVideoData)localObject).jdField_f_of_type_Boolean);
        if (((AIOFileVideoData)localObject).jdField_f_of_type_Boolean) {
          break label170;
        }
        this.jdField_a_of_type_Axuk.a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int, 1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label170:
      this.jdField_a_of_type_Axuk.a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int, 5);
      continue;
      label189:
      if (this.jdField_a_of_type_Ailt.d()) {
        this.jdField_a_of_type_Axuk.a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int, 6);
      }
    }
  }
  
  public void a(ailz paramailz, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramailz != null) && (a(paramailz.jdField_a_of_type_Long)))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onError id = " + paramailz.jdField_a_of_type_Long);
      paramString = this.jdField_a_of_type_Axuk.a();
      if (paramString != null)
      {
        this.jdField_a_of_type_Axuk.a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int, 7);
        localObject = rjm.a(paramInt1, paramInt2);
        if (!paramString.jdField_e_of_type_Boolean) {
          break label99;
        }
      }
    }
    return;
    label99:
    paramString.jdField_h_of_type_JavaLangString = ((String)localObject);
    Object localObject = new Bundle();
    float f = 0.0F;
    if (ailv.class.isInstance(this.jdField_a_of_type_Ailt)) {
      f = ((ailv)this.jdField_a_of_type_Ailt).a(paramailz.jdField_a_of_type_Long);
    }
    ((Bundle)localObject).putFloat("progress", f);
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().onFileVideoStatusChange(paramString.jdField_a_of_type_Long, 10, (Bundle)localObject);
    }
    updateUI();
  }
  
  public void a(ailz paramailz, long paramLong)
  {
    if ((paramailz != null) && (a(paramailz.jdField_a_of_type_Long)))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onDurationReady id = " + paramailz.jdField_a_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
    }
  }
  
  public void a(ailz paramailz, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramailz != null) && (a(paramailz.jdField_a_of_type_Long)))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onGetUrl id = " + paramailz.jdField_a_of_type_Long);
      this.jdField_a_of_type_Axuk.a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int, 4);
      this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new axvp(this, paramAIOFileVideoData));
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    if ((this.mContext != null) && (this.mContext.getIntent() != null)) {
      this.mContext.getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    bdig.a(2, localArrayList1);
    bdig.a(27, localArrayList1);
    bdig.a(39, localArrayList2);
    bdig.a(6, localArrayList2);
    if ((axtu.a().g()) && (!TextUtils.isEmpty(axtu.a().c()))) {
      bdig.a(54, localArrayList2);
    }
    if ((this.jdField_a_of_type_Ailt.c()) || (this.jdField_a_of_type_Ailt.d())) {
      ((ailv)this.jdField_a_of_type_Ailt).b(this.galleryView.getWidth(), this.galleryView.getHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList2;
      this.jdField_a_of_type_JavaLangString = null;
      a(paramAIOFileVideoData);
      paramAIOFileVideoData = this.jdField_a_of_type_Axuk.a(paramAIOFileVideoData, this.mContext);
      if (paramAIOFileVideoData != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOFileVideoData);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localArrayList1, localArrayList2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      return;
      if (paramAIOFileVideoData != null)
      {
        File localFile = new axub().a(paramAIOFileVideoData);
        if ((localFile != null) && (localFile.exists())) {
          a(localFile.getAbsolutePath());
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((this.mContext == null) || (this.mContext.isFinishing())) {}
    while (!bdcs.b(paramString)) {
      return;
    }
    aroo.a(this.mContext, paramString, new axvn(this, paramString));
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData)
  {
    ailz localailz = new axub().a(paramAIOFileVideoData, paramAIOFileVideoData.m);
    if ((localailz == null) || (this.jdField_a_of_type_Ailt == null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "initVideo error");
      this.jdField_a_of_type_Axuk.a(localailz.jdField_a_of_type_Long, localailz.jdField_b_of_type_Int, 7);
      return false;
    }
    localailz.jdField_e_of_type_Boolean = paramAIOFileVideoData.m;
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "initVideo, set playMediaInfo.isMute =  " + paramAIOFileVideoData.m);
    this.jdField_a_of_type_Ailt.a(this.galleryView, localailz);
    return true;
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return super.a(paramRichMediaBrowserInfo);
  }
  
  public void b(long paramLong)
  {
    AIOFileVideoData localAIOFileVideoData;
    if (a(paramLong))
    {
      this.jdField_a_of_type_Axuk.a(paramLong, 0, 0, "");
      localAIOFileVideoData = this.jdField_a_of_type_Axuk.a();
      if ((localAIOFileVideoData != null) && (!localAIOFileVideoData.jdField_f_of_type_Boolean)) {}
    }
    else
    {
      return;
    }
    localAIOFileVideoData.l = false;
    if ((localAIOFileVideoData.k) || (localAIOFileVideoData.jdField_f_of_type_Boolean)) {}
    for (localAIOFileVideoData.status = 0;; localAIOFileVideoData.status = 5)
    {
      new axub().a(localAIOFileVideoData);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "file[" + paramLong + "],download success, set downloadSuccess");
      this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
  }
  
  public void b(ailz paramailz)
  {
    if ((paramailz != null) && (a(paramailz.jdField_a_of_type_Long)))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onPlayPause id = " + paramailz.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Ailt.d())
      {
        this.jdField_a_of_type_Axuk.a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int, 6);
        this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
        long l = this.jdField_a_of_type_Ailt.a();
        int i = (int)(l / this.jdField_a_of_type_Ailt.b() * 10000.0D);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l));
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
        if (this.jdField_a_of_type_Axuk.a(this.jdField_a_of_type_Axuk.getCurrentPosition())) {
          this.jdField_a_of_type_Axuk.a(true);
        }
      }
    }
  }
  
  public void b(ailz paramailz, int paramInt)
  {
    if ((paramailz != null) && (a(paramailz.jdField_a_of_type_Long)))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onDownloading id = " + paramailz.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_Ailt != null) && (!this.jdField_a_of_type_Ailt.c()))
      {
        this.jdField_a_of_type_Axuk.a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int, 1);
        this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public boolean b()
  {
    if (super.b())
    {
      AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Axuk.a();
      if ((localAIOFileVideoData != null) && (!axtu.a().c()) && (!TextUtils.isEmpty(localAIOFileVideoData.jdField_c_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.jdField_a_of_type_Int = (azjb.a(this.mContext) / 2);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_Axuk.a(paramLong);
  }
  
  public void c(ailz paramailz)
  {
    if ((paramailz != null) && (paramailz.jdField_b_of_type_Boolean) && (a(paramailz.jdField_a_of_type_Long)))
    {
      Object localObject = this.jdField_a_of_type_Axuk.getSelectedItem();
      if (AIOFileVideoData.class.isInstance(((RichMediaBrowserInfo)localObject).baseData))
      {
        localObject = (AIOFileVideoData)((RichMediaBrowserInfo)localObject).baseData;
        ((AIOFileVideoData)localObject).k = true;
        if (!((AIOFileVideoData)localObject).jdField_f_of_type_Boolean)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onPlayFinish id = " + paramailz.jdField_a_of_type_Long + " ,but file is downloading!");
          this.jdField_a_of_type_Ailt.b(8);
        }
      }
    }
    else
    {
      return;
    }
    c(paramailz.jdField_a_of_type_Long);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onPlayFinish id = " + paramailz.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
    this.jdField_a_of_type_Axuk.a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int, 0);
    this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.mContext.runOnUiThread(new AIOFileVideoView.2(this));
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_Axuk.b(paramLong);
  }
  
  public void d(ailz paramailz)
  {
    if ((paramailz != null) && (a(paramailz.jdField_a_of_type_Long)))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onBuffering id = " + paramailz.jdField_a_of_type_Long);
      this.jdField_a_of_type_Axuk.a(paramailz.jdField_a_of_type_Long, paramailz.jdField_b_of_type_Int, 3);
      long l = this.jdField_a_of_type_Ailt.c();
      if (l <= 0L) {
        break label146;
      }
      paramailz = ShortVideoUtils.a(this.mContext, l * 1024L);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramailz + "/s");
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label146:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doEnterImmersion, isClick = ").append(paramBoolean).append(" ,  isShowingDanmaku =");
      if (this.jdField_a_of_type_Axuk.a() == null) {
        break label88;
      }
    }
    label88:
    for (boolean bool = this.jdField_a_of_type_Axuk.a().b();; bool = false)
    {
      QLog.d("AIOFileVideoView", 0, bool);
      super.d(paramBoolean);
      if (!paramBoolean) {
        break;
      }
      showContentView(false);
      this.jdField_a_of_type_Axuk.b(false);
      return;
    }
    if ((this.jdField_a_of_type_Axuk.a() != null) && (this.jdField_a_of_type_Axuk.a().b()))
    {
      this.jdField_a_of_type_Axuk.a().jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Axuk.d();
      h(false);
      return;
    }
    showContentView(false);
  }
  
  public void e(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      g(b());
      return;
    }
  }
  
  public void f()
  {
    h(true);
  }
  
  public void f(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    DisplayMetrics localDisplayMetrics;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof axvq))) {
      this.galleryView = ((RelativeLayout)paramView);
    }
    RichMediaBrowserInfo localRichMediaBrowserInfo;
    for (paramViewGroup = ((axvq)paramView.getTag()).a;; paramViewGroup = (GalleryUrlImageView)this.galleryView.findViewById(2131372238))
    {
      a();
      localRichMediaBrowserInfo = this.jdField_a_of_type_Axuk.getItem(paramInt);
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null)) {
        break;
      }
      return paramViewGroup;
      this.galleryView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558575, null));
      paramView = new Gallery.LayoutParams(-1, -1);
      this.galleryView.setLayoutParams(paramView);
    }
    AIOFileVideoData localAIOFileVideoData;
    axub localaxub;
    if (localRichMediaBrowserInfo.baseData.getType() == 103)
    {
      paramView = this.jdField_a_of_type_Axuk.a();
      if ((paramView == null) || (paramView.baseData == null) || (paramView.baseData.getType() != 103) || (((AIOBrowserBaseData)paramView.baseData).jdField_a_of_type_Long != ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long) || (paramView.isReport)) {
        break label385;
      }
      azmj.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
      paramView.isReport = true;
      localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
      localaxub = new axub();
      paramView = (Drawable)this.jdField_a_of_type_Axuk.mActiveDrawable.get(Integer.valueOf(paramInt));
      if (!localaxub.b(localAIOFileVideoData)) {
        break label421;
      }
    }
    for (;;)
    {
      this.galleryView.setTag(2131296400, Boolean.valueOf(true));
      this.galleryView.setTag(2131296433, Boolean.valueOf(true));
      paramViewGroup.setImageDrawable(paramView);
      paramViewGroup.setContentDescription(this.mContext.getString(2131691691));
      if (localaxub.b(localAIOFileVideoData)) {
        paramViewGroup.setImageDrawable(null);
      }
      if (localRichMediaBrowserInfo.isEnterImage) {
        localAIOFileVideoData.jdField_g_of_type_Boolean = true;
      }
      paramView = new axvq(this);
      paramView.a = paramViewGroup;
      this.galleryView.setTag(paramView);
      return this.galleryView;
      label385:
      azmj.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
      break;
      label421:
      if ((paramView == null) || (((URLDrawable)paramView).getStatus() != 1)) {
        break label448;
      }
      this.jdField_a_of_type_Axuk.onLoadFinish(paramInt, true);
    }
    label448:
    if (!TextUtils.isEmpty(localAIOFileVideoData.jdField_b_of_type_JavaLangString))
    {
      File localFile = new File(localAIOFileVideoData.jdField_b_of_type_JavaLangString);
      if (!localFile.exists()) {
        break label574;
      }
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = this.mScreenWidthPx;
      paramView.mRequestHeight = this.mScreenHeightPx;
      paramView.mLoadingDrawable = baul.a;
      paramView.mPlayGifImage = true;
      paramView.mUseExifOrientation = false;
      paramView = URLDrawable.getDrawable(localFile, paramView);
      ((URLDrawable)paramView).setTag(Integer.valueOf(1));
      this.jdField_a_of_type_Axuk.mActiveDrawable.put(Integer.valueOf(paramInt), (URLDrawable)paramView);
    }
    label574:
    for (;;)
    {
      break;
      paramView = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837967);
      break;
    }
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
        return;
        Object localObject = this.jdField_a_of_type_Axuk.a();
        if ((localObject != null) && (this.jdField_a_of_type_Ailt != null))
        {
          if (((AIOFileVideoData)localObject).jdField_h_of_type_Boolean)
          {
            ((AIOFileVideoData)localObject).jdField_h_of_type_Boolean = false;
            localObject = new axub().a((AIOFileVideoData)localObject, false);
            this.jdField_a_of_type_Ailt.a(paramView, (ailz)localObject);
          }
          this.jdField_a_of_type_Ailt.b();
          this.jdField_a_of_type_Ailt.f();
        }
        this.jdField_a_of_type_Axuk.g();
        this.jdField_a_of_type_Axuk.a().b();
        this.jdField_a_of_type_Axuk.a().jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Axuk.a().a();
        return;
        paramView = this.jdField_a_of_type_Axuk.a();
      } while ((paramView == null) || (this.jdField_a_of_type_Ailt == null));
      paramView.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Ailt.c();
      this.jdField_a_of_type_Ailt.e();
      this.jdField_a_of_type_Axuk.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
      this.jdField_a_of_type_Axuk.back();
      return;
      g();
      this.jdField_a_of_type_Axuk.i();
      return;
      d();
      return;
      c();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOFileVideoView", 0, "onClick qq_gallery_danmaku_view ");
      }
      paramView = this.jdField_a_of_type_Axuk.a();
      if (paramView != null)
      {
        long l = this.jdField_a_of_type_Ailt.a();
        MiniChatActivity.a(this.mContext, axtu.a().a(), axtu.a().a(), false, 26, paramView.jdField_d_of_type_Long, l);
      }
      this.jdField_a_of_type_Axuk.j();
      return;
    } while (this.basePresenter == null);
    this.basePresenter.back();
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
    this.jdField_a_of_type_Ailt = new ailv();
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      this.jdField_a_of_type_Ailt.a(((axtx)RichMediaBrowserManager.getInstance().getProvider()).a);
    }
    this.jdField_a_of_type_Ailt.a(this);
    this.jdField_a_of_type_Ailt.a(this);
    ((ailv)this.jdField_a_of_type_Ailt).a(this);
  }
  
  public View onCreateView(int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    a(paramRichMediaBrowserInfo);
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ailt != null) {
      this.jdField_a_of_type_Ailt.k();
    }
    if (this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_Axuk.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    a(this.jdField_a_of_type_Axuk.getSelectedItem());
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Axuk.mActiveDrawable != null) {
      this.jdField_a_of_type_Axuk.mActiveDrawable.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    showContentView(false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Axuk.getItem(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.baseData == null) || (this.jdField_a_of_type_Axuk.getGallery() == null)) {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "there data is null, position: " + paramInt);
    }
    Object localObject;
    do
    {
      return;
      localObject = ((DragGallery)this.jdField_a_of_type_Axuk.getGallery()).getSingleTapConfirmedEvent();
    } while ((paramAdapterView.baseData.getType() != 103) || (this.jdField_a_of_type_Ailt == null));
    if ((localObject != null) && (this.jdField_a_of_type_Ailt.a((MotionEvent)localObject)))
    {
      paramAdapterView = (AIOFileVideoData)paramAdapterView.baseData;
      localObject = new axub();
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onItemClick id = " + paramAdapterView.id);
      if (((axub)localObject).a(paramAdapterView)) {
        this.jdField_a_of_type_Axuk.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 5);
      }
      for (;;)
      {
        ((axub)localObject).a(paramAdapterView, paramView, this.jdField_a_of_type_Ailt);
        updateUI();
        return;
        this.jdField_a_of_type_Axuk.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 1);
      }
    }
    if (this.jdField_a_of_type_Axuk.b())
    {
      if (this.jdField_a_of_type_Axuk.a().jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Axuk.a().f();
        this.jdField_a_of_type_Axuk.a().jdField_a_of_type_Boolean = false;
        e();
        this.jdField_a_of_type_Axuk.a().a();
        return;
      }
      this.jdField_a_of_type_Axuk.a().f();
      this.jdField_a_of_type_Axuk.a().b();
      this.jdField_a_of_type_Axuk.a().jdField_a_of_type_Boolean = true;
      d(true);
      return;
    }
    this.jdField_a_of_type_Axuk.back();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onItemSelected position = " + paramInt);
    Object localObject = this.jdField_a_of_type_Axuk.getItem(paramInt);
    if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {}
    while (((RichMediaBrowserInfo)localObject).baseData.getType() != 103) {
      return;
    }
    paramAdapterView = (AIOFileVideoData)((RichMediaBrowserInfo)localObject).baseData;
    axub localaxub = new axub();
    this.jdField_a_of_type_Axuk.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 0);
    if (((RichMediaBrowserInfo)localObject).isEnterImage) {
      paramAdapterView.jdField_g_of_type_Boolean = true;
    }
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (localaxub.a(paramAdapterView, ((axtx)RichMediaBrowserManager.getInstance().getProvider()).a)))
    {
      if (paramAdapterView.l) {
        this.jdField_a_of_type_Axuk.a(paramAdapterView.jdField_a_of_type_Long, paramAdapterView.jdField_a_of_type_Int, 1);
      }
      if ((!bdcs.b(paramAdapterView.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Axuk.a(this.jdField_a_of_type_Axuk.getCurrentPosition()))) {
        this.jdField_a_of_type_Axuk.a(false);
      }
      updateUI();
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "FileVideo_AP onItemSelected needUrl return");
      return;
    }
    if ((a(paramAdapterView)) && (this.jdField_a_of_type_Axuk.a(paramAdapterView.jdField_a_of_type_Long)) && (((RichMediaBrowserInfo)localObject).isEnterImage))
    {
      if (paramAdapterView.jdField_h_of_type_Boolean)
      {
        paramAdapterView.jdField_h_of_type_Boolean = false;
        localObject = localaxub.a(paramAdapterView, paramAdapterView.m);
        this.jdField_a_of_type_Ailt.a(paramView, (ailz)localObject);
      }
      this.jdField_a_of_type_Ailt.b();
      this.jdField_a_of_type_Ailt.f();
    }
    if ((!bdcs.b(paramAdapterView.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_Axuk.a(this.jdField_a_of_type_Axuk.getCurrentPosition()))) {
      this.jdField_a_of_type_Axuk.a(false);
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaLangString = null;
    updateUI();
  }
  
  public void onPause()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onPause");
    if ((this.jdField_a_of_type_Ailt != null) && (this.jdField_a_of_type_Ailt.c()))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Ailt.h();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Ailt != null)
      {
        paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_a_of_type_Ailt.b());
        this.jdField_a_of_type_Ailt.c(paramInt);
      }
      this.jdField_a_of_type_Axuk.h();
    }
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onResume");
    if (this.jdField_a_of_type_Ailt != null)
    {
      this.jdField_a_of_type_Ailt.j();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Ailt.f();
      }
    }
    updateUI();
  }
  
  public void onScrollEnd(int paramInt)
  {
    AIOFileVideoData localAIOFileVideoData;
    if ((paramInt == this.jdField_a_of_type_Axuk.getCurrentPosition()) && (this.jdField_a_of_type_Axuk.a(paramInt)))
    {
      localAIOFileVideoData = this.jdField_a_of_type_Axuk.a();
      if (localAIOFileVideoData == null) {
        break label80;
      }
    }
    label80:
    for (boolean bool = bdcs.b(localAIOFileVideoData.jdField_c_of_type_JavaLangString);; bool = false)
    {
      if ((this.jdField_a_of_type_Ailt != null) && (this.jdField_a_of_type_Ailt.c()) && (bool))
      {
        this.jdField_a_of_type_Axuk.a();
        return;
      }
      this.jdField_a_of_type_Axuk.a(false);
      return;
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStop()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onStop");
    if (this.jdField_a_of_type_Ailt != null) {
      this.jdField_a_of_type_Ailt.h();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onStopTrackingTouch");
    if (this.jdField_a_of_type_Ailt != null)
    {
      this.jdField_a_of_type_Ailt.n();
      if ((this.jdField_a_of_type_Axuk.a() != null) && (this.jdField_a_of_type_Axuk.a(this.jdField_a_of_type_Axuk.getCurrentPosition())) && (paramSeekBar != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "seek danmaku");
        this.jdField_a_of_type_Axuk.a().a(paramSeekBar.getProgress());
        AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Axuk.a();
        if (localAIOFileVideoData != null) {
          this.jdField_a_of_type_Axuk.a().a(axts.a(localAIOFileVideoData.jdField_d_of_type_Long, paramSeekBar.getProgress(), this.jdField_a_of_type_Axuk.a(), this.jdField_a_of_type_Axuk.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap));
        }
      }
    }
  }
  
  public void onViewDetached(int paramInt, View paramView, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    a(paramRichMediaBrowserInfo);
  }
  
  public void showActionSheet(int paramInt)
  {
    super.showActionSheet(paramInt);
    AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Axuk.a();
    if (localAIOFileVideoData != null) {
      a(localAIOFileVideoData, paramInt);
    }
  }
  
  public void updateUI()
  {
    int i = 8;
    super.updateUI();
    Object localObject = this.jdField_a_of_type_Axuk.a();
    if (localObject != null)
    {
      b(b());
      c(a(this.jdField_a_of_type_Axuk.getSelectedItem()));
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "updateUI id = " + ((AIOFileVideoData)localObject).id + ", status = " + ((AIOFileVideoData)localObject).a());
    }
    switch (((AIOFileVideoData)localObject).status)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "updateUI status is error, status = " + ((AIOFileVideoData)localObject).status);
      return;
    case 1: 
      this.jdField_a_of_type_Axuk.onLoadFinish(this.jdField_a_of_type_Axuk.getSelectedIndex(), true);
      f(false);
      e(true);
      c(false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Ailt.a(8, "");
      this.jdField_a_of_type_Ailt.b(8);
      a(false);
      return;
    case 2: 
      this.jdField_a_of_type_Axuk.onLoadFinish(this.jdField_a_of_type_Axuk.getSelectedIndex(), true);
      float f = ((AIOFileVideoData)localObject).progress / (float)((AIOFileVideoData)localObject).jdField_c_of_type_Long * 100.0F;
      localObject = new DecimalFormat("0.00").format(f);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(alpo.a(2131700408) + (String)localObject + "%");
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)f * 100);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      e(true);
      c(false);
      this.jdField_a_of_type_Ailt.a(8, "");
      this.jdField_a_of_type_Ailt.b(8);
      a(false);
      return;
    case 4: 
      this.jdField_a_of_type_Axuk.onLoadStart(this.jdField_a_of_type_Axuk.getSelectedIndex(), ((AIOFileVideoData)localObject).progress);
      e(false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      c(false);
      this.jdField_a_of_type_Ailt.a(8, "");
      this.jdField_a_of_type_Ailt.b(8);
      a(false);
      return;
    case 3: 
      if (this.jdField_a_of_type_Ailt.c())
      {
        if (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        this.jdField_a_of_type_Axuk.onLoadFinish(this.jdField_a_of_type_Axuk.getSelectedIndex(), true);
        if (!((AIOFileVideoData)localObject).jdField_f_of_type_Boolean) {
          break label579;
        }
        f(true);
        e(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_Ailt.a(8, "");
        a(true);
        return;
        if ((!this.jdField_a_of_type_Ailt.d()) || (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
          break;
        }
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        break;
        e(true);
        f(false);
        c(false);
      }
    case 5: 
      this.jdField_a_of_type_Axuk.onLoadFinish(this.jdField_a_of_type_Axuk.getSelectedIndex(), true);
      f(true);
      e(false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Ailt.a(8, "");
      this.jdField_a_of_type_Ailt.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845635);
      a(true);
      return;
    case 6: 
      this.jdField_a_of_type_Axuk.onLoadFinish(this.jdField_a_of_type_Axuk.getSelectedIndex(), true);
      f(true);
      e(false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Ailt.a(8, "");
      this.jdField_a_of_type_Ailt.b(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845634);
      a(true);
      return;
    case 7: 
      label579:
      this.jdField_a_of_type_Axuk.onLoadFinish(this.jdField_a_of_type_Axuk.getSelectedIndex(), true);
      f(false);
      e(false);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Ailt.a(0, ((AIOFileVideoData)localObject).jdField_h_of_type_JavaLangString);
      this.jdField_a_of_type_Ailt.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845634);
      a(false);
      return;
    }
    this.jdField_a_of_type_Axuk.onLoadFinish(this.jdField_a_of_type_Axuk.getSelectedIndex(), true);
    f(false);
    e(false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Ailt.a(8, "");
    ailt localailt = this.jdField_a_of_type_Ailt;
    if (((AIOFileVideoData)localObject).l) {}
    for (;;)
    {
      localailt.b(i);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845634);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      a(true);
      return;
      i = 0;
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_Axuk.getItem(paramInt);
    if ((localObject1 == null) || (((RichMediaBrowserInfo)localObject1).baseData == null) || (paramView == null)) {
      return;
    }
    GalleryUrlImageView localGalleryUrlImageView;
    if ((paramView.getTag() instanceof axvq))
    {
      localGalleryUrlImageView = ((axvq)paramView.getTag()).a;
      if (((RichMediaBrowserInfo)localObject1).baseData.getType() == 103)
      {
        Object localObject2 = (AIOFileVideoData)((RichMediaBrowserInfo)localObject1).baseData;
        axub localaxub = new axub();
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        localObject2 = localaxub.a((AIOFileVideoData)localObject2);
        if (localObject2 == null) {
          break label196;
        }
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        if (((URLDrawable)localObject1).getStatus() != 1) {
          break label172;
        }
        localGalleryUrlImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_Axuk.onLoadFinish(paramInt, true);
        this.jdField_a_of_type_Axuk.a().c();
      }
    }
    for (;;)
    {
      super.updateView(paramInt, paramString1, paramString2, paramView, paramBoolean);
      return;
      label172:
      ((URLDrawable)localObject1).setTag(Integer.valueOf(1));
      ((URLDrawable)localObject1).startDownload();
      localGalleryUrlImageView.setDecodingDrawble((URLDrawable)localObject1);
      break;
      label196:
      localGalleryUrlImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(2130837967));
      this.jdField_a_of_type_Axuk.onLoadFinish(paramInt, true);
    }
  }
  
  public void v() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvm
 * JD-Core Version:    0.7.0.1
 */