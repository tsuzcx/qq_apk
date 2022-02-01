package com.tencent.aelight.camera.entry.api;

import android.text.TextUtils;

public class AECameraEntry
{
  public static final AECameraEntry A = new AECameraEntry("circleGuidePicker", 28);
  public static final AECameraEntry B = new AECameraEntry("tribeShortVideoPicker", 29);
  public static final AECameraEntry C = new AECameraEntry("kanDianUGCPicPicker", 30);
  public static final AECameraEntry D = new AECameraEntry("ad", 33);
  public static final AECameraEntry E = new AECameraEntry("circleMultiCutAdditionalPick", 34);
  public static final AECameraEntry F = new AECameraEntry("webFromAIO", 35);
  public static final AECameraEntry G = new AECameraEntry("bless", 36);
  public static final AECameraEntry H = new AECameraEntry("miniAppPlay", 38);
  public static final AECameraEntry I = new AECameraEntry("miniAppTakePhoto", 39);
  public static final AECameraEntry J = new AECameraEntry("aioARCake", 40);
  public static final AECameraEntry K = new AECameraEntry("autoTemplateMidPage", 41);
  public static final AECameraEntry L = new AECameraEntry("flashShow", 42);
  public static final AECameraEntry M = new AECameraEntry("qudongTakeFacePhoto", 1001, false);
  public static final AECameraEntry N = new AECameraEntry("web", 1002, false);
  public static final AECameraEntry O = new AECameraEntry("faceUnlock", 1003, false);
  private static final AECameraEntry[] P = { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, M, N, v, x, z, B, C, F, G, D, H, I, O, J };
  public static final AECameraEntry a = new AECameraEntry("", -1);
  public static final AECameraEntry b = new AECameraEntry("h5", 0);
  public static final AECameraEntry c = new AECameraEntry("mainCamera", 1);
  public static final AECameraEntry d = new AECameraEntry("", 2);
  public static final AECameraEntry e = new AECameraEntry("aioMainCamera", 3);
  public static final AECameraEntry f = new AECameraEntry("", 4);
  public static final AECameraEntry g = new AECameraEntry("qzoneCamera", 5);
  public static final AECameraEntry h = new AECameraEntry("", 6);
  public static final AECameraEntry i = new AECameraEntry("aioGifCamera", 7);
  public static final AECameraEntry j = new AECameraEntry("", 8);
  public static final AECameraEntry k = new AECameraEntry("aioGroupSignin", 9);
  public static final AECameraEntry l = new AECameraEntry("qzoneSignin", 10);
  public static final AECameraEntry m = new AECameraEntry("qzoneBanner", 11);
  public static final AECameraEntry n = new AECameraEntry("qzoneTail", 12);
  public static final AECameraEntry o = new AECameraEntry("qzoneMoodList", 13);
  public static final AECameraEntry p = new AECameraEntry("", 14);
  public static final AECameraEntry q = new AECameraEntry("qzoneFriendPlus", 15);
  public static final AECameraEntry r = new AECameraEntry("qzoneFriendState", 16);
  public static final AECameraEntry s = new AECameraEntry("qzoneSlideCamera", 17);
  public static final AECameraEntry t = new AECameraEntry("aioChats", 18);
  public static final AECameraEntry u = new AECameraEntry("massSendBless", 19);
  public static final AECameraEntry v = new AECameraEntry("qzonePublishFrame", 20);
  public static final AECameraEntry w = new AECameraEntry("aioGifCameraTail", 23);
  public static final AECameraEntry x = new AECameraEntry("circleCamera", 25);
  public static final AECameraEntry y = new AECameraEntry("circlePickCamera", 26);
  public static final AECameraEntry z = new AECameraEntry("circleGuideCamera", 27);
  private String Q;
  private int R;
  private boolean S;
  
  private AECameraEntry(String paramString, int paramInt)
  {
    this.R = paramInt;
    this.Q = paramString;
    this.S = true;
  }
  
  private AECameraEntry(String paramString, int paramInt, boolean paramBoolean)
  {
    this.R = paramInt;
    this.Q = paramString;
    this.S = paramBoolean;
  }
  
  public static AECameraEntry a(int paramInt)
  {
    AECameraEntry[] arrayOfAECameraEntry = P;
    int i2 = arrayOfAECameraEntry.length;
    int i1 = 0;
    while (i1 < i2)
    {
      AECameraEntry localAECameraEntry = arrayOfAECameraEntry[i1];
      if (paramInt == localAECameraEntry.a()) {
        return localAECameraEntry;
      }
      i1 += 1;
    }
    return a;
  }
  
  public static AECameraEntry a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return a;
    }
    AECameraEntry[] arrayOfAECameraEntry = P;
    int i2 = arrayOfAECameraEntry.length;
    int i1 = 0;
    while (i1 < i2)
    {
      AECameraEntry localAECameraEntry = arrayOfAECameraEntry[i1];
      if ((!TextUtils.isEmpty(localAECameraEntry.b())) && (paramString.equals(localAECameraEntry.b()))) {
        return localAECameraEntry;
      }
      i1 += 1;
    }
    return a;
  }
  
  public int a()
  {
    return this.R;
  }
  
  public String b()
  {
    return this.Q;
  }
  
  public boolean b(int paramInt)
  {
    return this.R == paramInt;
  }
  
  public boolean c()
  {
    return this.S;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.entry.api.AECameraEntry
 * JD-Core Version:    0.7.0.1
 */