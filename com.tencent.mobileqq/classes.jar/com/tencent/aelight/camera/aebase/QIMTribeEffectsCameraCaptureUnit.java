package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.setting.CaptureEntranceParams;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.tribe.util.TribeConstants;

public class QIMTribeEffectsCameraCaptureUnit
  extends AEPituCameraUnit
{
  public QIMTribeEffectsCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.r = new CaptureEntranceParams(10012, 105, 11);
    this.y = 9;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject1 = this.b.getActivity();
    if (localObject1 != null)
    {
      if (((Activity)localObject1).isFinishing()) {
        return;
      }
      Object localObject2;
      if (paramInt1 == TribeConstants.a)
      {
        if (paramInt2 == -1) {
          if (paramIntent != null)
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("result", paramIntent.getStringExtra("result"));
            ((Activity)localObject1).setResult(-1, (Intent)localObject2);
          }
          else
          {
            return;
          }
        }
        ((Activity)localObject1).finish();
        return;
      }
      if ((paramInt1 == 10012) && (paramInt2 == -1))
      {
        localObject2 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("thumbPath", ((PublishParam)localObject2).c);
        ((Intent)localObject1).putExtra("videoPath", ((PublishParam)localObject2).t);
        ((Intent)localObject1).putExtra("fakeVid", ((PublishParam)localObject2).b);
        ((Intent)localObject1).putExtra("videoDoodleDescription", ((PublishParam)localObject2).f);
        paramInt1 = paramIntent.getIntExtra("theme_id", -1);
        paramIntent = paramIntent.getStringExtra("theme_name");
        ((Intent)localObject1).putExtra("theme_id", paramInt1);
        ((Intent)localObject1).putExtra("theme_name", paramIntent);
        paramIntent = (QimMusicPlayer)QIMManager.a().d(8);
        if (paramIntent != null) {
          paramIntent.e();
        }
      }
      else
      {
        SLog.d("QIMTribeEffectsCameraCaptureUnit", "onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMTribeEffectsCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */