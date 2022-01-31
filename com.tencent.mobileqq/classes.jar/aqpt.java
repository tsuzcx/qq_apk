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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import com.tencent.mobileqq.gallery.presenter.AIOGalleryBasePresenter;
import com.tencent.mobileqq.gallery.view.AIOGalleryActivity;
import com.tencent.mobileqq.gallery.view.GalleryUrlImageView;
import com.tencent.mobileqq.gallery.view.video.AIOGalleryVideoView.2;
import com.tencent.mobileqq.gallery.view.video.AIOGalleryVideoView.3;
import com.tencent.mobileqq.gallery.view.video.AIOGalleryVideoView.4;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class aqpt
  extends aqog
  implements agqu, View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public long a;
  public agqv a;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  public aqno a;
  private bcuq jdField_a_of_type_Bcuq;
  final Runnable jdField_a_of_type_JavaLangRunnable = new AIOGalleryVideoView.3(this);
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
  
  public aqpt(Activity paramActivity, aqno paramaqno)
  {
    super(paramActivity, paramaqno);
    this.jdField_b_of_type_JavaLangRunnable = new AIOGalleryVideoView.4(this);
    this.jdField_a_of_type_Aqno = paramaqno;
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    Object localObject1 = new aqmu().a(paramAIOShortVideoData, 1);
    Object localObject2 = this.jdField_a_of_type_Aqno.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    long l;
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      l = ((File)localObject1).length();
      aqmd.a().a().a("AIOGalleryVideoView", 4, "showActionSheetForShortVideo, file.getPath()=" + ((File)localObject1).getPath() + ", mTransferredSize = " + l + ", data.size = " + paramAIOShortVideoData.jdField_c_of_type_Long);
      if (paramAIOShortVideoData.jdField_d_of_type_Int == 1) {
        if ((paramAIOShortVideoData.jdField_d_of_type_Int == 1) && (i != 0)) {
          break label566;
        }
      }
    }
    label566:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        bbjk.a(2, localArrayList1);
      }
      if ((bfnz.d()) && ((paramAIOShortVideoData.jdField_d_of_type_Int != 1) || (i == 0))) {
        bbjk.a(39, localArrayList2);
      }
      if (i == 0)
      {
        bbjk.a(6, localArrayList2);
        bbjk.a(3, localArrayList1);
        bbjk.a(27, localArrayList1);
      }
      if ((this.jdField_a_of_type_Aqmo.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aqmo.c())) && (this.jdField_a_of_type_Aqmo.a() != -1)) {
        bbjk.a(54, localArrayList2);
      }
      if (i == 0) {
        bbjk.a(64, localArrayList2);
      }
      a(paramAIOShortVideoData, (File)localObject1, paramInt, (aqmi)localObject2);
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", " biz_src_jc_video");
      }
      this.jdField_a_of_type_Bcvf.a(localArrayList1, localArrayList2);
      if ((j != 0) && (this.jdField_a_of_type_Aqno.e()))
      {
        paramAIOShortVideoData = this.jdField_a_of_type_Aqno.a(paramAIOShortVideoData.jdField_a_of_type_Long, paramAIOShortVideoData.jdField_a_of_type_Int, this.jdField_a_of_type_Aqmo.a());
        if (paramAIOShortVideoData != null)
        {
          paramAIOShortVideoData.putExtra("NeedReportForwardShortVideo", true);
          if (this.jdField_a_of_type_Aqno.a() != null)
          {
            localObject1 = this.jdField_a_of_type_Aqno.a().a;
            if ((localObject1 instanceof AIOShortVideoData))
            {
              localObject1 = (AIOShortVideoData)localObject1;
              paramInt = ((AIOShortVideoData)localObject1).jdField_g_of_type_Int;
              localObject2 = BaseApplicationImpl.sApplication.getRuntime();
              if ((paramInt == LocalMediaInfo.REDBAG_TYPE_GET) && (((AppRuntime)localObject2).getAccount().equals(((AIOShortVideoData)localObject1).jdField_d_of_type_JavaLangString)))
              {
                paramAIOShortVideoData.putExtra("param_key_redbag_type", paramInt);
                paramAIOShortVideoData.putExtra("param_key_redbag_video_id", ((AIOShortVideoData)localObject1).jdField_c_of_type_JavaLangString);
                paramAIOShortVideoData.putExtra("from_session_uin", ((AIOShortVideoData)localObject1).jdField_e_of_type_JavaLangString);
              }
              if (((AIOShortVideoData)localObject1).k == 2) {
                paramAIOShortVideoData.putExtra("special_video_type", ((AIOShortVideoData)localObject1).k);
              }
              if (!TextUtils.isEmpty(((AIOShortVideoData)localObject1).jdField_g_of_type_JavaLangString)) {
                paramAIOShortVideoData.putExtra("widgetinfo", ((AIOShortVideoData)localObject1).jdField_g_of_type_JavaLangString);
              }
            }
          }
          this.jdField_a_of_type_Bcvf.a(paramAIOShortVideoData);
        }
      }
      this.jdField_a_of_type_Bcvf.a();
      return;
      if (l >= paramAIOShortVideoData.jdField_c_of_type_Long) {
        break;
      }
      i = 1;
      break;
      aqmd.a().a().a("AIOGalleryVideoView", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
      i = 1;
      break;
    }
  }
  
  private boolean a(agra paramagra)
  {
    if (paramagra == null) {}
    aqmi localaqmi;
    do
    {
      return false;
      localaqmi = this.jdField_a_of_type_Aqno.a();
    } while ((localaqmi == null) || (localaqmi.a == null) || (localaqmi.a.jdField_a_of_type_Long != paramagra.jdField_a_of_type_Long));
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      aqmi localaqmi = this.jdField_a_of_type_Aqno.a();
      if ((localaqmi != null) && ((localaqmi.a instanceof AIOShortVideoData)) && (this.jdField_a_of_type_Aqno.a((AIOShortVideoData)localaqmi.a) != null))
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
  
  private void t()
  {
    Object localObject = this.jdField_a_of_type_Aqno.a();
    if ((localObject != null) && (((aqmi)localObject).a != null))
    {
      localObject = (AIOShortVideoData)((aqmi)localObject).a;
      if (!TextUtils.isEmpty(((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString))
      {
        bkvh.a(this.jdField_a_of_type_AndroidAppActivity, ((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString);
        axqy.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 2, 0, "", "", ((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString, "");
      }
    }
  }
  
  private void u()
  {
    Object localObject = this.jdField_a_of_type_Aqno.a();
    long l;
    if ((localObject != null) && (((aqmi)localObject).a != null) && (((aqmi)localObject).a.a() == 2))
    {
      localObject = (AIOShortVideoData)((aqmi)localObject).a;
      if (this.jdField_a_of_type_Bcuq != null) {
        this.jdField_a_of_type_Bcuq.b();
      }
      if (this.jdField_a_of_type_Agqv == null) {
        break label180;
      }
      l = this.jdField_a_of_type_Agqv.a();
      this.jdField_a_of_type_Bcuq = new bcuq(this.jdField_a_of_type_AndroidAppActivity);
      agra localagra = this.jdField_a_of_type_Aqno.a((AIOShortVideoData)localObject);
      if (localagra == null) {
        break label190;
      }
      this.jdField_a_of_type_Bcuq.a(localagra, ((AIOShortVideoData)localObject).jdField_e_of_type_Long, l);
      this.jdField_a_of_type_Bcuq.a(((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject).jdField_e_of_type_Int, ((AIOShortVideoData)localObject).jdField_f_of_type_Int);
      if (((AIOShortVideoData)localObject).jdField_e_of_type_Int <= ((AIOShortVideoData)localObject).jdField_f_of_type_Int) {
        break label185;
      }
    }
    label180:
    label185:
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_Bcuq.a(bool, ((AIOShortVideoData)localObject).jdField_b_of_type_Int)) {
        this.jdField_a_of_type_Aqno.j();
      }
      return;
      l = 0L;
      break;
    }
    label190:
    aqmd.a().a().a("AIOGalleryVideoView", 4, "Failed to floating, videoPlayMedioInfo is null");
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof aqqb))) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    }
    aqmi localaqmi;
    for (paramView = ((aqqb)paramView.getTag()).a;; paramView = (GalleryUrlImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371919))
    {
      a();
      localaqmi = this.jdField_a_of_type_Aqno.a(paramInt);
      if ((localaqmi != null) && (localaqmi.a != null)) {
        break;
      }
      return paramView;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558545, null));
      paramView = new Gallery.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    Object localObject;
    if (localaqmi.a.a() == 2)
    {
      localObject = (AIOShortVideoData)localaqmi.a;
      paramViewGroup = new aqmu();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296400, Boolean.valueOf(true));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296433, Boolean.valueOf(true));
      URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_Aqno.b.get(Integer.valueOf(paramInt));
      if (localURLDrawable == null) {
        break label364;
      }
      paramView.setImageDrawable(localURLDrawable);
      paramViewGroup = "0X8009EF2";
      if (((AIOShortVideoData)localObject).jdField_d_of_type_Int == 1) {
        paramViewGroup = "0X8009EF1";
      }
      paramView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691636));
      localObject = this.jdField_a_of_type_Aqno.b();
      if ((localObject == null) || (((aqmi)localObject).a == null) || (((aqmi)localObject).a.a() != 2) || (((aqmi)localObject).a.jdField_a_of_type_Long != localaqmi.a.jdField_a_of_type_Long) || (((aqmi)localObject).jdField_c_of_type_Boolean)) {
        break label401;
      }
      axqy.b(null, "dc00898", "", "", paramViewGroup, paramViewGroup, 1, 0, "", "", "", "");
      ((aqmi)localObject).jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      paramViewGroup = new aqqb(this);
      paramViewGroup.a = paramView;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      label364:
      if (paramViewGroup.a((AIOShortVideoData)localObject, 0) == null) {
        break;
      }
      this.jdField_a_of_type_Aqno.a(((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject).jdField_e_of_type_Int, ((AIOShortVideoData)localObject).jdField_f_of_type_Int, paramView, paramInt);
      break;
      label401:
      axqy.b(null, "dc00898", "", "", paramViewGroup, paramViewGroup, 2, 0, "", "", "", "");
    }
  }
  
  public View a(int paramInt, aqmi paramaqmi)
  {
    Object localObject;
    if ((paramaqmi != null) && (paramaqmi.a != null) && (paramaqmi.a.a() == 2))
    {
      localObject = (AIOShortVideoData)paramaqmi.a;
      paramaqmi = new aqmu().a((AIOShortVideoData)localObject, 0);
      if (paramaqmi == null) {
        break label127;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywm.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywm.a;
      paramaqmi = URLDrawable.getDrawable(paramaqmi, (URLDrawable.URLDrawableOptions)localObject);
      paramaqmi.startDownload();
      this.jdField_a_of_type_Aqno.b.put(Integer.valueOf(paramInt), paramaqmi);
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onCreateView(): preload thumb, position=" + paramInt);
    }
    for (;;)
    {
      return null;
      label127:
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onCreateView downloadMedia AIOShortVideoData.TYPE_THUMB");
      this.jdField_a_of_type_Aqno.b(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int, 0);
    }
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
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373021));
      this.jdField_c_of_type_AndroidWidgetImageButton.setContentDescription(ajya.a(2131700048));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131378679));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131378681));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131378680));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131364259));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363721));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374698));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373020));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373022));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373028));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363847));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379112);
      if (bkvi.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bkvi.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageButton.getLayoutParams();
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
    aqmi localaqmi = this.jdField_a_of_type_Aqno.a();
    if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 2)) {
      a((AIOShortVideoData)localaqmi.a, paramInt);
    }
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Aqno.b.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, View paramView, aqmi paramaqmi)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof aqqb)))
    {
      paramView = ((aqqb)paramView.getTag()).a;
      paramaqmi = (URLDrawable)this.jdField_a_of_type_Aqno.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (paramaqmi != null)
      {
        paramView.setImageDrawable(paramaqmi);
        aqmd.a().a().a("AIOGalleryVideoView", 4, "onViewDetached(): Use thumb cache replace video.");
      }
    }
    else
    {
      return;
    }
    paramView.setImageDrawable(aywm.a);
    aqmd.a().a().a("AIOGalleryVideoView", 4, "onViewDetached(): No thumb, use TRANSPARENT");
  }
  
  public void a(int paramInt, Object paramObject, aqmi paramaqmi)
  {
    a(bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131718837), this.jdField_a_of_type_AndroidAppActivity.getString(2131718836), new aqqa(this, paramInt, paramObject), new aqpv(this)));
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Aqno.a(paramInt);
    if ((localObject == null) || (((aqmi)localObject).a == null) || (paramView == null)) {
      return;
    }
    if ((paramView.getTag() instanceof aqqb))
    {
      GalleryUrlImageView localGalleryUrlImageView = ((aqqb)paramView.getTag()).a;
      if (((aqmi)localObject).a.a() == 2)
      {
        localObject = (AIOShortVideoData)((aqmi)localObject).a;
        aqmd.a().a().a("AIOGalleryVideoView", 4, "updateView loadShortVideoCover");
        this.jdField_a_of_type_Aqno.a(((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject).jdField_e_of_type_Int, ((AIOShortVideoData)localObject).jdField_f_of_type_Int, localGalleryUrlImageView, paramInt);
      }
    }
    super.a(paramInt, paramString1, paramString2, paramView, paramBoolean);
  }
  
  public void a(int paramInt1, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    aqmd.a().a().a("AIOGalleryVideoView", 4, "setShortVideoDrawableWithUrls position = " + paramInt1);
    aqmi localaqmi = this.jdField_a_of_type_Aqno.a(paramInt1);
    if ((localaqmi == null) || (localaqmi.a == null)) {}
    while (localaqmi.a.a() != 2) {
      return;
    }
    paramString1 = (AIOShortVideoData)localaqmi.a;
    aqny.a().a(localaqmi.a.jdField_a_of_type_Long, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt2, paramString2);
    paramString2 = new agra();
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
      aqmd.a().a().a("AIOGalleryVideoView", 4, "setShortVideoDrawableWithUrls, set playMediaInfo.isMute =  " + paramString2.e);
      this.jdField_a_of_type_Agqv.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramString2);
      if (!this.jdField_a_of_type_Aqno.a(paramString1.jdField_a_of_type_Long)) {
        break label327;
      }
      this.jdField_a_of_type_Agqv.f();
    }
    for (;;)
    {
      if (new aqmu().a(paramString1, 0) == null)
      {
        aqmd.a().a().a("AIOGalleryVideoView", 4, "setShortVideoDrawableWithUrls, get thumb");
        this.jdField_a_of_type_Aqno.b(paramString1.jdField_a_of_type_Long, paramString1.jdField_a_of_type_Int, 0);
      }
      j();
      return;
      paramString2.d = 0L;
      break;
      label327:
      this.jdField_a_of_type_Aqno.a(paramString1.jdField_a_of_type_Long, paramString1.jdField_a_of_type_Int, 0);
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    Object localObject = this.jdField_a_of_type_Aqno.a();
    if ((localObject == null) || (((aqmi)localObject).a == null) || (((aqmi)localObject).a.a() != 2))
    {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg exp!");
      return;
    }
    int i = this.jdField_a_of_type_Aqno.a(((aqmi)localObject).a.jdField_a_of_type_Long, ((aqmi)localObject).a.jdField_a_of_type_Int);
    if ((i >= 0) && (i < 100)) {}
    for (boolean bool = true;; bool = false)
    {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg isSaving:" + bool);
      localObject = (AIOShortVideoData)((aqmi)localObject).a;
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg BUSI_TYPE_VIDEO");
      if (bool)
      {
        aqmd.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg cancelDownloadMedia");
        this.jdField_a_of_type_Aqno.c(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int, 256);
      }
      if ((this.jdField_a_of_type_Agqv == null) || (!this.jdField_a_of_type_Agqv.c())) {
        break;
      }
      this.jdField_a_of_type_Agqv.h();
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Aqno.a(paramLong, paramInt1, paramInt2, paramString1);
    a(this.jdField_a_of_type_Aqno.c(), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(agra paramagra)
  {
    if (a(paramagra))
    {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onPlayStart id = " + paramagra.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqno.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 5);
      this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      if (this.jdField_a_of_type_Aqno.a(this.jdField_a_of_type_Aqno.a()))
      {
        this.jdField_a_of_type_Aqno.a();
        aqmi localaqmi = this.jdField_a_of_type_Aqno.a();
        if ((localaqmi != null) && (localaqmi.a != null) && (this.jdField_a_of_type_Aqno.a() != null) && (this.jdField_a_of_type_Agqv != null)) {
          this.jdField_a_of_type_Aqno.a().a(this.jdField_a_of_type_Aqno.a(localaqmi.a.d, this.jdField_a_of_type_Agqv.a()));
        }
      }
    }
    if (paramagra != null)
    {
      b(paramagra.jdField_a_of_type_Long);
      c(paramagra.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Aqno.a(0L, 0L, this.jdField_a_of_type_Aqno.a().c());
  }
  
  public void a(agra paramagra, int paramInt)
  {
    if (a(paramagra))
    {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onEndBuffering id = " + paramagra.jdField_a_of_type_Long);
      if (!this.jdField_a_of_type_Agqv.c()) {
        break label87;
      }
      this.jdField_a_of_type_Aqno.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 5);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label87:
      if (this.jdField_a_of_type_Agqv.d()) {
        this.jdField_a_of_type_Aqno.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 6);
      }
    }
  }
  
  public void a(agra paramagra, int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramagra))
    {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onError id = " + paramagra.jdField_a_of_type_Long);
      aqmi localaqmi = this.jdField_a_of_type_Aqno.a();
      if ((localaqmi != null) && (localaqmi.a != null) && (localaqmi.a.a() == 2))
      {
        this.jdField_a_of_type_Aqno.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 7);
        ((AIOShortVideoData)localaqmi.a).jdField_f_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void a(agra paramagra, long paramLong)
  {
    if (a(paramagra))
    {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onDurationReady id = " + paramagra.jdField_a_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
    }
  }
  
  public void a(agra paramagra, boolean paramBoolean)
  {
    if ((paramBoolean) && (a(paramagra)))
    {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onGetUrl id = " + paramagra.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqno.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 4);
      this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
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
  
  public void a(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, aqmi paramaqmi)
  {
    this.jdField_a_of_type_Bcvf.a(new aqpw(this, paramAIOShortVideoData, paramFile, paramInt, paramaqmi));
    this.jdField_a_of_type_Bcvf.a(new aqpx(this));
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = this.jdField_a_of_type_Aqno.a(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.a != null) && (paramAdapterView.a.a() == 2))
    {
      paramView = (AIOShortVideoData)paramAdapterView.a;
      this.jdField_a_of_type_Aqno.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
      if ((a(paramView)) && (this.jdField_a_of_type_Aqno.a(paramAdapterView.a.jdField_a_of_type_Long))) {
        this.jdField_a_of_type_Agqv.f();
      }
    }
    j();
  }
  
  public boolean a(AIOShortVideoData paramAIOShortVideoData)
  {
    agra localagra = this.jdField_a_of_type_Aqno.a(paramAIOShortVideoData);
    if (localagra == null)
    {
      this.jdField_a_of_type_Aqno.b(paramAIOShortVideoData);
      aqmd.a().a().a("AIOGalleryVideoView", 4, "initVideo handleUnDownloadVideo");
      return false;
    }
    if (this.jdField_a_of_type_Agqv != null)
    {
      localagra.e = paramAIOShortVideoData.jdField_g_of_type_Boolean;
      aqmd.a().a().a("AIOGalleryVideoView", 4, "initVideo, set playMediaInfo.isMute =  " + paramAIOShortVideoData.jdField_g_of_type_Boolean);
      this.jdField_a_of_type_Agqv.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localagra);
    }
    return true;
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Aqno.d(paramLong);
  }
  
  public void b(agra paramagra)
  {
    if (a(paramagra))
    {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onPlayPause id = " + paramagra.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Agqv.d())
      {
        this.jdField_a_of_type_Aqno.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 6);
        this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
        long l = this.jdField_a_of_type_Agqv.a();
        int i = (int)(l / this.jdField_a_of_type_Agqv.b() * 10000.0D);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l));
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
        if (this.jdField_a_of_type_Aqno.a(this.jdField_a_of_type_Aqno.a())) {
          this.jdField_a_of_type_Aqno.a(true);
        }
      }
    }
  }
  
  public void b(agra paramagra, int paramInt)
  {
    if (a(paramagra))
    {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onDownloading id = " + paramagra.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_Agqv != null) && (!this.jdField_a_of_type_Agqv.c()))
      {
        this.jdField_a_of_type_Aqno.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 1);
        this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    super.b(paramViewGroup);
    this.jdField_a_of_type_Agqv = new agqx();
    this.jdField_a_of_type_Agqv.a(this.jdField_a_of_type_Aqno.a());
    this.jdField_a_of_type_Agqv.a(this);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Aqno.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.a == null)) {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onItemClick data is null，position = " + paramInt);
    }
    do
    {
      do
      {
        return;
      } while (paramAdapterView.a.a() != 2);
      paramView = ((DragGallery)this.jdField_a_of_type_Aqno.a()).a();
      if ((this.jdField_a_of_type_Agqv == null) || (paramView == null) || (!this.jdField_a_of_type_Agqv.a(paramView))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryVideoView", 0, "onItemClick, play button click.");
      }
    } while (((AIOShortVideoData)paramAdapterView.a).l == 2);
    this.jdField_a_of_type_Agqv.f();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryVideoView", 0, "onItemClick, handle immersion.");
    }
    if (this.jdField_a_of_type_Aqno.f())
    {
      if (this.jdField_a_of_type_Aqno.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Aqno.e(false);
        this.jdField_a_of_type_Aqno.jdField_a_of_type_Boolean = false;
        m();
        this.jdField_a_of_type_Aqno.p();
        return;
      }
      this.jdField_a_of_type_Aqno.e(true);
      this.jdField_a_of_type_Aqno.q();
      this.jdField_a_of_type_Aqno.jdField_a_of_type_Boolean = true;
      c(true);
      return;
    }
    this.jdField_a_of_type_Aqno.j();
  }
  
  public void c()
  {
    super.c();
    if ((this.jdField_a_of_type_Agqv != null) && (this.jdField_a_of_type_Agqv.c())) {
      this.jdField_a_of_type_Agqv.f();
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(paramInt)))
    {
      if ((this.jdField_a_of_type_Agqv != null) && (this.jdField_a_of_type_Agqv.c())) {
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
    this.jdField_a_of_type_Aqno.e(paramLong);
  }
  
  public void c(agra paramagra)
  {
    if (a(paramagra))
    {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onPlayFinish id = " + paramagra.jdField_a_of_type_Long);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
      this.jdField_a_of_type_Aqno.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 0);
      this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryVideoView.2(this));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("doEnterImmersion, isClick = ").append(paramBoolean).append(" ,  isShowingDanmaku =");
      if (this.jdField_a_of_type_Aqno.a() == null) {
        break label96;
      }
    }
    label96:
    for (boolean bool = this.jdField_a_of_type_Aqno.a().b();; bool = false)
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
    if ((this.jdField_a_of_type_Aqno.a() != null) && (this.jdField_a_of_type_Aqno.a().b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.jdField_a_of_type_Boolean = false;
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
    if (this.jdField_a_of_type_Agqv != null) {
      this.jdField_a_of_type_Agqv.k();
    }
    if (this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void d(agra paramagra)
  {
    if (a(paramagra))
    {
      aqmd.a().a().a("AIOGalleryVideoView", 4, "onBuffering id = " + paramagra.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqno.a(paramagra.jdField_a_of_type_Long, paramagra.jdField_b_of_type_Int, 3);
      this.jdField_a_of_type_Aqno.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean d()
  {
    if (super.d())
    {
      Object localObject = this.jdField_a_of_type_Aqno.a();
      if ((localObject != null) && (((aqmi)localObject).a != null) && (((aqmi)localObject).a.a() == 2))
      {
        localObject = (AIOShortVideoData)((aqmi)localObject).a;
        localObject = new aqmu().a((AIOShortVideoData)localObject, 1);
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
      Object localObject = this.jdField_a_of_type_Aqno.a();
      if ((localObject == null) || (((aqmi)localObject).a == null)) {
        break label161;
      }
      l = ((aqmi)localObject).a.jdField_a_of_type_Long;
      if ((!paramBoolean) || (localObject == null) || (((aqmi)localObject).a == null) || (!avte.a()) || (!ShortVideoUtils.g())) {
        break label166;
      }
      localObject = (AIOShortVideoData)((aqmi)localObject).a;
      if (TextUtils.isEmpty(((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString)) {
        break label166;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_Long != l)
      {
        axqy.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 2, 0, "", "", ((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString, "");
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
    this.jdField_a_of_type_Aqno.b.clear();
  }
  
  public void j()
  {
    super.j();
    Object localObject = this.jdField_a_of_type_Aqno.a();
    AIOShortVideoData localAIOShortVideoData;
    if ((localObject != null) && (((aqmi)localObject).a != null) && (((aqmi)localObject).a.a() == 2))
    {
      localAIOShortVideoData = (AIOShortVideoData)((aqmi)localObject).a;
      a(d());
      b(a((aqmi)localObject));
      g(true);
      aqmd.a().a().a("AIOGalleryVideoView", 4, "updateUI id = " + localAIOShortVideoData.jdField_a_of_type_Long + ", status = " + localAIOShortVideoData.l);
    }
    switch (localAIOShortVideoData.l)
    {
    default: 
      aqmd.a().a().a("AIOGalleryVideoView", 4, "updateUI status is error, status = " + localAIOShortVideoData.l);
      return;
    case 1: 
      this.jdField_a_of_type_Aqno.a(this.jdField_a_of_type_Aqno.c(), localAIOShortVideoData.m);
      f(false);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqv.a(8, "");
      this.jdField_a_of_type_Agqv.b(8);
      a(false);
      return;
    case 2: 
      this.jdField_a_of_type_Aqno.b(this.jdField_a_of_type_Aqno.c(), true);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(ajya.a(2131700075) + localAIOShortVideoData.m + "%");
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(localAIOShortVideoData.m);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      e(true);
      this.jdField_a_of_type_Agqv.a(8, "");
      this.jdField_a_of_type_Agqv.b(8);
      a(true);
      return;
    case 4: 
      this.jdField_a_of_type_Aqno.a(this.jdField_a_of_type_Aqno.c(), localAIOShortVideoData.m);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      this.jdField_a_of_type_Agqv.a(8, "");
      this.jdField_a_of_type_Agqv.b(8);
      a(false);
      return;
    case 3: 
      if (this.jdField_a_of_type_Agqv.c()) {
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Aqno.b(this.jdField_a_of_type_Aqno.c(), true);
        f(true);
        e(false);
        this.jdField_a_of_type_Agqv.a(8, "");
        a(true);
        return;
        if ((this.jdField_a_of_type_Agqv.d()) && (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
      }
    case 5: 
      this.jdField_a_of_type_Aqno.b(this.jdField_a_of_type_Aqno.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqv.a(8, "");
      this.jdField_a_of_type_Agqv.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845268);
      a(true);
      return;
    case 6: 
      this.jdField_a_of_type_Aqno.b(this.jdField_a_of_type_Aqno.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqv.a(8, "");
      this.jdField_a_of_type_Agqv.b(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845267);
      a(true);
      return;
    case 7: 
      this.jdField_a_of_type_Aqno.b(this.jdField_a_of_type_Aqno.c(), true);
      f(false);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqv.a(0, localAIOShortVideoData.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_Agqv.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845267);
      a(false);
      return;
    }
    this.jdField_a_of_type_Aqno.b(this.jdField_a_of_type_Aqno.c(), true);
    f(false);
    e(false);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Agqv.a(8, "");
    localObject = this.jdField_a_of_type_Agqv;
    if (localAIOShortVideoData.jdField_f_of_type_Boolean) {}
    for (int i = 8;; i = 0)
    {
      ((agqv)localObject).b(i);
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
    default: 
    case 2131371129: 
    case 2131364259: 
    case 2131373021: 
    case 2131373022: 
    case 2131373020: 
    case 2131373028: 
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Agqv != null) {
            this.jdField_a_of_type_Agqv.f();
          }
          this.jdField_a_of_type_Aqno.m();
          this.jdField_a_of_type_Aqno.q();
          this.jdField_a_of_type_Aqno.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Aqno.p();
          return;
          paramView = this.jdField_a_of_type_Aqno.a();
        } while ((paramView == null) || (paramView.a == null));
        paramView = (AIOShortVideoData)paramView.a;
        this.jdField_a_of_type_Aqno.c(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 256);
        this.jdField_a_of_type_Aqno.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
        j();
        return;
        u();
        this.jdField_a_of_type_Aqno.o();
        return;
        l();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryVideoView", 0, "onClick qq_gallery_danmaku_view ");
        }
        paramView = this.jdField_a_of_type_Aqno.a();
        long l = this.jdField_a_of_type_Agqv.a();
        if ((paramView != null) && (paramView.a != null)) {
          MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqmo.a(), this.jdField_a_of_type_Aqmo.a(), false, 26, paramView.a.d, l);
        }
        this.jdField_a_of_type_Aqno.r();
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter == null);
      this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.j();
      return;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AIOGalleryActivity))
    {
      paramView = (AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (!akwf.a(this.jdField_a_of_type_AndroidAppActivity))
        {
          paramView.requestPermissions(new aqpu(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          return;
        }
        t();
        return;
      }
      t();
      return;
    }
    aqmd.a().a().a("AIOGalleryVideoView", 2, "onClick, activity:" + this.jdField_a_of_type_AndroidAppActivity);
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
      this.jdField_a_of_type_Aqno.n();
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    aqmd.a().a().a("AIOGalleryVideoView", 4, "onStopTrackingTouch");
    if (this.jdField_a_of_type_Agqv != null)
    {
      this.jdField_a_of_type_Agqv.n();
      if ((this.jdField_a_of_type_Aqno.a() != null) && (this.jdField_a_of_type_Aqno.a(this.jdField_a_of_type_Aqno.a())) && (paramSeekBar != null))
      {
        aqmd.a().a().a("AIOGalleryVideoView", 4, "seek danmaku");
        this.jdField_a_of_type_Aqno.a().a(paramSeekBar.getProgress());
        aqmi localaqmi = this.jdField_a_of_type_Aqno.a();
        if ((localaqmi != null) && (localaqmi.a != null)) {
          this.jdField_a_of_type_Aqno.a().a(this.jdField_a_of_type_Aqno.a(localaqmi.a.d, paramSeekBar.getProgress()));
        }
      }
    }
  }
  
  public void q()
  {
    aqmd.a().a().a("AIOGalleryVideoView", 4, "onResume");
    if (this.jdField_a_of_type_Agqv != null)
    {
      this.jdField_a_of_type_Agqv.j();
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Agqv.f();
      }
    }
  }
  
  public void r()
  {
    aqmd.a().a().a("AIOGalleryVideoView", 4, "onPause");
    if ((this.jdField_a_of_type_Agqv != null) && (this.jdField_a_of_type_Agqv.c()))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Agqv.f();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_Agqv != null) && (this.jdField_a_of_type_Agqv.a != null) && (this.jdField_a_of_type_Agqv.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Agqv.c()))
    {
      this.jdField_a_of_type_Agqv.d(2);
      Object localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719577);
      localObject = bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, (String)localObject, 2131694648, 2131720929, new aqpy(this), new aqpz(this));
      if (this.jdField_a_of_type_Agqv != null) {
        this.jdField_a_of_type_Agqv.f();
      }
      a((Dialog)localObject);
    }
  }
  
  public void v() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpt
 * JD-Core Version:    0.7.0.1
 */