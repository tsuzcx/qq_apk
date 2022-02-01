package com.tencent.aelight.camera.aioeditor.docenhance;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.ae.AEPath.Editor.CACHE;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;
import java.io.IOException;

class DocEnhanceFragment$5
  implements Runnable
{
  DocEnhanceFragment$5(DocEnhanceFragment paramDocEnhanceFragment, FragmentActivity paramFragmentActivity) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AEPath.Editor.CACHE.b);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    ((StringBuilder)localObject1).append(".jpg");
    localObject1 = ((StringBuilder)localObject1).toString();
    FileUtils.createFileIfNotExits((String)localObject1);
    Object localObject2 = new File((String)localObject1);
    try
    {
      ImageUtil.a(DocEnhanceFragment.a(this.this$0), (File)localObject2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("RESULT_KEY_IS_ENHANCED", DocEnhanceFragment.a(this.this$0));
      if (DocEnhanceFragment.a(this.this$0))
      {
        ((Intent)localObject2).putExtra("RESULT_KEY_ENHANCED_POINTS_ARRAY", DocEnhanceFragment.a(this.this$0));
        ((Intent)localObject2).putExtra("RESULT_KEY_ENHANCED_PIC_PATH", (String)localObject1);
        ((Intent)localObject2).putExtra("RESULT_KEY_ENHANCED_COLOR_CONFIG", DocEnhanceFragment.a(this.this$0));
      }
      this.a.setResult(-1, (Intent)localObject2);
      this.a.finish();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.DocEnhanceFragment.5
 * JD-Core Version:    0.7.0.1
 */