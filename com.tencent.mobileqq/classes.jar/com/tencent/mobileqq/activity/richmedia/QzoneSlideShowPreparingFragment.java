package com.tencent.mobileqq.activity.richmedia;

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
import com.tencent.biz.qqstory.takevideo.slideshow.QzoneSlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.video.VideoComponentCallback;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;
import java.util.ArrayList;

public class QzoneSlideShowPreparingFragment
  extends PublicBaseFragment
  implements PublicFragmentActivityCallBackInterface
{
  private static final String jdField_a_of_type_JavaLangString = QzoneSlideShowPhotoListManager.class.getName();
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new QzoneSlideShowPreparingFragment.1(this, Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
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
        localVideoComponentCallback.setRefer(getClass().getName());
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
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, FlowComponentInterface paramFlowComponentInterface, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.a(str, paramString4);
    }
    MediaCodecSendTask.VideoSendPublicParam localVideoSendPublicParam = new MediaCodecSendTask.VideoSendPublicParam();
    localVideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = getActivity();
    localVideoSendPublicParam.jdField_a_of_type_JavaLangString = str;
    localVideoSendPublicParam.jdField_b_of_type_JavaLangString = paramString1;
    localVideoSendPublicParam.jdField_a_of_type_Int = paramInt1;
    localVideoSendPublicParam.jdField_c_of_type_JavaLangString = paramString2;
    localVideoSendPublicParam.jdField_f_of_type_JavaLangString = paramString3;
    localVideoSendPublicParam.jdField_c_of_type_Int = 0;
    localVideoSendPublicParam.jdField_d_of_type_Int = 0;
    localVideoSendPublicParam.jdField_k_of_type_JavaLangString = paramString4;
    localVideoSendPublicParam.j = paramInt2;
    localVideoSendPublicParam.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = paramFlowComponentInterface;
    localVideoSendPublicParam.jdField_g_of_type_JavaLangString = paramString5;
    localVideoSendPublicParam.jdField_e_of_type_Int = paramInt3;
    localVideoSendPublicParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    localVideoSendPublicParam.jdField_a_of_type_Boolean = true;
    localVideoSendPublicParam.jdField_b_of_type_Boolean = paramBoolean1;
    localVideoSendPublicParam.jdField_f_of_type_Int = paramInt4;
    localVideoSendPublicParam.jdField_g_of_type_Int = paramInt5;
    localVideoSendPublicParam.jdField_h_of_type_JavaLangString = paramString6;
    localVideoSendPublicParam.jdField_h_of_type_Int = paramInt6;
    localVideoSendPublicParam.i = paramString7;
    localVideoSendPublicParam.jdField_e_of_type_Boolean = paramBoolean2;
    localVideoSendPublicParam.jdField_f_of_type_Boolean = paramBoolean3;
    localVideoSendPublicParam.jdField_g_of_type_Boolean = paramBoolean4;
    localVideoSendPublicParam.jdField_h_of_type_Boolean = QzoneConfig.getInstance().getConfig("QZoneSetting", "P2VNeedOriginal", true);
    localVideoSendPublicParam.jdField_k_of_type_Int = QzoneSlideShowPhotoListManager.a().a();
    localVideoSendPublicParam.jdField_d_of_type_JavaLangString = "";
    localVideoSendPublicParam.jdField_b_of_type_Int = 0;
    localVideoSendPublicParam.jdField_e_of_type_JavaLangString = "";
    new MediaCodecSendTask(localVideoSendPublicParam).execute(new Void[0]);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      String str = HardCodeUtil.a(2131712331);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getActivity(), 230, str, null, HardCodeUtil.a(2131712332), HardCodeUtil.a(2131712330), new QzoneSlideShowPreparingFragment.5(this), new QzoneSlideShowPreparingFragment.6(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    SlideShowPhotoListManager.a().e();
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131559193, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380381));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131380243));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLayoutInflater.findViewById(2131372815));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369759));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0%");
    this.b.setOnClickListener(new QzoneSlideShowPreparingFragment.3(this));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
    paramBundle = getActivity().getIntent();
    if (paramBundle != null)
    {
      SlideShowPhotoListManager.a().e();
      paramViewGroup = paramBundle.getParcelableArrayListExtra("qzone_slide_show_matters");
      int j = paramBundle.getIntExtra("qqstory_slide_show_scene", 21);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("entrance_qzone_p2v", -1);
      if ((paramViewGroup == null) || (paramViewGroup.size() <= 0) || (j != 22)) {
        break label425;
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
      SlideShowPhotoListManager.a().b(paramBundle);
      SlideShowPhotoListManager.a().a(paramBundle);
      SlideShowPhotoListManager.a().c(j);
      SlideShowPhotoListManager.a().b(this.jdField_a_of_type_Int);
      SlideShowPhotoListManager.a().a(getActivity(), new QzoneSlideShowPreparingFragment.4(this), 2);
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(680, 1, 1);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      label425:
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