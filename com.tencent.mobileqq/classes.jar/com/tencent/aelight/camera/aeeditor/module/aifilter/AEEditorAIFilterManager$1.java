package com.tencent.aelight.camera.aeeditor.module.aifilter;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

class AEEditorAIFilterManager$1
  implements AIFilterProxyBase.AIFilterProxyCallback
{
  AEEditorAIFilterManager$1(AEEditorAIFilterManager paramAEEditorAIFilterManager, AppInterface paramAppInterface, AIFilterProxyBase paramAIFilterProxyBase, AEEditorAIFilterManager.AIFilterObserver paramAIFilterObserver) {}
  
  public void a(int paramInt)
  {
    Object localObject = AEEditorAIFilterManager.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("proxy onProcessFailed: errCode=");
    localStringBuilder.append(paramInt);
    AEQLog.b((String)localObject, localStringBuilder.toString());
    localObject = this.c;
    if (localObject != null) {
      ((AEEditorAIFilterManager.AIFilterObserver)localObject).a(paramInt, this.b.d());
    }
  }
  
  public void a(ArrayList<SmartFilterReqItem> paramArrayList)
  {
    AEQLog.b(AEEditorAIFilterManager.c(), "proxy onDataReadyForRequest");
    AEEditorAIFilterManager.a(this.d, this.a, paramArrayList, new AEEditorAIFilterManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager.1
 * JD-Core Version:    0.7.0.1
 */