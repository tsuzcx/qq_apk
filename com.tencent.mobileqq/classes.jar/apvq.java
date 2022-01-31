import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.gallery.view.GalleryUrlImageView;
import com.tencent.mobileqq.gallery.view.video.AIOGalleryVideoView.1;
import com.tencent.mobileqq.gallery.view.video.AIOGalleryVideoView.2;
import com.tencent.mobileqq.gallery.view.video.AIOGalleryVideoView.3;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class apvq
  extends apue
  implements agey, View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public long a;
  public agez a;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  public aptm a;
  private bbra jdField_a_of_type_Bbra;
  final Runnable jdField_a_of_type_JavaLangRunnable = new AIOGalleryVideoView.2(this);
  public ImageView b;
  public LinearLayout b;
  public SeekBar b;
  public TextView b;
  public final Runnable b;
  public ImageButton c;
  public RelativeLayout c;
  public TextView c;
  private boolean c;
  public ImageButton d;
  public RelativeLayout d;
  public TextView d;
  
  public apvq(Activity paramActivity, aptm paramaptm)
  {
    super(paramActivity, paramaptm);
    this.jdField_b_of_type_JavaLangRunnable = new AIOGalleryVideoView.3(this);
    this.jdField_a_of_type_Aptm = paramaptm;
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    File localFile = new aptd().a(paramAIOShortVideoData, 1);
    apsr localapsr = this.jdField_a_of_type_Aptm.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    long l;
    if ((localFile != null) && (localFile.exists()))
    {
      l = localFile.length();
      apsm.a().a().a("AIOGalleryVideoView", 4, "showActionSheetForShortVideo, file.getPath()=" + localFile.getPath() + ", mTransferredSize = " + l + ", data.size = " + paramAIOShortVideoData.c);
      if (paramAIOShortVideoData.d != 1) {}
    }
    for (;;)
    {
      if ((paramAIOShortVideoData.d != 1) || (i == 0)) {
        a(2131627268, 2130839591, 59, localArrayList1);
      }
      if ((befo.d()) && ((paramAIOShortVideoData.d != 1) || (i == 0))) {
        a(2131627277, 2130839599, 61, localArrayList1);
      }
      if (i == 0)
      {
        a(2131627267, 2130839590, 63, localArrayList1);
        a(2131627271, 2130839593, 60, localArrayList1);
        a(2131627279, 2130839600, 58, localArrayList1);
      }
      if ((this.jdField_a_of_type_Apsx.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Apsx.c())) && (this.jdField_a_of_type_Apsx.a() != -1)) {
        a(2131627281, 2130839601, 62, localArrayList2);
      }
      if (i == 0) {
        a(2131627274, 2130839596, 64, localArrayList2, 5);
      }
      a(paramAIOShortVideoData, localFile, paramInt, localapsr);
      paramAIOShortVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
      this.jdField_a_of_type_Bahv.a(paramAIOShortVideoData);
      this.jdField_a_of_type_Bahv.a();
      return;
      if (l < paramAIOShortVideoData.c)
      {
        i = 1;
        continue;
        apsm.a().a().a("AIOGalleryVideoView", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
        i = 1;
      }
    }
  }
  
  private boolean a(agfe paramagfe)
  {
    if (paramagfe == null) {}
    apsr localapsr;
    do
    {
      return false;
      localapsr = this.jdField_a_of_type_Aptm.a();
    } while ((localapsr == null) || (localapsr.a == null) || (localapsr.a.jdField_a_of_type_Long != paramagfe.jdField_a_of_type_Long));
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      apsr localapsr = this.jdField_a_of_type_Aptm.a();
      if ((localapsr != null) && ((localapsr.a instanceof AIOShortVideoData)) && (this.jdField_a_of_type_Aptm.a((AIOShortVideoData)localapsr.a) != null))
      {
        this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
        return true;
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    return false;
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
    Object localObject = this.jdField_a_of_type_Aptm.a();
    long l;
    if ((localObject != null) && (((apsr)localObject).a != null) && (((apsr)localObject).a.a() == 2))
    {
      localObject = (AIOShortVideoData)((apsr)localObject).a;
      if (this.jdField_a_of_type_Bbra != null) {
        this.jdField_a_of_type_Bbra.b();
      }
      if (this.jdField_a_of_type_Agez == null) {
        break label180;
      }
      l = this.jdField_a_of_type_Agez.a();
      this.jdField_a_of_type_Bbra = new bbra(this.jdField_a_of_type_AndroidAppActivity);
      agfe localagfe = this.jdField_a_of_type_Aptm.a((AIOShortVideoData)localObject);
      if (localagfe == null) {
        break label190;
      }
      this.jdField_a_of_type_Bbra.a(localagfe, ((AIOShortVideoData)localObject).jdField_e_of_type_Long, l);
      this.jdField_a_of_type_Bbra.a(((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject).jdField_e_of_type_Int, ((AIOShortVideoData)localObject).jdField_f_of_type_Int);
      if (((AIOShortVideoData)localObject).jdField_e_of_type_Int <= ((AIOShortVideoData)localObject).jdField_f_of_type_Int) {
        break label185;
      }
    }
    label180:
    label185:
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_Bbra.a(bool, ((AIOShortVideoData)localObject).jdField_b_of_type_Int)) {
        this.jdField_a_of_type_Aptm.j();
      }
      return;
      l = 0L;
      break;
    }
    label190:
    apsm.a().a().a("AIOGalleryVideoView", 4, "Failed to floating, videoPlayMedioInfo is null");
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof apvx))) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    }
    apsr localapsr;
    for (paramView = ((apvx)paramView.getTag()).a;; paramView = (GalleryUrlImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131306224))
    {
      a();
      localapsr = this.jdField_a_of_type_Aptm.a(paramInt);
      if ((localapsr != null) && (localapsr.a != null)) {
        break;
      }
      return paramView;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131492993, null));
      paramView = new Gallery.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    Object localObject;
    if (localapsr.a.a() == 2)
    {
      localObject = (AIOShortVideoData)localapsr.a;
      paramViewGroup = new aptd();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296400, Boolean.valueOf(true));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296433, Boolean.valueOf(true));
      URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_Aptm.b.get(Integer.valueOf(paramInt));
      if (localURLDrawable == null) {
        break label350;
      }
      paramView.setImageDrawable(localURLDrawable);
      paramViewGroup = "0X8009EF2";
      if (((AIOShortVideoData)localObject).d == 1) {
        paramViewGroup = "0X8009EF1";
      }
      localObject = this.jdField_a_of_type_Aptm.b();
      if ((localObject == null) || (((apsr)localObject).a == null) || (((apsr)localObject).a.a() != 2) || (((apsr)localObject).a.jdField_a_of_type_Long != localapsr.a.jdField_a_of_type_Long) || (((apsr)localObject).jdField_c_of_type_Boolean)) {
        break label387;
      }
      awqx.b(null, "dc00898", "", "", paramViewGroup, paramViewGroup, 1, 0, "", "", "", "");
      ((apsr)localObject).jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      paramViewGroup = new apvx(this);
      paramViewGroup.a = paramView;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      label350:
      if (paramViewGroup.a((AIOShortVideoData)localObject, 0) == null) {
        break;
      }
      this.jdField_a_of_type_Aptm.a(((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject).jdField_e_of_type_Int, ((AIOShortVideoData)localObject).jdField_f_of_type_Int, paramView, paramInt);
      break;
      label387:
      awqx.b(null, "dc00898", "", "", paramViewGroup, paramViewGroup, 2, 0, "", "", "", "");
    }
  }
  
  public View a(int paramInt, apsr paramapsr)
  {
    Object localObject;
    if ((paramapsr != null) && (paramapsr.a != null) && (paramapsr.a.a() == 2))
    {
      localObject = (AIOShortVideoData)paramapsr.a;
      paramapsr = new aptd().a((AIOShortVideoData)localObject, 0);
      if (paramapsr == null) {
        break label127;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = axwd.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = axwd.a;
      paramapsr = URLDrawable.getDrawable(paramapsr, (URLDrawable.URLDrawableOptions)localObject);
      paramapsr.startDownload();
      this.jdField_a_of_type_Aptm.b.put(Integer.valueOf(paramInt), paramapsr);
      apsm.a().a().a("AIOGalleryVideoView", 4, "onCreateView(): preload thumb, position=" + paramInt);
    }
    for (;;)
    {
      return null;
      label127:
      apsm.a().a().a("AIOGalleryVideoView", 4, "onCreateView downloadMedia AIOShortVideoData.TYPE_THUMB");
      this.jdField_a_of_type_Aptm.b(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int, 0);
    }
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
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307309));
      this.jdField_c_of_type_AndroidWidgetImageButton.setContentDescription(ajjy.a(2131634249));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131312850));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131312852));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131312851));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131298702));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131298167));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131308956));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307308));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307310));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131307316));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131298293));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131313272);
      if (bjeh.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bjeh.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageButton.getLayoutParams();
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
    apsr localapsr = this.jdField_a_of_type_Aptm.a();
    if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 2)) {
      a((AIOShortVideoData)localapsr.a, paramInt);
    }
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Aptm.b.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, View paramView, apsr paramapsr)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof apvx)))
    {
      paramView = ((apvx)paramView.getTag()).a;
      paramapsr = (URLDrawable)this.jdField_a_of_type_Aptm.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (paramapsr != null)
      {
        paramView.setImageDrawable(paramapsr);
        apsm.a().a().a("AIOGalleryVideoView", 4, "onViewDetached(): Use thumb cache replace video.");
      }
    }
    else
    {
      return;
    }
    paramView.setImageDrawable(axwd.a);
    apsm.a().a().a("AIOGalleryVideoView", 4, "onViewDetached(): No thumb, use TRANSPARENT");
  }
  
  public void a(int paramInt, Object paramObject, apsr paramapsr)
  {
    a(babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131652999), this.jdField_a_of_type_AndroidAppActivity.getString(2131652998), new apvv(this, paramInt, paramObject), new apvw(this)));
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Aptm.a(paramInt);
    if ((localObject == null) || (((apsr)localObject).a == null) || (paramView == null)) {
      return;
    }
    if ((paramView.getTag() instanceof apvx))
    {
      GalleryUrlImageView localGalleryUrlImageView = ((apvx)paramView.getTag()).a;
      if (((apsr)localObject).a.a() == 2)
      {
        localObject = (AIOShortVideoData)((apsr)localObject).a;
        apsm.a().a().a("AIOGalleryVideoView", 4, "updateView loadShortVideoCover");
        this.jdField_a_of_type_Aptm.a(((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject).jdField_e_of_type_Int, ((AIOShortVideoData)localObject).jdField_f_of_type_Int, localGalleryUrlImageView, paramInt);
      }
    }
    super.a(paramInt, paramString1, paramString2, paramView, paramBoolean);
  }
  
  public void a(int paramInt1, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    apsm.a().a().a("AIOGalleryVideoView", 4, "setShortVideoDrawableWithUrls position = " + paramInt1);
    apsr localapsr = this.jdField_a_of_type_Aptm.a(paramInt1);
    if ((localapsr == null) || (localapsr.a == null)) {}
    while (localapsr.a.a() != 2) {
      return;
    }
    paramString1 = (AIOShortVideoData)localapsr.a;
    aptw.a().a(localapsr.a.jdField_a_of_type_Long, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt2, paramString2);
    paramString2 = new agfe();
    paramString2.jdField_a_of_type_Boolean = true;
    paramString2.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    paramString2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    paramString2.jdField_a_of_type_Int = paramInt2;
    paramString2.jdField_a_of_type_Long = paramString1.jdField_a_of_type_Long;
    paramString2.jdField_b_of_type_Int = paramString1.jdField_a_of_type_Int;
    paramArrayOfString = new File(paramString1.jdField_b_of_type_JavaLangString);
    if (paramArrayOfString.exists())
    {
      paramString2.d = paramArrayOfString.length();
      paramString2.e = paramString1.jdField_g_of_type_Boolean;
      apsm.a().a().a("AIOGalleryVideoView", 4, "setShortVideoDrawableWithUrls, set playMediaInfo.isMute =  " + paramString2.e);
      this.jdField_a_of_type_Agez.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramString2);
      if (!this.jdField_a_of_type_Aptm.a(paramString1.jdField_a_of_type_Long)) {
        break label327;
      }
      this.jdField_a_of_type_Agez.f();
    }
    for (;;)
    {
      if (new aptd().a(paramString1, 0) == null)
      {
        apsm.a().a().a("AIOGalleryVideoView", 4, "setShortVideoDrawableWithUrls, get thumb");
        this.jdField_a_of_type_Aptm.b(paramString1.jdField_a_of_type_Long, paramString1.jdField_a_of_type_Int, 0);
      }
      j();
      return;
      paramString2.d = 0L;
      break;
      label327:
      this.jdField_a_of_type_Aptm.a(paramString1.jdField_a_of_type_Long, paramString1.jdField_a_of_type_Int, 0);
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    Object localObject = this.jdField_a_of_type_Aptm.a();
    if ((localObject == null) || (((apsr)localObject).a == null) || (((apsr)localObject).a.a() != 2))
    {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg exp!");
      return;
    }
    int i = this.jdField_a_of_type_Aptm.a(((apsr)localObject).a.jdField_a_of_type_Long, ((apsr)localObject).a.jdField_a_of_type_Int);
    if ((i >= 0) && (i < 100)) {}
    for (boolean bool = true;; bool = false)
    {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg isSaving:" + bool);
      localObject = (AIOShortVideoData)((apsr)localObject).a;
      apsm.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg BUSI_TYPE_VIDEO");
      if (bool)
      {
        apsm.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg cancelDownloadMedia");
        this.jdField_a_of_type_Aptm.c(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int, 256);
      }
      if ((this.jdField_a_of_type_Agez == null) || (!this.jdField_a_of_type_Agez.c())) {
        break;
      }
      this.jdField_a_of_type_Agez.h();
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Aptm.a(paramLong, paramInt1, paramInt2, paramString1);
    a(this.jdField_a_of_type_Aptm.c(), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(agfe paramagfe)
  {
    if (a(paramagfe))
    {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onPlayStart id = " + paramagfe.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aptm.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 5);
      this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      if (this.jdField_a_of_type_Aptm.a(this.jdField_a_of_type_Aptm.a()))
      {
        this.jdField_a_of_type_Aptm.a();
        apsr localapsr = this.jdField_a_of_type_Aptm.a();
        if ((localapsr != null) && (localapsr.a != null) && (this.jdField_a_of_type_Aptm.a() != null) && (this.jdField_a_of_type_Agez != null)) {
          this.jdField_a_of_type_Aptm.a().a(this.jdField_a_of_type_Aptm.a(localapsr.a.d, this.jdField_a_of_type_Agez.a()));
        }
      }
    }
    if (paramagfe != null)
    {
      b(paramagfe.jdField_a_of_type_Long);
      c(paramagfe.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Aptm.a(0L, 0L, this.jdField_a_of_type_Aptm.a().c());
  }
  
  public void a(agfe paramagfe, int paramInt)
  {
    if (a(paramagfe))
    {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onEndBuffering id = " + paramagfe.jdField_a_of_type_Long);
      if (!this.jdField_a_of_type_Agez.c()) {
        break label87;
      }
      this.jdField_a_of_type_Aptm.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 5);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label87:
      if (this.jdField_a_of_type_Agez.d()) {
        this.jdField_a_of_type_Aptm.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 6);
      }
    }
  }
  
  public void a(agfe paramagfe, int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramagfe))
    {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onError id = " + paramagfe.jdField_a_of_type_Long);
      apsr localapsr = this.jdField_a_of_type_Aptm.a();
      if ((localapsr != null) && (localapsr.a != null) && (localapsr.a.a() == 2))
      {
        this.jdField_a_of_type_Aptm.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 7);
        ((AIOShortVideoData)localapsr.a).jdField_f_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void a(agfe paramagfe, long paramLong)
  {
    if (a(paramagfe))
    {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onDurationReady id = " + paramagfe.jdField_a_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
    }
  }
  
  public void a(agfe paramagfe, boolean paramBoolean)
  {
    if ((paramBoolean) && (a(paramagfe)))
    {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onGetUrl id = " + paramagfe.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aptm.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 4);
      this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    b(paramViewGroup);
  }
  
  public void a(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, apsr paramapsr)
  {
    this.jdField_a_of_type_Bahv.a(new apvr(this, paramAIOShortVideoData, paramFile, paramInt, paramapsr));
    this.jdField_a_of_type_Bahv.a(new apvs(this));
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = this.jdField_a_of_type_Aptm.a(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.a != null) && (paramAdapterView.a.a() == 2))
    {
      paramView = (AIOShortVideoData)paramAdapterView.a;
      this.jdField_a_of_type_Aptm.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
      if ((a(paramView)) && (this.jdField_a_of_type_Aptm.a(paramAdapterView.a.jdField_a_of_type_Long))) {
        this.jdField_a_of_type_Agez.f();
      }
    }
    j();
  }
  
  public boolean a(AIOShortVideoData paramAIOShortVideoData)
  {
    agfe localagfe = this.jdField_a_of_type_Aptm.a(paramAIOShortVideoData);
    if (localagfe == null)
    {
      this.jdField_a_of_type_Aptm.b(paramAIOShortVideoData);
      apsm.a().a().a("AIOGalleryVideoView", 4, "initVideo handleUnDownloadVideo");
      return false;
    }
    if (this.jdField_a_of_type_Agez != null)
    {
      localagfe.e = paramAIOShortVideoData.jdField_g_of_type_Boolean;
      apsm.a().a().a("AIOGalleryVideoView", 4, "initVideo, set playMediaInfo.isMute =  " + paramAIOShortVideoData.jdField_g_of_type_Boolean);
      this.jdField_a_of_type_Agez.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localagfe);
    }
    return true;
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Aptm.d(paramLong);
  }
  
  public void b(agfe paramagfe)
  {
    if (a(paramagfe))
    {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onPlayPause id = " + paramagfe.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Agez.d())
      {
        this.jdField_a_of_type_Aptm.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 6);
        this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
        long l = this.jdField_a_of_type_Agez.a();
        int i = (int)(l / this.jdField_a_of_type_Agez.b() * 10000.0D);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l));
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
        if (this.jdField_a_of_type_Aptm.a(this.jdField_a_of_type_Aptm.a())) {
          this.jdField_a_of_type_Aptm.a(true);
        }
      }
    }
  }
  
  public void b(agfe paramagfe, int paramInt)
  {
    if (a(paramagfe))
    {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onDownloading id = " + paramagfe.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_Agez != null) && (!this.jdField_a_of_type_Agez.c()))
      {
        this.jdField_a_of_type_Aptm.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 1);
        this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    super.b(paramViewGroup);
    this.jdField_a_of_type_Agez = new agfb();
    this.jdField_a_of_type_Agez.a(this.jdField_a_of_type_Aptm.a());
    this.jdField_a_of_type_Agez.a(this);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Aptm.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.a == null)) {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onItemClick data is null，position = " + paramInt);
    }
    do
    {
      do
      {
        return;
      } while (paramAdapterView.a.a() != 2);
      paramView = ((DragGallery)this.jdField_a_of_type_Aptm.a()).a();
      if ((this.jdField_a_of_type_Agez == null) || (paramView == null) || (!this.jdField_a_of_type_Agez.a(paramView))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryVideoView", 0, "onItemClick, play button click.");
      }
    } while (((AIOShortVideoData)paramAdapterView.a).l == 2);
    this.jdField_a_of_type_Agez.f();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryVideoView", 0, "onItemClick, handle immersion.");
    }
    if (this.jdField_a_of_type_Aptm.f())
    {
      if (this.jdField_a_of_type_Aptm.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Aptm.e(false);
        this.jdField_a_of_type_Aptm.jdField_a_of_type_Boolean = false;
        m();
        this.jdField_a_of_type_Aptm.p();
        return;
      }
      this.jdField_a_of_type_Aptm.e(true);
      this.jdField_a_of_type_Aptm.q();
      this.jdField_a_of_type_Aptm.jdField_a_of_type_Boolean = true;
      c(true);
      return;
    }
    this.jdField_a_of_type_Aptm.j();
  }
  
  public void c()
  {
    super.c();
    if ((this.jdField_a_of_type_Agez != null) && (this.jdField_a_of_type_Agez.c())) {
      this.jdField_a_of_type_Agez.f();
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(paramInt)))
    {
      if ((this.jdField_a_of_type_Agez != null) && (this.jdField_a_of_type_Agez.c())) {
        this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(false);
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_Aptm.e(paramLong);
  }
  
  public void c(agfe paramagfe)
  {
    if (a(paramagfe))
    {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onPlayFinish id = " + paramagfe.jdField_a_of_type_Long);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
      this.jdField_a_of_type_Aptm.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 0);
      this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryVideoView.1(this));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doEnterImmersion, isClick = ").append(paramBoolean).append(" ,  isShowingDanmaku =");
      if (this.jdField_a_of_type_Aptm.a() == null) {
        break label96;
      }
    }
    label96:
    for (boolean bool = this.jdField_a_of_type_Aptm.a().b();; bool = false)
    {
      QLog.d("AIOGalleryVideoView", 0, bool);
      super.c(paramBoolean);
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.b(false);
      d(false);
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.d(false);
      return;
    }
    if ((this.jdField_a_of_type_Aptm.a() != null) && (this.jdField_a_of_type_Aptm.a().b()))
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
    this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.t();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Agez != null) {
      this.jdField_a_of_type_Agez.k();
    }
    if (this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void d(agfe paramagfe)
  {
    if (a(paramagfe))
    {
      apsm.a().a().a("AIOGalleryVideoView", 4, "onBuffering id = " + paramagfe.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aptm.a(paramagfe.jdField_a_of_type_Long, paramagfe.jdField_b_of_type_Int, 3);
      this.jdField_a_of_type_Aptm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean d()
  {
    if (super.d())
    {
      Object localObject = this.jdField_a_of_type_Aptm.a();
      if ((localObject != null) && (((apsr)localObject).a != null) && (((apsr)localObject).a.a() == 2))
      {
        localObject = (AIOShortVideoData)((apsr)localObject).a;
        localObject = new aptd().a((AIOShortVideoData)localObject, 1);
        return (localObject != null) && (((File)localObject).exists());
      }
    }
    return false;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryVideoView", 0, "onEnterAnimationEnd");
    }
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
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryVideoView", 0, "onEnterAnimationStart");
    }
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
    long l;
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      Object localObject = this.jdField_a_of_type_Aptm.a();
      if ((localObject == null) || (((apsr)localObject).a == null)) {
        break label161;
      }
      l = ((apsr)localObject).a.jdField_a_of_type_Long;
      if ((!paramBoolean) || (localObject == null) || (((apsr)localObject).a == null) || (!autt.a()) || (!ShortVideoUtils.g())) {
        break label166;
      }
      localObject = (AIOShortVideoData)((apsr)localObject).a;
      if (TextUtils.isEmpty(((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString)) {
        break label166;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_Long != l)
      {
        awqx.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 2, 0, "", "", ((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString, "");
        this.jdField_a_of_type_Long = l;
      }
    }
    label161:
    label166:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      return;
      l = 0L;
      break;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_Aptm.b.clear();
  }
  
  public void j()
  {
    super.j();
    Object localObject = this.jdField_a_of_type_Aptm.a();
    AIOShortVideoData localAIOShortVideoData;
    if ((localObject != null) && (((apsr)localObject).a != null) && (((apsr)localObject).a.a() == 2))
    {
      localAIOShortVideoData = (AIOShortVideoData)((apsr)localObject).a;
      a(d());
      b(a((apsr)localObject));
      g(true);
      apsm.a().a().a("AIOGalleryVideoView", 4, "updateUI id = " + localAIOShortVideoData.jdField_a_of_type_Long + ", status = " + localAIOShortVideoData.l);
    }
    switch (localAIOShortVideoData.l)
    {
    default: 
      apsm.a().a().a("AIOGalleryVideoView", 4, "updateUI status is error, status = " + localAIOShortVideoData.l);
      return;
    case 1: 
      this.jdField_a_of_type_Aptm.a(this.jdField_a_of_type_Aptm.c(), localAIOShortVideoData.m);
      f(false);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agez.a(8, "");
      this.jdField_a_of_type_Agez.b(8);
      a(false);
      return;
    case 2: 
      this.jdField_a_of_type_Aptm.b(this.jdField_a_of_type_Aptm.c(), true);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(ajjy.a(2131634276) + localAIOShortVideoData.m + "%");
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(localAIOShortVideoData.m);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      e(true);
      this.jdField_a_of_type_Agez.a(8, "");
      this.jdField_a_of_type_Agez.b(8);
      a(true);
      return;
    case 4: 
      this.jdField_a_of_type_Aptm.a(this.jdField_a_of_type_Aptm.c(), localAIOShortVideoData.m);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      this.jdField_a_of_type_Agez.a(8, "");
      this.jdField_a_of_type_Agez.b(8);
      a(false);
      return;
    case 3: 
      if (this.jdField_a_of_type_Agez.c()) {
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Aptm.b(this.jdField_a_of_type_Aptm.c(), true);
        f(true);
        e(false);
        this.jdField_a_of_type_Agez.a(8, "");
        a(true);
        return;
        if ((this.jdField_a_of_type_Agez.d()) && (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
      }
    case 5: 
      this.jdField_a_of_type_Aptm.b(this.jdField_a_of_type_Aptm.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agez.a(8, "");
      this.jdField_a_of_type_Agez.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845180);
      a(true);
      return;
    case 6: 
      this.jdField_a_of_type_Aptm.b(this.jdField_a_of_type_Aptm.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agez.a(8, "");
      this.jdField_a_of_type_Agez.b(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845179);
      a(true);
      return;
    case 7: 
      this.jdField_a_of_type_Aptm.b(this.jdField_a_of_type_Aptm.c(), true);
      f(false);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agez.a(0, localAIOShortVideoData.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_Agez.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845179);
      a(false);
      return;
    }
    this.jdField_a_of_type_Aptm.b(this.jdField_a_of_type_Aptm.c(), true);
    f(false);
    e(false);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Agez.a(8, "");
    localObject = this.jdField_a_of_type_Agez;
    if (localAIOShortVideoData.jdField_f_of_type_Boolean) {}
    for (int i = 8;; i = 0)
    {
      ((agez)localObject).b(i);
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
          do
          {
            return;
            if (this.jdField_a_of_type_Agez != null) {
              this.jdField_a_of_type_Agez.f();
            }
            this.jdField_a_of_type_Aptm.m();
            this.jdField_a_of_type_Aptm.q();
            this.jdField_a_of_type_Aptm.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_Aptm.p();
            return;
            paramView = this.jdField_a_of_type_Aptm.a();
          } while ((paramView == null) || (paramView.a == null));
          paramView = (AIOShortVideoData)paramView.a;
          this.jdField_a_of_type_Aptm.c(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 256);
          this.jdField_a_of_type_Aptm.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
          j();
          return;
          s();
          this.jdField_a_of_type_Aptm.o();
          return;
          l();
          return;
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryVideoView", 0, "onClick qq_gallery_danmaku_view ");
          }
          paramView = this.jdField_a_of_type_Aptm.a();
          long l = this.jdField_a_of_type_Agez.a();
          if ((paramView != null) && (paramView.a != null)) {
            MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apsx.a(), this.jdField_a_of_type_Apsx.a(), false, 26, paramView.a.d, l);
          }
          this.jdField_a_of_type_Aptm.r();
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter == null);
        this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.j();
        return;
        paramView = this.jdField_a_of_type_Aptm.a();
      } while ((paramView == null) || (paramView.a == null));
      paramView = (AIOShortVideoData)paramView.a;
    } while (TextUtils.isEmpty(paramView.jdField_g_of_type_JavaLangString));
    bjeg.a(this.jdField_a_of_type_AndroidAppActivity, paramView.jdField_g_of_type_JavaLangString);
    awqx.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 2, 0, "", "", paramView.jdField_g_of_type_JavaLangString, "");
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
      this.jdField_a_of_type_Aptm.n();
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    apsm.a().a().a("AIOGalleryVideoView", 4, "onStopTrackingTouch");
    if (this.jdField_a_of_type_Agez != null)
    {
      this.jdField_a_of_type_Agez.n();
      if ((this.jdField_a_of_type_Aptm.a() != null) && (this.jdField_a_of_type_Aptm.a(this.jdField_a_of_type_Aptm.a())) && (paramSeekBar != null))
      {
        apsm.a().a().a("AIOGalleryVideoView", 4, "seek danmaku");
        this.jdField_a_of_type_Aptm.a().a(paramSeekBar.getProgress());
        apsr localapsr = this.jdField_a_of_type_Aptm.a();
        if ((localapsr != null) && (localapsr.a != null)) {
          this.jdField_a_of_type_Aptm.a().a(this.jdField_a_of_type_Aptm.a(localapsr.a.d, paramSeekBar.getProgress()));
        }
      }
    }
  }
  
  public void p()
  {
    apsm.a().a().a("AIOGalleryVideoView", 4, "onResume");
    if (this.jdField_a_of_type_Agez != null)
    {
      this.jdField_a_of_type_Agez.j();
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Agez.f();
      }
    }
  }
  
  public void q()
  {
    apsm.a().a().a("AIOGalleryVideoView", 4, "onPause");
    if ((this.jdField_a_of_type_Agez != null) && (this.jdField_a_of_type_Agez.c()))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Agez.f();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_Agez != null) && (this.jdField_a_of_type_Agez.a != null) && (this.jdField_a_of_type_Agez.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Agez.c()))
    {
      this.jdField_a_of_type_Agez.d(2);
      Object localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131653682);
      localObject = babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, (String)localObject, 2131628983, 2131655020, new apvt(this), new apvu(this));
      if (this.jdField_a_of_type_Agez != null) {
        this.jdField_a_of_type_Agez.f();
      }
      a((Dialog)localObject);
    }
  }
  
  public void v() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apvq
 * JD-Core Version:    0.7.0.1
 */