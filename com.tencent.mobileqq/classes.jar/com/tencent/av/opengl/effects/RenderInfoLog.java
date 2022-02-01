package com.tencent.av.opengl.effects;

import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

public class RenderInfoLog
{
  int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  int e = 0;
  boolean f = false;
  boolean g = false;
  String h = null;
  String i = null;
  String j = null;
  
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
    if ((paramInt1 != this.a) || (paramInt2 != this.b) || (paramInt3 != this.c) || (paramBoolean != this.g) || (this.d != paramCameraFrame.b()) || (this.f != paramCameraFrame.g) || (this.e != paramInt4) || (!TextUtils.equals(paramFilterDesc, this.h)) || (!TextUtils.equals(str1, this.i)) || (!TextUtils.equals(paramVideoMaterial, this.j)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RenderInfoLog, frameIndex[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], width[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], height[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], angle[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], needFaceData[");
      localStringBuilder.append(this.g);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], mDataLen[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("->");
      localStringBuilder.append(paramCameraFrame.b());
      localStringBuilder.append("], mBeautyLevel[");
      localStringBuilder.append(this.e);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("], isFront[");
      localStringBuilder.append(this.f);
      localStringBuilder.append("->");
      localStringBuilder.append(paramCameraFrame.g);
      localStringBuilder.append("], getFrameAngle[");
      localStringBuilder.append(RenderUtil.a(paramCameraFrame.g));
      localStringBuilder.append("], fAngle[");
      localStringBuilder.append((paramCameraFrame.e - RenderUtil.a(paramCameraFrame.g) - 1 + 4) % 4);
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
      this.f = paramCameraFrame.g;
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.g = paramBoolean;
      this.h = paramFilterDesc;
      this.i = str1;
      this.j = paramVideoMaterial;
      this.d = paramCameraFrame.b();
      this.e = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.RenderInfoLog
 * JD-Core Version:    0.7.0.1
 */