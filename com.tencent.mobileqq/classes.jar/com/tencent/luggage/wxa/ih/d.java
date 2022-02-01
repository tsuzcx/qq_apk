package com.tencent.luggage.wxa.ih;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Landroid/os/Parcelable;", "title", "", "templateId", "templateType", "", "chooseStatus", "keyWordList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "settingStatus", "isOpened", "", "sceneDesc", "wxaSubscribeStatusString", "isBaned", "tid", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;Ljava/lang/String;ZI)V", "item", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "(Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;Ljava/util/ArrayList;)V", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;IZLjava/lang/String;)V", "switchOpened", "(Ljava/lang/String;IIZ)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "()Z", "isFromProfile", "setFromProfile", "(Z)V", "isOpen", "setOpen", "getKeyWordList", "()Ljava/util/ArrayList;", "getSceneDesc", "()Ljava/lang/String;", "getSettingStatus", "setSettingStatus", "getTemplateId", "templateType$annotations", "()V", "getTemplateType", "getTid", "getTitle", "updateTimestamp", "", "getUpdateTimestamp", "()J", "setUpdateTimestamp", "(J)V", "getWxaSubscribeStatusString", "describeContents", "toString", "writeToParcel", "", "dest", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class d
  implements Parcelable
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<d> CREATOR = (Parcelable.Creator)new d.b();
  public static final d.a a = new d.a(null);
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  private final int e;
  private int f;
  @NotNull
  private final ArrayList<Pair<String, String>> g;
  private int h;
  private boolean i;
  private long j;
  private boolean k;
  @NotNull
  private final String l;
  private final boolean m;
  private final int n;
  
  public d(@NotNull Parcel paramParcel)
  {
    Object localObject = paramParcel.readString();
    if (localObject == null) {
      localObject = "";
    }
    this.c = ((String)localObject);
    localObject = paramParcel.readString();
    if (localObject == null) {
      localObject = "";
    }
    this.d = ((String)localObject);
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    int i1 = paramParcel.readInt();
    this.g = new ArrayList(i1);
    for (;;)
    {
      if (i1 != 0) {}
      try
      {
        localObject = this.g;
        Serializable localSerializable = paramParcel.readSerializable();
        if (localSerializable != null)
        {
          ((ArrayList)localObject).add((Pair)localSerializable);
          i1 -= 1;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.String>");
        }
      }
      catch (InvalidClassException localInvalidClassException)
      {
        label140:
        boolean bool2;
        int i2;
        boolean bool1;
        break label140;
      }
    }
    this.h = paramParcel.readInt();
    i1 = paramParcel.readByte();
    bool2 = false;
    i2 = (byte)0;
    if (i1 != i2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.i = bool1;
    this.j = paramParcel.readLong();
    localObject = paramParcel.readString();
    if (localObject == null) {
      localObject = "";
    }
    this.b = ((String)localObject);
    if (paramParcel.readByte() != i2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.k = bool1;
    localObject = paramParcel.readString();
    if (localObject == null) {
      localObject = "";
    }
    this.l = ((String)localObject);
    this.n = paramParcel.readInt();
    bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    this.m = bool1;
  }
  
  public d(@NotNull String paramString1, @NotNull String paramString2, int paramInt1, int paramInt2, @NotNull ArrayList<Pair<String, String>> paramArrayList, int paramInt3, boolean paramBoolean1, @NotNull String paramString3, @NotNull String paramString4, boolean paramBoolean2, int paramInt4)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramArrayList;
    this.h = paramInt3;
    this.i = paramBoolean1;
    this.j = 0L;
    this.b = paramString3;
    this.k = false;
    this.l = paramString4;
    this.n = paramInt4;
    this.m = paramBoolean2;
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  @NotNull
  public final String b()
  {
    return this.c;
  }
  
  @NotNull
  public final String c()
  {
    return this.d;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int e()
  {
    return this.f;
  }
  
  @NotNull
  public final ArrayList<Pair<String, String>> f()
  {
    return this.g;
  }
  
  public final int g()
  {
    return this.h;
  }
  
  public final boolean h()
  {
    return this.i;
  }
  
  @NotNull
  public final String i()
  {
    return this.l;
  }
  
  public final boolean j()
  {
    return this.m;
  }
  
  public final int k()
  {
    return this.n;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubscribeMsgTmpItem(title='");
    localStringBuilder.append(this.c);
    localStringBuilder.append("', templateId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append("', templateType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", chooseStatus=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", settingStatus=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", settingStatus=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", CREATOR=");
    localStringBuilder.append(CREATOR);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@Nullable Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ih.d
 * JD-Core Version:    0.7.0.1
 */