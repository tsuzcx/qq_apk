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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IMediaCodecSendTask;
import com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil;
import com.tencent.aelight.camera.struct.editor.FlowComponentInterface;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.struct.editor.VideoSendPublicParamBase;
import com.tencent.biz.qqstory.takevideo.slideshow.QzoneSlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
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
    if (paramInt == -1)
    {
      if (paramIntent != null)
      {
        Object localObject2 = paramIntent.getStringExtra("key_content");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        int i = paramIntent.getIntExtra("key_priv", 1);
        Object localObject3 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = new ArrayList();
        }
        int j = paramIntent.getIntExtra("key_font_id", -1);
        int k = paramIntent.getIntExtra("key_font_format_type", 0);
        localObject3 = paramIntent.getStringExtra("key_font_url");
        int m = paramIntent.getIntExtra("key_super_font_id", -1);
        String str = paramIntent.getStringExtra("key_super_font_info");
        boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
        boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
        boolean bool3 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
        paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
        if (paramIntent.f <= 5) {
          paramInt = paramIntent.f;
        } else {
          paramInt = 0;
        }
        int n = (int)paramIntent.jdField_a_of_type_Long;
        FlowComponentInterface localFlowComponentInterface = (FlowComponentInterface)((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).getVideoComponentCallback();
        localFlowComponentInterface.setRefer(getClass().getName());
        a(paramIntent.k, paramInt, paramIntent.j, paramIntent.c, paramIntent.b, n, localFlowComponentInterface, (String)localObject1, i, (ArrayList)localObject2, false, j, k, (String)localObject3, m, str, bool1, bool2, bool3);
        if (this.jdField_a_of_type_Int == 18) {
          LpReportInfo_pf00064.allReport(585, 15, 9);
        }
        a();
        return;
      }
      return;
    }
    a();
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, FlowComponentInterface paramFlowComponentInterface, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      ((IPtvFilterUtil)QRoute.api(IPtvFilterUtil.class)).createFakeVidConfigFile(paramString1, paramString4);
    }
    VideoSendPublicParamBase localVideoSendPublicParamBase = new VideoSendPublicParamBase();
    localVideoSendPublicParamBase.mContext = getBaseActivity();
    localVideoSendPublicParamBase.mVideoCacheDir = paramString1;
    localVideoSendPublicParamBase.mEncodeMode = paramInt1;
    localVideoSendPublicParamBase.mVideoFilePath = paramString2;
    localVideoSendPublicParamBase.mThumbFilePath = paramString3;
    localVideoSendPublicParamBase.mThumbWidth = 0;
    localVideoSendPublicParamBase.mThumbHeight = 0;
    localVideoSendPublicParamBase.fakeVid = paramString4;
    localVideoSendPublicParamBase.recordTime = paramInt2;
    localVideoSendPublicParamBase.mUserCallBack = paramFlowComponentInterface;
    localVideoSendPublicParamBase.mContent = paramString5;
    localVideoSendPublicParamBase.mPriv = paramInt3;
    localVideoSendPublicParamBase.mPrivUinList = paramArrayList;
    localVideoSendPublicParamBase.mEnableEditVideo = true;
    localVideoSendPublicParamBase.topicSyncQzone = paramBoolean1;
    localVideoSendPublicParamBase.fontId = paramInt4;
    localVideoSendPublicParamBase.fontFormatType = paramInt5;
    localVideoSendPublicParamBase.fontUrl = paramString6;
    localVideoSendPublicParamBase.superFontId = paramInt6;
    localVideoSendPublicParamBase.superFontInfo = paramString7;
    localVideoSendPublicParamBase.generateGif = paramBoolean2;
    localVideoSendPublicParamBase.timerDelete = paramBoolean3;
    localVideoSendPublicParamBase.isUploadOrigin = QzoneConfig.getInstance().getConfig("QZoneSetting", "P2VNeedOriginal", true);
    localVideoSendPublicParamBase.entrySource = QzoneSlideShowPhotoListManager.a().a();
    localVideoSendPublicParamBase.mUin = "";
    localVideoSendPublicParamBase.mUinType = 0;
    localVideoSendPublicParamBase.mTroopUin = "";
    ((IMediaCodecSendTask)QRoute.api(IMediaCodecSendTask.class)).execute(localVideoSendPublicParamBase);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      String str = HardCodeUtil.a(2131712306);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getBaseActivity(), 230, str, null, HardCodeUtil.a(2131712307), HardCodeUtil.a(2131712305), new QzoneSlideShowPreparingFragment.5(this), new QzoneSlideShowPreparingFragment.6(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    SlideShowPhotoListManager.a().c();
    getBaseActivity().finish();
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
    QLog.d(jdField_a_of_type_JavaLangString, 2, "QzoneSlideShowPreparingFragment onCreateView");
    int i = 0;
    paramLayoutInflater = paramLayoutInflater.inflate(2131559079, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379701));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131379558));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLayoutInflater.findViewById(2131372392));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369449));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0%");
    this.b.setOnClickListener(new QzoneSlideShowPreparingFragment.3(this));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
    paramBundle = getBaseActivity().getIntent();
    if (paramBundle != null)
    {
      SlideShowPhotoListManager.a().c();
      paramViewGroup = paramBundle.getParcelableArrayListExtra("qzone_slide_show_matters");
      int j = paramBundle.getIntExtra("qqstory_slide_show_scene", 21);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("entrance_qzone_p2v", -1);
      if ((paramViewGroup != null) && (paramViewGroup.size() > 0) && (j == 22))
      {
        Object localObject = (LocalMediaInfo)paramViewGroup.get(0);
        if (((LocalMediaInfo)localObject).mMimeType.contains("image"))
        {
          new BitmapFactory.Options().inPreferredConfig = Bitmap.Config.RGB_565;
          paramBundle = BitmapFactory.decodeFile(((LocalMediaInfo)localObject).path);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBundle);
        }
        else if (((LocalMediaInfo)localObject).mMimeType.contains("video"))
        {
          paramBundle = new MediaMetadataRetriever();
          paramBundle.setDataSource(((LocalMediaInfo)localObject).path);
          localObject = paramBundle.getFrameAtTime(0L, 3);
          paramBundle.release();
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        }
        paramBundle = new ArrayList();
        while (i < paramViewGroup.size())
        {
          paramBundle.add(new SlideItemInfo((LocalMediaInfo)paramViewGroup.get(i)));
          i += 1;
        }
        SlideShowPhotoListManager.a().b(paramBundle);
        SlideShowPhotoListManager.a().a(paramBundle);
        SlideShowPhotoListManager.a().c(j);
        SlideShowPhotoListManager.a().b(this.jdField_a_of_type_Int);
        SlideShowPhotoListManager.a().a(getBaseActivity(), new QzoneSlideShowPreparingFragment.4(this), 2);
      }
      else
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "slideShowLocalMediaInfos is null or SlideShowScene is not QzoneSlideShowPhotoListManager.SCENE_QZONE");
        a();
      }
    }
    LpReportInfo_pf00064.allReport(680, 1, 1);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment
 * JD-Core Version:    0.7.0.1
 */