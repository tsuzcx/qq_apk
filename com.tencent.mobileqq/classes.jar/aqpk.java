import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aqpk
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  aqpg jdField_a_of_type_Aqpg;
  aqph jdField_a_of_type_Aqph;
  public View b;
  public TextView b;
  
  public aqpk(aqpg paramaqpg, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Aqpg = paramaqpg;
    Resources localResources = paramView.getContext().getResources();
    paramView.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131372086);
    bgyd.a(localView1, false);
    localView1.setOnClickListener(this);
    View localView2 = paramView.findViewById(2131372087);
    bgyd.a(localView2, false);
    localView2.setOnClickListener(this);
    if (aqpg.a(paramaqpg))
    {
      i = 8;
      localView1.setVisibility(i);
      if (!aqpg.a(paramaqpg)) {
        break label334;
      }
    }
    label334:
    for (int i = j;; i = 8)
    {
      localView2.setVisibility(i);
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372079);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(localResources.getString(2131690886));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372076);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372080));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372090));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(3.0F, localResources));
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bgyd.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372088));
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bgyd.a(this.jdField_b_of_type_AndroidWidgetTextView, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131372081));
      this.jdField_a_of_type_Aqph = new aqph(paramaqpg, this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_Aqph);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aqpi(paramaqpg, this));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new MusicDanceDrawable();
      ((aqod)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a(paramView.getContext(), AIOUtils.dp2px(15.0F, localResources), AIOUtils.dp2px(9.5F, localResources));
      return;
      i = 0;
      break;
    }
  }
  
  public ColorNote a(int paramInt)
  {
    return (ColorNote)aqpg.a(this.jdField_a_of_type_Aqpg).get(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aqpg.a(this.jdField_a_of_type_Aqpg) != null)
      {
        aqpg.a(this.jdField_a_of_type_Aqpg).b();
        bdla.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpk
 * JD-Core Version:    0.7.0.1
 */