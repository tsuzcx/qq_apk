package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp;
import com.tencent.aelight.camera.ae.gif.preview.VideoPlayView;
import com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aebase.BaseVMPeakActivity;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import dov.com.qq.im.ae.current.SessionWrap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AEGIFSinglePreviewFragment
  extends Fragment
{
  private final float jdField_a_of_type_Float = 147.0F;
  private final int jdField_a_of_type_Int = 700;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AEGIFOutlineTextView jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView;
  private AEGIFTextMvp jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp;
  private VideoPlayView jdField_a_of_type_ComTencentAelightCameraAeGifPreviewVideoPlayView;
  private VideoGIFCreator jdField_a_of_type_ComTencentAelightCameraAeGifVideoVideoGIFCreator;
  private SessionWrap jdField_a_of_type_DovComQqImAeCurrentSessionWrap;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private final float jdField_b_of_type_Float = 58.799999F;
  private final int jdField_b_of_type_Int = 600;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean = false;
  
  public static Fragment a(String paramString1, Boolean paramBoolean, String paramString2, String paramString3, SessionWrap paramSessionWrap, boolean paramBoolean1, String paramString4)
  {
    AEGIFSinglePreviewFragment localAEGIFSinglePreviewFragment = new AEGIFSinglePreviewFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString1);
    localBundle.putString("KEY_AVAILABLE_SAVENAME", paramString3);
    localBundle.putBoolean("KEY_MATERIAL_APPLIED", paramBoolean.booleanValue());
    localBundle.putString("ARG_GIF_MATERIAL_ID", paramString2);
    localBundle.putParcelable("ARG_SESSION_INFO", paramSessionWrap);
    localBundle.putBoolean("ARG_GIF_SEND_TO_AIO", paramBoolean1);
    if (!TextUtils.isEmpty(paramString4)) {
      localBundle.putString("KEY_FONT_ID", paramString4);
    }
    localAEGIFSinglePreviewFragment.setArguments(localBundle);
    return localAEGIFSinglePreviewFragment;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122234).setOnClickListener(new AEGIFSinglePreviewFragment.1(this));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064121951);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122235).setOnClickListener(new AEGIFSinglePreviewFragment.2(this));
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122779).setOnClickListener(new AEGIFSinglePreviewFragment.3(this));
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(true);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
    }
    catch (IOException paramString)
    {
      label30:
      break label30;
    }
    QLog.e("AEGIFSinglePreviewFragment", 1, "mediaPlayer 初始化失败");
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new AEGIFSinglePreviewFragment.6(this));
  }
  
  private void a(String paramString1, SessionWrap paramSessionWrap, String paramString2, String paramString3)
  {
    if (!new File(paramString1).exists()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ARG_GIF_PATH", paramString1);
    localBundle.putString("curFriendUin", paramSessionWrap.jdField_a_of_type_JavaLangString);
    localBundle.putString("curFriendNick", paramSessionWrap.jdField_b_of_type_JavaLangString);
    localBundle.putString("troopUin", paramSessionWrap.jdField_c_of_type_JavaLangString);
    localBundle.putInt("curType", paramSessionWrap.jdField_a_of_type_Int);
    localBundle.putString("forward_summary_extra", paramString2);
    paramSessionWrap = new StringBuilder();
    paramSessionWrap.append("gif^");
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    paramSessionWrap.append(paramString1);
    localBundle.putString("widgetinfo", paramSessionWrap.toString());
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_SEND_GIF", localBundle, null);
    getActivity().setResult(201);
    getActivity().finish();
  }
  
  private void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    localBundle.putStringArrayList("qipc_param_emo_widget_infos", paramArrayList3);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new AEGIFSinglePreviewFragment.5(this));
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveAndSend---onlySave=");
    localStringBuilder.append(paramBoolean);
    AEQLog.b("AEGIFSinglePreviewFragment", localStringBuilder.toString());
    e();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoVideoGIFCreator = new VideoGIFCreator(this.jdField_a_of_type_JavaLangString);
    g();
    this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoVideoGIFCreator.a(new AEGIFSinglePreviewFragment.4(this, paramBoolean));
  }
  
  private void b()
  {
    a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifPreviewVideoPlayView = ((VideoPlayView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122807));
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeGifPreviewVideoPlayView.a(localMediaPlayer);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122466));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setOnClickListener(new AEGIFSinglePreviewFragment.7(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.setFontId(this.jdField_b_of_type_JavaLangString);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122528);
    localRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp = new AEGIFTextMvp((BaseVMPeakActivity)this.jdField_a_of_type_AndroidAppActivity, localRelativeLayout, this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView);
    this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp.a();
  }
  
  private void d()
  {
    AEGIFTextEditFragment localAEGIFTextEditFragment = AEGIFTextEditFragment.a(null, false, this.jdField_b_of_type_JavaLangString);
    localAEGIFTextEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp);
    getFragmentManager().beginTransaction().add(2064122227, localAEGIFTextEditFragment).addToBackStack(null).commit();
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      UiThreadUtil.a(new AEGIFSinglePreviewFragment.8(this));
    }
  }
  
  private void f()
  {
    UiThreadUtil.a(new AEGIFSinglePreviewFragment.9(this));
  }
  
  private void g()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122525);
    float f2 = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.getLeft() / localRelativeLayout.getWidth();
    float f3 = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.getTop() / localRelativeLayout.getHeight();
    float f1 = this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.a() + this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.b() * 2.0F;
    int i;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp.a().indexOf('\n') > 0)
    {
      f1 *= 2.5F;
      i = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 250.0F);
    }
    else
    {
      f1 *= 1.2F;
      i = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 250.0F);
    }
    f1 /= i;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFTextMvp.a().length() > 0) {
      this.jdField_a_of_type_ComTencentAelightCameraAeGifVideoVideoGIFCreator.a(this.jdField_a_of_type_ComTencentAelightCameraAeGifGiftextAEGIFOutlineTextView.a(), f2, f3, 1.0F, f1);
    }
  }
  
  protected int a()
  {
    return 2064318599;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(a(), paramViewGroup, false));
    int i = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int j = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 700.0F);
    if (i < j) {
      this.jdField_d_of_type_Boolean = true;
    } else {
      this.jdField_d_of_type_Boolean = false;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2064122525);
      paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      if (i < DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 600.0F))
      {
        paramViewGroup.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 58.799999F);
      }
      else
      {
        float f = (j - i) / DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 100.0F);
        paramViewGroup.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 147.0F - f * 88.199997F);
      }
      paramLayoutInflater.setLayoutParams(paramViewGroup);
    }
    paramLayoutInflater = getArguments();
    this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getString("KEY_PREVIEW_SOURCE_PATH");
    this.jdField_b_of_type_Boolean = paramLayoutInflater.getBoolean("KEY_MATERIAL_APPLIED");
    this.jdField_c_of_type_JavaLangString = paramLayoutInflater.getString("ARG_GIF_MATERIAL_ID");
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("receive materialId=");
    paramViewGroup.append(this.jdField_c_of_type_JavaLangString);
    paramViewGroup.append(", materialApplied=");
    paramViewGroup.append(this.jdField_b_of_type_Boolean);
    AEQLog.b("AEGIFSinglePreviewFragment", paramViewGroup.toString());
    this.jdField_d_of_type_JavaLangString = paramLayoutInflater.getString("KEY_AVAILABLE_SAVENAME");
    this.jdField_a_of_type_DovComQqImAeCurrentSessionWrap = ((SessionWrap)paramLayoutInflater.getParcelable("ARG_SESSION_INFO"));
    this.jdField_c_of_type_Boolean = paramLayoutInflater.getBoolean("ARG_GIF_SEND_TO_AIO");
    if (getArguments().containsKey("KEY_FONT_ID")) {
      this.jdField_b_of_type_JavaLangString = getArguments().getString("KEY_FONT_ID");
    }
    c();
    a();
    b();
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localObject != null) {
      ((MediaPlayer)localObject).release();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeGifPreviewVideoPlayView;
    if (localObject != null) {
      ((VideoPlayView)localObject).a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AEBaseDataReporter.a().ao();
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.pause();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    AEBaseReportParam.a().k();
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((localMediaPlayer != null) && (this.jdField_a_of_type_Boolean))
    {
      localMediaPlayer.start();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((localMediaPlayer != null) && (this.jdField_a_of_type_Boolean)) {
      localMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment
 * JD-Core Version:    0.7.0.1
 */