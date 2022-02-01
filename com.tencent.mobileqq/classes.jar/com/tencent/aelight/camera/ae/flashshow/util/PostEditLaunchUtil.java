package com.tencent.aelight.camera.ae.flashshow.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import java.util.ArrayList;
import java.util.Arrays;

public class PostEditLaunchUtil
{
  public static void a(@NonNull Activity paramActivity, int paramInt, @NonNull LocalMediaInfo paramLocalMediaInfo, WinkEditorMusicInfo paramWinkEditorMusicInfo, Integer paramInteger, Float paramFloat)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("localMediaInfos", new ArrayList(Arrays.asList(new LocalMediaInfo[] { paramLocalMediaInfo })));
    localIntent.putExtra("IS_EDIT_TEXT", false);
    localIntent.putExtra("IS_IMAGE_MODEL", false);
    localIntent.putExtra("wink_music_info", paramWinkEditorMusicInfo);
    localIntent.putExtra("music_volume", paramFloat);
    if (paramInteger != null) {
      localIntent.putExtra("music_start_time", paramInteger.intValue());
    }
    localIntent.putExtra("EDITOR_ENTRANCE", 1);
    localIntent.putExtra("IS_FROM_CAPTURE", true);
    localIntent.putExtra("ae_editor_video_flag", true);
    localIntent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
    localIntent.setClass(paramActivity, QQWinkActivity.class);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(@NonNull Activity paramActivity, int paramInt, @NonNull LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("localMediaInfos", new ArrayList(Arrays.asList(new LocalMediaInfo[] { paramLocalMediaInfo })));
    localIntent.putExtra("IS_EDIT_TEXT", false);
    localIntent.putExtra("IS_IMAGE_MODEL", false);
    localIntent.putExtra("EDITOR_ENTRANCE", 1);
    localIntent.putExtra("IS_FROM_CAPTURE", true);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("PUBLISH_SCHEMA_MUSIC_ID", paramString);
    }
    localIntent.putExtra("ae_editor_video_flag", false);
    localIntent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
    localIntent.setClass(paramActivity, QQWinkActivity.class);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(@NonNull Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("ae_editor_video_flag", true);
    localIntent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
    localIntent.setClass(paramActivity, QQWinkActivity.class);
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.util.PostEditLaunchUtil
 * JD-Core Version:    0.7.0.1
 */