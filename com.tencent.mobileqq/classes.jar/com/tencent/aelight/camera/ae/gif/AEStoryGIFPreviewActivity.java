package com.tencent.aelight.camera.ae.gif;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment;
import com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment;
import com.tencent.aelight.camera.aebase.BaseVMPeakActivity;
import com.tencent.aelight.camera.log.AEQLog;
import dov.com.qq.im.ae.current.SessionWrap;

public class AEStoryGIFPreviewActivity
  extends BaseVMPeakActivity
{
  private SessionWrap jdField_a_of_type_DovComQqImAeCurrentSessionWrap;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private String c;
  private String d;
  private String e = "";
  
  protected boolean a()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 21) && (paramInt2 == -1))
    {
      setResult(201);
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.j = false;
    super.onCreate(paramBundle);
    setContentView(2064318596);
    paramBundle = getIntent().getStringExtra("KEY_PREVIEW_SOURCE_PATH");
    getIntent().getIntExtra("AECAMERA_MODE", 200);
    this.b = getIntent().getBooleanExtra("KEY_MATERIAL_APPLIED", false);
    this.c = getIntent().getStringExtra("ARG_GIF_MATERIAL_ID");
    this.e = getIntent().getStringExtra("KEY_AVAILABLE_SAVENAME");
    this.jdField_a_of_type_DovComQqImAeCurrentSessionWrap = ((SessionWrap)getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    boolean bool = getIntent().getBooleanExtra("ARG_GIF_SEND_TO_AIO", false);
    long l = getIntent().getLongExtra("KEY_AVAILABLE_EMO_COUNT", 9223372036854775807L);
    if (getIntent().hasExtra("KEY_FONT_ID")) {
      this.d = getIntent().getStringExtra("KEY_FONT_ID");
    }
    FragmentManager localFragmentManager = getFragmentManager();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onCreate], materialApplied=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", materialId=");
    localStringBuilder.append(this.c);
    AEQLog.a("BaseActivity2", localStringBuilder.toString());
    if ((!this.b) && (TextUtils.isEmpty(this.c)))
    {
      if (localFragmentManager.findFragmentByTag(AEGIFChunkPreviewFragment.class.getSimpleName()) == null) {
        localFragmentManager.beginTransaction().add(2064122227, AEGIFChunkPreviewFragment.a(paramBundle, l, this.d), AEGIFChunkPreviewFragment.class.getSimpleName()).commit();
      }
    }
    else if (localFragmentManager.findFragmentByTag(AEGIFSinglePreviewFragment.class.getSimpleName()) == null) {
      localFragmentManager.beginTransaction().add(2064122227, AEGIFSinglePreviewFragment.a(paramBundle, Boolean.valueOf(this.b), this.c, this.e, this.jdField_a_of_type_DovComQqImAeCurrentSessionWrap, bool, this.d), AEGIFSinglePreviewFragment.class.getSimpleName()).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEStoryGIFPreviewActivity
 * JD-Core Version:    0.7.0.1
 */