import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpit
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837741);
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bpis jdField_a_of_type_Bpis;
  private bpiu jdField_a_of_type_Bpiu;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private final int jdField_b_of_type_Int;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  public bpit(@NonNull View paramView, @Nullable bpiu parambpiu, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131376097));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369286));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366749));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369290));
    this.c = ((ImageView)paramView.findViewById(2131369291));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379955));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)paramView.findViewById(2131365476));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, paramView.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_Bpiu = parambpiu;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    }
  }
  
  public void a(@NonNull bpis parambpis, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bpis = parambpis;
    this.jdField_a_of_type_Int = paramInt1;
    URLDrawable localURLDrawable;
    if ((parambpis.jdField_b_of_type_Int == 2) && (!TextUtils.isEmpty(parambpis.c())))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_b_of_type_Int > 0)
      {
        localURLDrawable = beyq.a(parambpis.c(), this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        label75:
        if (!parambpis.jdField_a_of_type_Boolean) {
          break label336;
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2131165238);
        if (parambpis.jdField_a_of_type_Int != 1) {
          break label252;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        label133:
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        if (parambpis.jdField_b_of_type_Int != 1) {
          break label545;
        }
        parambpis = this.jdField_a_of_type_AndroidWidgetTextView.getContext().getString(2131689713);
        label178:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(parambpis);
        parambpis = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (paramInt1 != 0) {
          break label611;
        }
        parambpis.leftMargin = bhtq.a(5.0F);
        parambpis.rightMargin = (-bhtq.a(10.0F));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(parambpis);
      return;
      localURLDrawable = beyq.a(parambpis.c());
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label75;
      label252:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(bpbi.b))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, bpbi.b, true);
        break label133;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, "https://downv6.qq.com/shadow_qqcamera/Android/lottie/MusicWave_8e84b13bfc72dd3c86c70617db423aef.zip", bpbi.a, true);
      break label133;
      label336:
      if (parambpis.jdField_b_of_type_Int == 0)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837741);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(null, 0);
        break;
        if (parambpis.jdField_b_of_type_Int != 1) {
          break label470;
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837741);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837833);
        this.c.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      label470:
      if (parambpis.jdField_a_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2131167252);
        this.c.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        break;
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        this.c.setVisibility(8);
      }
      label545:
      if (TextUtils.isEmpty(bpis.a(parambpis)))
      {
        parambpis = "";
        break label178;
      }
      if (bpis.a(parambpis).length() > 5)
      {
        parambpis = bpis.a(parambpis).substring(0, 5) + "...";
        break label178;
      }
      parambpis = bpis.a(parambpis);
      break label178;
      label611:
      if (paramInt1 == paramInt2 - 1)
      {
        parambpis.leftMargin = (-bhtq.a(10.0F));
        parambpis.rightMargin = bhtq.a(5.0F);
      }
      else
      {
        parambpis.leftMargin = (-bhtq.a(10.0F));
        parambpis.rightMargin = (-bhtq.a(10.0F));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramView.getId() == 2131376097) && (this.jdField_a_of_type_Bpis != null) && (this.jdField_a_of_type_Bpis.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Bpiu != null))
    {
      if (this.jdField_a_of_type_Bpis.jdField_b_of_type_Int == 1) {
        break label107;
      }
      localbpiu = this.jdField_a_of_type_Bpiu;
      localbpis = this.jdField_a_of_type_Bpis;
      i = getAdapterPosition();
      if (this.jdField_a_of_type_Bpis.jdField_a_of_type_Boolean) {
        break label102;
      }
      localbpiu.a(localbpis, i, bool1, this.jdField_a_of_type_Bpis.jdField_b_of_type_Int);
    }
    label102:
    label107:
    while (bpak.a("tag_music_search_btn")) {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bool1 = false;
      }
    }
    bpiu localbpiu = this.jdField_a_of_type_Bpiu;
    bpis localbpis = this.jdField_a_of_type_Bpis;
    int i = getAdapterPosition();
    if (!this.jdField_a_of_type_Bpis.jdField_a_of_type_Boolean) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localbpiu.a(localbpis, i, bool1, this.jdField_a_of_type_Bpis.jdField_b_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpit
 * JD-Core Version:    0.7.0.1
 */