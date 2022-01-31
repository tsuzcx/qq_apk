import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

public class anzb
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  anyx jdField_a_of_type_Anyx;
  anyy jdField_a_of_type_Anyy;
  MusicDanceDrawable jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable;
  public View b;
  public TextView b;
  
  public anzb(anyx paramanyx, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Anyx = paramanyx;
    Resources localResources = paramView.getContext().getResources();
    paramView.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131371239);
    bcvq.a(localView1, false);
    localView1.setOnClickListener(this);
    View localView2 = paramView.findViewById(2131371240);
    bcvq.a(localView2, false);
    localView2.setOnClickListener(this);
    if (anyx.a(paramanyx))
    {
      i = 8;
      localView1.setVisibility(i);
      if (!anyx.a(paramanyx)) {
        break label329;
      }
    }
    label329:
    for (int i = j;; i = 8)
    {
      localView2.setVisibility(i);
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371232);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(localResources.getString(2131690918));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371229);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371233));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371243));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aekt.a(3.0F, localResources));
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bcvq.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371241));
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bcvq.a(this.jdField_b_of_type_AndroidWidgetTextView, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371234));
      this.jdField_a_of_type_Anyy = new anyy(paramanyx, this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_Anyy);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new anyz(paramanyx, this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable = new MusicDanceDrawable();
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(paramView.getContext(), aekt.a(15.0F, localResources), aekt.a(9.5F, localResources));
      return;
      i = 0;
      break;
    }
  }
  
  public ColorNote a(int paramInt)
  {
    return (ColorNote)anyx.a(this.jdField_a_of_type_Anyx).get(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (anyx.a(this.jdField_a_of_type_Anyx) == null);
    anyx.a(this.jdField_a_of_type_Anyx).a();
    azmj.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzb
 * JD-Core Version:    0.7.0.1
 */