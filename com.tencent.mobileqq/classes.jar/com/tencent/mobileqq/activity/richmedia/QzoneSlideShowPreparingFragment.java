package com.tencent.mobileqq.activity.richmedia;

import abtr;
import ahua;
import ahuk;
import ahul;
import ahwl;
import ahwm;
import ahwn;
import ahwo;
import ahwp;
import ajya;
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
import bbdj;
import bbgu;
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
import vtm;
import vtz;

public class QzoneSlideShowPreparingFragment
  extends PublicBaseFragment
  implements abtr
{
  private static final String jdField_a_of_type_JavaLangString = vtm.class.getName();
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new ahwl(this, Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbgu jdField_a_of_type_Bbgu;
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
        localVideoComponentCallback.c_(getClass().getName());
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
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, ahua paramahua, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.a(str, paramString4);
    }
    ahul localahul = new ahul();
    localahul.jdField_a_of_type_AndroidAppActivity = getActivity();
    localahul.jdField_a_of_type_JavaLangString = str;
    localahul.jdField_b_of_type_JavaLangString = paramString1;
    localahul.jdField_a_of_type_Int = paramInt1;
    localahul.jdField_c_of_type_JavaLangString = paramString2;
    localahul.jdField_f_of_type_JavaLangString = paramString3;
    localahul.jdField_c_of_type_Int = 0;
    localahul.jdField_d_of_type_Int = 0;
    localahul.jdField_k_of_type_JavaLangString = paramString4;
    localahul.j = paramInt2;
    localahul.jdField_a_of_type_Ahua = paramahua;
    localahul.jdField_g_of_type_JavaLangString = paramString5;
    localahul.jdField_e_of_type_Int = paramInt3;
    localahul.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    localahul.jdField_a_of_type_Boolean = true;
    localahul.jdField_b_of_type_Boolean = paramBoolean1;
    localahul.jdField_f_of_type_Int = paramInt4;
    localahul.jdField_g_of_type_Int = paramInt5;
    localahul.jdField_h_of_type_JavaLangString = paramString6;
    localahul.jdField_h_of_type_Int = paramInt6;
    localahul.i = paramString7;
    localahul.jdField_e_of_type_Boolean = paramBoolean2;
    localahul.jdField_f_of_type_Boolean = paramBoolean3;
    localahul.jdField_g_of_type_Boolean = paramBoolean4;
    localahul.jdField_h_of_type_Boolean = QzoneConfig.getInstance().getConfig("QZoneSetting", "P2VNeedOriginal", true);
    localahul.jdField_k_of_type_Int = vtm.a().a();
    localahul.jdField_d_of_type_JavaLangString = "";
    localahul.jdField_b_of_type_Int = 0;
    localahul.jdField_e_of_type_JavaLangString = "";
    new ahuk(localahul).execute(new Void[0]);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bbgu == null)
    {
      String str = ajya.a(2131712365);
      this.jdField_a_of_type_Bbgu = bbdj.a(getActivity(), 230, str, null, ajya.a(2131712366), ajya.a(2131712364), new ahwo(this), new ahwp(this));
    }
    this.jdField_a_of_type_Bbgu.show();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    vtz.a().e();
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131559011, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378194));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131378082));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLayoutInflater.findViewById(2131371326));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368647));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0%");
    this.b.setOnClickListener(new ahwm(this));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
    paramBundle = getActivity().getIntent();
    if (paramBundle != null)
    {
      vtz.a().e();
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
      vtz.a().b(paramBundle);
      vtz.a().a(paramBundle);
      vtz.a().c(j);
      vtz.a().b(this.jdField_a_of_type_Int);
      vtz.a().a(getActivity(), new ahwn(this), 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment
 * JD-Core Version:    0.7.0.1
 */