package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterParcelData;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class DynamicFaceLayer$1
  implements Runnable
{
  DynamicFaceLayer$1(DynamicFaceLayer paramDynamicFaceLayer, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.size())
    {
      Object localObject3 = (PasterParcelData)this.a.get(i);
      if (!TextUtils.isEmpty(((PasterParcelData)localObject3).n))
      {
        Object localObject2;
        Object localObject1;
        do
        {
          int j;
          int k;
          int m;
          int n;
          do
          {
            localObject2 = null;
            if ((DynamicFaceLayer.a(this.this$0).h != null) && (DynamicFaceLayer.b(this.this$0).h.c()))
            {
              localObject1 = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), ((PasterParcelData)localObject3).n, "-Dynamic-", URLDrawableHelperConstants.a, new int[] { 13 }, "-Dynamic-", null);
              if (localObject1 != null)
              {
                if (((URLDrawable)localObject1).getStatus() != 1) {
                  ((URLDrawable)localObject1).restartDownload();
                }
                ((Drawable)localObject1).setCallback(DynamicFaceLayer.c(this.this$0));
              }
              else
              {
                localObject1 = localObject2;
                if (QLog.isColorLevel())
                {
                  QLog.d("DynamicFaceLayer", 2, "apng error");
                  localObject1 = localObject2;
                }
              }
            }
            else
            {
              localObject1 = DynamicFaceLayer.a(((PasterParcelData)localObject3).n);
              ((PasterParcelData)localObject3).n = ((String)localObject1);
              ((PasterParcelData)localObject3).p = 0;
              localObject1 = DynamicFaceLayer.b((String)localObject1);
            }
            j = (int)((PasterParcelData)localObject3).k.left;
            k = (int)((PasterParcelData)localObject3).k.right;
            m = (int)((PasterParcelData)localObject3).k.top;
            n = (int)((PasterParcelData)localObject3).k.bottom;
          } while (localObject1 == null);
          ((Drawable)localObject1).setBounds(j, m, k, n);
          if (TextUtils.isEmpty(((PasterParcelData)localObject3).u))
          {
            SLog.b("DynamicFaceLayer", "Create Normal FaceItem.");
            localObject2 = new FaceLayer.LayerParams(((PasterParcelData)localObject3).d.x, ((PasterParcelData)localObject3).d.y, ((PasterParcelData)localObject3).e, ((PasterParcelData)localObject3).f, ((PasterParcelData)localObject3).g, ((PasterParcelData)localObject3).h, (int)((PasterParcelData)localObject3).i, (int)((PasterParcelData)localObject3).j);
            localObject1 = new FaceLayer.FaceItem(this.this$0, (Drawable)localObject1, (FaceLayer.LayerParams)localObject2, ((PasterParcelData)localObject3).l, ((PasterParcelData)localObject3).m, ((PasterParcelData)localObject3).n, ((PasterParcelData)localObject3).p);
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Create FaceAndTextItem with text:");
            ((StringBuilder)localObject2).append(((PasterParcelData)localObject3).u);
            SLog.b("DynamicFaceLayer", ((StringBuilder)localObject2).toString());
            localObject2 = new FaceLayer.LayerParams(((PasterParcelData)localObject3).d.x, ((PasterParcelData)localObject3).d.y, ((PasterParcelData)localObject3).e, ((PasterParcelData)localObject3).f, ((PasterParcelData)localObject3).g, ((PasterParcelData)localObject3).h, (int)((PasterParcelData)localObject3).i, (int)((PasterParcelData)localObject3).j, ((PasterParcelData)localObject3).u, ((PasterParcelData)localObject3).t, ((PasterParcelData)localObject3).s);
            localObject1 = new FaceLayer.FaceAndTextItem(this.this$0, (Drawable)localObject1, (FaceLayer.LayerParams)localObject2, ((PasterParcelData)localObject3).l, ((PasterParcelData)localObject3).m, ((PasterParcelData)localObject3).n, ((PasterParcelData)localObject3).p);
            ((FaceLayer.FaceAndTextItem)localObject1).a();
          }
          ((FaceLayer.FaceItem)localObject1).q = 0;
          if (((FaceLayer.FaceItem)localObject1).y == 1) {
            break;
          }
          localObject2 = (FaceLayer)DynamicFaceLayer.d(this.this$0).a(FaceLayer.a);
        } while (localObject2 == null);
        try
        {
          localObject3 = FaceLayer.FaceItem.class.getDeclaredField("z");
          ((Field)localObject3).setAccessible(true);
          ((Field)localObject3).set(localObject1, localObject2);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, new Object[] { "reflect faceLayer Item error : ", localException.getMessage() });
          }
        }
        ((FaceLayer)localObject2).b.add(localObject1);
        ((FaceLayer)localObject2).u();
        break label664;
        this.this$0.b.add(localObject1);
        this.this$0.u();
      }
      label664:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer.1
 * JD-Core Version:    0.7.0.1
 */