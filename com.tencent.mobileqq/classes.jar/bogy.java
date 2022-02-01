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

class bogy
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837734);
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bogx jdField_a_of_type_Bogx;
  private bogz jdField_a_of_type_Bogz;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private final int jdField_b_of_type_Int;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  public bogy(@NonNull View paramView, @Nullable bogz parambogz, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131375957));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369195));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366699));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369199));
    this.c = ((ImageView)paramView.findViewById(2131369200));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379776));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)paramView.findViewById(2131365432));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, paramView.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_Bogz = parambogz;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    }
  }
  
  public void a(@NonNull bogx parambogx, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bogx = parambogx;
    this.jdField_a_of_type_Int = paramInt1;
    URLDrawable localURLDrawable;
    if ((parambogx.jdField_b_of_type_Int == 2) && (!TextUtils.isEmpty(parambogx.c())))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_b_of_type_Int > 0)
      {
        localURLDrawable = bdzx.a(parambogx.c(), this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        label75:
        if (!parambogx.jdField_a_of_type_Boolean) {
          break label336;
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2131165238);
        if (parambogx.jdField_a_of_type_Int != 1) {
          break label252;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        label133:
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        if (parambogx.jdField_b_of_type_Int != 1) {
          break label545;
        }
        parambogx = this.jdField_a_of_type_AndroidWidgetTextView.getContext().getString(2131689708);
        label178:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(parambogx);
        parambogx = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (paramInt1 != 0) {
          break label611;
        }
        parambogx.leftMargin = bgtn.a(5.0F);
        parambogx.rightMargin = (-bgtn.a(10.0F));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(parambogx);
      return;
      localURLDrawable = bdzx.a(parambogx.c());
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label75;
      label252:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(bnzn.b))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, bnzn.b, true);
        break label133;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, "https://downv6.qq.com/shadow_qqcamera/Android/lottie/MusicWave_8e84b13bfc72dd3c86c70617db423aef.zip", bnzn.a, true);
      break label133;
      label336:
      if (parambogx.jdField_b_of_type_Int == 0)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837734);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(null, 0);
        break;
        if (parambogx.jdField_b_of_type_Int != 1) {
          break label470;
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837734);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837754);
        this.c.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      label470:
      if (parambogx.jdField_a_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2131167229);
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
      if (TextUtils.isEmpty(bogx.a(parambogx)))
      {
        parambogx = "";
        break label178;
      }
      if (bogx.a(parambogx).length() > 5)
      {
        parambogx = bogx.a(parambogx).substring(0, 5) + "...";
        break label178;
      }
      parambogx = bogx.a(parambogx);
      break label178;
      label611:
      if (paramInt1 == paramInt2 - 1)
      {
        parambogx.leftMargin = (-bgtn.a(10.0F));
        parambogx.rightMargin = bgtn.a(5.0F);
      }
      else
      {
        parambogx.leftMargin = (-bgtn.a(10.0F));
        parambogx.rightMargin = (-bgtn.a(10.0F));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramView.getId() == 2131375957) && (this.jdField_a_of_type_Bogx != null) && (this.jdField_a_of_type_Bogx.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Bogz != null))
    {
      if (this.jdField_a_of_type_Bogx.jdField_b_of_type_Int == 1) {
        break label107;
      }
      localbogz = this.jdField_a_of_type_Bogz;
      localbogx = this.jdField_a_of_type_Bogx;
      i = getAdapterPosition();
      if (this.jdField_a_of_type_Bogx.jdField_a_of_type_Boolean) {
        break label102;
      }
      localbogz.a(localbogx, i, bool1, this.jdField_a_of_type_Bogx.jdField_b_of_type_Int);
    }
    label102:
    label107:
    while (bnyz.a("tag_music_search_btn")) {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bool1 = false;
      }
    }
    bogz localbogz = this.jdField_a_of_type_Bogz;
    bogx localbogx = this.jdField_a_of_type_Bogx;
    int i = getAdapterPosition();
    if (!this.jdField_a_of_type_Bogx.jdField_a_of_type_Boolean) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localbogz.a(localbogx, i, bool1, this.jdField_a_of_type_Bogx.jdField_b_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogy
 * JD-Core Version:    0.7.0.1
 */