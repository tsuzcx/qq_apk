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
import dov.com.qq.im.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.giftext.fragment.AEGIFSinglePreviewFragment.6;
import dov.com.qq.im.giftext.fragment.AEGIFSinglePreviewFragment.7;
import dov.com.qq.im.preview.VideoPlayView;
import java.io.IOException;
import java.util.ArrayList;

public class bhtr
  extends Fragment
{
  private final float jdField_a_of_type_Float = 147.0F;
  private final int jdField_a_of_type_Int = 700;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bhsk jdField_a_of_type_Bhsk;
  private biaw jdField_a_of_type_Biaw;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView;
  private VideoPlayView jdField_a_of_type_DovComQqImPreviewVideoPlayView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final float jdField_b_of_type_Float = 58.799999F;
  private final int jdField_b_of_type_Int = 600;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public static Fragment a(String paramString1, Boolean paramBoolean, String paramString2)
  {
    bhtr localbhtr = new bhtr();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString1);
    localBundle.putString("KEY_AVAILABLE_SAVENAME", paramString2);
    localBundle.putBoolean("KEY_MATERIAL_APPLIED", paramBoolean.booleanValue());
    localbhtr.setArguments(localBundle);
    return localbhtr;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301452).setOnClickListener(new bhts(this));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131296983);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301453).setOnClickListener(new bhtt(this));
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(true);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new bhtw(this));
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
  
  private void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new bhtv(this));
  }
  
  private void b()
  {
    a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_DovComQqImPreviewVideoPlayView = ((VideoPlayView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131313071));
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_DovComQqImPreviewVideoPlayView.a(this.jdField_a_of_type_AndroidMediaMediaPlayer);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131305470));
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setVisibility(0);
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setOnClickListener(new bhtx(this));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131307135);
    localRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_Bhsk = new bhsk((BaseVMPeakActivity)this.jdField_a_of_type_AndroidAppActivity, localRelativeLayout, this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView);
    this.jdField_a_of_type_Bhsk.a();
  }
  
  private void d()
  {
    bhty localbhty = bhty.a(null, false);
    localbhty.a(this.jdField_a_of_type_Bhsk);
    getFragmentManager().beginTransaction().add(2131301060, localbhty).addToBackStack(null).commit();
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      befn.a(new AEGIFSinglePreviewFragment.6(this));
    }
  }
  
  private void f()
  {
    befn.a(new AEGIFSinglePreviewFragment.7(this));
  }
  
  private void g()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131307112);
    float f2 = this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.getLeft() / localRelativeLayout.getWidth();
    float f3 = this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.getTop() / localRelativeLayout.getHeight();
    float f1 = this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.a() + this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.b() * 2.0F;
    if (this.jdField_a_of_type_Bhsk.a().indexOf('\n') > 0) {}
    for (f1 = f1 * 2.5F / azvv.a(this.jdField_a_of_type_AndroidAppActivity, 250.0F);; f1 = f1 * 1.2F / azvv.a(this.jdField_a_of_type_AndroidAppActivity, 250.0F))
    {
      if (this.jdField_a_of_type_Bhsk.a().length() > 0) {
        this.jdField_a_of_type_Biaw.a(this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.a(), f2, f3, 1.0F, f1);
      }
      return;
    }
  }
  
  private void h()
  {
    bhci.a().G();
  }
  
  protected int a()
  {
    return 2131492970;
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
    int j = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 700.0F);
    if (i < j)
    {
      this.c = true;
      if (this.c)
      {
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131307112);
        paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
        if (i >= azvv.a(this.jdField_a_of_type_AndroidAppActivity, 600.0F)) {
          break label201;
        }
        paramViewGroup.topMargin = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 58.799999F);
        label109:
        paramLayoutInflater.setLayoutParams(paramViewGroup);
      }
      paramLayoutInflater = getArguments();
      this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getString("KEY_PREVIEW_SOURCE_PATH");
      this.jdField_b_of_type_Boolean = paramLayoutInflater.getBoolean("KEY_MATERIAL_APPLIED");
      this.jdField_b_of_type_JavaLangString = paramLayoutInflater.getString("KEY_AVAILABLE_SAVENAME");
      if ((this.jdField_b_of_type_Boolean) || (!bhcm.a().a().equals("none"))) {
        break label244;
      }
      this.jdField_b_of_type_Boolean = false;
      c();
    }
    for (;;)
    {
      a();
      b();
      return this.jdField_a_of_type_AndroidViewViewGroup;
      this.c = false;
      break;
      label201:
      float f = (j - i) / azvv.a(this.jdField_a_of_type_AndroidAppActivity, 100.0F);
      paramViewGroup.topMargin = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 147.0F - f * 88.199997F);
      break label109;
      label244:
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    if (this.jdField_a_of_type_DovComQqImPreviewVideoPlayView != null) {
      this.jdField_a_of_type_DovComQqImPreviewVideoPlayView.a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    bhci.a().F();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    bhcm.a().j();
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
 * Qualified Name:     bhtr
 * JD-Core Version:    0.7.0.1
 */