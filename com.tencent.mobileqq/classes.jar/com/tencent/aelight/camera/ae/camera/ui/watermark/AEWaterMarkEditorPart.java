package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.baseutils.string.StringUtils;
import java.util.List;
import org.light.bean.WMElement;

public class AEWaterMarkEditorPart
  extends VideoStoryBasePart
{
  private static boolean a = false;
  private AEPituCameraUnit b;
  private boolean c = false;
  private WMElement d;
  private WatermarkEditView e;
  
  public AEWaterMarkEditorPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.b = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a()
  {
    List localList = this.b.aw();
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (localList.size() == 1)
      {
        localObject = (WMElement)localList.get(0);
        if ((localObject != null) && ("EDITABLE_LOCATION".equals(((WMElement)localObject).type)))
        {
          AEQLog.a("AEWaterMarkEditorPart", "only jump to poi");
          AESelectLocationFragment.a(this.mActivity, 203);
          this.c = true;
          this.d = ((WMElement)localObject);
          return;
        }
      }
      this.c = false;
      if (this.e == null)
      {
        localObject = (ViewStub)this.mActivity.findViewById(2063990953);
        if (localObject != null)
        {
          ((ViewStub)localObject).inflate();
          this.e = ((WatermarkEditView)this.mActivity.findViewById(2063990952));
          this.e.a(this.mActivity, this.mPartManager);
        }
      }
      Object localObject = this.e;
      if (localObject != null) {
        ((WatermarkEditView)localObject).a(localList);
      }
      return;
    }
    AEQLog.d("AEWaterMarkEditorPart", "showWaterMarkEdit---getEditableWMElements is null");
  }
  
  public Object get(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 589826) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(a);
  }
  
  protected void initView() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 203) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_select_poi");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult");
      ((StringBuilder)localObject).append(paramIntent);
      AEQLog.a("AEWaterMarkEditorPart", ((StringBuilder)localObject).toString());
      if (!this.c)
      {
        localObject = this.e;
        if (localObject != null)
        {
          ((WatermarkEditView)localObject).setWaterMarkLocation(paramIntent);
          return;
        }
      }
      if ((this.c) && (this.d != null))
      {
        paramIntent = StringUtils.removeUTF8Emoji(paramIntent).trim();
        this.d.setLocation(paramIntent);
      }
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 589826: 
      paramVarArgs = this.e;
      if ((paramVarArgs != null) && (paramVarArgs.getVisibility() == 0)) {
        this.e.setVisibility(8);
      }
      a = false;
      return;
    }
    a();
    if (this.c)
    {
      a = false;
      return;
    }
    a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.AEWaterMarkEditorPart
 * JD-Core Version:    0.7.0.1
 */