package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.opengl.effects.AEKitAbilityInfo;
import com.tencent.av.opengl.multiplevideos.MultipleTextureProcessor;
import com.tencent.av.opengl.multiplevideos.MultipleTextureSource.Texture;
import com.tencent.av.perfstat.MemoryPerfStat;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.util.ArrayList;
import java.util.List;

public final class VideoAfterTreatmentManager
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private volatile MultipleTextureProcessor jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureProcessor;
  private volatile String jdField_a_of_type_JavaLangString;
  private List<MultipleTextureSource.Texture> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private InputTextureInfo[] jdField_a_of_type_ArrayOfComTencentAvUiInputTextureInfo = new InputTextureInfo[16];
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private volatile String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private int d;
  private int e;
  
  public VideoAfterTreatmentManager(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    while (i < 16)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiInputTextureInfo[i] = new InputTextureInfo();
      i += 1;
    }
  }
  
  private MultipleTextureProcessor a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureProcessor == null) {}
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureProcessor == null)
      {
        this.d = paramInt1;
        this.e = paramInt2;
        this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureProcessor = new MultipleTextureProcessor(paramInt1, paramInt2);
        QLog.i("VideoAfterTreatmentManager", 1, "lazyGetMultipleTextureProcessor  realCreate mLastFilterPath:=" + this.jdField_b_of_type_JavaLangString + ",mFilterPath:=" + this.jdField_a_of_type_JavaLangString);
      }
      if ((i != 0) || (!this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureProcessor.a(this.jdField_a_of_type_JavaLangString);
        QLog.i("VideoAfterTreatmentManager", 1, "lazyGetMultipleTextureProcessor: applyMaterial:=" + this.jdField_a_of_type_JavaLangString);
      }
      return this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureProcessor;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureProcessor != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureProcessor.a();
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureProcessor = null;
      this.jdField_b_of_type_JavaLangString = "";
      QLog.i("VideoAfterTreatmentManager", 1, "destroyMultipleTextureProcessorIfNeed finish");
    }
  }
  
  public Frame a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int >= 2)
    {
      MemoryPerfStat.a().a(256);
      int i = AudioHelper.a(29);
      Object localObject = a(paramInt1, paramInt2);
      long l = System.currentTimeMillis();
      localObject = ((MultipleTextureProcessor)localObject).a(this.jdField_a_of_type_JavaUtilList, System.currentTimeMillis());
      l = System.currentTimeMillis() - l;
      if ((QLog.isDebugVersion()) || (i == 1)) {
        QLog.i("VideoAfterTreatmentManager", 2, "doCallAEModulePostScreenRender, cost[" + l + "]");
      }
      this.jdField_c_of_type_Long = Math.max(l, this.jdField_c_of_type_Long);
      this.jdField_a_of_type_Long = (l + this.jdField_a_of_type_Long);
      this.jdField_b_of_type_Long += 1L;
      return localObject;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, List<TTFaceOriginDataModel> paramList, boolean paramBoolean2)
  {
    int i = 1;
    this.jdField_a_of_type_ArrayOfComTencentAvUiInputTextureInfo[this.jdField_a_of_type_Int].jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ArrayOfComTencentAvUiInputTextureInfo[this.jdField_a_of_type_Int].jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ArrayOfComTencentAvUiInputTextureInfo[this.jdField_a_of_type_Int].jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Int += 1;
    MultipleTextureSource.Texture localTexture = new MultipleTextureSource.Texture();
    localTexture.jdField_a_of_type_Int = paramInt1;
    localTexture.jdField_b_of_type_Int = paramInt2;
    localTexture.jdField_c_of_type_Int = paramInt3;
    localTexture.jdField_a_of_type_JavaUtilList = paramList;
    localTexture.d = paramInt4;
    localTexture.e = paramInt5;
    localTexture.jdField_a_of_type_Boolean = paramBoolean1;
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().e)
    {
      paramBoolean1 = true;
      this.jdField_a_of_type_Boolean = paramBoolean1;
      if (this.jdField_a_of_type_Boolean)
      {
        paramInt1 = i;
        if (paramBoolean2) {}
      }
      else
      {
        if ((this.jdField_a_of_type_Boolean) || (paramBoolean2)) {
          break label182;
        }
      }
    }
    label182:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label187;
      }
      this.jdField_a_of_type_JavaUtilList.add(0, localTexture);
      return;
      paramBoolean1 = false;
      break;
    }
    label187:
    this.jdField_a_of_type_JavaUtilList.add(localTexture);
  }
  
  public boolean a(ScreenLayout paramScreenLayout)
  {
    int j = 1;
    this.jdField_a_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_ComTencentAvVideoController.a.a(3))
    {
      paramScreenLayout = ((EffectFaceManager)this.jdField_a_of_type_ComTencentAvVideoController.a.a(3)).a();
      if (paramScreenLayout != null) {
        this.jdField_a_of_type_JavaLangString = paramScreenLayout.getDesc();
      }
    }
    for (int i = 1;; i = 0)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        d();
      }
      if ((i == 0) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {}
      for (i = j;; i = 0)
      {
        boolean bool1 = this.jdField_a_of_type_ComTencentAvVideoController.a().j;
        boolean bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().k;
        if ((i == 0) || (!bool1) || (!bool2) || (VideoController.a().a() == null)) {
          break;
        }
        return AEKitAbilityInfo.a(VideoController.a().a());
      }
    }
  }
  
  public float[] a()
  {
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      this.jdField_a_of_type_ArrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.d, this.e, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    }
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("doCallAEModulePostScreenRender mMaxDealTime:=").append(this.jdField_c_of_type_Long).append(",avgCosts:");
    if (this.jdField_b_of_type_Long == 0L) {}
    for (float f = 0.0F;; f = (float)this.jdField_a_of_type_Long * 1.0F / (float)this.jdField_b_of_type_Long)
    {
      QLog.i("VideoAfterTreatmentManager", 1, f);
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentAvOpenglMultiplevideosMultipleTextureProcessor = null;
      this.jdField_b_of_type_JavaLangString = "";
      this.jdField_a_of_type_ArrayOfFloat = null;
      return;
    }
  }
  
  public void c()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoAfterTreatmentManager
 * JD-Core Version:    0.7.0.1
 */