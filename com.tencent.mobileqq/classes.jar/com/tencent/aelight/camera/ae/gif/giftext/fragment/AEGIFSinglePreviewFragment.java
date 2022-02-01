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
  private ViewGroup a;
  private Activity b;
  private VideoPlayView c;
  private MediaPlayer d;
  private String e = null;
  private AEGIFTextMvp f;
  private AEGIFOutlineTextView g;
  private String h;
  private Dialog i;
  private View j;
  private boolean k = false;
  private boolean l = false;
  private String m;
  private SessionWrap n;
  private boolean o = false;
  private String p = "";
  private boolean q = false;
  private final int r = 700;
  private final int s = 600;
  private final float t = 147.0F;
  private final float u = 58.799999F;
  private VideoGIFCreator v;
  
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
  
  private void a(String paramString)
  {
    this.d = new MediaPlayer();
    this.d.setLooping(true);
    try
    {
      this.d.setDataSource(paramString);
    }
    catch (IOException paramString)
    {
      label30:
      break label30;
    }
    QLog.e("AEGIFSinglePreviewFragment", 1, "mediaPlayer 初始化失败");
    this.d.setOnPreparedListener(new AEGIFSinglePreviewFragment.6(this));
  }
  
  private void a(String paramString1, SessionWrap paramSessionWrap, String paramString2, String paramString3)
  {
    if (!new File(paramString1).exists()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ARG_GIF_PATH", paramString1);
    localBundle.putString("curFriendUin", paramSessionWrap.a);
    localBundle.putString("curFriendNick", paramSessionWrap.b);
    localBundle.putString("troopUin", paramSessionWrap.d);
    localBundle.putInt("curType", paramSessionWrap.c);
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
    f();
    this.v = new VideoGIFCreator(this.e);
    h();
    this.v.a(new AEGIFSinglePreviewFragment.4(this, paramBoolean));
  }
  
  private void b()
  {
    this.a.findViewById(2063991116).setOnClickListener(new AEGIFSinglePreviewFragment.1(this));
    this.j = this.a.findViewById(2063990883);
    this.a.findViewById(2063991117).setOnClickListener(new AEGIFSinglePreviewFragment.2(this));
    this.a.findViewById(2063991554).setOnClickListener(new AEGIFSinglePreviewFragment.3(this));
  }
  
  private void c()
  {
    a(this.e);
    this.c = ((VideoPlayView)this.a.findViewById(2063991581));
    MediaPlayer localMediaPlayer = this.d;
    if (localMediaPlayer != null) {
      this.c.a(localMediaPlayer);
    }
  }
  
  private void d()
  {
    this.g = ((AEGIFOutlineTextView)this.a.findViewById(2063991291));
    this.g.setVisibility(0);
    this.g.setOnClickListener(new AEGIFSinglePreviewFragment.7(this));
    this.g.setFontId(this.h);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.a.findViewById(2063991347);
    localRelativeLayout.setVisibility(0);
    this.f = new AEGIFTextMvp((BaseVMPeakActivity)this.b, localRelativeLayout, this.g);
    this.f.a();
  }
  
  private void e()
  {
    AEGIFTextEditFragment localAEGIFTextEditFragment = AEGIFTextEditFragment.a(null, false, this.h);
    localAEGIFTextEditFragment.a(this.f);
    getFragmentManager().beginTransaction().add(2063991109, localAEGIFTextEditFragment).addToBackStack(null).commit();
  }
  
  private void f()
  {
    if (!this.b.isFinishing()) {
      UiThreadUtil.a(new AEGIFSinglePreviewFragment.8(this));
    }
  }
  
  private void g()
  {
    UiThreadUtil.a(new AEGIFSinglePreviewFragment.9(this));
  }
  
  private void h()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.a.findViewById(2063991344);
    float f2 = this.g.getLeft() / localRelativeLayout.getWidth();
    float f3 = this.g.getTop() / localRelativeLayout.getHeight();
    float f1 = this.g.getTextSize() + this.g.getTextStrokeSize() * 2.0F;
    int i1;
    if (this.f.g().indexOf('\n') > 0)
    {
      f1 *= 2.5F;
      i1 = DisplayUtil.a(this.b, 250.0F);
    }
    else
    {
      f1 *= 1.2F;
      i1 = DisplayUtil.a(this.b, 250.0F);
    }
    f1 /= i1;
    if (this.f.g().length() > 0) {
      this.v.a(this.g.getTextBitmap(), f2, f3, 1.0F, f1);
    }
  }
  
  protected int a()
  {
    return 2064056477;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = getActivity();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = ((ViewGroup)paramLayoutInflater.inflate(a(), paramViewGroup, false));
    int i1 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i2 = DisplayUtil.a(this.b, 700.0F);
    if (i1 < i2) {
      this.q = true;
    } else {
      this.q = false;
    }
    if (this.q)
    {
      paramLayoutInflater = this.a.findViewById(2063991344);
      paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      if (i1 < DisplayUtil.a(this.b, 600.0F))
      {
        paramViewGroup.topMargin = DisplayUtil.a(this.b, 58.799999F);
      }
      else
      {
        float f1 = (i2 - i1) / DisplayUtil.a(this.b, 100.0F);
        paramViewGroup.topMargin = DisplayUtil.a(this.b, 147.0F - f1 * 88.199997F);
      }
      paramLayoutInflater.setLayoutParams(paramViewGroup);
    }
    paramLayoutInflater = getArguments();
    this.e = paramLayoutInflater.getString("KEY_PREVIEW_SOURCE_PATH");
    this.l = paramLayoutInflater.getBoolean("KEY_MATERIAL_APPLIED");
    this.m = paramLayoutInflater.getString("ARG_GIF_MATERIAL_ID");
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("receive materialId=");
    paramViewGroup.append(this.m);
    paramViewGroup.append(", materialApplied=");
    paramViewGroup.append(this.l);
    AEQLog.b("AEGIFSinglePreviewFragment", paramViewGroup.toString());
    this.p = paramLayoutInflater.getString("KEY_AVAILABLE_SAVENAME");
    this.n = ((SessionWrap)paramLayoutInflater.getParcelable("ARG_SESSION_INFO"));
    this.o = paramLayoutInflater.getBoolean("ARG_GIF_SEND_TO_AIO");
    if (getArguments().containsKey("KEY_FONT_ID")) {
      this.h = getArguments().getString("KEY_FONT_ID");
    }
    d();
    b();
    c();
    return this.a;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.d;
    if (localObject != null) {
      ((MediaPlayer)localObject).release();
    }
    localObject = this.c;
    if (localObject != null) {
      ((VideoPlayView)localObject).a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AEBaseDataReporter.a().at();
    MediaPlayer localMediaPlayer = this.d;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.pause();
      this.k = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    AEBaseReportParam.a().Q();
    MediaPlayer localMediaPlayer = this.d;
    if ((localMediaPlayer != null) && (this.k))
    {
      localMediaPlayer.start();
      this.k = false;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    MediaPlayer localMediaPlayer = this.d;
    if ((localMediaPlayer != null) && (this.k)) {
      localMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment
 * JD-Core Version:    0.7.0.1
 */