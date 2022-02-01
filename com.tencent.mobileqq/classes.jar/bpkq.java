import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;
import java.util.Map;

public class bpkq
  implements bpib
{
  public bpkq(DoodleEditView paramDoodleEditView) {}
  
  public void a(bppp parambppp)
  {
    if ((parambppp instanceof bphx))
    {
      this.a.b(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bphx)parambppp);
      if (((bphx)parambppp).a != null) {
        ((bphx)parambppp).a.a(parambppp);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambppp, 0);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.r();
      return;
      if ((parambppp instanceof bpim))
      {
        this.a.b(true);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bpim)parambppp);
        if (((bpim)parambppp).a != null) {
          ((bpim)parambppp).a.a(parambppp);
        }
      }
      else
      {
        if ((parambppp instanceof bphq))
        {
          bphq localbphq = (bphq)parambppp;
          if (localbphq.b)
          {
            if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {}
            for (localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
            {
              ((bphm)localObject).b.remove(localbphq);
              this.a.jdField_a_of_type_Bpia.c();
              break;
            }
          }
          if ((localbphq.h == 1) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {}
          for (Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
          {
            localObject = (List)((bphm)localObject).a.get(localbphq.d);
            if (localObject == null) {
              break;
            }
            ((List)localObject).remove(localbphq.e);
            break;
          }
        }
        if ((parambppp instanceof bpif))
        {
          this.a.jdField_a_of_type_Bpia.c();
          if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
            this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
          }
        }
        else
        {
          this.a.jdField_a_of_type_Bpia.c();
        }
      }
    }
  }
  
  public void a(bppp parambppp, int paramInt1, int paramInt2)
  {
    if (parambppp == null) {}
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
        } while ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) || (parambppp.n));
        if (!parambppp.a()) {
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambppp, 0);
        }
        if (!this.a.a()) {
          if ((parambppp instanceof bpif)) {
            a(parambppp, paramInt1, paramInt2, 0.0F, 0.0F);
          }
        }
        for (;;)
        {
          if (!(parambppp instanceof bphx)) {
            break label192;
          }
          localObject = (bphx)parambppp;
          if (((bphx)localObject).a == null) {
            break;
          }
          ((bphx)localObject).a.a(parambppp, paramInt1, paramInt2);
          return;
          if ((((parambppp instanceof bphq)) || ((parambppp instanceof bphn))) && (DoodleEditView.a(this.a) != null))
          {
            DoodleEditView.a(this.a).a(parambppp);
            continue;
            if ((((parambppp instanceof bphq)) || ((parambppp instanceof bphn)) || ((parambppp instanceof bpif))) && (DoodleEditView.a(this.a) != null)) {
              DoodleEditView.a(this.a).a(parambppp);
            }
          }
        }
      } while (!(parambppp instanceof bpim));
      localObject = (bpim)parambppp;
    } while (((bpim)localObject).a == null);
    ((bpim)localObject).a.a(parambppp, paramInt1, paramInt2);
  }
  
  public void a(bppp parambppp, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if ((parambppp instanceof bpif))
    {
      parambppp = ((bpif)parambppp).a;
      if (parambppp != null)
      {
        int i = paramInt2;
        if (!parambppp.a())
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
              parambppp.a();
              parambppp.a(-1, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a, false, 3000, 500, null);
              return;
              parambppp.a(paramInt1, true);
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.a) == 1) {
                bool1 = true;
              }
              ((DoodleLayout)localObject).a(parambppp, paramInt2, 1, bool1);
              return;
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              parambppp.a(paramInt2, true);
              localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.a) == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((DoodleLayout)localObject).a(parambppp, paramInt2, 2, bool1);
                return;
              }
              if (!(parambppp instanceof bphq)) {
                break;
              }
              localObject = (bphq)parambppp;
            } while (!((bphq)localObject).b);
            yqp.b("DoodleEditView", "click the item:" + parambppp);
          } while (((bphq)localObject).c);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bphq)localObject);
          return;
          if (!(parambppp instanceof bphx)) {
            break;
          }
          this.a.b(true);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bphx)parambppp, paramFloat1, paramFloat2);
        } while (((bphx)parambppp).a == null);
        ((bphx)parambppp).a.a(parambppp, paramInt1, paramInt2, paramFloat1, paramFloat2);
        return;
      } while (!(parambppp instanceof bpim));
      this.a.b(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bpim)parambppp, paramFloat1, paramFloat2);
    } while (((bpim)parambppp).a == null);
    ((bpim)parambppp).a.a(parambppp, paramInt1, paramInt2, paramFloat1, paramFloat2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
  }
  
  public void b(bppp parambppp)
  {
    if (parambppp == null) {}
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
          if (!(parambppp instanceof bphx)) {
            break;
          }
          localObject = (bphx)parambppp;
        } while (((bphx)localObject).a == null);
        ((bphx)localObject).a.b(parambppp);
        return;
      } while (!(parambppp instanceof bpim));
      localObject = (bpim)parambppp;
    } while (((bpim)localObject).a == null);
    ((bpim)localObject).a.b(parambppp);
  }
  
  public void b(bppp parambppp, int paramInt1, int paramInt2)
  {
    yqp.b("DoodleEditView", "onClickBottomLeftBtn click the item:" + parambppp);
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) {}
    do
    {
      do
      {
        return;
      } while (parambppp == null);
      if (DoodleEditView.a(this.a) != null) {
        DoodleEditView.a(this.a).a();
      }
      if (parambppp.a())
      {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambppp, 1);
        if (parambppp.g) {
          this.a.a(parambppp);
        }
      }
    } while (parambppp.g);
    this.a.b(parambppp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkq
 * JD-Core Version:    0.7.0.1
 */