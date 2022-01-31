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
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.6;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.7;
import dov.com.qq.im.ae.gif.preview.VideoPlayView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class biuk
  extends Fragment
{
  private final float jdField_a_of_type_Float = 147.0F;
  private final int jdField_a_of_type_Int = 700;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bitf jdField_a_of_type_Bitf;
  private biwd jdField_a_of_type_Biwd;
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
  private VideoPlayView jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final float jdField_b_of_type_Float = 58.799999F;
  private final int jdField_b_of_type_Int = 600;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public static Fragment a(String paramString1, Boolean paramBoolean, String paramString2, SessionWrap paramSessionWrap, boolean paramBoolean1)
  {
    biuk localbiuk = new biuk();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString1);
    localBundle.putString("KEY_AVAILABLE_SAVENAME", paramString2);
    localBundle.putBoolean("KEY_MATERIAL_APPLIED", paramBoolean.booleanValue());
    localBundle.putParcelable("ARG_SESSION_INFO", paramSessionWrap);
    localBundle.putBoolean("ARG_GIF_SEND_TO_AIO", paramBoolean1);
    localbiuk.setArguments(localBundle);
    return localbiuk;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367062).setOnClickListener(new biul(this));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362523);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367063).setOnClickListener(new bium(this));
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(true);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new biup(this));
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
  
  private void a(String paramString1, SessionWrap paramSessionWrap, String paramString2)
  {
    if (!new File(paramString1).exists()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ARG_GIF_PATH", paramString1);
    localBundle.putString("curFriendUin", paramSessionWrap.jdField_a_of_type_JavaLangString);
    localBundle.putString("curFriendNick", paramSessionWrap.jdField_b_of_type_JavaLangString);
    localBundle.putString("troopUin", paramSessionWrap.c);
    localBundle.putInt("curType", paramSessionWrap.jdField_a_of_type_Int);
    localBundle.putString("forward_summary_extra", paramString2);
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_SEND_GIF", localBundle, null);
    getActivity().setResult(201);
    getActivity().finish();
  }
  
  private void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new biuo(this));
  }
  
  private void b()
  {
    a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView = ((VideoPlayView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378900));
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView.a(this.jdField_a_of_type_AndroidMediaMediaPlayer);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371163));
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setVisibility(0);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOnClickListener(new biuq(this));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372849);
    localRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_Bitf = new bitf((BaseVMPeakActivity)this.jdField_a_of_type_AndroidAppActivity, localRelativeLayout, this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView);
    this.jdField_a_of_type_Bitf.a();
  }
  
  private void d()
  {
    biur localbiur = biur.a(null, false);
    localbiur.a(this.jdField_a_of_type_Bitf);
    getFragmentManager().beginTransaction().add(2131366671, localbiur).addToBackStack(null).commit();
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      bfny.a(new AEGIFSinglePreviewFragment.6(this));
    }
  }
  
  private void f()
  {
    bfny.a(new AEGIFSinglePreviewFragment.7(this));
  }
  
  private void g()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372826);
    float f2 = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLeft() / localRelativeLayout.getWidth();
    float f3 = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getTop() / localRelativeLayout.getHeight();
    float f1 = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.a() + this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.b() * 2.0F;
    if (this.jdField_a_of_type_Bitf.a().indexOf('\n') > 0) {}
    for (f1 = f1 * 2.5F / baxn.a(this.jdField_a_of_type_AndroidAppActivity, 250.0F);; f1 = f1 * 1.2F / baxn.a(this.jdField_a_of_type_AndroidAppActivity, 250.0F))
    {
      if (this.jdField_a_of_type_Bitf.a().length() > 0) {
        this.jdField_a_of_type_Biwd.a(this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.a(), f2, f3, 1.0F, f1);
      }
      return;
    }
  }
  
  private void h()
  {
    bizt.a().I();
  }
  
  protected int a()
  {
    return 2131558521;
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
    int j = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 700.0F);
    if (i < j)
    {
      this.d = true;
      if (this.d)
      {
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372826);
        paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
        if (i >= baxn.a(this.jdField_a_of_type_AndroidAppActivity, 600.0F)) {
          break label224;
        }
        paramViewGroup.topMargin = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 58.799999F);
        label109:
        paramLayoutInflater.setLayoutParams(paramViewGroup);
      }
      paramLayoutInflater = getArguments();
      this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getString("KEY_PREVIEW_SOURCE_PATH");
      this.jdField_b_of_type_Boolean = paramLayoutInflater.getBoolean("KEY_MATERIAL_APPLIED");
      this.jdField_b_of_type_JavaLangString = paramLayoutInflater.getString("KEY_AVAILABLE_SAVENAME");
      this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)paramLayoutInflater.getParcelable("ARG_SESSION_INFO"));
      this.c = paramLayoutInflater.getBoolean("ARG_GIF_SEND_TO_AIO");
      if ((this.jdField_b_of_type_Boolean) || (!bizx.a().a().equals("none"))) {
        break label267;
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
      label224:
      float f = (j - i) / baxn.a(this.jdField_a_of_type_AndroidAppActivity, 100.0F);
      paramViewGroup.topMargin = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 147.0F - f * 88.199997F);
      break label109;
      label267:
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
    bizt.a().H();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    bizx.a().j();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biuk
 * JD-Core Version:    0.7.0.1
 */