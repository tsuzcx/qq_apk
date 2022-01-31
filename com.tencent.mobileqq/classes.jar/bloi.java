import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.BaseApplication;

class bloi
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bloh jdField_a_of_type_Bloh;
  private bloj jdField_a_of_type_Bloj;
  private final int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  public bloi(@NonNull View paramView, @Nullable bloj parambloj, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368843));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366440));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368847));
    this.c = ((ImageView)paramView.findViewById(2131368846));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378893));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Bloj = parambloj;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(@NonNull bloh parambloh, int paramInt)
  {
    this.jdField_a_of_type_Bloh = parambloh;
    this.jdField_a_of_type_Int = paramInt;
    URLDrawable localURLDrawable;
    if (!TextUtils.isEmpty(parambloh.c()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_b_of_type_Int > 0)
      {
        localURLDrawable = bayu.a(parambloh.c(), this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        label59:
        if (!parambloh.jdField_a_of_type_Boolean) {
          break label222;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2131165222);
        if (parambloh.jdField_a_of_type_Int != 1) {
          break label202;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        label108:
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(BaseApplication.getContext().getResources().getColor(2131165224));
        label126:
        if (!TextUtils.isEmpty(bloh.a(parambloh))) {
          break label350;
        }
        parambloh = "";
        label139:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(parambloh);
        parambloh = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (paramInt != 0) {
          break label400;
        }
      }
    }
    label400:
    for (parambloh.leftMargin = bdoo.a(14.0F);; parambloh.leftMargin = 0)
    {
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(parambloh);
      return;
      localURLDrawable = bayu.a(parambloh.c());
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label59;
      label202:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.c.setVisibility(8);
      break label108;
      label222:
      if (parambloh.b)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2131165223);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(BaseApplication.getContext().getResources().getColor(2131165225));
        break label126;
      }
      if (parambloh.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2131167144);
        this.c.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        this.c.setVisibility(8);
      }
      label350:
      if (bloh.a(parambloh).length() > 5)
      {
        parambloh = bloh.a(parambloh).substring(0, 5) + "...";
        break label139;
      }
      parambloh = bloh.a(parambloh);
      break label139;
    }
  }
  
  public void onClick(View paramView)
  {
    bloh localbloh;
    int i;
    if ((paramView.getId() == 2131369683) && (this.jdField_a_of_type_Bloh != null) && (!this.jdField_a_of_type_Bloh.b) && (this.jdField_a_of_type_Bloj != null))
    {
      paramView = this.jdField_a_of_type_Bloj;
      localbloh = this.jdField_a_of_type_Bloh;
      i = getAdapterPosition();
      if (this.jdField_a_of_type_Bloh.jdField_a_of_type_Boolean) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      paramView.a(localbloh, i, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bloi
 * JD-Core Version:    0.7.0.1
 */