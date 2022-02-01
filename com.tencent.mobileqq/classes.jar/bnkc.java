import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import java.util.List;

public class bnkc
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bnpf a;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public bnkc(View paramView, AEBottomListScrollView paramAEBottomListScrollView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380782));
    this.d = ((ImageView)paramView.findViewById(2131380789));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131380795));
    this.b = ((ImageView)paramView.findViewById(2131380796));
    this.c = ((ImageView)paramView.findViewById(2131380791));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131380846));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString.equals("0")) {
      return (String)bnjw.a().get(5);
    }
    if (this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
      return (String)bnjw.a().get(6);
    }
    if (bnjw.a()) {
      if (paramInt == 1) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      return (String)bnjw.a().get(paramInt);
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
      if (this.jdField_a_of_type_Bnpf.jdField_a_of_type_Boolean)
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
  
  public void a(bnpf parambnpf)
  {
    this.jdField_a_of_type_Bnpf = parambnpf;
    if (this.jdField_a_of_type_Bnpf != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      if ((!"0".equals(this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString)) && (!"call_material_id".equals(this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString))) {
        break label206;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.b.setVisibility(8);
      this.d.setVisibility(8);
      if (!this.jdField_a_of_type_Bnpf.b()) {
        break label566;
      }
      this.b.setVisibility(0);
      this.b.setImageResource(this.jdField_a_of_type_Bnpf.a());
    }
    for (;;)
    {
      this.itemView.setOnClickListener(this);
      parambnpf = a(getAdapterPosition());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378283, parambnpf);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378248, Boolean.valueOf(false));
      zlx.a(this.jdField_a_of_type_AndroidWidgetImageView, parambnpf, zlx.a(this.itemView.getContext(), 54.0F), zlx.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130850756), null);
      return;
      label206:
      if ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setImageResource(2130844583);
        break;
      }
      if (this.jdField_a_of_type_Bnpf.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setTag(2131378283, this.jdField_a_of_type_Bnpf.c);
        this.d.setTag(2131378248, Boolean.valueOf(false));
        zlx.a(this.d, this.jdField_a_of_type_Bnpf.c, zlx.a(this.itemView.getContext(), 54.0F), zlx.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130850756), null);
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setImageResource(2130845939);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.d.setVisibility(0);
      this.d.setTag(2131378283, this.jdField_a_of_type_Bnpf.c);
      this.d.setTag(2131378248, Boolean.valueOf(false));
      zlx.a(this.d, this.jdField_a_of_type_Bnpf.c, zlx.a(this.itemView.getContext(), 54.0F), zlx.a(this.itemView.getContext(), 54.0F), this.itemView.getContext().getResources().getDrawable(2130850756), null);
      if (this.jdField_a_of_type_Bnpf.e) {
        a(2);
      }
      for (;;)
      {
        this.b.setVisibility(8);
        break;
        if (this.jdField_a_of_type_Bnpf.f) {
          a(1);
        } else {
          a(0);
        }
      }
      label566:
      if (this.jdField_a_of_type_Bnpf.a())
      {
        this.b.setVisibility(0);
        this.b.setImageResource(2130845939);
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
  }
  
  public void b(bnpf parambnpf)
  {
    this.jdField_a_of_type_Bnpf = parambnpf;
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (i >= 0))
    {
      bnjw.a = bnjw.b;
      bnjw.b = i;
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(i);
    }
    if ((this.jdField_a_of_type_Bnpf != null) && ("call_material_id".equals(this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString)))
    {
      bnyh.a().R();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    bnyl.a().g("none");
    bnyl.a().f("2");
    bnyl.a().c(0);
    label104:
    Object localObject2;
    if (i == 0)
    {
      bnyl.a().b(-1);
      localObject2 = bnyh.a();
      if (this.jdField_a_of_type_Bnpf != null) {
        break label214;
      }
      localObject1 = "";
      label119:
      ((bnyh)localObject2).d((String)localObject1);
      localObject2 = new StringBuilder().append("【Click】Item :");
      if (this.jdField_a_of_type_Bnpf != null) {
        break label225;
      }
      localObject1 = "";
      label149:
      bnzb.b("AEBottomListAdapter", (String)localObject1);
      localObject2 = new StringBuilder().append("【Click】Usable :");
      if (this.jdField_a_of_type_Bnpf != null) {
        break label236;
      }
    }
    label214:
    label225:
    label236:
    for (Object localObject1 = "";; localObject1 = Boolean.valueOf(this.jdField_a_of_type_Bnpf.e))
    {
      bnzb.b("AEBottomListAdapter", localObject1);
      break;
      bnyl.a().b(i);
      break label104;
      localObject1 = this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString;
      break label119;
      localObject1 = this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString;
      break label149;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkc
 * JD-Core Version:    0.7.0.1
 */