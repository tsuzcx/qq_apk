import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import java.util.List;

public class bolk
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public boqu a;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public bolk(View paramView, AEBottomListScrollView paramAEBottomListScrollView, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380959));
    this.d = ((ImageView)paramView.findViewById(2131380966));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380972);
    this.b = ((ImageView)paramView.findViewById(2131380973));
    this.c = ((ImageView)paramView.findViewById(2131380968));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131381024));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString.equals("0")) {
      return (String)bolg.a().get(5);
    }
    if (this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
      return (String)bolg.a().get(6);
    }
    if (bolg.a()) {
      if (paramInt == 1) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      return (String)bolg.a().get(paramInt);
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
      if (this.jdField_a_of_type_Boqu.jdField_a_of_type_Boolean)
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
  
  public void a(boqu paramboqu)
  {
    this.jdField_a_of_type_Boqu = paramboqu;
    if (this.jdField_a_of_type_Boqu != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      if ((!"0".equals(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString)) && (!"call_material_id".equals(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString))) {
        break label273;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.b.setVisibility(8);
      this.d.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean) {
        break label262;
      }
      if (!"0".equals(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString)) {
        break label198;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!this.jdField_a_of_type_Boqu.b()) {
        break label641;
      }
      this.b.setVisibility(0);
      this.b.setImageResource(this.jdField_a_of_type_Boqu.a());
    }
    for (;;)
    {
      this.itemView.setOnClickListener(this);
      paramboqu = a(getAdapterPosition());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378440, paramboqu);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378405, Boolean.valueOf(false));
      if (!this.jdField_a_of_type_Boolean) {
        break label683;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(bolg.c);
      return;
      label198:
      this.d.setVisibility(0);
      zps.a(this.d, "https://downv6.qq.com/shadow_qqcamera/Android/image/material_more.png", zps.a(this.itemView.getContext(), bolg.a()), zps.a(this.itemView.getContext(), bolg.a()), this.itemView.getContext().getResources().getDrawable(2130850775), null);
      break;
      label262:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label273:
      if ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setImageResource(2130844597);
        break;
      }
      if (this.jdField_a_of_type_Boqu.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setTag(2131378440, this.jdField_a_of_type_Boqu.c);
        this.d.setTag(2131378405, Boolean.valueOf(false));
        zps.a(this.d, this.jdField_a_of_type_Boqu.c, zps.a(this.itemView.getContext(), bolg.a()), zps.a(this.itemView.getContext(), bolg.a()), this.itemView.getContext().getResources().getDrawable(2130844597), null);
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setImageResource(2130845954);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.d.setVisibility(0);
      this.d.setTag(2131378440, this.jdField_a_of_type_Boqu.c);
      this.d.setTag(2131378405, Boolean.valueOf(false));
      zps.a(this.d, this.jdField_a_of_type_Boqu.c, zps.a(this.itemView.getContext(), bolg.a()), zps.a(this.itemView.getContext(), bolg.a()), this.itemView.getContext().getResources().getDrawable(2130844597), null);
      if (this.jdField_a_of_type_Boqu.e) {
        a(2);
      }
      for (;;)
      {
        this.b.setVisibility(8);
        break;
        if (this.jdField_a_of_type_Boqu.f) {
          a(1);
        } else {
          a(0);
        }
      }
      label641:
      if (this.jdField_a_of_type_Boqu.a())
      {
        this.b.setVisibility(0);
        this.b.setImageResource(2130845954);
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
    label683:
    zps.a(this.jdField_a_of_type_AndroidWidgetImageView, paramboqu, zps.a(this.itemView.getContext(), bolg.b()), zps.a(this.itemView.getContext(), bolg.b()), this.itemView.getContext().getResources().getDrawable(2130850775), null);
  }
  
  public void b(boqu paramboqu)
  {
    this.jdField_a_of_type_Boqu = paramboqu;
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (i >= 0))
    {
      bolg.a = bolg.b;
      bolg.b = i;
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(i);
    }
    if ((this.jdField_a_of_type_Boqu != null) && ("call_material_id".equals(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString)))
    {
      bozr.a().T();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    bozv.a().g("none");
    bozv.a().f("2");
    bozv.a().d(0);
    label104:
    Object localObject2;
    if (i == 0)
    {
      bozv.a().c(-1);
      localObject2 = bozr.a();
      if (this.jdField_a_of_type_Boqu != null) {
        break label214;
      }
      localObject1 = "";
      label119:
      ((bozr)localObject2).d((String)localObject1);
      localObject2 = new StringBuilder().append("【Click】Item :");
      if (this.jdField_a_of_type_Boqu != null) {
        break label225;
      }
      localObject1 = "";
      label149:
      bpam.b("AEBottomListAdapter", (String)localObject1);
      localObject2 = new StringBuilder().append("【Click】Usable :");
      if (this.jdField_a_of_type_Boqu != null) {
        break label236;
      }
    }
    label214:
    label225:
    label236:
    for (Object localObject1 = "";; localObject1 = Boolean.valueOf(this.jdField_a_of_type_Boqu.e))
    {
      bpam.b("AEBottomListAdapter", localObject1);
      break;
      bozv.a().c(i);
      break label104;
      localObject1 = this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString;
      break label119;
      localObject1 = this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString;
      break label149;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bolk
 * JD-Core Version:    0.7.0.1
 */