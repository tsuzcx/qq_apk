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

public class aqsx
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  aqst jdField_a_of_type_Aqst;
  aqsu jdField_a_of_type_Aqsu;
  public View b;
  public TextView b;
  
  public aqsx(aqst paramaqst, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Aqst = paramaqst;
    Resources localResources = paramView.getContext().getResources();
    paramView.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131371929);
    bhga.a(localView1, false);
    localView1.setOnClickListener(this);
    View localView2 = paramView.findViewById(2131371930);
    bhga.a(localView2, false);
    localView2.setOnClickListener(this);
    if (aqst.a(paramaqst))
    {
      i = 8;
      localView1.setVisibility(i);
      if (!aqst.a(paramaqst)) {
        break label334;
      }
    }
    label334:
    for (int i = j;; i = 8)
    {
      localView2.setVisibility(i);
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371922);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(localResources.getString(2131690761));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371919);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371923));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371933));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(agej.a(3.0F, localResources));
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bhga.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371931));
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bhga.a(this.jdField_b_of_type_AndroidWidgetTextView, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371924));
      this.jdField_a_of_type_Aqsu = new aqsu(paramaqst, this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_Aqsu);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aqsv(paramaqst, this));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new MusicDanceDrawable();
      ((aqrq)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a(paramView.getContext(), agej.a(15.0F, localResources), agej.a(9.5F, localResources));
      return;
      i = 0;
      break;
    }
  }
  
  public ColorNote a(int paramInt)
  {
    return (ColorNote)aqst.a(this.jdField_a_of_type_Aqst).get(paramInt);
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
      if (aqst.a(this.jdField_a_of_type_Aqst) != null)
      {
        aqst.a(this.jdField_a_of_type_Aqst).b();
        bdll.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsx
 * JD-Core Version:    0.7.0.1
 */