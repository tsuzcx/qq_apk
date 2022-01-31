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

public class amib
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  amhx jdField_a_of_type_Amhx;
  amhy jdField_a_of_type_Amhy;
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  MusicDanceDrawable jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable;
  public View b;
  public TextView b;
  
  public amib(amhx paramamhx, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_Amhx = paramamhx;
    Resources localResources = paramView.getContext().getResources();
    paramView.setOnClickListener(this);
    View localView1 = paramView.findViewById(2131370928);
    bawi.a(localView1, false);
    localView1.setOnClickListener(this);
    View localView2 = paramView.findViewById(2131370929);
    bawi.a(localView2, false);
    localView2.setOnClickListener(this);
    if (amhx.a(paramamhx))
    {
      i = 8;
      localView1.setVisibility(i);
      if (!amhx.a(paramamhx)) {
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
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(actn.a(3.0F, localResources));
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bawi.a(this.jdField_a_of_type_AndroidWidgetTextView, true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370930));
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      bawi.a(this.jdField_b_of_type_AndroidWidgetTextView, true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370923));
      this.jdField_a_of_type_Amhy = new amhy(paramamhx, this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_Amhy);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new amhz(paramamhx, this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable = new MusicDanceDrawable();
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(paramView.getContext(), actn.a(15.0F, localResources), actn.a(9.5F, localResources));
      return;
      i = 0;
      break;
    }
  }
  
  public ColorNote a(int paramInt)
  {
    return (ColorNote)amhx.a(this.jdField_a_of_type_Amhx).get(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (amhx.a(this.jdField_a_of_type_Amhx) == null);
    amhx.a(this.jdField_a_of_type_Amhx).a();
    axqw.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amib
 * JD-Core Version:    0.7.0.1
 */