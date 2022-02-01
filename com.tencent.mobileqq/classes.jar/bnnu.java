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
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.9;
import dov.com.qq.im.ae.gif.preview.VideoPlayView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class bnnu
  extends ReportFragment
{
  private final float jdField_a_of_type_Float = 147.0F;
  private final int jdField_a_of_type_Int = 700;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bnmq jdField_a_of_type_Bnmq;
  private bnpn jdField_a_of_type_Bnpn;
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
  private VideoPlayView jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final float jdField_b_of_type_Float = 58.799999F;
  private final int jdField_b_of_type_Int = 600;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  
  public static Fragment a(String paramString1, Boolean paramBoolean, String paramString2, String paramString3, SessionWrap paramSessionWrap, boolean paramBoolean1, String paramString4)
  {
    bnnu localbnnu = new bnnu();
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
    localbnnu.setArguments(localBundle);
    return localbnnu;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367715).setOnClickListener(new bnnv(this));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362679);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367716).setOnClickListener(new bnnw(this));
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380061).setOnClickListener(new bnnx(this));
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(true);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new bnoa(this));
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        QLog.e("AEGIFSinglePreviewFragment", 1, "mediaPlayer 初始化失败");
      }
    }
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
    paramSessionWrap = new StringBuilder().append("gif^");
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    localBundle.putString("widgetinfo", paramString1);
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
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new bnnz(this));
  }
  
  private void a(boolean paramBoolean)
  {
    bnrh.b("AEGIFSinglePreviewFragment", "saveAndSend---onlySave=" + paramBoolean);
    e();
    this.jdField_a_of_type_Bnpn = new bnpn(this.jdField_a_of_type_JavaLangString);
    g();
    this.jdField_a_of_type_Bnpn.a(new bnny(this, paramBoolean));
  }
  
  private void b()
  {
    a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView = ((VideoPlayView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380794));
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView.a(this.jdField_a_of_type_AndroidMediaMediaPlayer);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372336));
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setVisibility(0);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOnClickListener(new bnob(this));
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setFontId(this.jdField_b_of_type_JavaLangString);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374153);
    localRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_Bnmq = new bnmq((BaseVMPeakActivity)this.jdField_a_of_type_AndroidAppActivity, localRelativeLayout, this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView);
    this.jdField_a_of_type_Bnmq.a();
  }
  
  private void d()
  {
    bnoc localbnoc = bnoc.a(null, false, this.jdField_b_of_type_JavaLangString);
    localbnoc.a(this.jdField_a_of_type_Bnmq);
    getFragmentManager().beginTransaction().add(2131367252, localbnoc).addToBackStack(null).commit();
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      bkyq.a(new AEGIFSinglePreviewFragment.8(this));
    }
  }
  
  private void f()
  {
    bkyq.a(new AEGIFSinglePreviewFragment.9(this));
  }
  
  private void g()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374127);
    float f2 = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLeft() / localRelativeLayout.getWidth();
    float f3 = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getTop() / localRelativeLayout.getHeight();
    float f1 = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.a() + this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.b() * 2.0F;
    if (this.jdField_a_of_type_Bnmq.a().indexOf('\n') > 0) {}
    for (f1 = f1 * 2.5F / DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 250.0F);; f1 = f1 * 1.2F / DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 250.0F))
    {
      if (this.jdField_a_of_type_Bnmq.a().length() > 0) {
        this.jdField_a_of_type_Bnpn.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.a(), f2, f3, 1.0F, f1);
      }
      return;
    }
  }
  
  protected int a()
  {
    return 2131558589;
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
    int j = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 700.0F);
    if (i < j)
    {
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_d_of_type_Boolean)
      {
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374127);
        paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
        if (i >= DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 600.0F)) {
          break label280;
        }
      }
    }
    label280:
    float f;
    for (paramViewGroup.topMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 58.799999F);; paramViewGroup.topMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 147.0F - f * 88.199997F))
    {
      paramLayoutInflater.setLayoutParams(paramViewGroup);
      paramLayoutInflater = getArguments();
      this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getString("KEY_PREVIEW_SOURCE_PATH");
      this.jdField_b_of_type_Boolean = paramLayoutInflater.getBoolean("KEY_MATERIAL_APPLIED");
      this.jdField_c_of_type_JavaLangString = paramLayoutInflater.getString("ARG_GIF_MATERIAL_ID");
      bnrh.b("AEGIFSinglePreviewFragment", "receive materialId=" + this.jdField_c_of_type_JavaLangString + ", materialApplied=" + this.jdField_b_of_type_Boolean);
      this.jdField_d_of_type_JavaLangString = paramLayoutInflater.getString("KEY_AVAILABLE_SAVENAME");
      this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)paramLayoutInflater.getParcelable("ARG_SESSION_INFO"));
      this.jdField_c_of_type_Boolean = paramLayoutInflater.getBoolean("ARG_GIF_SEND_TO_AIO");
      if (getArguments().containsKey("KEY_FONT_ID")) {
        this.jdField_b_of_type_JavaLangString = getArguments().getString("KEY_FONT_ID");
      }
      c();
      a();
      b();
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_d_of_type_Boolean = false;
      break;
      f = (j - i) / DisplayUtil.dip2px(this.jdField_a_of_type_AndroidAppActivity, 100.0F);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    if (this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView != null) {
      this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView.a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    bnqm.a().al();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    bnqq.a().i();
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnu
 * JD-Core Version:    0.7.0.1
 */