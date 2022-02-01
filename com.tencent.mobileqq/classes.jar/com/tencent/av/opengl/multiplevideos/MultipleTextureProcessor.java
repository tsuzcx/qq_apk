package com.tencent.av.opengl.multiplevideos;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.opengl.multiplevideos.renderbase.Filter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import com.tencent.ttpic.model.SizeI;
import com.tencent.util.Pair;
import java.io.File;
import java.util.List;

public class MultipleTextureProcessor
{
  private final int jdField_a_of_type_Int;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private CompositeFilter2 jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2;
  private MultipleTextureSource jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource;
  private Filter jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter;
  private final String jdField_a_of_type_JavaLangString = "MultipleTextureProcessor-" + Integer.toHexString(hashCode());
  private final int jdField_b_of_type_Int;
  private Filter jdField_b_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter;
  
  public MultipleTextureProcessor(int paramInt1, int paramInt2)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "MultipleTextureProcessor: " + paramInt1 + ", " + paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource = new MultipleTextureSource();
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource.a(new MultipleTextureProcessor.1(this));
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource.d();
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2 = new CompositeFilter2(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource.a(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2);
  }
  
  private Filter a(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: " + paramString + " not exists");
      return null;
    }
    PAGFilter localPAGFilter = new PAGFilter(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createCompositeFilter: create filter#" + Integer.toHexString(localPAGFilter.hashCode()));
    localPAGFilter.a(paramString);
    return localPAGFilter;
  }
  
  private void a(List<MultipleTextureSource.Texture> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter == null) || (!(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter instanceof PAGFilter))) {}
    Object localObject;
    float f1;
    do
    {
      return;
      localObject = ((PAGFilter)this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter).a();
      f1 = this.jdField_a_of_type_Int / ((SizeI)localObject).width;
      localObject = ((PAGFilter)this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter).a();
    } while (((List)localObject).size() != paramList.size());
    int i = 0;
    label74:
    Pair localPair;
    MultipleTextureSource.Texture localTexture;
    if (i < paramList.size())
    {
      localPair = (Pair)((List)localObject).get(i);
      localTexture = (MultipleTextureSource.Texture)paramList.get(i);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultipleTextureProcessor", 1, "convertFaceDataModel #" + i + " (" + localTexture.jdField_b_of_type_Int + ", " + localTexture.c + "), (" + localTexture.d + ", " + localTexture.e + ")");
      }
      if ((localTexture.jdField_a_of_type_JavaUtilList != null) && (localTexture.e != 0) && (localTexture.d != 0)) {
        break label234;
      }
    }
    for (;;)
    {
      i += 1;
      break label74;
      break;
      label234:
      int j = 0;
      while (j < localTexture.jdField_a_of_type_JavaUtilList.size())
      {
        float f2 = Math.max(((RectF)localPair.first).width() / localTexture.d, ((RectF)localPair.first).height() / localTexture.e);
        localTexture.jdField_a_of_type_JavaUtilList.set(j, FaceDataModelConvertor.a((TTFaceOriginDataModel)localTexture.jdField_a_of_type_JavaUtilList.get(j), new RectF(0.0F, 0.0F, localTexture.d, localTexture.e), (RectF)localPair.first, (Matrix)localPair.second, f1, localTexture.jdField_a_of_type_Boolean));
        localTexture.d = ((int)(localTexture.d * f2));
        localTexture.e = ((int)(localTexture.e * f2));
        j += 1;
      }
      if (localTexture.jdField_a_of_type_Boolean)
      {
        j = 0;
        while (j < localTexture.jdField_a_of_type_JavaUtilList.size())
        {
          FaceDataModelConvertor.a((TTFaceOriginDataModel)localTexture.jdField_a_of_type_JavaUtilList.get(j));
          j += 1;
        }
      }
    }
  }
  
  private Filter b(String paramString)
  {
    if (!FileUtils.exists(paramString))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: " + paramString + " not exists");
      return null;
    }
    AEFilter localAEFilter = new AEFilter();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createDecorateFilter: create filter#" + Integer.toHexString(localAEFilter.hashCode()));
    localAEFilter.a(paramString);
    return localAEFilter;
  }
  
  public Frame a(List<MultipleTextureSource.Texture> paramList, long paramLong)
  {
    a(paramList);
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource.a(paramList, paramLong);
    paramList = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    return paramList;
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: ");
    if (this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource.e();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: source#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource.hashCode()));
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource = null;
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2 != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2.hashCode()));
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2 = null;
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter.hashCode()));
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter = null;
    }
    if (this.jdField_b_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter != null)
    {
      this.jdField_b_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter.c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "destroy: filter#" + Integer.toHexString(this.jdField_b_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter.hashCode()));
      this.jdField_b_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter = null;
    }
  }
  
  public void a(String paramString)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: " + paramString);
    Filter localFilter = a(paramString + File.separator + "pag" + File.separator + "pag");
    Object localObject = localFilter;
    if (localFilter == null) {
      localObject = this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2;
    }
    paramString = b(paramString + File.separator + "ae");
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource.c();
    if ((this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter != null) && (this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter != this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosCompositeFilter2))
    {
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter.hashCode()));
    }
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureSource.a((Filter)localObject);
    this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter = ((Filter)localObject);
    if (this.jdField_b_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter != null)
    {
      this.jdField_b_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter.a().c();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: destroy filter#" + Integer.toHexString(this.jdField_b_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter.hashCode()));
    }
    if (paramString != null) {
      ((Filter)localObject).a(paramString, 0);
    }
    this.jdField_b_of_type_ComTencentAvOpenglMultiplevideosRenderbaseFilter = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.MultipleTextureProcessor
 * JD-Core Version:    0.7.0.1
 */