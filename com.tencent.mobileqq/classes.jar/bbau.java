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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;

public class bbau
  extends bbck
{
  int jdField_a_of_type_Int;
  private baup jdField_a_of_type_Baup;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public bbau(FaceDecoder paramFaceDecoder, int paramInt)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public bbau(FaceDecoder paramFaceDecoder, int paramInt, baup parambaup)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Baup = parambaup;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void a(Context paramContext, baxr parambaxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + paramContext + ", model = " + parambaxr);
    }
    if ((paramContext == null) || (parambaxr == null)) {
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
            bdoi.a(paramContext, parambaxr.jdField_b_of_type_JavaLangString, parambaxr.jdField_c_of_type_JavaLangString, i, "", parambaxr.p, false, new bbax(this, parambaxr));
            return;
            i = 104;
            break;
            if (parambaxr.jdField_d_of_type_Boolean)
            {
              i = 30013;
            }
            else
            {
              i = 30015;
              continue;
              if (parambaxr.jdField_d_of_type_Boolean) {
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
      localDrawable = paramImageView2.getResources().getDrawable(2130842349);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130842376);
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
      f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + AIOUtils.dp2px(4.0F, paramTextView1.getContext().getResources());
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding(AIOUtils.dp2px(2.0F, paramTextView1.getContext().getResources()), 0, AIOUtils.dp2px(2.0F, paramTextView1.getContext().getResources()), 0);
    }
    for (;;)
    {
      float f2 = i - AIOUtils.dp2px(89.0F, paramTextView1.getContext().getResources());
      if (f1 != 0.0F) {}
      for (f1 = f2 - (f1 + AIOUtils.dp2px(6.0F, paramTextView1.getContext().getResources()));; f1 = f2)
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
      paramString.setBounds(0, 0, AIOUtils.dp2px(14.0F, localResources), AIOUtils.dp2px(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(AIOUtils.dp2px(4.0F, localResources));
      paramTextView.setCompoundDrawables(null, null, paramString, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Baup != null) {
      this.jdField_a_of_type_Baup.notifyDataSetChanged();
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
  
  public void a(bayt parambayt, bbhb parambbhb)
  {
    Object localObject = parambbhb.b();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      baxr localbaxr;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(parambayt instanceof baxr)) || (!(parambbhb instanceof bbij))) {
          break label468;
        }
        localbaxr = (baxr)parambayt;
        bbij localbbij = (bbij)parambbhb;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean)
        {
          localLayoutParams.height = AIOUtils.dp2px(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localbbij.c() != null) {
            localbbij.c().setLayoutParams(localLayoutParams);
          }
          if ((localbaxr.d() == 1001) || (localbaxr.d() == 1002)) {
            break label459;
          }
          int i = parambbhb.a().getResources().getDimensionPixelSize(2131297456);
          parambayt = URLDrawable.URLDrawableOptions.obtain();
          parambayt.mRequestWidth = i;
          parambayt.mRequestHeight = i;
          if (localbaxr.jdField_b_of_type_Boolean) {
            parambayt.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            parambayt.mLoadingDrawable = ((Drawable)localObject);
            parambayt.mFailedDrawable = ((Drawable)localObject);
          }
          parambayt = URLDrawable.getDrawable(localbaxr.c(), parambayt);
          if (localbaxr.jdField_b_of_type_Boolean) {
            parambayt.setDecodeHandler(bfol.a);
          }
          if ((parambayt.getStatus() != 1) && (parambayt.getStatus() != 0)) {
            parambayt.restartDownload();
          }
          parambbhb.b().setImageDrawable(parambayt);
          if ((parambbhb.b() == null) || (localbbij.c() == null)) {
            break;
          }
          a(parambbhb.b(), localbbij.c(), localbaxr.jdField_b_of_type_Int);
          return;
        }
      }
      catch (Exception parambayt)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + parambayt.toString());
        return;
      }
      if ((localbaxr.d() == 8192) || (localbaxr.d() == 16) || (localbaxr.d() == 8))
      {
        localLayoutParams.height = AIOUtils.dp2px(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localbaxr.d() == 1001)
      {
        localLayoutParams.height = AIOUtils.dp2px(60.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if ((localbaxr.d() != 1024) && (localbaxr.d() != 1002))
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131298385);
        continue;
        label459:
        super.a(parambayt, parambbhb);
      }
    }
    label468:
    super.a(parambayt, parambbhb);
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
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    if (!(parambayt instanceof baxr))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + parambayt);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + parambayt);
    }
    baxr localbaxr = (baxr)parambayt;
    this.jdField_a_of_type_Int = localbaxr.d();
    Object localObject1 = parambbhb.a();
    Object localObject2 = parambbhb.b();
    Object localObject3 = parambbhb.c();
    Resources localResources = parambbhb.a().getContext().getResources();
    if ((localObject3 != null) && (localbaxr.jdField_c_of_type_Int != -1)) {
      ((TextView)localObject3).setTextColor(localResources.getColor(localbaxr.jdField_c_of_type_Int));
    }
    int i;
    if ((parambbhb instanceof bbij))
    {
      parambayt = (bbij)parambbhb;
      if (parambayt.e() != null) {
        parambayt.e().setVisibility(8);
      }
      if (localObject1 != null) {
        a((TextView)localObject1, localbaxr.h);
      }
      if (localObject2 != null) {
        a((TextView)localObject2, localbaxr.i);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (localObject3 != null) {
          ((TextView)localObject3).setMaxLines(1);
        }
        if (this.jdField_a_of_type_Int == 1002)
        {
          parambayt = parambbhb.a("ActiveEntitySearchResultPresenter_add_troop");
          localObject1 = (Pair)localbaxr.a("ActiveEntitySearchResultPresenter_add_troop");
          if ((parambayt != null) && (localObject1 != null))
          {
            parambayt.setVisibility(0);
            if ((parambayt instanceof TextView))
            {
              localObject2 = (TextView)parambayt;
              ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
              ((TextView)localObject2).setEnabled(((Boolean)((Pair)localObject1).second).booleanValue());
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131755352);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (!((Boolean)((Pair)localObject1).second).booleanValue()) {
                break label1304;
              }
              i = parambayt.getContext().getResources().getDimensionPixelSize(2131296742);
              ((TextView)localObject2).setPadding(i, 0, i, 0);
              ((TextView)localObject2).setMinWidth(ScreenUtil.dip2px(60.0F));
              ((TextView)localObject2).setMinWidth(ScreenUtil.dip2px(29.0F));
              ((TextView)localObject2).setBackgroundResource(2130839360);
              if (localObject3 != null)
              {
                ((ViewGroup.LayoutParams)localObject3).height = -2;
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              }
            }
          }
          label462:
          localObject2 = parambbhb.a("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localbaxr.a("ActiveEntitySearchResultPresenter_pay_troop");
          parambayt = (bayt)localObject1;
          if (localObject1 == null) {
            parambayt = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (!parambayt.booleanValue()) {
              break label1357;
            }
            i = 0;
            label513:
            ((View)localObject2).setVisibility(i);
          }
          localObject1 = parambbhb.a("ActiveEntitySearchResultPresenter_hot_troop");
          parambayt = (Integer)localbaxr.a("ActiveEntitySearchResultPresenter_hot_troop");
          if (parambayt != null) {
            break label1373;
          }
          parambayt = Integer.valueOf(0);
        }
        break;
      }
    }
    label831:
    label1095:
    label1357:
    label1363:
    label1373:
    for (;;)
    {
      if ((localObject1 instanceof TroopActiveLayout))
      {
        if (parambayt.intValue() <= 0) {
          break label1363;
        }
        ((View)localObject1).setVisibility(0);
        ((TroopActiveLayout)localObject1).setHotLevel(parambayt.intValue());
      }
      for (;;)
      {
        parambayt = parambbhb.a("ActiveEntitySearchResultPresenter_expand_desc");
        localObject1 = localbaxr.c();
        if (((parambayt instanceof FolderTextView)) && (localObject1 != null)) {
          ((FolderTextView)parambayt).setText(new QQText((CharSequence)localObject1, 11, 16));
        }
        super.b(localbaxr, parambbhb);
        a(parambbhb.a(), localbaxr.a(), true, false);
        a(parambbhb.b(), localbaxr.b(), false);
        a(parambbhb.c(), localbaxr.c(), false);
        a(parambbhb.d(), localbaxr.d(), false);
        if (this.jdField_a_of_type_Int == 1001)
        {
          parambayt = parambbhb.b();
          parambayt.setText(localbaxr.b());
          bgff.a(parambayt, localbaxr.f, localbaxr.g, 2131167093, 17);
          bgff.a("0X800B237", localbaxr.f, localbaxr.g);
        }
        return;
        if (parambayt.b() != null) {
          parambayt.b().a(localbaxr.jdField_b_of_type_JavaUtilList, localbaxr.e, localbaxr.jdField_d_of_type_Int - 1, 1);
        }
        if (parambayt.h() != null)
        {
          if (!TextUtils.isEmpty(localbaxr.r)) {
            parambayt.h().setText(localbaxr.r);
          }
        }
        else if ((parambayt.g() != null) && (parambayt.f() != null))
        {
          localObject1 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (!((amsw)localObject1).b(localbaxr.jdField_b_of_type_JavaLangString)) {
            break label992;
          }
          localbaxr.n = 2;
          label878:
          if (localbaxr.n != 0) {
            break label1026;
          }
          if (bezm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbaxr.jdField_b_of_type_JavaLangString)) {
            break label1014;
          }
          parambayt.f().setVisibility(0);
          parambayt.f().setText(amtj.a(2131689550));
          parambayt.g().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((parambayt.b() == null) || (parambayt.f() == null)) {
            break;
          }
          if (!bezm.b((QQAppInterface)localObject1, localbaxr.jdField_b_of_type_JavaLangString)) {
            break label1095;
          }
          parambayt.b().setVisibility(0);
          break;
          parambayt.h().setText("");
          break label831;
          label992:
          if (!((amsw)localObject1).d(localbaxr.jdField_b_of_type_JavaLangString)) {
            break label878;
          }
          localbaxr.n = 1;
          break label878;
          label1014:
          parambayt.f().setVisibility(8);
          break label922;
          if (localbaxr.n == 1)
          {
            parambayt.f().setVisibility(8);
            parambayt.g().setVisibility(0);
            parambayt.g().setText(2131717690);
          }
          else
          {
            parambayt.f().setVisibility(8);
            parambayt.g().setVisibility(0);
            parambayt.g().setText(2131690001);
          }
        }
        parambayt.b().setVisibility(8);
        break;
        if (parambayt.a() != null)
        {
          parambayt.a().setVisibility(0);
          parambayt.a().setLabelType(1);
          parambayt.a().a(localbaxr.a);
        }
        if (parambayt.a != null)
        {
          if ((localbaxr.jdField_b_of_type_Long & 0x800) == 0L) {
            break label1191;
          }
          parambayt.a.setVisibility(0);
        }
        while (parambayt.b != null)
        {
          parambayt.b.setVisibility(8);
          break;
          parambayt.a.setVisibility(8);
        }
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setCompoundDrawablePadding(AIOUtils.dp2px(4.0F, localResources));
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841646, 0);
        break;
        a((TextView)localObject1, (TextView)localObject3, localbaxr.a(), null);
        break;
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + parambbhb);
        throw new RuntimeException("View is not SearchResultFromNetView. View = " + parambbhb);
        ((TextView)localObject2).setPadding(0, 0, 0, 0);
        ((TextView)localObject2).setMinWidth(0);
        ((TextView)localObject2).setMinHeight(0);
        ((TextView)localObject2).setBackgroundDrawable(null);
        if (localObject3 == null) {
          break label462;
        }
        ((ViewGroup.LayoutParams)localObject3).height = ScreenUtil.dip2px(20.0F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break label462;
        i = 8;
        break label513;
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  protected void c(bayt parambayt, bbhb parambbhb)
  {
    super.c(parambayt, parambbhb);
    if ((parambayt instanceof baxr))
    {
      parambayt = (baxr)parambayt;
      if (parambayt.d() != 1002) {
        break label56;
      }
      parambbhb = parambbhb.a("ActiveEntitySearchResultPresenter_add_troop");
      if (parambbhb != null) {
        parambbhb.setOnClickListener(new bbav(this, parambayt));
      }
    }
    label56:
    while ((parambayt.d() != 1001) || (((bbij)parambbhb).f() == null)) {
      return;
    }
    ((bbij)parambbhb).f().setOnClickListener(new bbaw(this, parambayt));
  }
  
  public void d(bayt parambayt, bbhb parambbhb)
  {
    if (((parambayt instanceof baxr)) && (!this.jdField_a_of_type_Boolean) && (a(((baxr)parambayt).d()))) {
      bbgn.a(parambayt.a(), parambayt.b(), parambbhb.a(), ((baxr)parambayt).u);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbau
 * JD-Core Version:    0.7.0.1
 */