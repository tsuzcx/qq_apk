import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;

public class ayqe
  extends ayrm
{
  private ayqi a;
  protected Set<String> a;
  
  public ayqe(bdbb parambdbb)
  {
    super(parambdbb);
  }
  
  public ayqe(bdbb parambdbb, ayqi paramayqi)
  {
    super(parambdbb);
    this.jdField_a_of_type_Ayqi = paramayqi;
  }
  
  public ayqe(bdbb parambdbb, ayqi paramayqi, Set<String> paramSet)
  {
    super(parambdbb);
    this.jdField_a_of_type_Ayqi = paramayqi;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_entrance", 29);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SelectMemberActivity.a(paramString, "", 0, paramString));
    localIntent.putExtra("param_selected_records_for_create_discussion", localArrayList);
    paramActivity.startActivityForResult(localIntent, 1300);
  }
  
  public void a(aynu paramaynu, aywd paramaywd, Bitmap paramBitmap)
  {
    if (paramaynu.c() == 103)
    {
      if (paramaywd.b() != null) {
        paramaywd.b().setImageDrawable(ayvm.a(paramBitmap));
      }
      return;
    }
    super.a(paramaynu, paramaywd, paramBitmap);
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    super.b(paramaynu, paramaywd);
    Object localObject;
    if (((paramaynu instanceof aymo)) && (paramaynu.c() == null))
    {
      if (paramaywd.c() != null) {
        paramaywd.c().setVisibility(8);
      }
      if (paramaywd.a() != null) {
        paramaywd.a().setVisibility(8);
      }
      if (paramaywd.b() != null) {
        paramaywd.b().setVisibility(8);
      }
      localObject = ((ayvx)paramaywd).e();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(paramaynu.a());
      }
      localObject = paramaywd.a().findViewById(2131378980);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if ((((paramaynu instanceof aymj)) || ((paramaynu instanceof aymn)) || ((paramaynu instanceof aymf))) && (ayif.a(paramaynu.b()))) {
          ((View)localObject).setVisibility(0);
        }
      }
      if (paramaywd.c() != null)
      {
        localObject = paramaynu.b();
        if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(localObject))) {
          paramaywd.c().setText(alud.a(2131702962));
        }
      }
      if ((ayvm.a) && (paramaywd.a() != null) && ((paramaynu instanceof aynq))) {
        paramaywd.a().setOnLongClickListener(new ayqf(this, paramaynu));
      }
      if ((paramaywd.a() != null) && ((paramaynu instanceof aymf)))
      {
        int i = ((aymf)paramaynu).f();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchResultPresenter", 2, "add from type =" + i);
        }
        if ((i == 21) || (i == 1) || (i == 2))
        {
          paramaywd = paramaywd.a();
          paramaywd.setContentDescription(paramaywd.getContext().getString(2131699736));
          paramaywd.setImageResource(2130845613);
          paramaywd.setOnClickListener(new ayqg(this, paramaynu));
        }
      }
      return;
    }
    if ((paramaywd.c() != null) && (!TextUtils.isEmpty(paramaynu.c())))
    {
      paramaywd.c().setVisibility(0);
      label411:
      if (paramaywd.a() != null) {
        paramaywd.a().setVisibility(0);
      }
      if ((paramaywd.b() == null) || (paramaynu.b() == null)) {
        break label667;
      }
      paramaywd.b().setVisibility(0);
      if ((!(paramaynu instanceof aymf)) && (!(paramaynu instanceof ayme)) && (!(paramaynu instanceof ayml))) {
        break label651;
      }
      localObject = paramaynu.b();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bdeu.b((String)localObject))) {
        break label635;
      }
      localObject = paramaywd.b().getContext().getResources().getDrawable(2130841432);
      ((Drawable)localObject).setBounds(0, 0, aepi.a(15.0F, paramaywd.b().getContext().getResources()), aepi.a(15.0F, paramaywd.b().getContext().getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
      paramaywd.b().setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = ((ayvx)paramaywd).e();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (paramaywd.c() == null) {
        break label411;
      }
      paramaywd.c().setVisibility(8);
      break label411;
      label635:
      paramaywd.b().setCompoundDrawables(null, null, null, null);
      continue;
      label651:
      paramaywd.b().setCompoundDrawables(null, null, null, null);
      continue;
      label667:
      if (paramaywd.b() != null) {
        paramaywd.b().setVisibility(8);
      }
    }
  }
  
  protected void c(aynu paramaynu, aywd paramaywd)
  {
    if (this.jdField_a_of_type_Ayqi != null)
    {
      if (paramaywd.a() != null) {
        paramaywd.a().setOnClickListener(new ayqh(this));
      }
      return;
    }
    super.c(paramaynu, paramaywd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqe
 * JD-Core Version:    0.7.0.1
 */