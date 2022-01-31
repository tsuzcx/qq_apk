import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;
import java.util.Map;

public class bkcx
  implements bkai
{
  public bkcx(DoodleEditView paramDoodleEditView) {}
  
  public void a(bkhw parambkhw)
  {
    if ((parambkhw instanceof bkae))
    {
      this.a.b(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bkae)parambkhw);
      if (((bkae)parambkhw).a != null) {
        ((bkae)parambkhw).a.a(parambkhw);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambkhw, 0);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.r();
      return;
      if ((parambkhw instanceof bkat))
      {
        this.a.b(true);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bkat)parambkhw);
        if (((bkat)parambkhw).a != null) {
          ((bkat)parambkhw).a.a(parambkhw);
        }
      }
      else
      {
        if ((parambkhw instanceof bjzx))
        {
          bjzx localbjzx = (bjzx)parambkhw;
          if (localbjzx.b)
          {
            if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {}
            for (localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
            {
              ((bjzt)localObject).b.remove(localbjzx);
              this.a.jdField_a_of_type_Bkah.c();
              break;
            }
          }
          if ((localbjzx.h == 1) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {}
          for (Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
          {
            localObject = (List)((bjzt)localObject).a.get(localbjzx.d);
            if (localObject == null) {
              break;
            }
            ((List)localObject).remove(localbjzx.e);
            break;
          }
        }
        if ((parambkhw instanceof bkam))
        {
          this.a.jdField_a_of_type_Bkah.c();
          if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
            this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
          }
        }
        else
        {
          this.a.jdField_a_of_type_Bkah.c();
        }
      }
    }
  }
  
  public void a(bkhw parambkhw, int paramInt1, int paramInt2)
  {
    if (parambkhw == null) {}
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
        } while ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) || (parambkhw.n));
        if (!parambkhw.a()) {
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambkhw, 0);
        }
        if (!this.a.a()) {
          if ((parambkhw instanceof bkam)) {
            a(parambkhw, paramInt1, paramInt2, 0.0F, 0.0F);
          }
        }
        for (;;)
        {
          if (!(parambkhw instanceof bkae)) {
            break label192;
          }
          localObject = (bkae)parambkhw;
          if (((bkae)localObject).a == null) {
            break;
          }
          ((bkae)localObject).a.a(parambkhw, paramInt1, paramInt2);
          return;
          if ((((parambkhw instanceof bjzx)) || ((parambkhw instanceof bjzu))) && (DoodleEditView.a(this.a) != null))
          {
            DoodleEditView.a(this.a).a(parambkhw);
            continue;
            if ((((parambkhw instanceof bjzx)) || ((parambkhw instanceof bjzu)) || ((parambkhw instanceof bkam))) && (DoodleEditView.a(this.a) != null)) {
              DoodleEditView.a(this.a).a(parambkhw);
            }
          }
        }
      } while (!(parambkhw instanceof bkat));
      localObject = (bkat)parambkhw;
    } while (((bkat)localObject).a == null);
    ((bkat)localObject).a.a(parambkhw, paramInt1, paramInt2);
  }
  
  public void a(bkhw parambkhw, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if ((parambkhw instanceof bkam))
    {
      parambkhw = ((bkam)parambkhw).a;
      if (parambkhw != null)
      {
        int i = paramInt2;
        if (!parambkhw.a())
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
              parambkhw.a();
              parambkhw.a(-1, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a, false, 3000, 500, null);
              return;
              parambkhw.a(paramInt1, true);
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.a) == 1) {
                bool1 = true;
              }
              ((DoodleLayout)localObject).a(parambkhw, paramInt2, 1, bool1);
              return;
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              parambkhw.a(paramInt2, true);
              localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.a) == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((DoodleLayout)localObject).a(parambkhw, paramInt2, 2, bool1);
                return;
              }
              if (!(parambkhw instanceof bjzx)) {
                break;
              }
              localObject = (bjzx)parambkhw;
            } while (!((bjzx)localObject).b);
            veg.b("DoodleEditView", "click the item:" + parambkhw);
          } while (((bjzx)localObject).c);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bjzx)localObject);
          return;
          if (!(parambkhw instanceof bkae)) {
            break;
          }
          this.a.b(true);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bkae)parambkhw, paramFloat1, paramFloat2);
        } while (((bkae)parambkhw).a == null);
        ((bkae)parambkhw).a.a(parambkhw, paramInt1, paramInt2, paramFloat1, paramFloat2);
        return;
      } while (!(parambkhw instanceof bkat));
      this.a.b(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bkat)parambkhw, paramFloat1, paramFloat2);
    } while (((bkat)parambkhw).a == null);
    ((bkat)parambkhw).a.a(parambkhw, paramInt1, paramInt2, paramFloat1, paramFloat2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
  }
  
  public void b(bkhw parambkhw)
  {
    if (parambkhw == null) {}
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
          if (!(parambkhw instanceof bkae)) {
            break;
          }
          localObject = (bkae)parambkhw;
        } while (((bkae)localObject).a == null);
        ((bkae)localObject).a.b(parambkhw);
        return;
      } while (!(parambkhw instanceof bkat));
      localObject = (bkat)parambkhw;
    } while (((bkat)localObject).a == null);
    ((bkat)localObject).a.b(parambkhw);
  }
  
  public void b(bkhw parambkhw, int paramInt1, int paramInt2)
  {
    veg.b("DoodleEditView", "onClickBottomLeftBtn click the item:" + parambkhw);
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) {}
    do
    {
      do
      {
        return;
      } while (parambkhw == null);
      if (DoodleEditView.a(this.a) != null) {
        DoodleEditView.a(this.a).a();
      }
      if (parambkhw.a())
      {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambkhw, 1);
        if (parambkhw.g) {
          this.a.a(parambkhw);
        }
      }
    } while (parambkhw.g);
    this.a.b(parambkhw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkcx
 * JD-Core Version:    0.7.0.1
 */