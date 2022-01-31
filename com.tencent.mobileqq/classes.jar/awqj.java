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

public class awqj
  extends awsa
{
  int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new awqk(this);
  private awkh jdField_a_of_type_Awkh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public awqj(baxy parambaxy, int paramInt)
  {
    super(parambaxy);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public awqj(baxy parambaxy, int paramInt, awkh paramawkh)
  {
    super(parambaxy);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Awkh = paramawkh;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void a(Context paramContext, awng paramawng)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + paramContext + ", model = " + paramawng);
    }
    if ((paramContext == null) || (paramawng == null)) {
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
          azdn.a(paramContext, paramawng.jdField_b_of_type_JavaLangString, paramawng.jdField_c_of_type_JavaLangString, i, "", paramawng.jdField_k_of_type_JavaLangString, false, new awqn(this, paramawng));
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
      f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + actj.a(4.0F, paramTextView1.getContext().getResources());
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding(actj.a(2.0F, paramTextView1.getContext().getResources()), 0, actj.a(2.0F, paramTextView1.getContext().getResources()), 0);
    }
    for (;;)
    {
      float f2 = i - actj.a(89.0F, paramTextView1.getContext().getResources());
      if (f1 != 0.0F) {}
      for (f1 = f2 - (f1 + actj.a(6.0F, paramTextView1.getContext().getResources()));; f1 = f2)
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
      paramString.setBounds(0, 0, actj.a(14.0F, localResources), actj.a(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(actj.a(4.0F, localResources));
      paramTextView.setCompoundDrawables(null, null, paramString, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Awkh != null) {
      this.jdField_a_of_type_Awkh.notifyDataSetChanged();
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
  
  public void a(awoi paramawoi, awwr paramawwr)
  {
    Object localObject = paramawwr.b();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      awng localawng;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(paramawoi instanceof awng)) || (!(paramawwr instanceof awxz))) {
          break label468;
        }
        localawng = (awng)paramawoi;
        awxz localawxz = (awxz)paramawwr;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean)
        {
          localLayoutParams.height = actj.a(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localawxz.c() != null) {
            localawxz.c().setLayoutParams(localLayoutParams);
          }
          if ((localawng.d() == 1001) || (localawng.d() == 1002)) {
            break label459;
          }
          int i = paramawwr.a().getResources().getDimensionPixelSize(2131297291);
          paramawoi = URLDrawable.URLDrawableOptions.obtain();
          paramawoi.mRequestWidth = i;
          paramawoi.mRequestHeight = i;
          if (localawng.jdField_b_of_type_Boolean) {
            paramawoi.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            paramawoi.mLoadingDrawable = ((Drawable)localObject);
            paramawoi.mFailedDrawable = ((Drawable)localObject);
          }
          paramawoi = URLDrawable.getDrawable(localawng.c(), paramawoi);
          if (localawng.jdField_b_of_type_Boolean) {
            paramawoi.setDecodeHandler(bavw.a);
          }
          if ((paramawoi.getStatus() != 1) && (paramawoi.getStatus() != 0)) {
            paramawoi.restartDownload();
          }
          paramawwr.b().setImageDrawable(paramawoi);
          if ((paramawwr.b() == null) || (localawxz.c() == null)) {
            break;
          }
          a(paramawwr.b(), localawxz.c(), localawng.jdField_b_of_type_Int);
          return;
        }
      }
      catch (Exception paramawoi)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + paramawoi.toString());
        return;
      }
      if ((localawng.d() == 8192) || (localawng.d() == 16) || (localawng.d() == 8))
      {
        localLayoutParams.height = actj.a(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localawng.d() == 1001)
      {
        localLayoutParams.height = actj.a(60.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if ((localawng.d() != 1024) && (localawng.d() != 1002))
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131298200);
        continue;
        label459:
        super.a(paramawoi, paramawwr);
      }
    }
    label468:
    super.a(paramawoi, paramawwr);
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
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    if (!(paramawoi instanceof awng))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + paramawoi);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + paramawoi);
    }
    awng localawng = (awng)paramawoi;
    this.jdField_a_of_type_Int = localawng.d();
    Object localObject1 = paramawwr.a();
    Object localObject2 = paramawwr.b();
    Object localObject3 = paramawwr.c();
    Resources localResources = paramawwr.a().getContext().getResources();
    if ((localObject3 != null) && (localawng.jdField_c_of_type_Int != -1)) {
      ((TextView)localObject3).setTextColor(localResources.getColor(localawng.jdField_c_of_type_Int));
    }
    int i;
    if ((paramawwr instanceof awxz))
    {
      paramawoi = (awxz)paramawwr;
      if (paramawoi.e() != null) {
        paramawoi.e().setVisibility(8);
      }
      if (localObject1 != null) {
        a((TextView)localObject1, localawng.h);
      }
      if (localObject2 != null) {
        a((TextView)localObject2, localawng.i);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (localObject3 != null) {
          ((TextView)localObject3).setMaxLines(1);
        }
        if (this.jdField_a_of_type_Int == 1002)
        {
          paramawoi = paramawwr.a("ActiveEntitySearchResultPresenter_add_troop");
          localObject1 = (Pair)localawng.a("ActiveEntitySearchResultPresenter_add_troop");
          if ((paramawoi != null) && (localObject1 != null))
          {
            paramawoi.setVisibility(0);
            if ((paramawoi instanceof TextView))
            {
              localObject2 = (TextView)paramawoi;
              ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
              ((TextView)localObject2).setEnabled(((Boolean)((Pair)localObject1).second).booleanValue());
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131755338);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (!((Boolean)((Pair)localObject1).second).booleanValue()) {
                break label1242;
              }
              i = paramawoi.getContext().getResources().getDimensionPixelSize(2131296616);
              ((TextView)localObject2).setPadding(i, 0, i, 0);
              ((TextView)localObject2).setMinWidth(axlk.a(60.0F));
              ((TextView)localObject2).setMinWidth(axlk.a(29.0F));
              ((TextView)localObject2).setBackgroundResource(2130839060);
              if (localObject3 != null)
              {
                ((ViewGroup.LayoutParams)localObject3).height = -2;
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              }
            }
          }
          label462:
          localObject2 = paramawwr.a("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localawng.a("ActiveEntitySearchResultPresenter_pay_troop");
          paramawoi = (awoi)localObject1;
          if (localObject1 == null) {
            paramawoi = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (!paramawoi.booleanValue()) {
              break label1295;
            }
            i = 0;
            label513:
            ((View)localObject2).setVisibility(i);
          }
          localObject1 = paramawwr.a("ActiveEntitySearchResultPresenter_hot_troop");
          paramawoi = (Integer)localawng.a("ActiveEntitySearchResultPresenter_hot_troop");
          if (paramawoi != null) {
            break label1311;
          }
          paramawoi = Integer.valueOf(0);
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
        if (paramawoi.intValue() <= 0) {
          break label1301;
        }
        ((View)localObject1).setVisibility(0);
        ((TroopActiveLayout)localObject1).setHotLevel(paramawoi.intValue());
      }
      for (;;)
      {
        paramawoi = paramawwr.a("ActiveEntitySearchResultPresenter_expand_desc");
        localObject1 = localawng.c();
        if (((paramawoi instanceof FolderTextView)) && (localObject1 != null)) {
          ((FolderTextView)paramawoi).setText(new aykk((CharSequence)localObject1, 11, 16));
        }
        super.b(localawng, paramawwr);
        a(paramawwr.a(), localawng.a(), true, false);
        a(paramawwr.b(), localawng.b(), false);
        a(paramawwr.c(), localawng.c(), false);
        a(paramawwr.d(), localawng.d(), false);
        return;
        if (paramawoi.b() != null) {
          paramawoi.b().a(localawng.jdField_b_of_type_JavaUtilList, localawng.e, localawng.d - 1, 1);
        }
        if (paramawoi.h() != null)
        {
          if (!TextUtils.isEmpty(localawng.m)) {
            paramawoi.h().setText(localawng.m);
          }
        }
        else if ((paramawoi.g() != null) && (paramawoi.f() != null))
        {
          localObject1 = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (!((ajxl)localObject1).b(localawng.jdField_b_of_type_JavaLangString)) {
            break label930;
          }
          localawng.jdField_k_of_type_Int = 2;
          label816:
          if (localawng.jdField_k_of_type_Int != 0) {
            break label964;
          }
          if (bail.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localawng.jdField_b_of_type_JavaLangString)) {
            break label952;
          }
          paramawoi.f().setVisibility(0);
          paramawoi.f().setText(ajya.a(2131689628));
          label860:
          paramawoi.g().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((paramawoi.b() == null) || (paramawoi.f() == null)) {
            break;
          }
          if (!bail.b((QQAppInterface)localObject1, localawng.jdField_b_of_type_JavaLangString)) {
            break label1033;
          }
          paramawoi.b().setVisibility(0);
          break;
          paramawoi.h().setText("");
          break label769;
          label930:
          if (!((ajxl)localObject1).d(localawng.jdField_b_of_type_JavaLangString)) {
            break label816;
          }
          localawng.jdField_k_of_type_Int = 1;
          break label816;
          label952:
          paramawoi.f().setVisibility(8);
          break label860;
          label964:
          if (localawng.jdField_k_of_type_Int == 1)
          {
            paramawoi.f().setVisibility(8);
            paramawoi.g().setVisibility(0);
            paramawoi.g().setText(2131718754);
          }
          else
          {
            paramawoi.f().setVisibility(8);
            paramawoi.g().setVisibility(0);
            paramawoi.g().setText(2131690035);
          }
        }
        paramawoi.b().setVisibility(8);
        break;
        if (paramawoi.a() != null)
        {
          paramawoi.a().setVisibility(0);
          paramawoi.a().setLabelType(1);
          paramawoi.a().a(localawng.a);
        }
        if (paramawoi.a != null)
        {
          if ((localawng.jdField_b_of_type_Long & 0x800) == 0L) {
            break label1129;
          }
          paramawoi.a.setVisibility(0);
        }
        while (paramawoi.b != null)
        {
          paramawoi.b.setVisibility(8);
          break;
          label1129:
          paramawoi.a.setVisibility(8);
        }
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setCompoundDrawablePadding(actj.a(4.0F, localResources));
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841176, 0);
        break;
        a((TextView)localObject1, (TextView)localObject3, localawng.a(), null);
        break;
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + paramawwr);
        throw new RuntimeException("View is not SearchResultFromNetView. View = " + paramawwr);
        label1242:
        ((TextView)localObject2).setPadding(0, 0, 0, 0);
        ((TextView)localObject2).setMinWidth(0);
        ((TextView)localObject2).setMinHeight(0);
        ((TextView)localObject2).setBackgroundDrawable(null);
        if (localObject3 == null) {
          break label462;
        }
        ((ViewGroup.LayoutParams)localObject3).height = axlk.a(20.0F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break label462;
        i = 8;
        break label513;
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  protected void c(awoi paramawoi, awwr paramawwr)
  {
    super.c(paramawoi, paramawwr);
    if ((paramawoi instanceof awng))
    {
      paramawoi = (awng)paramawoi;
      if (paramawoi.d() != 1002) {
        break label56;
      }
      paramawwr = paramawwr.a("ActiveEntitySearchResultPresenter_add_troop");
      if (paramawwr != null) {
        paramawwr.setOnClickListener(new awql(this, paramawoi));
      }
    }
    label56:
    while ((paramawoi.d() != 1001) || (((awxz)paramawwr).f() == null)) {
      return;
    }
    ((awxz)paramawwr).f().setOnClickListener(new awqm(this, paramawoi));
  }
  
  public void d(awoi paramawoi, awwr paramawwr)
  {
    if (((paramawoi instanceof awng)) && (!this.jdField_a_of_type_Boolean) && (a(((awng)paramawoi).d()))) {
      awwd.a(paramawoi.a(), paramawoi.b(), paramawwr.a(), ((awng)paramawoi).r);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqj
 * JD-Core Version:    0.7.0.1
 */