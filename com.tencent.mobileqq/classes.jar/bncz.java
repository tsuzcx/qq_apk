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

public class bncz
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bnke a;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  public bncz(View paramView, AEBottomListScrollView paramAEBottomListScrollView, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381037));
    this.d = ((ImageView)paramView.findViewById(2131381044));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131381050);
    this.b = ((ImageView)paramView.findViewById(2131381051));
    this.c = ((ImageView)paramView.findViewById(2131381046));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131381101));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString.equals("0")) {
      return (String)bncv.a().get(5);
    }
    if (this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
      return (String)bncv.a().get(6);
    }
    if (bncv.b()) {
      if (paramInt == 1) {
        paramInt = 3;
      }
    }
    for (;;)
    {
      return (String)bncv.a().get(paramInt);
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
      if ((this.jdField_a_of_type_Bnke.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean) && (!"0".equals(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString)))
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
  
  public void a(bnke parambnke)
  {
    this.jdField_a_of_type_Bnke = parambnke;
    if (this.jdField_a_of_type_Bnke != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      if ((!"0".equals(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString)) && (!"call_material_id".equals(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString))) {
        break label273;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.b.setVisibility(8);
      this.d.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean) {
        break label262;
      }
      if (!"0".equals(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString)) {
        break label198;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!this.jdField_a_of_type_Bnke.b()) {
        break label641;
      }
      this.b.setVisibility(0);
      this.b.setImageResource(this.jdField_a_of_type_Bnke.a());
    }
    for (;;)
    {
      this.itemView.setOnClickListener(this);
      parambnke = a(getAdapterPosition());
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378495, parambnke);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(2131378460, Boolean.valueOf(false));
      if (!this.jdField_a_of_type_Boolean) {
        break label683;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(bncv.c);
      return;
      label198:
      this.d.setVisibility(0);
      UIUtils.setViewByURL(this.d, "https://downv6.qq.com/shadow_qqcamera/Android/image/material_more.png", UIUtils.dip2px(this.itemView.getContext(), bncv.a()), UIUtils.dip2px(this.itemView.getContext(), bncv.a()), this.itemView.getContext().getResources().getDrawable(2130850846), null);
      break;
      label262:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label273:
      if ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.b.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setImageResource(2130844540);
        break;
      }
      if (this.jdField_a_of_type_Bnke.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setTag(2131378495, this.jdField_a_of_type_Bnke.c);
        this.d.setTag(2131378460, Boolean.valueOf(false));
        UIUtils.setViewByURL(this.d, this.jdField_a_of_type_Bnke.c, UIUtils.dip2px(this.itemView.getContext(), bncv.a()), UIUtils.dip2px(this.itemView.getContext(), bncv.a()), this.itemView.getContext().getResources().getDrawable(2130844540), null);
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setImageResource(2130845942);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.d.setVisibility(0);
      this.d.setTag(2131378495, this.jdField_a_of_type_Bnke.c);
      this.d.setTag(2131378460, Boolean.valueOf(false));
      UIUtils.setViewByURL(this.d, this.jdField_a_of_type_Bnke.c, UIUtils.dip2px(this.itemView.getContext(), bncv.a()), UIUtils.dip2px(this.itemView.getContext(), bncv.a()), this.itemView.getContext().getResources().getDrawable(2130844540), null);
      if (this.jdField_a_of_type_Bnke.e) {
        a(2);
      }
      for (;;)
      {
        this.b.setVisibility(8);
        break;
        if (this.jdField_a_of_type_Bnke.f) {
          a(1);
        } else {
          a(0);
        }
      }
      label641:
      if (this.jdField_a_of_type_Bnke.a())
      {
        this.b.setVisibility(0);
        this.b.setImageResource(2130845942);
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
    label683:
    UIUtils.setViewByURL(this.jdField_a_of_type_AndroidWidgetImageView, parambnke, UIUtils.dip2px(this.itemView.getContext(), bncv.b()), UIUtils.dip2px(this.itemView.getContext(), bncv.b()), this.itemView.getContext().getResources().getDrawable(2130850846), null);
  }
  
  public void b(bnke parambnke)
  {
    this.jdField_a_of_type_Bnke = parambnke;
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView != null) && (i >= 0))
    {
      bncv.a = bncv.b;
      bncv.b = i;
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(i);
      if ((this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getAdapter() instanceof bncv)) {
        ((bncv)this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getAdapter()).a(true);
      }
    }
    if ((this.jdField_a_of_type_Bnke != null) && ("call_material_id".equals(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString)))
    {
      bnqm.a().X();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    bnqq.a().g("none");
    bnqq.a().f("2");
    bnqq.a().d(0);
    label131:
    Object localObject2;
    if (i == 0)
    {
      bnqq.a().c(-1);
      localObject2 = bnqm.a();
      if (this.jdField_a_of_type_Bnke != null) {
        break label242;
      }
      localObject1 = "";
      label146:
      ((bnqm)localObject2).d((String)localObject1);
      localObject2 = new StringBuilder().append("【Click】Item :");
      if (this.jdField_a_of_type_Bnke != null) {
        break label253;
      }
      localObject1 = "";
      label176:
      bnrh.b("AEBottomListAdapter", (String)localObject1);
      localObject2 = new StringBuilder().append("【Click】Usable :");
      if (this.jdField_a_of_type_Bnke != null) {
        break label264;
      }
    }
    label264:
    for (Object localObject1 = "";; localObject1 = Boolean.valueOf(this.jdField_a_of_type_Bnke.e))
    {
      bnrh.b("AEBottomListAdapter", localObject1);
      break;
      bnqq.a().c(i);
      break label131;
      label242:
      localObject1 = this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString;
      break label146;
      label253:
      localObject1 = this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString;
      break label176;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncz
 * JD-Core Version:    0.7.0.1
 */