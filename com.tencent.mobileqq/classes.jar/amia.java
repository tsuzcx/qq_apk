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

public class amia
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  amhw jdField_a_of_type_Amhw;
  amhx jdField_a_of_type_Amhx;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  MusicDanceDrawable jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable;
  public View b;
  public TextView b;
  
  public amia(amhw paramamhw, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Amhw = paramamhw;
    Resources localResources = paramView.getContext().getResources();
    paramView.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131370928);
    baww.a(localView1, false);
    localView1.setOnClickListener(this);
    View localView2 = paramView.findViewById(2131370929);
    baww.a(localView2, false);
    localView2.setOnClickListener(this);
    if (amhw.a(paramamhw))
    {
      i = 8;
      localView1.setVisibility(i);
      if (!amhw.a(paramamhw)) {
        break label329;
      }
    }
    label329:
    for (int i = j;; i = 8)
    {
      localView2.setVisibility(i);
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370921);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(localResources.getString(2131690866));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370918);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370922));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370932));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(actj.a(3.0F, localResources));
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      baww.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370930));
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      baww.a(this.jdField_b_of_type_AndroidWidgetTextView, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370923));
      this.jdField_a_of_type_Amhx = new amhx(paramamhw, this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_Amhx);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new amhy(paramamhw, this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable = new MusicDanceDrawable();
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(paramView.getContext(), actj.a(15.0F, localResources), actj.a(9.5F, localResources));
      return;
      i = 0;
      break;
    }
  }
  
  public ColorNote a(int paramInt)
  {
    return (ColorNote)amhw.a(this.jdField_a_of_type_Amhw).get(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (amhw.a(this.jdField_a_of_type_Amhw) == null);
    amhw.a(this.jdField_a_of_type_Amhw).a();
    axqy.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amia
 * JD-Core Version:    0.7.0.1
 */