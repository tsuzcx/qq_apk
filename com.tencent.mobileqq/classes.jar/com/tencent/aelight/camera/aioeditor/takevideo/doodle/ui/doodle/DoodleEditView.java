package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import java.util.ArrayList;
import java.util.List;

public class DoodleEditView
  extends DoodleView
  implements DoodleLayout.OnTextDialogShowListener
{
  protected TextFaceEditLayer a;
  Runnable b = new DoodleEditView.3(this);
  private float n = 0.0F;
  private float o = 0.0F;
  private int p;
  private boolean q = false;
  private DoodleEditView.DoodleEditViewListener r;
  private IFaceSelectedListener s;
  private boolean t = false;
  
  public DoodleEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  protected void a()
  {
    this.a = new TextFaceEditLayer(this);
    setLayerType(1, null);
    this.s = new DoodleEditView.1(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = getContext().getResources().getDisplayMetrics().widthPixels;
    int i = getContext().getResources().getDisplayMetrics().heightPixels;
    if (EditPicRawImage.f != 0) {
      i = EditPicRawImage.f;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("w: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" h: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" width: ");
    localStringBuilder.append(j);
    localStringBuilder.append(" height: ");
    localStringBuilder.append(i);
    AEQLog.b("DoodleEditView", localStringBuilder.toString());
    if (j > paramInt1) {
      this.n = ((j - paramInt1) / 2.0F);
    }
    if (i > paramInt2) {
      this.o = ((i - paramInt2) / 2.0F);
    }
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.h = paramEditVideoParams;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.b);
    }
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0)))
    {
      if (this.a.d())
      {
        localObject1 = this.a.h();
        ((GestureHelper.ZoomItem)localObject1).M = false;
        Object localObject2;
        Object localObject3;
        if ((localObject1 instanceof FaceLayer.FaceItem))
        {
          localObject2 = (FaceLayer)this.l.v.a(FaceLayer.a);
          localObject3 = (FaceLayer.FaceItem)localObject1;
          if (((FaceLayer.FaceItem)localObject3).y != 1)
          {
            localObject1 = localObject2;
            if (((FaceLayer.FaceItem)localObject3).y != 3) {}
          }
          else if (this.h != null)
          {
            localObject1 = localObject2;
            if (!this.h.c()) {}
          }
          else
          {
            localObject1 = (FaceLayer)this.l.v.a("DynamicFaceLayer");
            ((FaceLayer.FaceItem)localObject3).l.setCallback(this.l.v);
          }
          if (localObject1 != null) {
            ((FaceLayer)localObject1).b.add(localObject3);
          }
        }
        else if ((localObject1 instanceof TextLayer.TextItem))
        {
          localObject1 = (TextLayer.TextItem)localObject1;
          if (((TextLayer.TextItem)localObject1).c != null) {
            ((TextLayer.TextItem)localObject1).c.a(-1, false);
          }
          localObject2 = (TextLayer)this.l.v.a(TextLayer.a);
          if (localObject2 != null)
          {
            localObject3 = ((TextLayer.TextItem)localObject1).c;
            if (localObject3 != null)
            {
              if ((!((DynamicTextItem)localObject3).m()) && (((DynamicTextItem)localObject3).l())) {
                ((DynamicTextItem)localObject3).a(true);
              }
              if (!((DynamicTextItem)localObject3).e()) {
                ((TextLayer)localObject2).t.add(localObject1);
              }
            }
          }
        }
        this.l.v.invalidate();
      }
      this.a.i();
      setVisibility(8);
      Object localObject1 = this.r;
      if (localObject1 != null) {
        ((DoodleEditView.DoodleEditViewListener)localObject1).a();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(4);
      return;
    }
    postDelayed(this.b, TextLayer.f);
  }
  
  public boolean b()
  {
    return this.q;
  }
  
  public void c()
  {
    super.c();
    this.a.f();
    this.n = 0.0F;
    this.o = 0.0F;
  }
  
  public void d()
  {
    a(false);
  }
  
  public IFaceSelectedListener getFaceSelectedListener()
  {
    return this.s;
  }
  
  public int getFrom()
  {
    return this.p;
  }
  
  public TextFaceEditLayer getTextFaceEditLayer()
  {
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.m) {
      return;
    }
    paramCanvas.save();
    if ((this.n > 0.0F) || (this.o > 0.0F)) {
      paramCanvas.translate(this.n, this.o);
    }
    this.a.d(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if ((this.n <= 0.0F) && (this.o <= 0.0F))
    {
      i = 0;
    }
    else
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      localMotionEvent.setLocation(paramMotionEvent.getX() - this.n, paramMotionEvent.getY() - this.o);
      paramMotionEvent = localMotionEvent;
      i = 1;
    }
    if ((paramMotionEvent.getAction() == 0) && (this.a.b(paramMotionEvent))) {
      this.t = true;
    }
    boolean bool;
    if (this.t)
    {
      bool = this.a.c(paramMotionEvent);
      invalidate();
    }
    else
    {
      d();
      bool = false;
    }
    if (paramMotionEvent.getAction() == 1) {
      this.t = false;
    }
    if (i != 0) {
      paramMotionEvent.recycle();
    }
    return bool;
  }
  
  public void setDoodleEditViewListener(DoodleEditView.DoodleEditViewListener paramDoodleEditViewListener)
  {
    this.r = paramDoodleEditViewListener;
  }
  
  public void setFrom(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.a.a(this.l.G);
    this.a.a(new DoodleEditView.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */