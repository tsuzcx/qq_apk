package com.tencent.biz.qqcircle.localphoto.scan.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.gyailib.library.GYAISceneChain;
import com.gyailib.library.GYDetectCommonItemParams;
import com.gyailib.library.GYDetectCommonResultStruct;
import com.tencent.biz.qqcircle.localphoto.scan.data.LocalPhotoInfo;
import com.tencent.biz.qqcircle.localphoto.scan.data.LocalPhotoInfo.ImageTag;
import java.util.ArrayList;
import java.util.List;

public class ScanTagHelper
{
  private String a;
  private GYAISceneChain b;
  private ImageSimilarityChecker c;
  
  public void a(GYAISceneChain paramGYAISceneChain)
  {
    this.b = paramGYAISceneChain;
    this.c = new ImageSimilarityChecker();
  }
  
  public boolean a(@NonNull LocalPhotoInfo paramLocalPhotoInfo, @Nullable Bitmap paramBitmap)
  {
    boolean bool2 = false;
    if (paramBitmap == null) {
      return false;
    }
    Object localObject = this.c.a(paramBitmap);
    if (ImageSimilarityChecker.a((String)localObject, this.a)) {
      return false;
    }
    this.a = ((String)localObject);
    if (this.b != null)
    {
      localObject = new GYDetectCommonResultStruct();
      this.b.forwardDetect(paramBitmap, (GYDetectCommonResultStruct)localObject, 0);
      if ((((GYDetectCommonResultStruct)localObject).items != null) && (((GYDetectCommonResultStruct)localObject).items.length > 0))
      {
        paramLocalPhotoInfo.k = new ArrayList();
        paramBitmap = ((GYDetectCommonResultStruct)localObject).items;
        int j = paramBitmap.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramBitmap[i];
          LocalPhotoInfo.ImageTag localImageTag = new LocalPhotoInfo.ImageTag();
          if (!TextUtils.isEmpty(((GYDetectCommonItemParams)localObject).classifyType))
          {
            localImageTag.a = ((GYDetectCommonItemParams)localObject).classifyType;
            localImageTag.b = ((GYDetectCommonItemParams)localObject).classifyName;
            localImageTag.c = ((GYDetectCommonItemParams)localObject).classifyConfidence;
            paramLocalPhotoInfo.k.add(localImageTag);
          }
          i += 1;
        }
      }
    }
    boolean bool1 = bool2;
    if (paramLocalPhotoInfo.k != null)
    {
      bool1 = bool2;
      if (paramLocalPhotoInfo.k.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.utils.ScanTagHelper
 * JD-Core Version:    0.7.0.1
 */