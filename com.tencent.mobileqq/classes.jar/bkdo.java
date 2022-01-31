import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;
import java.util.Map;

public class bkdo
  implements bkaz
{
  public bkdo(DoodleEditView paramDoodleEditView) {}
  
  public void a(bkin parambkin)
  {
    if ((parambkin instanceof bkav))
    {
      this.a.b(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bkav)parambkin);
      if (((bkav)parambkin).a != null) {
        ((bkav)parambkin).a.a(parambkin);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambkin, 0);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.r();
      return;
      if ((parambkin instanceof bkbk))
      {
        this.a.b(true);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bkbk)parambkin);
        if (((bkbk)parambkin).a != null) {
          ((bkbk)parambkin).a.a(parambkin);
        }
      }
      else
      {
        if ((parambkin instanceof bkao))
        {
          bkao localbkao = (bkao)parambkin;
          if (localbkao.b)
          {
            if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b())) {}
            for (localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
            {
              ((bkak)localObject).b.remove(localbkao);
              this.a.jdField_a_of_type_Bkay.c();
              break;
            }
          }
          if ((localbkao.h == 1) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {}
          for (Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
          {
            localObject = (List)((bkak)localObject).a.get(localbkao.d);
            if (localObject == null) {
              break;
            }
            ((List)localObject).remove(localbkao.e);
            break;
          }
        }
        if ((parambkin instanceof bkbd))
        {
          this.a.jdField_a_of_type_Bkay.c();
          if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
            this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
          }
        }
        else
        {
          this.a.jdField_a_of_type_Bkay.c();
        }
      }
    }
  }
  
  public void a(bkin parambkin, int paramInt1, int paramInt2)
  {
    if (parambkin == null) {}
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
        } while ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) || (parambkin.n));
        if (!parambkin.a()) {
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambkin, 0);
        }
        if (!this.a.a()) {
          if ((parambkin instanceof bkbd)) {
            a(parambkin, paramInt1, paramInt2, 0.0F, 0.0F);
          }
        }
        for (;;)
        {
          if (!(parambkin instanceof bkav)) {
            break label192;
          }
          localObject = (bkav)parambkin;
          if (((bkav)localObject).a == null) {
            break;
          }
          ((bkav)localObject).a.a(parambkin, paramInt1, paramInt2);
          return;
          if ((((parambkin instanceof bkao)) || ((parambkin instanceof bkal))) && (DoodleEditView.a(this.a) != null))
          {
            DoodleEditView.a(this.a).a(parambkin);
            continue;
            if ((((parambkin instanceof bkao)) || ((parambkin instanceof bkal)) || ((parambkin instanceof bkbd))) && (DoodleEditView.a(this.a) != null)) {
              DoodleEditView.a(this.a).a(parambkin);
            }
          }
        }
      } while (!(parambkin instanceof bkbk));
      localObject = (bkbk)parambkin;
    } while (((bkbk)localObject).a == null);
    ((bkbk)localObject).a.a(parambkin, paramInt1, paramInt2);
  }
  
  public void a(bkin parambkin, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if ((parambkin instanceof bkbd))
    {
      parambkin = ((bkbd)parambkin).a;
      if (parambkin != null)
      {
        int i = paramInt2;
        if (!parambkin.a())
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
              parambkin.a();
              parambkin.a(-1, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a, false, 3000, 500, null);
              return;
              parambkin.a(paramInt1, true);
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.a) == 1) {
                bool1 = true;
              }
              ((DoodleLayout)localObject).a(parambkin, paramInt2, 1, bool1);
              return;
              paramInt2 = paramInt1;
              if (paramInt1 == -1) {
                paramInt2 = 0;
              }
              parambkin.a(paramInt2, true);
              localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
              if (DoodleEditView.a(this.a) == 1) {}
              for (bool1 = bool2;; bool1 = false)
              {
                ((DoodleLayout)localObject).a(parambkin, paramInt2, 2, bool1);
                return;
              }
              if (!(parambkin instanceof bkao)) {
                break;
              }
              localObject = (bkao)parambkin;
            } while (!((bkao)localObject).b);
            ved.b("DoodleEditView", "click the item:" + parambkin);
          } while (((bkao)localObject).c);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bkao)localObject);
          return;
          if (!(parambkin instanceof bkav)) {
            break;
          }
          this.a.b(true);
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bkav)parambkin, paramFloat1, paramFloat2);
        } while (((bkav)parambkin).a == null);
        ((bkav)parambkin).a.a(parambkin, paramInt1, paramInt2, paramFloat1, paramFloat2);
        return;
      } while (!(parambkin instanceof bkbk));
      this.a.b(true);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a((bkbk)parambkin, paramFloat1, paramFloat2);
    } while (((bkbk)parambkin).a == null);
    ((bkbk)parambkin).a.a(parambkin, paramInt1, paramInt2, paramFloat1, paramFloat2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
  }
  
  public void b(bkin parambkin)
  {
    if (parambkin == null) {}
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
          if (!(parambkin instanceof bkav)) {
            break;
          }
          localObject = (bkav)parambkin;
        } while (((bkav)localObject).a == null);
        ((bkav)localObject).a.b(parambkin);
        return;
      } while (!(parambkin instanceof bkbk));
      localObject = (bkbk)parambkin;
    } while (((bkbk)localObject).a == null);
    ((bkbk)localObject).a.b(parambkin);
  }
  
  public void b(bkin parambkin, int paramInt1, int paramInt2)
  {
    ved.b("DoodleEditView", "onClickBottomLeftBtn click the item:" + parambkin);
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) {}
    do
    {
      do
      {
        return;
      } while (parambkin == null);
      if (DoodleEditView.a(this.a) != null) {
        DoodleEditView.a(this.a).a();
      }
      if (parambkin.a())
      {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambkin, 1);
        if (parambkin.g) {
          this.a.a(parambkin);
        }
      }
    } while (parambkin.g);
    this.a.b(parambkin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdo
 * JD-Core Version:    0.7.0.1
 */