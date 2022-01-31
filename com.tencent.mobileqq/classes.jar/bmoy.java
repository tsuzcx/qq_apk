import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;
import java.util.Map;

public class bmoy
  implements bmmj
{
  public bmoy(DoodleEditView paramDoodleEditView) {}
  
  public void a(bmtx parambmtx)
  {
    if ((parambmtx instanceof bmmf))
    {
      this.a.b(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bmmf)parambmtx);
      if (((bmmf)parambmtx).a != null) {
        ((bmmf)parambmtx).a.a(parambmtx);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambmtx, 0);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.r();
      return;
      if ((parambmtx instanceof bmmu))
      {
        this.a.b(true);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bmmu)parambmtx);
        if (((bmmu)parambmtx).a != null) {
          ((bmmu)parambmtx).a.a(parambmtx);
        }
      }
      else
      {
        if ((parambmtx instanceof bmly))
        {
          bmly localbmly = (bmly)parambmtx;
          if (localbmly.b)
          {
            if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {}
            for (localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
            {
              ((bmlu)localObject).b.remove(localbmly);
              this.a.jdField_a_of_type_Bmmi.c();
              break;
            }
          }
          if ((localbmly.h == 1) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {}
          for (Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
          {
            localObject = (List)((bmlu)localObject).a.get(localbmly.d);
            if (localObject == null) {
              break;
            }
            ((List)localObject).remove(localbmly.e);
            break;
          }
        }
        if ((parambmtx instanceof bmmn))
        {
          this.a.jdField_a_of_type_Bmmi.c();
          if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
            this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
          }
        }
        else
        {
          this.a.jdField_a_of_type_Bmmi.c();
        }
      }
    }
  }
  
  public void a(bmtx parambmtx, int paramInt1, int paramInt2)
  {
    if (parambmtx == null) {}
    label4:
    Object localObject;
    label192:
    do
    {
      do
      {
        break label4;
        do
        {
          return;
        } while ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) || (parambmtx.n));
        if (!parambmtx.a()) {
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambmtx, 0);
        }
        if (!this.a.a()) {
          if ((parambmtx instanceof bmmn)) {
            a(parambmtx, paramInt1, paramInt2, 0.0F, 0.0F);
          }
        }
        for (;;)
        {
          if (!(parambmtx instanceof bmmf)) {
            break label192;
          }
          localObject = (bmmf)parambmtx;
          if (((bmmf)localObject).a == null) {
            break;
          }
          ((bmmf)localObject).a.a(parambmtx, paramInt1, paramInt2);
          return;
          if ((((parambmtx instanceof bmly)) || ((parambmtx instanceof bmlv))) && (DoodleEditView.a(this.a) != null))
          {
            DoodleEditView.a(this.a).a(parambmtx);
            continue;
            if ((((parambmtx instanceof bmly)) || ((parambmtx instanceof bmlv)) || ((parambmtx instanceof bmmn))) && (DoodleEditView.a(this.a) != null)) {
              DoodleEditView.a(this.a).a(parambmtx);
            }
          }
        }
      } while (!(parambmtx instanceof bmmu));
      localObject = (bmmu)parambmtx;
    } while (((bmmu)localObject).a == null);
    ((bmmu)localObject).a.a(parambmtx, paramInt1, paramInt2);
  }
  
  public void a(bmtx parambmtx, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if ((parambmtx instanceof bmmn))
    {
      parambmtx = ((bmmn)parambmtx).a;
      if (parambmtx != null)
      {
        int i = paramInt2;
        if (!parambmtx.a())
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
      do
      {
        do
        {
          Object localObject;
          do
          {
            do
            {
              return;
              parambmtx.a();
              parambmtx.a(-1, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a, false, 3000, 500, null);
              return;
              parambmtx.a(paramInt1, true);
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.a) == 1) {
                bool1 = true;
              }
              ((DoodleLayout)localObject).a(parambmtx, paramInt2, 1, bool1);
              return;
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              parambmtx.a(paramInt2, true);
              localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.a) == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((DoodleLayout)localObject).a(parambmtx, paramInt2, 2, bool1);
                return;
              }
              if (!(parambmtx instanceof bmly)) {
                break;
              }
              localObject = (bmly)parambmtx;
            } while (!((bmly)localObject).b);
            wsv.b("DoodleEditView", "click the item:" + parambmtx);
          } while (((bmly)localObject).c);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bmly)localObject);
          return;
          if (!(parambmtx instanceof bmmf)) {
            break;
          }
          this.a.b(true);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bmmf)parambmtx, paramFloat1, paramFloat2);
        } while (((bmmf)parambmtx).a == null);
        ((bmmf)parambmtx).a.a(parambmtx, paramInt1, paramInt2, paramFloat1, paramFloat2);
        return;
      } while (!(parambmtx instanceof bmmu));
      this.a.b(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bmmu)parambmtx, paramFloat1, paramFloat2);
    } while (((bmmu)parambmtx).a == null);
    ((bmmu)parambmtx).a.a(parambmtx, paramInt1, paramInt2, paramFloat1, paramFloat2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
  }
  
  public void b(bmtx parambmtx)
  {
    if (parambmtx == null) {}
    label4:
    Object localObject;
    do
    {
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e());
          if (!(parambmtx instanceof bmmf)) {
            break;
          }
          localObject = (bmmf)parambmtx;
        } while (((bmmf)localObject).a == null);
        ((bmmf)localObject).a.b(parambmtx);
        return;
      } while (!(parambmtx instanceof bmmu));
      localObject = (bmmu)parambmtx;
    } while (((bmmu)localObject).a == null);
    ((bmmu)localObject).a.b(parambmtx);
  }
  
  public void b(bmtx parambmtx, int paramInt1, int paramInt2)
  {
    wsv.b("DoodleEditView", "onClickBottomLeftBtn click the item:" + parambmtx);
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) {}
    do
    {
      do
      {
        return;
      } while (parambmtx == null);
      if (DoodleEditView.a(this.a) != null) {
        DoodleEditView.a(this.a).a();
      }
      if (parambmtx.a())
      {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambmtx, 1);
        if (parambmtx.g) {
          this.a.a(parambmtx);
        }
      }
    } while (parambmtx.g);
    this.a.b(parambmtx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmoy
 * JD-Core Version:    0.7.0.1
 */