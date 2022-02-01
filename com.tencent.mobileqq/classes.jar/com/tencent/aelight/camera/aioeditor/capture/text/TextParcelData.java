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
  private float jdField_a_of_type_Float;
  private DynamicTextItem jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
  private TextLayer.LayerParams jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$LayerParams;
  public SegmentKeeper a;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  
  protected TextParcelData(Parcel paramParcel)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    Object localObject2 = new DynamicTextBuilder();
    int j = paramParcel.readInt();
    Object localObject1 = (DynamicTextItem.TextMap)paramParcel.readParcelable(DynamicTextItem.TextMap.class.getClassLoader());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = ((DynamicTextBuilder)localObject2).a(j, ((DynamicTextItem.TextMap)localObject1).a());
    localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    boolean bool = true;
    if (localObject2 == null)
    {
      QLog.e("TextParcelData", 1, "read mDynamicTextItem from Parcel return null, use normal text instead");
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = new NormalTextItem(j, ((DynamicTextItem.TextMap)localObject1).a());
    }
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    if (paramParcel.readInt() != 1) {
      bool = false;
    }
    ((DynamicTextItem)localObject1).a(bool);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$LayerParams = new TextLayer.LayerParams(paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat());
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.b = paramParcel.readFloat();
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readFloat();
    this.e = paramParcel.readFloat();
    this.f = paramParcel.readFloat();
    this.g = paramParcel.readFloat();
    this.h = paramParcel.readFloat();
    this.i = paramParcel.readFloat();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = ((SegmentKeeper)paramParcel.readParcelable(SegmentKeeper.class.getClassLoader()));
  }
  
  public TextLayer.TextItem a(TextLayer paramTextLayer)
  {
    paramTextLayer.getClass();
    paramTextLayer = new TextLayer.TextItem(paramTextLayer, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$LayerParams);
    paramTextLayer.j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer$LayerParams.jdField_a_of_type_Float;
    DynamicTextItem localDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    paramTextLayer.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = localDynamicTextItem;
    paramTextLayer.n = localDynamicTextItem.a();
    paramTextLayer.o = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b();
    paramTextLayer.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    paramTextLayer.b = this.b;
    paramTextLayer.c = this.c;
    paramTextLayer.d = this.d;
    paramTextLayer.e = this.e;
    paramTextLayer.f = this.f;
    paramTextLayer.g = this.g;
    paramTextLayer.h = this.h;
    paramTextLayer.i = this.i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.TextParcelData
 * JD-Core Version:    0.7.0.1
 */