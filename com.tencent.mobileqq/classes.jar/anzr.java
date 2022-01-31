import android.graphics.Rect;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;

public class anzr
  implements BaseLayer.OnLayerTouchListener
{
  private final int jdField_a_of_type_Int = DisplayUtil.a(DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout), 40.0F);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  
  private anzr(DoodleLayout paramDoodleLayout) {}
  
  public boolean a(BaseLayer paramBaseLayer, MotionEvent paramMotionEvent)
  {
    Rect localRect = null;
    if ((paramBaseLayer instanceof FaceLayer))
    {
      localRect = new Rect();
      localRect = ((FaceLayer)paramBaseLayer).a(localRect);
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = (int)Math.abs(f2 - DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
    int j;
    int k;
    int m;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 3: 
    case 4: 
    default: 
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      do
      {
        return false;
        TakeVideoUtils.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
        paramBaseLayer = this.jdField_a_of_type_AndroidGraphicsRect;
        paramBaseLayer.top -= this.jdField_a_of_type_Int;
        paramBaseLayer = this.jdField_a_of_type_AndroidGraphicsRect;
        paramBaseLayer.bottom += this.jdField_a_of_type_Int;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getGlobalVisibleRect(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(4);
        DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, (int)f2);
        return false;
      } while (i <= DoodleLayout.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e()))
      {
        i = (int)f1;
        j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
        k = (int)f2;
        m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
        if ((this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(f1, f2, localRect)))
        {
          DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, true);
          return false;
        }
        DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        return false;
      }
      if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)))
      {
        DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, true);
        return false;
      }
      DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
      return false;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a()) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.e())))
    {
      i = (int)f1;
      j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
      k = (int)f2;
      m = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
      if ((DoodleLayout.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout)) && ((this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(f1, f2, localRect))))
      {
        if (!(paramBaseLayer instanceof FaceLayer)) {
          break label593;
        }
        SLog.b("DoodleLayout", "remove face.");
        ((FaceLayer)paramBaseLayer).b();
        DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.n();
      }
    }
    label593:
    while ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_AndroidGraphicsRect == null) || (!this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2))) {
      for (;;)
      {
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d() == 1) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.q();
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.j();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(0);
        return false;
        if ((paramBaseLayer instanceof TextLayer))
        {
          SLog.b("DoodleLayout", "editpic remove text.");
          ((TextLayer)paramBaseLayer).h();
          paramBaseLayer.d(false);
        }
        else if ((paramBaseLayer instanceof TextFaceEditLayer))
        {
          paramMotionEvent = ((TextFaceEditLayer)paramBaseLayer).a();
          if ((paramMotionEvent != null) && ((paramMotionEvent instanceof VoteLayer.VoteItem)))
          {
            SLog.b("DoodleLayout", "delete vote item from edit layer.");
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((VoteLayer.VoteItem)paramMotionEvent);
          }
          ((TextFaceEditLayer)paramBaseLayer).b();
        }
      }
    }
    if ((paramBaseLayer instanceof TextLayer))
    {
      SLog.b("DoodleLayout", "remove text.");
      ((TextLayer)paramBaseLayer).h();
      paramBaseLayer.d(false);
    }
    for (;;)
    {
      DoodleLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.n();
      break;
      if ((paramBaseLayer instanceof FaceLayer))
      {
        SLog.b("DoodleLayout", "remove face.");
        ((FaceLayer)paramBaseLayer).b();
      }
      else if ((paramBaseLayer instanceof TextFaceEditLayer))
      {
        paramMotionEvent = ((TextFaceEditLayer)paramBaseLayer).a();
        if ((paramMotionEvent != null) && ((paramMotionEvent instanceof VoteLayer.VoteItem)))
        {
          SLog.b("DoodleLayout", "delete vote item from edit layer.");
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((VoteLayer.VoteItem)paramMotionEvent);
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(((TextFaceEditLayer)paramBaseLayer).a(), 0);
        ((TextFaceEditLayer)paramBaseLayer).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anzr
 * JD-Core Version:    0.7.0.1
 */