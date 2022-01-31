import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.9;
import dov.com.qq.im.ae.gif.preview.VideoPlayView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class bkzd
  extends Fragment
{
  private final float jdField_a_of_type_Float = 147.0F;
  private final int jdField_a_of_type_Int = 700;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bkxy jdField_a_of_type_Bkxy;
  private blax jdField_a_of_type_Blax;
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
  private VideoPlayView jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final float jdField_b_of_type_Float = 58.799999F;
  private final int jdField_b_of_type_Int = 600;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public static Fragment a(String paramString1, Boolean paramBoolean, String paramString2, String paramString3, SessionWrap paramSessionWrap, boolean paramBoolean1)
  {
    bkzd localbkzd = new bkzd();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString1);
    localBundle.putString("KEY_AVAILABLE_SAVENAME", paramString3);
    localBundle.putBoolean("KEY_MATERIAL_APPLIED", paramBoolean.booleanValue());
    localBundle.putString("ARG_GIF_MATERIAL_ID", paramString2);
    localBundle.putParcelable("ARG_SESSION_INFO", paramSessionWrap);
    localBundle.putBoolean("ARG_GIF_SEND_TO_AIO", paramBoolean1);
    localbkzd.setArguments(localBundle);
    return localbkzd;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367189).setOnClickListener(new bkze(this));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362549);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367190).setOnClickListener(new bkzf(this));
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378856).setOnClickListener(new bkzg(this));
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(true);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new bkzj(this));
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
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new bkzi(this));
  }
  
  private void a(boolean paramBoolean)
  {
    blfg.b("AEGIFSinglePreviewFragment", "saveAndSend---onlySave=" + paramBoolean);
    e();
    this.jdField_a_of_type_Blax = new blax(this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_b_of_type_Boolean) {
      g();
    }
    this.jdField_a_of_type_Blax.a(new bkzh(this, paramBoolean));
  }
  
  private void b()
  {
    a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView = ((VideoPlayView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379542));
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView.a(this.jdField_a_of_type_AndroidMediaMediaPlayer);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371475));
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setVisibility(0);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOnClickListener(new bkzk(this));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373287);
    localRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_Bkxy = new bkxy((BaseVMPeakActivity)this.jdField_a_of_type_AndroidAppActivity, localRelativeLayout, this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView);
    this.jdField_a_of_type_Bkxy.a();
  }
  
  private void d()
  {
    bkzl localbkzl = bkzl.a(null, false);
    localbkzl.a(this.jdField_a_of_type_Bkxy);
    getFragmentManager().beginTransaction().add(2131366789, localbkzl).addToBackStack(null).commit();
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      bhot.a(new AEGIFSinglePreviewFragment.8(this));
    }
  }
  
  private void f()
  {
    bhot.a(new AEGIFSinglePreviewFragment.9(this));
  }
  
  private void g()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373264);
    float f2 = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLeft() / localRelativeLayout.getWidth();
    float f3 = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getTop() / localRelativeLayout.getHeight();
    float f1 = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.a() + this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.b() * 2.0F;
    if (this.jdField_a_of_type_Bkxy.a().indexOf('\n') > 0) {}
    for (f1 = f1 * 2.5F / bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 250.0F);; f1 = f1 * 1.2F / bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 250.0F))
    {
      if (this.jdField_a_of_type_Bkxy.a().length() > 0) {
        this.jdField_a_of_type_Blax.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.a(), f2, f3, 1.0F, f1);
      }
      return;
    }
  }
  
  protected int a()
  {
    return 2131558545;
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
    int j = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 700.0F);
    if (i < j)
    {
      this.d = true;
      if (this.d)
      {
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373264);
        paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
        if (i >= bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 600.0F)) {
          break label262;
        }
        paramViewGroup.topMargin = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 58.799999F);
        label109:
        paramLayoutInflater.setLayoutParams(paramViewGroup);
      }
      paramLayoutInflater = getArguments();
      this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getString("KEY_PREVIEW_SOURCE_PATH");
      this.jdField_b_of_type_Boolean = paramLayoutInflater.getBoolean("KEY_MATERIAL_APPLIED");
      this.jdField_b_of_type_JavaLangString = paramLayoutInflater.getString("ARG_GIF_MATERIAL_ID");
      blfg.b("AEGIFSinglePreviewFragment", "receive materialId=" + this.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = paramLayoutInflater.getString("KEY_AVAILABLE_SAVENAME");
      this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)paramLayoutInflater.getParcelable("ARG_SESSION_INFO"));
      this.jdField_c_of_type_Boolean = paramLayoutInflater.getBoolean("ARG_GIF_SEND_TO_AIO");
      if ((this.jdField_b_of_type_Boolean) || (!bler.a().b().equals("none"))) {
        break label305;
      }
      this.jdField_b_of_type_Boolean = false;
      c();
    }
    for (;;)
    {
      a();
      b();
      return this.jdField_a_of_type_AndroidViewViewGroup;
      this.d = false;
      break;
      label262:
      float f = (j - i) / bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 100.0F);
      paramViewGroup.topMargin = bcwh.a(this.jdField_a_of_type_AndroidAppActivity, 147.0F - f * 88.199997F);
      break label109;
      label305:
      this.jdField_b_of_type_Boolean = true;
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
    blen.a().P();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    bler.a().i();
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
 * Qualified Name:     bkzd
 * JD-Core Version:    0.7.0.1
 */