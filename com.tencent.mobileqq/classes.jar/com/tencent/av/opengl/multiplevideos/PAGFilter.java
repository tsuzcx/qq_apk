package com.tencent.av.opengl.multiplevideos;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.opengl.multiplevideos.renderbase.Filter;
import com.tencent.av.opengl.multiplevideos.renderbase.RefFrame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.model.SizeI;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGLayer;
import org.libpag.PAGRenderer;
import org.libpag.PAGSurface;

public class PAGFilter
  extends Filter
{
  private int jdField_a_of_type_Int = 720;
  private long jdField_a_of_type_Long;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private final String jdField_a_of_type_JavaLangString = "PAGFilter-" + Integer.toHexString(hashCode());
  private PAGFile jdField_a_of_type_OrgLibpagPAGFile;
  private PAGRenderer jdField_a_of_type_OrgLibpagPAGRenderer;
  private PAGSurface jdField_a_of_type_OrgLibpagPAGSurface;
  private int jdField_b_of_type_Int = 1280;
  private long jdField_b_of_type_Long = 0L;
  
  public PAGFilter(int paramInt1, int paramInt2)
  {
    super(1);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_OrgLibpagPAGFile != null)
    {
      if (this.jdField_a_of_type_OrgLibpagPAGSurface != null)
      {
        this.jdField_a_of_type_OrgLibpagPAGSurface.release();
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyPag: surface#" + Integer.toHexString(this.jdField_a_of_type_OrgLibpagPAGSurface.hashCode()) + " released");
        this.jdField_a_of_type_OrgLibpagPAGSurface = null;
      }
      if (this.jdField_a_of_type_OrgLibpagPAGRenderer == null) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "applyPag: not inited yet");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_OrgLibpagPAGRenderer.setFile(this.jdField_a_of_type_OrgLibpagPAGFile);
    this.jdField_a_of_type_OrgLibpagPAGSurface = PAGSurface.FromTexture(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, true);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyPag: create surface#" + Integer.toHexString(this.jdField_a_of_type_OrgLibpagPAGSurface.hashCode()));
    this.jdField_a_of_type_OrgLibpagPAGRenderer.setSurface(this.jdField_a_of_type_OrgLibpagPAGSurface);
    this.jdField_a_of_type_Long = (this.jdField_a_of_type_OrgLibpagPAGFile.duration() / 1000L);
  }
  
  @NotNull
  public Frame a(List<RefFrame> paramList, long paramLong)
  {
    if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_b_of_type_Long > paramLong)) {
      this.jdField_b_of_type_Long = paramLong;
    }
    int j = Math.min(this.jdField_a_of_type_OrgLibpagPAGFile.numImages(), paramList.size());
    int i = 0;
    while (i < j)
    {
      Object localObject = ((RefFrame)paramList.get(i)).jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
      localObject = PAGImage.FromTexture(((Frame)localObject).getTextureId(), 3553, ((Frame)localObject).width, ((Frame)localObject).height, true);
      if (localObject != null)
      {
        ((PAGImage)localObject).setScaleMode(3);
        this.jdField_a_of_type_OrgLibpagPAGRenderer.replaceImage(i, (PAGImage)localObject);
      }
      i += 1;
    }
    double d = (paramLong - this.jdField_b_of_type_Long) % this.jdField_a_of_type_Long / this.jdField_a_of_type_Long;
    this.jdField_a_of_type_OrgLibpagPAGRenderer.setProgress(d);
    this.jdField_a_of_type_OrgLibpagPAGRenderer.flush();
    return this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  }
  
  public SizeI a()
  {
    return new SizeI(this.jdField_a_of_type_OrgLibpagPAGFile.width(), this.jdField_a_of_type_OrgLibpagPAGFile.height());
  }
  
  public List<Pair<RectF, Matrix>> a()
  {
    int k = 0;
    PAGComposition localPAGComposition = this.jdField_a_of_type_OrgLibpagPAGRenderer.getRootComposition();
    int n = this.jdField_a_of_type_OrgLibpagPAGFile.numImages();
    int m = localPAGComposition.numLayers();
    ArrayList localArrayList = new ArrayList(n);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= n) {
        break;
      }
      localArrayList.add(null);
      i += 1;
    }
    while (j < m)
    {
      PAGLayer localPAGLayer = localPAGComposition.getLayerAt(j);
      if (localPAGLayer.layerType() == 5) {
        localArrayList.set(localPAGLayer.editableIndex(), new Pair(localPAGLayer.getBounds(), localPAGLayer.getTotalMatrix()));
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onInit");
    if (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame == null)
    {
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.bindFrame(-1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0.0D);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onInit: create frame#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.hashCode()));
    }
    this.jdField_a_of_type_OrgLibpagPAGRenderer = new PAGRenderer();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onInit: create render#" + Integer.toHexString(this.jdField_a_of_type_OrgLibpagPAGRenderer.hashCode()));
    d();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_OrgLibpagPAGFile = PAGFile.Load(paramString);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "applyMaterial: " + paramString + " loaded, width=" + this.jdField_a_of_type_OrgLibpagPAGFile.width() + ", height=" + this.jdField_a_of_type_OrgLibpagPAGFile.height());
    d();
  }
  
  public void b()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy");
    if (this.jdField_a_of_type_OrgLibpagPAGRenderer != null)
    {
      this.jdField_a_of_type_OrgLibpagPAGRenderer.setSurface(null);
      this.jdField_a_of_type_OrgLibpagPAGRenderer = null;
    }
    if (this.jdField_a_of_type_OrgLibpagPAGSurface != null)
    {
      this.jdField_a_of_type_OrgLibpagPAGSurface.release();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy: surface#" + Integer.toHexString(this.jdField_a_of_type_OrgLibpagPAGSurface.hashCode()) + " released");
      this.jdField_a_of_type_OrgLibpagPAGSurface = null;
    }
    if (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame != null)
    {
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onDestroy: frame#" + Integer.toHexString(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.hashCode()) + " cleared");
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.PAGFilter
 * JD-Core Version:    0.7.0.1
 */