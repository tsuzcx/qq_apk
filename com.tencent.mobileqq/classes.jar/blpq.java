import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import java.util.List;

public class blpq
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public blvb a;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public blpq(View paramView, AEBottomListScrollView paramAEBottomListScrollView, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380685));
    this.d = ((ImageView)paramView.findViewById(2131380692));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380698);
    this.b = ((ImageView)paramView.findViewById(2131380699));
    this.c = ((ImageView)paramView.findViewById(2131380694));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131380750));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString.equals("0")) {
      return (String)blpm.a().get(5);
    }
    if (this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
      return (String)blpm.a().get(6);
    }
    if (blpm.a()) {
      if (paramInt == 1) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      return (String)blpm.a().get(paramInt);
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
          } while (this.jdField_a_of_type_AndroidViewView == null);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return;
        } while (this.jdField_a_of_type_AndroidViewView == null);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 3: 
      if ((this.c != null) && (!this.jdField_a_of_type_Boolean)) {
        this.c.setVisibility(0);
      }
      if ((this.jdField_a_of_type_Blvb.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
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
  
  public void a(blvb paramblvb)
  {
    this.jdField_a_of_type_Blvb = paramblvb;
    if (this.jdField_a_of_type_Blvb != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      if ((!"0".equals(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString)) && (!"call_material_id".equals(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString))) {
        break label273;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.b.setVisibility(8);
      this.d.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean) {
        break label262;
      }
      if (!"0".equals(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString)) {
        break label198;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!this.jdField_a_of_type_Blvb.b()) {
        break label641;
      }
      this.b.setVisibility(0);
      this.b.setImageResource(this.jdField_a_of_type_Blvb.a());
    }
    for (;;)
    {
      this.itemView.setOnClickListener(this);
      paramblvb = a(getAdapterPosition());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378207, paramblvb);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378172, Boolean.valueOf(false));
      if (!this.jdField_a_of_type_Boolean) {
        break label683;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(blpm.c);
      return;
      label198:
      this.d.setVisibility(0);
      UIUtils.setViewByURL(this.d, "https://downv6.qq.com/shadow_qqcamera/Android/image/material_more.png", UIUtils.dip2px(this.itemView.getContext(), blpm.a()), UIUtils.dip2px(this.itemView.getContext(), blpm.a()), this.itemView.getContext().getResources().getDrawable(2130850704), null);
      break;
      label262:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label273:
      if ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setImageResource(2130844473);
        break;
      }
      if (this.jdField_a_of_type_Blvb.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setTag(2131378207, this.jdField_a_of_type_Blvb.c);
        this.d.setTag(2131378172, Boolean.valueOf(false));
        UIUtils.setViewByURL(this.d, this.jdField_a_of_type_Blvb.c, UIUtils.dip2px(this.itemView.getContext(), blpm.a()), UIUtils.dip2px(this.itemView.getContext(), blpm.a()), this.itemView.getContext().getResources().getDrawable(2130844473), null);
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setImageResource(2130845854);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.d.setVisibility(0);
      this.d.setTag(2131378207, this.jdField_a_of_type_Blvb.c);
      this.d.setTag(2131378172, Boolean.valueOf(false));
      UIUtils.setViewByURL(this.d, this.jdField_a_of_type_Blvb.c, UIUtils.dip2px(this.itemView.getContext(), blpm.a()), UIUtils.dip2px(this.itemView.getContext(), blpm.a()), this.itemView.getContext().getResources().getDrawable(2130844473), null);
      if (this.jdField_a_of_type_Blvb.e) {
        a(2);
      }
      for (;;)
      {
        this.b.setVisibility(8);
        break;
        if (this.jdField_a_of_type_Blvb.f) {
          a(1);
        } else {
          a(0);
        }
      }
      label641:
      if (this.jdField_a_of_type_Blvb.a())
      {
        this.b.setVisibility(0);
        this.b.setImageResource(2130845854);
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
    label683:
    UIUtils.setViewByURL(this.jdField_a_of_type_AndroidWidgetImageView, paramblvb, UIUtils.dip2px(this.itemView.getContext(), blpm.b()), UIUtils.dip2px(this.itemView.getContext(), blpm.b()), this.itemView.getContext().getResources().getDrawable(2130850704), null);
  }
  
  public void b(blvb paramblvb)
  {
    this.jdField_a_of_type_Blvb = paramblvb;
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (i >= 0))
    {
      blpm.a = blpm.b;
      blpm.b = i;
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(i);
    }
    if ((this.jdField_a_of_type_Blvb != null) && ("call_material_id".equals(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString)))
    {
      bmbc.a().X();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    bmbg.a().g("none");
    bmbg.a().f("2");
    bmbg.a().d(0);
    label104:
    Object localObject2;
    if (i == 0)
    {
      bmbg.a().c(-1);
      localObject2 = bmbc.a();
      if (this.jdField_a_of_type_Blvb != null) {
        break label214;
      }
      localObject1 = "";
      label119:
      ((bmbc)localObject2).d((String)localObject1);
      localObject2 = new StringBuilder().append("【Click】Item :");
      if (this.jdField_a_of_type_Blvb != null) {
        break label225;
      }
      localObject1 = "";
      label149:
      bmbx.b("AEBottomListAdapter", (String)localObject1);
      localObject2 = new StringBuilder().append("【Click】Usable :");
      if (this.jdField_a_of_type_Blvb != null) {
        break label236;
      }
    }
    label214:
    label225:
    label236:
    for (Object localObject1 = "";; localObject1 = Boolean.valueOf(this.jdField_a_of_type_Blvb.e))
    {
      bmbx.b("AEBottomListAdapter", localObject1);
      break;
      bmbg.a().c(i);
      break label104;
      localObject1 = this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString;
      break label119;
      localObject1 = this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString;
      break label149;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpq
 * JD-Core Version:    0.7.0.1
 */