package com.android.dx.command.annotool;

import com.android.dx.cf.attrib.BaseAnnotations;
import com.android.dx.cf.direct.ClassPathOpener.Consumer;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.direct.StdAttributeFactory;
import com.android.dx.cf.iface.AttributeList;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.ByteArray;
import java.io.File;

class AnnotationLister$1
  implements ClassPathOpener.Consumer
{
  AnnotationLister$1(AnnotationLister paramAnnotationLister) {}
  
  public void onException(Exception paramException)
  {
    throw new RuntimeException(paramException);
  }
  
  public void onProcessArchiveStart(File paramFile) {}
  
  public boolean processFileBytes(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (!paramString.endsWith(".class")) {}
    for (;;)
    {
      return true;
      paramArrayOfByte = new DirectClassFile(new ByteArray(paramArrayOfByte), paramString, true);
      paramArrayOfByte.setAttributeFactory(StdAttributeFactory.THE_ONE);
      AttributeList localAttributeList = paramArrayOfByte.getAttributes();
      paramString = paramArrayOfByte.getThisClass().getClassType().getClassName();
      BaseAnnotations localBaseAnnotations;
      if (paramString.endsWith("package-info"))
      {
        for (paramString = localAttributeList.findFirst("RuntimeInvisibleAnnotations"); paramString != null; paramString = localAttributeList.findNext(paramString))
        {
          localBaseAnnotations = (BaseAnnotations)paramString;
          AnnotationLister.access$000(this.this$0, paramArrayOfByte, localBaseAnnotations);
        }
        for (paramString = localAttributeList.findFirst("RuntimeVisibleAnnotations"); paramString != null; paramString = localAttributeList.findNext(paramString))
        {
          localBaseAnnotations = (BaseAnnotations)paramString;
          AnnotationLister.access$000(this.this$0, paramArrayOfByte, localBaseAnnotations);
        }
      }
      else
      {
        if ((AnnotationLister.access$100(this.this$0, paramString)) || (AnnotationLister.access$200(this.this$0, paramString)))
        {
          AnnotationLister.access$300(this.this$0, paramArrayOfByte);
          return true;
        }
        for (paramString = localAttributeList.findFirst("RuntimeInvisibleAnnotations"); paramString != null; paramString = localAttributeList.findNext(paramString))
        {
          localBaseAnnotations = (BaseAnnotations)paramString;
          AnnotationLister.access$400(this.this$0, paramArrayOfByte, localBaseAnnotations);
        }
        for (paramString = localAttributeList.findFirst("RuntimeVisibleAnnotations"); paramString != null; paramString = localAttributeList.findNext(paramString))
        {
          localBaseAnnotations = (BaseAnnotations)paramString;
          AnnotationLister.access$400(this.this$0, paramArrayOfByte, localBaseAnnotations);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.annotool.AnnotationLister.1
 * JD-Core Version:    0.7.0.1
 */