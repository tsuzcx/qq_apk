package com.tencent.ilive.opensdk.linkmicinterface;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

public class LinkMicUserparams
{
  public boolean enableReceiveAudio;
  public int linkMicType = 1;
  public String linkRoomSig;
  public Map<String, Object> params = new HashMap();
  public Rect renderRect;
  public long roomId;
  public View rootView;
  public byte[] sig;
  public String toUid;
  public String uid;
  public Bitmap videoSourceBitmap;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.linkmicinterface.LinkMicUserparams
 * JD-Core Version:    0.7.0.1
 */