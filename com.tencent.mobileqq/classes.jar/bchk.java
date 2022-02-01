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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;

public class bchk
  extends bcjc
{
  int jdField_a_of_type_Int;
  private ajgu jdField_a_of_type_Ajgu = new bchm(this);
  private View jdField_a_of_type_AndroidViewView;
  private aofu jdField_a_of_type_Aofu = new bchl(this);
  private bcbf jdField_a_of_type_Bcbf;
  private bceh jdField_a_of_type_Bceh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public bchk(FaceDecoder paramFaceDecoder, int paramInt)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public bchk(FaceDecoder paramFaceDecoder, int paramInt, bcbf parambcbf)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bcbf = parambcbf;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void a(Context paramContext, bceh parambceh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + paramContext + ", model = " + parambceh);
    }
    if ((paramContext == null) || (parambceh == null)) {
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
            bevl.a(paramContext, parambceh.jdField_b_of_type_JavaLangString, parambceh.jdField_c_of_type_JavaLangString, i, "", parambceh.q, false, new bchp(this, parambceh));
            return;
            i = 104;
            break;
            if (parambceh.jdField_d_of_type_Boolean)
            {
              i = 30013;
            }
            else
            {
              i = 30015;
              continue;
              if (parambceh.jdField_d_of_type_Boolean) {
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
      localDrawable = paramImageView2.getResources().getDrawable(2130842379);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130842406);
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
  
  private void b()
  {
    try
    {
      bdla.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "P_CliOper", "Grp_find", "", "grptab", "Clk_join", 0, 0, this.jdField_a_of_type_Bceh.jdField_b_of_type_JavaLangString, "", "", "");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bcbf != null) {
      this.jdField_a_of_type_Bcbf.notifyDataSetChanged();
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
  
  public void a(bcfj parambcfj, bcnt parambcnt)
  {
    Object localObject = parambcnt.b();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      bceh localbceh;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(parambcfj instanceof bceh)) || (!(parambcnt instanceof bcpb))) {
          break label468;
        }
        localbceh = (bceh)parambcfj;
        bcpb localbcpb = (bcpb)parambcnt;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.jdField_a_of_type_Boolean)
        {
          localLayoutParams.height = AIOUtils.dp2px(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localbcpb.c() != null) {
            localbcpb.c().setLayoutParams(localLayoutParams);
          }
          if ((localbceh.d() == 1001) || (localbceh.d() == 1002)) {
            break label459;
          }
          int i = parambcnt.a().getResources().getDimensionPixelSize(2131297457);
          parambcfj = URLDrawable.URLDrawableOptions.obtain();
          parambcfj.mRequestWidth = i;
          parambcfj.mRequestHeight = i;
          if (localbceh.jdField_b_of_type_Boolean) {
            parambcfj.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            parambcfj.mLoadingDrawable = ((Drawable)localObject);
            parambcfj.mFailedDrawable = ((Drawable)localObject);
          }
          parambcfj = URLDrawable.getDrawable(localbceh.c(), parambcfj);
          if (localbceh.jdField_b_of_type_Boolean) {
            parambcfj.setDecodeHandler(bgxc.a);
          }
          if ((parambcfj.getStatus() != 1) && (parambcfj.getStatus() != 0)) {
            parambcfj.restartDownload();
          }
          parambcnt.b().setImageDrawable(parambcfj);
          if ((parambcnt.b() == null) || (localbcpb.c() == null)) {
            break;
          }
          a(parambcnt.b(), localbcpb.c(), localbceh.jdField_b_of_type_Int);
          return;
        }
      }
      catch (Exception parambcfj)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + parambcfj.toString());
        return;
      }
      if ((localbceh.d() == 8192) || (localbceh.d() == 16) || (localbceh.d() == 8))
      {
        localLayoutParams.height = AIOUtils.dp2px(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localbceh.d() == 1001)
      {
        localLayoutParams.height = AIOUtils.dp2px(60.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if ((localbceh.d() != 1024) && (localbceh.d() != 1002))
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131298388);
        continue;
        label459:
        super.a(parambcfj, parambcnt);
      }
    }
    label468:
    super.a(parambcfj, parambcnt);
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
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    if (!(parambcfj instanceof bceh))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + parambcfj);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + parambcfj);
    }
    bceh localbceh = (bceh)parambcfj;
    this.jdField_a_of_type_Int = localbceh.d();
    Object localObject1 = parambcnt.a();
    Object localObject2 = parambcnt.b();
    Object localObject3 = parambcnt.c();
    Resources localResources = parambcnt.a().getContext().getResources();
    if ((localObject3 != null) && (localbceh.jdField_c_of_type_Int != -1)) {
      ((TextView)localObject3).setTextColor(localResources.getColor(localbceh.jdField_c_of_type_Int));
    }
    int i;
    if ((parambcnt instanceof bcpb))
    {
      parambcfj = (bcpb)parambcnt;
      if (parambcfj.e() != null) {
        parambcfj.e().setVisibility(8);
      }
      if (localObject1 != null) {
        a((TextView)localObject1, localbceh.i);
      }
      if (localObject2 != null) {
        a((TextView)localObject2, localbceh.j);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        if (localObject3 != null) {
          ((TextView)localObject3).setMaxLines(1);
        }
        if (this.jdField_a_of_type_Int == 1002)
        {
          parambcfj = parambcnt.a("ActiveEntitySearchResultPresenter_add_troop");
          localObject1 = (Pair)localbceh.a("ActiveEntitySearchResultPresenter_add_troop");
          if ((parambcfj != null) && (localObject1 != null))
          {
            parambcfj.setVisibility(0);
            if ((parambcfj instanceof TextView))
            {
              localObject2 = (TextView)parambcfj;
              ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
              ((TextView)localObject2).setEnabled(((Boolean)((Pair)localObject1).second).booleanValue());
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131755352);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (!((Boolean)((Pair)localObject1).second).booleanValue()) {
                break label1316;
              }
              i = parambcfj.getContext().getResources().getDimensionPixelSize(2131296743);
              ((TextView)localObject2).setPadding(i, 0, i, 0);
              ((TextView)localObject2).setMinWidth(ScreenUtil.dip2px(60.0F));
              ((TextView)localObject2).setMinWidth(ScreenUtil.dip2px(29.0F));
              ((TextView)localObject2).setBackgroundResource(2130839381);
              if (localObject3 != null)
              {
                ((ViewGroup.LayoutParams)localObject3).height = -2;
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              }
            }
          }
          label462:
          localObject2 = parambcnt.a("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localbceh.a("ActiveEntitySearchResultPresenter_pay_troop");
          parambcfj = (bcfj)localObject1;
          if (localObject1 == null) {
            parambcfj = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (!parambcfj.booleanValue()) {
              break label1369;
            }
            i = 0;
            label513:
            ((View)localObject2).setVisibility(i);
          }
          localObject1 = parambcnt.a("ActiveEntitySearchResultPresenter_hot_troop");
          parambcfj = (Integer)localbceh.a("ActiveEntitySearchResultPresenter_hot_troop");
          if (parambcfj != null) {
            break label1385;
          }
          parambcfj = Integer.valueOf(0);
        }
        break;
      }
    }
    label842:
    label1107:
    label1369:
    label1375:
    label1385:
    for (;;)
    {
      if ((localObject1 instanceof TroopActiveLayout))
      {
        if (parambcfj.intValue() <= 0) {
          break label1375;
        }
        ((View)localObject1).setVisibility(0);
        ((TroopActiveLayout)localObject1).setHotLevel(parambcfj.intValue());
      }
      for (;;)
      {
        parambcfj = parambcnt.a("ActiveEntitySearchResultPresenter_expand_desc");
        localObject1 = localbceh.c();
        if (((parambcfj instanceof FolderTextView)) && (localObject1 != null)) {
          ((FolderTextView)parambcfj).setText(new QQText((CharSequence)localObject1, 11, 16));
        }
        super.b(localbceh, parambcnt);
        a(parambcnt.a(), localbceh.a(), true, false);
        a(parambcnt.b(), localbceh.b(), false);
        a(parambcnt.c(), localbceh.c(), false);
        a(parambcnt.d(), localbceh.d(), false);
        if ((this.jdField_a_of_type_Int == 1001) && (TextUtils.isEmpty(localbceh.h)))
        {
          parambcfj = parambcnt.b();
          parambcfj.setText(localbceh.b());
          bhnz.a(parambcfj, localbceh.f, localbceh.g, 2131167107, 17);
          bhnz.a("0X800B237", localbceh.f, localbceh.g);
        }
        return;
        if (parambcfj.b() != null) {
          parambcfj.b().a(localbceh.jdField_b_of_type_JavaUtilList, localbceh.e, localbceh.jdField_d_of_type_Int - 1, 1);
        }
        if (parambcfj.h() != null)
        {
          if (!TextUtils.isEmpty(localbceh.s)) {
            parambcfj.h().setText(localbceh.s);
          }
        }
        else if ((parambcfj.g() != null) && (parambcfj.f() != null))
        {
          localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (!((anvk)localObject1).b(localbceh.jdField_b_of_type_JavaLangString)) {
            break label1004;
          }
          localbceh.n = 2;
          label890:
          if (localbceh.n != 0) {
            break label1038;
          }
          if (bghs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbceh.jdField_b_of_type_JavaLangString)) {
            break label1026;
          }
          parambcfj.f().setVisibility(0);
          parambcfj.f().setText(anvx.a(2131689550));
          parambcfj.g().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((parambcfj.b() == null) || (parambcfj.f() == null)) {
            break;
          }
          if (!bghs.b((QQAppInterface)localObject1, localbceh.jdField_b_of_type_JavaLangString)) {
            break label1107;
          }
          parambcfj.b().setVisibility(0);
          break;
          parambcfj.h().setText("");
          break label842;
          label1004:
          if (!((anvk)localObject1).d(localbceh.jdField_b_of_type_JavaLangString)) {
            break label890;
          }
          localbceh.n = 1;
          break label890;
          parambcfj.f().setVisibility(8);
          break label934;
          if (localbceh.n == 1)
          {
            parambcfj.f().setVisibility(8);
            parambcfj.g().setVisibility(0);
            parambcfj.g().setText(2131718061);
          }
          else
          {
            parambcfj.f().setVisibility(8);
            parambcfj.g().setVisibility(0);
            parambcfj.g().setText(2131690030);
          }
        }
        parambcfj.b().setVisibility(8);
        break;
        if (parambcfj.a() != null)
        {
          parambcfj.a().setVisibility(0);
          parambcfj.a().setLabelType(1);
          parambcfj.a().a(localbceh.a);
        }
        if (parambcfj.a != null)
        {
          if ((localbceh.jdField_b_of_type_Long & 0x800) == 0L) {
            break label1203;
          }
          parambcfj.a.setVisibility(0);
        }
        while (parambcfj.b != null)
        {
          parambcfj.b.setVisibility(8);
          break;
          parambcfj.a.setVisibility(8);
        }
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setCompoundDrawablePadding(AIOUtils.dp2px(4.0F, localResources));
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841656, 0);
        break;
        a((TextView)localObject1, (TextView)localObject3, localbceh.a(), null);
        break;
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + parambcnt);
        throw new RuntimeException("View is not SearchResultFromNetView. View = " + parambcnt);
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
  
  protected void c(bcfj parambcfj, bcnt parambcnt)
  {
    super.c(parambcfj, parambcnt);
    if ((parambcfj instanceof bceh))
    {
      parambcfj = (bceh)parambcfj;
      if (parambcfj.d() != 1002) {
        break label56;
      }
      parambcnt = parambcnt.a("ActiveEntitySearchResultPresenter_add_troop");
      if (parambcnt != null) {
        parambcnt.setOnClickListener(new bchn(this, parambcfj));
      }
    }
    label56:
    while ((parambcfj.d() != 1001) || (((bcpb)parambcnt).f() == null)) {
      return;
    }
    ((bcpb)parambcnt).f().setOnClickListener(new bcho(this, parambcfj));
  }
  
  public void d(bcfj parambcfj, bcnt parambcnt)
  {
    if (((parambcfj instanceof bceh)) && (!this.jdField_a_of_type_Boolean) && (a(((bceh)parambcfj).d()))) {
      bcnf.a(parambcfj.a(), parambcfj.b(), parambcnt.a(), ((bceh)parambcfj).u);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchk
 * JD-Core Version:    0.7.0.1
 */