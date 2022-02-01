package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import java.io.File;

public class AIOFilePicData
  extends AIORichMediaData
{
  public String a;
  public int b;
  public String c = "I:N";
  public String d = "I:N";
  public String e = "I:N";
  public String f = "I:N";
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public FileManagerEntity j;
  public boolean k = false;
  public long l = 0L;
  public long m = 0L;
  public boolean n = false;
  public String o;
  public int p;
  public String q;
  public String r;
  public boolean s = false;
  public String t;
  public int u;
  public int v;
  public int w;
  
  public int a(String paramString)
  {
    return 0;
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readInt();
    this.q = paramParcel.readString();
    this.k = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.l = Long.valueOf(paramParcel.readString()).longValue();
    this.m = Long.valueOf(paramParcel.readString()).longValue();
    this.n = Boolean.valueOf(paramParcel.readString()).booleanValue();
    this.r = paramParcel.readString();
    int i1 = paramParcel.readInt();
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    this.s = bool;
    this.t = paramParcel.readString();
    this.u = paramParcel.readInt();
    this.v = paramParcel.readInt();
    this.w = paramParcel.readInt();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.j == null) {
      this.j = paramQQAppInterface.getFileManagerDataCenter().a(this.L, this.a, this.b);
    }
    paramQQAppInterface = this.j;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.strMiddleThumPath;
      String str = "I:N";
      if (paramQQAppInterface != null) {
        paramQQAppInterface = this.j.strMiddleThumPath;
      } else {
        paramQQAppInterface = "I:N";
      }
      this.c = paramQQAppInterface;
      if (this.j.strLargeThumPath != null) {
        paramQQAppInterface = this.j.strLargeThumPath;
      } else {
        paramQQAppInterface = "I:N";
      }
      this.d = paramQQAppInterface;
      paramQQAppInterface = str;
      if (this.j.getFilePath() != null) {
        paramQQAppInterface = this.j.getFilePath();
      }
      this.e = paramQQAppInterface;
      this.q = this.j.fileName;
      boolean bool;
      if (this.j.status == 16) {
        bool = true;
      } else {
        bool = false;
      }
      this.k = bool;
      this.l = this.j.fileSize;
      this.O = this.j.fileSize;
      this.m = this.j.lastSuccessTime;
      this.n = this.j.sendCloudUnsuccessful();
    }
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord == null) {
      return;
    }
    Object localObject = paramDataLineMsgRecord.thumbPath;
    String str = "I:N";
    if (localObject != null) {
      localObject = paramDataLineMsgRecord.thumbPath;
    } else {
      localObject = "I:N";
    }
    this.c = ((String)localObject);
    if (paramDataLineMsgRecord.thumbPath != null) {
      localObject = paramDataLineMsgRecord.thumbPath;
    } else {
      localObject = "I:N";
    }
    this.d = ((String)localObject);
    localObject = str;
    if (paramDataLineMsgRecord.path != null) {
      localObject = paramDataLineMsgRecord.path;
    }
    this.e = ((String)localObject);
    this.q = paramDataLineMsgRecord.filename;
    this.l = paramDataLineMsgRecord.filesize;
    this.O = paramDataLineMsgRecord.filesize;
    this.n = false;
  }
  
  public void a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    if (paramTroopFileStatusInfo == null) {
      return;
    }
    Object localObject = paramTroopFileStatusInfo.n;
    String str = "I:N";
    if (localObject != null) {
      localObject = paramTroopFileStatusInfo.n;
    } else {
      localObject = "I:N";
    }
    this.c = ((String)localObject);
    if (paramTroopFileStatusInfo.m != null) {
      localObject = paramTroopFileStatusInfo.m;
    } else {
      localObject = "I:N";
    }
    this.d = ((String)localObject);
    localObject = str;
    if (paramTroopFileStatusInfo.k != null) {
      localObject = paramTroopFileStatusInfo.k;
    }
    this.e = ((String)localObject);
    this.q = paramTroopFileStatusInfo.t;
    boolean bool;
    if (paramTroopFileStatusInfo.e == 12) {
      bool = true;
    } else {
      bool = false;
    }
    this.k = bool;
    this.l = paramTroopFileStatusInfo.i;
    this.O = paramTroopFileStatusInfo.i;
    this.n = false;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt != 16)
    {
      if (paramInt != 18) {
        return paramInt == 20;
      }
      return this.d.equals("I:N") ^ true;
    }
    return this.c.equals("I:N") ^ true;
  }
  
  public String b(int paramInt)
  {
    String str;
    if (paramInt != 16)
    {
      if (paramInt != 18)
      {
        if (paramInt != 20) {
          str = null;
        } else {
          str = this.e;
        }
      }
      else {
        str = this.d;
      }
    }
    else {
      str = this.c;
    }
    if ((str != null) && (!str.equals("I:N")))
    {
      if (!str.startsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:/");
        localStringBuilder.append(str);
        return localStringBuilder.toString();
      }
      if (str.startsWith("//"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file:");
        localStringBuilder.append(str);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public File c(int paramInt)
  {
    Object localObject;
    if (paramInt != 16)
    {
      if (paramInt != 18)
      {
        if (paramInt != 20) {
          localObject = null;
        } else {
          localObject = this.e;
        }
      }
      else {
        localObject = this.d;
      }
    }
    else {
      localObject = this.c;
    }
    if ((localObject != null) && (!((String)localObject).equals("I:N")))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFilePicData
 * JD-Core Version:    0.7.0.1
 */