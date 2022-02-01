package com.tencent.aelight.camera.ae.play;

import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import java.util.List;

class AEPlayShowPart$6
  implements Runnable
{
  AEPlayShowPart$6(AEPlayShowPart paramAEPlayShowPart, String paramString, int paramInt) {}
  
  public void run()
  {
    boolean bool = "".equals(this.val$tabName);
    int i = 0;
    if (bool)
    {
      AEPlayShowPart.access$600(this.this$0, 0);
      return;
    }
    List localList = AEPlayShowPart.access$700(this.this$0).getmCategoryList();
    if (localList != null) {
      while (i < localList.size())
      {
        AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)localList.get(i);
        if (localAEMaterialCategory != null)
        {
          String str = this.val$tabName;
          if ((str != null) && (str.equals(localAEMaterialCategory.b)))
          {
            AEPlayShowPart.access$600(this.this$0, i);
            if (AEPlayShowPart.access$700(this.this$0).getCurrentPageView() != null) {
              AEPlayShowPart.access$700(this.this$0).getCurrentPageView().scrollTo(this.val$scrollY);
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowPart.6
 * JD-Core Version:    0.7.0.1
 */