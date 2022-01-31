import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;

public class awqh
  extends awry
{
  int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new awqi(this);
  private awkf jdField_a_of_type_Awkf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public awqh(baxk parambaxk, int paramInt)
  {
    super(parambaxk);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public awqh(baxk parambaxk, int paramInt, awkf paramawkf)
  {
    super(parambaxk);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Awkf = paramawkf;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void a(Context paramContext, awne paramawne)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + paramContext + ", model = " + paramawne);
    }
    if ((paramContext == null) || (paramawne == null)) {
      return;
    }
    Object localObject;
    if ((paramContext instanceof Activity))
    {
      localObject = ((Activity)paramContext).getIntent();
      if (localObject == null) {}
    }
    for (int j = ((Intent)localObject).getIntExtra("from_type_for_report", 0);; j = 0)
    {
      if (j == 9) {}
      for (int i = 112; (paramContext instanceof ActiveEntitySearchActivity); i = 103)
      {
        localObject = ((Activity)paramContext).getIntent().getLongArrayExtra("group_mask_long_array");
        if ((localObject != null) && (localObject.length == 1) && (localObject[0] == 1002L)) {
          if (j == 9) {
            i = 113;
          }
        }
        for (;;)
        {
          azdl.a(paramContext, paramawne.jdField_b_of_type_JavaLangString, paramawne.jdField_c_of_type_JavaLangString, i, "", paramawne.jdField_k_of_type_JavaLangString, false, new awql(this, paramawne));
          return;
          i = 104;
        }
      }
      break;
    }
  }
  
  public static void a(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 1)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130841821);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130841848);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    paramImageView1.setColorFilter(0);
    paramImageView2.setVisibility(8);
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence, TextView paramTextView3)
  {
    Paint localPaint = new Paint();
    if ((paramTextView1 == null) || (paramTextView2 == null) || (paramCharSequence == null)) {
      return;
    }
    int i = paramTextView1.getContext().getResources().getDisplayMetrics().widthPixels;
    float f1;
    if (paramTextView3 != null)
    {
      localPaint.setTextSize(paramTextView3.getTextSize());
      f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + actn.a(4.0F, paramTextView1.getContext().getResources());
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding(actn.a(2.0F, paramTextView1.getContext().getResources()), 0, actn.a(2.0F, paramTextView1.getContext().getResources()), 0);
    }
    for (;;)
    {
      float f2 = i - actn.a(89.0F, paramTextView1.getContext().getResources());
      if (f1 != 0.0F) {}
      for (f1 = f2 - (f1 + actn.a(6.0F, paramTextView1.getContext().getResources()));; f1 = f2)
      {
        localPaint.setTextSize(paramTextView1.getTextSize());
        if (localPaint.measureText(paramCharSequence, 0, paramCharSequence.length()) > f1)
        {
          paramTextView1.setMaxLines(2);
          paramTextView2.setMaxLines(1);
          return;
        }
        paramTextView1.setMaxLines(1);
        paramTextView2.setMaxLines(2);
        return;
      }
      f1 = 0.0F;
    }
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if ((paramString != null) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      paramString = URLDrawable.getDrawable(paramString);
      if ((paramString.getStatus() != 1) && (paramString.getStatus() != 0)) {
        paramString.restartDownload();
      }
      Resources localResources = paramTextView.getContext().getResources();
      paramString.setBounds(0, 0, actn.a(14.0F, localResources), actn.a(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(actn.a(4.0F, localResources));
      paramTextView.setCompoundDrawables(null, null, paramString, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Awkf != null) {
      this.jdField_a_of_type_Awkf.notifyDataSetChanged();
    }
  }
  
  public void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramView, paramCharSequence, paramBoolean, false);
  }
  
  public void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramView != null)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label32;
      }
      i = 1;
      if ((i == 0) || (paramView.getVisibility() == 0)) {
        break label38;
      }
      paramView.setVisibility(0);
    }
    label32:
    label38:
    do
    {
      do
      {
        return;
        i = 0;
        break;
      } while (i != 0);
      if ((paramBoolean1) && (!paramBoolean2) && (paramView.getVisibility() != 4))
      {
        paramView.setVisibility(4);
        return;
      }
    } while (paramView.getVisibility() == 8);
    paramView.setVisibility(8);
  }
  
  public void a(awog paramawog, awwp paramawwp)
  {
    Object localObject = paramawwp.b();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      awne localawne;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(paramawog instanceof awne)) || (!(paramawwp instanceof awxx))) {
          break label468;
        }
        localawne = (awne)paramawog;
        awxx localawxx = (awxx)paramawwp;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean)
        {
          localLayoutParams.height = actn.a(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localawxx.c() != null) {
            localawxx.c().setLayoutParams(localLayoutParams);
          }
          if ((localawne.d() == 1001) || (localawne.d() == 1002)) {
            break label459;
          }
          int i = paramawwp.a().getResources().getDimensionPixelSize(2131297291);
          paramawog = URLDrawable.URLDrawableOptions.obtain();
          paramawog.mRequestWidth = i;
          paramawog.mRequestHeight = i;
          if (localawne.jdField_b_of_type_Boolean) {
            paramawog.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            paramawog.mLoadingDrawable = ((Drawable)localObject);
            paramawog.mFailedDrawable = ((Drawable)localObject);
          }
          paramawog = URLDrawable.getDrawable(localawne.c(), paramawog);
          if (localawne.jdField_b_of_type_Boolean) {
            paramawog.setDecodeHandler(bavi.a);
          }
          if ((paramawog.getStatus() != 1) && (paramawog.getStatus() != 0)) {
            paramawog.restartDownload();
          }
          paramawwp.b().setImageDrawable(paramawog);
          if ((paramawwp.b() == null) || (localawxx.c() == null)) {
            break;
          }
          a(paramawwp.b(), localawxx.c(), localawne.jdField_b_of_type_Int);
          return;
        }
      }
      catch (Exception paramawog)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + paramawog.toString());
        return;
      }
      if ((localawne.d() == 8192) || (localawne.d() == 16) || (localawne.d() == 8))
      {
        localLayoutParams.height = actn.a(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localawne.d() == 1001)
      {
        localLayoutParams.height = actn.a(60.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if ((localawne.d() != 1024) && (localawne.d() != 1002))
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131298200);
        continue;
        label459:
        super.a(paramawog, paramawwp);
      }
    }
    label468:
    super.a(paramawog, paramawwp);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      bool = true;
    }
    return bool;
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    if (!(paramawog instanceof awne))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + paramawog);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + paramawog);
    }
    awne localawne = (awne)paramawog;
    this.jdField_a_of_type_Int = localawne.d();
    Object localObject1 = paramawwp.a();
    Object localObject2 = paramawwp.b();
    Object localObject3 = paramawwp.c();
    Resources localResources = paramawwp.a().getContext().getResources();
    if ((localObject3 != null) && (localawne.jdField_c_of_type_Int != -1)) {
      ((TextView)localObject3).setTextColor(localResources.getColor(localawne.jdField_c_of_type_Int));
    }
    int i;
    if ((paramawwp instanceof awxx))
    {
      paramawog = (awxx)paramawwp;
      if (paramawog.e() != null) {
        paramawog.e().setVisibility(8);
      }
      if (localObject1 != null) {
        a((TextView)localObject1, localawne.h);
      }
      if (localObject2 != null) {
        a((TextView)localObject2, localawne.i);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (localObject3 != null) {
          ((TextView)localObject3).setMaxLines(1);
        }
        if (this.jdField_a_of_type_Int == 1002)
        {
          paramawog = paramawwp.a("ActiveEntitySearchResultPresenter_add_troop");
          localObject1 = (Pair)localawne.a("ActiveEntitySearchResultPresenter_add_troop");
          if ((paramawog != null) && (localObject1 != null))
          {
            paramawog.setVisibility(0);
            if ((paramawog instanceof TextView))
            {
              localObject2 = (TextView)paramawog;
              ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
              ((TextView)localObject2).setEnabled(((Boolean)((Pair)localObject1).second).booleanValue());
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131755338);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (!((Boolean)((Pair)localObject1).second).booleanValue()) {
                break label1242;
              }
              i = paramawog.getContext().getResources().getDimensionPixelSize(2131296616);
              ((TextView)localObject2).setPadding(i, 0, i, 0);
              ((TextView)localObject2).setMinWidth(axli.a(60.0F));
              ((TextView)localObject2).setMinWidth(axli.a(29.0F));
              ((TextView)localObject2).setBackgroundResource(2130839060);
              if (localObject3 != null)
              {
                ((ViewGroup.LayoutParams)localObject3).height = -2;
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              }
            }
          }
          label462:
          localObject2 = paramawwp.a("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localawne.a("ActiveEntitySearchResultPresenter_pay_troop");
          paramawog = (awog)localObject1;
          if (localObject1 == null) {
            paramawog = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (!paramawog.booleanValue()) {
              break label1295;
            }
            i = 0;
            label513:
            ((View)localObject2).setVisibility(i);
          }
          localObject1 = paramawwp.a("ActiveEntitySearchResultPresenter_hot_troop");
          paramawog = (Integer)localawne.a("ActiveEntitySearchResultPresenter_hot_troop");
          if (paramawog != null) {
            break label1311;
          }
          paramawog = Integer.valueOf(0);
        }
        break;
      }
    }
    label769:
    label1033:
    label1295:
    label1301:
    label1311:
    for (;;)
    {
      if ((localObject1 instanceof TroopActiveLayout))
      {
        if (paramawog.intValue() <= 0) {
          break label1301;
        }
        ((View)localObject1).setVisibility(0);
        ((TroopActiveLayout)localObject1).setHotLevel(paramawog.intValue());
      }
      for (;;)
      {
        paramawog = paramawwp.a("ActiveEntitySearchResultPresenter_expand_desc");
        localObject1 = localawne.c();
        if (((paramawog instanceof FolderTextView)) && (localObject1 != null)) {
          ((FolderTextView)paramawog).setText(new ayki((CharSequence)localObject1, 11, 16));
        }
        super.b(localawne, paramawwp);
        a(paramawwp.a(), localawne.a(), true, false);
        a(paramawwp.b(), localawne.b(), false);
        a(paramawwp.c(), localawne.c(), false);
        a(paramawwp.d(), localawne.d(), false);
        return;
        if (paramawog.b() != null) {
          paramawog.b().a(localawne.jdField_b_of_type_JavaUtilList, localawne.e, localawne.d - 1, 1);
        }
        if (paramawog.h() != null)
        {
          if (!TextUtils.isEmpty(localawne.m)) {
            paramawog.h().setText(localawne.m);
          }
        }
        else if ((paramawog.g() != null) && (paramawog.f() != null))
        {
          localObject1 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (!((ajxn)localObject1).b(localawne.jdField_b_of_type_JavaLangString)) {
            break label930;
          }
          localawne.jdField_k_of_type_Int = 2;
          label816:
          if (localawne.jdField_k_of_type_Int != 0) {
            break label964;
          }
          if (bahx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localawne.jdField_b_of_type_JavaLangString)) {
            break label952;
          }
          paramawog.f().setVisibility(0);
          paramawog.f().setText(ajyc.a(2131689628));
          label860:
          paramawog.g().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((paramawog.b() == null) || (paramawog.f() == null)) {
            break;
          }
          if (!bahx.b((QQAppInterface)localObject1, localawne.jdField_b_of_type_JavaLangString)) {
            break label1033;
          }
          paramawog.b().setVisibility(0);
          break;
          paramawog.h().setText("");
          break label769;
          label930:
          if (!((ajxn)localObject1).d(localawne.jdField_b_of_type_JavaLangString)) {
            break label816;
          }
          localawne.jdField_k_of_type_Int = 1;
          break label816;
          label952:
          paramawog.f().setVisibility(8);
          break label860;
          label964:
          if (localawne.jdField_k_of_type_Int == 1)
          {
            paramawog.f().setVisibility(8);
            paramawog.g().setVisibility(0);
            paramawog.g().setText(2131718743);
          }
          else
          {
            paramawog.f().setVisibility(8);
            paramawog.g().setVisibility(0);
            paramawog.g().setText(2131690035);
          }
        }
        paramawog.b().setVisibility(8);
        break;
        if (paramawog.a() != null)
        {
          paramawog.a().setVisibility(0);
          paramawog.a().setLabelType(1);
          paramawog.a().a(localawne.a);
        }
        if (paramawog.a != null)
        {
          if ((localawne.jdField_b_of_type_Long & 0x800) == 0L) {
            break label1129;
          }
          paramawog.a.setVisibility(0);
        }
        while (paramawog.b != null)
        {
          paramawog.b.setVisibility(8);
          break;
          label1129:
          paramawog.a.setVisibility(8);
        }
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setCompoundDrawablePadding(actn.a(4.0F, localResources));
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841179, 0);
        break;
        a((TextView)localObject1, (TextView)localObject3, localawne.a(), null);
        break;
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + paramawwp);
        throw new RuntimeException("View is not SearchResultFromNetView. View = " + paramawwp);
        label1242:
        ((TextView)localObject2).setPadding(0, 0, 0, 0);
        ((TextView)localObject2).setMinWidth(0);
        ((TextView)localObject2).setMinHeight(0);
        ((TextView)localObject2).setBackgroundDrawable(null);
        if (localObject3 == null) {
          break label462;
        }
        ((ViewGroup.LayoutParams)localObject3).height = axli.a(20.0F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break label462;
        i = 8;
        break label513;
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  protected void c(awog paramawog, awwp paramawwp)
  {
    super.c(paramawog, paramawwp);
    if ((paramawog instanceof awne))
    {
      paramawog = (awne)paramawog;
      if (paramawog.d() != 1002) {
        break label56;
      }
      paramawwp = paramawwp.a("ActiveEntitySearchResultPresenter_add_troop");
      if (paramawwp != null) {
        paramawwp.setOnClickListener(new awqj(this, paramawog));
      }
    }
    label56:
    while ((paramawog.d() != 1001) || (((awxx)paramawwp).f() == null)) {
      return;
    }
    ((awxx)paramawwp).f().setOnClickListener(new awqk(this, paramawog));
  }
  
  public void d(awog paramawog, awwp paramawwp)
  {
    if (((paramawog instanceof awne)) && (!this.jdField_a_of_type_Boolean) && (a(((awne)paramawog).d()))) {
      awwb.a(paramawog.a(), paramawog.b(), paramawwp.a(), ((awne)paramawog).r);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqh
 * JD-Core Version:    0.7.0.1
 */