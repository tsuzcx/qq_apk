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
  public static final AECameraEntry K = new AECameraEntry("qudongTakeFacePhoto", 1001, false);
  public static final AECameraEntry L = new AECameraEntry("web", 1002, false);
  public static final AECameraEntry M = new AECameraEntry("faceUnlock", 1003, false);
  public static final AECameraEntry a;
  private static final AECameraEntry[] jdField_a_of_type_ArrayOfComTencentAelightCameraEntryApiAECameraEntry = { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, K, L, v, x, z, B, C, F, G, D, H, I, M, J };
  public static final AECameraEntry b;
  public static final AECameraEntry c;
  public static final AECameraEntry d;
  public static final AECameraEntry e;
  public static final AECameraEntry f;
  public static final AECameraEntry g;
  public static final AECameraEntry h;
  public static final AECameraEntry i;
  public static final AECameraEntry j;
  public static final AECameraEntry k;
  public static final AECameraEntry l;
  public static final AECameraEntry m;
  public static final AECameraEntry n;
  public static final AECameraEntry o;
  public static final AECameraEntry p;
  public static final AECameraEntry q;
  public static final AECameraEntry r;
  public static final AECameraEntry s;
  public static final AECameraEntry t;
  public static final AECameraEntry u;
  public static final AECameraEntry v;
  public static final AECameraEntry w;
  public static final AECameraEntry x;
  public static final AECameraEntry y;
  public static final AECameraEntry z;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentAelightCameraEntryApiAECameraEntry = new AECameraEntry("", -1);
    b = new AECameraEntry("h5", 0);
    c = new AECameraEntry("mainCamera", 1);
    d = new AECameraEntry("", 2);
    e = new AECameraEntry("aioMainCamera", 3);
    f = new AECameraEntry("", 4);
    g = new AECameraEntry("qzoneCamera", 5);
    h = new AECameraEntry("", 6);
    i = new AECameraEntry("aioGifCamera", 7);
    j = new AECameraEntry("", 8);
    k = new AECameraEntry("aioGroupSignin", 9);
    l = new AECameraEntry("qzoneSignin", 10);
    m = new AECameraEntry("qzoneBanner", 11);
    n = new AECameraEntry("qzoneTail", 12);
    o = new AECameraEntry("qzoneMoodList", 13);
    p = new AECameraEntry("", 14);
    q = new AECameraEntry("qzoneFriendPlus", 15);
    r = new AECameraEntry("qzoneFriendState", 16);
    s = new AECameraEntry("qzoneSlideCamera", 17);
    t = new AECameraEntry("aioChats", 18);
    u = new AECameraEntry("massSendBless", 19);
    v = new AECameraEntry("qzonePublishFrame", 20);
    w = new AECameraEntry("aioGifCameraTail", 23);
    x = new AECameraEntry("circleCamera", 25);
    y = new AECameraEntry("circlePickCamera", 26);
    z = new AECameraEntry("circleGuideCamera", 27);
  }
  
  private AECameraEntry(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private AECameraEntry(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static AECameraEntry a(int paramInt)
  {
    AECameraEntry[] arrayOfAECameraEntry = jdField_a_of_type_ArrayOfComTencentAelightCameraEntryApiAECameraEntry;
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
    return jdField_a_of_type_ComTencentAelightCameraEntryApiAECameraEntry;
  }
  
  public static AECameraEntry a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_ComTencentAelightCameraEntryApiAECameraEntry;
    }
    AECameraEntry[] arrayOfAECameraEntry = jdField_a_of_type_ArrayOfComTencentAelightCameraEntryApiAECameraEntry;
    int i2 = arrayOfAECameraEntry.length;
    int i1 = 0;
    while (i1 < i2)
    {
      AECameraEntry localAECameraEntry = arrayOfAECameraEntry[i1];
      if ((!TextUtils.isEmpty(localAECameraEntry.a())) && (paramString.equals(localAECameraEntry.a()))) {
        return localAECameraEntry;
      }
      i1 += 1;
    }
    return jdField_a_of_type_ComTencentAelightCameraEntryApiAECameraEntry;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Int == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.entry.api.AECameraEntry
 * JD-Core Version:    0.7.0.1
 */