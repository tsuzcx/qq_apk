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
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bobh
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837908);
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bobg jdField_a_of_type_Bobg;
  private bobi jdField_a_of_type_Bobi;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private final int jdField_b_of_type_Int;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  public bobh(@NonNull View paramView, @Nullable bobi parambobi, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131376108));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369468));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366893));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369472));
    this.c = ((ImageView)paramView.findViewById(2131369473));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380035));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)paramView.findViewById(2131365600));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, paramView.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_Bobi = parambobi;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    }
  }
  
  public void a(@NonNull bobg parambobg, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bobg = parambobg;
    this.jdField_a_of_type_Int = paramInt1;
    URLDrawable localURLDrawable;
    if ((parambobg.jdField_b_of_type_Int == 2) && (!TextUtils.isEmpty(parambobg.c())))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_b_of_type_Int > 0)
      {
        localURLDrawable = URLDrawableHelper.getDrawable(parambobg.c(), this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        label75:
        if (!parambobg.jdField_a_of_type_Boolean) {
          break label336;
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837958);
        if (parambobg.jdField_a_of_type_Int != 1) {
          break label252;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        label133:
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        if (parambobg.jdField_b_of_type_Int != 1) {
          break label545;
        }
        parambobg = this.jdField_a_of_type_AndroidWidgetTextView.getContext().getString(2131689731);
        label178:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(parambobg);
        parambobg = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (paramInt1 != 0) {
          break label612;
        }
        parambobg.leftMargin = ViewUtils.dip2px(5.0F);
        parambobg.rightMargin = (-ViewUtils.dip2px(10.0F));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(parambobg);
      return;
      localURLDrawable = URLDrawableHelper.getDrawable(parambobg.c());
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label75;
      label252:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.isLottieAnimJsonDone(bnsk.b))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.fromFileWithCacheBitmap(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, bnsk.b, true);
        break label133;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.fromNetworkWithCacheBitmap(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, "https://downv6.qq.com/shadow_qqcamera/Android/lottie/MusicWave_8e84b13bfc72dd3c86c70617db423aef.zip", bnsk.a, true);
      break label133;
      label336:
      if (parambobg.jdField_b_of_type_Int == 0)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837908);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(null, 0);
        break;
        if (parambobg.jdField_b_of_type_Int != 1) {
          break label470;
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837908);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837934);
        this.c.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      label470:
      if (parambobg.jdField_a_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837958);
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
      if (TextUtils.isEmpty(bobg.a(parambobg)))
      {
        parambobg = "";
        break label178;
      }
      if (bobg.a(parambobg).length() > 5)
      {
        parambobg = bobg.a(parambobg).substring(0, 5) + "...";
        break label178;
      }
      parambobg = bobg.a(parambobg);
      break label178;
      label612:
      if (paramInt1 == paramInt2 - 1)
      {
        parambobg.leftMargin = (-ViewUtils.dip2px(10.0F));
        parambobg.rightMargin = ViewUtils.dip2px(5.0F);
      }
      else
      {
        parambobg.leftMargin = (-ViewUtils.dip2px(10.0F));
        parambobg.rightMargin = (-ViewUtils.dip2px(10.0F));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramView.getId() == 2131376108) && (this.jdField_a_of_type_Bobg != null) && (this.jdField_a_of_type_Bobg.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Bobi != null))
    {
      if (this.jdField_a_of_type_Bobg.jdField_b_of_type_Int == 1) {
        break label107;
      }
      localbobi = this.jdField_a_of_type_Bobi;
      localbobg = this.jdField_a_of_type_Bobg;
      i = getAdapterPosition();
      if (this.jdField_a_of_type_Bobg.jdField_a_of_type_Boolean) {
        break label102;
      }
      localbobi.a(localbobg, i, bool1, this.jdField_a_of_type_Bobg.jdField_b_of_type_Int);
    }
    label102:
    label107:
    while (bnrf.a("tag_music_search_btn")) {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bool1 = false;
      }
    }
    bobi localbobi = this.jdField_a_of_type_Bobi;
    bobg localbobg = this.jdField_a_of_type_Bobg;
    int i = getAdapterPosition();
    if (!this.jdField_a_of_type_Bobg.jdField_a_of_type_Boolean) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localbobi.a(localbobg, i, bool1, this.jdField_a_of_type_Bobg.jdField_b_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobh
 * JD-Core Version:    0.7.0.1
 */