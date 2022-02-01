import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aqdu
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  aqdq jdField_a_of_type_Aqdq;
  aqdr jdField_a_of_type_Aqdr;
  public View b;
  public TextView b;
  
  public aqdu(aqdq paramaqdq, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Aqdq = paramaqdq;
    Resources localResources = paramView.getContext().getResources();
    paramView.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131371822);
    bgfz.a(localView1, false);
    localView1.setOnClickListener(this);
    View localView2 = paramView.findViewById(2131371823);
    bgfz.a(localView2, false);
    localView2.setOnClickListener(this);
    if (aqdq.a(paramaqdq))
    {
      i = 8;
      localView1.setVisibility(i);
      if (!aqdq.a(paramaqdq)) {
        break label334;
      }
    }
    label334:
    for (int i = j;; i = 8)
    {
      localView2.setVisibility(i);
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371815);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(localResources.getString(2131690761));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371812);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371816));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371826));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(afur.a(3.0F, localResources));
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bgfz.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371824));
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bgfz.a(this.jdField_b_of_type_AndroidWidgetTextView, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371817));
      this.jdField_a_of_type_Aqdr = new aqdr(paramaqdq, this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_Aqdr);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aqds(paramaqdq, this));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new MusicDanceDrawable();
      ((aqcn)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a(paramView.getContext(), afur.a(15.0F, localResources), afur.a(9.5F, localResources));
      return;
      i = 0;
      break;
    }
  }
  
  public ColorNote a(int paramInt)
  {
    return (ColorNote)aqdq.a(this.jdField_a_of_type_Aqdq).get(paramInt);
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
      if (aqdq.a(this.jdField_a_of_type_Aqdq) != null)
      {
        aqdq.a(this.jdField_a_of_type_Aqdq).b();
        bcst.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdu
 * JD-Core Version:    0.7.0.1
 */