package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;

public class AIOFileVideoData
  extends AIORichMediaData
{
  public String a;
  public String b;
  public String c;
  public long d;
  public int e;
  public int f;
  public String g;
  public String h;
  public String i;
  public long j;
  public String k;
  public boolean l = false;
  public boolean m = false;
  public long n = 0L;
  public boolean o = false;
  public boolean p = false;
  public boolean q = false;
  public String r;
  public int s;
  public int t;
  public String u;
  public String v;
  private String w = null;
  private boolean x = false;
  
  public AIOFileVideoData() {}
  
  public AIOFileVideoData(String paramString)
  {
    this.b = paramString;
  }
  
  private void a(Context paramContext, VideoPlayControllerForAIO paramVideoPlayControllerForAIO)
  {
    paramVideoPlayControllerForAIO = new AIOFileVideoData.1(this, paramContext, paramVideoPlayControllerForAIO);
    FMDialogUtil.a(paramContext, paramContext.getString(2131889584), paramContext.getString(2131889586), paramVideoPlayControllerForAIO);
  }
  
  private boolean e()
  {
    if (this.q) {
      return false;
    }
    if (!FileManagerUtil.b()) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.a)) && (this.O > 0L) && (this.O > this.d)) {
      return true;
    }
    return this.O > 1048576L;
  }
  
  public VideoPlayMedioInfo a(boolean paramBoolean)
  {
    VideoPlayMedioInfo localVideoPlayMedioInfo = new VideoPlayMedioInfo();
    localVideoPlayMedioInfo.c = new String[] { this.g };
    localVideoPlayMedioInfo.d = new ArrayList();
    localVideoPlayMedioInfo.d.add(this.h);
    localVideoPlayMedioInfo.a = (a() ^ true);
    String str;
    if (localVideoPlayMedioInfo.a) {
      str = this.i;
    } else {
      str = this.c;
    }
    localVideoPlayMedioInfo.b = str;
    localVideoPlayMedioInfo.o = this.n;
    localVideoPlayMedioInfo.h = true;
    localVideoPlayMedioInfo.n = this.O;
    localVideoPlayMedioInfo.k = this.L;
    localVideoPlayMedioInfo.l = this.M;
    localVideoPlayMedioInfo.m = paramBoolean;
    return localVideoPlayMedioInfo;
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = paramParcel.readString();
    this.a = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    int i1 = paramParcel.readInt();
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    this.o = bool;
    this.r = paramParcel.readString();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
    this.u = paramParcel.readString();
    this.v = paramParcel.readString();
  }
  
  public void a(View paramView, VideoPlayControllerForAIO paramVideoPlayControllerForAIO)
  {
    if (e())
    {
      if (QFileUtils.a(paramView.getContext(), false, new AIOFileVideoData.2(this, paramVideoPlayControllerForAIO, paramView))) {
        a(paramView.getContext(), paramVideoPlayControllerForAIO);
      }
    }
    else
    {
      if (this.x)
      {
        this.x = false;
        paramVideoPlayControllerForAIO.a(paramView, a(false));
      }
      paramVideoPlayControllerForAIO.c();
      paramVideoPlayControllerForAIO.h();
    }
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.r = paramDataLineMsgRecord.frienduin;
    this.s = paramDataLineMsgRecord.istroop;
    this.t = paramDataLineMsgRecord.issend;
    this.L = paramDataLineMsgRecord.uniseq;
    this.N = paramDataLineMsgRecord.time;
    this.P = paramDataLineMsgRecord.shmsgseq;
    this.O = paramDataLineMsgRecord.filesize;
    this.a = paramDataLineMsgRecord.filename;
    this.Q = 0;
    if (FileUtils.fileExistsAndNotEmpty(paramDataLineMsgRecord.path))
    {
      this.c = paramDataLineMsgRecord.path;
      this.o = true;
    }
  }
  
  public void a(String paramString)
  {
    this.w = paramString;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.c)) {
      return true;
    }
    if (this.o)
    {
      this.c = this.i;
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return FileUtil.b(this.b);
  }
  
  public boolean a(IAIOImageProvider paramIAIOImageProvider)
  {
    if (a()) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.i))) {
      return false;
    }
    paramIAIOImageProvider.a(this.L, this.M, 16842753);
    return true;
  }
  
  public String b(int paramInt)
  {
    if (TextUtils.isEmpty(this.b)) {
      return "";
    }
    if (!this.b.startsWith("/"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:/");
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
    if (this.b.startsWith("//"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    return TextUtils.isEmpty(this.w) ^ true;
  }
  
  public File c(int paramInt)
  {
    if (!FileUtil.b(this.b)) {
      return null;
    }
    return new File(this.b);
  }
  
  public String c()
  {
    return this.w;
  }
  
  public void d()
  {
    this.o = true;
    this.x = true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */