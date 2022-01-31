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

public class aylm
  extends aynd
{
  int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ayln(this);
  private ayfh jdField_a_of_type_Ayfh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public aylm(bcws parambcws, int paramInt)
  {
    super(parambcws);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public aylm(bcws parambcws, int paramInt, ayfh paramayfh)
  {
    super(parambcws);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ayfh = paramayfh;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void a(Context paramContext, ayij paramayij)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + paramContext + ", model = " + paramayij);
    }
    if ((paramContext == null) || (paramayij == null)) {
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
          bbbm.a(paramContext, paramayij.jdField_b_of_type_JavaLangString, paramayij.jdField_c_of_type_JavaLangString, i, "", paramayij.jdField_k_of_type_JavaLangString, false, new aylq(this, paramayij));
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
      localDrawable = paramImageView2.getResources().getDrawable(2130841973);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130842000);
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
      f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + aekt.a(4.0F, paramTextView1.getContext().getResources());
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding(aekt.a(2.0F, paramTextView1.getContext().getResources()), 0, aekt.a(2.0F, paramTextView1.getContext().getResources()), 0);
    }
    for (;;)
    {
      float f2 = i - aekt.a(89.0F, paramTextView1.getContext().getResources());
      if (f1 != 0.0F) {}
      for (f1 = f2 - (f1 + aekt.a(6.0F, paramTextView1.getContext().getResources()));; f1 = f2)
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
      paramString.setBounds(0, 0, aekt.a(14.0F, localResources), aekt.a(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(aekt.a(4.0F, localResources));
      paramTextView.setCompoundDrawables(null, null, paramString, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ayfh != null) {
      this.jdField_a_of_type_Ayfh.notifyDataSetChanged();
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
  
  public void a(ayjl paramayjl, ayru paramayru)
  {
    Object localObject = paramayru.b();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      ayij localayij;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(paramayjl instanceof ayij)) || (!(paramayru instanceof aytc))) {
          break label468;
        }
        localayij = (ayij)paramayjl;
        aytc localaytc = (aytc)paramayru;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean)
        {
          localLayoutParams.height = aekt.a(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localaytc.c() != null) {
            localaytc.c().setLayoutParams(localLayoutParams);
          }
          if ((localayij.d() == 1001) || (localayij.d() == 1002)) {
            break label459;
          }
          int i = paramayru.a().getResources().getDimensionPixelSize(2131297310);
          paramayjl = URLDrawable.URLDrawableOptions.obtain();
          paramayjl.mRequestWidth = i;
          paramayjl.mRequestHeight = i;
          if (localayij.jdField_b_of_type_Boolean) {
            paramayjl.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            paramayjl.mLoadingDrawable = ((Drawable)localObject);
            paramayjl.mFailedDrawable = ((Drawable)localObject);
          }
          paramayjl = URLDrawable.getDrawable(localayij.c(), paramayjl);
          if (localayij.jdField_b_of_type_Boolean) {
            paramayjl.setDecodeHandler(bcuq.a);
          }
          if ((paramayjl.getStatus() != 1) && (paramayjl.getStatus() != 0)) {
            paramayjl.restartDownload();
          }
          paramayru.b().setImageDrawable(paramayjl);
          if ((paramayru.b() == null) || (localaytc.c() == null)) {
            break;
          }
          a(paramayru.b(), localaytc.c(), localayij.jdField_b_of_type_Int);
          return;
        }
      }
      catch (Exception paramayjl)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + paramayjl.toString());
        return;
      }
      if ((localayij.d() == 8192) || (localayij.d() == 16) || (localayij.d() == 8))
      {
        localLayoutParams.height = aekt.a(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localayij.d() == 1001)
      {
        localLayoutParams.height = aekt.a(60.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if ((localayij.d() != 1024) && (localayij.d() != 1002))
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131298225);
        continue;
        label459:
        super.a(paramayjl, paramayru);
      }
    }
    label468:
    super.a(paramayjl, paramayru);
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
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    if (!(paramayjl instanceof ayij))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + paramayjl);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + paramayjl);
    }
    ayij localayij = (ayij)paramayjl;
    this.jdField_a_of_type_Int = localayij.d();
    Object localObject1 = paramayru.a();
    Object localObject2 = paramayru.b();
    Object localObject3 = paramayru.c();
    Resources localResources = paramayru.a().getContext().getResources();
    if ((localObject3 != null) && (localayij.jdField_c_of_type_Int != -1)) {
      ((TextView)localObject3).setTextColor(localResources.getColor(localayij.jdField_c_of_type_Int));
    }
    int i;
    if ((paramayru instanceof aytc))
    {
      paramayjl = (aytc)paramayru;
      if (paramayjl.e() != null) {
        paramayjl.e().setVisibility(8);
      }
      if (localObject1 != null) {
        a((TextView)localObject1, localayij.h);
      }
      if (localObject2 != null) {
        a((TextView)localObject2, localayij.i);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (localObject3 != null) {
          ((TextView)localObject3).setMaxLines(1);
        }
        if (this.jdField_a_of_type_Int == 1002)
        {
          paramayjl = paramayru.a("ActiveEntitySearchResultPresenter_add_troop");
          localObject1 = (Pair)localayij.a("ActiveEntitySearchResultPresenter_add_troop");
          if ((paramayjl != null) && (localObject1 != null))
          {
            paramayjl.setVisibility(0);
            if ((paramayjl instanceof TextView))
            {
              localObject2 = (TextView)paramayjl;
              ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
              ((TextView)localObject2).setEnabled(((Boolean)((Pair)localObject1).second).booleanValue());
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131755344);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (!((Boolean)((Pair)localObject1).second).booleanValue()) {
                break label1242;
              }
              i = paramayjl.getContext().getResources().getDimensionPixelSize(2131296632);
              ((TextView)localObject2).setPadding(i, 0, i, 0);
              ((TextView)localObject2).setMinWidth(azgq.a(60.0F));
              ((TextView)localObject2).setMinWidth(azgq.a(29.0F));
              ((TextView)localObject2).setBackgroundResource(2130839141);
              if (localObject3 != null)
              {
                ((ViewGroup.LayoutParams)localObject3).height = -2;
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              }
            }
          }
          label462:
          localObject2 = paramayru.a("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localayij.a("ActiveEntitySearchResultPresenter_pay_troop");
          paramayjl = (ayjl)localObject1;
          if (localObject1 == null) {
            paramayjl = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (!paramayjl.booleanValue()) {
              break label1295;
            }
            i = 0;
            label513:
            ((View)localObject2).setVisibility(i);
          }
          localObject1 = paramayru.a("ActiveEntitySearchResultPresenter_hot_troop");
          paramayjl = (Integer)localayij.a("ActiveEntitySearchResultPresenter_hot_troop");
          if (paramayjl != null) {
            break label1311;
          }
          paramayjl = Integer.valueOf(0);
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
        if (paramayjl.intValue() <= 0) {
          break label1301;
        }
        ((View)localObject1).setVisibility(0);
        ((TroopActiveLayout)localObject1).setHotLevel(paramayjl.intValue());
      }
      for (;;)
      {
        paramayjl = paramayru.a("ActiveEntitySearchResultPresenter_expand_desc");
        localObject1 = localayij.c();
        if (((paramayjl instanceof FolderTextView)) && (localObject1 != null)) {
          ((FolderTextView)paramayjl).setText(new baig((CharSequence)localObject1, 11, 16));
        }
        super.b(localayij, paramayru);
        a(paramayru.a(), localayij.a(), true, false);
        a(paramayru.b(), localayij.b(), false);
        a(paramayru.c(), localayij.c(), false);
        a(paramayru.d(), localayij.d(), false);
        return;
        if (paramayjl.b() != null) {
          paramayjl.b().a(localayij.jdField_b_of_type_JavaUtilList, localayij.e, localayij.d - 1, 1);
        }
        if (paramayjl.h() != null)
        {
          if (!TextUtils.isEmpty(localayij.m)) {
            paramayjl.h().setText(localayij.m);
          }
        }
        else if ((paramayjl.g() != null) && (paramayjl.f() != null))
        {
          localObject1 = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (!((aloz)localObject1).b(localayij.jdField_b_of_type_JavaLangString)) {
            break label930;
          }
          localayij.jdField_k_of_type_Int = 2;
          label816:
          if (localayij.jdField_k_of_type_Int != 0) {
            break label964;
          }
          if (bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayij.jdField_b_of_type_JavaLangString)) {
            break label952;
          }
          paramayjl.f().setVisibility(0);
          paramayjl.f().setText(alpo.a(2131689628));
          label860:
          paramayjl.g().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((paramayjl.b() == null) || (paramayjl.f() == null)) {
            break;
          }
          if (!bcgx.b((QQAppInterface)localObject1, localayij.jdField_b_of_type_JavaLangString)) {
            break label1033;
          }
          paramayjl.b().setVisibility(0);
          break;
          paramayjl.h().setText("");
          break label769;
          label930:
          if (!((aloz)localObject1).d(localayij.jdField_b_of_type_JavaLangString)) {
            break label816;
          }
          localayij.jdField_k_of_type_Int = 1;
          break label816;
          label952:
          paramayjl.f().setVisibility(8);
          break label860;
          label964:
          if (localayij.jdField_k_of_type_Int == 1)
          {
            paramayjl.f().setVisibility(8);
            paramayjl.g().setVisibility(0);
            paramayjl.g().setText(2131719227);
          }
          else
          {
            paramayjl.f().setVisibility(8);
            paramayjl.g().setVisibility(0);
            paramayjl.g().setText(2131690082);
          }
        }
        paramayjl.b().setVisibility(8);
        break;
        if (paramayjl.a() != null)
        {
          paramayjl.a().setVisibility(0);
          paramayjl.a().setLabelType(1);
          paramayjl.a().a(localayij.a);
        }
        if (paramayjl.a != null)
        {
          if ((localayij.jdField_b_of_type_Long & 0x800) == 0L) {
            break label1129;
          }
          paramayjl.a.setVisibility(0);
        }
        while (paramayjl.b != null)
        {
          paramayjl.b.setVisibility(8);
          break;
          label1129:
          paramayjl.a.setVisibility(8);
        }
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setCompoundDrawablePadding(aekt.a(4.0F, localResources));
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841296, 0);
        break;
        a((TextView)localObject1, (TextView)localObject3, localayij.a(), null);
        break;
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + paramayru);
        throw new RuntimeException("View is not SearchResultFromNetView. View = " + paramayru);
        label1242:
        ((TextView)localObject2).setPadding(0, 0, 0, 0);
        ((TextView)localObject2).setMinWidth(0);
        ((TextView)localObject2).setMinHeight(0);
        ((TextView)localObject2).setBackgroundDrawable(null);
        if (localObject3 == null) {
          break label462;
        }
        ((ViewGroup.LayoutParams)localObject3).height = azgq.a(20.0F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break label462;
        i = 8;
        break label513;
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  protected void c(ayjl paramayjl, ayru paramayru)
  {
    super.c(paramayjl, paramayru);
    if ((paramayjl instanceof ayij))
    {
      paramayjl = (ayij)paramayjl;
      if (paramayjl.d() != 1002) {
        break label56;
      }
      paramayru = paramayru.a("ActiveEntitySearchResultPresenter_add_troop");
      if (paramayru != null) {
        paramayru.setOnClickListener(new aylo(this, paramayjl));
      }
    }
    label56:
    while ((paramayjl.d() != 1001) || (((aytc)paramayru).f() == null)) {
      return;
    }
    ((aytc)paramayru).f().setOnClickListener(new aylp(this, paramayjl));
  }
  
  public void d(ayjl paramayjl, ayru paramayru)
  {
    if (((paramayjl instanceof ayij)) && (!this.jdField_a_of_type_Boolean) && (a(((ayij)paramayjl).d()))) {
      ayrg.a(paramayjl.a(), paramayjl.b(), paramayru.a(), ((ayij)paramayjl).r);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylm
 * JD-Core Version:    0.7.0.1
 */