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

public class bchs
  extends bcji
{
  int jdField_a_of_type_Int;
  private bcbl jdField_a_of_type_Bcbl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public bchs(aoof paramaoof, int paramInt)
  {
    super(paramaoof);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public bchs(aoof paramaoof, int paramInt, bcbl parambcbl)
  {
    super(paramaoof);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bcbl = parambcbl;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void a(Context paramContext, bcep parambcep)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + paramContext + ", model = " + parambcep);
    }
    if ((paramContext == null) || (parambcep == null)) {
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
          switch (i)
          {
          }
          for (;;)
          {
            bffu.a(paramContext, parambcep.jdField_b_of_type_JavaLangString, parambcep.jdField_c_of_type_JavaLangString, i, "", parambcep.p, false, new bchv(this, parambcep));
            return;
            i = 104;
            break;
            if (parambcep.jdField_d_of_type_Boolean)
            {
              i = 30013;
            }
            else
            {
              i = 30015;
              continue;
              if (parambcep.jdField_d_of_type_Boolean) {
                i = 30017;
              } else {
                i = 30019;
              }
            }
          }
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
      localDrawable = paramImageView2.getResources().getDrawable(2130842307);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130842334);
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
      f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + agej.a(4.0F, paramTextView1.getContext().getResources());
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding(agej.a(2.0F, paramTextView1.getContext().getResources()), 0, agej.a(2.0F, paramTextView1.getContext().getResources()), 0);
    }
    for (;;)
    {
      float f2 = i - agej.a(89.0F, paramTextView1.getContext().getResources());
      if (f1 != 0.0F) {}
      for (f1 = f2 - (f1 + agej.a(6.0F, paramTextView1.getContext().getResources()));; f1 = f2)
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
      paramString.setBounds(0, 0, agej.a(14.0F, localResources), agej.a(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(agej.a(4.0F, localResources));
      paramTextView.setCompoundDrawables(null, null, paramString, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bcbl != null) {
      this.jdField_a_of_type_Bcbl.notifyDataSetChanged();
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
  
  public void a(bcfr parambcfr, bcnz parambcnz)
  {
    Object localObject = parambcnz.b();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      bcep localbcep;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(parambcfr instanceof bcep)) || (!(parambcnz instanceof bcph))) {
          break label468;
        }
        localbcep = (bcep)parambcfr;
        bcph localbcph = (bcph)parambcnz;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean)
        {
          localLayoutParams.height = agej.a(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localbcph.c() != null) {
            localbcph.c().setLayoutParams(localLayoutParams);
          }
          if ((localbcep.d() == 1001) || (localbcep.d() == 1002)) {
            break label459;
          }
          int i = parambcnz.a().getResources().getDimensionPixelSize(2131297401);
          parambcfr = URLDrawable.URLDrawableOptions.obtain();
          parambcfr.mRequestWidth = i;
          parambcfr.mRequestHeight = i;
          if (localbcep.jdField_b_of_type_Boolean) {
            parambcfr.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            parambcfr.mLoadingDrawable = ((Drawable)localObject);
            parambcfr.mFailedDrawable = ((Drawable)localObject);
          }
          parambcfr = URLDrawable.getDrawable(localbcep.c(), parambcfr);
          if (localbcep.jdField_b_of_type_Boolean) {
            parambcfr.setDecodeHandler(bhez.a);
          }
          if ((parambcfr.getStatus() != 1) && (parambcfr.getStatus() != 0)) {
            parambcfr.restartDownload();
          }
          parambcnz.b().setImageDrawable(parambcfr);
          if ((parambcnz.b() == null) || (localbcph.c() == null)) {
            break;
          }
          a(parambcnz.b(), localbcph.c(), localbcep.jdField_b_of_type_Int);
          return;
        }
      }
      catch (Exception parambcfr)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + parambcfr.toString());
        return;
      }
      if ((localbcep.d() == 8192) || (localbcep.d() == 16) || (localbcep.d() == 8))
      {
        localLayoutParams.height = agej.a(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localbcep.d() == 1001)
      {
        localLayoutParams.height = agej.a(60.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if ((localbcep.d() != 1024) && (localbcep.d() != 1002))
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131298320);
        continue;
        label459:
        super.a(parambcfr, parambcnz);
      }
    }
    label468:
    super.a(parambcfr, parambcnz);
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
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    if (!(parambcfr instanceof bcep))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + parambcfr);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + parambcfr);
    }
    bcep localbcep = (bcep)parambcfr;
    this.jdField_a_of_type_Int = localbcep.d();
    Object localObject1 = parambcnz.a();
    Object localObject2 = parambcnz.b();
    Object localObject3 = parambcnz.c();
    Resources localResources = parambcnz.a().getContext().getResources();
    if ((localObject3 != null) && (localbcep.jdField_c_of_type_Int != -1)) {
      ((TextView)localObject3).setTextColor(localResources.getColor(localbcep.jdField_c_of_type_Int));
    }
    int i;
    if ((parambcnz instanceof bcph))
    {
      parambcfr = (bcph)parambcnz;
      if (parambcfr.e() != null) {
        parambcfr.e().setVisibility(8);
      }
      if (localObject1 != null) {
        a((TextView)localObject1, localbcep.h);
      }
      if (localObject2 != null) {
        a((TextView)localObject2, localbcep.i);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (localObject3 != null) {
          ((TextView)localObject3).setMaxLines(1);
        }
        if (this.jdField_a_of_type_Int == 1002)
        {
          parambcfr = parambcnz.a("ActiveEntitySearchResultPresenter_add_troop");
          localObject1 = (Pair)localbcep.a("ActiveEntitySearchResultPresenter_add_troop");
          if ((parambcfr != null) && (localObject1 != null))
          {
            parambcfr.setVisibility(0);
            if ((parambcfr instanceof TextView))
            {
              localObject2 = (TextView)parambcfr;
              ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
              ((TextView)localObject2).setEnabled(((Boolean)((Pair)localObject1).second).booleanValue());
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131755351);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (!((Boolean)((Pair)localObject1).second).booleanValue()) {
                break label1299;
              }
              i = parambcfr.getContext().getResources().getDimensionPixelSize(2131296687);
              ((TextView)localObject2).setPadding(i, 0, i, 0);
              ((TextView)localObject2).setMinWidth(bdep.a(60.0F));
              ((TextView)localObject2).setMinWidth(bdep.a(29.0F));
              ((TextView)localObject2).setBackgroundResource(2130839325);
              if (localObject3 != null)
              {
                ((ViewGroup.LayoutParams)localObject3).height = -2;
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              }
            }
          }
          label462:
          localObject2 = parambcnz.a("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localbcep.a("ActiveEntitySearchResultPresenter_pay_troop");
          parambcfr = (bcfr)localObject1;
          if (localObject1 == null) {
            parambcfr = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (!parambcfr.booleanValue()) {
              break label1352;
            }
            i = 0;
            label513:
            ((View)localObject2).setVisibility(i);
          }
          localObject1 = parambcnz.a("ActiveEntitySearchResultPresenter_hot_troop");
          parambcfr = (Integer)localbcep.a("ActiveEntitySearchResultPresenter_hot_troop");
          if (parambcfr != null) {
            break label1368;
          }
          parambcfr = Integer.valueOf(0);
        }
        break;
      }
    }
    label826:
    label1090:
    label1352:
    label1358:
    label1368:
    for (;;)
    {
      if ((localObject1 instanceof TroopActiveLayout))
      {
        if (parambcfr.intValue() <= 0) {
          break label1358;
        }
        ((View)localObject1).setVisibility(0);
        ((TroopActiveLayout)localObject1).setHotLevel(parambcfr.intValue());
      }
      for (;;)
      {
        parambcfr = parambcnz.a("ActiveEntitySearchResultPresenter_expand_desc");
        localObject1 = localbcep.c();
        if (((parambcfr instanceof FolderTextView)) && (localObject1 != null)) {
          ((FolderTextView)parambcfr).setText(new begp((CharSequence)localObject1, 11, 16));
        }
        super.b(localbcep, parambcnz);
        a(parambcnz.a(), localbcep.a(), true, false);
        a(parambcnz.b(), localbcep.b(), false);
        a(parambcnz.c(), localbcep.c(), false);
        a(parambcnz.d(), localbcep.d(), false);
        if (this.jdField_a_of_type_Int == 1001)
        {
          parambcfr = parambcnz.b();
          parambcfr.setText(localbcep.b());
          bhyu.a(parambcfr, localbcep.f, localbcep.g);
          bhyu.a("0X800B237", localbcep.f, localbcep.g);
        }
        return;
        if (parambcfr.b() != null) {
          parambcfr.b().a(localbcep.jdField_b_of_type_JavaUtilList, localbcep.e, localbcep.jdField_d_of_type_Int - 1, 1);
        }
        if (parambcfr.h() != null)
        {
          if (!TextUtils.isEmpty(localbcep.r)) {
            parambcfr.h().setText(localbcep.r);
          }
        }
        else if ((parambcfr.g() != null) && (parambcfr.f() != null))
        {
          localObject1 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (!((anyw)localObject1).b(localbcep.jdField_b_of_type_JavaLangString)) {
            break label987;
          }
          localbcep.n = 2;
          label873:
          if (localbcep.n != 0) {
            break label1021;
          }
          if (bgpy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbcep.jdField_b_of_type_JavaLangString)) {
            break label1009;
          }
          parambcfr.f().setVisibility(0);
          parambcfr.f().setText(anzj.a(2131689551));
          parambcfr.g().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((parambcfr.b() == null) || (parambcfr.f() == null)) {
            break;
          }
          if (!bgpy.b((QQAppInterface)localObject1, localbcep.jdField_b_of_type_JavaLangString)) {
            break label1090;
          }
          parambcfr.b().setVisibility(0);
          break;
          parambcfr.h().setText("");
          break label826;
          label987:
          if (!((anyw)localObject1).d(localbcep.jdField_b_of_type_JavaLangString)) {
            break label873;
          }
          localbcep.n = 1;
          break label873;
          label1009:
          parambcfr.f().setVisibility(8);
          break label917;
          label1021:
          if (localbcep.n == 1)
          {
            parambcfr.f().setVisibility(8);
            parambcfr.g().setVisibility(0);
            parambcfr.g().setText(2131717458);
          }
          else
          {
            parambcfr.f().setVisibility(8);
            parambcfr.g().setVisibility(0);
            parambcfr.g().setText(2131689982);
          }
        }
        parambcfr.b().setVisibility(8);
        break;
        if (parambcfr.a() != null)
        {
          parambcfr.a().setVisibility(0);
          parambcfr.a().setLabelType(1);
          parambcfr.a().a(localbcep.a);
        }
        if (parambcfr.a != null)
        {
          if ((localbcep.jdField_b_of_type_Long & 0x800) == 0L) {
            break label1186;
          }
          parambcfr.a.setVisibility(0);
        }
        while (parambcfr.b != null)
        {
          parambcfr.b.setVisibility(8);
          break;
          parambcfr.a.setVisibility(8);
        }
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setCompoundDrawablePadding(agej.a(4.0F, localResources));
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841610, 0);
        break;
        a((TextView)localObject1, (TextView)localObject3, localbcep.a(), null);
        break;
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + parambcnz);
        throw new RuntimeException("View is not SearchResultFromNetView. View = " + parambcnz);
        ((TextView)localObject2).setPadding(0, 0, 0, 0);
        ((TextView)localObject2).setMinWidth(0);
        ((TextView)localObject2).setMinHeight(0);
        ((TextView)localObject2).setBackgroundDrawable(null);
        if (localObject3 == null) {
          break label462;
        }
        ((ViewGroup.LayoutParams)localObject3).height = bdep.a(20.0F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break label462;
        i = 8;
        break label513;
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  protected void c(bcfr parambcfr, bcnz parambcnz)
  {
    super.c(parambcfr, parambcnz);
    if ((parambcfr instanceof bcep))
    {
      parambcfr = (bcep)parambcfr;
      if (parambcfr.d() != 1002) {
        break label56;
      }
      parambcnz = parambcnz.a("ActiveEntitySearchResultPresenter_add_troop");
      if (parambcnz != null) {
        parambcnz.setOnClickListener(new bcht(this, parambcfr));
      }
    }
    label56:
    while ((parambcfr.d() != 1001) || (((bcph)parambcnz).f() == null)) {
      return;
    }
    ((bcph)parambcnz).f().setOnClickListener(new bchu(this, parambcfr));
  }
  
  public void d(bcfr parambcfr, bcnz parambcnz)
  {
    if (((parambcfr instanceof bcep)) && (!this.jdField_a_of_type_Boolean) && (a(((bcep)parambcfr).d()))) {
      bcnl.a(parambcfr.a(), parambcfr.b(), parambcnz.a(), ((bcep)parambcfr).u);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchs
 * JD-Core Version:    0.7.0.1
 */