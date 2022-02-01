package com.tencent.aelight.camera.aioeditor.capture.text;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.LayerParams;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;

public class TextParcelData
  implements Parcelable
{
  public static final Parcelable.Creator<TextParcelData> CREATOR = new TextParcelData.1();
  public SegmentKeeper a = new SegmentKeeper();
  private TextLayer.LayerParams b;
  private DynamicTextItem c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  
  protected TextParcelData(Parcel paramParcel)
  {
    Object localObject2 = new DynamicTextBuilder();
    int m = paramParcel.readInt();
    Object localObject1 = (DynamicTextItem.TextMap)paramParcel.readParcelable(DynamicTextItem.TextMap.class.getClassLoader());
    this.c = ((DynamicTextBuilder)localObject2).a(m, ((DynamicTextItem.TextMap)localObject1).a());
    localObject2 = this.c;
    boolean bool = true;
    if (localObject2 == null)
    {
      QLog.e("TextParcelData", 1, "read mDynamicTextItem from Parcel return null, use normal text instead");
      this.c = new NormalTextItem(m, ((DynamicTextItem.TextMap)localObject1).a());
    }
    localObject1 = this.c;
    if (paramParcel.readInt() != 1) {
      bool = false;
    }
    ((DynamicTextItem)localObject1).a(bool);
    this.b = new TextLayer.LayerParams(paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat());
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readFloat();
    this.g = paramParcel.readFloat();
    this.h = paramParcel.readFloat();
    this.i = paramParcel.readFloat();
    this.j = paramParcel.readFloat();
    this.k = paramParcel.readFloat();
    this.l = paramParcel.readFloat();
    this.a = ((SegmentKeeper)paramParcel.readParcelable(SegmentKeeper.class.getClassLoader()));
  }
  
  public TextLayer.TextItem a(TextLayer paramTextLayer)
  {
    paramTextLayer.getClass();
    paramTextLayer = new TextLayer.TextItem(paramTextLayer, this.b);
    paramTextLayer.B = this.b.b;
    DynamicTextItem localDynamicTextItem = this.c;
    paramTextLayer.c = localDynamicTextItem;
    paramTextLayer.G = localDynamicTextItem.c();
    paramTextLayer.H = this.c.d();
    paramTextLayer.b = this.d;
    paramTextLayer.d = this.e;
    paramTextLayer.e = this.f;
    paramTextLayer.f = this.g;
    paramTextLayer.g = this.h;
    paramTextLayer.h = this.i;
    paramTextLayer.i = this.j;
    paramTextLayer.j = this.k;
    paramTextLayer.k = this.l;
    return paramTextLayer;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.TextParcelData
 * JD-Core Version:    0.7.0.1
 */