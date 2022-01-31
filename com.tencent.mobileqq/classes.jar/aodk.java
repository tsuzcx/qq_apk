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

public class aodk
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  aodg jdField_a_of_type_Aodg;
  aodh jdField_a_of_type_Aodh;
  MusicDanceDrawable jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable;
  public View b;
  public TextView b;
  
  public aodk(aodg paramaodg, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Aodg = paramaodg;
    Resources localResources = paramView.getContext().getResources();
    paramView.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131371258);
    bczz.a(localView1, false);
    localView1.setOnClickListener(this);
    View localView2 = paramView.findViewById(2131371259);
    bczz.a(localView2, false);
    localView2.setOnClickListener(this);
    if (aodg.a(paramaodg))
    {
      i = 8;
      localView1.setVisibility(i);
      if (!aodg.a(paramaodg)) {
        break label329;
      }
    }
    label329:
    for (int i = j;; i = 8)
    {
      localView2.setVisibility(i);
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371251);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(localResources.getString(2131690919));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131371248);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371252));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371262));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aepi.a(3.0F, localResources));
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bczz.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371260));
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bczz.a(this.jdField_b_of_type_AndroidWidgetTextView, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131371253));
      this.jdField_a_of_type_Aodh = new aodh(paramaodg, this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_Aodh);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aodi(paramaodg, this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable = new MusicDanceDrawable();
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(paramView.getContext(), aepi.a(15.0F, localResources), aepi.a(9.5F, localResources));
      return;
      i = 0;
      break;
    }
  }
  
  public ColorNote a(int paramInt)
  {
    return (ColorNote)aodg.a(this.jdField_a_of_type_Aodg).get(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (aodg.a(this.jdField_a_of_type_Aodg) == null);
    aodg.a(this.jdField_a_of_type_Aodg).a();
    azqs.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodk
 * JD-Core Version:    0.7.0.1
 */