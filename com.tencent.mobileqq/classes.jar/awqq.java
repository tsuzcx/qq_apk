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

public class awqq
  extends awry
{
  private awqu a;
  protected Set<String> a;
  
  public awqq(baxk parambaxk)
  {
    super(parambaxk);
  }
  
  public awqq(baxk parambaxk, awqu paramawqu)
  {
    super(parambaxk);
    this.jdField_a_of_type_Awqu = paramawqu;
  }
  
  public awqq(baxk parambaxk, awqu paramawqu, Set<String> paramSet)
  {
    super(parambaxk);
    this.jdField_a_of_type_Awqu = paramawqu;
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
  
  public void a(awog paramawog, awwp paramawwp, Bitmap paramBitmap)
  {
    if (paramawog.c() == 103)
    {
      if (paramawwp.b() != null) {
        paramawwp.b().setImageDrawable(awvy.a(paramBitmap));
      }
      return;
    }
    super.a(paramawog, paramawwp, paramBitmap);
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    super.b(paramawog, paramawwp);
    Object localObject;
    if (((paramawog instanceof awna)) && (paramawog.c() == null))
    {
      if (paramawwp.c() != null) {
        paramawwp.c().setVisibility(8);
      }
      if (paramawwp.a() != null) {
        paramawwp.a().setVisibility(8);
      }
      if (paramawwp.b() != null) {
        paramawwp.b().setVisibility(8);
      }
      localObject = ((awwj)paramawwp).e();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(paramawog.a());
      }
      localObject = paramawwp.a().findViewById(2131378329);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if ((((paramawog instanceof awmv)) || ((paramawog instanceof awmz)) || ((paramawog instanceof awmr))) && (awiu.a(paramawog.b()))) {
          ((View)localObject).setVisibility(0);
        }
      }
      if (paramawwp.c() != null)
      {
        localObject = paramawog.b();
        if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(localObject))) {
          paramawwp.c().setText(ajyc.a(2131702567));
        }
      }
      if ((awvy.a) && (paramawwp.a() != null) && ((paramawog instanceof awoc))) {
        paramawwp.a().setOnLongClickListener(new awqr(this, paramawog));
      }
      if ((paramawwp.a() != null) && ((paramawog instanceof awmr)))
      {
        int i = ((awmr)paramawog).f();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchResultPresenter", 2, "add from type =" + i);
        }
        if ((i == 21) || (i == 1) || (i == 2))
        {
          paramawwp = paramawwp.a();
          paramawwp.setContentDescription(paramawwp.getContext().getString(2131699363));
          paramawwp.setImageResource(2130845175);
          paramawwp.setOnClickListener(new awqs(this, paramawog));
        }
      }
      return;
    }
    if ((paramawwp.c() != null) && (!TextUtils.isEmpty(paramawog.c())))
    {
      paramawwp.c().setVisibility(0);
      label411:
      if (paramawwp.a() != null) {
        paramawwp.a().setVisibility(0);
      }
      if ((paramawwp.b() == null) || (paramawog.b() == null)) {
        break label667;
      }
      paramawwp.b().setVisibility(0);
      if ((!(paramawog instanceof awmr)) && (!(paramawog instanceof awmq)) && (!(paramawog instanceof awmx))) {
        break label651;
      }
      localObject = paramawog.b();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bbbd.b((String)localObject))) {
        break label635;
      }
      localObject = paramawwp.b().getContext().getResources().getDrawable(2130841313);
      ((Drawable)localObject).setBounds(0, 0, actn.a(15.0F, paramawwp.b().getContext().getResources()), actn.a(15.0F, paramawwp.b().getContext().getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
      paramawwp.b().setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = ((awwj)paramawwp).e();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (paramawwp.c() == null) {
        break label411;
      }
      paramawwp.c().setVisibility(8);
      break label411;
      label635:
      paramawwp.b().setCompoundDrawables(null, null, null, null);
      continue;
      label651:
      paramawwp.b().setCompoundDrawables(null, null, null, null);
      continue;
      label667:
      if (paramawwp.b() != null) {
        paramawwp.b().setVisibility(8);
      }
    }
  }
  
  protected void c(awog paramawog, awwp paramawwp)
  {
    if (this.jdField_a_of_type_Awqu != null)
    {
      if (paramawwp.a() != null) {
        paramawwp.a().setOnClickListener(new awqt(this));
      }
      return;
    }
    super.c(paramawog, paramawwp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqq
 * JD-Core Version:    0.7.0.1
 */