package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import java.io.File;

public abstract class AIORichMediaData
  implements Parcelable
{
  public static final Parcelable.Creator<AIORichMediaData> CREATOR = new AIORichMediaData.1();
  public long L;
  public int M = 0;
  public long N;
  public long O;
  public long P;
  public int Q = 0;
  public boolean R = false;
  public boolean S;
  public boolean T;
  
  static AIORichMediaData b(String paramString)
  {
    if (AIOImageData.class.getSimpleName().equals(paramString)) {
      return new AIOImageData();
    }
    if (AIOShortVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOShortVideoData();
    }
    if (AIODevLittleVideoData.class.getSimpleName().equals(paramString)) {
      return new AIODevLittleVideoData();
    }
    if (AIOFilePicData.class.getSimpleName().equals(paramString)) {
      return new AIOFilePicData();
    }
    if (AIOFileVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOFileVideoData();
    }
    if (AIOLightVideoData.class.getSimpleName().equals(paramString)) {
      return new AIOLightVideoData();
    }
    throw new ClassNotFoundException();
  }
  
  public void a(Parcel paramParcel)
  {
    this.L = paramParcel.readLong();
    this.M = paramParcel.readInt();
    this.N = paramParcel.readLong();
    this.O = paramParcel.readLong();
    this.P = paramParcel.readLong();
    this.Q = paramParcel.readInt();
    int i = paramParcel.readInt();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.R = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.S = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    this.T = bool1;
  }
  
  public abstract boolean a(int paramInt);
  
  public abstract String b(int paramInt);
  
  public abstract File c(int paramInt);
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
 * JD-Core Version:    0.7.0.1
 */