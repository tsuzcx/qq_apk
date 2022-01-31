package com.tencent.mobileqq.activity.richmedia;

import adkz;
import ajlk;
import ajlu;
import ajlv;
import ajnv;
import ajnw;
import ajnx;
import ajny;
import ajnz;
import alpo;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import bdcd;
import bdfq;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.video.VideoComponentCallback;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;
import java.util.ArrayList;
import xie;
import xir;

public class QzoneSlideShowPreparingFragment
  extends PublicBaseFragment
  implements adkz
{
  private static final String jdField_a_of_type_JavaLangString = xie.class.getName();
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new ajnv(this, Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdfq jdField_a_of_type_Bdfq;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QzoneSlideShowPreparingFragment.2(this);
  private TextView b;
  
  private void a(int paramInt, Intent paramIntent)
  {
    Object localObject2;
    Object localObject1;
    int i;
    if (paramInt == -1) {
      if (paramIntent != null)
      {
        localObject2 = paramIntent.getStringExtra("key_content");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        i = paramIntent.getIntExtra("key_priv", 1);
        localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
        if (localObject2 != null) {
          break label266;
        }
        localObject2 = new ArrayList();
      }
    }
    label266:
    for (;;)
    {
      int j = paramIntent.getIntExtra("key_font_id", -1);
      int k = paramIntent.getIntExtra("key_font_format_type", 0);
      String str1 = paramIntent.getStringExtra("key_font_url");
      int m = paramIntent.getIntExtra("key_super_font_id", -1);
      String str2 = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      boolean bool3 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
      paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (paramIntent.jdField_f_of_type_Int <= 5) {}
      for (paramInt = paramIntent.jdField_f_of_type_Int;; paramInt = 0)
      {
        int n = (int)paramIntent.jdField_a_of_type_Long;
        VideoComponentCallback localVideoComponentCallback = new VideoComponentCallback();
        localVideoComponentCallback.d_(getClass().getName());
        a(paramIntent.jdField_k_of_type_JavaLangString, paramInt, paramIntent.j, paramIntent.jdField_c_of_type_JavaLangString, paramIntent.jdField_b_of_type_JavaLangString, n, localVideoComponentCallback, (String)localObject1, i, (ArrayList)localObject2, false, j, k, str1, m, str2, bool1, bool2, bool3);
        if (this.jdField_a_of_type_Int == 18) {
          LpReportInfo_pf00064.allReport(585, 15, 9);
        }
        a();
        return;
      }
      a();
      return;
    }
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, ajlk paramajlk, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.a(str, paramString4);
    }
    ajlv localajlv = new ajlv();
    localajlv.jdField_a_of_type_AndroidAppActivity = getActivity();
    localajlv.jdField_a_of_type_JavaLangString = str;
    localajlv.jdField_b_of_type_JavaLangString = paramString1;
    localajlv.jdField_a_of_type_Int = paramInt1;
    localajlv.jdField_c_of_type_JavaLangString = paramString2;
    localajlv.jdField_f_of_type_JavaLangString = paramString3;
    localajlv.jdField_c_of_type_Int = 0;
    localajlv.jdField_d_of_type_Int = 0;
    localajlv.jdField_k_of_type_JavaLangString = paramString4;
    localajlv.j = paramInt2;
    localajlv.jdField_a_of_type_Ajlk = paramajlk;
    localajlv.jdField_g_of_type_JavaLangString = paramString5;
    localajlv.jdField_e_of_type_Int = paramInt3;
    localajlv.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    localajlv.jdField_a_of_type_Boolean = true;
    localajlv.jdField_b_of_type_Boolean = paramBoolean1;
    localajlv.jdField_f_of_type_Int = paramInt4;
    localajlv.jdField_g_of_type_Int = paramInt5;
    localajlv.jdField_h_of_type_JavaLangString = paramString6;
    localajlv.jdField_h_of_type_Int = paramInt6;
    localajlv.i = paramString7;
    localajlv.jdField_e_of_type_Boolean = paramBoolean2;
    localajlv.jdField_f_of_type_Boolean = paramBoolean3;
    localajlv.jdField_g_of_type_Boolean = paramBoolean4;
    localajlv.jdField_h_of_type_Boolean = QzoneConfig.getInstance().getConfig("QZoneSetting", "P2VNeedOriginal", true);
    localajlv.jdField_k_of_type_Int = xie.a().a();
    localajlv.jdField_d_of_type_JavaLangString = "";
    localajlv.jdField_b_of_type_Int = 0;
    localajlv.jdField_e_of_type_JavaLangString = "";
    new ajlu(localajlv).execute(new Void[0]);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bdfq == null)
    {
      String str = alpo.a(2131712737);
      this.jdField_a_of_type_Bdfq = bdcd.a(getActivity(), 230, str, null, alpo.a(2131712738), alpo.a(2131712736), new ajny(this), new ajnz(this));
    }
    this.jdField_a_of_type_Bdfq.show();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    xir.a().e();
    getActivity().finish();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    a(paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "QzoneSlideShowPreparingFragment onCreate");
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = 0;
    QLog.d(jdField_a_of_type_JavaLangString, 2, "QzoneSlideShowPreparingFragment onCreateView");
    paramLayoutInflater = paramLayoutInflater.inflate(2131559050, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378760));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131378633));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLayoutInflater.findViewById(2131371641));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368852));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0%");
    this.b.setOnClickListener(new ajnw(this));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
    paramBundle = getActivity().getIntent();
    if (paramBundle != null)
    {
      xir.a().e();
      paramViewGroup = paramBundle.getParcelableArrayListExtra("qzone_slide_show_matters");
      int j = paramBundle.getIntExtra("qqstory_slide_show_scene", 21);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("entrance_qzone_p2v", -1);
      if ((paramViewGroup == null) || (paramViewGroup.size() <= 0) || (j != 22)) {
        break label420;
      }
      Object localObject = (LocalMediaInfo)paramViewGroup.get(0);
      if (((LocalMediaInfo)localObject).mMimeType.contains("image"))
      {
        new BitmapFactory.Options().inPreferredConfig = Bitmap.Config.RGB_565;
        paramBundle = BitmapFactory.decodeFile(((LocalMediaInfo)localObject).path);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle);
      }
      for (;;)
      {
        paramBundle = new ArrayList();
        while (i < paramViewGroup.size())
        {
          paramBundle.add(new SlideItemInfo((LocalMediaInfo)paramViewGroup.get(i)));
          i += 1;
        }
        if (((LocalMediaInfo)localObject).mMimeType.contains("video"))
        {
          paramBundle = new MediaMetadataRetriever();
          paramBundle.setDataSource(((LocalMediaInfo)localObject).path);
          localObject = paramBundle.getFrameAtTime(0L, 3);
          paramBundle.release();
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        }
      }
      xir.a().b(paramBundle);
      xir.a().a(paramBundle);
      xir.a().c(j);
      xir.a().b(this.jdField_a_of_type_Int);
      xir.a().a(getActivity(), new ajnx(this), 2);
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(680, 1, 1);
      return paramLayoutInflater;
      label420:
      QLog.e(jdField_a_of_type_JavaLangString, 2, "slideShowLocalMediaInfos is null or SlideShowScene is not QzoneSlideShowPhotoListManager.SCENE_QZONE");
      a();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment
 * JD-Core Version:    0.7.0.1
 */