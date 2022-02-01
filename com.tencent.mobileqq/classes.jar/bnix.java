import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;
import java.util.Map;

public class bnix
  implements bngm
{
  public bnix(DoodleEditView paramDoodleEditView) {}
  
  public void a(bnno parambnno)
  {
    bngd localbngd;
    Object localObject;
    if ((parambnno instanceof bngd))
    {
      localbngd = (bngd)parambnno;
      if (localbngd.b) {
        if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))
        {
          localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
          ((bnfz)localObject).b.remove(localbngd);
          this.a.jdField_a_of_type_Bngl.c();
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambnno, 0);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.p();
      return;
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
      break;
      if ((localbngd.h == 1) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {}
      for (localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
      {
        localObject = (List)((bnfz)localObject).a.get(localbngd.d);
        if (localObject == null) {
          break;
        }
        ((List)localObject).remove(localbngd.e);
        break;
      }
      if ((parambnno instanceof bngq)) {
        this.a.jdField_a_of_type_Bngl.c();
      } else {
        this.a.jdField_a_of_type_Bngl.c();
      }
    }
  }
  
  public void a(bnno parambnno, int paramInt1, int paramInt2)
  {
    if (parambnno == null) {}
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e());
      if ((parambnno instanceof bngq))
      {
        a(parambnno, paramInt1, paramInt2, 0.0F, 0.0F);
        return;
      }
    } while (((!(parambnno instanceof bngd)) && (!(parambnno instanceof bnga))) || (DoodleEditView.a(this.a) == null));
    DoodleEditView.a(this.a).a(parambnno);
  }
  
  public void a(bnno parambnno, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    int i;
    if ((parambnno instanceof bngq))
    {
      parambnno = ((bngq)parambnno).a;
      if (parambnno != null)
      {
        i = paramInt2;
        if (!parambnno.a())
        {
          i = paramInt2;
          if (paramInt2 == 0) {
            i = 3;
          }
        }
      }
    }
    switch (i)
    {
    case 1: 
    default: 
      return;
    case 0: 
      parambnno.a();
      parambnno.a(-1, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a, false, 3000, 500, null);
      return;
    case 2: 
      parambnno.a(paramInt1, true);
      paramInt2 = paramInt1;
      if (paramInt1 == -1) {
        paramInt2 = 0;
      }
      localDoodleLayout = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
      if (DoodleEditView.a(this.a) == 1) {
        bool1 = true;
      }
      localDoodleLayout.a(parambnno, paramInt2, 1, bool1);
      return;
    }
    paramInt2 = paramInt1;
    if (paramInt1 == -1) {
      paramInt2 = 0;
    }
    parambnno.a(paramInt2, true);
    DoodleLayout localDoodleLayout = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
    if (DoodleEditView.a(this.a) == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localDoodleLayout.a(parambnno, paramInt2, 2, bool1);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
  }
  
  public void b(bnno parambnno)
  {
    if (parambnno == null) {}
    while (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) {
      return;
    }
  }
  
  public void b(bnno parambnno, int paramInt1, int paramInt2)
  {
    xvv.b("DoodleEditView", "onClickBottomLeftBtn click the item:" + parambnno);
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) {}
    do
    {
      do
      {
        return;
      } while (parambnno == null);
      if (DoodleEditView.a(this.a) != null) {
        DoodleEditView.a(this.a).a();
      }
      if (parambnno.a())
      {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambnno, 1);
        if (parambnno.g) {
          this.a.a(parambnno);
        }
      }
    } while (parambnno.g);
    this.a.b(parambnno);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnix
 * JD-Core Version:    0.7.0.1
 */