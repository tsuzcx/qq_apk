package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialAdapter$mReportHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AENewMaterialAdapter$mReportHandler$1
  extends Handler
{
  AENewMaterialAdapter$mReportHandler$1(Looper paramLooper)
  {
    super(localLooper);
  }
  
  public void handleMessage(@Nullable Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject;
    if (paramMessage != null) {
      localObject = Integer.valueOf(paramMessage.what);
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    if (((Integer)localObject).intValue() == 1)
    {
      localObject = paramMessage.obj;
      if ((localObject instanceof AEMaterialMetaData))
      {
        paramMessage = AENewMaterialAdapter.e(this.a);
        localObject = (AEMaterialMetaData)localObject;
        if (paramMessage.contains(((AEMaterialMetaData)localObject).m))
        {
          paramMessage = new StringBuilder();
          paramMessage.append("delay report expose for ");
          paramMessage.append(((AEMaterialMetaData)localObject).m);
          AEQLog.a("AEBottomPanelPart_AENewMaterialAdapter", paramMessage.toString());
          AEBaseDataReporter.a().a(((AEMaterialMetaData)localObject).m, ((AEMaterialMetaData)localObject).aa, ((AEMaterialMetaData)localObject).ab);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialAdapter.mReportHandler.1
 * JD-Core Version:    0.7.0.1
 */