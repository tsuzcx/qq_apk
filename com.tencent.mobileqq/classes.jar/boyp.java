import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.List;
import java.util.Map;

public class boyp
  implements bowe
{
  public boyp(DoodleEditView paramDoodleEditView) {}
  
  public void a(bpdg parambpdg)
  {
    bovv localbovv;
    Object localObject;
    if ((parambpdg instanceof bovv))
    {
      localbovv = (bovv)parambpdg;
      if (localbovv.b) {
        if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))
        {
          localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
          ((bovr)localObject).b.remove(localbovv);
          this.a.jdField_a_of_type_Bowd.c();
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambpdg, 0);
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.p();
      return;
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
      break;
      if ((localbovv.h == 1) && ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()))) {}
      for (localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();; localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a())
      {
        localObject = (List)((bovr)localObject).a.get(localbovv.d);
        if (localObject == null) {
          break;
        }
        ((List)localObject).remove(localbovv.e);
        break;
      }
      if ((parambpdg instanceof bowi)) {
        this.a.jdField_a_of_type_Bowd.c();
      } else {
        this.a.jdField_a_of_type_Bowd.c();
      }
    }
  }
  
  public void a(bpdg parambpdg, int paramInt1, int paramInt2)
  {
    if (parambpdg == null) {}
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e());
      if ((parambpdg instanceof bowi))
      {
        a(parambpdg, paramInt1, paramInt2, 0.0F, 0.0F);
        return;
      }
    } while (((!(parambpdg instanceof bovv)) && (!(parambpdg instanceof bovs))) || (DoodleEditView.a(this.a) == null));
    DoodleEditView.a(this.a).a(parambpdg);
  }
  
  public void a(bpdg parambpdg, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    int i;
    if ((parambpdg instanceof bowi))
    {
      parambpdg = ((bowi)parambpdg).a;
      if (parambpdg != null)
      {
        i = paramInt2;
        if (!parambpdg.a())
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
      parambpdg.a();
      parambpdg.a(-1, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a, false, 3000, 500, null);
      return;
    case 2: 
      parambpdg.a(paramInt1, true);
      paramInt2 = paramInt1;
      if (paramInt1 == -1) {
        paramInt2 = 0;
      }
      localDoodleLayout = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
      if (DoodleEditView.a(this.a) == 1) {
        bool1 = true;
      }
      localDoodleLayout.a(parambpdg, paramInt2, 1, bool1);
      return;
    }
    paramInt2 = paramInt1;
    if (paramInt1 == -1) {
      paramInt2 = 0;
    }
    parambpdg.a(paramInt2, true);
    DoodleLayout localDoodleLayout = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
    if (DoodleEditView.a(this.a) == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localDoodleLayout.a(parambpdg, paramInt2, 2, bool1);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }
  }
  
  public void b(bpdg parambpdg)
  {
    if (parambpdg == null) {}
    while (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) {
      return;
    }
  }
  
  public void b(bpdg parambpdg, int paramInt1, int paramInt2)
  {
    ykq.b("DoodleEditView", "onClickBottomLeftBtn click the item:" + parambpdg);
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.e()) {}
    do
    {
      do
      {
        return;
      } while (parambpdg == null);
      if (DoodleEditView.a(this.a) != null) {
        DoodleEditView.a(this.a).a();
      }
      if (parambpdg.a())
      {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(parambpdg, 1);
        if (parambpdg.g) {
          this.a.a(parambpdg);
        }
      }
    } while (parambpdg.g);
    this.a.b(parambpdg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boyp
 * JD-Core Version:    0.7.0.1
 */