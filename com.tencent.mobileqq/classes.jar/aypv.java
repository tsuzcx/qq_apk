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

public class aypv
  extends ayrm
{
  int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aypw(this);
  private ayjq jdField_a_of_type_Ayjq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public aypv(bdbb parambdbb, int paramInt)
  {
    super(parambdbb);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public aypv(bdbb parambdbb, int paramInt, ayjq paramayjq)
  {
    super(parambdbb);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ayjq = paramayjq;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void a(Context paramContext, ayms paramayms)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + paramContext + ", model = " + paramayms);
    }
    if ((paramContext == null) || (paramayms == null)) {
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
          bbfv.a(paramContext, paramayms.jdField_b_of_type_JavaLangString, paramayms.jdField_c_of_type_JavaLangString, i, "", paramayms.jdField_k_of_type_JavaLangString, false, new aypz(this, paramayms));
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
      localDrawable = paramImageView2.getResources().getDrawable(2130841986);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130842013);
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
      f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + aepi.a(4.0F, paramTextView1.getContext().getResources());
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding(aepi.a(2.0F, paramTextView1.getContext().getResources()), 0, aepi.a(2.0F, paramTextView1.getContext().getResources()), 0);
    }
    for (;;)
    {
      float f2 = i - aepi.a(89.0F, paramTextView1.getContext().getResources());
      if (f1 != 0.0F) {}
      for (f1 = f2 - (f1 + aepi.a(6.0F, paramTextView1.getContext().getResources()));; f1 = f2)
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
      paramString.setBounds(0, 0, aepi.a(14.0F, localResources), aepi.a(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(aepi.a(4.0F, localResources));
      paramTextView.setCompoundDrawables(null, null, paramString, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ayjq != null) {
      this.jdField_a_of_type_Ayjq.notifyDataSetChanged();
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
  
  public void a(aynu paramaynu, aywd paramaywd)
  {
    Object localObject = paramaywd.b();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      ayms localayms;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(paramaynu instanceof ayms)) || (!(paramaywd instanceof ayxl))) {
          break label468;
        }
        localayms = (ayms)paramaynu;
        ayxl localayxl = (ayxl)paramaywd;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean)
        {
          localLayoutParams.height = aepi.a(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localayxl.c() != null) {
            localayxl.c().setLayoutParams(localLayoutParams);
          }
          if ((localayms.d() == 1001) || (localayms.d() == 1002)) {
            break label459;
          }
          int i = paramaywd.a().getResources().getDimensionPixelSize(2131297310);
          paramaynu = URLDrawable.URLDrawableOptions.obtain();
          paramaynu.mRequestWidth = i;
          paramaynu.mRequestHeight = i;
          if (localayms.jdField_b_of_type_Boolean) {
            paramaynu.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            paramaynu.mLoadingDrawable = ((Drawable)localObject);
            paramaynu.mFailedDrawable = ((Drawable)localObject);
          }
          paramaynu = URLDrawable.getDrawable(localayms.c(), paramaynu);
          if (localayms.jdField_b_of_type_Boolean) {
            paramaynu.setDecodeHandler(bcyz.a);
          }
          if ((paramaynu.getStatus() != 1) && (paramaynu.getStatus() != 0)) {
            paramaynu.restartDownload();
          }
          paramaywd.b().setImageDrawable(paramaynu);
          if ((paramaywd.b() == null) || (localayxl.c() == null)) {
            break;
          }
          a(paramaywd.b(), localayxl.c(), localayms.jdField_b_of_type_Int);
          return;
        }
      }
      catch (Exception paramaynu)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + paramaynu.toString());
        return;
      }
      if ((localayms.d() == 8192) || (localayms.d() == 16) || (localayms.d() == 8))
      {
        localLayoutParams.height = aepi.a(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localayms.d() == 1001)
      {
        localLayoutParams.height = aepi.a(60.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if ((localayms.d() != 1024) && (localayms.d() != 1002))
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131298225);
        continue;
        label459:
        super.a(paramaynu, paramaywd);
      }
    }
    label468:
    super.a(paramaynu, paramaywd);
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
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    if (!(paramaynu instanceof ayms))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + paramaynu);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + paramaynu);
    }
    ayms localayms = (ayms)paramaynu;
    this.jdField_a_of_type_Int = localayms.d();
    Object localObject1 = paramaywd.a();
    Object localObject2 = paramaywd.b();
    Object localObject3 = paramaywd.c();
    Resources localResources = paramaywd.a().getContext().getResources();
    if ((localObject3 != null) && (localayms.jdField_c_of_type_Int != -1)) {
      ((TextView)localObject3).setTextColor(localResources.getColor(localayms.jdField_c_of_type_Int));
    }
    int i;
    if ((paramaywd instanceof ayxl))
    {
      paramaynu = (ayxl)paramaywd;
      if (paramaynu.e() != null) {
        paramaynu.e().setVisibility(8);
      }
      if (localObject1 != null) {
        a((TextView)localObject1, localayms.h);
      }
      if (localObject2 != null) {
        a((TextView)localObject2, localayms.i);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (localObject3 != null) {
          ((TextView)localObject3).setMaxLines(1);
        }
        if (this.jdField_a_of_type_Int == 1002)
        {
          paramaynu = paramaywd.a("ActiveEntitySearchResultPresenter_add_troop");
          localObject1 = (Pair)localayms.a("ActiveEntitySearchResultPresenter_add_troop");
          if ((paramaynu != null) && (localObject1 != null))
          {
            paramaynu.setVisibility(0);
            if ((paramaynu instanceof TextView))
            {
              localObject2 = (TextView)paramaynu;
              ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
              ((TextView)localObject2).setEnabled(((Boolean)((Pair)localObject1).second).booleanValue());
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131755344);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (!((Boolean)((Pair)localObject1).second).booleanValue()) {
                break label1242;
              }
              i = paramaynu.getContext().getResources().getDimensionPixelSize(2131296632);
              ((TextView)localObject2).setPadding(i, 0, i, 0);
              ((TextView)localObject2).setMinWidth(azkz.a(60.0F));
              ((TextView)localObject2).setMinWidth(azkz.a(29.0F));
              ((TextView)localObject2).setBackgroundResource(2130839142);
              if (localObject3 != null)
              {
                ((ViewGroup.LayoutParams)localObject3).height = -2;
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              }
            }
          }
          label462:
          localObject2 = paramaywd.a("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localayms.a("ActiveEntitySearchResultPresenter_pay_troop");
          paramaynu = (aynu)localObject1;
          if (localObject1 == null) {
            paramaynu = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (!paramaynu.booleanValue()) {
              break label1295;
            }
            i = 0;
            label513:
            ((View)localObject2).setVisibility(i);
          }
          localObject1 = paramaywd.a("ActiveEntitySearchResultPresenter_hot_troop");
          paramaynu = (Integer)localayms.a("ActiveEntitySearchResultPresenter_hot_troop");
          if (paramaynu != null) {
            break label1311;
          }
          paramaynu = Integer.valueOf(0);
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
        if (paramaynu.intValue() <= 0) {
          break label1301;
        }
        ((View)localObject1).setVisibility(0);
        ((TroopActiveLayout)localObject1).setHotLevel(paramaynu.intValue());
      }
      for (;;)
      {
        paramaynu = paramaywd.a("ActiveEntitySearchResultPresenter_expand_desc");
        localObject1 = localayms.c();
        if (((paramaynu instanceof FolderTextView)) && (localObject1 != null)) {
          ((FolderTextView)paramaynu).setText(new bamp((CharSequence)localObject1, 11, 16));
        }
        super.b(localayms, paramaywd);
        a(paramaywd.a(), localayms.a(), true, false);
        a(paramaywd.b(), localayms.b(), false);
        a(paramaywd.c(), localayms.c(), false);
        a(paramaywd.d(), localayms.d(), false);
        return;
        if (paramaynu.b() != null) {
          paramaynu.b().a(localayms.jdField_b_of_type_JavaUtilList, localayms.e, localayms.d - 1, 1);
        }
        if (paramaynu.h() != null)
        {
          if (!TextUtils.isEmpty(localayms.m)) {
            paramaynu.h().setText(localayms.m);
          }
        }
        else if ((paramaynu.g() != null) && (paramaynu.f() != null))
        {
          localObject1 = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (!((alto)localObject1).b(localayms.jdField_b_of_type_JavaLangString)) {
            break label930;
          }
          localayms.jdField_k_of_type_Int = 2;
          label816:
          if (localayms.jdField_k_of_type_Int != 0) {
            break label964;
          }
          if (bclg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayms.jdField_b_of_type_JavaLangString)) {
            break label952;
          }
          paramaynu.f().setVisibility(0);
          paramaynu.f().setText(alud.a(2131689628));
          label860:
          paramaynu.g().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((paramaynu.b() == null) || (paramaynu.f() == null)) {
            break;
          }
          if (!bclg.b((QQAppInterface)localObject1, localayms.jdField_b_of_type_JavaLangString)) {
            break label1033;
          }
          paramaynu.b().setVisibility(0);
          break;
          paramaynu.h().setText("");
          break label769;
          label930:
          if (!((alto)localObject1).d(localayms.jdField_b_of_type_JavaLangString)) {
            break label816;
          }
          localayms.jdField_k_of_type_Int = 1;
          break label816;
          label952:
          paramaynu.f().setVisibility(8);
          break label860;
          label964:
          if (localayms.jdField_k_of_type_Int == 1)
          {
            paramaynu.f().setVisibility(8);
            paramaynu.g().setVisibility(0);
            paramaynu.g().setText(2131719239);
          }
          else
          {
            paramaynu.f().setVisibility(8);
            paramaynu.g().setVisibility(0);
            paramaynu.g().setText(2131690082);
          }
        }
        paramaynu.b().setVisibility(8);
        break;
        if (paramaynu.a() != null)
        {
          paramaynu.a().setVisibility(0);
          paramaynu.a().setLabelType(1);
          paramaynu.a().a(localayms.a);
        }
        if (paramaynu.a != null)
        {
          if ((localayms.jdField_b_of_type_Long & 0x800) == 0L) {
            break label1129;
          }
          paramaynu.a.setVisibility(0);
        }
        while (paramaynu.b != null)
        {
          paramaynu.b.setVisibility(8);
          break;
          label1129:
          paramaynu.a.setVisibility(8);
        }
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setCompoundDrawablePadding(aepi.a(4.0F, localResources));
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841297, 0);
        break;
        a((TextView)localObject1, (TextView)localObject3, localayms.a(), null);
        break;
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + paramaywd);
        throw new RuntimeException("View is not SearchResultFromNetView. View = " + paramaywd);
        label1242:
        ((TextView)localObject2).setPadding(0, 0, 0, 0);
        ((TextView)localObject2).setMinWidth(0);
        ((TextView)localObject2).setMinHeight(0);
        ((TextView)localObject2).setBackgroundDrawable(null);
        if (localObject3 == null) {
          break label462;
        }
        ((ViewGroup.LayoutParams)localObject3).height = azkz.a(20.0F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break label462;
        i = 8;
        break label513;
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  protected void c(aynu paramaynu, aywd paramaywd)
  {
    super.c(paramaynu, paramaywd);
    if ((paramaynu instanceof ayms))
    {
      paramaynu = (ayms)paramaynu;
      if (paramaynu.d() != 1002) {
        break label56;
      }
      paramaywd = paramaywd.a("ActiveEntitySearchResultPresenter_add_troop");
      if (paramaywd != null) {
        paramaywd.setOnClickListener(new aypx(this, paramaynu));
      }
    }
    label56:
    while ((paramaynu.d() != 1001) || (((ayxl)paramaywd).f() == null)) {
      return;
    }
    ((ayxl)paramaywd).f().setOnClickListener(new aypy(this, paramaynu));
  }
  
  public void d(aynu paramaynu, aywd paramaywd)
  {
    if (((paramaynu instanceof ayms)) && (!this.jdField_a_of_type_Boolean) && (a(((ayms)paramaynu).d()))) {
      ayvp.a(paramaynu.a(), paramaynu.b(), paramaywd.a(), ((ayms)paramaynu).r);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypv
 * JD-Core Version:    0.7.0.1
 */