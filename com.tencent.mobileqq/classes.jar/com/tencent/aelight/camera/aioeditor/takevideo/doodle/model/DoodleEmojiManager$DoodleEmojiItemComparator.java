package com.tencent.aelight.camera.aioeditor.takevideo.doodle.model;

import android.text.TextUtils;
import java.io.File;
import java.util.Comparator;

public class DoodleEmojiManager$DoodleEmojiItemComparator
  implements Comparator<DoodleEmojiItem>
{
  private final String a;
  
  public int a(DoodleEmojiItem paramDoodleEmojiItem1, DoodleEmojiItem paramDoodleEmojiItem2)
  {
    if (TextUtils.equals(this.a, paramDoodleEmojiItem2.pack_id)) {
      return 1;
    }
    if (TextUtils.equals(this.a, paramDoodleEmojiItem1.pack_id)) {
      return -1;
    }
    paramDoodleEmojiItem1 = paramDoodleEmojiItem1.getLocalEmojiFolderPath();
    String str = paramDoodleEmojiItem2.getLocalEmojiFolderPath();
    paramDoodleEmojiItem2 = null;
    if (paramDoodleEmojiItem1 != null) {
      paramDoodleEmojiItem1 = new File(paramDoodleEmojiItem1);
    } else {
      paramDoodleEmojiItem1 = null;
    }
    if (str != null) {
      paramDoodleEmojiItem2 = new File(str);
    }
    int i;
    if ((paramDoodleEmojiItem1 != null) && (paramDoodleEmojiItem1.exists())) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((paramDoodleEmojiItem2 != null) && (paramDoodleEmojiItem2.exists())) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i == 0) && (j == 0)) {
      return 0;
    }
    if (i == 0) {
      return 1;
    }
    if (j == 0) {
      return -1;
    }
    long l = paramDoodleEmojiItem1.lastModified();
    if (paramDoodleEmojiItem2.lastModified() < l) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiItemComparator
 * JD-Core Version:    0.7.0.1
 */