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

public class bboz
  extends bbqp
{
  int jdField_a_of_type_Int;
  private bbir jdField_a_of_type_Bbir;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public bboz(aobu paramaobu, int paramInt)
  {
    super(paramaobu);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public bboz(aobu paramaobu, int paramInt, bbir parambbir)
  {
    super(paramaobu);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bbir = parambbir;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void a(Context paramContext, bblw parambblw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + paramContext + ", model = " + parambblw);
    }
    if ((paramContext == null) || (parambblw == null)) {
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
            begt.a(paramContext, parambblw.jdField_b_of_type_JavaLangString, parambblw.jdField_c_of_type_JavaLangString, i, "", parambblw.p, false, new bbpc(this, parambblw));
            return;
            i = 104;
            break;
            if (parambblw.jdField_d_of_type_Boolean)
            {
              i = 30013;
            }
            else
            {
              i = 30015;
              continue;
              if (parambblw.jdField_d_of_type_Boolean) {
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
      localDrawable = paramImageView2.getResources().getDrawable(2130842295);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130842322);
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
      f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + afur.a(4.0F, paramTextView1.getContext().getResources());
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding(afur.a(2.0F, paramTextView1.getContext().getResources()), 0, afur.a(2.0F, paramTextView1.getContext().getResources()), 0);
    }
    for (;;)
    {
      float f2 = i - afur.a(89.0F, paramTextView1.getContext().getResources());
      if (f1 != 0.0F) {}
      for (f1 = f2 - (f1 + afur.a(6.0F, paramTextView1.getContext().getResources()));; f1 = f2)
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
      paramString.setBounds(0, 0, afur.a(14.0F, localResources), afur.a(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(afur.a(4.0F, localResources));
      paramTextView.setCompoundDrawables(null, null, paramString, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbir != null) {
      this.jdField_a_of_type_Bbir.notifyDataSetChanged();
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
  
  public void a(bbmy parambbmy, bbvg parambbvg)
  {
    Object localObject = parambbvg.b();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      bblw localbblw;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(parambbmy instanceof bblw)) || (!(parambbvg instanceof bbwo))) {
          break label468;
        }
        localbblw = (bblw)parambbmy;
        bbwo localbbwo = (bbwo)parambbvg;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean)
        {
          localLayoutParams.height = afur.a(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localbbwo.c() != null) {
            localbbwo.c().setLayoutParams(localLayoutParams);
          }
          if ((localbblw.d() == 1001) || (localbblw.d() == 1002)) {
            break label459;
          }
          int i = parambbvg.a().getResources().getDimensionPixelSize(2131297389);
          parambbmy = URLDrawable.URLDrawableOptions.obtain();
          parambbmy.mRequestWidth = i;
          parambbmy.mRequestHeight = i;
          if (localbblw.jdField_b_of_type_Boolean) {
            parambbmy.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            parambbmy.mLoadingDrawable = ((Drawable)localObject);
            parambbmy.mFailedDrawable = ((Drawable)localObject);
          }
          parambbmy = URLDrawable.getDrawable(localbblw.c(), parambbmy);
          if (localbblw.jdField_b_of_type_Boolean) {
            parambbmy.setDecodeHandler(bgey.a);
          }
          if ((parambbmy.getStatus() != 1) && (parambbmy.getStatus() != 0)) {
            parambbmy.restartDownload();
          }
          parambbvg.b().setImageDrawable(parambbmy);
          if ((parambbvg.b() == null) || (localbbwo.c() == null)) {
            break;
          }
          a(parambbvg.b(), localbbwo.c(), localbblw.jdField_b_of_type_Int);
          return;
        }
      }
      catch (Exception parambbmy)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + parambbmy.toString());
        return;
      }
      if ((localbblw.d() == 8192) || (localbblw.d() == 16) || (localbblw.d() == 8))
      {
        localLayoutParams.height = afur.a(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localbblw.d() == 1001)
      {
        localLayoutParams.height = afur.a(60.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if ((localbblw.d() != 1024) && (localbblw.d() != 1002))
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131298307);
        continue;
        label459:
        super.a(parambbmy, parambbvg);
      }
    }
    label468:
    super.a(parambbmy, parambbvg);
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
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    if (!(parambbmy instanceof bblw))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + parambbmy);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + parambbmy);
    }
    bblw localbblw = (bblw)parambbmy;
    this.jdField_a_of_type_Int = localbblw.d();
    Object localObject1 = parambbvg.a();
    Object localObject2 = parambbvg.b();
    Object localObject3 = parambbvg.c();
    Resources localResources = parambbvg.a().getContext().getResources();
    if ((localObject3 != null) && (localbblw.jdField_c_of_type_Int != -1)) {
      ((TextView)localObject3).setTextColor(localResources.getColor(localbblw.jdField_c_of_type_Int));
    }
    int i;
    if ((parambbvg instanceof bbwo))
    {
      parambbmy = (bbwo)parambbvg;
      if (parambbmy.e() != null) {
        parambbmy.e().setVisibility(8);
      }
      if (localObject1 != null) {
        a((TextView)localObject1, localbblw.h);
      }
      if (localObject2 != null) {
        a((TextView)localObject2, localbblw.i);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (localObject3 != null) {
          ((TextView)localObject3).setMaxLines(1);
        }
        if (this.jdField_a_of_type_Int == 1002)
        {
          parambbmy = parambbvg.a("ActiveEntitySearchResultPresenter_add_troop");
          localObject1 = (Pair)localbblw.a("ActiveEntitySearchResultPresenter_add_troop");
          if ((parambbmy != null) && (localObject1 != null))
          {
            parambbmy.setVisibility(0);
            if ((parambbmy instanceof TextView))
            {
              localObject2 = (TextView)parambbmy;
              ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
              ((TextView)localObject2).setEnabled(((Boolean)((Pair)localObject1).second).booleanValue());
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131755350);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (!((Boolean)((Pair)localObject1).second).booleanValue()) {
                break label1242;
              }
              i = parambbmy.getContext().getResources().getDimensionPixelSize(2131296675);
              ((TextView)localObject2).setPadding(i, 0, i, 0);
              ((TextView)localObject2).setMinWidth(bclx.a(60.0F));
              ((TextView)localObject2).setMinWidth(bclx.a(29.0F));
              ((TextView)localObject2).setBackgroundResource(2130839317);
              if (localObject3 != null)
              {
                ((ViewGroup.LayoutParams)localObject3).height = -2;
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              }
            }
          }
          label462:
          localObject2 = parambbvg.a("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localbblw.a("ActiveEntitySearchResultPresenter_pay_troop");
          parambbmy = (bbmy)localObject1;
          if (localObject1 == null) {
            parambbmy = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (!parambbmy.booleanValue()) {
              break label1295;
            }
            i = 0;
            label513:
            ((View)localObject2).setVisibility(i);
          }
          localObject1 = parambbvg.a("ActiveEntitySearchResultPresenter_hot_troop");
          parambbmy = (Integer)localbblw.a("ActiveEntitySearchResultPresenter_hot_troop");
          if (parambbmy != null) {
            break label1311;
          }
          parambbmy = Integer.valueOf(0);
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
        if (parambbmy.intValue() <= 0) {
          break label1301;
        }
        ((View)localObject1).setVisibility(0);
        ((TroopActiveLayout)localObject1).setHotLevel(parambbmy.intValue());
      }
      for (;;)
      {
        parambbmy = parambbvg.a("ActiveEntitySearchResultPresenter_expand_desc");
        localObject1 = localbblw.c();
        if (((parambbmy instanceof FolderTextView)) && (localObject1 != null)) {
          ((FolderTextView)parambbmy).setText(new bdnt((CharSequence)localObject1, 11, 16));
        }
        super.b(localbblw, parambbvg);
        a(parambbvg.a(), localbblw.a(), true, false);
        a(parambbvg.b(), localbblw.b(), false);
        a(parambbvg.c(), localbblw.c(), false);
        a(parambbvg.d(), localbblw.d(), false);
        return;
        if (parambbmy.b() != null) {
          parambbmy.b().a(localbblw.jdField_b_of_type_JavaUtilList, localbblw.e, localbblw.jdField_d_of_type_Int - 1, 1);
        }
        if (parambbmy.h() != null)
        {
          if (!TextUtils.isEmpty(localbblw.r)) {
            parambbmy.h().setText(localbblw.r);
          }
        }
        else if ((parambbmy.g() != null) && (parambbmy.f() != null))
        {
          localObject1 = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (!((anmw)localObject1).b(localbblw.jdField_b_of_type_JavaLangString)) {
            break label930;
          }
          localbblw.l = 2;
          label816:
          if (localbblw.l != 0) {
            break label964;
          }
          if (bfpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbblw.jdField_b_of_type_JavaLangString)) {
            break label952;
          }
          parambbmy.f().setVisibility(0);
          parambbmy.f().setText(anni.a(2131689550));
          label860:
          parambbmy.g().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((parambbmy.b() == null) || (parambbmy.f() == null)) {
            break;
          }
          if (!bfpx.b((QQAppInterface)localObject1, localbblw.jdField_b_of_type_JavaLangString)) {
            break label1033;
          }
          parambbmy.b().setVisibility(0);
          break;
          parambbmy.h().setText("");
          break label769;
          label930:
          if (!((anmw)localObject1).d(localbblw.jdField_b_of_type_JavaLangString)) {
            break label816;
          }
          localbblw.l = 1;
          break label816;
          label952:
          parambbmy.f().setVisibility(8);
          break label860;
          label964:
          if (localbblw.l == 1)
          {
            parambbmy.f().setVisibility(8);
            parambbmy.g().setVisibility(0);
            parambbmy.g().setText(2131717330);
          }
          else
          {
            parambbmy.f().setVisibility(8);
            parambbmy.g().setVisibility(0);
            parambbmy.g().setText(2131689975);
          }
        }
        parambbmy.b().setVisibility(8);
        break;
        if (parambbmy.a() != null)
        {
          parambbmy.a().setVisibility(0);
          parambbmy.a().setLabelType(1);
          parambbmy.a().a(localbblw.a);
        }
        if (parambbmy.a != null)
        {
          if ((localbblw.jdField_b_of_type_Long & 0x800) == 0L) {
            break label1129;
          }
          parambbmy.a.setVisibility(0);
        }
        while (parambbmy.b != null)
        {
          parambbmy.b.setVisibility(8);
          break;
          label1129:
          parambbmy.a.setVisibility(8);
        }
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setCompoundDrawablePadding(afur.a(4.0F, localResources));
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841600, 0);
        break;
        a((TextView)localObject1, (TextView)localObject3, localbblw.a(), null);
        break;
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + parambbvg);
        throw new RuntimeException("View is not SearchResultFromNetView. View = " + parambbvg);
        label1242:
        ((TextView)localObject2).setPadding(0, 0, 0, 0);
        ((TextView)localObject2).setMinWidth(0);
        ((TextView)localObject2).setMinHeight(0);
        ((TextView)localObject2).setBackgroundDrawable(null);
        if (localObject3 == null) {
          break label462;
        }
        ((ViewGroup.LayoutParams)localObject3).height = bclx.a(20.0F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break label462;
        i = 8;
        break label513;
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  protected void c(bbmy parambbmy, bbvg parambbvg)
  {
    super.c(parambbmy, parambbvg);
    if ((parambbmy instanceof bblw))
    {
      parambbmy = (bblw)parambbmy;
      if (parambbmy.d() != 1002) {
        break label56;
      }
      parambbvg = parambbvg.a("ActiveEntitySearchResultPresenter_add_troop");
      if (parambbvg != null) {
        parambbvg.setOnClickListener(new bbpa(this, parambbmy));
      }
    }
    label56:
    while ((parambbmy.d() != 1001) || (((bbwo)parambbvg).f() == null)) {
      return;
    }
    ((bbwo)parambbvg).f().setOnClickListener(new bbpb(this, parambbmy));
  }
  
  public void d(bbmy parambbmy, bbvg parambbvg)
  {
    if (((parambbmy instanceof bblw)) && (!this.jdField_a_of_type_Boolean) && (a(((bblw)parambbmy).d()))) {
      bbus.a(parambbmy.a(), parambbmy.b(), parambbvg.a(), ((bblw)parambbmy).s);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboz
 * JD-Core Version:    0.7.0.1
 */