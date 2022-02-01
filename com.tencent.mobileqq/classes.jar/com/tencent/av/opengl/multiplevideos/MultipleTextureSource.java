package com.tencent.av.opengl.multiplevideos;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.av.opengl.multiplevideos.renderbase.ImageSource;
import com.tencent.av.opengl.multiplevideos.renderbase.RefFrame;
import com.tencent.av.opengl.multiplevideos.renderbase.RefFrame.FaceData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultipleTextureSource
  extends ImageSource
{
  private final String jdField_a_of_type_JavaLangString = "MultipleTextureSource-" + Integer.toHexString(hashCode());
  private List<Frame> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public void a() {}
  
  public void a(List<MultipleTextureSource.Texture> paramList, long paramLong)
  {
    ArrayList localArrayList1 = new ArrayList(paramList.size());
    int i = 0;
    if (i < paramList.size())
    {
      MultipleTextureSource.Texture localTexture = (MultipleTextureSource.Texture)paramList.get(i);
      label131:
      ArrayList localArrayList2;
      if (i >= this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = new Frame();
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "render: create cached frame#" + Integer.toHexString(localObject.hashCode()));
        ((Frame)localObject).setSizedTexture(localTexture.jdField_a_of_type_Int, localTexture.b, localTexture.c);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        if (!localTexture.a()) {
          break label257;
        }
        localArrayList2 = new ArrayList(1);
        RefFrame.FaceData localFaceData = new RefFrame.FaceData();
        localFaceData.jdField_a_of_type_JavaUtilList = localTexture.jdField_a_of_type_JavaUtilList;
        localArrayList2.add(localFaceData);
      }
      label257:
      for (Object localObject = RefFrame.a((Frame)localObject, localArrayList2);; localObject = RefFrame.a((Frame)localObject))
      {
        localArrayList1.add(localObject);
        i += 1;
        break;
        localObject = (Frame)this.jdField_a_of_type_JavaUtilList.get(i);
        ((Frame)this.jdField_a_of_type_JavaUtilList.get(i)).setSizedTexture(localTexture.jdField_a_of_type_Int, localTexture.b, localTexture.c);
        break label131;
      }
    }
    b(localArrayList1, paramLong);
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((Frame)this.jdField_a_of_type_JavaUtilList.get(i)).clear();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy: cached frame#" + Integer.toHexString(((Frame)this.jdField_a_of_type_JavaUtilList.get(i)).hashCode()));
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    FrameBufferCache.getInstance().destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.MultipleTextureSource
 * JD-Core Version:    0.7.0.1
 */