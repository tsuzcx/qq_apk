package com.tencent.aelight.camera.aeeditor.module.edit;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.microrapid.opencv.ImageAutoProcessor;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$13
  implements Runnable
{
  AEEditorImageEditFragment$13(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt) {}
  
  public void run()
  {
    if ((List)AEEditorImageEditFragment.a(this.this$0).get(this.a) == null) {
      if ((AEEditorImageEditFragment.a(this.this$0) != null) && (AEEditorImageEditFragment.a(this.this$0).size() > this.a) && (AEEditorImageEditFragment.a(this.this$0).get(this.a) != null))
      {
        Object localObject1 = (AEEditorImageInfo)AEEditorImageEditFragment.a(this.this$0).get(this.a);
        Object localObject2 = BitmapUtil.getImageSize(((AEEditorImageInfo)localObject1).jdField_a_of_type_JavaLangString);
        int j = Math.min(((Size)localObject2).getWidth(), ((Size)localObject2).getHeight()) / 480;
        int i = 2;
        if (j >= 2) {
          i = 4;
        }
        localObject1 = BitmapUtil.cropBitmap(((AEEditorImageInfo)localObject1).jdField_a_of_type_JavaLangString, ((AEEditorImageInfo)localObject1).jdField_a_of_type_ComTencentTavcutBeanCropConfig, i);
        if (localObject1 == null)
        {
          AEQLog.d("AEEditorImageEditFragment", "extractColor error input bitmap null.");
          return;
        }
        try
        {
          localObject2 = ImageAutoProcessor.mainColorExtract((Bitmap)localObject1, 6);
          BitmapUtils.recycle((Bitmap)localObject1);
          AEEditorImageEditFragment.a(this.this$0, (List)localObject2);
          AEEditorImageEditFragment.b(this.this$0).put(this.a, new ArrayList((Collection)localObject2));
          if (!CollectionUtil.isEmptyList((List)localObject2)) {
            ((List)localObject2).add(((List)localObject2).remove(0));
          }
          AEEditorImageEditFragment.a(this.this$0).put(this.a, localObject2);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[extractColor], extracted color cached, index=");
          ((StringBuilder)localObject1).append(this.a);
          AEQLog.a("AEEditorImageEditFragment", ((StringBuilder)localObject1).toString());
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
      }
      else
      {
        AEQLog.d("AEEditorImageEditFragment", "source image info error.");
        return;
      }
    }
    if (this.a == AEEditorImageEditFragment.a(this.this$0)) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.13.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.13
 * JD-Core Version:    0.7.0.1
 */