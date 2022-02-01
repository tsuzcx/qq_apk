package com.tencent.aelight.camera.aeeditor.data;

import com.tencent.aelight.camera.aeeditor.module.export.AEEditorGenerateRunnable;
import com.tencent.qcircle.weseevideo.model.MediaModel;

public class AEEditorVideoInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public float e;
  public long f;
  public String g;
  public String h;
  public AEEditorGenerateRunnable i;
  public MediaModel j;
  public int k;
  public String l;
  public long m;
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public int r = 0;
  public String s = "";
  public float t = 0.0F;
  public float u = 0.0F;
  public float v = 0.0F;
  public float w = 0.0F;
  public float x = 0.0F;
  
  public AEEditorVideoInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, MediaModel paramMediaModel, String paramString9, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.n = paramString1;
    this.o = paramString2;
    this.p = paramString3;
    this.q = paramString4;
    this.r = paramInt;
    this.b = paramString6;
    this.c = paramString7;
    this.h = paramString5;
    this.d = paramString8;
    this.j = paramMediaModel;
    this.g = "AEEDITOR_GENERATE_STATUS_WAIT";
    this.k = 0;
    this.f = 0L;
    this.s = paramString9;
    this.t = paramFloat1;
    this.u = paramFloat2;
    this.w = paramFloat3;
    this.x = paramFloat4;
    this.v = paramFloat5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.data.AEEditorVideoInfo
 * JD-Core Version:    0.7.0.1
 */