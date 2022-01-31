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

public class bkux
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public blab a;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public bkux(View paramView, AEBottomListScrollView paramAEBottomListScrollView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379823));
    this.d = ((ImageView)paramView.findViewById(2131379830));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131379836));
    this.b = ((ImageView)paramView.findViewById(2131379837));
    this.c = ((ImageView)paramView.findViewById(2131379832));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131379888));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString.equals("0")) {
      return (String)bkur.a().get(5);
    }
    if (this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
      return (String)bkur.a().get(6);
    }
    if (bkur.a()) {
      if (paramInt == 1) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      return (String)bkur.a().get(paramInt);
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
      if (this.jdField_a_of_type_Blab.jdField_a_of_type_Boolean)
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
  
  public void a(blab paramblab)
  {
    this.jdField_a_of_type_Blab = paramblab;
    if (this.jdField_a_of_type_Blab != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      if ((!"0".equals(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString)) && (!"call_material_id".equals(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString))) {
        break label206;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.b.setVisibility(8);
      this.d.setVisibility(8);
      if (!this.jdField_a_of_type_Blab.b()) {
        break label566;
      }
      this.b.setVisibility(0);
      this.b.setImageResource(this.jdField_a_of_type_Blab.a());
    }
    for (;;)
    {
      this.itemView.setOnClickListener(this);
      paramblab = a(getAdapterPosition());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131377450, paramblab);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131377419, Boolean.valueOf(false));
      xsm.a(this.jdField_a_of_type_AndroidWidgetImageView, paramblab, xsm.a(this.itemView.getContext(), 54.0F), xsm.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130850160), null);
      return;
      label206:
      if ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setImageResource(2130844187);
        break;
      }
      if (this.jdField_a_of_type_Blab.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setTag(2131377450, this.jdField_a_of_type_Blab.c);
        this.d.setTag(2131377419, Boolean.valueOf(false));
        xsm.a(this.d, this.jdField_a_of_type_Blab.c, xsm.a(this.itemView.getContext(), 54.0F), xsm.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130850160), null);
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setImageResource(2130845541);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.d.setVisibility(0);
      this.d.setTag(2131377450, this.jdField_a_of_type_Blab.c);
      this.d.setTag(2131377419, Boolean.valueOf(false));
      xsm.a(this.d, this.jdField_a_of_type_Blab.c, xsm.a(this.itemView.getContext(), 54.0F), xsm.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130850160), null);
      if (this.jdField_a_of_type_Blab.d) {
        a(2);
      }
      for (;;)
      {
        this.b.setVisibility(8);
        break;
        if (this.jdField_a_of_type_Blab.e) {
          a(1);
        } else {
          a(0);
        }
      }
      label566:
      if (this.jdField_a_of_type_Blab.a())
      {
        this.b.setVisibility(0);
        this.b.setImageResource(2130845541);
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
  }
  
  public void b(blab paramblab)
  {
    this.jdField_a_of_type_Blab = paramblab;
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (i >= 0))
    {
      bkur.a = bkur.b;
      bkur.b = i;
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(i);
    }
    if ((this.jdField_a_of_type_Blab != null) && ("call_material_id".equals(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString)))
    {
      bliu.a().E();
      return;
    }
    bliy.a().g("none");
    bliy.a().f("2");
    bliy.a().c(0);
    Object localObject;
    if (i == 0)
    {
      bliy.a().b(-1);
      localObject = bliu.a();
      if (this.jdField_a_of_type_Blab != null) {
        break label199;
      }
      paramView = "";
      label111:
      ((bliu)localObject).c(paramView);
      localObject = new StringBuilder().append("【Click】Item :");
      if (this.jdField_a_of_type_Blab != null) {
        break label210;
      }
      paramView = "";
      label139:
      bljn.b("AEBottomListAdapter", paramView);
      localObject = new StringBuilder().append("【Click】Usable :");
      if (this.jdField_a_of_type_Blab != null) {
        break label221;
      }
    }
    label199:
    label210:
    label221:
    for (paramView = "";; paramView = Boolean.valueOf(this.jdField_a_of_type_Blab.d))
    {
      bljn.b("AEBottomListAdapter", paramView);
      return;
      bliy.a().b(i);
      break;
      paramView = this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString;
      break label111;
      paramView = this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString;
      break label139;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkux
 * JD-Core Version:    0.7.0.1
 */