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

public class aqpr
  extends aqoe
  implements agqw, View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public long a;
  public agqx a;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  public aqnm a;
  private bcub jdField_a_of_type_Bcub;
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
  
  public aqpr(Activity paramActivity, aqnm paramaqnm)
  {
    super(paramActivity, paramaqnm);
    this.jdField_b_of_type_JavaLangRunnable = new AIOGalleryVideoView.4(this);
    this.jdField_a_of_type_Aqnm = paramaqnm;
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    Object localObject1 = new aqms().a(paramAIOShortVideoData, 1);
    Object localObject2 = this.jdField_a_of_type_Aqnm.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    long l;
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      l = ((File)localObject1).length();
      aqmb.a().a().a("AIOGalleryVideoView", 4, "showActionSheetForShortVideo, file.getPath()=" + ((File)localObject1).getPath() + ", mTransferredSize = " + l + ", data.size = " + paramAIOShortVideoData.jdField_c_of_type_Long);
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
        bbiw.a(2, localArrayList1);
      }
      if ((bfni.d()) && ((paramAIOShortVideoData.jdField_d_of_type_Int != 1) || (i == 0))) {
        bbiw.a(39, localArrayList2);
      }
      if (i == 0)
      {
        bbiw.a(6, localArrayList2);
        bbiw.a(3, localArrayList1);
        bbiw.a(27, localArrayList1);
      }
      if ((this.jdField_a_of_type_Aqmm.g()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aqmm.c())) && (this.jdField_a_of_type_Aqmm.a() != -1)) {
        bbiw.a(54, localArrayList2);
      }
      if (i == 0) {
        bbiw.a(64, localArrayList2);
      }
      a(paramAIOShortVideoData, (File)localObject1, paramInt, (aqmg)localObject2);
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", " biz_src_jc_video");
      }
      this.jdField_a_of_type_Bcuq.a(localArrayList1, localArrayList2);
      if ((j != 0) && (this.jdField_a_of_type_Aqnm.e()))
      {
        paramAIOShortVideoData = this.jdField_a_of_type_Aqnm.a(paramAIOShortVideoData.jdField_a_of_type_Long, paramAIOShortVideoData.jdField_a_of_type_Int, this.jdField_a_of_type_Aqmm.a());
        if (paramAIOShortVideoData != null)
        {
          paramAIOShortVideoData.putExtra("NeedReportForwardShortVideo", true);
          if (this.jdField_a_of_type_Aqnm.a() != null)
          {
            localObject1 = this.jdField_a_of_type_Aqnm.a().a;
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
          this.jdField_a_of_type_Bcuq.a(paramAIOShortVideoData);
        }
      }
      this.jdField_a_of_type_Bcuq.a();
      return;
      if (l >= paramAIOShortVideoData.jdField_c_of_type_Long) {
        break;
      }
      i = 1;
      break;
      aqmb.a().a().a("AIOGalleryVideoView", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
      i = 1;
      break;
    }
  }
  
  private boolean a(agrc paramagrc)
  {
    if (paramagrc == null) {}
    aqmg localaqmg;
    do
    {
      return false;
      localaqmg = this.jdField_a_of_type_Aqnm.a();
    } while ((localaqmg == null) || (localaqmg.a == null) || (localaqmg.a.jdField_a_of_type_Long != paramagrc.jdField_a_of_type_Long));
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      aqmg localaqmg = this.jdField_a_of_type_Aqnm.a();
      if ((localaqmg != null) && ((localaqmg.a instanceof AIOShortVideoData)) && (this.jdField_a_of_type_Aqnm.a((AIOShortVideoData)localaqmg.a) != null))
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
    Object localObject = this.jdField_a_of_type_Aqnm.a();
    if ((localObject != null) && (((aqmg)localObject).a != null))
    {
      localObject = (AIOShortVideoData)((aqmg)localObject).a;
      if (!TextUtils.isEmpty(((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString))
      {
        bkuq.a(this.jdField_a_of_type_AndroidAppActivity, ((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString);
        axqw.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 2, 0, "", "", ((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString, "");
      }
    }
  }
  
  private void u()
  {
    Object localObject = this.jdField_a_of_type_Aqnm.a();
    long l;
    if ((localObject != null) && (((aqmg)localObject).a != null) && (((aqmg)localObject).a.a() == 2))
    {
      localObject = (AIOShortVideoData)((aqmg)localObject).a;
      if (this.jdField_a_of_type_Bcub != null) {
        this.jdField_a_of_type_Bcub.b();
      }
      if (this.jdField_a_of_type_Agqx == null) {
        break label180;
      }
      l = this.jdField_a_of_type_Agqx.a();
      this.jdField_a_of_type_Bcub = new bcub(this.jdField_a_of_type_AndroidAppActivity);
      agrc localagrc = this.jdField_a_of_type_Aqnm.a((AIOShortVideoData)localObject);
      if (localagrc == null) {
        break label190;
      }
      this.jdField_a_of_type_Bcub.a(localagrc, ((AIOShortVideoData)localObject).jdField_e_of_type_Long, l);
      this.jdField_a_of_type_Bcub.a(((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject).jdField_e_of_type_Int, ((AIOShortVideoData)localObject).jdField_f_of_type_Int);
      if (((AIOShortVideoData)localObject).jdField_e_of_type_Int <= ((AIOShortVideoData)localObject).jdField_f_of_type_Int) {
        break label185;
      }
    }
    label180:
    label185:
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_Bcub.a(bool, ((AIOShortVideoData)localObject).jdField_b_of_type_Int)) {
        this.jdField_a_of_type_Aqnm.j();
      }
      return;
      l = 0L;
      break;
    }
    label190:
    aqmb.a().a().a("AIOGalleryVideoView", 4, "Failed to floating, videoPlayMedioInfo is null");
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof aqpz))) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    }
    aqmg localaqmg;
    for (paramView = ((aqpz)paramView.getTag()).a;; paramView = (GalleryUrlImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371919))
    {
      a();
      localaqmg = this.jdField_a_of_type_Aqnm.a(paramInt);
      if ((localaqmg != null) && (localaqmg.a != null)) {
        break;
      }
      return paramView;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131558545, null));
      paramView = new Gallery.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
    }
    Object localObject;
    if (localaqmg.a.a() == 2)
    {
      localObject = (AIOShortVideoData)localaqmg.a;
      paramViewGroup = new aqms();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296400, Boolean.valueOf(true));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(2131296433, Boolean.valueOf(true));
      URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_Aqnm.b.get(Integer.valueOf(paramInt));
      if (localURLDrawable == null) {
        break label364;
      }
      paramView.setImageDrawable(localURLDrawable);
      paramViewGroup = "0X8009EF2";
      if (((AIOShortVideoData)localObject).jdField_d_of_type_Int == 1) {
        paramViewGroup = "0X8009EF1";
      }
      paramView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691636));
      localObject = this.jdField_a_of_type_Aqnm.b();
      if ((localObject == null) || (((aqmg)localObject).a == null) || (((aqmg)localObject).a.a() != 2) || (((aqmg)localObject).a.jdField_a_of_type_Long != localaqmg.a.jdField_a_of_type_Long) || (((aqmg)localObject).jdField_c_of_type_Boolean)) {
        break label401;
      }
      axqw.b(null, "dc00898", "", "", paramViewGroup, paramViewGroup, 1, 0, "", "", "", "");
      ((aqmg)localObject).jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      paramViewGroup = new aqpz(this);
      paramViewGroup.a = paramView;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
      return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      label364:
      if (paramViewGroup.a((AIOShortVideoData)localObject, 0) == null) {
        break;
      }
      this.jdField_a_of_type_Aqnm.a(((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject).jdField_e_of_type_Int, ((AIOShortVideoData)localObject).jdField_f_of_type_Int, paramView, paramInt);
      break;
      label401:
      axqw.b(null, "dc00898", "", "", paramViewGroup, paramViewGroup, 2, 0, "", "", "", "");
    }
  }
  
  public View a(int paramInt, aqmg paramaqmg)
  {
    Object localObject;
    if ((paramaqmg != null) && (paramaqmg.a != null) && (paramaqmg.a.a() == 2))
    {
      localObject = (AIOShortVideoData)paramaqmg.a;
      paramaqmg = new aqms().a((AIOShortVideoData)localObject, 0);
      if (paramaqmg == null) {
        break label127;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywk.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywk.a;
      paramaqmg = URLDrawable.getDrawable(paramaqmg, (URLDrawable.URLDrawableOptions)localObject);
      paramaqmg.startDownload();
      this.jdField_a_of_type_Aqnm.b.put(Integer.valueOf(paramInt), paramaqmg);
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onCreateView(): preload thumb, position=" + paramInt);
    }
    for (;;)
    {
      return null;
      label127:
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onCreateView downloadMedia AIOShortVideoData.TYPE_THUMB");
      this.jdField_a_of_type_Aqnm.b(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int, 0);
    }
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
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373019));
      this.jdField_c_of_type_AndroidWidgetImageButton.setContentDescription(ajyc.a(2131700037));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131378674));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131378676));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131378675));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131364260));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363722));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374696));
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373018));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373020));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373026));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363848));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379107);
      if (bkur.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bkur.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageButton.getLayoutParams();
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
    aqmg localaqmg = this.jdField_a_of_type_Aqnm.a();
    if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 2)) {
      a((AIOShortVideoData)localaqmg.a, paramInt);
    }
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Aqnm.b.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, View paramView, aqmg paramaqmg)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof aqpz)))
    {
      paramView = ((aqpz)paramView.getTag()).a;
      paramaqmg = (URLDrawable)this.jdField_a_of_type_Aqnm.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (paramaqmg != null)
      {
        paramView.setImageDrawable(paramaqmg);
        aqmb.a().a().a("AIOGalleryVideoView", 4, "onViewDetached(): Use thumb cache replace video.");
      }
    }
    else
    {
      return;
    }
    paramView.setImageDrawable(aywk.a);
    aqmb.a().a().a("AIOGalleryVideoView", 4, "onViewDetached(): No thumb, use TRANSPARENT");
  }
  
  public void a(int paramInt, Object paramObject, aqmg paramaqmg)
  {
    a(bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131718826), this.jdField_a_of_type_AndroidAppActivity.getString(2131718825), new aqpy(this, paramInt, paramObject), new aqpt(this)));
  }
  
  public void a(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Aqnm.a(paramInt);
    if ((localObject == null) || (((aqmg)localObject).a == null) || (paramView == null)) {
      return;
    }
    if ((paramView.getTag() instanceof aqpz))
    {
      GalleryUrlImageView localGalleryUrlImageView = ((aqpz)paramView.getTag()).a;
      if (((aqmg)localObject).a.a() == 2)
      {
        localObject = (AIOShortVideoData)((aqmg)localObject).a;
        aqmb.a().a().a("AIOGalleryVideoView", 4, "updateView loadShortVideoCover");
        this.jdField_a_of_type_Aqnm.a(((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject).jdField_e_of_type_Int, ((AIOShortVideoData)localObject).jdField_f_of_type_Int, localGalleryUrlImageView, paramInt);
      }
    }
    super.a(paramInt, paramString1, paramString2, paramView, paramBoolean);
  }
  
  public void a(int paramInt1, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    aqmb.a().a().a("AIOGalleryVideoView", 4, "setShortVideoDrawableWithUrls position = " + paramInt1);
    aqmg localaqmg = this.jdField_a_of_type_Aqnm.a(paramInt1);
    if ((localaqmg == null) || (localaqmg.a == null)) {}
    while (localaqmg.a.a() != 2) {
      return;
    }
    paramString1 = (AIOShortVideoData)localaqmg.a;
    aqnw.a().a(localaqmg.a.jdField_a_of_type_Long, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt2, paramString2);
    paramString2 = new agrc();
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
      aqmb.a().a().a("AIOGalleryVideoView", 4, "setShortVideoDrawableWithUrls, set playMediaInfo.isMute =  " + paramString2.e);
      this.jdField_a_of_type_Agqx.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramString2);
      if (!this.jdField_a_of_type_Aqnm.a(paramString1.jdField_a_of_type_Long)) {
        break label327;
      }
      this.jdField_a_of_type_Agqx.f();
    }
    for (;;)
    {
      if (new aqms().a(paramString1, 0) == null)
      {
        aqmb.a().a().a("AIOGalleryVideoView", 4, "setShortVideoDrawableWithUrls, get thumb");
        this.jdField_a_of_type_Aqnm.b(paramString1.jdField_a_of_type_Long, paramString1.jdField_a_of_type_Int, 0);
      }
      j();
      return;
      paramString2.d = 0L;
      break;
      label327:
      this.jdField_a_of_type_Aqnm.a(paramString1.jdField_a_of_type_Long, paramString1.jdField_a_of_type_Int, 0);
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    Object localObject = this.jdField_a_of_type_Aqnm.a();
    if ((localObject == null) || (((aqmg)localObject).a == null) || (((aqmg)localObject).a.a() != 2))
    {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg exp!");
      return;
    }
    int i = this.jdField_a_of_type_Aqnm.a(((aqmg)localObject).a.jdField_a_of_type_Long, ((aqmg)localObject).a.jdField_a_of_type_Int);
    if ((i >= 0) && (i < 100)) {}
    for (boolean bool = true;; bool = false)
    {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg isSaving:" + bool);
      localObject = (AIOShortVideoData)((aqmg)localObject).a;
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg BUSI_TYPE_VIDEO");
      if (bool)
      {
        aqmb.a().a().a("AIOGalleryVideoView", 4, "onRevokeMsg cancelDownloadMedia");
        this.jdField_a_of_type_Aqnm.c(((AIOShortVideoData)localObject).jdField_a_of_type_Long, ((AIOShortVideoData)localObject).jdField_a_of_type_Int, 256);
      }
      if ((this.jdField_a_of_type_Agqx == null) || (!this.jdField_a_of_type_Agqx.c())) {
        break;
      }
      this.jdField_a_of_type_Agqx.h();
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    this.jdField_a_of_type_Aqnm.a(paramLong, paramInt1, paramInt2, paramString1);
    a(this.jdField_a_of_type_Aqnm.c(), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
  }
  
  public void a(agrc paramagrc)
  {
    if (a(paramagrc))
    {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onPlayStart id = " + paramagrc.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqnm.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 5);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      if (this.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Aqnm.a()))
      {
        this.jdField_a_of_type_Aqnm.a();
        aqmg localaqmg = this.jdField_a_of_type_Aqnm.a();
        if ((localaqmg != null) && (localaqmg.a != null) && (this.jdField_a_of_type_Aqnm.a() != null) && (this.jdField_a_of_type_Agqx != null)) {
          this.jdField_a_of_type_Aqnm.a().a(this.jdField_a_of_type_Aqnm.a(localaqmg.a.d, this.jdField_a_of_type_Agqx.a()));
        }
      }
    }
    if (paramagrc != null)
    {
      b(paramagrc.jdField_a_of_type_Long);
      c(paramagrc.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Aqnm.a(0L, 0L, this.jdField_a_of_type_Aqnm.a().c());
  }
  
  public void a(agrc paramagrc, int paramInt)
  {
    if (a(paramagrc))
    {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onEndBuffering id = " + paramagrc.jdField_a_of_type_Long);
      if (!this.jdField_a_of_type_Agqx.c()) {
        break label87;
      }
      this.jdField_a_of_type_Aqnm.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 5);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
      label87:
      if (this.jdField_a_of_type_Agqx.d()) {
        this.jdField_a_of_type_Aqnm.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 6);
      }
    }
  }
  
  public void a(agrc paramagrc, int paramInt1, int paramInt2, String paramString)
  {
    if (a(paramagrc))
    {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onError id = " + paramagrc.jdField_a_of_type_Long);
      aqmg localaqmg = this.jdField_a_of_type_Aqnm.a();
      if ((localaqmg != null) && (localaqmg.a != null) && (localaqmg.a.a() == 2))
      {
        this.jdField_a_of_type_Aqnm.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 7);
        ((AIOShortVideoData)localaqmg.a).jdField_f_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void a(agrc paramagrc, long paramLong)
  {
    if (a(paramagrc))
    {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onDurationReady id = " + paramagrc.jdField_a_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
    }
  }
  
  public void a(agrc paramagrc, boolean paramBoolean)
  {
    if ((paramBoolean) && (a(paramagrc)))
    {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onGetUrl id = " + paramagrc.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqnm.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 4);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
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
  
  public void a(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, aqmg paramaqmg)
  {
    this.jdField_a_of_type_Bcuq.a(new aqpu(this, paramAIOShortVideoData, paramFile, paramInt, paramaqmg));
    this.jdField_a_of_type_Bcuq.a(new aqpv(this));
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.a(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = this.jdField_a_of_type_Aqnm.a(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.a != null) && (paramAdapterView.a.a() == 2))
    {
      paramView = (AIOShortVideoData)paramAdapterView.a;
      this.jdField_a_of_type_Aqnm.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
      if ((a(paramView)) && (this.jdField_a_of_type_Aqnm.a(paramAdapterView.a.jdField_a_of_type_Long))) {
        this.jdField_a_of_type_Agqx.f();
      }
    }
    j();
  }
  
  public boolean a(AIOShortVideoData paramAIOShortVideoData)
  {
    agrc localagrc = this.jdField_a_of_type_Aqnm.a(paramAIOShortVideoData);
    if (localagrc == null)
    {
      this.jdField_a_of_type_Aqnm.b(paramAIOShortVideoData);
      aqmb.a().a().a("AIOGalleryVideoView", 4, "initVideo handleUnDownloadVideo");
      return false;
    }
    if (this.jdField_a_of_type_Agqx != null)
    {
      localagrc.e = paramAIOShortVideoData.jdField_g_of_type_Boolean;
      aqmb.a().a().a("AIOGalleryVideoView", 4, "initVideo, set playMediaInfo.isMute =  " + paramAIOShortVideoData.jdField_g_of_type_Boolean);
      this.jdField_a_of_type_Agqx.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localagrc);
    }
    return true;
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Aqnm.d(paramLong);
  }
  
  public void b(agrc paramagrc)
  {
    if (a(paramagrc))
    {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onPlayPause id = " + paramagrc.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Agqx.d())
      {
        this.jdField_a_of_type_Aqnm.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 6);
        this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
        long l = this.jdField_a_of_type_Agqx.a();
        int i = (int)(l / this.jdField_a_of_type_Agqx.b() * 10000.0D);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l));
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
        if (this.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Aqnm.a())) {
          this.jdField_a_of_type_Aqnm.a(true);
        }
      }
    }
  }
  
  public void b(agrc paramagrc, int paramInt)
  {
    if (a(paramagrc))
    {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onDownloading id = " + paramagrc.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_Agqx != null) && (!this.jdField_a_of_type_Agqx.c()))
      {
        this.jdField_a_of_type_Aqnm.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 1);
        this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    super.b(paramViewGroup);
    this.jdField_a_of_type_Agqx = new agqz();
    this.jdField_a_of_type_Agqx.a(this.jdField_a_of_type_Aqnm.a());
    this.jdField_a_of_type_Agqx.a(this);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Aqnm.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.a == null)) {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onItemClick data is null，position = " + paramInt);
    }
    do
    {
      do
      {
        return;
      } while (paramAdapterView.a.a() != 2);
      paramView = ((DragGallery)this.jdField_a_of_type_Aqnm.a()).a();
      if ((this.jdField_a_of_type_Agqx == null) || (paramView == null) || (!this.jdField_a_of_type_Agqx.a(paramView))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryVideoView", 0, "onItemClick, play button click.");
      }
    } while (((AIOShortVideoData)paramAdapterView.a).l == 2);
    this.jdField_a_of_type_Agqx.f();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryVideoView", 0, "onItemClick, handle immersion.");
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
  
  public void c()
  {
    super.c();
    if ((this.jdField_a_of_type_Agqx != null) && (this.jdField_a_of_type_Agqx.c())) {
      this.jdField_a_of_type_Agqx.f();
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPresenterAIOGalleryBasePresenter.a(paramInt)))
    {
      if ((this.jdField_a_of_type_Agqx != null) && (this.jdField_a_of_type_Agqx.c())) {
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
    this.jdField_a_of_type_Aqnm.e(paramLong);
  }
  
  public void c(agrc paramagrc)
  {
    if (a(paramagrc))
    {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onPlayFinish id = " + paramagrc.jdField_a_of_type_Long);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
      this.jdField_a_of_type_Aqnm.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 0);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryVideoView.2(this));
    }
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
    if ((this.jdField_a_of_type_Aqnm.a() != null) && (this.jdField_a_of_type_Aqnm.a().b()))
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
    if (this.jdField_a_of_type_Agqx != null) {
      this.jdField_a_of_type_Agqx.k();
    }
    if (this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void d(agrc paramagrc)
  {
    if (a(paramagrc))
    {
      aqmb.a().a().a("AIOGalleryVideoView", 4, "onBuffering id = " + paramagrc.jdField_a_of_type_Long);
      this.jdField_a_of_type_Aqnm.a(paramagrc.jdField_a_of_type_Long, paramagrc.jdField_b_of_type_Int, 3);
      this.jdField_a_of_type_Aqnm.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public boolean d()
  {
    if (super.d())
    {
      Object localObject = this.jdField_a_of_type_Aqnm.a();
      if ((localObject != null) && (((aqmg)localObject).a != null) && (((aqmg)localObject).a.a() == 2))
      {
        localObject = (AIOShortVideoData)((aqmg)localObject).a;
        localObject = new aqms().a((AIOShortVideoData)localObject, 1);
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
      Object localObject = this.jdField_a_of_type_Aqnm.a();
      if ((localObject == null) || (((aqmg)localObject).a == null)) {
        break label161;
      }
      l = ((aqmg)localObject).a.jdField_a_of_type_Long;
      if ((!paramBoolean) || (localObject == null) || (((aqmg)localObject).a == null) || (!avtc.a()) || (!ShortVideoUtils.g())) {
        break label166;
      }
      localObject = (AIOShortVideoData)((aqmg)localObject).a;
      if (TextUtils.isEmpty(((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString)) {
        break label166;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_Long != l)
      {
        axqw.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 2, 0, "", "", ((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString, "");
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
    this.jdField_a_of_type_Aqnm.b.clear();
  }
  
  public void j()
  {
    super.j();
    Object localObject = this.jdField_a_of_type_Aqnm.a();
    AIOShortVideoData localAIOShortVideoData;
    if ((localObject != null) && (((aqmg)localObject).a != null) && (((aqmg)localObject).a.a() == 2))
    {
      localAIOShortVideoData = (AIOShortVideoData)((aqmg)localObject).a;
      a(d());
      b(a((aqmg)localObject));
      g(true);
      aqmb.a().a().a("AIOGalleryVideoView", 4, "updateUI id = " + localAIOShortVideoData.jdField_a_of_type_Long + ", status = " + localAIOShortVideoData.l);
    }
    switch (localAIOShortVideoData.l)
    {
    default: 
      aqmb.a().a().a("AIOGalleryVideoView", 4, "updateUI status is error, status = " + localAIOShortVideoData.l);
      return;
    case 1: 
      this.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Aqnm.c(), localAIOShortVideoData.m);
      f(false);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqx.a(8, "");
      this.jdField_a_of_type_Agqx.b(8);
      a(false);
      return;
    case 2: 
      this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(ajyc.a(2131700064) + localAIOShortVideoData.m + "%");
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(localAIOShortVideoData.m);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      e(true);
      this.jdField_a_of_type_Agqx.a(8, "");
      this.jdField_a_of_type_Agqx.b(8);
      a(true);
      return;
    case 4: 
      this.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Aqnm.c(), localAIOShortVideoData.m);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      f(false);
      this.jdField_a_of_type_Agqx.a(8, "");
      this.jdField_a_of_type_Agqx.b(8);
      a(false);
      return;
    case 3: 
      if (this.jdField_a_of_type_Agqx.c()) {
        if (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
        f(true);
        e(false);
        this.jdField_a_of_type_Agqx.a(8, "");
        a(true);
        return;
        if ((this.jdField_a_of_type_Agqx.d()) && (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
      }
    case 5: 
      this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqx.a(8, "");
      this.jdField_a_of_type_Agqx.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845266);
      a(true);
      return;
    case 6: 
      this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
      f(true);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqx.a(8, "");
      this.jdField_a_of_type_Agqx.b(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845265);
      a(true);
      return;
    case 7: 
      this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
      f(false);
      e(false);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Agqx.a(0, localAIOShortVideoData.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_Agqx.b(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845265);
      a(false);
      return;
    }
    this.jdField_a_of_type_Aqnm.b(this.jdField_a_of_type_Aqnm.c(), true);
    f(false);
    e(false);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Agqx.a(8, "");
    localObject = this.jdField_a_of_type_Agqx;
    if (localAIOShortVideoData.jdField_f_of_type_Boolean) {}
    for (int i = 8;; i = 0)
    {
      ((agqx)localObject).b(i);
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
    default: 
    case 2131371129: 
    case 2131364260: 
    case 2131373019: 
    case 2131373020: 
    case 2131373018: 
    case 2131373026: 
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Agqx != null) {
            this.jdField_a_of_type_Agqx.f();
          }
          this.jdField_a_of_type_Aqnm.m();
          this.jdField_a_of_type_Aqnm.q();
          this.jdField_a_of_type_Aqnm.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Aqnm.p();
          return;
          paramView = this.jdField_a_of_type_Aqnm.a();
        } while ((paramView == null) || (paramView.a == null));
        paramView = (AIOShortVideoData)paramView.a;
        this.jdField_a_of_type_Aqnm.c(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 256);
        this.jdField_a_of_type_Aqnm.a(paramView.jdField_a_of_type_Long, paramView.jdField_a_of_type_Int, 0);
        j();
        return;
        u();
        this.jdField_a_of_type_Aqnm.o();
        return;
        l();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryVideoView", 0, "onClick qq_gallery_danmaku_view ");
        }
        paramView = this.jdField_a_of_type_Aqnm.a();
        long l = this.jdField_a_of_type_Agqx.a();
        if ((paramView != null) && (paramView.a != null)) {
          MiniChatActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqmm.a(), this.jdField_a_of_type_Aqmm.a(), false, 26, paramView.a.d, l);
        }
        this.jdField_a_of_type_Aqnm.r();
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
        if (!akwg.a(this.jdField_a_of_type_AndroidAppActivity))
        {
          paramView.requestPermissions(new aqps(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          return;
        }
        t();
        return;
      }
      t();
      return;
    }
    aqmb.a().a().a("AIOGalleryVideoView", 2, "onClick, activity:" + this.jdField_a_of_type_AndroidAppActivity);
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
      this.jdField_a_of_type_Aqnm.n();
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    aqmb.a().a().a("AIOGalleryVideoView", 4, "onStopTrackingTouch");
    if (this.jdField_a_of_type_Agqx != null)
    {
      this.jdField_a_of_type_Agqx.n();
      if ((this.jdField_a_of_type_Aqnm.a() != null) && (this.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Aqnm.a())) && (paramSeekBar != null))
      {
        aqmb.a().a().a("AIOGalleryVideoView", 4, "seek danmaku");
        this.jdField_a_of_type_Aqnm.a().a(paramSeekBar.getProgress());
        aqmg localaqmg = this.jdField_a_of_type_Aqnm.a();
        if ((localaqmg != null) && (localaqmg.a != null)) {
          this.jdField_a_of_type_Aqnm.a().a(this.jdField_a_of_type_Aqnm.a(localaqmg.a.d, paramSeekBar.getProgress()));
        }
      }
    }
  }
  
  public void q()
  {
    aqmb.a().a().a("AIOGalleryVideoView", 4, "onResume");
    if (this.jdField_a_of_type_Agqx != null)
    {
      this.jdField_a_of_type_Agqx.j();
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Agqx.f();
      }
    }
  }
  
  public void r()
  {
    aqmb.a().a().a("AIOGalleryVideoView", 4, "onPause");
    if ((this.jdField_a_of_type_Agqx != null) && (this.jdField_a_of_type_Agqx.c()))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Agqx.f();
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_Agqx != null) && (this.jdField_a_of_type_Agqx.a != null) && (this.jdField_a_of_type_Agqx.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Agqx.c()))
    {
      this.jdField_a_of_type_Agqx.d(2);
      Object localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719566);
      localObject = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, (String)localObject, 2131694647, 2131720918, new aqpw(this), new aqpx(this));
      if (this.jdField_a_of_type_Agqx != null) {
        this.jdField_a_of_type_Agqx.f();
      }
      a((Dialog)localObject);
    }
  }
  
  public void v() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpr
 * JD-Core Version:    0.7.0.1
 */