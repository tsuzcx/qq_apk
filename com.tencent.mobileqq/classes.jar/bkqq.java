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

public class bkqq
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bkvu a;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public bkqq(View paramView, AEBottomListScrollView paramAEBottomListScrollView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379765));
    this.d = ((ImageView)paramView.findViewById(2131379772));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131379778));
    this.b = ((ImageView)paramView.findViewById(2131379779));
    this.c = ((ImageView)paramView.findViewById(2131379774));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131379830));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString.equals("0")) {
      return (String)bkqk.a().get(5);
    }
    if (this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
      return (String)bkqk.a().get(6);
    }
    if (bkqk.a()) {
      if (paramInt == 1) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      return (String)bkqk.a().get(paramInt);
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
      if (this.jdField_a_of_type_Bkvu.jdField_a_of_type_Boolean)
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
  
  public void a(bkvu parambkvu)
  {
    this.jdField_a_of_type_Bkvu = parambkvu;
    if (this.jdField_a_of_type_Bkvu != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      if ((!"0".equals(this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString)) && (!"call_material_id".equals(this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString))) {
        break label206;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.b.setVisibility(8);
      this.d.setVisibility(8);
      if (!this.jdField_a_of_type_Bkvu.b()) {
        break label566;
      }
      this.b.setVisibility(0);
      this.b.setImageResource(this.jdField_a_of_type_Bkvu.a());
    }
    for (;;)
    {
      this.itemView.setOnClickListener(this);
      parambkvu = a(getAdapterPosition());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131377396, parambkvu);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131377365, Boolean.valueOf(false));
      xod.a(this.jdField_a_of_type_AndroidWidgetImageView, parambkvu, xod.a(this.itemView.getContext(), 54.0F), xod.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130850087), null);
      return;
      label206:
      if ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setImageResource(2130844115);
        break;
      }
      if (this.jdField_a_of_type_Bkvu.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setTag(2131377396, this.jdField_a_of_type_Bkvu.c);
        this.d.setTag(2131377365, Boolean.valueOf(false));
        xod.a(this.d, this.jdField_a_of_type_Bkvu.c, xod.a(this.itemView.getContext(), 54.0F), xod.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130850087), null);
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setImageResource(2130845469);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.d.setVisibility(0);
      this.d.setTag(2131377396, this.jdField_a_of_type_Bkvu.c);
      this.d.setTag(2131377365, Boolean.valueOf(false));
      xod.a(this.d, this.jdField_a_of_type_Bkvu.c, xod.a(this.itemView.getContext(), 54.0F), xod.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130850087), null);
      if (this.jdField_a_of_type_Bkvu.d) {
        a(2);
      }
      for (;;)
      {
        this.b.setVisibility(8);
        break;
        if (this.jdField_a_of_type_Bkvu.e) {
          a(1);
        } else {
          a(0);
        }
      }
      label566:
      if (this.jdField_a_of_type_Bkvu.a())
      {
        this.b.setVisibility(0);
        this.b.setImageResource(2130845469);
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
  }
  
  public void b(bkvu parambkvu)
  {
    this.jdField_a_of_type_Bkvu = parambkvu;
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (i >= 0))
    {
      bkqk.a = bkqk.b;
      bkqk.b = i;
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(i);
    }
    if ((this.jdField_a_of_type_Bkvu != null) && ("call_material_id".equals(this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString)))
    {
      blen.a().E();
      return;
    }
    bler.a().g("none");
    bler.a().f("2");
    bler.a().c(0);
    Object localObject;
    if (i == 0)
    {
      bler.a().b(-1);
      localObject = blen.a();
      if (this.jdField_a_of_type_Bkvu != null) {
        break label199;
      }
      paramView = "";
      label111:
      ((blen)localObject).c(paramView);
      localObject = new StringBuilder().append("【Click】Item :");
      if (this.jdField_a_of_type_Bkvu != null) {
        break label210;
      }
      paramView = "";
      label139:
      blfg.b("AEBottomListAdapter", paramView);
      localObject = new StringBuilder().append("【Click】Usable :");
      if (this.jdField_a_of_type_Bkvu != null) {
        break label221;
      }
    }
    label199:
    label210:
    label221:
    for (paramView = "";; paramView = Boolean.valueOf(this.jdField_a_of_type_Bkvu.d))
    {
      blfg.b("AEBottomListAdapter", paramView);
      return;
      bler.a().b(i);
      break;
      paramView = this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString;
      break label111;
      paramView = this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString;
      break label139;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqq
 * JD-Core Version:    0.7.0.1
 */