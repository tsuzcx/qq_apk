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

public class avqo
  extends avsf
{
  int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new avqp(this);
  private avkm jdField_a_of_type_Avkm;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public avqo(azwg paramazwg, int paramInt)
  {
    super(paramazwg);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public avqo(azwg paramazwg, int paramInt, avkm paramavkm)
  {
    super(paramazwg);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Avkm = paramavkm;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void a(Context paramContext, avnl paramavnl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + paramContext + ", model = " + paramavnl);
    }
    if ((paramContext == null) || (paramavnl == null)) {
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
          aydb.a(paramContext, paramavnl.jdField_b_of_type_JavaLangString, paramavnl.jdField_c_of_type_JavaLangString, i, "", paramavnl.jdField_k_of_type_JavaLangString, false, new avqs(this, paramavnl));
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
      localDrawable = paramImageView2.getResources().getDrawable(2130841727);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130841754);
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
      f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + aciy.a(4.0F, paramTextView1.getContext().getResources());
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding(aciy.a(2.0F, paramTextView1.getContext().getResources()), 0, aciy.a(2.0F, paramTextView1.getContext().getResources()), 0);
    }
    for (;;)
    {
      float f2 = i - aciy.a(89.0F, paramTextView1.getContext().getResources());
      if (f1 != 0.0F) {}
      for (f1 = f2 - (f1 + aciy.a(6.0F, paramTextView1.getContext().getResources()));; f1 = f2)
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
      paramString.setBounds(0, 0, aciy.a(14.0F, localResources), aciy.a(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(aciy.a(4.0F, localResources));
      paramTextView.setCompoundDrawables(null, null, paramString, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Avkm != null) {
      this.jdField_a_of_type_Avkm.notifyDataSetChanged();
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
  
  public void a(avon paramavon, avww paramavww)
  {
    Object localObject = paramavww.b();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      avnl localavnl;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(paramavon instanceof avnl)) || (!(paramavww instanceof avye))) {
          break label468;
        }
        localavnl = (avnl)paramavon;
        avye localavye = (avye)paramavww;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean)
        {
          localLayoutParams.height = aciy.a(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localavye.c() != null) {
            localavye.c().setLayoutParams(localLayoutParams);
          }
          if ((localavnl.d() == 1001) || (localavnl.d() == 1002)) {
            break label459;
          }
          int i = paramavww.a().getResources().getDimensionPixelSize(2131166210);
          paramavon = URLDrawable.URLDrawableOptions.obtain();
          paramavon.mRequestWidth = i;
          paramavon.mRequestHeight = i;
          if (localavnl.jdField_b_of_type_Boolean) {
            paramavon.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            paramavon.mLoadingDrawable = ((Drawable)localObject);
            paramavon.mFailedDrawable = ((Drawable)localObject);
          }
          paramavon = URLDrawable.getDrawable(localavnl.c(), paramavon);
          if (localavnl.jdField_b_of_type_Boolean) {
            paramavon.setDecodeHandler(azue.a);
          }
          if ((paramavon.getStatus() != 1) && (paramavon.getStatus() != 0)) {
            paramavon.restartDownload();
          }
          paramavww.b().setImageDrawable(paramavon);
          if ((paramavww.b() == null) || (localavye.c() == null)) {
            break;
          }
          a(paramavww.b(), localavye.c(), localavnl.jdField_b_of_type_Int);
          return;
        }
      }
      catch (Exception paramavon)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + paramavon.toString());
        return;
      }
      if ((localavnl.d() == 8192) || (localavnl.d() == 16) || (localavnl.d() == 8))
      {
        localLayoutParams.height = aciy.a(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localavnl.d() == 1001)
      {
        localLayoutParams.height = aciy.a(60.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if ((localavnl.d() != 1024) && (localavnl.d() != 1002))
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131167108);
        continue;
        label459:
        super.a(paramavon, paramavww);
      }
    }
    label468:
    super.a(paramavon, paramavww);
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
  
  public void b(avon paramavon, avww paramavww)
  {
    if (!(paramavon instanceof avnl))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + paramavon);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + paramavon);
    }
    avnl localavnl = (avnl)paramavon;
    this.jdField_a_of_type_Int = localavnl.d();
    Object localObject1 = paramavww.a();
    Object localObject2 = paramavww.b();
    Object localObject3 = paramavww.c();
    Resources localResources = paramavww.a().getContext().getResources();
    if ((localObject3 != null) && (localavnl.jdField_c_of_type_Int != -1)) {
      ((TextView)localObject3).setTextColor(localResources.getColor(localavnl.jdField_c_of_type_Int));
    }
    int i;
    if ((paramavww instanceof avye))
    {
      paramavon = (avye)paramavww;
      if (paramavon.e() != null) {
        paramavon.e().setVisibility(8);
      }
      if (localObject1 != null) {
        a((TextView)localObject1, localavnl.h);
      }
      if (localObject2 != null) {
        a((TextView)localObject2, localavnl.i);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (localObject3 != null) {
          ((TextView)localObject3).setMaxLines(1);
        }
        if (this.jdField_a_of_type_Int == 1002)
        {
          paramavon = paramavww.a("ActiveEntitySearchResultPresenter_add_troop");
          localObject1 = (Pair)localavnl.a("ActiveEntitySearchResultPresenter_add_troop");
          if ((paramavon != null) && (localObject1 != null))
          {
            paramavon.setVisibility(0);
            if ((paramavon instanceof TextView))
            {
              localObject2 = (TextView)paramavon;
              ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
              ((TextView)localObject2).setEnabled(((Boolean)((Pair)localObject1).second).booleanValue());
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131689801);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (!((Boolean)((Pair)localObject1).second).booleanValue()) {
                break label1242;
              }
              i = paramavon.getContext().getResources().getDimensionPixelSize(2131165544);
              ((TextView)localObject2).setPadding(i, 0, i, 0);
              ((TextView)localObject2).setMinWidth(awmc.a(60.0F));
              ((TextView)localObject2).setMinWidth(awmc.a(29.0F));
              ((TextView)localObject2).setBackgroundResource(2130839032);
              if (localObject3 != null)
              {
                ((ViewGroup.LayoutParams)localObject3).height = -2;
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              }
            }
          }
          label462:
          localObject2 = paramavww.a("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localavnl.a("ActiveEntitySearchResultPresenter_pay_troop");
          paramavon = (avon)localObject1;
          if (localObject1 == null) {
            paramavon = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (!paramavon.booleanValue()) {
              break label1295;
            }
            i = 0;
            label513:
            ((View)localObject2).setVisibility(i);
          }
          localObject1 = paramavww.a("ActiveEntitySearchResultPresenter_hot_troop");
          paramavon = (Integer)localavnl.a("ActiveEntitySearchResultPresenter_hot_troop");
          if (paramavon != null) {
            break label1311;
          }
          paramavon = Integer.valueOf(0);
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
        if (paramavon.intValue() <= 0) {
          break label1301;
        }
        ((View)localObject1).setVisibility(0);
        ((TroopActiveLayout)localObject1).setHotLevel(paramavon.intValue());
      }
      for (;;)
      {
        paramavon = paramavww.a("ActiveEntitySearchResultPresenter_expand_desc");
        localObject1 = localavnl.c();
        if (((paramavon instanceof FolderTextView)) && (localObject1 != null)) {
          ((FolderTextView)paramavon).setText(new axkd((CharSequence)localObject1, 11, 16));
        }
        super.b(localavnl, paramavww);
        a(paramavww.a(), localavnl.a(), true, false);
        a(paramavww.b(), localavnl.b(), false);
        a(paramavww.c(), localavnl.c(), false);
        a(paramavww.d(), localavnl.d(), false);
        return;
        if (paramavon.b() != null) {
          paramavon.b().a(localavnl.jdField_b_of_type_JavaUtilList, localavnl.e, localavnl.d - 1, 1);
        }
        if (paramavon.h() != null)
        {
          if (!TextUtils.isEmpty(localavnl.m)) {
            paramavon.h().setText(localavnl.m);
          }
        }
        else if ((paramavon.g() != null) && (paramavon.f() != null))
        {
          localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          if (!((ajjj)localObject1).b(localavnl.jdField_b_of_type_JavaLangString)) {
            break label930;
          }
          localavnl.jdField_k_of_type_Int = 2;
          label816:
          if (localavnl.jdField_k_of_type_Int != 0) {
            break label964;
          }
          if (azgu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localavnl.jdField_b_of_type_JavaLangString)) {
            break label952;
          }
          paramavon.f().setVisibility(0);
          paramavon.f().setText(ajjy.a(2131624088));
          label860:
          paramavon.g().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((paramavon.b() == null) || (paramavon.f() == null)) {
            break;
          }
          if (!azgu.b((QQAppInterface)localObject1, localavnl.jdField_b_of_type_JavaLangString)) {
            break label1033;
          }
          paramavon.b().setVisibility(0);
          break;
          paramavon.h().setText("");
          break label769;
          label930:
          if (!((ajjj)localObject1).d(localavnl.jdField_b_of_type_JavaLangString)) {
            break label816;
          }
          localavnl.jdField_k_of_type_Int = 1;
          break label816;
          label952:
          paramavon.f().setVisibility(8);
          break label860;
          label964:
          if (localavnl.jdField_k_of_type_Int == 1)
          {
            paramavon.f().setVisibility(8);
            paramavon.g().setVisibility(0);
            paramavon.g().setText(2131652918);
          }
          else
          {
            paramavon.f().setVisibility(8);
            paramavon.g().setVisibility(0);
            paramavon.g().setText(2131624481);
          }
        }
        paramavon.b().setVisibility(8);
        break;
        if (paramavon.a() != null)
        {
          paramavon.a().setVisibility(0);
          paramavon.a().setLabelType(1);
          paramavon.a().a(localavnl.a);
        }
        if (paramavon.a != null)
        {
          if ((localavnl.jdField_b_of_type_Long & 0x800) == 0L) {
            break label1129;
          }
          paramavon.a.setVisibility(0);
        }
        while (paramavon.b != null)
        {
          paramavon.b.setVisibility(8);
          break;
          label1129:
          paramavon.a.setVisibility(8);
        }
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setCompoundDrawablePadding(aciy.a(4.0F, localResources));
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841102, 0);
        break;
        a((TextView)localObject1, (TextView)localObject3, localavnl.a(), null);
        break;
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + paramavww);
        throw new RuntimeException("View is not SearchResultFromNetView. View = " + paramavww);
        label1242:
        ((TextView)localObject2).setPadding(0, 0, 0, 0);
        ((TextView)localObject2).setMinWidth(0);
        ((TextView)localObject2).setMinHeight(0);
        ((TextView)localObject2).setBackgroundDrawable(null);
        if (localObject3 == null) {
          break label462;
        }
        ((ViewGroup.LayoutParams)localObject3).height = awmc.a(20.0F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break label462;
        i = 8;
        break label513;
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  protected void c(avon paramavon, avww paramavww)
  {
    super.c(paramavon, paramavww);
    if ((paramavon instanceof avnl))
    {
      paramavon = (avnl)paramavon;
      if (paramavon.d() != 1002) {
        break label56;
      }
      paramavww = paramavww.a("ActiveEntitySearchResultPresenter_add_troop");
      if (paramavww != null) {
        paramavww.setOnClickListener(new avqq(this, paramavon));
      }
    }
    label56:
    while ((paramavon.d() != 1001) || (((avye)paramavww).f() == null)) {
      return;
    }
    ((avye)paramavww).f().setOnClickListener(new avqr(this, paramavon));
  }
  
  public void d(avon paramavon, avww paramavww)
  {
    if (((paramavon instanceof avnl)) && (!this.jdField_a_of_type_Boolean) && (a(((avnl)paramavon).d()))) {
      avwi.a(paramavon.a(), paramavon.b(), paramavww.a(), ((avnl)paramavon).r);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqo
 * JD-Core Version:    0.7.0.1
 */