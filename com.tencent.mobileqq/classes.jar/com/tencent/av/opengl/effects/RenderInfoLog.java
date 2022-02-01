package com.tencent.av.opengl.effects;

import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

public class RenderInfoLog
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString = null;
  int d = 0;
  int e = 0;
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, FilterDesc paramFilterDesc, VideoMaterial paramVideoMaterial, PendantItem paramPendantItem, CameraFrame paramCameraFrame, int paramInt4)
  {
    String str3 = "null";
    if ((paramFilterDesc != null) && (paramFilterDesc.name != null)) {
      paramFilterDesc = paramFilterDesc.name;
    } else {
      paramFilterDesc = "null";
    }
    String str1;
    if ((paramPendantItem != null) && (paramPendantItem.getId() != null)) {
      str1 = paramPendantItem.getId();
    } else {
      str1 = "null";
    }
    if (paramVideoMaterial == null) {
      paramVideoMaterial = "null";
    } else {
      paramVideoMaterial = paramVideoMaterial.toString();
    }
    if ((paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int) || (paramInt3 != this.jdField_c_of_type_Int) || (paramBoolean != this.jdField_b_of_type_Boolean) || (this.d != paramCameraFrame.a()) || (this.jdField_a_of_type_Boolean != paramCameraFrame.jdField_a_of_type_Boolean) || (this.e != paramInt4) || (!TextUtils.equals(paramFilterDesc, this.jdField_a_of_type_JavaLangString)) || (!TextUtils.equals(str1, this.jdField_b_of_type_JavaLangString)) || (!TextUtils.equals(paramVideoMaterial, this.jdField_c_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RenderInfoLog, frameIndex[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], width[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], height[");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], angle[");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], needFaceData[");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], mDataLen[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("->");
      localStringBuilder.append(paramCameraFrame.a());
      localStringBuilder.append("], mBeautyLevel[");
      localStringBuilder.append(this.e);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("], isFront[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramCameraFrame.jdField_a_of_type_Boolean);
      localStringBuilder.append("], getFrameAngle[");
      localStringBuilder.append(RenderUtil.a(paramCameraFrame.jdField_a_of_type_Boolean));
      localStringBuilder.append("], fAngle[");
      localStringBuilder.append((paramCameraFrame.d - RenderUtil.a(paramCameraFrame.jdField_a_of_type_Boolean) - 1 + 4) % 4);
      localStringBuilder.append("], strFilterDesc[");
      localStringBuilder.append(paramFilterDesc);
      localStringBuilder.append("], strPendantItem[");
      localStringBuilder.append(str1);
      localStringBuilder.append("], pendantItem[");
      String str2 = str3;
      if (paramPendantItem != null) {
        if (paramPendantItem.getId() == null) {
          str2 = str3;
        } else {
          str2 = paramPendantItem.getId();
        }
      }
      localStringBuilder.append(str2);
      localStringBuilder.append("], strFilters[");
      localStringBuilder.append(paramVideoMaterial);
      localStringBuilder.append("]");
      QLog.w(paramString, 1, localStringBuilder.toString());
      this.jdField_a_of_type_Boolean = paramCameraFrame.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_c_of_type_Int = paramInt3;
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_JavaLangString = paramFilterDesc;
      this.jdField_b_of_type_JavaLangString = str1;
      this.jdField_c_of_type_JavaLangString = paramVideoMaterial;
      this.d = paramCameraFrame.a();
      this.e = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.RenderInfoLog
 * JD-Core Version:    0.7.0.1
 */