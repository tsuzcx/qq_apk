import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;
import java.util.Map;

public class bmtk
  implements bmqv
{
  public bmtk(DoodleEditView paramDoodleEditView) {}
  
  public void a(bmyj parambmyj)
  {
    if ((parambmyj instanceof bmqr))
    {
      this.a.b(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bmqr)parambmyj);
      if (((bmqr)parambmyj).a != null) {
        ((bmqr)parambmyj).a.a(parambmyj);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambmyj, 0);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.r();
      return;
      if ((parambmyj instanceof bmrg))
      {
        this.a.b(true);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bmrg)parambmyj);
        if (((bmrg)parambmyj).a != null) {
          ((bmrg)parambmyj).a.a(parambmyj);
        }
      }
      else
      {
        if ((parambmyj instanceof bmqk))
        {
          bmqk localbmqk = (bmqk)parambmyj;
          if (localbmqk.b)
          {
            if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {}
            for (localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
            {
              ((bmqg)localObject).b.remove(localbmqk);
              this.a.jdField_a_of_type_Bmqu.c();
              break;
            }
          }
          if ((localbmqk.h == 1) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {}
          for (Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
          {
            localObject = (List)((bmqg)localObject).a.get(localbmqk.d);
            if (localObject == null) {
              break;
            }
            ((List)localObject).remove(localbmqk.e);
            break;
          }
        }
        if ((parambmyj instanceof bmqz))
        {
          this.a.jdField_a_of_type_Bmqu.c();
          if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
            this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
          }
        }
        else
        {
          this.a.jdField_a_of_type_Bmqu.c();
        }
      }
    }
  }
  
  public void a(bmyj parambmyj, int paramInt1, int paramInt2)
  {
    if (parambmyj == null) {}
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
        } while ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) || (parambmyj.n));
        if (!parambmyj.a()) {
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambmyj, 0);
        }
        if (!this.a.a()) {
          if ((parambmyj instanceof bmqz)) {
            a(parambmyj, paramInt1, paramInt2, 0.0F, 0.0F);
          }
        }
        for (;;)
        {
          if (!(parambmyj instanceof bmqr)) {
            break label192;
          }
          localObject = (bmqr)parambmyj;
          if (((bmqr)localObject).a == null) {
            break;
          }
          ((bmqr)localObject).a.a(parambmyj, paramInt1, paramInt2);
          return;
          if ((((parambmyj instanceof bmqk)) || ((parambmyj instanceof bmqh))) && (DoodleEditView.a(this.a) != null))
          {
            DoodleEditView.a(this.a).a(parambmyj);
            continue;
            if ((((parambmyj instanceof bmqk)) || ((parambmyj instanceof bmqh)) || ((parambmyj instanceof bmqz))) && (DoodleEditView.a(this.a) != null)) {
              DoodleEditView.a(this.a).a(parambmyj);
            }
          }
        }
      } while (!(parambmyj instanceof bmrg));
      localObject = (bmrg)parambmyj;
    } while (((bmrg)localObject).a == null);
    ((bmrg)localObject).a.a(parambmyj, paramInt1, paramInt2);
  }
  
  public void a(bmyj parambmyj, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if ((parambmyj instanceof bmqz))
    {
      parambmyj = ((bmqz)parambmyj).a;
      if (parambmyj != null)
      {
        int i = paramInt2;
        if (!parambmyj.a())
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
              parambmyj.a();
              parambmyj.a(-1, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a, false, 3000, 500, null);
              return;
              parambmyj.a(paramInt1, true);
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.a) == 1) {
                bool1 = true;
              }
              ((DoodleLayout)localObject).a(parambmyj, paramInt2, 1, bool1);
              return;
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              parambmyj.a(paramInt2, true);
              localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.a) == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((DoodleLayout)localObject).a(parambmyj, paramInt2, 2, bool1);
                return;
              }
              if (!(parambmyj instanceof bmqk)) {
                break;
              }
              localObject = (bmqk)parambmyj;
            } while (!((bmqk)localObject).b);
            wxe.b("DoodleEditView", "click the item:" + parambmyj);
          } while (((bmqk)localObject).c);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bmqk)localObject);
          return;
          if (!(parambmyj instanceof bmqr)) {
            break;
          }
          this.a.b(true);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bmqr)parambmyj, paramFloat1, paramFloat2);
        } while (((bmqr)parambmyj).a == null);
        ((bmqr)parambmyj).a.a(parambmyj, paramInt1, paramInt2, paramFloat1, paramFloat2);
        return;
      } while (!(parambmyj instanceof bmrg));
      this.a.b(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bmrg)parambmyj, paramFloat1, paramFloat2);
    } while (((bmrg)parambmyj).a == null);
    ((bmrg)parambmyj).a.a(parambmyj, paramInt1, paramInt2, paramFloat1, paramFloat2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
  }
  
  public void b(bmyj parambmyj)
  {
    if (parambmyj == null) {}
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
          if (!(parambmyj instanceof bmqr)) {
            break;
          }
          localObject = (bmqr)parambmyj;
        } while (((bmqr)localObject).a == null);
        ((bmqr)localObject).a.b(parambmyj);
        return;
      } while (!(parambmyj instanceof bmrg));
      localObject = (bmrg)parambmyj;
    } while (((bmrg)localObject).a == null);
    ((bmrg)localObject).a.b(parambmyj);
  }
  
  public void b(bmyj parambmyj, int paramInt1, int paramInt2)
  {
    wxe.b("DoodleEditView", "onClickBottomLeftBtn click the item:" + parambmyj);
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) {}
    do
    {
      do
      {
        return;
      } while (parambmyj == null);
      if (DoodleEditView.a(this.a) != null) {
        DoodleEditView.a(this.a).a();
      }
      if (parambmyj.a())
      {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambmyj, 1);
        if (parambmyj.g) {
          this.a.a(parambmyj);
        }
      }
    } while (parambmyj.g);
    this.a.b(parambmyj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtk
 * JD-Core Version:    0.7.0.1
 */