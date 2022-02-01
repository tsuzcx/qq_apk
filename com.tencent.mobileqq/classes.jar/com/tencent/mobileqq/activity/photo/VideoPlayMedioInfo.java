package com.tencent.mobileqq.activity.photo;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.SVUtils;
import java.util.ArrayList;

public class VideoPlayMedioInfo
{
  public boolean a;
  public String b;
  public String[] c;
  public ArrayList<String> d;
  public String e;
  public MessageForShortVideo f;
  public int g;
  public boolean h = false;
  public boolean i = false;
  public boolean j = false;
  public long k = -1L;
  public int l = -1;
  public boolean m;
  public long n = 0L;
  public long o = 0L;
  public long p;
  public long q = 0L;
  public Bundle r = null;
  
  public String a()
  {
    MessageForShortVideo localMessageForShortVideo = this.f;
    if (localMessageForShortVideo == null) {
      return this.b;
    }
    this.b = null;
    this.b = SVUtils.a(localMessageForShortVideo, "mp4");
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo
 * JD-Core Version:    0.7.0.1
 */