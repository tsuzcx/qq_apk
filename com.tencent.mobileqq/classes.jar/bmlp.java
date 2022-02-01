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
import dov.com.qq.im.aeeditor.AEEditorConstants;

class bmlp
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837754);
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmlo jdField_a_of_type_Bmlo;
  private bmlq jdField_a_of_type_Bmlq;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private final int jdField_b_of_type_Int;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  public bmlp(@NonNull View paramView, @Nullable bmlq parambmlq, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131375861));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369302));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366776));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369306));
    this.c = ((ImageView)paramView.findViewById(2131369307));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379721));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)paramView.findViewById(2131365508));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, paramView.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_Bmlq = parambmlq;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    }
  }
  
  public void a(@NonNull bmlo parambmlo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bmlo = parambmlo;
    this.jdField_a_of_type_Int = paramInt1;
    URLDrawable localURLDrawable;
    if ((parambmlo.jdField_b_of_type_Int == 2) && (!TextUtils.isEmpty(parambmlo.c())))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_b_of_type_Int > 0)
      {
        localURLDrawable = URLDrawableHelper.getDrawable(parambmlo.c(), this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        label75:
        if (!parambmlo.jdField_a_of_type_Boolean) {
          break label336;
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837944);
        if (parambmlo.jdField_a_of_type_Int != 1) {
          break label252;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        label133:
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        if (parambmlo.jdField_b_of_type_Int != 1) {
          break label545;
        }
        parambmlo = this.jdField_a_of_type_AndroidWidgetTextView.getContext().getString(2131689723);
        label178:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(parambmlo);
        parambmlo = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        if (paramInt1 != 0) {
          break label612;
        }
        parambmlo.leftMargin = ViewUtils.dip2px(5.0F);
        parambmlo.rightMargin = (-ViewUtils.dip2px(10.0F));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(parambmlo);
      return;
      localURLDrawable = URLDrawableHelper.getDrawable(parambmlo.c());
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label75;
      label252:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.isLottieAnimJsonDone(AEEditorConstants.DIR_MUSIC_PLAYING_LOTTIE))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.fromFileWithCacheBitmap(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, AEEditorConstants.DIR_MUSIC_PLAYING_LOTTIE, true);
        break label133;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.fromNetworkWithCacheBitmap(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, "https://downv6.qq.com/shadow_qqcamera/Android/lottie/MusicWave_8e84b13bfc72dd3c86c70617db423aef.zip", AEEditorConstants.LOCAL_PATH_MUSIC_PLAYING_LOTTIE, true);
      break label133;
      label336:
      if (parambmlo.jdField_b_of_type_Int == 0)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837754);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(null, 0);
        break;
        if (parambmlo.jdField_b_of_type_Int != 1) {
          break label470;
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837754);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837920);
        this.c.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      label470:
      if (parambmlo.jdField_a_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837944);
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
      if (TextUtils.isEmpty(bmlo.a(parambmlo)))
      {
        parambmlo = "";
        break label178;
      }
      if (bmlo.a(parambmlo).length() > 5)
      {
        parambmlo = bmlo.a(parambmlo).substring(0, 5) + "...";
        break label178;
      }
      parambmlo = bmlo.a(parambmlo);
      break label178;
      label612:
      if (paramInt1 == paramInt2 - 1)
      {
        parambmlo.leftMargin = (-ViewUtils.dip2px(10.0F));
        parambmlo.rightMargin = ViewUtils.dip2px(5.0F);
      }
      else
      {
        parambmlo.leftMargin = (-ViewUtils.dip2px(10.0F));
        parambmlo.rightMargin = (-ViewUtils.dip2px(10.0F));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramView.getId() == 2131375861) && (this.jdField_a_of_type_Bmlo != null) && (this.jdField_a_of_type_Bmlo.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Bmlq != null))
    {
      if (this.jdField_a_of_type_Bmlo.jdField_b_of_type_Int == 1) {
        break label107;
      }
      localbmlq = this.jdField_a_of_type_Bmlq;
      localbmlo = this.jdField_a_of_type_Bmlo;
      i = getAdapterPosition();
      if (this.jdField_a_of_type_Bmlo.jdField_a_of_type_Boolean) {
        break label102;
      }
      localbmlq.a(localbmlo, i, bool1, this.jdField_a_of_type_Bmlo.jdField_b_of_type_Int);
    }
    label102:
    label107:
    while (bmbv.a("tag_music_search_btn")) {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bool1 = false;
      }
    }
    bmlq localbmlq = this.jdField_a_of_type_Bmlq;
    bmlo localbmlo = this.jdField_a_of_type_Bmlo;
    int i = getAdapterPosition();
    if (!this.jdField_a_of_type_Bmlo.jdField_a_of_type_Boolean) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localbmlq.a(localbmlo, i, bool1, this.jdField_a_of_type_Bmlo.jdField_b_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlp
 * JD-Core Version:    0.7.0.1
 */