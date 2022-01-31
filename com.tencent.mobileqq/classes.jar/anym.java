import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.InteractPasterLayer.InteractItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer.LayerListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.DoodleEditViewListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.List;
import java.util.Map;

public class anym
  implements TextFaceEditLayer.LayerListener
{
  public anym(DoodleEditView paramDoodleEditView) {}
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    if ((paramZoomItem instanceof InteractPasterLayer.InteractItem))
    {
      this.a.b(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((InteractPasterLayer.InteractItem)paramZoomItem);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(paramZoomItem, 0);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.n();
      return;
      if ((paramZoomItem instanceof VoteLayer.VoteItem))
      {
        this.a.b(true);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((VoteLayer.VoteItem)paramZoomItem);
      }
      else
      {
        if ((paramZoomItem instanceof FaceLayer.FaceItem))
        {
          FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)paramZoomItem;
          if (localFaceItem.b)
          {
            if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {}
            for (localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
            {
              ((FaceLayer)localObject).b.remove(localFaceItem);
              this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b();
              break;
            }
          }
          if ((localFaceItem.h == 1) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {}
          for (Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
          {
            localObject = (List)((FaceLayer)localObject).a.get(localFaceItem.d);
            if (localObject == null) {
              break;
            }
            ((List)localObject).remove(localFaceItem.e);
            break;
          }
        }
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b();
      }
    }
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2)
  {
    if (paramZoomItem == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramZoomItem.k);
        if (!paramZoomItem.a()) {
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(paramZoomItem, 0);
        }
        if (this.a.a()) {
          break;
        }
        if ((paramZoomItem instanceof TextLayer.TextItem))
        {
          a(paramZoomItem, paramInt1, paramInt2, 0.0F, 0.0F);
          return;
        }
      } while (((!(paramZoomItem instanceof FaceLayer.FaceItem)) && (!(paramZoomItem instanceof FaceLayer.FaceAndTextItem))) || (DoodleEditView.a(this.a) == null));
      DoodleEditView.a(this.a).a(paramZoomItem);
      return;
    } while (((!(paramZoomItem instanceof FaceLayer.FaceItem)) && (!(paramZoomItem instanceof FaceLayer.FaceAndTextItem)) && (!(paramZoomItem instanceof TextLayer.TextItem))) || (DoodleEditView.a(this.a) == null));
    DoodleEditView.a(this.a).a(paramZoomItem);
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if ((paramZoomItem instanceof TextLayer.TextItem))
    {
      paramZoomItem = ((TextLayer.TextItem)paramZoomItem).a;
      if (paramZoomItem != null)
      {
        int i = paramInt2;
        if (!paramZoomItem.a())
        {
          i = paramInt2;
          if (paramInt2 == 0) {
            i = 3;
          }
        }
        switch (i)
        {
        }
      }
    }
    do
    {
      Object localObject;
      do
      {
        return;
        paramZoomItem.a();
        paramZoomItem.a(-1, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a, false, 3000, 500, null);
        return;
        paramZoomItem.a(paramInt1, true);
        paramInt2 = paramInt1;
        if (paramInt1 == -1) {
          paramInt2 = 0;
        }
        localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        if (DoodleEditView.a(this.a) == 1) {
          bool1 = true;
        }
        ((DoodleLayout)localObject).a(paramZoomItem, paramInt2, 1, bool1);
        return;
        paramInt2 = paramInt1;
        if (paramInt1 == -1) {
          paramInt2 = 0;
        }
        paramZoomItem.a(paramInt2, true);
        localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        if (DoodleEditView.a(this.a) == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          ((DoodleLayout)localObject).a(paramZoomItem, paramInt2, 2, bool1);
          return;
        }
        if (!(paramZoomItem instanceof FaceLayer.FaceItem)) {
          break;
        }
        localObject = (FaceLayer.FaceItem)paramZoomItem;
      } while (!((FaceLayer.FaceItem)localObject).b);
      SLog.b("DoodleEditView", "click the item:" + paramZoomItem);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((FaceLayer.FaceItem)localObject);
      return;
      if ((paramZoomItem instanceof InteractPasterLayer.InteractItem))
      {
        this.a.b(true);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((InteractPasterLayer.InteractItem)paramZoomItem, paramFloat1, paramFloat2);
        return;
      }
    } while (!(paramZoomItem instanceof VoteLayer.VoteItem));
    this.a.b(true);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((VoteLayer.VoteItem)paramZoomItem, paramFloat1, paramFloat2);
  }
  
  public void b(GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2)
  {
    SLog.b("DoodleEditView", "onClickBottomLeftBtn click the item:" + paramZoomItem);
    if (paramZoomItem != null)
    {
      if (DoodleEditView.a(this.a) != null) {
        DoodleEditView.a(this.a).a();
      }
      if (paramZoomItem.a())
      {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(paramZoomItem, 1);
        if (paramZoomItem.f)
        {
          this.a.a(paramZoomItem);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramZoomItem);
        }
      }
      if (!paramZoomItem.f) {
        this.a.b(paramZoomItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anym
 * JD-Core Version:    0.7.0.1
 */