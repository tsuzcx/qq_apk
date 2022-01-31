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

public class bili
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public biqn a;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public bili(View paramView, AEBottomListScrollView paramAEBottomListScrollView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379081));
    this.d = ((ImageView)paramView.findViewById(2131379088));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131379094));
    this.b = ((ImageView)paramView.findViewById(2131379095));
    this.c = ((ImageView)paramView.findViewById(2131379090));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131379132));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString.equals("0")) {
      return (String)bile.a().get(5);
    }
    if (this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
      return (String)bile.a().get(6);
    }
    if (bile.a()) {
      if (paramInt == 1) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      return (String)bile.a().get(paramInt);
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
      if (this.jdField_a_of_type_Biqn.jdField_a_of_type_Boolean)
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
  
  public void a(biqn parambiqn)
  {
    this.jdField_a_of_type_Biqn = parambiqn;
    if (this.jdField_a_of_type_Biqn != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      if ((!"0".equals(this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString)) && (!"call_material_id".equals(this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString))) {
        break label206;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.b.setVisibility(8);
      this.d.setVisibility(8);
      if (!this.jdField_a_of_type_Biqn.b()) {
        break label566;
      }
      this.b.setVisibility(0);
      this.b.setImageResource(this.jdField_a_of_type_Biqn.a());
    }
    for (;;)
    {
      this.itemView.setOnClickListener(this);
      parambiqn = a(getAdapterPosition());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131376880, parambiqn);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131376849, Boolean.valueOf(false));
      vzo.a(this.jdField_a_of_type_AndroidWidgetImageView, parambiqn, vzo.a(this.itemView.getContext(), 54.0F), vzo.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130849644), null);
      return;
      label206:
      if ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setImageResource(2130843771);
        break;
      }
      if (this.jdField_a_of_type_Biqn.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setTag(2131376880, this.jdField_a_of_type_Biqn.c);
        this.d.setTag(2131376849, Boolean.valueOf(false));
        vzo.a(this.d, this.jdField_a_of_type_Biqn.c, vzo.a(this.itemView.getContext(), 54.0F), vzo.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130849644), null);
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setImageResource(2130845103);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.d.setVisibility(0);
      this.d.setTag(2131376880, this.jdField_a_of_type_Biqn.c);
      this.d.setTag(2131376849, Boolean.valueOf(false));
      vzo.a(this.d, this.jdField_a_of_type_Biqn.c, vzo.a(this.itemView.getContext(), 54.0F), vzo.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130849644), null);
      if (this.jdField_a_of_type_Biqn.d) {
        a(2);
      }
      for (;;)
      {
        this.b.setVisibility(8);
        break;
        if (this.jdField_a_of_type_Biqn.e) {
          a(1);
        } else {
          a(0);
        }
      }
      label566:
      if (this.jdField_a_of_type_Biqn.a())
      {
        this.b.setVisibility(0);
        this.b.setImageResource(2130845103);
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
  }
  
  public void b(biqn parambiqn)
  {
    this.jdField_a_of_type_Biqn = parambiqn;
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (i >= 0)) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(i);
    }
    if ((this.jdField_a_of_type_Biqn != null) && ("call_material_id".equals(this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString)))
    {
      bizc.a().y();
      return;
    }
    bizg.a().g("none");
    bizg.a().f("2");
    bizg.a().c(0);
    Object localObject;
    if (i == 0)
    {
      bizg.a().b(-1);
      localObject = bizc.a();
      if (this.jdField_a_of_type_Biqn != null) {
        break label189;
      }
      paramView = "";
      label101:
      ((bizc)localObject).b(paramView);
      localObject = new StringBuilder().append("【Click】Item :");
      if (this.jdField_a_of_type_Biqn != null) {
        break label200;
      }
      paramView = "";
      label129:
      bizq.b("AEBottomListAdapter", paramView);
      localObject = new StringBuilder().append("【Click】Usable :");
      if (this.jdField_a_of_type_Biqn != null) {
        break label211;
      }
    }
    label189:
    label200:
    label211:
    for (paramView = "";; paramView = Boolean.valueOf(this.jdField_a_of_type_Biqn.d))
    {
      bizq.b("AEBottomListAdapter", paramView);
      return;
      bizg.a().b(i);
      break;
      paramView = this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString;
      break label101;
      paramView = this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString;
      break label129;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bili
 * JD-Core Version:    0.7.0.1
 */