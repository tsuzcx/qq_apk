package com.tencent.aelight.camera.aeeditor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class AEEditorLauncher
{
  public static void a(Activity paramActivity, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    int i;
    if (paramInt1 == 0)
    {
      i = 10000;
    }
    else if (paramInt1 == 1)
    {
      i = 10001;
    }
    else
    {
      if ((paramInt1 != 2) && (paramInt1 != 3)) {
        throw new IllegalArgumentException("wrong editor type");
      }
      i = 10002;
    }
    Intent localIntent1 = new Intent(paramActivity, AEEditorActivity.class);
    if (paramBundle != null) {
      paramBundle = new Bundle(paramBundle);
    } else {
      paramBundle = new Bundle();
    }
    paramBundle.putInt("editorType", paramInt1);
    paramBundle.putInt("editorFrom", paramInt2);
    if (paramActivity.getIntent() != null)
    {
      Intent localIntent2 = paramActivity.getIntent();
      a(paramBundle, localIntent2, "editor_filter_id");
      a(paramBundle, localIntent2, "editor_text_sticker_id");
      a(paramBundle, localIntent2, "editor_image_template_id");
      a(paramBundle, localIntent2, "editor_video_template_id");
      a(paramBundle, localIntent2, "editor_text_id");
      a(paramBundle, localIntent2, "editor_frame_id");
      paramBundle.putBoolean("key_is_capsule_button", localIntent2.getBooleanExtra("key_is_capsule_button", false));
    }
    localIntent1.putExtras(paramBundle);
    localIntent1.addFlags(603979776);
    paramActivity.startActivityForResult(localIntent1, i);
  }
  
  private static void a(Bundle paramBundle, Intent paramIntent, String paramString)
  {
    paramBundle.putString(paramString, paramIntent.getStringExtra(paramString));
    paramIntent.putExtra(paramString, "");
  }
  
  public static boolean a(Bundle paramBundle)
  {
    return a(paramBundle, 0);
  }
  
  private static boolean a(Bundle paramBundle, int paramInt)
  {
    boolean bool = false;
    if (paramBundle == null) {
      return false;
    }
    if (!paramBundle.containsKey("editorType")) {
      return false;
    }
    if (paramBundle.getInt("editorType") == paramInt) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(Bundle paramBundle)
  {
    return a(paramBundle, 1);
  }
  
  public static boolean c(Bundle paramBundle)
  {
    return a(paramBundle, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.AEEditorLauncher
 * JD-Core Version:    0.7.0.1
 */