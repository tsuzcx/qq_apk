import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import java.util.List;

public class bilz
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bire a;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public bilz(View paramView, AEBottomListScrollView paramAEBottomListScrollView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379086));
    this.d = ((ImageView)paramView.findViewById(2131379093));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131379099));
    this.b = ((ImageView)paramView.findViewById(2131379100));
    this.c = ((ImageView)paramView.findViewById(2131379095));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131379137));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString.equals("0")) {
      return (String)bilv.a().get(5);
    }
    if (this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
      return (String)bilv.a().get(6);
    }
    if (bilv.a()) {
      if (paramInt == 1) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      return (String)bilv.a().get(paramInt);
      paramInt = (paramInt - 1 - 1) % 4;
      continue;
      paramInt = (paramInt - 1) % 4;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_AndroidWidgetProgressBar == null);
          this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          return;
        } while (this.jdField_a_of_type_AndroidWidgetProgressBar == null);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      } while (this.jdField_a_of_type_AndroidWidgetProgressBar == null);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    case 3: 
      if (this.c != null) {
        this.c.setVisibility(0);
      }
      if (this.jdField_a_of_type_Bire.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      return;
    }
    if (this.c != null) {
      this.c.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  public void a(bire parambire)
  {
    this.jdField_a_of_type_Bire = parambire;
    if (this.jdField_a_of_type_Bire != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      if ((!"0".equals(this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString)) && (!"call_material_id".equals(this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString))) {
        break label206;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.b.setVisibility(8);
      this.d.setVisibility(8);
      if (!this.jdField_a_of_type_Bire.b()) {
        break label566;
      }
      this.b.setVisibility(0);
      this.b.setImageResource(this.jdField_a_of_type_Bire.a());
    }
    for (;;)
    {
      this.itemView.setOnClickListener(this);
      parambire = a(getAdapterPosition());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131376882, parambire);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131376851, Boolean.valueOf(false));
      vzl.a(this.jdField_a_of_type_AndroidWidgetImageView, parambire, vzl.a(this.itemView.getContext(), 54.0F), vzl.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130849653), null);
      return;
      label206:
      if ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setImageResource(2130843772);
        break;
      }
      if (this.jdField_a_of_type_Bire.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setTag(2131376882, this.jdField_a_of_type_Bire.c);
        this.d.setTag(2131376851, Boolean.valueOf(false));
        vzl.a(this.d, this.jdField_a_of_type_Bire.c, vzl.a(this.itemView.getContext(), 54.0F), vzl.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130849653), null);
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setImageResource(2130845104);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.d.setVisibility(0);
      this.d.setTag(2131376882, this.jdField_a_of_type_Bire.c);
      this.d.setTag(2131376851, Boolean.valueOf(false));
      vzl.a(this.d, this.jdField_a_of_type_Bire.c, vzl.a(this.itemView.getContext(), 54.0F), vzl.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130849653), null);
      if (this.jdField_a_of_type_Bire.d) {
        a(2);
      }
      for (;;)
      {
        this.b.setVisibility(8);
        break;
        if (this.jdField_a_of_type_Bire.e) {
          a(1);
        } else {
          a(0);
        }
      }
      label566:
      if (this.jdField_a_of_type_Bire.a())
      {
        this.b.setVisibility(0);
        this.b.setImageResource(2130845104);
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
  }
  
  public void b(bire parambire)
  {
    this.jdField_a_of_type_Bire = parambire;
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (i >= 0)) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(i);
    }
    if ((this.jdField_a_of_type_Bire != null) && ("call_material_id".equals(this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString)))
    {
      bizt.a().y();
      return;
    }
    bizx.a().g("none");
    bizx.a().f("2");
    bizx.a().c(0);
    Object localObject;
    if (i == 0)
    {
      bizx.a().b(-1);
      localObject = bizt.a();
      if (this.jdField_a_of_type_Bire != null) {
        break label189;
      }
      paramView = "";
      label101:
      ((bizt)localObject).b(paramView);
      localObject = new StringBuilder().append("【Click】Item :");
      if (this.jdField_a_of_type_Bire != null) {
        break label200;
      }
      paramView = "";
      label129:
      bjah.b("AEBottomListAdapter", paramView);
      localObject = new StringBuilder().append("【Click】Usable :");
      if (this.jdField_a_of_type_Bire != null) {
        break label211;
      }
    }
    label189:
    label200:
    label211:
    for (paramView = "";; paramView = Boolean.valueOf(this.jdField_a_of_type_Bire.d))
    {
      bjah.b("AEBottomListAdapter", paramView);
      return;
      bizx.a().b(i);
      break;
      paramView = this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString;
      break label101;
      paramView = this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString;
      break label129;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilz
 * JD-Core Version:    0.7.0.1
 */