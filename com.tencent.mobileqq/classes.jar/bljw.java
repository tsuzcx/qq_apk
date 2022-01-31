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

class bljw
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bljv jdField_a_of_type_Bljv;
  private bljx jdField_a_of_type_Bljx;
  private final int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  public bljw(@NonNull View paramView, @Nullable bljx parambljx, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368828));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366435));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368832));
    this.c = ((ImageView)paramView.findViewById(2131368831));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378836));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Bljx = parambljx;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(@NonNull bljv parambljv, int paramInt)
  {
    this.jdField_a_of_type_Bljv = parambljv;
    this.jdField_a_of_type_Int = paramInt;
    URLDrawable localURLDrawable;
    if (!TextUtils.isEmpty(parambljv.c()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_b_of_type_Int > 0)
      {
        localURLDrawable = baul.a(parambljv.c(), this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        label59:
        if (!parambljv.jdField_a_of_type_Boolean) {
          break label222;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2131165222);
        if (parambljv.jdField_a_of_type_Int != 1) {
          break label202;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        label108:
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(BaseApplication.getContext().getResources().getColor(2131165224));
        label126:
        if (!TextUtils.isEmpty(bljv.a(parambljv))) {
          break label350;
        }
        parambljv = "";
        label139:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(parambljv);
        parambljv = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (paramInt != 0) {
          break label400;
        }
      }
    }
    label400:
    for (parambljv.leftMargin = bdkf.a(14.0F);; parambljv.leftMargin = 0)
    {
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(parambljv);
      return;
      localURLDrawable = baul.a(parambljv.c());
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label59;
      label202:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.c.setVisibility(8);
      break label108;
      label222:
      if (parambljv.b)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2131165223);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(BaseApplication.getContext().getResources().getColor(2131165225));
        break label126;
      }
      if (parambljv.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2131167142);
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
      if (bljv.a(parambljv).length() > 5)
      {
        parambljv = bljv.a(parambljv).substring(0, 5) + "...";
        break label139;
      }
      parambljv = bljv.a(parambljv);
      break label139;
    }
  }
  
  public void onClick(View paramView)
  {
    bljv localbljv;
    int i;
    if ((paramView.getId() == 2131369664) && (this.jdField_a_of_type_Bljv != null) && (!this.jdField_a_of_type_Bljv.b) && (this.jdField_a_of_type_Bljx != null))
    {
      paramView = this.jdField_a_of_type_Bljx;
      localbljv = this.jdField_a_of_type_Bljv;
      i = getAdapterPosition();
      if (this.jdField_a_of_type_Bljv.jdField_a_of_type_Boolean) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      paramView.a(localbljv, i, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljw
 * JD-Core Version:    0.7.0.1
 */